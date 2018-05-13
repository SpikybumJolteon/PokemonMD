package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityNormalFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryFoxfireZoruaAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxfireZorua;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class AIFoxfireZoruaSummonFoxfire extends AIAnimation 
{
	private EntityFoxfireZorua entityFoxfireZorua;
	private EntityLivingBase attackTarget;

	private Random rand;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 26;

	public AIFoxfireZoruaSummonFoxfire(EntityFoxfireZorua entityFoxfireZorua) 
	{
		super(entityFoxfireZorua, 3);
		this.entityFoxfireZorua = entityFoxfireZorua;
		attackTarget = null;

		this.rand = new Random();
	}

	public int getAnimationID() 
	{
		return LibraryFoxfireZoruaAttackID.SUMMON_FOXFIRE;
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
		attackTarget = entityFoxfireZorua.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityFoxfireZorua.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if (entityFoxfireZorua.getAnimationTick() == 4 && entityFoxfireZorua.onGround)
            {
				entityFoxfireZorua.motionY = 0.35D;
            }
			
			if(entityFoxfireZorua.getAnimationTick() == 12)
			{
				if (!entityFoxfireZorua.worldObj.isRemote)
				{
					boolean foxfireSummoned = false;
					int numberOfSummonAttempts = 0;

					while (!foxfireSummoned && numberOfSummonAttempts < 30 ) 
					{
						int i = MathHelper.floor_double(entityFoxfireZorua.posX);
						int j = MathHelper.floor_double(entityFoxfireZorua.posY);
						int k = MathHelper.floor_double(entityFoxfireZorua.posZ);

						int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, 1, 2) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
						int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, 1, 2) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
						int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, 1, 2) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);

						if(World.doesBlockHaveSolidTopSurface(entityFoxfireZorua.worldObj, i1, j1 - 1, k1) && entityFoxfireZorua.worldObj.getBlockLightValue(i1, j1, k1) > 1)
						{
							EntityNormalFoxfire entityMinion = new EntityNormalFoxfire(entityFoxfireZorua.worldObj);

							entityMinion.setLocationAndAngles(i1 + 0.5D, j1, k1 + 0.5D, entityFoxfireZorua.rotationYaw, entityFoxfireZorua.rotationPitch);

							entityMinion.setAttackTarget(attackTarget);

							entityMinion.worldObj.playSoundAtEntity(entityMinion, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

							entityFoxfireZorua.worldObj.spawnEntityInWorld(entityMinion);
							
							entityMinion.setAttackPower(entityFoxfireZorua.getAttackPower() * 0.5F);
							
							foxfireSummoned = true;
						}

						numberOfSummonAttempts++;
					}
				}
			}
		}
	}
}