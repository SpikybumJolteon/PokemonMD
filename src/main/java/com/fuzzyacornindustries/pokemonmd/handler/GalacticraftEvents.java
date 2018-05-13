package com.fuzzyacornindustries.pokemonmd.handler;

import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class GalacticraftEvents 
{
	@SubscribeEvent
	public void LivingJumpEvent(LivingJumpEvent event) 
	{
		if (event.entity instanceof TamablePokemon || event.entity instanceof EntityHostilePokemonMD) 
		{
			EntityLivingBase mob = (EntityLivingBase)event.entityLiving;

			mob.motionY = 0.48D / WorldUtil.getGravityFactor(mob);
	        if (mob.motionY < 0.24D) mob.motionY = 0.24D;

	        if (mob.isPotionActive(Potion.jump))
	        {
	        	mob.motionY += (mob.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F;
	        }

	        if (mob.isSprinting())
	        {
	            float f = mob.rotationYaw * 0.017453292F;
	            mob.motionX -= MathHelper.sin(f) * 0.2F;
	            mob.motionZ += MathHelper.cos(f) * 0.2F;
	        }

	        mob.isAirBorne = true;
		}
	}
}