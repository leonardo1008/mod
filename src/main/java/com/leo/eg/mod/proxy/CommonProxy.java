package com.leo.eg.mod.proxy;

import com.leo.eg.mod.init.NewModBlocks;
import com.leo.eg.mod.init.NewModItems;

import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class CommonProxy {
	public void registerRenders(){
		NewModItems.registerRenders();
		NewModBlocks.registerRenders();
		
	}
	
}
