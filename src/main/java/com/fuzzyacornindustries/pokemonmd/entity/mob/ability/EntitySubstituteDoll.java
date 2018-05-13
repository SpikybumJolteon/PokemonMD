package com.fuzzyacornindustries.pokemonmd.entity.mob.ability;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.Optional.Method;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

@Optional.Interface(iface="micdoodle8.mods.galacticraft.api.entity.IEntityBreathable", modid="GalacticraftCore", striprefs=true)
public class EntitySubstituteDoll extends EntityAnimal implements IEntityBreathable
{
	static String mobName = "substitutedoll";

	public static final int NORMAL_ID = 0;
	public static final int RESILIENT_ID = 1;
	public static final int OBSIDIAN_ID = 2;

	float defaultHealth = 100F;
	
	public EntitySubstituteDoll(World par1World)
	{
		super(par1World);
		this.setSize(0.8F, 0.9F);

		this.experienceValue = 0;
	}

	public static String getMobName()
	{
		return mobName;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);

		if(this.getDollType() == this.OBSIDIAN_ID)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		}
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
	}

	public int getDollType()
	{
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	public void setDollType(int par1)
	{
		this.dataWatcher.updateObject(13, Byte.valueOf((byte)par1));
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("SubstituteDollType", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("SubstituteDollType");
			this.setDollType(b0);
		}
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("SubstituteDollType", (byte)this.getDollType());
	}

	@Override
	protected void fall(float par1) {}

	@Method(modid="GalacticraftCore")
	@Override
	public boolean canBreath()
	{
		return true;
	}
	
	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
	}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onLivingUpdate()
	{
		if(this.getDollType() == this.OBSIDIAN_ID)
		{
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	protected void func_145780_a(int xCoord, int yCoord, int zCoord, Block blockUnderneath)
	{
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) 
	{
		return null;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		if(this.getDollType() == this.OBSIDIAN_ID || this.getDollType() == this.RESILIENT_ID)
		{
			return false;
		}

		return super.isPotionApplicable(par1PotionEffect);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);

		if(this.getDollType() == this.OBSIDIAN_ID || this.getDollType() == this.RESILIENT_ID)
		{
			this.isImmuneToFire = true;
		}

		return (IEntityLivingData)par1EntityLivingData1;
	}
}