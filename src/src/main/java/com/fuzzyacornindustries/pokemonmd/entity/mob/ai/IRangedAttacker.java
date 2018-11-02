package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;

public interface IRangedAttacker 
{
	public void tickRangedAttackClock();
	public int getRangedAttackClock();
}