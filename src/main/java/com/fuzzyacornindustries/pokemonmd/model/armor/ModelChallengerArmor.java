package com.fuzzyacornindustries.pokemonmd.model.armor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChallengerArmor extends ModelBiped 
{
	public ModelRenderer headPieceTop;

	public ModelRenderer headPieceFnt;

	public ModelRenderer headPieceGemJoint;
	public ModelRenderer headPieceGem;

	public ModelRenderer headPieceHornLftJoint;
	public ModelRenderer headPieceHornLft;
	public ModelRenderer headPieceHornRtJoint;
	public ModelRenderer headPieceHornRt;

	public ModelRenderer headPieceSideLftJoint;
	public ModelRenderer headPieceSideLftFnt;
	public ModelRenderer headPieceSideLftBck;

	public ModelRenderer headPieceSideRtJoint;
	public ModelRenderer headPieceSideRtFnt;
	public ModelRenderer headPieceSideRtBck;

	public ModelRenderer armRtJoint;
	public ModelRenderer shoulderPadRtEdge;

	public ModelRenderer shoulderBladeRtJoint;
	public ModelRenderer shoulderBladeRtMidFnt;
	public ModelRenderer shoulderBladeRtFnt;
	public ModelRenderer shoulderBladeRtBck;

	public ModelRenderer armLftJoint;
	public ModelRenderer shoulderPadLftEdge;

	public ModelRenderer shoulderBladeLftJoint;
	public ModelRenderer shoulderBladeLftMidFnt;
	public ModelRenderer shoulderBladeLftFnt;
	public ModelRenderer shoulderBladeLftBck;

	public ModelRenderer bipedBodyJoint;
	//public ModelRenderer bipedBody;
	public ModelRenderer chestGemJoint;
	public ModelRenderer chestGem;

	public ModelRenderer legJoint;
	public ModelRenderer beltBckRt;
	public ModelRenderer beltBckLft;
	public ModelRenderer beltFntRt;
	public ModelRenderer beltFntLft;
	public ModelRenderer beltLft;
	public ModelRenderer beltRt;
	public ModelRenderer beltFnt;

	public ModelRenderer bootRtJoint;
	public ModelRenderer bootRt;
	public ModelRenderer bootRtFnt;
	public ModelRenderer bootRtSide;
	public ModelRenderer bootRtFntTop;
	public ModelRenderer bootRtFntTopTip;

	public ModelRenderer bootLftJoint;
	public ModelRenderer bootLft;
	public ModelRenderer bootLftFnt;
	public ModelRenderer bootLftSide;
	public ModelRenderer bootLftFntTop;
	public ModelRenderer bootLftFntTopTip;

	public ModelChallengerArmor(float expand) 
	{
		super(expand, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;
		
		float sizeModifier = 0.2F;
		float pointShiftModifier = 1.15F;
		float boxShiftModifier = 1.15F;
		
		this.headPieceTop = new ModelRenderer(this, 1, 32);
		this.headPieceTop.setRotationPoint(0.0F * pointShiftModifier, -8.0F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.headPieceTop.addBox(-2.5F, -1.3F * boxShiftModifier, -4.5F * boxShiftModifier, 5, 2, 7, sizeModifier);
		this.setRotateAngle(headPieceTop, 0.15707963267948966F, 0.0F, 0.0F);

		this.headPieceFnt = new ModelRenderer(this, 0, 32);
		this.headPieceFnt.setRotationPoint(0.0F * pointShiftModifier, 0.0F * pointShiftModifier, -4.2F * pointShiftModifier);
		this.headPieceFnt.addBox(-1.5F, -1.1F * boxShiftModifier, -0.5F * boxShiftModifier, 3, 2, 1, sizeModifier);
		this.setRotateAngle(headPieceFnt, -0.15707963267948966F, 0.0F, 0.0F);
		this.headPieceFnt.setTextureOffset(1, 35).addBox(-1.0F, 0.5F * boxShiftModifier, -0.4F * boxShiftModifier, 2, 1, 1, sizeModifier); // headPieceFntMid
		this.headPieceFnt.setTextureOffset(2, 37).addBox(-0.5F, 1.0F * boxShiftModifier, -0.3F * boxShiftModifier, 1, 1, 1, sizeModifier); // headPieceFntTip

		this.headPieceGemJoint = new ModelRenderer(this, 0, 0);
		this.headPieceGemJoint.setRotationPoint(0.0F * pointShiftModifier, -0.8F * pointShiftModifier, -4.2F * pointShiftModifier);
		this.headPieceGemJoint.addBox(-0.5F, -1.1F, -0.5F, 0, 0, 0, sizeModifier);
		this.setRotateAngle(headPieceGemJoint, -0.3490658503988659F, 0.0F, 0.0F);
		this.headPieceGem = new ModelRenderer(this, 18, 32);
		this.headPieceGem.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headPieceGem.addBox(-0.5F * boxShiftModifier, -1.0F * boxShiftModifier, -0.5F * boxShiftModifier, 1, 3, 1, sizeModifier);
		this.setRotateAngle(headPieceGem, 0.0F, 0.7853981633974483F, 0.0F);

		this.headPieceHornLftJoint = new ModelRenderer(this, 0, 0);
		this.headPieceHornLftJoint.setRotationPoint(1.5F * pointShiftModifier, -0.8F * pointShiftModifier, -3.6F * pointShiftModifier);
		this.headPieceHornLftJoint.addBox(-0.5F, -1.1F, -0.5F, 0, 0, 0, sizeModifier);
		this.setRotateAngle(headPieceHornLftJoint, -0.3490658503988659F, 0.0F, 0.0F);
		this.headPieceHornLft = new ModelRenderer(this, 6, 41);
		this.headPieceHornLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headPieceHornLft.addBox(-0.5F, -1.4F * boxShiftModifier, -0.5F * boxShiftModifier, 2, 2, 1, sizeModifier);
		this.setRotateAngle(headPieceHornLft, -0.17453292519943295F, 0.0F, -0.12217304763960307F);
		this.headPieceHornLft.setTextureOffset(1, 41).addBox(-0.2F, -3.4F * boxShiftModifier, -0.5F * boxShiftModifier, 1, 2, 1, sizeModifier); // headPieceHornLftTip
		this.headPieceHornRtJoint = new ModelRenderer(this, 0, 0);
		this.headPieceHornRtJoint.setRotationPoint(-1.5F * pointShiftModifier, -0.8F * pointShiftModifier, -3.6F * pointShiftModifier);
		this.headPieceHornRtJoint.addBox(-0.5F, -1.1F, -0.5F, 0, 0, 0, sizeModifier);
		this.setRotateAngle(headPieceHornRtJoint, -0.3490658503988659F, 0.0F, 0.0F);
		this.headPieceHornRt = new ModelRenderer(this, 18, 41);
		this.headPieceHornRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headPieceHornRt.addBox(-1.5F * boxShiftModifier, -1.4F * boxShiftModifier, -0.5F * boxShiftModifier, 2, 2, 1, sizeModifier);
		this.setRotateAngle(headPieceHornRt, -0.17453292519943295F, 0.0F, 0.12217304763960307F);
		this.headPieceHornRt.setTextureOffset(13, 41).addBox(-0.7F * boxShiftModifier, -3.4F * boxShiftModifier, -0.5F * boxShiftModifier, 1, 2, 1, sizeModifier); // headPieceHornRtTip

		this.headPieceSideLftJoint = new ModelRenderer(this, 0, 0);
		this.headPieceSideLftJoint.setRotationPoint(4.5F * pointShiftModifier, -5.5F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.headPieceSideLftJoint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, sizeModifier);
		this.setRotateAngle(headPieceSideLftJoint, 0.3141592653589793F, -0.15707963267948966F, 0.7853981633974483F);
		this.headPieceSideLftFnt = new ModelRenderer(this, 0, 45); // headPieceSideLftFnt
		this.headPieceSideLftFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headPieceSideLftFnt.addBox(-0.5F * boxShiftModifier, -0.5F * boxShiftModifier, -4.5F * boxShiftModifier, 1, 1, 3, sizeModifier);
		this.headPieceSideLftFnt.setTextureOffset(5, 44).addBox(-1.0F * boxShiftModifier, -1.0F * boxShiftModifier, -1.5F * boxShiftModifier, 2, 1, 3, sizeModifier); // headPieceSideLftTop
		this.headPieceSideLftFnt.setTextureOffset(6, 48).addBox(0.0F * boxShiftModifier, 0.0F * boxShiftModifier, -1.5F * boxShiftModifier, 1, 1, 3, sizeModifier); // headPieceSideLftBot
		this.headPieceSideLftBck = new ModelRenderer(this, 11, 44);
		this.headPieceSideLftBck.setRotationPoint(0.0F * pointShiftModifier, 0.0F * pointShiftModifier, 1.0F * pointShiftModifier);
		this.headPieceSideLftBck.addBox(-0.5F * boxShiftModifier, -0.5F * boxShiftModifier, -1.0F * boxShiftModifier, 1, 1, 4, sizeModifier);
		this.setRotateAngle(headPieceSideLftBck, -0.10471975511965977F, 0.03490658503988659F, -0.08726646259971647F);

		this.headPieceSideRtJoint = new ModelRenderer(this, 0, 0);
		this.headPieceSideRtJoint.setRotationPoint(-4.5F * pointShiftModifier, -5.5F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.headPieceSideRtJoint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, sizeModifier);
		this.setRotateAngle(headPieceSideRtJoint, 0.3141592653589793F, 0.15707963267948966F, -0.7853981633974483F);
		this.headPieceSideRtFnt = new ModelRenderer(this, 0, 53); // headPieceSideRtFnt
		this.headPieceSideRtFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headPieceSideRtFnt.addBox(-0.5F * boxShiftModifier, -0.5F * boxShiftModifier, -4.5F * boxShiftModifier, 1, 1, 3, sizeModifier);
		this.headPieceSideRtFnt.setTextureOffset(5, 52).addBox(-1.0F * boxShiftModifier, -1.0F * boxShiftModifier, -1.5F * boxShiftModifier, 2, 1, 3, sizeModifier); // headPieceSideRtTop
		this.headPieceSideRtFnt.setTextureOffset(6, 56).addBox(0.0F * boxShiftModifier, 0.0F * boxShiftModifier, -1.5F * boxShiftModifier, 1, 1, 3, sizeModifier); // headPieceSideRtBot
		this.headPieceSideRtBck = new ModelRenderer(this, 11, 52);
		this.headPieceSideRtBck.setRotationPoint(0.0F * pointShiftModifier, 0.0F * pointShiftModifier, 1.0F * pointShiftModifier);
		this.headPieceSideRtBck.addBox(-0.5F * boxShiftModifier, -0.5F * boxShiftModifier, -1.0F * boxShiftModifier, 1, 1, 4, sizeModifier);
		this.setRotateAngle(headPieceSideRtBck, -0.10471975511965977F, 0.03490658503988659F, -0.08726646259971647F);

		sizeModifier = 0.4F;
		pointShiftModifier = 1.2F;
		boxShiftModifier = 1.2F;
		
		this.armRtJoint = new ModelRenderer(this, 0, 0);
		this.armRtJoint.setRotationPoint(-5.0F * pointShiftModifier, 2.0F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.armRtJoint.addBox(-3.0F * boxShiftModifier, -2.0F * boxShiftModifier, -2.0F * boxShiftModifier, 0, 0, 0, 0.0F);
		this.shoulderPadRtEdge = new ModelRenderer(this, 0, 0);
		this.shoulderPadRtEdge.setRotationPoint(-3.0F * pointShiftModifier, 1.0F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.shoulderPadRtEdge.addBox(-1.0F * boxShiftModifier, -3.0F * boxShiftModifier, -1.0F * boxShiftModifier, 2, 4, 2, sizeModifier);
		this.setRotateAngle(shoulderPadRtEdge, 0.0F, 0.7853981633974483F, 0.4363323129985824F);

		this.shoulderBladeRtJoint = new ModelRenderer(this, 0, 0);
		this.shoulderBladeRtJoint.setRotationPoint(-0.6F * pointShiftModifier, -0.9F * (pointShiftModifier * 1.8F), 0.0F * pointShiftModifier);
		this.shoulderBladeRtJoint.addBox(1.0F * boxShiftModifier, -4.0F * boxShiftModifier, 0.0F * boxShiftModifier, 0, 0, 0, sizeModifier);
		this.setRotateAngle(shoulderBladeRtJoint, 0.7853981633974483F, 3.141592653589793F, -0.3490658503988659F);
		this.shoulderBladeRtMidFnt = new ModelRenderer(this, 38, 0); // shoulderBladeRtMidFnt
		this.shoulderBladeRtMidFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderBladeRtMidFnt.addBox(0.0F * boxShiftModifier, -3.0F * boxShiftModifier, -2.0F * boxShiftModifier, 3, 2, 5, sizeModifier);
		this.shoulderBladeRtMidFnt.setTextureOffset(54, 8).addBox(0.0F * boxShiftModifier, -1.0F * boxShiftModifier, 1.0F * boxShiftModifier, 3, 3, 2, sizeModifier); // shoulderBladeRtMidBck
		this.shoulderBladeRtMidFnt.setTextureOffset(54, 0).addBox(1.0F * boxShiftModifier, -4.0F * boxShiftModifier, 0.0F * boxShiftModifier, 1, 4, 4, sizeModifier); // shoulderBladeRtTop
		this.shoulderBladeRtMidFnt.setTextureOffset(51, 0).addBox(1.01F * boxShiftModifier, -4.5F * boxShiftModifier, 2.5F * boxShiftModifier, 1, 2, 2, sizeModifier); // shoulderBladeRtTopTip
		this.shoulderBladeRtFnt = new ModelRenderer(this, 52, 13);
		this.shoulderBladeRtFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderBladeRtFnt.addBox(0.9F, -2.8F, -5.1F, 2, 2, 4, sizeModifier);
		this.setRotateAngle(shoulderBladeRtFnt, 0.5759586531581287F, -0.3490658503988659F, -0.3490658503988659F);
		this.shoulderBladeRtBck = new ModelRenderer(this, 42, 7);
		this.shoulderBladeRtBck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderBladeRtBck.addBox(0.9F, -2.8F, 1.1F, 2, 2, 4, sizeModifier);
		this.setRotateAngle(shoulderBladeRtBck, -2.0943951023931953F, -0.3490658503988659F, -0.3490658503988659F);

		this.armLftJoint = new ModelRenderer(this, 0, 0);
		this.armLftJoint.setRotationPoint(5.0F * pointShiftModifier, 2.0F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.armLftJoint.addBox(-1.0F * boxShiftModifier, -2.0F * boxShiftModifier, -2.0F * boxShiftModifier, 0, 0, 0, 0.0F);
		this.shoulderPadLftEdge = new ModelRenderer(this, 24, 0);
		this.shoulderPadLftEdge.setRotationPoint(3.0F * pointShiftModifier, 1.0F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.shoulderPadLftEdge.addBox(-1.0F * boxShiftModifier, -3.0F * boxShiftModifier, -1.0F * boxShiftModifier, 2, 4, 2, sizeModifier);
		this.setRotateAngle(shoulderPadLftEdge, 0.0F, 0.7853981633974483F, -0.4363323129985824F);

		this.shoulderBladeLftJoint = new ModelRenderer(this, 0, 0);
		this.shoulderBladeLftJoint.setRotationPoint(0.6F * pointShiftModifier, -0.9F * (pointShiftModifier * 1.8F), 0.0F * pointShiftModifier);
		this.shoulderBladeLftJoint.addBox(1.0F * boxShiftModifier, -4.0F * boxShiftModifier, 0.0F * boxShiftModifier, 0, 0, 0, sizeModifier);
		this.setRotateAngle(shoulderBladeLftJoint, 0.7853981633974483F, 0.0F, 0.3490658503988659F);
		this.shoulderBladeLftMidFnt = new ModelRenderer(this, 43, 37); // shoulderBladeLftMidFnt
		this.shoulderBladeLftMidFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderBladeLftMidFnt.addBox(0.0F * boxShiftModifier, -3.0F * boxShiftModifier, -2.0F * boxShiftModifier, 3, 2, 5, sizeModifier);
		this.shoulderBladeLftMidFnt.setTextureOffset(38, 37).addBox(0.0F * boxShiftModifier, -1.0F * boxShiftModifier, 1.0F * boxShiftModifier, 3, 3, 2, sizeModifier); // shoulderBladeLftMidBck
		this.shoulderBladeLftMidFnt.setTextureOffset(54, 32).addBox(1.0F * boxShiftModifier, -4.0F * boxShiftModifier, 0.0F * boxShiftModifier, 1, 4, 4, sizeModifier); // shoulderBladeLftTop
		this.shoulderBladeLftMidFnt.setTextureOffset(58, 43).addBox(1.01F * boxShiftModifier, -4.5F * boxShiftModifier, 2.5F * boxShiftModifier, 1, 2, 2, sizeModifier); // shoulderBladeLftTopTip
		this.shoulderBladeLftFnt = new ModelRenderer(this, 30, 38);
		this.shoulderBladeLftFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderBladeLftFnt.addBox(0.9F, -2.8F, -5.1F, 2, 2, 4, sizeModifier);
		this.setRotateAngle(shoulderBladeLftFnt, 0.5759586531581287F, -0.3490658503988659F, -0.3490658503988659F);
		this.shoulderBladeLftBck = new ModelRenderer(this, 22, 40);
		this.shoulderBladeLftBck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderBladeLftBck.addBox(0.9F, -2.8F, 1.1F, 2, 2, 4, sizeModifier);
		this.setRotateAngle(shoulderBladeLftBck, -2.0943951023931953F, -0.3490658503988659F, -0.3490658503988659F);

		this.bipedBodyJoint = new ModelRenderer(this, 0, 0);
		this.bipedBodyJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBodyJoint.addBox(-4.0F * boxShiftModifier, 0.0F * boxShiftModifier, -2.0F * boxShiftModifier, 0, 0, 0, sizeModifier);
		//this.bipedBody = new ModelRenderer(this, 16, 16);
		//this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		//this.bipedBody.addBox(-4.0F * boxShiftModifier, 0.0F * boxShiftModifier, -2.0F * boxShiftModifier, 8, 12, 4, sizeModifier);
		this.chestGemJoint = new ModelRenderer(this, 0, 0);
		this.chestGemJoint.setRotationPoint(0.0F * pointShiftModifier, 3.0F * pointShiftModifier, -2.3F * pointShiftModifier);
		this.chestGemJoint.addBox(-0.5F * boxShiftModifier, -3.0F * boxShiftModifier, -0.5F * boxShiftModifier, 0, 0, 0, sizeModifier);
		this.setRotateAngle(chestGemJoint, 0.17453292519943295F, 0.0F, 0.0F);
		this.chestGem = new ModelRenderer(this, 57, 20);
		this.chestGem.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chestGem.addBox(-0.5F * boxShiftModifier, -1.5F * boxShiftModifier, -0.5F * boxShiftModifier, 1, 4, 1, sizeModifier);
		this.setRotateAngle(chestGem, 0.0F, 0.7853981633974483F, 0.0F);

		sizeModifier = 0.5F;
		pointShiftModifier = 1.2F;
		boxShiftModifier = 1.2F;
		
		this.legJoint = new ModelRenderer(this, 0, 0);
		this.legJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legJoint.addBox(-4.0F * boxShiftModifier, 0.0F * boxShiftModifier, -2.0F * boxShiftModifier, 0, 0, 0, sizeModifier);
		this.beltBckRt = new ModelRenderer(this, 26, 32);
		this.beltBckRt.setRotationPoint(0.0F * pointShiftModifier, 12.5F * (pointShiftModifier * 0.90F), 2.0F * pointShiftModifier);
		this.beltBckRt.addBox(-3.9F, -0.5F, -0.5F, 4, 1, 1, sizeModifier);
		this.setRotateAngle(beltBckRt, 0.7853981633974483F, 0.0F, 0.17453292519943295F);
		this.beltBckLft = new ModelRenderer(this, 36, 32);
		this.beltBckLft.setRotationPoint(0.0F * pointShiftModifier, 12.5F * (pointShiftModifier * 0.90F), 2.0F * pointShiftModifier);
		this.beltBckLft.addBox(-0.1F, -0.5F, -0.5F, 4, 1, 1, sizeModifier);
		this.setRotateAngle(beltBckLft, 0.7853981633974483F, 0.0F, -0.17453292519943295F);
		this.beltFntRt = new ModelRenderer(this, 26, 34);
		this.beltFntRt.setRotationPoint(0.0F * pointShiftModifier, 12.5F * (pointShiftModifier * 0.90F), -2.0F * pointShiftModifier);
		this.beltFntRt.addBox(-3.9F, -0.5F, -0.5F, 4, 1, 1, sizeModifier);
		this.setRotateAngle(beltFntRt, 0.7853981633974483F, 0.0F, 0.17453292519943295F);
		this.beltFntLft = new ModelRenderer(this, 36, 34);
		this.beltFntLft.setRotationPoint(0.0F * pointShiftModifier, 12.5F * (pointShiftModifier * 0.90F), -2.0F * pointShiftModifier);
		this.beltFntLft.addBox(-0.1F, -0.5F, -0.5F, 4, 1, 1, sizeModifier);
		this.setRotateAngle(beltFntLft, 0.7853981633974483F, 0.0F, -0.17453292519943295F);
		this.beltLft = new ModelRenderer(this, 42, 32);
		this.beltLft.setRotationPoint(3.9F * pointShiftModifier, 11.8F * (pointShiftModifier * 0.90F), 0.0F * pointShiftModifier);
		this.beltLft.addBox(-0.5F, -0.5F, -2.0F * boxShiftModifier, 1, 1, 4, sizeModifier);
		this.setRotateAngle(beltLft, 0.0F, 0.0F, 0.7853981633974483F);
		this.beltRt = new ModelRenderer(this, 20, 32);
		this.beltRt.setRotationPoint(-4.0F * pointShiftModifier, 11.8F * (pointShiftModifier * 0.90F), 0.0F * pointShiftModifier);
		this.beltRt.addBox(-0.5F, -0.5F, -2.0F * boxShiftModifier, 1, 1, 4, sizeModifier);
		this.setRotateAngle(beltRt, 0.0F, 0.0F, 0.7853981633974483F);
		this.beltFnt = new ModelRenderer(this, 48, 32);
		this.beltFnt.setRotationPoint(0.0F * pointShiftModifier, 12.0F * (pointShiftModifier * 0.90F), -2.0F * pointShiftModifier);
		this.beltFnt.addBox(-1.5F, -1.5F, -0.5F, 3, 3, 1, sizeModifier);
		this.setRotateAngle(beltFnt, 0.0F, 0.0F, 0.7853981633974483F);

		sizeModifier = 0.5F;
		pointShiftModifier = 1.1F;
		boxShiftModifier = 1.05F;
		
		this.bootRtJoint = new ModelRenderer(this, 0, 0);
		this.bootRtJoint.setRotationPoint(-1.9F * (pointShiftModifier * 0.2F), 12.0F * (pointShiftModifier * 0.95F), 0.0F * pointShiftModifier);
		this.bootRtJoint.addBox(-2.0F * boxShiftModifier, 0.0F * boxShiftModifier, -2.0F * boxShiftModifier, 0, 0, 0, sizeModifier);
		this.bootRt = new ModelRenderer(this, 24, 54);
		this.bootRt.setRotationPoint(0.0F * pointShiftModifier, 11.6F * (pointShiftModifier * 0.95F), 0.0F * pointShiftModifier);
		this.bootRt.addBox(-2.5F * boxShiftModifier, -4.5F * boxShiftModifier, -2.3F * boxShiftModifier, 5, 5, 5, sizeModifier * 1.7F);
		this.bootRtFnt = new ModelRenderer(this, 28, 47);
		this.bootRtFnt.setRotationPoint(0.0F * pointShiftModifier, 11.6F * (pointShiftModifier * 0.95F), -2.0F * pointShiftModifier);
		this.bootRtFnt.addBox(-2.49F * boxShiftModifier, -5.5F * boxShiftModifier, -0.5F * boxShiftModifier, 5, 6, 1, sizeModifier);
		this.setRotateAngle(bootRtFnt, 0.06981317007977318F, 0.0F, 0.0F);
		this.bootRtSide = new ModelRenderer(this, 21, 53);
		this.bootRtSide.setRotationPoint(-2.4F * pointShiftModifier, -2.5F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.bootRtSide.addBox(-0.5F * boxShiftModifier, -3.0F * boxShiftModifier, -0.5F * boxShiftModifier, 2, 4, 2, sizeModifier);
		this.setRotateAngle(bootRtSide, 0.0F, 0.7853981633974483F, -0.2617993877991494F);
		this.bootRtFntTop = new ModelRenderer(this, 20, 49);
		this.bootRtFntTop.setRotationPoint(-0.4F * pointShiftModifier, -4.6F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.bootRtFntTop.addBox(-2.5F * boxShiftModifier, -2.5F * boxShiftModifier, -0.5F * boxShiftModifier, 3, 3, 1, sizeModifier);
		this.setRotateAngle(bootRtFntTop, 0.22689280275926282F, -0.20943951023931953F, 0.7853981633974483F);
		this.bootRtFntTopTip = new ModelRenderer(this, 22, 47);
		this.bootRtFntTopTip.setRotationPoint(-1.0F * pointShiftModifier, -1.0F * pointShiftModifier, -0.3F * pointShiftModifier);
		this.bootRtFntTopTip.addBox(-0.5F * boxShiftModifier, -0.5F * boxShiftModifier, -0.5F * boxShiftModifier, 1, 1, 1, sizeModifier);
		this.setRotateAngle(bootRtFntTopTip, 0.7853981633974483F, 0.7853981633974483F, 0.0F);

		this.bootLftJoint = new ModelRenderer(this, 0, 0);
		this.bootLftJoint.setRotationPoint(1.9F * (pointShiftModifier * 0.2F), 12.0F * (pointShiftModifier * 0.95F), 0.01F * pointShiftModifier);
		this.bootLftJoint.addBox(-2.0F * boxShiftModifier, 0.0F * boxShiftModifier, -2.0F * boxShiftModifier, 0, 0, 0, sizeModifier);
		this.bootLft = new ModelRenderer(this, 44, 54);
		this.bootLft.setRotationPoint(0.0F * pointShiftModifier, 11.6F * (pointShiftModifier * 0.95F), 0.0F * pointShiftModifier);
		this.bootLft.addBox(-2.5F * boxShiftModifier, -4.5F * boxShiftModifier, -2.3F * boxShiftModifier, 5, 5, 5, sizeModifier * 1.7F);
		this.bootLftFnt = new ModelRenderer(this, 48, 47);
		this.bootLftFnt.setRotationPoint(0.0F * pointShiftModifier, 11.6F * (pointShiftModifier * 0.95F), -2.01F * pointShiftModifier);
		this.bootLftFnt.addBox(-2.51F * boxShiftModifier, -5.5F * boxShiftModifier, -0.5F * boxShiftModifier, 5, 6, 1, sizeModifier);
		this.setRotateAngle(bootLftFnt, 0.06981317007977318F, 0.0F, 0.0F);
		this.bootLftSide = new ModelRenderer(this, 40, 53);
		this.bootLftSide.setRotationPoint(0.9F * pointShiftModifier, -2.5F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.bootLftSide.addBox(-0.5F * boxShiftModifier, -3.0F * boxShiftModifier, -0.5F * boxShiftModifier, 2, 4, 2, sizeModifier);
		this.setRotateAngle(bootLftSide, 0.0F, 0.7853981633974483F, 0.2617993877991494F);
		this.bootLftFntTop = new ModelRenderer(this, 40, 49);
		this.bootLftFntTop.setRotationPoint(0.4F * pointShiftModifier, -4.6F * pointShiftModifier, 0.0F * pointShiftModifier);
		this.bootLftFntTop.addBox(-2.5F * boxShiftModifier, -2.5F * boxShiftModifier, -0.5F * boxShiftModifier, 3, 3, 1, sizeModifier);
		this.setRotateAngle(bootLftFntTop, 0.22689280275926282F, -0.20943951023931953F, 0.7853981633974483F);
		this.bootLftFntTopTip = new ModelRenderer(this, 42, 47);
		this.bootLftFntTopTip.setRotationPoint(-1.0F * pointShiftModifier, -1.0F * pointShiftModifier, -0.3F * pointShiftModifier);
		this.bootLftFntTopTip.addBox(-0.5F * boxShiftModifier, -0.5F * boxShiftModifier, -0.5F * boxShiftModifier, 1, 1, 1, sizeModifier);
		this.setRotateAngle(bootLftFntTopTip, 0.7853981633974483F, 0.7853981633974483F, 0.0F);

		this.bipedBody.addChild(this.bipedBodyJoint);
		//this.bipedBody.addChild(this.legJoint);
		this.bipedRightArm.addChild(this.armRtJoint);
		this.bipedLeftArm.addChild(this.armLftJoint);
		this.bipedRightLeg.addChild(this.bootRtJoint);
		this.bipedLeftLeg.addChild(this.bootLftJoint);

		this.bipedLeftArm.addChild(this.shoulderBladeLftJoint);
		this.bipedLeftArm.addChild(this.shoulderPadLftEdge);
		this.bipedRightArm.addChild(this.shoulderBladeRtJoint);
		this.bipedRightArm.addChild(this.shoulderPadRtEdge);
		this.bipedBody.addChild(this.beltBckLft);
		this.bipedBody.addChild(this.beltBckRt);
		this.bipedBody.addChild(this.beltFnt);
		this.bipedBody.addChild(this.beltFntLft);
		this.bipedBody.addChild(this.beltFntRt);
		this.bipedBody.addChild(this.beltLft);
		this.bipedBody.addChild(this.beltRt);
		//this.bipedBodyJoint.addChild(this.bipedBody);
		this.bipedBodyJoint.addChild(this.chestGemJoint);
		this.bootLft.addChild(this.bootLftSide);
		this.bootLftFnt.addChild(this.bootLftFntTop);
		this.bootLftFntTop.addChild(this.bootLftFntTopTip);
		this.bipedLeftLeg.addChild(this.bootLft);
		this.bipedLeftLeg.addChild(this.bootLftFnt);
		this.bootRt.addChild(this.bootRtSide);
		this.bootRtFnt.addChild(this.bootRtFntTop);
		this.bootRtFntTop.addChild(this.bootRtFntTopTip);
		this.bipedRightLeg.addChild(this.bootRt);
		this.bipedRightLeg.addChild(this.bootRtFnt);
		this.chestGemJoint.addChild(this.chestGem);
		this.headPieceGemJoint.addChild(this.headPieceGem);
		this.headPieceHornLftJoint.addChild(this.headPieceHornLft);
		this.headPieceHornRtJoint.addChild(this.headPieceHornRt);
		this.headPieceSideLftJoint.addChild(this.headPieceSideLftBck);
		this.headPieceSideLftJoint.addChild(this.headPieceSideLftFnt);
		this.headPieceSideRtJoint.addChild(this.headPieceSideRtBck);
		this.headPieceSideRtJoint.addChild(this.headPieceSideRtFnt);
		this.headPieceTop.addChild(this.headPieceFnt);
		this.headPieceTop.addChild(this.headPieceGemJoint);
		this.headPieceTop.addChild(this.headPieceHornLftJoint);
		this.headPieceTop.addChild(this.headPieceHornRtJoint);
		this.bipedHead.addChild(this.headPieceSideLftJoint);
		this.bipedHead.addChild(this.headPieceSideRtJoint);
		this.bipedHead.addChild(this.headPieceTop);
		this.shoulderBladeLftJoint.addChild(this.shoulderBladeLftBck);
		this.shoulderBladeLftJoint.addChild(this.shoulderBladeLftFnt);
		this.shoulderBladeLftJoint.addChild(this.shoulderBladeLftMidFnt);
		this.shoulderBladeRtJoint.addChild(this.shoulderBladeRtBck);
		this.shoulderBladeRtJoint.addChild(this.shoulderBladeRtFnt);
		this.shoulderBladeRtJoint.addChild(this.shoulderBladeRtMidFnt);
	}
	 // (Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{ 
		super.render(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		setRotationAngles(distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, entity);
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