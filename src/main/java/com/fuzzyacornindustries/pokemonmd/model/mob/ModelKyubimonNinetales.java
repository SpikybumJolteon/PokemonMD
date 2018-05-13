package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKyubimonNinetales extends ModelBase 
{
	private AnimationDeployer animationDeployer;
	
    public ModelRenderer body;
	public PartInfo bodyInfo;
    
	public ModelRenderer legFntLft[][] = new ModelRenderer[2][2];
	public ModelRenderer legFntRt[][] = new ModelRenderer[2][2];
	public ModelRenderer legBckLft[][] = new ModelRenderer[3][2];
	public ModelRenderer legBckRt[][] = new ModelRenderer[3][2];
	public PartInfo legFntLftInfo[][] = new PartInfo[legFntLft.length][legFntLft[0].length];
	public PartInfo legFntRtInfo[][] = new PartInfo[legFntRt.length][legFntRt[0].length];
	public PartInfo legBckLftInfo[][] = new PartInfo[legBckLft.length][legBckLft[0].length];
	public PartInfo legBckRtInfo[][] = new PartInfo[legBckRt.length][legBckRt[0].length];
    
    public ModelRenderer neckJoint;
    public ModelRenderer neck;
	public PartInfo neckJointInfo;
	public PartInfo neckInfo;
    
    public ModelRenderer mane;
    public ModelRenderer maneRt;
    public ModelRenderer maneLft;
	public PartInfo maneInfo;
	public PartInfo maneRtInfo;
	public PartInfo maneLftInfo;
    
    public ModelRenderer headJoint;
    public ModelRenderer head;
	public PartInfo headJointInfo;
	public PartInfo headInfo;
	
    public ModelRenderer muzzle;
    public ModelRenderer nose;
    public ModelRenderer jaw;
	public PartInfo jawInfo;
    
    public ModelRenderer earLftJoint;
    public ModelRenderer earLft;
	public PartInfo earLftJointInfo;
    
    public ModelRenderer earRtJoint;
    public ModelRenderer earRt;
	public PartInfo earRtJointInfo;
    
    public ModelRenderer ribbonKnot;
    
    public ModelRenderer ribbonNeckJoint;
	public PartInfo ribbonNeckJointInfo;
    public ModelRenderer ribbonNeck[] = new ModelRenderer[8];
    public PartInfo ribbonNeckInfo[] = new PartInfo[ribbonNeck.length];
    
    public ModelRenderer ribbonBowLftJoint;
	public PartInfo ribbonBowLftJointInfo;
	public ModelRenderer ribbonBowLft[] = new ModelRenderer[6];
	public PartInfo ribbonBowLftInfo[] = new PartInfo[ribbonBowLft.length];
    
    public ModelRenderer ribbonBowRtJoint;
	public PartInfo ribbonBowRtJointInfo;
	public ModelRenderer ribbonBowRt[] = new ModelRenderer[6];
	public PartInfo ribbonBowRtInfo[] = new PartInfo[ribbonBowRt.length];
    
    public ModelRenderer ribbonThreadLftJoint;
	public PartInfo ribbonThreadLftJointInfo;
	public ModelRenderer ribbonThreadLft[] = new ModelRenderer[5];
	public PartInfo ribbonThreadLftInfo[] = new PartInfo[ribbonThreadLft.length];
    
    public ModelRenderer ribbonThreadRtJoint;
	public PartInfo ribbonThreadRtJointInfo;
	public ModelRenderer ribbonThreadRt[] = new ModelRenderer[5];
	public PartInfo ribbonThreadRtInfo[] = new PartInfo[ribbonThreadRt.length];
    
    public ModelRenderer ribbonGemsRtJoint;
	public PartInfo ribbonGemsRtJointInfo;
	public ModelRenderer ribbonGemsRt[] = new ModelRenderer[2];
	public PartInfo ribbonGemsRtInfo[] = new PartInfo[ribbonGemsRt.length];
    public ModelRenderer ribbonGemsRt1;
    public ModelRenderer ribbonGemsRt2;
    
    public ModelRenderer ribbonGemsRtMidJoint;
	public PartInfo ribbonGemsRtMidJointInfo;
	public ModelRenderer ribbonGemsRtMid[] = new ModelRenderer[2];
	public PartInfo ribbonGemsRtMidInfo[] = new PartInfo[ribbonGemsRtMid.length];
    public ModelRenderer ribbonGemsRtMid1;
    public ModelRenderer ribbonGemsRtMid2;
    
    public ModelRenderer ribbonGemsMidJoint;
	public PartInfo ribbonGemsMidJointInfo;
	public ModelRenderer ribbonGemsMid[] = new ModelRenderer[2];
	public PartInfo ribbonGemsMidInfo[] = new PartInfo[ribbonGemsMid.length];
    public ModelRenderer ribbonGemsMid1;
    public ModelRenderer ribbonGemsMid2;
    
    public ModelRenderer ribbonGemsLftMidJoint;
	public PartInfo ribbonGemsLftMidJointInfo;
	public ModelRenderer ribbonGemsLftMid[] = new ModelRenderer[2];
	public PartInfo ribbonGemsLftMidInfo[] = new PartInfo[ribbonGemsLftMid.length];
    public ModelRenderer ribbonGemsLftMid1;
    public ModelRenderer ribbonGemsLftMid2;
    
    public ModelRenderer ribbonGemsLftJoint;
	public PartInfo ribbonGemsLftJointInfo;
	public ModelRenderer ribbonGemsLft[] = new ModelRenderer[2];
	public PartInfo ribbonGemsLftInfo[] = new PartInfo[ribbonGemsLft.length];
    public ModelRenderer ribbonGemsLft1;
    public ModelRenderer ribbonGemsLft2;

    public ModelRenderer tailJoint;
	public PartInfo tailJointInfo;
    public ModelRenderer tailFur;

	public ModelRenderer tail[][][] = new ModelRenderer[9][8][2];
	public PartInfo tailInfo[][][] = new PartInfo[tail.length][tail[0].length][tail[0][0].length];

    public ModelKyubimonNinetales() 
    {
        this.textureWidth = 128;
        this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

        this.body = new ModelRenderer(this, 0, 38);
        this.body.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.body.addBox(-3.5F, -4.0F, -8.5F, 7, 8, 18, 0.0F);
		this.bodyInfo = new PartInfo(this.body);

		int legPartNumber = 0;
        this.legFntLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntLft1Joint
        this.legFntLft[legPartNumber][jointNumber].setRotationPoint(2.5F, 1.0F, -6.0F);
        this.legFntLft[legPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntLft[legPartNumber][jointNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.legFntLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
        this.legFntLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 0); // legFntLft1
        this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntLft[legPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.5F, 3, 5, 3, 0.0F);
		this.legFntLftInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);
        legPartNumber++;
        this.legFntLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntLft2Joint
        this.legFntLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 3.0F, 0.0F);
        this.legFntLft[legPartNumber][jointNumber].addBox(-1.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntLft[legPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.legFntLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
        this.legFntLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 8); // legFntLft2
        this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntLft[legPartNumber][partNumber].addBox(-1.51F, -0.5F, -1.5F, 3, 10, 3, 0.0F);
		this.legFntLftInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);
        
        legPartNumber = 0;
        this.legFntRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntRt1Joint
        this.legFntRt[legPartNumber][jointNumber].setRotationPoint(-2.5F, 1.0F, -6.0F);
        this.legFntRt[legPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntRt[legPartNumber][jointNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.legFntRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
        this.legFntRt[legPartNumber][partNumber] = new ModelRenderer(this, 47, 0); // legFntRt1
        this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntRt[legPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.5F, 3, 5, 3, 0.0F);
		this.legFntRtInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);
        legPartNumber++;
        this.legFntRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntRt2Joint
        this.legFntRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 3.0F, 0.0F);
        this.legFntRt[legPartNumber][jointNumber].addBox(-1.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntRt[legPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.legFntRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
        this.legFntRt[legPartNumber][partNumber] = new ModelRenderer(this, 47, 8); // legFntRt2
        this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntRt[legPartNumber][partNumber].addBox(-1.49F, -0.5F, -1.5F, 3, 10, 3, 0.0F);
		this.legFntRtInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);

        legPartNumber = 0;
        this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckLft1Joint
        this.legBckLft[legPartNumber][jointNumber].setRotationPoint(2.5F, -0.2F, 7.0F);
        this.legBckLft[legPartNumber][jointNumber].addBox(-1.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
        this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 23); // legBckLft1
        this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckLft[legPartNumber][partNumber].addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
        legPartNumber++;
        this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckLft2Joint
        this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 5.0F, 0.0F);
        this.legBckLft[legPartNumber][jointNumber].addBox(-1.51F, -0.2F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckLft[legPartNumber][jointNumber], 0.7853981633974483F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
        this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 32); // legBckLft2
        this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckLft[legPartNumber][partNumber].addBox(-1.49F, -0.2F, -1.5F, 3, 5, 3, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
        legPartNumber++;
        this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckLft3Joint
        this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 4.1F, 0.0F);
        this.legBckLft[legPartNumber][jointNumber].addBox(-1.51F, -0.8F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -0.7853981633974483F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
        this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 40); // legBckLft3
        this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckLft[legPartNumber][partNumber].addBox(-1.5F, -0.8F, -1.5F, 3, 6, 3, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);

        legPartNumber = 0;
        this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckRt1Joint
        this.legBckRt[legPartNumber][jointNumber].setRotationPoint(-2.5F, -0.2F, 7.0F);
        this.legBckRt[legPartNumber][jointNumber].addBox(-1.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
        this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 47, 23); // legBckRt1
        this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckRt[legPartNumber][partNumber].addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
        legPartNumber++;
        this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckRt2Joint
        this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 5.0F, 0.0F);
        this.legBckRt[legPartNumber][jointNumber].addBox(-1.51F, -0.2F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckRt[legPartNumber][jointNumber], 0.7853981633974483F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
        this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 47, 32); // legBckRt2
        this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckRt[legPartNumber][partNumber].addBox(-1.51F, -0.2F, -1.5F, 3, 5, 3, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
        legPartNumber++;
        this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckRt3Joint
        this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 4.1F, 0.0F);
        this.legBckRt[legPartNumber][jointNumber].addBox(-1.51F, -0.8F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -0.7853981633974483F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
        this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 47, 40); // legBckRt3
        this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckRt[legPartNumber][partNumber].addBox(-1.5F, -0.8F, -1.5F, 3, 6, 3, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);

        this.neckJoint = new ModelRenderer(this, 0, 0);
        this.neckJoint.setRotationPoint(0.0F, -2.0F, -6.5F);
        this.neckJoint.addBox(-1.5F, -1.5F, -8.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(neckJoint, -0.7853981633974483F, 0.0F, 0.0F);
		this.neckJointInfo = new PartInfo(this.neckJoint);
        this.neck = new ModelRenderer(this, 72, 11);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-1.5F, -1.5F, -7.5F, 3, 3, 8, 0.0F);
		this.neckJointInfo = new PartInfo(this.neck);

        this.mane = new ModelRenderer(this, 10, 14);
        this.mane.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.mane.addBox(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
		this.maneInfo = new PartInfo(this.mane);
        this.maneRt = new ModelRenderer(this, 29, 9);
        this.maneRt.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.maneRt.addBox(-3.0F, -3.0F, -2.5F, 4, 6, 5, 0.0F);
		this.maneRtInfo = new PartInfo(this.maneRt);
        this.maneLft = new ModelRenderer(this, 29, 23);
        this.maneLft.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.maneLft.addBox(-1.0F, -3.0F, -2.5F, 4, 6, 5, 0.0F);
		this.maneLftInfo = new PartInfo(this.maneLft);

        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.headJoint.addBox(-3.5F, -4.5F, -3.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headJoint, 0.7853981633974483F, 0.0F, 0.0F);
		this.headJointInfo = new PartInfo(this.headJoint);
        this.head = new ModelRenderer(this, 8, 1);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-3.5F, -4.5F, -3.0F, 7, 7, 6, 0.0F);
		this.headInfo = new PartInfo(this.head);
        this.muzzle = new ModelRenderer(this, 72, 4);
        this.muzzle.setRotationPoint(0.0F, 0.5F, -2.7F);
        this.muzzle.addBox(-1.5F, -1.5F, -4.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(muzzle, 0.17453292519943295F, 0.0F, 0.0F);
        this.nose = new ModelRenderer(this, 72, 5);
        this.nose.setRotationPoint(0.0F, -0.8F, -3.8F);
        this.nose.addBox(-0.5F, -0.5F, -0.7F, 1, 1, 1, 0.0F);
        this.jaw = new ModelRenderer(this, 82, 6);
        this.jaw.setRotationPoint(0.0F, 1.0F, -2.7F);
        this.jaw.addBox(-1.51F, 0.0F, -3.8F, 3, 1, 4, 0.0F);
        this.setRotateAngle(jaw, 0.12217304763960307F, 0.0F, 0.0F);
		this.jawInfo = new PartInfo(this.jaw);

        this.earLftJoint = new ModelRenderer(this, 0, 0);
        this.earLftJoint.setRotationPoint(2.5F, -3.7F, -0.5F);
        this.earLftJoint.addBox(-1.5F, -2.5F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earLftJoint, 0.0F, 0.0F, 0.4363323129985824F);
		this.earLftJointInfo = new PartInfo(this.earLftJoint);
        this.earLft = new ModelRenderer(this, 39, 4);
        this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earLft.addBox(-1.5F, -2.5F, 0.0F, 3, 4, 1, 0.0F);
		this.earLft.setTextureOffset(39, 2).addBox(-1.0F, -3.5F, 0.0F, 2, 1, 1, 0.0F); // earLftMid
		this.earLft.setTextureOffset(44, 0).addBox(-1.0F, -2.2F, 0.5F, 2, 2, 1, 0.0F); // earLftBck
		this.earLft.setTextureOffset(42, 9).addBox(-0.5F, -3.2F, 0.3F, 1, 1, 1, 0.0F); // earLftBckMid
		this.earLft.setTextureOffset(46, 9).addBox(-0.5F, -4.3F, 0.01F, 1, 1, 1, 0.0F); // earLftTip

        this.earRtJoint = new ModelRenderer(this, 0, 0);
        this.earRtJoint.setRotationPoint(-2.5F, -3.7F, -0.5F);
        this.earRtJoint.addBox(-1.5F, -2.5F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earRtJoint, 0.0F, 0.0F, -0.4363323129985824F);
		this.earRtJointInfo = new PartInfo(this.earRtJoint);
        this.earRt = new ModelRenderer(this, 0, 11);
        this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earRt.addBox(-1.5F, -2.5F, 0.0F, 3, 4, 1, 0.0F);
		this.earRt.setTextureOffset(1, 9).addBox(-1.0F, -3.5F, 0.0F, 2, 1, 1, 0.0F); // earRtMid
		this.earRt.setTextureOffset(10, 14).addBox(-1.0F, -2.2F, 0.5F, 2, 2, 1, 0.0F); // earRtBck
		this.earRt.setTextureOffset(4, 7).addBox(-0.5F, -3.2F, 0.3F, 1, 1, 1, 0.0F); // earRtBckMid
		this.earRt.setTextureOffset(0, 7).addBox(-0.5F, -4.3F, 0.01F, 1, 1, 1, 0.0F); // earRtTip

        this.ribbonKnot = new ModelRenderer(this, 0, 0);
        this.ribbonKnot.setRotationPoint(0.0F, -4.6F, -4.0F);
        this.ribbonKnot.addBox(-1.5F, -1.6F, -2.0F, 3, 3, 4, 0.0F);

        this.ribbonNeckJoint = new ModelRenderer(this, 0, 0);
        this.ribbonNeckJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonNeckJoint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonNeckJoint, 0.3490658503988659F, 0.0F, 0.0F);
		this.ribbonNeckJointInfo = new PartInfo(this.ribbonNeckJoint);
		
		int ribbonPartNumber = 0;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 79, 56); // ribbonNeck1
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(1.7F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-1.0F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.4363323129985824F);
        ribbonPartNumber++;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 78, 52); // ribbonNeck2
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(3.8F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-0.9F, -1.0F, -1.01F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.8726646259971648F);
        ribbonPartNumber++;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 90, 49); // ribbonNeck3
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(3.5F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-1.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.6981317007977318F);
        ribbonPartNumber++;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 72, 0); // ribbonNeck4
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(4.9F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-1.0F, -1.0F, -1.01F, 5, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.7853981633974483F);
        ribbonPartNumber++;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 86, 0); // ribbonNeck5
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(4.0F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-1.0F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.7853981633974483F);
        ribbonPartNumber++;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 100, 0); // ribbonNeck6
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(4.1F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-1.0F, -1.0F, -1.01F, 6, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.7853981633974483F);
        ribbonPartNumber++;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 116, 0); // ribbonNeck7
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(5.2F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-1.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.7504915783575618F);
        ribbonPartNumber++;
        this.ribbonNeck[ribbonPartNumber] = new ModelRenderer(this, 114, 4); // ribbonNeck8
        this.ribbonNeck[ribbonPartNumber].setRotationPoint(3.0F, 0.4F, 0.0F);
        this.ribbonNeck[ribbonPartNumber].addBox(-1.0F, -1.0F, -1.01F, 5, 2, 2, 0.0F);
        this.setRotateAngle(ribbonNeck[ribbonPartNumber], 0.0F, 0.0F, 0.9250245035569946F);

        this.ribbonBowLftJoint = new ModelRenderer(this, 0, 0);
        this.ribbonBowLftJoint.setRotationPoint(1.5F, -0.2F, -1.3F);
        this.ribbonBowLftJoint.addBox(-0.5F, -1.0F, -1.01F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonBowLftJoint, 0.5235987755982988F, 0.17453292519943295F, 0.0F);
		this.ribbonBowLftJointInfo = new PartInfo(this.ribbonBowLftJoint);
		
		ribbonPartNumber = 0;
        this.ribbonBowLft[ribbonPartNumber] = new ModelRenderer(this, 14, 28); // ribbonBowLft1
        this.ribbonBowLft[ribbonPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonBowLft[ribbonPartNumber].addBox(-0.5F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowLft[ribbonPartNumber], 0.0F, 0.0F, -0.6108652381980153F);
        ribbonPartNumber++;
        this.ribbonBowLft[ribbonPartNumber] = new ModelRenderer(this, 0, 16); // ribbonBowLft2
        this.ribbonBowLft[ribbonPartNumber].setRotationPoint(4.3F, 0.0F, 0.0F);
        this.ribbonBowLft[ribbonPartNumber].addBox(-0.4F, -1.0F, -1.01F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowLft[ribbonPartNumber], 0.0F, 0.0F, 0.5235987755982988F);
        ribbonPartNumber++;
        this.ribbonBowLft[ribbonPartNumber] = new ModelRenderer(this, 0, 20); // ribbonBowLft3
        this.ribbonBowLft[ribbonPartNumber].setRotationPoint(3.1F, 0.0F, 0.0F);
        this.ribbonBowLft[ribbonPartNumber].addBox(-0.4F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowLft[ribbonPartNumber], 0.0F, 0.0F, 0.8726646259971648F);
        ribbonPartNumber++;
        this.ribbonBowLft[ribbonPartNumber] = new ModelRenderer(this, 0, 24); // ribbonBowLft4
        this.ribbonBowLft[ribbonPartNumber].setRotationPoint(2.1F, 0.0F, 0.0F);
        this.ribbonBowLft[ribbonPartNumber].addBox(-0.4F, -1.0F, -1.01F, 3, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowLft[ribbonPartNumber], 0.0F, 0.0F, 0.8726646259971648F);
        ribbonPartNumber++;
        this.ribbonBowLft[ribbonPartNumber] = new ModelRenderer(this, 0, 28); // ribbonBowLft5
        this.ribbonBowLft[ribbonPartNumber].setRotationPoint(2.1F, 0.0F, 0.0F);
        this.ribbonBowLft[ribbonPartNumber].addBox(-0.4F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowLft[ribbonPartNumber], 0.0F, 0.0F, 1.064650843716541F);
        ribbonPartNumber++;
        this.ribbonBowLft[ribbonPartNumber] = new ModelRenderer(this, 0, 32); // ribbonBowLft6
        this.ribbonBowLft[ribbonPartNumber].setRotationPoint(3.1F, 0.0F, 0.0F);
        this.ribbonBowLft[ribbonPartNumber].addBox(-0.4F, -1.0F, -1.01F, 6, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowLft[ribbonPartNumber], 0.0F, 0.0F, 0.6108652381980153F);

        this.ribbonBowRtJoint = new ModelRenderer(this, 0, 0);
        this.ribbonBowRtJoint.setRotationPoint(-1.5F, -0.2F, -1.3F);
        this.ribbonBowRtJoint.addBox(-0.5F, -1.0F, -1.01F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonBowRtJoint, 0.5235987755982988F, -0.17453292519943295F, 0.0F);
		this.ribbonBowRtJointInfo = new PartInfo(this.ribbonBowRtJoint);
		
		ribbonPartNumber = 0;
        this.ribbonBowRt[ribbonPartNumber] = new ModelRenderer(this, 0, 36); // ribbonBowRt1
        this.ribbonBowRt[ribbonPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonBowRt[ribbonPartNumber].addBox(-3.5F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowRt[ribbonPartNumber], 0.0F, 0.0F, 0.6108652381980153F);
        ribbonPartNumber++;
        this.ribbonBowRt[ribbonPartNumber] = new ModelRenderer(this, 0, 40); // ribbonBowRt2
        this.ribbonBowRt[ribbonPartNumber].setRotationPoint(-3.3F, 0.0F, 0.0F);
        this.ribbonBowRt[ribbonPartNumber].addBox(-3.7F, -1.0F, -1.01F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowRt[ribbonPartNumber], 0.0F, 0.0F, -0.5235987755982988F);
        ribbonPartNumber++;
        this.ribbonBowRt[ribbonPartNumber] = new ModelRenderer(this, 14, 34); // ribbonBowRt3
        this.ribbonBowRt[ribbonPartNumber].setRotationPoint(-3.3F, 0.0F, 0.0F);
        this.ribbonBowRt[ribbonPartNumber].addBox(-2.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowRt[ribbonPartNumber], 0.0F, 0.0F, -0.8726646259971648F);
        ribbonPartNumber++;
        this.ribbonBowRt[ribbonPartNumber] = new ModelRenderer(this, 0, 44); // ribbonBowRt4
        this.ribbonBowRt[ribbonPartNumber].setRotationPoint(-2.1F, 0.0F, 0.0F);
        this.ribbonBowRt[ribbonPartNumber].addBox(-2.6F, -1.0F, -1.01F, 3, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowRt[ribbonPartNumber], 0.0F, 0.0F, -0.8726646259971648F);
        ribbonPartNumber++;
        this.ribbonBowRt[ribbonPartNumber] = new ModelRenderer(this, 0, 48); // ribbonBowRt5
        this.ribbonBowRt[ribbonPartNumber].setRotationPoint(-2.1F, 0.0F, 0.0F);
        this.ribbonBowRt[ribbonPartNumber].addBox(-3.3F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowRt[ribbonPartNumber], 0.0F, 0.0F, -1.064650843716541F);
        ribbonPartNumber++;
        this.ribbonBowRt[ribbonPartNumber] = new ModelRenderer(this, 0, 52); // ribbonBowRt6
        this.ribbonBowRt[ribbonPartNumber].setRotationPoint(-2.9F, 0.0F, 0.0F);
        this.ribbonBowRt[ribbonPartNumber].addBox(-5.8F, -1.0F, -1.01F, 6, 2, 2, 0.0F);
        this.setRotateAngle(ribbonBowRt[ribbonPartNumber], 0.0F, 0.0F, -0.6108652381980153F);

        this.ribbonThreadLftJoint = new ModelRenderer(this, 0, 0);
        this.ribbonThreadLftJoint.setRotationPoint(1.0F, -0.1F, 0.9F);
        this.ribbonThreadLftJoint.addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonThreadLftJoint, 0.5235987755982988F, 0.0F, 0.0F);
		this.ribbonThreadLftJointInfo = new PartInfo(this.ribbonThreadLftJoint);
		
		ribbonPartNumber = 0;
        this.ribbonThreadLft[ribbonPartNumber] = new ModelRenderer(this, 39, 38); // ribbonThreadLft1
        this.ribbonThreadLft[ribbonPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonThreadLft[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(ribbonThreadLft[ribbonPartNumber], 0.0F, 0.0F, -1.3962634015954636F);
        ribbonPartNumber++;
        this.ribbonThreadLft[ribbonPartNumber] = new ModelRenderer(this, 32, 44); // ribbonThreadLft2
        this.ribbonThreadLft[ribbonPartNumber].setRotationPoint(0.0F, 5.5F, 0.0F);
        this.ribbonThreadLft[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ribbonThreadLft[ribbonPartNumber], -0.08726646259971647F, 0.0F, 0.5235987755982988F);
        ribbonPartNumber++;
        this.ribbonThreadLft[ribbonPartNumber] = new ModelRenderer(this, 40, 47); // ribbonThreadLft3
        this.ribbonThreadLft[ribbonPartNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
        this.ribbonThreadLft[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ribbonThreadLft[ribbonPartNumber], -0.3490658503988659F, 0.0F, 0.5235987755982988F);
        ribbonPartNumber++;
        this.ribbonThreadLft[ribbonPartNumber] = new ModelRenderer(this, 32, 50); // ribbonThreadLft4
        this.ribbonThreadLft[ribbonPartNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
        this.ribbonThreadLft[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ribbonThreadLft[ribbonPartNumber], -0.3490658503988659F, 0.0F, 0.3490658503988659F);
        ribbonPartNumber++;
        this.ribbonThreadLft[ribbonPartNumber] = new ModelRenderer(this, 45, 50); // ribbonThreadLft5
        this.ribbonThreadLft[ribbonPartNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
        this.ribbonThreadLft[ribbonPartNumber].addBox(-1.5F, -0.5F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(ribbonThreadLft[ribbonPartNumber], -0.3490658503988659F, 0.0F, 0.3490658503988659F);

        this.ribbonThreadRtJoint = new ModelRenderer(this, 0, 0);
        this.ribbonThreadRtJoint.setRotationPoint(-1.0F, -0.1F, 0.9F);
        this.ribbonThreadRtJoint.addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonThreadRtJoint, 0.5235987755982988F, 0.0F, 0.0F);
		this.ribbonThreadRtJointInfo = new PartInfo(this.ribbonThreadRtJoint);
		
		ribbonPartNumber = 0;
        this.ribbonThreadRt[ribbonPartNumber] = new ModelRenderer(this, 39, 38); // ribbonThreadRt1
        this.ribbonThreadRt[ribbonPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonThreadRt[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(ribbonThreadRt[ribbonPartNumber], 0.0F, 0.0F, 1.3962634015954636F);
        ribbonPartNumber++;
        this.ribbonThreadRt[ribbonPartNumber] = new ModelRenderer(this, 32, 44); // ribbonThreadRt2
        this.ribbonThreadRt[ribbonPartNumber].setRotationPoint(0.0F, 5.5F, 0.0F);
        this.ribbonThreadRt[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ribbonThreadRt[ribbonPartNumber], -0.08726646259971647F, 0.0F, -0.5235987755982988F);
        ribbonPartNumber++;
        this.ribbonThreadRt[ribbonPartNumber] = new ModelRenderer(this, 40, 47); // ribbonThreadRt3
        this.ribbonThreadRt[ribbonPartNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
        this.ribbonThreadRt[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ribbonThreadRt[ribbonPartNumber], -0.3490658503988659F, 0.0F, -0.5235987755982988F);
        ribbonPartNumber++;
        this.ribbonThreadRt[ribbonPartNumber] = new ModelRenderer(this, 32, 50); // ribbonThreadRt4
        this.ribbonThreadRt[ribbonPartNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
        this.ribbonThreadRt[ribbonPartNumber].addBox(-1.0F, -0.3F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ribbonThreadRt[ribbonPartNumber], -0.3490658503988659F, 0.0F, -0.3490658503988659F);
        ribbonPartNumber++;
        this.ribbonThreadRt[ribbonPartNumber] = new ModelRenderer(this, 45, 50); // ribbonThreadRt5
        this.ribbonThreadRt[ribbonPartNumber].setRotationPoint(0.0F, 3.5F, 0.0F);
        this.ribbonThreadRt[ribbonPartNumber].addBox(-1.5F, -0.5F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(ribbonThreadRt[ribbonPartNumber], -0.3490658503988659F, 0.0F, -0.3490658503988659F);

        this.ribbonGemsRtJoint = new ModelRenderer(this, 0, 0);
        this.ribbonGemsRtJoint.setRotationPoint(3.8F, -0.9F, 0.0F);
        this.ribbonGemsRtJoint.addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonGemsRtJoint, -0.45378560551852565F, 0.0F, -0.40142572795869574F);
		this.ribbonGemsRtJointInfo = new PartInfo(this.ribbonGemsRtJoint);
        this.ribbonGemsRt[0] = new ModelRenderer(this, 0, 0); // ribbonGemsRt1Joint
        this.ribbonGemsRt[0].setRotationPoint(0.0F, -0.3F, 0.0F);
        this.ribbonGemsRt[0].addBox(0.0F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsRt[1] = new ModelRenderer(this, 0, 0); // ribbonGemsRt2Joint
        this.ribbonGemsRt[1].setRotationPoint(0.0F, -1.1F, 0.0F);
        this.ribbonGemsRt[1].addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsRt1 = new ModelRenderer(this, 105, 5);
        this.ribbonGemsRt1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonGemsRt1.addBox(-0.7F, -0.8F, -0.2F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsRt1, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);
        this.ribbonGemsRt2 = new ModelRenderer(this, 108, 6);
        this.ribbonGemsRt2.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.ribbonGemsRt2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsRt2, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);

        this.ribbonGemsRtMidJoint = new ModelRenderer(this, 0, 0);
        this.ribbonGemsRtMidJoint.setRotationPoint(1.3F, -0.9F, 0.0F);
        this.ribbonGemsRtMidJoint.addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonGemsRtMidJoint, -0.45378560551852565F, 0.0F, -0.40142572795869574F);
		this.ribbonGemsRtMidJointInfo = new PartInfo(this.ribbonGemsRtMidJoint);
        this.ribbonGemsRtMid[0] = new ModelRenderer(this, 0, 0); // ribbonGemsRtMid1Joint
        this.ribbonGemsRtMid[0].setRotationPoint(0.0F, -0.3F, 0.0F);
        this.ribbonGemsRtMid[0].addBox(0.0F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsRtMid[1] = new ModelRenderer(this, 0, 0); // ribbonGemsRtMid2Joint
        this.ribbonGemsRtMid[1].setRotationPoint(0.0F, -1.1F, 0.0F);
        this.ribbonGemsRtMid[1].addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsRtMid1 = new ModelRenderer(this, 105, 8);
        this.ribbonGemsRtMid1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonGemsRtMid1.addBox(-0.7F, -0.8F, -0.2F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsRtMid1, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);
        this.ribbonGemsRtMid2 = new ModelRenderer(this, 108, 9);
        this.ribbonGemsRtMid2.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.ribbonGemsRtMid2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsRtMid2, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);

        this.ribbonGemsMidJoint = new ModelRenderer(this, 0, 0);
        this.ribbonGemsMidJoint.setRotationPoint(3.7F, -0.9F, 0.0F);
        this.ribbonGemsMidJoint.addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonGemsMidJoint, -0.45378560551852565F, 0.0F, 0.3665191429188092F);
		this.ribbonGemsMidJointInfo = new PartInfo(this.ribbonGemsMidJoint);
        this.ribbonGemsMid[0] = new ModelRenderer(this, 0, 0); // ribbonGemsMid1Joint
        this.ribbonGemsMid[0].setRotationPoint(0.0F, -0.3F, 0.0F);
        this.ribbonGemsMid[0].addBox(0.0F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsMid[1] = new ModelRenderer(this, 0, 0); // ribbonGemsMid2Joint
        this.ribbonGemsMid[1].setRotationPoint(0.0F, -1.1F, 0.0F);
        this.ribbonGemsMid[1].addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsMid1 = new ModelRenderer(this, 121, 9);
        this.ribbonGemsMid1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonGemsMid1.addBox(-0.7F, -0.8F, -0.2F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsMid1, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);
        this.ribbonGemsMid2 = new ModelRenderer(this, 124, 10);
        this.ribbonGemsMid2.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.ribbonGemsMid2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsMid2, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);

        this.ribbonGemsLftMidJoint = new ModelRenderer(this, 0, 0);
        this.ribbonGemsLftMidJoint.setRotationPoint(1.2F, -0.9F, 0.0F);
        this.ribbonGemsLftMidJoint.addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonGemsLftMidJoint, -0.45378560551852565F, 0.0F, 0.3665191429188092F);
		this.ribbonGemsLftMidJointInfo = new PartInfo(this.ribbonGemsLftMidJoint);
        this.ribbonGemsLftMid[0] = new ModelRenderer(this, 0, 0); // ribbonGemsLftMid1Joint
        this.ribbonGemsLftMid[0].setRotationPoint(0.0F, -0.3F, 0.0F);
        this.ribbonGemsLftMid[0].addBox(0.0F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsLftMid[1] = new ModelRenderer(this, 0, 0); // ribbonGemsLftMid2Joint
        this.ribbonGemsLftMid[1].setRotationPoint(0.0F, -1.1F, 0.0F);
        this.ribbonGemsLftMid[1].addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsLftMid1 = new ModelRenderer(this, 121, 12);
        this.ribbonGemsLftMid1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonGemsLftMid1.addBox(-0.7F, -0.8F, -0.2F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsLftMid1, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);
        this.ribbonGemsLftMid2 = new ModelRenderer(this, 124, 13);
        this.ribbonGemsLftMid2.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.ribbonGemsLftMid2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsLftMid2, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);

        this.ribbonGemsLftJoint = new ModelRenderer(this, 0, 0);
        this.ribbonGemsLftJoint.setRotationPoint(-1.1F, -0.9F, 0.0F);
        this.ribbonGemsLftJoint.addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(ribbonGemsLftJoint, -0.45378560551852565F, 0.0F, 0.3665191429188092F);
		this.ribbonGemsLftJointInfo = new PartInfo(this.ribbonGemsLftJoint);
        this.ribbonGemsLft[0] = new ModelRenderer(this, 0, 0); // ribbonGemsLft1Joint
        this.ribbonGemsLft[0].setRotationPoint(0.0F, -0.3F, 0.0F);
        this.ribbonGemsLft[0].addBox(0.0F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsLft[1] = new ModelRenderer(this, 0, 0); // ribbonGemsLft2Joint
        this.ribbonGemsLft[1].setRotationPoint(0.0F, -1.1F, 0.0F);
        this.ribbonGemsLft[1].addBox(-0.2F, -0.7F, -0.5F, 0, 0, 0, 0.0F);
        this.ribbonGemsLft1 = new ModelRenderer(this, 105, 19);
        this.ribbonGemsLft1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ribbonGemsLft1.addBox(-0.7F, -0.8F, -0.2F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsLft1, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);
        this.ribbonGemsLft2 = new ModelRenderer(this, 109, 19);
        this.ribbonGemsLft2.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.ribbonGemsLft2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(ribbonGemsLft2, 1.0471975511965976F, 0.47123889803846897F, 0.6457718232379019F);

        this.tailJoint = new ModelRenderer(this, 0, 0);
        this.tailJoint.setRotationPoint(0.0F, -2.0F, 9.6F);
        this.tailJoint.addBox(-1.5F, -1.5F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailJoint, -0.17453292519943295F, 0.0F, 0.0F);
		this.tailJointInfo = new PartInfo(this.tailJoint);
        this.tailFur = new ModelRenderer(this, 73, 44);
        this.tailFur.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFur.addBox(-2.0F, -2.1F, -2.0F, 4, 4, 4, 0.0F);

		this.tailJointInfo = new PartInfo(this.tailJoint);

		int tailNumber = 0;
		int tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(1.2F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.7853981633974483F, 1.7453292519943295F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail1_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail1_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail1_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail1_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 73, 19); // tail1_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail1_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail1_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail1_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail1_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.9F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.6981317007977318F, 1.3089969389957472F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail2_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail2_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail2_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail2_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 73, 31); // tail2_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail2_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail2_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail2_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail2_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.6F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.8726646259971648F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail3_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail3_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail3_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail3_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 89, 36); // tail3_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail3_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail3_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail3_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail3_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.3F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.4363323129985824F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail4_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail4_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail4_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail4_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 90, 24); // tail4_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail4_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail4_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail4_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail4_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail5_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail5_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.7853981633974483F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail5_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail5_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 90, 12); // tail5_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail5_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail5_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail5_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail5_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, -0.4363323129985824F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail6_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail6_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail6_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail6_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 89, 0); // tail6_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail6_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail6_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail6_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail6_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, -0.8726646259971648F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail7_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail7_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail7_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail7_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 5); // tail7_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail7_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail7_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail7_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail7_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.6981317007977318F, -1.3089969389957472F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail8_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail8_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail8_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail8_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 17); // tail8_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail8_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail8_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail8_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail8_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailNumber++;
		tailPartNumber = 0;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_1Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.7853981633974483F, -1.7453292519943295F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 51, 50); // tail9_1
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 6, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_2Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 63, 53); // tail9_2
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, 0.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_3Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.6108652381980153F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 86, 53); // tail9_3
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_4Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.0F, -2.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 41); // tail9_4
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.0F, -2.0F, -1.0F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_5Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 5.6F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-2.01F, -2.0F, -0.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 106, 29); // tail9_5
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-2.01F, -2.0F, -0.7F, 4, 4, 7, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_6Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.5F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 102, 52); // tail9_6
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.5F, -1.5F, -1.0F, 3, 3, 5, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_7Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.0F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 115, 58); // tail9_7
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		tailPartNumber++;
		this.tail[tailNumber][tailPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // tail9_8Joint
		this.tail[tailNumber][tailPartNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.5F);
		this.tail[tailNumber][tailPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][tailPartNumber][jointNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][jointNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][jointNumber]);
		this.tail[tailNumber][tailPartNumber][partNumber] = new ModelRenderer(this, 118, 52); // tail9_8
		this.tail[tailNumber][tailPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][tailPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 4, 0.0F);
		this.tailInfo[tailNumber][tailPartNumber][partNumber] = new PartInfo(this.tail[tailNumber][tailPartNumber][partNumber]);
		
        this.body.addChild(this.legBckLft[0][0]);
        this.body.addChild(this.legBckRt[0][0]);
        this.body.addChild(this.legFntLft[0][0]);
        this.body.addChild(this.legFntRt[0][0]);
        this.body.addChild(this.neckJoint);
        this.body.addChild(this.tailJoint);

        this.neckJoint.addChild(this.neck);
        this.neck.addChild(this.headJoint);
        this.neck.addChild(this.ribbonKnot);

        this.earLftJoint.addChild(this.earLft);
        this.earRtJoint.addChild(this.earRt);
        
        for(int i = 0; i < legFntLft.length - 1; i++)
        {
        	this.legFntLft[i][0].addChild(this.legFntLft[i][1]);
        	this.legFntLft[i][1].addChild(this.legFntLft[i + 1][0]);

        	this.legFntRt[i][0].addChild(this.legFntRt[i][1]);
        	this.legFntRt[i][1].addChild(this.legFntRt[i + 1][0]);
        }
        
        for(int i = 0; i < legBckLft.length - 1; i++)
        {
        	this.legBckLft[i][0].addChild(this.legBckLft[i][1]);
        	this.legBckLft[i][1].addChild(this.legBckLft[i + 1][0]);

        	this.legBckRt[i][0].addChild(this.legBckRt[i][1]);
        	this.legBckRt[i][1].addChild(this.legBckRt[i + 1][0]);
        }

        this.neck.addChild(this.mane);
        this.mane.addChild(this.maneLft);
        this.mane.addChild(this.maneRt);

        this.headJoint.addChild(this.head);
        this.head.addChild(this.earLftJoint);
        this.head.addChild(this.earRtJoint);
        this.head.addChild(this.jaw);
        this.head.addChild(this.muzzle);
        this.muzzle.addChild(this.nose);

        this.ribbonKnot.addChild(this.ribbonBowLftJoint);
        this.ribbonKnot.addChild(this.ribbonBowRtJoint);
        this.ribbonKnot.addChild(this.ribbonNeckJoint);
        this.ribbonKnot.addChild(this.ribbonThreadLftJoint);
        this.ribbonKnot.addChild(this.ribbonThreadRtJoint);
        
        this.ribbonBowLftJoint.addChild(this.ribbonBowLft[0]);
        this.ribbonBowRtJoint.addChild(this.ribbonBowRt[0]);
        
        for(int i = 0; i < ribbonBowLft.length - 1; i++)
        {
        	this.ribbonBowLft[i].addChild(this.ribbonBowLft[i + 1]);
        	this.ribbonBowRt[i].addChild(this.ribbonBowRt[i + 1]);
        }

        this.ribbonGemsLftJoint.addChild(this.ribbonGemsLft[0]);
        this.ribbonGemsLft[0].addChild(this.ribbonGemsLft1);
        this.ribbonGemsLft[0].addChild(this.ribbonGemsLft[1]);
        this.ribbonGemsLft[1].addChild(this.ribbonGemsLft2);

        this.ribbonGemsLftMidJoint.addChild(this.ribbonGemsLftMid[0]);
        this.ribbonGemsLftMid[0].addChild(this.ribbonGemsLftMid1);
        this.ribbonGemsLftMid[0].addChild(this.ribbonGemsLftMid[1]);
        this.ribbonGemsLftMid[1].addChild(this.ribbonGemsLftMid2);

        this.ribbonGemsMidJoint.addChild(this.ribbonGemsMid[0]);
        this.ribbonGemsMid[0].addChild(this.ribbonGemsMid1);
        this.ribbonGemsMid[0].addChild(this.ribbonGemsMid[1]);
        this.ribbonGemsMid[1].addChild(this.ribbonGemsMid2);

        this.ribbonGemsRtJoint.addChild(this.ribbonGemsRt[0]);
        this.ribbonGemsRt[0].addChild(this.ribbonGemsRt1);
        this.ribbonGemsRt[0].addChild(this.ribbonGemsRt[1]);
        this.ribbonGemsRt[1].addChild(this.ribbonGemsRt2);

        this.ribbonGemsRtMidJoint.addChild(this.ribbonGemsRtMid[0]);
        this.ribbonGemsRtMid[0].addChild(this.ribbonGemsRtMid1);
        this.ribbonGemsRtMid[0].addChild(this.ribbonGemsRtMid[1]);
        this.ribbonGemsRtMid[1].addChild(this.ribbonGemsRtMid2);

        this.ribbonNeck[3].addChild(this.ribbonGemsLftJoint);
        this.ribbonNeck[3].addChild(this.ribbonGemsLftMidJoint);
        this.ribbonNeck[3].addChild(this.ribbonGemsMidJoint);
        this.ribbonNeck[4].addChild(this.ribbonGemsRtJoint);
        this.ribbonNeck[4].addChild(this.ribbonGemsRtMidJoint);

        this.ribbonNeckJoint.addChild(this.ribbonNeck[0]);

        for(int i = 0; i < ribbonNeck.length - 1; i++)
        {
            this.ribbonNeck[i].addChild(this.ribbonNeck[i + 1]);
        }

        this.ribbonThreadLftJoint.addChild(this.ribbonThreadLft[0]);
        this.ribbonThreadRtJoint.addChild(this.ribbonThreadRt[0]);

        for(int i = 0; i < ribbonThreadLft.length - 1; i++)
        {
            this.ribbonThreadLft[i].addChild(this.ribbonThreadLft[i + 1]);
            this.ribbonThreadRt[i].addChild(this.ribbonThreadRt[i + 1]);
        }

        this.tailJoint.addChild(this.tailFur);
        
		for(int i = 0; i < tail.length; i++)
		{
			this.tailJoint.addChild(this.tail[i][0][0]);
		}

		for(int i = 0; i < tail.length; i++)
		{
			for(int j = 0; j < tail[i].length - 1; j++)
			{
				this.tail[i][j][0].addChild(this.tail[i][j][1]);
				this.tail[i][j][1].addChild(this.tail[i][j + 1][0]);
			}
		}

		animationDeployer = new AnimationDeployer(this);
    }

    @Override
    public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
    { 
        this.body.render(modelSize);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}