package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class EntitySnowSorceressBraixen extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity
{
	private IdleAnimationClock earsIdleAnimationClock[] = new IdleAnimationClock[2];
	private IdleAnimationClock bodySwayIdleAnimationClock[] = new IdleAnimationClock[5];
	private IdleAnimationClock armLftIdleAnimationClock[] = new IdleAnimationClock[2];
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[4];

	public static final int actionIDSpell = 1;

	static String mobName = "snowsorceressbraixen";

	public EntitySnowSorceressBraixen(World par1World)
	{
		super(par1World);

		this.setSize(0.5F, 0.95F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIArrowAttack(this, 1.0D, 35, 60, 15.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 0.75D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

		this.isImmuneToFire = true;
		this.experienceValue = 10;

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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
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
	protected void func_145780_a(int xCoord, int yCoord, int zCoord, Block blockUnderneath)
	{
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
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
				this.dropItem(Items.stick, 1);
			}

			j = this.rand.nextInt(4 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.snowball, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		switch (this.rand.nextInt(3))
		{
		case 0:
			this.dropItem(Items.blaze_rod, 1);
			break;
		case 1:
			this.dropItem(Items.nether_wart, 3);
			this.entityDropItem(new ItemStack(Blocks.soul_sand), 1);
		}

		this.dropItem(PokemonMDItem.rawstettaBerry, 1);
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	{
		byte b0 = 4;

		if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
		{
			b0 = 10;
		}
		else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
		{
			b0 = 20;
		}

		if (this.rand.nextInt(4) == 0)
		{
			((EntityLivingBase)par1EntityLivingBase).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b0 * 20, 0));
		}

		if (this.rand.nextInt(4) == 0)
		{
			((EntityLivingBase)par1EntityLivingBase).addPotionEffect(new PotionEffect(Potion.weakness.id, b0 * 20, 0));
		}

		if (this.rand.nextInt(8) == 0)
		{
			((EntityLivingBase)par1EntityLivingBase).addPotionEffect(new PotionEffect(Potion.blindness.id, b0 * 20, 0));
		}

		if (this.rand.nextInt(8) == 0)
		{
			((EntityLivingBase)par1EntityLivingBase).setFire(statusEffectDurationModifier(3));

			playIgniteSound(par1EntityLivingBase);
		}

		if (this.rand.nextInt(12) == 0)
		{
			((EntityLivingBase)par1EntityLivingBase).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0));

			playBioSound(par1EntityLivingBase);
		}

		((EntityLivingBase)par1EntityLivingBase).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, b0 * 20, 0));
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
	public IdleAnimationClock getIdleAnimationClockEars(int partNumber)
	{
		return earsIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBodySway(int partNumber)
	{
		return bodySwayIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockArmLft(int partNumber)
	{
		return armLftIdleAnimationClock[partNumber];
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

		for(int i = 0; i < bodySwayIdleAnimationClock.length; i++)
		{
			bodySwayIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < armLftIdleAnimationClock.length; i++)
		{
			armLftIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setEarClockDefaults();
		setBodySwayClockDefaults();
		setArmLftClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	private void setBodySwayClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < bodySwayIdleAnimationClock.length; i++)
		{
			bodySwayIdleAnimationClock[i] = new IdleAnimationClock(1, 0, 1);

			int duration = 75;

			bodySwayIdleAnimationClock[i].setPhaseDurationX(0, duration);
			bodySwayIdleAnimationClock[i].setPhaseDurationZ(0, duration);

			float frequencyX = 0.95F;
			float frequencyZ = 0.35F;

			int startingClockX = (int)(((float)(bodySwayIdleAnimationClock.length - i) / (float)bodySwayIdleAnimationClock.length) * 
					(float)bodySwayIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockZ = (int)(((float)(bodySwayIdleAnimationClock.length - i) / (float)bodySwayIdleAnimationClock.length) * 
					(float)bodySwayIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockX > bodySwayIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= bodySwayIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockZ > bodySwayIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= bodySwayIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			bodySwayIdleAnimationClock[i].setClockX(startingClockX);
			bodySwayIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}

	@SideOnly(Side.CLIENT)
	private void setArmLftClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < armLftIdleAnimationClock.length; i++)
		{
			armLftIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			armLftIdleAnimationClock[i].setPhaseDurationX(0, 50);
			armLftIdleAnimationClock[i].setPhaseDurationY(0, 130);

			float frequencyX = 0.2F;
			float frequencyY = 0.4F;

			int startingClockX = (int)(((float)(armLftIdleAnimationClock.length - i) / (float)armLftIdleAnimationClock.length) * 
					(float)armLftIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(armLftIdleAnimationClock.length - i) / (float)armLftIdleAnimationClock.length) * 
					(float)armLftIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > armLftIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= armLftIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > armLftIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= armLftIdleAnimationClock[i].getTotalDurationLengthY();
			}

			armLftIdleAnimationClock[i].setClockX(startingClockX);
			armLftIdleAnimationClock[i].setClockY(startingClockY);
		}

	}

	@SideOnly(Side.CLIENT)
	private void setEarClockDefaults() 
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < earsIdleAnimationClock.length; i++)
		{
			earsIdleAnimationClock[i] = new IdleAnimationClock(0, 0, 1);

			earsIdleAnimationClock[i].setPhaseDurationZ(0, 75);

			float frequencyZ = 0.25F;

			int startingClockZ = (int)(((float)(earsIdleAnimationClock.length - i) / (float)earsIdleAnimationClock.length) * 
					(float)earsIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockZ > earsIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= earsIdleAnimationClock[i].getTotalDurationLengthZ();
			}

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

			tailIdleAnimationClock[i].setPhaseDurationX(0, 60);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 50);

			float frequencyX = 0.65F;
			float frequencyY = 0.65F;

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