package com.fuzzyacornindustries.pokemonmd.render.mob;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayShinx;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelClayShinx;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderClayShinx extends RenderLiving
{
	private static final ResourceLocation glowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/clayshinxglows.png");
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/clayshinx.png");

	static float castShadowSize = 0.2F;

	public RenderClayShinx()
	{
		super(new ModelClayShinx(), castShadowSize);
		this.setRenderPassModel(new ModelClayShinx());
	}
	
	protected int shouldRenderPass(EntityClayShinx par1Entity, int par2, float par3)
	{
		this.bindTexture(glowTexture);
		float f1 = 1.0F;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glDepthMask(true);

		char c0 = 61680;
		int j = c0 % 65536;
		int k = c0 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(0.4F, 0.4F, 0.4F, f1);
		return 1;
	}

	protected ResourceLocation getEntityTexture(EntityClayShinx par1Entity)
	{
		return mainTexture;
	}

	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	{
		return this.shouldRenderPass((EntityClayShinx)par1EntityLivingBase, par2, par3);
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityClayShinx)par1Entity);
	}
}