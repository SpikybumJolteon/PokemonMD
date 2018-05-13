package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryFeywoodAbsolAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFeywoodAbsol;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AIFeywoodAbsolMegahorn extends AIAnimation 
{
	private EntityFeywoodAbsol entityAbsol;
	private EntityLivingBase attackTarget;

	public float range = 2.8F;
	
	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 12;

	public AIFeywoodAbsolMegahorn(EntityFeywoodAbsol entityAbsol)
	{
		super(entityAbsol, 3);
		this.entityAbsol = entityAbsol;
		attackTarget = null;
	}

	public int getAnimationID() 
	{
		return LibraryFeywoodAbsolAttackID.MEGAHORN;
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
		attackTarget = entityAbsol.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityAbsol.getLookHelper().setLookPositionWithEntity(attackTarget, 60F, 60F);
			entityAbsol.faceEntity(attackTarget, 60F, 60F);

			if(entityAbsol.getAnimationTick() == 5 && attackTarget != null && entityAbsol.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ) <= (range * range))
			{
				attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityAbsol), entityAbsol.getAttackPower());

				//System.out.println( "Test Entity Detected By Kill Order" );
				//System.out.println( Integer.toString( entityAbsol.getAttackTarget().getEntityId() ) );
			}
		}
	}
}