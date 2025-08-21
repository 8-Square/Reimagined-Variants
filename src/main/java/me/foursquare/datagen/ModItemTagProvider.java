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

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModItemTagProvider.CHERRY_TOOLS)
                .add(ModItems.CHERRY_PICKAXE)
                .add(ModItems.CHERRY_SWORD)
                .add(ModItems.CHERRY_AXE)
                .add(ModItems.CHERRY_SHOVEL)
                .add(ModItems.CHERRY_HOE);
        valueLookupBuilder(ModItemTagProvider.MANGROVE_TOOLS)
                .add(ModItems.MANGROVE_SWORD);
    }


}


