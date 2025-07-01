package com.pyloufass.motomod.item;

import com.pyloufass.motomod.MotoMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import com.pyloufass.motomod.MotoMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SAPPHORIT_SHARD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MotoMod.MOD_ID, "sapphorit_shard_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SAPPHORIT_SHARD))
                    .displayName(Text.translatable("itemgroup.motomod.sapphorit_shard_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.YELLOW_HAT);
                        entries.add(ModItems.BIKE_HELMET);
                        entries.add(ModItems.SAPPHORIT_SHARD);

                    }).build());

    public static void registerItemGroups() {
        MotoMod.LOGGER.info("Registering Item Groups for " + MotoMod.MOD_ID);
    }
}
