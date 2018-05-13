package com.fuzzyacornindustries.pokemonmd.item.turret;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.block.BlockPrototurret;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemMysticInitializer extends Item
{
	public static String itemName = "mysticinitializer";

	public ItemMysticInitializer()
	{
		this.maxStackSize = 1;
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDTurrets);
	}

	static public String getItemName()
	{
		return itemName;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Activates turret blocks and sets");
		parList.add("player as the owner. Right-click");
		parList.add("your turret with initializer at full");
		parList.add("to return it to its block form.");
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, 
			int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		if (!par2EntityPlayer.canPlayerEdit(x, y, z, par7, par1ItemStack))
		{
			return false;
		}
		else
		{
			Block block = par3World.getBlock(x, y, z);

			if (block instanceof BlockPrototurret)
			{
				if(!par3World.isRemote)
				{
					par3World.setBlockToAir(x, y, z);

					Entity entity = spawnEntity(par3World, par2EntityPlayer, x, y, z);
				}
				else
				{
					for(int i = 0; i < 5; i++)
					{
						float xx = (float) x + 0.5F, yy = (float) y + par3World.rand.nextFloat() * 6.0F / 16.0F, zz = (float) z + 0.5F, xx2 = par3World.rand.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;
						
						par3World.spawnParticle("instantSpell", (double) (xx), (double) yy, (double) (zz), 0.0F, 0.0F, 0.0F);
					}
				}

				return true;
			}
		}

		return false;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
	{
		if(entity != null)
		{
			if (entity.worldObj.isRemote)
			{
				return false;
			}
			else if(entity instanceof EntityPrototurret && ((EntityPrototurret)entity).func_152114_e(player) && ((EntityPrototurret)entity).getHealth() >= ((EntityPrototurret)entity).getMaxHealth())
			{
				if(((EntityPrototurret)entity).dropTurretItem(player))
				{
					((EntityLivingBase)entity).setDead();
				}

				player.inventoryContainer.detectAndSendChanges();
			}
		}

		return false;
	}

	public Entity spawnEntity(World parWorld, EntityPlayer parPlayer, double parX, double parY, double parZ)
	{
		EntityLiving entityToSpawn = null;
		
		if (!parWorld.isRemote)
		{	
			String entityToSpawnNameFull = ModInfo.MODID + "." + EntityPrototurret.getTurretName();
			
			if (EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull))
			{
				entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, parWorld);
				entityToSpawn.setLocationAndAngles(parX + 0.5D, parY, parZ + 0.5D, MathHelper.wrapAngleTo180_float(parWorld.rand.nextFloat() * 360.0F), 0.0F);

				((EntityPrototurret)entityToSpawn).func_152115_b(parPlayer.getUniqueID().toString());
				((EntityPrototurret)entityToSpawn).setTamed(true);

				entityToSpawn.setHealth(EntityPrototurret.healthMaximum);
				
				parWorld.spawnEntityInWorld(entityToSpawn);
				entityToSpawn.onSpawnWithEgg((IEntityLivingData)null);
				entityToSpawn.playLivingSound();
			}
			else
			{
				//DEBUG
				System.out.println("Entity not found " + EntityPrototurret.getTurretName());
			}
		}

		return entityToSpawn;
	}
}