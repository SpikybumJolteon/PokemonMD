package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityNormalFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryFoxfireZoruaAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryUniversalAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxfireZorua;
import com.fuzzyacornindustries.pokemonmd.library.EnumPotionID;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

public class AIGeneralIgnite extends AIAnimation 
{
	private EntityHostilePokemonMD entityAttacker;
	private EntityLivingBase attackTarget;

	/*
	 * For some reason, the tick read in the model class lags behind the AI tick.
	 * Only known fix for now is to make the attack duration longer than end animation.
	 */
	public int attackDuration = 17;

	public AIGeneralIgnite(EntityHostilePokemonMD entityAttacker) 
	{
		super(entityAttacker, 3);
		this.entityAttacker = entityAttacker;
		attackTarget = null;
	}

	public int getAnimationID() 
	{
		return LibraryUniversalAttackID.IGNITE;
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
		attackTarget = entityAttacker.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityAttacker.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if (!entityAttacker.worldObj.isRemote)
			{
				if(entityAttacker.getAnimationTick() == 6)
				{
					if(attackTarget.getActivePotionEffect(Potion.fireResistance) != null)
					{
						attackTarget.removePotionEffect(Potion.fireResistance.id);
					}

					if(attackTarget.getActivePotionEffect(Potion.regeneration) != null)
					{
						attackTarget.removePotionEffect(Potion.regeneration.id);
					}

					if(attackTarget.getActivePotionEffect(Potion.resistance) != null)
					{
						attackTarget.removePotionEffect(Potion.resistance.id);
					}

					if(attackTarget.getActivePotionEffect(Potion.field_76444_x) != null)
					{
						attackTarget.removePotionEffect(Potion.field_76444_x.id);
					}
				}

				if(entityAttacker.getAnimationTick() == 8)
				{
					attackTarget.setFire(30);

					entityAttacker.playIgniteSound(attackTarget);
				}
			}
		}
	}
}