package com.fuzzyacornindustries.pokemonmd.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNeoTiberiumBlock extends Block
{
    private final static String blockName = "neotiberiumblock";

    public BlockNeoTiberiumBlock()
    {
        super(Material.rock);
		this.setBlockName(getBlockName());
        this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		this.setBlockTextureName(ModInfo.MODID + ":" + getBlockName());
		
		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		this.setLightLevel(0.5F); // Lightstone would be 1.0F
    }

	static public String getBlockName()
	{
		return blockName;
	}
	/*
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Bricks with high");
		parList.add("blast resistance.");
	}*/
}