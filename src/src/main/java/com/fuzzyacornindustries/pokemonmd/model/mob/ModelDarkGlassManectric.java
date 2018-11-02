package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDarkGlassManectric;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDarkGlassManectric extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 1.1F;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer legFntLft;
	public ModelRenderer legFntRt;
	PartInfo legFntLftInfo;
	PartInfo legFntRtInfo;

	public ModelRenderer legBckRtJoint;
	PartInfo legBckRtJointInfo;
	public ModelRenderer legBckRt;
	public ModelRenderer legBckRtTipFnt;
	public ModelRenderer legBckRtTopMid;
	public ModelRenderer legBckRtTipBck;

	public ModelRenderer legBckLftJoint;
	PartInfo legBckLftJointInfo;
	public ModelRenderer legBckLft;
	public ModelRenderer legBckLftTipFnt;
	public ModelRenderer legBckLftTopMid;
	public ModelRenderer legBckLftTipBck;

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	PartInfo neckJointInfo;
	PartInfo neckInfo;

	public ModelRenderer headFaceJoint;
	public ModelRenderer headFace;
	public ModelRenderer head;
	public ModelRenderer headMuzzle;
	PartInfo headFaceJointInfo;
	PartInfo headFaceInfo;

	public ModelRenderer headSpikeLftBase;
	public ModelRenderer headSpikeMidBase;
	public ModelRenderer headSpikeRtBase;

	public ModelRenderer tail[][] = new ModelRenderer[2][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelDarkGlassManectric() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 13, 0);
		this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.body.addBox(-2.5F, -3.0F, -5.0F, 5, 6, 10, 0.0F);
		bodyInfo = new PartInfo(body);

		this.legFntLft = new ModelRenderer(this, 11, 37);
		this.legFntLft.setRotationPoint(1.3F, 2.5F, -3.0F);
		this.legFntLft.addBox(-1.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
		this.legFntLft.setTextureOffset(9, 46).addBox(-1.2F, 3.0F, -1.5F, 3, 3, 3, 0.0F); // legFntLftWristGlass
		legFntLftInfo = new PartInfo(legFntLft);
		this.legFntRt = new ModelRenderer(this, 24, 37);
		this.legFntRt.setRotationPoint(-1.3F, 2.5F, -3.0F);
		this.legFntRt.addBox(-1.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
		this.legFntRt.setTextureOffset(22, 46).addBox(-1.8F, 3.0F, -1.5F, 3, 3, 3, 0.0F); // legFntRtWristGlass
		legFntRtInfo = new PartInfo(legFntRt);

		this.legBckRtJoint = new ModelRenderer(this, 53, 57);
		this.legBckRtJoint.setRotationPoint(-1.3F, 2.5F, 3.0F);
		this.legBckRtJoint.addBox(-1.0F, 1.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRtJoint, -0.20943951023931953F, 0.0F, 0.0F);
		legBckRtJointInfo = new PartInfo(legBckRtJoint);
		this.legBckRt = new ModelRenderer(this, 53, 57); // legBckRtBot
		this.legBckRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRt.addBox(-1.0F, 1.5F, 0.0F, 2, 5, 2, 0.0F);
		this.legBckRt.setTextureOffset(50, 51).addBox(-1.5F, 0.5F, -2.5F, 3, 2, 4, 0.0F); // legBckRtBotMid
		this.legBckRt.setTextureOffset(50, 42).addBox(-1.5F, -3.5F, -3.0F, 2, 4, 5, 0.0F); // legBckRtMid
		this.legBckRt.setTextureOffset(51, 36).addBox(-1.6F, -5.5F, -2.5F, 2, 2, 4, 0.0F); // legBckRtMidTop
		this.legBckRtTipFnt = new ModelRenderer(this, 50, 31);
		this.legBckRtTipFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRtTipFnt.addBox(-1.4F, -7.0F, -2.2F, 1, 4, 1, 0.0F);
		this.setRotateAngle(legBckRtTipFnt, 0.20943951023931953F, 0.0F, 0.0F);
		this.legBckRtTopMid = new ModelRenderer(this, 54, 32);
		this.legBckRtTopMid.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRtTopMid.addBox(-1.3F, -6.5F, -1.7F, 1, 2, 2, 0.0F);
		this.setRotateAngle(legBckRtTopMid, -0.05235987755982988F, 0.0F, 0.0F);
		this.legBckRtTopMid.setTextureOffset(55, 28).addBox(-1.4F, -8.4F, -1.2F, 1, 3, 1, 0.0F); // legBckRtTipMid
		this.legBckRtTipBck = new ModelRenderer(this, 60, 32);
		this.legBckRtTipBck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRtTipBck.addBox(-1.4F, -6.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(legBckRtTipBck, -0.4886921905584123F, 0.0F, 0.0F);

		this.legBckLftJoint = new ModelRenderer(this, 38, 57);
		this.legBckLftJoint.setRotationPoint(1.3F, 2.5F, 3.0F);
		this.legBckLftJoint.addBox(-1.0F, 1.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckLftJoint, -0.20943951023931953F, -0.0F, 0.0F);
		legBckLftJointInfo = new PartInfo(legBckLftJoint);
		this.legBckLft = new ModelRenderer(this, 38, 57); // legBckLftBot
		this.legBckLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLft.addBox(-1.0F, 1.5F, 0.0F, 2, 5, 2, 0.0F);
		this.legBckLft.setTextureOffset(35, 51).addBox(-1.5F, 0.5F, -2.5F, 3, 2, 4, 0.0F); // legBckLftBotMid
		this.legBckLft.setTextureOffset(35, 42).addBox(-0.5F, -3.5F, -3.0F, 2, 4, 5, 0.0F); // legBckLftMid
		this.legBckLft.setTextureOffset(36, 36).addBox(-0.43F, -5.5F, -2.5F, 2, 2, 4, 0.0F); // legBckLftMidTop
		this.legBckLftTipFnt = new ModelRenderer(this, 35, 31);
		this.legBckLftTipFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLftTipFnt.addBox(0.4F, -7.0F, -2.2F, 1, 4, 1, 0.0F);
		this.setRotateAngle(legBckLftTipFnt, 0.20943951023931953F, 0.0F, 0.0F);
		this.legBckLftTopMid = new ModelRenderer(this, 39, 32);
		this.legBckLftTopMid.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLftTopMid.addBox(0.3F, -6.5F, -1.7F, 1, 2, 2, 0.0F);
		this.setRotateAngle(legBckLftTopMid, -0.05235987755982988F, 0.0F, 0.0F);
		this.legBckLftTopMid.setTextureOffset(40, 28).addBox(0.4F, -8.4F, -1.2F, 1, 3, 1, 0.0F); // legBckLftTipMid
		this.legBckLftTipBck = new ModelRenderer(this, 45, 32);
		this.legBckLftTipBck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLftTipBck.addBox(0.4F, -6.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(legBckLftTipBck, -0.4886921905584123F, 0.0F, 0.0F);

		this.neckJoint = new ModelRenderer(this, 14, 17);
		this.neckJoint.setRotationPoint(0.0F, -1.8F, -3.8F);
		this.neckJoint.addBox(-2.0F, -3.5F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, 0.7853981633974483F, 0.0F, 0.0F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 14, 17);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-2.0F, -3.5F, -1.5F, 4, 4, 3, 0.0F);
		neckInfo = new PartInfo(neck);

		this.headFaceJoint = new ModelRenderer(this, 0, 10);
		this.headFaceJoint.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.headFaceJoint.addBox(-2.0F, -2.8F, -4.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headFaceJoint, -0.7853981633974483F, 0.0F, 0.0F);
		headFaceJointInfo = new PartInfo(headFaceJoint);
		this.headFace = new ModelRenderer(this, 0, 10);
		this.headFace.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFace.addBox(-2.0F, -2.8F, -4.2F, 4, 3, 2, 0.0F);
		headFaceInfo = new PartInfo(headFace);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.5F, -3.5F, -3.5F, 5, 4, 5, 0.0F);
		this.setRotateAngle(head, 0.17453292519943295F, -0.0F, 0.0F);
		this.headMuzzle= new ModelRenderer(this, 0, 16); // headMuzzleBase
		this.headMuzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headMuzzle.addBox(-1.5F, -1.5F, -5.5F, 3, 2, 2, 0.0F);
		this.setRotateAngle(headMuzzle, 0.17453292519943295F, -0.0F, 0.0F);
		this.headMuzzle.setTextureOffset(0, 21).addBox(-1.0F, -1.4F, -6.5F, 2, 1, 1, 0.0F); // headMuzzleMid
		this.headMuzzle.setTextureOffset(7, 21).addBox(-0.5F, -1.3F, -7.0F, 1, 1, 2, 0.0F); // headMuzzleEnd

		this.headSpikeLftBase = new ModelRenderer(this, 0, 28);
		this.headSpikeLftBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headSpikeLftBase.addBox(0.4F, -5.4F, -2.3F, 2, 3, 2, 0.0F);
		this.setRotateAngle(headSpikeLftBase, -0.2617993877991494F, 0.0F, 0.0F);
		this.headSpikeLftBase.setTextureOffset(2, 25).addBox(1.1F, -6.9F, -1.8F, 1, 2, 1, 0.0F); // headSpikeLftTip
		this.headSpikeMidBase = new ModelRenderer(this, 9, 29);
		this.headSpikeMidBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headSpikeMidBase.addBox(-1.0F, -6.4F, -2.83F, 2, 4, 3, 0.0F);
		this.setRotateAngle(headSpikeMidBase, -0.2617993877991494F, -0.0F, 0.0F);
		this.headSpikeMidBase.setTextureOffset(11, 25).addBox(-0.5F, -8.4F, -2.3F, 1, 2, 2, 0.0F); // headSpikeMidTip
		this.headSpikeRtBase = new ModelRenderer(this, 20, 28);
		this.headSpikeRtBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headSpikeRtBase.addBox(-2.4F, -5.4F, -2.3F, 2, 3, 2, 0.0F);
		this.setRotateAngle(headSpikeRtBase, -0.2617993877991494F, 0.0F, 0.0F);
		this.headSpikeRtBase.setTextureOffset(22, 25).addBox(-2.1F, -6.9F, -1.8F, 1, 2, 1, 0.0F); // headSpikeRtTip

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 34, 0); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -1.5F, 4.0F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.3490658503988659F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 34, 0); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 45, 3); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.5F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 1.0471975511965976F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 45, 3); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 6, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		this.body.addChild(this.legBckLftJoint);
		this.body.addChild(this.legBckRtJoint);
		this.body.addChild(this.legFntLft);
		this.body.addChild(this.legFntRt);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.tail[0][0]);

		this.headFaceJoint.addChild(this.headFace);
		this.headFace.addChild(this.head);
		this.headFace.addChild(this.headMuzzle);

		this.headFace.addChild(this.headSpikeLftBase);
		this.headFace.addChild(this.headSpikeMidBase);
		this.headFace.addChild(this.headSpikeRtBase);
		this.legBckLftJoint.addChild(this.legBckLft);
		this.legBckLftJoint.addChild(this.legBckLftTipBck);
		this.legBckLftJoint.addChild(this.legBckLftTipFnt);
		this.legBckLftJoint.addChild(this.legBckLftTopMid);
		
		this.legBckRtJoint.addChild(this.legBckRt);
		this.legBckRtJoint.addChild(this.legBckRtTipBck);
		this.legBckRtJoint.addChild(this.legBckRtTipFnt);
		this.legBckRtJoint.addChild(this.legBckRtTopMid);

		this.neck.addChild(this.headFaceJoint);
		this.neckJoint.addChild(this.neck);

		this.tail[0][0].addChild(this.tail[0][1]); // tail1Joint * tail1
		this.tail[0][1].addChild(this.tail[1][0]); // tail1 * tail2Joint
		this.tail[1][0].addChild(this.tail[1][1]); // tail2Joint * tail2

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

		animateBody((EntityDarkGlassManectric)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityDarkGlassManectric)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityDarkGlassManectric)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityDarkGlassManectric)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headFaceJointInfo.resetNewAngles();
		headFaceInfo.resetNewAngles();

		legFntRtInfo.resetNewAngles();
		legFntLftInfo.resetNewAngles();
		legBckRtJointInfo.resetNewAngles();
		legBckLftJointInfo.resetNewAngles();

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}

	public void animateBody(EntityDarkGlassManectric entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.16F;

		bodyInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
	}

	public void animateHead(EntityDarkGlassManectric entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, neckJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckJointInfo, yawHeadOffsetDifference, pitchRotation, 0.2F, 0.2F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble();

		float idleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		float movementAmplitude = 0.2F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX);
		neckInfo.setNewRotateY(neckInfo.getNewRotateY());

		JointAnimation.reverseJointRotatesChange(neckInfo, headFaceJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headFaceInfo, yawHeadOffsetDifference, pitchRotation, 0.75F, 0.75F);
	}

	public void animateLegs(EntityDarkGlassManectric entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.8F;

		// Run constants
		float legFntRtModifierRun = 2F * PI * (1F/4F);
		float legBckRtModifierRun = 2F * PI * (5F/16F);
		float legBckLftModifierRun = 2F * PI * (8F/16F);

		// Walk constants
		float legFntRtModifierWalk = 2F * PI * (1F/2F);
		float legBckRtModifierWalk = 2F * PI * (3F/4F);
		float legBckLftModifierWalk = 2F * PI * (1F/4F);

		float legFntRtModifierDifference = legFntRtModifierRun - legFntRtModifierWalk;
		float legBckRtModifierDifference = legBckRtModifierRun - legBckRtModifierWalk;
		float legBckLftModifierDifference = legBckLftModifierRun - legBckLftModifierWalk;

		float legFntRtModifier;
		float legBckRtModifier;
		float legBckLftModifier;

		float sprint = 1.0F;
		float sneak = 0.35F;

		if(horzVelocity > sneak)
		{
			float modifier = (float)(1F - (Math.pow(Math.E, -5F * ((horzVelocity - sneak)/(sprint - sneak)))));
			legFntRtModifier = legFntRtModifierWalk + legFntRtModifierDifference * modifier;
			legBckRtModifier = legBckRtModifierWalk + legBckRtModifierDifference * modifier;
			legBckLftModifier = legBckLftModifierWalk + legBckLftModifierDifference * modifier;
		}
		else
		{
			legFntRtModifier = legFntRtModifierWalk;
			legBckRtModifier = legBckRtModifierWalk;
			legBckLftModifier = legBckLftModifierWalk;	
		}

		/**/
		JointAnimation.reverseJointRotatesChange(bodyInfo, legFntRtInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legFntLftInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckRtJointInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckLftJointInfo);

		//( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));

		legFntRtInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legFntRtModifier, horzVelocity, movementFrequency, amplitude));
		legFntLftInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
		legBckRtJointInfo.setNewRotateX(legBckRtJointInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckRtModifier, horzVelocity, movementFrequency, amplitude));
		legBckLftJointInfo.setNewRotateX(legBckLftJointInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckLftModifier, horzVelocity, movementFrequency, amplitude));
	}

	public void animateTail(EntityDarkGlassManectric entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = 0.2F;
			float idleAmplitudeY = 0.1F;

			float moveFrequency = 1F;
			float moveAmplitude = 0.2F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX;
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		
		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headFaceJoint, headFaceJointInfo.getNewRotates());
		this.animationDeployer.rotate(headFace, headFaceInfo.getNewRotates());

		this.animationDeployer.rotate(legFntRt, legFntRtInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legBckRtJoint, legBckRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(legBckLftJoint, legBckLftJointInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}