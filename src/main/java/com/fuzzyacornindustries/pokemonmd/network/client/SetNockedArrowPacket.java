package com.fuzzyacornindustries.pokemonmd.network.client;

import java.io.IOException;

import com.fuzzyacornindustries.pokemonmd.entity.player.PokemonMDPlayerInfo;
import com.fuzzyacornindustries.pokemonmd.network.AbstractMessage.AbstractClientMessage;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

/**
 * 
 * Updates the currently nocked arrow on the client, since DataWatcher
 * is apparently unable to handle NULL values.
 * 
 */
public class SetNockedArrowPacket extends AbstractClientMessage<SetNockedArrowPacket>
{
	private ItemStack arrowStack;

	public SetNockedArrowPacket() {}

	public SetNockedArrowPacket(ItemStack arrowStack) 
	{
		this.arrowStack = arrowStack;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException 
	{
		arrowStack = buffer.readItemStackFromBuffer();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException 
	{
		buffer.writeItemStackToBuffer(arrowStack);
	}

	@Override
	protected void process(EntityPlayer player, Side side) 
	{
		PokemonMDPlayerInfo.get(player).setNockedArrow(arrowStack);
	}
}