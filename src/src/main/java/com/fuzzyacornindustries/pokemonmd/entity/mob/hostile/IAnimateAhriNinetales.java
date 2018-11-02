package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;

public interface IAnimateAhriNinetales 
{
	public IdleAnimationClock getIdleAnimationClockBody();
	public IdleAnimationClock getIdleAnimationClockArmRt();
	public IdleAnimationClock getIdleAnimationClockTails(int partNumber);
	public IdleAnimationClock getIdleAnimationClockOrb();
}