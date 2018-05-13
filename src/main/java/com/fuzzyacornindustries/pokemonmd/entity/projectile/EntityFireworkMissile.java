package com.fuzzyacornindustries.pokemonmd.entity.projectile;

import java.util.ArrayList;
import java.util.List;

import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityNormalFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.library.LibraryDye;
import com.fuzzyacornindustries.pokemonmd.library.LibraryFireworks;
import com.fuzzyacornindustries.pokemonmd.library.LibraryWoolColors;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFireworkMissile extends Entity implements IProjectile
{
	private int field_145791_d = -1;
	private int field_145792_e = -1;
	private int field_145789_f = -1;
	private Block field_145790_g;
	private int inData;

	public EntityLivingBase shootingEntity;
	//private ItemStack fireworkItemStack;

	private int fireworkAge;
	private int ticksInAir;

	public float attackDamage;

	private boolean inGround;

	public EntityFireworkMissile(World worldPar)
	{
		super(worldPar);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.fireworkAge = 0;
	}

	public EntityFireworkMissile(World worldPar, double xPos, double yPos, double zPos)
	{
		super(worldPar);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.setPosition(xPos, yPos, zPos);
		this.yOffset = 0.0F;
		this.fireworkAge = 0;
	}

	public EntityFireworkMissile(World worldPar, EntityLivingBase shooterEntity, EntityLivingBase targetEntity, float velocity, float variability, float attackDamage)
	{
		super(worldPar);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = shooterEntity;

		this.posY = shootingEntity.posY + (double)shootingEntity.getEyeHeight() - 0.10000000149011612D;
		double distanceX = targetEntity.posX - shootingEntity.posX;
		double distanceY = targetEntity.boundingBox.minY + (double)(targetEntity.height / 3.0F) - this.posY;
		double distanceZ = targetEntity.posZ - shootingEntity.posZ;
		double d3 = (double)MathHelper.sqrt_double(distanceX * distanceX + distanceZ * distanceZ);

		if (d3 >= 1.0E-7D)
		{
			float f2 = (float)(Math.atan2(distanceZ, distanceX) * 180.0D / Math.PI) - 90.0F;
			float f3 = (float)(-(Math.atan2(distanceY, d3) * 180.0D / Math.PI));
			double d4 = distanceX / d3;
			double d5 = distanceZ / d3;
			this.setLocationAndAngles(shootingEntity.posX + d4, this.posY, shootingEntity.posZ + d5, f2, f3);
			this.yOffset = 0.0F;
			float f4 = (float)d3 * 0.15F;
			this.setThrowableHeading(distanceX, distanceY + (double)f4, distanceZ, velocity, variability);
		}

		this.fireworkAge = 0;
		this.attackDamage = attackDamage;
	}

	public EntityFireworkMissile(World worldPar, EntityLivingBase shooterEntity, float velocity, float attackDamage)
	{
		super(worldPar);
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
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, velocity * 1.5F, 1.0F);

		this.fireworkAge = 0;
		this.attackDamage = attackDamage;
	}

	protected void entityInit()
	{
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	/**
	 * Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction.
	 */
	public void setThrowableHeading(double parX, double parY, double parZ, float velocity, float variability)
	{
		float f2 = MathHelper.sqrt_double(parX * parX + parY * parY + parZ * parZ);
		parX /= (double)f2;
		parY /= (double)f2;
		parZ /= (double)f2;
		parX += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)variability;
		parY += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)variability;
		parZ += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)variability;
		parX *= (double)velocity;
		parY *= (double)velocity;
		parZ *= (double)velocity;
		this.motionX = parX;
		this.motionY = parY;
		this.motionZ = parZ;
		float f3 = MathHelper.sqrt_double(parX * parX + parZ * parZ);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(parX, parZ) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(parY, (double)f3) * 180.0D / Math.PI);
	}

	/**
	 * Sets the position and rotation. Only difference from the other one is no bounding on the rotation. Args: posX,
	 * posY, posZ, yaw, pitch
	 */
	@SideOnly(Side.CLIENT)
	public void setPositionAndRotation2(double parX, double parY, double parZ, float yawPar, float pitchPar, int p_70056_9_)
	{
		this.setPosition(parX, parY, parZ);
		this.setRotation(yawPar, pitchPar);
	}

	/**
	 * Sets the velocity to the args. Args: x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public void setVelocity(double parX, double parY, double parZ)
	{
		this.motionX = parX;
		this.motionY = parY;
		this.motionZ = parZ;

		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
		{
			float f = MathHelper.sqrt_double(parX * parX + parZ * parZ);
			this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(parX, parZ) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(parY, (double)f) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();

		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
		{
			float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
		}

		Block block = this.worldObj.getBlock(this.field_145791_d, this.field_145792_e, this.field_145789_f);

		if (block.getMaterial() != Material.air)
		{
			block.setBlockBoundsBasedOnState(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f);
			AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f);

			if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
			{
				this.inGround = true;
			}
		}

		if (this.inGround)
		{
			this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.0F, false, false);

			this.setDead();
		}
		else
		{
			++this.ticksInAir;
			Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
			vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

			if (movingobjectposition != null)
			{
				vec3 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
			}

			Entity entity = null;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			int i;
			float f1;

			for (i = 0; i < list.size(); ++i)
			{
				Entity entity1 = (Entity)list.get(i);

				if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5))
				{
					f1 = 0.3F;
					AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
					MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);

					if (movingobjectposition1 != null)
					{
						double d1 = vec31.distanceTo(movingobjectposition1.hitVec);

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

			if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer)
			{
				EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;

				if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
				{
					movingobjectposition = null;
				}
			}

			float f2;
			float f4;

			if (movingobjectposition != null)
			{
				if (movingobjectposition.entityHit != null)
				{
					if(!(movingobjectposition.entityHit instanceof TamablePokemon) && !(movingobjectposition.entityHit instanceof EntityPlayer) &&  
							!(movingobjectposition.entityHit instanceof EntityNormalFoxfire))
					{
						f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);

						if(this.shootingEntity != null)
						{
							movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), attackDamage);
						}

						this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 0.1F, false, false);

						if (!this.worldObj.isRemote)
						{
							this.worldObj.setEntityState(this, (byte)17);
							this.setDead();
						}
					}
				}
				else
				{
					this.field_145791_d = movingobjectposition.blockX;
					this.field_145792_e = movingobjectposition.blockY;
					this.field_145789_f = movingobjectposition.blockZ;
					this.field_145790_g = this.worldObj.getBlock(this.field_145791_d, this.field_145792_e, this.field_145789_f);
					this.inData = this.worldObj.getBlockMetadata(this.field_145791_d, this.field_145792_e, this.field_145789_f);
					this.motionX = (double)((float)(movingobjectposition.hitVec.xCoord - this.posX));
					this.motionY = (double)((float)(movingobjectposition.hitVec.yCoord - this.posY));
					this.motionZ = (double)((float)(movingobjectposition.hitVec.zCoord - this.posZ));
					f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
					this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
					this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
					this.inGround = true;

					if (this.field_145790_g.getMaterial() != Material.air)
					{
						this.field_145790_g.onEntityCollidedWithBlock(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f, this);
					}
				}
			}

			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

			for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
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
			float f3 = 0.99F;
			f1 = 0.05F;

			if (this.isInWater())
			{
				for (int l = 0; l < 4; ++l)
				{
					f4 = 0.25F;
					this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
				}

				f3 = 0.8F;
			}

			this.motionX *= (double)f3;
			this.motionY *= (double)f3;
			this.motionZ *= (double)f3;
			this.motionY -= (double)f1;
			this.setPosition(this.posX, this.posY, this.posZ);
			this.func_145775_I();
		}

		++this.fireworkAge;

		if (this.worldObj.isRemote && this.fireworkAge % 2 < 2)
		{
			this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY - 0.3D, this.posZ, this.rand.nextGaussian() * 0.05D, -this.motionY * 0.5D, this.rand.nextGaussian() * 0.05D);
		}
	}

	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte bytePar)
	{
		if (bytePar == 17 && this.worldObj.isRemote)
		{
			ItemStack fireworkItemStack = generateFirework();
			NBTTagCompound nbttagcompound5 = null;

			if (fireworkItemStack != null && fireworkItemStack.hasTagCompound())
			{
				nbttagcompound5 = fireworkItemStack.getTagCompound().getCompoundTag("Fireworks");
			}

			//System.out.println( "Test Firework Missile Run" );
			//System.out.println( Integer.toString( targetEntity.getEntityId() ) );

			this.worldObj.makeFireworks(this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, nbttagcompound5);
		}

		super.handleHealthUpdate(bytePar);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound p_70014_1_)
	{
		p_70014_1_.setShort("xTile", (short)this.field_145791_d);
		p_70014_1_.setShort("yTile", (short)this.field_145792_e);
		p_70014_1_.setShort("zTile", (short)this.field_145789_f);
		p_70014_1_.setByte("inTile", (byte)Block.getIdFromBlock(this.field_145790_g));
		p_70014_1_.setByte("inData", (byte)this.inData);
		p_70014_1_.setByte("inGround", (byte)(this.inGround ? 1 : 0));
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound p_70037_1_)
	{
		this.field_145791_d = p_70037_1_.getShort("xTile");
		this.field_145792_e = p_70037_1_.getShort("yTile");
		this.field_145789_f = p_70037_1_.getShort("zTile");
		this.field_145790_g = Block.getBlockById(p_70037_1_.getByte("inTile") & 255);
		this.inData = p_70037_1_.getByte("inData") & 255;
		this.inGround = p_70037_1_.getByte("inGround") == 1;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public float getShadowSize()
	{
		return 0.0F;
	}

	/**
	 * If returns false, the item will not inflict any damage against entities.
	 */
	public boolean canAttackWithItem()
	{
		return false;
	}

	public ItemStack generateFirework()
	{
		NBTTagCompound nbttagcompound;
		NBTTagCompound nbttagcompound1;

		ItemStack fireworkChargeItemStack = new ItemStack(Items.firework_charge);

		nbttagcompound = new NBTTagCompound();

		nbttagcompound1 = new NBTTagCompound();
		NBTTagList nbttaglist = new NBTTagList();

		ArrayList arraylist = new ArrayList();

		arraylist = getFireworkColorList();

		byte explosionStyle = getExplosionStyle();

		int[] aint1 = new int[arraylist.size()];

		for (int l2 = 0; l2 < aint1.length; ++l2)
		{
			aint1[l2] = ((Integer)arraylist.get(l2)).intValue();
		}

		nbttagcompound1 = applySpecialEffect(nbttagcompound1);

		nbttagcompound1.setIntArray("Colors", aint1);
		nbttagcompound1.setByte("Type", explosionStyle);
		nbttagcompound.setTag("Explosion", nbttagcompound1);

		fireworkChargeItemStack.setTagCompound(nbttagcompound);

		NBTTagCompound nbttagcompound2 = new NBTTagCompound();
		NBTTagCompound nbttagcompound3 = new NBTTagCompound();

		ItemStack fireworkItemStack = new ItemStack(Items.fireworks);

		NBTTagList nbttaglist2 = new NBTTagList();

		nbttaglist2.appendTag(fireworkChargeItemStack.getTagCompound().getCompoundTag("Explosion"));

		nbttagcompound3.setTag("Explosions", nbttaglist2);
		nbttagcompound3.setByte("Flight", (byte)1);
		nbttagcompound2.setTag("Fireworks", nbttagcompound3);

		fireworkItemStack.setTagCompound(nbttagcompound2);

		return fireworkItemStack;
	}

	public ArrayList getFireworkColorList()
	{
		ArrayList arraylist = new ArrayList();

		ItemStack tempItemStack;

		switch (this.rand.nextInt(7))
		{
		case 0:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.ROSE_RED);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.ORANGE_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.DANDELION_YELLOW);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
			break;
		case 1:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.DANDELION_YELLOW);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.PURPLE_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
			break;
		case 2:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.ROSE_RED);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.CACTUS_GREEN);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
			break;
		case 3:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.PURPLE_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.LIGHT_BLUE_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
			break;
		case 4:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.PURPLE_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.CACTUS_GREEN);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
			break;
		case 5:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.BONE_MEAL);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.PINK_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.ROSE_RED);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
			break;
		case 6:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.ROSE_RED);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.DANDELION_YELLOW);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.LAPIS_LAZULI);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
			break;
		case 7:
			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.CACTUS_GREEN);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.PURPLE_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));

			tempItemStack = new ItemStack(Items.dye, 1, LibraryDye.ORANGE_DYE);
			arraylist.add(Integer.valueOf(ItemDye.field_150922_c[tempItemStack.getItemDamage()]));
		}

		return arraylist;
	}

	public byte getExplosionStyle()
	{
		int k = this.rand.nextInt(10);

		if(k >= 6)
		{
			return LibraryFireworks.SHAPE_NORMAL;
		}
		else if(k == 1 || k == 2)
		{
			return LibraryFireworks.SHAPE_STAR;
		}
		else if(k == 0)
		{
			return LibraryFireworks.SHAPE_LARGE;
		}
		else
		{
			return LibraryFireworks.SHAPE_BURST;
		}
	}

	public NBTTagCompound applySpecialEffect(NBTTagCompound nbttagcompound)
	{
		int k = this.rand.nextInt(3);

		if(k == 1)
		{
			nbttagcompound.setBoolean("Flicker", true);
		}

		k = this.rand.nextInt(6);

		if(k == 1)
		{
			nbttagcompound.setBoolean("Trail", true);
		}  

		return nbttagcompound;
	}
}