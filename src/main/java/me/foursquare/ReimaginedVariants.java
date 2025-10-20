package me.foursquare;

import me.foursquare.buff.*;
import me.foursquare.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReimaginedVariants implements ModInitializer {
	public static final String MOD_ID = "re-variant";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItems.initialize();

        // BIOME TOOL BUFFS
        CherryGroveBuffs.initialize();
        MangroveBuffs.initialize();
        AcaciaBuffs.initialize();
        BambooBuffs.initialize();
        BirchBuffs.initialize();
        JungleBuffs.initialize();
        SpruceBuffs.initialize();
        WarpedBuffs.initialize();
        CrimsonBuffs.initialize();
        DarkOakBuffs.initialize();

		LOGGER.info("Hello Fabric world!");
	}
}