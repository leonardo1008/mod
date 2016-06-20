package com.leo.eg.mod;

import com.leo.eg.mod.init.NewModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NewModTab extends CreativeTabs{

	public NewModTab(String label) {
		super(label);
		
	}

	@Override
	public Item getTabIconItem() {
		return NewModItems.good_item;
	}

}
