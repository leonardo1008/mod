package com.leo.eg.mod.dimension;

import java.util.Random;

import com.leo.eg.mod.biome.BiomeRegistry;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class MiningDimension {
	private static int id = DimensionRegistry.dimensionId;
	public static String name = "Mining Dimension";
	public static boolean isMiningDimension;

	public static void init() {
		id = DimensionRegistry.dimensionId;
		DimensionManager.registerProviderType(id, WorldMiningProvider.class, true);
		DimensionManager.registerDimension(id, id);
		

	}
	
	public static void setId(int id) {
		MiningDimension.id = id;
	}
	
	public static int getId() {
		return id;
	}
	
	public static BiomeGenBase getBiome(int index)
	{
		return BiomeRegistry.miningBiome;
	}
}
