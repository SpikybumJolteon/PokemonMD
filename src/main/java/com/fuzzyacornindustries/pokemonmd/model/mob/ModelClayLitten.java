package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayLitten;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelClayLitten extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 2.0F;

    public ModelRenderer body;
    public ModelRenderer neckJoint;
    public ModelRenderer neck;
	PartInfo bodyInfo;
	PartInfo neckJointInfo;
	PartInfo neckInfo;
    
    public ModelRenderer bodyHairFnt;
    public ModelRenderer bodyHairMid;
    public ModelRenderer bodyHairBck;
	PartInfo bodyHairFntInfo;
	PartInfo bodyHairMidInfo;
	PartInfo bodyHairBckInfo;
    
    public ModelRenderer legFntLft;
    public ModelRenderer legFntRt;
    public ModelRenderer legBckLft;
    public ModelRenderer legBckRt;
	PartInfo legFntLftInfo;
	PartInfo legFntRtInfo;
	PartInfo legBckLftInfo;
	PartInfo legBckRtInfo;
    
    public ModelRenderer headJoint;
    public ModelRenderer head;
    public ModelRenderer nose;
	PartInfo headJointInfo;
	PartInfo headInfo;

    public ModelRenderer headHairRt;
    public ModelRenderer headHairLft;
    
    public ModelRenderer whiskerLftTop;
    public ModelRenderer whiskerLftBot;
    public ModelRenderer whiskerRtTop;
    public ModelRenderer whiskerRtBot;
	PartInfo whiskerLftTopInfo;
	PartInfo whiskerLftBotInfo;
	PartInfo whiskerRtTopInfo;
	PartInfo whiskerRtBotInfo;
    
    public ModelRenderer earLftJoint;
    public ModelRenderer earLft;
    public ModelRenderer earRtJoint;
    public ModelRenderer earRt;
	PartInfo earLftJointInfo;
	PartInfo earRtJointInfo;

	public ModelRenderer tail[][] = new ModelRenderer[5][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];
    
    public ModelRenderer tailTipTopLft;
    public ModelRenderer tailTipTopRt;
    public ModelRenderer tailTipBotLft;
    public ModelRenderer tailTipBotRt;

    public ModelClayLitten() 
    {
        this.textureWidth = 64;
        this.textureHeight = 32;

		int jointNumber = 0;
		int partNumber = 1;

        this.body = new ModelRenderer(this, 48, 24);
        this.body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.body.addBox(-1.5F, -1.5F, -2.5F, 3, 3, 5, 0.0F);
		bodyInfo = new PartInfo(body);
        this.neckJoint = new ModelRenderer(this, 0, 0);
        this.neckJoint.setRotationPoint(0.0F, -0.8F, -1.8F);
        this.neckJoint.addBox(-0.5F, -0.5F, -2.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(neckJoint, -0.7853981633974483F, 0.0F, 0.0F);
        neckJointInfo = new PartInfo(neckJoint);
        this.neck = new ModelRenderer(this, 0, 9);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
        neckInfo = new PartInfo(neck);

        this.bodyHairFnt = new ModelRenderer(this, 50, 20);
        this.bodyHairFnt.setRotationPoint(0.0F, -1.2F, -0.8F);
        this.bodyHairFnt.addBox(-0.5F, -1.7F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(bodyHairFnt, 0.17453292519943295F, 0.0F, 0.0F);
        bodyHairFntInfo = new PartInfo(bodyHairFnt);
        this.bodyHairMid = new ModelRenderer(this, 55, 19);
        this.bodyHairMid.setRotationPoint(0.0F, -1.2F, 0.0F);
        this.bodyHairMid.addBox(-0.5F, -2.7F, -0.5F, 1, 3, 1, 0.0F);
        bodyHairMidInfo = new PartInfo(bodyHairMid);
        this.bodyHairBck = new ModelRenderer(this, 60, 20);
        this.bodyHairBck.setRotationPoint(0.0F, -1.2F, 0.8F);
        this.bodyHairBck.addBox(-0.5F, -1.7F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(bodyHairBck, -0.17453292519943295F, 0.0F, 0.0F);
        bodyHairBckInfo = new PartInfo(bodyHairBck);

        this.legFntLft = new ModelRenderer(this, 5, 21);
        this.legFntLft.setRotationPoint(0.7F, 1.0F, -1.5F);
        this.legFntLft.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        legFntLftInfo = new PartInfo(legFntLft);
        this.legFntRt = new ModelRenderer(this, 0, 21);
        this.legFntRt.setRotationPoint(-0.7F, 1.0F, -1.5F);
        this.legFntRt.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        legFntRtInfo = new PartInfo(legFntRt);

        this.legBckLft = new ModelRenderer(this, 5, 26);
        this.legBckLft.setRotationPoint(0.7F, 1.0F, 1.5F);
        this.legBckLft.addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(legBckLft, -0.17453292519943295F, 0.0F, 0.0F);
		this.legBckLft.setTextureOffset(5, 29).addBox(-0.49F, 1.0F, 0.0F, 1, 2, 1, 0.0F); // legBckLftHind
		legBckLftInfo = new PartInfo(legBckLft);

        this.legBckRt = new ModelRenderer(this, 0, 26);
        this.legBckRt.setRotationPoint(-0.7F, 1.0F, 1.5F);
        this.legBckRt.addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(legBckRt, -0.17453292519943295F, 0.0F, 0.0F);
		this.legBckRt.setTextureOffset(0, 29).addBox(-0.51F, 1.0F, 0.0F, 1, 2, 1, 0.0F); // legBckRtHind
		legBckRtInfo = new PartInfo(legBckRt);

        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.headJoint.addBox(-2.0F, -3.0F, -3.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headJoint, 0.7853981633974483F, 0.0F, 0.0F);
        headJointInfo = new PartInfo(headJoint);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-2.0F, -3.0F, -3.0F, 4, 4, 4, 0.0F);
        headInfo = new PartInfo(head);
        this.nose = new ModelRenderer(this, 6, 9);
        this.nose.setRotationPoint(0.0F, -0.2F, -2.7F);
        this.nose.addBox(-0.5F, -0.5F, -0.9F, 1, 1, 1, 0.0F);
        this.setRotateAngle(nose, 0.17453292519943295F, 0.0F, 0.0F);

        this.headHairRt = new ModelRenderer(this, 11, 9);
        this.headHairRt.setRotationPoint(-0.3F, -2.8F, -2.2F);
        this.headHairRt.addBox(-0.5F, -1.2F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(headHairRt, 0.0F, 0.0F, -0.3490658503988659F);
        this.headHairLft = new ModelRenderer(this, 16, 9);
        this.headHairLft.setRotationPoint(0.3F, -2.8F, -2.2F);
        this.headHairLft.addBox(-0.5F, -1.2F, -0.51F, 1, 2, 1, 0.0F);
        this.setRotateAngle(headHairLft, 0.0F, 0.0F, 0.3490658503988659F);

        this.whiskerLftTop = new ModelRenderer(this, 6, 14);
        this.whiskerLftTop.setRotationPoint(1.6F, 0.0F, -2.3F);
        this.whiskerLftTop.addBox(0.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(whiskerLftTop, 0.0F, 0.0F, 0.2617993877991494F);
        whiskerLftTopInfo = new PartInfo(whiskerLftTop);
        this.whiskerLftBot = new ModelRenderer(this, 6, 16);
        this.whiskerLftBot.setRotationPoint(1.6F, 0.4F, -2.3F);
        this.whiskerLftBot.addBox(0.0F, -0.5F, -0.51F, 2, 1, 1, 0.0F);
        this.setRotateAngle(whiskerLftBot, 0.0F, 0.0F, 0.6108652381980153F);
        whiskerLftBotInfo = new PartInfo(whiskerLftBot);
        this.whiskerRtTop = new ModelRenderer(this, 0, 14);
        this.whiskerRtTop.setRotationPoint(-1.6F, 0.0F, -2.3F);
        this.whiskerRtTop.addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(whiskerRtTop, 0.0F, 0.0F, -0.2617993877991494F);
        whiskerRtTopInfo = new PartInfo(whiskerRtTop);
        this.whiskerRtBot = new ModelRenderer(this, 0, 16);
        this.whiskerRtBot.setRotationPoint(-1.6F, 0.4F, -2.3F);
        this.whiskerRtBot.addBox(-2.0F, -0.5F, -0.51F, 2, 1, 1, 0.0F);
        this.setRotateAngle(whiskerRtBot, 0.0F, 0.0F, -0.6108652381980153F);
        whiskerRtBotInfo = new PartInfo(whiskerRtBot);

        this.earLftJoint = new ModelRenderer(this, 0, 0);
        this.earLftJoint.setRotationPoint(1.3F, -2.7F, -1.0F);
        this.earLftJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earLftJoint, 0.0F, 0.0F, 0.3490658503988659F);
        earLftJointInfo = new PartInfo(earLftJoint);
        this.earLft = new ModelRenderer(this, 24, 3);
        this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earLft.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLft.setTextureOffset(25, 0).addBox(-0.5F, -1.9F, -0.49F, 1, 1, 1, 0.0F); // earLftTip
        this.earRtJoint = new ModelRenderer(this, 0, 0);
        this.earRtJoint.setRotationPoint(-1.3F, -2.7F, -1.0F);
        this.earRtJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earRtJoint, 0.0F, 0.0F, -0.3490658503988659F);
        earRtJointInfo = new PartInfo(earRtJoint);
        this.earRt = new ModelRenderer(this, 17, 3);
        this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earRt.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRt.setTextureOffset(18, 0).addBox(-0.5F, -1.9F, -0.49F, 1, 1, 1, 0.0F); // earRtTip

        int tailNumber = 0;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -0.8F, 2.3F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 0); // tail1
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 3); // tail2
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 6); // tail3
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 9); // tail4
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 12); // tail5
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        
        this.tailTipTopLft = new ModelRenderer(this, 34, 16);
        this.tailTipTopLft.setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailTipTopLft.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipTopLft, 0.6981317007977318F, 0.0F, 0.7853981633974483F);
        this.tailTipTopRt = new ModelRenderer(this, 28, 16);
        this.tailTipTopRt.setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailTipTopRt.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipTopRt, 0.6981317007977318F, 0.0F, -0.7853981633974483F);
        this.tailTipBotLft = new ModelRenderer(this, 34, 19);
        this.tailTipBotLft.setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailTipBotLft.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipBotLft, -0.6981317007977318F, 0.0F, -0.7853981633974483F);
        this.tailTipBotRt = new ModelRenderer(this, 28, 19);
        this.tailTipBotRt.setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailTipBotRt.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipBotRt, -0.6981317007977318F, 0.0F, 0.7853981633974483F);

        this.body.addChild(this.bodyHairBck);
        this.body.addChild(this.bodyHairFnt);
        this.body.addChild(this.bodyHairMid);
        this.body.addChild(this.legBckLft);
        this.body.addChild(this.legBckRt);
        this.body.addChild(this.legFntLft);
        this.body.addChild(this.legFntRt);
        this.body.addChild(this.neckJoint);
        this.body.addChild(this.tail[0][0]);

        this.neckJoint.addChild(this.neck);
        this.neck.addChild(this.headJoint);
        
        this.headJoint.addChild(this.head);
        this.head.addChild(this.earLftJoint);
        this.head.addChild(this.earRtJoint);
        this.head.addChild(this.headHairLft);
        this.head.addChild(this.headHairRt);
        this.head.addChild(this.nose);
        
        this.head.addChild(this.whiskerLftBot);
        this.head.addChild(this.whiskerLftTop);
        this.head.addChild(this.whiskerRtBot);
        this.head.addChild(this.whiskerRtTop);

        this.earLftJoint.addChild(this.earLft);
        this.earRtJoint.addChild(this.earRt);

		this.tail[0][0].addChild(this.tail[0][1]);

		for(int i = 1; i < tail.length; i++)
		{
			this.tail[i - 1][1].addChild(this.tail[i][0]);
			this.tail[i][0].addChild(this.tail[i][1]);
		}
        
        this.tail[4][1].addChild(this.tailTipBotLft);
        this.tail[4][1].addChild(this.tailTipBotRt);
        this.tail[4][1].addChild(this.tailTipTopLft);
        this.tail[4][1].addChild(this.tailTipTopRt);

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

		animateBody((EntityClayLitten)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityClayLitten)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityClayLitten)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityClayLitten)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();

		headInfo.resetNewAngles();
		headJointInfo.resetNewAngles();

		earRtJointInfo.resetNewAngles();
		earLftJointInfo.resetNewAngles();

		legFntRtInfo.resetNewAngles();
		legFntLftInfo.resetNewAngles();
		legBckRtInfo.resetNewAngles();
		legBckLftInfo.resetNewAngles();

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}
    
	public void animateBody(EntityClayLitten entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.2F;

		bodyInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
	}

	public void animateHead(EntityClayLitten entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, neckJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckInfo, yawHeadOffsetDifference, pitchRotation, 0.2F, 0.2F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble();

		float idleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		float movementAmplitude = 0.20F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX);

		JointAnimation.reverseJointRotatesChange(neckInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.9F, 0.9F);

		/* ******* Ears ******** */
		float moveAmplitudeZ = 0.35F;

		float firstAngleChangeZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, moveAmplitudeZ);

		float idleAmplitudeZ = 0.20F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = firstAngleChangeZ;

		angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ;

		earRtJointInfo.setNewRotateZ(earRtJointInfo.getNewRotateZ() - angleChangeZ - (float)Math.toRadians(10));
		earLftJointInfo.setNewRotateZ(earLftJointInfo.getNewRotateZ() + angleChangeZ + (float)Math.toRadians(10));
	}

	public void animateLegs(EntityClayLitten entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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

		//System.out.println( "Test Model Parameters in Tiberium Model class" );
		//System.out.println( "Velocity = " + Float.toString( velocity ) );
	}

	public void animateTail(EntityClayLitten entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		float idleAmplitudeX = 0.45F;
		float idleAmplitudeY = 0.45F;

		float moveAmplitude = 0.05F;

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += (MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, moveAmplitude))
					* ( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));
			angleChangeY += (MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY)
					* ( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));

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

		this.animationDeployer.rotate(earLftJoint, earLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(earRtJoint, earRtJointInfo.getNewRotates());

		this.animationDeployer.rotate(legFntRt, legFntRtInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legBckRt, legBckRtInfo.getNewRotates());
		this.animationDeployer.rotate(legBckLft, legBckLftInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}