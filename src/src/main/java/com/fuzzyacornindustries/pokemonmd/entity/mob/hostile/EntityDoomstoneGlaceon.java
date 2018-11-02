package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.library.LibraryDye;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDoomstoneGlaceon extends EntityHostilePokemonMD implements IAnimatedEntity, IStunImmune
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock armIdleAnimationClock[] = new IdleAnimationClock[4];
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[18];

	static String mobName = "doomstoneglaceon";

	public EntityDoomstoneGlaceon(World par1World)
	{
		super(par1World);
		
		this.setSize(0.9F, 0.9F);
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1F, false));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

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
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.15D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		
		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void fall(float fallSpeed)
	{
		fallSpeed = fallSpeed * fallSpeed;

		if(fallSpeed > 100)
		{
			fallSpeed = 100;
		}

		super.fall(fallSpeed);
	}

	@Override
	public void onLivingUpdate()
	{
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
		{
			float f = this.getBrightness(1.0F);

			if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
			{
				this.setFire(8);
			}
		}

		super.onLivingUpdate();
	}

	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return super.attackEntityAsMob(par1Entity);
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
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Blocks.packed_ice), 1);
			}

			j = this.rand.nextInt(4 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.snowball, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.bone, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI), 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.entityDropItem(new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI), 9);
	}

	@Override
	public boolean getCanSpawnHere()
	{
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

		if(biomegenbase == BiomeGenBase.extremeHills || biomegenbase == BiomeGenBase.extremeHillsEdge || biomegenbase == BiomeGenBase.extremeHillsPlus)
		{
			int i = MathHelper.floor_double(this.boundingBox.minY);

			if (i <= 92)
			{
				return false;
			}
		}

		return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockNeckBobble()
	{
		return neckBobbleIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockArm(int partNumber)
	{
		return armIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockTail(int partNumber)
	{
		return tailIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		neckBobbleIdleAnimationClock.incrementClocks();
		
		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < armIdleAnimationClock.length; i++)
		{
			armIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setNeckBobbleClockDefaults();
		setArmClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setNeckBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		neckBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 90);

		int startingClockX = randomInt;

		while(startingClockX > neckBobbleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= neckBobbleIdleAnimationClock.getTotalDurationLengthX();
		}

		neckBobbleIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setArmClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < armIdleAnimationClock.length; i++)
		{
			armIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 1);

			armIdleAnimationClock[i].setPhaseDurationX(0, 50);
			armIdleAnimationClock[i].setPhaseDurationY(0, 200);
			armIdleAnimationClock[i].setPhaseDurationZ(0, 75);

			float frequencyX = 0.05F;
			float frequencyY = 0.35F;
			float frequencyZ = 0.35F;

			int startingClockX = (int)(((float)(armIdleAnimationClock.length - i) / (float)armIdleAnimationClock.length) * (float)armIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(armIdleAnimationClock.length - i) / (float)armIdleAnimationClock.length) * (float)armIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;
			int startingClockZ = (int)(((float)(armIdleAnimationClock.length - i) / (float)armIdleAnimationClock.length) * (float)armIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockX > armIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= armIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > armIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= armIdleAnimationClock[i].getTotalDurationLengthY();
			}

			while(startingClockZ > armIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= armIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			armIdleAnimationClock[i].setClockX(startingClockX);
			armIdleAnimationClock[i].setClockY(startingClockY);
			armIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 1);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 55);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 40);
			tailIdleAnimationClock[i].setPhaseDurationZ(0, 100);

			float frequencyX = 0.75F;
			float frequencyY = 0.75F;
			float frequencyZ = 0.55F;

			int startingClockX = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;
			int startingClockZ = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockX > tailIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= tailIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > tailIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= tailIdleAnimationClock[i].getTotalDurationLengthY();
			}

			while(startingClockZ > tailIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= tailIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			tailIdleAnimationClock[i].setClockX(startingClockX);
			tailIdleAnimationClock[i].setClockY(startingClockY);
			tailIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}
}