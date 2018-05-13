package com.fuzzyacornindustries.pokemonmd.item.turret;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBarrierDefender extends TurretDefenseItem
{
	public static String itemName = "barrierdefender";

	public ItemBarrierDefender()
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
		parList.add("Defense add-on to turrets that");
		parList.add("grants 6 points of armor.");
	}
	
	@Override
	public int getArmorValue()
	{
		return 6;
	}
}