package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemPickaxe;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class ItemSilkscreenPickaxe extends ItemPickaxe
{
	public static String itemName = "silkscreenpickaxe";

	protected ItemSilkscreenPickaxe() 
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