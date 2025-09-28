package me.foursquare.datagen;

import me.foursquare.ReimaginedVariants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;


public class ModBiomeTagProvider extends FabricTagProvider.FabricValueLookupTagProvider<Biome> {


    public static final TagKey<Biome> SPRUCE_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "spruce_biomes"));
    public static final TagKey<Biome> JUNGLE_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "jungle_biomes"));
    public static final TagKey<Biome> BIRCH_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "birch_biomes"));
    public static final TagKey<Biome> ACACIA_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "acacia_biomes"));
    public static final TagKey<Biome> WARPED_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "warped_biomes"));
    public static final TagKey<Biome> CRIMSON_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "crimson_biomes"));
    public static final TagKey<Biome> DARK_OAK_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "dark_oak_biomes"));
    public static final TagKey<Biome> BAMBOO_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "bamboo_biomes"));
    public static final TagKey<Biome> PALE_OAK_BIOMES = TagKey.of(RegistryKeys.BIOME, Identifier.of(ReimaginedVariants.MOD_ID, "pale_oak_biomes"));

    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture, null);
    }


    @Override
    public void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    }
}
