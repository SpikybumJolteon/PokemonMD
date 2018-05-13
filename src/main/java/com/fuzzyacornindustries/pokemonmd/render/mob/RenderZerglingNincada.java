package com.fuzzyacornindustries.pokemonmd.render.mob;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZerglingNincada;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelZerglingNincada;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderZerglingNincada extends RenderLiving
{
	private static final ResourceLocation zerglingTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/zerglingnincada.png");
	private static final ResourceLocation raptorZerglingTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/raptorzerglingnincada.png");
	private static final ResourceLocation cracklingTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/cracklingnincada.png");
	private static final ResourceLocation cracklingGlowsTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/cracklingnincadaglows.png");

	static float castShadowSize = 0.2F;

	public RenderZerglingNincada()
	{	
		super(new ModelZerglingNincada(), castShadowSize);
		this.setRenderPassModel(new ModelZerglingNincada());
	}

	protected int shouldRenderPass(EntityZerglingNincada par1Entity, int par2, float par3)
	{
		if(par1Entity.getZerglingNincadaType() == EntityZerglingNincada.CRACKLING_ID)
		{
			this.bindTexture(cracklingGlowsTexture);
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
		else
		{
			return 0;
		}
	}

	protected ResourceLocation getEntityTexture(EntityZerglingNincada par1Entity)
	{
		switch(par1Entity.getZerglingNincadaType())
		{
		case 0:
			return zerglingTexture;
		case 1:
			return raptorZerglingTexture;
		case 2:
			return cracklingTexture;
		}

		return zerglingTexture;
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	{
		return this.shouldRenderPass((EntityZerglingNincada)par1EntityLivingBase, par2, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityZerglingNincada)par1Entity);
	}
}