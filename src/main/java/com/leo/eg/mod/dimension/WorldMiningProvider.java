package com.leo.eg.mod.dimension;

import com.leo.eg.mod.biome.BiomeRegistry;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldMiningProvider extends WorldProvider {

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeRegistry.miningBiome, 1.6F);
		this.dimensionId = DimensionRegistry.dimensionId;
	}
	
	public IChunkProvider createChunkGeneration(){
		return null;
		
	};
	
	@Override
	public String getDimensionName() {
		
		return "Mining";
	}

	@Override
	public String getInternalNameSuffix() {
		
		return "_mining";
	}

	
}
