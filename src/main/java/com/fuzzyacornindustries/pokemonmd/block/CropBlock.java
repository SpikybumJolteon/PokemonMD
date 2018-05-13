package com.fuzzyacornindustries.pokemonmd.block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class CropBlock extends BlockBush implements IGrowable
{
	@SideOnly(Side.CLIENT)
	protected IIcon[] iconArray;
	
	protected float growthSpeedModifier;
	
	public CropBlock(float growthSpeedModifier)
	{
		// Basic block setup
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab((CreativeTabs)null);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
		
		this.growthSpeedModifier = growthSpeedModifier;
	}
	
	/**
	 * is the block grass, dirt or farmland
	 */
	@Override
	protected boolean canPlaceBlockOn(Block soilBlock)
	{
		return soilBlock == Blocks.farmland;
	}

	@Override
	public void updateTick(World world, int xCoord, int yCoord, int zCoord, Random randomPar)
	{
		super.updateTick(world, xCoord, yCoord, zCoord, randomPar);

		if (world.getBlockLightValue(xCoord, yCoord + 1, zCoord) >= 9)
		{
			int l = world.getBlockMetadata(xCoord, yCoord, zCoord);

			if (l < 7)
			{
				float f = this.getGrowthIncrease(world, xCoord, yCoord, zCoord);

				if (randomPar.nextInt((int)(25.0F / f) + 1) == 0)
				{
					++l;
					world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, l, 2);
				}
			}
		}
	}
	
	public void setBlockMetadata(World world, int xCoord, int yCoord, int zCoord)
	{
		int l = world.getBlockMetadata(xCoord, yCoord, zCoord) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);

		if (l > 7)
		{
			l = 7;
		}

		world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, l, 2);
	}

	private float getGrowthIncrease(World world, int xCoord, int yCoord, int zCoord)
	{
		float f = 1.0F;
		Block block = world.getBlock(xCoord, yCoord, zCoord - 1);
		Block block1 = world.getBlock(xCoord, yCoord, zCoord + 1);
		Block block2 = world.getBlock(xCoord - 1, yCoord, zCoord);
		Block block3 = world.getBlock(xCoord + 1, yCoord, zCoord);
		Block block4 = world.getBlock(xCoord - 1, yCoord, zCoord - 1);
		Block block5 = world.getBlock(xCoord + 1, yCoord, zCoord - 1);
		Block block6 = world.getBlock(xCoord + 1, yCoord, zCoord + 1);
		Block block7 = world.getBlock(xCoord - 1, yCoord, zCoord + 1);
		boolean flag = block2 == this || block3 == this;
		boolean flag1 = block == this || block1 == this;
		boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

		for (int l = xCoord - 1; l <= xCoord + 1; ++l)
		{
			for (int i1 = zCoord - 1; i1 <= zCoord + 1; ++i1)
			{
				float f1 = 0.0F;

				if (world.getBlock(l, yCoord - 1, i1).canSustainPlant(world, l, yCoord - 1, i1, ForgeDirection.UP, this))
				{
					f1 = 1.0F;

					if (world.getBlock(l, yCoord - 1, i1).isFertile(world, l, yCoord - 1, i1))
					{
						f1 = 3.0F;
					}
				}

				if (l != xCoord || i1 != zCoord)
				{
					f1 /= 4.0F;
				}

				f += f1 * growthSpeedModifier;
			}
		}

		if (flag2 || flag && flag1)
		{
			f /= 2.0F;
		}

		return f;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int iconIDNumber)
	{
		if (iconIDNumber < 0 || iconIDNumber > 7)
		{
			iconIDNumber = 7;
		}

		return this.iconArray[iconIDNumber];
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return 1; // Cross like flowers
	}

	// identifies which seeds (ItemSeed or ItemSeedFood type) can grow this
	protected Item getDefaultSeedItemDrop()
	{
		return Items.wheat_seeds;
	}

	// identifies what food (ItemFood or ItemSeedFood type) is harvested from this
	protected Item getDefaultHarvestItemDrop()
	{
		return Items.wheat;
	}

	/**
	 * Drops the block items with a specified chance of dropping the specified items
	 */
	@Override
	public void dropBlockAsItemWithChance(World world, int xCoord, int yCoord, int zCoord, int p_149690_5_, float p_149690_6_, int p_149690_7_)
	{
		super.dropBlockAsItemWithChance(world, xCoord, yCoord, zCoord, p_149690_5_, p_149690_6_, 0);
	}

	@Override
	public Item getItemDropped(int blockMetadata, Random randomPar, int p_149650_3_)
	{
		return blockMetadata == 7 ? this.getDefaultHarvestItemDrop() : this.getDefaultSeedItemDrop();
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random randomPar)
	{
		return 1;
	}

	@Override
	public boolean func_149851_a(World world, int xCoord, int yCoord, int zCoord, boolean booleanPar)
	{
		return world.getBlockMetadata(xCoord, yCoord, zCoord) != 7;
	}

	@Override
	public boolean func_149852_a(World world, Random randomVal, int p_149852_3_, int p_149852_4_, int p_149852_5_)
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int xCoord, int yCoord, int zCoord)
	{
		return this.getDefaultSeedItemDrop();
	}

	@Override
	public void func_149853_b(World world, Random randomVal, int xCoord, int yCoord, int zCoord)
	{
		this.setBlockMetadata(world, xCoord, yCoord, zCoord);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortuneEnchantmentLevel)
	{
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortuneEnchantmentLevel);

		if (metadata >= 7)
		{
			for (int i = 0; i < 3 + fortuneEnchantmentLevel; ++i)
			{
				if (world.rand.nextInt(15) <= metadata)
				{
					ret.add(new ItemStack(this.getDefaultSeedItemDrop(), 1, 0));
				}
			}
		}

		return ret;
	}
}