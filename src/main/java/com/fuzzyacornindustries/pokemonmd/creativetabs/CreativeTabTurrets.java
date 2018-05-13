package com.fuzzyacornindustries.pokemonmd.creativetabs;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTurrets extends CreativeTabs 
{
	public CreativeTabTurrets(String par2Str)
	{
		super(par2Str);
	}

	@Override
	public Item getTabIconItem()
	{
		return PokemonMDItem.firagaCapacitor;
	}
}