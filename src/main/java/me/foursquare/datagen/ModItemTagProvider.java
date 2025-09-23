package me.foursquare.datagen;

import me.foursquare.ReimaginedVariants;
import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Item> WOODEN_VARIANT_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "wooden_variant_tools"));


    public static final TagKey<Item> CHERRY_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "cherry_tools"));
    public static final TagKey<Item> MANGROVE_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "mangrove_tools"));
    public static final TagKey<Item> BIRCH_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "birch_tools"));
    public static final TagKey<Item> ACACIA_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "acacia_tools"));
    public static final TagKey<Item> SPRUCE_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "spruce_tools"));
    public static final TagKey<Item> WARPED_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "warped_tools"));
    public static final TagKey<Item> CRIMSON_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "crimson_tools"));
    public static final TagKey<Item> JUNGLE_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "jungle_tools"));
    public static final TagKey<Item> BAMBOO_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "bamboo_tools"));
    public static final TagKey<Item> DARK_OAK_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "dark_oak_tools"));

    public static final TagKey<Item> WOODEN_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "wooden_tools"));


    public static final TagKey<Item> REPAIRS_CHERRY_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_cherry_tools"
            ));
    public static final TagKey<Item> REPAIRS_SPRUCE_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_spruce_tools"
            ));
    public static final TagKey<Item> REPAIRS_MANGROVE_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_mangrove_tools"
            ));
    public static final TagKey<Item> REPAIRS_BIRCH_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_birch_tools"
            ));
    public static final TagKey<Item> REPAIRS_ACACIA_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_acacia_tools"
            ));
    public static final TagKey<Item> REPAIRS_JUNGLE_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_jungle_tools"
            ));
    public static final TagKey<Item> REPAIRS_WARPED_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_warped_tools"
            ));
    public static final TagKey<Item> REPAIRS_CRIMSON_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_crimson_tools"
            ));
    public static final TagKey<Item> REPAIRS_BAMBOO_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_bamboo_tools"
            ));
    public static final TagKey<Item> REPAIRS_DARK_OAK_TOOLS = TagKey.of(
            Registries.ITEM.getKey(),
            Identifier.of(ReimaginedVariants.MOD_ID, "repairs_dark_oak_tools"
            ));


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModItemTagProvider.WOODEN_VARIANT_TOOLS)
                .add(ModItems.CHERRY_SWORD)
                .add(ModItems.CHERRY_AXE)
                .add(ModItems.CHERRY_PICKAXE)
                .add(ModItems.CHERRY_SHOVEL)
                .add(ModItems.CHERRY_HOE)
                .add(ModItems.MANGROVE_SWORD)
                .add(ModItems.MANGROVE_AXE)
                .add(ModItems.MANGROVE_PICKAXE)
                .add(ModItems.MANGROVE_SHOVEL)
                .add(ModItems.MANGROVE_HOE)
                .add(ModItems.SPRUCE_SWORD)
                .add(ModItems.SPRUCE_AXE)
                .add(ModItems.SPRUCE_PICKAXE)
                .add(ModItems.SPRUCE_SHOVEL)
                .add(ModItems.SPRUCE_HOE)
                .add(ModItems.BIRCH_SWORD)
                .add(ModItems.BIRCH_AXE)
                .add(ModItems.BIRCH_PICKAXE)
                .add(ModItems.BIRCH_SHOVEL)
                .add(ModItems.BIRCH_HOE)
                .add(ModItems.ACACIA_SWORD)
                .add(ModItems.ACACIA_AXE)
                .add(ModItems.ACACIA_PICKAXE)
                .add(ModItems.ACACIA_SHOVEL)
                .add(ModItems.ACACIA_HOE)
                .add(ModItems.JUNGLE_SWORD)
                .add(ModItems.JUNGLE_AXE)
                .add(ModItems.JUNGLE_PICKAXE)
                .add(ModItems.JUNGLE_SHOVEL)
                .add(ModItems.JUNGLE_HOE)
                .add(ModItems.WARPED_SWORD)
                .add(ModItems.WARPED_AXE)
                .add(ModItems.WARPED_PICKAXE)
                .add(ModItems.WARPED_SHOVEL)
                .add(ModItems.WARPED_HOE)
                .add(ModItems.CRIMSON_SWORD)
                .add(ModItems.CRIMSON_AXE)
                .add(ModItems.CRIMSON_PICKAXE)
                .add(ModItems.CRIMSON_SHOVEL)
                .add(ModItems.CRIMSON_HOE)
                .add(ModItems.BAMBOO_SWORD)
                .add(ModItems.BAMBOO_AXE)
                .add(ModItems.BAMBOO_PICKAXE)
                .add(ModItems.BAMBOO_SHOVEL)
                .add(ModItems.BAMBOO_HOE)
                .add(ModItems.DARK_OAK_SWORD)
                .add(ModItems.DARK_OAK_AXE)
                .add(ModItems.DARK_OAK_PICKAXE)
                .add(ModItems.DARK_OAK_SHOVEL)
                .add(ModItems.DARK_OAK_HOE);

        valueLookupBuilder(ModItemTagProvider.CHERRY_TOOLS)
                .add(ModItems.CHERRY_PICKAXE)
                .add(ModItems.CHERRY_SWORD)
                .add(ModItems.CHERRY_AXE)
                .add(ModItems.CHERRY_SHOVEL)
                .add(ModItems.CHERRY_HOE);

        valueLookupBuilder(ModItemTagProvider.MANGROVE_TOOLS)
                .add(ModItems.MANGROVE_SWORD)
                .add(ModItems.MANGROVE_PICKAXE)
                .add(ModItems.MANGROVE_AXE)
                .add(ModItems.MANGROVE_SHOVEL)
                .add(ModItems.MANGROVE_HOE);

        valueLookupBuilder(ModItemTagProvider.BIRCH_TOOLS)
                .add(ModItems.BIRCH_SWORD)
                .add(ModItems.BIRCH_PICKAXE)
                .add(ModItems.BIRCH_AXE)
                .add(ModItems.BIRCH_SHOVEL)
                .add(ModItems.BIRCH_HOE);

        valueLookupBuilder(ModItemTagProvider.SPRUCE_TOOLS)
                .add(ModItems.SPRUCE_SWORD)
                .add(ModItems.SPRUCE_PICKAXE)
                .add(ModItems.SPRUCE_AXE)
                .add(ModItems.SPRUCE_SHOVEL)
                .add(ModItems.SPRUCE_HOE);

        valueLookupBuilder(ModItemTagProvider.JUNGLE_TOOLS)
                .add(ModItems.JUNGLE_SWORD)
                .add(ModItems.JUNGLE_PICKAXE)
                .add(ModItems.JUNGLE_AXE)
                .add(ModItems.JUNGLE_SHOVEL)
                .add(ModItems.JUNGLE_HOE);

        valueLookupBuilder(ModItemTagProvider.WARPED_TOOLS)
                .add(ModItems.WARPED_SWORD)
                .add(ModItems.WARPED_PICKAXE)
                .add(ModItems.WARPED_AXE)
                .add(ModItems.WARPED_SHOVEL)
                .add(ModItems.WARPED_HOE);

        valueLookupBuilder(ModItemTagProvider.CRIMSON_TOOLS)
                .add(ModItems.CRIMSON_SWORD)
                .add(ModItems.CRIMSON_PICKAXE)
                .add(ModItems.CRIMSON_AXE)
                .add(ModItems.CRIMSON_SHOVEL)
                .add(ModItems.CRIMSON_HOE);

        valueLookupBuilder(ModItemTagProvider.BAMBOO_TOOLS)
                .add(ModItems.BAMBOO_SWORD)
                .add(ModItems.BAMBOO_PICKAXE)
                .add(ModItems.BAMBOO_AXE)
                .add(ModItems.BAMBOO_SHOVEL)
                .add(ModItems.BAMBOO_HOE);

        valueLookupBuilder(ModItemTagProvider.DARK_OAK_TOOLS)
                .add(ModItems.DARK_OAK_SWORD)
                .add(ModItems.DARK_OAK_PICKAXE)
                .add(ModItems.DARK_OAK_AXE)
                .add(ModItems.DARK_OAK_SHOVEL)
                .add(ModItems.DARK_OAK_HOE);

        valueLookupBuilder(ModItemTagProvider.WOODEN_TOOLS)
                .add(Items.WOODEN_SWORD)
                .add(Items.WOODEN_PICKAXE)
                .add(Items.WOODEN_AXE)
                .add(Items.WOODEN_SHOVEL)
                .add(Items.WOODEN_HOE);


        valueLookupBuilder(ModItemTagProvider.REPAIRS_CHERRY_TOOLS)
                .add(Items.CHERRY_PLANKS)
                .add(Items.CHERRY_LOG)
                .add(Items.STRIPPED_CHERRY_LOG)
                .add(Items.STRIPPED_CHERRY_WOOD)
                .add(Items.CHERRY_WOOD);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_SPRUCE_TOOLS)
                .add(Items.SPRUCE_PLANKS)
                .add(Items.SPRUCE_LOG)
                .add(Items.STRIPPED_SPRUCE_LOG)
                .add(Items.STRIPPED_SPRUCE_WOOD)
                .add(Items.SPRUCE_WOOD);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_BIRCH_TOOLS)
                .add(Items.BIRCH_PLANKS)
                .add(Items.BIRCH_LOG)
                .add(Items.STRIPPED_BIRCH_LOG)
                .add(Items.STRIPPED_BIRCH_WOOD)
                .add(Items.BIRCH_WOOD);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_MANGROVE_TOOLS)
                .add(Items.MANGROVE_PLANKS)
                .add(Items.MANGROVE_LOG)
                .add(Items.STRIPPED_MANGROVE_LOG)
                .add(Items.STRIPPED_MANGROVE_WOOD)
                .add(Items.MANGROVE_WOOD);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_ACACIA_TOOLS)
                .add(Items.ACACIA_PLANKS)
                .add(Items.ACACIA_LOG)
                .add(Items.STRIPPED_ACACIA_LOG)
                .add(Items.STRIPPED_ACACIA_WOOD)
                .add(Items.ACACIA_WOOD);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_JUNGLE_TOOLS)
                .add(Items.JUNGLE_PLANKS)
                .add(Items.JUNGLE_LOG)
                .add(Items.STRIPPED_JUNGLE_LOG)
                .add(Items.STRIPPED_JUNGLE_WOOD)
                .add(Items.JUNGLE_WOOD);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_WARPED_TOOLS)
                .add(Items.WARPED_PLANKS)
                .add(Items.WARPED_STEM)
                .add(Items.STRIPPED_WARPED_STEM)
                .add(Items.WARPED_NYLIUM)
                .add(Items.WARPED_WART_BLOCK)
                .add(Items.WARPED_FUNGUS)
                .add(Items.STRIPPED_WARPED_HYPHAE);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_CRIMSON_TOOLS)
                .add(Items.CRIMSON_PLANKS)
                .add(Items.CRIMSON_STEM)
                .add(Items.STRIPPED_CRIMSON_STEM)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.NETHER_WART_BLOCK)
                .add(Items.CRIMSON_FUNGUS)
                .add(Items.STRIPPED_CRIMSON_HYPHAE);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_BAMBOO_TOOLS)
                .add(Items.BAMBOO_BLOCK)
                .add(Items.BAMBOO_PLANKS)
                .add(Items.STRIPPED_BAMBOO_BLOCK)
                .add(Items.BAMBOO_MOSAIC)
                .add(Items.BAMBOO);
        valueLookupBuilder(ModItemTagProvider.REPAIRS_DARK_OAK_TOOLS)
                .add(Items.DARK_OAK_PLANKS)
                .add(Items.DARK_OAK_LOG)
                .add(Items.STRIPPED_DARK_OAK_LOG)
                .add(Items.STRIPPED_DARK_OAK_WOOD)
                .add(Items.DARK_OAK_WOOD);


        valueLookupBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.CHERRY_SWORD)
                .add(ModItems.MANGROVE_SWORD)
                .add(ModItems.SPRUCE_SWORD)
                .add(ModItems.BIRCH_SWORD)
                .add(ModItems.ACACIA_SWORD)
                .add(ModItems.JUNGLE_SWORD)
                .add(ModItems.WARPED_SWORD)
                .add(ModItems.CRIMSON_SWORD)
                .add(ModItems.DARK_OAK_SWORD)
                .add(ModItems.BAMBOO_SWORD);
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.CHERRY_SWORD)
                .add(ModItems.MANGROVE_SWORD)
                .add(ModItems.SPRUCE_SWORD)
                .add(ModItems.BIRCH_SWORD)
                .add(ModItems.ACACIA_SWORD)
                .add(ModItems.JUNGLE_SWORD)
                .add(ModItems.WARPED_SWORD)
                .add(ModItems.CRIMSON_SWORD)
                .add(ModItems.BAMBOO_SWORD)
                .add(ModItems.DARK_OAK_SWORD);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.CHERRY_AXE)
                .add(ModItems.MANGROVE_AXE)
                .add(ModItems.SPRUCE_AXE)
                .add(ModItems.BIRCH_AXE)
                .add(ModItems.ACACIA_AXE)
                .add(ModItems.JUNGLE_AXE)
                .add(ModItems.WARPED_AXE)
                .add(ModItems.CRIMSON_AXE)
                .add(ModItems.BAMBOO_AXE)
                .add(ModItems.DARK_OAK_AXE);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.CHERRY_PICKAXE)
                .add(ModItems.MANGROVE_PICKAXE)
                .add(ModItems.SPRUCE_PICKAXE)
                .add(ModItems.BIRCH_PICKAXE)
                .add(ModItems.ACACIA_PICKAXE)
                .add(ModItems.JUNGLE_PICKAXE)
                .add(ModItems.WARPED_PICKAXE)
                .add(ModItems.CRIMSON_PICKAXE)
                .add(ModItems.BAMBOO_PICKAXE)
                .add(ModItems.DARK_OAK_PICKAXE);
        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.CHERRY_PICKAXE)
                .add(ModItems.MANGROVE_PICKAXE)
                .add(ModItems.SPRUCE_PICKAXE)
                .add(ModItems.BIRCH_PICKAXE)
                .add(ModItems.ACACIA_PICKAXE)
                .add(ModItems.JUNGLE_PICKAXE)
                .add(ModItems.WARPED_PICKAXE)
                .add(ModItems.CRIMSON_PICKAXE)
                .add(ModItems.BAMBOO_PICKAXE)
                .add(ModItems.DARK_OAK_PICKAXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.CHERRY_HOE)
                .add(ModItems.MANGROVE_HOE)
                .add(ModItems.SPRUCE_HOE)
                .add(ModItems.BIRCH_HOE)
                .add(ModItems.ACACIA_HOE)
                .add(ModItems.JUNGLE_HOE)
                .add(ModItems.WARPED_HOE)
                .add(ModItems.CRIMSON_HOE)
                .add(ModItems.BAMBOO_HOE)
                .add(ModItems.DARK_OAK_HOE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.CHERRY_SHOVEL)
                .add(ModItems.MANGROVE_SHOVEL)
                .add(ModItems.SPRUCE_SHOVEL)
                .add(ModItems.BIRCH_SHOVEL)
                .add(ModItems.ACACIA_SHOVEL)
                .add(ModItems.JUNGLE_SHOVEL)
                .add(ModItems.WARPED_SHOVEL)
                .add(ModItems.CRIMSON_SHOVEL)
                .add(ModItems.BAMBOO_SHOVEL)
                .add(ModItems.DARK_OAK_SHOVEL);
    }


}


