package com.leo.eg.mod.proxy;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.blocks.SpecialRender;
import com.leo.eg.mod.entity.NMSVC;
import com.leo.eg.mod.entity.NMSmallvillagerCow;
import com.leo.eg.mod.entity.NMTLMob;
import com.leo.eg.mod.entity.NMTireLessMob;
import com.leo.eg.mod.entity.RenderMob;
import com.leo.eg.mod.entity.RenderMob2;
import com.leo.eg.mod.gui.GUIHandler;
import com.leo.eg.mod.handler.NMDrops;
import com.leo.eg.mod.handler.NewModFuelHandler;
import com.leo.eg.mod.init.NewModBlocks;
import com.leo.eg.mod.init.NewModItems;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		NewModItems.registerRenders();
		NewModBlocks.registerRenders();
		RenderingRegistry.registerEntityRenderingHandler(NMTireLessMob.class, new RenderMob(Minecraft.getMinecraft().getRenderManager(), new NMTLMob(), 0.0F));
		SpecialRender.BlockRegRender();
		RenderingRegistry.registerEntityRenderingHandler(NMSmallvillagerCow.class, new RenderMob2(Minecraft.getMinecraft().getRenderManager(), new NMSVC(), 0.0F));
		NewModBlocks.RegRender();
	}
	public void init(FMLInitializationEvent event){
		GameRegistry.registerFuelHandler(new NewModFuelHandler());
		MinecraftForge.EVENT_BUS.register(new NMDrops());
		NewMod.achievementcraftPowder.registerStat();
		
		 NetworkRegistry.INSTANCE.registerGuiHandler(NewMod.proxy, new GUIHandler());
	}
}
