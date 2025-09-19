package com.pyloufass.motomod.entity.custom;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.sound.SoundEvent;

public class ModAmbiantStandGoal extends Goal {
    private final AbstractMotoEntity entity;
    private int cooldown;

    public ModAmbiantStandGoal(AbstractMotoEntity entity) {
        this.entity = entity;
        this.resetCooldown(entity);
    }

    @Override
    public void start() {
        this.entity.updateAnger();
        this.playAmbientStandSound();
    }

    private void playAmbientStandSound() {
        SoundEvent soundEvent = this.entity.getAmbientStandSound();
        if (soundEvent != null) {
            this.entity.playSoundIfNotSilent(soundEvent);
        }
    }

    @Override
    public boolean shouldContinue() {
        return false;
    }

    @Override
    public boolean canStart() {
        this.cooldown++;
        if (this.cooldown > 0 && this.entity.getRandom().nextInt(1000) < this.cooldown) {
            this.resetCooldown(this.entity);
            return !this.entity.isImmobile() && this.entity.getRandom().nextInt(10) == 0;
        } else {
            return false;
        }
    }

    private void resetCooldown(AbstractMotoEntity entity) {
        this.cooldown = -entity.getMinAmbientStandDelay();
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }
}
