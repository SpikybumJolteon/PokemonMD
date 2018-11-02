package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class ItemSilkscreenArmor extends ItemArmor
{
	public String basePath = "silkscreenarmor/";

	public ItemSilkscreenArmor(int armorIDNumber)
	{
		super(PokemonMDItem.silkscreenArmorMaterial, PokemonMDMain.proxy.addArmor("silkscreenarmor"), armorIDNumber);
		
		String pieceName;
		
		if(armorIDNumber == 0)
		{
			pieceName = "silkscreenhelmet";
			this.setTextureName(ModInfo.MODID + ":" + basePath + pieceName);
			this.setUnlocalizedName(pieceName);
		}
		else if(armorIDNumber == 1)
		{
			pieceName = "silkscreenchestplate";
			this.setTextureName(ModInfo.MODID + ":" + basePath + pieceName);
			this.setUnlocalizedName(pieceName);
		}
		else if(armorIDNumber == 2)
		{
			pieceName = "silkscreenleggings";
			this.setTextureName(ModInfo.MODID + ":" + basePath + pieceName);
			this.setUnlocalizedName(pieceName);
		}
		else
		{
			pieceName = "silkscreenboots";
			this.setTextureName(ModInfo.MODID + ":" + basePath + pieceName);
			this.setUnlocalizedName(pieceName);
		}

		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == PokemonMDItem.silkscreenHelmet || 
				stack.getItem() == PokemonMDItem.silkscreenChestplate || 
				stack.getItem() == PokemonMDItem.silkscreenBoots)
		{
			return ModInfo.MODID + ":textures/armor/silkscreenarmor1.png";
		}
		else if(stack.getItem() == PokemonMDItem.silkscreenLeggings)
		{
			return ModInfo.MODID + ":textures/armor/silkscreenarmor2.png";
		}
		else
		{
			return null;
		}
	}
}