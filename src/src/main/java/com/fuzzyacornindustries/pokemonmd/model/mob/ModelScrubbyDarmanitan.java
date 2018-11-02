package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityScrubbyDarmanitan;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelScrubbyDarmanitan extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer legLft;
	public ModelRenderer legRt;
	PartInfo legLftInfo;
	PartInfo legRtInfo;

	public ModelRenderer armRtJoint;
	public ModelRenderer armRt;
	public ModelRenderer armRtForearmJoint;
	public ModelRenderer armRtForearm;
	PartInfo armRtJointInfo;
	PartInfo armRtInfo;
	PartInfo armRtForearmJointInfo;
	PartInfo armRtForearmInfo;

	public ModelRenderer armLftJoint;
	public ModelRenderer armLft;
	public ModelRenderer armLftForearmJoint;
	public ModelRenderer armLftForearm;
	PartInfo armLftJointInfo;
	PartInfo armLftInfo;
	PartInfo armLftForearmJointInfo;
	PartInfo armLftForearmInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer headHairRt1;
	public ModelRenderer headHairRt2;
	public ModelRenderer headHairLft1;
	public ModelRenderer headHairLft2;
	PartInfo headHairRt1Info;
	PartInfo headHairRt2Info;
	PartInfo headHairLft1Info;
	PartInfo headHairLft2Info;

	public ModelRenderer tail[][] = new ModelRenderer[2][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelScrubbyDarmanitan() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 38, 21);
		this.body.setRotationPoint(0.0F, 19.5F, 2.0F);
		this.body.addBox(-4.5F, -11.0F, -1.0F, 9, 13, 4, 0.0F);
		this.setRotateAngle(body, 0.7853981633974483F, 0.0F, 0.0F);
		this.body.setTextureOffset(40, 40).addBox(-4.5F, -9.0F, -4.0F, 9, 9, 3, 0.0F); // bodyLower
		this.body.setTextureOffset(42, 61).addBox(-4.5F, 0.0F, -3.0F, 9, 1, 2, 0.0F); // bodyBottom
		this.body.setTextureOffset(48, 53).addBox(-3.5F, -7.0F, -5.0F, 7, 6, 1, 0.0F); // bodyLowerTip
		this.body.setTextureOffset(46, 9).addBox(-3.5F, -9.0F, 3.0F, 7, 9, 2, 0.0F); // bodyTop
		this.body.setTextureOffset(52, 0).addBox(-2.5F, -8.0F, 5.0F, 5, 7, 1, 0.0F); // bodyTopTip
		bodyInfo = new PartInfo(body);

		this.legLft = new ModelRenderer(this, 13, 57);
		this.legLft.setRotationPoint(2.5F, 1.1F, -1.1F);
		this.legLft.addBox(-1.5F, -0.5F, -1.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(legLft, -0.7853981633974483F, 0.0F, 0.0F);
		legLftInfo = new PartInfo(legLft);
		this.legRt = new ModelRenderer(this, 0, 57);
		this.legRt.setRotationPoint(-2.5F, 1.1F, -1.1F);
		this.legRt.addBox(-1.5F, -0.5F, -1.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(legRt, -0.7853981633974483F, 0.0F, 0.0F);
		legRtInfo = new PartInfo(legRt);

		this.armRtJoint = new ModelRenderer(this, 0, 24);
		this.armRtJoint.setRotationPoint(-4.0F, -7.0F, 1.0F);
		this.armRtJoint.addBox(-3.5F, -2.0F, -7.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtJoint, -0.2617993877991494F, 0.17453292519943295F, 0.0F);
		armRtJointInfo = new PartInfo(armRtJoint);
		this.armRt = new ModelRenderer(this, 0, 24);
		this.armRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRt.addBox(-3.5F, -2.0F, -7.0F, 4, 4, 9, 0.0F);
		armRtInfo = new PartInfo(armRt);
		this.armRtForearmJoint = new ModelRenderer(this, 0, 39);
		this.armRtForearmJoint.setRotationPoint(-1.5F, 0.0F, -5.6F);
		this.armRtForearmJoint.addBox(-2.1F, -2.0F, -7.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtForearmJoint, 1.0471975511965976F, 0.0F, 0.0F);
		armRtForearmJointInfo = new PartInfo(armRtForearmJoint);
		this.armRtForearm = new ModelRenderer(this, 0, 39);
		this.armRtForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtForearm.addBox(-2.1F, -2.0F, -7.5F, 4, 4, 8, 0.0F);
		armRtForearmInfo = new PartInfo(armRtForearm);
		this.armLftJoint = new ModelRenderer(this, 17, 29);
		this.armLftJoint.setRotationPoint(4.0F, -7.0F, 1.0F);
		this.armLftJoint.addBox(-0.5F, -2.0F, -7.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftJoint, -0.2617993877991494F, -0.17453292519943295F, 0.0F);
		armLftJointInfo = new PartInfo(armLftJoint);
		this.armLft = new ModelRenderer(this, 17, 29);
		this.armLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLft.addBox(-0.5F, -2.0F, -7.0F, 4, 4, 9, 0.0F);
		armLftInfo = new PartInfo(armLft);
		this.armLftForearmJoint = new ModelRenderer(this, 18, 44);
		this.armLftForearmJoint.setRotationPoint(1.5F, 0.0F, -5.6F);
		this.armLftForearmJoint.addBox(-1.9F, -2.0F, -7.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftForearmJoint, 1.0471975511965976F, 0.0F, 0.0F);
		armLftForearmJointInfo = new PartInfo(armLftForearmJoint);
		this.armLftForearm = new ModelRenderer(this, 18, 44);
		this.armLftForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftForearm.addBox(-1.9F, -2.0F, -7.5F, 4, 4, 8, 0.0F);
		armLftForearmInfo = new PartInfo(armLftForearm);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -9.2F, -0.8F);
		this.headJoint.addBox(-4.0F, -5.0F, -2.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, -0.7853981633974483F, 0.0F, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-4.0F, -5.0F, -2.0F, 8, 8, 4, 0.0F);
		this.head.setTextureOffset(25, 0).addBox(-4.0F, -5.0F, -4.0F, 8, 4, 2, 0.0F); // headFaceTop
		this.head.setTextureOffset(25, 8).addBox(-4.0F, -1.0F, -4.0F, 1, 3, 2, 0.0F); // headMouthRt
		this.head.setTextureOffset(39, 8).addBox(3.0F, -1.0F, -4.0F, 1, 3, 2, 0.0F); // headMouthLft
		this.head.setTextureOffset(26, 16).addBox(-4.0F, 2.0F, -4.0F, 8, 1, 2, 0.0F); // headJaw
		this.head.setTextureOffset(29, 12).addBox(-2.0F, 1.0F, -4.0F, 4, 1, 2, 0.0F); // headMouthLipLower
		this.head.setTextureOffset(30, 7).addBox(-1.5F, 0.0F, -4.0F, 3, 1, 2, 0.0F); // headMouthLipUpper
		this.head.setTextureOffset(45, 6).addBox(-1.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F); // headNose
		headInfo = new PartInfo(head);

		this.headHairRt1 = new ModelRenderer(this, 0, 17);
		this.headHairRt1.setRotationPoint(-2.0F, -4.0F, -4.0F);
		this.headHairRt1.addBox(-5.0F, -1.0F, -0.5F, 6, 2, 1, 0.0F);
		this.setRotateAngle(headHairRt1, 0.0F, 0.0F, 0.5235987755982988F);
		headHairRt1Info = new PartInfo(headHairRt1);
		this.headHairRt2 = new ModelRenderer(this, 0, 13);
		this.headHairRt2.setRotationPoint(-4.0F, -1.0F, 0.0F);
		this.headHairRt2.addBox(-5.0F, -1.0F, -0.45F, 6, 2, 1, 0.0F);
		this.setRotateAngle(headHairRt2, 0.0F, 0.0F, 1.5481070465189704F);
		headHairRt2Info = new PartInfo(headHairRt2);
		this.headHairLft1 = new ModelRenderer(this, 18, 24);
		this.headHairLft1.setRotationPoint(2.0F, -4.0F, -4.01F);
		this.headHairLft1.addBox(-1.0F, -1.0F, -0.5F, 6, 2, 1, 0.0F);
		this.setRotateAngle(headHairLft1, 0.0F, 0.0F, -0.5235987755982988F);
		headHairLft1Info = new PartInfo(headHairLft1);
		this.headHairLft2 = new ModelRenderer(this, 18, 20);
		this.headHairLft2.setRotationPoint(4.0F, -1.0F, 0.0F);
		this.headHairLft2.addBox(-5.0F, -1.0F, -0.45F, 6, 2, 1, 0.0F);
		this.setRotateAngle(headHairLft2, 0.0F, 0.0F, 1.5481070465189704F);
		headHairLft2Info = new PartInfo(headHairLft2);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 26, 58); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.5F, 3.2F);
		this.tail[tailNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.7853981633974483F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 26, 58); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 37, 57); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.4F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 37, 57); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.4F, 2, 2, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		this.armLftJoint.addChild(this.armLft);
		this.armLft.addChild(this.armLftForearmJoint);
		this.armLftForearmJoint.addChild(this.armLftForearm);

		this.armRtJoint.addChild(this.armRt);
		this.armRt.addChild(this.armRtForearmJoint);
		this.armRtForearmJoint.addChild(this.armRtForearm);

		this.body.addChild(this.armLftJoint);
		this.body.addChild(this.armRtJoint);
		this.body.addChild(this.headJoint);
		this.body.addChild(this.legLft);
		this.body.addChild(this.legRt);
		this.body.addChild(this.tail[0][0]); // tail1Joint

		this.headJoint.addChild(this.head);
		this.head.addChild(this.headHairLft1);
		this.head.addChild(this.headHairRt1);

		this.headHairLft1.addChild(this.headHairLft2);
		this.headHairRt1.addChild(this.headHairRt2);

		this.tail[0][0].addChild(this.tail[0][1]); // tailBaseJoint * tailBase
		this.tail[0][1].addChild(this.tail[1][0]); // tailBase * tailEndJoint
		this.tail[1][0].addChild(this.tail[1][1]); // tailEndJoint * tailEnd

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

		animateBody((EntityScrubbyDarmanitan)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityScrubbyDarmanitan)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateArms((EntityScrubbyDarmanitan)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityScrubbyDarmanitan)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityScrubbyDarmanitan)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		legRtInfo.resetNewAngles();
		legLftInfo.resetNewAngles();

		headHairRt1Info.resetNewAngles();
		headHairRt2Info.resetNewAngles();
		headHairLft1Info.resetNewAngles();
		headHairLft2Info.resetNewAngles();

		armRtJointInfo.resetNewAngles();
		armRtInfo.resetNewAngles();
		armRtForearmJointInfo.resetNewAngles();
		armRtForearmInfo.resetNewAngles();
		armLftJointInfo.resetNewAngles();
		armLftInfo.resetNewAngles();
		armLftForearmJointInfo.resetNewAngles();
		armLftForearmInfo.resetNewAngles();

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}

	public void animateBody(EntityScrubbyDarmanitan entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBody();

		float moveFrequency = 1.2F;
		float moveAmplitude = 0.2F;

		float idleFrequencyX = 1F;
		float idleAmplitudeX = 0.1F;

		float newAngleX = MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 * idleFrequencyX) * idleAmplitudeX;

		bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + newAngleX + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude));
	}

	public void animateHead(EntityScrubbyDarmanitan entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.6F, 0.6F);

		/* **************** Head Hairs *********** */
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBody();

		float moveFrequency = 1.2F;
		float moveAmplitude = 0.2F;

		float idleFrequencyZ = 1F;
		float idleAmplitudeZ = 0.1F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = 0;

		angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 * idleFrequencyZ + PI) * idleAmplitudeZ;
		angleChangeZ += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);

		float newAngleZ = headHairLft1Info.getNewRotateZ() - angleChangeZ;
		headHairLft1Info.setNewRotateZ(newAngleZ);

		newAngleZ = headHairRt1Info.getNewRotateZ() + angleChangeZ;
		headHairRt1Info.setNewRotateZ(newAngleZ);

		idleFrequencyZ = 1F;
		idleAmplitudeZ = 0.3F;

		angleChangeZ = 0;

		angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 * idleFrequencyZ + (3*PI)/2) * idleAmplitudeZ;
		angleChangeZ += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);

		newAngleZ = headHairLft2Info.getNewRotateZ() - angleChangeZ;
		headHairLft2Info.setNewRotateZ(newAngleZ);

		newAngleZ = headHairRt2Info.getNewRotateZ() + angleChangeZ;
		headHairRt2Info.setNewRotateZ(newAngleZ);
	}

	public void animateArms(EntityScrubbyDarmanitan entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float moveFrequency = 1.2F;
		float moveAmplitude = 0.3F;

		JointAnimation.reverseJointRotatesChangeXWithModifier(bodyInfo, armRtJointInfo, 1.5F);
		JointAnimation.reverseJointRotatesChangeXWithModifier(bodyInfo, armLftJointInfo, 1.5F);

		JointAnimation.reverseJointRotatesChangeXWithModifier(armRtJointInfo, armRtForearmInfo, 1.1F);
		JointAnimation.reverseJointRotatesChangeXWithModifier(armLftJointInfo, armLftForearmInfo, 1.1F);
		
		armRtInfo.setNewRotateX(armRtInfo.getNewRotateX() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude));
		armRtForearmInfo.setNewRotateX(armRtForearmInfo.getNewRotateX() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude));
		armLftInfo.setNewRotateX(armLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude));
		armLftForearmInfo.setNewRotateX(armLftForearmInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude));
	}

	public void animateLegs(EntityScrubbyDarmanitan entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float frequency = 1.0F;
		float amplitude = 0.7F;

		JointAnimation.reverseJointRotatesChange(bodyInfo, legRtInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legLftInfo);
		
		this.legRt.rotateAngleX = legRtInfo.getNewRotateX() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
		this.legLft.rotateAngleX = legLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
	}

	public void animateTail(EntityScrubbyDarmanitan entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float amplitudeX = 0.30F;
			float amplitudeY = 0.35F;

			float moveFrequency = 1F;
			float moveAmplitude = 0.2F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * amplitudeX
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * amplitudeY;

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(armRtJoint, armRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());
		this.animationDeployer.rotate(armRtForearmJoint, armRtForearmJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRtForearm, armRtForearmInfo.getNewRotates());
		
		this.animationDeployer.rotate(armLftJoint, armLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armLftForearmJoint, armLftForearmJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLftForearm, armLftForearmInfo.getNewRotates());

		this.animationDeployer.rotate(headHairRt1, headHairRt1Info.getNewRotates());
		this.animationDeployer.rotate(headHairRt2, headHairRt2Info.getNewRotates());
		this.animationDeployer.rotate(headHairLft1, headHairLft1Info.getNewRotates());
		this.animationDeployer.rotate(headHairLft2, headHairLft2Info.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}