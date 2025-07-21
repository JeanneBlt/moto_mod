package com.pyloufass.motomod.mixin;

import com.pyloufass.motomod.block.entity.custom.SuspiciousSoulSandEntity;
import com.pyloufass.motomod.util.BrushUtils;
import com.pyloufass.motomod.util.MyDustParticlesOffset;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BrushableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.pyloufass.motomod.block.entity.custom.SuspiciousSoulSandEntity;

import static com.pyloufass.motomod.util.BrushUtils.getHitResult;

@Mixin(BrushItem.class)
public abstract class BrushItemMixin extends Item {

    public BrushItemMixin(Settings settings) {
        super(settings);
    }

    /**
     * @author : Pyloufass
     * @reason
     */
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (remainingUseTicks >= 0 && user instanceof PlayerEntity playerEntity) {
            HitResult hitResult = BrushUtils.getHitResult(playerEntity);
            if (hitResult instanceof BlockHitResult blockHitResult && hitResult.getType() == HitResult.Type.BLOCK) {
                int i = this.getMaxUseTime(stack, user) - remainingUseTicks + 1;
                boolean bl = i % 10 == 5;
                if (bl) {
                    BlockPos blockPos = blockHitResult.getBlockPos();
                    BlockState blockState = world.getBlockState(blockPos);
                    Arm arm = user.getActiveHand() == Hand.MAIN_HAND ? playerEntity.getMainArm() : playerEntity.getMainArm().getOpposite();
                    if (blockState.hasBlockBreakParticles() && blockState.getRenderType() != BlockRenderType.INVISIBLE) {
                        BrushUtils.addDustParticles(world, blockHitResult, blockState, user.getRotationVec(0.0F), arm);
                    }

                    SoundEvent soundEvent;
                    if (blockState.getBlock() instanceof BrushableBlock brushableBlock) {
                        soundEvent = brushableBlock.getBrushingSound();
                    } else {
                        soundEvent = SoundEvents.ITEM_BRUSH_BRUSHING_GENERIC;
                    }

                    world.playSound(playerEntity, blockPos, soundEvent, SoundCategory.BLOCKS);
                    if (world instanceof ServerWorld serverWorld && world.getBlockEntity(blockPos) instanceof BrushableBlockEntity brushableBlockEntity) {
                        boolean bl2 = brushableBlockEntity.brush(world.getTime(), serverWorld, playerEntity, blockHitResult.getSide(), stack);
                        if (bl2) {
                            EquipmentSlot equipmentSlot = stack.equals(playerEntity.getEquippedStack(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                            stack.damage(1, playerEntity, equipmentSlot);
                        }
                    }
                    if (world instanceof ServerWorld serverWorld && world.getBlockEntity(blockPos) instanceof SuspiciousSoulSandEntity brushableBlockEntity) {
                        boolean bl2 = brushableBlockEntity.brush(world.getTime(), serverWorld, playerEntity, blockHitResult.getSide(), stack);
                        if (bl2) {
                            EquipmentSlot equipmentSlot = stack.equals(playerEntity.getEquippedStack(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                            stack.damage(1, playerEntity, equipmentSlot);
                        }
                    }
                }
            } else {
                user.stopUsingItem();
            }
        } else {
            user.stopUsingItem();
        }
    }
}


