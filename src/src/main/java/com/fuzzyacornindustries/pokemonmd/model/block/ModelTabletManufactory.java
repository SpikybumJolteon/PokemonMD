package com.fuzzyacornindustries.pokemonmd.model.block;

import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityTabletManufactory;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTabletManufactory extends ModelBase 
{
	float PI = (float)Math.PI;

	public ModelRenderer panel;
	PartInfo panelInfo;

	public ModelRenderer rodRt[] = new ModelRenderer[3];
	public ModelRenderer rodLft[] = new ModelRenderer[3];
	public PartInfo rodRtInfo[] = new PartInfo[rodRt.length];
	public PartInfo rodLftInfo[] = new PartInfo[rodLft.length];

	public ModelTabletManufactory() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.panel = new ModelRenderer(this, 0, 0);
		this.panel.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.panel.addBox(-6.0F, -5.9F, -0.5F, 12, 12, 1, 0.0F);
		panelInfo = new PartInfo(panel);

		int rodRtNumber = 0;
		this.rodRt[rodRtNumber] = new ModelRenderer(this, 27, 0); // rodRt1
		this.rodRt[rodRtNumber].setRotationPoint(-6.0F, 11.0F, 0.0F);
		this.rodRt[rodRtNumber].addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		rodRtInfo[rodRtNumber] = new PartInfo(rodRt[rodRtNumber]);
		rodRtNumber++;
		this.rodRt[rodRtNumber] = new ModelRenderer(this, 27, 6); // rodRt2
		this.rodRt[rodRtNumber].setRotationPoint(-6.0F, 15.0F, 0.0F);
		this.rodRt[rodRtNumber].addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		rodRtInfo[rodRtNumber] = new PartInfo(rodRt[rodRtNumber]);
		rodRtNumber++;
		this.rodRt[rodRtNumber] = new ModelRenderer(this, 27, 12); // rodRt3
		this.rodRt[rodRtNumber].setRotationPoint(-6.0F, 19.0F, 0.0F);
		this.rodRt[rodRtNumber].addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		rodRtInfo[rodRtNumber] = new PartInfo(rodRt[rodRtNumber]);

		int rodLftNumber = 0;
		this.rodLft[rodLftNumber] = new ModelRenderer(this, 38, 0); // rodLft1
		this.rodLft[rodLftNumber].setRotationPoint(6.0F, 13.0F, 0.0F);
		this.rodLft[rodLftNumber].addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		rodLftInfo[rodLftNumber] = new PartInfo(rodLft[rodLftNumber]);
		rodLftNumber++;
		this.rodLft[rodLftNumber] = new ModelRenderer(this, 38, 6); // rodLft2
		this.rodLft[rodLftNumber].setRotationPoint(6.0F, 17.0F, 0.0F);
		this.rodLft[rodLftNumber].addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		rodLftInfo[rodLftNumber] = new PartInfo(rodLft[rodLftNumber]);
		rodLftNumber++;
		this.rodLft[rodLftNumber] = new ModelRenderer(this, 38, 12); // rodLft3
		this.rodLft[rodLftNumber].setRotationPoint(6.0F, 21.0F, 0.0F);
		this.rodLft[rodLftNumber].addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		rodLftInfo[rodLftNumber] = new PartInfo(rodLft[rodLftNumber]);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		this.panel.render(f5);

		for(int i = 0; i < rodRt.length; i++)
		{
			rodRt[i].render(f5);
		}

		for(int i = 0; i < rodLft.length; i++)
		{
			rodLft[i].render(f5);
		}
	}

	public void renderModel(float f, TileEntityTabletManufactory tileEntity)
	{
		animate(tileEntity);

		this.panel.render(f);

		for(int i = 0; i < rodRt.length; i++)
		{
			rodRt[i].render(f);
		}

		for(int i = 0; i < rodLft.length; i++)
		{
			rodLft[i].render(f);
		}
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void resetPartInfos()
	{
		panelInfo.resetNewPnt();
		panelInfo.resetNewAngles();

		for(int i = 0; i < rodRtInfo.length; i++)
		{
			rodRtInfo[i].resetNewAngles();
			rodRtInfo[i].resetNewPnt();
		}

		for(int i = 0; i < rodLftInfo.length; i++)
		{
			rodLftInfo[i].resetNewAngles();
			rodLftInfo[i].resetNewPnt();
		}
	}

	public void animate(TileEntityTabletManufactory tileEntity)
	{	
		resetPartInfos();

		animateVerticalShift((TileEntityTabletManufactory)tileEntity);
		animateBars((TileEntityTabletManufactory)tileEntity);
		animateRotation((TileEntityTabletManufactory)tileEntity);

		shiftRotationPoints();
	}
	
	public void animateVerticalShift(TileEntityTabletManufactory tileEntity)
	{
		IdleAnimationClock currentIdleAnimationClock = tileEntity.getVerticalFloatAnimationClock();

		float amplitudeShiftY = -1F;

		panelInfo.setNewPnt(new Vector3f(panelInfo.getNewPointX(),
				(panelInfo.getNewPointY() + MathHelper.cos(2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredY(0)) * amplitudeShiftY),
				panelInfo.getNewPointZ()));

		panelInfo.assignNewRotationPointToPart(panel);
	}

	public void animateBars(TileEntityTabletManufactory tileEntity)
	{
		float maxOffsetX = 12F;
		float maxOffsetY = 2F;
		
		for(int i = 0; i < 3; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = tileEntity.getBarsAnimationClock(i * 2);

			float newPointX = rodRtInfo[i].getNewPointX();
			float newPointY = rodRtInfo[i].getNewPointY();

			if(currentIdleAnimationClock.getPhaseDurationCoveredX(0) < 1F)
			{
				newPointX += durationEquation(currentIdleAnimationClock.getPhaseDurationCoveredX(0))
						* maxOffsetX;
			}
			else if(currentIdleAnimationClock.getPhaseDurationCoveredX(1) < 1F)
			{
				newPointX += maxOffsetX;
				
				newPointY += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(1) * (PI/2))
						* maxOffsetY;
			}
			else if(currentIdleAnimationClock.getPhaseDurationCoveredX(2) < 1F)
			{
				newPointX += (maxOffsetX - 
						durationEquation(currentIdleAnimationClock.getPhaseDurationCoveredX(2)) * maxOffsetX);
				
				newPointY += maxOffsetY;
			}
			else if(currentIdleAnimationClock.getPhaseDurationCoveredX(3) < 1F)
			{
				newPointY += (maxOffsetY - 
						MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(3) * (PI/2)) * maxOffsetY);
			}

			rodRtInfo[i].setNewPnt(new Vector3f(newPointX, newPointY, rodRtInfo[i].getNewPointZ()));
		}

		for(int i = 0; i < 3; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = tileEntity.getBarsAnimationClock(i * 2 + 1);

			float newPointX = rodLftInfo[i].getNewPointX();
			float newPointY = rodLftInfo[i].getNewPointY();

			if(currentIdleAnimationClock.getPhaseDurationCoveredX(0) < 1F)
			{
				newPointX -= durationEquation(currentIdleAnimationClock.getPhaseDurationCoveredX(0))
						* maxOffsetX;
			}
			else if(currentIdleAnimationClock.getPhaseDurationCoveredX(1) < 1F)
			{
				newPointX -= maxOffsetX;
				
				newPointY -= MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(1) * (PI/2))
						* maxOffsetY;
			}
			else if(currentIdleAnimationClock.getPhaseDurationCoveredX(2) < 1F)
			{
				newPointX -= (maxOffsetX - 
						durationEquation(currentIdleAnimationClock.getPhaseDurationCoveredX(2)) * maxOffsetX);
				
				newPointY -= maxOffsetY;
			}
			else if(currentIdleAnimationClock.getPhaseDurationCoveredX(3) < 1F)
			{
				newPointY -= (maxOffsetY - 
						MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(3) * (PI/2)) * maxOffsetY);
			}

			rodLftInfo[i].setNewPnt(new Vector3f(newPointX, newPointY, rodLftInfo[i].getNewPointZ()));
		}
	}
	
	public float durationEquation(float durationCovered)
	{
		float duration = 0;
		float slope = 10F;
		
		duration = 1/(1 + (float)Math.pow((float)Math.E, -(slope * durationCovered - (slope/2))));
		
		return duration;
	}

	public void animateRotation(TileEntityTabletManufactory tileEntity)
	{
		IdleAnimationClock currentIdleAnimationClock = tileEntity.getRotationAnimationClock();

		panelInfo.setNewRotateY((float)(panelInfo.getNewRotateY()) + (2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredY(0)));

		panelInfo.assignNewRotationAnglesToPart(panel);

		for(int i = 0; i < rodRt.length; i++)
		{
			PartAnimate.mirrorPartRotatesInfoChangesToSlavePart(panelInfo, rodRt[i], rodRtInfo[i]);
		}

		for(int i = 0; i < rodLft.length; i++)
		{
			PartAnimate.mirrorPartRotatesInfoChangesToSlavePart(panelInfo, rodLft[i], rodLftInfo[i]);
		}
	}

	public void shiftRotationPoints()
	{
		for(int i = 0; i < rodRtInfo.length; i++)
		{
			PartAnimate.shiftSlaveRotationNewPntWithParent(panelInfo, rodRtInfo[i]);
			PartAnimate.transposePart(panelInfo, rodRt[i], rodRtInfo[i]);
		}

		for(int i = 0; i < rodLftInfo.length; i++)
		{
			PartAnimate.shiftSlaveRotationNewPntWithParent(panelInfo, rodLftInfo[i]);
			PartAnimate.transposePart(panelInfo, rodLft[i], rodLftInfo[i]);
		}
	}
}