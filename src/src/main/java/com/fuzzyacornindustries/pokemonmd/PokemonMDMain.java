package com.fuzzyacornindustries.pokemonmd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.PokemonMDEntity;
import com.fuzzyacornindustries.pokemonmd.handler.PokemonMDEntityEvents;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.network.NetworkHelper;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;
import com.fuzzyacornindustries.pokemonmd.network.client.PoketamableNamePacket;
import com.fuzzyacornindustries.pokemonmd.recipes.CraftingManager;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = ModInfo.MODID, name = ModInfo.name, version = ModInfo.version)
public class PokemonMDMain
{
	@SidedProxy(clientSide = "com.fuzzyacornindustries.pokemonmd.ClientProxy", serverSide = "com.fuzzyacornindustries.pokemonmd.CommonProxy")
	public static CommonProxy proxy;	

	public static final Logger logger = LogManager.getLogger(ModInfo.MODID);

	public static final String[] fTimer;

	static 
	{
		fTimer = new String[] {"field_71428_T", "S", "timer"};
	}

	@Instance(ModInfo.MODID)
	public static PokemonMDMain modInstance;

	/** Whether mods are loaded */
	public static boolean isBG2Enabled;
	public static boolean isGalacticraftEnabled;
	public static boolean isGalacticraftPlanetsEnabled;
	public static boolean isZeldaSwordSkillsEnabled;
	public static boolean isFoodPlusEnabled;
	public static boolean isThermalFoundationEnabled;

	public NetworkHelper networkHelper;

	public enum GUI_ENUM 
	{
		VERDANT_PURIFIER
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent PreEvent)
	{
		isBG2Enabled = Loader.isModLoaded("battlegear2");
		isGalacticraftEnabled = Loader.isModLoaded("GalacticraftCore");
		isGalacticraftPlanetsEnabled = Loader.isModLoaded("GalacticraftMars");
		isZeldaSwordSkillsEnabled = Loader.isModLoaded("zeldaswordskills");
		isFoodPlusEnabled = Loader.isModLoaded("FoodPlus");
		isThermalFoundationEnabled = Loader.isModLoaded("ThermalFoundation");

		// Registrations MUST be done in this order. 
		// Be sure to check registration orders for unexplained errors.
		PokemonMDCreativeTabs.initializeTabs();

		PokemonMDBlock.mainRegistry();
		PokemonMDItem.mainRegistry();

		PacketDispatcher.preInit();

		networkHelper = new NetworkHelper(ModInfo.CHANNEL2, PoketamableNamePacket.class);

		PokemonMDEntity.preInit();

		// network = NetworkRegistry.INSTANCE.newSimpleChannel("PokemonMD");
		// network.registerMessage(PacketAnimation.Handler.class, PacketAnimation.class, packetIDActionAnimation, Side.CLIENT);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent Event)
	{
		proxy.registerNetworkStuff();

		proxy.registerTileEntities();
		proxy.registerRenderThings();

		MinecraftForge.EVENT_BUS.register(new PokemonMDEntityEvents());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent PostEvent)
	{
		BiomeDictionary.registerAllBiomes();

		proxy.initTimer();

		PokemonMDEntity.postInit();

		CraftingManager.mainRegistry();
	}

	public static boolean isClient() 
	{
		return FMLCommonHandler.instance().getSide().isClient();
	}

	public static boolean isEffectiveClient() 
	{
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	/*
	public static void sendAnimationPacket(IAnimatedEntity entity, int animationID) 
	{
		if(isEffectiveClient()) 
			return;

		entity.setAnimationID(animationID);
		network.sendToAll(new AnimationPacket((byte)animationID, ((Entity)entity).getEntityId()));
	}*/
}