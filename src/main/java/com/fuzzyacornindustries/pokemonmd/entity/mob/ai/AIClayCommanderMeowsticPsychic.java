package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayCommanderMeowsticMale;

public class AIClayCommanderMeowsticPsychic extends AIAnimation 
{
	private EntityClayCommanderMeowsticMale entityClayCommanderMeowsticMale;
	private EntityLivingBase attackTarget;
	
	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 125;

	public AIClayCommanderMeowsticPsychic(EntityClayCommanderMeowsticMale clayCommanderMeowstic) 
	{
		super(clayCommanderMeowstic, 3);
		entityClayCommanderMeowsticMale = clayCommanderMeowstic;
		attackTarget = null;

        this.rand = new Random();
	}

	public int getAnimationID() 
	{
		return EntityClayCommanderMeowsticMale.actionIDPsychic;
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
		attackTarget = entityClayCommanderMeowsticMale.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityClayCommanderMeowsticMale.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if(entityClayCommanderMeowsticMale.getAnimationTick() == 80 && attackTarget != null)
			{
				attackTarget.motionY = 0.80D;
			}
			if(entityClayCommanderMeowsticMale.getAnimationTick() == 83 && attackTarget != null)
			{
				attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityClayCommanderMeowsticMale), 2.0F);
			}

			/*
			System.out.println( "Test Animation Tick Code in AI class" );
			System.out.println( Float.toString( entityClayCommanderMeowsticMale.getAnimationTick() ) );
			*/
		}
	}
}