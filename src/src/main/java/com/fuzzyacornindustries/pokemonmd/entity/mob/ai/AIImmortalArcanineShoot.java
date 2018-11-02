package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryImmortalArcanineAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityImmortalArcanine;

import net.minecraft.entity.EntityLivingBase;

public class AIImmortalArcanineShoot extends AIAnimation 
{
	private EntityImmortalArcanine entityImmortalArcanine;
	private EntityLivingBase attackTarget;
	
	private float verticleJump;
	private float horizontalSpeedModifier;

	public float range = 2.8F;
	
	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 30;

	public AIImmortalArcanineShoot(EntityImmortalArcanine entityImmortalArcanine)
	{
		super(entityImmortalArcanine, 3);
		this.entityImmortalArcanine = entityImmortalArcanine;
		attackTarget = null;

		this.verticleJump = verticleJump;
		this.horizontalSpeedModifier = horizontalSpeedModifier;
	}

	public int getAnimationID() 
	{
		return LibraryImmortalArcanineAttackID.SHOOT;
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
		attackTarget = entityImmortalArcanine.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityImmortalArcanine.getLookHelper().setLookPositionWithEntity(attackTarget, 60F, 60F);
			entityImmortalArcanine.faceEntity(attackTarget, 60F, 60F);
			
			if(entityImmortalArcanine.getAnimationTick() == 1)
			{

		        //double d0 = this.attackTarget.posX - this.entityImmortalArcanine.posX;
		        //double d1 = this.attackTarget.posZ - this.entityImmortalArcanine.posZ;
		        //float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1) / horizontalSpeedModifier;
		        //this.entityImmortalArcanine.motionX += d0 / (double)f * 1D;
		        //this.entityImmortalArcanine.motionZ += d1 / (double)f * 1D;
		        //this.entityImmortalArcanine.motionY = (double)verticleJump;
			}
			
			if(entityImmortalArcanine.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ) <= (range * range))
			{
				//attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityImmortalArcanine), entityImmortalArcanine.getAttackPower());

				//System.out.println( "Test Entity Detected By Kill Order" );
				//System.out.println( Integer.toString( entityAbsol.getAttackTarget().getEntityId() ) );
			}
		}
	}
}