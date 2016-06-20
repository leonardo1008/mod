package com.leo.eg.mod.event;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModBlocks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class OnMineEvent {
	@SubscribeEvent
	public void OnMine(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(NewModBlocks.good_block))){
			e.player.addStat(NewMod.achievementcraftblock, 1);
		}
	}
}
