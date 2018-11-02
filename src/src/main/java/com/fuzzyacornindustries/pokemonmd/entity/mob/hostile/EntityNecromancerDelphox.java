package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.ModMathFunctions;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralIgnite;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralRangedAttacker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AINecromancerDelphoxFlamethrower;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryNecromancerDelphoxAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryUniversalAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityBloodmoonFireball;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityNecromancerDelphox extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity
{
	private IdleAnimationClock earsIdleAnimationClock[] = new IdleAnimationClock[4];
	private IdleAnimationClock bodySwayIdleAnimationClock[] = new IdleAnimationClock[7];
	private IdleAnimationClock armLftIdleAnimationClock[] = new IdleAnimationClock[3];
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[10];
	private IdleAnimationClock wingsIdleAnimationClock[] = new IdleAnimationClock[10];

	static String mobName = "necromancerdelphox";

	private int igniteCooldown;
	private int flashCooldown;
	private int flashCooldownDuration;

	private float proxyVengenceDamage = 15F;
	private double proxyVengenceDistance = 32D;

	private Vector3f preFlashLocation = new Vector3f(0,0,0);
	
	public float maxFireballRange = 10.0F;
	public float attackRange = 20F;

	public EntityNecromancerDelphox(World par1World)
	{
		super(par1World);

		this.setSize(0.5F, 1.9F);
		this.tasks.addTask(1, new EntityAISwimming(this));

		this.tasks.addTask(2, new AINecromancerDelphoxFlamethrower(this));
		this.tasks.addTask(2, new AIGeneralIgnite(this));

		this.tasks.addTask(3, new AIGeneralRangedAttacker(this, 1.0D, 20, 20, attackRange));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

		this.isImmuneToFire = true;
		this.experienceValue = 30;

		igniteCooldown = 0;
		flashCooldown = 0;
		flashCooldownDuration = 20 * 3;

		if(this.worldObj.isRemote)
		{
			setClockDefaults();
		}
	}

	public static String getMobName()
	{
		return mobName;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(45.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(13, new Byte((byte)0));
	}

	@Override
	public int getTotalArmorValue()
	{
		return 6;
	}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
	}

	@Override
	protected void fall(float par1) {}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return false;
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getLivingSound()
	{
		return ModInfo.MODID + ":mob." + getMobName() + ".living";
	}

	@Override
	protected String getHurtSound()
	{
		return ModInfo.MODID + ":mob." + getMobName() + ".hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return ModInfo.MODID + ":mob." + getMobName() + ".death";
	}

	@Override
	protected void func_145780_a(int xCoord, int yCoord, int zCoord, Block blockUnderneath)
	{
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}

	@Override
	public void setInWeb() {}
	
	@Override
	public void onLivingUpdate()
	{
		if (this.isEntityAlive() && this.isEntityInsideOpaqueBlock())
		{
			if (this.teleportRandomly(32D))
			{
				flashCooldown = flashCooldownDuration;
			}
		}

		super.onLivingUpdate();
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(animationID != LibraryNecromancerDelphoxAttackID.NO_ACTION) animationTick++;

		if(igniteCooldown > 0) igniteCooldown--;

		if(flashCooldown > 0)
		{
			flashCooldown--;

			if(flashCooldown > flashCooldownDuration - 10)
			{
				this.worldObj.spawnParticle("largeexplode", preFlashLocation.getX() + this.worldObj.rand.nextFloat() * 2F,
						preFlashLocation.getY() + this.worldObj.rand.nextFloat() * 2F,
						preFlashLocation.getZ() + this.worldObj.rand.nextFloat() * 2F, 1.0D, 0.0D, 0.0D);
			}

			if(flashCooldown > flashCooldownDuration - 15 && flashCooldown < flashCooldownDuration - 5)
			{
				this.worldObj.spawnParticle("largeexplode", this.posX + this.worldObj.rand.nextFloat() * 2F, 
						this.posY + this.worldObj.rand.nextFloat() * 2F, 
						this.posZ + this.worldObj.rand.nextFloat() * 2F, 1.0D, 0.0D, 0.0D);
			}
		}

		if ((double)this.getHealth() <= this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 2D && ticksExisted % 20 == 0 && (int)this.getHealth() > 0)
		{
			int counter = 0;

			counter = ((int)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 2) / (int)this.getHealth();

			if(counter > 10)
			{
				counter = 10;
			}

			while(counter > 0)
			{
				PokemonMDMain.proxy.generateParticleBloodmoonFireBlast(this);

				counter--;
			}

			if ((double)this.getHealth() <= this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 4D)
			{
				counter = ((int)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 4) / (int)this.getHealth() + 1;

				if(counter > 10)
				{
					counter = 10;
				}

				while(counter > 0)
				{
					double motionX = rand.nextGaussian() * 0.02D;
					double motionY = rand.nextGaussian() * 0.02D;
					double motionZ = rand.nextGaussian() * 0.02D;
					worldObj.spawnParticle("largesmoke", posX + rand.nextFloat() * width * 2.0F - width, 
							posY + 0.5D + rand.nextFloat() * height - 1F, posZ + rand.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);

					counter--;
				}
			}
		}
/*
		if(this.worldObj.isRemote)
		{
			incrementPartClocks();
		}*/

		if(!worldObj.isRemote)
		{
			int currentPosY = MathHelper.floor_double(this.posY);
			int currentPoxX = MathHelper.floor_double(this.posX);
			int currentPoxZ = MathHelper.floor_double(this.posZ);
			boolean flag = false;

			for (int l1 = -1; l1 <= 1; ++l1)
			{
				for (int i2 = -1; i2 <= 1; ++i2)
				{
					for (int j = 0; j <= 3; ++j)
					{
						int j2 = currentPoxX + l1;
						int k = currentPosY + j;
						int l = currentPoxZ + i2;
						Block block = this.worldObj.getBlock(j2, k, l);

						if (!block.isAir(worldObj, j2, k, l) && block == Blocks.tallgrass || block instanceof BlockDoublePlant || block instanceof BlockFlower || block instanceof BlockVine || block instanceof BlockWeb || block instanceof BlockCactus)
						{
							flag = this.worldObj.func_147480_a(j2, k, l, true) || flag;
						}
					}
				}
			}
		}
	}

	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			this.dropItem(PokemonMDItem.blessingOfArceus, 1);

			int j;
			int k;

			if(lootingEnchantmentLevel > 0)
			{
				this.dropItem(PokemonMDItem.blessingOfArceus, 1);
			}

			j = this.rand.nextInt(1 + lootingEnchantmentLevel) + 1;

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.ender_pearl, 1);
			}

			j = this.rand.nextInt(6 + lootingEnchantmentLevel) + 1;

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 6);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel) + 1;

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.blaze_rod, 1);
			}

			j = this.rand.nextInt(4 + lootingEnchantmentLevel) + 2;

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.nether_wart, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(Items.golden_apple, 1);
		this.dropItem(PokemonMDItem.willOfTheAncients, 1);
	}

	@Override
	public boolean getCanSpawnHere()
	{
		Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

		if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL)
		{
			BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

			if (this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.worldObj.getCurrentMoonPhaseFactor() == 1.0F)
			{
				if(this.rand.nextInt(3) == 0)
				{
					return super.getCanSpawnHere();
				}
			}
		}

		return false;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		if(animationID == LibraryNecromancerDelphoxAttackID.NO_ACTION)
		{	
			if(targetEntity.isDead)
			{
				resetTargetToAttack();
			}
			else
			{
				int attackWeight = this.rand.nextInt(16);

				if(targetEntity.getHealth() <= 4 && igniteCooldown <= 0)
				{
					PacketDispatcher.sendAnimationPacket(this, LibraryUniversalAttackID.IGNITE);

					igniteCooldown = 30 * 20;
				}
				else
				{
					if(isWithinProxyDeathfireRange(targetEntity))
					{
						targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), proxyVengenceDamage);
					}

					PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.FLAMETHROWER);
				}
				/*
				else if(attackWeight < 2 && !this.isWet() && !targetEntity.isWet())
				{
					if(isWithinProxyDeathfireRange(targetEntity))
					{
						targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), proxyVengenceDamage);
					}

					if(!isInLiquid())
					{
						PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.FOXFIRE_SUMMON);
					}
					else
					{
						PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.FIREBALL);
					}
				}
				else if(attackWeight < 6 && (double)this.getHealth() <= this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 2D)
				{
					if(isWithinProxyDeathfireRange(targetEntity))
					{
						targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), proxyVengenceDamage);
					}

					PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.FOXFIRE_STORM);
				}
				else if(attackWeight < 13 && !isInLiquid())
				{
					if(isWithinProxyDeathfireRange(targetEntity))
					{
						targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), proxyVengenceDamage);
					}

					int currentPosY = MathHelper.floor_double(this.posY);
					int currentPoxX = MathHelper.floor_double(this.posX);
					int currentPoxZ = MathHelper.floor_double(this.posZ);
					boolean flag = false;

					int j2 = currentPoxX;
					int k = currentPosY + 2;
					int l = currentPoxZ;
					Block block = this.worldObj.getBlock(j2, k, l);

					if (block.isAir(worldObj, j2, k, l))
					{
						if((double)this.getHealth() <= this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 2D)
						{
							PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.FIREBLAST);	
						}
						else
						{
							PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.JUMP_FIREBALL);
						}
					}
					else
					{
						PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.FIREBALL);
					}
				}
				else
				{
					if(isWithinProxyDeathfireRange(targetEntity))
					{
						targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), proxyVengenceDamage);
					}

					PacketDispatcher.sendAnimationPacket(this, LibraryNecromancerDelphoxAttackID.FIREBALL);
				}*/
			}
		}
	}

	public boolean isWithinProxyDeathfireRange(EntityLivingBase targetEntity)
	{
		return targetEntity.getDistanceSq(this.posX, this.boundingBox.minY, this.posZ) < proxyVengenceDistance;
	}

	public void attackWithFireball(EntityNecromancerDelphox attackingMob, EntityLivingBase targetEntity, float par2)
	{
		Vector3f spawnFireballPoint = new Vector3f(ModMathFunctions.findShooterOffsetPoint(attackingMob.posX, attackingMob.posZ, 
				targetEntity.posX, targetEntity.posZ, 1F));

		double d0 = targetEntity.posX - spawnFireballPoint.getX();//this.posX;
		double d1 = targetEntity.boundingBox.minY + (double)(targetEntity.height / 2.0F) - (attackingMob.posY + (double)(attackingMob.height / 2.0F));
		double d2 = targetEntity.posZ - spawnFireballPoint.getZ();//this.posZ;

		float f1 = MathHelper.sqrt_float(par2) * 0.2F;
		this.worldObj.playSoundAtEntity(this, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
		this.worldObj.playSoundAtEntity(targetEntity, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

		EntityBloodmoonFireball entitysmallfireball = new EntityBloodmoonFireball(attackingMob.worldObj, attackingMob, 
				spawnFireballPoint.getX(), attackingMob.posY, spawnFireballPoint.getZ(),
				d0 + attackingMob.rand.nextGaussian() * (double)f1, d1, d2 + attackingMob.rand.nextGaussian() * (double)f1, 1.0F, 8F);
		entitysmallfireball.posY = attackingMob.posY + (double)(attackingMob.height / 2.0F);

		this.worldObj.spawnEntityInWorld(entitysmallfireball);
	}

	public void attackWithOffsetFireball(EntityNecromancerDelphox attackingMob, EntityLivingBase targetEntity, float par2)
	{
		float fireballOffsetDistance = 4F;

		float offsetX = (float) (attackingMob.posX + attackingMob.rand.nextFloat() * fireballOffsetDistance * 2F - fireballOffsetDistance);
		float offsetY = (float) (attackingMob.posY + attackingMob.rand.nextFloat() * fireballOffsetDistance);
		float offsetZ = (float) (attackingMob.posZ + attackingMob.rand.nextFloat() * fireballOffsetDistance * 2F - fireballOffsetDistance);

		Vector3f spawnFireballPoint = new Vector3f(offsetX, offsetY, offsetZ);

		double d0 = targetEntity.posX - spawnFireballPoint.getX();//this.posX;
		double d1 = targetEntity.boundingBox.minY + (double)(targetEntity.height / 2.0F) - spawnFireballPoint.getY();
		double d2 = targetEntity.posZ - spawnFireballPoint.getZ();//this.posZ;

		float f1 = MathHelper.sqrt_float(par2) * 2.8F;
		this.worldObj.playSoundAtEntity(this, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
		this.worldObj.playSoundAtEntity(targetEntity, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

		EntityBloodmoonFireball entitysmallfireball = new EntityBloodmoonFireball(attackingMob.worldObj, attackingMob, 
				spawnFireballPoint.getX(), spawnFireballPoint.getY(), spawnFireballPoint.getZ(),
				d0 + attackingMob.rand.nextGaussian() * (double)f1, d1, d2 + attackingMob.rand.nextGaussian() * (double)f1, 1.0F, 8F);

		this.worldObj.spawnEntityInWorld(entitysmallfireball);

		this.worldObj.spawnParticle("largeexplode", entitysmallfireball.posX + this.worldObj.rand.nextFloat() * 2F, 
				entitysmallfireball.posY + this.worldObj.rand.nextFloat() * 2F, 
				entitysmallfireball.posZ + this.worldObj.rand.nextFloat() * 2F, 1.0D, 0.0D, 0.0D);

		//System.out.println( "Test Animation Tick Code in Entity class" );
		//System.out.println( "X = " + Float.toString( spawnFireballPoint.getX() ) + ", Y = " + Float.toString( spawnFireballPoint.getY() ) + ", Z = " + Float.toString( spawnFireballPoint.getZ() ) + ".");
	}

	public void attackWithFireblast(EntityNecromancerDelphox attackingMob, EntityLivingBase targetEntity, float par2)
	{
		Vector3f spawnFireballPoint = new Vector3f(ModMathFunctions.findShooterOffsetPoint(attackingMob.posX, attackingMob.posZ, 
				targetEntity.posX, targetEntity.posZ, 1F));

		float fireBlastAttackPower = 16F;

		double d0 = targetEntity.posX - spawnFireballPoint.getX();//this.posX;
		double d1 = targetEntity.boundingBox.minY + (double)(targetEntity.height / 2.0F) - (attackingMob.posY + (double)(attackingMob.height / 2.0F));
		double d2 = targetEntity.posZ - spawnFireballPoint.getZ();//this.posZ;

		float f1 = MathHelper.sqrt_float(par2) * 0.2F;
		this.worldObj.playSoundAtEntity(this, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
		this.worldObj.playSoundAtEntity(targetEntity, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

		EntityBloodmoonFireball mainEntitysmallfireball = new EntityBloodmoonFireball(attackingMob.worldObj, attackingMob, 
				spawnFireballPoint.getX(), attackingMob.posY, spawnFireballPoint.getZ(),
				d0, d1, d2, 1.0F, fireBlastAttackPower);
		mainEntitysmallfireball.posY = attackingMob.posY + (double)(attackingMob.height / 2.0F);

		float offsetDistance = 0.9f;

		double originX = targetEntity.posX - this.posX;
		double originY = targetEntity.posY - this.posY;
		double originZ = targetEntity.posZ - this.posZ;

		double xzDistance = Math.sqrt(Math.pow(originX,  2D) + Math.pow(originZ,  2D));
		float offsetAngleX = (float)Math.atan2(originY, xzDistance);

		Vector3f topFireballPoint = new Vector3f(0, offsetDistance, 0);
		Vector3f sideFireballPoint = new Vector3f(offsetDistance, 0, 0);
		Vector3f diagonalFireballPoint = new Vector3f(MathHelper.cos((float)Math.toRadians(60)) * offsetDistance,
				-MathHelper.sin((float)Math.toRadians(60)) * offsetDistance, 0F);

		double offsetAngleY = Math.atan2(spawnFireballPoint.getZ() - this.posZ, spawnFireballPoint.getX() - this.posX) - Math.toRadians(90);
		float offsetSin = -(float)Math.sin(offsetAngleY);
		float offsetCos = (float)Math.cos(offsetAngleY);

		/* Top Fireball Sets */
		float newZY[] = new float[2];
		newZY = ModMathFunctions.rotatePointGeneric2D(0, topFireballPoint.getY(), offsetAngleX);

		topFireballPoint.setY(newZY[1]);
		float topFireballHorzOffset = newZY[0];

		for(int i = 1; i <= 2; i++)
		{
			EntityBloodmoonFireball entitysmallfireball = new EntityBloodmoonFireball(attackingMob.worldObj, attackingMob, 
					mainEntitysmallfireball.posX + (double)i * topFireballHorzOffset * offsetSin, 
					mainEntitysmallfireball.posY + (double)i * topFireballPoint.getY(), 
					mainEntitysmallfireball.posZ + (double)i * topFireballHorzOffset * offsetCos,
					d0, d1, d2, 1.0F, fireBlastAttackPower);

			this.worldObj.spawnEntityInWorld(entitysmallfireball);
		}

		/* Side Fireball Sets */
		for(int i = 0; i < 5; i++)
		{
			EntityBloodmoonFireball entitysmallfireball = new EntityBloodmoonFireball(attackingMob.worldObj, attackingMob, 
					mainEntitysmallfireball.posX + offsetCos * (offsetDistance * (i - 2)), mainEntitysmallfireball.posY, mainEntitysmallfireball.posZ - offsetSin * (offsetDistance * (i - 2)),
					d0, d1, d2, 1.0F, fireBlastAttackPower);

			this.worldObj.spawnEntityInWorld(entitysmallfireball);
		}

		/* Diagonal Fireball Sets */
		newZY = new float[2];
		newZY = ModMathFunctions.rotatePointGeneric2D(diagonalFireballPoint.getZ(), diagonalFireballPoint.getY(), offsetAngleX);

		float diagonalFireballHorzOffset = newZY[0];

		for(int i = 1; i <= 2; i++)
		{
			EntityBloodmoonFireball entitysmallfireball = new EntityBloodmoonFireball(attackingMob.worldObj, attackingMob, 
					mainEntitysmallfireball.posX + (double)i * (diagonalFireballHorzOffset * offsetSin + diagonalFireballPoint.getX() * offsetCos), 
					mainEntitysmallfireball.posY + (double)i * newZY[1], 
					mainEntitysmallfireball.posZ + (double)i * (diagonalFireballHorzOffset * offsetCos - diagonalFireballPoint.getX() * offsetSin),
					d0, d1, d2, 1.0F, fireBlastAttackPower);

			this.worldObj.spawnEntityInWorld(entitysmallfireball);
		}

		newZY = ModMathFunctions.rotatePointGeneric2D(-diagonalFireballPoint.getZ(), diagonalFireballPoint.getY(), offsetAngleX);

		diagonalFireballHorzOffset = newZY[0];		

		for(int i = 1; i <= 2; i++)
		{
			EntityBloodmoonFireball entitysmallfireball = new EntityBloodmoonFireball(attackingMob.worldObj, attackingMob, 
					mainEntitysmallfireball.posX + (double)i * (diagonalFireballHorzOffset * offsetSin - diagonalFireballPoint.getX() * offsetCos), 
					mainEntitysmallfireball.posY + (double)i * newZY[1], 
					mainEntitysmallfireball.posZ + (double)i * (diagonalFireballHorzOffset * offsetCos + diagonalFireballPoint.getX() * offsetSin),
					d0, d1, d2, 1.0F, fireBlastAttackPower);

			this.worldObj.spawnEntityInWorld(entitysmallfireball);
		}

		/*
		System.out.println( "Test Fireball Coordinates for Fire Blast" );
		//System.out.println( "MainFireball: " + Double.toString( mainEntitysmallfireball.posX ) + ", " + Double.toString( mainEntitysmallfireball.posY ) + ", " + Double.toString( mainEntitysmallfireball.posZ ));

		System.out.println( "newZY[0]: " + Double.toString( newZY[0] ) );
		System.out.println( "newZY[1]: " + Double.toString( newZY[1] ) );
		System.out.println( "offsetAngleX: " + Double.toString( offsetAngleX ) );
		System.out.println( "offsetCos: " + Double.toString( offsetCos ) );
		System.out.println( "offsetSin: " + Double.toString( offsetSin ) );
		//System.out.println( "TopFireball Vector: " + Float.toString( topFireballPoint.getX()) + ", " + Float.toString( topFireballPoint.getY() ) + ", " + Float.toString( topFireballPoint.getZ()));
		System.out.println( "diagonalFireballHorzOffset * offsetCos: " + Double.toString( diagonalFireballHorzOffset * offsetCos ) );
		System.out.println( "diagonalFireballHorzOffset * offsetSin: " + Double.toString( diagonalFireballHorzOffset * offsetSin ) );

		System.out.println( " " );/**/
	}

	public boolean isInLiquid()
	{
		int currentPosY = MathHelper.floor_double(this.posY);
		int currentPoxX = MathHelper.floor_double(this.posX);
		int currentPoxZ = MathHelper.floor_double(this.posZ);

		for(int i = 0; i < 2; i++)
		{
			int j2 = currentPoxX;
			int k = currentPosY - i;
			int l = currentPoxZ;
			Block block = this.worldObj.getBlock(j2, k, l);

			if (block instanceof BlockLiquid)
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			if (damageSource instanceof EntityDamageSource)
			{
				if((damageSource.getEntity().getDistanceSq(this.posX, this.boundingBox.minY, this.posZ) < 18D || 
						damageSource.getEntity().getDistanceSq(this.posX, this.boundingBox.minY, this.posZ) > Math.pow(attackRange + 3F, 2D)) 
						&& flashCooldown == 0)
				{
					for (int i = 0; i < 64; ++i)
					{
						preFlashLocation = new Vector3f((float)this.posX, (float)this.posY, (float)this.posZ);

						if (this.teleportRandomly(32D))
						{
							flashCooldown = flashCooldownDuration;
							return true;
						}
					}
				}
				else if(damageSource.isExplosion())
				{
					for (int i = 0; i < 64; ++i)
					{
						preFlashLocation = new Vector3f((float)this.posX, (float)this.posY, (float)this.posZ);

						if (this.teleportRandomly(32D))
						{
							flashCooldown = flashCooldownDuration;
							return true;
						}
					}
				}
				else if(damageSource.getEntity() instanceof EntityLivingBase)
				{
					switchTargetToAttack(damageSource);
				}
			}

			return super.attackEntityFrom(damageSource, damageAmount);
		}
	}

	/**
	 * sets this entity's combat AI.
	 */
	public void switchTargetToAttack(DamageSource damageSource)
	{
		//this.setTarget((Entity)null);
		if(!(damageSource.getEntity() instanceof EntityPlayerMP) || !((EntityPlayerMP)damageSource.getEntity()).theItemInWorldManager.isCreative())
		{
			this.setAttackTarget((EntityLivingBase)damageSource.getEntity());
		}
	}

	/**
	 * sets this entity's combat AI.
	 */
	public void resetTargetToAttack()
	{
		this.setTarget((Entity)null);
		this.setAttackTarget((EntityLivingBase)null);
	}

	/**
	 * Teleport entity to a random nearby position
	 */
	protected boolean teleportRandomly(double maxDistance)
	{
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * maxDistance;
		double d1 = this.posY + (double)(this.rand.nextInt(20) - 10);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * maxDistance;

		return this.teleportTo(d0, d1, d2);
	}

	/**
	 * Teleport entity
	 */
	protected boolean teleportTo(double p_70825_1_, double p_70825_3_, double p_70825_5_)
	{
		EnderTeleportEvent event = new EnderTeleportEvent(this, p_70825_1_, p_70825_3_, p_70825_5_, 0);

		if (MinecraftForge.EVENT_BUS.post(event))
		{
			return false;
		}

		double d3 = this.posX;
		double d4 = this.posY;
		double d5 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;

		boolean flag = false;
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		if (this.worldObj.blockExists(i, j, k))
		{
			boolean flag1 = false;

			while (!flag1 && j > 0)
			{
				Block block = this.worldObj.getBlock(i, j - 1, k);

				if (block.getMaterial().blocksMovement())
				{
					flag1 = true;
				}
				else
				{
					--this.posY;
					--j;
				}
			}

			if (flag1)
			{
				this.setPosition(this.posX, this.posY, this.posZ);

				if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
				{
					flag = true;
				}
			}
		}

		if (!flag)
		{
			this.setPosition(d3, d4, d5);
			return false;
		}
		else
		{
			//this.worldObj.playSoundAtEntity(this, ModStrings.MODID + ":mob.commonsounds.flash", 2.0F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

			short short1 = 128;

			for (int l = 0; l < short1; ++l)
			{
				double d6 = (double)l / ((double)short1 - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
				double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				//this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);

				//this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);

				//MainRegistry.proxy.generateParticleBloodmoonFlame(this);
			}

			this.worldObj.playSoundEffect(d3, d4, d5, ModInfo.MODID + ":mob.commonsounds.flash", 1.0F, 1.0F);
			this.playSound(ModInfo.MODID + ":mob.commonsounds.flash", 1.0F, 1.0F);
			return true;
		}
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockEars(int partNumber)
	{
		return earsIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBodySway(int partNumber)
	{
		return bodySwayIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockArmLft(int partNumber)
	{
		return armLftIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockTail(int partNumber)
	{
		return tailIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockWings(int partNumber)
	{
		return wingsIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		for(int i = 0; i < earsIdleAnimationClock.length; i++)
		{
			earsIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < bodySwayIdleAnimationClock.length; i++)
		{
			bodySwayIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < armLftIdleAnimationClock.length; i++)
		{
			armLftIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < wingsIdleAnimationClock.length; i++)
		{
			wingsIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setEarClockDefaults();
		setBodySwayClockDefaults();
		setArmLftClockDefaults();
		setTailClockDefaults();
		setWingsClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	private void setBodySwayClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < bodySwayIdleAnimationClock.length; i++)
		{
			bodySwayIdleAnimationClock[i] = new IdleAnimationClock(1, 0, 1);

			int duration = 75;

			bodySwayIdleAnimationClock[i].setPhaseDurationX(0, duration);
			bodySwayIdleAnimationClock[i].setPhaseDurationZ(0, duration);

			float frequencyX = 0.95F;
			float frequencyZ = 0.35F;

			int startingClockX = (int)(((float)(bodySwayIdleAnimationClock.length - i) / (float)bodySwayIdleAnimationClock.length) * 
					(float)bodySwayIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockZ = (int)(((float)(bodySwayIdleAnimationClock.length - i) / (float)bodySwayIdleAnimationClock.length) * 
					(float)bodySwayIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockX > bodySwayIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= bodySwayIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockZ > bodySwayIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= bodySwayIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			bodySwayIdleAnimationClock[i].setClockX(startingClockX);
			bodySwayIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}

	@SideOnly(Side.CLIENT)
	private void setArmLftClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < armLftIdleAnimationClock.length; i++)
		{
			armLftIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			armLftIdleAnimationClock[i].setPhaseDurationX(0, 50);
			armLftIdleAnimationClock[i].setPhaseDurationY(0, 130);

			float frequencyX = 0.2F;
			float frequencyY = 0.4F;

			int startingClockX = (int)(((float)(armLftIdleAnimationClock.length - i) / (float)armLftIdleAnimationClock.length) * 
					(float)armLftIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(armLftIdleAnimationClock.length - i) / (float)armLftIdleAnimationClock.length) * 
					(float)armLftIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > armLftIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= armLftIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > armLftIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= armLftIdleAnimationClock[i].getTotalDurationLengthY();
			}

			armLftIdleAnimationClock[i].setClockX(startingClockX);
			armLftIdleAnimationClock[i].setClockY(startingClockY);
		}

	}

	@SideOnly(Side.CLIENT)
	private void setEarClockDefaults() 
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < earsIdleAnimationClock.length; i++)
		{
			earsIdleAnimationClock[i] = new IdleAnimationClock(0, 0, 1);

			earsIdleAnimationClock[i].setPhaseDurationZ(0, 75);

			float frequencyZ = 0.25F;

			int startingClockZ = (int)(((float)(earsIdleAnimationClock.length - i) / (float)earsIdleAnimationClock.length) * 
					(float)earsIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockZ > earsIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= earsIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			earsIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 30);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 45);

			float frequencyX = 0.75F;
			float frequencyY = 0.45F;

			int startingClockX = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > tailIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= tailIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > tailIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= tailIdleAnimationClock[i].getTotalDurationLengthY();
			}

			tailIdleAnimationClock[i].setClockX(startingClockX);
			tailIdleAnimationClock[i].setClockY(startingClockY);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void setWingsClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < wingsIdleAnimationClock.length; i++)
		{
			wingsIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			wingsIdleAnimationClock[i].setPhaseDurationX(0, 140);
			wingsIdleAnimationClock[i].setPhaseDurationY(0, 140);

			float frequencyX = 0.8F;
			float frequencyY = 0.35F;

			int startingClockX = (int)(((float)(wingsIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(wingsIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > wingsIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= wingsIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > wingsIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= wingsIdleAnimationClock[i].getTotalDurationLengthY();
			}

			wingsIdleAnimationClock[i].setClockX(startingClockX);
			wingsIdleAnimationClock[i].setClockY(startingClockY);
		}
	}
}