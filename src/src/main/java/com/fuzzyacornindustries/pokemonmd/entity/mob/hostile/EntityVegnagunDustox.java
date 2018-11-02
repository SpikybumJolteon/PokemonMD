package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIVegnagunDustoxFlyShots;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class EntityVegnagunDustox extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity, IMiniBoss, IStunImmune
{
	private IdleAnimationClock wingsIdleAnimationClock;
	private IdleAnimationClock bodyFloatIdleAnimationClock;
	private IdleAnimationClock legsIdleAnimationClock[][] = new IdleAnimationClock[4][3];

	private int tempCounter = 0;

	public static final int actionIDFlyShots = 1;

	static String mobName = "vegnagundustox";

	public EntityVegnagunDustox(World par1World)
	{
		super(par1World);
		
		this.setSize(0.8F, 1.3F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AIVegnagunDustoxFlyShots(this));
		this.tasks.addTask(3, new EntityAIArrowAttack(this, 1.0D, 35, 60, 20.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

        this.experienceValue = 60;

		this.isImmuneToFire = true;

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
		
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
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
	public void onUpdate()
	{
		super.onUpdate();

		if(animationID != 0) animationTick++;
	}

	@Override
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
	{
		if(animationID == 0 && this.rand.nextInt(2) == 1)
		{
			PacketDispatcher.sendAnimationPacket(this, actionIDFlyShots);
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

		tempCounter = 0;
	}

	@Override
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

			if (entity instanceof EntityVegnagunDustox)
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
		{
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
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.blessingOfArceus, 1);
		
		this.entityDropItem(new ItemStack(PokemonMDBlock.xelNagaDynamo), 1);
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
				return super.getCanSpawnHere();
			}
		}

		return false;
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockWings()
	{
		return wingsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockLegs(int legNumber, int partNumber)
	{
		return legsIdleAnimationClock[legNumber][partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBodyFloat()
	{
		return bodyFloatIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		for(int i = 0; i < legsIdleAnimationClock.length; i++)
		{
			for(int j = 0; j < legsIdleAnimationClock[i].length; j++)
			{
				legsIdleAnimationClock[i][j].incrementClocks();
			}
		}

		wingsIdleAnimationClock.incrementClocks();
		bodyFloatIdleAnimationClock.incrementClocks();
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setWingsClockDefaults();
		setBodyFloatClockDefaults();
		setLegsClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setWingsClockDefaults()
	{
		int startingClockY = this.rand.nextInt(100);

		wingsIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		wingsIdleAnimationClock.setPhaseDurationY(0, 3);

		while(startingClockY > wingsIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= wingsIdleAnimationClock.getTotalDurationLengthY();
		}

		wingsIdleAnimationClock.setClockY(startingClockY);
	}

	@SideOnly(Side.CLIENT)
	public void setBodyFloatClockDefaults()
	{
		bodyFloatIdleAnimationClock = new IdleAnimationClock(1, 1, 1);

		bodyFloatIdleAnimationClock.setPhaseDurationX(0, 30);
		bodyFloatIdleAnimationClock.setPhaseDurationY(0, 60);
		bodyFloatIdleAnimationClock.setPhaseDurationZ(0, 120);

		bodyFloatIdleAnimationClock.setClockX(0);
		bodyFloatIdleAnimationClock.setClockY(0);
		bodyFloatIdleAnimationClock.setClockZ(0);
	}

	@SideOnly(Side.CLIENT)
	public void setLegsClockDefaults()
	{
		for(int i = 0; i < legsIdleAnimationClock.length; i++)
		{
			for(int j = 0; j < legsIdleAnimationClock[0].length; j++)
			{
				legsIdleAnimationClock[i][j] = new IdleAnimationClock(1, 1, 1);

				legsIdleAnimationClock[i][j].setPhaseDurationX(0, 30);
				legsIdleAnimationClock[i][j].setPhaseDurationY(0, 160);
				legsIdleAnimationClock[i][j].setPhaseDurationY(0, 120);

				float frequencyX = 0.20F;
				float frequencyY = 0.15F;
				float frequencyZ = 0.10F;

				int startingClockX = (int)(((float)(legsIdleAnimationClock.length - i) / (float)legsIdleAnimationClock.length) * (float)legsIdleAnimationClock[i][j].getTotalDurationLengthX() * frequencyX);
				int startingClockY = (int)(((float)(legsIdleAnimationClock.length - i) / (float)legsIdleAnimationClock.length) * (float)legsIdleAnimationClock[i][j].getTotalDurationLengthY() * frequencyY);
				int startingClockZ = (int)(((float)(legsIdleAnimationClock.length - i) / (float)legsIdleAnimationClock.length) * (float)legsIdleAnimationClock[i][j].getTotalDurationLengthZ() * frequencyZ);

				legsIdleAnimationClock[i][j].setClockX(startingClockX);
				legsIdleAnimationClock[i][j].setClockY(startingClockY);
				legsIdleAnimationClock[i][j].setClockY(startingClockZ);
			}
		}
	}
}