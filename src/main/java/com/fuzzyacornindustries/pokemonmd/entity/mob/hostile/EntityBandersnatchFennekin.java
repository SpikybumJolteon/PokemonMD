package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityBandersnatchFennekin extends EntityHostilePokemonMD implements IAnimatedEntity
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[4];

	static String mobName = "bandersnatchfennekin";
	
	private int currentTextureNumber = 0;

	public EntityBandersnatchFennekin(World par1World)
	{
		super(par1World);
		this.setSize(0.5F, 0.9F);

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
	protected void entityInit()
	{
		super.entityInit();
		
		this.dataWatcher.addObject(16, new Byte((byte)0));
		this.dataWatcher.addObject(13, new Byte((byte)0));
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.1D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.90D);
	}

	@Override
	protected void fall(float par1) {}

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
	protected void attackEntity(Entity par1Entity, float par2)
	{		
		if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0)
		{
			if (this.onGround)
			{
				double d0 = par1Entity.posX - this.posX;
				double d1 = par1Entity.posZ - this.posZ;
				float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
				this.motionX = d0 / (double)f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
				this.motionZ = d1 / (double)f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
				this.motionY = 0.4000000059604645D;
			}
		}
		else
		{
			super.attackEntity(par1Entity, par2);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		if (super.attackEntityAsMob(targetEntity))
		{
			if (targetEntity instanceof EntityLivingBase)
			{
				if (this.rand.nextInt(2) == 0)
				{
					((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, statusEffectDurationModifier(5) * 20, 0));
				}

				if (this.rand.nextInt(4) == 0)
				{
					((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.weakness.id, statusEffectDurationModifier(5) * 20, 0));
				}

				if (this.rand.nextInt(10) == 0)
				{
					((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.blindness.id, statusEffectDurationModifier(5) * 20, 0));
				}

				if (this.rand.nextInt(10) == 0)
				{
					targetEntity.setFire(statusEffectDurationModifier(1));
				}

				((EntityLivingBase)targetEntity).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, statusEffectDurationModifier(5) * 20, 0));
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	public int statusEffectDurationModifier(int durationModifier)
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
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.stick, 2);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.snowball, 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(PokemonMDItem.aurumDust, 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		switch (this.rand.nextInt(3))
		{
		case 0:
			this.dropItem(Items.blaze_rod, 1);
			break;
		case 1:
			this.dropItem(Items.nether_wart, 3);
			break;
		case 2:
			this.entityDropItem(new ItemStack(Blocks.soul_sand), 1);
		}

		this.dropItem(PokemonMDItem.rawstettaBerry, 1);
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	public boolean isBiomeForArticFurCoat()
	{
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
		
		if(biomegenbase == BiomeGenBase.frozenOcean || 
				biomegenbase == BiomeGenBase.frozenRiver || 
				biomegenbase == BiomeGenBase.coldTaiga || 
				biomegenbase == BiomeGenBase.coldTaigaHills ||
				biomegenbase == BiomeGenBase.iceMountains ||
				biomegenbase == BiomeGenBase.icePlains)
		{
			return true;
		}
		else if(biomegenbase == BiomeGenBase.extremeHills || 
				biomegenbase == BiomeGenBase.extremeHillsEdge || 
				biomegenbase == BiomeGenBase.extremeHillsPlus)
		{
			int i = MathHelper.floor_double(this.boundingBox.minY);

			if (i <= 92)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);

		// Type 1 is Temperate Coat where Type 0 is default Snow Coat
		if (isBiomeForArticFurCoat())
		{
			this.setBandersnatchFennekinType(0);
		}
		else
		{
			this.setBandersnatchFennekinType(1);
		}

		return par1EntityLivingData;
	}

	public int getBandersnatchFennekinType()
	{
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	public void setBandersnatchFennekinType(int par1)
	{
		this.dataWatcher.updateObject(13, Byte.valueOf((byte)par1));
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("BandersnatchFennekinType", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("BandersnatchFennekinType");
			this.setBandersnatchFennekinType(b0);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("BandersnatchFennekinType", (byte)this.getBandersnatchFennekinType());
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.moveSlowdown.id ? false : super.isPotionApplicable(par1PotionEffect);
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
	public IdleAnimationClock getIdleAnimationClockTail(int partNumber)
	{
		return tailIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void incrementPartClocks()
	{
		neckBobbleIdleAnimationClock.incrementClocks();
		
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

		neckBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 45);

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
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 25);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 50);

			float pointClusterDensityX = 0.40F;
			float pointClusterDensityY = 0.30F;

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