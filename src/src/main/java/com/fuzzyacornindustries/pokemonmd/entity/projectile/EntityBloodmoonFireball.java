package com.fuzzyacornindustries.pokemonmd.entity.projectile;

import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityBloodmoonFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityBloodmoonNinetales;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockWeb;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBloodmoonFireball extends PokemonMDFireball
{
	private int currentTextureNumber = 0;
	private float attackPower;
	
	public EntityBloodmoonFireball(World worldPar)
	{
		super(worldPar);
	}

	public EntityBloodmoonFireball(World worldPar, double p_i1760_2_, double p_i1760_4_, double p_i1760_6_, double p_i1760_8_, double p_i1760_10_, double p_i1760_12_, float fireballSpeedModifier)
	{
		super(worldPar, p_i1760_2_, p_i1760_4_, p_i1760_6_, p_i1760_8_, p_i1760_10_, p_i1760_12_, fireballSpeedModifier);
	}

	public EntityBloodmoonFireball(World worldPar, EntityLivingBase shootingEntity, double p_i1761_3_, double p_i1761_5_, double p_i1761_7_, float fireballSpeedModifier)
	{
		super(worldPar, shootingEntity, p_i1761_3_, p_i1761_5_, p_i1761_7_, fireballSpeedModifier);
	}

	public EntityBloodmoonFireball(World worldPar, EntityLivingBase shootingEntity, double setLocationX, double setLocationY, double setLocationZ,
			double accelerationXPar, double accelerationYPar, double accelerationZPar, float fireballSpeedModifier, float attackPower)
	{
		super(worldPar, shootingEntity, setLocationX, setLocationY, setLocationZ, accelerationXPar, accelerationYPar, accelerationZPar, fireballSpeedModifier);

		this.attackPower = attackPower;
	}

	@Override
	protected void entityInit()
	{
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

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("BloodmoonFlameTexture", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("BloodmoonFlameTexture");
			this.setCurrentTexture(b0);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("BloodmoonFlameTexture", (byte)this.getCurrentTexture());
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(this.ticksExisted > 200)
		{
			this.setDead();
			
			return;
		}
		
		if(currentTextureNumber >= 2)
		{
			currentTextureNumber = 0;
		}
		else
		{
			currentTextureNumber++;
		}

		setCurrentTexture(currentTextureNumber);
		
		int currentPosY = MathHelper.floor_double(this.posY);
		int currentPoxX = MathHelper.floor_double(this.posX);
		int currentPoxZ = MathHelper.floor_double(this.posZ);
		boolean flag = false;

		for (int l1 = -1; l1 <= 1; ++l1)
		{
			for (int i2 = -1; i2 <= 1; ++i2)
			{
				for (int j = 0; j <= 3; ++j)
				{
					int j2 = currentPoxX + l1;
					int k = currentPosY + j;
					int l = currentPoxZ + i2;
					Block block = this.worldObj.getBlock(j2, k, l);

					if (!block.isAir(worldObj, j2, k, l) && block == Blocks.tallgrass || block instanceof BlockDoublePlant || block instanceof BlockFlower || block instanceof BlockVine || block instanceof BlockWeb || block instanceof BlockLeaves || block instanceof BlockCactus)
					{
						flag = this.worldObj.func_147480_a(j2, k, l, true) || flag;
					}
				}
			}
		}
	}

	/**
	 * Called when this EntityFireball hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition parMovingObjectPosition)
	{
		if (!this.worldObj.isRemote && !(parMovingObjectPosition.entityHit instanceof EntityBloodmoonNinetales) 
				&& !(parMovingObjectPosition.entityHit instanceof EntityBloodmoonFoxfire))
		{
			
			if (parMovingObjectPosition.entityHit != null)
			{
				if (parMovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity).setProjectile(), this.attackPower))
				{
					parMovingObjectPosition.entityHit.setFire(5);
				}
			}
			else
			{
				int i = parMovingObjectPosition.blockX;
				int j = parMovingObjectPosition.blockY;
				int k = parMovingObjectPosition.blockZ;

				switch (parMovingObjectPosition.sideHit)
				{
				case 0:
					--j;
					break;
				case 1:
					++j;
					break;
				case 2:
					--k;
					break;
				case 3:
					++k;
					break;
				case 4:
					--i;
					break;
				case 5:
					++i;
				}
			}

			this.setDead();
		}
	}
}