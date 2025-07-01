package com.pyloufass.motomod.util;

import com.pyloufass.motomod.MotoMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> YELLOW_HAT_REPAIR = createTag("yellow_hat_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MotoMod.MOD_ID, name));
        }
    }
}
