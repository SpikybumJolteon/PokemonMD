package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.LibraryDye;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.utility.BiomeType;

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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityInfestedDeerling extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock;
	
	static String mobName = "infesteddeerling";

	public EntityInfestedDeerling(World par1World)
	{
		super(par1World);
		
		this.setSize(0.3F, 0.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1F, false));
		this.tasks.addTask(2, new EntityAIWander(this, 0.6D));
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
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.1D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
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
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
		{
			float f = this.getBrightness(1.0F);

			if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
			{
				this.setFire(8);
			}
		}

		for (int i = 0; i < 2; ++i)
		{
			this.worldObj.spawnParticle("townaura", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityLivingBase)
			{
				byte b0 = 5;

				if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
				{
					b0 = 10;
				}
				else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
				{
					b0 = 18;
				}

				if (this.rand.nextInt(2) == 0)
				{
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, b0 * 20, 0));
				}

				if (this.rand.nextInt(4) == 0)
				{
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0));
				}

				if (this.rand.nextInt(10) == 0)
				{
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, b0 * 20, 0));
				}

				((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.weakness.id, b0 * 20, 0));
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

			j = this.rand.nextInt(4 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.stick, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.slime_ball, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Items.dye, 1, LibraryDye.CACTUS_GREEN), 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.pechitaBerry, 1);

		switch (this.rand.nextInt(2))
		{
		case 0:
			this.entityDropItem(new ItemStack(Blocks.mycelium), 1);
			break;
		case 1:
			this.dropItem(Items.nether_wart, 3);
		}
	}

	@Override
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(this.posY) - 1;// Check block below point in question
		int j = MathHelper.floor_double(this.posX);
		int k = MathHelper.floor_double(this.posZ);

		Block blockID = this.worldObj.getBlock(j, i, k);

		// Is the block in question a grass block?
		return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && blockID == Blocks.grass; 
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
	public IdleAnimationClock getIdleAnimationClockTail()
	{
		return tailIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		neckBobbleIdleAnimationClock.incrementClocks();
		tailIdleAnimationClock.incrementClocks();
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

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 75);

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

		tailIdleAnimationClock = new IdleAnimationClock(1, 1, 0);

		tailIdleAnimationClock.setPhaseDurationX(0, 80);
		tailIdleAnimationClock.setPhaseDurationY(0, 60);

		int startingClockX = randomInt;

		while(startingClockX > tailIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= tailIdleAnimationClock.getTotalDurationLengthX();
		}

		int startingClockY = randomInt;

		while(startingClockY > tailIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= tailIdleAnimationClock.getTotalDurationLengthY();
		}

		tailIdleAnimationClock.setClockX(startingClockX);
		tailIdleAnimationClock.setClockY(startingClockY);
	}
}