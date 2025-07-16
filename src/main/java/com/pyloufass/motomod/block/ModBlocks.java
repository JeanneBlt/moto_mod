package com.pyloufass.motomod.block;

import com.pyloufass.motomod.MotoMod;
import com.pyloufass.motomod.block.custom.LotusCropBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
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

import java.util.function.Function;

public class ModBlocks {

    public static final Block SAPPHORIT_BLOCK = registerBlock("sapphorit_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER_BULB)));

    public static final Block SAPPHORIT_LOTUS_CROP = registerBlockWithoutBlockItem("sapphorit_lotus_crop",
            properties -> new LotusCropBlock(properties.noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
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
