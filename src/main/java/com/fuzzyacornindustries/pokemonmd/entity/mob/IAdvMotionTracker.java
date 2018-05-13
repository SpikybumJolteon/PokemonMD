package com.fuzzyacornindustries.pokemonmd.entity.mob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IAdvMotionTracker 
{
	@SideOnly(Side.CLIENT)
	public float getSidewaysVelocity();

	@SideOnly(Side.CLIENT)
	public float getLinearVelocity();
}