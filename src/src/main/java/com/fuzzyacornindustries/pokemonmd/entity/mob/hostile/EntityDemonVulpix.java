package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.OkamiPokemon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class EntityDemonVulpix extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[][] = new IdleAnimationClock[6][3];

	static String mobName = "demonvulpix";

	public EntityDemonVulpix(World par1World)
	{
		super(par1World);
		
		this.setSize(0.5F, 0.9F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityWolf.class, 15.0F, 1.0D, 1.2D));
		this.tasks.addTask(2, new EntityAIAvoidEntity(this, OkamiPokemon.class, 15.0F, 1.0D, 1.2D));
		this.tasks.addTask(3, new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

		this.isImmuneToFire = true;
		this.experienceValue = 20;

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
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
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

			j = this.rand.nextInt(4 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.paper, 1);
			}

			j = this.rand.nextInt(4 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.gold_nugget, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.blaze_powder, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(Items.blaze_rod, 1);
		this.dropItem(Items.nether_wart, 3);
		this.entityDropItem(new ItemStack(Blocks.soul_sand), 1);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		double d0 = targetEntity.posX - this.posX;
		double d1 = targetEntity.boundingBox.minY + (double)(targetEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
		double d2 = targetEntity.posZ - this.posZ;

		float f1 = MathHelper.sqrt_float(par2) * 0.5F;
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

		EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
		entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F);

		this.worldObj.spawnEntityInWorld(entitysmallfireball);
	}

	@Override
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(this.boundingBox.minY);


		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

		if (i >= 16 && !BiomeDictionary.isBiomeOfType(this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ)), Type.NETHER))
		{
			return false;
		}
		else
		{
			return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
		}
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
	public IdleAnimationClock getIdleAnimationClockTail(int tailNumber, int partNumber)
	{
		return tailIdleAnimationClock[tailNumber][partNumber];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		neckBobbleIdleAnimationClock.incrementClocks();

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
		setNeckBobbleClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setNeckBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		neckBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 60);

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
			for(int j = 0; j < tailIdleAnimationClock[0].length; j++)
			{
				tailIdleAnimationClock[i][j] = new IdleAnimationClock(1, 1, 0);

				tailIdleAnimationClock[i][j].setPhaseDurationX(0, 50);
				tailIdleAnimationClock[i][j].setPhaseDurationY(0, 100);

				float fractionStartX = (float)i / (float)tailIdleAnimationClock.length * (float)tailIdleAnimationClock[i][j].getTotalDurationLengthX();
				//float fractionStartY = (float)i / (float)tailIdleAnimationClock.length * (float)tailIdleAnimationClock[i][j].getTotalDurationLengthY();

				int startingClockX = (int)(fractionStartX + ((float)(tailIdleAnimationClock[i].length - j) / (float)tailIdleAnimationClock[i].length) * (float)tailIdleAnimationClock[i][j].getTotalDurationLengthX() * 0.4F) + randomInt;
				int startingClockY = (int)(((float)(tailIdleAnimationClock[i].length - j) / (float)tailIdleAnimationClock[i].length) * (float)tailIdleAnimationClock[i][j].getTotalDurationLengthX() * 1F) + randomInt;

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