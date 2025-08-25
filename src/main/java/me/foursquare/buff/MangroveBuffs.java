package me.foursquare.buff;

import me.foursquare.datagen.ModItemTagProvider;
import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.inventory.Inventory;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class MangroveBuffs {

    private MangroveBuffs() {}


    private static void ApplyBuff(ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = player.getWorld().getBiome(player.getBlockPos());
        boolean InsideMangrove = biome.matchesKey(BiomeKeys.MANGROVE_SWAMP);
        boolean HasTagItem = player.getInventory().contains(ModItemTagProvider.MANGROVE_TOOLS);


        if (InsideMangrove && HasTagItem) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 219, 0));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 219, 0));
        }
        }

    public static void initialize() {
        ServerTickEvents.END_SERVER_TICK.register(server  ->
                server.getPlayerManager().getPlayerList()
                        .forEach(MangroveBuffs::ApplyBuff));
    }
}

