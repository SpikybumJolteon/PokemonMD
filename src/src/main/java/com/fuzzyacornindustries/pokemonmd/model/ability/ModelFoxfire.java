package com.fuzzyacornindustries.pokemonmd.model.ability;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntityBloodmoonFoxfire;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.IAnimateFoxfire;

public class ModelFoxfire extends ModelBase 
{
	public final float PI = (float)Math.PI;

	public final float WALK_FREQUENCY = 1.5F;

	private AnimationDeployer animationDeployer;

	public ModelRenderer center;
	PartInfo centerInfo;

	public ModelRenderer flameSide[] = new ModelRenderer[4];
	public ModelRenderer flameInterior[] = new ModelRenderer[4];
	PartInfo flameSideInfo[] = new PartInfo[flameSide.length];
	PartInfo flameInteriorInfo[] = new PartInfo[flameInterior.length];

	public ModelFoxfire() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.center = new ModelRenderer(this, 0, 0);
		this.center.setRotationPoint(0.0F, 20.0F, 0.0F);
		this.center.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		centerInfo = new PartInfo(center);

		int flamePartNumber = 0;
		this.flameSide[flamePartNumber] = new ModelRenderer(this, 0, 0); // flameSide1
		this.flameSide[flamePartNumber].setRotationPoint(0.0F, 2.0F, -4.01F);
		this.flameSide[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		flameSideInfo[flamePartNumber] = new PartInfo(flameSide[flamePartNumber]);
		flamePartNumber++;
		this.flameSide[flamePartNumber] = new ModelRenderer(this, 19, 0); // flameSide2
		this.flameSide[flamePartNumber].setRotationPoint(4.01F, 2.0F, 0.0F);
		this.flameSide[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		this.setRotateAngle(flameSide[flamePartNumber], 0.0F, 1.5707963267948966F, 0.0F);
		flameSideInfo[flamePartNumber] = new PartInfo(flameSide[flamePartNumber]);
		flamePartNumber++;
		this.flameSide[flamePartNumber] = new ModelRenderer(this, 0, 10); // flameSide3
		this.flameSide[flamePartNumber].setRotationPoint(0.0F, 2.0F, 4.01F);
		this.flameSide[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		this.setRotateAngle(flameSide[flamePartNumber], 0.0F, 3.141592653589793F, 0.0F);
		flameSideInfo[flamePartNumber] = new PartInfo(flameSide[flamePartNumber]);
		flamePartNumber++;
		this.flameSide[flamePartNumber] = new ModelRenderer(this, 19, 10); // flameSide4
		this.flameSide[flamePartNumber].setRotationPoint(-4.01F, 2.0F, 0.0F);
		this.flameSide[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		this.setRotateAngle(flameSide[flamePartNumber], 0.0F, 4.71238898038469F, 0.0F);
		flameSideInfo[flamePartNumber] = new PartInfo(flameSide[flamePartNumber]);

		flamePartNumber = 0;

		this.flameInterior[flamePartNumber] = new ModelRenderer(this, 0, 10); // flameInterior1
		this.flameInterior[flamePartNumber].setRotationPoint(0.0F, 2.0F, -4.0F);
		this.flameInterior[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		this.setRotateAngle(flameInterior[flamePartNumber], -0.7853981633974483F, 0.0F, 0.0F);
		flameInteriorInfo[flamePartNumber] = new PartInfo(flameInterior[flamePartNumber]);
		flamePartNumber++;
		this.flameInterior[flamePartNumber] = new ModelRenderer(this, 19, 10); // flameInterior2
		this.flameInterior[flamePartNumber].setRotationPoint(4.0F, 2.0F, 0.0F);
		this.flameInterior[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		this.setRotateAngle(flameInterior[flamePartNumber], 0.7853981633974483F, 1.5707963267948966F, 0.0F);
		flameInteriorInfo[flamePartNumber] = new PartInfo(flameInterior[flamePartNumber]);
		flamePartNumber++;
		this.flameInterior[flamePartNumber] = new ModelRenderer(this, 0, 0); // flameInterior3
		this.flameInterior[flamePartNumber].setRotationPoint(0.0F, 2.0F, 4.0F);
		this.flameInterior[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		this.setRotateAngle(flameInterior[flamePartNumber], -0.7853981633974483F, 3.141592653589793F, 0.0F);
		flameInteriorInfo[flamePartNumber] = new PartInfo(flameInterior[flamePartNumber]);
		flamePartNumber++;
		this.flameInterior[flamePartNumber] = new ModelRenderer(this, 19, 0); // flameInterior4
		this.flameInterior[flamePartNumber].setRotationPoint(-4.0F, 2.0F, 0.0F);
		this.flameInterior[flamePartNumber].addBox(-4.0F, -8.0F, 0.0F, 8, 8, 1, 0.0F);
		this.setRotateAngle(flameInterior[flamePartNumber], 0.7853981633974483F, 4.71238898038469F, 0.0F);
		flameInteriorInfo[flamePartNumber] = new PartInfo(flameInterior[flamePartNumber]);

		for(int i = 0; i < flameSide.length; i++)
		{
			this.center.addChild(this.flameSide[i]);
			this.center.addChild(this.flameInterior[i]);
		}

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		animate(entity, f, f1, f2, f3, f4, f5);

		this.center.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void animate(Entity entity, float distanceMoved, float horzVelocity, float par3, float par4, float par5, float par6)
	{	
		/* Static references to array lengths in Entity class from Model class
		 * makes the glow/normal models not animate in sync. */
		this.animationDeployer.update((IAnimatedEntity)entity);
		resetPartInfos();

		animateSpin((IAnimateFoxfire)entity, distanceMoved, horzVelocity, par3, par4, par5, par6);
		animateVerticalFloat((IAnimateFoxfire)entity, distanceMoved, horzVelocity, par3, par4, par5, par6);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		centerInfo.resetNewAngles();
		centerInfo.resetNewPnt();

		for(int i = 0; i < flameSide.length; i++)
		{
			flameSideInfo[i].resetNewAngles();
			flameInteriorInfo[i].resetNewAngles();
		}
	}

	public void animateSpin(IAnimateFoxfire entity, float distanceMoved, float horzVelocity, float par3, float par4, float par5, float par6)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockSpin();

		centerInfo.setNewRotateY(centerInfo.getNewRotateY() - (2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredY(0)));
	}

	public void animateVerticalFloat(IAnimateFoxfire entity, float distanceMoved, float horzVelocity, float par3, float par4, float par5, float par6)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockVerticalFloat();

		float amplitudeShiftY = 1.5F;

		centerInfo.setNewPointY(centerInfo.getNewPnt().getY() + MathHelper.cos(2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredY(0)) * amplitudeShiftY);

		float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

		float walkMaximumChangeY = 0.5F;

		float walkCyclePointChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI + PI/2) * walkMaximumChangeY * (1 - horzVelocity);

		centerInfo.setNewPointY(centerInfo.getNewPointY() + walkCyclePointChange  * horzVelocity);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(center, centerInfo.getNewRotates());
		this.animationDeployer.move(center, centerInfo.getNewPnt());

		for(int i = 0; i < flameSide.length; i++)
		{
			this.animationDeployer.rotate(flameSide[i], flameSideInfo[i].getNewRotates());
			this.animationDeployer.rotate(flameInterior[i], flameInteriorInfo[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}