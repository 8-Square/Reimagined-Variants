package me.foursquare.buff;

import me.foursquare.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class WarpedBuffs {

    private WarpedBuffs() {}


    private static void ApplyBuff(ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = player.getWorld().getBiome(player.getBlockPos());
        boolean InsideWarped =
                biome.matchesKey(BiomeKeys.WARPED_FOREST) ||
                biome.matchesKey(BiomeKeys.NETHER_WASTES);
        boolean HasTagItem = player.getInventory().contains(ModItemTagProvider.WARPED_TOOLS);


        if (InsideWarped && HasTagItem) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 219, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 219, 0));
        }
        }

    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server  ->
                server.getPlayerManager().getPlayerList()
                        .forEach(WarpedBuffs::ApplyBuff));
    }
}

