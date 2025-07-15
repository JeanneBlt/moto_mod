package com.pyloufass.motomod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.BLACK_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.BLUE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.BROWN_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.CYAN_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.GRAY_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.GREEN_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.LIGHT_GREY_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.LIME_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.PINK_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.RED_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.WHITE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.SAPPHORIT_BLOCK);

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
