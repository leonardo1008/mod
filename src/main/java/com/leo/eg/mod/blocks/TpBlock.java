package com.leo.eg.mod.blocks;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.Reference;
import com.leo.eg.mod.gui.GUIHandler;
import com.leo.eg.mod.items.ItemCoordnateCache;
import com.leo.eg.mod.tileentity.Tpblocktileentity;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.main.Main;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TpBlock extends Block implements ITileEntityProvider{

	public TpBlock(String name, Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
		this.setHardness(10.0F);
		this.setResistance(5000.0F);
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
		if(stack != null){
			if(stack.getItem() instanceof ItemCoordnateCache){
				if(stack.getItem().hasEffect(stack)){
					Tpblocktileentity tect = (Tpblocktileentity) worldIn.getTileEntity(pos);
					tect.addEntry("none", stack);
					
					playerIn.addChatMessage(new ChatComponentText("Added Coordinate"));
				}
			}
		}
		
		    return true;
	
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {

		return new Tpblocktileentity();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
	    Tpblocktileentity te = (Tpblocktileentity) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, blockstate);
	}


	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    if (stack.hasDisplayName()) {
	        ((Tpblocktileentity) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
	    }
	}
	
}
