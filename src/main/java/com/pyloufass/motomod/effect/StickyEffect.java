package com.pyloufass.motomod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

// MIT License!
public class StickyEffect extends StatusEffect {
    public StickyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision) {
            Vec3d velocity = entity.getVelocity();

            double slowFactor = 0.2 - (0.05 * amplifier);
            slowFactor = Math.max(slowFactor, 0.05);

            double newX = velocity.x * slowFactor;
            double newZ = velocity.z * slowFactor;

            entity.setVelocity(newX, velocity.y, newZ);
            entity.velocityDirty = true;
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
