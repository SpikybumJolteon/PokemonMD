package com.fuzzyacornindustries.pokemonmd.entity.mob.tamable;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.entity.mob.IMobMotionTracker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.IStunImmune;
import com.fuzzyacornindustries.pokemonmd.item.BerryItem;
import com.fuzzyacornindustries.pokemonmd.item.ItemBerryColberta;
import com.fuzzyacornindustries.pokemonmd.item.ItemBerryOranian;
import com.fuzzyacornindustries.pokemonmd.item.ItemBerryPasshaura;
import com.fuzzyacornindustries.pokemonmd.item.ItemBerryPechita;
import com.fuzzyacornindustries.pokemonmd.item.ItemBerryRawstetta;
import com.fuzzyacornindustries.pokemonmd.library.DataWatcherLibrary;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@Optional.Interface(iface="micdoodle8.mods.galacticraft.api.entity.IEntityBreathable", modid="GalacticraftCore", striprefs=true)
public class TamablePokemon extends EntityTameable implements IStunImmune, IEntityAdditionalSpawnData, IAnimatedEntity, IMobMotionTracker, IEntityBreathable
{	
	private String poketamableName;

	public float previousYaw[] = new float[6];
	public float changeInYaw;

	public float previousHeight[] = new float[6];
	public float changeInHeight;

	public static final int actionIDNone = 0;

	protected int animationID;
	protected int animationTick;

	public int regenTimer = 0;

	boolean isHappy = false;
	int happyTimer = 0;
	int happyDuration = 20;

	public boolean isBegging = false;

	private float field_70926_e;
	private float field_70924_f;

	public TamablePokemon(World par1World)
	{
		super(par1World);

		poketamableName = "";

		this.experienceValue = 0;

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

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(DataWatcherLibrary.HEALTH, new Float(this.getHealth()));
		this.dataWatcher.addObject(19, new Byte((byte)0));

		this.dataWatcher.addObject(DataWatcherLibrary.TEXTURE, new Byte((byte)0));
		this.dataWatcher.addObject(DataWatcherLibrary.SOUND, new Byte((byte)0));

		this.dataWatcher.addObject(DataWatcherLibrary.MAX_HEALTH, new Float((float)0));
		this.dataWatcher.addObject(DataWatcherLibrary.ATTACK_POWER, new Float((float)0));

		this.dataWatcher.addObject(DataWatcherLibrary.FIRE_IMMUNITY, new Byte((byte)0));
		this.dataWatcher.addObject(DataWatcherLibrary.DROWNING_IMMUNITY, new Byte((byte)0));
		this.dataWatcher.addObject(DataWatcherLibrary.FALL_DAMAGE_IMMUNITY, new Byte((byte)0));
		this.dataWatcher.addObject(DataWatcherLibrary.BLOCK_SUFFOCATION_AVOIDANCE, new Byte((byte)0));
		this.dataWatcher.addObject(DataWatcherLibrary.TOXIN_IMMUNITY, new Byte((byte)0));

		this.dataWatcher.addObject(DataWatcherLibrary.SPACE_SURVIVALBILITY, new Byte((byte)0));
	}

	public float getMaximumHealth()
	{
		return this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.MAX_HEALTH);
	}

	public void setMaximumHealth(float newMaxHealth)
	{
		this.dataWatcher.updateObject(DataWatcherLibrary.MAX_HEALTH, Float.valueOf(newMaxHealth));

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)newMaxHealth);
	}

	public float getAttackPower()
	{
		return this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.ATTACK_POWER);
	}

	public void setAttackPower(float newAttackPower)
	{
		this.dataWatcher.updateObject(DataWatcherLibrary.ATTACK_POWER, Float.valueOf(newAttackPower));
	}

	public int hasFireImmunityEssence()
	{
		return (int)this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.FIRE_IMMUNITY);
	}

	// Set 1 for true; 0 for false
	public void setFireImmunityEssence(int activateFireImmunityEssence)
	{
		if(activateFireImmunityEssence == 1)
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.FIRE_IMMUNITY, (byte)1);

			this.isImmuneToFire = true;
		}
		else
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.FIRE_IMMUNITY, (byte)0);

			this.isImmuneToFire = false;
		}
	}

	public int hasDrowningImmunityEssence()
	{
		return (int)this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.DROWNING_IMMUNITY);
	}

	// Set 1 for true; 0 for false
	public void setDrowningImmunityEssence(int activateDrowningImmunityEssence)
	{
		if(activateDrowningImmunityEssence == 1)
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.DROWNING_IMMUNITY, (byte)1);
		}
		else
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.DROWNING_IMMUNITY, (byte)0);
		}
	}

	public int hasFallImmunityEssence()
	{
		return (int)this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.FALL_DAMAGE_IMMUNITY);
	}

	// Set 1 for true; 0 for false
	public void setFallImmunityEssence(int activateFallImmunityEssence)
	{
		if(activateFallImmunityEssence == 1)
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.FALL_DAMAGE_IMMUNITY, (byte)1);
		}
		else
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.FALL_DAMAGE_IMMUNITY, (byte)0);
		}
	}

	public int hasBlockSuffocationAvoidanceEssence()
	{
		return (int)this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.BLOCK_SUFFOCATION_AVOIDANCE);
	}

	// Set 1 for true; 0 for false
	public void setBlockSuffocationAvoidanceEssence(int activateBlockSuffacationAvoidanceEssence)
	{
		if(activateBlockSuffacationAvoidanceEssence == 1)
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.BLOCK_SUFFOCATION_AVOIDANCE, (byte)1);
		}
		else
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.BLOCK_SUFFOCATION_AVOIDANCE, (byte)0);
		}
	}

	public int hasToxinImmunityEssence()
	{
		return (int)this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.TOXIN_IMMUNITY);
	}

	// Set 1 for true; 0 for false
	public void setToxinImmunityEssence(int activateToxinImmunityEssence)
	{
		if(activateToxinImmunityEssence == 1)
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.TOXIN_IMMUNITY, (byte)1);
		}
		else
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.TOXIN_IMMUNITY, (byte)0);
		}
	}

	public int hasSpaceSurvivabilityEssence()
	{
		return (int)this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.SPACE_SURVIVALBILITY);
	}

	// Set 1 for true; 0 for false
	public void setSpaceSurvivabilityEssence(int activateToxinImmunityEssence)
	{
		if(activateToxinImmunityEssence == 1)
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.SPACE_SURVIVALBILITY, (byte)1);
		}
		else
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.SPACE_SURVIVALBILITY, (byte)0);
		}
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	@Override
	protected void updateAITick()
	{
		this.dataWatcher.updateObject(DataWatcherLibrary.HEALTH, Float.valueOf(this.getHealth()));
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		ByteBufUtils.writeUTF8String(data, poketamableName);
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		poketamableName = ByteBufUtils.readUTF8String(data);
	}

	/**
	 * Used by Renderer to display Poketamable Name
	 */
	public String getDisplayName()
	{
		return poketamableName;
	}

	public void setName(String name)
	{
		this.poketamableName = name;;
	}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		if(this.hasDrowningImmunityEssence() == 1)
		{
			return currentAirSupply;
		}
		else
		{
			return super.decreaseAirSupply(currentAirSupply);
		}
	}

	@Override
	protected void fall(float p_70069_1_)
	{
		if(this.hasFallImmunityEssence() != 1)
		{
			super.fall(p_70069_1_);
		}
	}

	@Method(modid="GalacticraftCore")
	@Override
	public boolean canBreath()
	{
		if(this.hasSpaceSurvivabilityEssence() == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		this.field_70924_f = this.field_70926_e;

		if (this.func_70922_bv())
		{
			this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
		}
		else
		{
			this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
		}

		if (this.func_70922_bv())
		{
			this.numTicksToChaseTarget = 10;
		}

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

		if (!this.worldObj.isRemote)
		{
			if(this.isEntityAlive() && this.isEntityInsideOpaqueBlock() && this.hasBlockSuffocationAvoidanceEssence() == 1)
			{
				EntityLivingBase theOwner = this.getOwner();

				if (theOwner != null)
				{
					if (!this.isSitting())
					{
						this.teleportToOwner(theOwner);
					}
				}
			}
		}
	}

	public void teleportToOwner(EntityLivingBase theOwner)
	{
		int i = MathHelper.floor_double(theOwner.posX);
		int j = MathHelper.floor_double(theOwner.posZ);
		int k = MathHelper.floor_double(theOwner.boundingBox.minY);

		if (World.doesBlockHaveSolidTopSurface(this.worldObj, i, k - 1, j) && !this.worldObj.getBlock(i, k, j).isNormalCube() && !this.worldObj.getBlock(i, k + 1, j).isNormalCube())
		{
			this.setLocationAndAngles((double)((float)i + 0.5F), (double)k, (double)((float)j + 0.5F), this.rotationYaw, this.rotationPitch);
			this.setPathToEntity((PathEntity)null);
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);

		this.poketamableName = nbt.getString("petName");

		if (nbt.hasKey("MaximumHealth", 99))
		{
			float b0 = nbt.getFloat("MaximumHealth");
			this.setMaximumHealth(b0);
		}

		if (nbt.hasKey("AttackPower", 99))
		{
			float b0 = nbt.getFloat("AttackPower");
			this.setAttackPower(b0);
		}

		if (nbt.hasKey("FireImmunity", 99))
		{
			int b0 = nbt.getInteger("FireImmunity");
			this.setFireImmunityEssence(b0);
		}

		if (nbt.hasKey("DrowningImmunity", 99))
		{
			int b0 = nbt.getInteger("DrowningImmunity");
			this.setDrowningImmunityEssence(b0);
		}

		if (nbt.hasKey("FallImmunity", 99))
		{
			int b0 = nbt.getInteger("FallImmunity");
			this.setFallImmunityEssence(b0);
		}

		if (nbt.hasKey("BlockSuffacationAvoidance", 99))
		{
			int b0 = nbt.getInteger("BlockSuffacationAvoidance");
			this.setBlockSuffocationAvoidanceEssence(b0);
		}

		if (nbt.hasKey("ToxinImmunity", 99))
		{
			int b0 = nbt.getInteger("ToxinImmunity");
			this.setToxinImmunityEssence(b0);
		}

		if (nbt.hasKey("SpaceSurvivability", 99))
		{
			int b0 = nbt.getInteger("SpaceSurvivability");
			this.setSpaceSurvivabilityEssence(b0);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);

		nbt.setString("petName", this.poketamableName);

		nbt.setFloat("MaximumHealth", (float)this.getMaximumHealth());
		nbt.setFloat("AttackPower", (float)this.getAttackPower());
		nbt.setInteger("FireImmunity", (int)this.hasFireImmunityEssence());
		nbt.setInteger("DrowningImmunity", (int)this.hasDrowningImmunityEssence());
		nbt.setInteger("FallImmunity", (int)this.hasFallImmunityEssence());
		nbt.setInteger("BlockSuffacationAvoidance", (int)this.hasBlockSuffocationAvoidanceEssence());
		nbt.setInteger("ToxinImmunity", (int)this.hasToxinImmunityEssence());
		nbt.setInteger("SpaceSurvivability", (int)this.hasSpaceSurvivabilityEssence());
	}

	public int getMainTextureType()
	{
		return this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.TEXTURE);
	}

	public void setMainTextureType(int par1)
	{
		this.dataWatcher.updateObject(DataWatcherLibrary.TEXTURE, Byte.valueOf((byte)par1));
	}

	public void applyCurrentTexture()
	{
		if(!this.isTamed())
		{
			setMainTextureType(0);
		}
		else if(this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH) < ((float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 4))
		{
			setMainTextureType(1);
		}
		else if(isHappy == true)
		{
			setMainTextureType(2);
		}
		else
		{
			setMainTextureType(0);
		}
	}

	public int getSoundType()
	{
		return this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.SOUND);
	}

	public void setSoundType(int par1)
	{
		this.dataWatcher.updateObject(DataWatcherLibrary.SOUND, Byte.valueOf((byte)par1));
	}

	public void toggleIdleSounds()
	{
		if(this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.SOUND) == 0)
		{
			setSoundType(1);
		}
		else
		{
			setSoundType(0);
		}
	}

	@Override
	protected void func_145780_a(int xCoord, int yCoord, int zCoord, Block blockUnderneath)
	{
		this.playSound("mob.wolf.step", 0.15F, 1.0F);
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.7F;
	}

	public void toggleHappiness()
	{
		if(this.happyTimer != 0 || isHappy)
		{
			if(this.happyTimer >= this.happyDuration)
			{
				this.happyTimer = 0;

				isHappy = false;
			}
			else
			{
				this.happyTimer++;

				isHappy = true;
			}
		}
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
	 * use in wolves.
	 */
	@Override
	public int getVerticalFaceSpeed()
	{
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	public boolean berryHeal(EntityPlayer par1EntityPlayer, float healthMaximum, BerryItem berry)
	{
		boolean decreaseBerryItemstack = false;

		float oldHealthAmount = this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH);

		if (!par1EntityPlayer.capabilities.isCreativeMode)
		{
			decreaseBerryItemstack = true;
		}

		this.heal(berry.getPokemonHealAmount());

		if(this.worldObj.isRemote)
		{
			spawnHealParticles(berry.getPokemonHealAmount());

			if((oldHealthAmount + berry.getPokemonHealAmount()) >= healthMaximum)
			{	
				spawnHeartParticles(2);

				isHappy = true;	
			}
		}

		if(!(berry instanceof ItemBerryOranian))
		{
			if(berry instanceof ItemBerryColberta && this.getActivePotionEffect(Potion.blindness) != null)
			{
				this.removePotionEffect(Potion.blindness.id);

				isHappy = true;
			}
			else if(berry instanceof ItemBerryPasshaura)
			{
				this.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1800 * 20, 1));

				isHappy = true;
			}
			else if(berry instanceof ItemBerryPechita && this.getActivePotionEffect(Potion.poison) != null)
			{
				this.removePotionEffect(Potion.poison.id);

				isHappy = true;
			}
			else if(berry instanceof ItemBerryRawstetta)
			{
				this.extinguish();
				this.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1800 * 20, 1));

				isHappy = true;
			}
		}

		return decreaseBerryItemstack;
	}

	public boolean zssPotionHeal(EntityPlayer par1EntityPlayer, float healthMaximum, Item zssPotion)
	{
		boolean decreaseBerryItemstack = false;

		float oldHealthAmount = this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH);

		if (!par1EntityPlayer.capabilities.isCreativeMode)
		{
			decreaseBerryItemstack = true;
		}

		float healAmount = healthMaximum - oldHealthAmount;

		this.heal(healAmount);

		if(this.worldObj.isRemote)
		{
			spawnHealParticles(healthMaximum - oldHealthAmount);

			spawnHeartParticles(2);
		}

		isHappy = true;

		return decreaseBerryItemstack;
	}

	public void decreasePlayerItemStack(EntityPlayer player, ItemStack itemstack)
	{
		if (!player.capabilities.isCreativeMode)
		{
			--itemstack.stackSize;
		}

		if (itemstack.stackSize <= 0)
		{
			player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
		}
	}

	public void applyLifeBoost(EntityPlayer player, ItemStack itemstack)
	{
		if(!this.worldObj.isRemote)
		{
			this.setMaximumHealth(this.getMaximumHealth() + 1F);

			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.getMaximumHealth());
		}

		this.heal(1F);

		if(this.worldObj.isRemote)
		{
			spawnHealParticles(1F);

			spawnHeartParticles(1);
		}

		decreasePlayerItemStack(player, itemstack);

		isHappy = true;
	}

	public void applyFiragaEssence(EntityPlayer player, ItemStack itemstack)
	{
		this.setFireImmunityEssence(1);

		isHappy = true;

		decreasePlayerItemStack(player, itemstack);

		if(this.worldObj.isRemote)
		{
			spawnFlameParticles(8);

			spawnHeartParticles(1);
		}
	}

	public void applyWatergaEssence(EntityPlayer player, ItemStack itemstack)
	{
		this.setDrowningImmunityEssence(1);

		isHappy = true;

		decreasePlayerItemStack(player, itemstack);

		if(this.worldObj.isRemote)
		{
			spawnBubbleParticles(14);

			spawnHeartParticles(1);
		}
	}

	public void applyGravigaEssence(EntityPlayer player, ItemStack itemstack)
	{
		this.setFallImmunityEssence(1);

		isHappy = true;

		decreasePlayerItemStack(player, itemstack);

		if(this.worldObj.isRemote)
		{
			spawnPortalParticles(10);

			spawnHeartParticles(1);
		}
	}

	public void applyQuakagaEssence(EntityPlayer player, ItemStack itemstack)
	{
		this.setBlockSuffocationAvoidanceEssence(1);

		isHappy = true;

		decreasePlayerItemStack(player, itemstack);

		if(this.worldObj.isRemote)
		{
			spawnMagicCritParticles(8);

			spawnHeartParticles(1);
		}
	}

	public void applyBiogaEssence(EntityPlayer player, ItemStack itemstack)
	{
		this.setToxinImmunityEssence(1);

		isHappy = true;

		decreasePlayerItemStack(player, itemstack);

		if(this.worldObj.isRemote)
		{
			spawnHealParticles(8);

			spawnHeartParticles(1);
		}
	}

	public void applySpaceSurvivabilityEssence(EntityPlayer player, ItemStack itemstack)
	{
		this.setSpaceSurvivabilityEssence(1);

		isHappy = true;

		decreasePlayerItemStack(player, itemstack);

		if(this.worldObj.isRemote)
		{
			spawnPortalParticles(8);
			spawnMagicCritParticles(8);
			spawnAttackChargeParticles(8);

			spawnHeartParticles(1);
		}
	}

	public void applyAttackBoost(EntityPlayer player, ItemStack itemstack)
	{
		if(!this.worldObj.isRemote)
		{
			this.setAttackPower(this.getAttackPower() + 0.5F);
		}

		if(this.worldObj.isRemote)
		{
			spawnAttackChargeParticles(4);

			spawnHeartParticles(1);
		}

		decreasePlayerItemStack(player, itemstack);

		isHappy = true;
	}

	@SideOnly(Side.CLIENT)
	public void spawnHealParticles(float healAmount)
	{
		for (int i = 0; i < (int)healAmount; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("happyVillager", this.posX + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void spawnAttackChargeParticles(int numOfParticles)
	{
		for (int i = 0; i < numOfParticles; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("reddust", this.posX + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void spawnHeartParticles(int numOfParticles)
	{
		for (int i = 0; i < numOfParticles; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void spawnFlameParticles(int numOfParticles)
	{
		for (int i = 0; i < numOfParticles; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("flame", this.posX + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void spawnBubbleParticles(int numOfParticles)
	{
		for (int i = 0; i < numOfParticles; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("splash", this.posX + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void spawnPortalParticles(int numOfParticles)
	{
		for (int i = 0; i < numOfParticles; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("portal", this.posX + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void spawnMagicCritParticles(int numOfParticles)
	{
		for (int i = 0; i < numOfParticles; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("magicCrit", this.posX + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.5F) - (double)this.width, d0, d1, d2);
		}
	}

	public void applySit()
	{
		this.aiSit.setSitting(!this.isSitting());
		this.isJumping = false;
		this.setPathToEntity((PathEntity)null);
		this.setTarget((Entity)null);
		this.setAttackTarget((EntityLivingBase)null);
	}

	/**
	 * Returns true if this entity can attack entities of the specified class.
	 */
	@Override
	public boolean canAttackClass(Class par1Class)
	{
		return EntityCreeper.class != par1Class && EntityGhast.class != par1Class && EntityVillager.class != par1Class && EntityPlayer.class != par1Class && TamablePokemon.class != par1Class;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1)
	{
		if (par1 == 8)
		{
			//this.field_70928_h = true;
			//this.timeWolfIsShaking = 0.0F;
			//this.prevTimeWolfIsShaking = 0.0F;
		}
		else
		{
			super.handleHealthUpdate(par1);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getHealthPercent()
	{
		float healthAmount = this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH);

		if(!this.isTamed())
		{
			return 0;
		}

		return healthAmount / (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
	}

	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	@Override
	protected boolean canDespawn()
	{
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	@Override
	public boolean func_142018_a(EntityLivingBase par1EntityLivingBase, EntityLivingBase par2EntityLivingBase)
	{
		if (!(par1EntityLivingBase instanceof EntityGhast))
		{
			if (par1EntityLivingBase instanceof TamablePokemon)
			{
				TamablePokemon entityPokemon = (TamablePokemon)par1EntityLivingBase;

				if (entityPokemon.isTamed() && entityPokemon.getOwner() == par2EntityLivingBase)
				{
					return false;
				}
			}

			return par1EntityLivingBase instanceof EntityPlayer && par2EntityLivingBase instanceof EntityPlayer && !((EntityPlayer)par2EntityLivingBase).canAttackPlayer((EntityPlayer)par1EntityLivingBase) ? false : !(par1EntityLivingBase instanceof EntityHorse) || !((EntityHorse)par1EntityLivingBase).isTame();
		}
		else
		{
			return false;
		}
	}

	public boolean func_70922_bv()
	{
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	public void func_70918_i(boolean par1)
	{
		if (par1)
		{
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
		}
		else
		{
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
		}
	}

	/*
	 * Required function to implement.
	 */
	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return null;
	}

	public void setDeadWithoutRecall()
	{
		super.setDead();
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			if (damageSource instanceof EntityDamageSource && this.isTamed() && this.getOwner() == damageSource.getEntity())
			{
				if(this.getOwner() instanceof EntityPlayer)
				{
					EntityPlayer entityPlayer = (EntityPlayer)this.getOwner();

					if(!entityPlayer.capabilities.isCreativeMode)
					{
						if (damageSource.getSourceOfDamage() instanceof EntityArrow)
						{
							return false;
						}

						return true;
					}
				}
			}

			return super.attackEntityFrom(damageSource, damageAmount);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float par1)
	{
		return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * par1) * 0.15F * (float)Math.PI;
	}

	@Override
	public String getCommandSenderName()
	{
		return poketamableName;
	}

	@Override
	public boolean isBreedingItem(ItemStack par1ItemStack)
	{
		return false;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		if(par1PotionEffect.getPotionID() == Potion.poison.id || par1PotionEffect.getPotionID() == Potion.wither.id)
		{
			if(this.hasToxinImmunityEssence() == 1)
				return false;
		}

		super.isPotionApplicable(par1PotionEffect);

		return true;
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