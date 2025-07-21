package com.pyloufass.motomod;

import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.block.entity.custom.SuspiciousSoulSandEntity;
import com.pyloufass.motomod.block.entity.renderer.SuspiciousSoulSandEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import com.pyloufass.motomod.block.entity.ModBlockEntities;

public class MotoModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SAPPHORIT_LOTUS_CROP);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.SAPPHORIT_LOTUS);
        BlockEntityRendererFactories.register(ModBlockEntities.SUSPICIOUS_SOUL_SAND_ENTITY, SuspiciousSoulSandEntityRenderer::new);
    }
}
