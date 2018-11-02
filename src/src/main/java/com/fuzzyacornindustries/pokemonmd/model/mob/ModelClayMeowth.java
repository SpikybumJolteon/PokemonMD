package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayMeowth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelClayMeowth extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;
	
	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer pawRt;
	public ModelRenderer pawLft;

	public ModelRenderer armRt;
	public ModelRenderer armLft;
	PartInfo armRtInfo;
	PartInfo armLftInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer earRtJoint;
	public ModelRenderer earRt;
	PartInfo earRtJointInfo;
	PartInfo earRtInfo;
	public ModelRenderer earLftJoint;
	public ModelRenderer earLft;
	PartInfo earLftJointInfo;
	PartInfo earLftInfo;

	public ModelRenderer coin;
	public ModelRenderer whiskers;

	public ModelRenderer tail[][] = new ModelRenderer[6][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelClayMeowth() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 56, 26);
		this.body.setRotationPoint(0.0F, 22.6F, 0.0F);
		this.body.addBox(-1.0F, -3.5F, -1.0F, 2, 4, 2, 0.0F);
		bodyInfo = new PartInfo(body);

		this.pawRt = new ModelRenderer(this, 42, 29);
		this.pawRt.setRotationPoint(-0.6F, 0.4F, 0.0F);
		this.pawRt.addBox(-0.5F, 0.0F, -1.3F, 1, 1, 2, 0.0F);
		this.pawLft = new ModelRenderer(this, 49, 29);
		this.pawLft.setRotationPoint(0.6F, 0.4F, 0.0F);
		this.pawLft.addBox(-0.5F, 0.0F, -1.3F, 1, 1, 2, 0.0F);

		this.armRt = new ModelRenderer(this, 42, 25);
		this.armRt.setRotationPoint(-0.8F, -1.6F, 0.0F);
		this.armRt.addBox(-0.8F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
		armRtInfo = new PartInfo(armRt);
		this.armLft = new ModelRenderer(this, 49, 25);
		this.armLft.setRotationPoint(0.8F, -1.6F, 0.0F);
		this.armLft.addBox(-0.3F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
		armLftInfo = new PartInfo(armLft);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.headJoint.addBox(-1.5F, -2.5F, -1.5F, 0, 0, 0, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-1.5F, -2.5F, -1.5F, 3, 3, 3, 0.0F);
		headInfo = new PartInfo(head);

		this.earRtJoint = new ModelRenderer(this, 0, 10);
		this.earRtJoint.setRotationPoint(-1.0F, -2.0F, 0.0F);
		this.earRtJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.0F, -0.0F, -0.5235987755982988F);
		earRtJointInfo = new PartInfo(earRtJoint);
		this.earRt = new ModelRenderer(this, 0, 10);
		this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRt.setTextureOffset(1, 7).addBox(-0.5F, -1.7F, -0.49F, 1, 1, 1, 0.0F); // earRtTip
		earRtInfo = new PartInfo(earRt);
		this.earLftJoint = new ModelRenderer(this, 7, 10);
		this.earLftJoint.setRotationPoint(1.0F, -2.0F, 0.0F);
		this.earLftJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.0F, -0.0F, 0.5235987755982988F);
		earLftJointInfo = new PartInfo(earLftJoint);
		this.earLft = new ModelRenderer(this, 7, 10);
		this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLft.setTextureOffset(8, 7).addBox(-0.5F, -1.7F, -0.49F, 1, 1, 1, 0.0F); // earLftTip
		earLftInfo = new PartInfo(earLft);

		this.coin = new ModelRenderer(this, 17, 6);
		this.coin.setRotationPoint(0.0F, -2.0F, -1.5F);
		this.coin.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
		this.whiskers = new ModelRenderer(this, 13, 0);
		this.whiskers.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.whiskers.addBox(-3.0F, -5.0F, -1.0F, 6, 5, 0, 0.0F);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 33, 29); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -0.4F, 0.7F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 33, 29); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 34, 26); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 34, 26); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 34, 23); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.15F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 34, 23); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.15F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 34, 20); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.15F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 34, 20); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.15F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 34, 17); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.15F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 34, 17); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.15F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 33, 12); // tail6Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -1.5F, -0.15F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 33, 12); // tail6
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -1.5F, -0.15F, 1, 2, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		this.body.addChild(this.headJoint);
		this.body.addChild(this.armLft);
		this.body.addChild(this.armRt);
		this.body.addChild(this.pawLft);
		this.body.addChild(this.pawRt);
		this.body.addChild(this.tail[0][0]); // tail1Joint

		this.headJoint.addChild(this.head);
		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earRtJoint);
		this.head.addChild(this.coin);
		this.head.addChild(this.whiskers);
		
		this.earLftJoint.addChild(this.earLft);
		this.earRtJoint.addChild(this.earRt);

		this.tail[0][0].addChild(this.tail[0][1]); // tail1Joint * tail1
		this.tail[0][1].addChild(this.tail[1][0]); // tail1 * tail2Joint
		this.tail[1][0].addChild(this.tail[1][1]); // tail2Joint * tail2
		this.tail[1][1].addChild(this.tail[2][0]); // tail2 * tail3Joint
		this.tail[2][0].addChild(this.tail[2][1]); // tail3Joint * tail3
		this.tail[2][1].addChild(this.tail[3][0]); // tail3 * tail4Joint
		this.tail[3][0].addChild(this.tail[3][1]); // tail4Joint * tail4
		this.tail[3][1].addChild(this.tail[4][0]); // tail4 * tail5Joint
		this.tail[4][0].addChild(this.tail[4][1]); // tail5Joint * tail5
		this.tail[4][1].addChild(this.tail[5][0]); // tail5 * tail6Joint
		this.tail[5][0].addChild(this.tail[5][1]); // tail6Joint * tail6

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		this.body.render(modelSize);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void animate(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{	
		/* Static references to array lengths in Entity class from Model class
		 * makes the glow/normal models not animate in sync. */
		this.animationDeployer.update((IAnimatedEntity)entity);
		resetPartInfos();

		animateHead((EntityClayMeowth)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateArms((EntityClayMeowth)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityClayMeowth)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityClayMeowth)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();
		
		armRtInfo.resetNewAngles();
		armLftInfo.resetNewAngles();

		earRtJointInfo.resetNewAngles();
		earRtInfo.resetNewAngles();
		earLftJointInfo.resetNewAngles();
		earLftInfo.resetNewAngles();

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}

	public void animateHead(EntityClayMeowth entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockEars();

		PartAnimate.headAnimateInfoOnly(headInfo, yawHeadOffsetDifference, pitchRotation);

		float moveFrequencyZ = 0.7F;
		float moveAmplitudeZ = 0.15F;

		float firstAngleChangeZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyZ, moveAmplitudeZ);

		float idleAmplitudeZ = 0.20F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = firstAngleChangeZ;

		angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI + PI) * idleAmplitudeZ;

		earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - angleChangeZ);
		earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + angleChangeZ);
	}

	public void animateArms(EntityClayMeowth entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockArms();

		float moveFrequencyX = 0.7F;
		float moveAmplitudeX = 0.2F;

		float angleChangeX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyX, moveAmplitudeX);

		float idleAmplitudeX = 0.20F;

		// + (float)Math.toRadians(45)

		angleChangeX += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeX;

		armRtInfo.setNewRotateX(armRtInfo.getNewRotateX() + angleChangeX);
		armLftInfo.setNewRotateX(armLftInfo.getNewRotateX() - angleChangeX);
	}

	public void animateLegs(EntityClayMeowth entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float frequency = 1.5F;
		float amplitude = 0.6F;

		this.pawRt.rotateAngleX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
		this.pawLft.rotateAngleX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
	}

	public void animateTail(EntityClayMeowth entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float amplitudeX = 0.30F;
			float amplitudeZ = 0.85F;
			
			float moveFrequency = 1F;
			float moveAmplitude = 0.2F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeZ = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * amplitudeX
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);
			angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2) * amplitudeZ;

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateZ(tailInfo[i][1].getNewRotateZ() + angleChangeZ);
		}
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());

		this.animationDeployer.rotate(earLft, earLftInfo.getNewRotates());
		this.animationDeployer.rotate(earLftJoint, earLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(earRt, earRtInfo.getNewRotates());
		this.animationDeployer.rotate(earRtJoint, earRtJointInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}