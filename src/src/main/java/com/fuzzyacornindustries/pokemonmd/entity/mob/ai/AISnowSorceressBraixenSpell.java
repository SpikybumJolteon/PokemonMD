package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySnowSorceressBraixen;

public class AISnowSorceressBraixenSpell extends AIAnimation 
{
	private EntitySnowSorceressBraixen entitySnowSorceressBraixen;
	private EntityLivingBase attackTarget;

	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 200;

	public AISnowSorceressBraixenSpell(EntitySnowSorceressBraixen snowSorceressBraixen) 
	{
		super(snowSorceressBraixen, 3);
		entitySnowSorceressBraixen = snowSorceressBraixen;
		attackTarget = null;

		this.rand = new Random();
	}

	public int getAnimationID() 
	{
		return EntitySnowSorceressBraixen.actionIDSpell;
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
		attackTarget = entitySnowSorceressBraixen.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entitySnowSorceressBraixen.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
			/*
			if(entitySnowSorceressBraixen.getAnimationTick() == 80 && attackTarget != null)
			{
				attackTarget.motionY = 0.70D;
			}
			if(entitySnowSorceressBraixen.getAnimationTick() == 83 && attackTarget != null)
			{
				attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entitySnowSorceressBraixen), 2.0F);
			}

			/*
			System.out.println( "Test Animation Tick Code in AI class" );
			System.out.println( Float.toString( entitySnowSorceressBraixen.getAnimationTick() ) );
			 */
		}
	}
}