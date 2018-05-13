package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBloodmoonNinetales;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;

public class AIBloodmoonNinetalesFoxfireStorm extends AIAnimation 
{
	private EntityBloodmoonNinetales entityBloodmoonNinetales;
	private EntityLivingBase attackTarget;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 30;

	public AIBloodmoonNinetalesFoxfireStorm(EntityBloodmoonNinetales entityBloodmoonNinetales) 
	{
		super(entityBloodmoonNinetales, 3);
		this.entityBloodmoonNinetales = entityBloodmoonNinetales;
		attackTarget = null;
	}

	public int getAnimationID() 
	{
		return LibraryAhriNinetalesAttackID.FOXFIRE_STORM;
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
		attackTarget = entityBloodmoonNinetales.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityBloodmoonNinetales.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
			
			if(entityBloodmoonNinetales.getAnimationTick() == 1)
			{
				if(entityBloodmoonNinetales.worldObj.rand.nextInt(3) != 0)
				{
					entityBloodmoonNinetales.playGaspSound();
				}
				else
				{
					entityBloodmoonNinetales.playLaughSound();
				}
			}
			else if(entityBloodmoonNinetales.getAnimationTick() % 3 == 0 && 
					entityBloodmoonNinetales.getAnimationTick() >= 5 && entityBloodmoonNinetales.getAnimationTick() <= 25)
			{
				if (!entityBloodmoonNinetales.worldObj.isRemote)
				{
					float f;
					
					double d0 = this.entityBloodmoonNinetales.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
					
					f = MathHelper.sqrt_double(d0) / entityBloodmoonNinetales.maxFireballRange;
					float f1 = f;

					if (f < 0.1F)
					{
						f1 = 0.1F;
					}

					if (f1 > 1.0F)
					{
						f1 = 1.0F;
					}
					
					entityBloodmoonNinetales.attackWithOffsetFireball(entityBloodmoonNinetales, attackTarget, f1);
					/*
					System.out.println( "Test Animation Tick Code in AI class" );
					System.out.println( Float.toString( entityBloodmoonNinetales.getAnimationTick() ) );*/
				}
			}
		}
	}
}