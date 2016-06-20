package com.leo.eg.mod.gui;

import com.leo.eg.mod.tileentity.Tpblocktileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class GuiModTileEntity extends Container{
	 private Tpblocktileentity te;
	 public GuiModTileEntity(IInventory playerInv, Tpblocktileentity te) {
	        this.te = te;
	    }

	    @Override
	    public boolean canInteractWith(EntityPlayer playerIn) {
	        return false;
	    }

}
