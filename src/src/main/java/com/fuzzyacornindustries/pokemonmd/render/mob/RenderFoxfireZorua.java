package com.fuzzyacornindustries.pokemonmd.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxfireZorua;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelFoxfireZorua;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFoxfireZorua extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/foxfirezorua.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/foxfirezoruahurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/foxfirezoruahappy.png");

	static float castShadowSize = 0.4F;

	public RenderFoxfireZorua()
	{	
		super(new ModelFoxfireZorua(), castShadowSize);
	}

	protected ResourceLocation getEntityTexture(EntityFoxfireZorua par1Entity)
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

	protected ResourceLocation getMobTexture(EntityFoxfireZorua par1Entity)
	{
		return this.getEntityTexture((EntityFoxfireZorua)par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityFoxfireZorua)par1Entity);
	}
}