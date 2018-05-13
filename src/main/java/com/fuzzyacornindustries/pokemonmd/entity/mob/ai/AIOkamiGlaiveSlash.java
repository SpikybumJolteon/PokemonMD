package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryOkamiPokemonAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.OkamiPokemon;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AIOkamiGlaiveSlash extends AIAnimation 
{
	private OkamiPokemon entityOkamiPokemon;
	private EntityLivingBase attackTarget;

	//public float attackPower = 0.0F;
	public float range;
	
	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 9;

	public AIOkamiGlaiveSlash(OkamiPokemon entityOkamiPokemon, float range)
	{
		super(entityOkamiPokemon, 3);
		this.entityOkamiPokemon = entityOkamiPokemon;
		attackTarget = null;
		this.range = range * range;
	}

	public int getAnimationID() 
	{
		return LibraryOkamiPokemonAttackID.GLAIVE_SLASH;
	}

	public boolean isAutomatic() 
	{
		return true;
	}

	public int getDuration() 
	{
		return attackDuration;
	}

	public void startExecuting() 
	{
		super.startExecuting();
		attackTarget = entityOkamiPokemon.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityOkamiPokemon.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if(entityOkamiPokemon.getAnimationTick() == 2 && attackTarget != null && entityOkamiPokemon.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ) <= range)
			{
				attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityOkamiPokemon), entityOkamiPokemon.getAttackPower());

				//System.out.println( "Test Entity Detected By Kill Order" );
				//System.out.println( Integer.toString( entityOkamiPokemon.getAttackTarget().getEntityId() ) );
			}
		}
	}
}