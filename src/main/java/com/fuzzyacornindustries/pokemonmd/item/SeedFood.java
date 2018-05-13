package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class SeedFood extends ItemFood implements IPlantable
{
	private Block berryBlock;
	
	/**
	 * Block ID of the soil this seed food should be planted on.
	 */
	private Block soilId;
	
	public SeedFood(int healAmount, float saturation, Block berryBlock, Block soilBlock)
	{
		super(healAmount, saturation, false);
		this.berryBlock = berryBlock;
		this.soilId = soilBlock;
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	@Override
	public boolean onItemUse(ItemStack heldItemStack, EntityPlayer player, World world, int xCoord, int yCoord, int zCoord, int par7, float par8, float par9, float par10)
	{
		if (par7 != 1)
		{
			return false;
		}
		else if (player.canPlayerEdit(xCoord, yCoord, zCoord, par7, heldItemStack) && player.canPlayerEdit(xCoord, yCoord + 1, zCoord, par7, heldItemStack))
		{
			if (world.getBlock(xCoord, yCoord, zCoord).canSustainPlant(world, xCoord, yCoord, zCoord, ForgeDirection.UP, this) && world.isAirBlock(xCoord, yCoord + 1, zCoord))
			{
				world.setBlock(xCoord, yCoord + 1, zCoord, this.berryBlock);
				--heldItemStack.stackSize;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z)
	{
		return berryBlock;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		return 0;
	}
}