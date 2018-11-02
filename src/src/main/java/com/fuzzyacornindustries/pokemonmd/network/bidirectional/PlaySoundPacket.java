package com.fuzzyacornindustries.pokemonmd.network.bidirectional;

import java.io.IOException;

import com.fuzzyacornindustries.pokemonmd.network.AbstractMessage;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

/**
 * 
 * Taken from Zelda Sword Skills by CoolAlias
 * 
 * Plays a sound on the client or server side
 *
 */
public class PlaySoundPacket extends AbstractMessage<PlaySoundPacket>
{
	private String sound;

	private float volume;

	private float pitch;

	/** Coordinates at which to play the sound; used on the server side */
	private double x, y, z;

	public PlaySoundPacket() {}

	public PlaySoundPacket(String sound, float volume, float pitch, double x, double y, double z) 
	{
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Use only when sending to the SERVER to use the entity's coordinates as the center;
	 * if sent to the client, the position coordinates will be ignored.
	 */
	public PlaySoundPacket(String sound, float volume, float pitch, Entity entity) 
	{
		this(sound, volume, pitch, entity.posX, entity.posY, entity.posZ);
	}

	/**
	 * Use only when sending to the CLIENT - the sound will play at the player's position
	 */
	public PlaySoundPacket(String sound, float volume, float pitch) 
	{
		this(sound, volume, pitch, 0, 0, 0);
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException 
	{
		sound = ByteBufUtils.readUTF8String(buffer);
		volume = buffer.readFloat();
		pitch = buffer.readFloat();
		x = buffer.readDouble();
		y = buffer.readDouble();
		z = buffer.readDouble();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException 
	{
		ByteBufUtils.writeUTF8String(buffer, sound);
		buffer.writeFloat(volume);
		buffer.writeFloat(pitch);
		buffer.writeDouble(x);
		buffer.writeDouble(y);
		buffer.writeDouble(z);
	}

	@Override
	protected void process(EntityPlayer player, Side side) 
	{
		if (side.isClient()) 
		{
			player.playSound(sound, volume, pitch);
		} 
		else 
		{
			player.worldObj.playSoundEffect(x, y, z, sound, volume, pitch);
		}
	}
}