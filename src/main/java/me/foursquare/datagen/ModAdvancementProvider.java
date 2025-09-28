package me.foursquare.datagen;

import me.foursquare.ReimaginedVariants;
import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        final RegistryEntryLookup<Item> itemLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);
        final RegistryEntry<Biome> cherryGrove = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.CHERRY_GROVE);
        final RegistryEntry<Biome> mangrove = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.MANGROVE_SWAMP);
        final RegistryEntryList.Named<Biome> spruce = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.SPRUCE_BIOMES);
        final RegistryEntryList.Named<Biome> birch = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.BIRCH_BIOMES);
        final RegistryEntryList.Named<Biome> warped = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.WARPED_BIOMES);
        final RegistryEntryList.Named<Biome> crimson = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.CRIMSON_BIOMES);
        final RegistryEntryList.Named<Biome> jungle = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.JUNGLE_BIOMES);
        final RegistryEntryList.Named<Biome> acacia = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.ACACIA_BIOMES);
        final RegistryEntryList.Named<Biome> dark_oak = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.DARK_OAK_BIOMES);
        final RegistryEntryList.Named<Biome> pale_oak = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.PALE_OAK_BIOMES);
        final RegistryEntryList.Named<Biome> bamboo = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(ModBiomeTagProvider.BAMBOO_BIOMES);

// <editor-fold desc="OVERALL ADVANCEMENTS">
        AdvancementEntry getCustomWoodVariant = Advancement.Builder.create()
                .display(
                        ModItems.CRIMSON_AXE,
                        Text.literal("Reimagined Variants"),
                        Text.literal("Craft A Wooden Tool Variant"),
                        Identifier.of(ReimaginedVariants.MOD_ID, "gui/advancement/cherry"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_wood_variant_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.WOODEN_VARIANT_TOOLS).build()
                ))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_wood_variant_tool");

        AdvancementEntry getAllCustomWoodVariant = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        Items.NETHER_STAR,
                        Text.literal("Reimagined Dedication!"),
                        Text.literal("Craft EVERY SINGLE Wooden Tool Variation"),
                        Identifier.of(ReimaginedVariants.MOD_ID, "gui/advancement/cherry"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("got_all_wood_variant_tool", InventoryChangedCriterion.Conditions.items(
                        //<editor-fold desc="ALL TOOLS">
                        ModItems.CHERRY_SWORD,
                        ModItems.CHERRY_AXE,
                        ModItems.CHERRY_PICKAXE,
                        ModItems.CHERRY_SHOVEL,
                        ModItems.CHERRY_HOE,
                        ModItems.MANGROVE_SWORD,
                        ModItems.MANGROVE_AXE,
                        ModItems.MANGROVE_PICKAXE,
                        ModItems.MANGROVE_SHOVEL,
                        ModItems.MANGROVE_HOE,
                        ModItems.SPRUCE_SWORD,
                        ModItems.SPRUCE_AXE,
                        ModItems.SPRUCE_PICKAXE,
                        ModItems.SPRUCE_SHOVEL,
                        ModItems.SPRUCE_HOE,
                        ModItems.BIRCH_SWORD,
                        ModItems.BIRCH_AXE,
                        ModItems.BIRCH_PICKAXE,
                        ModItems.BIRCH_SHOVEL,
                        ModItems.BIRCH_HOE,
                        ModItems.ACACIA_SWORD,
                        ModItems.ACACIA_AXE,
                        ModItems.ACACIA_PICKAXE,
                        ModItems.ACACIA_SHOVEL,
                        ModItems.ACACIA_HOE,
                        ModItems.JUNGLE_SWORD,
                        ModItems.JUNGLE_AXE,
                        ModItems.JUNGLE_PICKAXE,
                        ModItems.JUNGLE_SHOVEL,
                        ModItems.JUNGLE_HOE,
                        ModItems.WARPED_SWORD,
                        ModItems.WARPED_AXE,
                        ModItems.WARPED_PICKAXE,
                        ModItems.WARPED_SHOVEL,
                        ModItems.WARPED_HOE,
                        ModItems.CRIMSON_SWORD,
                        ModItems.CRIMSON_AXE,
                        ModItems.CRIMSON_PICKAXE,
                        ModItems.CRIMSON_SHOVEL,
                        ModItems.CRIMSON_HOE,
                        ModItems.BAMBOO_SWORD,
                        ModItems.BAMBOO_AXE,
                        ModItems.BAMBOO_PICKAXE,
                        ModItems.BAMBOO_SHOVEL,
                        ModItems.BAMBOO_HOE,
                        ModItems.DARK_OAK_SWORD,
                        ModItems.DARK_OAK_AXE,
                        ModItems.DARK_OAK_PICKAXE,
                        ModItems.DARK_OAK_SHOVEL,
                        ModItems.DARK_OAK_HOE
                        //</editor-fold>
                ))
                .rewards(AdvancementRewards.Builder.experience(920))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_wood_variant_tool");
//</editor-fold>

// <editor-fold desc="CHERRY ADVANCEMENTS">
        AdvancementEntry getCherryTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.CHERRY_SWORD,
                        Text.literal("Cherry!"),
                        Text.literal("Craft A Cherry Tool In A Cherry Biome"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_cherry_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.CHERRY_TOOLS).build()
                ))
                .criterion("got_cherry_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.createBiome(cherryGrove)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_cherry_tool");

        AdvancementEntry getAllCherryTool = Advancement.Builder.create()
                .parent(getCherryTool)
                .display(
                        ModItems.CHERRY_PICKAXE,
                        Text.literal("Cherries!"),
                        Text.literal("Craft Every Cherry Tool While Inside A Cherry Biome"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_cherry_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.CHERRY_SWORD,
                        ModItems.CHERRY_PICKAXE,
                        ModItems.CHERRY_AXE,
                        ModItems.CHERRY_SHOVEL,
                        ModItems.CHERRY_HOE
                ))
                .criterion("got_cherry_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.createBiome(cherryGrove)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_cherry_tool");
// </editor-fold>

// <editor-fold desc="MANGROVE ADVANCEMENTS">
        AdvancementEntry getMangroveTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.MANGROVE_SWORD,
                        Text.literal("Mangrove!"),
                        Text.literal("Mangroves are the best trees"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_mangrove_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.MANGROVE_TOOLS).build()
                ))
                .criterion("got_mangrove_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.createBiome(mangrove)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_mangrove_tool");

        AdvancementEntry getAllMangroveTool = Advancement.Builder.create()
                .parent(getMangroveTool)
                .display(
                        ModItems.MANGROVE_PICKAXE,
                        Text.literal("Mangrove+"),
                        Text.literal("You either got really lucky or travelled 10k blocks to get to this biome"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_mangrove_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.MANGROVE_SWORD,
                        ModItems.MANGROVE_PICKAXE,
                        ModItems.MANGROVE_AXE,
                        ModItems.MANGROVE_SHOVEL,
                        ModItems.MANGROVE_HOE
                ))
                .criterion("got_mangrove_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.createBiome(cherryGrove)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_mangrove_tool");
// </editor-fold>

// <editor-fold desc="SPRUCE ADVANCEMENTS">
        AdvancementEntry getSpruceTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.SPRUCE_SWORD,
                        Text.literal("Spruce Tools"),
                        Text.literal("Mangroves are better than other trees"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_spruce_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.SPRUCE_TOOLS).build()
                ))
                .criterion("got_spruce_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(spruce)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_spruce_tool");

        AdvancementEntry getAllSpruceTool = Advancement.Builder.create()
                .parent(getSpruceTool)
                .display(
                        ModItems.SPRUCE_PICKAXE,
                        Text.literal("Spruce To Perfection"),
                        Text.literal("All spruce tools crafted!"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_spruce_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.SPRUCE_SWORD,
                        ModItems.SPRUCE_PICKAXE,
                        ModItems.SPRUCE_AXE,
                        ModItems.SPRUCE_SHOVEL,
                        ModItems.SPRUCE_HOE
                ))
                .criterion("got_spruce_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(spruce)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_spruce_tool");
// </editor-fold>

// <editor-fold desc="BIRCH ADVANCEMENTS">
        AdvancementEntry getBirchTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.BIRCH_SWORD,
                        Text.literal("Someone Actually Uses Birch??"),
                        Text.literal("Never expected someone to craft this"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_birch_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.BIRCH_TOOLS).build()
                ))
                .criterion("got_birch_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(birch)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_birch_tool");

        AdvancementEntry getAllBirchTool = Advancement.Builder.create()
                .parent(getBirchTool)
                .display(
                        ModItems.BIRCH_PICKAXE,
                        Text.literal("Barking Up The Wrong Tree"),
                        Text.literal("You crafted all birch tools, Take a hidden achievement"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .criterion("got_all_birch_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.BIRCH_SWORD,
                        ModItems.BIRCH_PICKAXE,
                        ModItems.BIRCH_AXE,
                        ModItems.BIRCH_SHOVEL,
                        ModItems.BIRCH_HOE
                ))
                .criterion("got_birch_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(birch)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_birch_tool");
// </editor-fold>

// <editor-fold desc="ACACIA ADVANCEMENTS">
        AdvancementEntry getAcaciaTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.ACACIA_SWORD,
                        Text.literal("You really took a tree down for this?"),
                        Text.literal("Never expected someone to craft this"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_acacia_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.ACACIA_TOOLS).build()
                ))
                .criterion("got_acacia_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(acacia)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_acacia_tool");

        AdvancementEntry getAllAcaciaTool = Advancement.Builder.create()
                .parent(getAcaciaTool)
                .display(
                        ModItems.ACACIA_PICKAXE,
                        Text.literal("No Shade Here"),
                        Text.literal("You just took down your only tree just for a few wooden tools"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_acacia_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.ACACIA_SWORD,
                        ModItems.ACACIA_PICKAXE,
                        ModItems.ACACIA_AXE,
                        ModItems.ACACIA_SHOVEL,
                        ModItems.ACACIA_HOE
                ))
                .criterion("got_acacia_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(acacia)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_acacia_tool");
// </editor-fold>

// <editor-fold desc="JUNGLE ADVANCEMENTS">
        AdvancementEntry getJungleTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.JUNGLE_SWORD,
                        Text.literal("Welcome To The Jungle!"),
                        Text.literal("We've got tools and games"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_jungle_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.JUNGLE_TOOLS).build()
                ))
                .criterion("got_jungle_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(jungle)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_jungle_tool");

        AdvancementEntry getAllJungleTool = Advancement.Builder.create()
                .parent(getJungleTool)
                .display(
                        ModItems.JUNGLE_PICKAXE,
                        Text.literal("The Jungle"),
                        Text.literal("What An Annoying Place"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_jungle_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.JUNGLE_SWORD,
                        ModItems.JUNGLE_PICKAXE,
                        ModItems.JUNGLE_AXE,
                        ModItems.JUNGLE_SHOVEL,
                        ModItems.JUNGLE_HOE
                ))
                .criterion("got_jungle_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(jungle)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_jungle_tool");
// </editor-fold>

// <editor-fold desc="WARPED ADVANCEMENTS">
        AdvancementEntry getWarpedTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.WARPED_SWORD,
                        Text.literal("Warped Your Way"),
                        Text.literal(""),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_warped_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.WARPED_TOOLS).build()
                ))
                .criterion("got_warped_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(warped)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_warped_tool");

        AdvancementEntry getAllWarpedTool = Advancement.Builder.create()
                .parent(getWarpedTool)
                .display(
                        ModItems.WARPED_PICKAXE,
                        Text.literal("Warped Ambitions"),
                        Text.literal("Alright Speedrunner *eye roll*"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_warped_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.WARPED_SWORD,
                        ModItems.WARPED_PICKAXE,
                        ModItems.WARPED_AXE,
                        ModItems.WARPED_SHOVEL,
                        ModItems.WARPED_HOE
                ))
                .criterion("got_warped_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(warped)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_warped_tool");
// </editor-fold>

// <editor-fold desc="CRIMSON ADVANCEMENTS">
        AdvancementEntry getCrimsonTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.CRIMSON_SWORD,
                        Text.literal("Red as Blood"),
                        Text.literal("Obtain A Crimson Tool"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_crimson_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.CRIMSON_TOOLS).build()
                ))
                .criterion("got_crimson_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(crimson)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_crimson_tool");

        AdvancementEntry getAllCrimsonTool = Advancement.Builder.create()
                .parent(getCrimsonTool)
                .display(
                        ModItems.CRIMSON_PICKAXE,
                        Text.literal("Crimson Vengeance"),
                        Text.literal("Guess you like: THE NETHER"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_crimson_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.CRIMSON_SWORD,
                        ModItems.CRIMSON_PICKAXE,
                        ModItems.CRIMSON_AXE,
                        ModItems.CRIMSON_SHOVEL,
                        ModItems.CRIMSON_HOE
                ))
                .criterion("got_crimson_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(crimson)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_crimson_tool");
// </editor-fold>

// <editor-fold desc="BAMBOO ADVANCEMENTS">
        AdvancementEntry getBambooTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.BAMBOO_SWORD,
                        Text.literal("Sticks & Stones May Break My Bones"),
                        Text.literal("Craft A Bamboo Tool"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_bamboo_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.BAMBOO_TOOLS).build()
                ))
                .criterion("got_bamboo_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(bamboo)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_bamboo_tool");

        AdvancementEntry getAllBambooTool = Advancement.Builder.create()
                .parent(getBambooTool)
                .display(
                        ModItems.BAMBOO_PICKAXE,
                        Text.literal("Bamboo Dynasty"),
                        Text.literal("Guess you really like pandas"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_bamboo_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.BAMBOO_SWORD,
                        ModItems.BAMBOO_PICKAXE,
                        ModItems.BAMBOO_AXE,
                        ModItems.BAMBOO_SHOVEL,
                        ModItems.BAMBOO_HOE
                ))
                .criterion("got_bamboo_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(bamboo)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_bamboo_tool");
// </editor-fold>

// <editor-fold desc="DARK OAK ADVANCEMENTS">
        AdvancementEntry getDarkOakTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.DARK_OAK_SWORD,
                        Text.literal("Dark & Spooky"),
                        Text.literal("I- I- i d-d-don't like the dark o-oak"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_dark_oak_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.DARK_OAK_TOOLS).build()
                ))
                .criterion("got_dark_oak_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(dark_oak)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_dark_oak_tool");

        AdvancementEntry getAllDarkOakTool = Advancement.Builder.create()
                .parent(getDarkOakTool)
                .display(
                        ModItems.DARK_OAK_PICKAXE,
                        Text.literal("The Dark One"),
                        Text.literal("It takes a bit of dedication to get here and do all this"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_dark_oak_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.DARK_OAK_SWORD,
                        ModItems.DARK_OAK_PICKAXE,
                        ModItems.DARK_OAK_AXE,
                        ModItems.DARK_OAK_SHOVEL,
                        ModItems.DARK_OAK_HOE
                ))
                .criterion("got_dark_oak_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(dark_oak)
                        )))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_dark_oak_tool");
// </editor-fold>

// <editor-fold desc="PALE OAK ADVANCEMENTS">
        AdvancementEntry getPaleOakTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        ModItems.PALE_OAK_SWORD,
                        Text.literal("Pale as Bone"),
                        Text.literal("Craft a Pale Oak Tool"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_pale_oak_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.PALE_OAK_TOOLS).build()
                ))
                .criterion("got_pale_oak_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.create().biome(pale_oak)
                        )))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_pale_oak_tool");

        AdvancementEntry getAllPaleOakTool = Advancement.Builder.create()
                .parent(getPaleOakTool)
                .display(
                        ModItems.PALE_OAK_PICKAXE,
                        Text.literal("Pale & Stale"),
                        Text.literal("Either you're really lucky or you used creative"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("got_all_pale_oak_tool", InventoryChangedCriterion.Conditions.items(
                        ModItems.PALE_OAK_SWORD,
                        ModItems.PALE_OAK_PICKAXE,
                        ModItems.PALE_OAK_AXE,
                        ModItems.PALE_OAK_SHOVEL,
                        ModItems.PALE_OAK_HOE
                ))
                .criterion("got_pale_oak_biome", TickCriterion.Conditions.createLocation(
                        EntityPredicate.Builder.create().location(
                                LocationPredicate.Builder.create().biome(pale_oak)
                        )))
                .rewards(AdvancementRewards.Builder.experience(200))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_pale_oak_tool");
// </editor-fold>

// <editor-fold desc="REGULAR ADVANCEMENTS">
        AdvancementEntry getRegularTool = Advancement.Builder.create()
                .parent(getCustomWoodVariant)
                .display(
                        Items.WOODEN_SWORD,
                        Text.literal("Plain & Unlucky"),
                        Text.literal("Out of all the wood types you chose oak..."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("got_regular_tool", InventoryChangedCriterion.Conditions.items(
                        ItemPredicate.Builder.create().tag(itemLookup, ModItemTagProvider.WOODEN_TOOLS).build()
                ))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_regular_tool");

        AdvancementEntry getAllRegularTool = Advancement.Builder.create()
                .parent(getRegularTool)
                .display(
                        Items.WOODEN_PICKAXE,
                        Text.literal("Extra Unordinary"),
                        Text.literal("Really... this has to be on purpose..."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("got_all_regular_tool", InventoryChangedCriterion.Conditions.items(
                        Items.WOODEN_SWORD,
                        Items.WOODEN_AXE,
                        Items.WOODEN_PICKAXE,
                        Items.WOODEN_HOE,
                        Items.WOODEN_SHOVEL
                ))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_regular_tool");

// </editor-fold>

    }
}
