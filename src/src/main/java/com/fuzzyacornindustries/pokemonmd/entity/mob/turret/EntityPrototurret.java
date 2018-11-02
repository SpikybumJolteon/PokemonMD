package com.fuzzyacornindustries.pokemonmd.entity.mob.turret;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralRangedAttacker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIPrototurretShoot;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIPrototurretStop;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.IStunImmune;
import com.fuzzyacornindustries.pokemonmd.gui.PokemonMDGuiHandler;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.item.turret.ITurretItemDefense;
import com.fuzzyacornindustries.pokemonmd.item.turret.ItemRegenUtility;
import com.fuzzyacornindustries.pokemonmd.item.turret.TurretDefenseItem;
import com.fuzzyacornindustries.pokemonmd.library.DataWatcherLibrary;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPrototurret extends EntityTameable implements IRangedAttackMob, IAnimatedEntity, IInvBasic, IStunImmune
{
	private IdleAnimationClock panelIdleAnimationClock;
	private IdleAnimationClock verticalFloatIdleAnimationClock;

	private int animationID;
	private int animationTick;

	public static final int actionIDNone = 0;
	public static final int actionIDFireRound = 1;

	public AnimalChest prototurretInventory;

	public static final float baseAttackPower = 1.0F;

	public static final int powerItemSlotID = 0;
	public static final int defenseItemSlotID = 1;
	public static final int utilityItemSlotID = 2;

	public static final int slotsLength = 3;
	private ItemStack[] slots = new ItemStack[slotsLength];

	public int regenTimer = 0;

	public static float healthMaximum = 20.0F;

	public float maxSightRange = 18.0F;

	protected AIPrototurretStop aiStopped = new AIPrototurretStop(this);

	private static String turretName = "prototurret";

	public EntityPrototurret(World par1World)
	{
		super(par1World);
		this.setSize(0.3F, 0.95F);
		this.tasks.addTask(1, this.aiStopped);
		this.tasks.addTask(2, new AIPrototurretShoot(this));
		this.tasks.addTask(3, new AIGeneralRangedAttacker(this, 1.0D, 20, 20, maxSightRange));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMob.class, 0, true));

		animationID = actionIDNone;
		animationTick = 0;

		this.setPrototurretInventory();

		setPanelClockDefaults();
		setVerticalFloatClockDefaults();
	}

	public static String getTurretName()
	{
		return turretName;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
	}

	@Override
	public int getTotalArmorValue()
	{
		int armorValue = 0;

		if(this.getStackInSlot(EntityPrototurret.defenseItemSlotID) != null)
		{
			if(this.getStackInSlot(EntityPrototurret.defenseItemSlotID).getItem() instanceof TurretDefenseItem)
			{
				ITurretItemDefense defenseItem = (ITurretItemDefense)this.getStackInSlot(EntityPrototurret.defenseItemSlotID).getItem();

				armorValue = defenseItem.getArmorValue();
			}
		}

		return armorValue;
	}

	@Override
	protected void fall(float par1) {}

	/**
	 * Decrements the entity's air supply when underwater
	 */
	@Override
	protected int decreaseAirSupply(int par1)
	{
		return par1;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(animationID != 0) animationTick++;

		//System.out.println( "Test Entity/Model ID Code In Entity Class" );
		//System.out.println( Integer.toString( this.getEntityId() ) );
		//System.out.println( Integer.toString( entity.getAnimationID() ) );
		/*
		System.out.println( "Test Animation Tick Code" );
		System.out.println( Integer.toString( this.getAnimationTick() ) );
		System.out.println( Integer.toString( this.getAnimationID() ) );
		 */

		if(!this.isStopped())
		{
			incrementPartClocks();
		}
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		this.dataWatcher.addObject(DataWatcherLibrary.TURRET_STOPPED, new Byte((byte)0));
		this.dataWatcher.addObject(DataWatcherLibrary.HEALTH, new Float(this.getHealth()));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound()
	{
		return null;//ModStrings.MODID + ":mob." + getTurretName() + ".living";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return null;//ModStrings.MODID + ":mob." + getTurretName() + ".hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return null;//ModStrings.MODID + ":mob." + getTurretName() + ".death";
	}
	/*
	protected float getSoundVolume()
	{
		return 1.3F;
	}*/

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate()
	{
		int randomIntReset = this.rand.nextInt(60);

		if(randomIntReset == 0)
		{
			resetTargetToAttack();
		}

		this.motionX = 0;
		this.motionY = 0;
		this.motionZ = 0;

		if(this.getHealth() <= this.healthMaximum)
		{
			if(this.isStopped())
			{
				regenTimer++;
			}

			if(this.getStackInSlot(EntityPrototurret.utilityItemSlotID) != null)
			{
				if(this.getStackInSlot(EntityPrototurret.utilityItemSlotID).getItem() instanceof ItemRegenUtility && this.getHealth() < this.healthMaximum)
				{
					regenTimer++;
				}
			}

			if(regenTimer >= 400)
			{
				float healAmount = 1.0F;

				this.heal(healAmount);
				regenTimer = 0;

				spawnHealParticles(healAmount);
			}
		}
		else
		{
			regenTimer = 0;
		}

		if (this.isStopped())
		{
			this.setPrototurretState(1);
		}
		else
		{
			this.setPrototurretState(0);
		}

		super.onLivingUpdate();
	}

	public void spawnHealParticles(float healAmount)
	{
		for (int i = 0; i < (int)healAmount; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle("happyVillager", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
		}
	}

	/**
	 * sets this entity's combat AI.
	 */
	public void resetTargetToAttack()
	{
		this.setTarget((Entity)null);
		this.setAttackTarget((EntityLivingBase)null);
	}
	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity = par1DamageSource.getEntity();
			this.aiSit.setSitting(false);

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
			{
				par2 = (par2 + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	{
		if(this.isSitting() == false)
		{
			if(animationID == 0)
				PacketDispatcher.sendAnimationPacket(this, actionIDFireRound);
		}
		/*
		if(this.getStackInSlot(0) != null)
		{
			if(this.getStackInSlot(0).getItem() instanceof TurretPowerItem)
			{
				if(this.getStackInSlot(0).getItem() instanceof ItemChaosCapacitor)
				{
					ItemChaosCapacitor powerSlotItemStack = (ItemChaosCapacitor)this.getStackInSlot(0).getItem();

					setAttackPower(powerSlotItemStack.getAttackPower());

					par1EntityLivingBase.attackEntityFrom(DamageSource.causeMobDamage(this), attackPower);
				}
			}
		}
		else
		{
			this.setAttackPower(1.0F);
		}
		 */
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return null;
	}
	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return false;
	}

	public int getSizeInventory()
	{
		return this.slots.length;
	}

	public ItemStack getStackInSlot(int slotNumber) 
	{
		AnimalChest entityInventory = this.prototurretInventory;
		ItemStack itemStack = entityInventory.getStackInSlot(slotNumber);

		if(itemStack != null)
		{
			return entityInventory.getStackInSlot(slotNumber);
		}

		return null;
	}

	/**
	 * Called by InventoryBasic.onInventoryChanged() on a array that is never filled.
	 */
	public void onInventoryChanged(InventoryBasic par1InventoryBasic)
	{
		/*int i = this.func_110241_cb();
        boolean flag = this.isHorseSaddled();
        this.func_110232_cE();

        if (this.ticksExisted > 20)
        {
            if (i == 0 && i != this.func_110241_cb())
            {
                this.playSound("mob.horse.armor", 0.5F, 1.0F);
            }
            else if (i != this.func_110241_cb())
            {
                this.playSound("mob.horse.armor", 0.5F, 1.0F);
            }

            if (!flag && this.isHorseSaddled())
            {
                this.playSound("mob.horse.leather", 0.5F, 1.0F);
            }
        }*/
	}

	public int getInventoryStackLimit() 
	{
		return 64;
	}

	public static int getPowerItemSlotID()
	{
		return powerItemSlotID;
	}

	public static int getDefenseItemSlotID()
	{
		return defenseItemSlotID;
	}

	public static int getUtilityItemSlotID()
	{
		return utilityItemSlotID;
	}

	public boolean isStopped()
	{
		return (this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.TURRET_STOPPED) & 1) != 0;
	}

	public void setStopped(boolean p_70904_1_)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.TURRET_STOPPED);

		if (p_70904_1_)
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.TURRET_STOPPED, Byte.valueOf((byte)(b0 | 1)));
		}
		else
		{
			this.dataWatcher.updateObject(DataWatcherLibrary.TURRET_STOPPED, Byte.valueOf((byte)(b0 & -2)));
		}
	}

	public AIPrototurretStop setAITurretStopped()
	{
		return this.aiStopped;
	}

	/**
	 * Return this turret's type.
	 */
	public int getPrototurretState()
	{
		return this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.TURRET_STOPPED);
	}

	/**
	 * Set this turret's type.
	 */
	public void setPrototurretState(int par1)
	{
		this.dataWatcher.updateObject(DataWatcherLibrary.TURRET_STOPPED, Byte.valueOf((byte)par1));
	}

	/*******************************
	 * GUI dependent code follows. *
	 *******************************/	
	public void openGui(EntityPlayer player)
	{
		if(!this.worldObj.isRemote)
		{
			player.openGui(PokemonMDMain.modInstance, PokemonMDGuiHandler.guiIDPrototurret, this.worldObj, this.getEntityId(), 0, 0);
		}
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (this.isTamed() && this.func_152114_e(player))
		{
			if(player.isSneaking())
			{
				if (!this.worldObj.isRemote)
				{
					this.openGui(player);
				}

				return true;
			}
			else if (itemstack != null)
			{
				if (itemstack.getItem() == PokemonMDItem.xelNagaShard)
				{
					Item itemPar = itemstack.getItem();
					float healAmount = 10F;

					boolean decreaseItemstack = false;

					float oldHealthAmount = this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH);

					if (!player.capabilities.isCreativeMode)
					{
						decreaseItemstack = true;
					}

					this.heal(healAmount);

					spawnHealParticles(healAmount);

					if(oldHealthAmount + healAmount >= healthMaximum)
					{	
						for(int i = 0; i < 5; i++)
						{
							float xx = (float) this.posX + 0.5F, yy = (float) this.posY + this.worldObj.rand.nextFloat() * 6.0F / 16.0F, zz = (float) this.posZ + 0.5F, xx2 = this.worldObj.rand.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;

							this.worldObj.spawnParticle("instantSpell", (double) (xx), (double) yy, (double) (zz), 0.0F, 0.0F, 0.0F);
						}
					}

					if(decreaseItemstack == true)
					{
						--itemstack.stackSize;
					}

					if (itemstack.stackSize <= 0)
					{
						player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
					}

					return true;
				}
				else if(itemstack.getItem() == PokemonMDItem.mysticInitializer)
				{
					return super.interact(player);
				}
			}

			if (!this.worldObj.isRemote)
			{
				this.aiStopped.setStopped(!this.isStopped());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
				this.setTarget((Entity)null);
				this.setAttackTarget((EntityLivingBase)null);
			}

			return true;
		}

		else
		{
			return super.interact(player);
		}
	}

	private void setPrototurretInventory()
	{
		AnimalChest entityInventory = this.prototurretInventory;
		this.prototurretInventory = new AnimalChest("PrototurretInventory", this.slots.length);
		this.prototurretInventory.func_110133_a(this.getCommandSenderName());

		if(entityInventory != null)
		{
			entityInventory.func_110132_b(this);

			int i = Math.min(entityInventory.getSizeInventory(), this.prototurretInventory.getSizeInventory());

			for(int j = 0; j < i; ++j)
			{
				ItemStack itemStack = entityInventory.getStackInSlot(j);

				if(itemStack != null)
				{
					this.prototurretInventory.setInventorySlotContents(j, itemStack.copy());
				}
			}

			entityInventory = null;

		}
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);

		if (!this.worldObj.isRemote)
		{
			this.dropChestItems();
		}
	}

	public void dropChestItems()
	{
		this.dropItemsInChest(this, this.prototurretInventory);
	}

	private void dropItemsInChest(Entity entity, AnimalChest animalChest)
	{
		if (animalChest != null && !this.worldObj.isRemote)
		{
			for (int i = 0; i < animalChest.getSizeInventory(); ++i)
			{
				ItemStack itemstack = animalChest.getStackInSlot(i);

				if (itemstack != null)
				{
					this.entityDropItem(itemstack, 0.0F);
				}
			}
		}
	}
	/*
    public String getOwnerName()
    {
        return this.dataWatcher.getWatchableObjectString(21);
    }

    public void setOwnerName(String par1Str)
    {
        this.dataWatcher.updateObject(21, par1Str);
    }*/

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		/*
        par1NBTTagCompound.setBoolean("EatingHaystack", this.isEatingHaystack());
        par1NBTTagCompound.setBoolean("ChestedHorse", this.isChested());
        par1NBTTagCompound.setBoolean("HasReproduced", this.getHasReproduced());
        par1NBTTagCompound.setBoolean("Bred", this.func_110205_ce());
        par1NBTTagCompound.setInteger("Type", this.getHorseType());
        par1NBTTagCompound.setInteger("Variant", this.getHorseVariant());
        par1NBTTagCompound.setInteger("Temper", this.getTemper());
        par1NBTTagCompound.setBoolean("Tame", this.isTame());
        par1NBTTagCompound.setString("OwnerName", this.getOwnerName());

        if (this.isChested())
        {*//*
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 0; i < this.prototurretInventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = this.prototurretInventory.getStackInSlot(i);

                if (itemstack != null)
                {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    nbttagcompound1.setByte("Slot", (byte)i);
                    itemstack.writeToNBT(nbttagcompound1);
                    nbttaglist.appendTag(nbttagcompound1);
                }
            }

            par1NBTTagCompound.setTag("Items", nbttaglist);
        //}*/

		if (this.prototurretInventory.getStackInSlot(this.powerItemSlotID) != null)
		{
			par1NBTTagCompound.setTag("PowerItem", this.prototurretInventory.getStackInSlot(this.powerItemSlotID).writeToNBT(new NBTTagCompound()));
		}

		if (this.prototurretInventory.getStackInSlot(this.defenseItemSlotID) != null)
		{
			par1NBTTagCompound.setTag("DefenseItem", this.prototurretInventory.getStackInSlot(this.defenseItemSlotID).writeToNBT(new NBTTagCompound()));
		}

		if (this.prototurretInventory.getStackInSlot(this.utilityItemSlotID) != null)
		{
			par1NBTTagCompound.setTag("UtilityItem", this.prototurretInventory.getStackInSlot(this.utilityItemSlotID).writeToNBT(new NBTTagCompound()));
		}

		par1NBTTagCompound.setBoolean("Stopped", this.isStopped());
		/*
        if (this.prototurretInventory.getStackInSlot(0) != null)
        {
            par1NBTTagCompound.setTag("SaddleItem", this.horseChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        }*/
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		/*
		this.setEatingHaystack(par1NBTTagCompound.getBoolean("EatingHaystack"));
		this.func_110242_l(par1NBTTagCompound.getBoolean("Bred"));
		this.setChested(par1NBTTagCompound.getBoolean("ChestedHorse"));
		this.setHasReproduced(par1NBTTagCompound.getBoolean("HasReproduced"));
		this.setHorseType(par1NBTTagCompound.getInteger("Type"));
		this.setHorseVariant(par1NBTTagCompound.getInteger("Variant"));
		this.setTemper(par1NBTTagCompound.getInteger("Temper"));
		this.setHorseTamed(par1NBTTagCompound.getBoolean("Tame"));
		 *//*
		if (par1NBTTagCompound.hasKey("OwnerName", 8))
		{
			this.setOwnerName(par1NBTTagCompound.getString("OwnerName"));
		}

		IAttributeInstance iattributeinstance = this.getAttributeMap().getAttributeInstanceByName("Speed");

		if (iattributeinstance != null)
		{
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(iattributeinstance.getBaseValue() * 0.25D);
		}

		if (this.isChested())
		{
			NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
			this.func_110226_cD();

			for (int i = 0; i < nbttaglist.tagCount(); ++i)
			{
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound1.getByte("Slot") & 255;

				if (j >= 2 && j < this.horseChest.getSizeInventory())
				{
					this.horseChest.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
				}
			}
		}*/

		ItemStack itemstack;

		if (par1NBTTagCompound.hasKey("PowerItem", 10))
		{
			itemstack = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("PowerItem"));

			this.prototurretInventory.setInventorySlotContents(powerItemSlotID, itemstack);
		}

		if (par1NBTTagCompound.hasKey("DefenseItem", 10))
		{
			itemstack = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("DefenseItem"));

			this.prototurretInventory.setInventorySlotContents(defenseItemSlotID, itemstack);
		}

		if (par1NBTTagCompound.hasKey("UtilityItem", 10))
		{
			itemstack = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("UtilityItem"));

			this.prototurretInventory.setInventorySlotContents(utilityItemSlotID, itemstack);
		}

		this.aiStopped.setStopped(par1NBTTagCompound.getBoolean("Stopped"));
		this.setStopped(par1NBTTagCompound.getBoolean("Stopped"));
		/*
		if (par1NBTTagCompound.hasKey("SaddleItem", 10))
		{
			itemstack = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("SaddleItem"));

			if (itemstack != null && itemstack.getItem() == Items.saddle)
			{
				this.horseChest.setInventorySlotContents(0, itemstack);
			}
		}
		else if (par1NBTTagCompound.getBoolean("Saddle"))
		{
			this.horseChest.setInventorySlotContents(0, new ItemStack(Items.saddle));
		}*/

		//this.func_110232_cE();
	}

	public boolean dropTurretItem(EntityPlayer par1EntityPlayer)
	{
		if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(getTurretItem())))
		{
			par1EntityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(getTurretItem()), false);
		}

		if(this.hasCustomNameTag())
		{
			if (!par1EntityPlayer.inventory.addItemStackToInventory(dropNameTag()))
			{
				par1EntityPlayer.dropPlayerItemWithRandomChoice(dropNameTag(), false);
			}
		}

		if (this.prototurretInventory != null && !this.worldObj.isRemote)
		{
			for (int i = 0; i < this.prototurretInventory.getSizeInventory(); ++i)
			{
				ItemStack itemstack = this.prototurretInventory.getStackInSlot(i);

				if (itemstack != null && !par1EntityPlayer.inventory.addItemStackToInventory(itemstack))
				{
					par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}

		return true;
	}

	public ItemStack dropNameTag()
	{
		ItemStack nameTag = new ItemStack(Items.name_tag);

		nameTag.setStackDisplayName(this.getCustomNameTag());

		return nameTag;
	}
	/*
	public boolean dropTurretItem(EntityPlayer par1EntityPlayer) 
	{
		if(this.hasCustomNameTag())
		{
			if (!par1EntityPlayer.inventory.addItemStackToInventory(dropNameTag()))
			{
				par1EntityPlayer.dropPlayerItemWithRandomChoice(dropNameTag(), false);
			}
		}

		return true;
	}*/

	public Block getTurretItem()
	{
		return PokemonMDBlock.prototurret;
	}
	/*
	public boolean dropTurretItem(EntityPlayer par1EntityPlayer)
	{
		if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(getTurretItem())))
		{
			par1EntityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(getTurretItem()), false);
		}

		if(this.hasCustomNameTag())
		{
			if (!par1EntityPlayer.inventory.addItemStackToInventory(dropNameTag()))
			{
				par1EntityPlayer.dropPlayerItemWithRandomChoice(dropNameTag(), false);
			}
		}

		return true;
	}*/

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getIdleAnimationClockPanel()
	{
		return panelIdleAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockVerticalFloat()
	{
		return verticalFloatIdleAnimationClock;
	}

	public void incrementPartClocks()
	{
		panelIdleAnimationClock.incrementClocks();

		verticalFloatIdleAnimationClock.incrementClocks();
	}

	public void setPanelClockDefaults()
	{
		int startingClockY = this.rand.nextInt(100);

		panelIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		panelIdleAnimationClock.setPhaseDurationY(0, 100);

		while(startingClockY > panelIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= panelIdleAnimationClock.getTotalDurationLengthY();
		}

		panelIdleAnimationClock.setClockY(startingClockY);
	}

	public void setVerticalFloatClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		verticalFloatIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		int duration = 80;

		verticalFloatIdleAnimationClock.setPhaseDurationY(0, duration);

		int startingClockY = verticalFloatIdleAnimationClock.getTotalDurationLengthY() + randomInt;

		verticalFloatIdleAnimationClock.setClockY(startingClockY);
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