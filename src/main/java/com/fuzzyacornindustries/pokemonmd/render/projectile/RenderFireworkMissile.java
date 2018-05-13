package com.fuzzyacornindustries.pokemonmd.render.projectile;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityFireworkMissile;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderFireworkMissile extends Render
{
	private static final ResourceLocation fireworkMissileTexture = new ResourceLocation(ModInfo.MODID + ":" + "textures/projectiles/fireworkmissile.png");

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityFireworkMissile p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		this.bindEntityTexture(p_76986_1_);

		float textureDimensionX = 15F;
		float textureDimensionY = 10F;

		float leftX;
		float rightX;
		float topY;
		float botY;

		float xStart;
		float xEnd;
		float yStart;
		float yEnd;

		float xPar;
		float yPar;
		float zPar;

		GL11.glPushMatrix();
		GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
		GL11.glRotatef(p_76986_1_.prevRotationYaw + (p_76986_1_.rotationYaw - p_76986_1_.prevRotationYaw) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(p_76986_1_.prevRotationPitch + (p_76986_1_.rotationPitch - p_76986_1_.prevRotationPitch) * p_76986_9_, 0.0F, 0.0F, 1.0F);
		Tessellator tessellator = Tessellator.instance;

		/*
        float textureSidePortionXStart = 0F;
        float textureSidePortionXEnd = 1.0F;
        float textureSidePortionYStart = 0F;
        float textureSidePortionYEnd = 0.5F;
		 */
		byte b0 = 0;
		float f2 = 0.0F;
		float f3 = 1.0F;
		float f4 = (float)(0 + b0 * 10) / 32.0F;
		float f5 = (float)(5 + b0 * 10) / 32.0F;
		float f6 = 0.0F;
		float f7 = 0.15625F;
		float f8 = (float)(5 + b0 * 10) / 32.0F;
		float f9 = (float)(10 + b0 * 10) / 32.0F;
		float f10 = 0.05625F;
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		/* Missile Front Texture */
		leftX = 0F;
		rightX = 5F;
		topY = 5F;
		botY = 10F;

		xStart = leftX/textureDimensionX;
		xEnd = rightX/textureDimensionX;
		yStart = topY/textureDimensionY;
		yEnd = botY/textureDimensionY;
		
        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f10, 0.0F, 0.0F);

		xPar = 4F;
		yPar = 2F;
		zPar = 2F;

		// Two sets are needed for rendering on each side of the texture, depending on player positioning
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)xPar, (double)-yPar, (double)-zPar, (double)xStart, (double)yEnd);
        tessellator.addVertexWithUV((double)xPar, (double)-yPar, (double)zPar, (double)xEnd, (double)yEnd);
        tessellator.addVertexWithUV((double)xPar, (double)yPar, (double)zPar, (double)xEnd, (double)yStart);
        tessellator.addVertexWithUV((double)xPar, (double)yPar, (double)-zPar, (double)xStart, (double)yStart);
        tessellator.draw();
        
        GL11.glNormal3f(-f10, 0.0F, 0.0F);
        
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)xPar, (double)yPar, (double)-zPar, (double)xStart, (double)yEnd);
        tessellator.addVertexWithUV((double)xPar, (double)yPar, (double)zPar, (double)xEnd, (double)yEnd);
        tessellator.addVertexWithUV((double)xPar, (double)-yPar, (double)zPar, (double)xEnd, (double)yStart);
        tessellator.addVertexWithUV((double)xPar, (double)-yPar, (double)-zPar, (double)xStart, (double)yStart);
        tessellator.draw();

		for (int i = 0; i < 4; ++i)
		{
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			tessellator.startDrawingQuads();

			/* Missile Length Texture */
			leftX = 0F;
			rightX = 15F;
			topY = 0F;
			botY = 5F;

			xStart = leftX/textureDimensionX;
			xEnd = rightX/textureDimensionX;
			yStart = topY/textureDimensionY;
			yEnd = botY/textureDimensionY;

			xPar = 8F;
			yPar = 2F;
			zPar = 0F;

			tessellator.addVertexWithUV((double)(-xPar), (double)(-yPar), (double)zPar, (double)xStart, (double)yEnd);
			tessellator.addVertexWithUV((double)(xPar), (double)(-yPar), (double)zPar, (double)xEnd, (double)yEnd);
			tessellator.addVertexWithUV((double)(xPar), (double)(yPar), (double)zPar, (double)xEnd, (double)yStart);
			tessellator.addVertexWithUV((double)(-xPar), (double)(yPar), (double)zPar, (double)xStart, (double)yStart);
      
			tessellator.draw();
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(EntityFireworkMissile p_110775_1_)
	{
		return fireworkMissileTexture;
	}

	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return this.getEntityTexture((EntityFireworkMissile)p_110775_1_);
	}

	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		this.doRender((EntityFireworkMissile)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}
}