package com.pyloufass.motomod.item.custom.paintbrush;
import com.pyloufass.motomod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.DyeColor;

public class BlockByColor {
    public static Block getBanner(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_BANNER;
            case BLUE -> Blocks.BLUE_BANNER;
            case BROWN -> Blocks.BROWN_BANNER;
            case CYAN -> Blocks.CYAN_BANNER;
            case GRAY -> Blocks.GRAY_BANNER;
            case GREEN -> Blocks.GREEN_BANNER;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_BANNER;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_BANNER;
            case LIME -> Blocks.LIME_BANNER;
            case MAGENTA -> Blocks.MAGENTA_BANNER;
            case ORANGE -> Blocks.ORANGE_BANNER;
            case PINK -> Blocks.PINK_BANNER;
            case PURPLE -> Blocks.PURPLE_BANNER;
            case RED -> Blocks.RED_BANNER;
            case WHITE -> Blocks.WHITE_BANNER;
            case YELLOW -> Blocks.YELLOW_BANNER;
        };
    }

    public static Block getBed(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_BED;
            case BLUE -> Blocks.BLUE_BED;
            case BROWN -> Blocks.BROWN_BED;
            case CYAN -> Blocks.CYAN_BED;
            case GRAY -> Blocks.GRAY_BED;
            case GREEN -> Blocks.GREEN_BED;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_BED;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_BED;
            case LIME -> Blocks.LIME_BED;
            case MAGENTA -> Blocks.MAGENTA_BED;
            case ORANGE -> Blocks.ORANGE_BED;
            case PINK -> Blocks.PINK_BED;
            case PURPLE -> Blocks.PURPLE_BED;
            case RED -> Blocks.RED_BED;
            case WHITE -> Blocks.WHITE_BED;
            case YELLOW -> Blocks.YELLOW_BED;
        };
    }

    public static Block getCandle(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_CANDLE;
            case BLUE -> Blocks.BLUE_CANDLE;
            case BROWN -> Blocks.BROWN_CANDLE;
            case CYAN -> Blocks.CYAN_CANDLE;
            case GRAY -> Blocks.GRAY_CANDLE;
            case GREEN -> Blocks.GREEN_CANDLE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_CANDLE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_CANDLE;
            case LIME -> Blocks.LIME_CANDLE;
            case MAGENTA -> Blocks.MAGENTA_CANDLE;
            case ORANGE -> Blocks.ORANGE_CANDLE;
            case PINK -> Blocks.PINK_CANDLE;
            case PURPLE -> Blocks.PURPLE_CANDLE;
            case RED -> Blocks.RED_CANDLE;
            case WHITE -> Blocks.WHITE_CANDLE;
            case YELLOW -> Blocks.YELLOW_CANDLE;
        };
    }

    public static Block getCandleCake(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_CANDLE_CAKE;
            case BLUE -> Blocks.BLUE_CANDLE_CAKE;
            case BROWN -> Blocks.BROWN_CANDLE_CAKE;
            case CYAN -> Blocks.CYAN_CANDLE_CAKE;
            case GRAY -> Blocks.GRAY_CANDLE_CAKE;
            case GREEN -> Blocks.GREEN_CANDLE_CAKE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_CANDLE_CAKE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_CANDLE_CAKE;
            case LIME -> Blocks.LIME_CANDLE_CAKE;
            case MAGENTA -> Blocks.MAGENTA_CANDLE_CAKE;
            case ORANGE -> Blocks.ORANGE_CANDLE_CAKE;
            case PINK -> Blocks.PINK_CANDLE_CAKE;
            case PURPLE -> Blocks.PURPLE_CANDLE_CAKE;
            case RED -> Blocks.RED_CANDLE_CAKE;
            case WHITE -> Blocks.WHITE_CANDLE_CAKE;
            case YELLOW -> Blocks.YELLOW_CANDLE_CAKE;
        };
    }

    public static Block getCarpet(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_CARPET;
            case BLUE -> Blocks.BLUE_CARPET;
            case BROWN -> Blocks.BROWN_CARPET;
            case CYAN -> Blocks.CYAN_CARPET;
            case GRAY -> Blocks.GRAY_CARPET;
            case GREEN -> Blocks.GREEN_CARPET;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_CARPET;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_CARPET;
            case LIME -> Blocks.LIME_CARPET;
            case MAGENTA -> Blocks.MAGENTA_CARPET;
            case ORANGE -> Blocks.ORANGE_CARPET;
            case PINK -> Blocks.PINK_CARPET;
            case PURPLE -> Blocks.PURPLE_CARPET;
            case RED -> Blocks.RED_CARPET;
            case WHITE -> Blocks.WHITE_CARPET;
            case YELLOW -> Blocks.YELLOW_CARPET;
        };
    }

    public static Block getConcrete(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_CONCRETE;
            case BLUE -> Blocks.BLUE_CONCRETE;
            case BROWN -> Blocks.BROWN_CONCRETE;
            case CYAN -> Blocks.CYAN_CONCRETE;
            case GRAY -> Blocks.GRAY_CONCRETE;
            case GREEN -> Blocks.GREEN_CONCRETE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_CONCRETE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_CONCRETE;
            case LIME -> Blocks.LIME_CONCRETE;
            case MAGENTA -> Blocks.MAGENTA_CONCRETE;
            case ORANGE -> Blocks.ORANGE_CONCRETE;
            case PINK -> Blocks.PINK_CONCRETE;
            case PURPLE -> Blocks.PURPLE_CONCRETE;
            case RED -> Blocks.RED_CONCRETE;
            case WHITE -> Blocks.WHITE_CONCRETE;
            case YELLOW -> Blocks.YELLOW_CONCRETE;
        };
    }

    public static Block getConcretePowder(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_CONCRETE_POWDER;
            case BLUE -> Blocks.BLUE_CONCRETE_POWDER;
            case BROWN -> Blocks.BROWN_CONCRETE_POWDER;
            case CYAN -> Blocks.CYAN_CONCRETE_POWDER;
            case GRAY -> Blocks.GRAY_CONCRETE_POWDER;
            case GREEN -> Blocks.GREEN_CONCRETE_POWDER;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_CONCRETE_POWDER;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_CONCRETE_POWDER;
            case LIME -> Blocks.LIME_CONCRETE_POWDER;
            case MAGENTA -> Blocks.MAGENTA_CONCRETE_POWDER;
            case ORANGE -> Blocks.ORANGE_CONCRETE_POWDER;
            case PINK -> Blocks.PINK_CONCRETE_POWDER;
            case PURPLE -> Blocks.PURPLE_CONCRETE_POWDER;
            case RED -> Blocks.RED_CONCRETE_POWDER;
            case WHITE -> Blocks.WHITE_CONCRETE_POWDER;
            case YELLOW -> Blocks.YELLOW_CONCRETE_POWDER;
        };
    }

    public static Block getGlazedTerracotta(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_GLAZED_TERRACOTTA;
            case BLUE -> Blocks.BLUE_GLAZED_TERRACOTTA;
            case BROWN -> Blocks.BROWN_GLAZED_TERRACOTTA;
            case CYAN -> Blocks.CYAN_GLAZED_TERRACOTTA;
            case GRAY -> Blocks.GRAY_GLAZED_TERRACOTTA;
            case GREEN -> Blocks.GREEN_GLAZED_TERRACOTTA;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA;
            case LIME -> Blocks.LIME_GLAZED_TERRACOTTA;
            case MAGENTA -> Blocks.MAGENTA_GLAZED_TERRACOTTA;
            case ORANGE -> Blocks.ORANGE_GLAZED_TERRACOTTA;
            case PINK -> Blocks.PINK_GLAZED_TERRACOTTA;
            case PURPLE -> Blocks.PURPLE_GLAZED_TERRACOTTA;
            case RED -> Blocks.RED_GLAZED_TERRACOTTA;
            case WHITE -> Blocks.WHITE_GLAZED_TERRACOTTA;
            case YELLOW -> Blocks.YELLOW_GLAZED_TERRACOTTA;
        };
    }

    public static Block getShulkerBox(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_SHULKER_BOX;
            case BLUE -> Blocks.BLUE_SHULKER_BOX;
            case BROWN -> Blocks.BROWN_SHULKER_BOX;
            case CYAN -> Blocks.CYAN_SHULKER_BOX;
            case GRAY -> Blocks.GRAY_SHULKER_BOX;
            case GREEN -> Blocks.GREEN_SHULKER_BOX;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_SHULKER_BOX;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_SHULKER_BOX;
            case LIME -> Blocks.LIME_SHULKER_BOX;
            case MAGENTA -> Blocks.MAGENTA_SHULKER_BOX;
            case ORANGE -> Blocks.ORANGE_SHULKER_BOX;
            case PINK -> Blocks.PINK_SHULKER_BOX;
            case PURPLE -> Blocks.PURPLE_SHULKER_BOX;
            case RED -> Blocks.RED_SHULKER_BOX;
            case WHITE -> Blocks.WHITE_SHULKER_BOX;
            case YELLOW -> Blocks.YELLOW_SHULKER_BOX;
        };
    }

    public static Block getStainedGlass(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_STAINED_GLASS;
            case BLUE -> Blocks.BLUE_STAINED_GLASS;
            case BROWN -> Blocks.BROWN_STAINED_GLASS;
            case CYAN -> Blocks.CYAN_STAINED_GLASS;
            case GRAY -> Blocks.GRAY_STAINED_GLASS;
            case GREEN -> Blocks.GREEN_STAINED_GLASS;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_STAINED_GLASS;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_STAINED_GLASS;
            case LIME -> Blocks.LIME_STAINED_GLASS;
            case MAGENTA -> Blocks.MAGENTA_STAINED_GLASS;
            case ORANGE -> Blocks.ORANGE_STAINED_GLASS;
            case PINK -> Blocks.PINK_STAINED_GLASS;
            case PURPLE -> Blocks.PURPLE_STAINED_GLASS;
            case RED -> Blocks.RED_STAINED_GLASS;
            case WHITE -> Blocks.WHITE_STAINED_GLASS;
            case YELLOW -> Blocks.YELLOW_STAINED_GLASS;
        };
    }

    public static Block getStainedGlassPane(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_STAINED_GLASS_PANE;
            case BLUE -> Blocks.BLUE_STAINED_GLASS_PANE;
            case BROWN -> Blocks.BROWN_STAINED_GLASS_PANE;
            case CYAN -> Blocks.CYAN_STAINED_GLASS_PANE;
            case GRAY -> Blocks.GRAY_STAINED_GLASS_PANE;
            case GREEN -> Blocks.GREEN_STAINED_GLASS_PANE;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_STAINED_GLASS_PANE;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_STAINED_GLASS_PANE;
            case LIME -> Blocks.LIME_STAINED_GLASS_PANE;
            case MAGENTA -> Blocks.MAGENTA_STAINED_GLASS_PANE;
            case ORANGE -> Blocks.ORANGE_STAINED_GLASS_PANE;
            case PINK -> Blocks.PINK_STAINED_GLASS_PANE;
            case PURPLE -> Blocks.PURPLE_STAINED_GLASS_PANE;
            case RED -> Blocks.RED_STAINED_GLASS_PANE;
            case WHITE -> Blocks.WHITE_STAINED_GLASS_PANE;
            case YELLOW -> Blocks.YELLOW_STAINED_GLASS_PANE;
        };
    }

    public static Block getTerracotta(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_TERRACOTTA;
            case BLUE -> Blocks.BLUE_TERRACOTTA;
            case BROWN -> Blocks.BROWN_TERRACOTTA;
            case CYAN -> Blocks.CYAN_TERRACOTTA;
            case GRAY -> Blocks.GRAY_TERRACOTTA;
            case GREEN -> Blocks.GREEN_TERRACOTTA;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_TERRACOTTA;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_TERRACOTTA;
            case LIME -> Blocks.LIME_TERRACOTTA;
            case MAGENTA -> Blocks.MAGENTA_TERRACOTTA;
            case ORANGE -> Blocks.ORANGE_TERRACOTTA;
            case PINK -> Blocks.PINK_TERRACOTTA;
            case PURPLE -> Blocks.PURPLE_TERRACOTTA;
            case RED -> Blocks.RED_TERRACOTTA;
            case WHITE -> Blocks.WHITE_TERRACOTTA;
            case YELLOW -> Blocks.YELLOW_TERRACOTTA;
        };
    }

    public static Block getWallBanner(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_WALL_BANNER;
            case BLUE -> Blocks.BLUE_WALL_BANNER;
            case BROWN -> Blocks.BROWN_WALL_BANNER;
            case CYAN -> Blocks.CYAN_WALL_BANNER;
            case GRAY -> Blocks.GRAY_WALL_BANNER;
            case GREEN -> Blocks.GREEN_WALL_BANNER;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WALL_BANNER;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WALL_BANNER;
            case LIME -> Blocks.LIME_WALL_BANNER;
            case MAGENTA -> Blocks.MAGENTA_WALL_BANNER;
            case ORANGE -> Blocks.ORANGE_WALL_BANNER;
            case PINK -> Blocks.PINK_WALL_BANNER;
            case PURPLE -> Blocks.PURPLE_WALL_BANNER;
            case RED -> Blocks.RED_WALL_BANNER;
            case WHITE -> Blocks.WHITE_WALL_BANNER;
            case YELLOW -> Blocks.YELLOW_WALL_BANNER;
        };
    }

    public static Block getWool(DyeColor color) {
        return switch (color) {
            case BLACK -> Blocks.BLACK_WOOL;
            case BLUE -> Blocks.BLUE_WOOL;
            case BROWN -> Blocks.BROWN_WOOL;
            case CYAN -> Blocks.CYAN_WOOL;
            case GRAY -> Blocks.GRAY_WOOL;
            case GREEN -> Blocks.GREEN_WOOL;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WOOL;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WOOL;
            case LIME -> Blocks.LIME_WOOL;
            case MAGENTA -> Blocks.MAGENTA_WOOL;
            case ORANGE -> Blocks.ORANGE_WOOL;
            case PINK -> Blocks.PINK_WOOL;
            case PURPLE -> Blocks.PURPLE_WOOL;
            case RED -> Blocks.RED_WOOL;
            case WHITE -> Blocks.WHITE_WOOL;
            case YELLOW -> Blocks.YELLOW_WOOL;
        };
    }

    public static Block getCrystalliumBlock(DyeColor color) {
        return switch (color) {
            case BLACK -> ModBlocks.BLACK_CRYSTALLIUM_BLOCK;
            case BLUE -> ModBlocks.BLUE_CRYSTALLIUM_BLOCK;
            case BROWN -> ModBlocks.BROWN_CRYSTALLIUM_BLOCK;
            case CYAN -> ModBlocks.CYAN_CRYSTALLIUM_BLOCK;
            case GRAY -> ModBlocks.GRAY_CRYSTALLIUM_BLOCK;
            case GREEN -> ModBlocks.GREEN_CRYSTALLIUM_BLOCK;
            case LIGHT_BLUE -> ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK;
            case LIGHT_GRAY -> ModBlocks.LIGHT_GRAY_CRYSTALLIUM_BLOCK;
            case LIME -> ModBlocks.LIME_CRYSTALLIUM_BLOCK;
            case MAGENTA -> ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK;
            case ORANGE -> ModBlocks.ORANGE_CRYSTALLIUM_BLOCK;
            case PINK -> ModBlocks.PINK_CRYSTALLIUM_BLOCK;
            case PURPLE -> ModBlocks.PURPLE_CRYSTALLIUM_BLOCK;
            case RED -> ModBlocks.RED_CRYSTALLIUM_BLOCK;
            case WHITE -> ModBlocks.WHITE_CRYSTALLIUM_BLOCK;
            case YELLOW -> ModBlocks.YELLOW_CRYSTALLIUM_BLOCK;
        };
    }

    public static Block getCrystalliumCut(DyeColor color) {
        return switch (color) {
            case BLACK -> ModBlocks.BLACK_CRYSTALLIUM_CUT;
            case BLUE -> ModBlocks.BLUE_CRYSTALLIUM_CUT;
            case BROWN -> ModBlocks.BROWN_CRYSTALLIUM_CUT;
            case CYAN -> ModBlocks.CYAN_CRYSTALLIUM_CUT;
            case GRAY -> ModBlocks.GRAY_CRYSTALLIUM_CUT;
            case GREEN -> ModBlocks.GREEN_CRYSTALLIUM_CUT;
            case LIGHT_BLUE -> ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT;
            case LIGHT_GRAY -> ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT;
            case LIME -> ModBlocks.LIME_CRYSTALLIUM_CUT;
            case MAGENTA -> ModBlocks.MAGENTA_CRYSTALLIUM_CUT;
            case ORANGE -> ModBlocks.ORANGE_CRYSTALLIUM_CUT;
            case PINK -> ModBlocks.PINK_CRYSTALLIUM_CUT;
            case PURPLE -> ModBlocks.PURPLE_CRYSTALLIUM_CUT;
            case RED -> ModBlocks.RED_CRYSTALLIUM_CUT;
            case WHITE -> ModBlocks.WHITE_CRYSTALLIUM_CUT;
            case YELLOW -> ModBlocks.YELLOW_CRYSTALLIUM_CUT;
        };
    }

    public static Block getCrystalliumCutSlab(DyeColor color) {
        return switch (color) {
            case BLACK -> ModBlocks.BLACK_CRYSTALLIUM_CUT_SLAB;
            case BLUE -> ModBlocks.BLUE_CRYSTALLIUM_CUT_SLAB;
            case BROWN -> ModBlocks.BROWN_CRYSTALLIUM_CUT_SLAB;
            case CYAN -> ModBlocks.CYAN_CRYSTALLIUM_CUT_SLAB;
            case GRAY -> ModBlocks.GRAY_CRYSTALLIUM_CUT_SLAB;
            case GREEN -> ModBlocks.GREEN_CRYSTALLIUM_CUT_SLAB;
            case LIGHT_BLUE -> ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB;
            case LIGHT_GRAY -> ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB;
            case LIME -> ModBlocks.LIME_CRYSTALLIUM_CUT_SLAB;
            case MAGENTA -> ModBlocks.MAGENTA_CRYSTALLIUM_CUT_SLAB;
            case ORANGE -> ModBlocks.ORANGE_CRYSTALLIUM_CUT_SLAB;
            case PINK -> ModBlocks.PINK_CRYSTALLIUM_CUT_SLAB;
            case PURPLE -> ModBlocks.PURPLE_CRYSTALLIUM_CUT_SLAB;
            case RED -> ModBlocks.RED_CRYSTALLIUM_CUT_SLAB;
            case WHITE -> ModBlocks.WHITE_CRYSTALLIUM_CUT_SLAB;
            case YELLOW -> ModBlocks.YELLOW_CRYSTALLIUM_CUT_SLAB;
        };
    }

    public static Block getCrystalliumCutStairs(DyeColor color) {
        return switch (color) {
            case BLACK -> ModBlocks.BLACK_CRYSTALLIUM_CUT_STAIRS;
            case BLUE -> ModBlocks.BLUE_CRYSTALLIUM_CUT_STAIRS;
            case BROWN -> ModBlocks.BROWN_CRYSTALLIUM_CUT_STAIRS;
            case CYAN -> ModBlocks.CYAN_CRYSTALLIUM_CUT_STAIRS;
            case GRAY -> ModBlocks.GRAY_CRYSTALLIUM_CUT_STAIRS;
            case GREEN -> ModBlocks.GREEN_CRYSTALLIUM_CUT_STAIRS;
            case LIGHT_BLUE -> ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS;
            case LIGHT_GRAY -> ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS;
            case LIME -> ModBlocks.LIME_CRYSTALLIUM_CUT_STAIRS;
            case MAGENTA -> ModBlocks.MAGENTA_CRYSTALLIUM_CUT_STAIRS;
            case ORANGE -> ModBlocks.ORANGE_CRYSTALLIUM_CUT_STAIRS;
            case PINK -> ModBlocks.PINK_CRYSTALLIUM_CUT_STAIRS;
            case PURPLE -> ModBlocks.PURPLE_CRYSTALLIUM_CUT_STAIRS;
            case RED -> ModBlocks.RED_CRYSTALLIUM_CUT_STAIRS;
            case WHITE -> ModBlocks.WHITE_CRYSTALLIUM_CUT_STAIRS;
            case YELLOW -> ModBlocks.YELLOW_CRYSTALLIUM_CUT_STAIRS;
        };
    }
}
