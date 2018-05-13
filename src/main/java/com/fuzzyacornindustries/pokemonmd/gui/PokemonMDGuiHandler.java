package com.fuzzyacornindustries.pokemonmd.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.container.ContainerPrototurret;
import com.fuzzyacornindustries.pokemonmd.container.ContainerTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.container.ContainerVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.container.ContainerVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;

import cpw.mods.fml.common.network.IGuiHandler;

public class PokemonMDGuiHandler implements IGuiHandler
{
	public static final int guiIDVerdantPurifier = 0;
	public static final int guiIDVespeneCondenser = 1;
	public static final int guiIDTabletManufactory = 2;
	public static final int guiIDPrototurret = 3;

	public PokemonMDGuiHandler () {}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if(tileEntity != null)
		{
			switch(ID)
			{
			case guiIDVerdantPurifier:
			{
				if(tileEntity instanceof TileEntityVerdantPurifier)
				{
					return new ContainerVerdantPurifier(player.inventory, (TileEntityVerdantPurifier)tileEntity);
				}
			}
			case guiIDVespeneCondenser:
			{
				if(tileEntity instanceof TileEntityVespeneCondenser)
				{
					return new ContainerVespeneCondenser(player.inventory, (TileEntityVespeneCondenser)tileEntity);
				}
			}
			case guiIDTabletManufactory:
			{
				if(tileEntity instanceof TileEntityTabletManufactory)
				{
					return new ContainerTabletManufactory(player.inventory, (TileEntityTabletManufactory)tileEntity);
				}
			}/*
			case guiIDMicroFilter:
			{
				if(tileEntity instanceof TileEntityMicroFilter)
				{
					return new ContainerMicroFilter(player.inventory, (TileEntityMicroFilter)tileEntity);
				}
			}
			 */
			}
		}

		// int x is used to pass on the EntityID if it is not a TileEntity.
		int entityID = x;
		
		if(ID == guiIDPrototurret)
		{
				return new ContainerPrototurret(player.inventory, (EntityPrototurret)world.getEntityByID(entityID));
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if(tileEntity != null)
		{
			switch(ID)
			{
			case guiIDVerdantPurifier:
			{
				if(tileEntity instanceof TileEntityVerdantPurifier)
				{
					return new GuiVerdantPurifier(player.inventory, (TileEntityVerdantPurifier)tileEntity);
				}
			}
			case guiIDVespeneCondenser:
			{
				if(tileEntity instanceof TileEntityVespeneCondenser)
				{
					return new GuiVespeneCondenser(player.inventory, (TileEntityVespeneCondenser)tileEntity);
				}
			}
			case guiIDTabletManufactory:
			{
				if(tileEntity instanceof TileEntityTabletManufactory)
				{
					return new GuiTabletManufactory(player.inventory, (TileEntityTabletManufactory)tileEntity);
				}
			}
			/*
			case guiIDMicroFilter:
			{
				if(tileEntity instanceof TileEntityMicroFilter)
				{
					return new GuiMicroFilter(player.inventory, (TileEntityMicroFilter)tileEntity);
				}
			}
			 */
			}
		}
		
		// int x is used to pass on the EntityID if it is not a TileEntity.
		int entityID = x;

		if(ID == guiIDPrototurret)
		{
			return new GuiPrototurret(player.inventory, (EntityPrototurret)world.getEntityByID(entityID));
		}
		
		return null;
	}
}