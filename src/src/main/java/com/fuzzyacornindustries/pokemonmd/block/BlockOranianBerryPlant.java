package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOranianBerryPlant extends CropBlock
{
	String blockName = "oranianberryplant";

	public static final float growthSpeed = 2.0F;

	public BlockOranianBerryPlant()
	{
		super(growthSpeed);

		this.setBlockName(blockName);
		this.setBlockTextureName(ModInfo.MODID + ":" + getBlockName() + "_stage0");
	}

	public String getBlockName()
	{
		return blockName;
	}

	// this is seed item for the crop
	@Override
	protected Item getDefaultSeedItemDrop()
	{
		return PokemonMDItem.oranianBerry;
	}

	// this is item harvested from crop
	@Override
	protected Item getDefaultHarvestItemDrop()
	{
		Random rand = new Random();

		int i = rand.nextInt(15);

		if(i == 1)
		{
			return PokemonMDItem.reviveSeed;
		}

		return PokemonMDItem.oranianBerry;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random randomVal)
	{
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister blockMetadata)
	{
		this.iconArray = new IIcon[8];
		// seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
		this.iconArray[0] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage0");
		this.iconArray[1] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage0");
		this.iconArray[2] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage1");
		this.iconArray[3] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage1");
		this.iconArray[4] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage1");
		this.iconArray[5] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage2");
		this.iconArray[6] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage2");
		this.iconArray[7] = blockMetadata.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage3");
	}
}