package com.pyloufass.motomod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Arm;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.entity.projectile.ProjectileUtil;

public class BrushUtils {

    public static HitResult getHitResult(PlayerEntity user) {
        return ProjectileUtil.getCollision(user, EntityPredicates.CAN_HIT, user.getBlockInteractionRange());
    }

    public static void addDustParticles(World world, BlockHitResult hitResult, BlockState state, Vec3d userRotation, Arm arm) {
        double d = 3.0;
        int i = arm == Arm.RIGHT ? 1 : -1;
        int j = world.getRandom().nextBetweenExclusive(7, 12);
        BlockStateParticleEffect blockStateParticleEffect = new BlockStateParticleEffect(ParticleTypes.BLOCK, state);
        Direction direction = hitResult.getSide();
        MyDustParticlesOffset offset = MyDustParticlesOffset.fromSide(userRotation, direction);
        Vec3d vec3d = hitResult.getPos();

        for (int k = 0; k < j; k++) {
            world.addParticleClient(
                    blockStateParticleEffect,
                    vec3d.x - (direction == Direction.WEST ? 1.0E-6F : 0.0F),
                    vec3d.y,
                    vec3d.z - (direction == Direction.NORTH ? 1.0E-6F : 0.0F),
                    offset.xd() * i * 3.0 * world.getRandom().nextDouble(),
                    0.0,
                    offset.zd() * i * 3.0 * world.getRandom().nextDouble()
            );
        }
    }
}

