package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.IMobMotionTracker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZombieFlareon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZombieFlareon extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public final float RUN_FREQUENCY = 1.05F;
	public final float WALK_FREQUENCY = 1.2F;
	public final float SNEAK_VELOCITY = 0.35F;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer legFntLft;
	public ModelRenderer legFntRt;
	public ModelRenderer legBckLft;
	public ModelRenderer legBckRt;
	PartInfo legFntLftInfo;
	PartInfo legFntRtInfo;
	PartInfo legBckLftInfo;
	PartInfo legBckRtInfo;
	
	public ModelRenderer maneJoint;
	public ModelRenderer mane;
	PartInfo maneJointInfo;
	PartInfo maneInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headInfo;
	PartInfo headJointInfo;

	public ModelRenderer muzzle;
	PartInfo muzzleInfo;

	public ModelRenderer headTuff[][] = new ModelRenderer[4][2];
	PartInfo headTuffInfo[][] = new PartInfo[headTuff.length][headTuff[0].length];

	public ModelRenderer earLftJoint;
	public ModelRenderer earLft;
	PartInfo earLftJointInfo;
	PartInfo earLftInfo;

	public ModelRenderer earRtJoint;
	public ModelRenderer earRt;
	PartInfo earRtJointInfo;
	PartInfo earRtInfo;

	public ModelRenderer tail[][] = new ModelRenderer[5][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelZombieFlareon() 
	{	
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 40, 52);
		this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.body.addBox(-2.5F, -2.5F, -3.5F, 5, 5, 7, 0.0F);
		bodyInfo = new PartInfo(body);

		this.legFntLft = new ModelRenderer(this, 47, 0);
		this.legFntLft.setRotationPoint(1.4F, 2.0F, -2.0F);
		this.legFntLft.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		legFntLftInfo = new PartInfo(legFntLft);
		this.legFntRt = new ModelRenderer(this, 56, 0);
		this.legFntRt.setRotationPoint(-1.4F, 2.0F, -2.0F);
		this.legFntRt.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		legFntRtInfo = new PartInfo(legFntRt);
		this.legBckLft = new ModelRenderer(this, 47, 9);
		this.legBckLft.setRotationPoint(1.4F, 2.0F, 2.0F);
		this.legBckLft.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(legBckLft, -0.17453292519943295F, -0.0F, 0.0F);
		this.legBckLft.setTextureOffset(47, 16).addBox(-1.0F, 2.0F, 0.0F, 2, 3, 2, 0.0F); // legBckLftHind
		legBckLftInfo = new PartInfo(legBckLft);
		this.legBckRt = new ModelRenderer(this, 56, 9);
		this.legBckRt.setRotationPoint(-1.4F, 2.0F, 2.0F);
		this.legBckRt.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(legBckRt, -0.17453292519943295F, -0.0F, 0.0F);
		this.legBckRt.setTextureOffset(56, 16).addBox(-1.0F, 2.0F, 0.0F, 2, 3, 2, 0.0F); // legBckRtHind
		legBckRtInfo = new PartInfo(legBckRt);

		this.maneJoint = new ModelRenderer(this, 0, 0);
		this.maneJoint.setRotationPoint(0.0F, -1.5F, -3.0F);
		this.maneJoint.addBox(-2.0F, -3.0F, -3.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(maneJoint, 1.2217304763960306F, 0.0F, 0.0F);
		maneJointInfo = new PartInfo(maneJoint);
		this.mane = new ModelRenderer(this, 44, 32);
		this.mane.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.mane.addBox(-2.0F, -3.0F, -3.0F, 4, 4, 6, 0.0F);
		this.mane.setTextureOffset(42, 43).addBox(-3.5F, -2.7F, -2.0F, 7, 4, 4, 0.0F); // maneSides
		maneInfo = new PartInfo(mane);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.headJoint.addBox(-0.5F, -3.5F, -4.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, -1.2217304763960306F, 0.0F, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 30, 0); // headLft
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-0.5F, -3.5F, -4.5F, 3, 5, 5, 0.0F);
		this.head.setTextureOffset(36, 11).addBox(-2.5F, -3.5F, -2.5F, 2, 3, 3, 0.0F); // headRtBck
		this.head.setTextureOffset(20, 6).addBox(-2.5F, -0.5F, -4.5F, 2, 2, 5, 0.0F); // headRtFnt
		this.head.setTextureOffset(21, 0).addBox(-2.2F, -3.2F, -4.2F, 2, 3, 2, 0.0F); // headSkull
		headInfo = new PartInfo(head);

		this.muzzle = new ModelRenderer(this, 27, 14);
		this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muzzle.addBox(-1.0F, -1.9F, -5.2F, 2, 2, 2, 0.0F);
		this.setRotateAngle(muzzle, 0.3490658503988659F, -0.0F, 0.0F);
		this.muzzle.setTextureOffset(22, 14).addBox(-0.5F, -1.8F, -5.5F, 1, 1, 1, 0.0F); // nose
		muzzleInfo = new PartInfo(muzzle);

		int headTuffNumber = 0;
		this.headTuff[headTuffNumber][jointNumber] = new ModelRenderer(this, 0, 0); // headTuffBaseJoint
		this.headTuff[headTuffNumber][jointNumber].setRotationPoint(0.0F, -3.0F, -2.0F);
		this.headTuff[headTuffNumber][jointNumber].addBox(-1.0F, -1.2F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headTuff[headTuffNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		headTuffInfo[headTuffNumber][jointNumber] = new PartInfo(headTuff[headTuffNumber][jointNumber]);
		this.headTuff[headTuffNumber][partNumber] = new ModelRenderer(this, 21, 20); // headTuffBase
		this.headTuff[headTuffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headTuff[headTuffNumber][partNumber].addBox(-1.0F, -1.2F, -0.5F, 2, 1, 1, 0.0F);
		headTuffInfo[headTuffNumber][partNumber] = new PartInfo(headTuff[headTuffNumber][partNumber]);
		headTuffNumber++;
		this.headTuff[headTuffNumber][jointNumber] = new ModelRenderer(this, 0, 0); // headTuffMidJoint
		this.headTuff[headTuffNumber][jointNumber].setRotationPoint(0.0F, -1.0F, 0.0F);
		this.headTuff[headTuffNumber][jointNumber].addBox(-1.5F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headTuff[headTuffNumber][jointNumber], 1.1344640137963142F, 0.0F, 0.0F);
		headTuffInfo[headTuffNumber][jointNumber] = new PartInfo(headTuff[headTuffNumber][jointNumber]);
		this.headTuff[headTuffNumber][partNumber] = new ModelRenderer(this, 25, 20); // headTuffMid
		this.headTuff[headTuffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headTuff[headTuffNumber][partNumber].addBox(-1.5F, -0.9F, 0.0F, 3, 2, 3, 0.0F);
		headTuffInfo[headTuffNumber][partNumber] = new PartInfo(headTuff[headTuffNumber][partNumber]);
		headTuffNumber++;
		this.headTuff[headTuffNumber][jointNumber] = new ModelRenderer(this, 0, 0); // headTuffEndJoint
		this.headTuff[headTuffNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.headTuff[headTuffNumber][jointNumber].addBox(-1.0F, -0.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headTuff[headTuffNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		headTuffInfo[headTuffNumber][jointNumber] = new PartInfo(headTuff[headTuffNumber][jointNumber]);
		this.headTuff[headTuffNumber][partNumber] = new ModelRenderer(this, 35, 19); // headTuffEnd
		this.headTuff[headTuffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headTuff[headTuffNumber][partNumber].addBox(-1.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
		headTuffInfo[headTuffNumber][partNumber] = new PartInfo(headTuff[headTuffNumber][partNumber]);
		headTuffNumber++;
		this.headTuff[headTuffNumber][jointNumber] = new ModelRenderer(this, 0, 0); // headTuffTipJoint
		this.headTuff[headTuffNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.headTuff[headTuffNumber][jointNumber].addBox(-0.5F, -0.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headTuff[headTuffNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		headTuffInfo[headTuffNumber][jointNumber] = new PartInfo(headTuff[headTuffNumber][jointNumber]);
		this.headTuff[headTuffNumber][partNumber] = new ModelRenderer(this, 39, 23); // headTuffTip
		this.headTuff[headTuffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headTuff[headTuffNumber][partNumber].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
		headTuffInfo[headTuffNumber][partNumber] = new PartInfo(headTuff[headTuffNumber][partNumber]);

		this.earLftJoint = new ModelRenderer(this, 0, 0);
		this.earLftJoint.setRotationPoint(1.5F, -2.8F, -1.5F);
		this.earLftJoint.addBox(0.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.5235987755982988F, -0.5235987755982988F, -0.5235987755982988F);
		earLftJointInfo = new PartInfo(earLftJoint);
		this.earLft = new ModelRenderer(this, 2, 12);
		this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft.addBox(0.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLft.setTextureOffset(0, 7).addBox(2.0F, -1.5F, -0.5F, 4, 3, 1, 0.0F); // earLftMid
		this.earLft.setTextureOffset(2, 3).addBox(6.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F); // earLftEnd
		this.earLft.setTextureOffset(3, 0).addBox(8.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F); // earLftTip
		earLftInfo = new PartInfo(earLft);

		this.earRtJoint = new ModelRenderer(this, 0, 0);
		this.earRtJoint.setRotationPoint(-1.5F, -2.8F, -1.5F);
		this.earRtJoint.addBox(0.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.5235987755982988F, 0.5235987755982988F, 0.5235987755982988F);
		earRtJointInfo = new PartInfo(earRtJoint);
		this.earRt = new ModelRenderer(this, 12, 18);
		this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt.addBox(-2.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRt.setTextureOffset(10, 13).addBox(-6.0F, -1.5F, -0.5F, 4, 3, 1, 0.0F); // earRtMid
		this.earRt.setTextureOffset(13, 5).addBox(-8.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F); // earRtEnd
		this.earRt.setTextureOffset(14, 2).addBox(-9.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F); // earRtTip
		earRtInfo = new PartInfo(earRt);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -2.1F, 3.0F);
		this.tail[tailNumber][jointNumber].addBox(-2.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.08726646259971647F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 0, 27); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.0F, -2.0F, -0.5F, 4, 4, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.5F);
		this.tail[tailNumber][jointNumber].addBox(-3.0F, -3.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 0, 34); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-3.0F, -3.0F, -1.0F, 6, 6, 4, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 0, 45); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 4, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.7F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 0, 54); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.0F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.3490658503988659F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 0, 60); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		this.body.addChild(this.legBckLft);
		this.body.addChild(this.legBckRt);
		this.body.addChild(this.legFntLft);
		this.body.addChild(this.legFntRt);
		this.body.addChild(this.maneJoint);
		this.body.addChild(this.tail[0][0]);

		this.maneJoint.addChild(this.mane);
		this.mane.addChild(this.headJoint);

		this.headJoint.addChild(this.head);
		this.head.addChild(this.muzzle);
		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earRtJoint);
		this.head.addChild(this.headTuff[0][0]);

		this.earLftJoint.addChild(this.earLft);
		this.earRtJoint.addChild(this.earRt);

		this.headTuff[0][0].addChild(this.headTuff[0][1]); // headTuffBaseJoint* headTuffBase
		this.headTuff[0][1].addChild(this.headTuff[1][0]); // headTuffBase     * headTuffMidJoint
		this.headTuff[1][0].addChild(this.headTuff[1][1]); // headTuffMidJoint * headTuffMid
		this.headTuff[1][1].addChild(this.headTuff[2][0]); // headTuffMid      * headTuffEndJoint
		this.headTuff[2][0].addChild(this.headTuff[2][1]); // headTuffEndJoint * headTuffEnd
		this.headTuff[2][1].addChild(this.headTuff[3][0]); // headTuffEnd      * headTuffTipJoint
		this.headTuff[3][0].addChild(this.headTuff[3][1]); // headTuffTipJoint * headTuffTip

		this.tail[0][0].addChild(this.tail[0][1]); // tail1Joint * tail1
		this.tail[0][1].addChild(this.tail[1][0]); // tail1      * tail2Joint
		this.tail[1][0].addChild(this.tail[1][1]); // tail2Joint * tail2
		this.tail[1][1].addChild(this.tail[2][0]); // tail2      * tail3Joint
		this.tail[2][0].addChild(this.tail[2][1]); // tail3Joint * tail3
		this.tail[2][1].addChild(this.tail[3][0]); // tail3      * tail4Joint
		this.tail[3][0].addChild(this.tail[3][1]); // tail4Joint * tail4
		this.tail[3][1].addChild(this.tail[4][0]); // tail4      * tail5Joint
		this.tail[4][0].addChild(this.tail[4][1]); // tail5Joint * tail5

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{
		animate((EntityZombieFlareon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		this.body.render(modelSize);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void animate(EntityZombieFlareon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{	
		animationDeployer.update((IAnimatedEntity)entity);
		resetPartInfos();

		float angularVelocity = ((IMobMotionTracker)entity).getAngularVelocity();
		float verticalVelocity = (float)((IMobMotionTracker)entity).getHeightVelocity();

		animateBody((EntityZombieFlareon)animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, verticalVelocity);
		animateHead((EntityZombieFlareon)animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, verticalVelocity);
		animateLegs((EntityZombieFlareon)animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, verticalVelocity);
		animateTail((EntityZombieFlareon)animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, verticalVelocity, angularVelocity);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyInfo.resetNewAngles();
		
		maneJointInfo.resetNewAngles();
		maneInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();
		earRtInfo.resetNewAngles();
		earLftInfo.resetNewAngles();
		muzzleInfo.resetNewAngles();

		legFntRtInfo.resetNewAngles();
		legFntLftInfo.resetNewAngles();
		legBckRtInfo.resetNewAngles();
		legBckLftInfo.resetNewAngles();

		for(int i = 0; i < headTuff.length; i++)
		{
			headTuffInfo[i][0].resetNewAngles();
			headTuffInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}

	public void animateBody(EntityZombieFlareon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float verticalVelocity)
	{
		float walkCycleInterval = ((WALK_FREQUENCY * distanceMoved + PI) % (2 * PI))/(2 * PI);
		float runCycleInterval = ((RUN_FREQUENCY * distanceMoved + PI) % (2 * PI))/(2 * PI);

		float bodyWalkAngle = (float)Math.toRadians(18);
		float bodyRunAngle = (float)Math.toRadians(28);

		float newVerticalVelocity = 2.0F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI + PI/2) * bodyWalkAngle * (1 - horzVelocity);
		float runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI + PI/2) * bodyRunAngle * horzVelocity;

		float bodyJumpAngle = (float)Math.toRadians(-55);
		float verticalVelocityChangeAngle = (float)Math.toRadians(10);

		bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
				+ bodyJumpAngle * newVerticalVelocity);
	}

	public void animateHead(EntityZombieFlareon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float verticalVelocity)
	{
		float walkCycleInterval = ((WALK_FREQUENCY * distanceMoved + PI/2F) % (2 * PI))/(2 * PI);
		float runCycleInterval = ((RUN_FREQUENCY * distanceMoved + PI/2F) % (2 * PI))/(2 * PI);

		float newVerticalVelocity = 2.0F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		JointAnimation.reverseJointRotatesChange(bodyInfo, maneJointInfo);

		float headWalkAngle = (float)Math.toRadians(15);
		float headRunAngle = (float)Math.toRadians(25);

		float walkCycleRateChange = MathHelper.cos(walkCycleInterval * 2 * PI + PI/2) * (1 - horzVelocity);
		float runCycleRateChange = MathHelper.cos(runCycleInterval * 2 * PI + PI/2) * horzVelocity;

		float walkCycleAngleChange = walkCycleRateChange * headWalkAngle;
		float runCycleAngleChange = runCycleRateChange * headRunAngle;

		// + (float)Math.toRadians(45)
		float angleChangeX = (walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity));

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble(0);

		float idleHeadAmplitudeX = (float)Math.toRadians(15);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleHeadAmplitudeX + idleHeadAmplitudeX;

		maneInfo.setNewRotateX(maneInfo.getNewRotateX() + angleChangeX);
		maneInfo.setNewRotateY(maneInfo.getNewRotateY());

		JointAnimation.reverseJointRotatesChange(maneInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnly(headInfo, yawHeadOffsetDifference, pitchRotation);

		/* ******* Ears ******** */
		float earAngleChangeZ = 0;

		/* ** Ears Movement ** */
		float earWalkAngle = (float)Math.toRadians(10);
		float earRunAngle = (float)Math.toRadians(25);

		walkCycleAngleChange = walkCycleRateChange * earWalkAngle;
		runCycleAngleChange = runCycleRateChange * earRunAngle;

		earAngleChangeZ = (walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity));

		/* ** Ears Idle ** */
		float idleAmplitudeZ = (float)Math.toRadians(10);
		earAngleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ;

		/* ** Ears Falling/Jumping ** */
		float fallingEarAngle = (float)Math.toRadians(30);
		earAngleChangeZ += fallingEarAngle * newVerticalVelocity;

		earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - earAngleChangeZ);
		earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + earAngleChangeZ);
		
		/* ******* Head Hair ******** */

		for(int i = 0; i < headTuff.length; i++)
		{
			currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble(i);

			float movementAmplitudeX = (float)Math.toRadians(10);
			
			float amplitudeBobbleX = 0.45F;
			float amplitudeBobbleY = 0.25F;

			// + (float)Math.toRadians(45)
			angleChangeX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, this.RUN_FREQUENCY, movementAmplitudeX);
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 + PI) * amplitudeBobbleX * 
					( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2 + PI) * amplitudeBobbleY * 
					( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));

			headTuffInfo[i][1].setNewRotateX(headTuffInfo[i][1].getNewRotateX() + angleChangeX);
			headTuffInfo[i][1].setNewRotateY(headTuffInfo[i][1].getNewRotateY() + angleChangeY);
		}

		for(int i = 0; i < headTuffInfo.length - 1; i++)
		{
			JointAnimation.reverseJointRotatesChange(headTuffInfo[i][1], headTuffInfo[i + 1][0]);
		}
	}

	public void animateLegs(EntityZombieFlareon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float verticalVelocity)
	{
		float amplitude = 0.8F;

		// Run constants
		float legFntRtModifierRun = 2F * PI * (1F/4F);
		float legBckRtModifierRun = 2F * PI * (7F/16F);
		float legBckLftModifierRun = 2F * PI * (8F/16F);

		// Walk constants
		float legFntRtModifierWalk = 2F * PI * (9F/16F);
		float legBckRtModifierWalk = 2F * PI * (14F/16F);
		float legBckLftModifierWalk = 2F * PI * (6F/16F);

		float legFntRtModifierDifference = legFntRtModifierRun - legFntRtModifierWalk;
		float legBckRtModifierDifference = legBckRtModifierRun - legBckRtModifierWalk;
		float legBckLftModifierDifference = legBckLftModifierRun - legBckLftModifierWalk;

		float legFntRtModifier;
		float legBckRtModifier;
		float legBckLftModifier;

		float sprint = 1.0F;
		float sneak = SNEAK_VELOCITY;

		if(horzVelocity > sneak)
		{
			float modifier = (horzVelocity - sneak)/(sprint - sneak);
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

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float fallingModifier = 0;

		if(newVerticalVelocity < 0)
			fallingModifier = newVerticalVelocity;

		float fallingLegAngle = (float)Math.toRadians(25);

		float newHorizontalVelocity = (2F * horzVelocity > 1F ? 1F : horzVelocity * 2F);

		JointAnimation.reverseJointRotatesChange(bodyInfo, legFntRtInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legFntLftInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckRtInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckLftInfo);

		legFntRtInfo.setNewRotateX(legFntRtInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legFntRtModifier + PI, newHorizontalVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)) + fallingLegAngle * fallingModifier);
		legFntLftInfo.setNewRotateX(legFntLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + PI, newHorizontalVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)) + fallingLegAngle * fallingModifier);
		legBckRtInfo.setNewRotateX(legBckRtInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckRtModifier + PI, newHorizontalVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)));
		legBckLftInfo.setNewRotateX(legBckLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckLftModifier + PI, newHorizontalVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)));
	}
	
	public void animateTail(EntityZombieFlareon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float verticalVelocity, float angularVelocity)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		float yawChangeAngle = -(float)Math.toRadians(15);
		float verticalVelocityChangeAngle = (float)Math.toRadians(-9);

		float bodyJumpAngle = (float)Math.toRadians(-55);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float absoluteMoveVelocity = horzVelocity + Math.abs(newVerticalVelocity);

		if(absoluteMoveVelocity > 1F)
			absoluteMoveVelocity = 1F;

		tailInfo[0][1].setNewRotateX(tailInfo[0][1].getNewRotateX() + bodyJumpAngle * newVerticalVelocity);

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = 0.22F;
			float idleAmplitudeY = 0.28F;

			float moveAmplitudeX = 0.35F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			// Idle Animations
			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX 
					* (1F - absoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.5F);
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY
					* (1F - absoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.5F);

			// Movement Animations
			angleChangeX += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - (PI * ((float)i / (float)(tail.length - 1)) + PI), absoluteMoveVelocity, RUN_FREQUENCY, moveAmplitudeX) 
					+ verticalVelocityChangeAngle * newVerticalVelocity;
			angleChangeY += angularVelocity * yawChangeAngle;

			// Part Number Dampener
			angleChangeX *= (1F - (Math.pow(Math.E, -0.95F * (float)(i + 1))));
			angleChangeY *= (1F - (Math.pow(Math.E, -0.95F * (float)(i + 1))));

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}
	}

	public void deployAnimations()
	{
		animationDeployer.rotate(body, bodyInfo.getNewRotates());
		
		animationDeployer.rotate(maneJoint, maneJointInfo.getNewRotates());
		animationDeployer.rotate(mane, maneInfo.getNewRotates());
		animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		animationDeployer.rotate(head, headInfo.getNewRotates());
		animationDeployer.rotate(muzzle, muzzleInfo.getNewRotates());
		animationDeployer.rotate(earLft, earLftInfo.getNewRotates());
		animationDeployer.rotate(earRt, earRtInfo.getNewRotates());

		animationDeployer.rotate(legFntRt, legFntRtInfo.getNewRotates());
		animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		animationDeployer.rotate(legBckRt, legBckRtInfo.getNewRotates());
		animationDeployer.rotate(legBckLft, legBckLftInfo.getNewRotates());

		for(int i = 0; i < headTuff.length; i++)
		{
			animationDeployer.rotate(headTuff[i][0], headTuffInfo[i][0].getNewRotates());
			animationDeployer.rotate(headTuff[i][1], headTuffInfo[i][1].getNewRotates());
		}

		for(int i = 0; i < tail.length; i++)
		{
			animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		animationDeployer.applyChanges();
	}
}