package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayCommanderLiepard;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelClayCommanderLiepard extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 1.1F;
	
    public ModelRenderer body;
    public ModelRenderer bodyFntTopArmor;
    public ModelRenderer bodyBckTopArmor;
	PartInfo bodyInfo;
    
    public ModelRenderer legFntLft;
    public ModelRenderer legFntLftForeleg;
    public ModelRenderer legFntRt;
    public ModelRenderer legFntRtForeleg;
    public ModelRenderer legBckLft;
    public ModelRenderer legBckLftHind;
    public ModelRenderer legBckRt;
    public ModelRenderer legBckRtHind;
	PartInfo legFntLftInfo;
	PartInfo legFntLftForelegInfo;
	PartInfo legFntRtInfo;
	PartInfo legFntRtForelegInfo;
	PartInfo legBckLftInfo;
	PartInfo legBckLftHindInfo;
	PartInfo legBckRtInfo;
	PartInfo legBckRtHindInfo;
    
    public ModelRenderer neckJoint;
    public ModelRenderer neck;
	PartInfo neckJointInfo;
	PartInfo neckInfo;
    
    public ModelRenderer headJoint;
    public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;
    
    public ModelRenderer muzzle;
    public ModelRenderer nose;
    public ModelRenderer whiskers;
    public ModelRenderer headPiece;

    public ModelRenderer earRtJoint;
    public ModelRenderer earRt;
    public ModelRenderer earLftJoint;
    public ModelRenderer earLft;
	PartInfo earRtJointInfo;
	PartInfo earRtInfo;
	PartInfo earLftJointInfo;
	PartInfo earLftInfo;
    
	public ModelRenderer tail[][] = new ModelRenderer[11][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];
	
    public ModelRenderer tail11FntFur;
    public ModelRenderer tail11BckFur;
	PartInfo tail11FntFurInfo;
	PartInfo tail11BckFurInfo;

    public ModelClayCommanderLiepard() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

        this.body = new ModelRenderer(this, 15, 51);
        this.body.setRotationPoint(0.0F, 13.5F, 0.0F);
        this.body.addBox(-2.5F, -3.0F, -7.0F, 5, 6, 7, 0.0F);
        this.body.setTextureOffset(40, 52).addBox(-2.5F, -3.0F, 0.0F, 5, 5, 7, 0.0F); // bodyBck
        this.body.setTextureOffset(0, 58).addBox(-2.0F, -0.8F, -8.0F, 4, 4, 1, 0.0F); // bodyFntArmor
        this.body.setTextureOffset(0, 43).addBox(-3.1F, -3.5F, -6.0F, 1, 4, 5, 0.0F); // bodyFntRtArmor
        this.body.setTextureOffset(9, 48).addBox(2.1F, -3.5F, -6.0F, 1, 4, 5, 0.0F); // bodyFntLftArmor
        this.body.setTextureOffset(33, 38).addBox(-3.1F, -3.5F, 0.0F, 1, 4, 5, 0.0F); // bodyBckRtArmor
        this.body.setTextureOffset(33, 48).addBox(2.1F, -3.5F, 0.0F, 1, 4, 5, 0.0F); // bodyBckLftArmor
        bodyInfo = new PartInfo(body);
        this.bodyFntTopArmor = new ModelRenderer(this, 17, 45);
        this.bodyFntTopArmor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyFntTopArmor.addBox(0.0F, -4.0F, -5.0F, 5, 1, 5, 0.0F);
        this.setRotateAngle(bodyFntTopArmor, 0.0F, 0.7853981633974483F, 0.0F);
        this.bodyBckTopArmor = new ModelRenderer(this, 42, 46);
        this.bodyBckTopArmor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyBckTopArmor.addBox(-4.0F, -3.8F, -1.0F, 5, 1, 5, 0.0F);
        this.setRotateAngle(bodyBckTopArmor, 0.0F, 0.7853981633974483F, 0.0F);

        this.legFntLft = new ModelRenderer(this, 56, 0);
        this.legFntLft.setRotationPoint(2.0F, 1.0F, -4.5F);
        this.legFntLft.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(legFntLft, 0.08726646259971647F, -0.0F, 0.0F);
        legFntLftInfo = new PartInfo(legFntLft);
		this.legFntLftForeleg = new ModelRenderer(this, 56, 6);
        this.legFntLftForeleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntLftForeleg.addBox(-1.1F, 1.5F, -0.7F, 2, 8, 2, 0.0F);
        this.setRotateAngle(legFntLftForeleg, -0.17453292519943295F, -0.0F, 0.0F);
        this.legFntLftForeleg.setTextureOffset(47, 8).addBox(-1.5F, 3.5F, -1.0F, 3, 4, 1, 0.0F); // legFntLftArmor
        legFntLftForelegInfo = new PartInfo(legFntLftForeleg);
        
        this.legFntRt = new ModelRenderer(this, 38, 0);
        this.legFntRt.setRotationPoint(-2.0F, 1.0F, -4.5F);
        this.legFntRt.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(legFntRt, 0.08726646259971647F, -0.0F, 0.0F);
        legFntRtInfo = new PartInfo(legFntRt);
        this.legFntRtForeleg = new ModelRenderer(this, 38, 6);
        this.legFntRtForeleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntRtForeleg.addBox(-0.9F, 1.5F, -0.7F, 2, 8, 2, 0.0F);
        this.setRotateAngle(legFntRtForeleg, -0.17453292519943295F, -0.0F, 0.0F);
        this.legFntRtForeleg.setTextureOffset(47, 0).addBox(-1.5F, 3.5F, -1.0F, 3, 4, 1, 0.0F); // legFntRtArmor
        legFntRtForelegInfo = new PartInfo(legFntRtForeleg);

        this.legBckLft = new ModelRenderer(this, 56, 17);
        this.legBckLft.setRotationPoint(2.0F, 1.0F, 4.5F);
        this.legBckLft.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(legBckLft, -0.17453292519943295F, -0.0F, 0.0F);
        legBckLftInfo = new PartInfo(legBckLft);
        this.legBckLftHind = new ModelRenderer(this, 56, 26);
        this.legBckLftHind.setRotationPoint(0.0F, 4.0F, 0.8F);
        this.legBckLftHind.addBox(-1.1F, -0.7F, 0.2F, 2, 6, 2, 0.0F);
        this.legBckLftHind.setTextureOffset(47, 27).addBox(0.5F, 0.0F, 0.5F, 1, 4, 3, 0.0F); // legBckLftArmor
        legBckLftHindInfo = new PartInfo(legBckLftHind);

        this.legBckRt = new ModelRenderer(this, 38, 17);
        this.legBckRt.setRotationPoint(-2.0F, 1.0F, 4.5F);
        this.legBckRt.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(legBckRt, -0.17453292519943295F, -0.0F, 0.0F);
        legBckRtInfo = new PartInfo(legBckRt);
        this.legBckRtHind = new ModelRenderer(this, 38, 26);
        this.legBckRtHind.setRotationPoint(0.0F, 4.0F, 0.8F);
        this.legBckRtHind.addBox(-0.9F, -0.7F, 0.5F, 2, 6, 2, 0.0F);
        this.legBckRtHind.setTextureOffset(47, 17).addBox(-1.5F, 0.0F, 0.5F, 1, 4, 3, 0.0F); // legBckRtArmor
        legBckRtHindInfo = new PartInfo(legBckRtHind);

        this.neckJoint = new ModelRenderer(this, 48, 36);
        this.neckJoint.setRotationPoint(0.0F, -1.3F, -5.5F);
        this.neckJoint.addBox(-1.5F, -1.5F, -5.0F, 0, 0, 0, 0.0F);
        neckJointInfo = new PartInfo(neckJoint);
        this.neck = new ModelRenderer(this, 48, 36);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-1.5F, -1.5F, -5.0F, 3, 3, 5, 0.0F);
        neckInfo = new PartInfo(neck);

        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.headJoint.addBox(-2.5F, -3.5F, -4.0F, 0, 0, 0, 0.0F);
        headJointInfo = new PartInfo(headJoint);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-2.5F, -3.5F, -4.0F, 5, 5, 5, 0.0F);
        headInfo = new PartInfo(head);

        this.muzzle = new ModelRenderer(this, 16, 0);
        this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.muzzle.addBox(-1.0F, -1.5F, -5.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(muzzle, 0.2617993877991494F, -0.0F, 0.0F);
        this.nose = new ModelRenderer(this, 25, 0);
        this.nose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nose.addBox(-0.5F, -1.3F, -5.3F, 1, 1, 1, 0.0F);
        this.setRotateAngle(nose, 0.2617993877991494F, -0.0F, 0.0F);
        this.whiskers = new ModelRenderer(this, 20, 4);
        this.whiskers.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.whiskers.addBox(-2.0F, -1.2F, -4.8F, 4, 2, 1, 0.0F);
        this.setRotateAngle(whiskers, 0.2617993877991494F, -0.0F, 0.0F);
        this.headPiece = new ModelRenderer(this, 0, 11);
        this.headPiece.setRotationPoint(0.0F, -3.0F, -3.5F);
        this.headPiece.addBox(-0.5F, -4.5F, -1.0F, 5, 5, 2, 0.0F);
        this.setRotateAngle(headPiece, 0.0F, -0.0F, -0.7853981633974483F);

        this.earRtJoint = new ModelRenderer(this, 0, 25);
        this.earRtJoint.setRotationPoint(-2.0F, -3.0F, -1.5F);
        this.earRtJoint.addBox(-1.5F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earRtJoint, 0.0F, -0.0F, -0.7853981633974483F);
        earRtJointInfo = new PartInfo(earRtJoint);
        this.earRt = new ModelRenderer(this, 0, 25);
        this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earRt.addBox(-1.5F, -2.0F, -0.5F, 3, 3, 1, 0.0F);
        this.earRt.setTextureOffset(1, 22).addBox(-1.0F, -3.0F, -0.5F, 2, 1, 1, 0.0F); // earRtMid
        this.earRt.setTextureOffset(2, 19).addBox(-0.5F, -3.7F, -0.49F, 1, 1, 1, 0.0F); // earRtEnd
        this.earRt.setTextureOffset(1, 30).addBox(-1.0F, -1.9F, 0.0F, 2, 2, 1, 0.0F); // earRtBck
        earRtInfo = new PartInfo(earRt);

        this.earLftJoint = new ModelRenderer(this, 9, 25);
        this.earLftJoint.setRotationPoint(2.0F, -3.0F, -1.5F);
        this.earLftJoint.addBox(-1.5F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earLftJoint, 0.0F, -0.0F, 0.7853981633974483F);
        earLftJointInfo = new PartInfo(earLftJoint);
        this.earLft = new ModelRenderer(this, 9, 25);
        this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earLft.addBox(-1.5F, -2.0F, -0.5F, 3, 3, 1, 0.0F);
        this.earLft.setTextureOffset(10, 22).addBox(-1.0F, -3.0F, -0.5F, 2, 1, 1, 0.0F); // earLftMid
        this.earLft.setTextureOffset(11, 19).addBox(-0.5F, -3.7F, -0.49F, 1, 1, 1, 0.0F); // earLftEnd
        this.earLft.setTextureOffset(10, 30).addBox(-1.0F, -1.9F, 0.0F, 2, 2, 1, 0.0F); // earLftBck
        earLftInfo = new PartInfo(earLft);

        int tailNumber = 0;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 29, 0); // tail1Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -2.0F, 6.5F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 29, 0); // tail1
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -1.0F, 1, 1, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 4); // tail2Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 4); // tail2
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 7); // tail3Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 7); // tail3
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 10); // tail4Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 10); // tail4
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 13); // tail5Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 13); // tail5
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 16); // tail6Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 16); // tail6
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 19); // tail7Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 19); // tail7
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 22); // tail8Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 22); // tail8
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 25); // tail9Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 25); // tail9
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 28); // tail10Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 28); // tail10
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 28, 31); // tail11Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 28, 31); // tail11
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 4, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
        
        this.tail11FntFur = new ModelRenderer(this, 26, 36);
        this.tail11FntFur.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.tail11FntFur.addBox(-0.6F, -0.5F, -5.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(tail11FntFur, -0.5235987755982988F, -0.0F, 0.0F);
        tail11FntFurInfo = new PartInfo(tail11FntFur);
        this.tail11BckFur = new ModelRenderer(this, 20, 38);
        this.tail11BckFur.setRotationPoint(0.0F, 0.0F, 2.4F);
        this.tail11BckFur.addBox(-0.4F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tail11BckFur, -0.6981317007977318F, -0.0F, 0.0F);
        tail11BckFurInfo = new PartInfo(tail11BckFur);
        
        this.body.addChild(this.bodyBckTopArmor);
        this.body.addChild(this.bodyFntTopArmor);
        this.body.addChild(this.legBckLft);
        this.body.addChild(this.legBckRt);
        this.body.addChild(this.legFntLft);
        this.body.addChild(this.legFntRt);
        this.body.addChild(this.neckJoint);
        this.body.addChild(this.tail[0][0]);

        this.legBckLft.addChild(this.legBckLftHind);
        this.legBckRt.addChild(this.legBckRtHind);
        this.legFntLft.addChild(this.legFntLftForeleg);
        this.legFntRt.addChild(this.legFntRtForeleg);

        this.neckJoint.addChild(this.neck);
        this.neck.addChild(this.headJoint);

        this.headJoint.addChild(this.head);
        this.head.addChild(this.earLftJoint);
        this.head.addChild(this.earRtJoint);
        this.head.addChild(this.headPiece);
        this.head.addChild(this.muzzle);
        this.head.addChild(this.nose);
        this.head.addChild(this.whiskers);

        this.earLftJoint.addChild(this.earLft);
        this.earRtJoint.addChild(this.earRt);

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
        this.tail[8][1].addChild(this.tail[9][0]); // tail9 * tail10Joint
        this.tail[9][0].addChild(this.tail[9][1]); // tail10Joint * tail10
        this.tail[9][1].addChild(this.tail[10][0]); // tail10 * tail11Joint
        this.tail[10][0].addChild(this.tail[10][1]); // tail11Joint * tail11
        
        this.tail[10][1].addChild(this.tail11BckFur);
        this.tail[10][1].addChild(this.tail11FntFur);

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

		animateBody((EntityClayCommanderLiepard)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityClayCommanderLiepard)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityClayCommanderLiepard)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityClayCommanderLiepard)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyInfo.resetNewAngles();
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		earRtInfo.resetNewAngles();
		earLftInfo.resetNewAngles();

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

	public void animateBody(EntityClayCommanderLiepard entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.2F;

		bodyInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
	}
	
	public void animateHead(EntityClayCommanderLiepard entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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
		float moveAmplitudeZ = 0.15F;

		float firstAngleChangeZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyZ, moveAmplitudeZ);

		float idleAmplitudeZ = 0.20F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = firstAngleChangeZ;

		angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ;

		earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - angleChangeZ);
		earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + angleChangeZ);
	}

	public void animateLegs(EntityClayCommanderLiepard entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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

	public void animateTail(EntityClayCommanderLiepard entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = 0.2F;
			float idleAmplitudeY = 0.25F;
			
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

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}