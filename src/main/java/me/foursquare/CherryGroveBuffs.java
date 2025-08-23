package me.foursquare;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class CherryGroveBuffs {

    private CherryGroveBuffs() {}
//    public static void cGApplyBuff {
//
//    }
    private static void tick(ServerPlayerEntity player) {
        RegistryEntry<Biome> biome = player.getWorld().getBiome(player.getBlockPos());
        boolean InsideCherry = biome.matchesKey(BiomeKeys.CHERRY_GROVE);

        if (InsideCherry) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 30, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 30, 1));
        }
    }
    
}
