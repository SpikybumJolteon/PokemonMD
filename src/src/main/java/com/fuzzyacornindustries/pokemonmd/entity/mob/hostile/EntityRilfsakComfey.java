package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.LibraryFlowers;
import com.fuzzyacornindustries.pokemonmd.library.LibraryLargeFlowers;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityRilfsakComfey extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock leavesIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[14];

	public float field_70886_e;
	public float destPos;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;

	static String mobName = "rilfsakcomfey";

	public EntityRilfsakComfey(World par1World)
	{
		super(par1World);
		this.setSize(0.9F, 0.5F);

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
			if(this.rand.nextInt(10) == 1)
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

					((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.poison.id, b0 * 20, 0));
				}
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
		return null;//ModInfo.MODID + ":mob." + getMobName() + ".living";
	}
	// Happiny
	// Shaymin
	// Cherubi
	// Victini
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

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Blocks.red_flower, 1, LibraryFlowers.POPPY), 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.entityDropItem(new ItemStack(Blocks.double_plant, 1, LibraryLargeFlowers.ROSE_BUSH), 1);
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockLeaves() 
	{
		return leavesIdleAnimationClock;
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
		leavesIdleAnimationClock.incrementClocks();

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setTailClockDefaults();
		setLeavesClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setLeavesClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		leavesIdleAnimationClock = new IdleAnimationClock(0, 0, 1);

		leavesIdleAnimationClock.setPhaseDurationZ(0, 45);

		int startingClockZ = randomInt;

		while(startingClockZ > leavesIdleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= leavesIdleAnimationClock.getTotalDurationLengthZ();
		}

		leavesIdleAnimationClock.setClockZ(startingClockZ);
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 0, 1);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 35);
			tailIdleAnimationClock[i].setPhaseDurationZ(0, 70);

			float frequencyX = 0.70F;
			float frequencyZ = 0.75F;

			int startingClockX = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockZ = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockX > tailIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= tailIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockZ > tailIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= tailIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			tailIdleAnimationClock[i].setClockX(startingClockX);
			tailIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}
}