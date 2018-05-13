package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.LibraryWood;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.google.common.collect.Maps;

import cpw.mods.fml.common.registry.GameRegistry;

public class FuelsVerdantPurifier 
{
    private static final FuelsVerdantPurifier purifyingFuelBase = new FuelsVerdantPurifier();
    /** The list of fuel values. */
    private final Map fuelList = Maps.newHashMap();

    public static FuelsVerdantPurifier instance()
    {
        return purifyingFuelBase;
    }

    private FuelsVerdantPurifier()
    {
    	int cycleTime = TileEntityVerdantPurifier.purificationTime;
    	
        addPurifyingRecipe(new ItemStack(Blocks.pumpkin), cycleTime * 2);
        addPurifyingRecipe(new ItemStack(Blocks.melon_block), cycleTime * 2);
        addPurifyingRecipe(new ItemStack(Blocks.cactus), cycleTime / 2);
        addPurifyingRecipe(new ItemStack(Blocks.leaves), cycleTime / 4);
        addPurifyingRecipe(new ItemStack(Blocks.leaves2), cycleTime / 4);
        addPurifyingRecipe(new ItemStack(Blocks.vine), cycleTime / 4);
        addPurifyingRecipe(new ItemStack(Blocks.waterlily), cycleTime * 4);
        addPurifyingRecipe(new ItemStack(Blocks.sapling), cycleTime);
        addPurifyingRecipe(new ItemStack(Blocks.log), cycleTime);
        addPurifyingRecipe(new ItemStack(Blocks.log2), cycleTime);
        addPurifyingRecipe(new ItemStack(Items.reeds), cycleTime / 2);
        addPurifyingRecipe(new ItemStack(Items.wheat), cycleTime);
        addPurifyingRecipe(new ItemStack(Items.wheat_seeds), cycleTime / 4);
        addPurifyingRecipe(new ItemStack(Items.apple), cycleTime * 2);
        addPurifyingRecipe(new ItemStack(Items.potato), cycleTime);
        addPurifyingRecipe(new ItemStack(Items.carrot), cycleTime);
        addPurifyingRecipe(new ItemStack(Items.melon), cycleTime / 2);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.verdantGoo), cycleTime * 8);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.verdantCharge), cycleTime * 16);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.colbertaBerry), cycleTime * 2);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.oranianBerry), cycleTime / 2);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.passhauraBerry), cycleTime);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.pechitaBerry), cycleTime);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.rawstettaBerry), cycleTime);
        addPurifyingRecipe(new ItemStack(PokemonMDItem.reviveSeed), cycleTime * 4);
        

		/* *********** Zelda Sword Skills Recipes *********** */
        if(PokemonMDMain.isZeldaSwordSkillsEnabled)
        {
			ItemStack dekuShield = GameRegistry.findItemStack("zeldaswordskills", "zss.shield_deku", 1);
			ItemStack dekuNut = GameRegistry.findItemStack("zeldaswordskills", "zss.deku_nut", 1);
			
			if(dekuShield != null)
		        addPurifyingRecipe(dekuShield, cycleTime * 32);
			
			if(dekuNut != null)
		        addPurifyingRecipe(dekuNut, cycleTime * 8);
        }
        

		/* *********** Food Plus Recipes *********** */
        if(PokemonMDMain.isFoodPlusEnabled)
        {
			ItemStack tomatoSeed = GameRegistry.findItemStack("FoodPlus", "tomato_seed", 1);
			ItemStack strawberrySeed = GameRegistry.findItemStack("FoodPlus", "strawberry_seed", 1);
			ItemStack cherryTomato = GameRegistry.findItemStack("FoodPlus", "cherry_tomato", 1);
			ItemStack cherry = GameRegistry.findItemStack("FoodPlus", "cherry", 1);
			ItemStack peanut = GameRegistry.findItemStack("FoodPlus", "peanut", 1);
			ItemStack coffee_bean = GameRegistry.findItemStack("FoodPlus", "coffee_bean", 1);
			ItemStack rice = GameRegistry.findItemStack("FoodPlus", "rice", 1);
			ItemStack orange = GameRegistry.findItemStack("FoodPlus", "orange", 1);
			ItemStack pear = GameRegistry.findItemStack("FoodPlus", "pear", 1);
			ItemStack kiwi = GameRegistry.findItemStack("FoodPlus", "kiwi", 1);
			ItemStack coconut = GameRegistry.findItemStack("FoodPlus", "coconut", 1);
			ItemStack banana = GameRegistry.findItemStack("FoodPlus", "banana", 1);

			if(tomatoSeed != null)
		        addPurifyingRecipe(tomatoSeed, cycleTime / 4);

			if(strawberrySeed != null)
		        addPurifyingRecipe(strawberrySeed, cycleTime / 4);

			if(cherryTomato != null)
		        addPurifyingRecipe(cherryTomato, cycleTime / 2);

			if(cherry != null)
		        addPurifyingRecipe(cherry, cycleTime / 2);

			if(peanut != null)
		        addPurifyingRecipe(peanut, cycleTime / 2);

			if(coffee_bean != null)
		        addPurifyingRecipe(coffee_bean, cycleTime / 2);

			if(rice != null)
		        addPurifyingRecipe(rice, cycleTime / 2);

			if(orange != null)
		        addPurifyingRecipe(orange, cycleTime);

			if(pear != null)
		        addPurifyingRecipe(pear, cycleTime);

			if(kiwi != null)
		        addPurifyingRecipe(kiwi, cycleTime);

			if(coconut != null)
		        addPurifyingRecipe(coconut, cycleTime);

			if(banana != null)
		        addPurifyingRecipe(banana, cycleTime);
        }
    }

    public void addPurifyingRecipe(ItemStack parItemStackFuel, int parFuelDuration)
    {
    	fuelList.put(parItemStackFuel, parFuelDuration);
    }
    
    public Map getFuelList()
    {
        return fuelList;
    }

    private boolean areItemStacksEqual(ItemStack parItemStack1, ItemStack parItemStack2)
    {
        return parItemStack2.getItem() == parItemStack1.getItem() 
              && (parItemStack2.getItemDamage() == 32767 
              || parItemStack2.getItemDamage() == parItemStack1.getItemDamage());
    }

    public int getVerdantPurifierFuelTime(ItemStack parItemStack)
    {
        Iterator iterator = fuelList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));

        return ((Integer)entry.getValue()).intValue();
    }
}