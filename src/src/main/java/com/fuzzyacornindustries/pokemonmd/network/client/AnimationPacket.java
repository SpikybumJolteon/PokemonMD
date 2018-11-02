package com.fuzzyacornindustries.pokemonmd.network.client;

import java.io.IOException;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.network.AbstractMessage.AbstractClientMessage;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;

public class AnimationPacket implements IMessage 
{
	private byte animationID;
	private int entityID;

	public AnimationPacket() {}

	public AnimationPacket(byte animationByte, int entity) 
	{
		animationID = animationByte;
		entityID = entity;
	}

	@Override
	public void toBytes(ByteBuf buffer) 
	{
		buffer.writeByte(animationID);
		buffer.writeInt(entityID);
	}

	@Override
	public void fromBytes(ByteBuf buffer) 
	{
		animationID = buffer.readByte();
		entityID = buffer.readInt();
	}

	public static class Handler implements IMessageHandler<AnimationPacket, IMessage> 
	{
		@Override
		public IMessage onMessage(AnimationPacket packet, MessageContext ctx) 
		{
			World world = PokemonMDMain.proxy.getWorldClient();
			IAnimatedEntity entity = (IAnimatedEntity)world.getEntityByID(packet.entityID);

			if(entity != null && packet.animationID != -1) 
			{
				entity.setAnimationID(packet.animationID);
				if(packet.animationID == 0) entity.setAnimationTick(0);
			}

			return null;
		}
	}
}