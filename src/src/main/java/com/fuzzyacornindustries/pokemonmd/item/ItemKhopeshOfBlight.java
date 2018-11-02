package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityBlightOoze;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemKhopeshOfBlight extends ItemSword
{
	public static String itemName = "khopeshofblight";

    public IIcon bigIcon;
    
	protected ItemKhopeshOfBlight() 
	{
		super(PokemonMDItem.challengerMaterial);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":challengertools/" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A Challenger tier sword-like");
		parList.add("weapon that can hurl poison");
		parList.add("projectiles with right click");
		parList.add("and consume a spider eye.");
		parList.add("Slows target with a regular");
		parList.add("strike.");
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(1, par3EntityLivingBase);

		int durationInSeconds = 5;

		((EntityLivingBase)par2EntityLivingBase).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, durationInSeconds * 20, 0));

		return true;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack khopesh, World world, EntityPlayer player)
	{
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.spider_eye))
		{
			if(!player.capabilities.isCreativeMode)
				player.inventory.consumeInventoryItem(Items.spider_eye);

			EntityBlightOoze blightOoze = new EntityBlightOoze(world, player, 1.0F);

			khopesh.damageItem(1, player);

			player.worldObj.playSoundAtEntity(player, "mob.slime.big", 1F, 1F);

			if (!world.isRemote)
			{
				world.spawnEntityInWorld(blightOoze);
			}

			return khopesh;
		}

		return super.onItemRightClick(khopesh, world, player);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) 
    {
        super.registerIcons(par1IconRegister);
        
        bigIcon = par1IconRegister.registerIcon(this.getIconString() + "big");
    }
}