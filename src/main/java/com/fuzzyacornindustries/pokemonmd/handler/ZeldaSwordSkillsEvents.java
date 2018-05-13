package com.fuzzyacornindustries.pokemonmd.handler;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.IStunImmune;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import zeldaswordskills.entity.ZSSEntityInfo;
import zeldaswordskills.entity.buff.Buff;
import zeldaswordskills.entity.mobs.EntityBlackKnight;
import zeldaswordskills.entity.mobs.EntityGrandWizzrobe;

public class ZeldaSwordSkillsEvents 
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityLivingBase) 
		{
			if(event.entity instanceof IStunImmune)
			{
				ZSSEntityInfo.get((EntityLivingBase) event.entity).applyBuff(Buff.RESIST_STUN, Integer.MAX_VALUE, 100);
			}
		}
	}

	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event) 
	{
		if (event.source.getEntity() instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			EntityLivingBase mob = event.entityLiving;

			if(mob instanceof EntityGrandWizzrobe || mob instanceof EntityBlackKnight)
			{
				ItemStack blessingOfArceus = new ItemStack(PokemonMDItem.blessingOfArceus);

				event.drops.add(new EntityItem(mob.worldObj, mob.posX, mob.posY, mob.posZ, blessingOfArceus.copy()));
			}
		}
	}
}