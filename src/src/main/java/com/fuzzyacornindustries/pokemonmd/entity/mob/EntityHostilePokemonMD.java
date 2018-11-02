package com.fuzzyacornindustries.pokemonmd.entity.mob;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHostilePokemonMD extends EntityMob implements IAnimatedEntity, IMobMotionTracker
{
	public float previousYaw[] = new float[6];
	public float changeInYaw;

	public float previousHeight[] = new float[6];
	public float changeInHeight;
	
	protected int animationID;
	protected int animationTick;

	public static final int actionIDNone = 0;

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(this.worldObj.isRemote)
		{
			incrementPartClocks();
		}
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		if(this.worldObj.isRemote)
		{
			float currentYaw = this.renderYawOffset;

			if(currentYaw - previousYaw[0] > 180F)
			{
				for(int i = 0; i < previousYaw.length; i++)
				{
					previousYaw[i] += (currentYaw - previousYaw[i]);
				}
			}
			else if(currentYaw - previousYaw[0] < -180F)
			{
				for(int i = 0; i < previousYaw.length; i++)
				{
					previousYaw[i] += (currentYaw - previousYaw[i]);
				}
			}

			float sum = 0;
			for (float d : previousYaw) sum += d;
			float averagePreviousYaw = 1.0F * sum / previousYaw.length;

			changeInYaw = (currentYaw - averagePreviousYaw) / 50F;

			for(int i = previousYaw.length - 1; i > 0; i--)
			{
				previousYaw[i] = previousYaw[i - 1];
			}

			previousYaw[0] = currentYaw;

			//System.out.println( "Test change in pitch" );
			//System.out.println( Float.toString( this.renderYawOffset ) );
			//System.out.println( Float.toString( averagePreviousYaw ) );
			//System.out.println( Float.toString( changeInYaw ) );

			float currentHeight = (float)this.posY;

			float sum2 = 0;
			for (float d : previousHeight) sum2 += d;
			float averagePreviousHeight = 1.0F * sum2 / previousHeight.length;

			changeInHeight = (currentHeight - averagePreviousHeight) / 2F;

			for(int i = previousHeight.length - 1; i > 0; i--)
			{
				previousHeight[i] = previousHeight[i - 1];
			}

			previousHeight[0] = currentHeight;
		}
	}
	
	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if(itemstack != null)
		{
			if(itemstack.getItem() == PokemonMDItem.deminizer)
			{
				for(int i = 0; i < 5; i++)
				{
					this.worldObj.spawnParticle("largeexplode", this.posX + this.rand.nextGaussian(), this.posY + this.height / 2D + this.rand.nextGaussian(), this.posZ + this.rand.nextGaussian(), 1.0D, 0.0D, 0.0D);
				}

				this.worldObj.playSoundAtEntity(this, ModInfo.MODID + ":effects.deminizer", 3.0F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
			}
		}

		return super.interact(par1EntityPlayer);
	}

	public void playIgniteSound(EntityLivingBase targetEntity)
	{
		targetEntity.worldObj.playSoundAtEntity(targetEntity, ModInfo.MODID + ":mob.commonsounds.ignite", 1.5F, 0.4F / (targetEntity.worldObj.rand.nextFloat() * 0.4F + 0.8F));
	}

	public void playBioSound(EntityLivingBase targetEntity)
	{
		targetEntity.worldObj.playSoundAtEntity(targetEntity, ModInfo.MODID + ":mob.commonsounds.bio", 1.5F, 0.4F / (targetEntity.worldObj.rand.nextFloat() * 0.4F + 0.8F));
	}

	public EntityHostilePokemonMD(World world)
	{
		super(world);

		animationID = actionIDNone;
		animationTick = 0;

		if(this.worldObj.isRemote)
		{
			for(int i = 0; i < previousYaw.length; i++)
			{
				previousYaw[i] = this.renderYawOffset;
			}

			changeInYaw = 0;

			for(int i = 0; i < previousHeight.length; i++)
			{
				previousHeight[i] = (float)this.posY;
			}

			changeInHeight = 0;
		}
	}
	
	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public void incrementPartClocks() {}

	@SideOnly(Side.CLIENT)
	public float getAngularVelocity()
	{	
		float angularVelocity = changeInYaw;

		if(angularVelocity != 0)
		{
			if(angularVelocity > 1F)
				angularVelocity = 1F;
			else if(angularVelocity < -1F)
				angularVelocity = -1F;
		}

		return angularVelocity;
	}

	@SideOnly(Side.CLIENT)
	public float getHeightVelocity()
	{	
		float verticalVelocity = changeInHeight;

		if(verticalVelocity != 0)
		{
			if(verticalVelocity > 1F)
				verticalVelocity = 1F;
			else if(verticalVelocity < -1F)
				verticalVelocity = -1F;
		}
		return verticalVelocity;
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
}