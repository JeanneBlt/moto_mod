package com.pyloufass.motomod.item;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.block.ModBlocks;
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

                        //armors
                        entries.add(ModItems.YELLOW_HAT);
                        entries.add(ModItems.BIKE_HELMET);

                        entries.add(ModItems.MOTO_GOLEM_SPAWN_EGG);

                        //minerals
                        entries.add(ModItems.SAPPHORIT_SHARD);
                        entries.add(ModItems.SAPPHORIT_CARROT);
                        entries.add(ModItems.SAPPHORIT_SEED);

                        entries.add(ModItems.DRIVE_POTTERY_SHARD);
                        entries.add(ModItems.SAPPHORIT_KEY);
                        entries.add(ModItems.PADMA_POTTERY_SHARD);
                        entries.add(ModItems.SUNSET_ARMOR_TRIM_SMITHING_TEMPLATE);

                        //paintbrushes
                        entries.add(ModItems.PAINTBRUSH_BLACK);
                        entries.add(ModItems.PAINTBRUSH_BLUE);
                        entries.add(ModItems.PAINTBRUSH_BROWN);
                        entries.add(ModItems.PAINTBRUSH_CYAN);
                        entries.add(ModItems.PAINTBRUSH_GRAY);
                        entries.add(ModItems.PAINTBRUSH_GREEN);
                        entries.add(ModItems.PAINTBRUSH_LIGHT_BLUE);
                        entries.add(ModItems.PAINTBRUSH_LIGHT_GRAY);
                        entries.add(ModItems.PAINTBRUSH_LIME);
                        entries.add(ModItems.PAINTBRUSH_MAGENTA);
                        entries.add(ModItems.PAINTBRUSH_ORANGE);
                        entries.add(ModItems.PAINTBRUSH_PINK);
                        entries.add(ModItems.PAINTBRUSH_PURPLE);
                        entries.add(ModItems.PAINTBRUSH_RED);
                        entries.add(ModItems.PAINTBRUSH_WHITE);
                        entries.add(ModItems.PAINTBRUSH_YELLOW);

                    }).build());

    public static final ItemGroup SAPPHORIT_SHARD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MotoMod.MOD_ID, "sapphorit_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SAPPHORIT_BLOCK))
                    .displayName(Text.translatable("itemgroup.motomod.sapphorit_block"))
                    .entries((displayContext, entries) -> {

                        //blocks
                        entries.add(ModBlocks.SAPPHORIT_BLOCK);
                        entries.add(ModBlocks.SUSPICIOUS_SOUL_SAND);
                        entries.add(ModBlocks.SAPPHORIT_LOTUS);

                        entries.add(ModBlocks.DASH_CARPET);
                        entries.add(ModBlocks.GOLEM_ENGINE);

                        entries.add(ModBlocks.WHEEL);

                        //crystallium blocks
                        entries.add(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.WHITE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.WHITE_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.WHITE_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.WHITE_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.GRAY_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.GRAY_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.GRAY_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.GRAY_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.BLACK_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.BLACK_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.BLACK_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.BLACK_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.BROWN_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.BROWN_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.BROWN_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.BROWN_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.RED_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.RED_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.RED_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.RED_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.ORANGE_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.ORANGE_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.ORANGE_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.YELLOW_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.YELLOW_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.YELLOW_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.LIME_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.LIME_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.LIME_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.LIME_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.GREEN_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.GREEN_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.GREEN_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.GREEN_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.CYAN_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.CYAN_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.CYAN_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.CYAN_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.BLUE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.BLUE_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.BLUE_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.BLUE_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.PURPLE_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.PURPLE_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.PURPLE_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.MAGENTA_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_STAIRS);

                        entries.add(ModBlocks.PINK_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.PINK_CRYSTALLIUM_CUT);
                        entries.add(ModBlocks.PINK_CRYSTALLIUM_CUT_SLAB);
                        entries.add(ModBlocks.PINK_CRYSTALLIUM_CUT_STAIRS);

                    }).build());

    public static void registerItemGroups() {
        MotoMod.LOGGER.info("Registering Item Groups for " + MotoMod.MOD_ID);
    }
}
