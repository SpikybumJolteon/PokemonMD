package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityZombieUmbreon extends EntityHostilePokemonMD
{
	private IdleAnimationClock neckBobbleIdleAnimationClock[] = new IdleAnimationClock[5];
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[7];

	static String mobName = "zombieumbreon";

	public EntityZombieUmbreon(World par1World)
	{
		super(par1World);
		
		this.setSize(0.7F, 0.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
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
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
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
		int randomIntReset = this.rand.nextInt(60);

		if(randomIntReset == 0)
		{
			resetTargetToAttack();
		}

		if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
		{
			float f = this.getBrightness(1.0F);

			if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && 
					this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), 
							MathHelper.floor_double(this.posY), 
							MathHelper.floor_double(this.posZ)) &&
							!this.isPotionActive(Potion.fireResistance.id))
			{
				this.setFire(8);
			}
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		boolean flag = super.attackEntityAsMob(targetEntity);

		byte b0 = 5;

		if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
		{
			b0 = 4;
		}
		else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
		{
			b0 = 8;
		}

		if (this.rand.nextInt(8) == 0)
		{
			((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 1));
		}

		return flag;
	}

	/**
	 * sets this entity's combat AI.
	 */
	public void resetTargetToAttack()
	{
		this.setTarget((Entity)null);
		this.setAttackTarget((EntityLivingBase)null);
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

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		int j;
		int k;

		j = this.rand.nextInt(2 + par1);

		for (k = 0; k < j; ++k)
		{
			this.dropItem(Items.glowstone_dust, 1);
		}

		this.dropItem(PokemonMDItem.pechitaBerry, 1);
		this.dropItem(PokemonMDItem.oranianBerry, 1);
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockNeckBobble(int partNumber)
	{
		return neckBobbleIdleAnimationClock[partNumber];
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
		for(int i = 0; i < neckBobbleIdleAnimationClock.length; i++)
		{
			neckBobbleIdleAnimationClock[i].incrementClocks();
		}
		
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

		for(int i = 0; i < neckBobbleIdleAnimationClock.length; i++)
		{
			neckBobbleIdleAnimationClock[i] = new IdleAnimationClock(1, 0, 1);

			neckBobbleIdleAnimationClock[i].setPhaseDurationX(0, 90);
			neckBobbleIdleAnimationClock[i].setPhaseDurationZ(0, 120);

			float pointClusterDensityX = 0.55F;
			float pointClusterDensityZ = 0.45F;

			int startingClockX = (int)(((float)(neckBobbleIdleAnimationClock.length - i) / (float)neckBobbleIdleAnimationClock.length) * (float)neckBobbleIdleAnimationClock[i].getTotalDurationLengthX() * pointClusterDensityX) + randomInt;
			int startingClockZ = (int)(((float)(neckBobbleIdleAnimationClock.length - i) / (float)neckBobbleIdleAnimationClock.length) * (float)neckBobbleIdleAnimationClock[i].getTotalDurationLengthZ() * pointClusterDensityZ) + randomInt;

			while(startingClockX > neckBobbleIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= neckBobbleIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockZ > neckBobbleIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= neckBobbleIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			neckBobbleIdleAnimationClock[i].setClockX(startingClockX);
			neckBobbleIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 45);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float pointClusterDensityX = 0.55F;
			float pointClusterDensityY = 0.65F;

			int startingClockX = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * pointClusterDensityX) + randomInt;
			int startingClockY = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthY() * pointClusterDensityY) + randomInt;

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