package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWillOfTheAncients extends Item
{
	public static String itemName = "willoftheancients";

	public ItemWillOfTheAncients()
	{
		this.maxStackSize = 1;
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A book of mystic");
		parList.add("legend.");
	}
}