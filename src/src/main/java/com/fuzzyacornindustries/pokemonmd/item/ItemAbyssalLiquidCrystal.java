package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAbyssalLiquidCrystal extends Item
{
	public static String itemName = "abyssalliquidcrystal";

	public ItemAbyssalLiquidCrystal()
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
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("An almost liquid paste");
		parList.add("of matter from the void;");
		parList.add("a potent furnace fuel.");
	}
}