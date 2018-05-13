package com.fuzzyacornindustries.pokemonmd.utility;

import net.minecraft.entity.EnumCreatureType;

/**
 * 
 * Helper class containing data needed to add spawn rates for an entity
 *
 * Based on Zelda Sword Skills by CoolAlias
 */
public class SpawnableEntityData
{
	/** The creature type used to determine spawning behavior */
	public final EnumCreatureType creatureType;

	public final String[] biomeNames;

	/** Minimum number of entities to spawn in a group */
	public final int min;

	/** Maximum number of entities that may spawn in a group */
	public final int max;

	/** Spawn rate for this entity */
	public final int spawnRate;

	public SpawnableEntityData(EnumCreatureType creatureType, String[] biomeNames, int min, int max, int defaultSpawnRate) 
	{
		this.creatureType = creatureType;

		this.biomeNames = biomeNames;

		this.min = min;
		this.max = max;
		this.spawnRate = defaultSpawnRate;
	}
}