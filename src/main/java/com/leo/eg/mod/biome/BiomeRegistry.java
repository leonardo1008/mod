package com.leo.eg.mod.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {
	public static void MainRegistry(){
		initializeBiome();
		registerBiome();
	}
	
	public static BiomeGenBase miningBiome;
	
	public static void initializeBiome(){
		miningBiome = new MiningBiomeGen(200).setBiomeName("Mining").setTemperatureRainfall(1.6F, 1.2F);
	}
	
	public static void registerBiome(){
		BiomeDictionary.registerBiomeType(miningBiome, Type.DRY);
		BiomeManager.addSpawnBiome(miningBiome);
	}
}
