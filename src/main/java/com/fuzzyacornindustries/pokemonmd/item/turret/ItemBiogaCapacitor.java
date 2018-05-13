package com.fuzzyacornindustries.pokemonmd.item.turret;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemBiogaCapacitor extends TurretPowerItem
{
	public static String itemName = "biogacapacitor";

	public ItemBiogaCapacitor()
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
		parList.add("Stage 3 attack add-on to turrets that");
		parList.add("inflicts a heavy poison for 5 seconds.");
	}

	@Override
	public void performAttackStyle(EntityLivingBase attackTarget) 
	{
		super.performAttackStyle(attackTarget);

		byte numberOfSeconds = 5;

		((EntityLivingBase)attackTarget).addPotionEffect(new PotionEffect(Potion.poison.id, numberOfSeconds * 20, 1));
	}
}