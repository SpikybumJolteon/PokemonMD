package com.fuzzyacornindustries.pokemonmd.render.mob;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityIonianNinetales;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelAhriNinetales;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelAhriNinetalesOrb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderIonianNinetales extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/ionianninetales.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/ionianninetaleshurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/ionianninetaleshappy.png");
	private static final ResourceLocation orbTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/ionianninetalesorb.png");

	static float castShadowSize = 0.4F;

	private ModelAhriNinetalesOrb modelOrb;

	public RenderIonianNinetales()
	{	
		super(new ModelAhriNinetales(), castShadowSize);

		this.modelOrb = new ModelAhriNinetalesOrb();
	}

	protected ResourceLocation getEntityTexture(EntityIonianNinetales par1Entity)
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

		this.modelOrb.setLivingAnimations(entity, distanceMoved, horzVelocity, partialTick);
		this.renderOrb(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);

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
				this.modelOrb.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);

			}

			if ((colorMultiplier >> 24 & 255) > 0)
			{
				redColor = (float)(colorMultiplier >> 16 & 255) / 255.0F;
				greenColor = (float)(colorMultiplier >> 8 & 255) / 255.0F;
				float blueColor = (float)(colorMultiplier & 255) / 255.0F;
				alphaFloat = (float)(colorMultiplier >> 24 & 255) / 255.0F;
				GL11.glColor4f(redColor, greenColor, blueColor, alphaFloat);
				this.modelOrb.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHead - yawOffset, pitchRotation, modelSize);
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
		System.out.println( "Test Animation Tick Code Jade Glaive doRender method" );
		System.out.println( Float.toString( ((EntityOkamiSylveon)entityLivingBasePar).getAnimationTick() ) );
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

	protected void renderOrb(EntityLivingBase entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yaw, float pitchRotation, float modelSize)
	{
		this.bindTexture(this.orbTexture);
		/*
		GL11.glPushMatrix();
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
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
		 */

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);
		this.bindTexture(this.orbTexture);
		Tessellator.instance.setBrightness(0xf000f0);
		this.modelOrb.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		/*
		if (!entity.isInvisible())
		{
			this.modelOrb.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize);
		}
		else if (!entity.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer))
		{

			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
			this.modelOrb.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
			GL11.glPopMatrix();
			GL11.glDepthMask(true);

		}
		else
		{
			this.modelOrb.setRotationAngles(distanceMoved, horzVelocity, yawRotationDifference, yaw, pitchRotation, modelSize, entity);
		}*/
	}

	protected ResourceLocation getMobTexture(EntityIonianNinetales par1Entity)
	{
		return getEntityTexture(par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityIonianNinetales)par1Entity);
	}
}