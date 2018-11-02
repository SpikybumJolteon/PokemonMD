package com.fuzzyacornindustries.pokemonmd.entity.mob;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IHeadMobMotionTracker extends IMobMotionTracker
{
	@SideOnly(Side.CLIENT)
	public float getHeadAngularVelocity();
}