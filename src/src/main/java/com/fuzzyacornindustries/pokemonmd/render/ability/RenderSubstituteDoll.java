package com.fuzzyacornindustries.pokemonmd.render.ability;

import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelSubstituteDoll;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderSubstituteDoll extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" + "textures/abilities/substitutedoll/substitutedoll.png");
	private static final ResourceLocation resilientTexture = new ResourceLocation(ModInfo.MODID + ":" + "textures/abilities/substitutedoll/resilientsubstitutedoll.png");
	private static final ResourceLocation obsidianTexture = new ResourceLocation(ModInfo.MODID + ":" + "textures/abilities/substitutedoll/obsidiansubstitutedoll.png");

	static float castShadowSize = 0.4F;

	public RenderSubstituteDoll()
	{	
		super(new ModelSubstituteDoll(), castShadowSize);
	}

	protected ResourceLocation getEntityTexture(EntitySubstituteDoll par1Entity)
	{
		if(par1Entity.getDollType() == 0)
		{
			return mainTexture;
		}
		else if(par1Entity.getDollType() == 1)
		{
			return resilientTexture;
		}
		else
		{
			return obsidianTexture;
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntitySubstituteDoll)par1Entity);
	}
}