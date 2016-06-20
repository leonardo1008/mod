package com.leo.eg.mod;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

public class CoordStore {
	private String name;
	private int dim;
	private int x, y, z;
	
	public CoordStore(String name, int dim, int x, int y, int z) {
		this.name = name;
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String getName() {
		return name;
	}

	public int getDim() {
		return dim;
	}
	
	public BlockPos getPos(){
		return new BlockPos(x, y ,z);
	}
	public void writeEntryToNBT(NBTTagCompound nbt){
		nbt.setString("name", name);
		nbt.setInteger("dimension", dim);
		nbt.setInteger("posX", x);
		nbt.setInteger("posY", y);
		nbt.setInteger("posZ", z);
	}
	public static CoordStore readEntryFromNBT(NBTTagCompound nbt){
		
		return new CoordStore(nbt.getString("name"), nbt.getInteger("dimension"), nbt.getInteger("posX"), nbt.getInteger("posY"), nbt.getInteger("posZ"));
	}
}
