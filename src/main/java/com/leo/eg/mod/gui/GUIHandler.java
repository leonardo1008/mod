package com.leo.eg.mod.gui;

import com.leo.eg.mod.tileentity.Tpblocktileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler{
	 public static final int MOD_TILE_ENTITY_GUI = 0;
	 
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == MOD_TILE_ENTITY_GUI)
            return new Tpblocktileentity();
		return null;
		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == MOD_TILE_ENTITY_GUI)
            return new GuiModTileEntity(null, null);

        return null;
    }

}
