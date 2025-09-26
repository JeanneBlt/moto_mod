package com.pyloufass.motomod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.item.ModItems;
import com.pyloufass.motomod.trim.ModTrimPatterns;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                //offerSmithingTrimRecipe(ModItems.SUNSET_ARMOR_TRIM_SMITHING_TEMPLATE, ModTrimPatterns.SUNSET,
                //        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(MotoMod.MOD_ID, "sunset")));
            }
        };
    }

    @Override
    public String getName() {
        return "MotoMod Recipes";
    }
}
