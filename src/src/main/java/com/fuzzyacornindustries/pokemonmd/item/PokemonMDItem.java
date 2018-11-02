package com.fuzzyacornindustries.pokemonmd.item;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityArmoredLuxray;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityArmoredShinx;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBandersnatchFennekin;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBloodmoonNinetales;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayCommanderDelcatty;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayCommanderLiepard;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayCommanderMeowsticMale;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayEspurr;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayLitten;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayLuxio;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayMeowth;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayPurrloin;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayShinx;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClaySkitty;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityCujoFurfrou;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityCuotlEkans;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDarkGlassManectric;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDemonVulpix;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDoomstoneGlaceon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDoomstoneLeafeon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityForcewindEelektrik;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityGrenadeTogepi;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityInfestedDeerling;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityMuBuneary;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityNecromancerDelphox;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityProxyPylonCarbink;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityRilfsakComfey;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityScrubbyDarmanitan;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySnowSorceressBraixen;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityTiberiumGrowlithe;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityVegnagunDustox;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityVerktoraMightyena;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityVoorstMightyena;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZealotPawniard;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZerglingNincada;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZombieFlareon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZombieLeafeon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZombieUmbreon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityDeathBlossomLurantis;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFeywoodAbsol;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFirecrackerLitten;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxcraftFennekin;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxfireZorua;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityIonianNinetales;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityOkamiEspeon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityOkamiSylveon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityOkamiUmbreon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntitySmeetaLiepard;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemAttackBoost;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemAttackOrderer;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemBiogaEssence;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemCometEssence;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemDeathBlossomLurantisSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemEssenceRecaller;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFeywoodAbsolSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFiragaEssence;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFirecrackerLittenKOd;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFirecrackerLittenSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFoxcraftFennekinSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFoxfireZoruaKOd;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFoxfireZoruaSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemGravigaEssence;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemIonianNinetalesKOd;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemIonianNinetalesSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemLifeBoost;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiEspeonKOd;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiEspeonSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiSylveonKOd;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiSylveonSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiUmbreonKOd;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemOkamiUmbreonSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemQuakagaEssence;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemSmeetaLiepardSummon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemWatergaEssence;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemBarrierDefender;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemBioCapacitor;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemBiogaCapacitor;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemBioraCapacitor;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemChaosCapacitor;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemFiraCapacitor;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemFiragaCapacitor;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemFireCapacitor;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemMysticInitializer;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemRegenUtility;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.recipes.FuelsFurnace;
import com.fuzzyacornindustries.pokemonmd.render.item.RenderItemBowOfKindred;
import com.fuzzyacornindustries.pokemonmd.render.item.RenderItemKhopeshOfBlight;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.util.EnumHelper;

public class PokemonMDItem
{
	public static void mainRegistry()
	{
		initializeItem();
		registerItem();
	}

	public static void postInt()
	{
		initializeItem();
		registerItem();
	}

	public static ToolMaterial silkscreenMaterial = EnumHelper.addToolMaterial("Silkscreen Tool Material", 2, 350, 4.0F, 2.0F, 18);
	public static ToolMaterial challengerMaterial = EnumHelper.addToolMaterial("Challenger Tool Material", 3, 1561, 8.0F, 3.0F, 20);
	//public static ToolMaterial aiurMaterial = EnumHelper.addToolMaterial("Aiur Tool Material", 3, 2000, 10.0F, 4.0F, 5);

	public static ArmorMaterial silkscreenArmorMaterial = EnumHelper.addArmorMaterial("Silkscreen Armor Material", 15, new int[]{2, 6, 5, 2}, 18);
	public static ArmorMaterial challengerArmorMaterial = EnumHelper.addArmorMaterial("Challenger Armor Material", 33, new int[]{3, 8, 6, 3}, 22);

	public static Item aurumDust;
	public static Item aurumRod;
	public static Item blessingOfArceus;
	public static Item colbertaBerry;
	public static Item deminizer;
	public static Item goldenChaff;
	public static Item infernoFuelRod;
	public static Item neoTiberiumShard;
	public static Item oranianBerry;
	public static Item passhauraBerry;
	public static Item pechitaBerry;
	public static Item pokeraser;
	public static Item rawstettaBerry;
	public static Item reviveSeed;
	public static Item richTiberiumShard;
	public static Item silkscreenAlloy;
	public static Item silkscreenAxe;
	public static Item silkscreenBoots;
	public static Item silkscreenChestplate;
	public static Item silkscreenHelmet;
	public static Item silkscreenHoe;
	public static Item silkscreenLeggings;
	public static Item silkscreenMesh;
	public static Item silkscreenPickaxe;
	public static Item silkscreenShovel;
	public static Item silkscreenSword;
	public static Item spiderkissSword;
	public static Item tiberiumShard;
	public static Item voidScissors;
	public static Item willOfTheAncients;
	public static Item xelNagaCircuit;
	public static Item xelNagaShard;

	public static Item spawnEggArmoredLuxray;
	public static Item spawnEggArmoredShinx;
	public static Item spawnEggBandersnatchFennekin;
	public static Item spawnEggClayCommanderDelcatty;
	public static Item spawnEggClayCommanderLiepard;
	public static Item spawnEggClayCommanderMeowsticMale;
	public static Item spawnEggClayEspurr;
	public static Item spawnEggClayLuxio;
	public static Item spawnEggClayMeowth;
	public static Item spawnEggClayPurrloin;
	public static Item spawnEggClayShinx;
	public static Item spawnEggClaySkitty;
	public static Item spawnEggCujoFurfrou;
	public static Item spawnEggCuotlEkans;
	public static Item spawnEggDarkGlassManectric;
	public static Item spawnEggDemonVulpix;
	public static Item spawnEggDoomstoneGlaceon;
	public static Item spawnEggDoomstoneLeafeon;
	public static Item spawnEggForcewindEelektrik;
	public static Item spawnEggGrenadeTogepi;
	public static Item spawnEggInfestedDeerling;
	public static Item spawnEggProxyPylonCarbink;
	public static Item spawnEggScrubbyDarmanitan;
	public static Item spawnEggSnowSorceressBraixen;
	public static Item spawnEggSwordieMienshao;
	public static Item spawnEggVegnagunDustox;
	public static Item spawnEggVerktoraMightyena;
	public static Item spawnEggVoorstMightyena;
	public static Item spawnEggZealotPawniard;
	public static Item spawnEggZombieFlareon;
	public static Item spawnEggZombieLeafeon;
	public static Item spawnEggZombieUmbreon;

	// Beta 1.0 Additions
	public static Item spawnEggBloodmoonNinetales;
	public static Item spawnEggClayLitten;
	public static Item spawnEggFirecrackerLitten;
	public static Item spawnEggFoxfireZorua;
	public static Item spawnEggIonianNinetales;
	public static Item spawnEggOkamiEspeon;
	public static Item spawnEggOkamiSylveon;
	public static Item spawnEggOkamiUmbreon;
	public static Item spawnEggTiberiumGrowlithe;

	// Beta 1.1 Additions
	public static Item spawnEggDeathBlossomLurantis;
	public static Item spawnEggPrototurret;
	public static Item spawnEggRilfsakComfey;
	public static Item spawnEggZerglingNincada;
	public static Item spawnEggMuBuneary;
	public static Item spawnEggFoxcraftFennekin;
	public static Item spawnEggFeywoodAbsol;
	public static Item spawnEggNecromancerDelphox;
	public static Item spawnEggSmeetaLiepard;

	//public static Item spawnEggEnderPopplio;
	//public static Item spawnEggRageBomberRowlet;

	public static Item abyssalLiquidCrystal;
	public static Item attackOrderer;

	public static Item firecrackerLittenKOd;
	public static Item firecrackerLittenSummon;
	public static Item foxfireZoruaKOd;
	public static Item foxfireZoruaSummon;
	public static Item ionianNinetalesKOd;
	public static Item ionianNinetalesSummon;
	public static Item okamiEspeonKOd;
	public static Item okamiEspeonSummon;
	public static Item okamiSylveonKOd;
	public static Item okamiSylveonSummon;
	public static Item okamiUmbreonKOd;
	public static Item okamiUmbreonSummon;
	public static Item essenceRecaller;
	public static Item dreamFeather;

	// Beta 1.1 Additions
	public static Item bowofkindred;
	public static Item challengerAlloy;
	public static Item clayTablet;
	public static Item emeraldOfChaos;
	public static Item huntersCharge;
	public static Item huntersCharm;
	public static Item khopeshOfBlight;
	public static Item teleportBarrel;
	public static Item verdantCharge;
	public static Item verdantGoo;
	public static Item vespeneCrystal;
	public static Item vespeneFuelRod;
	public static Item warpTech;

	public static Item deathBlossomLurantisSummon;
	public static Item foxcraftFennekinSummon;
	public static Item feywoodAbsolSummon;
	public static Item smeetaLiepardSummon;
	
	public static Item attackBoost;
	public static Item lifeBoost;

	public static Item biogaEssence;
	public static Item firagaEssence;
	public static Item gravigaEssence;
	public static Item quakagaEssence;
	public static Item watergaEssence;

	public static Item barrierDefender;
	public static Item bioCapacitor;
	public static Item bioraCapacitor;
	public static Item biogaCapacitor;
	public static Item chaosCapacitor;
	public static Item fireCapacitor;
	public static Item firaCapacitor;
	public static Item firagaCapacitor;
	public static Item mysticInitializer;
	public static Item regenUtility;

	public static Item substituteDollItem;
	public static Item resilientSubstituteDollItem;
	public static Item obsidianSubstituteDollItem;

	public static Item challengerHelmet;
	public static Item challengerChestplate;
	public static Item challengerLeggings;
	public static Item challengerBoots; 

	// Battlegear Beta 1.1 Additions
	public static Item silkscreenDagger;
	public static Item silkscreenMace;
	public static Item silkscreenSpear;
	public static Item silkscreenWaraxe;
	public static Item spiderkissDagger;
	public static Item spiderkissMace;
	public static Item spiderkissSpear;
	public static Item spiderkissWaraxe;

	// Galacticraft Beta 1.1 Additions
	public static Item cometEssence;

	// Tested to be safe to alphabetize entries.
	public static void initializeItem()
	{
		aurumDust = new ItemAurumDust();
		blessingOfArceus = new ItemBlessingOfArceus();
		colbertaBerry = new ItemBerryColberta(1, 0.1F);
		goldenChaff = new ItemGoldenChaff();
		oranianBerry = new ItemBerryOranian(1, 0.1F);
		passhauraBerry = new ItemBerryPasshaura(1, 0.1F);
		pechitaBerry = new ItemBerryPechita(1, 0.1F);
		rawstettaBerry = new ItemBerryRawstetta(1, 0.1F);
		silkscreenAlloy = new ItemSilkscreenAlloy();
		silkscreenAxe = new ItemSilkscreenAxe();
		silkscreenBoots = new ItemSilkscreenArmor(3);
		silkscreenChestplate = new ItemSilkscreenArmor(1);
		silkscreenHelmet = new ItemSilkscreenArmor(0);
		silkscreenHoe = new ItemSilkscreenHoe();
		silkscreenLeggings = new ItemSilkscreenArmor(2);
		silkscreenMesh = new ItemSilkscreenMesh();
		silkscreenPickaxe = new ItemSilkscreenPickaxe();
		silkscreenShovel = new ItemSilkscreenShovel();
		silkscreenSword = new ItemSilkscreenSword();
		spiderkissSword = new ItemSpiderkissSword();
		voidScissors = new ItemVoidScissors();
		xelNagaCircuit = new ItemXelNagaCircuit();
		xelNagaShard = new ItemXelNagaShard();

		// Beta 1.0 content
		abyssalLiquidCrystal = new ItemAbyssalLiquidCrystal();
		//alloyOfAiur = new ItemAlloyOfAiur();
		aurumRod = new ItemAurumRod();
		deminizer = new ItemDeminizer();
		essenceRecaller = new ItemEssenceRecaller();
		infernoFuelRod = new ItemInfernoFuelRod();
		attackOrderer = new ItemAttackOrderer();
		neoTiberiumShard = new ItemNeoTiberiumShard();
		pokeraser = new ItemPokeraser();
		reviveSeed = new ItemReviveSeed();
		richTiberiumShard = new ItemRichTiberiumShard();
		tiberiumShard = new ItemTiberiumShard();
		willOfTheAncients = new ItemWillOfTheAncients();

		firecrackerLittenSummon = new ItemFirecrackerLittenSummon();
		firecrackerLittenKOd = new ItemFirecrackerLittenKOd();
		foxfireZoruaSummon = new ItemFoxfireZoruaSummon();
		foxfireZoruaKOd = new ItemFoxfireZoruaKOd();
		ionianNinetalesSummon = new ItemIonianNinetalesSummon();
		ionianNinetalesKOd = new ItemIonianNinetalesKOd();
		okamiEspeonSummon = new ItemOkamiEspeonSummon();
		okamiEspeonKOd = new ItemOkamiEspeonKOd();
		okamiSylveonSummon = new ItemOkamiSylveonSummon();
		okamiSylveonKOd = new ItemOkamiSylveonKOd();
		okamiUmbreonSummon = new ItemOkamiUmbreonSummon();
		okamiUmbreonKOd = new ItemOkamiUmbreonKOd();
		dreamFeather = new ItemDreamFeather();

		// Beta 1.1 Content
		bowofkindred = new ItemBowOfKindred();
		challengerAlloy = new ItemChallengerAlloy();
		clayTablet = new ItemClayTablet();
		emeraldOfChaos = new ItemEmeraldOfChaos();
		huntersCharge = new ItemHuntersCharge();
		huntersCharm = new ItemHuntersCharm();
		khopeshOfBlight = new ItemKhopeshOfBlight();
		teleportBarrel = new ItemTeleportBarrel();
		verdantCharge = new ItemVerdantCharge();
		verdantGoo = new ItemVerdantGoo();
		vespeneCrystal = new ItemVespeneCrystal();
		vespeneFuelRod = new ItemVespeneFuelRod();
		warpTech = new ItemWarpTech();

		deathBlossomLurantisSummon = new ItemDeathBlossomLurantisSummon();
		foxcraftFennekinSummon = new ItemFoxcraftFennekinSummon();
		feywoodAbsolSummon = new ItemFeywoodAbsolSummon();
		smeetaLiepardSummon = new ItemSmeetaLiepardSummon();
		
		attackBoost = new ItemAttackBoost();
		lifeBoost = new ItemLifeBoost();

		biogaEssence = new ItemBiogaEssence();
		firagaEssence = new ItemFiragaEssence();
		gravigaEssence = new ItemGravigaEssence();
		quakagaEssence = new ItemQuakagaEssence();
		watergaEssence = new ItemWatergaEssence();

		barrierDefender = new ItemBarrierDefender();
		bioCapacitor = new ItemBioCapacitor();
		bioraCapacitor = new ItemBioraCapacitor();
		biogaCapacitor = new ItemBiogaCapacitor();
		chaosCapacitor = new ItemChaosCapacitor();
		fireCapacitor = new ItemFireCapacitor();
		firaCapacitor = new ItemFiraCapacitor();
		firagaCapacitor = new ItemFiragaCapacitor();
		mysticInitializer = new ItemMysticInitializer();
		regenUtility = new ItemRegenUtility();

		substituteDollItem = new ItemSubstituteDoll();
		resilientSubstituteDollItem = new ItemResilientSubstituteDoll();
		obsidianSubstituteDollItem = new ItemObsidianSubstituteDoll();

		challengerHelmet = new ItemChallengerArmor(0);
		challengerChestplate = new ItemChallengerArmor(1);
		challengerLeggings = new ItemChallengerArmor(2);
		challengerBoots = new ItemChallengerArmor(3); 

		if(PokemonMDMain.isGalacticraftEnabled)
		{
			cometEssence = new ItemCometEssence();
		}

		addMobSpawnItem(spawnEggArmoredLuxray, EntityArmoredLuxray.getMobName(), "Armored Luxray", 0x062518, 0xd9c225);
		addMobSpawnItem(spawnEggArmoredShinx, EntityArmoredShinx.getMobName(), "Armored Shinx", 0xdac329, 0x062518);
		addMobSpawnItem(spawnEggBandersnatchFennekin, EntityBandersnatchFennekin.getMobName(), "Bandersnatch Fennekin", 0xccd9da, 0x29494e);
		addMobSpawnItem(spawnEggClayCommanderDelcatty, EntityClayCommanderDelcatty.getMobName(), "Clay Commander Delcatty", 0x392f1f, 0x6d6d6d);
		addMobSpawnItem(spawnEggClayCommanderLiepard, EntityClayCommanderLiepard.getMobName(), "Clay Commander Liepard", 0x281b37, 0x7d6747);
		addMobSpawnItem(spawnEggClayCommanderMeowsticMale, EntityClayCommanderMeowsticMale.getMobName(), "Clay Commander Meowstic-Male", 0x2e2638, 0xb6a8f9);
		addMobSpawnItem(spawnEggClayEspurr, EntityClayEspurr.getMobName(), "Clay Espurr", 0x322818, 0xb166da);
		addMobSpawnItem(spawnEggClayLuxio, EntityClayLuxio.getMobName(), "Clay Luxio", 0x0eb8ff, 0xf6ff00);
		addMobSpawnItem(spawnEggClayMeowth, EntityClayMeowth.getMobName(), "Clay Meowth", 0x36341a, 0xefefc6);
		addMobSpawnItem(spawnEggClayPurrloin, EntityClayPurrloin.getMobName(), "Clay Purrloin", 0x3d2723, 0xd4a0c8);
		addMobSpawnItem(spawnEggClayShinx, EntityClayShinx.getMobName(), "Clay Shinx", 0x262640, 0x00b4ff);
		addMobSpawnItem(spawnEggClaySkitty, EntityClaySkitty.getMobName(), "Clay Skitty", 0x2e2516, 0xe6bbbb);
		addMobSpawnItem(spawnEggCujoFurfrou, EntityCujoFurfrou.getMobName(), "Cujo Furfrou", 0x7f4415, 0xe86800);
		addMobSpawnItem(spawnEggCuotlEkans, EntityCuotlEkans.getMobName(), "Cuotl Ekans", 0x85959b, 0xa8fffe);
		addMobSpawnItem(spawnEggDarkGlassManectric, EntityDarkGlassManectric.getMobName(), "Dark Glass Manectric", 0x6c7e94, 0x364355);
		addMobSpawnItem(spawnEggDemonVulpix, EntityDemonVulpix.getMobName(), "Demon Vulpix", 0x290f29, 0xffffff);
		addMobSpawnItem(spawnEggDoomstoneGlaceon, EntityDoomstoneGlaceon.getMobName(), "Doomstone Glaceon", 0x70a4ff, 0xf9f9f9);
		addMobSpawnItem(spawnEggDoomstoneLeafeon, EntityDoomstoneLeafeon.getMobName(), "Doomstone Leafeon", 0x747474, 0x689878);
		addMobSpawnItem(spawnEggForcewindEelektrik, EntityForcewindEelektrik.getMobName(), "Forcewind Eelektrik", 0x282954, 0xdbecff);
		addMobSpawnItem(spawnEggGrenadeTogepi, EntityGrenadeTogepi.getMobName(), "Grenade Togepi", 0x302f2a, 0xffe310);
		addMobSpawnItem(spawnEggInfestedDeerling, EntityInfestedDeerling.getMobName(), "Infested Deerling", 0x857450, 0x8801aa);
		addMobSpawnItem(spawnEggProxyPylonCarbink, EntityProxyPylonCarbink.getMobName(), "Proxy Pylon Carbink", 0x27262c, 0x83cfcf);
		addMobSpawnItem(spawnEggScrubbyDarmanitan, EntityScrubbyDarmanitan.getMobName(), "Scrubby Darmanitan", 0xb30c0c, 0xffda10);
		addMobSpawnItem(spawnEggSnowSorceressBraixen, EntitySnowSorceressBraixen.getMobName(), "Snow Sorceress Braixen", 0xbde9f5, 0xfff44b);
		addMobSpawnItem(spawnEggSwordieMienshao, EntitySwordieMienshao.getMobName(), "Swordie Mienshao", 0x2b2e3f, 0x096859);
		addMobSpawnItem(spawnEggVegnagunDustox, EntityVegnagunDustox.getMobName(), "Vegnagun Dustox", 0x9bc131, 0x3ec396);
		addMobSpawnItem(spawnEggVerktoraMightyena, EntityVerktoraMightyena.getMobName(), "Verktora Mightyena", 0x3c261d, 0x000000);
		addMobSpawnItem(spawnEggVoorstMightyena, EntityVoorstMightyena.getMobName(), "Voorst Mightyena", 0xbba559, 0x46390e);
		addMobSpawnItem(spawnEggZealotPawniard, EntityZealotPawniard.getMobName(), "Zealot Pawniard", 0xddc945, 0xa5dcff);
		addMobSpawnItem(spawnEggZombieFlareon, EntityZombieFlareon.getMobName(), "Zombie Flareon", 0xc45721, 0xdecd89);
		addMobSpawnItem(spawnEggZombieLeafeon, EntityZombieLeafeon.getMobName(), "Zombie Leafeon", 0x54802f, 0xb1a886);
		addMobSpawnItem(spawnEggZombieUmbreon, EntityZombieUmbreon.getMobName(), "Zombie Umbreon", 0x000000, 0xffe776);

		// Beta 1.0 Additions
		addMobSpawnItem(spawnEggBloodmoonNinetales, EntityBloodmoonNinetales.getMobName(), "Bloodmoon Ninetales", 0x0b0101, 0xeeeeee);
		addMobSpawnItem(spawnEggClayLitten, EntityClayLitten.getMobName(), "Clay Litten", 0x000000, 0xff0000);
		addMobSpawnItem(spawnEggFirecrackerLitten, EntityFirecrackerLitten.getMobName(), "Firecracker Litten", 0x000000, 0xe93030);
		addMobSpawnItem(spawnEggFoxfireZorua, EntityFoxfireZorua.getMobName(), "Foxfire Zorua", 0x000000, 0xcc7900);
		addMobSpawnItem(spawnEggIonianNinetales, EntityIonianNinetales.getMobName(), "Ionian Ninetales", 0xb7b6cc, 0xb60a0a);
		addMobSpawnItem(spawnEggOkamiEspeon, EntityOkamiEspeon.getMobName(), "Okami Espeon", 0xcab3d2, 0xff0000);
		addMobSpawnItem(spawnEggOkamiSylveon, EntityOkamiSylveon.getMobName(), "Okami Sylveon", 0xfffff5, 0xfba4a4);
		addMobSpawnItem(spawnEggOkamiUmbreon, EntityOkamiUmbreon.getMobName(), "Okami Umbreon", 0x000000, 0xffe776);
		addMobSpawnItem(spawnEggTiberiumGrowlithe, EntityTiberiumGrowlithe.getMobName(), "Tiberium Growlithe", 0x4cff0d, 0x030303);
		
		// Beta 1.1 Additions
		//addMobSpawnItem(spawnEggPrototurret, EntityPrototurret.getTurretName(), "Prototurret", 0x101010, 0x4ca9dd);
		addMobSpawnItem(spawnEggDeathBlossomLurantis, EntityDeathBlossomLurantis.getMobName(), "Death Blossom Lurantis", 0x31334f, 0x67eaeb);
		addMobSpawnItem(spawnEggRilfsakComfey, EntityRilfsakComfey.getMobName(), "Rilfsak Comfey", 0xa0b96e, 0xf80000);
		addMobSpawnItem(spawnEggZerglingNincada, EntityZerglingNincada.getMobName(), "Zergling Nincada", 0x7b6f29, 0x56a888);
		addMobSpawnItem(spawnEggMuBuneary, EntityMuBuneary.getMobName(), "Mu Buneary", 0x3e3833, 0xaaa39c);
		addMobSpawnItem(spawnEggFoxcraftFennekin, EntityFoxcraftFennekin.getMobName(), "Foxcraft Fennekin", 0x351e3b, 0xdf3c1c);
		addMobSpawnItem(spawnEggFeywoodAbsol, EntityFeywoodAbsol.getMobName(), "Feywood Absol", 0x191214, 0xdec1cc);
		addMobSpawnItem(spawnEggNecromancerDelphox, EntityNecromancerDelphox.getMobName(), "Necromancer Delphox", 0x464d45, 0xc7d299);
		addMobSpawnItem(spawnEggSmeetaLiepard, EntitySmeetaLiepard.getMobName(), "Smeeta Liepard", 0x6a5277, 0xf9d878);

		//addMobSpawnItem(spawnEggRageBomberRowlet, EntityRageBomberRowlet.getMobName(), "Rage Bomber Rowlet", 0x3b220f, 0x4c663c);
		//addMobSpawnItem(spawnEggEnderPopplio, EntityEnderPopplio.getMobName(), "Ender Popplio", 0x000000, 0xffbcfe);
		//addMobSpawnItem(spawnEgg, Entity.getMobName(), "", );
	}

	public static void registerItem()
	{
		GameRegistry.registerItem(aurumDust, aurumDust.getUnlocalizedName());
		GameRegistry.registerItem(blessingOfArceus, blessingOfArceus.getUnlocalizedName());
		GameRegistry.registerItem(colbertaBerry, colbertaBerry.getUnlocalizedName());
		GameRegistry.registerItem(goldenChaff, goldenChaff.getUnlocalizedName());
		GameRegistry.registerItem(oranianBerry, oranianBerry.getUnlocalizedName());
		GameRegistry.registerItem(passhauraBerry, passhauraBerry.getUnlocalizedName());
		GameRegistry.registerItem(pechitaBerry, pechitaBerry.getUnlocalizedName());
		GameRegistry.registerItem(rawstettaBerry, rawstettaBerry.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenAlloy, silkscreenAlloy.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenAxe, silkscreenAxe.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenBoots, silkscreenBoots.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenChestplate, silkscreenChestplate.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenHelmet, silkscreenHelmet.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenHoe, silkscreenHoe.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenLeggings, silkscreenLeggings.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenMesh, silkscreenMesh.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenPickaxe, silkscreenPickaxe.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenShovel, silkscreenShovel.getUnlocalizedName());
		GameRegistry.registerItem(silkscreenSword, silkscreenSword.getUnlocalizedName());
		GameRegistry.registerItem(spiderkissSword, spiderkissSword.getUnlocalizedName());
		GameRegistry.registerItem(voidScissors, voidScissors.getUnlocalizedName());
		GameRegistry.registerItem(xelNagaCircuit, xelNagaCircuit.getUnlocalizedName());
		GameRegistry.registerItem(xelNagaShard, xelNagaShard.getUnlocalizedName());

		// Beta 1.0 Additions
		GameRegistry.registerItem(abyssalLiquidCrystal, abyssalLiquidCrystal.getUnlocalizedName());
		//GameRegistry.registerItem(alloyOfAiur, alloyOfAiur.getUnlocalizedName());
		GameRegistry.registerItem(aurumRod, aurumRod.getUnlocalizedName());
		GameRegistry.registerItem(deminizer, deminizer.getUnlocalizedName());
		GameRegistry.registerItem(dreamFeather, dreamFeather.getUnlocalizedName());
		GameRegistry.registerItem(essenceRecaller, essenceRecaller.getUnlocalizedName());
		GameRegistry.registerItem(infernoFuelRod, infernoFuelRod.getUnlocalizedName());
		GameRegistry.registerItem(attackOrderer, attackOrderer.getUnlocalizedName());
		GameRegistry.registerItem(neoTiberiumShard, neoTiberiumShard.getUnlocalizedName());
		GameRegistry.registerItem(pokeraser, pokeraser.getUnlocalizedName());
		GameRegistry.registerItem(richTiberiumShard, richTiberiumShard.getUnlocalizedName());
		GameRegistry.registerItem(reviveSeed, reviveSeed.getUnlocalizedName());
		GameRegistry.registerItem(tiberiumShard, tiberiumShard.getUnlocalizedName());
		GameRegistry.registerItem(willOfTheAncients, willOfTheAncients.getUnlocalizedName());

		GameRegistry.registerItem(firecrackerLittenSummon, firecrackerLittenSummon.getUnlocalizedName());
		GameRegistry.registerItem(firecrackerLittenKOd, firecrackerLittenKOd.getUnlocalizedName());
		GameRegistry.registerItem(foxfireZoruaSummon, foxfireZoruaSummon.getUnlocalizedName());
		GameRegistry.registerItem(foxfireZoruaKOd, foxfireZoruaKOd.getUnlocalizedName());
		GameRegistry.registerItem(ionianNinetalesSummon, ionianNinetalesSummon.getUnlocalizedName());
		GameRegistry.registerItem(ionianNinetalesKOd, ionianNinetalesKOd.getUnlocalizedName());
		GameRegistry.registerItem(okamiEspeonSummon, okamiEspeonSummon.getUnlocalizedName());
		GameRegistry.registerItem(okamiEspeonKOd, okamiEspeonKOd.getUnlocalizedName());
		GameRegistry.registerItem(okamiSylveonSummon, okamiSylveonSummon.getUnlocalizedName());
		GameRegistry.registerItem(okamiSylveonKOd, okamiSylveonKOd.getUnlocalizedName());
		GameRegistry.registerItem(okamiUmbreonSummon, okamiUmbreonSummon.getUnlocalizedName());
		GameRegistry.registerItem(okamiUmbreonKOd, okamiUmbreonKOd.getUnlocalizedName());

		GameRegistry.registerFuelHandler(new FuelsFurnace());

		// Beta 1.1 Content
		GameRegistry.registerItem(bowofkindred, bowofkindred.getUnlocalizedName());
		GameRegistry.registerItem(challengerAlloy, challengerAlloy.getUnlocalizedName());
		GameRegistry.registerItem(clayTablet, clayTablet.getUnlocalizedName());
		GameRegistry.registerItem(emeraldOfChaos, emeraldOfChaos.getUnlocalizedName());
		GameRegistry.registerItem(huntersCharge, huntersCharge.getUnlocalizedName());
		GameRegistry.registerItem(huntersCharm, huntersCharm.getUnlocalizedName());
		GameRegistry.registerItem(khopeshOfBlight, khopeshOfBlight.getUnlocalizedName());
		GameRegistry.registerItem(teleportBarrel, teleportBarrel.getUnlocalizedName());
		GameRegistry.registerItem(verdantCharge, verdantCharge.getUnlocalizedName());
		GameRegistry.registerItem(verdantGoo, verdantGoo.getUnlocalizedName());
		GameRegistry.registerItem(vespeneCrystal, vespeneCrystal.getUnlocalizedName());
		GameRegistry.registerItem(vespeneFuelRod, vespeneFuelRod.getUnlocalizedName());
		GameRegistry.registerItem(warpTech, warpTech.getUnlocalizedName());

		GameRegistry.registerItem(deathBlossomLurantisSummon, deathBlossomLurantisSummon.getUnlocalizedName());
		GameRegistry.registerItem(foxcraftFennekinSummon, foxcraftFennekinSummon.getUnlocalizedName());
		GameRegistry.registerItem(feywoodAbsolSummon, feywoodAbsolSummon.getUnlocalizedName());
		GameRegistry.registerItem(smeetaLiepardSummon, smeetaLiepardSummon.getUnlocalizedName());
		
		GameRegistry.registerItem(attackBoost, attackBoost.getUnlocalizedName());
		GameRegistry.registerItem(lifeBoost, lifeBoost.getUnlocalizedName());

		GameRegistry.registerItem(biogaEssence, biogaEssence.getUnlocalizedName());
		GameRegistry.registerItem(firagaEssence, firagaEssence.getUnlocalizedName());
		GameRegistry.registerItem(gravigaEssence, gravigaEssence.getUnlocalizedName());
		GameRegistry.registerItem(quakagaEssence, quakagaEssence.getUnlocalizedName());
		GameRegistry.registerItem(watergaEssence, watergaEssence.getUnlocalizedName());

		GameRegistry.registerItem(barrierDefender, barrierDefender.getUnlocalizedName());
		GameRegistry.registerItem(bioCapacitor, bioCapacitor.getUnlocalizedName());
		GameRegistry.registerItem(bioraCapacitor, bioraCapacitor.getUnlocalizedName());
		GameRegistry.registerItem(biogaCapacitor, biogaCapacitor.getUnlocalizedName());
		GameRegistry.registerItem(chaosCapacitor, chaosCapacitor.getUnlocalizedName());
		GameRegistry.registerItem(fireCapacitor, fireCapacitor.getUnlocalizedName());
		GameRegistry.registerItem(firaCapacitor, firaCapacitor.getUnlocalizedName());
		GameRegistry.registerItem(firagaCapacitor, firagaCapacitor.getUnlocalizedName());
		GameRegistry.registerItem(mysticInitializer, mysticInitializer.getUnlocalizedName());
		GameRegistry.registerItem(regenUtility, regenUtility.getUnlocalizedName());

		GameRegistry.registerItem(substituteDollItem, substituteDollItem.getUnlocalizedName());
		GameRegistry.registerItem(resilientSubstituteDollItem, resilientSubstituteDollItem.getUnlocalizedName());
		GameRegistry.registerItem(obsidianSubstituteDollItem, obsidianSubstituteDollItem.getUnlocalizedName());

		GameRegistry.registerItem(challengerHelmet, challengerHelmet.getUnlocalizedName());
		GameRegistry.registerItem(challengerChestplate, challengerChestplate.getUnlocalizedName());
		GameRegistry.registerItem(challengerLeggings, challengerLeggings.getUnlocalizedName());
		GameRegistry.registerItem(challengerBoots, challengerBoots.getUnlocalizedName());
/*
		if(PokemonMDMain.isBG2Enabled)
		{
			GameRegistry.registerItem(silkscreenDagger, silkscreenDagger.getUnlocalizedName());
			GameRegistry.registerItem(silkscreenMace, silkscreenMace.getUnlocalizedName());
			GameRegistry.registerItem(silkscreenSpear, silkscreenSpear.getUnlocalizedName());
			GameRegistry.registerItem(silkscreenWaraxe, silkscreenWaraxe.getUnlocalizedName());
			GameRegistry.registerItem(spiderkissDagger, spiderkissDagger.getUnlocalizedName());
			GameRegistry.registerItem(spiderkissMace, spiderkissMace.getUnlocalizedName());
			GameRegistry.registerItem(spiderkissSpear, spiderkissSpear.getUnlocalizedName());
			GameRegistry.registerItem(spiderkissWaraxe, spiderkissWaraxe.getUnlocalizedName());
		}*/
		
		if(PokemonMDMain.isGalacticraftEnabled)
		{
			GameRegistry.registerItem(cometEssence, cometEssence.getUnlocalizedName());
		}
	}

	/**
	 * Registers all custom Item renderers
	 */
	@SideOnly(Side.CLIENT)
	public static void registerRenderers() 
	{
		MinecraftForgeClient.registerItemRenderer(PokemonMDItem.bowofkindred, new RenderItemBowOfKindred(0.75F));
		MinecraftForgeClient.registerItemRenderer(PokemonMDItem.khopeshOfBlight, new RenderItemKhopeshOfBlight());
	}

	public static void addMobSpawnItem(Item spawnItem, String mobName, String mobNameFull, int primaryColor, int secondaryColor)
	{
		spawnItem = createCorruptPokemonSpawnItem(mobName, mobNameFull, primaryColor, secondaryColor);

		registerCorruptPokemonSpawnItem(spawnItem, mobName);
	}

	public static CorruptPokemonPlacer createCorruptPokemonSpawnItem(String mobName, String mobNameFull, int primaryColor, int secondaryColor)
	{
		return (CorruptPokemonPlacer) new CorruptPokemonPlacer(mobName, mobNameFull, primaryColor, secondaryColor).setUnlocalizedName("spawnegg" + mobName).setTextureName(ModInfo.MODID + ":spawnegg");
	}

	public static void registerCorruptPokemonSpawnItem(Item spawnItem, String mobName)
	{
		GameRegistry.registerItem(spawnItem, "spawnegg" + mobName);
	}
}