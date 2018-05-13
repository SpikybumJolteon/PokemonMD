package com.fuzzyacornindustries.pokemonmd.render.mob;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityNecromancerDelphox;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelNecromancerDelphox;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderNecromancerDelphox extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/necromancerdelphox.png");

	static float castShadowSize = 0.5F;

	public RenderNecromancerDelphox()
	{	
		super(new ModelNecromancerDelphox(), castShadowSize);
	}

	protected ResourceLocation getMobTexture(EntityNecromancerDelphox par1Entity)
	{
		return mainTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityNecromancerDelphox)par1Entity);
	}
}