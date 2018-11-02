package com.fuzzyacornindustries.pokemonmd.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class PokemonMDCreativeTabs
{
	public static CreativeTabs tabPokemonMDBlocks;
	public static CreativeTabs tabPokemonMDItems;
	public static CreativeTabs tabPokemonMDMob;
	public static CreativeTabs tabPokemonMDTamables;
	public static CreativeTabs tabPokemonMDTurrets;

	public static void initializeTabs()
	{
		tabPokemonMDBlocks = new CreativeTabBlocks("pokemonmdtabblocks");
		tabPokemonMDTamables = new CreativeTabTamables("pokemonmdtabtamables");
		tabPokemonMDItems = new CreativeTabItems("pokemonmdtabitems");
		tabPokemonMDMob = new CreativeTabMobs("pokemonmdtabmobs");
		tabPokemonMDTurrets = new CreativeTabTurrets("pokemonmdtabturrets");
	}
}