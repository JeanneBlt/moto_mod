package com.pyloufass.motomod.item.custom.paintbrush;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import com.pyloufass.motomod.component.ModDataComponentTypes;
import com.pyloufass.motomod.item.custom.paintbrush.PublicShulkerBoxBlockEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.block.enums.BedPart;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.minecraft.block.entity.BlockEntity;

import java.util.Map;

import static net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage.writeNbt;
import static net.minecraft.inventory.Inventories.readNbt;

public class PaintBrushItem extends Item {
    private final Map<Block, Block> PAINT_BRUSH_MAP;

    public PaintBrushItem(Settings settings, Map<Block, Block> PAINT_BRUSH_MAP) {
        super(settings);
        this.PAINT_BRUSH_MAP = PAINT_BRUSH_MAP;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        var pos = context.getBlockPos();
        var oldState = world.getBlockState(pos);
        Block clickedBlock = oldState.getBlock();

        if (!PAINT_BRUSH_MAP.containsKey(clickedBlock) || world.isClient()) {
            return ActionResult.SUCCESS;
        }

        Block newBlock = PAINT_BRUSH_MAP.get(clickedBlock);
        var newState = newBlock.getDefaultState();

        // if bed
        if (clickedBlock instanceof BedBlock && newBlock instanceof BedBlock) {
            var facing = oldState.get(BedBlock.FACING);
            var part = oldState.get(BedBlock.PART);

            var footPos = (part == BedPart.FOOT) ? pos : pos.offset(facing.getOpposite());
            var headPos = (part == BedPart.HEAD) ? pos : pos.offset(facing);

            world.removeBlock(headPos, false);
            world.removeBlock(footPos, false);

            var footState = newBlock.getDefaultState()
                    .with(BedBlock.FACING, facing)
                    .with(BedBlock.PART, BedPart.FOOT);

            var headState = newBlock.getDefaultState()
                    .with(BedBlock.FACING, facing)
                    .with(BedBlock.PART, BedPart.HEAD);

            world.setBlockState(footPos, footState, Block.NOTIFY_ALL);
            world.setBlockState(headPos, headState, Block.NOTIFY_ALL);

        // normal case
        } else {
            BlockEntity oldBlockEntity = world.getBlockEntity(pos);
            NbtCompound blockEntityNbt = null;

            if (oldBlockEntity instanceof ShulkerBoxBlockEntity shulkerBox) {
                blockEntityNbt = new NbtCompound();

                RegistryWrapper.WrapperLookup registryLookup =
                        (RegistryWrapper.WrapperLookup) ((ServerWorld) world).getRegistryManager();

                PublicShulkerBoxBlockEntity publicWrapper =
                        new PublicShulkerBoxBlockEntity(pos, oldState);

                publicWrapper.readNbt(shulkerBox.createNbt(registryLookup), registryLookup);
                publicWrapper.writeNbt(blockEntityNbt, registryLookup);
                blockEntityNbt.remove("id");
            }

            if (blockEntityNbt != null) {
                BlockEntity newBlockEntity = world.getBlockEntity(pos);
                if (newBlockEntity instanceof ShulkerBoxBlockEntity newShulker) {
                    RegistryWrapper.WrapperLookup registryWrapper =
                            (RegistryWrapper.WrapperLookup) ((ServerWorld) world).getRegistryManager();

                    PublicShulkerBoxBlockEntity publicWrapper =
                            new PublicShulkerBoxBlockEntity(pos, newState);

                    publicWrapper.readNbt(blockEntityNbt, registryWrapper);

                    NbtCompound nbtToApply = publicWrapper.createNbt(registryWrapper);

                    world.removeBlockEntity(pos);

                    var finalNbt = new NbtCompound();
                    finalNbt.putString("id", BlockEntityType.getId(newShulker.getType()).toString());
                    finalNbt.putInt("x", pos.getX());
                    finalNbt.putInt("y", pos.getY());
                    finalNbt.putInt("z", pos.getZ());
                    finalNbt.copyFrom(nbtToApply);

                    BlockEntity recreated = BlockEntity.createFromNbt(pos, newState, finalNbt, registryWrapper);
                    if (recreated != null) {
                        world.addBlockEntity(recreated);
                    }
                }
            }

            for (var property : oldState.getProperties()) {
                if (newState.contains(property)) {
                    newState = copyProperty(oldState, newState, property);
                }
            }

            world.setBlockState(pos, newState, Block.NOTIFY_ALL);
        }

        context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
        world.playSound(null, pos, SoundEvents.ENTITY_PAINTING_PLACE, SoundCategory.BLOCKS);
        context.getStack().set(ModDataComponentTypes.COORDINATES, pos);

        return ActionResult.SUCCESS;
    }

    private static <T extends Comparable<T>> net.minecraft.block.BlockState copyProperty(
            net.minecraft.block.BlockState from,
            net.minecraft.block.BlockState to,
            net.minecraft.state.property.Property<T> property) {
        return to.with(property, from.get(property));
    }

}
