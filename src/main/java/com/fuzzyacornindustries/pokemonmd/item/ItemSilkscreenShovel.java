package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemSpade;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class ItemSilkscreenShovel extends ItemSpade
{
	public static String itemName = "silkscreenshovel";

	protected ItemSilkscreenShovel() 
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