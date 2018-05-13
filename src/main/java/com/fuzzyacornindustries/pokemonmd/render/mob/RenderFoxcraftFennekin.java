package com.fuzzyacornindustries.pokemonmd.render.mob;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxcraftFennekin;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelFoxcraftFennekin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderFoxcraftFennekin extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/foxcraftfennekin.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/foxcraftfennekinhurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/foxcraftfennekinhappy.png");

	static float castShadowSize = 0.2F;

	public RenderFoxcraftFennekin()
	{	
		super(new ModelFoxcraftFennekin(), castShadowSize);
	}

	protected ResourceLocation getEntityTexture(EntityFoxcraftFennekin par1Entity)
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

	protected ResourceLocation getMobTexture(EntityFoxcraftFennekin par1Entity)
	{
		return this.getEntityTexture((EntityFoxcraftFennekin)par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityFoxcraftFennekin)par1Entity);
	}
}