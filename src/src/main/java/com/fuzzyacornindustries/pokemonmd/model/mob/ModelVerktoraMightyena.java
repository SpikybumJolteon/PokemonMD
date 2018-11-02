package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityVerktoraMightyena;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVerktoraMightyena extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 1.1F;

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
    
    public ModelRenderer neckJoint;
    public ModelRenderer neck;
	PartInfo neckJointInfo;
	PartInfo neckInfo;

    public ModelRenderer headFaceJoint;
    public ModelRenderer headFace;
	PartInfo headFaceJointInfo;
	PartInfo headFaceInfo;
    
    public ModelRenderer head;
    public ModelRenderer headMuzzle;
    public ModelRenderer headNose;
    
    public ModelRenderer headJaw;
	PartInfo headJawInfo;
    
    public ModelRenderer headLowerFaceJoint;
    public ModelRenderer headLowerFace;
	PartInfo headLowerFaceJointInfo;
	PartInfo headLowerFaceInfo;
    
    public ModelRenderer headLower;
    public ModelRenderer headLowerMuzzle;
    public ModelRenderer headLowerNose;
    
    public ModelRenderer headLowerJaw;
	PartInfo headLowerJawInfo;

	public ModelRenderer tail[][] = new ModelRenderer[13][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

    public ModelVerktoraMightyena() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

        this.body = new ModelRenderer(this, 28, 46);
        this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.body.addBox(-3.0F, -3.0F, -6.0F, 6, 6, 12, 0.0F);
        bodyInfo = new PartInfo(body);

        this.legFntLft = new ModelRenderer(this, 28, 31);
        this.legFntLft.setRotationPoint(1.4F, 2.5F, -3.4F);
        this.legFntLft.addBox(-1.5F, -0.5F, -1.5F, 3, 7, 3, 0.0F);
        legFntLftInfo = new PartInfo(legFntLft);
        this.legFntRt = new ModelRenderer(this, 52, 31);
        this.legFntRt.setRotationPoint(-1.4F, 2.5F, -3.5F);
        this.legFntRt.addBox(-1.5F, -0.5F, -1.5F, 3, 7, 3, 0.0F);
        legFntRtInfo = new PartInfo(legFntRt);
        this.legBckLft = new ModelRenderer(this, 28, 41);
        this.legBckLft.setRotationPoint(1.4F, 2.5F, 4.1F);
        this.legBckLft.addBox(-1.5F, -1.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(legBckLft, -0.17453292519943295F, -0.0F, 0.0F);
        this.legBckLft.setTextureOffset(28, 49).addBox(-1.49F, 1.5F, 0.0F, 3, 5, 3, 0.0F); // legBckLftHind
        legBckLftInfo = new PartInfo(legBckLft);
        this.legBckRt = new ModelRenderer(this, 52, 41);
        this.legBckRt.setRotationPoint(-1.4F, 2.5F, 4.0F);
        this.legBckRt.addBox(-1.5F, -1.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(legBckRt, -0.17453292519943295F, -0.0F, 0.0F);
        this.legBckRt.setTextureOffset(52, 49).addBox(-1.51F, 1.5F, 0.0F, 3, 5, 3, 0.0F); // legBckRtHind
        legBckRtInfo = new PartInfo(legBckRt);

        this.neckJoint = new ModelRenderer(this, 50, 24);
        this.neckJoint.setRotationPoint(0.0F, -1.6F, -4.6F);
        this.neckJoint.addBox(-1.5F, -1.5F, -4.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(neckJoint, -0.3490658503988659F, 0.0F, 0.0F);
        neckJointInfo = new PartInfo(neckJoint);
        this.neck = new ModelRenderer(this, 50, 24);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-1.5F, -1.5F, -4.0F, 3, 3, 4, 0.0F);
        neckInfo = new PartInfo(neck);

        this.headFaceJoint = new ModelRenderer(this, 0, 11);
        this.headFaceJoint.setRotationPoint(0.0F, 0.0F, -3.3F);
        this.headFaceJoint.addBox(-2.6F, -2.3F, -4.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headFaceJoint, 0.3490658503988659F, 0.0F, 0.0F);
        headFaceJointInfo = new PartInfo(headFaceJoint);
        this.headFace = new ModelRenderer(this, 0, 11);
        this.headFace.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFace.addBox(-2.51F, -2.3F, -4.5F, 5, 5, 1, 0.0F);
        headFaceInfo = new PartInfo(headFace);

        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-2.5F, -3.0F, -4.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(head, 0.17453292519943295F, 0.0F, 0.0F);
        this.headMuzzle = new ModelRenderer(this, 12, 11);
        this.headMuzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headMuzzle.addBox(-1.0F, -0.8F, -7.1F, 2, 2, 3, 0.0F);
        this.setRotateAngle(headMuzzle, 0.17453292519943295F, -0.0F, 0.0F);
        this.headNose = new ModelRenderer(this, 15, 17);
        this.headNose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headNose.addBox(-0.5F, 0.4F, -7.3F, 1, 1, 1, 0.0F);

        this.headJaw = new ModelRenderer(this, 20, 9);
        this.headJaw.setRotationPoint(0.0F, 1.5F, -4.1F);
        this.headJaw.addBox(-1.01F, 0.1F, -2.6F, 2, 1, 3, 0.0F);
        this.setRotateAngle(headJaw, 0.08726646259971647F, -0.0F, 0.0F);
        headJawInfo = new PartInfo(headJaw);

        this.headLowerFaceJoint = new ModelRenderer(this, 17, 35);
        this.headLowerFaceJoint.setRotationPoint(0.0F, 2.0F, -5.4F);
        this.headLowerFaceJoint.addBox(-2.1F, -1.9F, -4.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headLowerFaceJoint, 0.08726646259971647F, -0.0F, 0.0F);
        headLowerFaceJointInfo = new PartInfo(headLowerFaceJoint);
        this.headLowerFace = new ModelRenderer(this, 17, 35);
        this.headLowerFace.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headLowerFace.addBox(-2.01F, -1.9F, -4.0F, 4, 4, 1, 0.0F);
        headLowerFaceInfo = new PartInfo(headLowerFace);

        this.headLower = new ModelRenderer(this, 0, 39);
        this.headLower.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headLower.addBox(-2.0F, -2.5F, -3.5F, 4, 4, 4, 0.0F);
        this.setRotateAngle(headLower, 0.17453292519943295F, -0.0F, 0.0F);
        this.headLowerMuzzle = new ModelRenderer(this, 6, 34);
        this.headLowerMuzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headLowerMuzzle.addBox(-1.0F, -1.0F, -5.63F, 2, 2, 3, 0.0F);
        this.setRotateAngle(headLowerMuzzle, 0.2617993877991494F, 0.0F, 0.0F);
        this.headLowerNose = new ModelRenderer(this, 13, 33);
        this.headLowerNose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headLowerNose.addBox(-0.5F, -0.4F, -5.9F, 1, 1, 1, 0.0F);
        this.setRotateAngle(headLowerNose, 0.17453292519943295F, -0.0F, 0.0F);

        this.headLowerJaw = new ModelRenderer(this, 0, 34);
        this.headLowerJaw.setRotationPoint(0.0F, 1.5F, -3.0F);
        this.headLowerJaw.addBox(-1.01F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(headLowerJaw, 0.17453292519943295F, -0.0F, 0.0F);
        headLowerJawInfo = new PartInfo(headLowerJaw);

        int tailNumber = 0;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 0); // tail1Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -1.5F, 5.5F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 0); // tail1
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 3, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 31, 5); // tail2Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.4F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 5); // tail2
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.4F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 31, 9); // tail3Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 9); // tail3
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 31, 13); // tail4Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 13); // tail4
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 31, 17); // tail5Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 17); // tail5
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 31, 21); // tail6Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 31, 21); // tail6
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 37, 23); // tail7Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 37, 23); // tail7
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 43, 21); // tail8Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 43, 21); // tail8
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 43, 17); // tail9Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 43, 17); // tail9
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 43, 13); // tail10Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 43, 13); // tail10
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 44, 10); // tail11Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 44, 10); // tail11
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 44, 7); // tail12Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 44, 7); // tail12
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 44, 4); // tail13Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.1F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 44, 4); // tail13
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.1F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

        this.body.addChild(this.legBckLft);
        this.body.addChild(this.legBckRt);
        this.body.addChild(this.legFntLft);
        this.body.addChild(this.legFntRt);
        this.body.addChild(this.neckJoint);
        this.body.addChild(this.headLowerFaceJoint);
        this.body.addChild(this.tail[0][0]); // tail1Joint

        this.neckJoint.addChild(this.neck);
        this.neck.addChild(this.headFaceJoint);

        this.headFaceJoint.addChild(this.headFace);
        this.headFace.addChild(this.head);
        this.headFace.addChild(this.headJaw);
        this.headFace.addChild(this.headMuzzle);
        this.headFace.addChild(this.headNose);

        this.headLowerFaceJoint.addChild(this.headLowerFace);
        this.headLowerFace.addChild(this.headLower);
        this.headLowerFace.addChild(this.headLowerJaw);
        this.headLowerFace.addChild(this.headLowerMuzzle);
        this.headLowerFace.addChild(this.headLowerNose);

        this.tail[0][0].addChild(this.tail[0][1]);
        
		for(int i = 1; i < tail.length; i++)
		{
	        this.tail[i - 1][1].addChild(this.tail[i][0]);
	        this.tail[i][0].addChild(this.tail[i][1]);
		}

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

		animateBody((EntityVerktoraMightyena)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityVerktoraMightyena)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityVerktoraMightyena)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityVerktoraMightyena)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headFaceJointInfo.resetNewAngles();
		headFaceInfo.resetNewAngles();
		headLowerFaceInfo.resetNewAngles();

		headJawInfo.resetNewAngles();
		headLowerJawInfo.resetNewAngles();

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

	public void animateBody(EntityVerktoraMightyena entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.2F;

		bodyInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
	}
	
	public void animateHead(EntityVerktoraMightyena entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, neckJointInfo);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble();

		float idleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		float movementAmplitude = 0.2F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX);
		neckInfo.setNewRotateY(neckInfo.getNewRotateY());

		JointAnimation.reverseJointRotatesChange(neckInfo, headFaceJointInfo);

		PartAnimate.headAnimateInfoOnly(headFaceInfo, yawHeadOffsetDifference, pitchRotation);
		PartAnimate.headAnimateInfoOnly(headLowerFaceInfo, yawHeadOffsetDifference, pitchRotation);
		
		/* ******* Main Jaw ******** */
		currentIdleAnimationClock = entity.getIdleAnimationClockJawMain();

		idleAmplitudeX = 0.35F;
		float jittleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		angleChangeX = 0;
		
		if(currentIdleAnimationClock.getPhaseDurationCoveredX(0) < 1F)
		{
			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI) * idleAmplitudeX + idleAmplitudeX;

			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * 5 * PI) * jittleAmplitudeX + jittleAmplitudeX;
		}
		else
		{
			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(1) * PI + PI) * idleAmplitudeX + idleAmplitudeX;
		}

		float newAngleX = headJawInfo.getNewRotateX() + angleChangeX;

		headJawInfo.setNewRotateX(newAngleX);

		/* ******* Lower Jaw ******** */
		currentIdleAnimationClock = entity.getIdleAnimationClockJawLower();

		angleChangeX = 0;

		if(currentIdleAnimationClock.getPhaseDurationCoveredX(0) < 1F)
		{
			idleAmplitudeX = 0.2F;
			
			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI * 6) * idleAmplitudeX + idleAmplitudeX;
		}
		else if(currentIdleAnimationClock.getPhaseDurationCoveredX(1) < 1F)
		{
			idleAmplitudeX = 0.4F;
			
			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(1) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;
		}
		else
		{
			idleAmplitudeX = 0.4F;
			
			angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(2) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;
		}
		
		newAngleX = headLowerJawInfo.getNewRotateX() + angleChangeX;

		headLowerJawInfo.setNewRotateX(newAngleX);
	}

	public void animateLegs(EntityVerktoraMightyena entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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

	public void animateTail(EntityVerktoraMightyena entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = 0.18F;
			float idleAmplitudeY = 0.22F;
			
			float moveAmplitude = 0.05F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, moveAmplitude);
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY;

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
		this.animationDeployer.rotate(headLowerFace, headLowerFaceInfo.getNewRotates());

		this.animationDeployer.rotate(headJaw, headJawInfo.getNewRotates());
		this.animationDeployer.rotate(headLowerJaw, headLowerJawInfo.getNewRotates());

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