package me.foursquare.item;

import me.foursquare.ReimaginedVariants;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    // CHERRY WEAPONS
    public static final Item CHERRY_SWORD = register(
            "cherry_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.CHERRY_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item CHERRY_PICKAXE = register(
            "cherry_pickaxe",
            Item::new,
            new Item.Settings().pickaxe(
                    ModToolMaterial.CHERRY_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item CHERRY_AXE = register(
            "cherry_axe",
            Item::new,
            new Item.Settings().axe(
                    ModToolMaterial.CHERRY_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item CHERRY_HOE = register(
            "cherry_hoe",
            Item::new,
            new Item.Settings().hoe(
                    ModToolMaterial.CHERRY_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));
    public static final Item CHERRY_SHOVEL = register(
            "cherry_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.CHERRY_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));

    // MANGROVE TOOLS
    public static final Item MANGROVE_SWORD = register(
            "mangrove_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.MANGROVE_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item MANGROVE_PICKAXE = register(
            "mangrove_pickaxe",
            Item::new,
            new Item.Settings().pickaxe(
                    ModToolMaterial.MANGROVE_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item MANGROVE_AXE = register(
            "mangrove_axe",
            Item::new,
            new Item.Settings().axe(
                    ModToolMaterial.MANGROVE_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item MANGROVE_SHOVEL = register(
            "mangrove_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.MANGROVE_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item MANGROVE_HOE = register(
            "mangrove_hoe",
            Item::new,
            new Item.Settings().hoe(
                    ModToolMaterial.MANGROVE_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));

    // BIRCH TOOLS
    public static final Item BIRCH_SWORD = register(
            "birch_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.BIRCH_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item BIRCH_PICKAXE = register(
            "birch_pickaxe",
            Item::new,
            new Item.Settings().pickaxe(
                    ModToolMaterial.BIRCH_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item BIRCH_AXE = register(
            "birch_axe",
            Item::new,
            new Item.Settings().axe(
                    ModToolMaterial.BIRCH_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item BIRCH_SHOVEL = register(
            "birch_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.BIRCH_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item BIRCH_HOE = register(
            "birch_hoe",
            Item::new,
            new Item.Settings().hoe(
                    ModToolMaterial.BIRCH_TOOL_MATERIAL,
                    -0.0f,
                    -3.0f
            ));

    // ACACIA TOOLS
    public static final Item ACACIA_SWORD = register(
            "acacia_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.ACACIA_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item ACACIA_PICKAXE = register(
            "acacia_pickaxe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.ACACIA_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item ACACIA_AXE = register(
            "acacia_axe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.ACACIA_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item ACACIA_SHOVEL = register(
            "acacia_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.ACACIA_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item ACACIA_HOE = register(
            "acacia_hoe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.ACACIA_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));

    // SPRUCE TOOLS ////////////////////////////////////////////////////////
    public static final Item SPRUCE_SWORD = register(
            "spruce_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.SPRUCE_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item SPRUCE_PICKAXE = register(
            "spruce_pickaxe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.SPRUCE_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item SPRUCE_AXE = register(
            "spruce_axe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.SPRUCE_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item SPRUCE_SHOVEL = register(
            "spruce_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.SPRUCE_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item SPRUCE_HOE = register(
            "spruce_hoe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.SPRUCE_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));

    // JUNGLE TOOLS ------------------------------------------
    public static final Item JUNGLE_SWORD = register(
            "jungle_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.JUNGLE_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item JUNGLE_PICKAXE = register(
            "jungle_pickaxe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.JUNGLE_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item JUNGLE_AXE = register(
            "jungle_axe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.JUNGLE_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item JUNGLE_SHOVEL = register(
            "jungle_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.JUNGLE_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item JUNGLE_HOE = register(
            "jungle_hoe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.JUNGLE_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));

    // WARPED TOOLS ////////////////////////////////////////////////////////
    public static final Item WARPED_SWORD = register(
            "warped_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.WARPED_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item WARPED_PICKAXE = register(
            "warped_pickaxe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.WARPED_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item WARPED_AXE = register(
            "warped_axe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.WARPED_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item WARPED_SHOVEL = register(
            "warped_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.WARPED_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item WARPED_HOE = register(
            "warped_hoe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.WARPED_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));

    // CRIMSON TOOLS ////////////////////////////////////////////////////////
    public static final Item CRIMSON_SWORD = register(
            "crimson_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.CRIMSON_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item CRIMSON_PICKAXE = register(
            "crimson_pickaxe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.CRIMSON_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item CRIMSON_AXE = register(
            "crimson_axe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.CRIMSON_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item CRIMSON_SHOVEL = register(
            "crimson_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.CRIMSON_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item CRIMSON_HOE = register(
            "crimson_hoe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.CRIMSON_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));


    // BAMBOO TOOLS ////////////////////////////////////////////////////////
    public static final Item BAMBOO_SWORD = register(
            "bamboo_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.BAMBOO_TOOL_MATERIAL,
                    2.6f,
                    -2.4f
            ));
    public static final Item BAMBOO_PICKAXE = register(
            "bamboo_pickaxe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.BAMBOO_TOOL_MATERIAL,
                    0.6f,
                    -2.8f
            ));
    public static final Item BAMBOO_AXE = register(
            "bamboo_axe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.BAMBOO_TOOL_MATERIAL,
                    5.6f,
                    -3.2f
            ));
    public static final Item BAMBOO_SHOVEL = register(
            "bamboo_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.BAMBOO_TOOL_MATERIAL,
                    1.1f,
                    -3.0f
            ));
    public static final Item BAMBOO_HOE = register(
            "bamboo_hoe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.BAMBOO_TOOL_MATERIAL,
                    -0.4f,
                    -3.0f
            ));


    // DARK OAK TOOLS ////////////////////////////////////////////////////////
    public static final Item DARK_OAK_SWORD = register(
            "dark_oak_sword",
            Item::new,
            new Item.Settings().sword(
                    ModToolMaterial.DARK_OAK_TOOL_MATERIAL,
                    3.0f,
                    -2.4f
            ));
    public static final Item DARK_OAK_PICKAXE = register(
            "dark_oak_pickaxe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.DARK_OAK_TOOL_MATERIAL,
                    1.0f,
                    -2.8f
            ));
    public static final Item DARK_OAK_AXE = register(
            "dark_oak_axe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.DARK_OAK_TOOL_MATERIAL,
                    6.0f,
                    -3.2f
            ));
    public static final Item DARK_OAK_SHOVEL = register(
            "dark_oak_shovel",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.DARK_OAK_TOOL_MATERIAL,
                    1.5f,
                    -3.0f
            ));
    public static final Item DARK_OAK_HOE = register(
            "dark_oak_hoe",
            Item::new,
            new Item.Settings().shovel(
                    ModToolMaterial.DARK_OAK_TOOL_MATERIAL,
                    0.0f,
                    -3.0f
            ));
    // STONE TYPES

    // COBBLESTONE PICKAXE


    public static final RegistryKey<ItemGroup> WOODEN_VARIANTS_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "item_group"));
    public static final ItemGroup WOODEN_VARIANTS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.CHERRY_PICKAXE))
            .displayName(Text.translatable("itemGroup.re-variant.wooden_variants"))
            .build();


    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, WOODEN_VARIANTS_KEY, WOODEN_VARIANTS);

        ItemGroupEvents.modifyEntriesEvent(WOODEN_VARIANTS_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.CHERRY_SWORD);
            itemGroup.add(ModItems.CHERRY_PICKAXE);
            itemGroup.add(ModItems.CHERRY_AXE);
            itemGroup.add(ModItems.CHERRY_SHOVEL);
            itemGroup.add(ModItems.CHERRY_HOE);

            itemGroup.add(ModItems.MANGROVE_SWORD);
            itemGroup.add(ModItems.MANGROVE_PICKAXE);
            itemGroup.add(ModItems.MANGROVE_AXE);
            itemGroup.add(ModItems.MANGROVE_SHOVEL);
            itemGroup.add(ModItems.MANGROVE_HOE);

            itemGroup.add(ModItems.BIRCH_SWORD);
            itemGroup.add(ModItems.BIRCH_PICKAXE);
            itemGroup.add(ModItems.BIRCH_AXE);
            itemGroup.add(ModItems.BIRCH_SHOVEL);
            itemGroup.add(ModItems.BIRCH_HOE);

            itemGroup.add(ModItems.ACACIA_SWORD);
            itemGroup.add(ModItems.ACACIA_PICKAXE);
            itemGroup.add(ModItems.ACACIA_AXE);
            itemGroup.add(ModItems.ACACIA_SHOVEL);
            itemGroup.add(ModItems.ACACIA_HOE);

            itemGroup.add(ModItems.SPRUCE_SWORD);
            itemGroup.add(ModItems.SPRUCE_PICKAXE);
            itemGroup.add(ModItems.SPRUCE_AXE);
            itemGroup.add(ModItems.SPRUCE_SHOVEL);
            itemGroup.add(ModItems.SPRUCE_HOE);

            itemGroup.add(ModItems.JUNGLE_SWORD);
            itemGroup.add(ModItems.JUNGLE_PICKAXE);
            itemGroup.add(ModItems.JUNGLE_AXE);
            itemGroup.add(ModItems.JUNGLE_SHOVEL);
            itemGroup.add(ModItems.JUNGLE_HOE);

            itemGroup.add(ModItems.WARPED_SWORD);
            itemGroup.add(ModItems.WARPED_PICKAXE);
            itemGroup.add(ModItems.WARPED_AXE);
            itemGroup.add(ModItems.WARPED_SHOVEL);
            itemGroup.add(ModItems.WARPED_HOE);

            itemGroup.add(ModItems.CRIMSON_SWORD);
            itemGroup.add(ModItems.CRIMSON_PICKAXE);
            itemGroup.add(ModItems.CRIMSON_AXE);
            itemGroup.add(ModItems.CRIMSON_SHOVEL);
            itemGroup.add(ModItems.CRIMSON_HOE);

            itemGroup.add(ModItems.BAMBOO_SWORD);
            itemGroup.add(ModItems.BAMBOO_PICKAXE);
            itemGroup.add(ModItems.BAMBOO_AXE);
            itemGroup.add(ModItems.BAMBOO_SHOVEL);
            itemGroup.add(ModItems.BAMBOO_HOE);

            itemGroup.add(ModItems.DARK_OAK_SWORD);
            itemGroup.add(ModItems.DARK_OAK_PICKAXE);
            itemGroup.add(ModItems.DARK_OAK_AXE);
            itemGroup.add(ModItems.DARK_OAK_SHOVEL);
            itemGroup.add(ModItems.DARK_OAK_HOE);
        });
    }
}
