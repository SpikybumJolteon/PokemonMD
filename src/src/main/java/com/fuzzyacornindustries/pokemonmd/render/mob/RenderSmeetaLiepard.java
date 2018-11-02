package com.fuzzyacornindustries.pokemonmd.render.mob;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntitySmeetaLiepard;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelSmeetaLiepard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderSmeetaLiepard extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/smeetaliepard.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/smeetaliepardhurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/smeetaliepardhappy.png");

	private static final ResourceLocation mainGlowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/smeetaliepardglows.png");
	private static final ResourceLocation hurtGlowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/smeetaliepardhurtglows.png");
	private static final ResourceLocation happyGlowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/smeetaliepardhappyglows.png");

	static float castShadowSize = 0.3F;

	private ModelSmeetaLiepard modelGlow;

	public RenderSmeetaLiepard()
	{	
		super(new ModelSmeetaLiepard(), castShadowSize);

		this.modelGlow = new ModelSmeetaLiepard();
	}

	protected ResourceLocation getEntityTexture(EntitySmeetaLiepard par1Entity)
	{
		switch (par1Entity.getMainTextureType())
		{
		case 0:
			return mainTexture;
		case 1:
			return hurtTexture;
		}

		return happyTexture;
	}

	protected ResourceLocation getEntityGlowTexture(EntitySmeetaLiepard par1Entity)
	{
		switch (par1Entity.getMainTextureType())
		{
		case 0:
			return mainGlowTexture;
		case 1:
			return hurtGlowTexture;
		}

		return happyGlowTexture;
	}

	protected int shouldRenderPass(EntitySmeetaLiepard par1Entity, int par2, float par3)
	{
		this.bindTexture(getEntityGlowTexture(par1Entity));
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

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntitySmeetaLiepard)par1Entity);
	}
}