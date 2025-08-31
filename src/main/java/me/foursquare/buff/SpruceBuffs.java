package me.foursquare.buff;

import me.foursquare.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class SpruceBuffs {

    private SpruceBuffs() {}


    private static void ApplyBuff(ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = player.getWorld().getBiome(player.getBlockPos());
        boolean InsideSpruce =
                biome.matchesKey(BiomeKeys.TAIGA) ||
                biome.matchesKey(BiomeKeys.GROVE) ||
                biome.matchesKey(BiomeKeys.WINDSWEPT_FOREST) ||
                biome.matchesKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA) ||
                biome.matchesKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA) ||
                biome.matchesKey(BiomeKeys.SNOWY_TAIGA);
        boolean HasTagItem = player.getInventory().contains(ModItemTagProvider.SPRUCE_TOOLS);


        if (InsideSpruce && HasTagItem) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 219, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 219, 0));
        }
        }

    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server  ->
                server.getPlayerManager().getPlayerList()
                        .forEach(SpruceBuffs::ApplyBuff));
    }
}

