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
        final RegistryEntry<Biome> spruce = wrapperLookup.getOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.TAIGA);

//        ItemPredicate cherryToolPredicate = ItemPredicate.Builder.create()
//                .tag(itemLookup, ModItemTagProvider.CHERRY_TOOLS).build();

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
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.createBiome(spruce)
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
                        EntityPredicate.Builder.create().location(LocationPredicate.Builder.createBiome(spruce)
                        )))
                .build(consumer, ReimaginedVariants.MOD_ID + "/get_all_spruce_tool");
    }
}
