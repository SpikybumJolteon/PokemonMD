package com.fuzzyacornindustries.pokemonmd.entity.mob.ability;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralLeapAtTarget;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralMeleeJumper;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityNormalFoxfire extends EntityAgeable implements IAnimatedEntity, IAnimateFoxfire
{
	private IdleAnimationClock spinIdleAnimationClock;
	private IdleAnimationClock verticalFloatIdleAnimationClock;

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	static String mobName = "normalfoxfire";

	private int currentTextureNumber = 0;
	
	public float attackPower = 2F;

	public EntityNormalFoxfire(World par1World)
	{
		super(par1World);
		this.setSize(0.5F, 0.9F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new AIGeneralLeapAtTarget(this, 0.4F, 1.0F));
		this.tasks.addTask(2, new AIGeneralMeleeJumper(this, 1F, true));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));

		setClockDefaults();

		animationID = actionIDNone;
		animationTick = 0;

		this.experienceValue = 0;
	}

	public static String getMobName()
	{
		return mobName;
	}
	
	public void setAttackPower(float newAttackPower)
	{
		this.attackPower = newAttackPower;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.0001D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(10.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
	}

	public int getCurrentTexture()
	{
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	public void setCurrentTexture(int par1)
	{
		this.dataWatcher.updateObject(13, Byte.valueOf((byte)par1));
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("NormalFoxfireTexture", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("NormalFoxfireTexture");
			this.setCurrentTexture(b0);
		}
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("NormalFoxfireTexture", (byte)this.getCurrentTexture());
	}

	@Override
	protected void fall(float par1) {}
	
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
			this.attackEntityFrom(DamageSource.drown, 100.0F);
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(currentTextureNumber >= 31)
		{
			currentTextureNumber = 0;
		}
		else
		{
			currentTextureNumber++;
		}

		if(this.ticksExisted < 15)
		{
			this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
		}

		if(this.ticksExisted > 200)
		{
			this.setDead();
		}

		if (ticksExisted % 5 == 0)
		{
			double motionX = rand.nextGaussian() * 0.02D;
			double motionY = rand.nextGaussian() * 0.02D;
			double motionZ = rand.nextGaussian() * 0.02D;
			worldObj.spawnParticle("largesmoke", posX + rand.nextFloat() * width * 2.0F - width, 
					posY + 0.5D + rand.nextFloat() * height - 1F, posZ + rand.nextFloat() * width * 2.0F - width, motionX, motionY, motionZ);
		}

		if (ticksExisted % 2 == 0)
		{
			PokemonMDMain.proxy.generateParticleNormalFlame(this);
		}

		setCurrentTexture(currentTextureNumber);

		incrementPartClocks();
	}

	@Override
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		this.setDead();

		return targetEntity.attackEntityFrom(DamageSource.causeMobDamage(this), this.attackPower);
	}

	@Override
	protected String getHurtSound()
	{
		return null;//ModStrings.MODID + ":mob." + getMobName() + ".hurt";
	}

	@Override
	protected String getLivingSound()
	{
		return null;//ModStrings.MODID + ":mob." + getMobName() + ".living";
	}

	protected void func_145780_a(int xCoord, int yCoord, int zCoord, Block blockUnderneath)
	{
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}

	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float p_70070_1_)
	{
		return 15728880;
	}

	/**
	 * Gets how bright this entity is.
	 */
	public float getBrightness(float p_70013_1_)
	{
		return 1.0F;
	}
	/*
	@Override
	public void onDeath(DamageSource p_70645_1_)
    {
        if (ForgeHooks.onLivingDeath(this, p_70645_1_)) return;
        Entity entity = p_70645_1_.getEntity();

        this.dead = true;
        this.func_110142_aN().func_94549_h();

        this.worldObj.setEntityState(this, (byte)3);
    }

	@Override
    protected void onDeathUpdate()
    {
        ++this.deathTime;

        if (this.deathTime == 20)
        {
            this.setDead();

            for (int i = 0; i < 20; ++i)
            {
                double d2 = this.rand.nextGaussian() * 0.02D;
                double d0 = this.rand.nextGaussian() * 0.02D;
                double d1 = this.rand.nextGaussian() * 0.02D;
                this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d2, d0, d1);
            }
        }
    }
	 */
	@Override
	protected void damageEntity(DamageSource p_70665_1_, float p_70665_2_)
	{
		if (!this.isEntityInvulnerable())
		{
			p_70665_2_ = ForgeHooks.onLivingHurt(this, p_70665_1_, p_70665_2_);
			if (p_70665_2_ <= 0) return;
			p_70665_2_ = this.applyArmorCalculations(p_70665_1_, p_70665_2_);
			p_70665_2_ = this.applyPotionDamageCalculations(p_70665_1_, p_70665_2_);
			float f1 = p_70665_2_;
			p_70665_2_ = Math.max(p_70665_2_ - this.getAbsorptionAmount(), 0.0F);
			this.setAbsorptionAmount(this.getAbsorptionAmount() - (f1 - p_70665_2_));
		}

		this.setDead();
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return false;
	}

	@Override
	public boolean canBePushed()
	{
		return false;
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@Override
	public IdleAnimationClock getIdleAnimationClockSpin() 
	{
		return spinIdleAnimationClock;
	}


	public IdleAnimationClock getIdleAnimationClockVerticalFloat()
	{
		return verticalFloatIdleAnimationClock;
	}

	public void incrementPartClocks()
	{
		spinIdleAnimationClock.incrementClocks();
		verticalFloatIdleAnimationClock.incrementClocks();
	}

	public void setClockDefaults()
	{
		setSpinClockDefaults();
		setVerticalFloatClockDefaults();
	}

	public void setSpinClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		spinIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		spinIdleAnimationClock.setPhaseDurationY(0, 60);

		int startingClockY = randomInt;

		while(startingClockY > spinIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= spinIdleAnimationClock.getTotalDurationLengthY();
		}

		spinIdleAnimationClock.setClockY(startingClockY);
	}

	public void setVerticalFloatClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		verticalFloatIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		int duration = 60;

		verticalFloatIdleAnimationClock.setPhaseDurationY(0, duration);

		int startingClockY = verticalFloatIdleAnimationClock.getTotalDurationLengthY() + randomInt;

		verticalFloatIdleAnimationClock.setClockY(startingClockY);
	}

	@Override
	public void setAnimationID(int id) 
	{
		animationID = id;
	}

	@Override
	public void setAnimationTick(int tick) 
	{
		animationTick = tick;	
	}

	@Override
	public int getAnimationID() 
	{
		return animationID;
	}

	@Override
	public int getAnimationTick() 
	{
		return animationTick;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) 
	{
		return null;
	}
}