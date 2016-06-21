package com.leo.eg.mod.event;

import com.leo.eg.mod.NewMod;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class SkcEvent {
	@SubscribeEvent
    public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event) {
		event.player.addStat(NewMod.achievementlogin, 1);
		event.player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Get Started! (This mod should be used with NEI mod)"));
		event.player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.YELLOW + "- Craft the Orange Powder with following recipe: top row: Obsidian Obsidian Obsidian, second row: Obsidian Beacon Obsidian, last row: Obsidian Nether_Star Obsidian"));
		event.player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "Then use the NEI mod to reach to the rest of the mod!" + EnumChatFormatting.OBFUSCATED + "BYE!"));
    }
}
