package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.ModMathFunctions;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.EntityHostilePokemonMD;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIClayLittenEmberVolley;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIGeneralRangedAttacker;
import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntitySmallNormalFireball;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.network.PacketDispatcher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class EntityClayLitten extends EntityHostilePokemonMD implements IRangedAttackMob, IAnimatedEntity
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[5];

	private int tempCounter = 0;

	public static final int actionIDEmberVolley = 1;
	
	static String mobName = "claylitten";

	public float maxFireballRange = 10.0F;
	public float attackRange = 20F;

	public EntityClayLitten(World par1World)
	{
		super(par1World);
		
		this.setSize(0.5F, 0.95F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AIClayLittenEmberVolley(this));
		this.tasks.addTask(3, new AIGeneralRangedAttacker(this, 1.0D, 35, 60, 15.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 0.75D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySubstituteDoll.class, 0, true));

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
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
	}

	@Override
	public int getTotalArmorValue()
	{
		return 2;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		
		this.dataWatcher.addObject(13, new Byte((byte)0));
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

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
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (ticksExisted % 20 == 0)
		{
			PokemonMDMain.proxy.generateParticleBloodmoonFlame(this);
		}

		if(animationID != 0) animationTick++;
	}

	public void resetTargetToAttack()
	{
		this.setTarget((Entity)null);
		this.setAttackTarget((EntityLivingBase)null);
	}

	@Override
	protected void fall(float par1) {}

	@Override
	protected int decreaseAirSupply(int currentAirSupply)
	{
		return currentAirSupply;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Blocks.hardened_clay), 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(Items.blaze_powder), 1);
			}

			j = this.rand.nextInt(2 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.entityDropItem(new ItemStack(PokemonMDItem.xelNagaShard), 1);
			}
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.entityDropItem(new ItemStack(Items.blaze_rod), 2);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		if(animationID == 0)
		{
			PacketDispatcher.sendAnimationPacket(this, actionIDEmberVolley);
		}

		tempCounter = 0;
	}

	public void attackWithFireball(EntityClayLitten attackingMob, EntityLivingBase targetEntity, float par2)
	{
		Vector3f spawnFireballPoint = new Vector3f(ModMathFunctions.findShooterOffsetPoint(attackingMob.posX, attackingMob.posZ, 
				targetEntity.posX, targetEntity.posZ, 0.45F));

		double d0 = targetEntity.posX - spawnFireballPoint.getX();//this.posX;
		double d1 = targetEntity.boundingBox.minY + (double)(targetEntity.height / 2.0F) - (attackingMob.posY + (double)(attackingMob.height / 2.0F));
		double d2 = targetEntity.posZ - spawnFireballPoint.getZ();//this.posZ;

		float f1 = MathHelper.sqrt_float(par2) * 0.2F;
		this.worldObj.playSoundAtEntity(this, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
		this.worldObj.playSoundAtEntity(targetEntity, ModInfo.MODID + ":mob.commonsounds.fireballswoosh", 0.5F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));

		EntitySmallNormalFireball entitysmallfireball = new EntitySmallNormalFireball(attackingMob.worldObj, attackingMob, 
				spawnFireballPoint.getX(), attackingMob.posY, spawnFireballPoint.getZ(),
				d0 + attackingMob.rand.nextGaussian() * (double)f1, d1, d2 + attackingMob.rand.nextGaussian() * (double)f1, 0.75F);
		entitysmallfireball.posY = attackingMob.posY + (double)(attackingMob.height / 2.0F);

		this.worldObj.spawnEntityInWorld(entitysmallfireball);
	}

	@Override
	public boolean getCanSpawnHere()
	{
		Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

		if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL)
		{
			BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

			if (this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.worldObj.getCurrentMoonPhaseFactor() == 1.0F)
			{
				return super.getCanSpawnHere();
			}
		}

		return false;
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

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 40);

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

			tailIdleAnimationClock[i].setPhaseDurationX(0, 40);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 45);

			float frequencyX = 0.75F;
			float frequencyY = 0.55F;

			int startingClockX = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

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