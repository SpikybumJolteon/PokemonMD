package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralRangedAttacker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIMuBunearyChannelConfuse;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIMuBunearySpinAttack;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AISwordieMienshaoSlash;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;

public class EntityMuBuneary extends EntityHostilePokemonMD implements IAnimatedEntity, IRangedAttackMob
{
	private IdleAnimationClock earsIdleAnimationClock[] = new IdleAnimationClock[15];
	private IdleAnimationClock bodyIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[3];
	private IdleAnimationClock armsIdleAnimationClock[] = new IdleAnimationClock[2];

	public static final int actionIDCastConfuse = 1;
	public static final int actionIDSpinAttack = 2;

	protected static final int CAN_CAST = 17;

	public float meleeAttackRange = 1.3F;
	public float rangedAttackRange = 10.0F;

	static String mobName = "mubuneary";

	public EntityMuBuneary(World par1World)
	{
		super(par1World);

		this.setSize(0.4F, 1.4F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new AIMuBunearyChannelConfuse(this, rangedAttackRange));
		this.tasks.addTask(4, new AIGeneralRangedAttacker(this, 1.0D, 20, 20, rangedAttackRange));
		this.tasks.addTask(5, new EntityAIWander(this, 0.95D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.33D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(CAN_CAST, Byte.valueOf((byte)0));
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(this.getAnimationID() == this.actionIDCastConfuse)
		{
			if(this.worldObj.rand.nextInt(5) == 0)
			{
				PokemonMDMain.proxy.generateParticleBloodmoonFireBlast(this);
			}
		}

		if(animationID != 0) animationTick++;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		if(animationID == 0)
		{
			if(this.canCastConfuse())
			{
				PacketDispatcher.sendAnimationPacket(this, this.actionIDCastConfuse);
			}
			else
			{
				PacketDispatcher.sendAnimationPacket(this, this.actionIDSpinAttack);
			}
		}
	}

	public void addMeleeAITasks()
	{
		this.tasks.addTask(1, new AIMuBunearySpinAttack(this));
		this.tasks.addTask(2, new AIGeneralRangedAttacker(this, 1.0D, 20, 20, meleeAttackRange));
	}

	public void toggleConfuseCastability() 
	{
		if (!worldObj.isRemote) 
		{
			addMeleeAITasks();

			dataWatcher.updateObject(CAN_CAST, (byte)1);
		}
	}

	public boolean canCastConfuse()
	{
		if (this.getHealth() < this.getMaxHealth())
		{
			return false;
		}

		return dataWatcher.getWatchableObjectByte(CAN_CAST) == (byte)0;
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
			this.toggleConfuseCastability();

			return super.attackEntityFrom(damageSource, damageAmount);
		}
	}

	@Override
	protected String getLivingSound()
	{
		return null;//ModInfo.MODID + ":mob." + getMobName() + ".living";
	}

	@Override
	protected String getHurtSound()
	{
		return null;//ModInfo.MODID + ":mob." + getMobName() + ".hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return null;//ModInfo.MODID + ":mob." + getMobName() + ".death";
	}

	@Override
	protected void func_145780_a(int xCoord, int yCoord, int zCoord, Block blockUnderneath)
	{
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}
	/*
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
				this.dropItem(Items.gold_nugget, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(Items.gold_nugget, 9);
	}*/

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockEars(int partNumber)
	{
		return earsIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBody()
	{
		return bodyIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockArms(int partNumber)
	{
		return armsIdleAnimationClock[partNumber];
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
		for(int i = 0; i < earsIdleAnimationClock.length; i++)
		{
			earsIdleAnimationClock[i].incrementClocks();
		}

		bodyIdleAnimationClock.incrementClocks();

		for(int i = 0; i < armsIdleAnimationClock.length; i++)
		{
			armsIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setEarsClockDefaults();
		setBodyClockDefaults();
		setArmsClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setBodyClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		bodyIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		bodyIdleAnimationClock.setPhaseDurationX(0, 80);

		int startingClockX = randomInt;

		while(startingClockX > bodyIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= bodyIdleAnimationClock.getTotalDurationLengthX();
		}

		bodyIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setArmsClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < armsIdleAnimationClock.length; i++)
		{
			armsIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			armsIdleAnimationClock[i].setPhaseDurationX(0, 50);
			armsIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float frequencyX = 0.25F;
			float frequencyY = 0.20F;

			int startingClockX = (int)(((float)(armsIdleAnimationClock.length - i) / (float)armsIdleAnimationClock.length) * (float)armsIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(armsIdleAnimationClock.length - i) / (float)armsIdleAnimationClock.length) * (float)armsIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > armsIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= armsIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > armsIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= armsIdleAnimationClock[i].getTotalDurationLengthY();
			}

			armsIdleAnimationClock[i].setClockX(startingClockX);
			armsIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	@SideOnly(Side.CLIENT)
	public void setEarsClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < earsIdleAnimationClock.length; i++)
		{
			earsIdleAnimationClock[i] = new IdleAnimationClock(1, 0, 1);

			earsIdleAnimationClock[i].setPhaseDurationX(0, 80);
			earsIdleAnimationClock[i].setPhaseDurationZ(0, 90);

			float frequencyX = 0.65F;
			float frequencyZ = 0.60F;

			int startingClockX = (int)(((float)(earsIdleAnimationClock.length - i) / (float)earsIdleAnimationClock.length) * (float)earsIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockZ = (int)(((float)(earsIdleAnimationClock.length - i) / (float)earsIdleAnimationClock.length) * (float)earsIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockX > earsIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= earsIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockZ > earsIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= earsIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			earsIdleAnimationClock[i].setClockX(startingClockX);
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

			tailIdleAnimationClock[i].setPhaseDurationX(0, 20);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float frequencyX = 0.35F;
			float frequencyY = 0.30F;

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
}