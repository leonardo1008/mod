package com.leo.eg.mod.items;

import com.leo.eg.mod.NewMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class NEWMODSWORD extends ItemSword {

	public NEWMODSWORD(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(NewMod.tabNewMod);
	}

}
