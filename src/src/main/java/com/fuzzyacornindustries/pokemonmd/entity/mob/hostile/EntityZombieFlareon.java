package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.LibraryColor;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityZombieFlareon extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[5];
	private IdleAnimationClock neckBobbleIdleAnimationClock[] = new IdleAnimationClock[4];

	static String mobName = "zombieflareon";

	public EntityZombieFlareon(World par1World)
	{
		super(par1World);

		this.setSize(0.7F, 0.9F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1F, false));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

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

		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
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

		if(animationID != 0) animationTick++;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityTarget)
	{
		boolean flag = super.attackEntityAsMob(entityTarget);

		float f = this.getBrightness(1.0F);

		if (f >= 0.8F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
		{
			entityTarget.setFire(fireAspectDuration(3));
		}
		else if (this.rand.nextInt(5) == 1)
		{
			entityTarget.setFire(fireAspectDuration(3));
		}

		return flag;
	}

	public int fireAspectDuration(int durationModifier)
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
	protected void dropFewItems(boolean slainByPlayer, int lootingEnchantmentLevel)
	{
		if(slainByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, LibraryColor.YELLOW), 0.0F);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.rawstettaBerry, 1);
		this.dropItem(Items.blaze_rod, 1);
	}

	@Override
	public boolean getCanSpawnHere()
	{
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

		if (biomegenbase == BiomeGenBase.hell)
		{
			int i = MathHelper.floor_double(this.posY) - 1;// Check block below point in question
			int j = MathHelper.floor_double(this.posX);
			int k = MathHelper.floor_double(this.posZ);

			Block blockID = this.worldObj.getBlock(j, i, k);

			// Is the block in question a nether native block?
			return super.getCanSpawnHere() &&
					(blockID == Blocks.netherrack || blockID == Blocks.nether_brick || blockID == Blocks.soul_sand); 
		}
		else
		{
			return super.getCanSpawnHere();
		}
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
			neckBobbleIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			neckBobbleIdleAnimationClock[i].setPhaseDurationX(0, 50);
			neckBobbleIdleAnimationClock[i].setPhaseDurationY(0, 150);

			float pointClusterDensityX = 0.60F;
			float pointClusterDensityY = 0.35F;

			int startingClockX = (int)(((float)(neckBobbleIdleAnimationClock.length - i) / (float)neckBobbleIdleAnimationClock.length) * (float)neckBobbleIdleAnimationClock[i].getTotalDurationLengthX() * pointClusterDensityX) + randomInt;
			int startingClockY = (int)(((float)(neckBobbleIdleAnimationClock.length - i) / (float)neckBobbleIdleAnimationClock.length) * (float)neckBobbleIdleAnimationClock[i].getTotalDurationLengthY() * pointClusterDensityY) + randomInt;

			while(startingClockX > neckBobbleIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= neckBobbleIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > neckBobbleIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= neckBobbleIdleAnimationClock[i].getTotalDurationLengthY();
			}

			neckBobbleIdleAnimationClock[i].setClockX(startingClockX);
			neckBobbleIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 100);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 50);

			float pointClusterDensityX = 0.30F;
			float pointClusterDensityY = 0.40F;

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