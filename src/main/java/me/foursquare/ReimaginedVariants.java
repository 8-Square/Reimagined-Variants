package me.foursquare;

import me.foursquare.buff.CherryGroveBuffs;
import me.foursquare.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class    ReimaginedVariants implements ModInitializer {
	public static final String MOD_ID = "re-variant";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItems.initialize();
        CherryGroveBuffs.initialize();
		LOGGER.info("Hello Fabric world!");
	}
}