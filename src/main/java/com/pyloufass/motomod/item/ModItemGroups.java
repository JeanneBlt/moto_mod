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
                        entries.add(ModItems.YELLOW_HAT);
                        entries.add(ModItems.BIKE_HELMET);
                        entries.add(ModItems.SAPPHORIT_SHARD);

                    }).build());

    public static final ItemGroup SAPPHORIT_SHARD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MotoMod.MOD_ID, "sapphorit_shard_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SAPPHORIT_SHARD_BLOCK))
                    .displayName(Text.translatable("itemgroup.motomod.sapphorit_shard_block"))
                    .entries((displayContext, entries) -> {

                        //blocks
                        entries.add(ModBlocks.SAPPHORIT_SHARD_BLOCK);
                        entries.add(ModBlocks.BLACK_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.BLUE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.BROWN_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.CYAN_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.GRAY_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.GREEN_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.LIGHT_CYAN_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.LIGHT_GREY_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.LIME_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.PINK_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.RED_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.WHITE_CRYSTALLIUM_BLOCK);
                        entries.add(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK);

                    }).build());

    public static void registerItemGroups() {
        MotoMod.LOGGER.info("Registering Item Groups for " + MotoMod.MOD_ID);
    }
}
