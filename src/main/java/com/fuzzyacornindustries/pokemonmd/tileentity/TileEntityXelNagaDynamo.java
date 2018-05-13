package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.Random;

import net.minecraft.tileentity.TileEntity;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;

public class TileEntityXelNagaDynamo extends TileEntity implements IAnimatedEntity
{
	public IdleAnimationClock dynamoIdleAnimationClock[] = new IdleAnimationClock[3];

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	public TileEntityXelNagaDynamo()
	{
		setClockDefaults();

		animationID = actionIDNone;
		animationTick = 0;
	}

	@Override
	public void updateEntity() 
	{
		incrementPartClocks();
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getDynamoAnimationClock(int partNumber) 
	{
		return dynamoIdleAnimationClock[partNumber];
	}
	
	public void incrementPartClocks()
	{
		for(int i = 0; i < dynamoIdleAnimationClock.length; i++)
		{
			dynamoIdleAnimationClock[i].incrementClocks();
		}
	}
	
	public void setClockDefaults()
	{
		setDynamoClockDefaults();
	}

	public void setDynamoClockDefaults()
	{
		for(int i = 0; i < dynamoIdleAnimationClock.length; i++)
		{
			dynamoIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 1);	
		}
		
		setDynamoClockValues(dynamoIdleAnimationClock[0], 5, 10, 7);
		setDynamoClockValues(dynamoIdleAnimationClock[1], 50, 140, 260);
		setDynamoClockValues(dynamoIdleAnimationClock[2], 10, 25, 15);
	}
	
	public void setDynamoClockValues(IdleAnimationClock idleAnimationClock, int xTime, int yTime, int zTime)
	{
		Random rand = new Random();

		int startingClockX = rand.nextInt(100);
		int startingClockY = rand.nextInt(100);
		int startingClockZ = rand.nextInt(100);

		idleAnimationClock.setPhaseDurationX(0, xTime);
		idleAnimationClock.setPhaseDurationY(0, yTime);
		idleAnimationClock.setPhaseDurationZ(0, zTime);

		while(startingClockX > idleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= idleAnimationClock.getTotalDurationLengthX();
		}

		while(startingClockY > idleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= idleAnimationClock.getTotalDurationLengthY();
		}

		while(startingClockZ > idleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= idleAnimationClock.getTotalDurationLengthZ();
		}

		idleAnimationClock.setClockX(startingClockX);
		idleAnimationClock.setClockY(startingClockY);
		idleAnimationClock.setClockZ(startingClockZ);
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