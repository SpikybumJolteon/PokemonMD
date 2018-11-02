package com.fuzzyacornindustries.pokemonmd.item.turret;

import net.minecraft.entity.EntityLivingBase;

public class TurretPowerItem extends TurretEquipment implements ITurretItemAttack
{
	public TurretPowerItem()
	{
	}
	
	@Override
	public float getAttackPower()
	{
		return 1F;//EntityPrototurret.baseAttackPower;
	}

	public void performAttackStyle(EntityLivingBase attackTarget) 
	{
		// TODO Auto-generated method stub
		
	}
}