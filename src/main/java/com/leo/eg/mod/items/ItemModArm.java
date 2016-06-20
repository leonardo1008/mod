package com.leo.eg.mod.items;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModItems;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.animation.Event;


public class ItemModArm extends ItemArmor {

	public ItemModArm(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
		

	}
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		if(stack.getItem() == NewModItems.piladboots || stack.getItem() == Items.diamond_boots || stack.getItem() == Items.iron_boots){
			int l = EnchantmentHelper.getEnchantmentLevel(NewMod.jumpBoost.effectId, stack);
			if(l > 0){
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 50, l - 1));
			}
		}
	}
	

	private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestpiece, Item leggings, Item boots){
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet
			&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestpiece 
			&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings
			&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == helmet;
		 	
	}
	
	


}
