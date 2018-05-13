package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class CorruptPokemonPlacer extends ItemMonsterPlacer
{
	@SideOnly(Side.CLIENT)
	private IIcon theIcon;
	protected int colorBase = 0x000000;
	protected int colorSpots = 0xFFFFFF;
	protected String entityToSpawnName = "";
	protected String entityToSpawnNameFull = "";
	protected String entityLanguageName = "";
	protected EntityLiving entityToSpawn = null;

	public CorruptPokemonPlacer()
	{
		super();
	}

	public CorruptPokemonPlacer(String parEntityToSpawnName, String parEntityLanguageName, int parPrimaryColor, int parSecondaryColor)
	{
		setHasSubtypes(false);
		maxStackSize = 64;
		setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDMob);
		setEntityToSpawnName(parEntityToSpawnName, parEntityLanguageName);
		colorBase = parPrimaryColor;
		colorSpots = parSecondaryColor;
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
				d0 = 0.5D;
			}

			Entity entity = spawnEntity(par3World, x + 0.5D, y + d0, z + 0.5D);

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
						Entity entity = spawnEntity(par2World, i, j, k);

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

	public Entity spawnEntity(World parWorld, double parX, double parY, double parZ)
	{
		if (!parWorld.isRemote)
		{
			entityToSpawnNameFull = ModInfo.MODID + "." + entityToSpawnName;
			
			if (EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull))
			{
				entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, parWorld);
				entityToSpawn.setLocationAndAngles(parX, parY, parZ, MathHelper.wrapAngleTo180_float(parWorld.rand.nextFloat() * 360.0F), 0.0F);
				parWorld.spawnEntityInWorld(entityToSpawn);
				entityToSpawn.onSpawnWithEgg((IEntityLivingData)null);
				entityToSpawn.playLivingSound();
			}
			else
			{
				//DEBUG
				System.out.println("Entity not found " + entityToSpawnName);
			}
		}

		return entityToSpawn;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item parItem, CreativeTabs parTab, List parList)
	{
		parList.add(new ItemStack(parItem, 1, 0));     
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack par1ItemStack, int parColorType)
	{
		return (parColorType == 0) ? colorBase : colorSpots;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack)
	{
		return "Spawn " + entityLanguageName;
	}  


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
		theIcon = par1IconRegister.registerIcon(getIconString() + "_overlay");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int parDamageVal, int parRenderPass)
	{
		return parRenderPass > 0 ? theIcon : super.getIconFromDamageForRenderPass(parDamageVal, parRenderPass);
	}

	public void setColors(int parColorBase, int parColorSpots)
	{
		colorBase = parColorBase;
		colorSpots = parColorSpots;
	}

	public int getColorBase()
	{
		return colorBase;
	}

	public int getColorSpots()
	{
		return colorSpots;
	}

	public void setEntityToSpawnName(String parEntityToSpawnName, String parEntityLanguageName)
	{
		entityToSpawnName = parEntityToSpawnName;
		entityToSpawnNameFull = ModInfo.MODID + "." + entityToSpawnName;
		entityLanguageName = parEntityLanguageName;
	}
}