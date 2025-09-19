package com.pyloufass.motomod.block;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.block.custom.LotusCropBlock;
import com.pyloufass.motomod.block.custom.SuspiciousSoulSand;
import com.pyloufass.motomod.block.custom.WheelBlock;
import com.pyloufass.motomod.status.ModStatus;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.sound.SoundEvents;
import java.util.function.Function;

public class ModBlocks {

    public static final Block SAPPHORIT_BLOCK = registerBlock("sapphorit_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));

    public static final Block GOLEM_ENGINE = registerBlock("golem_engine",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));

    public static final Block WHEEL = registerBlock("wheel",
            properties -> new WheelBlock(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));

    public static final Block SAPPHORIT_LOTUS_CROP = registerBlockWithoutBlockItem("sapphorit_lotus_crop",
            properties -> new LotusCropBlock(properties.noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SAPPHORIT_LOTUS = registerBlock("sapphorit_lotus",
            properties -> new CactusFlowerBlock(properties.noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SAPPHORIT_CRYSTALLIUM_BLOCK = registerBlock("sapphorit_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block BLACK_CRYSTALLIUM_BLOCK = registerBlock("black_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block BLUE_CRYSTALLIUM_BLOCK = registerBlock("blue_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block BROWN_CRYSTALLIUM_BLOCK = registerBlock("brown_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block CYAN_CRYSTALLIUM_BLOCK = registerBlock("cyan_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block GRAY_CRYSTALLIUM_BLOCK = registerBlock("gray_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block GREEN_CRYSTALLIUM_BLOCK = registerBlock("green_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block LIGHT_BLUE_CRYSTALLIUM_BLOCK = registerBlock("light_blue_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block LIGHT_GRAY_CRYSTALLIUM_BLOCK = registerBlock("light_gray_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block LIME_CRYSTALLIUM_BLOCK = registerBlock("lime_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block MAGENTA_CRYSTALLIUM_BLOCK = registerBlock("magenta_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block ORANGE_CRYSTALLIUM_BLOCK = registerBlock("orange_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block PINK_CRYSTALLIUM_BLOCK = registerBlock("pink_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block PURPLE_CRYSTALLIUM_BLOCK = registerBlock("purple_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block RED_CRYSTALLIUM_BLOCK = registerBlock("red_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block WHITE_CRYSTALLIUM_BLOCK = registerBlock("white_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block YELLOW_CRYSTALLIUM_BLOCK = registerBlock("yellow_crystallium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));

    public static final Block SAPPHORIT_CRYSTALLIUM_CUT = registerBlock("sapphorit_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block BLACK_CRYSTALLIUM_CUT = registerBlock("black_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block BLUE_CRYSTALLIUM_CUT = registerBlock("blue_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block BROWN_CRYSTALLIUM_CUT = registerBlock("brown_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block CYAN_CRYSTALLIUM_CUT = registerBlock("cyan_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block GRAY_CRYSTALLIUM_CUT = registerBlock("gray_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block GREEN_CRYSTALLIUM_CUT = registerBlock("green_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block LIGHT_BLUE_CRYSTALLIUM_CUT = registerBlock("light_blue_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block LIGHT_GRAY_CRYSTALLIUM_CUT = registerBlock("light_gray_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block LIME_CRYSTALLIUM_CUT = registerBlock("lime_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block MAGENTA_CRYSTALLIUM_CUT = registerBlock("magenta_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block ORANGE_CRYSTALLIUM_CUT = registerBlock("orange_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block PINK_CRYSTALLIUM_CUT = registerBlock("pink_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block PURPLE_CRYSTALLIUM_CUT = registerBlock("purple_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block RED_CRYSTALLIUM_CUT = registerBlock("red_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block WHITE_CRYSTALLIUM_CUT = registerBlock("white_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));
    public static final Block YELLOW_CRYSTALLIUM_CUT = registerBlock("yellow_crystallium_cut",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));

    public static final Block SAPPHORIT_CRYSTALLIUM_CUT_STAIRS = registerBlock("sapphorit_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block BLACK_CRYSTALLIUM_CUT_STAIRS = registerBlock("black_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block BLUE_CRYSTALLIUM_CUT_STAIRS = registerBlock("blue_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block BROWN_CRYSTALLIUM_CUT_STAIRS = registerBlock("brown_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block CYAN_CRYSTALLIUM_CUT_STAIRS = registerBlock("cyan_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block GRAY_CRYSTALLIUM_CUT_STAIRS = registerBlock("gray_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block GREEN_CRYSTALLIUM_CUT_STAIRS = registerBlock("green_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS = registerBlock("light_blue_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS = registerBlock("light_gray_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block LIME_CRYSTALLIUM_CUT_STAIRS = registerBlock("lime_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block MAGENTA_CRYSTALLIUM_CUT_STAIRS = registerBlock("magenta_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block ORANGE_CRYSTALLIUM_CUT_STAIRS = registerBlock("orange_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block PINK_CRYSTALLIUM_CUT_STAIRS = registerBlock("pink_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block PURPLE_CRYSTALLIUM_CUT_STAIRS = registerBlock("purple_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block RED_CRYSTALLIUM_CUT_STAIRS = registerBlock("red_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block WHITE_CRYSTALLIUM_CUT_STAIRS = registerBlock("white_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));
    public static final Block YELLOW_CRYSTALLIUM_CUT_STAIRS = registerBlock("yellow_crystallium_cut_stairs",
            properties -> new StairsBlock(ModBlocks.SAPPHORIT_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));

    public static final Block SAPPHORIT_CRYSTALLIUM_CUT_SLAB = registerBlock("sapphorit_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block BLACK_CRYSTALLIUM_CUT_SLAB = registerBlock("black_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block BLUE_CRYSTALLIUM_CUT_SLAB = registerBlock("blue_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block BROWN_CRYSTALLIUM_CUT_SLAB = registerBlock("brown_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block CYAN_CRYSTALLIUM_CUT_SLAB = registerBlock("cyan_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block GRAY_CRYSTALLIUM_CUT_SLAB = registerBlock("gray_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block GREEN_CRYSTALLIUM_CUT_SLAB = registerBlock("green_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB = registerBlock("light_blue_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB = registerBlock("light_gray_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block LIME_CRYSTALLIUM_CUT_SLAB = registerBlock("lime_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block MAGENTA_CRYSTALLIUM_CUT_SLAB = registerBlock("magenta_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block ORANGE_CRYSTALLIUM_CUT_SLAB = registerBlock("orange_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block PINK_CRYSTALLIUM_CUT_SLAB = registerBlock("pink_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block PURPLE_CRYSTALLIUM_CUT_SLAB = registerBlock("purple_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block RED_CRYSTALLIUM_CUT_SLAB = registerBlock("red_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block WHITE_CRYSTALLIUM_CUT_SLAB = registerBlock("white_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));
    public static final Block YELLOW_CRYSTALLIUM_CUT_SLAB = registerBlock("yellow_crystallium_cut_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));

    public static final Block DASH_CARPET = registerBlock("dash_carpet",
            properties -> new CarpetBlock(properties.strength(2f).requiresTool()));
    public static final Block DASH_BLOCK = registerBlock("dash_block",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));

    public static final Block SUSPICIOUS_SOUL_SAND = registerBlock("suspicious_soul_sand",
            properties -> new SuspiciousSoulSand(
                    Blocks.SOUL_SAND,
                    SoundEvents.ITEM_BRUSH_BRUSHING_SAND,
                    SoundEvents.ITEM_BRUSH_BRUSHING_SAND_COMPLETE,
                    properties.strength(4f).sounds(BlockSoundGroup.SOUL_SAND)
            )
    );

    public static Block getCrystalliumBlock(DyeColor color) {
        return switch (color) {
            case BLACK -> BLACK_CRYSTALLIUM_BLOCK;
            case BLUE -> BLUE_CRYSTALLIUM_BLOCK;
            case BROWN -> BROWN_CRYSTALLIUM_BLOCK;
            case CYAN -> CYAN_CRYSTALLIUM_BLOCK;
            case GRAY -> GRAY_CRYSTALLIUM_BLOCK;
            case GREEN -> GREEN_CRYSTALLIUM_BLOCK;
            case LIGHT_BLUE -> LIGHT_BLUE_CRYSTALLIUM_BLOCK;
            case LIGHT_GRAY -> LIGHT_GRAY_CRYSTALLIUM_BLOCK;
            case LIME -> LIME_CRYSTALLIUM_BLOCK;
            case MAGENTA -> MAGENTA_CRYSTALLIUM_BLOCK;
            case ORANGE -> ORANGE_CRYSTALLIUM_BLOCK;
            case PINK -> PINK_CRYSTALLIUM_BLOCK;
            case PURPLE -> PURPLE_CRYSTALLIUM_BLOCK;
            case RED -> RED_CRYSTALLIUM_BLOCK;
            case WHITE -> WHITE_CRYSTALLIUM_BLOCK;
            case YELLOW -> YELLOW_CRYSTALLIUM_BLOCK;
        };
    }

    public static Block getCrystalliumCut(DyeColor color) {
        return switch (color) {
            case BLACK -> BLACK_CRYSTALLIUM_CUT;
            case BLUE -> BLUE_CRYSTALLIUM_CUT;
            case BROWN -> BROWN_CRYSTALLIUM_CUT;
            case CYAN -> CYAN_CRYSTALLIUM_CUT;
            case GRAY -> GRAY_CRYSTALLIUM_CUT;
            case GREEN -> GREEN_CRYSTALLIUM_CUT;
            case LIGHT_BLUE -> LIGHT_BLUE_CRYSTALLIUM_CUT;
            case LIGHT_GRAY -> LIGHT_GRAY_CRYSTALLIUM_CUT;
            case LIME -> LIME_CRYSTALLIUM_CUT;
            case MAGENTA -> MAGENTA_CRYSTALLIUM_CUT;
            case ORANGE -> ORANGE_CRYSTALLIUM_CUT;
            case PINK -> PINK_CRYSTALLIUM_CUT;
            case PURPLE -> PURPLE_CRYSTALLIUM_CUT;
            case RED -> RED_CRYSTALLIUM_CUT;
            case WHITE -> WHITE_CRYSTALLIUM_CUT;
            case YELLOW -> YELLOW_CRYSTALLIUM_CUT;
        };
    }

    public static Block getCrystalliumCutSlab(DyeColor color) {
        return switch (color) {
            case BLACK -> BLACK_CRYSTALLIUM_CUT_SLAB;
            case BLUE -> BLUE_CRYSTALLIUM_CUT_SLAB;
            case BROWN -> BROWN_CRYSTALLIUM_CUT_SLAB;
            case CYAN -> CYAN_CRYSTALLIUM_CUT_SLAB;
            case GRAY -> GRAY_CRYSTALLIUM_CUT_SLAB;
            case GREEN -> GREEN_CRYSTALLIUM_CUT_SLAB;
            case LIGHT_BLUE -> LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB;
            case LIGHT_GRAY -> LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB;
            case LIME -> LIME_CRYSTALLIUM_CUT_SLAB;
            case MAGENTA -> MAGENTA_CRYSTALLIUM_CUT_SLAB;
            case ORANGE -> ORANGE_CRYSTALLIUM_CUT_SLAB;
            case PINK -> PINK_CRYSTALLIUM_CUT_SLAB;
            case PURPLE -> PURPLE_CRYSTALLIUM_CUT_SLAB;
            case RED -> RED_CRYSTALLIUM_CUT_SLAB;
            case WHITE -> WHITE_CRYSTALLIUM_CUT_SLAB;
            case YELLOW -> YELLOW_CRYSTALLIUM_CUT_SLAB;
        };
    }

    public static Block getCrystalliumCutStairs(DyeColor color) {
        return switch (color) {
            case BLACK -> BLACK_CRYSTALLIUM_CUT_STAIRS;
            case BLUE -> BLUE_CRYSTALLIUM_CUT_STAIRS;
            case BROWN -> BROWN_CRYSTALLIUM_CUT_STAIRS;
            case CYAN -> CYAN_CRYSTALLIUM_CUT_STAIRS;
            case GRAY -> GRAY_CRYSTALLIUM_CUT_STAIRS;
            case GREEN -> GREEN_CRYSTALLIUM_CUT_STAIRS;
            case LIGHT_BLUE -> LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS;
            case LIGHT_GRAY -> LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS;
            case LIME -> LIME_CRYSTALLIUM_CUT_STAIRS;
            case MAGENTA -> MAGENTA_CRYSTALLIUM_CUT_STAIRS;
            case ORANGE -> ORANGE_CRYSTALLIUM_CUT_STAIRS;
            case PINK -> PINK_CRYSTALLIUM_CUT_STAIRS;
            case PURPLE -> PURPLE_CRYSTALLIUM_CUT_STAIRS;
            case RED -> RED_CRYSTALLIUM_CUT_STAIRS;
            case WHITE -> WHITE_CRYSTALLIUM_CUT_STAIRS;
            case YELLOW -> YELLOW_CRYSTALLIUM_CUT_STAIRS;
        };
    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MotoMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MotoMod.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(MotoMod.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MotoMod.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MotoMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MotoMod.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        MotoMod.LOGGER.info("Registering Mod Blocks for " + MotoMod.MOD_ID);

    }
}
