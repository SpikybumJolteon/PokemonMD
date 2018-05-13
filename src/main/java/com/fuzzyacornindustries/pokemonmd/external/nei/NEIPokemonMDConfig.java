package com.fuzzyacornindustries.pokemonmd.external.nei;

import java.util.HashMap;
import java.util.Set;

import com.fuzzyacornindustries.pokemonmd.container.ContainerTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesTabletManufactory;

import java.util.Map.Entry;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.ICraftingHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class NEIPokemonMDConfig implements IConfigureNEI
{	
	private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> tabletManufactoryRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();

	@Override
	public void loadConfig() 
	{
		this.registerRecipes();

		API.registerRecipeHandler(new VerdantPurifierRecipeHandler());
		API.registerUsageHandler(new VerdantPurifierRecipeHandler());

		API.registerRecipeHandler(new VespeneCondenserRecipeHandler());
		API.registerUsageHandler(new VespeneCondenserRecipeHandler());

		API.registerRecipeHandler(new VerdantPurifierFuelHandler());
		API.registerUsageHandler(new VerdantPurifierFuelHandler());

		API.registerRecipeHandler(new TabletManufactoryRecipeHandler());
		API.registerUsageHandler(new TabletManufactoryRecipeHandler());
	}

	@Override
	public String getName() 
	{
		return "PokemonMD NEI Plugin";
	}

	@Override
	public String getVersion() 
	{
		return "Alpha 0.0";
	}

	public void registerTabletManufactoryRecipe(HashMap<Integer, PositionedStack> input, PositionedStack output)
	{
		NEIPokemonMDConfig.tabletManufactoryRecipes.put(input, output);
	}

	public static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getTabletManufactoryRecipes()
	{
		return NEIPokemonMDConfig.tabletManufactoryRecipes.entrySet();
	}

	public void registerRecipes()
	{
		this.addTabletManufactoryRecipes();
	}

	private void addTabletManufactoryRecipes()
	{
		int slotPositionArray[][] = new int[8][2];
		
		slotPositionArray[0][0] = ContainerTabletManufactory.sideItemsLftColumnX;
		slotPositionArray[0][1] = ContainerTabletManufactory.sideItemsRow1Y;

		slotPositionArray[1][0] = ContainerTabletManufactory.tabletItemSlotX;
		slotPositionArray[1][1] = ContainerTabletManufactory.tabletItemSlotY;

		slotPositionArray[2][0] = ContainerTabletManufactory.sideItemsRtColumnX;
		slotPositionArray[2][1] = ContainerTabletManufactory.sideItemsRow1Y;

		slotPositionArray[3][0] = ContainerTabletManufactory.sideItemsLftColumnX;
		slotPositionArray[3][1] = ContainerTabletManufactory.sideItemsRow2Y;

		slotPositionArray[4][0] = ContainerTabletManufactory.fuelItemSlotX;
		slotPositionArray[4][1] = ContainerTabletManufactory.fuelItemSlotY;

		slotPositionArray[5][0] = ContainerTabletManufactory.sideItemsRtColumnX;
		slotPositionArray[5][1] = ContainerTabletManufactory.sideItemsRow2Y;
		
		slotPositionArray[6][0] = ContainerTabletManufactory.sideItemsLftColumnX;
		slotPositionArray[6][1] = ContainerTabletManufactory.sideItemsRow3Y;

		slotPositionArray[7][0] = ContainerTabletManufactory.sideItemsRtColumnX;
		slotPositionArray[7][1] = ContainerTabletManufactory.sideItemsRow3Y;
		
		int adjustmentX = 2;
		
		for (int i = 0; i < RecipesTabletManufactory.getRecipeList().size(); i++)
		{
			HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();
			IRecipe rec = RecipesTabletManufactory.getRecipeList().get(i);

			if (rec instanceof ShapedRecipes)
			{
				ShapedRecipes recipe = (ShapedRecipes) rec;

				for (int j = 0; j < recipe.recipeItems.length; j++)
				{
					/*
            		System.out.println( "Test NEI Recipe Adding" );
            		for(int k = 0; k < recipe.recipeItems.length; k++)
            		{
            			if(recipe.recipeItems != null)
            			{
            				System.out.println( recipe.recipeItems[k].getDisplayName() );
            			}
            			else
            			{
            			System.out.println( "Slot: " + k + " is Null" );
            			}
            		}*/

					if(recipe.recipeItems[j] != null)
					{
						ItemStack stack = recipe.recipeItems[j];

						input1.put(j, new PositionedStack(stack, slotPositionArray[j][0] - adjustmentX, slotPositionArray[j][1]));
					}
				}
			}

			this.registerTabletManufactoryRecipe(input1, new PositionedStack(rec.getRecipeOutput(), ContainerTabletManufactory.productItemSlotX - adjustmentX, ContainerTabletManufactory.productItemSlotY));
		}
	}
}