package com.fuzzyacornindustries.pokemonmd.item.turret;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemFiraCapacitor extends TurretPowerItem
{
	public static String itemName = "firacapacitor";

	public ItemFiraCapacitor()
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
		parList.add("Stage 2 attack add-on to turrets that ");
		parList.add("sets target on fire for 10 seconds.");
	}

	@Override
	public void performAttackStyle(EntityLivingBase attackTarget) 
	{
		super.performAttackStyle(attackTarget);

		byte numberOfSeconds = 10;

		((EntityLivingBase)attackTarget).setFire(numberOfSeconds * 20);
	}
}