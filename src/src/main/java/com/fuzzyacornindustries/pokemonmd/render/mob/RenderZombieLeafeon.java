package com.fuzzyacornindustries.pokemonmd.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZombieLeafeon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelZombieLeafeon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderZombieLeafeon extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/zombieleafeon.png");

	static float castShadowSize = 0.3F;

	public RenderZombieLeafeon()
	{	
		super(new ModelZombieLeafeon(), castShadowSize);
	}

	protected ResourceLocation getMobTexture(EntityZombieLeafeon par1Entity)
	{
		return mainTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityZombieLeafeon)par1Entity);
	}
}