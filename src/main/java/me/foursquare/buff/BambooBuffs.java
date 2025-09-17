package me.foursquare.buff;

import me.foursquare.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class BambooBuffs {

    private BambooBuffs() {}


    private static void ApplyBuff(ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = player.getWorld().getBiome(player.getBlockPos());
        boolean InsideBamboo =
                biome.matchesKey(BiomeKeys.BAMBOO_JUNGLE);
        boolean HasTagItem = player.getInventory().contains(ModItemTagProvider.BAMBOO_TOOLS);


        if (InsideBamboo && HasTagItem) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 219, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 219, 0));
        }
        }

    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server  ->
                server.getPlayerManager().getPlayerList()
                        .forEach(BambooBuffs::ApplyBuff));
    }
}

