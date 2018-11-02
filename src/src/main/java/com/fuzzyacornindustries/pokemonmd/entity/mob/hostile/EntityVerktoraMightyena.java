package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityVerktoraMightyena extends EntityHostilePokemonMD implements IAnimatedEntity, IMiniBoss, IStunImmune
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock jawMainIdleAnimationClock;
	private IdleAnimationClock jawLowerIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[13];

	static String mobName = "verktoramightyena";

	public EntityVerktoraMightyena(World par1World)
	{
		super(par1World);
		this.setSize(1F, 1F);

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
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(85.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.80D);
	}
	
	@Override
	protected void fall(float par1) {}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	public void onLivingUpdate()
	{
		if (this.isWet())
		{
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	protected void attackEntity(Entity targetEntity, float par2)
	{		
		if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0)
		{
			if (this.onGround)
			{
				double d0 = targetEntity.posX - this.posX;
				double d1 = targetEntity.posZ - this.posZ;
				float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
				this.motionX = d0 / (double)f2 * 0.5D * 0.950000011920929D + this.motionX * 0.20000000298023224D;
				this.motionZ = d1 / (double)f2 * 0.5D * 0.950000011920929D + this.motionZ * 0.20000000298023224D;
				this.motionY = 0.4000000059604645D;
			}
		}
		else
		{
			super.attackEntity(targetEntity, par2);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		boolean flag = super.attackEntityAsMob(targetEntity);

		targetEntity.setFire(statusEffectDurationModifier(3));

		((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.blindness.id, statusEffectDurationModifier(10) * 20, 0));
		
		return flag;
	}

	public int statusEffectDurationModifier(int durationModifier)
	{
		if(this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
		{
			return 2 + durationModifier;
		}
		if(this.worldObj.difficultySetting == EnumDifficulty.HARD)
		{
			return 4 + durationModifier;
		}
		else
		{
			return 1 + durationModifier / 2;
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
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		boolean potionAffects = true;

		if(par1PotionEffect.getPotionID() == Potion.poison.id)
		{
			potionAffects = false;
		}
		else if(par1PotionEffect.getPotionID() == Potion.moveSlowdown.id)
		{
			potionAffects = false;
		}
		else
		{
			super.isPotionApplicable(par1PotionEffect);
		}

		return potionAffects;
	}

	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(5 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.gold_nugget, 2);
			}

			j = this.rand.nextInt(5 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.ghast_tear, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.colbertaBerry, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.blessingOfArceus, 1);
		
		this.dropItem(Items.blaze_rod, 2);
		this.dropItem(Items.nether_wart, 6);
		this.entityDropItem(new ItemStack(Blocks.soul_sand), 2);
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
	public IdleAnimationClock getIdleAnimationClockJawMain()
	{
		return jawMainIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockJawLower()
	{
		return jawLowerIdleAnimationClock;
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
		jawMainIdleAnimationClock.incrementClocks();
		jawLowerIdleAnimationClock.incrementClocks();
		
		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setNeckBobbleClockDefaults();
		setJawMainClockDefaults();
		setJawLowerClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setNeckBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		neckBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 50);

		int startingClockX = randomInt;

		while(startingClockX > neckBobbleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= neckBobbleIdleAnimationClock.getTotalDurationLengthX();
		}

		neckBobbleIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setJawMainClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		jawMainIdleAnimationClock = new IdleAnimationClock(2, 0, 0);

		jawMainIdleAnimationClock.setPhaseDurationX(0, 20);
		jawMainIdleAnimationClock.setPhaseDurationX(1, 20);

		int startingClockX = randomInt;

		while(startingClockX > jawMainIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= jawMainIdleAnimationClock.getTotalDurationLengthX();
		}

		jawMainIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setJawLowerClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		jawLowerIdleAnimationClock = new IdleAnimationClock(3, 0, 0);

		jawLowerIdleAnimationClock.setPhaseDurationX(0, 40);
		jawLowerIdleAnimationClock.setPhaseDurationX(1, 25);
		jawLowerIdleAnimationClock.setPhaseDurationX(2, 15);

		int startingClockX = randomInt;

		while(startingClockX > jawLowerIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= jawLowerIdleAnimationClock.getTotalDurationLengthX();
		}

		jawLowerIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 65);

			tailIdleAnimationClock[i].setPhaseDurationY(0, 45);

			float frequencyX = 0.55F;
			float frequencyY = 0.45F;

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