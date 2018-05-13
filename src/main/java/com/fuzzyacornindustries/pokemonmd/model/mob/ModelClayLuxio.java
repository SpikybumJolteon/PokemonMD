package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayLuxio;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelClayLuxio extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	float movementFrequency = 1.4F;

	public ModelRenderer body;
	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	PartInfo bodyInfo;
	PartInfo neckJointInfo;
	PartInfo neckInfo;

	public ModelRenderer legFntLft;
	public ModelRenderer legFntRt;
	public ModelRenderer legBckRt;
	public ModelRenderer legBckLft;
	PartInfo legFntLftInfo;
	PartInfo legFntRtInfo;
	PartInfo legBckRtInfo;
	PartInfo legBckLftInfo;

	public ModelRenderer bodyArmorFlapFntLftJoint;
	public ModelRenderer bodyArmorFlapFntLft;
	public ModelRenderer bodyArmorFlapFntRtJoint;
	public ModelRenderer bodyArmorFlapFntRt;
	public ModelRenderer bodyArmorFlapBckLftJoint;
	public ModelRenderer bodyArmorFlapBckLft;
	public ModelRenderer bodyArmorFlapBckRtJoint;
	public ModelRenderer bodyArmorFlapBckRt;
	PartInfo bodyArmorFlapFntLftJointInfo;
	PartInfo bodyArmorFlapFntLftInfo;
	PartInfo bodyArmorFlapFntRtJointInfo;
	PartInfo bodyArmorFlapFntRtInfo;
	PartInfo bodyArmorFlapBckLftJointInfo;
	PartInfo bodyArmorFlapBckLftInfo;
	PartInfo bodyArmorFlapBckRtJointInfo;
	PartInfo bodyArmorFlapBckRtInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer muzzle;
	public ModelRenderer headPiece;

	public ModelRenderer foreheadHairRt;
	public ModelRenderer foreheadHairLft;
	public ModelRenderer cheekHairLftBck;
	public ModelRenderer cheekHairLftFnt;
	public ModelRenderer cheekHairRtFnt;
	public ModelRenderer cheekHairRtBck;
	PartInfo foreheadHairRtInfo;
	PartInfo foreheadHairLftInfo;
	PartInfo cheekHairLftBckInfo;
	PartInfo cheekHairLftFntInfo;
	PartInfo cheekHairRtFntInfo;
	PartInfo cheekHairRtBckInfo;

	public ModelRenderer earLftJoint;
	public ModelRenderer earLft;
	public ModelRenderer earRtJoint;
	public ModelRenderer earRt;
	PartInfo earLftJointInfo;
	PartInfo earLftInfo;
	PartInfo earRtJointInfo;
	PartInfo earRtInfo;

	public ModelRenderer tail[][] = new ModelRenderer[8][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelRenderer tail8[] = new ModelRenderer[3];
	PartInfo tail8Info[] = new PartInfo[tail8.length];

	public ModelClayLuxio() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 25, 50);
		this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.body.addBox(-2.5F, -2.5F, -4.5F, 5, 5, 9, 0.0F);
		this.body.setTextureOffset(14, 49).addBox(-3.0F, -3.0F, -5.0F, 6, 6, 4, 0.0F); // bodyArmorFnt
		this.body.setTextureOffset(44, 49).addBox(-3.0F, -3.0F, 1.0F, 6, 6, 4, 0.0F); // bodyArmorBck
		bodyInfo = new PartInfo(body);
		this.neckJoint = new ModelRenderer(this, 5, 54);
		this.neckJoint.setRotationPoint(0.0F, -1.3F, -4.0F);
		this.neckJoint.addBox(-1.0F, -1.0F, -4.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, -0.7853981633974483F, 0.0F, 0.0F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 5, 54);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 5, 0.0F);
		neckInfo = new PartInfo(neck);

		this.legFntLft = new ModelRenderer(this, 56, 41);
		this.legFntLft.setRotationPoint(1.2F, 2.0F, -2.5F);
		this.legFntLft.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		legFntLftInfo = new PartInfo(legFntLft);
		this.legFntRt = new ModelRenderer(this, 14, 41);
		this.legFntRt.setRotationPoint(-1.2F, 2.0F, -2.5F);
		this.legFntRt.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F);
		legFntRtInfo = new PartInfo(legFntRt);
		this.legBckRt = new ModelRenderer(this, 22, 43);
		this.legBckRt.setRotationPoint(-1.2F, 2.0F, 2.8F);
		this.legBckRt.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(legBckRt, -0.17453292519943295F, 0.0F, 0.0F);
		this.legBckRt.setTextureOffset(30, 44).addBox(-0.99F, 1.5F, 0.0F, 2, 4, 2, 0.0F); // legBckRtHind
		legBckRtInfo = new PartInfo(legBckRt);
		this.legBckLft = new ModelRenderer(this, 48, 43);
		this.legBckLft.setRotationPoint(1.2F, 2.0F, 2.8F);
		this.legBckLft.addBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(legBckLft, -0.17453292519943295F, 0.0F, 0.0F);
		this.legBckLft.setTextureOffset(40, 44).addBox(-1.01F, 1.5F, 0.0F, 2, 4, 2, 0.0F); // legBckLftHind
		legBckLftInfo = new PartInfo(legBckLft);

		this.bodyArmorFlapFntLftJoint = new ModelRenderer(this, 47, 30);
		this.bodyArmorFlapFntLftJoint.setRotationPoint(2.8F, 2.8F, -3.0F);
		this.bodyArmorFlapFntLftJoint.addBox(-0.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		bodyArmorFlapFntLftJointInfo = new PartInfo(bodyArmorFlapFntLftJoint);
		this.bodyArmorFlapFntLft = new ModelRenderer(this, 47, 30);
		this.bodyArmorFlapFntLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodyArmorFlapFntLft.addBox(-0.5F, -0.5F, -1.5F, 1, 2, 3, 0.0F);
		this.bodyArmorFlapFntLft.setTextureOffset(48, 35).addBox(-0.5F, 1.5F, -1.0F, 1, 1, 2, 0.0F); // bodyArmorFlapFntLftMid
		this.bodyArmorFlapFntLft.setTextureOffset(49, 38).addBox(-0.5F, 2.5F, -0.5F, 1, 1, 1, 0.0F); // bodyArmorFlapFntLftTip
		bodyArmorFlapFntLftInfo = new PartInfo(bodyArmorFlapFntLft);
		this.bodyArmorFlapFntRtJoint = new ModelRenderer(this, 38, 30);
		this.bodyArmorFlapFntRtJoint.setRotationPoint(-2.8F, 2.8F, -3.0F);
		this.bodyArmorFlapFntRtJoint.addBox(-0.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		bodyArmorFlapFntRtJointInfo = new PartInfo(bodyArmorFlapFntRtJoint);
		this.bodyArmorFlapFntRt = new ModelRenderer(this, 38, 30);
		this.bodyArmorFlapFntRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodyArmorFlapFntRt.addBox(-0.5F, -0.5F, -1.5F, 1, 2, 3, 0.0F);
		this.bodyArmorFlapFntRt.setTextureOffset(39, 35).addBox(-0.5F, 1.5F, -1.0F, 1, 1, 2, 0.0F); // bodyArmorFlapFntRtMid
		this.bodyArmorFlapFntRt.setTextureOffset(40, 38).addBox(-0.5F, 2.5F, -0.5F, 1, 1, 1, 0.0F); // bodyArmorFlapFntRtTip
		bodyArmorFlapFntRtInfo = new PartInfo(bodyArmorFlapFntRt);
		this.bodyArmorFlapBckLftJoint = new ModelRenderer(this, 56, 30);
		this.bodyArmorFlapBckLftJoint.setRotationPoint(2.8F, 2.8F, 3.0F);
		this.bodyArmorFlapBckLftJoint.addBox(-0.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		bodyArmorFlapBckLftJointInfo = new PartInfo(bodyArmorFlapBckLftJoint);
		this.bodyArmorFlapBckLft = new ModelRenderer(this, 56, 30);
		this.bodyArmorFlapBckLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodyArmorFlapBckLft.addBox(-0.5F, -0.5F, -1.5F, 1, 2, 3, 0.0F);
		this.bodyArmorFlapBckLft.setTextureOffset(57, 35).addBox(-0.5F, 1.5F, -1.0F, 1, 1, 2, 0.0F); // bodyArmorFlapBckLftMid
		this.bodyArmorFlapBckLft.setTextureOffset(58, 38).addBox(-0.5F, 2.5F, -0.5F, 1, 1, 1, 0.0F); // bodyArmorFlapBckLftTip
		bodyArmorFlapBckLftInfo = new PartInfo(bodyArmorFlapBckLft);
		this.bodyArmorFlapBckRtJoint = new ModelRenderer(this, 29, 30);
		this.bodyArmorFlapBckRtJoint.setRotationPoint(-2.8F, 2.8F, 3.0F);
		this.bodyArmorFlapBckRtJoint.addBox(-0.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		bodyArmorFlapBckRtJointInfo = new PartInfo(bodyArmorFlapBckRtJoint);
		this.bodyArmorFlapBckRt = new ModelRenderer(this, 29, 30);
		this.bodyArmorFlapBckRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodyArmorFlapBckRt.addBox(-0.5F, -0.5F, -1.5F, 1, 2, 3, 0.0F);
		this.bodyArmorFlapBckRt.setTextureOffset(30, 35).addBox(-0.5F, 1.5F, -1.0F, 1, 1, 2, 0.0F); // bodyArmorFlapBckRtMid
		this.bodyArmorFlapBckRt.setTextureOffset(31, 38).addBox(-0.5F, 2.5F, -0.5F, 1, 1, 1, 0.0F); // bodyArmorFlapBckRtTip
		bodyArmorFlapBckRtInfo = new PartInfo(bodyArmorFlapBckRt);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, 0.0F, -3.0F);
		this.headJoint.addBox(-2.5F, -3.8F, -4.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, 0.7853981633974483F, 0.0F, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.5F, -3.8F, -4.2F, 5, 5, 5, 0.0F);
		headInfo = new PartInfo(head);
		this.muzzle = new ModelRenderer(this, 0, 10);
		this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muzzle.addBox(-1.0F, -2.0F, -5.6F, 2, 2, 2, 0.0F);
		this.setRotateAngle(muzzle, 0.17453292519943295F, 0.0F, 0.0F);
		this.muzzle.setTextureOffset(2, 14).addBox(-0.5F, -1.9F, -5.9F, 1, 1, 1, 0.0F); // nose

		this.headPiece = new ModelRenderer(this, 52, 0);
		this.headPiece.setRotationPoint(0.0F, -4.0F, -2.5F);
		this.headPiece.addBox(-2.5F, -6.5F, -0.5F, 5, 5, 1, 0.0F);
		this.setRotateAngle(headPiece, -0.17453292519943295F, 0.0F, 0.0F);
		this.headPiece.setTextureOffset(56, 6).addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F); // headPieceStem

		this.foreheadHairRt = new ModelRenderer(this, 42, 0);
		this.foreheadHairRt.setRotationPoint(-0.5F, -4.0F, -3.5F);
		this.foreheadHairRt.addBox(-0.5F, -2.5F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(foreheadHairRt, 0.17453292519943295F, 0.0F, -0.2617993877991494F);
		foreheadHairRtInfo = new PartInfo(foreheadHairRt);
		this.foreheadHairLft = new ModelRenderer(this, 47, 0);
		this.foreheadHairLft.setRotationPoint(0.5F, -4.0F, -3.5F);
		this.foreheadHairLft.addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(foreheadHairLft, 0.17453292519943295F, 0.0F, 0.08726646259971647F);
		foreheadHairLftInfo = new PartInfo(foreheadHairLft);
		this.cheekHairLftBck = new ModelRenderer(this, 13, 17);
		this.cheekHairLftBck.setRotationPoint(1.8F, -1.0F, -2.0F);
		this.cheekHairLftBck.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1, 0.0F);
		this.setRotateAngle(cheekHairLftBck, 0.0F, -0.5235987755982988F, 0.7853981633974483F);
		cheekHairLftBckInfo = new PartInfo(cheekHairLftBck);
		this.cheekHairLftFnt = new ModelRenderer(this, 14, 20);
		this.cheekHairLftFnt.setRotationPoint(1.8F, -1.0F, -2.5F);
		this.cheekHairLftFnt.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(cheekHairLftFnt, 0.0F, -0.4363323129985824F, 1.1344640137963142F);
		cheekHairLftFntInfo = new PartInfo(cheekHairLftFnt);
		this.cheekHairRtFnt = new ModelRenderer(this, 1, 20);
		this.cheekHairRtFnt.setRotationPoint(-1.8F, -1.0F, -2.5F);
		this.cheekHairRtFnt.addBox(-3.5F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(cheekHairRtFnt, 0.0F, 0.4363323129985824F, -1.1344640137963142F);
		cheekHairRtFntInfo = new PartInfo(cheekHairRtFnt);
		this.cheekHairRtBck = new ModelRenderer(this, 0, 17);
		this.cheekHairRtBck.setRotationPoint(-1.8F, -1.0F, -2.0F);
		this.cheekHairRtBck.addBox(-4.5F, -0.5F, -0.5F, 5, 1, 1, 0.0F);
		this.setRotateAngle(cheekHairRtBck, 0.0F, 0.5235987755982988F, -0.7853981633974483F);
		cheekHairRtBckInfo = new PartInfo(cheekHairRtBck);

		this.earLftJoint = new ModelRenderer(this, 33, 7);
		this.earLftJoint.setRotationPoint(2.0F, -3.0F, 0.0F);
		this.earLftJoint.addBox(-1.0F, 0.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.0F, 0.0F, 0.4363323129985824F);
		earLftJointInfo = new PartInfo(earLftJoint);
		this.earLft = new ModelRenderer(this, 33, 7);
		this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft.addBox(-1.0F, 0.0F, -0.5F, 3, 2, 1, 0.0F);
		this.earLft.setTextureOffset(32, 3).addBox(-1.0F, -3.0F, -0.5F, 4, 3, 1, 0.0F); // earLftMid
		this.earLft.setTextureOffset(33, 0).addBox(-0.5F, -5.0F, -0.5F, 3, 2, 1, 0.0F); // earLftTip
		earLftInfo = new PartInfo(earLft);
		this.earRtJoint = new ModelRenderer(this, 22, 7);
		this.earRtJoint.setRotationPoint(-2.0F, -3.0F, 0.0F);
		this.earRtJoint.addBox(-2.0F, 0.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.0F, 0.0F, -0.4363323129985824F);
		earRtJointInfo = new PartInfo(earRtJoint);
		this.earRt = new ModelRenderer(this, 22, 7);
		this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt.addBox(-2.0F, 0.0F, -0.5F, 3, 2, 1, 0.0F);
		this.earRt.setTextureOffset(21, 3).addBox(-3.0F, -3.0F, -0.5F, 4, 3, 1, 0.0F); // earRtMid
		this.earRt.setTextureOffset(22, 0).addBox(-2.5F, -5.0F, -0.5F, 3, 2, 1, 0.0F); // earRtTip
		earRtInfo = new PartInfo(earRt);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 58); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -1.6F, 4.5F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 0, 58); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 1, 55); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.3F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 1, 55); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 1, 52); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 1, 52); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 1, 49); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 1, 49); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 1, 46); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 1, 46); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 1, 43); // tail6Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 1, 43); // tail6
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 1, 40); // tail7Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 1, 40); // tail7
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 0, 35); // tail8Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 0, 35); // tail8_1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 4, 0.0F);
		this.setRotateAngle(tail[tailNumber][partNumber], 1.3962634015954636F, 0.0F, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		int tail8Number = 0;
		this.tail8[tail8Number] = new ModelRenderer(this, 10, 35); // tail8_2
		this.tail8[tail8Number].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8[tail8Number].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 4, 0.0F);
		this.setRotateAngle(tail8[tail8Number], 0.0F, 1.3962634015954636F, 0.0F);
		tail8Info[tail8Number] = new PartInfo(tail8[tail8Number]);
		tail8Number++;
		this.tail8[tail8Number] = new ModelRenderer(this, 17, 36); // tail8_3
		this.tail8[tail8Number].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8[tail8Number].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 4, 0.0F);
		this.setRotateAngle(tail8[tail8Number], -1.3962634015954636F, 0.0F, 0.0F);
		tail8Info[tail8Number] = new PartInfo(tail8[tail8Number]);
		tail8Number++;
		this.tail8[tail8Number] = new ModelRenderer(this, 23, 37); // tail8_4
		this.tail8[tail8Number].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8[tail8Number].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 4, 0.0F);
		this.setRotateAngle(tail8[tail8Number], 0.0F, -1.3962634015954636F, 0.0F);
		tail8Info[tail8Number] = new PartInfo(tail8[tail8Number]);

		this.body.addChild(this.legFntLft);
		this.body.addChild(this.legFntRt);
		this.body.addChild(this.legBckLft);
		this.body.addChild(this.legBckRt);
		this.body.addChild(this.bodyArmorFlapBckLftJoint);
		this.body.addChild(this.bodyArmorFlapBckRtJoint);
		this.body.addChild(this.bodyArmorFlapFntLftJoint);
		this.body.addChild(this.bodyArmorFlapFntRtJoint);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.tail[0][0]);

		this.bodyArmorFlapFntLftJoint.addChild(this.bodyArmorFlapFntLft);
		this.bodyArmorFlapFntRtJoint.addChild(this.bodyArmorFlapFntRt);
		this.bodyArmorFlapBckLftJoint.addChild(this.bodyArmorFlapBckLft);
		this.bodyArmorFlapBckRtJoint.addChild(this.bodyArmorFlapBckRt);

		this.neckJoint.addChild(this.neck);
		this.neck.addChild(this.headJoint);

		this.headJoint.addChild(this.head);
		this.head.addChild(this.muzzle);
		this.head.addChild(this.cheekHairLftBck);
		this.head.addChild(this.cheekHairLftFnt);
		this.head.addChild(this.cheekHairRtBck);
		this.head.addChild(this.cheekHairRtFnt);
		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earRtJoint);
		this.head.addChild(this.foreheadHairLft);
		this.head.addChild(this.foreheadHairRt);
		this.head.addChild(this.headPiece);

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
		this.tail[7][0].addChild(this.tail[7][1]); // tail8Joint * tail8_1

		this.tail[7][0].addChild(this.tail8[0]);
		this.tail[7][0].addChild(this.tail8[1]);
		this.tail[7][0].addChild(this.tail8[2]);

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

		animateBody((EntityClayLuxio)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateHead((EntityClayLuxio)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityClayLuxio)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityClayLuxio)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

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

		cheekHairLftBckInfo.resetNewAngles();
		cheekHairLftFntInfo.resetNewAngles();
		cheekHairRtBckInfo.resetNewAngles();
		cheekHairRtFntInfo.resetNewAngles();
		foreheadHairLftInfo.resetNewAngles();
		foreheadHairRtInfo.resetNewAngles();
		
		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < tail8.length; i++)
		{
			tail8Info[i].resetNewAngles();
		}
	}
    
	public void animateBody(EntityClayLuxio entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float amplitude = 0.12F;

		bodyInfo.setNewRotateX(PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, amplitude));
	}

	public void animateHead(EntityClayLuxio entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, neckJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckJointInfo, yawHeadOffsetDifference, pitchRotation, 0.4F, 0.4F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble();

		float idleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		float movementFrequency = 1.5F;
		float movementAmplitude = 0.2F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX);
		neckInfo.setNewRotateY(neckInfo.getNewRotateY());

		JointAnimation.reverseJointRotatesChange(neckInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.6F, 0.6F);

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

		/* ******* Hairs ******** */
		foreheadHairRtInfo.setNewRotateZ(foreheadHairRtInfo.getNewRotateZ() - angleChangeZ * 0.7F);
		foreheadHairLftInfo.setNewRotateZ(foreheadHairLftInfo.getNewRotateZ() + angleChangeZ * 0.7F);

		cheekHairRtBckInfo.setNewRotateZ(cheekHairRtBckInfo.getNewRotateZ() - angleChangeZ * 0.7F);
		cheekHairRtFntInfo.setNewRotateZ(cheekHairRtFntInfo.getNewRotateZ() - angleChangeZ * 0.7F);
		cheekHairLftBckInfo.setNewRotateZ(cheekHairLftBckInfo.getNewRotateZ() + angleChangeZ * 0.7F);
		cheekHairLftFntInfo.setNewRotateZ(cheekHairLftFntInfo.getNewRotateZ() + angleChangeZ * 0.7F);
	}

	public void animateLegs(EntityClayLuxio entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
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

		float flapAmplitude = 0.4F;
		
		this.bodyArmorFlapFntLft.rotateAngleZ = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, flapAmplitude);
		this.bodyArmorFlapFntRt.rotateAngleZ = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, flapAmplitude);
		this.bodyArmorFlapBckLft.rotateAngleZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, flapAmplitude);
		this.bodyArmorFlapBckRt.rotateAngleZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, flapAmplitude);
	}

	public void animateTail(EntityClayLuxio entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = 0.1F;
			float idleAmplitudeY = 0.2F;

			float moveAmplitude = 0.1F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, moveAmplitude);
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY;

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}

		float moveFrequency = 1F;
		float moveAmplitude = 0.1F;
		
		float moveRotation = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);
		
		applyTailTipZAnimations(tailInfo[7][1], entity.getIdleAnimationClockTail(tail8.length - 1), -1, moveRotation);
		applyTailTipZAnimations(tail8Info[0], entity.getIdleAnimationClockTail(tail8.length), 1, -moveRotation);
		applyTailTipZAnimations(tail8Info[1], entity.getIdleAnimationClockTail(tail8.length + 1), 1, -moveRotation);
		applyTailTipZAnimations(tail8Info[2], entity.getIdleAnimationClockTail(tail8.length + 2), -1, moveRotation);
	}

	public void applyTailTipZAnimations(PartInfo tailTipInfo, IdleAnimationClock currentIdleAnimationClock, int modifier, float moveRotation)
	{
		float idleAmplitudeZ = 0.4F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = 0;

		angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeZ;

		tailTipInfo.setNewRotateZ(tailTipInfo.getNewRotateZ() + angleChangeZ * modifier + moveRotation);
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

		this.animationDeployer.rotate(earLft, earLftInfo.getNewRotates());
		this.animationDeployer.rotate(earLftJoint, earLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(earRt, earRtInfo.getNewRotates());
		this.animationDeployer.rotate(earRtJoint, earRtJointInfo.getNewRotates());

		this.animationDeployer.rotate(cheekHairLftBck, cheekHairLftBckInfo.getNewRotates());
		this.animationDeployer.rotate(cheekHairLftFnt, cheekHairLftFntInfo.getNewRotates());
		this.animationDeployer.rotate(cheekHairRtBck, cheekHairRtBckInfo.getNewRotates());
		this.animationDeployer.rotate(cheekHairRtFnt, cheekHairRtFntInfo.getNewRotates());
		this.animationDeployer.rotate(foreheadHairLft, foreheadHairLftInfo.getNewRotates());
		this.animationDeployer.rotate(foreheadHairRt, foreheadHairRtInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		for(int i = 0; i < tail8.length; i++)
		{
			this.animationDeployer.rotate(tail8[i], tail8Info[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}