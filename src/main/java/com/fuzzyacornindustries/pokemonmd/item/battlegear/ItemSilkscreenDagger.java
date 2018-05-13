package com.fuzzyacornindustries.pokemonmd.item.battlegear;

import java.util.Iterator;
import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.battlegear2.Battlegear;
import mods.battlegear2.api.PlayerEventChild;
import mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent;
import mods.battlegear2.api.weapons.Attributes;
import mods.battlegear2.api.weapons.IBackStabbable;
import mods.battlegear2.api.weapons.IBattlegearWeapon;
import mods.battlegear2.api.weapons.IExtendedReachWeapon;
import mods.battlegear2.api.weapons.IHitTimeModifier;
import mods.battlegear2.items.OneHandedWeapon;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

@Optional.InterfaceList(value={
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IBattlegearWeapon", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.Attributes", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IBackStabbable", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IHitTimeModifier", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IExtendedReachWeapon", modid="battlegear2", striprefs=true)
})
public class ItemSilkscreenDagger extends ItemSword implements IBattlegearWeapon, Attributes, IBackStabbable, IHitTimeModifier, IExtendedReachWeapon
{
	public static String itemName = "silkscreendagger";
	
    private final float hitTime;
    private final float reach;

	protected float baseDamage = 0;
	
	public ItemSilkscreenDagger() 
	{
		super(PokemonMDItem.silkscreenMaterial);
        this.hitTime = 0.5F;
        this.reach = -2F;
		//set the base damage to that of lower than usual (balance)
		this.baseDamage = 4 + PokemonMDItem.silkscreenMaterial.getDamageVsEntity();
		this.baseDamage -= 2;

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
		parList.add("A dagger made of a silk material");
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
	public boolean func_150897_b(Block par1Block) //Daggers can harvest tallgrass and wool
    {
        return par1Block == Blocks.tallgrass||par1Block == Blocks.wool;
    }

    @Override
    public Multimap getAttributeModifiers(ItemStack stack) 
    {
        Multimap map = HashMultimap.create();
        
		map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.baseDamage, 0));
        map.put(extendedReach.getAttributeUnlocalizedName(), new AttributeModifier(extendReachUUID, "Reach Modifier", this.reach, 0));
        map.put(attackSpeed.getAttributeUnlocalizedName(), new AttributeModifier(attackSpeedUUID, "Speed Modifier", this.hitTime, 1));
        return map;
    }

	@Method(modid="battlegear2")
	@Override
	public int getHitTime(ItemStack stack, EntityLivingBase target) 
	{
		return -(int)(getModifiedAmount(stack, attackSpeed.getAttributeUnlocalizedName()) * 10);
	}

	@Method(modid="battlegear2")
	@Override //Here we simply cause more damage (hit will touch twice, one here and the other called vanilla)
	public boolean onBackStab(EntityLivingBase entityHit, EntityLivingBase entityHitting)
	{
        return entityHit.attackEntityFrom(new EntityDamageSource(Battlegear.CUSTOM_DAMAGE_SOURCE + ".backstab", entityHitting), this.baseDamage);
	}

	@Method(modid="battlegear2")
    @Override
    public float getReachModifierInBlocks(ItemStack stack) {
        return getModifiedAmount(stack, extendedReach.getAttributeUnlocalizedName());
    }

    public float getModifiedAmount(ItemStack stack, String modifierName)
    {
        Iterator itr = stack.getAttributeModifiers().get(modifierName).iterator();
        float f = 0;
    
        while(itr.hasNext())
        {
            f += ((AttributeModifier)itr.next()).getAmount();
        }
        return f;
    }

	@Method(modid="battlegear2")
	@Override
	public boolean sheatheOnBack(ItemStack item) 
	{
		return false;
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