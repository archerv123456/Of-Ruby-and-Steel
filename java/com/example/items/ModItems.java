package com.example.items;

import com.example.ExampleMod;
import com.example.items.custom.MetalDetectorItem;
import com.example.items.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RUBY = registerItem( "ruby", new Item(new FabricItemSettings()) );
    public static final Item STEEL = registerItem( "steel", new Item(new FabricItemSettings()) );
    public static final Item STEEL_NUGGET = registerItem( "steel_nugget", new Item(new FabricItemSettings()) );
    public static final Item RAW_STEEL = registerItem( "raw_steel", new Item(new FabricItemSettings()) );
    public static final Item RAW_RUBY = registerItem( "raw_ruby", new Item(new FabricItemSettings()) );
    public static final Item METAL_DETECTOR = registerItem( "metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));



    public static final Item RUBY_PICKAXE = registerItem( "ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, 4, -2.85f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem( "ruby_axe",
            new AxeItem(ModToolMaterial.RUBY, 12, -2.95f, new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem( "ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, 3, -3.25f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem( "ruby_sword",
            new SwordItem(ModToolMaterial.RUBY, 9, -1.8f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem( "ruby_hoe",
            new HoeItem(ModToolMaterial.RUBY, -5, 0, new FabricItemSettings()));

    public static final Item RUBY_HELMET = registerItem( "ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem( "ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGING = registerItem( "ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem( "ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item STEEL_PICKAXE = registerItem( "steel_pickaxe",
            new PickaxeItem(SteelToolMaterial.STEEL, 4, -2.85f, new FabricItemSettings()));
    public static final Item STEEL_AXE = registerItem( "steel_axe",
            new AxeItem(SteelToolMaterial.STEEL, 5, -2.95f, new FabricItemSettings()));
    public static final Item STEEL_SHOVEL = registerItem( "steel_shovel",
            new ShovelItem(SteelToolMaterial.STEEL, 3, -3.25f, new FabricItemSettings()));
    public static final Item STEEL_SHORTSWORD = registerItem( "steel_shortsword",
            new SwordItem(SteelToolMaterial.STEEL, 2, -1.3f, new FabricItemSettings()));
    public static final Item STEEL_LONGSWORD = registerItem( "steel_longsword",
            new SwordItem(SteelToolMaterial.STEEL, 10, -3f, new FabricItemSettings()));
    public static final Item STEEL_HOE = registerItem( "steel_hoe",
            new HoeItem(SteelToolMaterial.STEEL, 0, 0, new FabricItemSettings()));

    public static final Item STEEL_HELMET = registerItem( "steel_helmet",
            new ModArmorItem(SteelArmorMaterials.STEEL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item STEEL_CHESTPLATE = registerItem( "steel_chestplate",
            new ArmorItem(SteelArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item STEEL_LEGGING = registerItem( "steel_leggings",
            new ArmorItem(SteelArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item STEEL_BOOTS = registerItem( "steel_boots",
            new ArmorItem(SteelArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering Mod Items for " + ExampleMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }

}
