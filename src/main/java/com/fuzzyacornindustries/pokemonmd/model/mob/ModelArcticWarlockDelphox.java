package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArcticWarlockDelphox extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public final float RUN_FREQUENCY = 0.6F;
	public final float WALK_FREQUENCY = 1.2F;
	public final float SNEAK_VELOCITY = 0.45F;

	public ModelRenderer bodyJoint;
	public ModelRenderer body;
	public PartInfo bodyJointInfo;
	public PartInfo bodyInfo;

	public ModelRenderer legs[][] = new ModelRenderer[2][2];
	public PartInfo legsInfo[][] = new PartInfo[legs.length][legs[0].length];

	public ModelRenderer skirtFnt[][] = new ModelRenderer[3][2];
	public PartInfo skirtFntInfo[][] = new PartInfo[skirtFnt.length][skirtFnt[0].length];

	public ModelRenderer skirtBck[][] = new ModelRenderer[3][2];
	public PartInfo skirtBckInfo[][] = new PartInfo[skirtBck.length][skirtBck[0].length];

	public ModelRenderer skirtRt[][] = new ModelRenderer[4][2];
	public PartInfo skirtRtInfo[][] = new PartInfo[skirtRt.length][skirtRt[0].length];

	public ModelRenderer skirtLft[][] = new ModelRenderer[4][2];
	public PartInfo skirtLftInfo[][] = new PartInfo[skirtLft.length][skirtLft[0].length];

	public ModelRenderer armRtBaseJoint;
	public ModelRenderer armRtBase;
	public ModelRenderer armRtEndJoint;
	public ModelRenderer armRtEnd;
	public PartInfo armRtBaseJointInfo;
	public PartInfo armRtBaseInfo;
	public PartInfo armRtEndJointInfo;
	public PartInfo armRtEndInfo;

	public ModelRenderer armRtFingerRt;
	public ModelRenderer armRtFingerLft;

	public ModelRenderer armRtFluff[][] = new ModelRenderer[3][2];
	public PartInfo armRtFluffInfo[][] = new PartInfo[armRtFluff.length][armRtFluff[0].length];

	public ModelRenderer armLftBaseJoint;
	public ModelRenderer armLftBase;
	public ModelRenderer armLftEndJoint;
	public ModelRenderer armLftEnd;
	public PartInfo armLftBaseJointInfo;
	public PartInfo armLftBaseInfo;
	public PartInfo armLftEndJointInfo;
	public PartInfo armLftEndInfo;

	public ModelRenderer armLftFingerRt;
	public ModelRenderer armLftFingerLft;

	public ModelRenderer armLftFluff[][] = new ModelRenderer[3][2];
	public PartInfo armLftFluffInfo[][] = new PartInfo[armLftFluff.length][armLftFluff[0].length];

	public ModelRenderer staffJoint;
	public ModelRenderer staff;
	public PartInfo staffJointInfo;
	public PartInfo staffInfo;

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	public PartInfo neckJointInfo;
	public PartInfo neckInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	public PartInfo headJointInfo;
	public PartInfo headInfo;

	public ModelRenderer muzzle;

	public ModelRenderer earLftJoint;
	public ModelRenderer earLft;
	public ModelRenderer earRtJoint;
	public ModelRenderer earRt;
	public PartInfo earLftJointInfo;
	public PartInfo earLftInfo;
	public PartInfo earRtJointInfo;
	public PartInfo earRtInfo;

	public ModelRenderer earLftTuffMainJoint;
	public ModelRenderer earLftTuffTop[] = new ModelRenderer[2];
	public ModelRenderer earLftTuffMain[] = new ModelRenderer[3];
	public ModelRenderer earLftTuffBot[] = new ModelRenderer[2];
	public PartInfo earLftTuffTopInfo[] = new PartInfo[earLftTuffTop.length];
	public PartInfo earLftTuffMainInfo[] = new PartInfo[earLftTuffMain.length];
	public PartInfo earLftTuffBotInfo[] = new PartInfo[earLftTuffBot.length];

	public ModelRenderer earRtTuffMainJoint;
	public ModelRenderer earRtTuffTop[] = new ModelRenderer[2];
	public ModelRenderer earRtTuffMain[] = new ModelRenderer[3];
	public ModelRenderer earRtTuffBot[] = new ModelRenderer[2];
	public PartInfo earRtTuffTopInfo[] = new PartInfo[earRtTuffTop.length];
	public PartInfo earRtTuffMainInfo[] = new PartInfo[earRtTuffMain.length];
	public PartInfo earRtTuffBotInfo[] = new PartInfo[earRtTuffBot.length];

	public ModelRenderer cheekFluff[][] = new ModelRenderer[2][2];
	public PartInfo cheekFluffInfo[][] = new PartInfo[cheekFluff.length][cheekFluff[0].length];

	public ModelRenderer tail[][] = new ModelRenderer[7][2];
	public PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelArcticWarlockDelphox() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.bodyJoint = new ModelRenderer(this, 14, 9);
		this.bodyJoint.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.bodyJoint.addBox(-2.0F, -8.0F, -2.0F, 0, 0, 0, 0.0F);
		this.bodyJointInfo = new PartInfo(this.bodyJoint);
		this.body = new ModelRenderer(this, 14, 9);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-2.0F, -8.0F, -2.0F, 4, 9, 4, 0.0F);
		this.bodyInfo = new PartInfo(this.body);

		int legNumber = 0;
		this.legs[legNumber][jointNumber] = new ModelRenderer(this, 44, 22); // legLftJoint
		this.legs[legNumber][jointNumber].setRotationPoint(1.1F, 1.0F, 0.0F);
		this.legs[legNumber][jointNumber].addBox(-1.0F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legs[legNumber][jointNumber], -0.17453292519943295F, 0.0F, 0.0F);
		this.legsInfo[legNumber][jointNumber] = new PartInfo(this.legs[legNumber][jointNumber]);
		this.legs[legNumber][partNumber] = new ModelRenderer(this, 44, 22); // legLft
		this.legs[legNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legs[legNumber][partNumber].addBox(-1.0F, -1.5F, -1.0F, 2, 7, 2, 0.0F);
		this.legs[legNumber][partNumber].setTextureOffset(36, 25).addBox(-1.0F, 3.0F, 1.0F, 2, 7, 2, 0.0F); // legLftEnd
		this.legsInfo[legNumber][partNumber] = new PartInfo(this.legs[legNumber][partNumber]);
		legNumber++;
		this.legs[legNumber][jointNumber] = new ModelRenderer(this, 44, 22); // legRtJoint
		this.legs[legNumber][jointNumber].setRotationPoint(-1.1F, 1.0F, 0.0F);
		this.legs[legNumber][jointNumber].addBox(-1.0F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legs[legNumber][jointNumber], -0.17453292519943295F, 0.0F, 0.0F);
		this.legsInfo[legNumber][jointNumber] = new PartInfo(this.legs[legNumber][jointNumber]);
		this.legs[legNumber][partNumber] = new ModelRenderer(this, 44, 22); // legRt
		this.legs[legNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legs[legNumber][partNumber].addBox(-1.0F, -1.5F, -1.0F, 2, 7, 2, 0.0F);
		this.legs[legNumber][partNumber].setTextureOffset(36, 25).addBox(-1.0F, 3.0F, 1.0F, 2, 7, 2, 0.0F); // legRtEnd
		this.legsInfo[legNumber][partNumber] = new PartInfo(this.legs[legNumber][partNumber]);

		int skirtPartNumber = 0;
		this.skirtFnt[skirtPartNumber][jointNumber] = new ModelRenderer(this, 14, 22); // skirtFnt1Joint
		this.skirtFnt[skirtPartNumber][jointNumber].setRotationPoint(0.0F, -1.0F, -1.5F);
		this.skirtFnt[skirtPartNumber][jointNumber].addBox(-2.5F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(skirtFnt[skirtPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.skirtFntInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtFnt[skirtPartNumber][jointNumber]);
		this.skirtFnt[skirtPartNumber][partNumber] = new ModelRenderer(this, 14, 22); // skirtFnt1
		this.skirtFnt[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtFnt[skirtPartNumber][partNumber].addBox(-2.5F, 0.0F, -1.0F, 5, 4, 2, 0.0F);
		this.skirtFntInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtFnt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtFnt[skirtPartNumber][jointNumber] = new ModelRenderer(this, 18, 28); // skirtFnt2Joint
		this.skirtFnt[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
		this.skirtFnt[skirtPartNumber][jointNumber].addBox(-3.5F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.skirtFntInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtFnt[skirtPartNumber][jointNumber]);
		this.skirtFnt[skirtPartNumber][partNumber] = new ModelRenderer(this, 18, 28); // skirtFnt2
		this.skirtFnt[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtFnt[skirtPartNumber][partNumber].addBox(-3.5F, 0.0F, -1.0F, 7, 4, 2, 0.0F);
		this.skirtFntInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtFnt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtFnt[skirtPartNumber][jointNumber] = new ModelRenderer(this, 22, 34); // skirtFnt3Joint
		this.skirtFnt[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
		this.skirtFnt[skirtPartNumber][jointNumber].addBox(-4.5F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.skirtFntInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtFnt[skirtPartNumber][jointNumber]);
		this.skirtFnt[skirtPartNumber][partNumber] = new ModelRenderer(this, 22, 34); // skirtFnt3
		this.skirtFnt[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtFnt[skirtPartNumber][partNumber].addBox(-4.5F, 0.0F, -1.0F, 9, 3, 2, 0.0F);
		this.skirtFntInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtFnt[skirtPartNumber][partNumber]);

		skirtPartNumber = 0;
		this.skirtBck[skirtPartNumber][jointNumber] = new ModelRenderer(this, 0, 21); // skirtBck1Joint
		this.skirtBck[skirtPartNumber][jointNumber].setRotationPoint(0.0F, -1.0F, 1.5F);
		this.skirtBck[skirtPartNumber][jointNumber].addBox(-2.5F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(skirtBck[skirtPartNumber][jointNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.skirtBckInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtBck[skirtPartNumber][jointNumber]);
		this.skirtBck[skirtPartNumber][partNumber] = new ModelRenderer(this, 0, 21); // skirtBck1
		this.skirtBck[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtBck[skirtPartNumber][partNumber].addBox(-2.5F, 0.0F, -1.0F, 5, 5, 2, 0.0F);
		this.skirtBckInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtBck[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtBck[skirtPartNumber][jointNumber] = new ModelRenderer(this, 0, 28); // skirtBck2Joint
		this.skirtBck[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 4.5F, 0.0F);
		this.skirtBck[skirtPartNumber][jointNumber].addBox(-3.5F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.skirtBckInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtBck[skirtPartNumber][jointNumber]);
		this.skirtBck[skirtPartNumber][partNumber] = new ModelRenderer(this, 0, 28); // skirtBck2
		this.skirtBck[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtBck[skirtPartNumber][partNumber].addBox(-3.5F, 0.0F, -1.0F, 7, 4, 2, 0.0F);
		this.skirtBckInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtBck[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtBck[skirtPartNumber][jointNumber] = new ModelRenderer(this, 0, 34); // skirtBck3Joint
		this.skirtBck[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
		this.skirtBck[skirtPartNumber][jointNumber].addBox(-4.5F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.skirtBckInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtBck[skirtPartNumber][jointNumber]);
		this.skirtBck[skirtPartNumber][partNumber] = new ModelRenderer(this, 0, 34); // skirtBck3
		this.skirtBck[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtBck[skirtPartNumber][partNumber].addBox(-4.5F, 0.0F, -1.0F, 9, 4, 2, 0.0F);
		this.skirtBckInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtBck[skirtPartNumber][partNumber]);

		skirtPartNumber = 0;
		this.skirtRt[skirtPartNumber][jointNumber] = new ModelRenderer(this, 11, 40); // skirtRt1Joint
		this.skirtRt[skirtPartNumber][jointNumber].setRotationPoint(-2.0F, -1.0F, 0.0F);
		this.skirtRt[skirtPartNumber][jointNumber].addBox(-1.0F, 0.0F, -2.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(skirtRt[skirtPartNumber][jointNumber], 0.0F, 0.0F, 0.2617993877991494F);
		this.skirtRtInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtRt[skirtPartNumber][jointNumber]);
		this.skirtRt[skirtPartNumber][partNumber] = new ModelRenderer(this, 11, 40); // skirtRt1
		this.skirtRt[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtRt[skirtPartNumber][partNumber].addBox(-1.0F, 0.0F, -2.0F, 2, 3, 4, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtRt[skirtPartNumber][jointNumber] = new ModelRenderer(this, 0, 43); // skirtRt2Joint
		this.skirtRt[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.5F);
		this.skirtRt[skirtPartNumber][jointNumber].addBox(-1.0F, 0.0F, -2.5F, 0, 0, 0, 0.0F);
		this.skirtRtInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtRt[skirtPartNumber][jointNumber]);
		this.skirtRt[skirtPartNumber][partNumber] = new ModelRenderer(this, 0, 43); // skirtRt2
		this.skirtRt[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtRt[skirtPartNumber][partNumber].addBox(-0.99F, 0.0F, -3.0F, 2, 3, 6, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtRt[skirtPartNumber][jointNumber] = new ModelRenderer(this, 16, 39); // skirtRt3Joint
		this.skirtRt[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
		this.skirtRt[skirtPartNumber][jointNumber].addBox(-1.0F, 0.0F, -3.0F, 0, 0, 0, 0.0F);
		this.skirtRtInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtRt[skirtPartNumber][jointNumber]);
		this.skirtRt[skirtPartNumber][partNumber] = new ModelRenderer(this, 16, 39); // skirtRt3
		this.skirtRt[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtRt[skirtPartNumber][partNumber].addBox(-1.0F, 0.0F, -3.5F, 2, 3, 8, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtRt[skirtPartNumber][jointNumber] = new ModelRenderer(this, 28, 43); // skirtRt4Joint
		this.skirtRt[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.5F);
		this.skirtRt[skirtPartNumber][jointNumber].addBox(-0.99F, 0.0F, -5.0F, 0, 0, 0, 0.0F);
		this.skirtRtInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtRt[skirtPartNumber][jointNumber]);
		this.skirtRt[skirtPartNumber][partNumber] = new ModelRenderer(this, 28, 43); // skirtRt4
		this.skirtRt[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtRt[skirtPartNumber][partNumber].addBox(-0.99F, 0.0F, -5.0F, 2, 2, 10, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);

		skirtPartNumber = 0;
		this.skirtLft[skirtPartNumber][jointNumber] = new ModelRenderer(this, 44, 57); // skirtLft1Joint
		this.skirtLft[skirtPartNumber][jointNumber].setRotationPoint(2.0F, -1.0F, 0.0F);
		this.skirtLft[skirtPartNumber][jointNumber].addBox(-1.0F, 0.0F, -2.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(skirtLft[skirtPartNumber][jointNumber], 0.0F, 0.0F, -0.2617993877991494F);
		this.skirtLftInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtLft[skirtPartNumber][jointNumber]);
		this.skirtLft[skirtPartNumber][partNumber] = new ModelRenderer(this, 44, 57); // skirtLft1
		this.skirtLft[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtLft[skirtPartNumber][partNumber].addBox(-1.0F, 0.0F, -2.0F, 2, 3, 4, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtLft[skirtPartNumber][jointNumber] = new ModelRenderer(this, 28, 55); // skirtLft2Joint
		this.skirtLft[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.5F);
		this.skirtLft[skirtPartNumber][jointNumber].addBox(-1.01F, 0.0F, -3.0F, 0, 0, 0, 0.0F);
		this.skirtLftInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtLft[skirtPartNumber][jointNumber]);
		this.skirtLft[skirtPartNumber][partNumber] = new ModelRenderer(this, 28, 55); // skirtLft2
		this.skirtLft[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtLft[skirtPartNumber][partNumber].addBox(-1.01F, 0.0F, -3.0F, 2, 3, 6, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtLft[skirtPartNumber][jointNumber] = new ModelRenderer(this, 14, 50); // skirtLft3Joint
		this.skirtLft[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
		this.skirtLft[skirtPartNumber][jointNumber].addBox(-1.0F, 0.0F, -3.5F, 0, 0, 0, 0.0F);
		this.skirtLftInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtLft[skirtPartNumber][jointNumber]);
		this.skirtLft[skirtPartNumber][partNumber] = new ModelRenderer(this, 14, 50); // skirtLft3
		this.skirtLft[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtLft[skirtPartNumber][partNumber].addBox(-1.0F, 0.0F, -3.5F, 2, 3, 8, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);
		skirtPartNumber++;
		this.skirtLft[skirtPartNumber][jointNumber] = new ModelRenderer(this, 0, 52); // skirtLft4Joint
		this.skirtLft[skirtPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.5F);
		this.skirtLft[skirtPartNumber][jointNumber].addBox(-1.01F, 0.0F, -5.0F, 0, 0, 0, 0.0F);
		this.skirtLftInfo[skirtPartNumber][jointNumber] = new PartInfo(this.skirtLft[skirtPartNumber][jointNumber]);
		this.skirtLft[skirtPartNumber][partNumber] = new ModelRenderer(this, 0, 52); // skirtLft4
		this.skirtLft[skirtPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.skirtLft[skirtPartNumber][partNumber].addBox(-1.01F, 0.0F, -5.0F, 2, 2, 10, 0.0F);
		this.skirtRtInfo[skirtPartNumber][partNumber] = new PartInfo(this.skirtRt[skirtPartNumber][partNumber]);

		this.armRtBaseJoint = new ModelRenderer(this, 28, 0);
		this.armRtBaseJoint.setRotationPoint(-2.0F, -6.5F, -0.5F);
		this.armRtBaseJoint.addBox(-5.5F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtBaseJoint, 0.5235987755982988F, 1.3962634015954636F, 0.0F);
		this.armRtBaseJointInfo = new PartInfo(this.armRtBaseJoint);
		this.armRtBase = new ModelRenderer(this, 26, 4);
		this.armRtBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtBase.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 6, 0.0F);
		this.armRtBaseInfo = new PartInfo(this.armRtBase);
		this.armRtEndJoint = new ModelRenderer(this, 28, 4);
		this.armRtEndJoint.setRotationPoint(0.0F, 0.0F, -5.0F);
		this.armRtEndJoint.addBox(-1.0F, -1.0F, -5.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtEndJoint, -0.5235987755982988F, -1.3962634015954636F, 0.0F);
		this.armRtEndJointInfo = new PartInfo(this.armRtEndJoint);
		this.armRtEnd = new ModelRenderer(this, 34, 13);
		this.armRtEnd.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtEnd.addBox(-1.0F, -1.0F, -5.5F, 2, 2, 6, 0.0F);
		this.armRtEndInfo = new PartInfo(this.armRtEnd);

		this.armRtFingerRt = new ModelRenderer(this, 26, 8);
		this.armRtFingerRt.setRotationPoint(-0.4F, 0.05F, -5.5F);
		this.armRtFingerRt.addBox(-0.5F, -0.5F, -0.51F, 1, 1, 1, 0.0F);
		this.armRtFingerLft = new ModelRenderer(this, 26, 22);
		this.armRtFingerLft.setRotationPoint(0.4F, 0.0F, -5.5F);
		this.armRtFingerLft.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);

		int armFluffNumber = 0;
		this.armRtFluff[armFluffNumber][jointNumber] = new ModelRenderer(this, 30, 14); // armRtFluffFrontJoint
		this.armRtFluff[armFluffNumber][jointNumber].setRotationPoint(0.0F, 0.6F, -4.0F);
		this.armRtFluff[armFluffNumber][jointNumber].addBox(-0.5F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtFluff[armFluffNumber][jointNumber], 0.3490658503988659F, 0.0F, 0.6108652381980153F);
		this.armRtFluffInfo[armFluffNumber][jointNumber] = new PartInfo(this.armRtFluff[armFluffNumber][jointNumber]);
		this.armRtFluff[armFluffNumber][partNumber] = new ModelRenderer(this, 30, 14); // armRtFluffFront
		this.armRtFluff[armFluffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtFluff[armFluffNumber][partNumber].addBox(-0.5F, -0.5F, -1.0F, 1, 3, 2, 0.0F);
		this.armRtFluffInfo[armFluffNumber][partNumber] = new PartInfo(this.armRtFluff[armFluffNumber][partNumber]);
		armFluffNumber++;
		this.armRtFluff[armFluffNumber][jointNumber] = new ModelRenderer(this, 38, 3); // armRtFluffMidJoint
		this.armRtFluff[armFluffNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -3.0F);
		this.armRtFluff[armFluffNumber][jointNumber].addBox(-0.51F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtFluff[armFluffNumber][jointNumber], 0.3490658503988659F, 0.0F, 0.6108652381980153F);
		this.armRtFluffInfo[armFluffNumber][jointNumber] = new PartInfo(this.armRtFluff[armFluffNumber][jointNumber]);
		this.armRtFluff[armFluffNumber][partNumber] = new ModelRenderer(this, 38, 3); // armRtFluffMid
		this.armRtFluff[armFluffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtFluff[armFluffNumber][partNumber].addBox(-0.51F, 0.0F, -1.0F, 1, 5, 2, 0.0F);
		this.armRtFluff[armFluffNumber][partNumber].setTextureOffset(34, 14).addBox(-0.51F, 5.0F, -0.4F, 1, 1, 1, 0.0F); // armRtFluffMidTip
		this.armRtFluffInfo[armFluffNumber][partNumber] = new PartInfo(this.armRtFluff[armFluffNumber][partNumber]);
		armFluffNumber++;
		this.armRtFluff[armFluffNumber][jointNumber] = new ModelRenderer(this, 26, 0); // armRtFluffBackJoint
		this.armRtFluff[armFluffNumber][jointNumber].setRotationPoint(0.0F, 0.5F, -1.5F);
		this.armRtFluff[armFluffNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtFluff[armFluffNumber][jointNumber], 0.3490658503988659F, 0.0F, 0.6108652381980153F);
		this.armRtFluffInfo[armFluffNumber][jointNumber] = new PartInfo(this.armRtFluff[armFluffNumber][jointNumber]);
		this.armRtFluff[armFluffNumber][partNumber] = new ModelRenderer(this, 26, 0); // armRtFluffBack
		this.armRtFluff[armFluffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtFluff[armFluffNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.armRtFluffInfo[armFluffNumber][partNumber] = new PartInfo(this.armRtFluff[armFluffNumber][partNumber]);

		this.armLftBaseJoint = new ModelRenderer(this, 44, 2);
		this.armLftBaseJoint.setRotationPoint(2.0F, -6.5F, -0.5F);
		this.armLftBaseJoint.addBox(-1.0F, -1.0F, -5.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftBaseJoint, 0.9599310885968813F, -0.9599310885968813F, 0.0F);
		this.armLftBaseJointInfo = new PartInfo(this.armLftBaseJoint);
		this.armLftBase = new ModelRenderer(this, 44, 2);
		this.armLftBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftBase.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 6, 0.0F);
		this.armLftBaseInfo = new PartInfo(this.armLftBase);
		this.armLftEndJoint = new ModelRenderer(this, 44, 10);
		this.armLftEndJoint.setRotationPoint(0.0F, 0.0F, -5.0F);
		this.armLftEndJoint.addBox(-1.0F, -1.0F, -5.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftEndJoint, -0.08726646259971647F, 0.2617993877991494F, 0.0F);
		this.armLftEndJointInfo = new PartInfo(this.armLftEndJoint);
		this.armLftEnd = new ModelRenderer(this, 44, 10);
		this.armLftEnd.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftEnd.addBox(-1.0F, -1.0F, -5.5F, 2, 2, 6, 0.0F);
		this.armLftEndInfo = new PartInfo(this.armLftEnd);

		this.armLftFingerRt = new ModelRenderer(this, 52, 0);
		this.armLftFingerRt.setRotationPoint(-0.4F, 0.0F, -5.5F);
		this.armLftFingerRt.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.armLftFingerLft = new ModelRenderer(this, 58, 0);
		this.armLftFingerLft.setRotationPoint(0.4F, 0.05F, -5.5F);
		this.armLftFingerLft.addBox(-0.5F, -0.5F, -0.51F, 1, 1, 1, 0.0F);

		armFluffNumber = 0;
		this.armLftFluff[armFluffNumber][jointNumber] = new ModelRenderer(this, 44, 2); // armLftFluffFrontJoint
		this.armLftFluff[armFluffNumber][jointNumber].setRotationPoint(0.0F, 0.6F, -4.0F);
		this.armLftFluff[armFluffNumber][jointNumber].addBox(-0.5F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftFluff[armFluffNumber][jointNumber], -0.7853981633974483F, 0.0F, -0.2617993877991494F);
		this.armLftFluffInfo[armFluffNumber][jointNumber] = new PartInfo(this.armLftFluff[armFluffNumber][jointNumber]);
		this.armLftFluff[armFluffNumber][partNumber] = new ModelRenderer(this, 44, 2); // armLftFluffFront
		this.armLftFluff[armFluffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftFluff[armFluffNumber][partNumber].addBox(-0.5F, -0.5F, -1.0F, 1, 3, 2, 0.0F);
		this.armLftFluffInfo[armFluffNumber][partNumber] = new PartInfo(this.armLftFluff[armFluffNumber][partNumber]);
		armFluffNumber++;
		this.armLftFluff[armFluffNumber][jointNumber] = new ModelRenderer(this, 54, 0); // armLftFluffMidJoint
		this.armLftFluff[armFluffNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -3.0F);
		this.armLftFluff[armFluffNumber][jointNumber].addBox(-0.49F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftFluff[armFluffNumber][jointNumber], -0.7853981633974483F, 0.0F, -0.2617993877991494F);
		this.armLftFluffInfo[armFluffNumber][jointNumber] = new PartInfo(this.armLftFluff[armFluffNumber][jointNumber]);
		this.armLftFluff[armFluffNumber][partNumber] = new ModelRenderer(this, 54, 0); // armLftFluffMid
		this.armLftFluff[armFluffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftFluff[armFluffNumber][partNumber].addBox(-0.49F, 0.0F, -1.0F, 1, 5, 2, 0.0F);
		this.armLftFluff[armFluffNumber][partNumber].setTextureOffset(55, 10).addBox(-0.49F, 5.0F, -0.4F, 1, 1, 1, 0.0F); // armLftFluffMidTip
		this.armLftFluffInfo[armFluffNumber][partNumber] = new PartInfo(this.armLftFluff[armFluffNumber][partNumber]);
		armFluffNumber++;
		this.armLftFluff[armFluffNumber][jointNumber] = new ModelRenderer(this, 42, 0); // armLftFluffBackJoint
		this.armLftFluff[armFluffNumber][jointNumber].setRotationPoint(0.0F, 0.5F, -1.5F);
		this.armLftFluff[armFluffNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftFluff[armFluffNumber][jointNumber], -0.7853981633974483F, 0.0F, -0.2617993877991494F);
		this.armLftFluffInfo[armFluffNumber][jointNumber] = new PartInfo(this.armLftFluff[armFluffNumber][jointNumber]);
		this.armLftFluff[armFluffNumber][partNumber] = new ModelRenderer(this, 42, 0); // armLftFluffBack
		this.armLftFluff[armFluffNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftFluff[armFluffNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.armLftFluffInfo[armFluffNumber][partNumber] = new PartInfo(this.armLftFluff[armFluffNumber][partNumber]);

		this.staffJoint = new ModelRenderer(this, 60, 2);
		this.staffJoint.setRotationPoint(0.0F, 0.0F, -6.0F);
		this.staffJoint.addBox(-0.5F, -4.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(staffJoint, 0.3490658503988659F, 0.0F, 0.6108652381980153F);
		this.staffJointInfo = new PartInfo(this.staffJoint);
		this.staff = new ModelRenderer(this, 60, 2);
		this.staff.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.staff.addBox(-0.5F, -4.5F, -0.5F, 1, 20, 1, 0.0F);
		this.staff.setTextureOffset(34, 45).addBox(0.0F, 3.5F, 0.0F, 1, 1, 1, 0.0F); // staffEmberLow
		this.staff.setTextureOffset(28, 45).addBox(-1.0F, 1.5F, -1.0F, 1, 1, 1, 0.0F); // staffEmberMid
		this.staff.setTextureOffset(31, 43).addBox(0.0F, -2.0F, -1.0F, 1, 1, 1, 0.0F); // staffEmberHi
		this.staff.setTextureOffset(34, 41).addBox(0.5F, -4.0F, -0.5F, 2, 1, 1, 0.0F); // staffHeadLft
		this.staff.setTextureOffset(28, 39).addBox(-1.0F, -6.5F, 0.0F, 1, 4, 1, 0.0F); // staffHeadRtLow
		this.staff.setTextureOffset(36, 39).addBox(-1.5F, -6.0F, -0.5F, 3, 1, 1, 0.0F); // staffHeadRtTop
		this.staffInfo = new PartInfo(this.staff);

		this.neckJoint = new ModelRenderer(this, 30, 21);
		this.neckJoint.setRotationPoint(0.0F, -7.5F, 0.0F);
		this.neckJoint.addBox(-1.0F, -2.8F, -1.0F, 0, 0, 0, 0.0F);
		this.neckJointInfo = new PartInfo(this.neckJoint);
		this.neck = new ModelRenderer(this, 30, 21);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-1.0F, -2.8F, -1.0F, 2, 3, 2, 0.0F);
		this.neckInfo = new PartInfo(this.neck);

		this.headJoint = new ModelRenderer(this, 14, 0);
		this.headJoint.setRotationPoint(0.0F, -2.5F, 0.0F);
		this.headJoint.addBox(-2.0F, -3.5F, -2.5F, 4, 4, 4, 0.0F);
		this.headJointInfo = new PartInfo(this.headJoint);
		this.head = new ModelRenderer(this, 14, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -3.5F, -2.5F, 4, 4, 4, 0.0F);
		this.headInfo = new PartInfo(this.head);

		this.muzzle = new ModelRenderer(this, 14, 0);
		this.muzzle.setRotationPoint(0.0F, -0.7F, -2.0F);
		this.muzzle.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(muzzle, 0.3490658503988659F, -0.0F, 0.0F);

		this.earLftJoint = new ModelRenderer(this, 0, 53);
		this.earLftJoint.setRotationPoint(1.5F, -2.8F, -0.5F);
		this.earLftJoint.addBox(-1.5F, -2.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.0F, 0.0F, 0.17453292519943295F);
		this.earLftJointInfo = new PartInfo(this.earLftJoint);
		this.earLft = new ModelRenderer(this, 0, 53);
		this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft.addBox(-1.5F, -2.5F, 0.0F, 3, 3, 1, 0.0F);
		this.earLft.setTextureOffset(0, 42).addBox(-1.0F, -4.5F, 0.0F, 2, 2, 1, 0.0F); // earLftMid
		this.earLft.setTextureOffset(16, 55).addBox(-0.5F, -5.5F, 0.0F, 1, 1, 1, 0.0F); // earLftEnd
		this.earLftInfo = new PartInfo(this.earLft);

		this.earRtJoint = new ModelRenderer(this, 0, 57);
		this.earRtJoint.setRotationPoint(-1.5F, -2.8F, -0.5F);
		this.earRtJoint.addBox(-1.5F, -2.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.0F, 0.0F, -0.17453292519943295F);
		this.earRtJointInfo = new PartInfo(this.earRtJoint);
		this.earRt = new ModelRenderer(this, 0, 57);
		this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt.addBox(-1.5F, -2.5F, 0.0F, 3, 3, 1, 0.0F);
		this.earRt.setTextureOffset(0, 45).addBox(-1.0F, -4.5F, 0.0F, 2, 2, 1, 0.0F); // earRtMid
		this.earRt.setTextureOffset(16, 53).addBox(-0.5F, -5.5F, 0.0F, 1, 1, 1, 0.0F); // earRtEnd
		this.earRtInfo = new PartInfo(this.earRt);

		this.earLftTuffMainJoint = new ModelRenderer(this, 0, 0);
		this.earLftTuffMainJoint.setRotationPoint(1.0F, -2.0F, -0.5F);
		this.earLftTuffMainJoint.addBox(-0.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftTuffMainJoint, 0.0F, 0.2617993877991494F, -0.2617993877991494F);
		
		this.earLftTuffTop[0] = new ModelRenderer(this, 8, 0); // earLftTuffTop
		this.earLftTuffTop[0].setRotationPoint(1.3F, -0.7F, 0.1F);
		this.earLftTuffTop[0].addBox(0.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.setRotateAngle(earLftTuffTop[0], 0.0F, 0.0F, -0.5235987755982988F);
		this.earLftTuffTop[1] = new ModelRenderer(this, 0, 4); // earLftTuffTopEnd
		this.earLftTuffTop[1].setRotationPoint(1.7F, 0.0F, 0.0F);
		this.earLftTuffTop[1].addBox(0.1F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.earLftTuffMain[0] = new ModelRenderer(this, 0, 0); // earLftTuffMain
		this.earLftTuffMain[0].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLftTuffMain[0].addBox(-0.5F, -1.5F, -0.5F, 3, 3, 1, 0.0F);
		this.earLftTuffMain[1] = new ModelRenderer(this, 8, 3); // earLftTuffMainMid
		this.earLftTuffMain[1].setRotationPoint(2.5F, 0.0F, 0.0F);
		this.earLftTuffMain[1].addBox(-0.5F, -1.0F, -0.51F, 2, 2, 1, 0.0F);
		this.earLftTuffMain[2] = new ModelRenderer(this, 0, 6); // earLftTuffMainEnd
		this.earLftTuffMain[2].setRotationPoint(1.2F, 0.0F, 0.0F);
		this.earLftTuffMain[2].addBox(0.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.earLftTuffBot[0] = new ModelRenderer(this, 8, 6); // earLftTuffBot
		this.earLftTuffBot[0].setRotationPoint(0.5F, 1.0F, 0.1F);
		this.earLftTuffBot[0].addBox(0.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.setRotateAngle(earLftTuffBot[0], 0.0F, 0.0F, 0.3490658503988659F);
		this.earLftTuffBot[1] = new ModelRenderer(this, 4, 4); // earLftTuffBotEnd
		this.earLftTuffBot[1].setRotationPoint(1.9F, 0.0F, 0.0F);
		this.earLftTuffBot[1].addBox(-0.2F, -0.5F, -0.5F, 1, 1, 1, 0.0F);

		this.earRtTuffMainJoint = new ModelRenderer(this, 6, 17);
		this.earRtTuffMainJoint.setRotationPoint(-1.0F, -2.0F, -0.5F);
		this.earRtTuffMainJoint.addBox(-3.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtTuffMainJoint, 0.0F, -0.2617993877991494F, 0.2617993877991494F);
		
		this.earRtTuffTop[0] = new ModelRenderer(this, 0, 12); // earRtTuffTop
		this.earRtTuffTop[0].setRotationPoint(-1.3F, -0.7F, 0.1F);
		this.earRtTuffTop[0].addBox(-1.8F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.setRotateAngle(earRtTuffTop[0], 0.0F, 0.0F, 0.5235987755982988F);
		this.earRtTuffTop[1] = new ModelRenderer(this, 6, 15); // earRtTuffTopEnd
		this.earRtTuffTop[1].setRotationPoint(-1.7F, 0.0F, 0.0F);
		this.earRtTuffTop[1].addBox(-1.1F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.earRtTuffMain[0] = new ModelRenderer(this, 6, 17); // earRtTuffMain
		this.earRtTuffMain[0].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRtTuffMain[0].addBox(-2.5F, -1.5F, -0.5F, 3, 3, 1, 0.0F);
		this.earRtTuffMain[1] = new ModelRenderer(this, 0, 15); // earRtTuffMainMid
		this.earRtTuffMain[1].setRotationPoint(-2.5F, 0.0F, 0.0F);
		this.earRtTuffMain[1].addBox(-1.5F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRtTuffMain[2] = new ModelRenderer(this, 10, 13); // earRtTuffMainEnd
		this.earRtTuffMain[2].setRotationPoint(-1.2F, 0.0F, 0.0F);
		this.earRtTuffMain[2].addBox(-1.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.earRtTuffBot[0] = new ModelRenderer(this, 0, 18); // earRtTuffBot
		this.earRtTuffBot[0].setRotationPoint(-0.5F, 1.0F, 0.1F);
		this.earRtTuffBot[0].addBox(-2.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.setRotateAngle(earRtTuffBot[0], 0.0F, 0.0F, -0.3490658503988659F);
		this.earRtTuffBot[1] = new ModelRenderer(this, 10, 15); // earRtTuffBotEnd
		this.earRtTuffBot[1].setRotationPoint(-1.9F, 0.0F, 0.0F);
		this.earRtTuffBot[1].addBox(-0.7F, -0.5F, -0.5F, 1, 1, 1, 0.0F);

		int cheekFluffSide = 0;
		int cheekFluffNumber = 0;
		this.cheekFluff[cheekFluffSide][cheekFluffNumber] = new ModelRenderer(this, 43, 41); // cheekFluffRtTop
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].setRotationPoint(-1.5F, -0.5F, 0.0F);
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].addBox(-2.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(cheekFluff[cheekFluffSide][cheekFluffNumber], 0.08726646259971647F, 0.2617993877991494F, 0.17453292519943295F);
		this.cheekFluffInfo[cheekFluffSide][cheekFluffNumber] = new PartInfo(this.cheekFluff[cheekFluffSide][cheekFluffNumber]);
		cheekFluffNumber++;
		this.cheekFluff[cheekFluffSide][cheekFluffNumber] = new ModelRenderer(this, 44, 43); // cheekFluffRtBot
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(cheekFluff[cheekFluffSide][cheekFluffNumber], -0.0153588974175501F, 0.17383479349863523F, -0.08866272600131193F);
		this.cheekFluffInfo[cheekFluffSide][cheekFluffNumber] = new PartInfo(this.cheekFluff[cheekFluffSide][cheekFluffNumber]);
		cheekFluffNumber = 0;
		cheekFluffSide++;
		this.cheekFluff[cheekFluffSide][cheekFluffNumber] = new ModelRenderer(this, 43, 49); // cheekFluffLftTop
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].setRotationPoint(1.5F, -0.5F, 0.0F);
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
		this.setRotateAngle(cheekFluff[cheekFluffSide][cheekFluffNumber], 0.046425758103049164F, -0.2577851305195624F, -0.18064157758141308F);
		this.cheekFluffInfo[cheekFluffSide][cheekFluffNumber] = new PartInfo(this.cheekFluff[cheekFluffSide][cheekFluffNumber]);
		cheekFluffNumber++;
		this.cheekFluff[cheekFluffSide][cheekFluffNumber] = new ModelRenderer(this, 44, 51); // cheekFluffLftBot
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].setRotationPoint(1.5F, 0.0F, 0.0F);
		this.cheekFluff[cheekFluffSide][cheekFluffNumber].addBox(0.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(cheekFluff[cheekFluffSide][cheekFluffNumber], -0.0153588974175501F, -0.17383479349863523F, 0.08866272600131193F);
		this.cheekFluffInfo[cheekFluffSide][cheekFluffNumber] = new PartInfo(this.cheekFluff[cheekFluffSide][cheekFluffNumber]);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 53, 20); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -1.0F, 1.5F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 53, 20); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 52, 25); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.0F);
		this.tail[tailNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.08726646259971647F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 52, 25); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(tail[tailNumber][partNumber], -0.08726646259971647F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 44, 31); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.0F);
		this.tail[tailNumber][jointNumber].addBox(-2.6F, -2.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.08726646259971647F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 44, 31); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.6F, -2.5F, -0.5F, 5, 5, 5, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 48, 41); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][jointNumber].addBox(-2.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 48, 41); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.0F, -2.0F, -0.5F, 4, 4, 4, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 52, 49); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 3.0F);
		this.tail[tailNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 52, 49); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 54, 55); // tail6Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.0F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 54, 55); // tail6
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 56, 60); // tail7Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.0F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 56, 60); // tail7
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);



		this.armLftBase.addChild(this.armLftEndJoint);
		this.armLftBaseJoint.addChild(this.armLftBase);
		this.armLftEnd.addChild(this.armLftFingerLft);
		this.armLftEnd.addChild(this.armLftFingerRt);
		this.armLftEnd.addChild(this.armLftFluff[0][0]);
		this.armLftEnd.addChild(this.armLftFluff[1][0]);
		this.armLftEnd.addChild(this.armLftFluff[2][0]);
		this.armLftEndJoint.addChild(this.armLftEnd);
		this.armLftFluff[0][0].addChild(this.armLftFluff[0][1]);
		this.armLftFluff[1][0].addChild(this.armLftFluff[1][1]);
		this.armLftFluff[2][0].addChild(this.armLftFluff[2][1]);
		this.armRtBase.addChild(this.armRtEndJoint);
		this.armRtBaseJoint.addChild(this.armRtBase);
		this.armRtEnd.addChild(this.armRtFingerLft);
		this.armRtEnd.addChild(this.armRtFingerRt);
		this.armRtEnd.addChild(this.armRtFluff[0][0]);
		this.armRtEnd.addChild(this.armRtFluff[1][0]);
		this.armRtEnd.addChild(this.armRtFluff[2][0]);
		this.armRtEnd.addChild(this.staffJoint);
		this.armRtEndJoint.addChild(this.armRtEnd);
		this.armRtFluff[0][0].addChild(this.armRtFluff[0][1]);
		this.armRtFluff[1][0].addChild(this.armRtFluff[1][1]);
		this.armRtFluff[2][0].addChild(this.armRtFluff[2][1]);
		this.body.addChild(this.armLftBaseJoint);
		this.body.addChild(this.armRtBaseJoint);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.skirtBck[0][0]);
		this.body.addChild(this.skirtFnt[0][0]);
		this.body.addChild(this.skirtLft[0][0]);
		this.body.addChild(this.skirtRt[0][0]);
		this.body.addChild(this.tail[0][0]);
		this.bodyJoint.addChild(this.body);
		this.bodyJoint.addChild(this.legs[0][0]);
		this.bodyJoint.addChild(this.legs[1][0]);
		this.earLftJoint.addChild(this.earLft);
		this.earLftTuffBot[0].addChild(this.earLftTuffBot[1]);
		this.earLftTuffMain[0].addChild(this.earLftTuffMain[1]);
		this.earLftTuffMainJoint.addChild(this.earLftTuffBot[0]);
		this.earLftTuffMainJoint.addChild(this.earLftTuffMain[0]);
		this.earLftTuffMainJoint.addChild(this.earLftTuffTop[0]);
		this.earLftTuffMain[1].addChild(this.earLftTuffMain[2]);
		this.earLftTuffTop[0].addChild(this.earLftTuffTop[1]);
		this.earRtJoint.addChild(this.earRt);
		this.earRtTuffBot[0].addChild(this.earRtTuffBot[1]);
		this.earRtTuffMain[0].addChild(this.earRtTuffMain[1]);
		this.earRtTuffMainJoint.addChild(this.earRtTuffBot[0]);
		this.earRtTuffMainJoint.addChild(this.earRtTuffMain[0]);
		this.earRtTuffMainJoint.addChild(this.earRtTuffTop[0]);
		this.earRtTuffMain[1].addChild(this.earRtTuffMain[2]);
		this.earRtTuffTop[0].addChild(this.earRtTuffTop[1]);
		this.head.addChild(this.cheekFluff[0][0]);
		this.head.addChild(this.cheekFluff[0][1]);
		this.head.addChild(this.cheekFluff[1][0]);
		this.head.addChild(this.cheekFluff[1][1]);
		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earLftTuffMainJoint);
		this.head.addChild(this.earRtJoint);
		this.head.addChild(this.earRtTuffMainJoint);
		this.head.addChild(this.muzzle);
		this.headJoint.addChild(this.head);
		this.legs[0][0].addChild(this.legs[0][1]);
		this.legs[1][0].addChild(this.legs[1][1]);
		this.neck.addChild(this.headJoint);
		this.neckJoint.addChild(this.neck);
		
		for(int i = 0; i < skirtBck.length - 1; i++)
		{
			this.skirtBck[i][0].addChild(this.skirtBck[i][1]);
			this.skirtBck[i][1].addChild(this.skirtBck[i + 1][0]);

			this.skirtFnt[i][0].addChild(this.skirtFnt[i][1]);
			this.skirtFnt[i][1].addChild(this.skirtFnt[i + 1][0]);
		}

		this.skirtBck[skirtBck.length - 1][0].addChild(this.skirtBck[skirtBck.length- 1][1]);
		this.skirtFnt[skirtFnt.length - 1][0].addChild(this.skirtFnt[skirtFnt.length- 1][1]);

		for(int i = 0; i < skirtLft.length - 1; i++)
		{
			this.skirtLft[i][0].addChild(this.skirtLft[i][1]);
			this.skirtLft[i][1].addChild(this.skirtLft[i + 1][0]);

			this.skirtRt[i][0].addChild(this.skirtRt[i][1]);
			this.skirtRt[i][1].addChild(this.skirtRt[i + 1][0]);
		}

		this.skirtLft[skirtLft.length - 1][0].addChild(this.skirtLft[skirtLft.length- 1][1]);
		this.skirtRt[skirtRt.length - 1][0].addChild(this.skirtRt[skirtRt.length- 1][1]);

		this.staffJoint.addChild(this.staff);

		for(int i = 0; i < tail.length - 1; i++)
		{
			this.tail[i][0].addChild(this.tail[i][1]);
			this.tail[i][1].addChild(this.tail[i + 1][0]);
		}

		this.tail[tail.length - 1][0].addChild(this.tail[tail.length- 1][1]);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{
		this.bodyJoint.render(modelSize);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}