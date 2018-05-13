package com.fuzzyacornindustries.pokemonmd.block;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemMysticInitializer;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityPrototurret;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPrototurret extends BlockContainer
{
	private static final String blockName = "prototurret";
	
	public BlockPrototurret()
	{
		super(Material.rock);

		this.setBlockBounds(1F/16F*2F, 1F/16F*3F, 1F/16F*3F, 1F - 1F/16F*3F, 1F - 1F/16F*3F, 1F - 1F/16F*3F);
		
		this.setBlockName(getBlockName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDTurrets);
		
		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		//this.setLightLevel(0.5F); // Lightstone would be 1.0F
	}

	static public String getBlockName()
	{
		return blockName;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) 
	{
		return new TileEntityPrototurret();
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
        this.blockIcon = icon.registerIcon(ModInfo.MODID + ":" + "prototurreticon");
    }
	/*
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{	
		//player.openGui(MainRegistry.modInstance, PokemonMDGuiHandler.guiIDMicroFilter, world, x, y, z);

		if (!world.isRemote && player.inventory.getCurrentItem().getItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemMysticInitializer)
        {
            EntityPrototurret prototurret = new EntityPrototurret(world);
            prototurret.setLocationAndAngles((double)x + 0.5D, (double)y, (double)z + 0.5D, 0.0F, 0.0F);
            world.spawnEntityInWorld(prototurret);
            prototurret.spawnExplosionParticle();
            
            prototurret.func_152115_b(player.getUniqueID().toString());
            
            this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            world.setBlockToAir(x, y, z);

    		return true;
        }
        //super.onBlockDestroyedByPlayer(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
		
		return false;
	}*/
	
	/*
	@SuppressWarnings("unused")
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 6.0F / 16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;
		
		world.spawnParticle("instantSpell", (double) (xx), (double) yy, (double) (zz), 0.0F, 0.0F, 0.0F);
		//world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
	}*/
}