package com.fuzzyacornindustries.pokemonmd.network;

import java.io.IOException;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.google.common.base.Throwables;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

/**
 * Taken from Zelda Sword Skills by CoolAlias
 * 
 * A wrapper much like the vanilla packet class, allowing use of PacketBuffer's many
 * useful methods as well as implementing a final version of IMessageHandler which
 * calls {@link #process(EntityPlayer, Side)} on each received message, letting the
 * message handle itself rather than having to add an extra class in each one.
 *
 */
public abstract class AbstractMessage<T extends AbstractMessage<T>> implements IMessage, IMessageHandler <T, IMessage>
{
	/**
	 * Some PacketBuffer methods throw IOException - default handling propagates the exception.
	 * If an IOException is expected but should not be fatal, handle it within this method.
	 */
	protected abstract void read(PacketBuffer buffer) throws IOException;

	/**
	 * Some PacketBuffer methods throw IOException - default handling propagates the exception.
	 * If an IOException is expected but should not be fatal, handle it within this method.
	 */
	protected abstract void write(PacketBuffer buffer) throws IOException;

	/**
	 * Called on whichever side the message is received;
	 * for bidirectional packets, be sure to check side
	 */
	protected abstract void process(EntityPlayer player, Side side);

	/**
	 * If message is sent to the wrong side, an exception will be thrown during handling
	 * @return True if the message is allowed to be handled on the given side
	 */
	protected boolean isValidOnSide(Side side) 
	{
		return true;
	}

	@Override
	public void fromBytes(ByteBuf buffer) 
	{
		try 
		{
			read(new PacketBuffer(buffer));
		} 
		catch (IOException e) 
		{
			throw Throwables.propagate(e);
		}
	}

	@Override
	public void toBytes(ByteBuf buffer) 
	{
		try 
		{
			write(new PacketBuffer(buffer));
		} 
		catch (IOException e) 
		{
			throw Throwables.propagate(e);
		}
	}

	@Override
	public final IMessage onMessage(T msg, MessageContext ctx) 
	{
		if (!msg.isValidOnSide(ctx.side)) 
		{
			throw new RuntimeException("Invalid side " + ctx.side.name() + " for " + msg.getClass().getSimpleName());
		}
		
		msg.process(PokemonMDMain.proxy.getPlayerEntity(ctx), ctx.side);
		return null;
	}

	/**
	 * Messages that can only be sent from the server to the client should use this class
	 */
	public static abstract class AbstractClientMessage<T extends AbstractMessage<T>> extends AbstractMessage<T> 
	{
		@Override
		protected final boolean isValidOnSide(Side side) 
		{
			return side.isClient();
		}
	}

	/**
	 * Messages that can only be sent from the client to the server should use this class
	 */
	public static abstract class AbstractServerMessage<T extends AbstractMessage<T>> extends AbstractMessage<T> 
	{
		@Override
		protected final boolean isValidOnSide(Side side) 
		{
			return side.isServer();
		}
	}
}
