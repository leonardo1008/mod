package com.leo.eg.mod.items;



import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.leo.eg.mod.NewMod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class MultiToolPickSword extends ItemPickaxe{

	

	public  MultiToolPickSword(String name ,ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
		
		
	}
	
	private static Set effectiveAgainst = Sets.newHashSet(new Block[] {
		    Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, 
		    Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, 
		    Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, 
		    Blocks.soul_sand, Blocks.mycelium});
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
	    return ImmutableSet.of("pickaxe", "sword");
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, Block block) {
	    if (block.getMaterial() == Material.wood || block.getMaterial() == Material.vine || block.getMaterial() == Material.plants)
	        return this.efficiencyOnProperMaterial;
	    return effectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(stack, block);
	}
	
	
	
	

}
