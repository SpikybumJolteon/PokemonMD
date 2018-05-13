package com.fuzzyacornindustries.pokemonmd.network.client;

import java.io.IOException;

import com.fuzzyacornindustries.pokemonmd.entity.player.PokemonMDPlayerInfo;
import com.fuzzyacornindustries.pokemonmd.network.AbstractMessage.AbstractClientMessage;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

/**
 * 
 * Synchronizes all PlayerInfo data on the client
 *
 */
public class SyncPlayerInfoPacket extends AbstractClientMessage<SyncPlayerInfoPacket>
{
	/** NBTTagCompound used to store and transfer the Player's Info */
	private NBTTagCompound compound;

	public SyncPlayerInfoPacket() {}

	public SyncPlayerInfoPacket(PokemonMDPlayerInfo info) 
	{
		compound = new NBTTagCompound();
		info.saveNBTData(compound);
	}

	/**
	 * Sets validate to false for reset skills packets
	 */
	public SyncPlayerInfoPacket setReset() 
	{
		return this;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException 
	{
		compound = buffer.readNBTTagCompoundFromBuffer();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException 
	{
		buffer.writeNBTTagCompoundToBuffer(compound);
	}

	@Override
	protected void process(EntityPlayer player, Side side) 
	{
		PokemonMDPlayerInfo info = PokemonMDPlayerInfo.get(player);
		info.loadNBTData(compound);
	}
}