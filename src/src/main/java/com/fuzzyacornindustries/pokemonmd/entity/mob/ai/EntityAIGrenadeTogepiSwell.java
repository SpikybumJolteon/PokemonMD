package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityGrenadeTogepi;

public class EntityAIGrenadeTogepiSwell extends EntityAIBase
{
	EntityGrenadeTogepi swellingTogepi;

	EntityLivingBase attackTarget;

	public EntityAIGrenadeTogepiSwell(EntityGrenadeTogepi par1Entity)
	{
		this.swellingTogepi = par1Entity;
		this.setMutexBits(1);
	}
	
	public boolean shouldExecute()
	{
		if (swellingTogepi.getAttackType() == 1)
		{
			EntityLivingBase entityliving = this.swellingTogepi.getAttackTarget();
			return this.swellingTogepi.getTogepiState() > 0 || entityliving != null;
		}
		else
		{
			return false;
		}
	}

	public void startExecuting()
	{
		this.swellingTogepi.getNavigator().clearPathEntity();
		this.attackTarget = this.swellingTogepi.getAttackTarget();
	}

	public void resetTask()
	{
		this.attackTarget = null;
	}

	public void updateTask()
	{
		if (this.attackTarget == null)
		{
			this.swellingTogepi.setTogepiState(-1);
		}
		else if (!this.swellingTogepi.getEntitySenses().canSee(this.attackTarget))
		{
			this.swellingTogepi.setTogepiState(-1);
		}
		else
		{
			this.swellingTogepi.setTogepiState(1);
		}
	}
}