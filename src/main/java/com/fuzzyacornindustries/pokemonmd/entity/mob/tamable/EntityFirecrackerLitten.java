package com.fuzzyacornindustries.pokemonmd.entity.mob.tamable;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralBerryBeg;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralRangedAttacker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryAhriNinetalesAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityFireworkMissile;
import com.fuzzyacornindustries.pokemonmd.item.BerryItem;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.item.tamable.IBoostItem;
import com.fuzzyacornindustries.pokemonmd.item.tamable.IEssenceItem;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemFirecrackerLittenSummon;
import com.fuzzyacornindustries.pokemonmd.library.DataWatcherLibrary;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityFirecrackerLitten extends TamablePokemon implements IRangedAttackMob
{
	private IdleAnimationClock bodyIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[8];

	static String mobName = "firecrackerlitten";

	public float maxSightRange = 15.0F;

	public static final float defaultBaseAttackPower = 4F;
	public static final float defaultBaseMaxHealth = 30F;

	public static final float defaultMaximumAttackBoost = 14F;
	public static final float defaultmaximumHealthBoost = 60F;

	public EntityFirecrackerLitten(World par1World)
	{
		super(par1World);
		
		this.setSize(0.5F, 0.9F);
		this.tasks.addTask(1, new EntityAISwimming(this));

		this.tasks.addTask(3, this.aiSit);
		this.tasks.addTask(3, new AIGeneralRangedAttacker(this, 1.0D, 20, 20, maxSightRange));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, TamablePokemon.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(8, new AIGeneralBerryBeg(this, 8.0F));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

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
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.40D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		this.dataWatcher.updateObject(DataWatcherLibrary.MAX_HEALTH, Float.valueOf(this.defaultBaseMaxHealth));
		this.dataWatcher.updateObject(DataWatcherLibrary.ATTACK_POWER, Float.valueOf(this.defaultBaseAttackPower));

		this.setFireImmunityEssence(1);
		this.setFallImmunityEssence(1);
	}

	@Override
	protected String getLivingSound()
	{
		if(this.isTamed() && this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH) < ((float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() / 4))
		{
			return ModInfo.MODID + ":mob." + getMobName() + ".whine";
		}
		else if(this.dataWatcher.getWatchableObjectByte(DataWatcherLibrary.SOUND) == 1)
		{
			return null;
		}
		else
		{
			return ModInfo.MODID + ":mob." + getMobName() + ".living";
		}
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

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);

		par1NBTTagCompound.setByte("FirecrackerLittenTextureType", (byte)this.getMainTextureType());
		par1NBTTagCompound.setByte("FirecrackerLittenSoundType", (byte)this.getSoundType());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

		if (par1NBTTagCompound.hasKey("FirecrackerLittenTextureType", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("FirecrackerLittenTextureType");
			this.setMainTextureType(b0);
		}

		if (par1NBTTagCompound.hasKey("FirecrackerLittenSoundType", 99))
		{
			byte b0 = par1NBTTagCompound.getByte("FirecrackerLittenSoundType");
			this.setSoundType(b0);
		}
	}

	@Override
	public void setDead()
	{
		if (this.getOwner() != null && this.getOwner() instanceof EntityPlayer && !worldObj.isRemote)
		{
			EntityPlayer owner = (EntityPlayer)this.getOwner();

			ItemStack poketamableStack = new ItemFirecrackerLittenSummon().fromPoketamableEntity(this);

			if (poketamableStack != null)
			{
				if (owner.getHealth() > 0 && owner.inventory.addItemStackToInventory(poketamableStack))
				{
					//worldObj.playSoundAtEntity(owner, "mob.slime.big", 1F, 1F);
				}
				else
				{
					//worldObj.playSoundAtEntity(owner, "mob.slime.big", 1F, 1F);
					worldObj.spawnEntityInWorld(new EntityItem(worldObj, owner.posX, owner.posY, owner.posZ, poketamableStack));
				}
			}
		}

		super.setDead();
	}

	@Override
	public void onLivingUpdate()
	{
		if(this.isSitting() == true && this.getHealth() < (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue())
		{
			regenTimer++;

			if(regenTimer >= 500)
			{
				float healAmount = 1.0F;

				this.heal(healAmount);
				regenTimer = 0;

				if(this.worldObj.isRemote)
					spawnHealParticles(healAmount);
			}
		}
		else
		{
			regenTimer = 0;
		}

		if(this.worldObj.isRemote)
		{
			applyCurrentTexture();
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(animationID != LibraryAhriNinetalesAttackID.NO_ACTION) animationTick++;

		toggleHappiness();
	}
	
	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (this.isTamed())
		{
			if(player.isSneaking())
			{
				toggleIdleSounds();
			}

			if (itemstack != null)
			{
				if (itemstack.getItem() instanceof BerryItem)
				{
					BerryItem berry = (BerryItem)itemstack.getItem();

					boolean decreaseBerryItemstack = false;

					if(this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH) < (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue())
					{	
						decreaseBerryItemstack = berryHeal(player, (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue(), berry);

						if(decreaseBerryItemstack == true)
						{
							--itemstack.stackSize;
						}

						if (itemstack.stackSize <= 0)
						{
							player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
						}

						return true;
					}
				}
				else if(itemstack.getItem() instanceof IBoostItem)
				{
					if(itemstack.getItem() == PokemonMDItem.lifeBoost && this.getMaximumHealth() < this.defaultmaximumHealthBoost)
					{
						applyLifeBoost(player, itemstack);

						return true;
					}
					else if(itemstack.getItem() == PokemonMDItem.attackBoost && this.getAttackPower() < this.defaultMaximumAttackBoost)
					{
						applyAttackBoost(player, itemstack);

						return true;
					}
				}
				else if(itemstack.getItem() instanceof IEssenceItem)
				{
					if(itemstack.getItem() == PokemonMDItem.firagaEssence && this.hasFireImmunityEssence() != 1)
					{
						applyFiragaEssence(player, itemstack);
						
						return true;
					}
					else if(itemstack.getItem() == PokemonMDItem.watergaEssence && this.hasDrowningImmunityEssence() != 1)
					{
						applyWatergaEssence(player, itemstack);
						
						return true;
					}
					else if(itemstack.getItem() == PokemonMDItem.gravigaEssence && this.hasFallImmunityEssence() != 1)
					{
						applyGravigaEssence(player, itemstack);
						
						return true;
					}
					else if(itemstack.getItem() == PokemonMDItem.quakagaEssence && this.hasBlockSuffocationAvoidanceEssence() != 1)
					{
						applyQuakagaEssence(player, itemstack);
						
						return true;
					}
					else if(itemstack.getItem() == PokemonMDItem.biogaEssence && this.hasToxinImmunityEssence() != 1)
					{
						applyBiogaEssence(player, itemstack);
						
						return true;
					}
					else if(PokemonMDMain.isGalacticraftEnabled && itemstack.getItem() == PokemonMDItem.cometEssence && this.hasSpaceSurvivabilityEssence() != 1)
					{
						applySpaceSurvivabilityEssence(player, itemstack);

						return true;
					}
				}
				else if(PokemonMDMain.isZeldaSwordSkillsEnabled)
				{
					if(this.dataWatcher.getWatchableObjectFloat(DataWatcherLibrary.HEALTH) < (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue())
					{	
						Item item = GameRegistry.findItem("zeldaswordskills", "zss.potion_red");

						if(item != null && itemstack.getItem() == item)
						{
							boolean decreasePotionItemstack = false;

							decreasePotionItemstack = zssPotionHeal(player, (float)this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue(), itemstack.getItem());

							if(decreasePotionItemstack == true)
							{
								if (--itemstack.stackSize <= 0) 
								{
									itemstack = new ItemStack(Items.glass_bottle);
								}

								player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
							}

							return true;
						}
					}
				}
			}

			if (this.func_152114_e(player) && !this.worldObj.isRemote && !player.isSneaking())
			{
				applySit();
			}
		}

		return super.interact(player);
	}

	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		EntityFireworkMissile entitymissile = new EntityFireworkMissile(this.worldObj, this, targetEntity, 1.6F, (float)(5), this.getAttackPower() / 2F);

		this.worldObj.playSoundAtEntity(this, "fireworks.launch", 3.0F, 1.0F);
		this.worldObj.spawnEntityInWorld(entitymissile);

		if(animationID == LibraryAhriNinetalesAttackID.NO_ACTION)
		{
			//MainRegistry.sendAnimationPacket(this, LibraryFoxfireZoruaAttackID.SUMMON_FOXFIRE);
		}
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockBody()
	{
		return bodyIdleAnimationClock;
	}

	@SideOnly(Side.CLIENT)
	public IdleAnimationClock getIdleAnimationClockTail(int partNumber)
	{
		return tailIdleAnimationClock[partNumber];
	}

	@SideOnly(Side.CLIENT)
	public void incrementPartClocks()
	{
		bodyIdleAnimationClock.incrementClocks();

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}
	}

	@SideOnly(Side.CLIENT)
	public void setClockDefaults()
	{
		setBodyClockDefaults();
		setTailClockDefaults();
	}

	@SideOnly(Side.CLIENT)
	public void setBodyClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		bodyIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		bodyIdleAnimationClock.setPhaseDurationX(0, 50);

		int startingClockX = randomInt;

		while(startingClockX > bodyIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= bodyIdleAnimationClock.getTotalDurationLengthX();
		}

		bodyIdleAnimationClock.setClockX(startingClockX);
	}

	@SideOnly(Side.CLIENT)
	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 55);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 65);

			float pointClusterDensityX = 0.55F;
			float pointClusterDensityY = 0.45F;

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