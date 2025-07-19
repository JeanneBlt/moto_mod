package com.pyloufass.motomod.block.entity;

import com.pyloufass.motomod.MotoMod;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.block.entity.custom.SuspiciousSoulSandEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<SuspiciousSoulSandEntity> SUSPICIOUS_SOUL_SAND_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MotoMod.MOD_ID, "suspicious_soul_sand_entity"),
                    FabricBlockEntityTypeBuilder.create(SuspiciousSoulSandEntity::new, ModBlocks.SUSPICIOUS_SOUL_SAND).build(null));

    public static void registerBlockEntities() {
        MotoMod.LOGGER.info("Registering Block Entities for " + MotoMod.MOD_ID);
    }
}
