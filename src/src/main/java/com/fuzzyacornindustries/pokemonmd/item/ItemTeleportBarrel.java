package com.fuzzyacornindustries.pokemonmd.item;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.item.Item;

public class ItemTeleportBarrel extends Item
{
	public static String itemName = "teleportbarrel";

	public ItemTeleportBarrel()
	{
		this.maxStackSize = 64;
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
	}
}