package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibrarySmeetaLiepardAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntitySmeetaLiepard;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

public class AISmeetaLiepardPounce extends AIAnimation 
{
	private EntitySmeetaLiepard entitySmeetaLiepard;
	private EntityLivingBase attackTarget;
	
	private float verticleJump;
	private float horizontalSpeedModifier;

	public float range = 2.8F;
	
	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 30;

	public AISmeetaLiepardPounce(EntitySmeetaLiepard entitySmeetaLiepard, float verticleJump, float horizontalSpeedModifier)
	{
		super(entitySmeetaLiepard, 3);
		this.entitySmeetaLiepard = entitySmeetaLiepard;
		attackTarget = null;

		this.verticleJump = verticleJump;
		this.horizontalSpeedModifier = horizontalSpeedModifier;
	}

	public int getAnimationID() 
	{
		return LibrarySmeetaLiepardAttackID.POUNCE;
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
		attackTarget = entitySmeetaLiepard.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entitySmeetaLiepard.getLookHelper().setLookPositionWithEntity(attackTarget, 60F, 60F);
			entitySmeetaLiepard.faceEntity(attackTarget, 60F, 60F);
			
			if(entitySmeetaLiepard.getAnimationTick() == 1)
			{

		        //double d0 = this.attackTarget.posX - this.entitySmeetaLiepard.posX;
		        //double d1 = this.attackTarget.posZ - this.entitySmeetaLiepard.posZ;
		        //float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1) / horizontalSpeedModifier;
		        //this.entitySmeetaLiepard.motionX += d0 / (double)f * 1D;
		        //this.entitySmeetaLiepard.motionZ += d1 / (double)f * 1D;
		        this.entitySmeetaLiepard.motionY = (double)verticleJump;
			}
			
			if(entitySmeetaLiepard.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ) <= (range * range))
			{
				//attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entitySmeetaLiepard), entitySmeetaLiepard.getAttackPower());

				//System.out.println( "Test Entity Detected By Kill Order" );
				//System.out.println( Integer.toString( entityAbsol.getAttackTarget().getEntityId() ) );
			}
		}
	}
}