package com.pyloufass.motomod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.block.custom.LotusCropBlock;
import com.pyloufass.motomod.component.ModDataComponentTypes;
import com.pyloufass.motomod.item.ModArmorMaterials;
import com.pyloufass.motomod.item.ModItems;
import net.minecraft.client.data.*;
import net.minecraft.client.item.ItemAsset;
import net.minecraft.client.render.item.model.ConditionItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
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

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BROWN_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYAN_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAY_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIME_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE_CRYSTALLIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK);


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

//        sapphoritPool.button(ModBlocks.SAPPHORIT_BUTTON);
//        sapphoritPool.pressurePlate(ModBlocks.SAPPHORIT_PRESSURE_PLATE);
//
//        sapphoritPool.fence(ModBlocks.SAPPHORIT_FENCE);
//        sapphoritPool.fenceGate(ModBlocks.SAPPHORIT_FENCE_GATE);
//        sapphoritPool.wall(ModBlocks.SAPPHORIT_WALL);
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_NETHER_ORE);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_END_ORE);
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
//
//        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
//        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);
//
//        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
//        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
//        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModBlocks.PINK_GARNET_LAMP)
//                .with(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED,
//                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOnIdentifier)).build()),
//                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOffIdentifier)).build()))));
//
//        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
//        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.HONEY_BERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
//                HoneyBerryBushBlock.AGE, 0, 1, 2, 3);
//
//        blockStateModelGenerator.createLogTexturePool(ModBlocks.DRIFTWOOD_LOG).log(ModBlocks.DRIFTWOOD_LOG).wood(ModBlocks.DRIFTWOOD_WOOD);
//        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_DRIFTWOOD_LOG).log(ModBlocks.STRIPPED_DRIFTWOOD_LOG).wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIFTWOOD_PLANKS);
//        blockStateModelGenerator.registerSingleton(ModBlocks.DRIFTWOOD_LEAVES, TexturedModel.LEAVES);
//        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DRIFTWOOD_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
//
//        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CHAIR);
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GROWTH_CHAMBER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
//        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
//
//        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
//        // itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
//        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
//
//        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);
//
//        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD);
//
//        itemModelGenerator.upload(ModItems.KAUPEN_BOW, Models.BOW);
//        itemModelGenerator.registerBow(ModItems.KAUPEN_BOW);
//
//        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_HELMET, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
//        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_CHESTPLATE, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
//        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_LEGGINGS, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
//        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_BOOTS, ModArmorMaterials.PINK_GARNET_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
//
//        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);
//        itemModelGenerator.register(ModItems.KAUPEN_SMITHING_TEMPLATE, Models.GENERATED);
//
//        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);
//
//        itemModelGenerator.register(ModBlocks.DRIFTWOOD_SAPLING.asItem(), Models.GENERATED);
//
//        itemModelGenerator.register(ModItems.MANTIS_SPAWN_EGG,
//                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
//
//        ItemModel.Unbaked unbakedChisel = ItemModels.basic(itemModelGenerator.upload(ModItems.CHISEL, Models.GENERATED));
//        ItemModel.Unbaked unbakedUsedChisel = ItemModels.basic(itemModelGenerator.registerSubModel(ModItems.CHISEL, "_used", Models.GENERATED));
//        itemModelGenerator.output.accept(ModItems.CHISEL,
//                new ItemAsset(new ConditionItemModel.Unbaked(new HasComponentProperty(ModDataComponentTypes.COORDINATES, false),
//                        unbakedUsedChisel, unbakedChisel),
//                        new ItemAsset.Properties(false)).model());
    }
}
