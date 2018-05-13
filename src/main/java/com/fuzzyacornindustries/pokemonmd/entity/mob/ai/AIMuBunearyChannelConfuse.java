package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityMuBuneary;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;

/* 
 * Logic taken from Wizzrobe mob in Zelda Sword Skills
 * by coolAlias.
 */
public class AIMuBunearyChannelConfuse extends AIAnimation
{
	private EntityMuBuneary entityMuBuneary;

	/** Timer for casting time */
	private int castingTimer;

	/** Time between casting attempts */
	private final int attackDuration = 120;

	/** Distance squared at which a target is considered 'close enough' to attack */
	private final double minDistanceSq;

	/** Current attack target */
	private EntityLivingBase attackTarget;

	/** Number of ticks target has been out of sight */
	private int unseenTimer;

	/** Maximum time target can remain out of sight before caster aborts spell */
	private static final int MAX_TIME_UNSEEN = 10;

	public AIMuBunearyChannelConfuse(EntityMuBuneary muBuneary, float range) 
	{
		super(muBuneary, 3);
		entityMuBuneary = muBuneary;
		minDistanceSq = range * range;
		attackTarget = null;
	}

	public int getAnimationID() 
	{
		return EntityMuBuneary.actionIDCastConfuse;
	}

	public boolean isAutomatic() 
	{
		return false;
	}

	public int getDuration() 
	{
		return attackDuration;
	}

	/**
	 * Forcefully interrupts the spell-casting attempt, such as when taking damage
	 */
	public void interruptCasting() 
	{
		resetTask();
	}

	@Override
	public boolean continueExecuting() 
	{
		if (attackTarget == null) 
		{
			return false;
		} 
		else if (castingTimer < 1) 
		{
			return false;
		} 
		else if (!entityMuBuneary.getEntitySenses().canSee(attackTarget) && ++unseenTimer > MAX_TIME_UNSEEN) 
		{
			unseenTimer = 0;
			return false;
		}

		return entityMuBuneary.getDistanceSq(attackTarget.posX, attackTarget.boundingBox.minY, attackTarget.posZ) < minDistanceSq;
	}

	@Override
	public boolean shouldExecute() 
	{
		EntityLivingBase target = entityMuBuneary.getAttackTarget();

		if (target == null) 
		{
			return false;
		}
		else if (!entityMuBuneary.canCastConfuse())
		{
			return false;
		}

		attackTarget = target;
		double d = entityMuBuneary.getDistanceSq(attackTarget.posX, attackTarget.boundingBox.minY, attackTarget.posZ);
		boolean flag = entityMuBuneary.getEntitySenses().canSee(attackTarget);

		if (!flag) 
		{
			interruptCasting(); // calls resetTask
			return false;
		}

		if (castingTimer == 0) 
		{
			entityMuBuneary.getLookHelper().setLookPositionWithEntity(attackTarget, 30.0F, 30.0F);

			if (d > minDistanceSq || !flag) 
			{
				return false;
			}

			castingTimer = attackDuration;

			return castingTimer > 0;
		}

		return false;
	}

	@Override
	public void startExecuting() 
	{
		super.startExecuting();
		entityMuBuneary.getNavigator().clearPathEntity();
	}

	@Override
	public void resetTask() 
	{
		attackTarget = null;
		castingTimer = 0;
		unseenTimer = 0;
		
		super.resetTask();
	}

	@Override
	public void updateTask() 
	{
		if (castingTimer > 0) 
		{
			--castingTimer;
			entityMuBuneary.getLookHelper().setLookPositionWithEntity(attackTarget, 30.0F, 30.0F);
		}

		if (castingTimer <= 0) 
		{
			byte durationSeconds = 8;

			if (entityMuBuneary.worldObj.difficultySetting == EnumDifficulty.NORMAL)
			{
				durationSeconds = 16;
			}
			else if (entityMuBuneary.worldObj.difficultySetting == EnumDifficulty.HARD)
			{
				durationSeconds = 26;
			}

			((EntityLivingBase)attackTarget).addPotionEffect(new PotionEffect(Potion.confusion.id, durationSeconds * 20, 2));
			entityMuBuneary.toggleConfuseCastability();

			entityMuBuneary.motionY = 0.35D;
		}
	}
}