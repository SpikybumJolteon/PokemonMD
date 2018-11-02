package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityVegnagunDustox;

public class AIVegnagunDustoxFlyShots extends AIAnimation
{
	private EntityVegnagunDustox entityVegnagunDustox;
	private EntityLivingBase attackTarget;

	public static final int attackDuration = 90;

	public AIVegnagunDustoxFlyShots(EntityVegnagunDustox vegnagunDustox) 
	{
		super(vegnagunDustox, 3);
		entityVegnagunDustox = vegnagunDustox;
		attackTarget = null;
	}

	public int getAnimationID() 
	{
		return EntityVegnagunDustox.actionIDFlyShots;
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
		attackTarget = entityVegnagunDustox.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityVegnagunDustox.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if(entityVegnagunDustox.getAnimationTick() == 1 && attackTarget != null)
			{
				if (entityVegnagunDustox.onGround)
                {
					entityVegnagunDustox.motionY = 0.9900000059604645D;
                }
				
				fireArrow();
			}
			else if(entityVegnagunDustox.getAnimationTick() > 10 && entityVegnagunDustox.getAnimationTick()%10 == 0)
			{
				fireArrow();
			}
		}
	}
	
	public void fireArrow()
	{
		Random rand = new Random();
		
		EntityArrow entityarrow = new EntityArrow(entityVegnagunDustox.worldObj, entityVegnagunDustox, attackTarget, 1.8F, (float)(14 - entityVegnagunDustox.worldObj.difficultySetting.getDifficultyId() * 4));
		entityarrow.setDamage(6F + rand.nextGaussian() * 0.25D + (double)((float)entityVegnagunDustox.worldObj.difficultySetting.getDifficultyId() * 0.11F));

		entityVegnagunDustox.playArrowAttackSound();
		entityVegnagunDustox.worldObj.spawnEntityInWorld(entityarrow);
	}
}