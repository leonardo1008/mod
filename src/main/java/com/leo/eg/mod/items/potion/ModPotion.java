package com.leo.eg.mod.items.potion;

import com.leo.eg.mod.init.NewModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ModPotion extends Potion {

	public ModPotion(int potionID, ResourceLocation location, boolean badEffect, int potionColor) {
		super(potionID, location, badEffect, potionColor);
		this.isBadEffect();
		
	}

	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
		}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		 par3EntityPlayer.addPotionEffect(new PotionEffect(NewModItems.newModPotion.id, 200, 0));
		 return null;
		}
}
