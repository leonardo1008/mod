package com.leo.eg.mod.event;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.init.NewModItems;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class OnCraftEvent{
	@SubscribeEvent
	public void OnCraft(PlayerEvent.ItemCraftedEvent e){
		if(e.crafting.getItem().equals(NewModItems.diamondApple)){
			e.player.addStat(NewMod.achievementcraftapple, 1);
		}
	}
}
