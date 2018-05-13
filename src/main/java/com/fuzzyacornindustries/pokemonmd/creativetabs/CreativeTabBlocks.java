package com.fuzzyacornindustries.pokemonmd.creativetabs;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabBlocks extends CreativeTabs 
{
	public CreativeTabBlocks(String par2Str)
	{
		super(par2Str);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(PokemonMDBlock.xelNagaTechBlock);
	}
}