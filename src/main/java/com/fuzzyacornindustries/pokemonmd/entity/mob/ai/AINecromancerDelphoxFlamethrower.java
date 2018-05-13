package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityNecromancerDelphox;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class AINecromancerDelphoxFlamethrower extends AIAnimation 
{
	private EntityNecromancerDelphox EntityNecromancerDelphox;
	private EntityLivingBase attackTarget;

	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 15;

	public AINecromancerDelphoxFlamethrower(EntityNecromancerDelphox EntityNecromancerDelphox) 
	{
		super(EntityNecromancerDelphox, 3);
		this.EntityNecromancerDelphox = EntityNecromancerDelphox;
		attackTarget = null;

		this.rand = new Random();
	}

	public int getAnimationID() 
	{
		return LibraryAhriNinetalesAttackID.FIREBALL;
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
		attackTarget = EntityNecromancerDelphox.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			EntityNecromancerDelphox.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
			
			if(EntityNecromancerDelphox.getAnimationTick() == 1)
			{
				//EntityNecromancerDelphox.playAttackSound();
			}
			else if(EntityNecromancerDelphox.getAnimationTick() >= 26 || EntityNecromancerDelphox.getAnimationTick() <= 40)
			{
				/*
				if (!EntityNecromancerDelphox.worldObj.isRemote)
				{
					float f;
					
					double d0 = this.EntityNecromancerDelphox.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
					
					f = MathHelper.sqrt_double(d0) / EntityNecromancerDelphox.maxFireballRange;
					float f1 = f;

					if (f < 0.1F)
					{
						f1 = 0.1F;
					}

					if (f1 > 1.0F)
					{
						f1 = 1.0F;
					}
					
					EntityNecromancerDelphox.attackWithFireball(EntityNecromancerDelphox, attackTarget, f1);
				}*/
			}
		}
	}
}