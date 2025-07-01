package com.pyloufass.motomod.item;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> YELLOW_HAT_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MotoMod.MOD_ID, "yellow_hat"));
    public static final RegistryKey<EquipmentAsset> BIKE_HELMET_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MotoMod.MOD_ID, "bike_helmet"));

    public static final ArmorMaterial YELLOW_HAT_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.HELMET, 2);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0,0, ModTags.Items.YELLOW_HAT_REPAIR, YELLOW_HAT_KEY);

    public static final ArmorMaterial BIKE_HELMET_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.HELMET, 2);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0,0, ModTags.Items.BIKE_HELMET_REPAIR, BIKE_HELMET_KEY);
}

