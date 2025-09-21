package me.foursquare.buff;

import me.foursquare.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class DarkOakBuffs {

    private DarkOakBuffs() {}


    private static void ApplyBuff(ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = player.getWorld().getBiome(player.getBlockPos());
        boolean InsideDarkOak =
                biome.matchesKey(BiomeKeys.DARK_FOREST);
        boolean HasTagItem = player.getInventory().contains(ModItemTagProvider.DARK_OAK_TOOLS);


        if (InsideDarkOak && HasTagItem) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 219, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 219, 0));
        }
        }

    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server  ->
                server.getPlayerManager().getPlayerList()
                        .forEach(DarkOakBuffs::ApplyBuff));
    }
}

