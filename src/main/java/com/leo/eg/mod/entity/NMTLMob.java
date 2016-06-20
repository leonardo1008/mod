
package com.leo.eg.mod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NMTLMob extends ModelBase
{
  //fields
	
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer tail;
  
  public NMTLMob()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      leg1 = new ModelRenderer(this, 0, 21);
      leg1.addBox(0F, 0F, 0F, 2, 5, 2);
      leg1.setRotationPoint(0F, 19F, 0F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 10, 21);
      leg2.addBox(0F, 0F, 0F, 2, 5, 2);
      leg2.setRotationPoint(0F, 19F, 4F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 4, 4, 7);
      body.setRotationPoint(-1F, 15F, -1F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      head = new ModelRenderer(this, 23, 0);
      head.addBox(0F, 0F, 0F, 4, 4, 6);
      head.setRotationPoint(-2F, 12F, 1F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 1.584718F, 0F);
      tail = new ModelRenderer(this, 23, 13);
      tail.addBox(0F, 0F, 0F, 1, 5, 1);
      tail.setRotationPoint(0F, 18F, 5F);
      tail.setTextureSize(64, 32);
      tail.mirror = true;
      setRotation(tail, 2.119181F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    leg1.render(f5);
    leg2.render(f5);
    body.render(f5);
    head.render(f5);
    tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
