package com.fuzzyacornindustries.pokemonmd.item.battlegear;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.battlegear2.api.PlayerEventChild;
import mods.battlegear2.api.weapons.Attributes;
import mods.battlegear2.api.weapons.IBattlegearWeapon;
import mods.battlegear2.api.weapons.IPotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

@Optional.InterfaceList(value={
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IBattlegearWeapon", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.Attributes", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IPotionEffect", modid="battlegear2", striprefs=true)
})
public class ItemSpiderkissMace extends ItemSilkscreenMace implements IPotionEffect, IBattlegearWeapon, Attributes
{
	public static String itemName = "spiderkissmace";
	
    private float stunChance;
    private Map<PotionEffect, Float> effects;
    private static NumberFormat percentFormat = NumberFormat.getPercentInstance();

    static
    {
        percentFormat.setMaximumFractionDigits(0);
    }
    
	public ItemSpiderkissMace() 
	{
		super();

        effects= new HashMap<PotionEffect,Float>();
        this.stunChance = 0.05F + 0.05F * 2;
        effects.put(new PotionEffect(2,3*20,100), stunChance);
        effects.put(new PotionEffect(9,3*20,100), stunChance);
        effects.put(new PotionEffect(15,3*20,100), stunChance);
        effects.put(new PotionEffect(18,3*20,100), stunChance);
        
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":silkscreentools/" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
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
	
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List parList, boolean par4) 
    {
		parList.add("A mace tipped in a spider toxin");
		parList.add("that slows and poisons.");
		parList.add("");
		
		parList.add(EnumChatFormatting.GOLD+StatCollector.translateToLocal("attribute.name.weapon.daze")+" "+percentFormat.format(stunChance));
    }

    @Override
    public Multimap getAttributeModifiers(ItemStack stack) 
    {
        Multimap map = HashMultimap.create();

		map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.baseDamage, 0));
		
        return map;
    }

	@Method(modid="battlegear2")
	@Override
	public boolean sheatheOnBack(ItemStack stack) 
	{
		return true;
	}

	@Method(modid="battlegear2")
	@Override
	public boolean isOffhandHandDual(ItemStack off) 
	{
		return true;
	}

	@Method(modid="battlegear2")
	@Override
	public boolean offhandAttackEntity(PlayerEventChild.OffhandAttackEvent event, ItemStack mainhandItem, ItemStack offhandItem) 
	{
		return true;
	}

	@Method(modid="battlegear2")
	@Override
	public boolean offhandClickAir(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem) 
	{
		return true;
	}

	@Method(modid="battlegear2")
	@Override
	public boolean offhandClickBlock(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem) 
	{
		return true;
	}

	@Method(modid="battlegear2")
	@Override
	public void performPassiveEffects(Side effectiveSide, ItemStack mainhandItem, ItemStack offhandItem) {}

	@Method(modid="battlegear2")
	@Override
	public boolean allowOffhand(ItemStack mainhand, ItemStack offhand) 
	{
		return true;
	}
}