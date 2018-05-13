package com.fuzzyacornindustries.pokemonmd.render.ability;

import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityNormalFoxfire;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.ability.ModelFoxfire;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNormalFoxfire extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/abilities/normalfoxfire/normalfoxfire0.png");

	static float castShadowSize = 0.0F;

	public RenderNormalFoxfire()
	{
		super(new ModelFoxfire(), castShadowSize);
		this.setRenderPassModel(new ModelFoxfire());
	}

    protected float setMobDeathMaxRotation(EntityNormalFoxfire par1Entity)
    {
        return 0F;
    }
    
    protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return this.setMobDeathMaxRotation((EntityNormalFoxfire)par1EntityLivingBase);
    }

	protected ResourceLocation getEntityTexture(EntityNormalFoxfire par1Entity)
	{
		int textureNumber = par1Entity.getCurrentTexture();

		return new ResourceLocation(ModInfo.MODID + ":" +"textures/abilities/normalfoxfire/normalfoxfire" + textureNumber + ".png");
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityNormalFoxfire)par1Entity);
	}
}