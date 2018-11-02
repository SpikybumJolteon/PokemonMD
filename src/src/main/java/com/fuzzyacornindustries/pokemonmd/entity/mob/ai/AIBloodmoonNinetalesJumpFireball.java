package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBloodmoonNinetales;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;

public class AIBloodmoonNinetalesJumpFireball extends AIAnimation 
{
	private EntityBloodmoonNinetales entityBloodmoonNinetales;
	private EntityLivingBase attackTarget;

	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 28;

	public AIBloodmoonNinetalesJumpFireball(EntityBloodmoonNinetales entityBloodmoonNinetales) 
	{
		super(entityBloodmoonNinetales, 3);
		this.entityBloodmoonNinetales = entityBloodmoonNinetales;
		attackTarget = null;

		this.rand = new Random();
	}

	public int getAnimationID() 
	{
		return LibraryAhriNinetalesAttackID.JUMP_FIREBALL;
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
				entityBloodmoonNinetales.playGaspSound();
			}
			else if(entityBloodmoonNinetales.getAnimationTick() == 6 && entityBloodmoonNinetales.onGround)
            {
				entityBloodmoonNinetales.motionY = 0.45D;
            }
			else if(entityBloodmoonNinetales.getAnimationTick() == 12)
			{
				entityBloodmoonNinetales.playAttackSound();
			}
			else if(entityBloodmoonNinetales.getAnimationTick() == 14)
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
					
					entityBloodmoonNinetales.attackWithFireball(entityBloodmoonNinetales, attackTarget, f1);
				}
			}
		}
	}
}