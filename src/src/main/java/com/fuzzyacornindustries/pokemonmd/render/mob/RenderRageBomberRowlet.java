package com.fuzzyacornindustries.pokemonmd.render.mob;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityRageBomberRowlet;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelRageBomberRowlet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderRageBomberRowlet extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/ragebomberrowlet.png");

	static float castShadowSize = 0.2F;

	public RenderRageBomberRowlet()
	{	
		super(new ModelRageBomberRowlet(), castShadowSize);
	}

	protected ResourceLocation getMobTexture(EntityRageBomberRowlet par1Entity)
	{
		return mainTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityRageBomberRowlet)par1Entity);
	}
}