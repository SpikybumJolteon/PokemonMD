package com.fuzzyacornindustries.pokemonmd.item.turret;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemChaosCapacitor extends TurretPowerItem
{
	public static String itemName = "chaoscapacitor";

	public static int attackPowerAddition = 4;
	
	public ItemChaosCapacitor()
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
		parList.add("Attack add-on to turrets");
		parList.add("that inflicts " + attackPowerAddition + "+ damage.");
	}
	
	@Override
	public float getAttackPower()
	{
		return EntityPrototurret.baseAttackPower + (float)attackPowerAddition;
	}
/*
	@Override
	public void performAttackStyle() 
	{
		// TODO Auto-generated method stub
		
	}*/
}