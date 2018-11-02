package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AIGeneralMeleeJumper extends EntityAIBase
{
	World worldObj;
	EntityCreature attacker;

	/** An amount of decrementing ticks that allows the entity to attack once the tick reaches 0. */
	int attackTick;
	boolean isAirborn;

	double speedTowardsTarget;

	/** When true, the mob will continue chasing its target, even if it can't find a path to them right now. */
	boolean longMemory;

	/** The PathEntity of our entity. */
	PathEntity entityPathEntity;

	Class classTarget;

	private int counterToAttackTarget;

	private double targetXPos;
	private double field_151495_j;
	private double field_151496_k;

	private int failedPathFindingPenalty;

	public AIGeneralMeleeJumper(EntityCreature attackingMob, Class p_i1635_2_, double p_i1635_3_, boolean p_i1635_5_)
	{
		this(attackingMob, p_i1635_3_, p_i1635_5_);
		this.classTarget = p_i1635_2_;
	}

	public AIGeneralMeleeJumper(EntityCreature attackingMob, double speedTowardsTarget, boolean hasLongTrackingMemory)
	{
		this.attacker = attackingMob;
		this.worldObj = attackingMob.worldObj;
		this.speedTowardsTarget = speedTowardsTarget;
		this.longMemory = hasLongTrackingMemory;
		this.setMutexBits(3);
	}

	public boolean shouldExecute()
	{
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

		if (entitylivingbase == null)
		{
			return false;
		}
		else if (!entitylivingbase.isEntityAlive())
		{
			return false;
		}
		else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass()))
		{
			return false;
		}
		else
		{
			if (-- this.counterToAttackTarget <= 0)
			{
				this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
				this.counterToAttackTarget = 4 + this.attacker.getRNG().nextInt(7);
				return this.entityPathEntity != null;
			}
			else
			{
				return true;
			}
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean continueExecuting()
	{
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
		return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (!this.longMemory ? !this.attacker.getNavigator().noPath() : this.attacker.isWithinHomeDistance(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ))));
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
		this.counterToAttackTarget = 0;
		this.isAirborn = false;
	}

	public void resetTask()
	{
		this.attacker.getNavigator().clearPathEntity();
	}

	public void updateTask()
	{
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

		if(isAirborn == true)
		{
			if(this.attacker.onGround)
			{
				this.attacker.getNavigator().clearPathEntity();
				this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget);
			}

			isAirborn = false;
		}
		else if(this.attacker.onGround)
		{
			isAirborn = true;
		}
		else
		{
			isAirborn = false;
		}

		this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
		double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.boundingBox.minY, entitylivingbase.posZ);
		double d1 = (double)(this.attacker.width * 2.0F * this.attacker.width * 2.0F + entitylivingbase.width);
		--this.counterToAttackTarget;

		if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && this.counterToAttackTarget <= 0 
				&& (this.targetXPos == 0.0D && this.field_151495_j == 0.0D && this.field_151496_k == 0.0D 
				|| entitylivingbase.getDistanceSq(this.targetXPos, this.field_151495_j, this.field_151496_k) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F))
		{
			this.targetXPos = entitylivingbase.posX;
			this.field_151495_j = entitylivingbase.boundingBox.minY;
			this.field_151496_k = entitylivingbase.posZ;
			this.counterToAttackTarget = failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);

			if (this.attacker.getNavigator().getPath() != null)
			{
				PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
				if (finalPathPoint != null && entitylivingbase.getDistanceSq(finalPathPoint.xCoord, finalPathPoint.yCoord, finalPathPoint.zCoord) < 1)
				{
					failedPathFindingPenalty = 0;
				}
				else
				{
					failedPathFindingPenalty += 10;
				}
			}
			else
			{
				failedPathFindingPenalty += 10;
			}

			if (d0 > 1024.0D)
			{
				this.counterToAttackTarget += 10;
			}
			else if (d0 > 256.0D)
			{
				this.counterToAttackTarget += 5;
			}

			if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget))
			{
				this.counterToAttackTarget += 15;
			}
		}

		this.attackTick = Math.max(this.attackTick - 1, 0);

		if (d0 <= d1 && this.attackTick <= 20)
		{
			this.attackTick = 20;

			if (this.attacker.getHeldItem() != null)
			{
				this.attacker.swingItem();
			}

			this.attacker.attackEntityAsMob(entitylivingbase);
		}
	}
}