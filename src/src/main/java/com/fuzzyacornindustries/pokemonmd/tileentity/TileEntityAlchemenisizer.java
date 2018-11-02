package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;

import net.minecraft.tileentity.TileEntity;

public class TileEntityAlchemenisizer extends TileEntity implements IAnimatedEntity
{
	private IdleAnimationClock rotationAnimationClock;
	private IdleAnimationClock verticalShiftIdleAnimationClock[] = new IdleAnimationClock[3];

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;
	
	public TileEntityAlchemenisizer()
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

	public void incrementPartClocks()
	{
		rotationAnimationClock.incrementClocks();
		
		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i].incrementClocks();
		}
	}

	public IdleAnimationClock getIdleAnimationClockRotation()
	{
		return rotationAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockVerticalShift(int partNumber) 
	{
		return verticalShiftIdleAnimationClock[partNumber];
	}
	
	public void setClockDefaults()
	{
		setRotationClockDefaults();
		setVerticalShiftDefaults();
	}
	
	public void setRotationClockDefaults()
	{
		Random rand = new Random();

		int startingClockY = rand.nextInt(100);

		rotationAnimationClock = new IdleAnimationClock(0, 1, 0);

		rotationAnimationClock.setPhaseDurationY(0, 200);

		while(startingClockY > rotationAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= rotationAnimationClock.getTotalDurationLengthY();
		}

		rotationAnimationClock.setClockY(startingClockY);
	}
	
	public void setVerticalShiftDefaults()
	{
		Random rand = new Random();
		
		int randomInt = rand.nextInt(100);

		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i] = new IdleAnimationClock(0, 1, 0);

			verticalShiftIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float frequencyY = 0.35F;

			int startingClockY = (int)(((float)(verticalShiftIdleAnimationClock.length - i) / (float)verticalShiftIdleAnimationClock.length) * (float)verticalShiftIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;
			
			while(startingClockY > verticalShiftIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= verticalShiftIdleAnimationClock[i].getTotalDurationLengthY();
			}

			verticalShiftIdleAnimationClock[i].setClockY(startingClockY);
		}
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