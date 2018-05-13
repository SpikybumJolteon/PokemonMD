package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayLitten;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityVegnagunDustox;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;

public class AIClayLittenEmberVolley extends AIAnimation
{
	private EntityClayLitten entityClayLitten;
	private EntityLivingBase attackTarget;

	public static final int attackDuration = 40;

	public AIClayLittenEmberVolley(EntityClayLitten clayLitten) 
	{
		super(clayLitten, 3);
		entityClayLitten = clayLitten;
		attackTarget = null;
	}

	public int getAnimationID() 
	{
		return EntityClayLitten.actionIDEmberVolley;
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
		attackTarget = entityClayLitten.getAttackTarget();
	}

	public void updateTask() 
	{	
		if (!entityClayLitten.worldObj.isRemote)
		{
			if(attackTarget != null)
			{
				entityClayLitten.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

				if(entityClayLitten.getAnimationTick() > 0 && entityClayLitten.getAnimationTick() % 4 == 0)
				{
					float f;

					double d0 = this.entityClayLitten.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);

					f = MathHelper.sqrt_double(d0) / entityClayLitten.maxFireballRange;
					float f1 = f;

					if (f < 0.1F)
					{
						f1 = 0.1F;
					}

					if (f1 > 1.0F)
					{
						f1 = 1.0F;
					}

					entityClayLitten.attackWithFireball(entityClayLitten, attackTarget, f1);
				}
			}
		}
	}
}