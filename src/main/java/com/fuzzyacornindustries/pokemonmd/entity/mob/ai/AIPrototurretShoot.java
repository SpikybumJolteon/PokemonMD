package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.AIAnimation;
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.item.turret.ITurretItemAttack;
import com.fuzzyacornindustries.pokemonmd.item.turret.TurretPowerItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AIPrototurretShoot extends AIAnimation 
{
	private EntityPrototurret entityPrototurret;
	private EntityLivingBase attackTarget;
	
	protected Random rand;

	public static final int barrelRecoilDuration = 30;

	public AIPrototurretShoot(EntityPrototurret prototurret) 
	{
		super(prototurret, 3);
		entityPrototurret = prototurret;
		attackTarget = null;
		
		this.rand = new Random();
	}

	public int getAnimationID() 
	{
		return EntityPrototurret.actionIDFireRound;
	}

	public boolean isAutomatic() 
	{
		return true;
	}

	public int getDuration() 
	{
		return barrelRecoilDuration;
	}

	public void startExecuting() 
	{
		super.startExecuting();
		attackTarget = entityPrototurret.getAttackTarget();
	}

	public void updateTask() 
	{	
		if(attackTarget != null)
		{
			entityPrototurret.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);

			if(entityPrototurret.getAnimationTick() == 2 && attackTarget != null)
			{
				float attackPower = EntityPrototurret.baseAttackPower;

				if(entityPrototurret.getStackInSlot(EntityPrototurret.powerItemSlotID) != null)
				{
					if(entityPrototurret.getStackInSlot(EntityPrototurret.powerItemSlotID).getItem() instanceof TurretPowerItem)
					{
						ITurretItemAttack powerItem = (ITurretItemAttack)entityPrototurret.getStackInSlot(EntityPrototurret.powerItemSlotID).getItem();
						
						attackPower = powerItem.getAttackPower();

						powerItem.performAttackStyle(attackTarget);
						/*
						if(entityPrototurret.getStackInSlot(EntityPrototurret.powerItemSlotID).getItem() instanceof ItemChaosCapacitor)
						{
							ItemChaosCapacitor powerSlotItemStack = (ItemChaosCapacitor)entityPrototurret.getStackInSlot(EntityPrototurret.powerItemSlotID).getItem();

							attackPower = powerSlotItemStack.getAttackPower();
						}*/
					}
				}

				entityPrototurret.playSound(ModInfo.MODID + ":mob." + entityPrototurret.getTurretName() + ".attack", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
				attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityPrototurret), attackPower);
			}
		}
	}
}