package com.pyloufass.motomod.item;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {

    //items
    public static final Item SAPPHORIT_SHARD = registerItem("sapphorit_shard", Item::new);

    //clothes
    public static final Item YELLOW_HAT = registerItem("yellow_hat",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.YELLOW_HAT_MATERIAL, EquipmentType.HELMET)));
    public static final Item BIKE_HELMET = registerItem("bike_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.BIKE_HELMET_MATERIAL, EquipmentType.HELMET)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MotoMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MotoMod.MOD_ID, name)))));
    }
    public static void registerModItems() {
        MotoMod.LOGGER.info("Registering Mod Items for " + MotoMod.MOD_ID);

    }
}
