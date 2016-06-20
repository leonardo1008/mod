package com.leo.eg.mod.biome;

import net.minecraft.world.WorldType;

	public class MiningWorldType extends WorldType{
	public MiningWorldType(int par1, String name){
		super(name);
	}
	
	 public net.minecraft.world.gen.layer.GenLayer getBiomeLayer(long worldSeed, net.minecraft.world.gen.layer.GenLayer parentLayer, String chunkProviderSettingsJson)
	    {
	        net.minecraft.world.gen.layer.GenLayer ret = new MiningGenLayerBiome(200L, parentLayer, this, chunkProviderSettingsJson);
	        ret = net.minecraft.world.gen.layer.GenLayerZoom.magnify(1000L, ret, 2);
	        ret = new net.minecraft.world.gen.layer.GenLayerBiomeEdge(1000L, ret);
	        return ret;
	    }
}
