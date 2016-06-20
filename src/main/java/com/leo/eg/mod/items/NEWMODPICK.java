package com.leo.eg.mod.items;

import com.leo.eg.mod.NewMod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class NEWMODPICK extends ItemPickaxe {
	public NEWMODPICK(String unlocalizedName, ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(NewMod.tabNewMod);
}
}
