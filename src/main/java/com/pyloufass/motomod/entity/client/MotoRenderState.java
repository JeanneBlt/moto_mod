package com.pyloufass.motomod.entity.client;

import com.pyloufass.motomod.entity.custom.MotoVariant;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class MotoRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public MotoVariant variant;
}
