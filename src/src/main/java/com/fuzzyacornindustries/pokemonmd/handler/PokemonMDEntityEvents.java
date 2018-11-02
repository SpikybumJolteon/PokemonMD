package com.fuzzyacornindustries.pokemonmd.handler;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.entity.player.PokemonMDPlayerInfo;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.PokemonMDArrow;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFoxfireZoruaSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemIonianNinetalesSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiEspeonSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiSylveonSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiUmbreonSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemPoketamableSummon;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class PokemonMDEntityEvents 
{
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) 
	{
		if (event.entity.getClass() != PokemonMDArrow.class && event.entity.getClass() == EntityArrow.class)
		{
			if(((EntityArrow)event.entity).shootingEntity instanceof EntityPlayer)
			{
				if (!event.entity.worldObj.isRemote) 
				{
					PokemonMDArrow pokemonMDArrow = new PokemonMDArrow(((EntityArrow)event.entity).worldObj, ((EntityArrow)event.entity).shootingEntity,
							((EntityArrow)event.entity).posX, ((EntityArrow)event.entity).posY, ((EntityArrow)event.entity).posZ,
							((EntityArrow)event.entity).motionX, ((EntityArrow)event.entity).motionY, ((EntityArrow)event.entity).motionZ, 
							((EntityArrow)event.entity).rotationYaw, ((EntityArrow)event.entity).rotationPitch, 
							((EntityArrow)event.entity).getDamage());

					//Reflection values found at: C:\Users\-user-\.gradle\caches\minecraft\net\minecraftforge\forge\-forgeversion-\ unpacked\conf
					int knockbackStrength = ReflectionHelper.getPrivateValue(EntityArrow.class, (EntityArrow)event.entity, new String[] {"field_70256_ap", "knockbackStrength"});

					pokemonMDArrow.setKnockbackStrength(knockbackStrength);

					if(((EntityArrow)event.entity).isBurning())
					{
						pokemonMDArrow.setFire(100);
					}

					pokemonMDArrow.worldObj.spawnEntityInWorld(pokemonMDArrow);
				}

				event.entity.setDead();
			}
		}
		else if (!event.entity.worldObj.isRemote) 
		{
			if (event.entity instanceof EntityPlayer) 
			{
				PokemonMDPlayerInfo.get((EntityPlayer) event.entity).onJoinWorld();
			}
		}
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityPlayer && PokemonMDPlayerInfo.get((EntityPlayer) event.entity) == null) 
		{
			PokemonMDPlayerInfo.register((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onItemToss(ItemTossEvent event)
	{
		if (!event.entity.worldObj.isRemote)
		{
			EntityItem itemDropped = event.entityItem;
			//System.out.println("PlayerDropsEvent iterating over drop "+itemDropped);

			final Item id = itemDropped.getEntityItem().getItem();

			if (id instanceof ItemPoketamableSummon)
			{
				TamablePokemon poketamable = null;

				if(id == PokemonMDItem.okamiEspeonSummon)
				{
					poketamable = ItemOkamiEspeonSummon.toPoketamableEntity(itemDropped.worldObj, itemDropped.getEntityItem(), event.player);
				}
				else if(id == PokemonMDItem.ionianNinetalesSummon)
				{
					poketamable = ItemIonianNinetalesSummon.toPoketamableEntity(itemDropped.worldObj, itemDropped.getEntityItem(), event.player);
				}
				else if(id == PokemonMDItem.foxfireZoruaSummon)
				{
					poketamable = ItemFoxfireZoruaSummon.toPoketamableEntity(itemDropped.worldObj, itemDropped.getEntityItem(), event.player);
				}
				else if(id == PokemonMDItem.okamiSylveonSummon)
				{
					poketamable = ItemOkamiSylveonSummon.toPoketamableEntity(itemDropped.worldObj, itemDropped.getEntityItem(), event.player);
				}
				else if(id == PokemonMDItem.okamiUmbreonSummon)
				{
					poketamable = ItemOkamiUmbreonSummon.toPoketamableEntity(itemDropped.worldObj, itemDropped.getEntityItem(), event.player);
				}
				
				if(poketamable != null)
				{
					revivePoketamable(event, poketamable, itemDropped);
				}
			}
			else if(id == PokemonMDItem.reviveSeed)
			{
				final List nearEnts = itemDropped.worldObj.getEntitiesWithinAABBExcludingEntity(itemDropped, itemDropped.boundingBox.expand(8D, 8D, 8D));

				for (Object o : nearEnts)
				{
					if (o instanceof EntityItem)
					{
						EntityItem foundItem;

						foundItem = (EntityItem) o;

						if (foundItem.getEntityItem().getItem() instanceof ItemPoketamableSummon)
						{
							TamablePokemon poketamable = null;

							if(foundItem.getEntityItem().getItem() == PokemonMDItem.okamiEspeonSummon)
							{
								poketamable = ItemOkamiEspeonSummon.toPoketamableEntity(itemDropped.worldObj, foundItem.getEntityItem(), event.player);
							}
							else if(foundItem.getEntityItem().getItem() == PokemonMDItem.ionianNinetalesSummon)
							{
								poketamable = ItemIonianNinetalesSummon.toPoketamableEntity(itemDropped.worldObj, foundItem.getEntityItem(), event.player);
							}
							else if(foundItem.getEntityItem().getItem() == PokemonMDItem.foxfireZoruaSummon)
							{
								poketamable = ItemFoxfireZoruaSummon.toPoketamableEntity(itemDropped.worldObj, foundItem.getEntityItem(), event.player);
							}
							else if(foundItem.getEntityItem().getItem() == PokemonMDItem.okamiSylveonSummon)
							{
								poketamable = ItemOkamiSylveonSummon.toPoketamableEntity(itemDropped.worldObj, foundItem.getEntityItem(), event.player);
							}
							else if(foundItem.getEntityItem().getItem() == PokemonMDItem.okamiUmbreonSummon)
							{
								poketamable = ItemOkamiUmbreonSummon.toPoketamableEntity(itemDropped.worldObj, foundItem.getEntityItem(), event.player);
							}

							if(poketamable != null)
							{
								poketamable.setPosition(itemDropped.posX, itemDropped.posY, itemDropped.posZ);
								itemDropped.worldObj.spawnEntityInWorld(poketamable);
								poketamable.setHealth(poketamable.getMaxHealth()); // set full entity health
								event.setCanceled(true);
								foundItem.getEntityItem().stackSize--;

								if (foundItem.getEntityItem().stackSize < 1)
								{
									foundItem.setDead(); // destroy item
								}
							}

							break;
						}
					}
				}
			}
		}
	}

	public void revivePoketamable(ItemTossEvent event, TamablePokemon poketamable, EntityItem itemDropped)
	{
		// poketamable is ko'd. see if it was tossed onto revive seed for revival

		final List nearEnts = itemDropped.worldObj.getEntitiesWithinAABBExcludingEntity(itemDropped, itemDropped.boundingBox.expand(8D, 8D, 8D));

		for (Object o : nearEnts)
		{
			if (o instanceof EntityItem)
			{
				EntityItem foundItem;

				foundItem = (EntityItem) o;

				if (foundItem.getEntityItem().getItem() == PokemonMDItem.reviveSeed)
				{
					poketamable.setPosition(itemDropped.posX, itemDropped.posY, itemDropped.posZ);
					itemDropped.worldObj.spawnEntityInWorld(poketamable);
					poketamable.setHealth(poketamable.getMaxHealth()); // set full entity health
					event.setCanceled(true);
					foundItem.getEntityItem().stackSize--;

					if (foundItem.getEntityItem().stackSize < 1)
					{
						foundItem.setDead(); // destroy item
					}

					break;
				}
			}
		}
	}
}