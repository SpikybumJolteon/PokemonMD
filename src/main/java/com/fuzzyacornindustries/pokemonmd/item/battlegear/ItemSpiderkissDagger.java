package com.fuzzyacornindustries.pokemonmd.item.battlegear;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.battlegear2.api.weapons.Attributes;
import mods.battlegear2.api.weapons.IBackStabbable;
import mods.battlegear2.api.weapons.IBattlegearWeapon;
import mods.battlegear2.api.weapons.IExtendedReachWeapon;
import mods.battlegear2.api.weapons.IHitTimeModifier;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

@Optional.InterfaceList(value={
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IBattlegearWeapon", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.Attributes", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IBackStabbable", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IHitTimeModifier", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IExtendedReachWeapon", modid="battlegear2", striprefs=true)
})
public class ItemSpiderkissDagger extends ItemSilkscreenDagger implements IBattlegearWeapon, Attributes, IBackStabbable, IHitTimeModifier, IExtendedReachWeapon
{
	public static String itemName = "spiderkissdagger";
	
	public ItemSpiderkissDagger() 
	{
		super();
		
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
		parList.add("A dagger tipped in a spider toxin");
		parList.add("that slows and poisons.");
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        
        int durationInSeconds = 5;
        
		((EntityLivingBase)par2EntityLivingBase).addPotionEffect(new PotionEffect(Potion.poison.id, durationInSeconds * 20, 0));
		((EntityLivingBase)par2EntityLivingBase).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, durationInSeconds * 20, 0));
        
        return true;
    }
}