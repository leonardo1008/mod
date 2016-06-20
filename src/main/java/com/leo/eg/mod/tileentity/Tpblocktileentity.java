package com.leo.eg.mod.tileentity;

import java.util.ArrayList;
import java.util.List;

import com.leo.eg.mod.CoordStore;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class Tpblocktileentity extends TileEntity implements IInventory{
	private ItemStack[] inventory;
    private String customName;
	private List<CoordStore> teleports = new ArrayList<CoordStore>();
	
	public Tpblocktileentity(){
		this.inventory = new ItemStack[this.getSizeInventory()];
	}

	public void addEntry(String name, ItemStack coordStorer) {
		NBTTagCompound nbt = (NBTTagCompound) coordStorer.getTagCompound().getTag("coords");
		int dim = nbt.getInteger("dim");
		int posX = nbt.getInteger("posX");
		int posY = nbt.getInteger("posY");
		int posZ = nbt.getInteger("posZ");
		teleports.add(new CoordStore(name, dim, posX, posY, posZ));
	}

	public CoordStore getEntry(int i) {
		if (i < teleports.size()) {
			return teleports.get(i);
		}
		return null;
	}

	public void deleteEntry(int i) {
		if (i < teleports.size()) {
			teleports.remove(i);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {

		 super.readFromNBT(compound);

		    NBTTagList list = compound.getTagList("Items", 10);
		    for (int i = 0; i < list.tagCount(); ++i) {
		        NBTTagCompound stackTag = list.getCompoundTagAt(i);
		        int slot = stackTag.getByte("Slot") & 255;
		        this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		    }

		    if (compound.hasKey("CustomName", 8)) {
		        this.setCustomName(compound.getString("CustomName"));
		    }
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {

		super.writeToNBT(compound);

	    NBTTagList list = new NBTTagList();
	    for (int i = 0; i < this.getSizeInventory(); ++i) {
	        if (this.getStackInSlot(i) != null) {
	            NBTTagCompound stackTag = new NBTTagCompound();
	            stackTag.setByte("Slot", (byte) i);
	            this.getStackInSlot(i).writeToNBT(stackTag);
	            list.appendTag(stackTag);
	        }
	    }
	    compound.setTag("Items", list);

	    if (this.hasCustomName()) {
	    	compound.setString("CustomName", this.getCustomName());
	    }
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
