package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZombieLeafeon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZombieLeafeon extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 1.5F;

	public ModelRenderer body;
	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	PartInfo bodyInfo;
	PartInfo neckJointInfo;
	PartInfo neckInfo;

	public ModelRenderer legFntRt;
	public ModelRenderer legFntLft;
	public ModelRenderer legBckLft;
	public ModelRenderer legBckRt;
	PartInfo legFntLftInfo;
	PartInfo legFntRtInfo;
	PartInfo legBckLftInfo;
	PartInfo legBckRtInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer muzzle;
	public ModelRenderer nose;

	public ModelRenderer headMossLftTop;
	public ModelRenderer headMossRtCheek;
	public ModelRenderer headShroom;
	public ModelRenderer headShroomCap;

	public ModelRenderer headLeaf[][] = new ModelRenderer[3][2];
	PartInfo headLeafInfo[][] = new PartInfo[headLeaf.length][headLeaf[0].length];

	public ModelRenderer earRtJoint;
	public ModelRenderer earRt;
	public ModelRenderer earLftJoint;
	public ModelRenderer earLft;
	PartInfo earRtJointInfo;
	PartInfo earRtInfo;
	PartInfo earLftJointInfo;
	PartInfo earLftInfo;

	public ModelRenderer bodyShroom1Joint;
	public ModelRenderer bodyShroom1;
	public ModelRenderer bodyShroom2Joint;
	public ModelRenderer bodyShroom2;
	public ModelRenderer bodyShroom3Joint;
	public ModelRenderer bodyShroom3;

	public ModelRenderer tailJoint;
	public ModelRenderer tail;
	PartInfo tailJointInfo;
	PartInfo tailInfo;

	public ModelZombieLeafeon() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 22, 0);
		this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
		this.body.addBox(-2.5F, -2.5F, -3.5F, 5, 4, 7, 0.0F);
		bodyInfo = new PartInfo(body);
		this.neckJoint = new ModelRenderer(this, 28, 12);
		this.neckJoint.setRotationPoint(0.0F, -2.0F, -3.0F);
		this.neckJoint.addBox(-1.5F, -2.0F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, 0.7853981633974483F, -0.0F, 0.0F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 28, 12);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-1.5F, -2.0F, -1.5F, 3, 3, 3, 0.0F);
		neckInfo = new PartInfo(neck);

		this.legFntRt = new ModelRenderer(this, 47, 0);
		this.legFntRt.setRotationPoint(-1.2F, 1.0F, -2.0F);
		this.legFntRt.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		legFntRtInfo = new PartInfo(legFntRt);
		this.legFntLft = new ModelRenderer(this, 56, 0);
		this.legFntLft.setRotationPoint(1.2F, 1.0F, -2.0F);
		this.legFntLft.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		legFntLftInfo = new PartInfo(legFntLft);
		this.legBckLft = new ModelRenderer(this, 47, 8);
		this.legBckLft.setRotationPoint(1.2F, 1.0F, 2.0F);
		this.legBckLft.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(legBckLft, -0.17453292519943295F, -0.0F, 0.0F);
		this.legBckLft.setTextureOffset(47, 14).addBox(-1.1F, 1.9F, 0.0F, 2, 3, 2, 0.0F); // legBckLftHind
		legBckLftInfo = new PartInfo(legBckLft);
		this.legBckRt = new ModelRenderer(this, 56, 8);
		this.legBckRt.setRotationPoint(-1.2F, 1.0F, 2.0F);
		this.legBckRt.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(legBckRt, -0.17453292519943295F, -0.0F, 0.0F);
		this.legBckRt.setTextureOffset(56, 14).addBox(-0.9F, 1.9F, 0.0F, 2, 3, 2, 0.0F); // legBckRtHind
		legBckRtInfo = new PartInfo(legBckRt);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.headJoint.addBox(-2.5F, -4.0F, -2.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, -0.7853981633974483F, -0.0F, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.5F, -4.0F, -2.5F, 5, 5, 4, 0.0F);
		headInfo = new PartInfo(head);

		this.muzzle = new ModelRenderer(this, 0, 10);
		this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muzzle.addBox(-1.0F, -2.0F, -3.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(muzzle, 0.2617993877991494F, -0.0F, 0.0F);
		this.nose = new ModelRenderer(this, 2, 15);
		this.nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.nose.addBox(-0.5F, -1.9F, -3.8F, 1, 1, 1, 0.0F);
		this.setRotateAngle(nose, 0.2617993877991494F, -0.0F, 0.0F);

		this.headMossLftTop = new ModelRenderer(this, 9, 10);
		this.headMossLftTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headMossLftTop.addBox(0.3F, -4.8F, -2.4F, 3, 2, 3, 0.0F);
		this.setRotateAngle(headMossLftTop, 0.2230530784048753F, -0.0F, 0.0F);
		this.headMossRtCheek = new ModelRenderer(this, 11, 16);
		this.headMossRtCheek.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headMossRtCheek.addBox(-3.0F, -0.27F, -2.8F, 2, 2, 2, 0.0F);
		this.setRotateAngle(headMossRtCheek, -0.29740410453983374F, -0.0F, 0.0F);
		this.headShroom = new ModelRenderer(this, 0, 22);
		this.headShroom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headShroom.addBox(-1.9F, -1.4F, -5.6F, 1, 1, 2, 0.0F);
		this.setRotateAngle(headShroom, -0.9665633397544597F, -0.0F, 0.0F);
		this.headShroomCap = new ModelRenderer(this, 0, 18);
		this.headShroomCap.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headShroomCap.addBox(-2.4F, -1.9F, -6.2F, 2, 2, 1, 0.0F);
		this.setRotateAngle(headShroomCap, -0.9665633397544597F, -0.0F, 0.0F);

		int headLeafNumber = 0;
		this.headLeaf[headLeafNumber][jointNumber] = new ModelRenderer(this, 14, 29); // headLeaf1Joint
		this.headLeaf[headLeafNumber][jointNumber].setRotationPoint(0.0F, -4.0F, 0.0F);
		this.headLeaf[headLeafNumber][jointNumber].addBox(-0.5F, -0.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headLeaf[headLeafNumber][jointNumber], 1.040914365889418F, -0.0F, 0.0F);
		headLeafInfo[headLeafNumber][jointNumber] = new PartInfo(headLeaf[headLeafNumber][jointNumber]);
		this.headLeaf[headLeafNumber][partNumber] = new ModelRenderer(this, 14, 29); // headLeaf1
		this.headLeaf[headLeafNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headLeaf[headLeafNumber][partNumber].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
		headLeafInfo[headLeafNumber][partNumber] = new PartInfo(headLeaf[headLeafNumber][partNumber]);
		headLeafNumber++;
		this.headLeaf[headLeafNumber][jointNumber] = new ModelRenderer(this, 15, 25); // headLeaf2Joint
		this.headLeaf[headLeafNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.7F);
		this.headLeaf[headLeafNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headLeaf[headLeafNumber][jointNumber], 1.2217304763960306F, -0.0F, 0.0F);
		headLeafInfo[headLeafNumber][jointNumber] = new PartInfo(headLeaf[headLeafNumber][jointNumber]);
		this.headLeaf[headLeafNumber][partNumber] = new ModelRenderer(this, 15, 25); // headLeaf2
		this.headLeaf[headLeafNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headLeaf[headLeafNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		headLeafInfo[headLeafNumber][partNumber] = new PartInfo(headLeaf[headLeafNumber][partNumber]);
		headLeafNumber++;
		this.headLeaf[headLeafNumber][jointNumber] = new ModelRenderer(this, 15, 21); // headLeaf3Joint
		this.headLeaf[headLeafNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.5F);
		this.headLeaf[headLeafNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headLeaf[headLeafNumber][jointNumber], 1.2217304763960306F, -0.0F, 0.0F);
		headLeafInfo[headLeafNumber][jointNumber] = new PartInfo(headLeaf[headLeafNumber][jointNumber]);
		this.headLeaf[headLeafNumber][partNumber] = new ModelRenderer(this, 15, 21); // headLeaf3
		this.headLeaf[headLeafNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headLeaf[headLeafNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		headLeafInfo[headLeafNumber][partNumber] = new PartInfo(headLeaf[headLeafNumber][partNumber]);

		this.earRtJoint = new ModelRenderer(this, 10, 47);
		this.earRtJoint.setRotationPoint(-1.8F, -3.3F, 0.3F);
		this.earRtJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.0F, 0.6981317007977318F, -1.0471975511965976F);
		earRtJointInfo = new PartInfo(earRtJoint);
		this.earRt = new ModelRenderer(this, 10, 47);
		this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRt.setTextureOffset(9, 41).addBox(-1.5F, -5.0F, -0.5F, 3, 4, 1, 0.0F); // earRtMid
		this.earRt.setTextureOffset(10, 37).addBox(-1.0F, -7.0F, -0.5F, 2, 2, 1, 0.0F); // earRtEnd
		this.earRt.setTextureOffset(11, 34).addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F); // earRtTip
		earRtInfo = new PartInfo(earRt);
		this.earLftJoint = new ModelRenderer(this, 1, 47);
		this.earLftJoint.setRotationPoint(1.8F, -3.3F, 0.3F);
		this.earLftJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.0F, -0.6981317007977318F, 1.0471975511965976F);
		earLftJointInfo = new PartInfo(earLftJoint);
		this.earLft = new ModelRenderer(this, 1, 47);
		this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLft.setTextureOffset(0, 41).addBox(-1.5F, -5.0F, -0.5F, 3, 4, 1, 0.0F); // earLftMid
		this.earLft.setTextureOffset(1, 37).addBox(-1.0F, -7.0F, -0.5F, 2, 2, 1, 0.0F); // earLftEnd
		this.earLft.setTextureOffset(2, 34).addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F); // earLftTip
		earLftInfo = new PartInfo(earLft);

		this.bodyShroom1Joint = new ModelRenderer(this, 24, 26);
		this.bodyShroom1Joint.setRotationPoint(-2.0F, -2.0F, 0.0F);
		this.bodyShroom1Joint.addBox(-0.5F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(bodyShroom1Joint, 0.2617993877991494F, 0.0F, -0.7853981633974483F);
		this.bodyShroom1 = new ModelRenderer(this, 24, 26);
		this.bodyShroom1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodyShroom1.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.bodyShroom1.setTextureOffset(22, 22).addBox(-1.0F, -3.0F, -1.0F, 2, 1, 2, 0.0F); // bodyShroom1Cap
		this.bodyShroom1.setTextureOffset(24, 19).addBox(-0.5F, -3.6F, -0.5F, 1, 1, 1, 0.0F); // bodyShroom1CapTip
		this.bodyShroom2Joint = new ModelRenderer(this, 33, 26);
		this.bodyShroom2Joint.setRotationPoint(2.0F, 0.0F, -3.0F);
		this.bodyShroom2Joint.addBox(-0.5F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(bodyShroom2Joint, 0.9599310885968813F, -1.2217304763960306F, 0.5235987755982988F);
		this.bodyShroom2 = new ModelRenderer(this, 33, 26);
		this.bodyShroom2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodyShroom2.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.bodyShroom2.setTextureOffset(31, 22).addBox(-1.0F, -2.5F, -1.0F, 2, 1, 2, 0.0F); // bodyShroom2Cap
		this.bodyShroom2.setTextureOffset(33, 19).addBox(-0.5F, -3.1F, -0.5F, 1, 1, 1, 0.0F); // bodyShroom2CapTip
		this.bodyShroom3Joint = new ModelRenderer(this, 42, 26);
		this.bodyShroom3Joint.setRotationPoint(2.0F, -2.0F, 1.0F);
		this.bodyShroom3Joint.addBox(-0.5F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(bodyShroom3Joint, -0.2617993877991494F, 0.2617993877991494F, 0.6981317007977318F);
		this.bodyShroom3 = new ModelRenderer(this, 42, 26);
		this.bodyShroom3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodyShroom3.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.bodyShroom3.setTextureOffset(40, 22).addBox(-1.0F, -2.5F, -1.0F, 2, 1, 2, 0.0F); // bodyShroom3Cap

		this.tailJoint = new ModelRenderer(this, 49, 20);
		this.tailJoint.setRotationPoint(0.0F, -1.8F, 3.0F);
		this.tailJoint.addBox(-0.5F, -0.5F, -0.1F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tailJoint, -0.5235987755982988F, 0.0F, 0.0F);
		tailJointInfo = new PartInfo(tailJoint);
		this.tail = new ModelRenderer(this, 49, 20);
		this.tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail.addBox(-0.5F, -0.5F, -0.1F, 1, 1, 6, 0.0F);
		this.tail.setTextureOffset(53, 28).addBox(-1.0F, -0.4F, 1.0F, 2, 1, 1, 0.0F); // tailBase
		this.tail.setTextureOffset(50, 34).addBox(-1.0F, -0.4F, 3.0F, 3, 1, 1, 0.0F); // tailBaseMid
		this.tail.setTextureOffset(56, 31).addBox(-1.4F, -0.4F, 2.0F, 2, 1, 1, 0.0F); // tailSubBase
		this.tail.setTextureOffset(51, 37).addBox(1.0F, -0.4F, 4.0F, 1, 1, 1, 0.0F); // tailMidLft
		this.tail.setTextureOffset(56, 37).addBox(-2.0F, -0.4F, 4.0F, 2, 1, 1, 0.0F); // tailMidRt
		this.tail.setTextureOffset(52, 40).addBox(-1.5F, -0.4F, 5.0F, 3, 1, 1, 0.0F); // tailMidEnd
		this.tail.setTextureOffset(56, 43).addBox(-1.0F, -0.4F, 6.0F, 1, 1, 1, 0.0F); // tailEnd
		this.tail.setTextureOffset(54, 46).addBox(-0.5F, -0.4F, 7.0F, 1, 1, 1, 0.0F); // tailTip
		tailInfo = new PartInfo(tail);

		this.body.addChild(this.legBckLft);
		this.body.addChild(this.legBckRt);
		this.body.addChild(this.legFntLft);
		this.body.addChild(this.legFntRt);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.bodyShroom1Joint);
		this.body.addChild(this.bodyShroom2Joint);
		this.body.addChild(this.bodyShroom3Joint);
		this.body.addChild(this.tailJoint);

		this.neckJoint.addChild(this.neck);
		this.neck.addChild(this.headJoint);

		this.headJoint.addChild(this.head);
		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earRtJoint);
		this.head.addChild(this.headMossLftTop);
		this.head.addChild(this.headMossRtCheek);
		this.head.addChild(this.headShroom);
		this.head.addChild(this.headShroomCap);
		this.head.addChild(this.muzzle);
		this.head.addChild(this.nose);
		this.head.addChild(this.headLeaf[0][0]);

		this.earLftJoint.addChild(this.earLft);
		this.earRtJoint.addChild(this.earRt);

		this.headLeaf[0][0].addChild(this.headLeaf[0][1]); // headLeaf1Joint * headLeaf1
		this.headLeaf[0][1].addChild(this.headLeaf[1][0]); // headLeaf1      * headLeaf2Joint
		this.headLeaf[1][0].addChild(this.headLeaf[1][1]); // headLeaf2Joint * headLeaf2
		this.headLeaf[1][1].addChild(this.headLeaf[2][0]); // headLeaf2      * headLeaf3Joint
		this.headLeaf[2][0].addChild(this.headLeaf[2][1]); // headLeaf3Joint * headLeaf3

		this.bodyShroom1Joint.addChild(this.bodyShroom1);
		this.bodyShroom2Joint.addChild(this.bodyShroom2);
		this.bodyShroom3Joint.addChild(this.bodyShroom3);

		this.tailJoint.addChild(this.tail);

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

		animateBody((EntityZombieLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityZombieLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityZombieLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityZombieLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		legFntRtInfo.resetNewAngles();
		legFntLftInfo.resetNewAngles();
		legBckRtInfo.resetNewAngles();
		legBckLftInfo.resetNewAngles();

		earRtInfo.resetNewAngles();
		earLftInfo.resetNewAngles();

		tailJointInfo.resetNewAngles();
		tailInfo.resetNewAngles();

		for(int i = 0; i < headLeafInfo.length; i++)
		{
			headLeafInfo[i][0].resetNewAngles();
			headLeafInfo[i][1].resetNewAngles();
		}
	}

	public void animateBody(EntityZombieLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.2F;

		bodyInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
	}

	public void animateHead(EntityZombieLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, neckJointInfo);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble();

		float idleAmplitudeX = 0.25F;

		// + (float)Math.toRadians(45)
		float movementAmplitude = 0.2F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX);
		neckInfo.setNewRotateY(neckInfo.getNewRotateY());

		JointAnimation.reverseJointRotatesChange(neckInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnly(headInfo, yawHeadOffsetDifference, pitchRotation);

		/* ******* Ears ******** */
		float moveFrequencyZ = movementFrequency;
		float moveAmplitudeZ = 0.3F;

		float firstAngleChangeZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyZ, moveAmplitudeZ);

		float idleAmplitudeZ = 0.20F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = firstAngleChangeZ;

		angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ;

		earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - angleChangeZ);
		earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + angleChangeZ);

		/* ******* Head Leaf ******** */
		for(int i = 0; i < headLeaf.length; i++)
		{
			float moveAmplitudeX = 0.15F;

			float firstAngleChangeX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, moveAmplitudeX);

			idleAmplitudeX = 0.20F;

			// + (float)Math.toRadians(45)
			angleChangeX = firstAngleChangeX;

			angleChangeX += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeX;

			headLeafInfo[i][1].setNewRotateX(headLeafInfo[i][1].getNewRotateX() + angleChangeX);	
		}
	}

	public void animateLegs(EntityZombieLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckRtInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckLftInfo);

		//( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));

		legFntRtInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legFntRtModifier, horzVelocity, movementFrequency, amplitude));
		legFntLftInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
		legBckRtInfo.setNewRotateX(legBckRtInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckRtModifier, horzVelocity, movementFrequency, amplitude));
		legBckLftInfo.setNewRotateX(legBckLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckLftModifier, horzVelocity, movementFrequency, amplitude));
	}
	
	public void animateTail(EntityZombieLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail();

		float idleAmplitudeX = 0.20F;
		float idleAmplitudeY = 0.45F;

		float moveFrequency = 1F;
		float moveAmplitude = 0.2F;

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = 0;

		angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX;
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY
				+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);

		tailInfo.setNewRotateX(tailInfo.getNewRotateX() + angleChangeX);
		tailInfo.setNewRotateY(tailInfo.getNewRotateY() + angleChangeY);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(earLft, earLftInfo.getNewRotates());
		this.animationDeployer.rotate(earLftJoint, earLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(earRt, earRtInfo.getNewRotates());
		this.animationDeployer.rotate(earRtJoint, earRtJointInfo.getNewRotates());

		this.animationDeployer.rotate(legFntRt, legFntRtInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legBckRt, legBckRtInfo.getNewRotates());
		this.animationDeployer.rotate(legBckLft, legBckLftInfo.getNewRotates());

		this.animationDeployer.rotate(tail, tailInfo.getNewRotates());
		
		for(int i = 0; i < headLeaf.length; i++)
		{
			this.animationDeployer.rotate(headLeaf[i][0], headLeafInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(headLeaf[i][1], headLeafInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}