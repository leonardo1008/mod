package com.leo.eg.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTest extends Block {

	public BlockTest(Material materialIn) {
		super(materialIn);
		this.setHarvestLevel("pickaxe", 3);
		this.setHardness(45.0F);
		this.setResistance(100.0F);
	}
}
