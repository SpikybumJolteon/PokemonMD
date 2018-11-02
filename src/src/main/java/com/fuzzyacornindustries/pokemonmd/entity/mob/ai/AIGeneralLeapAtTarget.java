package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

public class AIGeneralLeapAtTarget extends EntityAIBase 
{
	private EntityLiving entityLeaper;
	private EntityLivingBase attackTarget;
	
	private float verticleJump;
	private float horizontalSpeedModifier;

	private Random rand;

	public AIGeneralLeapAtTarget(EntityLiving entityLeaper, float verticleJump, float horizontalSpeedModifier) 
	{
		this.entityLeaper = entityLeaper;
		attackTarget = null;

		this.verticleJump = verticleJump;
		this.horizontalSpeedModifier = horizontalSpeedModifier;
		
		this.rand = new Random();
	}

	public boolean isAutomatic() 
	{
		return true;
	}

    public void startExecuting()
    {
        double d0 = this.attackTarget.posX - this.entityLeaper.posX;
        double d1 = this.attackTarget.posZ - this.entityLeaper.posZ;
        float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1) / horizontalSpeedModifier;
        this.entityLeaper.motionX += d0 / (double)f * 1D;
        this.entityLeaper.motionZ += d1 / (double)f * 1D;
        this.entityLeaper.motionY = (double)verticleJump;
    }

    public boolean continueExecuting()
    {
        return !this.entityLeaper.onGround;
    }

    public boolean shouldExecute()
    {
        this.attackTarget = this.entityLeaper.getAttackTarget();

        if (this.attackTarget == null)
        {
            return false;
        }
        else
        {
            double d0 = this.entityLeaper.getDistanceSqToEntity(this.attackTarget);
            return d0 >= 4.0D && d0 <= 20.0D ? (!this.entityLeaper.onGround ? false : this.entityLeaper.getRNG().nextInt(7) == 0) : false;
        }
    }
}