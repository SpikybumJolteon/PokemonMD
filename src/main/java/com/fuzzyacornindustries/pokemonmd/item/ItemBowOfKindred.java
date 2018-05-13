package com.fuzzyacornindustries.pokemonmd.item;

import java.util.ArrayList;
import java.util.List;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.player.PlayerUtility;
import com.fuzzyacornindustries.pokemonmd.entity.player.PokemonMDPlayerInfo;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityHunterBolt;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.utility.TargetUtilities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

//@Optional.InterfaceList(value={
//		@Optional.Interface(iface="mods.battlegear2.api.IAllowItem", modid="battlegear2", striprefs=true),
//		@Optional.Interface(iface="mods.battlegear2.api.ISheathed", modid="battlegear2", striprefs=true),
//		@Optional.Interface(iface="mods.battlegear2.api.quiver.ISpecialBow", modid="battlegear2", striprefs=true)
//})
public class ItemBowOfKindred extends ItemBow //implements IZoom//, IAllowItem, ISheathed, ISpecialBow
{
	public static final String[] bowPullIconNameArray = new String[] {"pulling0", "pulling1", "pulling2"};

	public static String itemName = "bowofkindred";

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public ItemBowOfKindred()
	{
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + getItemName() + "/" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);

		setFull3D();
	}

	static public String getItemName()
	{
		return itemName;
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack bow, World world, EntityPlayer player, int itemInUseCount)
	{
		int chargeTimer = this.getMaxItemUseDuration(bow) - itemInUseCount + 10;

		ArrowLooseEvent event = new ArrowLooseEvent(player, bow, chargeTimer);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
		{
			return;
		}

		chargeTimer = event.charge;

		if (player.capabilities.isCreativeMode || bow.getItemDamage() < bow.getMaxDamage() || player.inventory.hasItem(PokemonMDItem.huntersCharge)) //  || player.inventory.hasItem(Items.arrow)
		{
			float charge = (float)chargeTimer / 20.0F;
			charge = (charge * charge + charge * 2.0F) / 3.0F;

			if ((double)charge < 0.1D)
			{
				return;
			}

			if (charge > 1.0F)
			{
				charge = 1.0F;
			}

			if(player.isSneaking())
			{
				int danceOfArrowsQuantity = 3;

				List<EntityMob> nearestThreeTargetMobs = TargetUtilities.acquireNearestLookMobTargetList(player, 10, 5D, danceOfArrowsQuantity); 

				int numberOfShotsToFire = nearestThreeTargetMobs.size();

				if (numberOfShotsToFire > 0)
				{
					for (EntityMob target : nearestThreeTargetMobs) 
					{
						if(player.capabilities.isCreativeMode || this.getDamage(bow) < this.getMaxDamage() || player.inventory.hasItem(PokemonMDItem.huntersCharge))
						{
							applyHunterCharge(bow, player);

							EntityHunterBolt entityBolt = new EntityHunterBolt(world, player, (EntityLivingBase)target, charge * 2.0F, 0F);

							TargetUtilities.applyHunterBoltSettings(entityBolt, bow, charge, 0.49F);

							bow.damageItem(1, player);

							if (!world.isRemote)
							{
								world.spawnEntityInWorld(entityBolt);
							}

							playShootSound(player, world, charge);

							//System.out.println( "Test Entity Detected By Dance of Arrows" );
							//System.out.println( Integer.toString( target.getEntityId() ) );
						}
					}

					//System.out.println( "Test Entity Detected By Dance of Arrows" );
					//System.out.println( Integer.toString( nearestThreeTargetMobs.size() ) );
				}
			}
			else
			{
				applyHunterCharge(bow, player);

				EntityHunterBolt entityBolt = new EntityHunterBolt(world, player, charge * 2.0F);

				TargetUtilities.applyHunterBoltSettings(entityBolt, bow, charge);

				bow.damageItem(1, player);

				playShootSound(player, world, charge);

				if (!world.isRemote)
				{
					world.spawnEntityInWorld(entityBolt);
				}
			}
		}
	}

	public void playShootSound(EntityPlayer player, World world, float charge)
	{
		world.playSoundAtEntity(player, ModInfo.MODID + ":effects.bowofkindred.shoot", 3.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + charge * 0.5F);
	}

	public void applyHunterCharge(ItemStack bow, EntityPlayer player)
	{
		if(this.getDamage(bow) >= this.getMaxDamage() - 1 && player.inventory.hasItem(PokemonMDItem.huntersCharge))
		{
			bow.setItemDamage(0);

			player.inventory.consumeInventoryItem(PokemonMDItem.huntersCharge);
		}
	}

	@Override
	public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_)
	{
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
	{
		return true;
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		return itemStack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack itemStack)
	{
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		return EnumAction.bow;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack bow, World world, EntityPlayer player)
	{
		ArrowNockEvent event = new ArrowNockEvent(player, bow);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
		{
			return event.result;
		}

		if(this.getDamage(bow) < this.getMaxDamage() || player.inventory.hasItem(PokemonMDItem.huntersCharge))
		{
			player.setItemInUse(bow, this.getMaxItemUseDuration(bow));
		}

		return bow;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (usingItem != null)
		{
			int time = 72000 - useRemaining;
			if (time < 3)
				return iconArray[0];
			if (time < 6)
				return iconArray[1];
			return iconArray[2];
		}

		return getIcon(stack, renderPass);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(this.getIconString() + "standby");
		this.iconArray = new IIcon[bowPullIconNameArray.length];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(this.getIconString() + bowPullIconNameArray[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getItemIconForUseDuration(int iconNumber)
	{
		return this.iconArray[iconNumber];
	}
}