package com.fuzzyacornindustries.pokemonmd.render.mob;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityDeathBlossomLurantis;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelDeathBlossomLurantis;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderDeathBlossomLurantis extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/deathblossomlurantis.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/deathblossomlurantishurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/deathblossomlurantishappy.png");

	static float castShadowSize = 0.3F;

	public RenderDeathBlossomLurantis()
	{	
		super(new ModelDeathBlossomLurantis(), castShadowSize);
	}

	protected ResourceLocation getEntityTexture(EntityDeathBlossomLurantis par1Entity)
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

	protected ResourceLocation getMobTexture(EntityDeathBlossomLurantis par1Entity)
	{
		return this.getEntityTexture((EntityDeathBlossomLurantis)par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityDeathBlossomLurantis)par1Entity);
	}
}