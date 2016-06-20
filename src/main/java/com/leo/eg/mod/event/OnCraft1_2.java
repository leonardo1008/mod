package com.leo.eg.mod.event;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModItems;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class OnCraft1_2 {
	@SubscribeEvent
	public void OnCraft3(PlayerEvent.ItemCraftedEvent e){
		if(e.crafting.getItem().equals(NewModItems.toolnewmodsword)){
			e.player.addStat(NewMod.achievementcraftop, 1);
		}
	}
}
