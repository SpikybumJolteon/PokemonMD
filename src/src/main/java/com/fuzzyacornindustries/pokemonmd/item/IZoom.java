package com.fuzzyacornindustries.pokemonmd.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IZoom 
{
	// The number of ticks required before maximum zoom is reached,
	// as a float value (vanilla bow is 20.0F)
	@SideOnly(Side.CLIENT)
	float getMaxZoomTime();

	// The factor by which the field of view will be modified;
	// vanilla bow uses 0.15F, with higher values giving higher magnification
	@SideOnly(Side.CLIENT)
	float getZoomFactor();
}