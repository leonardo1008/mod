package com.leo.eg.mod.world;

import java.util.Random;

import com.leo.eg.mod.init.NewModBlocks;

import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {
	private WorldGenerator gen_tutorial_ore; 	// Generates Tutorial Ore (used in Overworld)
	private WorldGenerator gen_multi_ore;// Generates Multi Ore (used in Overworld)
	private WorldGenerator gen_cobblestone;	
	private WorldGenerator gen_cobb;// Generates Cobblestone (used in End)
	private WorldGenerator gen_cobble;
	private WorldGenerator gen_cobblest;
	private WorldGenerator gen_na;
	private WorldGenerator genadan;
	private WorldGenerator genadanium;
	private WorldGenerator gen_cobbf;// Generates Cobblestone (used in End)
	private WorldGenerator gen_cobbled;
	private WorldGenerator gena;
	private WorldGenerator genfi;
	private WorldGenerator genpo;
	private WorldGenerator genpi;
	private WorldGenerator genan;
	private WorldGenerator genfil;
	private WorldGenerator genpor;
	private WorldGenerator genpil;
	//@formatter:on

	public WorldGen() {

		this.gen_tutorial_ore = new WorldGenMinable(NewModBlocks.good_block.getDefaultState(), 16);
		this.gen_cobblestone = new WorldGenMinable(NewModBlocks.good_block.getDefaultState(), 16, BlockHelper.forBlock(Blocks.end_stone));
		this.gen_multi_ore = new WorldGenSingleMinable(NewModBlocks.multiOre.getDefaultState());
		this.gen_cobb = new WorldGenMinable(NewModBlocks.good_block.getDefaultState(), 16, BlockHelper.forBlock(Blocks.netherrack));
		this.gen_cobble = new WorldGenMinable(NewModBlocks.good_block.getDefaultState(), 16, BlockHelper.forBlock(Blocks.lava));
		this.gen_cobblest = new WorldGenMinable(NewModBlocks.good_block.getDefaultState(), 16, BlockHelper.forBlock(Blocks.soul_sand));
		this.gen_na = new WorldGenMinable(NewModBlocks.nadaniumOre.getDefaultState(),5, BlockHelper.forBlock(Blocks.soul_sand));
		this.genadan = new WorldGenMinable(NewModBlocks.nadaniumOre.getDefaultState(), 5);
		this.genadanium = new WorldGenMinable(NewModBlocks.nadaniumOre.getDefaultState(), 5, BlockHelper.forBlock(Blocks.end_stone));
		this.gen_cobbf = new WorldGenMinable(NewModBlocks.nadaniumOre.getDefaultState(), 5, BlockHelper.forBlock(Blocks.netherrack));
		this.gen_cobbled = new WorldGenMinable(NewModBlocks.nadaniumOre.getDefaultState(), 5, BlockHelper.forBlock(Blocks.lava));
		this.gena = new WorldGenMinable(NewModBlocks.anadiumOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.end_stone));
		this.genfi = new WorldGenMinable(NewModBlocks.filanidelOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.end_stone));
		this.genpo = new WorldGenMinable(NewModBlocks.portoOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.end_stone));
		this.genpi = new WorldGenMinable(NewModBlocks.piladOre.getDefaultState(), 16, BlockHelper.forBlock(Blocks.end_stone));
		this.genan = new WorldGenMinable(NewModBlocks.anadiumOre.getDefaultState(), 16);
		this.genfil = new WorldGenMinable(NewModBlocks.filanidelOre.getDefaultState(), 16);
		this.genpor = new WorldGenMinable(NewModBlocks.portoOre.getDefaultState(), 16);
		this.genpil = new WorldGenMinable(NewModBlocks.piladOre.getDefaultState(), 16);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0: // Overworld
			this.runGenerator(this.gen_tutorial_ore, world, random, chunkX, chunkZ, 20, 0, 64);
			this.runGenerator(this.gen_multi_ore, world, random, chunkX, chunkZ, 10, 0, 16);
			this.runGenerator(this.genadan, world, random, chunkX, chunkZ, 20, 0, 15);
			this.runGenerator(this.genan, world, random, chunkX, chunkZ, 20, 0, 64);
			this.runGenerator(this.genfil, world, random, chunkX, chunkZ, 20, 0, 64);
			this.runGenerator(this.genpor, world, random, chunkX, chunkZ, 20, 0, 64);
			this.runGenerator(this.genpil, world, random, chunkX, chunkZ, 20, 0, 64);
			break;
		case -1: // Nether
			this.runGenerator(this.gen_cobb, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.gen_cobble, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.gen_cobblest, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.gen_na, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.gen_cobbf, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.gen_cobbled, world, random, chunkX, chunkZ, 10, 0, 80);
			break;
		case 1: // End
			this.runGenerator(this.gen_cobblestone, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.genadanium, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.gena, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.genfi, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.genpo, world, random, chunkX, chunkZ, 10, 0, 80);
			this.runGenerator(this.genpi, world, random, chunkX, chunkZ, 10, 0, 80);
			break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}

}



