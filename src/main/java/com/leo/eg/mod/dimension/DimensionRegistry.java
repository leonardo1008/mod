package com.leo.eg.mod.dimension;

import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry {
	public static void dimensionRegistry(){
		registerDimension();
	}
	public static int dimensionId = 10;
	
	public static void registerDimension(){
		DimensionManager.registerProviderType(dimensionId, WorldMiningProvider.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
	}
}
