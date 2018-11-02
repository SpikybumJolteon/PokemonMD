package com.fuzzyacornindustries.pokemonmd.item.tamable;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssenceRecaller extends Item
{
	public static String itemName = "essencerecaller";

	public ItemEssenceRecaller()
	{
		this.maxStackSize = 1;
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
		parList.add("An item to return your own Poketamable");
		parList.add("to their summon item form; will not work");
		parList.add("on others or ones spawned with eggs;");
		parList.add("must be at full health to use.");
	}
	/*
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		if(par2EntityLivingBase instanceof TamablePokemon && ((TamablePokemon)par2EntityLivingBase).func_152114_e(par3EntityLivingBase) || !((TamablePokemon)par2EntityLivingBase).isTamed())
		{
			((EntityLivingBase)par2EntityLivingBase).setDead();
		}

		return true;
	}*/

	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
	{
		if (entity.worldObj.isRemote)
		{
			return false;
		}
		else if(entity instanceof TamablePokemon && ((TamablePokemon)entity).func_152114_e(player))
		{
			((TamablePokemon)entity).setDead();

			player.inventoryContainer.detectAndSendChanges();
		}

		return false;
	}
}