package com.leo.eg.mod.blocks;

import java.util.List;

import com.leo.eg.mod.NewMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class CobbleKiller extends Block implements IMetaBlockName{
	public enum EnumType implements IStringSerializable {
		WHITE(0, "white"),DARK(1,"dark");

		private int ID;
		private String name;

		private EnumType(int ID, String name) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public String getName() {
			
			return name;
		}
		
		public int getID() {
	        return ID;
	    }
		
		@Override
		public String toString() {
		    return getName();
		}

	}

	public static final PropertyEnum TYPE = PropertyEnum.create("type", CobbleKiller.EnumType.class);

	public CobbleKiller(String name, Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setCreativeTab(NewMod.tabNewMod);
		this.setHardness(5.0F);
		this.setHarvestLevel("nm:toolnewmodpick", 3);
		this.setResistance(10.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.WHITE));
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
	    list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	    list.add(new ItemStack(itemIn, 1, 1)); //Meta 1
	}
	
	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(TYPE, meta == 0 ? EnumType.WHITE : EnumType.DARK);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    EnumType type = (EnumType) state.getValue(TYPE);
	    return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		
		 return stack.getItemDamage() == 0 ? "white" : "dark";
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {

		return true;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
	

}
