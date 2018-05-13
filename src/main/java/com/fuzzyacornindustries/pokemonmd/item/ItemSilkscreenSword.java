package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSilkscreenSword extends ItemSword
{
	public static String itemName = "silkscreensword";

	protected ItemSilkscreenSword() 
	{
		super(PokemonMDItem.silkscreenMaterial);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":silkscreentools/" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
	}

	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A sword made of a silk material");
		parList.add("that inflicts slow.");
	}
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        
        int durationInSeconds = 5;
        
		((EntityLivingBase)par2EntityLivingBase).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, durationInSeconds * 20, 0));
        
        return true;
    }
}