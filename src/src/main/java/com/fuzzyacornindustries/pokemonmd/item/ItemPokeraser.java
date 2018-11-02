package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemPokeraser extends Item
{
	public static String itemName = "pokeraser";

	public ItemPokeraser()
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
		parList.add("A creative mode item for removing");
		parList.add("Pokemobs from this mod; won't remove");
		parList.add("other player's Poketamables.");
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		if(par2EntityLivingBase instanceof EntityHostilePokemonMD || par2EntityLivingBase instanceof EntitySubstituteDoll)
		{
			((EntityLivingBase)par2EntityLivingBase).setDead();
		}
		else if(par2EntityLivingBase instanceof TamablePokemon && par3EntityLivingBase instanceof EntityPlayer)
		{
			if(((TamablePokemon)par2EntityLivingBase).isTamed() && !((TamablePokemon)par2EntityLivingBase).func_152114_e((EntityPlayer)par3EntityLivingBase))
			{
				return true;
			}

			((EntityLivingBase)par2EntityLivingBase).setDead();
		}

		return true;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
	{
		if (entity.worldObj.isRemote)
		{
			return false;
		}
		else if(entity instanceof EntityHostilePokemonMD || entity instanceof EntitySubstituteDoll)
		{
			((EntityLivingBase)entity).setDead();
		}
		else if(entity instanceof TamablePokemon)
		{
			if(((TamablePokemon)entity).isTamed() && !((TamablePokemon)entity).func_152114_e(player))
			{
				return true;
			}

			((EntityLivingBase)entity).setDead();
		}

		return false;
	}
}