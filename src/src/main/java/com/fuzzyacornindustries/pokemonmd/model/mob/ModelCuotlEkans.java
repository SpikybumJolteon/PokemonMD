package com.fuzzyacornindustries.pokemonmd.model.mob;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityCuotlEkans;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCuotlEkans extends ModelBase 
{
	Random rand = new Random();

	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer head;
	public ModelRenderer jaw;
	PartInfo headInfo;
	PartInfo jawInfo;

	public ModelRenderer headDynamoPntJoint;
	public ModelRenderer headDynamoPnt;
	PartInfo headDynamoPntJointInfo;
	PartInfo headDynamoPntInfo;

	public ModelRenderer dynamoJoint;
	public ModelRenderer dynamoInner;
	public ModelRenderer dynamoOuter;
	PartInfo dynamoJointInfo;
	PartInfo dynamoInnerInfo;
	PartInfo dynamoOuterInfo;

	public ModelRenderer dynamoRotateFntPntJoint;
	public ModelRenderer dynamoRotateFntPnt;
	PartInfo dynamoRotateFntPntJointInfo;
	PartInfo dynamoRotateFntPntInfo;

	public ModelRenderer rotateSetFntJoint;
	public ModelRenderer rotateSetFnt;
	PartInfo rotateSetFntJointInfo;
	PartInfo rotateSetFntInfo;

	public ModelRenderer rotateFntRotateBckPntJoint;
	public ModelRenderer rotateFntRotateBckPnt;
	PartInfo rotateFntRotateBckPntJointInfo;
	PartInfo rotateFntRotateBckPntInfo;

	public ModelRenderer rotateSetBckJoint;
	public ModelRenderer rotateSetBck;
	PartInfo rotateSetBckJointInfo;
	PartInfo rotateSetBckInfo;

	public ModelRenderer rotateSetBckTailPntJoint;
	public ModelRenderer rotateSetBckTailPnt;
	PartInfo rotateSetBckTailPntJointInfo;
	PartInfo rotateSetBckTailPntInfo;

	public ModelRenderer tail[][] = new ModelRenderer[5][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelCuotlEkans() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		int jointNumber = 0;
		int partNumber = 1;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 19.0F, -12.0F);
		this.head.addBox(-1.5F, -2.5F, 4.0F, 3, 2, 3, 0.0F);
		this.head.setTextureOffset(2, 6).addBox(-1.0F, -1.5F, 2.0F, 2, 1, 2, 0.0F); // muzzle
		this.head.setTextureOffset(3, 10).addBox(-1.0F, -0.5F, 2.0F, 2, 1, 1, 0.0F); // fangs
		headInfo = new PartInfo(head);
		this.jaw = new ModelRenderer(this, 1, 13);
		this.jaw.setRotationPoint(0.0F, 0.3F, 6.0F);
		this.jaw.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(jaw, 0.5651376117957639F, -0.0F, 0.0F);
		jawInfo = new PartInfo(jaw);

		this.headDynamoPntJoint = new ModelRenderer(this, 0, 0);
		this.headDynamoPntJoint.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.headDynamoPntJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		headDynamoPntJointInfo = new PartInfo(headDynamoPntJoint);
		this.headDynamoPnt = new ModelRenderer(this, 0, 0);
		this.headDynamoPnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headDynamoPnt.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		headDynamoPntInfo = new PartInfo(headDynamoPnt);

		this.dynamoJoint = new ModelRenderer(this, 37, 0);
		this.dynamoJoint.setRotationPoint(0.0F, 0.0F, 3.5F);
		this.dynamoJoint.addBox(-0.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		dynamoJointInfo = new PartInfo(dynamoJoint);
		this.dynamoInner = new ModelRenderer(this, 37, 0); // dynamoInnerN
		this.dynamoInner.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.dynamoInner.addBox(-0.5F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
		this.dynamoInner.setTextureOffset(40, 3).addBox(-0.5F, -0.5F, 0.3F, 1, 1, 1, 0.0F); // dynamoInnerE
		this.dynamoInner.setTextureOffset(37, 6).addBox(-0.5F, 0.5F, -0.5F, 1, 1, 1, 0.0F); // dynamoInnerS
		this.dynamoInner.setTextureOffset(34, 3).addBox(-0.5F, -0.5F, -1.3F, 1, 1, 1, 0.0F); // dynamoInnerW
		dynamoInnerInfo = new PartInfo(dynamoInner);

		this.dynamoOuter = new ModelRenderer(this, 47, 0); // dynamoOuterN
		this.dynamoOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.dynamoOuter.addBox(-0.5F, -2.7F, -1.0F, 1, 1, 2, 0.0F);
		this.dynamoOuter.setTextureOffset(51, 4).addBox(-0.5F, -2.0F, 1.0F, 1, 1, 1, 0.0F); // dynamoOuterNE
		this.dynamoOuter.setTextureOffset(51, 7).addBox(-0.5F, -1.0F, 1.7F, 1, 2, 1, 0.0F); // dynamoOuterE
		this.dynamoOuter.setTextureOffset(51, 11).addBox(-0.5F, 1.0F, 1.0F, 1, 1, 1, 0.0F); // dynamoOuterSE
		this.dynamoOuter.setTextureOffset(47, 14).addBox(-0.5F, 1.7F, -1.0F, 1, 1, 2, 0.0F); // dynamoOuterS
		this.dynamoOuter.setTextureOffset(45, 11).addBox(-0.5F, 1.0F, -2.0F, 1, 1, 1, 0.0F); // dynamoOuterSW
		this.dynamoOuter.setTextureOffset(45, 7).addBox(-0.5F, -1.0F, -2.7F, 1, 2, 1, 0.0F); // dynamoOuterW
		this.dynamoOuter.setTextureOffset(45, 4).addBox(-0.5F, -2.0F, -2.0F, 1, 1, 1, 0.0F); // dynamoOuterNW
		dynamoOuterInfo = new PartInfo(dynamoOuter);

		this.dynamoRotateFntPntJoint = new ModelRenderer(this, 0, 0);
		this.dynamoRotateFntPntJoint.setRotationPoint(0.0F, 0.0F, 2.5F);
		this.dynamoRotateFntPntJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		dynamoRotateFntPntJointInfo = new PartInfo(dynamoRotateFntPntJoint);
		this.dynamoRotateFntPnt = new ModelRenderer(this, 0, 0);
		this.dynamoRotateFntPnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.dynamoRotateFntPnt.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		dynamoRotateFntPntInfo = new PartInfo(dynamoRotateFntPnt);

		this.rotateSetFntJoint = new ModelRenderer(this, 24, 18);
		this.rotateSetFntJoint.setRotationPoint(0.0F, 0.0F, 2.5F);
		this.rotateSetFntJoint.addBox(-0.5F, -2.0F, -1.5F, 0, 0, 0, 0.0F);
		rotateSetFntJointInfo = new PartInfo(rotateSetFntJoint);
		this.rotateSetFnt = new ModelRenderer(this, 24, 18); // rotateSetFntTop
		this.rotateSetFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rotateSetFnt.addBox(-0.5F, -2.0F, -1.5F, 1, 1, 3, 0.0F);
		this.rotateSetFnt.setTextureOffset(29, 23).addBox(1.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F); // rotateSetFntLft
		this.rotateSetFnt.setTextureOffset(24, 28).addBox(-0.5F, 1.0F, -1.5F, 1, 1, 3, 0.0F); // rotateSetFntBot
		this.rotateSetFnt.setTextureOffset(19, 23).addBox(-2.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F); // rotateSetFntRt
		rotateSetFntInfo = new PartInfo(rotateSetFnt);

		this.rotateFntRotateBckPntJoint = new ModelRenderer(this, 0, 0);
		this.rotateFntRotateBckPntJoint.setRotationPoint(0.0F, 0.0F, 2.2F);
		this.rotateFntRotateBckPntJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		rotateFntRotateBckPntJointInfo = new PartInfo(rotateFntRotateBckPntJoint);
		this.rotateFntRotateBckPnt = new ModelRenderer(this, 0, 0);
		this.rotateFntRotateBckPnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rotateFntRotateBckPnt.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		rotateFntRotateBckPntInfo = new PartInfo(rotateFntRotateBckPnt);

		this.rotateSetBckJoint = new ModelRenderer(this, 43, 18);
		this.rotateSetBckJoint.setRotationPoint(0.0F, 0.0F, 2.3F);
		this.rotateSetBckJoint.addBox(-0.5F, -2.0F, -1.5F, 0, 0, 0, 0.0F);
		rotateSetBckJointInfo = new PartInfo(rotateSetBckJoint);
		this.rotateSetBck = new ModelRenderer(this, 43, 18); // rotateSetBckTop
		this.rotateSetBck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rotateSetBck.addBox(-0.5F, -2.0F, -1.5F, 1, 1, 3, 0.0F);
		this.rotateSetBck.setTextureOffset(48, 23).addBox(1.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F); // rotateSetBckLft
		this.rotateSetBck.setTextureOffset(43, 28).addBox(-0.5F, 1.0F, -1.5F, 1, 1, 3, 0.0F); // rotateSetBckBot
		this.rotateSetBck.setTextureOffset(38, 23).addBox(-2.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F); // rotateSetBckRt
		rotateSetBckInfo = new PartInfo(rotateSetBck);

		this.rotateSetBckTailPntJoint = new ModelRenderer(this, 0, 0);
		this.rotateSetBckTailPntJoint.setRotationPoint(0.0F, 0.0F, 1.9F);
		this.rotateSetBckTailPntJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		rotateSetBckTailPntJointInfo = new PartInfo(rotateSetBckTailPntJoint);
		this.rotateSetBckTailPnt = new ModelRenderer(this, 0, 0);
		this.rotateSetBckTailPnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rotateSetBckTailPnt.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		rotateSetBckTailPntInfo = new PartInfo(rotateSetBckTailPnt);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 56, 11); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, 0.0F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 56, 11); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 56, 16); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.3F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 56, 16); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 57, 21); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.5F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 57, 21); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 57, 25); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 57, 25); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 57, 29); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 57, 29); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		this.head.addChild(this.headDynamoPntJoint);
		this.head.addChild(this.jaw);

		this.headDynamoPntJoint.addChild(this.headDynamoPnt);
		this.headDynamoPnt.addChild(this.dynamoJoint);

		this.dynamoJoint.addChild(this.dynamoInner);
		this.dynamoJoint.addChild(this.dynamoOuter);

		this.dynamoJoint.addChild(this.dynamoRotateFntPntJoint);

		this.dynamoRotateFntPntJoint.addChild(this.dynamoRotateFntPnt);
		this.dynamoRotateFntPnt.addChild(this.rotateSetFntJoint);

		this.rotateSetFntJoint.addChild(this.rotateSetFnt);
		this.rotateSetFntJoint.addChild(this.rotateFntRotateBckPntJoint);

		this.rotateFntRotateBckPntJoint.addChild(this.rotateFntRotateBckPnt);
		this.rotateFntRotateBckPnt.addChild(this.rotateSetBckJoint);

		this.rotateSetBckJoint.addChild(this.rotateSetBck);
		this.rotateSetBckJoint.addChild(this.rotateSetBckTailPntJoint);

		this.rotateSetBckTailPntJoint.addChild(this.rotateSetBckTailPnt);
		this.rotateSetBckTailPnt.addChild(this.tail[0][0]);

		this.tail[0][0].addChild(this.tail[0][1]); // tail1Joint * tail1
		this.tail[0][1].addChild(this.tail[1][0]); // tail1 * tail2Joint
		this.tail[1][0].addChild(this.tail[1][1]); // tail2Joint * tail2
		this.tail[1][1].addChild(this.tail[2][0]); // tail2 * tail3Joint
		this.tail[2][0].addChild(this.tail[2][1]); // tail3Joint * tail3
		this.tail[2][1].addChild(this.tail[3][0]); // tail3 * tail4Joint
		this.tail[3][0].addChild(this.tail[3][1]); // tail4Joint * tail4
		this.tail[3][1].addChild(this.tail[4][0]); // tail4 * tail5Joint
		this.tail[4][0].addChild(this.tail[4][1]); // tail5Joint * tail5

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{ 
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		this.head.render(modelSize);
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

		animateJaw((EntityCuotlEkans)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateBody((EntityCuotlEkans)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityCuotlEkans)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateDynamos((EntityCuotlEkans)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateRotateRods((EntityCuotlEkans)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		headInfo.resetNewAngles();
		jawInfo.resetNewAngles();

		headDynamoPntJointInfo.resetNewAngles();
		headDynamoPntInfo.resetNewAngles();

		dynamoJointInfo.resetNewAngles();
		dynamoInnerInfo.resetNewAngles();
		dynamoOuterInfo.resetNewAngles();

		dynamoRotateFntPntJointInfo.resetNewAngles();
		dynamoRotateFntPntInfo.resetNewAngles();

		rotateSetFntJointInfo.resetNewAngles();
		rotateSetFntInfo.resetNewAngles();

		rotateFntRotateBckPntJointInfo.resetNewAngles();
		rotateFntRotateBckPntInfo.resetNewAngles();

		rotateSetBckJointInfo.resetNewAngles();
		rotateSetBckInfo.resetNewAngles();

		rotateSetBckTailPntJointInfo.resetNewAngles();
		rotateSetBckTailPntInfo.resetNewAngles();

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}

	public void animateJaw(EntityCuotlEkans entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockJaw();

		float idleAmplitudeX = 0.2F;

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;

		if(currentIdleAnimationClock.getPhaseDurationCoveredX(0) < 1F)
		{
			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;
		}
		else if(currentIdleAnimationClock.getPhaseDurationCoveredX(1) < 1F)
		{
			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(1) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;
		}
		else
		{
		}

		jawInfo.setNewRotateX(jawInfo.getNewRotateX() + angleChangeX);
	}
	
	public void animateDynamos(EntityCuotlEkans entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockDynamo(0);

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = 0;
		float angleChangeZ = 0;

		dynamoOuterInfo.setNewRotateX(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2);
		dynamoOuterInfo.setNewRotateY(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2);
		dynamoOuterInfo.setNewRotateZ(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2);
		
		currentIdleAnimationClock = entity.getIdleAnimationClockDynamo(1);

		dynamoInnerInfo.setNewRotateX(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2);
		dynamoInnerInfo.setNewRotateY(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2);
		dynamoInnerInfo.setNewRotateZ(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2);
	}

	public void animateBody(EntityCuotlEkans entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		int i = 0;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), headInfo, i);
		i++;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), headDynamoPntInfo, i);
		i++;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), dynamoOuterInfo, i);
		i++;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), dynamoRotateFntPntInfo, i);
		i++;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), rotateSetFntInfo, i);
		i++;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), rotateFntRotateBckPntInfo, i);
		i++;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), rotateSetBckInfo, i);
		i++;
		applyIdleBodyAnimation(entity.getIdleAnimationClockBody(i), rotateSetBckTailPntInfo, i);
	}
	
	public void applyIdleBodyAnimation(IdleAnimationClock currentIdleAnimationClock, PartInfo partInfo, int partNumber)
	{
		float idleAmplitudeX = 0.15F;
		float idleAmplitudeY = 0.28F;

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = 0;

		angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX * 
				( 1 - (Math.pow(Math.E, -0.4F * (float)(partNumber + 1))));
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY * 
				( 1 - (Math.pow(Math.E, -0.4F * (float)(partNumber + 1))));

		partInfo.setNewRotateX(partInfo.getNewRotateX() + angleChangeX);
		partInfo.setNewRotateY(partInfo.getNewRotateY() + angleChangeY);
	}

	public void animateRotateRods(EntityCuotlEkans entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockRotateRods();

		rotateSetFntInfo.setNewRotateZ(rotateSetFntInfo.getNewRotateZ() - (float)(2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredZ(0)));

		rotateSetBckInfo.setNewRotateZ(rotateSetBckInfo.getNewRotateZ() + (float)(2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredZ(0)));
	}

	public void animateTail(EntityCuotlEkans entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		
		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBody(i + 8);

			float idleAmplitudeX = 0.15F;
			float idleAmplitudeY = 0.28F;

			float moveFrequency = 0.5F;
			float moveAmplitude = 0.1F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY;

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}
		
		for(int i = 2; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockRattle();

			float idleAmplitudeX = 0.05F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX * 
					( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1 - 7))));

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
		}		
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(head, headInfo.getNewRotates());
		this.animationDeployer.rotate(jaw, jawInfo.getNewRotates());

		this.animationDeployer.rotate(headDynamoPntJoint, headDynamoPntJointInfo.getNewRotates());
		this.animationDeployer.rotate(headDynamoPnt, headDynamoPntInfo.getNewRotates());

		this.animationDeployer.rotate(dynamoJoint, dynamoJointInfo.getNewRotates());
		this.animationDeployer.rotate(dynamoInner, dynamoInnerInfo.getNewRotates());
		this.animationDeployer.rotate(dynamoOuter, dynamoOuterInfo.getNewRotates());

		this.animationDeployer.rotate(dynamoRotateFntPntJoint, dynamoRotateFntPntJointInfo.getNewRotates());
		this.animationDeployer.rotate(dynamoRotateFntPnt, dynamoRotateFntPntInfo.getNewRotates());

		this.animationDeployer.rotate(rotateSetFntJoint, rotateSetFntJointInfo.getNewRotates());
		this.animationDeployer.rotate(rotateSetFnt, rotateSetFntInfo.getNewRotates());

		this.animationDeployer.rotate(rotateFntRotateBckPntJoint, rotateFntRotateBckPntJointInfo.getNewRotates());
		this.animationDeployer.rotate(rotateFntRotateBckPnt, rotateFntRotateBckPntInfo.getNewRotates());

		this.animationDeployer.rotate(rotateSetBckJoint, rotateSetBckJointInfo.getNewRotates());
		this.animationDeployer.rotate(rotateSetBck, rotateSetBckInfo.getNewRotates());

		this.animationDeployer.rotate(rotateSetBckTailPntJoint, rotateSetBckTailPntJointInfo.getNewRotates());
		this.animationDeployer.rotate(rotateSetBckTailPnt, rotateSetBckTailPntInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}