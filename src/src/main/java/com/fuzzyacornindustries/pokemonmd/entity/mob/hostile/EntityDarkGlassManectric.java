package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.EntityAIDarkGlassManectricSwell;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDarkGlassManectric extends EntityHostilePokemonMD implements IAnimatedEntity, IMiniBoss, IStunImmune
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[2];

	static String mobName = "darkglassmanectric";

	private int lastActiveTime;

	/**
	 * The amount of time since the Manectric was close enough to the player to ignite
	 */
	private int timeSinceIgnited;
	private int fuseTime = 40;

	/** Explosion radius for this Manectric. */
	private int explosionRadius = 4;

	private int attackType = 0;
	private int attackPhaseDuration = 50;
	private int attackPhaseTime = 0;

	public EntityDarkGlassManectric(World par1World)
	{
		super(par1World);
		this.setSize(0.7F, 1.1F);

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIDarkGlassManectricSwell(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

		this.experienceValue = 20;
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
	protected void fall(float par1)
	{
		super.fall(par1);
		this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + par1 * 1.5F);

		if (this.timeSinceIgnited > this.fuseTime - 5)
		{
			this.timeSinceIgnited = this.fuseTime - 5;
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		
		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
		this.dataWatcher.addObject(16, Byte.valueOf((byte) - 1));
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
	}

	@Override
	public void onUpdate()
	{
		setAttackType();

		if (attackType == 1)
		{
			if (this.isEntityAlive())
			{
				this.lastActiveTime = this.timeSinceIgnited;
				int i = this.getManectricState();

				if (i > 0 && this.timeSinceIgnited == 0)
				{
					this.playSound(ModInfo.MODID + ":mob.commonsounds.glassfuse", 0.50F, 1.0F);
				}

				this.timeSinceIgnited += i;

				if (this.timeSinceIgnited < 0)
				{
					this.timeSinceIgnited = 0;
				}

				if (this.timeSinceIgnited >= this.fuseTime)
				{
					this.timeSinceIgnited = this.fuseTime;

					if (!this.worldObj.isRemote)
					{
						boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

						this.playSound(ModInfo.MODID + ":mob.commonsounds.explodingglass", 0.50F, 1.0F);
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);

						this.setDead();
					}
				}
			}
		}

		super.onUpdate();
	}

	public int getAttackType()
	{
		return attackType;
	}

	public void setAttackType()
	{
		if (attackPhaseTime <= 0)
		{
			int i = this.rand.nextInt(4);

			if (i == 1)
			{
				attackType = 1;
			}
			else
			{
				attackType = 0;
			}

			attackPhaseTime = attackPhaseDuration;
		}

		attackPhaseTime--;
	}

	@Override
	public boolean attackEntityAsMob(Entity attackTarget)
	{
		if (attackType == 0)
		{
			boolean flag = super.attackEntityAsMob(attackTarget);

			byte b0 = 4;

			if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
			{
				b0 = 8;
			}
			else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
			{
				b0 = 14;
			}

			if (this.rand.nextInt(8) == 0)
			{
				((EntityLivingBase)attackTarget).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b0 * 20, 1));
			}

			return flag;
		}
		else
		{
			return true;
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);

		par1NBTTagCompound.setShort("Fuse", (short)this.fuseTime);
		par1NBTTagCompound.setByte("ExplosionRadius", (byte)this.explosionRadius);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("Fuse"))
		{
			this.fuseTime = par1NBTTagCompound.getShort("Fuse");
		}

		if (par1NBTTagCompound.hasKey("ExplosionRadius"))
		{
			this.explosionRadius = par1NBTTagCompound.getByte("ExplosionRadius");
		}
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
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		this.playSound(ModInfo.MODID + ":mob.commonsounds.glasswalk4legs", 0.50F, 1.0F);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
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
				this.entityDropItem(new ItemStack(Blocks.glass), 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Items.ender_pearl), 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.blessingOfArceus, 1);
		
		int j;
		int k;

		j = this.rand.nextInt(8 + par1);

		for (k = 0; k < j; ++k)
		{
			this.entityDropItem(new ItemStack(PokemonMDBlock.voidGlass), 1);
		}

		j = this.rand.nextInt(6 + par1);

		for (k = 0; k < j; ++k)
		{
			this.dropItem(Items.glowstone_dust, 1);
		}

		j = this.rand.nextInt(2 + par1);
		
		for (k = 0; k < j; ++k)
		{
			this.entityDropItem(new ItemStack(Items.ender_eye), 1);
		}

		//this.dropItem(PokemonMDItem.blessingOfArceus, 1);
	}

	@SideOnly(Side.CLIENT)
	public float getManectricFlashIntensity(float par1)
	{
		return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * par1) / (float)(this.fuseTime - 2);
	}

	/**
	 * Returns the current Manectric's state, -1 is idle, 1 is 'in fuse'
	 */
	public int getManectricState()
	{
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	/**
	 * Sets the Manectric's state, -1 to idle and 1 to be 'in fuse'
	 */
	public void setManectricState(int metadata)
	{
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)metadata));
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
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setNeckBobbleClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setNeckBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		neckBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 75);

		int startingClockX = randomInt;

		while(startingClockX > neckBobbleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= neckBobbleIdleAnimationClock.getTotalDurationLengthX();
		}

		neckBobbleIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 0, 1);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 40);
			tailIdleAnimationClock[i].setPhaseDurationZ(0, 80);

			float pointClusterDensityX = 0.55F;
			float pointClusterDensityZ = 0.75F;

			int startingClockX = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * pointClusterDensityX) + randomInt;
			int startingClockZ = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthY() * pointClusterDensityZ) + randomInt;

			while(startingClockX > tailIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= tailIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockZ > tailIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= tailIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			tailIdleAnimationClock[i].setClockX(startingClockX);
			tailIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}
}