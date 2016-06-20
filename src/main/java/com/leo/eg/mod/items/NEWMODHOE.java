package com.leo.eg.mod.items;

import com.leo.eg.mod.NewMod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;

public class NEWMODHOE extends ItemHoe {
	public NEWMODHOE(String unlocalizedName, ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(NewMod.tabNewMod);
	}
}
