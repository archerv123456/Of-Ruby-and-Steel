package com.example;

import com.example.block.ModBlocks;
import com.example.datagen.*;
import com.example.enchantment.CurseOfHarmingEnchantment;
import com.example.items.ModItems;
import com.example.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.EnchantedItemCriterion;
import net.minecraft.advancement.criterion.EnterBlockCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.state.State;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class ExampleModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(AdvancementsProvider::new);
	}

	static class AdvancementsProvider extends FabricAdvancementProvider {
		protected AdvancementsProvider(FabricDataOutput dataGenerator) {
			super(dataGenerator);
		}

		@Override
		public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
			AdvancementEntry rootAdvancment = Advancement.Builder.create()
					.display(
							ModItems.RUBY,
							Text.literal("Of Steel and Ruby"),
							Text.literal("Just the start..."),
							new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("spawn", TickCriterion.Conditions.createTick())
					.build(consumer, "examplemod" + "/root");

			AdvancementEntry GotSteel = Advancement.Builder.create().parent(rootAdvancment)
					.display(
							ModItems.STEEL, // The display icon
							Text.literal("Steel!"), // The title
							Text.literal("The weird middle material."), // The description
							null,
							AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
							true, // Show toast top right
							true, // Announce to chat
							false // Hidden in the advancement tab
					)
					// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
					.criterion("got_steel", InventoryChangedCriterion.Conditions.items(ModItems.STEEL))
					.build(consumer, "examplemod" + "/got_steel");

			AdvancementEntry GotSteelPickaxeAdvancement = Advancement.Builder.create().parent(GotSteel)
					.display(
							ModItems.STEEL_PICKAXE,
							Text.literal("Pickaxe of Steel"),
							Text.literal("Maybe you can mine something stronger..."),
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("got_steel_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.STEEL_PICKAXE))
					.build(consumer, "examplemod" + "/got_steel_pickaxe");

			AdvancementEntry GotRubyAdvancement = Advancement.Builder.create().parent(GotSteelPickaxeAdvancement)
					.display(
							ModItems.RUBY,
							Text.literal("Ruby... Ruby..."),
							Text.literal("Now all you need is... a few more?"),
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("got_ruby", InventoryChangedCriterion.Conditions.items(ModItems.RUBY))
					.build(consumer, "examplemod" + "/got_ruby");

			AdvancementEntry GotMetalDetector = Advancement.Builder.create().parent(GotRubyAdvancement)
					.display(
							ModItems.METAL_DETECTOR,
							Text.literal("Metal Finder"),
							Text.literal("Doesn't detect debris."),
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("got_metal_detector", InventoryChangedCriterion.Conditions.items(ModItems.METAL_DETECTOR))
					.build(consumer, "examplemod" + "/got_metal_detector");

			AdvancementEntry GotSoundBlock = Advancement.Builder.create().parent(GotRubyAdvancement)
					.display(
							ModBlocks.SOUND_BLOCK,
							Text.literal("It makes sound..."),
							Text.literal("...why?"),
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("got_sound_block", InventoryChangedCriterion.Conditions.items(ModBlocks.SOUND_BLOCK))
					.build(consumer, "examplemod" + "/got_sound_block");



			AdvancementEntry GotSteelShortandLongsword = Advancement.Builder.create().parent(GotSteel)
					.display(
							ModItems.STEEL_LONGSWORD,
							Text.literal("There's 2!?"),
							Text.literal("Alright then..."),
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("got_steel_longsword", InventoryChangedCriterion.Conditions.items(ModItems.STEEL_LONGSWORD))
					.criterion("got_steel_shortsword", InventoryChangedCriterion.Conditions.items(ModItems.STEEL_SHORTSWORD))
					.build(consumer, "examplemod" + "/got_steel_shortandlongsword");

			AdvancementEntry GotFullRubySet = Advancement.Builder.create().parent(GotRubyAdvancement)
					.display(
							ModItems.RUBY_CHESTPLATE,
							Text.literal("Man of Flames"),
							Text.literal("That's one way to be fired up!"),
							null, // children to parent advancements don't need a background set
							AdvancementFrame.TASK,
							true,
							true,
							false
					)
					.criterion("got_ruby_helmet", InventoryChangedCriterion.Conditions.items(ModItems.RUBY_HELMET))
					.criterion("got_ruby_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.RUBY_CHESTPLATE))
					.criterion("got_ruby_legging", InventoryChangedCriterion.Conditions.items(ModItems.RUBY_LEGGING))
					.criterion("got_ruby_boots", InventoryChangedCriterion.Conditions.items(ModItems.RUBY_BOOTS))
					.build(consumer, "examplemod" + "/got_full_ruby_set");
		}
	}
}
