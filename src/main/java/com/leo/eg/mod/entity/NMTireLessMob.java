package com.leo.eg.mod.entity;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;

public class NMTireLessMob extends EntityAnimal {

	public NMTireLessMob(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 1.0F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(true);
		this.tasks.addTask(0, new EntityAIWander(this, 0.9D));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.5D));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(3, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(4, new EntityAIBreakDoor(this));
		this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityZombie.class, 12.0F, 2.0D, 2.5D));
		this.tasks.addTask(6, new EntityAISwimming(this));
		this.tasks.addTask(7, new EntityAITempt(this, 1.3D, Items.cake, false));
		this.tasks.addTask(8, new EntityAITempt(this, 1.3D, Items.sugar, false));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));

		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, false));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySpider.class, false));

	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.9D);

	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {

		return new NMTireLessMob(worldObj);
	}

}
