package com.fuzzyacornindustries.pokemonmd.item.turret;

import net.minecraft.entity.EntityLivingBase;

public interface ITurretItemAttack 
{
	void performAttackStyle(EntityLivingBase attackTarget);
	float getAttackPower();
}