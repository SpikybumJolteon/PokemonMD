package com.fuzzyacornindustries.pokemonmd;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.gui.GuiPoketamableRename;
import com.fuzzyacornindustries.pokemonmd.gui.PokemonMDGuiHandler;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityAlchemenisizer;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaPylon;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CommonProxy 
{
	public void registerRenderThings() {}

	public int addArmor(String armor)
	{
		return 0;
	}

	public void registerNetworkStuff()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(PokemonMDMain.modInstance, new PokemonMDGuiHandler());
	}

	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityVerdantPurifier.class, "TileEntityVerdantPurifier");
		GameRegistry.registerTileEntity(TileEntityVespeneCondenser.class, "TileEntityVespeneCondenser");
		GameRegistry.registerTileEntity(TileEntityXelNagaDynamo.class, "TileEntityXelNagaDynamo");
		GameRegistry.registerTileEntity(TileEntityXelNagaPylon.class, "TileEntityXelNagaPylon");

		// Beta 1.1 Content
		GameRegistry.registerTileEntity(TileEntityPrototurret.class, "TileEntityPrototurret");
		GameRegistry.registerTileEntity(TileEntityTabletManufactory.class, "TileEntityTabletManufactory");

		GameRegistry.registerTileEntity(TileEntityAlchemenisizer.class, "TileEntityAlchemenisizer");
		
		/*
		GameRegistry.registerTileEntity(TileEntityMicroFilter.class, "TileEntityMicroFilter");
		GameRegistry.registerTileEntity(TileEntityPrototurret.class, "TileEntityPrototurret");
		 */
	}

	public void generateParticleBloodmoonFlame(Entity theEntity){}

	public void generateParticleNormalFlame(Entity theEntity){}

	public void generateParticleBloodmoonFireBlast(Entity theEntity){}
	
	public void generateParticleHunterEssence(Entity theEntity){}

	public void initTimer() {}

	public void displayPoketamableRenameGui(ItemStack itemStack){}
	
	public float getPartialTick() 
	{
		return 1F;
	}

	public World getWorldClient() 
	{
		return null;
	}

	/**
	 * Returns a side-appropriate EntityPlayer for use during message handling
	 */
	public EntityPlayer getPlayerEntity(MessageContext ctx) 
	{
		return ctx.getServerHandler().playerEntity;
	}
}