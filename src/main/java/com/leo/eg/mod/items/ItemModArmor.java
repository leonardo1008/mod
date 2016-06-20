package com.leo.eg.mod.items;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModArmor extends ItemArmor {

	public ItemModArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(NewMod.tabNewMod);
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack){
		if(itemstack.getItem() == NewModItems.newmodhelmet){
			this.effectPlayer(player, Potion.nightVision, 5);
			this.effectPlayer(player, Potion.waterBreathing, 5);
			this.effectPlayer(player, Potion.heal, 5);
		}
		if(itemstack.getItem() == NewModItems.newmodchestplate){
			this.effectPlayer(player, Potion.resistance, 4);
			this.effectPlayer(player, Potion.regeneration, 25);
			this.effectPlayer(player, Potion.saturation, 10);
		}
		if(itemstack.getItem() == NewModItems.newmodpants){
			this.effectPlayer(player, Potion.moveSpeed, 4);
			this.effectPlayer(player, Potion.digSpeed, 255);
			this.effectPlayer(player, Potion.healthBoost, 20);
		}
		if(itemstack.getItem() == NewModItems.newmodboots){
			this.effectPlayer(player, Potion.jump, 5);
			this.effectPlayer(player, Potion.absorption, 30);
			this.effectPlayer(player, Potion.invisibility, 1);
		}
		if(this.isWearingFullSet(player, NewModItems.newmodhelmet, NewModItems.newmodchestplate, NewModItems.newmodpants, NewModItems.newmodboots)){
			this.effectPlayer(player, Potion.invisibility, 5);
		}
	}
	

	private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestpiece, Item leggings, Item boots){
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet
			&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestpiece 
			&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings
			&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == helmet;
		 	
	}
	
	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
	        player.addPotionEffect(new PotionEffect(potion.id, 1200, amplifier, true, true));
		
	}

}
