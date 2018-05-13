package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class AIGeneralRangedAttacker extends EntityAIBase
{
	/** The entity the AI instance has been applied to */
	private final EntityLiving attackerEntity;
	/** The entity (as a RangedAttackMob) the AI instance has been applied to. */
	private final IRangedAttackMob rangedAttackEntityHost;
	private EntityLivingBase attackTarget;
	/**
	 * A decrementing tick that spawns a ranged attack once this value reaches 0. It is then set back to the
	 * maxRangedAttackTime.
	 */
	private int rangedAttackTime;
	private double entityMoveSpeed;
	private int timeTargetIsSeeable;
	private int minimumRangedAttackTime;
	/** The maximum time the AI has to wait before peforming another ranged attack. */
	private int maxRangedAttackTime;
	private float maxRange;
	private float maxRangeSquared;

	public AIGeneralRangedAttacker(IRangedAttackMob attackingMob, double movementSpeedModifier, int maxRangedAttackTime, float maxRange)
	{
		this(attackingMob, movementSpeedModifier, maxRangedAttackTime, maxRangedAttackTime, maxRange);
	}

	public AIGeneralRangedAttacker(IRangedAttackMob attackingMob, double movementSpeedModifier, int minimumRangedAttackTime, int maxRangedAttackTime, float maxRange)
	{
		this.rangedAttackTime = -1;

		if (!(attackingMob instanceof EntityLivingBase))
		{
			throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
		}
		else
		{
			this.rangedAttackEntityHost = attackingMob;
			this.attackerEntity = (EntityLiving)attackingMob;
			this.entityMoveSpeed = movementSpeedModifier;
			this.minimumRangedAttackTime = minimumRangedAttackTime;
			this.maxRangedAttackTime = maxRangedAttackTime;
			this.maxRange = maxRange;
			this.maxRangeSquared = maxRange * maxRange;
			this.setMutexBits(3);
		}
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@Override
	public boolean shouldExecute()
	{
		EntityLivingBase entitylivingbase = this.attackerEntity.getAttackTarget();

		if (entitylivingbase == null)
		{
			return false;
		}
		else
		{
			this.attackTarget = entitylivingbase;
			return true;
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	@Override
	public boolean continueExecuting()
	{
		return this.shouldExecute() || !this.attackerEntity.getNavigator().noPath();
	}

	/**
	 * Resets the task
	 */
	@Override
	public void resetTask()
	{
		this.attackTarget = null;
		this.timeTargetIsSeeable = 0;
		this.rangedAttackTime = -1;
	}

	/**
	 * Updates the task
	 */
	@Override
	public void updateTask()
	{
		double d0 = this.attackerEntity.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
		boolean flag = this.attackerEntity.getEntitySenses().canSee(this.attackTarget);

		if(attackTarget.isDead == true)
		{	
			this.attackerEntity.setAttackTarget(null);
		}
		
		if (flag)
		{
			++this.timeTargetIsSeeable;
		}
		else
		{
			this.timeTargetIsSeeable = 0;
		}

		if (d0 <= (double)this.maxRangeSquared && this.timeTargetIsSeeable != 0)
		{
			this.attackerEntity.getNavigator().clearPathEntity();
		}
		else
		{
			this.attackerEntity.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
		}

		this.attackerEntity.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);
		float f;

		if (--this.rangedAttackTime == 0)
		{
			if (d0 > (double)this.maxRangeSquared || !flag)
			{
				return;
			}

			f = MathHelper.sqrt_double(d0) / this.maxRange;
			float f1 = f;

			if (f < 0.1F)
			{
				f1 = 0.1F;
			}

			if (f1 > 1.0F)
			{
				f1 = 1.0F;
			}

			this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, f1);
			this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.minimumRangedAttackTime) + (float)this.minimumRangedAttackTime);
		}
		else if (this.rangedAttackTime < 0)
		{
			f = MathHelper.sqrt_double(d0) / this.maxRange;
			this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.minimumRangedAttackTime) + (float)this.minimumRangedAttackTime);
		}
	}
}