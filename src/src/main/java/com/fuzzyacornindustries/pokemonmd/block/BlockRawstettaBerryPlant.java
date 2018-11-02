package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRawstettaBerryPlant extends CropBlock
{
	String blockName = "rawstettaberryplant";
	
	public static final float growthSpeed = 0.6F;

	public BlockRawstettaBerryPlant()
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
		return PokemonMDItem.rawstettaBerry;
	}

	// this is item harvested from crop
	@Override
	protected Item getDefaultHarvestItemDrop()
	{
		return PokemonMDItem.rawstettaBerry;
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
	public void registerBlockIcons(IIconRegister parIIconRegister)
	{
		this.iconArray = new IIcon[8];
		// seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
		this.iconArray[0] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage0");
		this.iconArray[1] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage0");
		this.iconArray[2] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage1");
		this.iconArray[3] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage1");
		this.iconArray[4] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage1");
		this.iconArray[5] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage2");
		this.iconArray[6] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage2");
		this.iconArray[7] = parIIconRegister.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "_stage3");
	}
}