package com.leo.eg.mod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class EnchantmentJumpBoost extends Enchantment {

	public EnchantmentJumpBoost(int enchID,ResourceLocation name,   int enchWeight
			 ) {
		super(enchID, name, enchWeight, EnumEnchantmentType.ARMOR_FEET);
		this.setName("jumpBoost");
		
	}
	
	

	public int getMinEnchantability(int par1){
		return 10 + (par1 - 1) * 5;
		
	}
	
	public int getMaxEnchantability(int par1){
		return this.getMinEnchantability(par1) + 25;
	}
	
	public int getMaxLevel(){
		return 10;
	}
	
	
}
