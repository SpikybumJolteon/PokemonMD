package com.fuzzyacornindustries.pokemonmd.network.client;

import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemPoketamableSummon;
import com.fuzzyacornindustries.pokemonmd.network.NetworkHelper.IPacket;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class PoketamableNamePacket implements IPacket
{
    private String user, poketamableName;

    public PoketamableNamePacket()
    {
    }

    public PoketamableNamePacket(String udata, String ndata)
    {
        user = udata;
        poketamableName = ndata;
    }

    @Override
    public void writeBytes(ChannelHandlerContext ctx, ByteBuf bytes)
    {
        ByteBufUtils.writeUTF8String(bytes, user);
        ByteBufUtils.writeUTF8String(bytes, poketamableName);
    }

    @Override
    public void readBytes(ChannelHandlerContext ctx, ByteBuf bytes)
    {
        user = ByteBufUtils.readUTF8String(bytes);
        poketamableName = ByteBufUtils.readUTF8String(bytes);
        EntityPlayerMP p = MinecraftServer.getServer().getConfigurationManager().func_152612_a(user);
        
        if (p != null)
        {
            if (p.getCurrentEquippedItem() != null && p.getCurrentEquippedItem().getItem() instanceof ItemPoketamableSummon)
            {
            	ItemPoketamableSummon.writePoketamableNameToItemStack(p.getCurrentEquippedItem(), poketamableName);
            }
        }
    }
}