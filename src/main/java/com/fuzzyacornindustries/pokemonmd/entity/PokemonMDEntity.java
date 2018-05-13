package com.fuzzyacornindustries.pokemonmd.entity;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityBloodmoonFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityNormalFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
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
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityBlightOoze;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityBloodmoonFireball;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityFireworkMissile;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityHunterBolt;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityIonianFireball;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntitySmallNormalFireball;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.PokemonMDArrow;
import com.fuzzyacornindustries.pokemonmd.library.LibraryEntityID;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class PokemonMDEntity
{
	public static void preInit()
	{
		registerEntityMob();
		registerEntityAbility();
		registerEntityProjectiles();
	}

	public static void postInit()
	{
		addSpawnLocations();
	}

	public static void registerEntityMob()
	{
		createEntity(EntityArmoredLuxray.class, EntityArmoredLuxray.getMobName(), LibraryEntityID.ARMORED_LUXRAY);
		createEntity(EntityArmoredShinx.class, EntityArmoredShinx.getMobName(), LibraryEntityID.ARMORED_SHINX);
		createEntity(EntityBandersnatchFennekin.class, EntityBandersnatchFennekin.getMobName(), LibraryEntityID.BANDERSNATCH_FENNEKIN);
		createEntity(EntityClayCommanderDelcatty.class, EntityClayCommanderDelcatty.getMobName(), LibraryEntityID.CLAY_COMMANDER_DELCATTY);
		createEntity(EntityClayCommanderLiepard.class, EntityClayCommanderLiepard.getMobName(), LibraryEntityID.CLAY_COMMANDER_LIEPARD);
		createEntity(EntityClayCommanderMeowsticMale.class, EntityClayCommanderMeowsticMale.getMobName(), LibraryEntityID.CLAY_COMMANDER_MEOWSTIC_MALE);
		createEntity(EntityClayEspurr.class, EntityClayEspurr.getMobName(), LibraryEntityID.CLAY_ESPURR);
		createEntity(EntityClayLuxio.class, EntityClayLuxio.getMobName(), LibraryEntityID.CLAY_LUXIO);
		createEntity(EntityClayMeowth.class, EntityClayMeowth.getMobName(), LibraryEntityID.CLAY_MEOWTH);
		createEntity(EntityClayPurrloin.class, EntityClayPurrloin.getMobName(), LibraryEntityID.CLAY_PURRLOIN);
		createEntity(EntityClayShinx.class, EntityClayShinx.getMobName(), LibraryEntityID.CLAY_SHINX);
		createEntity(EntityClaySkitty.class, EntityClaySkitty.getMobName(), LibraryEntityID.CLAY_SKITTY);
		createEntity(EntityCujoFurfrou.class, EntityCujoFurfrou.getMobName(), LibraryEntityID.CUJO_FURFROU);
		createEntity(EntityCuotlEkans.class, EntityCuotlEkans.getMobName(), LibraryEntityID.CUOTL_EKANS);
		createEntity(EntityDarkGlassManectric.class, EntityDarkGlassManectric.getMobName(), LibraryEntityID.DARK_GLASS_MANECTRIC);
		createEntity(EntityDemonVulpix.class, EntityDemonVulpix.getMobName(), LibraryEntityID.DEMON_VULPIX);
		createEntity(EntityDoomstoneGlaceon.class, EntityDoomstoneGlaceon.getMobName(), LibraryEntityID.DOOMSTONE_GLACEON);
		createEntity(EntityDoomstoneLeafeon.class, EntityDoomstoneLeafeon.getMobName(), LibraryEntityID.DOOMSTONE_LEAFEON);
		createEntity(EntityForcewindEelektrik.class, EntityForcewindEelektrik.getMobName(), LibraryEntityID.FORCEWIND_EELEKTRIK);
		createEntity(EntityGrenadeTogepi.class, EntityGrenadeTogepi.getMobName(), LibraryEntityID.GRENADE_TOGEPI);
		createEntity(EntityInfestedDeerling.class, EntityInfestedDeerling.getMobName(), LibraryEntityID.INFESTED_DEERLING);
		createEntity(EntityProxyPylonCarbink.class, EntityProxyPylonCarbink.getMobName(), LibraryEntityID.PROXY_PYLON_CARBINK);
		createEntity(EntityScrubbyDarmanitan.class, EntityScrubbyDarmanitan.getMobName(), LibraryEntityID.SCRUBBY_DARMANITAN);
		createEntity(EntitySnowSorceressBraixen.class, EntitySnowSorceressBraixen.getMobName(), LibraryEntityID.SNOW_SORCERESS_BRAIXEN);
		createEntity(EntitySwordieMienshao.class, EntitySwordieMienshao.getMobName(), LibraryEntityID.SWORDIE_MIENSHAO);
		createEntity(EntityVegnagunDustox.class, EntityVegnagunDustox.getMobName(), LibraryEntityID.VEGNAGUN_DUSTOX);
		createEntity(EntityVerktoraMightyena.class, EntityVerktoraMightyena.getMobName(), LibraryEntityID.VERKTORA_MIGHTYENA);
		createEntity(EntityVoorstMightyena.class, EntityVoorstMightyena.getMobName(), LibraryEntityID.VOORST_MIGHTYENA);
		createEntity(EntityZealotPawniard.class, EntityZealotPawniard.getMobName(), LibraryEntityID.ZEALOT_PAWNIARD);
		createEntity(EntityZombieFlareon.class, EntityZombieFlareon.getMobName(), LibraryEntityID.ZOMBIE_FLAREON);
		createEntity(EntityZombieLeafeon.class, EntityZombieLeafeon.getMobName(), LibraryEntityID.ZOMBIE_LEAFEON);
		createEntity(EntityZombieUmbreon.class, EntityZombieUmbreon.getMobName(), LibraryEntityID.ZOMBIE_UMBREON);

		// Beta 1.0 Mobs
		createEntity(EntityBloodmoonNinetales.class, EntityBloodmoonNinetales.getMobName(), LibraryEntityID.BLOODMOON_NINETALES);
		createEntity(EntityClayLitten.class, EntityClayLitten.getMobName(), LibraryEntityID.CLAY_LITTEN);
		createEntity(EntityFirecrackerLitten.class, EntityFirecrackerLitten.getMobName(), LibraryEntityID.FIRECRACKER_LITTEN);
		createEntity(EntityFoxfireZorua.class, EntityFoxfireZorua.getMobName(), LibraryEntityID.FOXFIRE_ZORUA);
		createEntity(EntityIonianNinetales.class, EntityIonianNinetales.getMobName(), LibraryEntityID.IONIAN_NINETALES);
		createEntity(EntityOkamiEspeon.class, EntityOkamiEspeon.getMobName(), LibraryEntityID.OKAMI_ESPEON);
		createEntity(EntityOkamiSylveon.class, EntityOkamiSylveon.getMobName(), LibraryEntityID.OKAMI_SYLVEON);
		createEntity(EntityOkamiUmbreon.class, EntityOkamiUmbreon.getMobName(), LibraryEntityID.OKAMI_UMBREON);
		createEntity(EntityTiberiumGrowlithe.class, EntityTiberiumGrowlithe.getMobName(), LibraryEntityID.TIBERIUM_GROWLITHE);

		// Beta 1.1 Mobs
		createEntity(EntityDeathBlossomLurantis.class, EntityDeathBlossomLurantis.getMobName(), LibraryEntityID.DEATH_BLOSSOM_LURANTIS);
		createEntity(EntityPrototurret.class, EntityPrototurret.getTurretName(), LibraryEntityID.PROTOTURRET);
		createEntity(EntityRilfsakComfey.class, EntityRilfsakComfey.getMobName(), LibraryEntityID.RILFSAK_COMFEY);
		createEntity(EntitySubstituteDoll.class, EntitySubstituteDoll.getMobName(), LibraryEntityID.SUBSTITUTE_DOLL);
		createEntity(EntityZerglingNincada.class, EntityZerglingNincada.getMobName(), LibraryEntityID.ZERGLING_NINCADA);
		createEntity(EntityMuBuneary.class, EntityMuBuneary.getMobName(), LibraryEntityID.MU_BUNEARY);
		createEntity(EntityFoxcraftFennekin.class, EntityFoxcraftFennekin.getMobName(), LibraryEntityID.FOXCRAFT_FENNEKIN);
		createEntity(EntityFeywoodAbsol.class, EntityFeywoodAbsol.getMobName(), LibraryEntityID.FEYWOOD_ABSOL);
		createEntity(EntityNecromancerDelphox.class, EntityNecromancerDelphox.getMobName(), LibraryEntityID.NECROMANCER_DELPHOX);

		/*
		createEntity(EntityEnderPopplio.class, EntityEnderPopplio.getMobName(), LibraryEntityID.ENDER_POPPLIO);
		createEntity(EntityRageBomberRowlet.class, EntityRageBomberRowlet.getMobName(), LibraryEntityID.RAGE_BOMBER_ROWLET);

		createEntityMob(EntityFoxfireZorua.class, EntityFoxfireZorua.getMobName(), 0x000000, 0xcd7b00);
		createEntityMob(EntitySunIdolEspeon.class, EntitySunIdolEspeon.getMobName(), 0x492a0d, 0xffe952);

		createEntityMob(EntityPrototurret.class, EntityPrototurret.getTurretName(), 0x0f0f0f, 0x1ced00);

		/********************************
		 * X-alamon update code follows.*
		 ********************************/
		/*
		createEntityMob(EntityBanelingNincada.class, EntityBanelingNincada.getMobName(), 0x3e3712, 0x60fb45);
		createEntityMob(EntityCracklingNincada.class, EntityCracklingNincada.getMobName(), 0x4b2230, 0xdfff00);
		createEntityMob(EntityEvertedGulpin.class, EntityEvertedGulpin.getMobName(), 0x360000, 0xfd0000);
		createEntityMob(EntityNecromancerDelphox.class, EntityNecromancerDelphox.getMobName(), 0x4e6a4a, 0x485047);
		createEntityMob(EntityZerglingNincada.class, EntityZerglingNincada.getMobName(), 0x7e702a, 0x61b293);
		/**/
	}

	public static void registerEntityAbility()
	{
		createEntity(EntityBloodmoonFoxfire.class, "bloodmoonfoxfire", LibraryEntityID.BLOODMOON_FOXFIRE, 64, 2, true);
		createEntity(EntityNormalFoxfire.class, "normalfoxfire", LibraryEntityID.NORMAL_FOXFIRE, 64, 2, true);
	}

	public static void registerEntityProjectiles()
	{
		createEntity(EntityBloodmoonFireball.class, "bloodmoonfireball", LibraryEntityID.BLOODMOON_FIREBALL, 64, 2, true);
		createEntity(EntityIonianFireball.class, "ionianfireball", LibraryEntityID.IONIAN_FIREBALL, 64, 2, true);
		createEntity(EntitySmallNormalFireball.class, "smallnormalfireball", LibraryEntityID.SMALL_NORMAL_FIREBALL, 64, 2, true);
		createEntity(EntityFireworkMissile.class, "fireworkmissile", LibraryEntityID.FIREWORK_MISSILE, 64, 2, true);
		createEntity(PokemonMDArrow.class, "pokemonmdarrow", LibraryEntityID.POKEMONMD_ARROW, 64, 2, true);
		createEntity(EntityHunterBolt.class, "hunterbolt", LibraryEntityID.HUNTER_BOLT, 64, 2, true);
		createEntity(EntityBlightOoze.class, "blightooze", LibraryEntityID.BLIGHT_OOZE, 64, 2, true);
	}

	public static void addSpawnLocations()
	{
		BiomeGenBase[] biomes;
		SpawnListEntry spawnListEntry;

		/***************************
		 * Clay Army Spawns
		 ***************************/
		SpawnListEntry spawnListEntryClayCommanderDelcatty;
		SpawnListEntry spawnListEntryClayCommanderLiepard;
		SpawnListEntry spawnListEntryClayCommanderMeowsticMale;
		SpawnListEntry spawnListEntryClayEspurr;
		SpawnListEntry spawnListEntryClayLitten;
		SpawnListEntry spawnListEntryClayLuxio;
		SpawnListEntry spawnListEntryClayMeowth;
		SpawnListEntry spawnListEntryClayPurrloin;
		SpawnListEntry spawnListEntryClayShinx;
		SpawnListEntry spawnListEntryClaySkitty;

		biomes = BiomeDictionary.getBiomesForType(Type.SANDY);

		spawnListEntryClayCommanderDelcatty = new SpawnListEntry(EntityClayCommanderDelcatty.class, 7, 1, 1);
		spawnListEntryClayCommanderLiepard = new SpawnListEntry(EntityClayCommanderLiepard.class, 12, 1, 1);
		spawnListEntryClayCommanderMeowsticMale = new SpawnListEntry(EntityClayCommanderMeowsticMale.class, 7, 1, 1);
		spawnListEntryClayEspurr = new SpawnListEntry(EntityClayEspurr.class, 100, 3, 6);
		spawnListEntryClayLitten = new SpawnListEntry(EntityClayLitten.class, 140, 3, 6);
		spawnListEntryClayLuxio = new SpawnListEntry(EntityClayLuxio.class, 140, 3, 6);
		spawnListEntryClayMeowth = new SpawnListEntry(EntityClayMeowth.class, 130, 3, 6);
		spawnListEntryClayPurrloin = new SpawnListEntry(EntityClayPurrloin.class, 130, 3, 6);
		spawnListEntryClayShinx = new SpawnListEntry(EntityClayShinx.class, 170, 3, 6);
		spawnListEntryClaySkitty = new SpawnListEntry(EntityClaySkitty.class, 100, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderDelcatty);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderLiepard);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderMeowsticMale);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayEspurr);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLitten);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLuxio);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayMeowth);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayPurrloin);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayShinx);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClaySkitty);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MESA);

		spawnListEntryClayCommanderDelcatty = new SpawnListEntry(EntityClayCommanderDelcatty.class, 10, 1, 1);
		spawnListEntryClayCommanderLiepard = new SpawnListEntry(EntityClayCommanderLiepard.class, 9, 1, 1);
		spawnListEntryClayCommanderMeowsticMale = new SpawnListEntry(EntityClayCommanderMeowsticMale.class, 8, 1, 1);
		spawnListEntryClayEspurr = new SpawnListEntry(EntityClayEspurr.class, 100, 3, 6);
		spawnListEntryClayLitten = new SpawnListEntry(EntityClayLitten.class, 140, 3, 6);
		spawnListEntryClayLuxio = new SpawnListEntry(EntityClayLuxio.class, 140, 3, 6);
		spawnListEntryClayMeowth = new SpawnListEntry(EntityClayMeowth.class, 70, 3, 6);
		spawnListEntryClayPurrloin = new SpawnListEntry(EntityClayPurrloin.class, 100, 3, 6);
		spawnListEntryClayShinx = new SpawnListEntry(EntityClayShinx.class, 170, 3, 6);
		spawnListEntryClaySkitty = new SpawnListEntry(EntityClaySkitty.class, 130, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderDelcatty);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderLiepard);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderMeowsticMale);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayEspurr);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLitten);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLuxio);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayMeowth);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayPurrloin);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayShinx);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClaySkitty);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.JUNGLE);

		spawnListEntryClayCommanderDelcatty = new SpawnListEntry(EntityClayCommanderDelcatty.class, 12, 1, 1);
		spawnListEntryClayCommanderLiepard = new SpawnListEntry(EntityClayCommanderLiepard.class, 6, 1, 1);
		spawnListEntryClayCommanderMeowsticMale = new SpawnListEntry(EntityClayCommanderMeowsticMale.class, 12, 1, 1);
		spawnListEntryClayEspurr = new SpawnListEntry(EntityClayEspurr.class, 100, 3, 6);
		spawnListEntryClayLitten = new SpawnListEntry(EntityClayLitten.class, 30, 1, 2);
		spawnListEntryClayLuxio = new SpawnListEntry(EntityClayLuxio.class, 30, 3, 6);
		spawnListEntryClayMeowth = new SpawnListEntry(EntityClayMeowth.class, 120, 3, 6);
		spawnListEntryClayPurrloin = new SpawnListEntry(EntityClayPurrloin.class, 100, 3, 6);
		spawnListEntryClayShinx = new SpawnListEntry(EntityClayShinx.class, 200, 3, 6);
		spawnListEntryClaySkitty = new SpawnListEntry(EntityClaySkitty.class, 140, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderDelcatty);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderLiepard);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderMeowsticMale);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayEspurr);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLitten);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLuxio);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayMeowth);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayPurrloin);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayShinx);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClaySkitty);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.PLAINS);

		spawnListEntryClayCommanderDelcatty = new SpawnListEntry(EntityClayCommanderDelcatty.class, 9, 1, 1);
		spawnListEntryClayCommanderLiepard = new SpawnListEntry(EntityClayCommanderLiepard.class, 9, 1, 1);
		spawnListEntryClayCommanderMeowsticMale = new SpawnListEntry(EntityClayCommanderMeowsticMale.class, 8, 1, 1);
		spawnListEntryClayEspurr = new SpawnListEntry(EntityClayEspurr.class, 100, 3, 6);
		spawnListEntryClayLitten = new SpawnListEntry(EntityClayLitten.class, 100, 3, 6);
		spawnListEntryClayLuxio = new SpawnListEntry(EntityClayLuxio.class, 140, 3, 6);
		spawnListEntryClayMeowth = new SpawnListEntry(EntityClayMeowth.class, 70, 3, 6);
		spawnListEntryClayPurrloin = new SpawnListEntry(EntityClayPurrloin.class, 70, 3, 6);
		spawnListEntryClayShinx = new SpawnListEntry(EntityClayShinx.class, 150, 3, 6);
		spawnListEntryClaySkitty = new SpawnListEntry(EntityClaySkitty.class, 100, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderDelcatty);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderLiepard);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayCommanderMeowsticMale);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayEspurr);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLitten);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayLuxio);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayMeowth);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayPurrloin);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClayShinx);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryClaySkitty);
			}
		}


		/***************************
		 * Armored Shinx Line
		 ***************************/
		SpawnListEntry spawnListEntryArmoredLuxray;
		SpawnListEntry spawnListEntryArmoredShinx;

		biomes = BiomeDictionary.getBiomesForType(Type.HOT);

		spawnListEntryArmoredLuxray = new SpawnListEntry(EntityArmoredLuxray.class, 6, 1, 1);
		spawnListEntryArmoredShinx = new SpawnListEntry(EntityArmoredShinx.class, 50, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if((BiomeDictionary.isBiomeOfType(biomes[i], Type.DRY) || BiomeDictionary.isBiomeOfType(biomes[i], Type.WASTELAND)) && !BiomeDictionary.isBiomeOfType(biomes[i], Type.SANDY) && !BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredLuxray);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredShinx);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.PLAINS);

		spawnListEntryArmoredLuxray = new SpawnListEntry(EntityArmoredLuxray.class, 12, 1, 1);
		spawnListEntryArmoredShinx = new SpawnListEntry(EntityArmoredShinx.class, 110, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredLuxray);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredShinx);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SAVANNA);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredLuxray);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredShinx);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MESA);

		spawnListEntryArmoredLuxray = new SpawnListEntry(EntityArmoredLuxray.class, 6, 1, 1);
		spawnListEntryArmoredShinx = new SpawnListEntry(EntityArmoredShinx.class, 50, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredLuxray);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredShinx);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SPARSE);

		spawnListEntryArmoredLuxray = new SpawnListEntry(EntityArmoredLuxray.class, 12, 1, 1);
		spawnListEntryArmoredShinx = new SpawnListEntry(EntityArmoredShinx.class, 70, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(BiomeDictionary.isBiomeOfType(biomes[i], Type.SNOWY) && !BiomeDictionary.isBiomeOfType(biomes[i], Type.WET) && !BiomeDictionary.isBiomeOfType(biomes[i], Type.BEACH) && !BiomeDictionary.isBiomeOfType(biomes[i], Type.WATER) && !BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredLuxray);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredShinx);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.HILLS);

		spawnListEntryArmoredLuxray = new SpawnListEntry(EntityArmoredLuxray.class, 10, 1, 1);
		spawnListEntryArmoredShinx = new SpawnListEntry(EntityArmoredShinx.class, 60, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredLuxray);
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryArmoredShinx);
			}
		}

		/***************************
		 * Bandersnatch Fennekin
		 ***************************/
		SpawnListEntry spawnListEntryBandersnatchFennekin;

		biomes = BiomeDictionary.getBiomesForType(Type.COLD);

		spawnListEntryBandersnatchFennekin = new SpawnListEntry(EntityBandersnatchFennekin.class, 80, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.SNOWY))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryBandersnatchFennekin);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		spawnListEntryBandersnatchFennekin = new SpawnListEntry(EntityBandersnatchFennekin.class, 120, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryBandersnatchFennekin);
		}

		biomes = new BiomeGenBase[]{BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus};

		spawnListEntryBandersnatchFennekin = new SpawnListEntry(EntityBandersnatchFennekin.class, 80, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryBandersnatchFennekin);
		}

		/***************************
		 * Bloodmoon Ninetales
		 ***************************/
		SpawnListEntry spawnListEntryBloodmoonNinetales;

		biomes = BiomeDictionary.getBiomesForType(Type.WASTELAND);

		spawnListEntryBloodmoonNinetales = new SpawnListEntry(EntityBloodmoonNinetales.class, 22, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryBloodmoonNinetales);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.DEAD);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryBloodmoonNinetales);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SANDY);

		for(int i = 0; i < biomes.length; i++)
		{
			if(BiomeDictionary.isBiomeOfType(biomes[i], Type.SPARSE))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryBloodmoonNinetales);
			}
		}

		/***************************
		 * Cujo Furfrou
		 ***************************/
		SpawnListEntry spawnListEntryCujoFurfrou;

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		spawnListEntryCujoFurfrou = new SpawnListEntry(EntityCujoFurfrou.class, 110, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryCujoFurfrou);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.FOREST);

		spawnListEntryCujoFurfrou = new SpawnListEntry(EntityCujoFurfrou.class, 110, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.HOT))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryCujoFurfrou);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.HILLS);

		spawnListEntryCujoFurfrou = new SpawnListEntry(EntityCujoFurfrou.class, 90, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.HOT))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryCujoFurfrou);
			}
		}

		/***************************
		 * Cuotl Ekans
		 ***************************/
		SpawnListEntry spawnListEntryCuotlEkans;

		biomes = BiomeDictionary.getBiomesForType(Type.COLD);

		spawnListEntryCuotlEkans = new SpawnListEntry(EntityCuotlEkans.class, 80, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryCuotlEkans);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.JUNGLE);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryCuotlEkans);
			}
		}

		/***************************
		 * Dark Glass Manectric
		 ***************************/
		SpawnListEntry spawnListEntryDarkGlassManectric;

		biomes = BiomeDictionary.getBiomesForType(Type.SANDY);

		spawnListEntryDarkGlassManectric = new SpawnListEntry(EntityDarkGlassManectric.class, 8, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryDarkGlassManectric);
			}
		}

		/***************************
		 * Demon Vulpix
		 ***************************/
		SpawnListEntry spawnListEntryDemonVulpix;

		biomes = BiomeDictionary.getBiomesForType(Type.NETHER);

		spawnListEntryDemonVulpix = new SpawnListEntry(EntityDemonVulpix.class, 60, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryDemonVulpix);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.HOT);

		spawnListEntryDemonVulpix = new SpawnListEntry(EntityDemonVulpix.class, 75, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryDemonVulpix);
		}

		/***************************
		 * Doomstone Glaceon
		 ***************************/
		SpawnListEntry spawnListEntryDoomstoneGlaceon;

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		spawnListEntryDoomstoneGlaceon = new SpawnListEntry(EntityDoomstoneGlaceon.class, 75, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryDoomstoneGlaceon);
			}
		}

		biomes = new BiomeGenBase[]{BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus};

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryDoomstoneGlaceon);
		}

		/***************************
		 * Doomstone Leafeon
		 ***************************/
		SpawnListEntry spawnListEntryDoomstoneLeafeon;

		biomes = BiomeDictionary.getBiomesForType(Type.HILLS);

		spawnListEntryDoomstoneLeafeon = new SpawnListEntry(EntityDoomstoneLeafeon.class, 75, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryDoomstoneLeafeon);
			}
		}

		biomes = new BiomeGenBase[]{BiomeGenBase.plains};

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryDoomstoneGlaceon);
			}
		}

		/***************************
		 * Forcewind Eelektrik
		 ***************************/
		SpawnListEntry spawnListEntryForcewindEelektrik;

		biomes = BiomeDictionary.getBiomesForType(Type.OCEAN);

		spawnListEntryForcewindEelektrik = new SpawnListEntry(EntityForcewindEelektrik.class, 140, 2, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryForcewindEelektrik);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.BEACH);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryForcewindEelektrik);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.RIVER);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryForcewindEelektrik);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SWAMP);

		spawnListEntryForcewindEelektrik = new SpawnListEntry(EntityForcewindEelektrik.class, 100, 2, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryForcewindEelektrik);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.JUNGLE);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryForcewindEelektrik);
			}
		}

		/***************************
		 * Grenade Togepi
		 ***************************/
		SpawnListEntry spawnListEntryGrenadeTogepi;

		biomes = BiomeDictionary.getBiomesForType(Type.HILLS);

		spawnListEntryGrenadeTogepi = new SpawnListEntry(EntityGrenadeTogepi.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.HOT))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryGrenadeTogepi);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		spawnListEntryGrenadeTogepi = new SpawnListEntry(EntityGrenadeTogepi.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.HOT))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryGrenadeTogepi);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.NETHER);

		spawnListEntryGrenadeTogepi = new SpawnListEntry(EntityGrenadeTogepi.class, 60, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryGrenadeTogepi);
		}

		/***************************
		 * Infested Deerling
		 ***************************/
		SpawnListEntry spawnListEntryInfestedDeerling;

		biomes = BiomeDictionary.getBiomesForType(Type.FOREST);

		spawnListEntryInfestedDeerling = new SpawnListEntry(EntityInfestedDeerling.class, 120, 2, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryInfestedDeerling);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SWAMP);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryInfestedDeerling);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.CONIFEROUS);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryInfestedDeerling);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SAVANNA);

		spawnListEntryInfestedDeerling = new SpawnListEntry(EntityInfestedDeerling.class, 80, 2, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryInfestedDeerling);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.JUNGLE);

		spawnListEntryInfestedDeerling = new SpawnListEntry(EntityInfestedDeerling.class, 100, 2, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryInfestedDeerling);
			}
		}

		/***************************
		 * Proxy Pylon Carbink
		 ***************************/
		SpawnListEntry spawnListEntryProxyPylonCarbink;

		biomes = BiomeDictionary.getBiomesForType(Type.FOREST);

		spawnListEntryProxyPylonCarbink = new SpawnListEntry(EntityProxyPylonCarbink.class, 70, 2, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MESA);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.PLAINS);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.HILLS);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SWAMP);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SANDY);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.WASTELAND);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.BEACH);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryProxyPylonCarbink);
			}
		}

		/***************************
		 * Scrubby Darmanitan
		 ***************************/
		SpawnListEntry spawnListEntryScrubbyDarmanitan;

		biomes = BiomeDictionary.getBiomesForType(Type.PLAINS);

		spawnListEntryScrubbyDarmanitan = new SpawnListEntry(EntityScrubbyDarmanitan.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.SANDY))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryScrubbyDarmanitan);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SAVANNA);

		spawnListEntryScrubbyDarmanitan = new SpawnListEntry(EntityScrubbyDarmanitan.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.SANDY))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryScrubbyDarmanitan);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.WASTELAND);

		spawnListEntryScrubbyDarmanitan = new SpawnListEntry(EntityScrubbyDarmanitan.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.SANDY))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryScrubbyDarmanitan);
			}		
		}

		biomes = BiomeDictionary.getBiomesForType(Type.DEAD);

		spawnListEntryScrubbyDarmanitan = new SpawnListEntry(EntityScrubbyDarmanitan.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.SANDY))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryScrubbyDarmanitan);
			}		
		}

		/***************************
		 * Snow Sorceress Braixen
		 ***************************/
		SpawnListEntry spawnListEntrySnowSorceressBraixen;

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		spawnListEntrySnowSorceressBraixen = new SpawnListEntry(EntitySnowSorceressBraixen.class, 75, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntrySnowSorceressBraixen);
		}

		biomes = new BiomeGenBase[]{BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus};

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntrySnowSorceressBraixen);
		}

		/***************************
		 * Swordie Mienshao
		 ***************************/
		SpawnListEntry spawnListEntrySwordieMienshao;

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		spawnListEntrySwordieMienshao = new SpawnListEntry(EntitySwordieMienshao.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntrySwordieMienshao);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.CONIFEROUS);

		spawnListEntrySwordieMienshao = new SpawnListEntry(EntitySwordieMienshao.class, 120, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntrySwordieMienshao);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		spawnListEntrySwordieMienshao = new SpawnListEntry(EntitySwordieMienshao.class, 100, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntrySwordieMienshao);
			}
		}

		/***************************
		 * Tiberium Growlithe
		 ***************************/
		SpawnListEntry spawnListEntryTiberiumGrowlithe;

		biomes = BiomeDictionary.getBiomesForType(Type.PLAINS);

		spawnListEntryTiberiumGrowlithe = new SpawnListEntry(EntityTiberiumGrowlithe.class, 70, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryTiberiumGrowlithe);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SANDY);

		spawnListEntryTiberiumGrowlithe = new SpawnListEntry(EntityTiberiumGrowlithe.class, 90, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryTiberiumGrowlithe);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.WASTELAND);

		spawnListEntryTiberiumGrowlithe = new SpawnListEntry(EntityTiberiumGrowlithe.class, 120, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryTiberiumGrowlithe);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.DEAD);

		spawnListEntryTiberiumGrowlithe = new SpawnListEntry(EntityTiberiumGrowlithe.class, 120, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryTiberiumGrowlithe);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		spawnListEntryTiberiumGrowlithe = new SpawnListEntry(EntityTiberiumGrowlithe.class, 70, 3, 6);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryTiberiumGrowlithe);
			}
		}

		/***************************
		 * Vegnagun Dustox
		 ***************************/
		SpawnListEntry spawnListEntryVegnagunDustox;

		biomes = BiomeDictionary.getBiomesForType(Type.MESA);

		spawnListEntryVegnagunDustox = new SpawnListEntry(EntityVegnagunDustox.class, 4, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryVegnagunDustox);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryVegnagunDustox);
		}

		/***************************
		 * Verktora Mightyena
		 ***************************/
		SpawnListEntry spawnListEntryVerktoraMightyena;

		biomes = BiomeDictionary.getBiomesForType(Type.NETHER);

		spawnListEntryVerktoraMightyena = new SpawnListEntry(EntityVerktoraMightyena.class, 6, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryVerktoraMightyena);
		}

		/***************************
		 * Voorst Mightyena
		 ***************************/
		SpawnListEntry spawnListEntryVoorstMightyena;

		biomes = BiomeDictionary.getBiomesForType(Type.FOREST);

		spawnListEntryVoorstMightyena = new SpawnListEntry(EntityVoorstMightyena.class, 6, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryVoorstMightyena);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SAVANNA);

		spawnListEntryVoorstMightyena = new SpawnListEntry(EntityVoorstMightyena.class, 8, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryVoorstMightyena);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SWAMP);

		spawnListEntryVoorstMightyena = new SpawnListEntry(EntityVoorstMightyena.class, 4, 1, 1);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryVoorstMightyena);
		}

		/***************************
		 * Zergling Nincada
		 ***************************/
		SpawnListEntry spawnListEntryZerglingNincada;

		biomes = BiomeDictionary.getBiomesForType(Type.FOREST);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 110, 4, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			if(BiomeDictionary.isBiomeOfType(biomes[i], Type.COLD))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.PLAINS);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 130, 4, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.SANDY))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SWAMP);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 130, 2, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SAVANNA);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 90, 2, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.WASTELAND);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 90, 2, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.DEAD);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 90, 2, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 70, 2, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 70, 2, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
		}

		biomes = BiomeDictionary.getBiomesForType(Type.NETHER);

		spawnListEntryZerglingNincada = new SpawnListEntry(EntityZerglingNincada.class, 110, 2, 7);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZerglingNincada);
		}


		/***************************
		 * Zombie Flareon
		 ***************************/
		SpawnListEntry spawnListEntryZombieFlareon;

		biomes = BiomeDictionary.getBiomesForType(Type.DRY);

		spawnListEntryZombieFlareon = new SpawnListEntry(EntityZombieFlareon.class, 110, 1, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.COLD))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieFlareon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.NETHER);

		spawnListEntryZombieFlareon = new SpawnListEntry(EntityZombieFlareon.class, 120, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieFlareon);
		}

		/***************************
		 * Zombie Leafeon
		 ***************************/
		SpawnListEntry spawnListEntryZombieLeafeon;

		biomes = BiomeDictionary.getBiomesForType(Type.FOREST);

		spawnListEntryZombieLeafeon = new SpawnListEntry(EntityZombieLeafeon.class, 120, 1, 3);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieLeafeon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SPOOKY);

		spawnListEntryZombieLeafeon = new SpawnListEntry(EntityZombieLeafeon.class, 70, 1, 2);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.SPARSE) && !BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieLeafeon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SWAMP);

		spawnListEntryZombieLeafeon = new SpawnListEntry(EntityZombieLeafeon.class, 100, 1, 3);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieLeafeon);
			}
		}

		/***************************
		 * Zombie Umbreon
		 ***************************/
		SpawnListEntry spawnListEntryZombieUmbreon;

		biomes = BiomeDictionary.getBiomesForType(Type.FOREST);

		spawnListEntryZombieUmbreon = new SpawnListEntry(EntityZombieUmbreon.class, 70, 2, 4);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MESA);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.PLAINS);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.HILLS);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SWAMP);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SANDY);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.SNOWY);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.WASTELAND);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}

		biomes = BiomeDictionary.getBiomesForType(Type.BEACH);

		for(int i = 0; i < biomes.length; i++)
		{
			if(!BiomeDictionary.isBiomeOfType(biomes[i], Type.NETHER))
			{
				biomes[i].getSpawnableList(EnumCreatureType.monster).add(spawnListEntryZombieUmbreon);
			}
		}
	}

	public static void createEntity(Class entityClass, String entityName, int entityID)
	{
		int trackingRange = 64;
		int updateFrequency = 1;
		boolean sendsVelocityUpdates = true;

		EntityRegistry.registerModEntity(entityClass, entityName, entityID, PokemonMDMain.modInstance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

	public static void createEntity(Class entityClass, String entityName, int entityID, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, PokemonMDMain.modInstance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}