package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.IMobMotionTracker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZombieUmbreon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZombieUmbreon extends ModelBase 
{
	public final float PI = (float)Math.PI;

	public final float RUN_FREQUENCY = 1.2F;
	public final float WALK_FREQUENCY = 1.2F;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 1.5F;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer legFntRt;
	public ModelRenderer legFntLft;
	public ModelRenderer legBckLft;
	public ModelRenderer legBckRt;
	PartInfo legFntLftInfo;
	PartInfo legFntRtInfo;
	PartInfo legBckLftInfo;
	PartInfo legBckRtInfo;

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	public ModelRenderer headJoint;
	public ModelRenderer head;
	public ModelRenderer muzzle;
	PartInfo neckJointInfo;
	PartInfo neckInfo;
	PartInfo headJointInfo;
	PartInfo headInfo;
	PartInfo muzzleInfo;

	public ModelRenderer earRt[][] = new ModelRenderer[5][2];
	PartInfo earRtInfo[][] = new PartInfo[earRt.length][earRt[0].length];

	public ModelRenderer earLft[][] = new ModelRenderer[2][2];
	PartInfo earLftInfo[][] = new PartInfo[earLft.length][earLft[0].length];

	public ModelRenderer tail[][] = new ModelRenderer[7][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelZombieUmbreon() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 36, 50);
		this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.body.addBox(-2.5F, -3.0F, -4.5F, 5, 5, 9, 0.0F);
		bodyInfo = new PartInfo(body);

		this.legFntRt = new ModelRenderer(this, 18, 42);
		this.legFntRt.setRotationPoint(-1.2F, 1.5F, -2.7F);
		this.legFntRt.addBox(-1.0F, -0.5F, -1.0F, 2, 6, 2, 0.0F);
		legFntRtInfo = new PartInfo(legFntRt);
		this.legFntLft = new ModelRenderer(this, 27, 42);
		this.legFntLft.setRotationPoint(1.2F, 1.5F, -2.7F);
		this.legFntLft.addBox(-1.0F, -0.5F, -1.0F, 2, 6, 2, 0.0F);
		legFntLftInfo = new PartInfo(legFntLft);
		this.legBckLft = new ModelRenderer(this, 27, 51);
		this.legBckLft.setRotationPoint(1.4F, 1.4F, 2.8F);
		this.legBckLft.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(legBckLft, -0.17453292519943295F, -0.0F, 0.0F);
		this.legBckLft.setTextureOffset(27, 58).addBox(-1.01F, 1.5F, 0.0F, 2, 4, 2, 0.0F); // legBckLftHind
		legBckLftInfo = new PartInfo(legBckLft);
		this.legBckRt = new ModelRenderer(this, 18, 51);
		this.legBckRt.setRotationPoint(-1.4F, 1.4F, 2.8F);
		this.legBckRt.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(legBckRt, -0.17453292519943295F, -0.0F, 0.0F);
		this.legBckRt.setTextureOffset(18, 58).addBox(-0.99F, 1.5F, 0.0F, 2, 4, 2, 0.0F); // legBckRtHind
		legBckRtInfo = new PartInfo(legBckRt);

		this.neckJoint = new ModelRenderer(this, 0, 0);
		this.neckJoint.setRotationPoint(0.0F, -2.0F, -3.0F);
		this.neckJoint.addBox(-1.5F, -4.5F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, 0.7853981633974483F, 0.0F, 0.0F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 38, 41);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-1.5F, -4.5F, -1.5F, 3, 5, 3, 0.0F);
		neckInfo = new PartInfo(neck);
		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.headJoint.addBox(-2.5F, -4.0F, -3.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, -0.7853981633974483F, 0.0F, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.5F, -4.0F, -3.5F, 5, 5, 5, 0.0F);
		headInfo = new PartInfo(head);
		this.muzzle = new ModelRenderer(this, 16, 0);
		this.muzzle.setRotationPoint(0.0F, 0.0F, -3.0F);
		this.muzzle.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(muzzle, 0.3490658503988659F, -0.0F, 0.0F);
		muzzleInfo = new PartInfo(muzzle);

		int earLftNumber = 0;
		this.earLft[earLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // earLftBaseJoint
		this.earLft[earLftNumber][jointNumber].setRotationPoint(1.49F, -3.0F, 0.0F);
		this.earLft[earLftNumber][jointNumber].addBox(-1.0F, -3.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLft[earLftNumber][jointNumber], -1.0471975511965976F, 0.0F, 0.7853981633974483F);
		earLftInfo[earLftNumber][jointNumber] = new PartInfo(earLft[earLftNumber][jointNumber]);
		this.earLft[earLftNumber][partNumber] = new ModelRenderer(this, 15, 35); // earLftBase
		this.earLft[earLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft[earLftNumber][partNumber].addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
		earLftInfo[earLftNumber][partNumber] = new PartInfo(earLft[earLftNumber][partNumber]);
		earLftNumber++;
		this.earLft[earLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // earLftBaseMidJoint
		this.earLft[earLftNumber][jointNumber].setRotationPoint(0.0F, -2.5F, 0.0F);
		this.earLft[earLftNumber][jointNumber].addBox(-1.5F, -2.7F, -1.5F, 0, 0, 0, 0.0F);
		earLftInfo[earLftNumber][jointNumber] = new PartInfo(earLft[earLftNumber][jointNumber]);
		this.earLft[earLftNumber][partNumber] = new ModelRenderer(this, 13, 28); // earLftBaseMid
		this.earLft[earLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft[earLftNumber][partNumber].addBox(-1.5F, -2.7F, -1.5F, 3, 3, 3, 0.0F);
		earLftInfo[earLftNumber][partNumber] = new PartInfo(earLft[earLftNumber][partNumber]);

		int earRtNumber = 0;
		this.earRt[earRtNumber][jointNumber] = new ModelRenderer(this, 0, 0);  // earRtBaseJoint
		this.earRt[earRtNumber][jointNumber].setRotationPoint(-1.49F, -3.0F, 0.0F);
		this.earRt[earRtNumber][jointNumber].addBox(-1.0F, -3.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRt[earRtNumber][jointNumber], -1.0471975511965976F, 0.0F, -0.7853981633974483F);
		earRtInfo[earRtNumber][jointNumber] = new PartInfo(earRt[earRtNumber][jointNumber]);
		this.earRt[earRtNumber][partNumber] = new ModelRenderer(this, 2, 36); // earRtBase
		this.earRt[earRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt[earRtNumber][partNumber].addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
		earRtInfo[earRtNumber][partNumber] = new PartInfo(earRt[earRtNumber][partNumber]);
		earRtNumber++;
		this.earRt[earRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // earRtBaseMidJoint
		this.earRt[earRtNumber][jointNumber].setRotationPoint(0.0F, -2.5F, 0.0F);
		this.earRt[earRtNumber][jointNumber].addBox(-1.5F, -2.7F, -1.5F, 0, 0, 0, 0.0F);
		earRtInfo[earRtNumber][jointNumber] = new PartInfo(earRt[earRtNumber][jointNumber]);
		this.earRt[earRtNumber][partNumber] = new ModelRenderer(this, 0, 29); // earRtBaseMid
		this.earRt[earRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt[earRtNumber][partNumber].addBox(-1.5F, -2.7F, -1.5F, 3, 3, 3, 0.0F);
		earRtInfo[earRtNumber][partNumber] = new PartInfo(earRt[earRtNumber][partNumber]);
		earRtNumber++;
		this.earRt[earRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // earRtMidJoint
		this.earRt[earRtNumber][jointNumber].setRotationPoint(0.0F, -2.2F, 0.0F);
		this.earRt[earRtNumber][jointNumber].addBox(-1.5F, -2.7F, -1.5F, 0, 0, 0, 0.0F);
		earRtInfo[earRtNumber][jointNumber] = new PartInfo(earRt[earRtNumber][jointNumber]);
		this.earRt[earRtNumber][partNumber] = new ModelRenderer(this, 0, 22); // earRtMid
		this.earRt[earRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt[earRtNumber][partNumber].addBox(-1.5F, -2.7F, -1.5F, 3, 3, 3, 0.0F);
		earRtInfo[earRtNumber][partNumber] = new PartInfo(earRt[earRtNumber][partNumber]);
		earRtNumber++;
		this.earRt[earRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // earRtEndJoint
		this.earRt[earRtNumber][jointNumber].setRotationPoint(0.0F, -2.3F, 0.0F);
		this.earRt[earRtNumber][jointNumber].addBox(-1.0F, -2.3F, -1.0F, 0, 0, 0, 0.0F);
		earRtInfo[earRtNumber][jointNumber] = new PartInfo(earRt[earRtNumber][jointNumber]);
		this.earRt[earRtNumber][partNumber] = new ModelRenderer(this, 2, 16); // earRtEnd
		this.earRt[earRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt[earRtNumber][partNumber].addBox(-1.0F, -2.3F, -1.0F, 2, 3, 2, 0.0F);
		earRtInfo[earRtNumber][partNumber] = new PartInfo(earRt[earRtNumber][partNumber]);
		earRtNumber++;
		this.earRt[earRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // earRtTipJoint
		this.earRt[earRtNumber][jointNumber].setRotationPoint(0.0F, -1.9F, 0.0F);
		this.earRt[earRtNumber][jointNumber].addBox(-0.5F, -2.4F, -0.5F, 0, 0, 0, 0.0F);
		earRtInfo[earRtNumber][jointNumber] = new PartInfo(earRt[earRtNumber][jointNumber]);
		this.earRt[earRtNumber][partNumber] = new ModelRenderer(this, 4, 11); // earRtTip
		this.earRt[earRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt[earRtNumber][partNumber].addBox(-0.5F, -2.4F, -0.5F, 1, 3, 1, 0.0F);
		earRtInfo[earRtNumber][partNumber] = new PartInfo(earRt[earRtNumber][partNumber]);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -1.8F, 3.8F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.3F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 53, 44); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 54, 39); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 52, 32); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.tail[tailNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 52, 32); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 52, 25); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.3F);
		this.tail[tailNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 52, 25); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 54, 20); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.2F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 54, 20); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 54, 15); // tail6Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.4F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 54, 15); // tail6
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 54, 10); // tail7Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.0F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 54, 10); // tail7
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		this.body.addChild(this.legBckLft);
		this.body.addChild(this.legBckRt);
		this.body.addChild(this.legFntLft);
		this.body.addChild(this.legFntRt);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.tail[0][0]);

		this.neckJoint.addChild(this.neck);
		this.neck.addChild(this.headJoint);

		this.headJoint.addChild(this.head);
		this.head.addChild(this.earLft[0][0]); // earLftBaseJoint
		this.head.addChild(this.earRt[0][0]); // earRtBaseJoint
		this.head.addChild(this.muzzle);

		this.earLft[0][0].addChild(this.earLft[0][1]); // earLftBaseJoint    * earLftBase
		this.earLft[0][1].addChild(this.earLft[1][0]); // earLftBase         * earLftBaseMidJoint
		this.earLft[1][0].addChild(this.earLft[1][1]); // earLftBaseMidJoint * earLftBaseMid

		this.earRt[0][0].addChild(this.earRt[0][1]); // earRtBaseJoint    * earRtBase
		this.earRt[0][1].addChild(this.earRt[1][0]); // earRtBase         * earRtBaseMidJoint
		this.earRt[1][0].addChild(this.earRt[1][1]); // earRtBaseMidJoint * earRtBaseMid
		this.earRt[1][1].addChild(this.earRt[2][0]); // earRtBaseMid      * earRtMidJoint
		this.earRt[2][0].addChild(this.earRt[2][1]); // earRtMidJoint     * earRtMid
		this.earRt[2][1].addChild(this.earRt[3][0]); // earRtMid          * earRtEndJoint
		this.earRt[3][0].addChild(this.earRt[3][1]); // earRtEndJoint     * earRtEnd
		this.earRt[3][1].addChild(this.earRt[4][0]); // earRtEnd          * earRtTipJoint
		this.earRt[4][0].addChild(this.earRt[4][1]); // earRtTipJoint     * earRtTip

		this.tail[0][0].addChild(this.tail[0][1]); // tail1Joint * tail1
		this.tail[0][1].addChild(this.tail[1][0]); // tail1      * tail2Joint
		this.tail[1][0].addChild(this.tail[1][1]); // tail2Joint * tail2
		this.tail[1][1].addChild(this.tail[2][0]); // tail2      * tail3Joint
		this.tail[2][0].addChild(this.tail[2][1]); // tail3Joint * tail3
		this.tail[2][1].addChild(this.tail[3][0]); // tail3      * tail4Joint
		this.tail[3][0].addChild(this.tail[3][1]); // tail4Joint * tail4
		this.tail[3][1].addChild(this.tail[4][0]); // tail4      * tail5Joint
		this.tail[4][0].addChild(this.tail[4][1]); // tail5Joint * tail5
		this.tail[4][1].addChild(this.tail[5][0]); // tail5      * tail6Joint
		this.tail[5][0].addChild(this.tail[5][1]); // tail6Joint * tail6
		this.tail[5][1].addChild(this.tail[6][0]); // tail6      * tail7Joint
		this.tail[6][0].addChild(this.tail[6][1]); // tail7Joint * tail7

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

		float angularVelocity = ((IMobMotionTracker)entity).getAngularVelocity();
		float verticleVelocity = (float)((IMobMotionTracker)entity).getHeightVelocity();

		animateBody((EntityZombieUmbreon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, verticleVelocity);
		animateHead((EntityZombieUmbreon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, verticleVelocity);
		animateLegs((EntityZombieUmbreon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, verticleVelocity);
		animateTail((EntityZombieUmbreon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, angularVelocity, verticleVelocity);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyInfo.resetNewAngles();
		
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		legFntRtInfo.resetNewAngles();
		legFntLftInfo.resetNewAngles();
		legBckRtInfo.resetNewAngles();
		legBckLftInfo.resetNewAngles();

		for(int i = 0; i < earRtInfo.length; i++)
		{
			earRtInfo[i][0].resetNewAngles();
			earRtInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < earLftInfo.length; i++)
		{
			earLftInfo[i][0].resetNewAngles();
			earLftInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}

	public void animateBody(EntityZombieUmbreon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float verticalVelocity)
	{
		float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
		float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

		float bodyWalkAngle = (float)Math.toRadians(10);
		float bodyRunAngle = (float)Math.toRadians(16);

		float walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI + PI/2) * bodyWalkAngle * (1 - horzVelocity)
				+ bodyWalkAngle * (1 - horzVelocity);
		float runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI + PI/2) * bodyRunAngle * horzVelocity
				+ bodyRunAngle * horzVelocity;

		float bodyJumpAngle = (float)Math.toRadians(-55);
		float verticalVelocityChangeAngle = (float)Math.toRadians(10);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
				+ bodyJumpAngle * newVerticalVelocity);
	}

	public void animateHead(EntityZombieUmbreon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float verticalVelocity)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, neckJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckJointInfo, yawHeadOffsetDifference, pitchRotation, 0.4F, 0.4F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble(0);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float fallingEarAngle = (float)Math.toRadians(10);

		float idleAmplitudeX = 0.1F;

		float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
		float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

		float walkAngle = (float)Math.toRadians(4);
		float runAngle = (float)Math.toRadians(8);

		float walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity)
				+ walkAngle * (1 - horzVelocity);
		float runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI) * runAngle * horzVelocity
				+ runAngle * horzVelocity;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocity);

		/* ******* Ears ******** */
		float moveFrequencyX = movementFrequency;
		float moveAmplitudeX = 0.15F;

		float moveFrequencyZ = 0.7F;
		float moveAmplitudeZ = 0.1F;

		float firstAngleChangeX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyX, moveAmplitudeX);
		float firstAngleChangeZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyZ, moveAmplitudeZ);

		for(int i = 0; i < earRt.length; i++)
		{
			currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble(i);

			idleAmplitudeX = 0.35F;
			float idleAmplitudeZ = 0.45F;

			// + (float)Math.toRadians(45)
			float angleChangeX = firstAngleChangeX;
			float angleChangeZ = firstAngleChangeZ;

			angleChangeX += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeX * 
					( 1 - (Math.pow(Math.E, -0.9F * (float)(i + 1))));
			angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI + PI) * idleAmplitudeZ * 
					( 1 - (Math.pow(Math.E, -0.9F * (float)(i + 1))));

			earRtInfo[i][1].setNewRotateX(earRtInfo[i][1].getNewRotateX() - angleChangeX);
			earRtInfo[i][1].setNewRotateZ(earRtInfo[i][1].getNewRotateZ());

			if(i < earLft.length)
			{
				earLftInfo[i][1].setNewRotateX(earLftInfo[i][1].getNewRotateX() - angleChangeX);
				earLftInfo[i][1].setNewRotateZ(earLftInfo[i][1].getNewRotateZ() - angleChangeZ);
			}
		}
	}

	public void animateLegs(EntityZombieUmbreon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float verticalVelocity)
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
		float sneak = 0.45F;

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

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float fallingModifier = 0;

		if(newVerticalVelocity < 0)
			fallingModifier = newVerticalVelocity;

		float fallingLegAngle = (float)Math.toRadians(25);

		/**/
		JointAnimation.reverseJointRotatesChange(bodyInfo, legFntRtInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legFntLftInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckRtInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, legBckLftInfo);

		//( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));

		legFntRtInfo.setNewRotateX(legFntRtInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legFntRtModifier, horzVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)) + fallingLegAngle * fallingModifier);
		legFntLftInfo.setNewRotateX(legFntLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)) + fallingLegAngle * fallingModifier);
		legBckRtInfo.setNewRotateX(legBckRtInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckRtModifier, horzVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)));
		legBckLftInfo.setNewRotateX(legBckLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved + legBckLftModifier, horzVelocity, this.RUN_FREQUENCY, amplitude) * (1F - Math.abs(newVerticalVelocity)));
	}

	public void animateTail(EntityZombieUmbreon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float angularVelocity, float verticalVelocity)
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

		tailInfo[0][1].setNewRotateX(tailInfo[0][1].getNewRotateX() + bodyJumpAngle * newVerticalVelocity);
		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float moveAmplitude = 0.15F * (1/(i+1));

			float idleAmplitudeX = 0.40F;
			float idleAmplitudeY = 0.50F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += (MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, this.RUN_FREQUENCY, moveAmplitude))
					* (1F - (Math.pow(Math.E, -0.4F * (float)(i + 1))))
					+ verticalVelocity * verticalVelocityChangeAngle;
			angleChangeY += ((MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY)
					* (1F - (Math.pow(Math.E, -0.4F * (float)(i + 1)))) * (1F - Math.abs(angularVelocity))) * (1F - (Math.abs(verticalVelocity) * 0.5F))
					+ angularVelocity * yawChangeAngle;

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());
		this.animationDeployer.rotate(muzzle, muzzleInfo.getNewRotates());

		this.animationDeployer.rotate(legFntRt, legFntRtInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legBckRt, legBckRtInfo.getNewRotates());
		this.animationDeployer.rotate(legBckLft, legBckLftInfo.getNewRotates());

		for(int i = 0; i < earLft.length; i++)
		{
			this.animationDeployer.rotate(earLft[i][0], earLftInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(earLft[i][1], earLftInfo[i][1].getNewRotates());
		}

		for(int i = 0; i < earRt.length; i++)
		{
			this.animationDeployer.rotate(earRt[i][0], earRtInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(earRt[i][1], earRtInfo[i][1].getNewRotates());
		}

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}