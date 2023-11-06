package com.example.util;

import com.example.block.ModBlocks;
import com.example.items.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier END_CITY_ID =
            new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier DUNGEON_ID =
            new Identifier("minecraft", "chests/simple_dungeon");
    private static  final Identifier STRONGHOLD_CORRIDOR_ID =
            new Identifier("minecraft", "chests/stronghold_corridor");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.RUBY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(END_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.STEEL))
                        .with(ItemEntry.builder(ModItems.STEEL_LONGSWORD))
                        .with(ItemEntry.builder(ModItems.STEEL_HELMET))
                        .with(ItemEntry.builder(ModItems.STEEL_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.STEEL_LEGGING))
                        .with(ItemEntry.builder(ModItems.STEEL_BOOTS))
                        .with(ItemEntry.builder(ModItems.STEEL_SHORTSWORD))
                        .with(ItemEntry.builder(ModItems.STEEL_PICKAXE))
                        .with(ItemEntry.builder(ModItems.STEEL_AXE))
                        .with(ItemEntry.builder(ModItems.STEEL_SHOVEL))
                        .with(ItemEntry.builder(ModItems.STEEL_HOE))
                        .with(ItemEntry.builder(ModBlocks.SOUND_BLOCK))
                        .with(ItemEntry.builder(ModBlocks.STEEL_BLOCK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(DUNGEON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.STEEL))
                        .with(ItemEntry.builder(ModItems.RAW_STEEL))
                        .with(ItemEntry.builder(ModItems.STEEL_SHORTSWORD))
                        .with(ItemEntry.builder(ModItems.STEEL_PICKAXE))
                        .with(ItemEntry.builder(ModItems.RAW_STEEL))
                        .with(ItemEntry.builder(ModItems.STEEL_CHESTPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
            }

            if(STRONGHOLD_CORRIDOR_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.RAW_RUBY))
                        .with(ItemEntry.builder(ModItems.STEEL_LONGSWORD))
                        .with(ItemEntry.builder(ModItems.STEEL_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.STEEL_LEGGING))
                        .with(ItemEntry.builder(ModItems.STEEL_BOOTS))
                        .with(ItemEntry.builder(ModItems.STEEL_HELMET))
                        .with(ItemEntry.builder(ModItems.RUBY_SWORD))
                        .with(ItemEntry.builder(ModItems.STEEL_AXE))
                        .with(ItemEntry.builder(ModItems.STEEL_SHORTSWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

            }
        });
    }
}
