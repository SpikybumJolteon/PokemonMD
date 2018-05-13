package com.fuzzyacornindustries.pokemonmd.external.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fuzzyacornindustries.pokemonmd.container.ContainerVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.gui.GuiVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVespeneCondenser;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class VespeneCondenserRecipeHandler extends TemplateRecipeHandler
{
    //public static ArrayList<FuelPair> afuels;
    //public static HashSet<Block> efuels;
    
    public class PurifyingPair extends CachedRecipe
    {
        public PurifyingPair(ItemStack ingred, ItemStack result) 
        {
            ingred.stackSize = 1;
            this.ingred = new PositionedStack(ingred, ContainerVespeneCondenser.smeltItemSlotX - 5, ContainerVespeneCondenser.smeltItemSlotY - 11);
            this.result = new PositionedStack(result, ContainerVespeneCondenser.productItemSlotX - 5, ContainerVespeneCondenser.productItemSlotY - 11);
        }
		
        public List<PositionedStack> getIngredients() 
        {
            return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred));
        }

        public PositionedStack getResult() 
        {
            return result;
        }
/*
        public PositionedStack getOtherStack() 
        {
            return afuels.get((cycleticks / 48) % afuels.size()).stack;
        }
*/
        PositionedStack ingred;
        PositionedStack result;
    }
/*
    public static class FuelPair
    {
        public FuelPair(ItemStack ingred, int burnTime) 
        {
            this.stack = new PositionedStack(ingred, 51, 42, false);
            this.burnTime = burnTime;
        }

        public PositionedStack stack;
        public int burnTime;
    }*/

    @Override
    public void loadTransferRects() 
    {
        //transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "fuel"));
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "condensing"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() 
    {
        return GuiVespeneCondenser.class;
    }

    @Override
    public String getRecipeName() 
    {
        return NEIClientUtils.translate("recipe.vespenecondenser.name");
    }

    @Override
    public TemplateRecipeHandler newInstance() 
    {
        //if (afuels == null || afuels.isEmpty())
            //findFuels();
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) 
    {
        if (outputId.equals("condensing") && getClass() == VespeneCondenserRecipeHandler.class) //don't want subclasses getting a hold of this
        {
            Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) RecipesVespeneCondenser.instance().getCondensingList();
            for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
                arecipes.add(new PurifyingPair(recipe.getKey(), recipe.getValue()));
        } 
        else
            super.loadCraftingRecipes(outputId, results);
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) 
    {
        Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) RecipesVespeneCondenser.instance().getCondensingList();
        for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
            if (NEIServerUtils.areStacksSameType(recipe.getValue(), result))
                arecipes.add(new PurifyingPair(recipe.getKey(), recipe.getValue()));
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients) 
    {
        //if (inputId.equals("fuel") && getClass() == VespeneCondenserRecipeHandler.class)//don't want subclasses getting a hold of this
          //  loadCraftingRecipes("purifying");
        //else
            super.loadUsageRecipes(inputId, ingredients);
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) 
    {
        Map<ItemStack, ItemStack> recipes = (Map<ItemStack, ItemStack>) RecipesVespeneCondenser.instance().getCondensingList();
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
        return ModInfo.MODID + ":" +"textures/guis/vespenecondensergui.png";
    }

    @Override
    public void drawExtras(int recipe) 
    {
        drawProgressBar(GuiVespeneCondenser.cookIconDrawX - 5, GuiVespeneCondenser.cookIconDrawY - 11, 
        		GuiVespeneCondenser.cookIconStartX, GuiVespeneCondenser.cookIconStartY, 
        		GuiVespeneCondenser.cookIconWidth, GuiVespeneCondenser.cookIconHeight, 
        		48, 0);
    }
/*
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
/*
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
*/
    @Override
    public String getOverlayIdentifier() 
    {
        return "condensing";
    }
}