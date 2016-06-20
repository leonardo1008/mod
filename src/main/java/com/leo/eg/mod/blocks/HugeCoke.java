package com.leo.eg.mod.blocks;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.items.Straw;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class HugeCoke extends Block{
	public HugeCoke(String name, Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);

	}
	
	@Override 
	public boolean isOpaqueCube(){
		return false;
	}
	@Override 
	public boolean isFullCube(){
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
			ItemStack stack = playerIn.getCurrentEquippedItem();
			if(!worldIn.isRemote){
				if(stack.getItem() != null){
					if(stack.getItem() instanceof Straw){
						int amplifier = 4;
						int amplifi = 5;
						playerIn.addPotionEffect(new PotionEffect(Potion.saturation.id, 1, amplifier, true, true));
						playerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 4000, amplifi, true, true));
					}
				}
			}
		
		
				return true;
		
}
}

