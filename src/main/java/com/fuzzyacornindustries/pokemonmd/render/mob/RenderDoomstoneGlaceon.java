package com.fuzzyacornindustries.pokemonmd.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDoomstoneGlaceon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelDoomstoneGlaceon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDoomstoneGlaceon extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/doomstoneglaceon.png");

	static float castShadowSize = 0.5F;

	public RenderDoomstoneGlaceon()
	{	
		super(new ModelDoomstoneGlaceon(), castShadowSize);
	}

    protected float setMobDeathMaxRotation(EntityDoomstoneGlaceon par1Entity)
    {
        return 0F;
    }
    
    protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return this.setMobDeathMaxRotation((EntityDoomstoneGlaceon)par1EntityLivingBase);
    }

	protected ResourceLocation getMobTexture(EntityDoomstoneGlaceon par1Entity)
	{
		return mainTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityDoomstoneGlaceon)par1Entity);
	}
}