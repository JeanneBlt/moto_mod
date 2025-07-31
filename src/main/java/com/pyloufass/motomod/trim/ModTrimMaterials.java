package com.pyloufass.motomod.trim;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import static com.pyloufass.motomod.block.ModBlocks.SAPPHORIT_LOTUS;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> SAPPHORIT_SHARD = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MotoMod.MOD_ID, "sapphorit_shard"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, SAPPHORIT_SHARD, Registries.ITEM.getEntry(ModItems.SAPPHORIT_SHARD),
                Style.EMPTY.withColor(TextColor.parse("#b03fe0").getOrThrow()));

    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(ArmorTrimAssets.of("pink_garnet"),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
