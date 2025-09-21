package me.foursquare.datagen;

import com.mojang.datafixers.types.templates.Tag;
import me.foursquare.ReimaginedVariants;
import me.foursquare.ReimaginedVariantsDataGenerator;
import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Item;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagGroupLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import javax.swing.text.html.HTML;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
                .parent(getSpruceTool)
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
                        Text.literal("Someone Actually Uses Acacia??"),
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
                        Text.literal("Barking Up The Wrong Tree"),
                        Text.literal("You crafted all acacia tools, Take a hidden achievement"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
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
                        Text.literal("Jungle Tools"),
                        Text.literal(""),
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
                        true
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
                        Text.literal("Never expected someone to craft this"),
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
                        Text.literal("You crafted all warped tools, Take a hidden achievement"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
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
                        Text.literal("You crafted all crimson tools, Take a hidden achievement"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
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
    }
}
