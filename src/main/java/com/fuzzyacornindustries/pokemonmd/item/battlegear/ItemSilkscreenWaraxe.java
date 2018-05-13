package com.fuzzyacornindustries.pokemonmd.item.battlegear;

import java.util.List;

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
import mods.battlegear2.api.weapons.IPenetrateWeapon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

@Optional.InterfaceList(value={
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IBattlegearWeapon", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.Attributes", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IPenetrateWeapon", modid="battlegear2", striprefs=true)
})
public class ItemSilkscreenWaraxe extends ItemSword implements IBattlegearWeapon, Attributes, IPenetrateWeapon
{
	public static String itemName = "silkscreenwaraxe";

	private final int ignoreDamageAmount = 1;
	protected float baseDamage = 0;
	
	public ItemSilkscreenWaraxe() 
	{
		super(PokemonMDItem.silkscreenMaterial);

		//set the base damage to that of lower than usual (balance)
		this.baseDamage = 4 + PokemonMDItem.silkscreenMaterial.getDamageVsEntity();
		this.baseDamage -= 1 + ignoreDamageAmount;
		
		this.setMaxDamage(PokemonMDItem.silkscreenMaterial.getMaxUses());
		
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
		parList.add("A waraxe made of a silk material");
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
	
	@Override
	public boolean func_150897_b(Block par1Block)//Waraxe can harvest logs
    {
        return par1Block instanceof BlockLog;
    }
	
	@Method(modid="battlegear2")
    @Override
    public Multimap getAttributeModifiers(ItemStack stack) 
    {
        Multimap map = HashMultimap.create();

		map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.baseDamage, 0));
        map.put(armourPenetrate.getAttributeUnlocalizedName(), new AttributeModifier(penetrateArmourUUID, "Attack Modifier", this.ignoreDamageAmount, 0));
		
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

	@Method(modid="battlegear2")
	@Override
	public int getPenetratingPower(ItemStack stack) 
	{
		return ignoreDamageAmount;
	}
}