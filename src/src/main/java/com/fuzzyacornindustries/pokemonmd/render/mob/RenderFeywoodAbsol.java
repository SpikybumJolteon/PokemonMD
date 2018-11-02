package com.fuzzyacornindustries.pokemonmd.render.mob;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFeywoodAbsol;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelFeywoodAbsol;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderFeywoodAbsol extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/feywoodabsol.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/feywoodabsolhurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/feywoodabsolhappy.png");

	static float castShadowSize = 0.3F;

	public RenderFeywoodAbsol()
	{	
		super(new ModelFeywoodAbsol(), castShadowSize);
	}

	protected ResourceLocation getEntityTexture(EntityFeywoodAbsol par1Entity)
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

	protected ResourceLocation getMobTexture(EntityFeywoodAbsol par1Entity)
	{
		return this.getEntityTexture((EntityFeywoodAbsol)par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityFeywoodAbsol)par1Entity);
	}
}