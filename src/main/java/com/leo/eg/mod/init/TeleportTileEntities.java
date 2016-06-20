package com.leo.eg.mod.init;

import com.leo.eg.mod.tileentity.PortalTE;
import com.leo.eg.mod.tileentity.Tpblocktileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TeleportTileEntities {
	public static void register(){
		GameRegistry.registerTileEntity(Tpblocktileentity.class, "nmCoordBlock");
		GameRegistry.registerTileEntity(PortalTE.class, "nmMiningPortal");
	}
}
