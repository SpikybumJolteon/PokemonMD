package com.fuzzyacornindustries.pokemonmd.render.mob;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityOkamiUmbreon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelOkamiUmbreon;
import com.fuzzyacornindustries.pokemonmd.model.mob.tools.ModelOkamiMoonGlaive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderOkamiUmbreon extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiumbreon.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiumbreonhurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiumbreonhappy.png");

	private static final ResourceLocation mainGlowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiumbreonglows.png");
	private static final ResourceLocation hurtGlowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiumbreonhurtglows.png");
	private static final ResourceLocation happyGlowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiumbreonhappyglows.png");

	private static final ResourceLocation moonGlaiveTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiweapon/moonglaive.png");
	private static final ResourceLocation moonGlaiveGlowTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/okamiweapon/moonglaiveglows.png");

	static float castShadowSize = 0.4F;

	private ModelOkamiMoonGlaive modelMoonGlaive;
	private ModelOkamiMoonGlaive modelMoonGlaiveGlow;
	private ModelOkamiUmbreon modelGlow;

	public RenderOkamiUmbreon()
	{	
		super(new ModelOkamiUmbreon(), castShadowSize);

		this.modelMoonGlaive = new ModelOkamiMoonGlaive();
		this.modelMoonGlaiveGlow = new ModelOkamiMoonGlaive();
		this.modelGlow = new ModelOkamiUmbreon();
	}

	protected ResourceLocation getEntityTexture(EntityOkamiUmbreon par1Entity)
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

	protected ResourceLocation getEntityGlowTexture(EntityOkamiUmbreon par1Entity)
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

	@Override
	public void doRender(EntityLiving entity, double dx, double dy, double dz, float yaw, float partialTick)
	{
		super.doRender(entity, dx, dy, dz, yaw, partialTick);

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);

		float yawOffset = this.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTick);
		float yawHead = this.interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTick);
		float yawRotationDifference;

		if (entity.isRiding() && entity.ridingEntity instanceof EntityLivingBase)
		{
			EntityLivingBase entitylivingbase1 = (EntityLivingBase)entity.ridingEntity;
			yawOffset = this.interpolateRotation(entitylivingbase1.prevRenderYawOffset, entitylivingbase1.renderYawOffset, partialTick);
			yawRotationDifference = MathHelper.wrapAngleTo180_float(yawHead - yawOffset);

			if (yawRotationDifference < -85.0F)
			{
				yawRotationDifference = -85.0F;
			}

			if (yawRotationDifference >= 85.0F)
			{
				yawRotationDifference = 85.0F;
			}

			yawOffset = yawHead - yawRotationDifference;

			if (yawRotationDifference * yawRotationDifference > 2500.0F)
			{
				yawOffset += yawRotationDifference * 0.2F;
			}
		}

		float pitchRotation = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTick;
		this.renderLivingAt(entity, dx, dy, dz);
		yawRotationDifference = this.handleRotationFloat(entity, partialTick);
		this.rotateCorpse(entity, yawRotationDifference, yawOffset, partialTick);
		float modelSize = 0.0625F;
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTick);
		GL11.glTranslatef(0.0F, -24.0F * modelSize - 0.0078125F, 0.0F);
		float horzVelocity = entity.prevLimbSwingAmount + (entity.limbSwingAmount - entity.prevLimbSwingAmount) * partialTick;
		float distanceMoved = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTick);

		if (entity.isChild())
		{
			distanceMoved *= 3.0F;
		}

		if (horzVelocity > 1.0F)
		{
			horzVelocity = 1.0F;
		}

		GL11.glEnable(GL11.GL_ALPHA_TEST);
		this.modelMoonGlaive.setLivingAnimations(entity, distanceMoved, horzVelocity, partialTick);
		this.renderMoonGlaive(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);

		this.modelMoonGlaiveGlow.setLivingAnimations(entity, distanceMoved, horzVelocity, partialTick);
		this.renderMoonGlaiveGlow(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);
		
		this.modelGlow.setLivingAnimations(entity, distanceMoved, horzVelocity, partialTick);
		this.renderMobGlow(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);

		int colorMultiplier;
		float redColor;
		float greenColor;
		float alphaFloat;

		GL11.glDepthMask(true);
		float brightnessFloat = entity.getBrightness(partialTick);
		colorMultiplier = this.getColorMultiplier(entity, brightnessFloat, partialTick);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);

		if ((colorMultiplier >> 24 & 255) > 0 || entity.hurtTime > 0 || entity.deathTime > 0)
		{
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glDepthFunc(GL11.GL_EQUAL);

			if (entity.hurtTime > 0 || entity.deathTime > 0)
			{
				GL11.glColor4f(brightnessFloat, 0.0F, 0.0F, 0.4F);
				this.modelMoonGlaive.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);

			}

			if ((colorMultiplier >> 24 & 255) > 0)
			{
				redColor = (float)(colorMultiplier >> 16 & 255) / 255.0F;
				greenColor = (float)(colorMultiplier >> 8 & 255) / 255.0F;
				float blueColor = (float)(colorMultiplier & 255) / 255.0F;
				alphaFloat = (float)(colorMultiplier >> 24 & 255) / 255.0F;
				GL11.glColor4f(redColor, greenColor, blueColor, alphaFloat);
				this.modelMoonGlaive.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);
			}

			GL11.glDepthFunc(GL11.GL_LEQUAL);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);

		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();

		/*
		System.out.println( "Test Animation Tick Code Moon Glaive doRender method" );
		System.out.println( Float.toString( ((EntityOkamiEspeon)entityLivingBasePar).getAnimationTick() ) );
		 */
	}

	private float interpolateRotation(float entityPrevRenderYawOffset, float entityRenderYawOffset, float partialTick)
	{
		float adjustmentAngle;

		for (adjustmentAngle = entityRenderYawOffset - entityPrevRenderYawOffset; adjustmentAngle < -180.0F; adjustmentAngle += 360.0F)
		{
			;
		}

		while (adjustmentAngle >= 180.0F)
		{
			adjustmentAngle -= 360.0F;
		}

		return entityPrevRenderYawOffset + partialTick * adjustmentAngle;
	}

	protected void renderMoonGlaive(EntityLivingBase entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yaw, float pitchRotation, float modelSize)
	{
		this.bindTexture(this.moonGlaiveTexture);

		if (!entity.isInvisible())
		{
			this.modelMoonGlaive.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize);
		}
		else if (!entity.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer))
		{
			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
			this.modelMoonGlaive.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
			GL11.glPopMatrix();
			GL11.glDepthMask(true);
		}
		else
		{
			this.modelMoonGlaive.setRotationAngles(distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize, entity);
		}
	}

	protected void renderMobGlow(EntityLivingBase entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yaw, float pitchRotation, float modelSize)
	{
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

		if(entity instanceof EntityOkamiUmbreon)
		{
			this.bindTexture(this.getEntityGlowTexture((EntityOkamiUmbreon)entity));
		}

		Tessellator.instance.setBrightness(0xf000f0);
		this.modelGlow.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	protected void renderMoonGlaiveGlow(EntityLivingBase entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yaw, float pitchRotation, float modelSize)
	{
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

		this.bindTexture(this.moonGlaiveGlowTexture);
		
		Tessellator.instance.setBrightness(0xf000f0);
		this.modelMoonGlaiveGlow.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityOkamiUmbreon)par1Entity);
	}
}