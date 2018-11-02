package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipesTabletManufactory 
{
	private static List<IRecipe> recipes = new ArrayList<IRecipe>();

    public static ShapedRecipes addRecipe(ItemStack output, Object... inputList)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (inputList[i] instanceof String[])
        {
            String[] astring = (String[]) inputList[i++];

            for (String s1 : astring)
            {
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (inputList[i] instanceof String)
            {
                String s2 = (String) inputList[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap<Character, ItemStack> hashmap;

        for (hashmap = new HashMap<Character, ItemStack>(); i < inputList.length; i += 2)
        {
            Character character = (Character) inputList[i];
            ItemStack itemstack1 = null;

            if (inputList[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item) inputList[i + 1]);
            }
            else if (inputList[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block) inputList[i + 1], 1, 32767);
            }
            else if (inputList[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack) inputList[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = hashmap.get(Character.valueOf(c0)).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, output);
        RecipesTabletManufactory.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public static ItemStack findMatchingRecipe(IInventory inventory, World par2World)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < inventory.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = inventory.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            int k = itemstack.getItem().getMaxDamage() - itemstack.getItemDamageForDisplay();
            int l = itemstack.getItem().getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int i1 = k + l + itemstack.getItem().getMaxDamage() * 5 / 100;
            int j1 = itemstack.getItem().getMaxDamage() - i1;

            if (j1 < 0)
            {
                j1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, j1);
        }
        else
        {
            for (j = 0; j < RecipesTabletManufactory.recipes.size(); ++j)
            {
                IRecipe irecipe = RecipesTabletManufactory.recipes.get(j);

                if (irecipe instanceof ShapedRecipes && RecipesTabletManufactory.matches((ShapedRecipes) irecipe, inventory, par2World))
                {
                    return irecipe.getRecipeOutput().copy();
                }
            }

            return null;
        }
    }

    private static boolean matches(ShapedRecipes recipe, IInventory inventory, World par2World)
    {
        for (int i = 0; i <= 3 - recipe.recipeWidth; ++i)
        {
            for (int j = 0; j <= 3 - recipe.recipeHeight; ++j)
            {
                if (RecipesTabletManufactory.checkMatch(recipe, inventory, i, j, true))
                {
                    return true;
                }

                if (RecipesTabletManufactory.checkMatch(recipe, inventory, i, j, false))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkMatch(ShapedRecipes recipe, IInventory inventory, int par2, int par3, boolean par4)
    {
        for (int k = 0; k < 3; ++k)
        {
            for (int l = 0; l < 3; ++l)
            {
                int i1 = k - par2;
                int j1 = l - par3;
                ItemStack itemstack = null;

                if (i1 >= 0 && j1 >= 0 && i1 < recipe.recipeWidth && j1 < recipe.recipeHeight)
                {
                    if (par4)
                    {
                        itemstack = recipe.recipeItems[recipe.recipeWidth - i1 - 1 + j1 * recipe.recipeWidth];
                    }
                    else
                    {
                        itemstack = recipe.recipeItems[i1 + j1 * recipe.recipeWidth];
                    }
                }

                ItemStack itemstack1 = null;

                if (k >= 0 && l < 3)
                {
                    int k2 = k + l * 3;
                    itemstack1 = inventory.getStackInSlot(k2);
                }

                if (itemstack1 != null || itemstack != null)
                {
                    if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
                    {
                        return false;
                    }

                    if (itemstack.getItem() != itemstack1.getItem())
                    {
                        return false;
                    }

                    if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static List<IRecipe> getRecipeList()
    {
        return RecipesTabletManufactory.recipes;
    }
	
	/*
	private static final RecipesTabletManufactory MANUFACTURING_BASE = new RecipesTabletManufactory();

	private Map manufactureList = new HashMap();
	
	public static RecipesTabletManufactory instance() 
	{
		return MANUFACTURING_BASE;
	}
	
	private RecipesTabletManufactory()
	{
		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.clayTablet, PokemonMDItem.vespeneCrystal,
				PokemonMDItem.tiberiumShard, PokemonMDItem.tiberiumShard, 
				Items.spider_eye, Items.spider_eye,
				PokemonMDItem.tiberiumShard, PokemonMDItem.tiberiumShard), 
				new ItemStack(PokemonMDItem.bioCapacitor));

		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.bioCapacitor, PokemonMDItem.vespeneFuelRod,
				PokemonMDItem.richTiberiumShard, PokemonMDItem.richTiberiumShard, 
				Items.spider_eye, Items.spider_eye,
				PokemonMDItem.richTiberiumShard, PokemonMDItem.richTiberiumShard), 
				new ItemStack(PokemonMDItem.bioraCapacitor));

		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.bioraCapacitor, PokemonMDItem.emeraldOfChaos,
				PokemonMDItem.neoTiberiumShard, PokemonMDItem.neoTiberiumShard, 
				Items.spider_eye, Items.spider_eye,
				PokemonMDItem.neoTiberiumShard, PokemonMDItem.neoTiberiumShard), 
				new ItemStack(PokemonMDItem.biogaCapacitor));

		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.clayTablet, PokemonMDItem.vespeneCrystal,
				PokemonMDItem.tiberiumShard, PokemonMDItem.tiberiumShard, 
				Items.blaze_powder, Items.blaze_powder,
				PokemonMDItem.tiberiumShard, PokemonMDItem.tiberiumShard), 
				new ItemStack(PokemonMDItem.fireCapacitor));

		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.fireCapacitor, PokemonMDItem.vespeneFuelRod,
				PokemonMDItem.richTiberiumShard, PokemonMDItem.richTiberiumShard, 
				Items.blaze_powder, Items.blaze_powder,
				PokemonMDItem.richTiberiumShard, PokemonMDItem.richTiberiumShard), 
				new ItemStack(PokemonMDItem.firaCapacitor));

		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.firaCapacitor, PokemonMDItem.emeraldOfChaos,
				PokemonMDItem.neoTiberiumShard, PokemonMDItem.neoTiberiumShard, 
				Items.blaze_powder, Items.blaze_powder,
				PokemonMDItem.neoTiberiumShard, PokemonMDItem.neoTiberiumShard), 
				new ItemStack(PokemonMDItem.firagaCapacitor));

		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.clayTablet, PokemonMDItem.vespeneFuelRod,
				PokemonMDItem.richTiberiumShard, PokemonMDItem.richTiberiumShard, 
				Items.iron_ingot, Items.iron_ingot,
				PokemonMDItem.richTiberiumShard, PokemonMDItem.richTiberiumShard), 
				new ItemStack(PokemonMDItem.barrierDefender));

		this.addRecipe(new TabletManufactoryRecipe(PokemonMDItem.clayTablet, PokemonMDItem.vespeneFuelRod,
				PokemonMDItem.neoTiberiumShard, PokemonMDItem.neoTiberiumShard, 
				PokemonMDItem.xelNagaCircuit, PokemonMDItem.xelNagaCircuit,
				PokemonMDItem.neoTiberiumShard, PokemonMDItem.neoTiberiumShard), 
				new ItemStack(PokemonMDItem.regenUtility));
	}
	
	public void addRecipe(TabletManufactoryRecipe manufactureRecipe, ItemStack itemstack)
	{
		this.manufactureList.put(manufactureRecipe, itemstack);
	}

	public ItemStack getManufactureResult(TabletManufactoryRecipe manufactureRecipe) 
	{
		Iterator iterator = this.manufactureList.entrySet().iterator();
		Entry entry;
		
		do 
		{
			if (!iterator.hasNext()) 
			{
				return null;
			}
			
			entry = (Entry) iterator.next();
		} 
		while (!canBeManufactured(manufactureRecipe, (TabletManufactoryRecipe) entry.getKey()));
		
		return (ItemStack) entry.getValue();
	}

    public Map getManufacturingList()
    {
        return manufactureList;
    }

    
	private boolean canBeManufactured(TabletManufactoryRecipe manufactureRecipe, TabletManufactoryRecipe manufactureRecipe2)
	{
		return manufactureRecipe.doesMatchRecipe(manufactureRecipe2);
	}*/
}