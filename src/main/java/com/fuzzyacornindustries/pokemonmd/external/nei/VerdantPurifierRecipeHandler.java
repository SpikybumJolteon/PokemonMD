package com.fuzzyacornindustries.pokemonmd.external.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

import com.fuzzyacornindustries.pokemonmd.gui.GuiVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.recipes.FuelsVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;

public class VerdantPurifierRecipeHandler extends TemplateRecipeHandler
{
    public static ArrayList<FuelPair> afuels;
    public static HashSet<Block> efuels;
    
    public class PurifyingPair extends CachedRecipe
    {
        public PurifyingPair(ItemStack ingred, ItemStack result) 
        {
            ingred.stackSize = 1;
            this.ingred = new PositionedStack(ingred, 51, 6);
            this.result = new PositionedStack(result, 111, 24);
        }

        public List<PositionedStack> getIngredients() 
        {
            return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred));
        }

        public PositionedStack getResult() 
        {
            return result;
        }

        public PositionedStack getOtherStack() 
        {
            return afuels.get((cycleticks / 48) % afuels.size()).stack;
        }

        PositionedStack ingred;
        PositionedStack result;
    }

    public static class FuelPair
    {
        public FuelPair(ItemStack ingred, int burnTime) 
        {
            this.stack = new PositionedStack(ingred, 51, 42, false);
            this.burnTime = burnTime;
        }

        public PositionedStack stack;
        public int burnTime;
    }

    @Override
    public void loadTransferRects() 
    {
        transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "purifierfuel"));
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "purifying"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() 
    {
        return GuiVerdantPurifier.class;
    }

    @Override
    public String getRecipeName() 
    {
        return NEIClientUtils.translate("recipe.verdantpurifier.name");
    }

    @Override
    public TemplateRecipeHandler newInstance() 
    {
        if (afuels == null || afuels.isEmpty())
            findFuels();
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) 
    {
        if (outputId.equals("purifying") && getClass() == VerdantPurifierRecipeHandler.class) //don't want subclasses getting a hold of this
        {
            Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) RecipesVerdantPurifier.instance().getPurifyingList();
            for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
                arecipes.add(new PurifyingPair(recipe.getKey(), recipe.getValue()));
        } 
        else
            super.loadCraftingRecipes(outputId, results);
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) 
    {
        Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) RecipesVerdantPurifier.instance().getPurifyingList();
        for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
            if (NEIServerUtils.areStacksSameType(recipe.getValue(), result))
                arecipes.add(new PurifyingPair(recipe.getKey(), recipe.getValue()));
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) 
    {
        if (inputId.equals("purifierfuel") && getClass() == VerdantPurifierRecipeHandler.class)//don't want subclasses getting a hold of this
            loadCraftingRecipes("purifying");
        else
            super.loadUsageRecipes(inputId, ingredients);
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) 
    {
        Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) RecipesVerdantPurifier.instance().getPurifyingList();
        for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
            if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) 
            {
            	PurifyingPair arecipe = new PurifyingPair(recipe.getKey(), recipe.getValue());
                arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
                arecipes.add(arecipe);
            }
    }

    @Override
    public String getGuiTexture() 
    {
        return ModInfo.MODID + ":" +"textures/guis/verdantpurifiergui.png";
    }

    @Override
    public void drawExtras(int recipe) 
    {
        drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
        drawProgressBar(74, 23, 176, 14, 24, 16, 48, 0);
    }

    private static Set<Item> excludedFuels() 
    {
        Set<Item> efuels = new HashSet<Item>();
        efuels.add(Item.getItemFromBlock(Blocks.brown_mushroom));
        efuels.add(Item.getItemFromBlock(Blocks.red_mushroom));
        efuels.add(Item.getItemFromBlock(Blocks.standing_sign));
        efuels.add(Item.getItemFromBlock(Blocks.wall_sign));
        efuels.add(Item.getItemFromBlock(Blocks.wooden_door));
        efuels.add(Item.getItemFromBlock(Blocks.trapped_chest));
        return efuels;
    }

    private static void findFuels() 
    {
        afuels = new ArrayList<FuelPair>();
        Set<Item> efuels = excludedFuels();
        for (ItemStack item : ItemList.items)
            if (!efuels.contains(item.getItem())) 
            {
                int burnTime = FuelsVerdantPurifier.instance().getVerdantPurifierFuelTime(item);
                if (burnTime > 0)
                    afuels.add(new FuelPair(item.copy(), burnTime));
            }
    }

    @Override
    public String getOverlayIdentifier() 
    {
        return "purifying";
    }
}