package com.fuzzyacornindustries.pokemonmd.creativetabs;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabItems extends CreativeTabs 
{
	public CreativeTabItems(String lable)
	{
		super(lable);
	}

	@Override
	public Item getTabIconItem()
	{
		return PokemonMDItem.xelNagaShard;
	}
}