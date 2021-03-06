package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaPylon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockXelNagaPylon extends BlockContainer
{
	private static final String blockName = "xelnagapylon";
	
	public BlockXelNagaPylon()
	{
		super(Material.rock);

		this.setBlockName(getBlockName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		
		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		this.setLightLevel(0.5F); // Lightstone would be 1.0F
	}

	static public String getBlockName()
	{
		return blockName;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) 
	{
		return new TileEntityXelNagaPylon();
	}

	public int getRenderType()
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":" + "xelnagapylonicon");
    }
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 6.0F / 16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;
		
		world.spawnParticle("instantSpell", (double) (xx), (double) yy, (double) (zz), 0.0F, 0.0F, 0.0F);
	}
}