package com.pyloufass.motomod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.block.custom.LotusCropBlock;
import com.pyloufass.motomod.component.ModDataComponentTypes;
import com.pyloufass.motomod.item.ModArmorMaterials;
import com.pyloufass.motomod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.client.item.ItemAsset;
import net.minecraft.client.render.item.model.ConditionItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHORIT_BLOCK);
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.DASH_BLOCK, ModBlocks.DASH_CARPET);
        blockStateModelGenerator.registerBrushableBlock(ModBlocks.SUSPICIOUS_SOUL_SAND);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.SAPPHORIT_LOTUS_CROP, BlockStateModelGenerator.CrossType.NOT_TINTED,
                LotusCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SAPPHORIT_LOTUS, BlockStateModelGenerator.CrossType.TINTED);

        blockStateModelGenerator.registerRotatable(ModBlocks.WHEEL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROWN_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYAN_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAY_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIME_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK);

        blockStateModelGenerator.registerSingleton(ModBlocks.GOLEM_ENGINE, TexturedModel.CUBE_BOTTOM_TOP);

        BlockStateModelGenerator.BlockTexturePool sapphoritCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT);
        sapphoritCrystalliumCutPool.stairs(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_STAIRS);
        sapphoritCrystalliumCutPool.slab(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool blackCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLACK_CRYSTALLIUM_CUT);
        blackCrystalliumCutPool.stairs(ModBlocks.BLACK_CRYSTALLIUM_CUT_STAIRS);
        blackCrystalliumCutPool.slab(ModBlocks.BLACK_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool blueCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLUE_CRYSTALLIUM_CUT);
        blueCrystalliumCutPool.stairs(ModBlocks.BLUE_CRYSTALLIUM_CUT_STAIRS);
        blueCrystalliumCutPool.slab(ModBlocks.BLUE_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool brownCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BROWN_CRYSTALLIUM_CUT);
        brownCrystalliumCutPool.stairs(ModBlocks.BROWN_CRYSTALLIUM_CUT_STAIRS);
        brownCrystalliumCutPool.slab(ModBlocks.BROWN_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool cyanCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CYAN_CRYSTALLIUM_CUT);
        cyanCrystalliumCutPool.stairs(ModBlocks.CYAN_CRYSTALLIUM_CUT_STAIRS);
        cyanCrystalliumCutPool.slab(ModBlocks.CYAN_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool grayCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRAY_CRYSTALLIUM_CUT);
        grayCrystalliumCutPool.stairs(ModBlocks.GRAY_CRYSTALLIUM_CUT_STAIRS);
        grayCrystalliumCutPool.slab(ModBlocks.GRAY_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool greenCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GREEN_CRYSTALLIUM_CUT);
        greenCrystalliumCutPool.stairs(ModBlocks.GREEN_CRYSTALLIUM_CUT_STAIRS);
        greenCrystalliumCutPool.slab(ModBlocks.GREEN_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool lightBlueCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT);
        lightBlueCrystalliumCutPool.stairs(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS);
        lightBlueCrystalliumCutPool.slab(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool lightGrayCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT);
        lightGrayCrystalliumCutPool.stairs(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS);
        lightGrayCrystalliumCutPool.slab(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool limeCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LIME_CRYSTALLIUM_CUT);
        limeCrystalliumCutPool.stairs(ModBlocks.LIME_CRYSTALLIUM_CUT_STAIRS);
        limeCrystalliumCutPool.slab(ModBlocks.LIME_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool magentaCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAGENTA_CRYSTALLIUM_CUT);
        magentaCrystalliumCutPool.stairs(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_STAIRS);
        magentaCrystalliumCutPool.slab(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool orangeCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ORANGE_CRYSTALLIUM_CUT);
        orangeCrystalliumCutPool.stairs(ModBlocks.ORANGE_CRYSTALLIUM_CUT_STAIRS);
        orangeCrystalliumCutPool.slab(ModBlocks.ORANGE_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool pinkCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_CRYSTALLIUM_CUT);
        pinkCrystalliumCutPool.stairs(ModBlocks.PINK_CRYSTALLIUM_CUT_STAIRS);
        pinkCrystalliumCutPool.slab(ModBlocks.PINK_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool purpleCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PURPLE_CRYSTALLIUM_CUT);
        purpleCrystalliumCutPool.stairs(ModBlocks.PURPLE_CRYSTALLIUM_CUT_STAIRS);
        purpleCrystalliumCutPool.slab(ModBlocks.PURPLE_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool redCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_CRYSTALLIUM_CUT);
        redCrystalliumCutPool.stairs(ModBlocks.RED_CRYSTALLIUM_CUT_STAIRS);
        redCrystalliumCutPool.slab(ModBlocks.RED_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool whiteCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WHITE_CRYSTALLIUM_CUT);
        whiteCrystalliumCutPool.stairs(ModBlocks.WHITE_CRYSTALLIUM_CUT_STAIRS);
        whiteCrystalliumCutPool.slab(ModBlocks.WHITE_CRYSTALLIUM_CUT_SLAB);
        BlockStateModelGenerator.BlockTexturePool yellowCrystalliumCutPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.YELLOW_CRYSTALLIUM_CUT);
        yellowCrystalliumCutPool.stairs(ModBlocks.YELLOW_CRYSTALLIUM_CUT_STAIRS);
        yellowCrystalliumCutPool.slab(ModBlocks.YELLOW_CRYSTALLIUM_CUT_SLAB);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.DRIVE_POTTERY_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PADMA_POTTERY_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHORIT_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHORIT_KEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHORIT_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNSET_ARMOR_TRIM_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOTO_GOLEM_SPAWN_EGG, Models.GENERATED);

        itemModelGenerator.register(ModItems.PAINTBRUSH_BLACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_BLUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_BROWN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_CYAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_GRAY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_GREEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_LIGHT_BLUE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_LIGHT_GRAY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_LIME, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_MAGENTA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_PINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_PURPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_RED, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_WHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAINTBRUSH_YELLOW, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.BIKE_HELMET, ModArmorMaterials.BIKE_HELMET_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.YELLOW_HAT, ModArmorMaterials.YELLOW_HAT_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);

    }
}
