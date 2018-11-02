package com.fuzzyacornindustries.pokemonmd.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityArmoredLuxray;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelArmoredLuxray;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArmoredLuxray extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/armoredluxray.png");

	static float castShadowSize = 0.5F;

	public RenderArmoredLuxray()
	{	
		super(new ModelArmoredLuxray(), castShadowSize);
	}

	protected ResourceLocation getMobTexture(EntityArmoredLuxray par1Entity)
	{
		return mainTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityArmoredLuxray)par1Entity);
	}
}