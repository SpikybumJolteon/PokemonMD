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
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityZealotPawniard extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock armsIdleAnimationClock;

	static String mobName = "zealotpawniard";

	public EntityZealotPawniard(World par1World)
	{
		super(par1World);
		this.setSize(0.3F, 0.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1F, false));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

		this.experienceValue = 2;

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

		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
	}

	@Override
	public int getTotalArmorValue()
	{
		return 2;
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
		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
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
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(PokemonMDItem.xelNagaShard, 1);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);

		playSound(ModInfo.MODID + ":mob." + getMobName() + ".spawn", this.getSoundVolume() + 0.7F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);

		return (IEntityLivingData)par1EntityLivingData1;
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

		armsIdleAnimationClock.setPhaseDurationZ(0, 50);

		while(startingClockZ > armsIdleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= armsIdleAnimationClock.getTotalDurationLengthZ();
		}

		armsIdleAnimationClock.setClockZ(startingClockZ);
	}
}