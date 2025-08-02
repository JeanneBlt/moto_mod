package com.pyloufass.motomod.datagen;

import com.pyloufass.motomod.block.custom.LotusCropBlock;
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
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.SAPPHORIT_BLOCK);

        addDrop(ModBlocks.SAPPHORIT_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.BLACK_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.BLUE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.BROWN_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.CYAN_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.GRAY_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.GREEN_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.LIME_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.MAGENTA_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.ORANGE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.PINK_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.PURPLE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.RED_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.WHITE_CRYSTALLIUM_BLOCK);
        addDrop(ModBlocks.YELLOW_CRYSTALLIUM_BLOCK);

        addDrop(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.BLACK_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.BLUE_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.BROWN_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.CYAN_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.GRAY_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.GREEN_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.LIME_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.ORANGE_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.PINK_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.PURPLE_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.RED_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.WHITE_CRYSTALLIUM_CUT_STAIRS);
        addDrop(ModBlocks.YELLOW_CRYSTALLIUM_CUT_STAIRS);

        addDrop(ModBlocks.SAPPHORIT_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.BLACK_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.BLUE_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.BROWN_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.CYAN_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.GRAY_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.GREEN_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.LIGHT_BLUE_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.LIGHT_GRAY_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.LIME_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.MAGENTA_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.ORANGE_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.PINK_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.PURPLE_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.RED_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.WHITE_CRYSTALLIUM_CUT_SLAB);
        addDrop(ModBlocks.YELLOW_CRYSTALLIUM_CUT_SLAB);

        addDrop(ModBlocks.SAPPHORIT_LOTUS, sapphoritLotusLoot());

        this.addDrop(ModBlocks.SAPPHORIT_LOTUS_CROP, sapphoritLotusCropLoot());
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }



    public LootTable.Builder sapphoritLotusCropLoot()
    {
        LootTable.Builder lotusLootTable = LootTable.builder();

        lotusLootTable.pool(LootPool.builder()
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.SAPPHORIT_LOTUS_CROP)
                        .properties(StatePredicate.Builder.create().exactMatch(LotusCropBlock.AGE, 0)))
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.SAPPHORIT_SEED))
        );

        lotusLootTable.pool(LootPool.builder()
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.SAPPHORIT_LOTUS_CROP)
                        .properties(StatePredicate.Builder.create().exactMatch(LotusCropBlock.AGE, 1)))
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.SAPPHORIT_SHARD)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f))))
        );
        lotusLootTable.pool(LootPool.builder()
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.SAPPHORIT_LOTUS_CROP)
                        .properties(StatePredicate.Builder.create().exactMatch(LotusCropBlock.AGE, 2)))
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.SAPPHORIT_SHARD)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 6.0f))))
        );

        lotusLootTable.pool(LootPool.builder()
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.SAPPHORIT_LOTUS_CROP)
                        .properties(StatePredicate.Builder.create().exactMatch(LotusCropBlock.AGE, 3)))
                .conditionally(this.createSilkTouchCondition())
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModBlocks.SAPPHORIT_LOTUS))
        );

        lotusLootTable.pool(LootPool.builder()
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.SAPPHORIT_LOTUS_CROP)
                        .properties(StatePredicate.Builder.create().exactMatch(LotusCropBlock.AGE, 3)))
                .conditionally(this.createWithoutSilkTouchCondition())
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.SAPPHORIT_SHARD)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 10.0f))))
        );

        return lotusLootTable;
    }

    public LootTable.Builder sapphoritLotusLoot()
    {
        LootTable.Builder lotusLootTable = LootTable.builder();

        lotusLootTable.pool(LootPool.builder()
                .conditionally(this.createSilkTouchCondition())
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModBlocks.SAPPHORIT_LOTUS)));

        lotusLootTable.pool(LootPool.builder()
                .conditionally(this.createWithoutSilkTouchCondition())
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.SAPPHORIT_SHARD)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 10.0f))))
        );

        return lotusLootTable;
    }


}
