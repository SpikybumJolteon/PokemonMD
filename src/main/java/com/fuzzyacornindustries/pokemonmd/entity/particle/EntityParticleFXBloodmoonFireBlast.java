package com.fuzzyacornindustries.pokemonmd.entity.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityParticleFXBloodmoonFireBlast extends EntityFX
{
	private float fireBlastFlameScale;

	private int currentTextureNumber = 0;
	
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;

    public EntityParticleFXBloodmoonFireBlast(World worldPar, double positionX, double positionY, double positionZ, double startingMotionX, double startingMotionY, double startingMotionZ)
    {
        super(worldPar, positionX, positionY, positionZ, startingMotionX, startingMotionY, startingMotionZ);
        this.motionX = startingMotionX;
        this.motionY = startingMotionY;
        this.motionZ = startingMotionZ;
        this.portalPosX = this.posX = this.prevPosX = positionX;
        this.portalPosY = this.posY = this.prevPosY = positionY;
        this.portalPosZ = this.posZ = this.prevPosZ = positionZ;
        float f = this.rand.nextFloat() * 0.6F + 0.4F;
        this.fireBlastFlameScale = this.particleScale = this.rand.nextFloat() * 0.2F + 0.5F;
        this.particleMaxAge = (int)(Math.random() * 10.0D) + 40;
        this.particleAge = 1;
        this.noClip = true;
		this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
    }

    public void renderParticle(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        float f6 = ((float)this.particleAge + p_70539_2_) / (float)this.particleMaxAge;
        f6 = 1.0F - f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        this.particleScale = this.fireBlastFlameScale * f6;
        super.renderParticle(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
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

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float f = (float)this.particleAge / (float)this.particleMaxAge;
        float f1 = f;
        f = -f + f * f * 2.0F;
        f = 1.0F - f;
        this.posX = this.portalPosX + this.motionX * (double)f;
        this.posY = this.portalPosY + this.motionY * (double)f + (double)(1.0F - f1);
        this.posZ = this.portalPosZ + this.motionZ * (double)f;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }
    }
}