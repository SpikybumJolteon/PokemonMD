package com.fuzzyacornindustries.pokemonmd.render.turret;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.turret.ModelPrototurret;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderPrototurret extends RenderLiving
{
	private static final ResourceLocation glowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/turrets/prototurretglows.png");
	private static final ResourceLocation stoppedTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/turrets/prototurretglowsstopped.png");
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/turrets/prototurret.png");

	static float castShadowSize = 0.2F;

	public RenderPrototurret()
	{
		super(new ModelPrototurret(), castShadowSize);
		this.setRenderPassModel(new ModelPrototurret());
	}

    protected float getDeathMaxRotation(EntityPrototurret par1Entity)
    {
        return 0F;
    }

    protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return this.getDeathMaxRotation((EntityPrototurret)par1EntityLivingBase);
    }

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityPrototurret par1Entity, int par2, float par3)
	{
		this.bindTexture(par1Entity.getPrototurretState() == 1 ? stoppedTexture : glowTexture);
		float f1 = 1.0F;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDisable(GL11.GL_LIGHTING);

		if (par1Entity.isInvisible())
		{
			GL11.glDepthMask(false);
		}
		else
		{
			GL11.glDepthMask(true);
		}

		char c0 = 61680;
		int j = c0 % 65536;
		int k = c0 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(0.5F, 0.5F, 0.5F, f1);
		return 1;
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityPrototurret par1Entity)
	{
		return mainTexture;
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	{
		return this.shouldRenderPass((EntityPrototurret)par1EntityLivingBase, par2, par3);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityPrototurret)par1Entity);
	}
}