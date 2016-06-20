package com.leo.eg.mod.items.food;

import com.leo.eg.mod.NewMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class NMFood extends ItemFood{

	public NMFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
		this.setAlwaysEdible();

	}
	 protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	    {
	        if (!worldIn.isRemote)
	        {
	            player.addPotionEffect(new PotionEffect(Potion.absorption.id, 9000, 25));
	            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 9000, 20));
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 9000, 10));
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 9000, 10));
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 9000, 5));
                player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 9000, 10));
                player.addChatComponentMessage(new ChatComponentText("The God of Diamond Gives You A SuperPower For 7 minutes!"));
	        }

	        if (stack.getMetadata() > 0)
	        {
	            if (!worldIn.isRemote)
	            {
	                player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 9000, 20));
	                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 9000, 10));
	                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 9000, 10));
	            }
	        }
	        else
	        {
	            super.onFoodEaten(stack, worldIn, player);
	        }


}
}
