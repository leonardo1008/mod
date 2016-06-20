package com.leo.eg.mod.entity;

import com.leo.eg.mod.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMob extends RenderLiving {
	private static final ResourceLocation nmtl = new ResourceLocation(
			Reference.MOD_ID + ":textures/entity/NMTireLessMob.png");

	public RenderMob(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);

	}

	protected ResourceLocation getEntityTexture(NMTireLessMob entity) {
		return nmtl;
	}

	

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((NMTireLessMob) entity);
	}

}
