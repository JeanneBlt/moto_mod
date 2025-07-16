package com.pyloufass.motomod.item;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.item.custom.paintbrush.DyeBlockMappings;
import com.pyloufass.motomod.item.custom.paintbrush.PaintBrushItem;
import com.pyloufass.motomod.item.custom.ModArmorItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.function.Function;

public class ModItems {

    //items
    public static final Item SAPPHORIT_SHARD = registerItem("sapphorit_shard", Item::new);
    public static final Item SAPPHORIT_CARROT = registerItem("sapphorit_carrot", Item::new);
    public static final Item SAPPHORIT_SEED = registerItem("sapphorit_seed", Item::new);

    //paintbrushes
    public static final Item PAINTBRUSH_BLACK = registerItem("paintbrush_black", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.BLACK)));
    public static final Item PAINTBRUSH_BLUE = registerItem("paintbrush_blue", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.BLUE)));
    public static final Item PAINTBRUSH_BROWN = registerItem("paintbrush_brown", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.BROWN)));
    public static final Item PAINTBRUSH_CYAN = registerItem("paintbrush_cyan", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.CYAN)));
    public static final Item PAINTBRUSH_GRAY = registerItem("paintbrush_gray", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.GRAY)));
    public static final Item PAINTBRUSH_GREEN = registerItem("paintbrush_green", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.GREEN)));
    public static final Item PAINTBRUSH_LIGHT_BLUE = registerItem("paintbrush_light_blue", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.LIGHT_BLUE)));
    public static final Item PAINTBRUSH_LIGHT_GRAY = registerItem("paintbrush_light_gray", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.LIGHT_GRAY)));
    public static final Item PAINTBRUSH_LIME = registerItem("paintbrush_lime", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.LIME)));
    public static final Item PAINTBRUSH_MAGENTA = registerItem("paintbrush_magenta", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.MAGENTA)));
    public static final Item PAINTBRUSH_ORANGE = registerItem("paintbrush_orange", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.ORANGE)));
    public static final Item PAINTBRUSH_PINK = registerItem("paintbrush_pink", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.PINK)));
    public static final Item PAINTBRUSH_PURPLE = registerItem("paintbrush_purple", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.PURPLE)));
    public static final Item PAINTBRUSH_RED = registerItem("paintbrush_red", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.RED)));
    public static final Item PAINTBRUSH_WHITE = registerItem("paintbrush_white", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.WHITE)));
    public static final Item PAINTBRUSH_YELLOW = registerItem("paintbrush_yellow", setting -> new PaintBrushItem(setting.maxDamage(32),
            DyeBlockMappings.generateColorMapping(DyeColor.YELLOW)));


    //armors
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
