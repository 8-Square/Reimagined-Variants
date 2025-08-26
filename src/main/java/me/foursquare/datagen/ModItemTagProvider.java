package me.foursquare.datagen;

import me.foursquare.ReimaginedVariants;
import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
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

    public static final TagKey<Item> CHERRY_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "cherry_tools"));
    public static final TagKey<Item> MANGROVE_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "mangrove_tools"));
    public static final TagKey<Item> BIRCH_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "birch_tools"));
    public static final TagKey<Item> ACACIA_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "acacia_tools"));
    public static final TagKey<Item> SPRUCE_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "spruce_tools"));
    public static final TagKey<Item> WARPED_TOOLS = TagKey.of(RegistryKeys.ITEM, Identifier.of(ReimaginedVariants.MOD_ID, "warped_tools"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
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

        valueLookupBuilder(ModItemTagProvider.WARPED_TOOLS)
                .add(ModItems.WARPED_SWORD)
                .add(ModItems.WARPED_PICKAXE)
                .add(ModItems.WARPED_AXE)
                .add(ModItems.WARPED_SHOVEL)
                .add(ModItems.WARPED_HOE);

    }


}


