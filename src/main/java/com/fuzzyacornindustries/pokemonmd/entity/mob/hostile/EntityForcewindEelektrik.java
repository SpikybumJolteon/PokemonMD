package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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

public class EntityForcewindEelektrik extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock fangsIdleAnimationClock;
	private IdleAnimationClock bodyIdleAnimationClock[] = new IdleAnimationClock[13];

	public float field_70886_e;
	public float destPos;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;

	static String mobName = "forcewindeelektrik";

	public EntityForcewindEelektrik(World par1World)
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
		
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(18.0D);
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

	@Override
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
				byte b0 = 6;

				if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
				{
					b0 = 12;
				}
				else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
				{
					b0 = 20;
				}

				((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b0 * 20, 1));

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
		return par1PotionEffect.getPotionID() == Potion.moveSlowdown.id ? false : super.isPotionApplicable(par1PotionEffect);
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

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.fish, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel) + 1;

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Items.dye, 1, 0), 0.0F);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(Items.redstone, 5);
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockFangs() 
	{
		return fangsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBody(int partNumber)
	{
		return bodyIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		fangsIdleAnimationClock.incrementClocks();
		
		for(int i = 0; i < bodyIdleAnimationClock.length; i++)
		{
			bodyIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setBodyClockDefaults();
		setFangsClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setFangsClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		fangsIdleAnimationClock = new IdleAnimationClock(2, 0, 0);

		fangsIdleAnimationClock.setPhaseDurationX(0, 15);
		fangsIdleAnimationClock.setPhaseDurationX(1, 15);

		int startingClockX = randomInt;
		
		while(startingClockX > fangsIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= fangsIdleAnimationClock.getTotalDurationLengthX();
		}

		fangsIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setBodyClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < bodyIdleAnimationClock.length; i++)
		{
			bodyIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			bodyIdleAnimationClock[i].setPhaseDurationX(0, 35);
			bodyIdleAnimationClock[i].setPhaseDurationY(0, 70);

			float frequencyX = 0.70F;
			float frequencyY = 0.75F;

			int startingClockX = (int)(((float)(bodyIdleAnimationClock.length - i) / (float)bodyIdleAnimationClock.length) * (float)bodyIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(bodyIdleAnimationClock.length - i) / (float)bodyIdleAnimationClock.length) * (float)bodyIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

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
}