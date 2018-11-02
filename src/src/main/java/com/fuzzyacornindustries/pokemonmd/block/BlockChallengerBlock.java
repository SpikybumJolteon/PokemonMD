package com.fuzzyacornindustries.pokemonmd.block;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockChallengerBlock extends Block
{
    private final static String blockName = "challengerblock";

    public BlockChallengerBlock()
    {
        super(Material.iron);
		this.setBlockName(getBlockName());
        this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		this.setBlockTextureName(ModInfo.MODID + ":" + getBlockName());
		
		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(100.0F);
    }

	static public String getBlockName()
	{
		return blockName;
	}
}