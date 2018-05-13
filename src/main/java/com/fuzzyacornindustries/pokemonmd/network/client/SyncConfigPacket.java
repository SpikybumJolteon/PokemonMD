package com.fuzzyacornindustries.pokemonmd.network.client;

import java.io.IOException;

import com.fuzzyacornindustries.pokemonmd.network.AbstractMessage.AbstractClientMessage;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

/**
 * 
 * Sent to each player as they log in to synchronize certain configuration settings.
 *
 */
public class SyncConfigPacket extends AbstractClientMessage<SyncConfigPacket>
{
	/** Processing calls a static method in Config, so use this field to indicate that it is a valid packet */
	private boolean isValid;
	/** Bit 2 (shift 1) */
	public boolean enableStunPlayer;

	public SyncConfigPacket() {}

	/**
	 * Returns whether packet is valid
	 */
	public final boolean isMessageValid() 
	{
		return isValid;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException 
	{
		short bits = buffer.readShort();
		this.enableStunPlayer = (bits & (0x1 << 1)) > 0;
		this.isValid = true;
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException 
	{
		short bits = 0;
		//bits |= (Config.canPlayersBeStunned() ? (0x1 << 1) : 0x0);
		
		buffer.writeShort(bits);
	}

	@Override
	protected void process(EntityPlayer player, Side side) 
	{
		//Config.syncClientSettings(this);
	}
}