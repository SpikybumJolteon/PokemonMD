package com.fuzzyacornindustries.pokemonmd.block;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockVoidGlass extends Block
{
    private final static String blockName = "voidglass";

    public BlockVoidGlass()
    {
        super(Material.glass);
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

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
}