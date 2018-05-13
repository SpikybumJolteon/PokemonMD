package com.fuzzyacornindustries.pokemonmd.entity.mob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IMobMotionTracker 
{
	@SideOnly(Side.CLIENT)
	public float getAngularVelocity();

	@SideOnly(Side.CLIENT)
	public float getHeightVelocity();
}