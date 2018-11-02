package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryOkamiPokemonAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.OkamiPokemon;

public class AIOkamiGlaiveSlashReverse extends AIOkamiGlaiveSlash 
{
	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 9;

	public AIOkamiGlaiveSlashReverse(OkamiPokemon entityOkamiPokemon, float range) 
	{
		super(entityOkamiPokemon, range);
	}

	@Override
	public int getAnimationID() 
	{
		return LibraryOkamiPokemonAttackID.GLAIVE_SLASH_REVERSE;
	}
}