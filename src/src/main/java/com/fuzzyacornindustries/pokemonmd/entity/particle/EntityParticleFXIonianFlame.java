package com.fuzzyacornindustries.pokemonmd.entity.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityParticleFXIonianFlame extends EntityFX
{
	private float flameScale;

	private int currentTextureNumber = 0;

	public EntityParticleFXIonianFlame(World worldPar, double positionX, double positionY, double positionZ, double startingMotionX, double startingMotionY, double startingMotionZ)
	{
		super(worldPar, positionX, positionY, positionZ, startingMotionX, startingMotionY, startingMotionZ);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        this.motionX += startingMotionX;
        this.motionY += startingMotionY;
        this.motionZ += startingMotionZ;
		this.flameScale = this.particleScale;
		this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
		this.particleMaxAge = (int)(5.0D / (Math.random() * 0.8D + 0.2D)) + 1;
	}

	@Override
	public void renderParticle(Tessellator tessellatorPar, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
	{
		float f6 = ((float)this.particleAge + p_70539_2_) / (float)this.particleMaxAge;
		this.particleScale = this.flameScale * (1.0F - f6 * f6 * 0.5F);
		super.renderParticle(tessellatorPar, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
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

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("IonianFlameTexture", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("IonianFlameTexture");
			this.setCurrentTexture(b0);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("IonianFlameTexture", (byte)this.getCurrentTexture());
	}

	@Override
	public int getBrightnessForRender(float partialTickTime)
	{
		float f1 = ((float)this.particleAge + partialTickTime) / (float)this.particleMaxAge;

		if (f1 < 0.0F)
		{
			f1 = 0.0F;
		}

		if (f1 > 1.0F)
		{
			f1 = 1.0F;
		}

		int i = super.getBrightnessForRender(partialTickTime);
		int j = i & 255;
		int k = i >> 16 & 255;
		j += (int)(f1 * 15.0F * 16.0F);

		if (j > 240)
		{
			j = 240;
		}

		return j | k << 16;
	}

	@Override
	public float getBrightness(float partialTickTime)
	{
		float f1 = ((float)this.particleAge + partialTickTime) / (float)this.particleMaxAge;

		if (f1 < 0.0F)
		{
			f1 = 0.0F;
		}

		if (f1 > 1.0F)
		{
			f1 = 1.0F;
		}

		float f2 = super.getBrightness(partialTickTime);
		return f2 * f1 + (1.0F - f1);
	}

	@Override
	public void onUpdate()
	{
		if(currentTextureNumber >= 2)
		{
			currentTextureNumber = 0;
		}
		else
		{
			currentTextureNumber++;
		}

		setCurrentTexture(currentTextureNumber);
		
		this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.motionY += 0.004D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY)
        {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
	}
}