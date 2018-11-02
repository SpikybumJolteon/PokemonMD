package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.LibraryClayColors;
import com.fuzzyacornindustries.pokemonmd.library.LibraryDye;
import com.fuzzyacornindustries.pokemonmd.library.LibraryWood;
import com.google.common.collect.Maps;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesVerdantPurifier 
{
	private static final RecipesVerdantPurifier purifyingBase = new RecipesVerdantPurifier();
	/** The list of purifying results. */
	private final Map purifyingList = Maps.newHashMap();
	private final Map experienceList = Maps.newHashMap();

	public static RecipesVerdantPurifier instance()
	{
		return purifyingBase;
	}

	private RecipesVerdantPurifier()
	{
		addPurifyingRecipe(
				new ItemStack(Items.rotten_flesh), 
				new ItemStack(Items.porkchop), 0.3F);
		addPurifyingRecipe(
				new ItemStack(Blocks.cobblestone), 
				new ItemStack(Blocks.mossy_cobblestone), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.mossy_cobblestone), 
				new ItemStack(Blocks.dirt), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.dirt), 
				new ItemStack(Blocks.grass), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.soul_sand), 
				new ItemStack(Blocks.sand), 0.5F);
		addPurifyingRecipe(
				new ItemStack(Blocks.stone), 
				new ItemStack(Blocks.gravel), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.gravel), 
				new ItemStack(Blocks.sand), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Items.spider_eye), 
				new ItemStack(Items.nether_wart), 0.2F);
		addPurifyingRecipe(
				new ItemStack(Items.poisonous_potato), 
				new ItemStack(PokemonMDItem.pechitaBerry), 1.0F);
		addPurifyingRecipe(
				new ItemStack(PokemonMDItem.silkscreenMesh), 
				new ItemStack(PokemonMDItem.silkscreenAlloy), 1.0F);
		addPurifyingRecipe(
				new ItemStack(Items.blaze_powder), 
				new ItemStack(PokemonMDItem.rawstettaBerry), 0.5F);
		addPurifyingRecipe(
				new ItemStack(Items.apple), 
				new ItemStack(PokemonMDItem.oranianBerry), 0.5F);
		addPurifyingRecipe(
				new ItemStack(Items.fish), 
				new ItemStack(PokemonMDItem.passhauraBerry), 1.0F);
		addPurifyingRecipe(
				new ItemStack(PokemonMDItem.goldenChaff), 
				new ItemStack(Items.wheat), 0.3F);

		addPurifyingRecipe(
				new ItemStack(Items.dye, 1, LibraryDye.CACTUS_GREEN), 
				new ItemStack(Blocks.cactus), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Items.paper), 
				new ItemStack(Items.reeds), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Items.sugar), 
				new ItemStack(Items.reeds), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Items.gold_nugget), 
				new ItemStack(PokemonMDItem.aurumDust), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Items.gold_ingot), 
				new ItemStack(PokemonMDBlock.packedAurumDust), 0.1F);
		addPurifyingRecipe(
				new ItemStack(PokemonMDItem.tiberiumShard), 
				new ItemStack(Items.quartz), 0.1F);
		addPurifyingRecipe(
				new ItemStack(PokemonMDItem.richTiberiumShard), 
				new ItemStack(PokemonMDItem.tiberiumShard), 0.1F);
		addPurifyingRecipe(
				new ItemStack(PokemonMDItem.neoTiberiumShard), 
				new ItemStack(PokemonMDItem.richTiberiumShard), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.log, 1, LibraryWood.OAK_LOG), 
				new ItemStack(Blocks.sapling, 1, LibraryWood.OAK_SAPLING), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.log, 1, LibraryWood.BIRCH_LOG), 
				new ItemStack(Blocks.sapling, 1, LibraryWood.BIRCH_SAPLING), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.log, 1, LibraryWood.SPRUCE_LOG), 
				new ItemStack(Blocks.sapling, 1, LibraryWood.SPRUCE_SAPLING), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.log, 1, LibraryWood.JUNGLE_LOG), 
				new ItemStack(Blocks.sapling, 1, LibraryWood.JUNGLE_SAPLING), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.log2, 1, LibraryWood.ACACIA_LOG_2), 
				new ItemStack(Blocks.sapling, 1, LibraryWood.ACACIA_SAPLING), 0.1F);
		addPurifyingRecipe(
				new ItemStack(Blocks.log2, 1, LibraryWood.DARK_OAK_LOG_2), 
				new ItemStack(Blocks.sapling, 1, LibraryWood.DARK_OAK_SAPLING), 0.1F);

		addPurifyingRecipe(
				new ItemStack(PokemonMDItem.blessingOfArceus), 
				new ItemStack(Items.diamond), 10.0F);


		/* *********** Food Plus Recipes *********** */
		if(PokemonMDMain.isFoodPlusEnabled)
		{
			ItemStack cherryTomato = GameRegistry.findItemStack("FoodPlus", "cherry_tomato", 1);
			ItemStack tomato = GameRegistry.findItemStack("FoodPlus", "tomato", 1);
			ItemStack tentacle = GameRegistry.findItemStack("FoodPlus", "tentacle", 1);
			ItemStack salt = GameRegistry.findItemStack("FoodPlus", "salt", 1);

			if(cherryTomato != null && tomato != null)
			{
				addPurifyingRecipe(
						cherryTomato, 
						tomato, 0.1F);
			}

			if(tentacle != null && salt != null)
			{
				addPurifyingRecipe(
						tentacle, 
						salt, 0.1F);
			}
		}
		

		/* *********** Thermal Foundations Recipes *********** */
		if(PokemonMDMain.isThermalFoundationEnabled)
		{
			ItemStack sulfur = new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 16);
			ItemStack niter = new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 17);			

			if(sulfur != null && niter != null)
			{
				addPurifyingRecipe(
						sulfur, 
						niter, 0.3F);
			}
		}

		
		/* *********** Hybrid Recipes *********** */
		if(PokemonMDMain.isThermalFoundationEnabled && PokemonMDMain.isFoodPlusEnabled)
		{
			ItemStack niter = new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 17);
			ItemStack salt = GameRegistry.findItemStack("FoodPlus", "salt", 1);

			if(salt != null && niter != null)
			{
				addPurifyingRecipe(
						niter, 
						salt, 0.3F);
			}
		}
	}

	public void addPurifyingRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, float parExperience)
	{
		purifyingList.put(parItemStackIn, parItemStackOut);
		experienceList.put(parItemStackOut, Float.valueOf(parExperience));
	}

	public ItemStack getPurifyingResult(ItemStack parItemStack)
	{
		Iterator iterator = purifyingList.entrySet().iterator();
		Entry entry;

		do
		{
			if (!iterator.hasNext())
			{
				return null;
			}

			entry = (Entry)iterator.next();
		}
		while (!areItemStacksEqual(parItemStack, (ItemStack)entry

				.getKey()));

		return (ItemStack)entry.getValue();
	}

	private boolean areItemStacksEqual(ItemStack parItemStack1, ItemStack parItemStack2)
	{
		return parItemStack2.getItem() == parItemStack1.getItem() 
				&& (parItemStack2.getItemDamage() == 32767 
				|| parItemStack2.getItemDamage() == parItemStack1.getItemDamage());
	}

	public Map getPurifyingList()
	{
		return purifyingList;
	}

	public float getVerdantPurifierExperience(ItemStack parItemStack)
	{
		Iterator iterator = experienceList.entrySet().iterator();
		Entry entry;

		do
		{
			if (!iterator.hasNext())
			{
				return 0.0F;
			}

			entry = (Entry)iterator.next();
		}
		while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));

		return ((Float)entry.getValue()).floatValue();
	}
}