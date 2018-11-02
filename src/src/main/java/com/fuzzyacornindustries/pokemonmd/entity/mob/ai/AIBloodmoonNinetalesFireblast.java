package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBloodmoonNinetales;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class AIBloodmoonNinetalesFireblast extends AIAnimation 
{
	private EntityBloodmoonNinetales entityBloodmoonNinetales;
	private EntityLivingBase attackTarget;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 56;

	public AIBloodmoonNinetalesFireblast(EntityBloodmoonNinetales entityBloodmoonNinetales) 
	{
		super(entityBloodmoonNinetales, 3);
		this.entityBloodmoonNinetales = entityBloodmoonNinetales;
		attackTarget = null;
	}

	public int getAnimationID() 
	{
		return LibraryAhriNinetalesAttackID.FIREBLAST;
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
				if(entityBloodmoonNinetales.worldObj.rand.nextInt(3) == 1)
				{
					entityBloodmoonNinetales.playLaughSound();
				}
			}
			else if (entityBloodmoonNinetales.getAnimationTick() == 34 && entityBloodmoonNinetales.onGround)
            {
				entityBloodmoonNinetales.motionY = 0.60D;

				entityBloodmoonNinetales.playGaspSound();
            }
			else if(entityBloodmoonNinetales.getAnimationTick() == 40)
			{
				entityBloodmoonNinetales.playAttackSound();
			}
			else if(entityBloodmoonNinetales.getAnimationTick() == 44)
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

					entityBloodmoonNinetales.attackWithFireblast(entityBloodmoonNinetales, attackTarget, f1);
				}
			}
		}
	}
}