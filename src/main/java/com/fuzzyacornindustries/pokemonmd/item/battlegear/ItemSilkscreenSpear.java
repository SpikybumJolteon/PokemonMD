package com.fuzzyacornindustries.pokemonmd.item.battlegear;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.battlegear2.api.IBackSheathedRender;
import mods.battlegear2.api.PlayerEventChild;
import mods.battlegear2.api.shield.IShield;
import mods.battlegear2.api.weapons.Attributes;
import mods.battlegear2.api.weapons.IBattlegearWeapon;
import mods.battlegear2.api.weapons.IExtendedReachWeapon;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

@Optional.InterfaceList(value={
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IBattlegearWeapon", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.Attributes", modid="battlegear2", striprefs=true),
		@Optional.Interface(iface="mods.battlegear2.api.weapons.IExtendedReachWeapon", modid="battlegear2", striprefs=true)
})
public class ItemSilkscreenSpear extends ItemSword implements IBattlegearWeapon, Attributes, IExtendedReachWeapon
{
	public static String itemName = "silkscreenspear";
	
    //Will make it one more than a sword
    private final int mounted_extra_damage;
    private final float reach;
    
    public IIcon bigIcon;

	protected float baseDamage = 0;

    public ItemSilkscreenSpear() 
    {
		super(PokemonMDItem.silkscreenMaterial);
        this.mounted_extra_damage = 3;
        this.reach = 2.0F;
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
		parList.add("A spear made of a silk material");
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

	@Method(modid="battlegear2")
	@Override
	public float getReachModifierInBlocks(ItemStack stack) 
	{
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
	public boolean allowOffhand(ItemStack mainhand, ItemStack offhand) 
	{
		return offhand == null || offhand.getItem() instanceof IShield;
	}

    @Override
    public Multimap getAttributeModifiers(ItemStack stack) 
    {
        Multimap map = HashMultimap.create();
        
		map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.baseDamage, 0));
        map.put(extendedReach.getAttributeUnlocalizedName(), new AttributeModifier(extendReachUUID, "Reach Modifier", this.reach, 0));
        map.put(mountedBonus.getAttributeUnlocalizedName(), new AttributeModifier(mountedBonusUUID, "Attack Modifier", this.mounted_extra_damage, 0));
        return map;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) 
    {
        super.registerIcons(par1IconRegister);
        
        bigIcon = par1IconRegister.registerIcon(this.getIconString() + "big");
    }
/*
	@Method(modid="battlegear2")
    @Override
    @SideOnly(Side.CLIENT)
    public void preRenderBackSheathed(ItemStack itemStack, int amountOnBack, RenderPlayerEvent event, boolean inMainHand) 
    {
        if(inMainHand) 
        {
            GL11.glScalef(0.6F, -0.6F, 0.6F);
            GL11.glTranslatef(0, -1, 0);
        }
        else
        {//Case never reached anyway
            GL11.glScalef(-0.6F, 0.6F, 0.6F);
        }
    }*/

	@Method(modid="battlegear2")
	@Override
	public boolean sheatheOnBack(ItemStack item) 
	{
		return true;
	}

	@Method(modid="battlegear2")
	@Override
	public boolean isOffhandHandDual(ItemStack off) 
	{
		return false;
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
}