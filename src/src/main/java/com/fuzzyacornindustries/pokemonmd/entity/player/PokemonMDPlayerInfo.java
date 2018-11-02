package com.fuzzyacornindustries.pokemonmd.entity.player;

import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;
import com.fuzzyacornindustries.pokemonmd.network.client.SetNockedArrowPacket;
import com.fuzzyacornindustries.pokemonmd.network.client.SyncPlayerInfoPacket;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PokemonMDPlayerInfo implements IExtendedEntityProperties
{
	private static final String EXT_PROP_NAME = "PokemonMDPlayerInfo";

	private final EntityPlayer player;

	/** [Bow] Stores the currently nocked arrow in order to avoid the graphical glitch caused by writing to the stack's NBT */
	private ItemStack arrowStack = null;

	public PokemonMDPlayerInfo(EntityPlayer player) 
	{
		this.player = player;
	}

	@Override
	public void init(Entity entity, World world) {}

	/**
	 * If player has not received starting gear, it is provided
	 */
	public void verifyStartingGear() 
	{
		/*
		if ((receivedGear & 1) == 0 && ZSSItems.grantBonusGear(player)) 
		{
			receivedGear |= 1;
		}*/
	}

	/**
	 * Returns the currently nocked arrow for the Hero's Bow, possibly null
	 */
	public ItemStack getNockedArrow() 
	{
		return arrowStack;
	}

	/**
	 * Marks this arrow as nocked in the Hero's Bow
	 * @param stack The current arrow or null if empty
	 */
	public void setNockedArrow(ItemStack stack) 
	{
		arrowStack = stack;

		if (player instanceof EntityPlayerMP) 
		{
			PacketDispatcher.sendTo(new SetNockedArrowPacket(stack), (EntityPlayerMP) player);
		}
	}

	/** Used to register these extended properties for the player during EntityConstructing event */
	public static final void register(EntityPlayer player) 
	{
		player.registerExtendedProperties(EXT_PROP_NAME, new PokemonMDPlayerInfo(player));
	}
	
	/** Returns ExtendedPlayer properties for player */
	public static final PokemonMDPlayerInfo get(EntityPlayer player) 
	{
		return (PokemonMDPlayerInfo) player.getExtendedProperties(EXT_PROP_NAME);
	}

	/**
	 * Called when a player logs in for the first time
	 */
	public void onPlayerLoggedIn() 
	{
		if (player instanceof EntityPlayerMP) 
		{
			verifyStartingGear();
		}
	}

	/**
	 * Call each time the player joins the world to sync data to the client
	 */
	public void onJoinWorld() 
	{
		if (player instanceof EntityPlayerMP) 
		{
			PacketDispatcher.sendTo(new SyncPlayerInfoPacket(this), (EntityPlayerMP) player);
		}
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) 
	{
		//compound.setByte("ZSSGearReceived", receivedGear);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) 
	{
		//receivedGear = compound.getByte("ZSSGearReceived");
	}
}