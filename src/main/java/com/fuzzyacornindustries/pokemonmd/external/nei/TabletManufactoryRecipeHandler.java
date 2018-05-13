package com.fuzzyacornindustries.pokemonmd.external.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.container.ContainerTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.gui.GuiTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesTabletManufactory;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.FurnaceRecipeHandler.FuelPair;
import codechicken.nei.recipe.TemplateRecipeHandler.CachedRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

public class TabletManufactoryRecipeHandler extends TemplateRecipeHandler
{
	private static final ResourceLocation tabletManufactoryTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/guis/tabletmanufactorygui.png");

	private static int ticksPassed;
	private static int maximumDisplayDuration = 50;

	@Override
	public int recipiesPerPage()
	{
		return 1;
	}

	public Set<Entry<ArrayList<PositionedStack>, PositionedStack>> getRecipes()
	{
		HashMap<ArrayList<PositionedStack>, PositionedStack> recipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

		for (Entry<HashMap<Integer, PositionedStack>, PositionedStack> stack : NEIPokemonMDConfig.getTabletManufactoryRecipes())
		{
			ArrayList<PositionedStack> inputStacks = new ArrayList<PositionedStack>();

			for (Map.Entry<Integer, PositionedStack> input : stack.getKey().entrySet())
			{
				inputStacks.add(input.getValue());
			}

			recipes.put(inputStacks, stack.getValue());
		}

		return recipes.entrySet();
	}

	public String getRecipeId()
	{
		return "pokemonmd.tabletmanufactory";
	}

	@Override
	public void drawBackground(int i)
	{

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GuiDraw.changeTexture(TabletManufactoryRecipeHandler.tabletManufactoryTexture);
		GuiDraw.drawTexturedModalRect(24, 15, 26, 15, 125, 54);

		int showProgressWidth =  (int)((TabletManufactoryRecipeHandler.ticksPassed % (float)maximumDisplayDuration)  / (float)maximumDisplayDuration * (float)GuiTabletManufactory.manufactureIconWidth);

		GuiDraw.drawTexturedModalRect(GuiTabletManufactory.manufactureIconDrawX - 2, GuiTabletManufactory.manufactureIconDrawY, 
				GuiTabletManufactory.manufactureIconStartX, GuiTabletManufactory.manufactureIconStartY, 
				showProgressWidth, GuiTabletManufactory.manufactureIconHeight);


		/*
		k = this.tabletManufactory.getManufactureProgressScaled(manufactureIconWidth);
		this.drawTexturedModalRect(guiLeft + manufactureIconDrawX, guiTop + manufactureIconDrawY, 
				manufactureIconStartX, manufactureIconStartY, 
				k, manufactureIconHeight);
/*
        if (TabletManufactoryRecipeHandler.ticksPassed % 70 > 26)
        {
            GuiDraw.drawTexturedModalRect(103, 36, 176, 0, 17, 13);
        }

        GuiDraw.drawTexturedModalRect(79, 44, 176, 13, Math.min(TabletManufactoryRecipeHandler.ticksPassed % 70, 53), 17);

        int yOffset = (int) Math.floor(TabletManufactoryRecipeHandler.ticksPassed % 48 * 0.29166666666666666666666666666667D);

        GuiDraw.drawTexturedModalRect(83, 35 + yOffset, 176, 30 + yOffset, 14, 14 - yOffset);*/
	}

	/*
	@Override
	public void loadTransferRects() 
	{
		//transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "fuel"));
		transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "manufacturing"));
	}
	 */
	@Override
	public void onUpdate()
	{
		TabletManufactoryRecipeHandler.ticksPassed += 1;
		super.onUpdate();
	}

	@Override
	public void loadTransferRects()
	{
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if (outputId.equals(this.getRecipeId()))
		{
			for (final Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
			{
				this.arecipes.add(new TabletManufactoryRecipe(irecipe));
			}
		}
		else
		{
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		for (final Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
		{
			if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getValue().item, result))
			{
				this.arecipes.add(new TabletManufactoryRecipe(irecipe));
			}
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (final Map.Entry<ArrayList<PositionedStack>, PositionedStack> irecipe : this.getRecipes())
		{
			for (final PositionedStack pstack : irecipe.getKey())
			{
				if (pstack.contains(ingredient))
				{
					this.arecipes.add(new TabletManufactoryRecipe(irecipe));
					break;
				}
			}
		}
	}

	@Override
	public TemplateRecipeHandler newInstance()
	{
		return super.newInstance();
	}

	@Override
	public ArrayList<PositionedStack> getIngredientStacks(int recipe)
	{
		return (ArrayList<PositionedStack>) this.arecipes.get(recipe).getIngredients();
	}

	@Override
	public PositionedStack getResultStack(int recipe)
	{
		return this.arecipes.get(recipe).getResult();
	}

	public class TabletManufactoryRecipe extends TemplateRecipeHandler.CachedRecipe
	{
		public ArrayList<PositionedStack> input;
		public PositionedStack output;

		@Override
		public ArrayList<PositionedStack> getIngredients()
		{
			return (ArrayList<PositionedStack>) getCycledIngredients(cycleticks / 20, this.input);
		}

		@Override
		public PositionedStack getResult()
		{
			return this.output;
		}

		public TabletManufactoryRecipe(ArrayList<PositionedStack> pstack1, PositionedStack pstack2)
		{
			super();
			this.input = pstack1;
			this.output = pstack2;
		}

		public TabletManufactoryRecipe(Map.Entry<ArrayList<PositionedStack>, PositionedStack> recipe)
		{
			this(new ArrayList<PositionedStack>(recipe.getKey()), recipe.getValue().copy());
		}
		/*
        @Override
        public List<PositionedStack> getOtherStacks()
        {
            ArrayList<PositionedStack> stacks = new ArrayList<PositionedStack>();
            PositionedStack stack = this.getOtherStack();
            if (stack != null)
            {
                stacks.add(stack);
            }
            return stacks;
        }

        @Override
        public PositionedStack getOtherStack()
        {
            return TabletManufactoryRecipeHandler.afuels.get(TabletManufactoryRecipeHandler.ticksPassed / 48 % TabletManufactoryRecipeHandler.afuels.size()).stack;
        }*/
	}

	@Override
	public String getRecipeName() 
	{
		return NEIClientUtils.translate("recipe.tabletmanufactory.name");
	}

	@Override
	public String getGuiTexture() 
	{
		return ModInfo.MODID + ":" +"textures/guis/tabletmanufactorygui.png";
	}

	@Override
	public void drawForeground(int recipe)
	{
	}

	//public static ArrayList<FuelPair> afuels;
	//public static HashSet<Block> efuels;
	/*
	public class ManufacturingSet extends CachedRecipe
	{
		public ManufacturingSet(TabletManufactoryRecipe manufactoringRecipe, ItemStack result) 
		{

			this.tablet = new PositionedStack(manufactoringRecipe.getTablet(), ContainerTabletManufactory.tabletItemSlotX - 5, ContainerTabletManufactory.tabletItemSlotY - 11);
			this.fuel = new PositionedStack(manufactoringRecipe.getFuel(), ContainerTabletManufactory.fuelItemSlotX - 5, ContainerTabletManufactory.fuelItemSlotY - 11);

			this.ingred[0] = new PositionedStack(manufactoringRecipe.getPartOfPartsArray(0), ContainerTabletManufactory.sideItemsLftColumnX, ContainerTabletManufactory.sideItemsRow1Y);
			this.ingred[1] = new PositionedStack(manufactoringRecipe.getPartOfPartsArray(1), ContainerTabletManufactory.sideItemsRtColumnX, ContainerTabletManufactory.sideItemsRow1Y);
			this.ingred[2] = new PositionedStack(manufactoringRecipe.getPartOfPartsArray(2), ContainerTabletManufactory.sideItemsLftColumnX, ContainerTabletManufactory.sideItemsRow2Y);
			this.ingred[3] = new PositionedStack(manufactoringRecipe.getPartOfPartsArray(3), ContainerTabletManufactory.sideItemsRtColumnX, ContainerTabletManufactory.sideItemsRow2Y);
			this.ingred[4] = new PositionedStack(manufactoringRecipe.getPartOfPartsArray(4), ContainerTabletManufactory.sideItemsLftColumnX, ContainerTabletManufactory.sideItemsRow3Y);
			this.ingred[5] = new PositionedStack(manufactoringRecipe.getPartOfPartsArray(5), ContainerTabletManufactory.sideItemsRtColumnX, ContainerTabletManufactory.sideItemsRow3Y);

			this.result = new PositionedStack(result, ContainerTabletManufactory.productItemSlotX - 5, ContainerTabletManufactory.productItemSlotY - 11);
		}

		public List<PositionedStack> getTablet() 
		{
			return getCycledIngredients(cycleticks / 48, Arrays.asList(tablet));
		}

		public List<PositionedStack> getFuel() 
		{
			return getCycledIngredients(cycleticks / 48, Arrays.asList(fuel));
		}

		public List<PositionedStack> getIndred(int ingredNum) 
		{
			return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred[ingredNum]));
		}

		public PositionedStack getResult() 
		{
			return result;
		}

        public PositionedStack getOtherStack() 
        {
            return afuels.get((cycleticks / 48) % afuels.size()).stack;
        }

		PositionedStack tablet;
		PositionedStack fuel;

		PositionedStack ingred[] = new PositionedStack[6];

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
    }

	@Override
	public void loadTransferRects() 
	{
		//transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "fuel"));
		transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "manufacturing"));
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() 
	{
		return GuiTabletManufactory.class;
	}

	@Override
	public String getRecipeName() 
	{
		return NEIClientUtils.translate("recipe.tabletmanufactory.name");
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
		if (outputId.equals("condensing") && getClass() == TabletManufactoryRecipeHandler.class) //don't want subclasses getting a hold of this
		{
			Map<TabletManufactoryRecipe, ItemStack> recipes = (Map<TabletManufactoryRecipe, ItemStack>) RecipesTabletManufactory.instance().getManufacturingList();
			for (Entry<TabletManufactoryRecipe, ItemStack> recipe : recipes.entrySet())
				arecipes.add(new ManufacturingSet(recipe.getKey(), recipe.getValue()));
		} 
		else
			super.loadCraftingRecipes(outputId, results);
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) 
	{
		Map<TabletManufactoryRecipe, ItemStack> recipes = (Map<TabletManufactoryRecipe, ItemStack>) RecipesTabletManufactory.instance().getManufacturingList();
		for (Entry<TabletManufactoryRecipe, ItemStack> recipe : recipes.entrySet())
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result))
				arecipes.add(new ManufacturingSet(recipe.getKey(), recipe.getValue()));
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) 
	{
		//if (inputId.equals("fuel") && getClass() == TabletManufactoryRecipeHandler.class)//don't want subclasses getting a hold of this
		//  loadCraftingRecipes("purifying");
		//else
		super.loadUsageRecipes(inputId, ingredients);
	}
/*
	@Override
	public void loadUsageRecipes(ItemStack ingredient) 
	{
		Map<TabletManufactoryRecipe, ItemStack> recipes = (Map<TabletManufactoryRecipe, ItemStack>) RecipesTabletManufactory.instance().getManufacturingList();
		for (Entry<TabletManufactoryRecipe, ItemStack> recipe : recipes.entrySet())
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) 
			{
				ManufacturingSet arecipe = new ManufacturingSet(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				arecipes.add(arecipe);
			}
	}

	@Override
	public String getGuiTexture() 
	{
		return ModStrings.MODID + ":" +"textures/guis/tabletmanufactorygui.png";
	}

	@Override
	public void drawExtras(int recipe) 
	{
		drawProgressBar(GuiTabletManufactory.manufactureIconDrawX - 5, GuiTabletManufactory.manufactureIconDrawY - 11, 
				GuiTabletManufactory.manufactureIconStartX, GuiTabletManufactory.manufactureIconStartY, 
				GuiTabletManufactory.manufactureIconWidth, GuiTabletManufactory.manufactureIconHeight, 
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

	@Override
	public String getOverlayIdentifier() 
	{
		return "manufacturing";
	}
	 */

}