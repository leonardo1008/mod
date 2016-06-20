package com.leo.eg.mod.blocks.crops;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class NMO extends BlockCrops{
	public NMO(String name){
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
	}
	public Item getSeed(){
		return NewModItems.good_food_item;
	}
	public Item getCrop(){
		return NewModItems.carboncoal;
	}
}
