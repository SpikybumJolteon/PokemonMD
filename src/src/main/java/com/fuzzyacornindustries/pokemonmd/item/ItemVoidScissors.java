package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVoidScissors extends Item
{
	public static String itemName = "voidscissors";

	public ItemVoidScissors()
	{
		this.maxStackSize = 1;
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
		setMaxDamage(64);
	}

	static public String getItemName()
	{
		return itemName;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A recipe tool used to cut certain vanilla");
		parList.add("items down to their raw materials;");
		parList.add("some material is lost in the process.");
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
    {
        ItemStack copiedStack = itemStack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
        copiedStack.stackSize = 1;

        return copiedStack;
    }
	
	@Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
        return false;
    }
	
	@Override
    public boolean hasContainerItem()
    {
        return true;
    }
}