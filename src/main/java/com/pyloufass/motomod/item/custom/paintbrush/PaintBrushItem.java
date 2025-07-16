package com.pyloufass.motomod.item.custom.paintbrush;

import net.minecraft.block.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.*;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import com.pyloufass.motomod.component.ModDataComponentTypes;
import com.pyloufass.motomod.item.custom.paintbrush.PublicShulkerBoxBlockEntity;
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
import net.minecraft.world.biome.Biome;

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
            RegistryWrapper.WrapperLookup registries = world.getRegistryManager();
            BlockEntity oldEntity = world.getBlockEntity(pos);
            NbtCompound savedNbt = null;

            if (oldEntity instanceof ShulkerBoxBlockEntity) {
                savedNbt = oldEntity.createNbtWithId(registries);
            }

            for (Property<?> property : oldState.getProperties()) {
                if (newState.contains(property)) {
                    newState = copyProperty(oldState, newState, property);
                }
            }

            world.setBlockState(pos, newState, Block.NOTIFY_ALL);

            if (savedNbt != null) {
                Identifier id = Registries.BLOCK_ENTITY_TYPE.getId(BlockEntityType.SHULKER_BOX);
                if (id != null) savedNbt.putString("id", id.toString());

                BlockEntity newEntity = world.getBlockEntity(pos);
                if (newEntity != null) {
                    newEntity.read(savedNbt, registries);
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
