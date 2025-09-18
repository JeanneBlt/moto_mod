package com.pyloufass.motomod.entity;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.entity.custom.MotoEntity;
import com.pyloufass.motomod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> MOTO_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MotoMod.MOD_ID, "moto"));


    public static final EntityType<MotoEntity> MOTO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MotoMod.MOD_ID, "moto"),
            EntityType.Builder.create(MotoEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build(MOTO_KEY));

    public static void registerModEntities() {
        MotoMod.LOGGER.info("Registering Mod Entities for " + MotoMod.MOD_ID);
    }
}
