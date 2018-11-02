package com.fuzzyacornindustries.pokemonmd.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNeoTiberiumBricks extends Block
{
    private final static String blockName = "neotiberiumbricks";

    public BlockNeoTiberiumBricks()
    {
        super(Material.rock);
		this.setBlockName(getBlockName());
        this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		this.setBlockTextureName(ModInfo.MODID + ":" + getBlockName());
		
		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(100.0F);
		this.setLightLevel(0.5F); // Lightstone would be 1.0F
    }

	static public String getBlockName()
	{
		return blockName;
	}
}