package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityIonianNinetales;

public class AIIonianNinetalesFireball extends AIAnimation 
{
	private EntityIonianNinetales entityIonianNinetales;
	private EntityLivingBase attackTarget;

	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 15;

	public AIIonianNinetalesFireball(EntityIonianNinetales entityIonianNinetales) 
	{
		super(entityIonianNinetales, 3);
		this.entityIonianNinetales = entityIonianNinetales;
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
		attackTarget = entityIonianNinetales.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityIonianNinetales.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
			
			if(entityIonianNinetales.getAnimationTick() == 5)
			{
				if (!entityIonianNinetales.worldObj.isRemote)
				{
					float f;
					
					double d0 = this.entityIonianNinetales.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
					
					f = MathHelper.sqrt_double(d0) / entityIonianNinetales.maxFireballRange;
					float f1 = f;

					if (f < 0.1F)
					{
						f1 = 0.1F;
					}

					if (f1 > 1.0F)
					{
						f1 = 1.0F;
					}
					
					entityIonianNinetales.attackWithFireball(entityIonianNinetales, attackTarget, f1);
				}
			}
		}
	}
}