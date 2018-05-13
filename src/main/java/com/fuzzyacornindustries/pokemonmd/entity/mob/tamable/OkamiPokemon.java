package com.fuzzyacornindustries.pokemonmd.entity.mob.tamable;

import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.world.World;

public class OkamiPokemon extends TamablePokemon implements IRangedAttackMob
{
	public IdleAnimationClock bodyIdleAnimationClock;

	public OkamiPokemon(World par1World)
	{
		super(par1World);
	}
	
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) 
	{
		
	}

	public IdleAnimationClock getIdleAnimationClockBody()
	{
		return bodyIdleAnimationClock;
	}
}