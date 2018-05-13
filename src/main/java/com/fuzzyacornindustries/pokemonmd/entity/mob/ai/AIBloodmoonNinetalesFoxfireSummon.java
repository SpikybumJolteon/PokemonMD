package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityBloodmoonFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBloodmoonNinetales;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class AIBloodmoonNinetalesFoxfireSummon extends AIAnimation 
{
	private EntityBloodmoonNinetales entityBloodmoonNinetales;
	private EntityLivingBase attackTarget;

	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 28;

	public AIBloodmoonNinetalesFoxfireSummon(EntityBloodmoonNinetales entityBloodmoonNinetales) 
	{
		super(entityBloodmoonNinetales, 3);
		this.entityBloodmoonNinetales = entityBloodmoonNinetales;
		attackTarget = null;

		this.rand = new Random();
	}

	public int getAnimationID() 
	{
		return LibraryAhriNinetalesAttackID.FOXFIRE_SUMMON;
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
		attackTarget = entityBloodmoonNinetales.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityBloodmoonNinetales.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if(entityBloodmoonNinetales.getAnimationTick() == 1)
			{
				entityBloodmoonNinetales.playLaughSound();
			}
			else if(entityBloodmoonNinetales.getAnimationTick() == 5 ||
					entityBloodmoonNinetales.getAnimationTick() == 12 ||
					entityBloodmoonNinetales.getAnimationTick() == 19)
			{
				if (!entityBloodmoonNinetales.worldObj.isRemote)
				{
					boolean foxfireSummoned = false;
					int numberOfSummonAttempts = 0;

					while (!foxfireSummoned && numberOfSummonAttempts < 30 ) 
					{
						int i = MathHelper.floor_double(entityBloodmoonNinetales.posX);
						int j = MathHelper.floor_double(entityBloodmoonNinetales.posY);
						int k = MathHelper.floor_double(entityBloodmoonNinetales.posZ);

						int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, 1, 2) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
						int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, 1, 2) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
						int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, 1, 2) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);

						if(World.doesBlockHaveSolidTopSurface(entityBloodmoonNinetales.worldObj, i1, j1 - 1, k1) && entityBloodmoonNinetales.worldObj.getBlockLightValue(i1, j1, k1) > 1)
						{
							EntityBloodmoonFoxfire entityMinion = new EntityBloodmoonFoxfire(entityBloodmoonNinetales.worldObj);

							entityMinion.setLocationAndAngles(i1 + 0.5D, j1, k1 + 0.5D, entityBloodmoonNinetales.rotationYaw, entityBloodmoonNinetales.rotationPitch);

							entityMinion.setAttackTarget(attackTarget);

							entityMinion.worldObj.playSoundAtEntity(entityMinion, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
							entityMinion.worldObj.playSoundAtEntity(attackTarget, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

							entityBloodmoonNinetales.worldObj.spawnEntityInWorld(entityMinion);
							
							foxfireSummoned = true;
						}

						numberOfSummonAttempts++;
					}
				}
			}
		}
	}
}