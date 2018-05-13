package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityBloodmoonFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBloodmoonNinetales;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityIonianNinetales;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class AIIonianNinetalesJumpFireball extends AIAnimation 
{
	private EntityIonianNinetales entityIonianNinetales;
	private EntityLivingBase attackTarget;

	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 30;

	public AIIonianNinetalesJumpFireball(EntityIonianNinetales entityIonianNinetales) 
	{
		super(entityIonianNinetales, 3);
		this.entityIonianNinetales = entityIonianNinetales;
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
		attackTarget = entityIonianNinetales.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityIonianNinetales.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if (entityIonianNinetales.getAnimationTick() == 6 && entityIonianNinetales.onGround)
            {
				entityIonianNinetales.motionY = 0.45D;
            }
			
			if(entityIonianNinetales.getAnimationTick() == 14)
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