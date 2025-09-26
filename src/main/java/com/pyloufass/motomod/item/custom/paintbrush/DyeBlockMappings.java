package com.pyloufass.motomod.item.custom.paintbrush;
import com.pyloufass.motomod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.DyeColor;

import java.util.HashMap;
import java.util.Map;

public class DyeBlockMappings {

    public static Map<Block, Block> generateColorMapping(DyeColor targetColor) {
        Map<Block, Block> map = new HashMap<>();

        for (DyeColor sourceColor : DyeColor.values()) {
            if (sourceColor == targetColor) continue;

            // Banners
            map.put(BlockByColor.getBanner(sourceColor), BlockByColor.getBanner(targetColor));
            map.put(BlockByColor.getWallBanner(sourceColor), BlockByColor.getWallBanner(targetColor));

            // Beds
            map.put(BlockByColor.getBed(sourceColor), BlockByColor.getBed(targetColor));

            // Candles
            map.put(BlockByColor.getCandle(sourceColor), BlockByColor.getCandle(targetColor));
            map.put(BlockByColor.getCandleCake(sourceColor), BlockByColor.getCandleCake(targetColor));

            // Carpet
            map.put(BlockByColor.getCarpet(sourceColor), BlockByColor.getCarpet(targetColor));

            // Concrete
            map.put(BlockByColor.getConcrete(sourceColor), BlockByColor.getConcrete(targetColor));
            map.put(BlockByColor.getConcretePowder(sourceColor), BlockByColor.getConcretePowder(targetColor));

            // Glass
            map.put(BlockByColor.getStainedGlass(sourceColor), BlockByColor.getStainedGlass(targetColor));
            map.put(BlockByColor.getStainedGlassPane(sourceColor), BlockByColor.getStainedGlassPane(targetColor));

            // Terracotta
            map.put(BlockByColor.getTerracotta(sourceColor), BlockByColor.getTerracotta(targetColor));
            map.put(BlockByColor.getGlazedTerracotta(sourceColor), BlockByColor.getGlazedTerracotta(targetColor));

            // Wool
            map.put(BlockByColor.getWool(sourceColor), BlockByColor.getWool(targetColor));

            // Shulker boxes
            map.put(BlockByColor.getShulkerBox(sourceColor), BlockByColor.getShulkerBox(targetColor));

            // Custom Crystallium blocks
            map.put(BlockByColor.getCrystalliumBlock(sourceColor), ModBlocks.getCrystalliumBlock(targetColor));

            map.put(BlockByColor.getCrystalliumCut(sourceColor), ModBlocks.getCrystalliumCut(targetColor));

            map.put(BlockByColor.getCrystalliumCutSlab(sourceColor), ModBlocks.getCrystalliumCutSlab(targetColor));

            map.put(BlockByColor.getCrystalliumCutStairs(sourceColor), ModBlocks.getCrystalliumCutStairs(targetColor));
        }

        //special cases

        // terracotta
        map.put(Blocks.TERRACOTTA, BlockByColor.getTerracotta(targetColor));

        // sapphorit crystallium
        map.put(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK, ModBlocks.getCrystalliumBlock(targetColor));

        //candle
        map.put(Blocks.CANDLE, BlockByColor.getCandle(targetColor));
        map.put(Blocks.CANDLE_CAKE, BlockByColor.getCandleCake(targetColor));

        //glass
        map.put(Blocks.GLASS, BlockByColor.getStainedGlass(targetColor));
        map.put(Blocks.GLASS_PANE, BlockByColor.getStainedGlassPane(targetColor));

        return map;
    }
}
