package com.leo.eg.mod.biome;

import com.leo.eg.mod.entity.NMTireLessMob;
import com.leo.eg.mod.init.NewModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class MiningBiomeGen extends BiomeGenBase{
	public MiningBiomeGen(int id){
		super(id);
		this.theBiomeDecorator.bigMushroomsPerChunk = 4;
		this.theBiomeDecorator.treesPerChunk = 3;
		this.spawnableCreatureList.add(new SpawnListEntry(NMTireLessMob.class, 7, 3, 15));
		this.theBiomeDecorator.mushroomsPerChunk = 10;
		this.fillerBlock = NewModBlocks.multiOre.getDefaultState();
		
	}
}
