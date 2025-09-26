package com.pyloufass.motomod.entity.client;

import com.google.common.collect.Maps;
import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.entity.custom.MotoEntity;
import com.pyloufass.motomod.entity.custom.MotoVariant;
import com.pyloufass.motomod.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.vehicle.VehicleEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class MotoRenderer  extends LivingEntityRenderer<MotoEntity, MotoRenderState, MotoModel> {
    private static final Map<MotoVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(MotoVariant.class), map -> {
                map.put(MotoVariant.DEFAULT,
                        Identifier.of(MotoMod.MOD_ID, "textures/entity/moto/red_moto.png"));
                map.put(MotoVariant.ORCHID,
                        Identifier.of(MotoMod.MOD_ID, "textures/entity/moto/blue_moto.png"));
            });

    public MotoRenderer(EntityRendererFactory.Context context) {
        super(context, new MotoModel(context.getPart(MotoModel.MOTO)), 0.75f);
    }

    @Override
    public Identifier getTexture(MotoRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
    }

    @Override
    public void render(MotoRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(state.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public MotoRenderState createRenderState() {
        return new MotoRenderState();
    }

    @Override
    public void updateRenderState(MotoEntity livingEntity, MotoRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idlingAnimationState);
        livingEntityRenderState.variant = livingEntity.getVariant();
    }
}
