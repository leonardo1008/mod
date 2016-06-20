package com.leo.eg.mod.blocks;

import java.util.ArrayList;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class MultiOre extends Block {

	public MultiOre(String name,Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
		this.setHardness(3.0F);
		this.setHarvestLevel("nm:toolnewmodpick", 3);
	}
	
	@Override
	public ArrayList getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
	    ArrayList drops = new ArrayList();
	    drops.add(new ItemStack(Items.coal, RANDOM.nextInt(3) + 1));
	    drops.add(new ItemStack(Items.iron_ingot, RANDOM.nextInt(2) + 1));
	    drops.add(new ItemStack(Items.gold_ingot, RANDOM.nextInt(2) + 1));
	    drops.add(new ItemStack(Items.dye, RANDOM.nextInt(3) + 2, 4));
	    drops.add(new ItemStack(Items.redstone, RANDOM.nextInt(2) + 2));
	    drops.add(new ItemStack(NewModItems.diamondIngot, RANDOM.nextInt(2) + 1));
	    if (RANDOM.nextFloat() < 0.5F)
	        drops.add(new ItemStack(Items.diamond, RANDOM.nextInt(2) + 2));
	    return drops;
	}

}
