package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIVegnagunDustoxFlyShots;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class EntityRageBomberRowlet extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity
{
	private IdleAnimationClock idleBobbleIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock;

	private int animationID;
	private int animationTick;

	private int tempCounter = 0;

	//public static final int actionIDNone = 0;
	//public static final int actionIDFlyShots = 1;

	static String mobName = "ragebomberrowlet";

	public EntityRageBomberRowlet(World par1World)
	{
		super(par1World);
		this.setSize(0.8F, 1.3F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		//this.tasks.addTask(2, new AIVegnagunDustoxFlyShots(this));
		this.tasks.addTask(3, new EntityAIArrowAttack(this, 1.0D, 35, 60, 20.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

		setClockDefaults();
	}

	public static String getMobName()
	{
		return mobName;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	@Override
	public int getTotalArmorValue()
	{
		return 2;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(13, new Byte((byte)0));
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getLivingSound()
	{
		return null;//ModStrings.MODID + ":mob." + getMobName() + ".living";
	}

	@Override
	protected String getHurtSound()
	{
		return null;//ModStrings.MODID + ":mob." + getMobName() + ".hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return null;//ModStrings.MODID + ":mob." + getMobName() + ".death";
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(animationID != 0) animationTick++;

		incrementPartClocks();
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		int randomIntReset = this.rand.nextInt(60);

		if(randomIntReset == 0)
		{
			resetTargetToAttack();
		}

		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}
	}

	public void resetTargetToAttack()
	{
		this.setTarget((Entity)null);
		this.setAttackTarget((EntityLivingBase)null);
	}

	@Override
	protected void fall(float par1) {}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase attackTarget, float par2)
	{/*
		if(animationID == 0 && this.rand.nextInt(2) == 1)
		{
			MainRegistry.sendAnimationPacket(this, actionIDFlyShots);
		}
		else if(animationID != actionIDFlyShots)
		{
			for(int i = 0; i < 3; i++)
			{
				EntityArrow entityarrow = new EntityArrow(this.worldObj, this, attackTarget, 2.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
				entityarrow.setDamage((double)(par2 * 6.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11F));

				playArrowAttackSound();
				this.worldObj.spawnEntityInWorld(entityarrow);
			}
		}

		tempCounter = 0;*/
	}

	public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity;

			entity = damageSource.getEntity();

			if (entity instanceof EntityRageBomberRowlet)
			{
				return false;
			}

			return super.attackEntityFrom(damageSource, damageAmount);
		}
	}

	public void playArrowAttackSound()
	{
		this.playSound(ModInfo.MODID + ":mob." + getMobName() + ".attack", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	}
	
	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{/*
			int j;
			int k;

			j = this.rand.nextInt(16 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.arrow, 1);
			}

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.quartz, 1);
			}

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.glowstone_dust, 1);
			}

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.xelNagaCircuit, 1);
			}

			j = this.rand.nextInt(1 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.diamond, 1);
			}*/
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{/*
		this.dropItem(PokemonMDItem.blessingOfArceus, 1);
		
		this.entityDropItem(new ItemStack(PokemonMDBlock.xelNagaDynamo), 1);*/
	}

	public boolean getCanSpawnHere()
	{
		Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

		if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL)
		{
			BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

			if (this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.worldObj.getCurrentMoonPhaseFactor() == 1.0F)
			{
				return super.getCanSpawnHere();
			}
		}

		return false;
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getIdleAnimationClockIdleBobble()
	{
		return idleBobbleIdleAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockTail()
	{
		return tailIdleAnimationClock;
	}

	public void incrementPartClocks()
	{
		idleBobbleIdleAnimationClock.incrementClocks();
		tailIdleAnimationClock.incrementClocks();
	}
	
	public void setClockDefaults()
	{
		setIdleBobbleClockDefaults();
		setTailClockDefaults();
	}

	public void setIdleBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		idleBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		idleBobbleIdleAnimationClock.setPhaseDurationX(0, 75);

		int startingClockX = randomInt;

		while(startingClockX > idleBobbleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= idleBobbleIdleAnimationClock.getTotalDurationLengthX();
		}

		idleBobbleIdleAnimationClock.setClockX(startingClockX);
	}

	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		tailIdleAnimationClock = new IdleAnimationClock(1, 1, 0);

		tailIdleAnimationClock.setPhaseDurationX(0, 80);
		tailIdleAnimationClock.setPhaseDurationY(0, 60);

		int startingClockX = randomInt;

		while(startingClockX > tailIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= tailIdleAnimationClock.getTotalDurationLengthX();
		}

		int startingClockY = randomInt;

		while(startingClockY > tailIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= tailIdleAnimationClock.getTotalDurationLengthY();
		}

		tailIdleAnimationClock.setClockX(startingClockX);
		tailIdleAnimationClock.setClockY(startingClockY);
	}

	@Override
	public void setAnimationID(int id) 
	{
		animationID = id;
	}

	@Override
	public void setAnimationTick(int tick) 
	{
		animationTick = tick;	
	}

	@Override
	public int getAnimationID() 
	{
		return animationID;
	}

	@Override
	public int getAnimationTick() 
	{
		return animationTick;
	}
}