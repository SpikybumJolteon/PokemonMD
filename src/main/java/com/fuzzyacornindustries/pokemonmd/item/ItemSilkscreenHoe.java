package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemHoe;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class ItemSilkscreenHoe extends ItemHoe
{
	public static String itemName = "silkscreenhoe";

	protected ItemSilkscreenHoe() 
	{
		super(PokemonMDItem.silkscreenMaterial);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":silkscreentools/" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
	}
}