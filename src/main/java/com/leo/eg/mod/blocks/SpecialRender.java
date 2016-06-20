package com.leo.eg.mod.blocks;

import com.leo.eg.mod.Reference;
import com.leo.eg.mod.init.NewModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class SpecialRender {
	public static void BlockRegRender(){
		ModelBakery.addVariantName(Item.getItemFromBlock(NewModBlocks.color_cobble), "nm:color_cobble.white", "nm:color_cobble.dark");
		
	}
	
	
}
