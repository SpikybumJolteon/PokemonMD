package com.fuzzyacornindustries.pokemonmd.item.turret;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemRegenUtility extends TurretUtilityItem
{
	public static String itemName = "regenutility";

	public ItemRegenUtility()
	{
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + "turrets/" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDTurrets);
	}

	static public String getItemName()
	{
		return itemName;
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Utility add-on to turrets that grant");
		parList.add("a slow health regeneration.");
	}

}