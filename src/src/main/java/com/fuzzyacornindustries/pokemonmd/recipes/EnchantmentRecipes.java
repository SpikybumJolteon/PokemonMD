package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class EnchantmentRecipes extends ShapelessRecipes implements IRecipe
{
	/** Is the ItemStack that you get when craft the recipe. */
	private final ItemStack recipeOutput;
	/** Is a List of ItemStack that composes the recipe. */
	public final List recipeItems;

	public EnchantmentRecipes(ItemStack itemStack, List list)
	{
		super(itemStack, list);

		this.recipeOutput = itemStack;
		this.recipeItems = list;
	}

	public ItemStack getRecipeOutput()
	{
		return this.recipeOutput;
	}

	/**
	 * Used to check if a recipe matches current crafting inventory
	 *//*
	@Override
	public boolean matches(InventoryCrafting craftingInventory, World p_77569_2_)
	{
		ArrayList arraylist = new ArrayList(this.recipeItems);

		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 3; ++j)
			{
				ItemStack itemstack = craftingInventory.getStackInRowAndColumn(j, i);

				if (itemstack != null)
				{
					boolean flag = false;
					Iterator iterator = arraylist.iterator();

					while (iterator.hasNext())
					{
						ItemStack itemstack1 = (ItemStack)iterator.next();

						if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage()))
						{
							flag = true;
							arraylist.remove(itemstack1);
							break;
						}
					}

					if (!flag)
					{
						return false;
					}
				}
			}
		}

		return arraylist.isEmpty();
	}*/

	/**
	 * Returns an Item that is the result of this recipe
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting craftingInventory)
	{
		ItemStack itemStackToEnchant;

		Map map;

		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 3; ++j)
			{
				if(craftingInventory.getStackInRowAndColumn(j, i) != null)
				{
					ItemStack itemStack = craftingInventory.getStackInRowAndColumn(j, i);

					if(itemStack.isItemEnchanted())
					{
						itemStackToEnchant = this.recipeOutput;

						map = EnchantmentHelper.getEnchantments(craftingInventory.getStackInRowAndColumn(j, i));

						EnchantmentHelper.setEnchantments(map, itemStackToEnchant);

						return itemStackToEnchant.copy();
					}
				}
			}
		}

		return this.recipeOutput.copy();
	}
}