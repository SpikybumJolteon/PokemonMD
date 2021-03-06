package com.fuzzyacornindustries.pokemonmd.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockChallengerBlock extends ItemBlock 
{
	public ItemBlockChallengerBlock(Block block) 
	{
		super(block);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Block with high");
		parList.add("blast resistance.");
	}
}