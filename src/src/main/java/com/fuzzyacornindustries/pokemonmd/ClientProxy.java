package com.fuzzyacornindustries.pokemonmd;

import java.util.HashMap;
import java.util.Map;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
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
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityEnderPopplio;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityForcewindEelektrik;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityGrenadeTogepi;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityInfestedDeerling;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityMuBuneary;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityNecromancerDelphox;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityProxyPylonCarbink;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityRageBomberRowlet;
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
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.entity.particle.EntityParticleFXBloodmoonFireBlast;
import com.fuzzyacornindustries.pokemonmd.entity.particle.EntityParticleFXBloodmoonFlame;
import com.fuzzyacornindustries.pokemonmd.entity.particle.EntityParticleFXHunterEssence;
import com.fuzzyacornindustries.pokemonmd.entity.particle.EntityParticleFXIonianFlame;
import com.fuzzyacornindustries.pokemonmd.entity.particle.EntityParticleFXNormalFlame;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityBlightOoze;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityBloodmoonFireball;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityFireworkMissile;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityHunterBolt;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityIonianFireball;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntitySmallNormalFireball;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.PokemonMDArrow;
import com.fuzzyacornindustries.pokemonmd.gui.GuiPoketamableRename;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.item.RendererItemPrototurret;
import com.fuzzyacornindustries.pokemonmd.model.armor.ModelChallengerArmor;
import com.fuzzyacornindustries.pokemonmd.render.ability.RenderBloodmoonFoxfire;
import com.fuzzyacornindustries.pokemonmd.render.ability.RenderNormalFoxfire;
import com.fuzzyacornindustries.pokemonmd.render.ability.RenderSubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderArmoredLuxray;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderArmoredShinx;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderBandersnatchFennekin;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderBloodmoonNinetales;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayCommanderDelcatty;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayCommanderLiepard;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayCommanderMeowsticMale;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayEspurr;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayLitten;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayLuxio;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayMeowth;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayPurrloin;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClayShinx;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderClaySkitty;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderCujoFurfrou;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderCuotlEkans;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderDarkGlassManectric;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderDeathBlossomLurantis;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderDemonVulpix;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderDoomstoneGlaceon;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderDoomstoneLeafeon;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderEnderPopplio;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderFeywoodAbsol;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderFirecrackerLitten;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderForcewindEelektrik;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderFoxcraftFennekin;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderFoxfireZorua;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderGrenadeTogepi;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderInfestedDeerling;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderIonianNinetales;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderMuBuneary;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderNecromancerDelphox;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderOkamiEspeon;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderOkamiSylveon;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderOkamiUmbreon;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderProxyPylonCarbink;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderRageBomberRowlet;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderRilfsakComfey;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderScrubbyDarmanitan;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderSmeetaLiepard;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderSnowSorceressBraixen;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderSwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderTiberiumGrowlithe;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderVegnagunDustox;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderVerktoraMightyena;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderVoorstMightyena;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderZealotPawniard;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderZerglingNincada;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderZombieFlareon;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderZombieLeafeon;
import com.fuzzyacornindustries.pokemonmd.render.mob.RenderZombieUmbreon;
import com.fuzzyacornindustries.pokemonmd.render.particle.RenderParticleBloodmoonFlame;
import com.fuzzyacornindustries.pokemonmd.render.particle.RenderParticleFireBlastFlame;
import com.fuzzyacornindustries.pokemonmd.render.particle.RenderParticleHunterEssence;
import com.fuzzyacornindustries.pokemonmd.render.particle.RenderParticleIonianFlame;
import com.fuzzyacornindustries.pokemonmd.render.particle.RenderParticleNormalFlame;
import com.fuzzyacornindustries.pokemonmd.render.projectile.RenderBlightOoze;
import com.fuzzyacornindustries.pokemonmd.render.projectile.RenderBloodmoonFireball;
import com.fuzzyacornindustries.pokemonmd.render.projectile.RenderFireworkMissile;
import com.fuzzyacornindustries.pokemonmd.render.projectile.RenderHunterBolt;
import com.fuzzyacornindustries.pokemonmd.render.projectile.RenderIonianFireball;
import com.fuzzyacornindustries.pokemonmd.render.projectile.RenderPokemonMDArrow;
import com.fuzzyacornindustries.pokemonmd.render.projectile.RenderSmallNormalFireball;
import com.fuzzyacornindustries.pokemonmd.render.turret.RenderPrototurret;
import com.fuzzyacornindustries.pokemonmd.renderer.block.RendererAlchemenisizer;
import com.fuzzyacornindustries.pokemonmd.renderer.block.RendererPrototurret;
import com.fuzzyacornindustries.pokemonmd.renderer.block.RendererTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.renderer.block.RendererVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.renderer.block.RendererVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.renderer.block.RendererXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.renderer.block.RendererXelNagaPylon;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityAlchemenisizer;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaPylon;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	private Timer mcTimer;

	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityArmoredLuxray.class, new RenderArmoredLuxray());
		RenderingRegistry.registerEntityRenderingHandler(EntityArmoredShinx.class, new RenderArmoredShinx());
		RenderingRegistry.registerEntityRenderingHandler(EntityBandersnatchFennekin.class, new RenderBandersnatchFennekin());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayCommanderDelcatty.class, new RenderClayCommanderDelcatty());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayCommanderLiepard.class, new RenderClayCommanderLiepard());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayCommanderMeowsticMale.class, new RenderClayCommanderMeowsticMale());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayEspurr.class, new RenderClayEspurr());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayLuxio.class, new RenderClayLuxio());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayMeowth.class, new RenderClayMeowth());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayPurrloin.class, new RenderClayPurrloin());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayShinx.class, new RenderClayShinx());
		RenderingRegistry.registerEntityRenderingHandler(EntityClaySkitty.class, new RenderClaySkitty());
		RenderingRegistry.registerEntityRenderingHandler(EntityCujoFurfrou.class, new RenderCujoFurfrou());
		RenderingRegistry.registerEntityRenderingHandler(EntityCuotlEkans.class, new RenderCuotlEkans());
		RenderingRegistry.registerEntityRenderingHandler(EntityDemonVulpix.class, new RenderDemonVulpix());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkGlassManectric.class, new RenderDarkGlassManectric());
		RenderingRegistry.registerEntityRenderingHandler(EntityDoomstoneGlaceon.class, new RenderDoomstoneGlaceon());
		RenderingRegistry.registerEntityRenderingHandler(EntityDoomstoneLeafeon.class, new RenderDoomstoneLeafeon());
		RenderingRegistry.registerEntityRenderingHandler(EntityForcewindEelektrik.class, new RenderForcewindEelektrik());
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenadeTogepi.class, new RenderGrenadeTogepi());
		RenderingRegistry.registerEntityRenderingHandler(EntityInfestedDeerling.class, new RenderInfestedDeerling());
		RenderingRegistry.registerEntityRenderingHandler(EntityProxyPylonCarbink.class, new RenderProxyPylonCarbink());
		RenderingRegistry.registerEntityRenderingHandler(EntityScrubbyDarmanitan.class, new RenderScrubbyDarmanitan());
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowSorceressBraixen.class, new RenderSnowSorceressBraixen());
		RenderingRegistry.registerEntityRenderingHandler(EntitySwordieMienshao.class, new RenderSwordieMienshao());
		RenderingRegistry.registerEntityRenderingHandler(EntityVegnagunDustox.class, new RenderVegnagunDustox());
		RenderingRegistry.registerEntityRenderingHandler(EntityVerktoraMightyena.class, new RenderVerktoraMightyena());
		RenderingRegistry.registerEntityRenderingHandler(EntityVoorstMightyena.class, new RenderVoorstMightyena());
		RenderingRegistry.registerEntityRenderingHandler(EntityZealotPawniard.class, new RenderZealotPawniard());
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieFlareon.class, new RenderZombieFlareon());
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieLeafeon.class, new RenderZombieLeafeon());
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieUmbreon.class, new RenderZombieUmbreon());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVerdantPurifier.class, new RendererVerdantPurifier());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityXelNagaDynamo.class, new RendererXelNagaDynamo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityXelNagaPylon.class, new RendererXelNagaPylon());

		// Beta 1.0 Additions
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodmoonNinetales.class, new RenderBloodmoonNinetales());
		RenderingRegistry.registerEntityRenderingHandler(EntityClayLitten.class, new RenderClayLitten());
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderPopplio.class, new RenderEnderPopplio());
		RenderingRegistry.registerEntityRenderingHandler(EntityFirecrackerLitten.class, new RenderFirecrackerLitten());
		RenderingRegistry.registerEntityRenderingHandler(EntityFoxfireZorua.class, new RenderFoxfireZorua());
		RenderingRegistry.registerEntityRenderingHandler(EntityIonianNinetales.class, new RenderIonianNinetales());
		RenderingRegistry.registerEntityRenderingHandler(EntityOkamiEspeon.class, new RenderOkamiEspeon());
		RenderingRegistry.registerEntityRenderingHandler(EntityOkamiSylveon.class, new RenderOkamiSylveon());
		RenderingRegistry.registerEntityRenderingHandler(EntityOkamiUmbreon.class, new RenderOkamiUmbreon());
		RenderingRegistry.registerEntityRenderingHandler(EntityRageBomberRowlet.class, new RenderRageBomberRowlet());
		RenderingRegistry.registerEntityRenderingHandler(EntityTiberiumGrowlithe.class, new RenderTiberiumGrowlithe());

		RenderingRegistry.registerEntityRenderingHandler(EntityBloodmoonFoxfire.class, new RenderBloodmoonFoxfire());
		RenderingRegistry.registerEntityRenderingHandler(EntityNormalFoxfire.class, new RenderNormalFoxfire());

		RenderingRegistry.registerEntityRenderingHandler(EntityParticleFXBloodmoonFlame.class, new RenderParticleBloodmoonFlame());
		RenderingRegistry.registerEntityRenderingHandler(EntityParticleFXIonianFlame.class, new RenderParticleIonianFlame());
		RenderingRegistry.registerEntityRenderingHandler(EntityParticleFXNormalFlame.class, new RenderParticleNormalFlame());
		RenderingRegistry.registerEntityRenderingHandler(EntityParticleFXBloodmoonFireBlast.class, new RenderParticleFireBlastFlame());
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodmoonFireball.class, new RenderBloodmoonFireball());
		RenderingRegistry.registerEntityRenderingHandler(EntityIonianFireball.class, new RenderIonianFireball());
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallNormalFireball.class, new RenderSmallNormalFireball());
		RenderingRegistry.registerEntityRenderingHandler(EntityFireworkMissile.class, new RenderFireworkMissile());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVespeneCondenser.class, new RendererVespeneCondenser());

		// Beta 1.1 Additions
		RenderingRegistry.registerEntityRenderingHandler(EntityDeathBlossomLurantis.class, new RenderDeathBlossomLurantis());
		RenderingRegistry.registerEntityRenderingHandler(EntityPrototurret.class, new RenderPrototurret());
		RenderingRegistry.registerEntityRenderingHandler(EntityRilfsakComfey.class, new RenderRilfsakComfey());
		RenderingRegistry.registerEntityRenderingHandler(EntitySubstituteDoll.class, new RenderSubstituteDoll());
		RenderingRegistry.registerEntityRenderingHandler(EntityZerglingNincada.class, new RenderZerglingNincada());
		RenderingRegistry.registerEntityRenderingHandler(EntityMuBuneary.class, new RenderMuBuneary());
		RenderingRegistry.registerEntityRenderingHandler(EntityFoxcraftFennekin.class, new RenderFoxcraftFennekin());
		RenderingRegistry.registerEntityRenderingHandler(EntityFeywoodAbsol.class, new RenderFeywoodAbsol());
		RenderingRegistry.registerEntityRenderingHandler(EntityNecromancerDelphox.class, new RenderNecromancerDelphox());
		RenderingRegistry.registerEntityRenderingHandler(EntitySmeetaLiepard.class, new RenderSmeetaLiepard());

		RenderingRegistry.registerEntityRenderingHandler(PokemonMDArrow.class, new RenderPokemonMDArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityHunterBolt.class, new RenderHunterBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlightOoze.class, new RenderBlightOoze());

		RenderingRegistry.registerEntityRenderingHandler(EntityParticleFXHunterEssence.class, new RenderParticleHunterEssence());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTabletManufactory.class, new RendererTabletManufactory());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPrototurret.class, new RendererPrototurret());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemenisizer.class, new RendererAlchemenisizer());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PokemonMDBlock.prototurret), new RendererItemPrototurret());

		PokemonMDItem.registerRenderers();

		ModelChallengerArmor modelChallengerArmor = new ModelChallengerArmor(1F);
		ModelChallengerArmor modelChallengerLeggings = new ModelChallengerArmor(0.5F);

		armorModels.put(PokemonMDItem.challengerHelmet, modelChallengerArmor);
		armorModels.put(PokemonMDItem.challengerChestplate, modelChallengerArmor);
		armorModels.put(PokemonMDItem.challengerLeggings, modelChallengerLeggings);
		armorModels.put(PokemonMDItem.challengerBoots, modelChallengerArmor);
	}

	@Override
	public void generateParticleBloodmoonFlame(Entity theEntity)
	{
		double motionX = theEntity.worldObj.rand.nextGaussian() * 0.01D;
		double motionY = theEntity.worldObj.rand.nextGaussian() * 0.01D;
		double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.01D;

		EntityParticleFXBloodmoonFlame bloodmoonFlameParticle = new EntityParticleFXBloodmoonFlame(theEntity.worldObj, theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width - theEntity.width + 0.25F, 
				theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() * theEntity.height * 0.5F - 0.75F, theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width - theEntity.width + 0.25F, motionX, motionY, motionZ);

		theEntity.worldObj.spawnEntityInWorld(bloodmoonFlameParticle);
	}

	@Override
	public void generateParticleNormalFlame(Entity theEntity)
	{
		double motionX = theEntity.worldObj.rand.nextGaussian() * 0.01D;
		double motionY = theEntity.worldObj.rand.nextGaussian() * 0.01D;
		double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.01D;

		EntityParticleFXNormalFlame normalFlameParticle = new EntityParticleFXNormalFlame(theEntity.worldObj, theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width - theEntity.width + 0.25F, 
				theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() * theEntity.height * 0.5F - 0.75F, theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width - theEntity.width + 0.25F, motionX, motionY, motionZ);

		theEntity.worldObj.spawnEntityInWorld(normalFlameParticle);
	}

	@Override
	public void generateParticleBloodmoonFireBlast(Entity theEntity)
	{
		double motionX = (theEntity.worldObj.rand.nextDouble() - 0.5D) * 2.0D;
		double motionY = theEntity.worldObj.rand.nextDouble();
		double motionZ = (theEntity.worldObj.rand.nextDouble() - 0.5D) * 2.0D;

		EntityParticleFXBloodmoonFireBlast fireBlastParticle = new EntityParticleFXBloodmoonFireBlast(theEntity.worldObj, theEntity.posX + (theEntity.worldObj.rand.nextFloat() - 0.5D) * theEntity.width * 10D, 
				theEntity.posY + theEntity.worldObj.rand.nextFloat() * theEntity.height - 0.5F, theEntity.posZ + (theEntity.worldObj.rand.nextFloat() - 0.5D) * theEntity.width * 10D, motionX, motionY, motionZ);

		theEntity.worldObj.spawnEntityInWorld(fireBlastParticle);
	}

	public void generateParticleHunterEssence(Entity theEntity)
	{
		double motionX = theEntity.worldObj.rand.nextDouble() * 0.01D;
		double motionY = theEntity.worldObj.rand.nextDouble() * 0.01D;
		double motionZ = theEntity.worldObj.rand.nextDouble() * 0.01D;

		EntityParticleFXHunterEssence hunterEssenceParticle = new EntityParticleFXHunterEssence(theEntity.worldObj, theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width - theEntity.width + 0.25F, 
				theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() * theEntity.height * 0.5F - 0.75F, theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width - theEntity.width + 0.25F, motionX, motionY, motionZ);

		theEntity.worldObj.spawnEntityInWorld(hunterEssenceParticle);
	}

	@Override
	public void displayPoketamableRenameGui(ItemStack itemStack)
	{
		FMLClientHandler.instance().getClient().displayGuiScreen(new GuiPoketamableRename(itemStack));
	}

	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

	public void initTimer() 
	{
		mcTimer = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), PokemonMDMain.fTimer);
	}

	public float getPartialTick() 
	{
		return mcTimer.renderPartialTicks;
	}

	@Override
	public World getWorldClient() 
	{
		return FMLClientHandler.instance().getWorldClient();
	}

	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) 
	{
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
}