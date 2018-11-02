package com.fuzzyacornindustries.pokemonmd.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDoomstoneGlaceon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDoomstoneLeafeon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelDoomstoneLeafeon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDoomstoneLeafeon extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/doomstoneleafeon.png");

	static float castShadowSize = 0.5F;

	public RenderDoomstoneLeafeon()
	{	
		super(new ModelDoomstoneLeafeon(), castShadowSize);
	}

    protected float setMobDeathMaxRotation(EntityDoomstoneLeafeon par1Entity)
    {
        return 0F;
    }
    
    protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return this.setMobDeathMaxRotation((EntityDoomstoneLeafeon)par1EntityLivingBase);
    }

	protected ResourceLocation getMobTexture(EntityDoomstoneLeafeon par1Entity)
	{
		return mainTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityDoomstoneLeafeon)par1Entity);
	}
}