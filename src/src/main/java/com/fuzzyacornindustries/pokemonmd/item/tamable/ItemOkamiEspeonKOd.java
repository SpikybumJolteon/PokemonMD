package com.fuzzyacornindustries.pokemonmd.item.tamable;

import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class ItemOkamiEspeonKOd extends ItemPoketamableKOd
{
	public ItemOkamiEspeonKOd()
	{
		itemName = "okamiespeonkod";
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + "tamables/" + getItemName());
	}
}