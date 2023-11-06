package com.example.datagen;

import com.example.block.ModBlocks;
import com.example.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE);
    private static final List<ItemConvertible> STEEL_SMELTABLES = List.of(ModItems.RAW_STEEL,
            ModBlocks.STEEL_ORE, ModBlocks.DEEPSLATE_STEEL_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                1.2f, 500, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.6f, 300, "ruby");
        offerSmelting(exporter, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL,
                0.8f, 300, "steel");
        offerBlasting(exporter, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL,
                0.2f, 200, "steel");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL, RecipeCategory.DECORATIONS,
                ModBlocks.STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
                .pattern("CCC")
                .pattern("CRC")
                .pattern("CCC")
                .input('C', Items.COBBLESTONE)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_RUBY)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE, 1)
                .pattern("RRR")
                .pattern(" SD")
                .pattern(" S ")
                .input('D', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE, 1)
                .pattern("RRD")
                .pattern("RS ")
                .pattern(" S ")
                .input('D', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL, 1)
                .pattern(" R ")
                .pattern(" D ")
                .pattern(" S ")
                .input('D', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE, 1)
                .pattern("RR ")
                .pattern(" D ")
                .pattern(" S ")
                .input('D', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_SWORD, 1)
                .pattern(" R ")
                .pattern("DRD")
                .pattern(" S ")
                .input('D', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.METAL_DETECTOR, 1)
                .pattern("iIi")
                .pattern(" R ")
                .pattern("SD ")
                .input('D', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .input('S', Items.STICK)
                .input('i', Items.IRON_INGOT)
                .input('I', Items.IRON_BLOCK)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK, 1)
                .pattern("WWW")
                .pattern("WRW")
                .pattern("WWW")
                .input('W', Items.WHITE_WOOL)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SOUND_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE, 1)
                .pattern("R R")
                .pattern("RRR")
                .pattern("dRd")
                .input('d', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_LEGGING, 1)
                .pattern("RRR")
                .pattern("d d")
                .pattern("R R")
                .input('d', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_LEGGING)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_HELMET, 1)
                .pattern("RdR")
                .pattern("R R")
                .pattern("   ")
                .input('d', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS, 1)
                .pattern("   ")
                .pattern("R R")
                .pattern("d d")
                .input('d', Items.DIAMOND)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.END_CRYSTAL, 6)
                .pattern("ggg")
                .pattern("grg")
                .pattern("oGo")
                .input('g', Items.GLASS)
                .input('r', ModItems.RUBY)
                .input('G', Items.GHAST_TEAR)
                .input('o', Items.OBSIDIAN)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(Items.END_CRYSTAL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" s ")
                .pattern(" s ")
                .input('S', ModItems.STEEL)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_AXE, 1)
                .pattern("SS ")
                .pattern("Ss ")
                .pattern(" s ")
                .input('S', ModItems.STEEL)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_SHOVEL, 1)
                .pattern(" S ")
                .pattern(" s ")
                .pattern(" s ")
                .input('S', ModItems.STEEL)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_HOE, 1)
                .pattern("SS ")
                .pattern(" s ")
                .pattern(" s ")
                .input('S', ModItems.STEEL)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STEEL_SHORTSWORD, 1)
                .pattern("  S")
                .pattern(" i ")
                .pattern("s  ")
                .input('S', ModItems.STEEL)
                .input('s', Items.STICK)
                .input('i', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_SHORTSWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STEEL_LONGSWORD, 1)
                .pattern(" S ")
                .pattern("iSi")
                .pattern(" s ")
                .input('S', ModItems.STEEL)
                .input('s', Items.STICK)
                .input('i', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_LONGSWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STEEL_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.STEEL)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STEEL_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.STEEL)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STEEL_LEGGING, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.STEEL)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_LEGGING)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STEEL_BOOTS, 1)
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.STEEL)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STEEL_BOOTS)));


    }
}
