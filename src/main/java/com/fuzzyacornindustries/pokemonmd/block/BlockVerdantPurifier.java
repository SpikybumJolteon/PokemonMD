package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.interfaces.IPylonPowered;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVerdantPurifier extends BlockContainer implements IPylonPowered
{	
	private static final String blockName = "verdantpurifier";

	private static boolean isPurifying;
	private final boolean isActivePurifier;

	public static boolean isPowered;

	private final Random random = new Random();

	protected BlockVerdantPurifier(boolean isActive)
	{
		super(Material.rock);
		isActivePurifier = isActive;

		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		this.setLightLevel(0.2F); // Lightstone would be 1.0F

		isPowered = false;
	}

	static public String getBlockName()
	{
		return blockName;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) 
	{
		if(!world.isRemote)
		{
			player.openGui(PokemonMDMain.modInstance, 0, world, x, y, z);
		}

		return true;
	}

	public Item getItemDropped(int par1, Random random, int par3)
	{
		return Item.getItemFromBlock(PokemonMDBlock.verdantPurifier);
	}

	public Item getItem(World world, int x, int y, int z)
	{
		return Item.getItemFromBlock(PokemonMDBlock.verdantPurifier);
	}

	public TileEntity createNewTileEntity(World world, int par2)
	{
		return new TileEntityVerdantPurifier();
	}

	public int getRenderType()
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(ModInfo.MODID + ":" + "verdantpurifiericon");
	}

	public static void updateBlockState(boolean purifying, World world, int x, int y, int z) 
	{
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);

		isPurifying = true;

		if(isPylonNearby(world, x, y, z))
		{
			isPowered = true;
		}
		else
		{
			isPowered = false;
		}

		if (purifying) 
		{
			world.setBlock(x, y, z, PokemonMDBlock.verdantPurifierActive);
		} 
		else 
		{
			world.setBlock(x, y, z, PokemonMDBlock.verdantPurifier);
		}

		isPurifying = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);

		if (tileentity != null) 
		{
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) 
	{
		if (!isPurifying) 
		{
			TileEntityVerdantPurifier tileentityfurnace = (TileEntityVerdantPurifier) world.getTileEntity(x, y, z);
			if (tileentityfurnace != null) 
			{
				for (int i = 0; i < tileentityfurnace.getSizeInventory(); ++i) 
				{
					ItemStack itemstack = tileentityfurnace.getStackInSlot(i);

					if (itemstack != null) 
					{
						float f = this.random.nextFloat() * 0.6F + 0.1F;
						float f1 = this.random.nextFloat() * 0.6F + 0.1F;
						float f2 = this.random.nextFloat() * 0.6F + 0.1F;

						while (itemstack.stackSize > 0) 
						{
							int j = this.random.nextInt(21) + 10;

							if (j > itemstack.stackSize) 
							{
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;

							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) 
							{
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
							}

							float f3 = 0.025F;

							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);

							world.spawnEntityInWorld(entityitem);
						}
					}
				}

				world.func_147453_f(x, y, z, block);
			}
		}

		super.breakBlock(world, x, y, z, block, meta);
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (this.isActivePurifier && isPylonNearby(world, x, y, z)) 
		{
			float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 6.0F / 16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;

			world.spawnParticle("instantSpell", (double) (xx), (double) yy, (double) (zz), 0.0F, 0.0F, 0.0F);
		}
	}

	public static boolean isPylonNearby(World world, int x, int y, int z)
	{
		for (int l = x - 4; l <= x + 4; ++l)
		{
			for (int i1 = y; i1 <= y + 8; ++i1)
			{
				for (int j1 = z - 4; j1 <= z + 4; ++j1)
				{
					if (world.getBlock(l, i1 - 4, j1) == PokemonMDBlock.xelNagaPylon)
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public void setPylonPoweredState(Boolean isPylonPowered)
	{
		isPowered = isPylonPowered;
	}

	@Override
	public Boolean getPylonPoweredState() 
	{
		return isPowered;
	}
}