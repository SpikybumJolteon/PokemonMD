package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityProxyPylonCarbink extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity, IStunImmune
{
	private IdleAnimationClock barrierPebblesIdleAnimationClock;
	private IdleAnimationClock barrierArmsIdleAnimationClock;
	private IdleAnimationClock verticalFloatIdleAnimationClock;

	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 10.0F);

	static String mobName = "proxypyloncarbink";

	int numberOfMinionsToSpawn;

	public EntityProxyPylonCarbink(World par1World)
	{
		super(par1World);
		
		this.setSize(0.3F, 0.95F);
		this.tasks.addTask(1, this.aiArrowAttack);
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

		this.isImmuneToFire = true;
		this.experienceValue = 10;

		numberOfMinionsToSpawn = 10;

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

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
	}

	@Override
	public int getTotalArmorValue()
	{
		return 24;
	}

	@Override
	protected void fall(float par1) {}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
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
	public void onLivingUpdate()
	{
		if (this.isEntityAlive() && this.isEntityInsideOpaqueBlock())
		{
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			this.setDead();
		}

		this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);

		this.motionX = 0;
		this.motionY = 0;
		this.motionZ = 0;

		super.onLivingUpdate();
	}

	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			this.dropItem(PokemonMDItem.xelNagaShard, 1);

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.quartz, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.glowstone_dust, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.xelNagaCircuit, 1);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, 2, 4) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
		int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, 2, 4) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
		int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, 2, 4) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);

		if (!this.worldObj.isRemote && numberOfMinionsToSpawn != 0)
		{
			EntityZealotPawniard entityZealotPawniard = new EntityZealotPawniard(this.worldObj);

			if(World.doesBlockHaveSolidTopSurface(this.worldObj, i1, j1 - 1, k1) && this.worldObj.getBlockLightValue(i1, j1, k1) > 1)
			{
				entityZealotPawniard.setLocationAndAngles(i1 + 0.5D, j1, k1 + 0.5D, this.rotationYaw, this.rotationPitch);

				this.worldObj.spawnEntityInWorld(entityZealotPawniard);

				entityZealotPawniard.playSound(ModInfo.MODID + ":mob." + EntityZealotPawniard.getMobName() + ".spawn", this.getSoundVolume() + 0.7F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);

				numberOfMinionsToSpawn--;
			}
		}
	}

	public boolean getCanSummonAtLocation(EntityMob entityToSummon)
	{
		if(entityToSummon.worldObj.checkNoEntityCollision(this.boundingBox) && entityToSummon.worldObj.getCollidingBoundingBoxes(entityToSummon, entityToSummon.boundingBox).isEmpty() && !entityToSummon.worldObj.isAnyLiquid(this.boundingBox))
		{
			int i = MathHelper.floor_double(entityToSummon.posX);
			int j = MathHelper.floor_double(entityToSummon.boundingBox.minY);
			int k = MathHelper.floor_double(entityToSummon.posZ);

			if(entityToSummon.getBlockPathWeight(i, j, k) >= 0.0F)
			{
				if(entityToSummon.worldObj.difficultySetting != EnumDifficulty.PEACEFUL)
				{
					return true;
				}
			}
		}

		return false;
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBarrierPebbles()
	{
		return barrierPebblesIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBarrierArms()
	{
		return barrierArmsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockVerticalFloat()
	{
		return verticalFloatIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		barrierPebblesIdleAnimationClock.incrementClocks();
		barrierArmsIdleAnimationClock.incrementClocks();
		verticalFloatIdleAnimationClock.incrementClocks();
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setBarrierPebblesClockDefaults();
		setBarrierArmsClockDefaults();
		setVerticalFloatClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setBarrierPebblesClockDefaults()
	{
		int startingClockX = this.rand.nextInt(100);

		barrierPebblesIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		barrierPebblesIdleAnimationClock.setPhaseDurationX(0, 32);

		while(startingClockX > barrierPebblesIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= barrierPebblesIdleAnimationClock.getTotalDurationLengthX();
		}

		barrierPebblesIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setBarrierArmsClockDefaults()
	{
		int startingClockX = this.rand.nextInt(100);

		barrierArmsIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		barrierArmsIdleAnimationClock.setPhaseDurationX(0, 100 );

		while(startingClockX > barrierArmsIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= barrierArmsIdleAnimationClock.getTotalDurationLengthX();
		}

		barrierArmsIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setVerticalFloatClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		verticalFloatIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		int duration = 80;

		verticalFloatIdleAnimationClock.setPhaseDurationY(0, duration);

		int startingClockY = verticalFloatIdleAnimationClock.getTotalDurationLengthY() + randomInt;

		verticalFloatIdleAnimationClock.setClockY(startingClockY);
	}
}