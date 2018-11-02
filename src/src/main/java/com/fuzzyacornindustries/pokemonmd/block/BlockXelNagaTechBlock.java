package com.fuzzyacornindustries.pokemonmd.block;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockXelNagaTechBlock extends Block
{
	private final static String blockName = "xelnagatechblock";
	
	public IIcon bottom;
	public IIcon top;
	public IIcon front;
	public IIcon back;
	public IIcon left;
	public IIcon right;

	protected BlockXelNagaTechBlock()
	{
		super(Material.rock);
		this.setBlockName(getBlockName());
		this.setBlockTextureName(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "front");
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		
		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		this.setLightLevel(1.0F); // Lightstone would be 1.0F
	}

	static public String getBlockName()
	{
		return blockName;
	}
	
	public void registerBlockIcons(IIconRegister icon)
	{
		bottom = icon.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "bottom");
		top = icon.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "top");
		front = icon.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "front");
		back = icon.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "back");
		left = icon.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "left");
		right = icon.registerIcon(ModInfo.MODID + ":" + getBlockName() + "/" + getBlockName() + "right");
	}
	
	public IIcon getIcon(int side, int meta)
	{
		if(side == 0)
		{
			return bottom;
		}
		else if(side == 1)
		{
			return top;
		}
		else if(side == 2)
		{
			return front;
		}
		else if(side == 3)
		{
			return back;
		}
		else if(side == 4)
		{
			return left;
		}
		else if(side == 5)
		{
			return right;
		}
		else
		{
			return null;
		}
	}

	/**
     * The code that follows correctly creates a texture for a block
     * identicle to a furnace block.
     */
	/**
     * Gets the block's texture. Args: side, meta
     *//*
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.top : (side == 0 ? this.top : (side != meta ? this.blockIcon : this.front));
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     *//*
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.func_149930_e(world, x, y, z);
    }
    
    private void func_149930_e(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
	
	/**
     * Called when the block is placed in the world.
     *//*
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack p_149689_6_)
    {
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }*/
}