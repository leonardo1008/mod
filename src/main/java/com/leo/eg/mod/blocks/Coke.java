package com.leo.eg.mod.blocks;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.Reference;
import com.leo.eg.mod.gui.GUIHandler;
import com.leo.eg.mod.items.ItemCoordnateCache;
import com.leo.eg.mod.items.Straw;
import com.leo.eg.mod.tileentity.Coketileenity;
import com.leo.eg.mod.tileentity.Tpblocktileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Coke extends Block{

	public Coke(String name, Material materialIn) {
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
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		
		return false;
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		
		return true;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
			ItemStack stack = playerIn.getCurrentEquippedItem();
			if(!worldIn.isRemote){
				if(stack.getItem() != null){
					if(stack.getItem() instanceof Straw){
						int amplifier = 3;
						playerIn.addPotionEffect(new PotionEffect(Potion.saturation.id, 1, amplifier, true, true));
					}
				}
			}
		
		
				return true;
		
}
}

