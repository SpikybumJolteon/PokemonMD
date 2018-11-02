package com.fuzzyacornindustries.pokemonmd.entity.projectile;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlightOoze extends Entity
{
	protected int field_145795_e = -1;
	protected int field_145793_f = -1;
	protected int field_145794_g = -1;
	protected Block field_145796_h;
	protected boolean inGround;
	public EntityLivingBase shootingEntity;
	protected int ticksAlive;
	protected int ticksInAir;
	public double accelerationX;
	public double accelerationY;
	public double accelerationZ;

	public float fireballSpeedModifier;


	public EntityBlightOoze(World worldPar)
	{
		super(worldPar);
		this.setSize(0.3125F, 0.3125F);
		this.fireballSpeedModifier = 1.0F;
	}

	public EntityBlightOoze(World p_i1760_1_, double p_i1760_2_, double p_i1760_4_, double p_i1760_6_, double p_i1760_8_, double p_i1760_10_, double p_i1760_12_, float fireballSpeedModifier)
	{
		super(p_i1760_1_);
		this.setSize(0.3125F, 0.3125F);
		this.setLocationAndAngles(p_i1760_2_, p_i1760_4_, p_i1760_6_, this.rotationYaw, this.rotationPitch);
		this.setPosition(p_i1760_2_, p_i1760_4_, p_i1760_6_);
		double d6 = (double)MathHelper.sqrt_double(p_i1760_8_ * p_i1760_8_ + p_i1760_10_ * p_i1760_10_ + p_i1760_12_ * p_i1760_12_);
		this.accelerationX = p_i1760_8_ / d6 * 0.1D;
		this.accelerationY = p_i1760_10_ / d6 * 0.1D;
		this.accelerationZ = p_i1760_12_ / d6 * 0.1D;
		this.fireballSpeedModifier = fireballSpeedModifier;
	}

	public EntityBlightOoze(World p_i1761_1_, EntityLivingBase p_i1761_2_, double p_i1761_3_, double p_i1761_5_, double p_i1761_7_, float fireballSpeedModifier)
	{
		super(p_i1761_1_);
		this.shootingEntity = p_i1761_2_;
		this.setSize(0.3125F, 0.3125F);
		this.setLocationAndAngles(p_i1761_2_.posX, p_i1761_2_.posY, p_i1761_2_.posZ, p_i1761_2_.rotationYaw, p_i1761_2_.rotationPitch);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		this.motionX = this.motionY = this.motionZ = 0.0D;
		double d3 = (double)MathHelper.sqrt_double(p_i1761_3_ * p_i1761_3_ + p_i1761_5_ * p_i1761_5_ + p_i1761_7_ * p_i1761_7_);
		this.accelerationX = p_i1761_3_ / d3 * 0.1D;
		this.accelerationY = p_i1761_5_ / d3 * 0.1D;
		this.accelerationZ = p_i1761_7_ / d3 * 0.1D;
		this.fireballSpeedModifier = fireballSpeedModifier;
	}

	public EntityBlightOoze(World worldPar, EntityLivingBase shootingEntity, double setLocationX, double setLocationY, double setLocationZ,
			double accelerationXPar, double accelerationYPar, double accelerationZPar, float fireballSpeedModifier)
	{
		super(worldPar);

		this.shootingEntity = shootingEntity;
		this.setSize(0.3125F, 0.3125F);

		this.setLocationAndAngles(setLocationX, setLocationY, setLocationZ, shootingEntity.rotationYaw, shootingEntity.rotationPitch);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		this.motionX = this.motionY = this.motionZ = 0.0D;
		double d3 = (double)MathHelper.sqrt_double(accelerationXPar * accelerationXPar + accelerationYPar * accelerationYPar + accelerationZPar * accelerationZPar);
		this.accelerationX = accelerationXPar / d3 * 0.1D;
		this.accelerationY = accelerationYPar / d3 * 0.1D;
		this.accelerationZ = accelerationZPar / d3 * 0.1D;
		this.fireballSpeedModifier = fireballSpeedModifier;
	}

	public EntityBlightOoze(World world, EntityLivingBase shooterEntity, float baseSpeed)
	{
		super(world);

		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = shooterEntity;

		this.setSize(0.5F, 0.5F);
		this.setLocationAndAngles(shooterEntity.posX, shooterEntity.posY + (double)shooterEntity.getEyeHeight(), shooterEntity.posZ, shooterEntity.rotationYaw, shooterEntity.rotationPitch);

		this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		this.posY -= 0.10000000149011612D;
		this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);

		this.yOffset = 0.0F;

		this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
		this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
		this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));

		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, baseSpeed * 1.5F, 1.0F);
	}
	
	public void setThrowableHeading(double xDirection, double yDirection, double zDirection, float baseSpeed, float accuracy)
	{
		float vectorMagnitude = MathHelper.sqrt_double(xDirection * xDirection + yDirection * yDirection + zDirection * zDirection);

		xDirection /= (double)vectorMagnitude;
		yDirection /= (double)vectorMagnitude;
		zDirection /= (double)vectorMagnitude;

		xDirection += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)accuracy;
		yDirection += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)accuracy;
		zDirection += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)accuracy;

		xDirection *= (double)baseSpeed;
		yDirection *= (double)baseSpeed;
		zDirection *= (double)baseSpeed;

		this.motionX = xDirection;
		this.motionY = yDirection;
		this.motionZ = zDirection;

		float f3 = MathHelper.sqrt_double(xDirection * xDirection + zDirection * zDirection);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(xDirection, zDirection) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(yDirection, (double)f3) * 180.0D / Math.PI);
	}

	/**
	 * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
	 * length * 64 * renderDistanceWeight Args: distance
	 */
	 @SideOnly(Side.CLIENT)
	public boolean isInRangeToRenderDist(double p_70112_1_)
	{
		double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
		d1 *= 64.0D;
		return p_70112_1_ < d1 * d1;
	}

	 @Override
	 public void onUpdate()
	 {
		 if (!this.worldObj.isRemote && (this.shootingEntity != null && this.shootingEntity.isDead || !this.worldObj.blockExists((int)this.posX, (int)this.posY, (int)this.posZ)))
		 {
			 this.setDead();
		 }
		 else
		 {
			 super.onUpdate();

			 if (this.inGround)
			 {
				 if (this.worldObj.getBlock(this.field_145795_e, this.field_145793_f, this.field_145794_g) == this.field_145796_h)
				 {
					 ++this.ticksAlive;

					 if (this.ticksAlive == 600)
					 {
						 this.setDead();
					 }

					 return;
				 }

				 this.inGround = false;
				 this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
				 this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
				 this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
				 this.ticksAlive = 0;
				 this.ticksInAir = 0;
			 }
			 else
			 {
				 ++this.ticksInAir;
			 }

			 Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			 Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			 MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
			 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

			 if (movingobjectposition != null)
			 {
				 vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
			 }

			 Entity entity = null;
			 List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			 double d0 = 0.0D;

			 for (int i = 0; i < list.size(); ++i)
			 {
				 Entity entity1 = (Entity)list.get(i);

				 if (entity1.canBeCollidedWith() && (!entity1.isEntityEqual(this.shootingEntity) || this.ticksInAir >= 25))
				 {
					 float f = 0.3F;
					 AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
					 MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

					 if (movingobjectposition1 != null)
					 {
						 double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

						 if (d1 < d0 || d0 == 0.0D)
						 {
							 entity = entity1;
							 d0 = d1;
						 }
					 }
				 }
			 }

			 if (entity != null)
			 {
				 movingobjectposition = new MovingObjectPosition(entity);
			 }

			 if (movingobjectposition != null)
			 {
				 this.onImpact(movingobjectposition);
			 }

			 this.posX += this.motionX;
			 this.posY += this.motionY;
			 this.posZ += this.motionZ;
			 float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			 this.rotationYaw = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) + 90.0F;

			 for (this.rotationPitch = (float)(Math.atan2((double)f1, this.motionY) * 180.0D / Math.PI) - 90.0F; this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
			 {
				 ;
			 }

			 while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
			 {
				 this.prevRotationPitch += 360.0F;
			 }

			 while (this.rotationYaw - this.prevRotationYaw < -180.0F)
			 {
				 this.prevRotationYaw -= 360.0F;
			 }

			 while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
			 {
				 this.prevRotationYaw += 360.0F;
			 }

			 this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
			 this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
			 float f2 = this.getMotionFactor();

			 if (this.isInWater())
			 {
				 for (int j = 0; j < 4; ++j)
				 {
					 float f3 = 0.25F;
					 this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY * (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
				 }

				 f2 = 0.8F;
			 }

			 this.motionX += this.accelerationX;
			 this.motionY += this.accelerationY;
			 this.motionZ += this.accelerationZ;
			 this.motionX *= (double)f2;
			 this.motionY *= (double)f2;
			 this.motionZ *= (double)f2;
			 this.worldObj.spawnParticle("slime", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
			 this.setPosition(this.posX, this.posY, this.posZ);
		 }

		 if(this.ticksExisted > 200)
		 {
			 this.setDead();

			 return;
		 }

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

					 if (!block.isAir(worldObj, j2, k, l) && block == Blocks.tallgrass || block instanceof BlockDoublePlant)
					 {
						 flag = this.worldObj.func_147480_a(j2, k, l, true) || flag;
					 }
				 }
			 }

		 }
	 }

	 /**
	  * Return the motion factor for this projectile. The factor is multiplied by the original motion.
	  */
	 protected float getMotionFactor()
	 {
		 return 0.95F;
	 }

	 /**
	  * Called when this projectile hits a block or entity.
	  */
	 protected void onImpact(MovingObjectPosition parMovingObjectPosition)
	 {
		 if (!this.worldObj.isRemote && !(parMovingObjectPosition.entityHit instanceof EntityBlightOoze))
		 {
			 if (parMovingObjectPosition.entityHit != null && parMovingObjectPosition.entityHit instanceof EntityLivingBase)
			 {
				 if (parMovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 4.0F))
				 {
					 ((EntityLivingBase)parMovingObjectPosition.entityHit).addPotionEffect(new PotionEffect(Potion.poison.id, 5 * 20, 1));
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

	 public void writeEntityToNBT(NBTTagCompound p_70014_1_)
	 {
		 p_70014_1_.setShort("xTile", (short)this.field_145795_e);
		 p_70014_1_.setShort("yTile", (short)this.field_145793_f);
		 p_70014_1_.setShort("zTile", (short)this.field_145794_g);
		 p_70014_1_.setByte("inTile", (byte)Block.getIdFromBlock(this.field_145796_h));
		 p_70014_1_.setByte("inGround", (byte)(this.inGround ? 1 : 0));
		 p_70014_1_.setTag("direction", this.newDoubleNBTList(new double[] {this.motionX, this.motionY, this.motionZ}));
	 }

	 /**
	  * (abstract) Protected helper method to read subclass entity data from NBT.
	  */
	 public void readEntityFromNBT(NBTTagCompound p_70037_1_)
	 {
		 this.field_145795_e = p_70037_1_.getShort("xTile");
		 this.field_145793_f = p_70037_1_.getShort("yTile");
		 this.field_145794_g = p_70037_1_.getShort("zTile");
		 this.field_145796_h = Block.getBlockById(p_70037_1_.getByte("inTile") & 255);
		 this.inGround = p_70037_1_.getByte("inGround") == 1;

		 if (p_70037_1_.hasKey("direction", 9))
		 {
			 NBTTagList nbttaglist = p_70037_1_.getTagList("direction", 6);
			 this.motionX = nbttaglist.func_150309_d(0);
			 this.motionY = nbttaglist.func_150309_d(1);
			 this.motionZ = nbttaglist.func_150309_d(2);
		 }
		 else
		 {
			 this.setDead();
		 }
	 }

	 /**
	  * Returns true if other Entities should be prevented from moving through this Entity.
	  */
	 public boolean canBeCollidedWith()
	 {
		 return true;
	 }

	 public float getCollisionBorderSize()
	 {
		 return 1.0F;
	 }

	 @SideOnly(Side.CLIENT)
	 public float getShadowSize()
	 {
		 return 0.0F;
	 }

	 /**
	  * Gets how bright this entity is.
	  */
	 public float getBrightness(float p_70013_1_)
	 {
		 return 1.0F;
	 }

	 @SideOnly(Side.CLIENT)
	 public int getBrightnessForRender(float p_70070_1_)
	 {
		 return 15728880;
	 }

	 @Override
	 protected void entityInit() {}

	 @Override
	 public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
	 {
		 return false;
	 }
}