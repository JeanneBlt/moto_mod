package com.pyloufass.motomod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SAPPHORIT_BLOCK)

                .add(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.BLACK_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.BLUE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.BROWN_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.CYAN_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.GRAY_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.LIME_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.PINK_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.RED_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.WHITE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK)

                .add(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.BLACK_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.BLUE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.BROWN_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.CYAN_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.GRAY_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.LIME_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.ORANGE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.PINK_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.PURPLE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.RED_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.WHITE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.YELLOW_CRYSTALLIUM_CUT_STAIRS)

                .add(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.BLACK_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.BLUE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.BROWN_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.CYAN_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.GRAY_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.LIME_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.ORANGE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.PINK_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.PURPLE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.RED_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.WHITE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.YELLOW_CRYSTALLIUM_CUT_SLAB);


        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.SAPPHORIT_BLOCK)

                .add(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.BLACK_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.BLUE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.BROWN_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.CYAN_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.GRAY_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.LIME_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.PINK_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.RED_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.WHITE_CRYSTALLIUM_BLOCK)
                .add(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK)

                .add(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.BLACK_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.BLUE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.BROWN_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.CYAN_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.GRAY_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.LIME_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.ORANGE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.PINK_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.PURPLE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.RED_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.WHITE_CRYSTALLIUM_CUT_STAIRS)
                .add(ModBlocks.YELLOW_CRYSTALLIUM_CUT_STAIRS)

                .add(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.BLACK_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.BLUE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.BROWN_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.CYAN_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.GRAY_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.LIME_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.ORANGE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.PINK_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.PURPLE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.RED_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.WHITE_CRYSTALLIUM_CUT_SLAB)
                .add(ModBlocks.YELLOW_CRYSTALLIUM_CUT_SLAB);
    }
}
