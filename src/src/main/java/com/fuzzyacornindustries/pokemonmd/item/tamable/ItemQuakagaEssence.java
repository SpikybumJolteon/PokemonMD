package com.fuzzyacornindustries.pokemonmd.item.tamable;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemQuakagaEssence extends Item implements IEssenceItem
{
	public static String itemName = "quakagaessence";

	public ItemQuakagaEssence()
	{
		this.maxStackSize = 64;
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDTamables);
	}

	static public String getItemName()
	{
		return itemName;
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Right click a Poketamable");
		parList.add("to permanently add an ability");
		parList.add("to try and escape sufficating");
		parList.add("in a block by teleporting");
		parList.add("to its owner.");
	}
}