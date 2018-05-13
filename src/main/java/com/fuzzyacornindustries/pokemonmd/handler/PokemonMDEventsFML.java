package com.fuzzyacornindustries.pokemonmd.handler;

import com.fuzzyacornindustries.pokemonmd.entity.player.PokemonMDPlayerInfo;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;
import com.fuzzyacornindustries.pokemonmd.network.client.SyncConfigPacket;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * 
 * Various events on the FML event bus
 *
 */
public class PokemonMDEventsFML 
{
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent event) 
	{
		PokemonMDPlayerInfo.get(event.player).onPlayerLoggedIn();
		
		if (event.player instanceof EntityPlayerMP) 
		{
			PacketDispatcher.sendTo(new SyncConfigPacket(), (EntityPlayerMP) event.player);
		}
	}
}