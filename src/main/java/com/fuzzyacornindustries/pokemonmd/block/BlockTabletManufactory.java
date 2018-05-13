package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.gui.PokemonMDGuiHandler;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.tileentity.interfaces.IPylonPowered;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTabletManufactory extends BlockContainer implements IPylonPowered
{
	private static final String blockName = "tabletmanufactory";

	private final boolean isActive;

	private static boolean keepInventory;
	private final Random random = new Random();

	public static boolean isPowered;

	public BlockTabletManufactory(boolean isActive)
	{
		super(Material.rock);

		this.setBlockName(getBlockName());

		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		this.setLightLevel(0.5F); // Lightstone would be 1.0F

		this.isActive = isActive;

		isPowered = false;
	}

	static public String getBlockName()
	{
		return blockName;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) 
	{
		return new TileEntityTabletManufactory();
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
		this.blockIcon = icon.registerIcon(ModInfo.MODID + ":" + "tabletmanufactory/" + "tabletmanufactoryicon");
	}

	public Item getItemDropped(int par1, Random random, int par3)
	{
		return Item.getItemFromBlock(PokemonMDBlock.tabletManufactory);
	}

	public Item getItem(World world, int par2, int par3, int par4)
	{
		return Item.getItemFromBlock(PokemonMDBlock.tabletManufactory);
	}

	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityTabletManufactory();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			player.openGui(PokemonMDMain.modInstance, PokemonMDGuiHandler.guiIDTabletManufactory, world, x, y, z);
		}

		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityPlayer player, ItemStack itemStack)
	{
		if(itemStack.hasDisplayName())
		{
			((TileEntityTabletManufactory)world.getTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
		}
	}

	public static void updateTabletManufactoryBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord)
	{
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

		if(isPylonNearby(worldObj, xCoord, yCoord, zCoord))
		{
			isPowered = true;
		}
		else
		{
			isPowered = false;
		}

		TileEntity tileEntity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;

		if(active)
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, PokemonMDBlock.tabletManufactoryActive);
		}
		else
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, PokemonMDBlock.tabletManufactory);
		}

		keepInventory = false;

		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if(tileEntity != null)
		{
			tileEntity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileEntity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) 
	{
		if (!keepInventory) 
		{
			TileEntityTabletManufactory tileEntity = (TileEntityTabletManufactory) world.getTileEntity(x, y, z);

			if (tileEntity != null) 
			{
				for (int i = 0; i < tileEntity.getSizeInventory(); ++i) 
				{
					ItemStack itemstack = tileEntity.getStackInSlot(i);

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

	public boolean hasComparatorInputOverride()
	{
		return true;
	}

	public int getComparatorInputOverride(World world, int x, int y, int z, int i)
	{
		return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
	}
}