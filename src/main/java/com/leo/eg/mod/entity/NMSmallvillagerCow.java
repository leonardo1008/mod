package com.leo.eg.mod.entity;

import java.util.UUID;

import com.leo.eg.mod.init.NewModItems;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;

public class NMSmallvillagerCow extends EntityMob {
	private static final UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
	private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID,
			"Baby speed boost", 0.5D, 1);

	private float zombieWidth = -1.0F;
	/** The height of the the entity. */
	private float zombieHeight;

	public NMSmallvillagerCow(World worldIn) {
		super(worldIn);
		this.setSize(0.4F, 0.6F);
		((PathNavigateGround) this.getNavigator()).setAvoidsWater(false);
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		((PathNavigateGround) this.getNavigator()).setCanSwim(true);
		((PathNavigateGround) this.getNavigator()).setEnterDoors(true);
		this.tasks.addTask(0, new EntityAIWander(this, 0.3D));
		
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(7, new EntityAIAvoidEntity(this, NMTireLessMob.class, 5.0F, 1.0D, 2.0D));
		this.applyEntityAI();

	}

	protected void applyEntityAI() {
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));

		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] { EntityPigZombie.class }));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);

	}

	public boolean isAIEnabled() {
		return true;
	}

	public EntityAgeable createChild(EntityAgeable ageable) {

		return new NMTireLessMob(worldObj);
	}

	protected int getExperiencePoints(EntityPlayer player) {
		if (this.isChild()) {
			this.experienceValue = (int) ((float) this.experienceValue * 2.5F);
		} else if (this.onGround) {
			this.experienceValue = (int) ((float) this.experienceValue * 10.F);
		}

		return super.getExperiencePoints(player);
	}

	

	protected Item getDropItem() {
		return NewModItems.good_food_item;
	}

}
