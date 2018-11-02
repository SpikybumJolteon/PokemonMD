package com.fuzzyacornindustries.pokemonmd.item;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemSubstituteDoll extends Item
{
	public static String itemName = "substitutedollitem";
	
	protected EntityLiving entityToSpawn = null;
	
    public ItemSubstituteDoll()
    {
        this.maxStackSize = 64;
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + "substitutedollitem");
        this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
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
			Block block = par3World.getBlock(x, y, z);
			
			x += Facing.offsetsXForSide[par7];
			y += Facing.offsetsYForSide[par7];
			z += Facing.offsetsZForSide[par7];
			
			double d0 = 0.0D;

			if (par7 == 1 && block.getRenderType() == 11)
			{
				d0 = 1.0D;
			}

			Entity entity = spawnEntity(par3World, par2EntityPlayer, x + 0.5D, y + d0, z + 0.5D);

			if (entity != null)
			{
				if (entity instanceof EntityLivingBase && par1ItemStack.hasDisplayName())
				{
					((EntityLiving)entity).setCustomNameTag(par1ItemStack.getDisplayName());
				}

				if (!par2EntityPlayer.capabilities.isCreativeMode)
				{
					--par1ItemStack.stackSize;
				}
			}

			return true;
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par2World.isRemote)
		{
			return par1ItemStack;
		}
		else
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
						Entity entity = spawnEntity(par2World, par3EntityPlayer, i, j, k);

						if (entity != null)
						{
							if (entity instanceof EntityLivingBase && par1ItemStack.hasDisplayName())
							{
								((EntityLiving)entity).setCustomNameTag(par1ItemStack.getDisplayName());
							}

							if (!par3EntityPlayer.capabilities.isCreativeMode)
							{
								--par1ItemStack.stackSize;
							}
						}
					}
				}

				return par1ItemStack;
			}
		}
	}

	public Entity spawnEntity(World parWorld, EntityPlayer parPlayer, double parX, double parY, double parZ)
	{
		if (!parWorld.isRemote)
		{
			String entityToSpawnNameFull = ModInfo.MODID + "." + EntitySubstituteDoll.getMobName();
			
			if (EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull))
			{
				entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, parWorld);
				entityToSpawn.setLocationAndAngles(parX, parY, parZ, MathHelper.wrapAngleTo180_float(parWorld.rand.nextFloat() * 360.0F), 0.0F);

				((EntitySubstituteDoll)entityToSpawn).setDollType(EntitySubstituteDoll.NORMAL_ID);

				parWorld.spawnEntityInWorld(entityToSpawn);
				entityToSpawn.onSpawnWithEgg((IEntityLivingData)null);
				entityToSpawn.playLivingSound();
			}
			else
			{
				//DEBUG
				System.out.println("Entity not found " + EntitySubstituteDoll.getMobName());
			}
		}

		return entityToSpawn;
	}
}