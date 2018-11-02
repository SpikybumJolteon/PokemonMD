package com.fuzzyacornindustries.pokemonmd.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBandersnatchFennekin;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelBandersnatchFennekin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBandersnatchFennekin extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/bandersnatchfennekin.png");
	private static final ResourceLocation temperateTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/bandersnatchfennekintemperate.png");

	static float castShadowSize = 0.2F;

	public RenderBandersnatchFennekin()
	{	
		super(new ModelBandersnatchFennekin(), castShadowSize);
	}

	protected ResourceLocation getEntityTexture(EntityBandersnatchFennekin par1Entity)
	{
		return par1Entity.getBandersnatchFennekinType() == 1 ? temperateTexture : mainTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityBandersnatchFennekin)par1Entity);
	}
}