package com.fuzzyacornindustries.pokemonmd.item.tamable;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Facing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemPoketamableSummon extends Item
{
	public static String itemName;
	public static TamablePokemon poketamable;

	protected TamablePokemon entityToSpawn = null;

	public static int maximumDamage = 20;
	
	public ItemPoketamableSummon()
	{
		this.maxStackSize = 1;
		setMaxDamage(maximumDamage);
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDTamables);
	}

	static public String getItemName()
	{
		return itemName;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, 
			int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if (par3World.isRemote)
		{
			return true;
		}
		else
		{
			if(par1ItemStack.getItemDamage()  < par1ItemStack.getMaxDamage())
			{
				Block block = par3World.getBlock(x, y, z);

				x += Facing.offsetsXForSide[par7];
				y += Facing.offsetsYForSide[par7];
				z += Facing.offsetsZForSide[par7];

				double d0 = 0.0D;

				if (par7 == 1 && block.getRenderType() == 11)
				{
					d0 = 1.0D;
				}

				Entity entity = spawnEntity(par3World, par2EntityPlayer, par1ItemStack, x + 0.5D, y + d0, z + 0.5D);

				if (entity != null)
				{
					if (entity instanceof EntityLivingBase && par1ItemStack.hasDisplayName())
					{
						((EntityLiving)entity).setCustomNameTag(par1ItemStack.getDisplayName());
					}

					--par1ItemStack.stackSize;
				}
			}

			return false;
		}
	}
	
	public static void retrieveEntityStats(TamablePokemon poketamableEntity, ItemStack poketamableStack)
	{
		writeCompoundStringToItemStack(poketamableStack, "display", "Name", poketamableEntity.getDisplayName());
		writeCompoundFloatToItemStack(poketamableStack, "pokemonmd", "health", poketamableEntity.getHealth());
		writeCompoundFloatToItemStack(poketamableStack, "pokemonmd", "attackpower", poketamableEntity.getAttackPower());
		writeCompoundIntegerToItemStack(poketamableStack, "pokemonmd", "fireimmunity", poketamableEntity.hasFireImmunityEssence());
		writeCompoundIntegerToItemStack(poketamableStack, "pokemonmd", "drowningimmunity", poketamableEntity.hasDrowningImmunityEssence());
		writeCompoundIntegerToItemStack(poketamableStack, "pokemonmd", "fallimmunity", poketamableEntity.hasFallImmunityEssence());
		writeCompoundIntegerToItemStack(poketamableStack, "pokemonmd", "blocksuffocationavoidance", poketamableEntity.hasBlockSuffocationAvoidanceEssence());
		writeCompoundIntegerToItemStack(poketamableStack, "pokemonmd", "toxinimmunity", poketamableEntity.hasToxinImmunityEssence());
		writeCompoundIntegerToItemStack(poketamableStack, "pokemonmd", "survivability", poketamableEntity.hasSpaceSurvivabilityEssence());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("health", poketamableEntity.getHealth());
		poketamableStack.setItemDamage((int) itemDamageHealthValue(poketamableEntity.getHealth(), poketamableEntity.getMaximumHealth()));
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("maxhealth", poketamableEntity.getMaximumHealth());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("attackpower", poketamableEntity.getAttackPower());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("fireimmunity", poketamableEntity.hasFireImmunityEssence());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("drowningimmunity", poketamableEntity.hasDrowningImmunityEssence());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("fallgimmunity", poketamableEntity.hasFallImmunityEssence());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("blocksuffocationavoidance", poketamableEntity.hasBlockSuffocationAvoidanceEssence());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("toxinimmunity", poketamableEntity.hasToxinImmunityEssence());
		poketamableStack.getTagCompound().getCompoundTag("pokemonmd").setFloat("spacesurvivability", poketamableEntity.hasSpaceSurvivabilityEssence());
	}
	
	public static void applyEntityStats(TamablePokemon poketamableEntity, ItemStack poketamableStack, EntityPlayer player)
	{
		poketamableEntity.setMaximumHealth((poketamableStack.getTagCompound() != null && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getFloat("maxhealth") != 0) ? 
				poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getFloat("maxhealth") : poketamableEntity.getMaximumHealth());
		poketamableEntity.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(poketamableEntity.getMaximumHealth());
		poketamableEntity.setHealth((poketamableStack.getTagCompound() != null  && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getFloat("health") != 0) ? 
				poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getFloat("health") : poketamableEntity.getMaximumHealth());
		poketamableEntity.setAttackPower((poketamableStack.getTagCompound() != null  && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getFloat("attackpower") != 0) ? 
				poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getFloat("attackpower") : poketamableEntity.getAttackPower());
		
		poketamableEntity.setFireImmunityEssence((poketamableStack.getTagCompound() != null && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getInteger("fireimmunity") == 1) || poketamableEntity.hasFireImmunityEssence() == 1 ? 1 : 0);
		poketamableEntity.setDrowningImmunityEssence((poketamableStack.getTagCompound() != null && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getInteger("drowningimmunity") == 1) || poketamableEntity.hasDrowningImmunityEssence() == 1 ? 1 : 0);
		poketamableEntity.setFallImmunityEssence((poketamableStack.getTagCompound() != null && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getInteger("fallimmunity") == 1) || poketamableEntity.hasFallImmunityEssence() == 1 ? 1 : 0);
		poketamableEntity.setBlockSuffocationAvoidanceEssence((poketamableStack.getTagCompound() != null  && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getInteger("blocksuffocationavoidance") == 1) || poketamableEntity.hasBlockSuffocationAvoidanceEssence() == 1 ? 1 : 0);
		poketamableEntity.setToxinImmunityEssence((poketamableStack.getTagCompound() != null && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getInteger("toxinimmunity") == 1) || poketamableEntity.hasToxinImmunityEssence() == 1 ? 1 : 0);
		poketamableEntity.setSpaceSurvivabilityEssence((poketamableStack.getTagCompound() != null && poketamableStack.getTagCompound().getCompoundTag("pokemonmd").getInteger("spacesurvivability") == 1) || poketamableEntity.hasSpaceSurvivabilityEssence() == 1 ? 1 : 0);
	
		poketamableEntity.func_152115_b(player.getUniqueID().toString());
		poketamableEntity.setTamed(true);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par2World.isRemote)
		{
			if(par3EntityPlayer.isSneaking())
			{
				PokemonMDMain.proxy.displayPoketamableRenameGui(par1ItemStack);
			}
		}
		else if(!par3EntityPlayer.isSneaking())
		{
			if(par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage())
			{
				MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

				if (movingobjectposition == null)
				{
					return par1ItemStack;
				}
				else
				{
					if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
					{
						int i = movingobjectposition.blockX;
						int j = movingobjectposition.blockY;
						int k = movingobjectposition.blockZ;

						if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
						{
							return par1ItemStack;
						}

						if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
						{
							return par1ItemStack;
						}

						if (par2World.getBlock(i, j, k) instanceof BlockLiquid)
						{
							Entity entity = spawnEntity(par2World, par3EntityPlayer, par1ItemStack, i, j, k);

							if (entity != null)
							{
								if (entity instanceof EntityLivingBase && par1ItemStack.hasDisplayName())
								{
									((EntityLiving)entity).setCustomNameTag(par1ItemStack.getDisplayName());
								}

								--par1ItemStack.stackSize;
							}
						}
					}
				}
			}
		}

		return par1ItemStack;
	}

	public Entity spawnEntity(World parWorld, EntityPlayer parPlayer, ItemStack par1ItemStack, double parX, double parY, double parZ)
	{
		return null;
	}

	public static double itemDamageHealthValue(double input, double max)
	{
		return Math.abs((1 - (input / max)) * maximumDamage);
	}

	public static void writePoketamableNameToItemStack(ItemStack stack, String name)
	{
		writeCompoundStringToItemStack(stack, "display", "Name", EnumChatFormatting.DARK_PURPLE + name);
	}

	public static String getPoketamableNameFromItemStack(ItemStack stack)
	{
		return (stack.stackTagCompound != null ? stack.stackTagCompound.getCompoundTag("display").getString("Name") : "");
	}

	public static void writeCompoundIntegerToItemStack(ItemStack stack, String tag, String key, int data)
	{
		checkCompoundTag(stack, tag);
		stack.getTagCompound().getCompoundTag(tag).setInteger(key, data);
	}

	public static void writeCompoundFloatToItemStack(ItemStack stack, String tag, String key, float data)
	{
		checkCompoundTag(stack, tag);
		stack.getTagCompound().getCompoundTag(tag).setFloat(key, data);
	}

	public static void writeCompoundStringToItemStack(ItemStack stack, String tag, String key, String data)
	{
		checkCompoundTag(stack, tag);
		stack.getTagCompound().getCompoundTag(tag).setString(key, data);
	}

	private static void checkCompoundTag(ItemStack stack, String tag)
	{
		if (stack.getTagCompound() == null)
		{
			stack.setTagCompound(new NBTTagCompound());
		}

		if (!stack.getTagCompound().hasKey(tag))
		{
			stack.getTagCompound().setTag(tag, new NBTTagCompound());
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Hold 'sneak' and right click");
		parList.add("to bring up Poketamable stats");
		parList.add("and rename tamable. Press");
		parList.add("escape to save and exit menu.");
	}
}