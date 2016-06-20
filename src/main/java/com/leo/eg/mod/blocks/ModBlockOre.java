package com.leo.eg.mod.blocks;

import java.util.Random;

import com.leo.eg.mod.NewMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class ModBlockOre extends Block {
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;

	public ModBlockOre(String unlocalizedName, Material mat) {
		super(mat);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(10.0f);
		this.setResistance(15.0f);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(NewMod.tabNewMod);
	}
	
}