package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityCujoFurfrou;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCujoFurfrou extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 1.5F;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	PartInfo neckJointInfo;
	PartInfo neckInfo;

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
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer muzzle;
	public ModelRenderer nose;
	public ModelRenderer headHair;
	public ModelRenderer headHairTop;
	public ModelRenderer headHairHornLft;
	public ModelRenderer headHairHornRt;

	public ModelRenderer earLft[] = new ModelRenderer[5];
	PartInfo earLftInfo[] = new PartInfo[earLft.length];

	public ModelRenderer earRt[] = new ModelRenderer[5];
	PartInfo earRtInfo[] = new PartInfo[earRt.length];

	public ModelRenderer tail[][] = new ModelRenderer[9][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];
	
	public ModelRenderer tail9TipLft;
	public ModelRenderer tail9TipRt;

	public ModelCujoFurfrou() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 34, 49);
		this.body.setRotationPoint(0.0F, 15.5F, 0.0F);
		this.body.addBox(-2.5F, -2.5F, -5.0F, 5, 5, 10, 0.0F);
        bodyInfo = new PartInfo(body);

		this.neckJoint = new ModelRenderer(this, 15, 55);
		this.neckJoint.setRotationPoint(0.0F, -1.3F, -3.9F);
		this.neckJoint.addBox(-1.0F, -1.0F, -7.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, -0.7853981633974483F, 0.0F, 0.0F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 15, 55);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-1.0F, -1.0F, -7.0F, 2, 2, 7, 0.0F);
		neckInfo = new PartInfo(neck);

		this.legFntLft = new ModelRenderer(this, 54, 13);
		this.legFntLft.setRotationPoint(1.1F, 1.5F, -3.0F);
		this.legFntLft.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.legFntLft.setTextureOffset(52, 20).addBox(-1.1F, 4.0F, -1.5F, 3, 2, 3, 0.0F); // legFntLftHair
        this.legFntLft.setTextureOffset(54, 26).addBox(-1.0F, 6.0F, -1.0F, 2, 1, 2, 0.0F); // legFntLftPaw
        legFntLftInfo = new PartInfo(legFntLft);
		this.legFntRt = new ModelRenderer(this, 36, 13);
		this.legFntRt.setRotationPoint(-1.1F, 1.5F, -3.0F);
		this.legFntRt.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.legFntRt.setTextureOffset(34, 20).addBox(-1.9F, 4.0F, -1.5F, 3, 2, 3, 0.0F); // legFntRtHair
        this.legFntRt.setTextureOffset(36, 26).addBox(-1.0F, 6.0F, -1.0F, 2, 1, 2, 0.0F); // legFntRtPaw
        legFntRtInfo = new PartInfo(legFntRt);
		this.legBckLft = new ModelRenderer(this, 54, 31);
		this.legBckLft.setRotationPoint(1.1F, 1.5F, 3.5F);
		this.legBckLft.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2, 0.0F);
		this.setRotateAngle(legBckLft, -0.17453292519943295F, 0.0F, 0.0F);
        this.legBckLft.setTextureOffset(54, 39).addBox(-1.01F, 3.0F, 0.0F, 2, 1, 2, 0.0F); // legBckLftHind
        this.legBckLft.setTextureOffset(52, 43).addBox(-1.1F, 4.0F, -0.5F, 3, 2, 3, 0.0F); // legBckLftHair
        this.legBckLft.setTextureOffset(55, 49).addBox(-1.05F, 6.0F, 0.0F, 2, 1, 2, 0.0F); // legBckLftPaw
        legBckLftInfo = new PartInfo(legBckLft);
		this.legBckRt = new ModelRenderer(this, 36, 31);
		this.legBckRt.setRotationPoint(-1.1F, 1.5F, 3.5F);
		this.legBckRt.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2, 0.0F);
		this.setRotateAngle(legBckRt, -0.17453292519943295F, 0.0F, 0.0F);
        this.legBckRt.setTextureOffset(36, 39).addBox(-0.99F, 3.0F, 0.0F, 2, 1, 2, 0.0F); // legBckRtHind
        this.legBckRt.setTextureOffset(34, 43).addBox(-1.9F, 4.0F, -0.5F, 3, 2, 3, 0.0F); // legBckRtHair
        this.legBckRt.setTextureOffset(35, 49).addBox(-0.95F, 6.0F, 0.0F, 2, 1, 2, 0.0F); // legBckRtPaw
        legBckRtInfo = new PartInfo(legBckRt);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, 0.0F, -6.5F);
		this.headJoint.addBox(-2.0F, -3.0F, -3.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, 0.7853981633974483F, 0.0F, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -3.0F, -3.0F, 4, 4, 4, 0.0F);
		headInfo = new PartInfo(head);

		this.muzzle = new ModelRenderer(this, 18, 4);
		this.muzzle.setRotationPoint(0.0F, -0.2F, -2.0F);
		this.muzzle.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 4, 0.0F);
		this.setRotateAngle(muzzle, 0.17453292519943295F, 0.0F, 0.0F);
		this.nose = new ModelRenderer(this, 17, 5);
		this.nose.setRotationPoint(0.0F, -0.2F, -2.0F);
		this.nose.addBox(-0.6F, -0.9F, -3.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(nose, 0.17453292519943295F, 0.0F, 0.0F);
		this.headHair = new ModelRenderer(this, 44, 0);
		this.headHair.setRotationPoint(0.0F, -3.0F, -1.0F);
		this.headHair.addBox(-2.5F, -0.9F, -2.5F, 5, 2, 5, 0.0F);
		this.setRotateAngle(headHair, -0.17453292519943295F, 0.0F, 0.0F);
		this.headHairTop = new ModelRenderer(this, 27, 1);
		this.headHairTop.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.headHairTop.addBox(-2.0F, -1.2F, -2.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(headHairTop, -0.17453292519943295F, 0.0F, 0.0F);
		this.headHairHornLft = new ModelRenderer(this, 40, 0);
		this.headHairHornLft.setRotationPoint(1.0F, 0.0F, -2.0F);
		this.headHairHornLft.addBox(-0.5F, -2.7F, -1.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(headHairHornLft, 0.4363323129985824F, 0.0F, 0.0F);
		this.headHairHornRt = new ModelRenderer(this, 26, 0);
		this.headHairHornRt.setRotationPoint(-1.0F, 0.0F, -2.0F);
		this.headHairHornRt.addBox(-0.5F, -2.7F, -1.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(headHairHornRt, 0.4363323129985824F, 0.0F, 0.0F);

		int earLftNumber = 0;
		this.earLft[earLftNumber] = new ModelRenderer(this, 10, 9); // earLft1
		this.earLft[earLftNumber].setRotationPoint(2.0F, -1.0F, -0.5F);
		this.earLft[earLftNumber].addBox(-1.0F, -0.5F, -0.5F, 2, 2, 1, 0.0F);
        earLftInfo[earLftNumber] = new PartInfo(earLft[earLftNumber]);
		earLftNumber++;
		this.earLft[earLftNumber] = new ModelRenderer(this, 11, 13); // earLft2
		this.earLft[earLftNumber].setRotationPoint(0.5F, 1.3F, 0.0F);
		this.earLft[earLftNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
        earLftInfo[earLftNumber] = new PartInfo(earLft[earLftNumber]);
		earLftNumber++;
		this.earLft[earLftNumber] = new ModelRenderer(this, 11, 17); // earLft3
		this.earLft[earLftNumber].setRotationPoint(0.0F, 1.6F, 0.0F);
		this.earLft[earLftNumber].addBox(-0.5F, -0.1F, -0.5F, 1, 2, 1, 0.0F);
        earLftInfo[earLftNumber] = new PartInfo(earLft[earLftNumber]);
		earLftNumber++;
		this.earLft[earLftNumber] = new ModelRenderer(this, 11, 21); // earLft4
		this.earLft[earLftNumber].setRotationPoint(0.0F, 1.6F, 0.0F);
		this.earLft[earLftNumber].addBox(-0.5F, -0.1F, -0.5F, 1, 2, 1, 0.0F);
        earLftInfo[earLftNumber] = new PartInfo(earLft[earLftNumber]);
		earLftNumber++;
		this.earLft[earLftNumber] = new ModelRenderer(this, 10, 25); // earLft5
		this.earLft[earLftNumber].setRotationPoint(0.0F, 1.6F, 0.0F);
		this.earLft[earLftNumber].addBox(-1.0F, -0.1F, -0.5F, 2, 1, 1, 0.0F);
        this.earLft[earLftNumber].setTextureOffset(9, 28).addBox(-1.5F, 0.9F, -0.5F, 3, 1, 1, 0.0F); // earLft5Mid
        this.earLft[earLftNumber].setTextureOffset(10, 31).addBox(-1.0F, 1.9F, -0.5F, 2, 1, 1, 0.0F); // earLft5End
        this.earLft[earLftNumber].setTextureOffset(11, 34).addBox(-0.5F, 2.9F, -0.5F, 1, 1, 1, 0.0F); // earLft5Tip
        earLftInfo[earLftNumber] = new PartInfo(earLft[earLftNumber]);

        int earRtNumber = 0;
		this.earRt[earRtNumber] = new ModelRenderer(this, 1, 9); // earRt1
		this.earRt[earRtNumber].setRotationPoint(-2.0F, -1.0F, -0.5F);
		this.earRt[earRtNumber].addBox(-1.0F, -0.5F, -0.5F, 2, 2, 1, 0.0F);
        earRtInfo[earRtNumber] = new PartInfo(earRt[earRtNumber]);
		earRtNumber++;
		this.earRt[earRtNumber] = new ModelRenderer(this, 2, 13); // earRt2
		this.earRt[earRtNumber].setRotationPoint(-0.5F, 1.3F, 0.0F);
		this.earRt[earRtNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
        earRtInfo[earRtNumber] = new PartInfo(earRt[earRtNumber]);
		earRtNumber++;
		this.earRt[earRtNumber] = new ModelRenderer(this, 2, 17); // earRt3
		this.earRt[earRtNumber].setRotationPoint(0.0F, 1.6F, 0.0F);
		this.earRt[earRtNumber].addBox(-0.5F, -0.1F, -0.5F, 1, 2, 1, 0.0F);
        earRtInfo[earRtNumber] = new PartInfo(earRt[earRtNumber]);
		earRtNumber++;
		this.earRt[earRtNumber] = new ModelRenderer(this, 2, 21); // earRt4
		this.earRt[earRtNumber].setRotationPoint(0.0F, 1.6F, 0.0F);
		this.earRt[earRtNumber].addBox(-0.5F, -0.1F, -0.5F, 1, 2, 1, 0.0F);
        earRtInfo[earRtNumber] = new PartInfo(earRt[earRtNumber]);
		earRtNumber++;
		this.earRt[earRtNumber] = new ModelRenderer(this, 1, 25); // earRt5
		this.earRt[earRtNumber].setRotationPoint(0.0F, 1.6F, 0.0F);
		this.earRt[earRtNumber].addBox(-1.0F, -0.1F, -0.5F, 2, 1, 1, 0.0F);
        this.earRt[earRtNumber].setTextureOffset(0, 28).addBox(-1.5F, 0.9F, -0.5F, 3, 1, 1, 0.0F); // earRt5Mid
        this.earRt[earRtNumber].setTextureOffset(1, 31).addBox(-1.0F, 1.9F, -0.5F, 2, 1, 1, 0.0F); // earRt5End
        this.earRt[earRtNumber].setTextureOffset(2, 34).addBox(-0.5F, 2.9F, -0.5F, 1, 1, 1, 0.0F); // earRt5Tip
        earRtInfo[earRtNumber] = new PartInfo(earRt[earRtNumber]);

        int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 24, 16); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -1.5F, 4.5F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 24, 16); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 21); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.3F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 21); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 25); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 25); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 29); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 29); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 33); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 33); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 37); // tail6Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 37); // tail6
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 41); // tail7Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 41); // tail7
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 45); // tail8Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 45); // tail8
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 49); // tail9Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 49); // tail9
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		
		this.tail9TipLft = new ModelRenderer(this, 29, 50);
		this.tail9TipLft.setRotationPoint(0.0F, 0.0F, 1.0F);
		this.tail9TipLft.addBox(0.0F, -0.45F, -0.2F, 1, 1, 3, 0.0F);
		this.setRotateAngle(tail9TipLft, 0.0F, 0.17453292519943295F, 0.0F);
		this.tail9TipRt = new ModelRenderer(this, 19, 50);
		this.tail9TipRt.setRotationPoint(0.0F, 0.0F, 1.0F);
		this.tail9TipRt.addBox(-1.0F, -0.55F, -0.2F, 1, 1, 3, 0.0F);
		this.setRotateAngle(tail9TipRt, 0.0F, -0.17453292519943295F, 0.0F);

		this.body.addChild(this.legBckLft);
		this.body.addChild(this.legBckRt);
		this.body.addChild(this.legFntLft);
		this.body.addChild(this.legFntRt);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.tail[0][0]);
		
		this.neckJoint.addChild(this.neck);
		this.neck.addChild(this.headJoint);
		this.headJoint.addChild(this.head);
		
		this.head.addChild(this.headHair);
		this.head.addChild(this.muzzle);
		this.head.addChild(this.nose);
		this.head.addChild(this.earLft[0]);
		this.head.addChild(this.earRt[0]);
		
		this.headHair.addChild(this.headHairHornLft);
		this.headHair.addChild(this.headHairHornRt);
		this.headHair.addChild(this.headHairTop);

		this.earLft[0].addChild(this.earLft[1]); // earLft1 * earLft2
		this.earLft[1].addChild(this.earLft[2]); // earLft2 * earLft3
		this.earLft[2].addChild(this.earLft[3]); // earLft3 * earLft4
		this.earLft[3].addChild(this.earLft[4]); // earLft4 * earLft5
		
		this.earRt[0].addChild(this.earRt[1]); // earRt1 * earRt2
		this.earRt[1].addChild(this.earRt[2]); // earRt2 * earRt3
		this.earRt[2].addChild(this.earRt[3]); // earRt3 * earRt4
		this.earRt[3].addChild(this.earRt[4]); // earRt4 * earRt5

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
		this.tail[5][1].addChild(this.tail[6][0]); // tail6 * tail7Joint
		this.tail[6][0].addChild(this.tail[6][1]); // tail7Joint * tail7
		this.tail[6][1].addChild(this.tail[7][0]); // tail7 * tail8Joint
		this.tail[7][0].addChild(this.tail[7][1]); // tail8Joint * tail8
        this.tail[7][1].addChild(this.tail[8][0]); // tail8 * tail9Joint
        this.tail[8][0].addChild(this.tail[8][1]); // tail9Joint * tail9

		this.tail[8][1].addChild(this.tail9TipLft); // tail9
		this.tail[8][1].addChild(this.tail9TipRt); // tail9

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

		animateBody((EntityCujoFurfrou)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityCujoFurfrou)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateEars((EntityCujoFurfrou)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityCujoFurfrou)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityCujoFurfrou)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

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
		
		for(int i = 0; i < earLftInfo.length; i++)
		{
			earRtInfo[i].resetNewAngles();
		}
		
		for(int i = 0; i < earLftInfo.length; i++)
		{
			earLftInfo[i].resetNewAngles();
		}

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}
    
	public void animateBody(EntityCujoFurfrou entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.16F;

		bodyInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
	}
	
	public void animateHead(EntityCujoFurfrou entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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

		JointAnimation.reverseJointRotatesChange(neckInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.75F, 0.75F);
	}
	
	public void animateEars(EntityCujoFurfrou entity, float distanceMoved, float velocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float moveAmplitudeX = 0.1F;

		float moveAmplitudeZ = 0.1F;

		float firstAngleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, velocity, movementFrequency, moveAmplitudeX);
		float firstAngleChangeZ = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, velocity, movementFrequency, moveAmplitudeZ);

		earRtInfo[0].setNewRotateX(firstAngleChangeX - headInfo.getNewRotateX());
		earRtInfo[0].setNewRotateZ(firstAngleChangeZ);
		earLftInfo[0].setNewRotateX(firstAngleChangeX - headInfo.getNewRotateX());
		earLftInfo[0].setNewRotateZ(-firstAngleChangeZ);
		
		for(int i = 1; i < earRt.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockEars(i);

			float frequencyIdleX = 1F;
			float frequencyIdleZ = 1F;

			float amplitudeIdleX = 0.10F * (1F - velocity);
			float amplitudeIdleZ = 0.15F * (1F - velocity);

			// + (float)Math.toRadians(45)
			float angleChangeX = firstAngleChangeX;
			float angleChangeZ = firstAngleChangeZ;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 * frequencyIdleX) * amplitudeIdleX * 
					( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));
			angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2 * frequencyIdleZ) * amplitudeIdleZ * 
					( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));
			
			earRtInfo[i].setNewRotateX(angleChangeX);
			earRtInfo[i].setNewRotateZ(angleChangeZ);

			earLftInfo[i].setNewRotateX(angleChangeX);
			earLftInfo[i].setNewRotateZ(-angleChangeZ);
		}
	}

	public void animateLegs(EntityCujoFurfrou entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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

	public void animateTail(EntityCujoFurfrou entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = 0.19F;
			float idleAmplitudeY = 0.25F;
			
			float moveAmplitude = 0.1F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX;
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, moveAmplitude);

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

		this.animationDeployer.rotate(legFntRt, legFntRtInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legBckRt, legBckRtInfo.getNewRotates());
		this.animationDeployer.rotate(legBckLft, legBckLftInfo.getNewRotates());

		for(int i = 0; i < earLft.length; i++)
		{
			this.animationDeployer.rotate(earLft[i], earLftInfo[i].getNewRotates());
		}

		for(int i = 0; i < earRt.length; i++)
		{
			this.animationDeployer.rotate(earRt[i], earRtInfo[i].getNewRotates());
		}
		
		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}