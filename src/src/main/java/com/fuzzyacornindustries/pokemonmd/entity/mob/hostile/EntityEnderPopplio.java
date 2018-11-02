package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralLeapAtTarget;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralMeleeJumper;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityEnderPopplio extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock idleBobbleIdleAnimationClock;

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	static String mobName = "enderpopplio";

	public EntityEnderPopplio(World par1World)
	{
		super(par1World);
		this.setSize(0.4F, 0.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AIGeneralLeapAtTarget(this, 0.4F, 1.0F));
		this.tasks.addTask(2, new AIGeneralMeleeJumper(this, 1F, true));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		
		setClockDefaults();

		animationID = actionIDNone;
		animationTick = 0;
	}

	public static String getMobName()
	{
		return mobName;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(17.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
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
	public void onLivingUpdate()
	{
		this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		incrementPartClocks();
	}

	@Override
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		boolean flag = super.attackEntityAsMob(targetEntity);

		return flag;
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

	protected void func_145780_a(int xCoord, int yCoord, int zCoord, Block blockUnderneath)
	{
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}

	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		/*
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.tiberiumShard, 1);
			}
		}*/
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		//this.dropItem(Items.ender_pearl, 1);
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getIdleAnimationClockIdleBobble()
	{
		return idleBobbleIdleAnimationClock;
	}

	public void incrementPartClocks()
	{
		idleBobbleIdleAnimationClock.incrementClocks();
	}
	
	public void setClockDefaults()
	{
		setIdleBobbleClockDefaults();
	}

	public void setIdleBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		idleBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		idleBobbleIdleAnimationClock.setPhaseDurationX(0, 40);

		int startingClockX = randomInt;

		while(startingClockX > idleBobbleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= idleBobbleIdleAnimationClock.getTotalDurationLengthX();
		}

		idleBobbleIdleAnimationClock.setClockX(startingClockX);
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