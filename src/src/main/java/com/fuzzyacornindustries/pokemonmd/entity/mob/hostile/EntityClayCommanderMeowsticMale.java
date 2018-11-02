package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIClayCommanderMeowsticPsychic;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityClayCommanderMeowsticMale extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity, IMiniBoss, IStunImmune
{
	private IdleAnimationClock armsIdleAnimationClock;
	private IdleAnimationClock earsIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[][] = new IdleAnimationClock[2][5];

	public static final int actionIDPsychic = 1;

	private int animationID;
	private int animationTick;

	public boolean isAttacking;

	static String mobName = "claycommandermeowsticmale";

	int numberOfMinionsToSpawn;

	public EntityClayCommanderMeowsticMale(World par1World)
	{
		super(par1World);
		
		this.setSize(0.3F, 0.9F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AIClayCommanderMeowsticPsychic(this));

		this.tasks.addTask(3, new EntityAIArrowAttack(this, 1.0D, 35, 60, 15.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 0.7D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

		this.isImmuneToFire = true;
		this.experienceValue = 25;

		numberOfMinionsToSpawn = 25;

		isAttacking = false;

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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setShort("carriedData", (short)this.getCarryingData());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		this.setCarryingData(nbt.getShort("carriedData"));
	}

	public int getCarryingData()
	{
		return this.dataWatcher.getWatchableObjectByte(17);
	}

	public void setCarryingData(int metaData)
	{
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)(metaData & 255)));
	}

	@Override
	public int getTotalArmorValue()
	{
		return 4;
	}

	@Override
	protected void fall(float par1) {}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		
		this.dataWatcher.addObject(13, new Byte((byte)0));
		this.dataWatcher.addObject(17, new Byte((byte)0));
	}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
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

		if(animationID != 0) animationTick++;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (!super.attackEntityFrom(par1DamageSource, par2))
		{
			return false;
		}
		else
		{
			for (int l = 0; l < 8; ++l)
			{
				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.posY);
				int k = MathHelper.floor_double(this.posZ);

				int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, 2, 4) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
				int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, 2, 4) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
				int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, 2, 4) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);

				if (!this.worldObj.isRemote && numberOfMinionsToSpawn != 0)
				{
					if(World.doesBlockHaveSolidTopSurface(this.worldObj, i1, j1 - 1, k1) && this.worldObj.getBlockLightValue(i1, j1, k1) > 1)
					{
						int randomInt = this.rand.nextInt(22);

						if (randomInt >= 0 && randomInt <= 7)
						{
							EntityClaySkitty entityMinion = new EntityClaySkitty(this.worldObj);

							entityMinion.setLocationAndAngles(i1 + 0.5D, j1, k1 + 0.5D, this.rotationYaw, this.rotationPitch);

							this.worldObj.spawnEntityInWorld(entityMinion);

							numberOfMinionsToSpawn--;
						}
						else if (randomInt >= 8 && randomInt <= 15)
						{
							EntityClayPurrloin entityMinion = new EntityClayPurrloin(this.worldObj);

							entityMinion.setLocationAndAngles(i1 + 0.5D, j1, k1 + 0.5D, this.rotationYaw, this.rotationPitch);

							this.worldObj.spawnEntityInWorld(entityMinion);

							numberOfMinionsToSpawn--;
						}
						else if (randomInt == 16)
						{
							EntityClayEspurr entityMinion = new EntityClayEspurr(this.worldObj);

							entityMinion.setLocationAndAngles(i1 + 0.5D, j1, k1 + 0.5D, this.rotationYaw, this.rotationPitch);

							this.worldObj.spawnEntityInWorld(entityMinion);

							numberOfMinionsToSpawn--;
						}
						else if (randomInt == 17)
						{
							EntityClayMeowth entityMinion = new EntityClayMeowth(this.worldObj);

							entityMinion.setLocationAndAngles(i1 + 0.5D, j1, k1 + 0.5D, this.rotationYaw, this.rotationPitch);

							this.worldObj.spawnEntityInWorld(entityMinion);

							numberOfMinionsToSpawn--;
						}
					}
				}
			}

			return true;
		}
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		byte durationSeconds = 8;

		if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
		{
			durationSeconds = 16;
		}
		else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
		{
			durationSeconds = 26;
		}

		// Swagger
		if (this.rand.nextInt(8) == 0)
		{
			((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.confusion.id, durationSeconds * 20, 2));
			((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.damageBoost.id, durationSeconds * 10, 0));
		}

		// Psychic
		else if (this.rand.nextInt(4) == 0)
		{
			if(animationID == 0)
			{
				PacketDispatcher.sendAnimationPacket(this, actionIDPsychic);
			}
		}

		// Flash
		else if (this.rand.nextInt(4) == 0)
		{
			((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.blindness.id, durationSeconds * 20, 0));
		}

		// Charm
		else
		{
			((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.weakness.id, durationSeconds * 20, 1));
		}

		// Mean Look
		((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, durationSeconds * 20, 3));

		isAttacking = true;
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
				this.entityDropItem(new ItemStack(Blocks.hardened_clay), 1);
			}

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.clay_ball, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.glowstone_dust, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.redstone, 1);
			}

			this.dropItem(PokemonMDItem.xelNagaShard, 1);
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{

		this.dropItem(PokemonMDItem.blessingOfArceus, 1);
		
		this.dropItem(PokemonMDItem.xelNagaCircuit, 1);
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockEars()
	{
		return earsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockArms()
	{
		return armsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockTail(int tailNumber, int partNumber)
	{
		return tailIdleAnimationClock[tailNumber][partNumber];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		earsIdleAnimationClock.incrementClocks();
		armsIdleAnimationClock.incrementClocks();

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			for(int j = 0; j < tailIdleAnimationClock[0].length; j++)
			{
				tailIdleAnimationClock[i][j].incrementClocks();
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setArmsClockDefaults();
		setEarsClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setArmsClockDefaults()
	{
		int startingClockX = this.rand.nextInt(100);

		armsIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		armsIdleAnimationClock.setPhaseDurationX(0, 80);

		while(startingClockX > armsIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= armsIdleAnimationClock.getTotalDurationLengthX();
		}

		armsIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setEarsClockDefaults()
	{
		int startingClockX = this.rand.nextInt(100);

		earsIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		earsIdleAnimationClock.setPhaseDurationX(0, 100);

		while(startingClockX > earsIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= earsIdleAnimationClock.getTotalDurationLengthX();
		}

		earsIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			for(int j = 0; j < tailIdleAnimationClock[0].length; j++)
			{
				tailIdleAnimationClock[i][j] = new IdleAnimationClock(1, 1, 0);

				tailIdleAnimationClock[i][j].setPhaseDurationX(0, 50);
				tailIdleAnimationClock[i][j].setPhaseDurationY(0, 100);

				float pointClusterDensityX = 0.90F;
				float pointClusterDensityY = 0.80F;

				float fractionStartX = (float)i / (float)tailIdleAnimationClock.length * (float)tailIdleAnimationClock[i][j].getTotalDurationLengthX();

				int startingClockX = (int)(fractionStartX + ((float)(tailIdleAnimationClock[i].length - j) / (float)tailIdleAnimationClock[i].length) * (float)tailIdleAnimationClock[i][j].getTotalDurationLengthX() * pointClusterDensityX) + randomInt;
				int startingClockY = (int)(((float)(tailIdleAnimationClock[i].length - j) / (float)tailIdleAnimationClock[i].length) * (float)tailIdleAnimationClock[i][j].getTotalDurationLengthX() * pointClusterDensityY) + randomInt;

				while(startingClockX > tailIdleAnimationClock[i][j].getTotalDurationLengthX())
				{
					startingClockX -= tailIdleAnimationClock[i][j].getTotalDurationLengthX();
				}

				while(startingClockY > tailIdleAnimationClock[i][j].getTotalDurationLengthY())
				{
					startingClockY -= tailIdleAnimationClock[i][j].getTotalDurationLengthY();
				}

				tailIdleAnimationClock[i][j].setClockX(startingClockX);
				tailIdleAnimationClock[i][j].setClockY(startingClockY);
			}
		}
	}
}