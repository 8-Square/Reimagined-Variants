package me.foursquare.datagen;

import me.foursquare.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // ACACIA TOOLS
        itemModelGenerator.register(ModItems.ACACIA_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ACACIA_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ACACIA_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ACACIA_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ACACIA_HOE, Models.HANDHELD);

        // BIRCH TOOLS
        itemModelGenerator.register(ModItems.BIRCH_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCH_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCH_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCH_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BIRCH_HOE, Models.HANDHELD);

        // SPRUCE TOOLS
        itemModelGenerator.register(ModItems.SPRUCE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPRUCE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPRUCE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPRUCE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPRUCE_HOE, Models.HANDHELD);

        // MANGROVE TOOLS
        itemModelGenerator.register(ModItems.MANGROVE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MANGROVE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MANGROVE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MANGROVE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MANGROVE_HOE, Models.HANDHELD);

        // CHERRY TOOLS
        itemModelGenerator.register(ModItems.CHERRY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHERRY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHERRY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHERRY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHERRY_HOE, Models.HANDHELD);

        // JUNGLE TOOLS
        itemModelGenerator.register(ModItems.JUNGLE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JUNGLE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JUNGLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JUNGLE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.JUNGLE_HOE, Models.HANDHELD);

        // WARPED TOOLS
        itemModelGenerator.register(ModItems.WARPED_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARPED_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARPED_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARPED_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARPED_HOE, Models.HANDHELD);

        // CRIMSON TOOLS
        itemModelGenerator.register(ModItems.CRIMSON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CRIMSON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CRIMSON_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CRIMSON_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CRIMSON_HOE, Models.HANDHELD);

        // BAMBOO TOOLS
        itemModelGenerator.register(ModItems.BAMBOO_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BAMBOO_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BAMBOO_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BAMBOO_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BAMBOO_HOE, Models.HANDHELD);

        // DARK OAK TOOLS
        itemModelGenerator.register(ModItems.DARK_OAK_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARK_OAK_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARK_OAK_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARK_OAK_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DARK_OAK_HOE, Models.HANDHELD);
    }
}
