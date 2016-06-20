package com.leo.eg.mod.items;

import com.leo.eg.mod.NewMod;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class NEWMODAXE extends ItemAxe {
	public NEWMODAXE(String unlocalizedName, ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(NewMod.tabNewMod);
	}
}
