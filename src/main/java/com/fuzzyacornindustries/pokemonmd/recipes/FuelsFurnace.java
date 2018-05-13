package com.fuzzyacornindustries.pokemonmd.recipes;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.common.IFuelHandler;

public class FuelsFurnace implements IFuelHandler
{
	private static final ItemStack INFERNO_FUEL_ROD = new ItemStack(PokemonMDItem.infernoFuelRod);
	private static final ItemStack ABYSSAL_LIQUID_CRYSTAL = new ItemStack(PokemonMDItem.abyssalLiquidCrystal);

	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.isItemEqual(INFERNO_FUEL_ROD))
		{
			return TileEntityFurnace.getItemBurnTime(new ItemStack(Items.coal)) * 2;
		}
		else if (fuel.isItemEqual(ABYSSAL_LIQUID_CRYSTAL))
		{
			return TileEntityFurnace.getItemBurnTime(new ItemStack(Items.coal)) * 4;
		}

		return 0;
	}
}