package com.example;

import com.example.block.ModBlocks;
import com.example.enchantment.*;
import com.example.items.ModItemGroups;
import com.example.items.ModItems;
import com.example.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final RegistryKey<PlacedFeature> RUBY_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("examplemod","ruby_ore"));
	public static final RegistryKey<PlacedFeature> STEEL_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("examplemod","steel_ore"));
	public static final String MOD_ID = "examplemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Enchantment FROST = new FrostEnchantment();
	public static Enchantment GLOWING = new GlowingEnchantment();
	public static Enchantment WEAKENING = new WeakeningEnchantment();
	public static Enchantment POISON = new PoisonEnchantment();
	public static Enchantment EXTRA_HEALTH = new ExtraHealthEnchantment();
	public static Enchantment DRAIN_HEALTH = new HealthDrainEnchantment();
	public static Enchantment WEAKNESS_CURSE = new CurseOfWeakeningEnchantment();
	public static Enchantment SLOWNESS_CURSE = new CurseOfSlownessEnchantment();
	public static Enchantment INSTANTDAMAGE_CURSE = new CurseOfHarmingEnchantment();

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();

		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "frost"), FROST);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "glowing"), GLOWING);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "weakening"), WEAKENING);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "poison"), POISON);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "extra_health"), EXTRA_HEALTH);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "health_drain"), DRAIN_HEALTH);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "weakness_curse"), WEAKNESS_CURSE);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "slowness_curse"), SLOWNESS_CURSE);
		Registry.register(Registries.ENCHANTMENT, new Identifier("examplemod", "instantdamage_curse"), INSTANTDAMAGE_CURSE);

		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, STEEL_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED_KEY);


		LOGGER.info("Hello Fabric world!");
	}
}