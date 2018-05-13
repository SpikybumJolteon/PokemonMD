package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDarkGlassManectric;

public class EntityAIDarkGlassManectricSwell extends EntityAIBase
{
	/** The Manectric that is swelling. */
	EntityDarkGlassManectric swellingManectric;

	EntityLivingBase attackTarget;

	public EntityAIDarkGlassManectricSwell(EntityDarkGlassManectric par1Entity)
	{
		this.swellingManectric = par1Entity;
		this.setMutexBits(1);
	}
	
	public boolean shouldExecute()
	{
		if (swellingManectric.getAttackType() == 1)
		{
			EntityLivingBase entityliving = this.swellingManectric.getAttackTarget();
			return this.swellingManectric.getManectricState() > 0 || entityliving != null && this.swellingManectric.getDistanceSqToEntity(entityliving) < 7.0D;
		}
		else
		{
			return false;
		}
	}

	public void startExecuting()
	{
		this.swellingManectric.getNavigator().clearPathEntity();
		this.attackTarget = this.swellingManectric.getAttackTarget();
	}

	public void resetTask()
	{
		this.attackTarget = null;
	}

	public void updateTask()
	{
		if (this.attackTarget == null)
		{
			this.swellingManectric.setManectricState(-1);
		}
		else if (this.swellingManectric.getDistanceSqToEntity(this.attackTarget) > 49.0D)
		{
			this.swellingManectric.setManectricState(-1);
		}
		else if (!this.swellingManectric.getEntitySenses().canSee(this.attackTarget))
		{
			this.swellingManectric.setManectricState(-1);
		}
		else
		{
			this.swellingManectric.setManectricState(1);
		}
	}
}