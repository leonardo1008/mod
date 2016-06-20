package com.leo.eg.mod.dimension;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class MiningTeleporter extends Teleporter{

	public MiningTeleporter(WorldServer worldIn) {
		super(worldIn);
	}
		
	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) {
			BlockPos posNew = MinecraftServer.getServer().worldServerForDimension(MiningDimension.getId()).getTopSolidOrLiquidBlock(entityIn.getPosition());
			entityIn.motionX = entityIn.motionY = entityIn.motionZ = 0.0D;
			entityIn.setLocationAndAngles(posNew.getX(), posNew.getY(), posNew.getZ(), rotationYaw, entityIn.rotationPitch);
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
		return true;
	}

}