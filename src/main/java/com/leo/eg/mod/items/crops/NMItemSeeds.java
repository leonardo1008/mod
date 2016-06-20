package com.leo.eg.mod.items.crops;

import com.leo.eg.mod.NewMod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class NMItemSeeds extends ItemSeeds {


	public NMItemSeeds(Block crops, Block soil, String name) {
		super(crops, soil);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
		
	
}}
