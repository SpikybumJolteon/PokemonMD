package com.fuzzyacornindustries.pokemonmd.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;

public class CreativeTabMobs extends CreativeTabs 
{
	public CreativeTabMobs(String par2Str)
	{
		super(par2Str);
	}

	@Override
	public Item getTabIconItem()
	{
		return PokemonMDItem.blessingOfArceus;
	}
}