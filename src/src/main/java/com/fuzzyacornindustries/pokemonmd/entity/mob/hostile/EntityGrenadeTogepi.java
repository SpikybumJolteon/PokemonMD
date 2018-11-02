package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import net.minecraft.entity.Entity;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.EntityAIGrenadeTogepiSwell;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGrenadeTogepi extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock armsIdleAnimationClock;

	static String mobName = "grenadetogepi";

	private int lastActiveTime;

	private int timeSinceIgnited;
	private int fuseTime = 40;

	private int explosionRadius = 2;

	private int attackType = 0;
	private int numberOfTimesDamaged = 0;

	public EntityGrenadeTogepi(World par1World)
	{
		super(par1World);
		this.setSize(0.6F, 0.9F);

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIGrenadeTogepiSwell(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
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
	protected void fall(float par1)
	{
		super.fall(par1);
		this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + par1 * 1.5F);

		if (this.timeSinceIgnited > this.fuseTime - 5)
		{
			this.timeSinceIgnited = this.fuseTime - 5;
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		
		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
		this.dataWatcher.addObject(16, Byte.valueOf((byte) - 1));
		this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onUpdate()
	{
		setAttackType();

		if (attackType == 1)
		{
			if (this.isEntityAlive())
			{
				if(hasBeenAttackedByFlintAndSteel())
				{
					this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);

					this.entityDropItem(new ItemStack(Blocks.netherrack), 1);
					this.dropItem(PokemonMDItem.aurumDust, 1);

					this.playSound(ModInfo.MODID + ":mob." + getMobName() + ".death", 0.50F, 1.0F);

					this.setHealth(0);
				}
				else
				{
					this.lastActiveTime = this.timeSinceIgnited;
					int i = this.getTogepiState();

					if (i > 0 && this.timeSinceIgnited == 0)
					{
						this.playSound(ModInfo.MODID + ":mob." + getMobName() + ".fuse", 0.50F, 1.0F);
					}

					this.timeSinceIgnited += i;

					if (this.timeSinceIgnited < 0)
					{
						this.timeSinceIgnited = 0;
					}

					if (this.timeSinceIgnited >= this.fuseTime)
					{
						this.timeSinceIgnited = this.fuseTime;

						if (!this.worldObj.isRemote)
						{
							boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

							this.playSound(ModInfo.MODID + ":mob." + getMobName() + ".explode", 0.50F, 1.0F);
							this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);

							this.setDead();
						}
					}
				}
			}
		}

		super.onUpdate();
	}

	public int getAttackType()
	{
		return attackType;
	}

	public void setAttackType()
	{
		if (numberOfTimesDamaged <= 1)
		{
			attackType = 0;
		}
		else
		{
			attackType = 1;
		}
	}

	@Override
	public boolean interact(EntityPlayer p_70085_1_)
	{
		ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == Items.flint_and_steel)
		{
			p_70085_1_.swingItem();

			if (!this.worldObj.isRemote)
			{
				this.entityDropItem(new ItemStack(Blocks.netherrack), 1);
				this.dropItem(PokemonMDItem.aurumDust, 1);

				this.playSound(ModInfo.MODID + ":mob." + getMobName() + ".death", 0.50F, 1.0F);

				this.setHealth(0);

				this.setAttackedByFlintAndSteel();
				itemstack.damageItem(1, p_70085_1_);
				return true;
			}
		}

		return super.interact(p_70085_1_);
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
			numberOfTimesDamaged++;
			return true;
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (attackType == 0)
		{
			boolean flag = super.attackEntityAsMob(par1Entity);

			float f = this.getBrightness(1.0F);

			if (f >= 0.8F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
			{
				par1Entity.setFire(fireAspectDuration(2));
			}
			else if (this.rand.nextInt(3) == 0)
			{
				par1Entity.setFire(fireAspectDuration(1));
			}

			return flag;
		}
		else
		{
			return true;
		}
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
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);

		par1NBTTagCompound.setShort("Fuse", (short)this.fuseTime);
		par1NBTTagCompound.setByte("ExplosionRadius", (byte)this.explosionRadius);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("Fuse"))
		{
			this.fuseTime = par1NBTTagCompound.getShort("Fuse");
		}

		if (par1NBTTagCompound.hasKey("ExplosionRadius"))
		{
			this.explosionRadius = par1NBTTagCompound.getByte("ExplosionRadius");
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
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(1 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.gunpowder, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		int j;
		int k;

		j = this.rand.nextInt(4);

		for (k = 0; k < j; ++k)
		{
			this.entityDropItem(new ItemStack(Blocks.netherrack), 1);
		}

		j = this.rand.nextInt(3);

		for (k = 0; k < j; ++k)
		{
			this.dropItem(Items.blaze_powder, 1);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getTogepiFlashIntensity(float par1)
	{
		return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * par1) / (float)(this.fuseTime - 2);
	}

	/**
	 * Returns/Sets the current state of togepi, -1 is idle, 1 is 'in fuse'
	 */
	public int getTogepiState()
	{
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setTogepiState(int par1)
	{
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)par1));
	}

	public boolean hasBeenAttackedByFlintAndSteel()
	{
		return this.dataWatcher.getWatchableObjectByte(16) == 1;
	}

	public void setAttackedByFlintAndSteel()
	{
		this.dataWatcher.updateObject(18, Byte.valueOf((byte)1));
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockArms()
	{
		return armsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		armsIdleAnimationClock.incrementClocks();
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setArmsClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setArmsClockDefaults()
	{
		int startingClockZ = this.rand.nextInt(100);

		armsIdleAnimationClock = new IdleAnimationClock(0, 0, 1);

		armsIdleAnimationClock.setPhaseDurationZ(0, 30);

		while(startingClockZ > armsIdleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= armsIdleAnimationClock.getTotalDurationLengthZ();
		}

		armsIdleAnimationClock.setClockZ(startingClockZ);
	}
}