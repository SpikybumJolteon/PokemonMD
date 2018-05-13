package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralLeapAtTarget;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralMeleeJumper;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityZerglingNincada extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock wingsIdleAnimationClock;
	private IdleAnimationClock backArmsIdleAnimationClock;

	public static final int ZERGLING_ID = 0;
	public static final int RAPTOR_ZERGLING_ID = 1;
	public static final int CRACKLING_ID = 2;

	static String mobName = "zerglingnincada";

	private static int zerglingType = 0;

	public EntityZerglingNincada(World par1World)
	{
		super(par1World);

		this.setSize(0.4F, 0.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
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

		if(this.getZerglingNincadaType() == this.ZERGLING_ID)
		{
			this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(22.0D);
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		}
		else if(this.getZerglingNincadaType() == this.RAPTOR_ZERGLING_ID)
		{
			this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.40D);
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.40D);
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		}
	}

	@Override
	public int getTotalArmorValue()
	{
		if(this.getZerglingNincadaType() == this.CRACKLING_ID)
		{
			return 2;
		}

		return 0;
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
	protected void fall(float par1) 
	{
		if(this.getZerglingNincadaType() == this.RAPTOR_ZERGLING_ID || this.getZerglingNincadaType() == this.CRACKLING_ID)
		{}
		else
		{
			super.fall(par1);
		}
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
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
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		boolean flag = super.attackEntityAsMob(targetEntity);

		return flag;
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
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(2 + lootingEnchantmentLevel + this.getZerglingNincadaType() * 4);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		if(this.getZerglingNincadaType() == this.CRACKLING_ID)
		{

		}
		else if(this.getZerglingNincadaType() == this.RAPTOR_ZERGLING_ID)
		{

		}
		else
		{

		}
		//this.dropItem(Items.ender_pearl, 1);
		//this.dropItem(Items.iron_ingot, 1);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);

		int typeChance = this.rand.nextInt(30);

		if (typeChance <= 6 && (this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.worldObj.getCurrentMoonPhaseFactor() == 1.0F))
		{
			this.setZerglingNincadaType(this.CRACKLING_ID);
		}
		else if (typeChance <= 10)
		{
			this.setZerglingNincadaType(this.RAPTOR_ZERGLING_ID);
		}
		else
		{
			this.setZerglingNincadaType(this.ZERGLING_ID);
		}

		setCombatTask();

		return par1EntityLivingData;
	}

	public void setCombatTask()
	{
		if (this.getZerglingNincadaType() == this.CRACKLING_ID)
		{
			this.tasks.addTask(1, new AIGeneralLeapAtTarget(this, 0.4F, 1.0F));
			this.tasks.addTask(2, new AIGeneralMeleeJumper(this, 1F, true));
		}
		else if (this.getZerglingNincadaType() == this.RAPTOR_ZERGLING_ID)
		{
			this.tasks.addTask(1, new AIGeneralLeapAtTarget(this, 0.6F, 0.7F));
			this.tasks.addTask(2, new AIGeneralMeleeJumper(this, 1F, true));
		}
		else
		{
			this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1F, false));
		}
	}

	public int getZerglingNincadaType()
	{
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	public void setZerglingNincadaType(int par1)
	{
		this.dataWatcher.updateObject(13, Byte.valueOf((byte)par1));

		if(this.zerglingType == this.CRACKLING_ID)
		{
			this.isImmuneToFire = true;
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("ZerglingNincadaType", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("ZerglingNincadaType");
			this.setZerglingNincadaType(b0);
		}

		setCombatTask();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("ZerglingNincadaType", (byte)this.getZerglingNincadaType());
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
	public IdleAnimationClock getIdleAnimationClockBackArms()
	{
		return backArmsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockWings()
	{
		return wingsIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		neckBobbleIdleAnimationClock.incrementClocks();
		backArmsIdleAnimationClock.incrementClocks();
		wingsIdleAnimationClock.incrementClocks();
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setNeckBobbleClockDefaults();
		setBackArmsClockDefaults();
		setWingsClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setNeckBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		neckBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 40);

		int startingClockX = randomInt;

		while(startingClockX > neckBobbleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= neckBobbleIdleAnimationClock.getTotalDurationLengthX();
		}

		neckBobbleIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setBackArmsClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		backArmsIdleAnimationClock = new IdleAnimationClock(2, 0, 0);

		backArmsIdleAnimationClock.setPhaseDurationX(0, 20);
		backArmsIdleAnimationClock.setPhaseDurationX(1, 20);

		int startingClockX = randomInt;

		while(startingClockX > backArmsIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= backArmsIdleAnimationClock.getTotalDurationLengthX();
		}

		backArmsIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setWingsClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		wingsIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		wingsIdleAnimationClock.setPhaseDurationY(0, 60);

		int startingClockY = randomInt;

		while(startingClockY > wingsIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= wingsIdleAnimationClock.getTotalDurationLengthY();
		}

		wingsIdleAnimationClock.setClockY(startingClockY);
	}
}