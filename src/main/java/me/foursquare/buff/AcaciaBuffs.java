package me.foursquare.buff;

import me.foursquare.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class AcaciaBuffs {

    private AcaciaBuffs() {}


    private static void ApplyBuff(ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = player.getWorld().getBiome(player.getBlockPos());
        boolean InsideSavanna =
                biome.matchesKey(BiomeKeys.SAVANNA) ||
                biome.matchesKey(BiomeKeys.SAVANNA_PLATEAU) ||
                biome.matchesKey(BiomeKeys.WINDSWEPT_FOREST);
        boolean HasTagItem = player.getInventory().contains(ModItemTagProvider.ACACIA_TOOLS);


        if (InsideSavanna && HasTagItem) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 219, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 219, 0));
        }
        }

    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server  ->
                server.getPlayerManager().getPlayerList()
                        .forEach(AcaciaBuffs::ApplyBuff));
    }
}

