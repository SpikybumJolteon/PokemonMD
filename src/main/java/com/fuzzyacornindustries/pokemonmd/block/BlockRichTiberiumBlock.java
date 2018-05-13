package com.fuzzyacornindustries.pokemonmd.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class BlockRichTiberiumBlock extends Block
{
    private final static String blockName = "richtiberiumblock";

    public BlockRichTiberiumBlock()
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