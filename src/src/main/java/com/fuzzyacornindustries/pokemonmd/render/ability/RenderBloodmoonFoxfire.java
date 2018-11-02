package com.fuzzyacornindustries.pokemonmd.render.ability;

import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityBloodmoonFoxfire;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.ability.ModelFoxfire;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBloodmoonFoxfire extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/abilities/bloodmoonfoxfire/bloodmoonfoxfire0.png");

	static float castShadowSize = 0.0F;

	public RenderBloodmoonFoxfire()
	{
		super(new ModelFoxfire(), castShadowSize);
		this.setRenderPassModel(new ModelFoxfire());
	}

    protected float setMobDeathMaxRotation(EntityBloodmoonFoxfire par1Entity)
    {
        return 0F;
    }
    
    protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return this.setMobDeathMaxRotation((EntityBloodmoonFoxfire)par1EntityLivingBase);
    }

	protected ResourceLocation getEntityTexture(EntityBloodmoonFoxfire par1Entity)
	{
		int textureNumber = par1Entity.getCurrentTexture();

		return new ResourceLocation(ModInfo.MODID + ":" +"textures/abilities/bloodmoonfoxfire/bloodmoonfoxfire" + textureNumber + ".png");
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityBloodmoonFoxfire)par1Entity);
	}
}