package com.fuzzyacornindustries.pokemonmd.render.mob;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFirecrackerLitten;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelFirecrackerLitten;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderFirecrackerLitten extends RenderLiving
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/firecrackerlitten.png");
	private static final ResourceLocation hurtTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/firecrackerlittenhurt.png");
	private static final ResourceLocation happyTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/mobs/tamable/firecrackerlittenhappy.png");

	static float castShadowSize = 0.3F;

	public RenderFirecrackerLitten()
	{	
		super(new ModelFirecrackerLitten(), castShadowSize);
	}

	protected ResourceLocation getEntityTexture(EntityFirecrackerLitten par1Entity)
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

	protected ResourceLocation getMobTexture(EntityFirecrackerLitten par1Entity)
	{
		return this.getEntityTexture((EntityFirecrackerLitten)par1Entity);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getMobTexture((EntityFirecrackerLitten)par1Entity);
	}
}