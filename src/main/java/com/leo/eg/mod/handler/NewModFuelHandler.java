package com.leo.eg.mod.handler;

import com.leo.eg.mod.init.NewModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class NewModFuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == NewModItems.carboncoal) return 20000;
		if(fuel.getItem() == NewModItems.good_item) return 1800;
		return 0;
	}

}
