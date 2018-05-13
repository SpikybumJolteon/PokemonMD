package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityCuotlEkans extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock bodyIdleAnimationClock[] = new IdleAnimationClock[13];
	private IdleAnimationClock dynamoIdleAnimationClock[] = new IdleAnimationClock[2];
	private IdleAnimationClock jawIdleAnimationClock;
	private IdleAnimationClock rotateRodsIdleAnimationClock;
	private IdleAnimationClock rattleIdleAnimationClock;

	public float field_70886_e;
	public float destPos;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;

	static String mobName = "cuotlekans";

	public EntityCuotlEkans(World par1World)
	{	
		super(par1World);
		this.setSize(0.7F, 0.9F);

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
		
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0D);
	}

	@Override
	public int getTotalArmorValue()
	{
		return 4;
	}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		
		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		this.field_70888_h = this.field_70886_e;
		this.field_70884_g = this.destPos;
		this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);

		if (this.destPos < 0.0F)
		{
			this.destPos = 0.0F;
		}

		if (this.destPos > 1.0F)
		{
			this.destPos = 1.0F;
		}

		if (!this.onGround && this.field_70889_i < 1.0F)
		{
			this.field_70889_i = 1.0F;
		}

		this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}

		this.field_70886_e += this.field_70889_i * 2.0F;
	}

	public void onUpdate()
	{
		super.onUpdate();

		if (!this.worldObj.isRemote)
		{
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}

	@Override
	protected void fall(float par1) {}

	@Override
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		if (super.attackEntityAsMob(targetEntity))
		{
			if (targetEntity instanceof EntityLivingBase)
			{
				byte b0 = 3;

				if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
				{
					b0 = 7;
				}
				else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
				{
					b0 = 15;
				}

				((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0));
				((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b0 * 20, 0));
				((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, b0 * 20, 0));
			}

			return true;
		}
		else
		{
			return false;
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
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean par1)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1)
		{
			b0 = (byte)(b0 | 1);
		}
		else
		{
			b0 &= -2;
		}

		this.dataWatcher.updateObject(16, Byte.valueOf(b0));
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

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}

			this.dropItem(PokemonMDItem.xelNagaShard, 1);
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.xelNagaCircuit, 1);
		this.dropItem(Items.glowstone_dust, 2);
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBody(int partNumber)
	{
		return bodyIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public void setIdleAnimationClockJaw(IdleAnimationClock idleAnimationClock) 
	{
		jawIdleAnimationClock = idleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockJaw() 
	{
		return jawIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockDynamo(int partNumber) 
	{
		return dynamoIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockRotateRods() 
	{
		return rotateRodsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockRattle() 
	{
		return rattleIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		for(int i = 0; i < bodyIdleAnimationClock.length; i++)
		{
			bodyIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < dynamoIdleAnimationClock.length; i++)
		{
			dynamoIdleAnimationClock[i].incrementClocks();
		}

		jawIdleAnimationClock.incrementClocks();
		rotateRodsIdleAnimationClock.incrementClocks();
		rattleIdleAnimationClock.incrementClocks();
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setBodyClockDefaults();
		setJawClockDefaults();
		setDynamoClockDefaults();
		setRotateRodsClockDefaults();
		setRattleClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setBodyClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < bodyIdleAnimationClock.length; i++)
		{
			bodyIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			bodyIdleAnimationClock[i].setPhaseDurationX(0, 45);
			bodyIdleAnimationClock[i].setPhaseDurationY(0, 60);

			float pointClusterDensityX = 0.85F;
			float pointClusterDensityY = 0.95F;

			int startingClockX = (int)(((float)(bodyIdleAnimationClock.length - i) / (float)bodyIdleAnimationClock.length) * (float)bodyIdleAnimationClock[i].getTotalDurationLengthX() * pointClusterDensityX) + randomInt;
			int startingClockY = (int)(((float)(bodyIdleAnimationClock.length - i) / (float)bodyIdleAnimationClock.length) * (float)bodyIdleAnimationClock[i].getTotalDurationLengthY() * pointClusterDensityY) + randomInt;

			while(startingClockX > bodyIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= bodyIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > bodyIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= bodyIdleAnimationClock[i].getTotalDurationLengthY();
			}

			bodyIdleAnimationClock[i].setClockX(startingClockX);
			bodyIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	@SideOnly(Side.CLIENT)
	public void setJawClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		jawIdleAnimationClock = new IdleAnimationClock(3, 0, 0);

		jawIdleAnimationClock.setPhaseDurationX(0, 30);
		jawIdleAnimationClock.setPhaseDurationX(1, 15);
		jawIdleAnimationClock.setPhaseDurationX(2, 30);

		int startingClockX = randomInt;
		
		while(startingClockX > jawIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= jawIdleAnimationClock.getTotalDurationLengthX();
		}

		jawIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setDynamoClockDefaults()
	{
		Random rand = new Random();

		int sectionNumber = 0;

		int startingClockX = rand.nextInt(100);
		int startingClockY = rand.nextInt(100);
		int startingClockZ = rand.nextInt(100);

		dynamoIdleAnimationClock[sectionNumber] = new IdleAnimationClock(1, 1, 1);

		dynamoIdleAnimationClock[sectionNumber].setPhaseDurationX(0, 50);
		dynamoIdleAnimationClock[sectionNumber].setPhaseDurationY(0, 140);
		dynamoIdleAnimationClock[sectionNumber].setPhaseDurationZ(0, 260);

		while(startingClockX > dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthX())
		{
			startingClockX -= dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthX();
		}

		while(startingClockY > dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthY())
		{
			startingClockY -= dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthY();
		}

		while(startingClockZ > dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthZ())
		{
			startingClockZ -= dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthZ();
		}

		dynamoIdleAnimationClock[sectionNumber].setClockX(startingClockX);
		dynamoIdleAnimationClock[sectionNumber].setClockY(startingClockY);
		dynamoIdleAnimationClock[sectionNumber].setClockZ(startingClockZ);

		/* ****************** */
		sectionNumber++;

		startingClockX = rand.nextInt(100);
		startingClockY = rand.nextInt(100);

		dynamoIdleAnimationClock[sectionNumber] = new IdleAnimationClock(1, 1, 1);

		dynamoIdleAnimationClock[sectionNumber].setPhaseDurationX(0, 10);
		dynamoIdleAnimationClock[sectionNumber].setPhaseDurationY(0, 50);
		dynamoIdleAnimationClock[sectionNumber].setPhaseDurationZ(0, 25);

		while(startingClockX > dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthX())
		{
			startingClockX -= dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthX();
		}

		while(startingClockY > dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthY())
		{
			startingClockY -= dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthY();
		}

		while(startingClockZ > dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthZ())
		{
			startingClockZ -= dynamoIdleAnimationClock[sectionNumber].getTotalDurationLengthZ();
		}

		dynamoIdleAnimationClock[sectionNumber].setClockX(startingClockX);
		dynamoIdleAnimationClock[sectionNumber].setClockY(startingClockY);
		dynamoIdleAnimationClock[sectionNumber].setClockZ(startingClockZ);
	}

	@SideOnly(Side.CLIENT)
	public void setRotateRodsClockDefaults()
	{
		Random rand = new Random();

		int startingClockZ = rand.nextInt(100);

		rotateRodsIdleAnimationClock = new IdleAnimationClock(0, 0, 1);

		rotateRodsIdleAnimationClock.setPhaseDurationZ(0, 50);

		while(startingClockZ > rotateRodsIdleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= rotateRodsIdleAnimationClock.getTotalDurationLengthZ();
		}

		rotateRodsIdleAnimationClock.setClockZ(startingClockZ);
	}

	@SideOnly(Side.CLIENT)
	public void setRattleClockDefaults()
	{
		Random rand = new Random();

		int startingClockX = rand.nextInt(100);

		rattleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		rattleIdleAnimationClock.setPhaseDurationX(0, 2);

		while(startingClockX > rattleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= rattleIdleAnimationClock.getTotalDurationLengthX();
		}

		rattleIdleAnimationClock.setClockX(startingClockX);
	}
}