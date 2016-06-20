package com.leo.eg.mod.entity;

import com.leo.eg.mod.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMob2 extends RenderLiving {
	private static final ResourceLocation nmsvc = new ResourceLocation(
			Reference.MOD_ID + ":textures/entity/smallvillagercow.png");

	public RenderMob2(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);

	}

	protected ResourceLocation getEntityTexture(NMSmallvillagerCow entity) {
		return nmsvc;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((NMSmallvillagerCow) entity);
	}

}
