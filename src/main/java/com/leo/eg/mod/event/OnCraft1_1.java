package com.leo.eg.mod.event;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModItems;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class OnCraft1_1 {
	@SubscribeEvent
	public void OnCraft1(PlayerEvent.ItemCraftedEvent e){
		if(e.crafting.getItem() == NewModItems.good_item){
			e.player.addStat(NewMod.achievementcraftPowder, 1);
		}
	}
}
