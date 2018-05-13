package com.fuzzyacornindustries.pokemonmd.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;

/**
 * 
 * Helper enum for determining mob types on spawn, based on generic biome 'type.'
 *
 * Taken from Zeld Sword Skills by CoolAlias
 */
public enum BiomeType 
{
	ARID("arid", "Desert", "Desert Hills", "Savanna", "Savanna Plateau", "Mesa", "Mesa Plateau", "Mesa Plateau F"),
	BEACH("beach", "Beach"),
	BEACHES_ALL("beach_all", "Beach", "Stone Beach"),
	COLD("cold", "Cold Beach", "Cold Taiga", "Cold Taiga Hills", "Frozen River", "Ice Mountains", "Ice Plains"),
	FIERY("fiery", "Hell"),
	FOREST("forest", "Birch Forest", "Birch Forest Hills", "Forest", "Forest Hills", "Roofed Forest", "Taiga", "Taiga Hills", "Mega Taiga", "Mega Taiga Hills", "Cold Taiga", "Cold Taiga Hills"),
	JUNGLE("jungle", "Jungle", "Jungle Edge", "Jungle Hills"),
	MOUNTAIN("mountain", "Extreme Hills", "Extreme Hills+", "Extreme Hills Edge"),
	OCEAN("ocean", "Ocean", "Frozen Ocean", "Deep Ocean"),
	PLAINS("plains", "Plains"),
	RIVER("river", "River"),
	SHROOM("shroom", "MushroomIsland", "MushroomIslandShore"),
	SWAMP("swamp", "Swampland"),
	TAIGA("taiga", "Taiga", "Taiga Hills", "Mega Taiga", "Mega Taiga Hills"),
	TEMPERATE_FOREST("temperate_forest", "Birch Forest", "Birch Forest Hills", "Forest", "Forest Hills", "Roofed Forest");
	
	private final String unlocalizedName;

	/** Default biomes for this type */
	public final String[] defaultBiomes;

	/** Mapping of biome names to biome types */
	private static final Map<String, BiomeType> biomeTypeList = new HashMap<String, BiomeType>();

	private BiomeType(String name, String... defaultBiomes) 
	{
		this.unlocalizedName = name;
		this.defaultBiomes = defaultBiomes;
	}

	@Override
	public String toString() 
	{
		return StatCollector.translateToLocal("biometype." + unlocalizedName + ".name");
	}

	/**
	 * Loads biome type lists from config file
	 *//*
	public static void postInit(Configuration config) 
	{
		config.addCustomCategoryComment("Mob Spawns", "Mobs use the 'Biome Type' lists to populate their individual spawn settings the first time the game is loaded.\nChanging the type lists after this point has no effect UNLESS you also delete the mob spawn locations in the\nconfig - this will force them to re-populate the next time the game is loaded.\nAlternatively, you may add new biomes directly to the individual mob spawn entries and completely ignore biome type.");
		for (BiomeType type : BiomeType.values()) {
			addBiomes(type, config.get("Mob Spawns", String.format("[Biome Types] List of %s type biomes - certain mobs spawn differently depending on the biome type", type.toString()), type.defaultBiomes).getStringList());
		}
	}*/

	/**
	 * Adds each biome name to the mapping for this BiomeType
	 */
	private static void addBiomes(BiomeType type, String[] biomeNames) 
	{
		for (String biome : biomeNames) 
		{
			if (biome.length() < 1) 
			{
				continue;
			}
			
			biome = biome.toLowerCase().replace(" ", "");
			
			if (!isRealBiome(biome)) 
			{
				//ZSSMain.logger.warn(String.format("%s is not a recognized biome! This entry will be ignored for BiomeType %s", biome, type.toString()));
			} 
			else if (biomeTypeList.containsKey(biome)) 
			{
				//ZSSMain.logger.warn(String.format("Error while adding %s for %s: biome already mapped to %s", biome, type.toString(), biomeTypeList.get(biome).toString()));
			} 
			else 
			{
				biomeTypeList.put(biome, type);
			}
		}
	}

	/**
	 * Returns the BiomeType for the given BiomeGenBase, or null if none exists
	 * @param biome	Null is allowed for directly passing {@link World#getBiomeGenForCoords}
	 */
	public static BiomeType getBiomeTypeFor(BiomeGenBase biome) 
	{
		if (biome != null && biome.biomeName != null && biome.biomeName.length() > 0) 
		{
			return biomeTypeList.get(biome.biomeName.toLowerCase().replace(" ", ""));
		}
		
		return null;
	}

	/**
	 * Returns true if the name given is a real biome
	 */
	public static boolean isRealBiome(String name) 
	{
		for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) 
		{
			if (biome != null && biome.biomeName != null && biome.biomeName.toLowerCase().replace(" ", "").equals(name)) 
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Combines the given biome types into a single master array, less any biomes to ignore
	 * @param ignore Array of biome names (strings) to ignore; may be null 
	 */
	public static String[] getBiomeArray(String[] ignore, BiomeType... types) 
	{
		List<String> combined = new ArrayList<String>();
		
		for (BiomeType biomes : types) 
		{
			for (String biome : biomes.defaultBiomes) 
			{
				if (ignore == null || Arrays.binarySearch(ignore, biome, String.CASE_INSENSITIVE_ORDER) < 0) 
				{
					combined.add(biome);
				}
			}
		}
		
		return combined.toArray(new String[combined.size()]);
	}
}