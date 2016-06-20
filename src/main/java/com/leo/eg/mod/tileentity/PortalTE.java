package com.leo.eg.mod.tileentity;

import com.leo.eg.mod.dimension.DimensionRegistry;
import com.leo.eg.mod.dimension.MiningDimension;
import com.leo.eg.mod.dimension.MiningTeleporter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class PortalTE extends TileEntity implements IInventory {
	private ItemStack[] inventory;
    private String customName;
	private static final String KEY_STRUCTURE_TYPE = "StructureTypeOrdinal";
	private static final String S_OFFSET_X = "TentOffsetX";
	private static final String S_OFFSET_Z = "TentOffsetZ";
	private static final String S_PLAYER_X = "PlayerPrevX";
	private static final String S_PLAYER_Y = "PlayerPrevY";
	private static final String S_PLAYER_Z = "PlayerPrevZ";
	private static final String S_PREV_DIM = "PreviousPlayerDimension";

	private int offsetX;
	private int offsetZ;	
	private double prevX, prevY, prevZ;
	private int prevDimID;
	private ItemStack tentStack;
	

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		int ordinal = nbt.getInteger(KEY_STRUCTURE_TYPE);;
		
		this.offsetX = nbt.getInteger(S_OFFSET_X);
		this.offsetZ = nbt.getInteger(S_OFFSET_Z);
		this.prevX = nbt.getDouble(S_PLAYER_X);
		this.prevY = nbt.getDouble(S_PLAYER_Y);
		this.prevZ = nbt.getDouble(S_PLAYER_Z);
		this.prevDimID = nbt.getInteger(S_PREV_DIM);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setInteger(S_OFFSET_X, this.offsetX);
		nbt.setInteger(S_OFFSET_Z, this.offsetZ);
		nbt.setDouble(S_PLAYER_X, prevX);
		nbt.setDouble(S_PLAYER_Y, prevY);
		nbt.setDouble(S_PLAYER_Z, prevZ);
		nbt.setInteger(S_PREV_DIM, this.getPrevDimension());
	}

	

	public void setOffsetX(int toSet)
	{
		this.offsetX = toSet;
	}

	public int getOffsetX()
	{
		return this.offsetX;
	}

	public void setOffsetZ(int toSet)
	{
		this.offsetZ = toSet;
	}

	public int getOffsetZ()
	{
		return this.offsetZ;
	}

	public void setOverworldXYZ(double posX, double posY, double posZ)
	{
		this.prevX = posX;
		this.prevY = posY;
		this.prevZ = posZ;
	}
	
	public void setPrevDimension(int dimID)
	{
		this.prevDimID = dimID;
	}
	
	public int getPrevDimension()
	{
		return this.prevDimID;
	}

	public BlockPos getOverworldXYZ()
	{
		return new BlockPos(this.prevX, this.prevY, this.prevZ);
	}


	public boolean onPlayerActivate(EntityPlayer player)
	{
		if (!player.isRiding())
        {
            player.setPortal(pos);
			MinecraftServer mcServer = MinecraftServer.getServer();
			EntityPlayerMP playerMP = (EntityPlayerMP)player;
			// where the corresponding structure is in Tent dimension
			
			

			if(playerMP.timeUntilPortal > 0)
			{
				playerMP.timeUntilPortal = 10;
			}
			else if(!MiningDimension.isMiningDimension)
			{
				// remember the player's coordinates from the overworld
				this.setOverworldXYZ(playerMP.posX, playerMP.posY, playerMP.posZ);

				MiningTeleporter tel = new MiningTeleporter(
						 mcServer.worldServerForDimension(DimensionRegistry.dimensionId));
				// debug:
				//System.out.print("Created teleporter to Tent Dimension: " + tel.toString());
				// teleport the player to Tent Dimension
				playerMP.timeUntilPortal = 10;	
				mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, DimensionRegistry.dimensionId, tel);
			}
			else if(MiningDimension.isMiningDimension)
			{
				MiningTeleporter tel = new MiningTeleporter(
						 mcServer.worldServerForDimension(this.getPrevDimension()));
				// debug:
				//System.out.print("Created teleporter to Overworld: " + tel.toString());
				// teleport player to overworld
				playerMP.timeUntilPortal = 10;
				mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, this.getPrevDimension(), tel);
				
			}
			return true;
		}

		return false;
	}

	public String getCustomName(){
		return this.customName;
		
	}
	
	public void setCustomName(String customName) {
        this.customName = customName;
    }
	
	@Override
	public String getName() {
		 return this.hasCustomName() ? this.customName : "container.tpblocktileentity";
	}

	@Override
	public boolean hasCustomName() {
		
		return this.customName != null && !this.customName.equals("");
	}

	@Override
	public IChatComponent getDisplayName() {
		
		 return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}
	

	@Override
	public int getSizeInventory() {
		
		return 64;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		 if (index < 0 || index >= this.getSizeInventory())
		        return null;
		    return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		 if (this.getStackInSlot(index) != null) {
		        ItemStack itemstack;

		        if (this.getStackInSlot(index).stackSize <= count) {
		            itemstack = this.getStackInSlot(index);
		            this.setInventorySlotContents(index, null);
		            this.markDirty();
		            return itemstack;
		        } else {
		            itemstack = this.getStackInSlot(index).splitStack(count);

		            if (this.getStackInSlot(index).stackSize <= 0) {
		                this.setInventorySlotContents(index, null);
		            } else {
		                //Just to show that changes happened
		                this.setInventorySlotContents(index, this.getStackInSlot(index));
		            }

		            this.markDirty();
		            return itemstack;
		        }
		    } else {
		        return null;
		    }
	}

	
	public ItemStack getStackInSlotOnClosing(int index) {
	    ItemStack stack = this.getStackInSlot(index);
	    this.setInventorySlotContents(index, null);
	    return stack;
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index < 0 || index >= this.getSizeInventory())
	        return;

	    if (stack != null && stack.stackSize > this.getInventoryStackLimit())
	        stack.stackSize = this.getInventoryStackLimit();
	        
	    if (stack != null && stack.stackSize == 0)
	        stack = null;

	    this.inventory[index] = stack;
	    this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 16;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
	    return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
	    return true;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		 for (int i = 0; i < this.getSizeInventory(); i++)
		        this.setInventorySlotContents(i, null);
		
	}
}
