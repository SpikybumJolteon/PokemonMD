package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFeywoodMegaAbsol extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public final float RUN_FREQUENCY = 0.6F;
	public final float WALK_FREQUENCY = 0.95F;
	public final float WALK_MAX = 0.4F;
	public final float RUN_MIN = 0.5F;

	public ModelRenderer bodyJoint;
	public ModelRenderer body;
	public ModelRenderer bodyBck;
	PartInfo bodyJointInfo;
	PartInfo bodyJointSitInfo;
	PartInfo bodyInfo;
	PartInfo bodySitInfo;

	public ModelRenderer legFntLft[][] = new ModelRenderer[2][2];
	PartInfo legFntLftInfo[][] = new PartInfo[legFntLft.length][legFntLft[0].length];
	PartInfo legFntLftSitInfo[][] = new PartInfo[legFntLft.length][legFntLft[0].length];

	public ModelRenderer legFntRt[][] = new ModelRenderer[2][2];
	PartInfo legFntRtInfo[][] = new PartInfo[legFntRt.length][legFntRt[0].length];
	PartInfo legFntRtSitInfo[][] = new PartInfo[legFntRt.length][legFntRt[0].length];

	public ModelRenderer legBckLft[][] = new ModelRenderer[3][2];
	PartInfo legBckLftInfo[][] = new PartInfo[legBckLft.length][legBckLft[0].length];
	PartInfo legBckLftSitInfo[][] = new PartInfo[legBckLft.length][legBckLft[0].length];

	public ModelRenderer legBckRt[][] = new ModelRenderer[3][2];
	PartInfo legBckRtInfo[][] = new PartInfo[legBckRt.length][legBckRt[0].length];
	PartInfo legBckRtSitInfo[][] = new PartInfo[legBckRt.length][legBckRt[0].length];

	public ModelRenderer legFntLftSpike;
	public ModelRenderer legFntRtSpike;
	public ModelRenderer legBckLftSpike;
	public ModelRenderer legBckRtSpike;

	PartInfo legFntLftSpikeInfo;
	PartInfo legFntRtSpikeInfo;
	PartInfo legBckLftSpikeInfo;
	PartInfo legBckRtSpikeInfo;
	PartInfo legFntLftSpikeSitInfo;
	PartInfo legFntRtSpikeSitInfo;
	PartInfo legBckLftSpikeSitInfo;
	PartInfo legBckRtSpikeSitInfo;

	public ModelRenderer legFntLftTuff1[] = new ModelRenderer[5];
	PartInfo legFntLftTuff1Info[] = new PartInfo[legFntLftTuff1.length];
	PartInfo legFntLftTuff1_1SitInfo;

	public ModelRenderer legFntLftTuff2[] = new ModelRenderer[5];
	PartInfo legFntLftTuff2Info[] = new PartInfo[legFntLftTuff2.length];
	PartInfo legFntLftTuff2_1SitInfo;

	public ModelRenderer legFntLftTuff3[] = new ModelRenderer[4];
	PartInfo legFntLftTuff3Info[] = new PartInfo[legFntLftTuff3.length];
	PartInfo legFntLftTuff3_1SitInfo;

	public ModelRenderer legFntLftTuff4[] = new ModelRenderer[3];
	PartInfo legFntLftTuff4Info[] = new PartInfo[legFntLftTuff4.length];
	PartInfo legFntLftTuff4_1SitInfo;

	public ModelRenderer legFntRtTuff1[] = new ModelRenderer[5];
	PartInfo legFntRtTuff1Info[] = new PartInfo[legFntRtTuff1.length];
	PartInfo legFntRtTuff1_1SitInfo;

	public ModelRenderer legFntRtTuff2[] = new ModelRenderer[5];
	PartInfo legFntRtTuff2Info[] = new PartInfo[legFntRtTuff2.length];
	PartInfo legFntRtTuff2_1SitInfo;

	public ModelRenderer legFntRtTuff3[] = new ModelRenderer[4];
	PartInfo legFntRtTuff3Info[] = new PartInfo[legFntRtTuff3.length];
	PartInfo legFntRtTuff3_1SitInfo;

	public ModelRenderer legFntRtTuff4[] = new ModelRenderer[3];
	PartInfo legFntRtTuff4Info[] = new PartInfo[legFntRtTuff4.length];
	PartInfo legFntRtTuff4_1SitInfo;

	public ModelRenderer legBckLftTuff1[] = new ModelRenderer[5];
	PartInfo legBckLftTuff1Info[] = new PartInfo[legBckLftTuff1.length];
	PartInfo legBckLftTuff1_1SitInfo;

	public ModelRenderer legBckLftTuff2[] = new ModelRenderer[5];
	PartInfo legBckLftTuff2Info[] = new PartInfo[legBckLftTuff2.length];
	PartInfo legBckLftTuff2_1SitInfo;

	public ModelRenderer legBckLftTuff3[] = new ModelRenderer[4];
	PartInfo legBckLftTuff3Info[] = new PartInfo[legBckLftTuff3.length];
	PartInfo legBckLftTuff3_1SitInfo;

	public ModelRenderer legBckLftTuff4[] = new ModelRenderer[3];
	PartInfo legBckLftTuff4Info[] = new PartInfo[legBckLftTuff4.length];
	PartInfo legBckLftTuff4_1SitInfo;

	public ModelRenderer legBckRtTuff1[] = new ModelRenderer[5];
	PartInfo legBckRtTuff1Info[] = new PartInfo[legBckRtTuff1.length];
	PartInfo legBckRtTuff1_1SitInfo;

	public ModelRenderer legBckRtTuff2[] = new ModelRenderer[5];
	PartInfo legBckRtTuff2Info[] = new PartInfo[legBckRtTuff2.length];
	PartInfo legBckRtTuff2_1SitInfo;

	public ModelRenderer legBckRtTuff3[] = new ModelRenderer[4];
	PartInfo legBckRtTuff3Info[] = new PartInfo[legBckRtTuff3.length];
	PartInfo legBckRtTuff3_1SitInfo;

	public ModelRenderer legBckRtTuff4[] = new ModelRenderer[3];
	PartInfo legBckRtTuff4Info[] = new PartInfo[legBckRtTuff4.length];
	PartInfo legBckRtTuff4_1SitInfo;

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo neckJointInfo;
	PartInfo neckInfo;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer muzzle;

	public ModelRenderer headHair;
	public ModelRenderer headHairMid;
	public ModelRenderer headHairTop;

	public ModelRenderer headGem;
	public ModelRenderer headGemTop;
	public ModelRenderer headGemBot;
	public ModelRenderer headGemBotTip;

	public ModelRenderer headBang[] = new ModelRenderer[8];
	PartInfo headBangInfo[] = new PartInfo[headBang.length];

	public ModelRenderer headHornBase;
	public ModelRenderer headHorn1;
	public ModelRenderer headHorn2;
	public ModelRenderer headHorn3;
	public ModelRenderer headHorn4;
	public ModelRenderer headHorn5;
	public ModelRenderer headHorn6;

	public ModelRenderer headHornBot;
	public ModelRenderer headHornBotTip;

	public ModelRenderer headHornEdge1;
	public ModelRenderer headHornEdge2;
	public ModelRenderer headHornEdge3;

	public ModelRenderer headHornSmall;
	public ModelRenderer headHornSmallTip;
	public ModelRenderer headHornSmallBlade;

	public ModelRenderer tail1;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer tailEdge1;
	public ModelRenderer tailEdge2;
	public ModelRenderer tailEdge3;
	public ModelRenderer tailEdge4;
	PartInfo tailInfo;

	public ModelRenderer backFluffLft;
	public ModelRenderer backFluffRt;

	public ModelRenderer backFluffLft1;

	public ModelRenderer backFluffLft1Top;
	public ModelRenderer backFluffLft1Top1_1;
	public ModelRenderer backFluffLft1Top1_2;
	public ModelRenderer backFluffLft1Top2;

	public ModelRenderer backFluffLft1Mid;
	public ModelRenderer backFluffLft1Mid1_1;
	public ModelRenderer backFluffLft1Mid1_2;
	public ModelRenderer backFluffLft1Mid2;

	public ModelRenderer backFluffLft1Bot;
	public ModelRenderer backFluffLft1Bot1_1;
	public ModelRenderer backFluffLft1Bot1_2;
	public ModelRenderer backFluffLft1Bot2;

	public ModelRenderer backFluffLft2;
	public ModelRenderer backFluffLft2Mid;
	public ModelRenderer backFluffLft2Mid1_1;
	public ModelRenderer backFluffLft2Mid1_2;
	public ModelRenderer backFluffLft2Mid2;

	public ModelRenderer backFluffLft3;
	public ModelRenderer backFluffLft3Mid;
	public ModelRenderer backFluffLft3Mid1_1;
	public ModelRenderer backFluffLft3Mid1_2;
	public ModelRenderer backFluffLft3Mid2;

	public ModelRenderer backFluffRt1;

	public ModelRenderer backFluffRt1Top;
	public ModelRenderer backFluffRt1Top1_1;
	public ModelRenderer backFluffRt1Top1_2;
	public ModelRenderer backFluffRt1Top2;

	public ModelRenderer backFluffRt1Mid;
	public ModelRenderer backFluffRt1Mid1_1;
	public ModelRenderer backFluffRt1Mid1_2;
	public ModelRenderer backFluffRt1Mid2;

	public ModelRenderer backFluffRt1Bot;
	public ModelRenderer backFluffRt1Bot1_1;
	public ModelRenderer backFluffRt1Bot1_2;
	public ModelRenderer backFluffRt1Bot2;

	public ModelRenderer backFluffRt2;
	public ModelRenderer backFluffRt2Mid;
	public ModelRenderer backFluffRt2Mid1_1;
	public ModelRenderer backFluffRt2Mid1_2;
	public ModelRenderer backFluffRt2Mid2;

	public ModelRenderer backFluffRt3;
	public ModelRenderer backFluffRt3Mid;
	public ModelRenderer backFluffRt3Mid1_1;
	public ModelRenderer backFluffRt3Mid1_2;
	public ModelRenderer backFluffRt3Mid2;

	public ModelFeywoodMegaAbsol() 
	{
		this.textureWidth = 128;
		this.textureHeight = 128;

		int jointNumber = 0;
		int partNumber = 1;

		this.bodyJoint = new ModelRenderer(this, 0, 0);
		this.bodyJoint.setRotationPoint(0.0F, 8.5F, 1.0F);
		this.bodyJoint.addBox(0.0F, -3.0F, -6.0F, 0, 0, 0, 0.0F);
		this.bodyJointInfo = new PartInfo(bodyJoint);
		this.body = new ModelRenderer(this, 66, 107);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-5.0F, -5.5F, -11.0F, 10, 10, 11, 0.0F);
		this.body.setTextureOffset(67, 87).addBox(-4.5F, -4.7F, 0.0F, 9, 9, 11, 0.0F); // bodyBck
		this.bodyInfo = new PartInfo(body);

		this.bodyJoint.setRotationPoint(0.0F, 14.0F, 1.0F);
		this.bodyJointSitInfo = new PartInfo(bodyJoint);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.setRotateAngle(body, -0.7853981633974483F, 0.0F, 0.0F);
		this.bodySitInfo = new PartInfo(body);

		int legPartNumber = 0;
		this.legFntLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntLft1Joint
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(4.0F, 0.0F, -6.9F);
		this.legFntLft[legPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.legFntLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber] = new ModelRenderer(this, 108, 58); // legFntLft1
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLft[legPartNumber][partNumber].addBox(-3.0F, -1.4F, -2.5F, 5, 6, 5, 0.0F);
		this.legFntLftInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntLft2Joint
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(-0.5F, 4.7F, -0.2F);
		this.legFntLft[legPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legFntLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber] = new ModelRenderer(this, 108, 69); // legFntLft2
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLft[legPartNumber][partNumber].addBox(-2.49F, -2.0F, -2.5F, 5, 13, 5, 0.0F);
		this.legFntLftInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(4.0F, 0.0F, -6.9F); // legFntLft1Joint
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], 1.1344640137963142F, 0.0F, 0.0F);
		this.legFntLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntLft1
		this.legFntLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(-0.5F, 4.7F, -0.2F); // legFntLft2Joint
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.legFntLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntLft2
		this.legFntLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legFntRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntRt1Joint
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(-4.0F, 0.0F, -6.9F);
		this.legFntRt[legPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.legFntRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber] = new ModelRenderer(this, 46, 58); // legFntRt1
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntRt[legPartNumber][partNumber].addBox(-2.0F, -1.4F, -2.5F, 5, 6, 5, 0.0F);
		this.legFntRtInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntRt2Joint
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(0.5F, 4.7F, -0.2F);
		this.legFntRt[legPartNumber][jointNumber].addBox(-1.0F, -1.0F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legFntRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber] = new ModelRenderer(this, 46, 69); // legFntRt2
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntRt[legPartNumber][partNumber].addBox(-2.51F, -2.0F, -2.5F, 5, 13, 5, 0.0F);
		this.legFntRtInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(-4.0F, 0.0F, -6.9F); // legFntRt1Joint
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], 1.1344640137963142F, 0.0F, 0.0F);
		this.legFntRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntRt1
		this.legFntRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(0.5F, 4.7F, -0.2F); // legFntRt2Joint
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.legFntRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntRt2
		this.legFntRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckLft1Joint
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(3.7F, 0.0F, 6.3F);
		this.legBckLft[legPartNumber][jointNumber].addBox(-2.0F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -0.17453292519943295F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 108, 88); // legBckLft1
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLft[legPartNumber][partNumber].addBox(-3.0F, -1.2F, -1.5F, 5, 9, 5, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckLft2Joint
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(-0.5F, 5.7F, 0.0F);
		this.legBckLft[legPartNumber][jointNumber].addBox(-1.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], 1.1344640137963142F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 108, 102); // legBckLft2
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLft[legPartNumber][partNumber].addBox(-2.51F, -0.5F, -2.5F, 5, 7, 5, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckLft3Joint
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 4.9F, 0.0F);
		this.legBckLft[legPartNumber][jointNumber].addBox(-1.5F, -0.6F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -1.1344640137963142F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 108, 114); // legBckLft3
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLft[legPartNumber][partNumber].addBox(-2.52F, -1.5F, -2.5F, 5, 9, 5, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(3.7F, 0.0F, 6.3F); // legBckLft1Joint
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -1.1519173063162573F, 0.0F, 0.0F);
		this.legBckLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckLft1
		this.setRotateAngle(legBckLft[legPartNumber][partNumber], 0.0F, 0.17453292519943295F, -0.5235987755982988F);
		this.legBckLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(-0.5F, 5.7F, 0.0F); // legBckLft2Joint
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], 2.007128639793479F, 0.0F, 0.0F);
		this.legBckLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckLft2
		this.legBckLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 4.9F, 0.0F); // legBckLft3Joint
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -1.7104226669544427F, 0.0F, 0.0F);
		this.legBckLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckLft3
		this.legBckLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckRt1Joint
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(-3.7F, 0.0F, 6.3F);
		this.legBckRt[legPartNumber][jointNumber].addBox(-2.0F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -0.17453292519943295F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 46, 88); // legBckRt1
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRt[legPartNumber][partNumber].addBox(-2.0F, -1.2F, -1.5F, 5, 9, 5, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckRt2Joint
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.5F, 5.7F, 0.0F);
		this.legBckRt[legPartNumber][jointNumber].addBox(-1.5F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], 1.1344640137963142F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 46, 102); // legBckRt2
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRt[legPartNumber][partNumber].addBox(-2.49F, -0.5F, -2.5F, 5, 7, 5, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legBckRt3Joint
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 4.9F, 0.0F);
		this.legBckRt[legPartNumber][jointNumber].addBox(-1.5F, -0.6F, -1.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -1.1344640137963142F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 46, 114); // legBckRt3
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRt[legPartNumber][partNumber].addBox(-2.48F, -1.5F, -2.5F, 5, 9, 5, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(-3.7F, 0.0F, 6.3F); // legBckRt1Joint
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -1.1519173063162573F, 0.0F, 0.0F);
		this.legBckRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckRt1
		this.setRotateAngle(legBckRt[legPartNumber][partNumber], 0.0F, -0.17453292519943295F, 0.5235987755982988F);
		this.legBckRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.5F, 5.7F, 0.0F); // legBckRt2Joint
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], 2.007128639793479F, 0.0F, 0.0F);
		this.legBckRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckRt2
		this.legBckRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 4.9F, 0.0F); // legBckRt3Joint
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -1.7104226669544427F, 0.0F, 0.0F);
		this.legBckRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckRt3
		this.legBckRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);

		this.legFntLftSpike = new ModelRenderer(this, 97, 92);
		this.legFntLftSpike.setRotationPoint(0.85F, -1.0F, 1.0F);
		this.legFntLftSpike.addBox(-0.5F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legFntLftSpike, 0.6283185307179586F, 0.20943951023931953F, 0.0F);
		this.legFntLftSpike.setTextureOffset(98, 88).addBox(-0.5F, 0.0F, 2.6F, 2, 2, 2, 0.0F); // legFntLftSpikeMid
		this.legFntLftSpike.setTextureOffset(106, 89).addBox(0.0F, 0.5F, 4.6F, 1, 1, 2, 0.0F); // legFntLftSpikeTip
		this.legFntLftSpikeInfo = new PartInfo(legFntLftSpike);

		this.legFntLftSpike = new ModelRenderer(this, 97, 92);
		this.legFntLftSpike.setRotationPoint(0.85F, -1.0F, 1.0F);
		this.legFntLftSpike.addBox(-0.5F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legFntLftSpike, 0.6283185307179586F, 0.20943951023931953F, 0.0F);
		this.legFntLftSpikeSitInfo = new PartInfo(legFntLftSpike);

		this.legFntRtSpike = new ModelRenderer(this, 67, 92);
		this.legFntRtSpike.setRotationPoint(-1.85F, -1.0F, 1.0F);
		this.legFntRtSpike.addBox(-0.5F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legFntRtSpike, 0.6283185307179586F, -0.20943951023931953F, 0.0F);
		this.legFntRtSpike.setTextureOffset(68, 88).addBox(-0.5F, 0.0F, 2.6F, 2, 2, 2, 0.0F); // legFntRtSpikeMid
		this.legFntRtSpike.setTextureOffset(62, 89).addBox(0.0F, 0.5F, 4.6F, 1, 1, 2, 0.0F); // legFntRtSpikeTip
		this.legFntRtSpikeInfo = new PartInfo(legFntRtSpike);

		this.legFntRtSpike = new ModelRenderer(this, 67, 92);
		this.legFntRtSpike.setRotationPoint(-1.85F, -1.0F, 1.0F);
		this.legFntRtSpike.addBox(-0.5F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legFntRtSpike, 0.6283185307179586F, -0.20943951023931953F, 0.0F);
		this.legFntRtSpikeSitInfo = new PartInfo(legFntRtSpike);

		this.legBckLftSpike = new ModelRenderer(this, 97, 112);
		this.legBckLftSpike.setRotationPoint(0.0F, -1.0F, 1.0F);
		this.legBckLftSpike.addBox(-1.0F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legBckLftSpike, 0.6283185307179586F, 0.0F, 0.0F);
		this.legBckLftSpike.setTextureOffset(98, 108).addBox(-1.0F, 0.0F, 2.6F, 2, 2, 2, 0.0F); // legBckLftSpikeMid
		this.legBckLftSpike.setTextureOffset(107, 115).addBox(-0.5F, 0.5F, 4.5F, 1, 1, 2, 0.0F); // legBckLftSpikeTip
		this.legBckLftSpikeInfo = new PartInfo(legBckLftSpike);

		this.legBckLftSpike = new ModelRenderer(this, 97, 112);
		this.legBckLftSpike.setRotationPoint(0.0F, -1.0F, 1.0F);
		this.legBckLftSpike.addBox(-1.0F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legBckLftSpike, 1.5707963267948966F, 0.0F, 0.0F);
		this.legBckLftSpikeSitInfo = new PartInfo(legBckLftSpike);

		this.legBckRtSpike = new ModelRenderer(this, 67, 112);
		this.legBckRtSpike.setRotationPoint(0.0F, -1.0F, 1.0F);
		this.legBckRtSpike.addBox(-1.0F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legBckRtSpike, 0.6283185307179586F, 0.0F, 0.0F);
		this.legBckRtSpike.setTextureOffset(68, 108).addBox(-1.0F, 0.0F, 2.6F, 2, 2, 2, 0.0F); // legBckRtSpikeMid
		this.legBckRtSpike.setTextureOffset(61, 115).addBox(-0.5F, 0.5F, 4.5F, 1, 1, 2, 0.0F); // legBckRtSpikeTip
		this.legBckRtSpikeInfo = new PartInfo(legBckRtSpike);

		this.legBckRtSpike = new ModelRenderer(this, 67, 112);
		this.legBckRtSpike.setRotationPoint(0.0F, -1.0F, 1.0F);
		this.legBckRtSpike.addBox(-1.0F, -0.5F, -0.4F, 2, 3, 3, 0.0F);
		this.setRotateAngle(legBckRtSpike, 1.5707963267948966F, 0.0F, 0.0F);
		this.legBckRtSpikeSitInfo = new PartInfo(legBckRtSpike);

		int legTuffNumber = 0;
		this.legFntLftTuff1[legTuffNumber] = new ModelRenderer(this, 87, 68); // legFntLftTuff1_1
		this.legFntLftTuff1[legTuffNumber].setRotationPoint(1.4F, 3.5F, 2.0F);
		this.legFntLftTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legFntLftTuff1[legTuffNumber], 0.6108652381980153F, 0.4363323129985824F, 0.0F);
		this.legFntLftTuff1Info[legTuffNumber] = new PartInfo(legFntLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff1[legTuffNumber] = new ModelRenderer(this, 87, 64); // legFntLftTuff1_2
		this.legFntLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legFntLftTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legFntLftTuff1Info[legTuffNumber] = new PartInfo(legFntLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff1[legTuffNumber] = new ModelRenderer(this, 89, 62); // legFntLftTuff1_3
		this.legFntLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legFntLftTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff1Info[legTuffNumber] = new PartInfo(legFntLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff1[legTuffNumber] = new ModelRenderer(this, 89, 60); // legFntLftTuff1_4
		this.legFntLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff1Info[legTuffNumber] = new PartInfo(legFntLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff1[legTuffNumber] = new ModelRenderer(this, 89, 58); // legFntLftTuff1_5
		this.legFntLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff1Info[legTuffNumber] = new PartInfo(legFntLftTuff1[legTuffNumber]);

		this.legFntLftTuff1[0].setRotationPoint(1.4F, 3.5F, 2.0F); // legFntLftTuff1_1
		this.setRotateAngle(legFntLftTuff1[0], 1.2217304763960306F, 0.4363323129985824F, 0.0F);
		this.legFntLftTuff1_1SitInfo = new PartInfo(legFntLftTuff1[0]);

		legTuffNumber = 0;
		this.legFntLftTuff2[legTuffNumber] = new ModelRenderer(this, 93, 66); // legFntLftTuff2_1
		this.legFntLftTuff2[legTuffNumber].setRotationPoint(1.6F, 4.4F, 2.0F);
		this.legFntLftTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legFntLftTuff2[legTuffNumber], 0.2617993877991494F, 0.6108652381980153F, 0.0F);
		this.legFntLftTuff2Info[legTuffNumber] = new PartInfo(legFntLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff2[legTuffNumber] = new ModelRenderer(this, 93, 62); // legFntLftTuff2_2
		this.legFntLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legFntLftTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legFntLftTuff2Info[legTuffNumber] = new PartInfo(legFntLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff2[legTuffNumber] = new ModelRenderer(this, 95, 60); // legFntLftTuff2_3
		this.legFntLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legFntLftTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff2Info[legTuffNumber] = new PartInfo(legFntLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff2[legTuffNumber] = new ModelRenderer(this, 95, 58); // legFntLftTuff2_4
		this.legFntLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff2Info[legTuffNumber] = new PartInfo(legFntLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff2[legTuffNumber] = new ModelRenderer(this, 95, 56); // legFntLftTuff2_5
		this.legFntLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff2Info[legTuffNumber] = new PartInfo(legFntLftTuff2[legTuffNumber]);

		this.legFntLftTuff2[0].setRotationPoint(1.6F, 4.4F, 2.0F); // legFntLftTuff2_1
		this.setRotateAngle(legFntLftTuff2[0], 1.1344640137963142F, 0.6108652381980153F, 0.0F);
		this.legFntLftTuff2_1SitInfo = new PartInfo(legFntLftTuff2[0]);

		legTuffNumber = 0;
		this.legFntLftTuff3[legTuffNumber] = new ModelRenderer(this, 101, 67); // legFntLftTuff3_1
		this.legFntLftTuff3[legTuffNumber].setRotationPoint(1.2F, 5.5F, 2.0F);
		this.legFntLftTuff3[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legFntLftTuff3[legTuffNumber], -0.17453292519943295F, 0.4363323129985824F, 0.0F);
		this.legFntLftTuff3Info[legTuffNumber] = new PartInfo(legFntLftTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff3[legTuffNumber] = new ModelRenderer(this, 103, 65); // legFntLftTuff3_2
		this.legFntLftTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legFntLftTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff3Info[legTuffNumber] = new PartInfo(legFntLftTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff3[legTuffNumber] = new ModelRenderer(this, 103, 63); // legFntLftTuff3_3
		this.legFntLftTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff3Info[legTuffNumber] = new PartInfo(legFntLftTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff3[legTuffNumber] = new ModelRenderer(this, 103, 61); // legFntLftTuff3_4
		this.legFntLftTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff3Info[legTuffNumber] = new PartInfo(legFntLftTuff3[legTuffNumber]);

		this.legFntLftTuff3[0].setRotationPoint(1.2F, 5.5F, 2.0F); // legFntLftTuff3_1
		this.setRotateAngle(legFntLftTuff3[0], 1.0471975511965976F, 0.4363323129985824F, 0.0F);
		this.legFntLftTuff3_1SitInfo = new PartInfo(legFntLftTuff3[0]);

		legTuffNumber = 0;
		this.legFntLftTuff4[legTuffNumber] = new ModelRenderer(this, 99, 62); // legFntLftTuff4_1
		this.legFntLftTuff4[legTuffNumber].setRotationPoint(1.7F, 6.6F, 2.4F);
		this.legFntLftTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(legFntLftTuff4[legTuffNumber], -0.4363323129985824F, 0.4363323129985824F, 0.0F);
		this.legFntLftTuff4Info[legTuffNumber] = new PartInfo(legFntLftTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff4[legTuffNumber] = new ModelRenderer(this, 99, 60); // legFntLftTuff4_2
		this.legFntLftTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff4Info[legTuffNumber] = new PartInfo(legFntLftTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legFntLftTuff4[legTuffNumber] = new ModelRenderer(this, 99, 58); // legFntLftTuff4_3
		this.legFntLftTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntLftTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntLftTuff4Info[legTuffNumber] = new PartInfo(legFntLftTuff4[legTuffNumber]);

		this.legFntLftTuff4[0].setRotationPoint(1.7F, 6.6F, 2.4F); // legFntLftTuff4_1
		this.setRotateAngle(legFntLftTuff4[0], 1.0471975511965976F, 0.4363323129985824F, 0.0F);
		this.legFntLftTuff4_1SitInfo = new PartInfo(legFntLftTuff4[0]);

		legTuffNumber = 0;
		this.legFntRtTuff1[legTuffNumber] = new ModelRenderer(this, 79, 68); // legFntRtTuff1_1
		this.legFntRtTuff1[legTuffNumber].setRotationPoint(-1.4F, 3.5F, 2.0F);
		this.legFntRtTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legFntRtTuff1[legTuffNumber], 0.6108652381980153F, -0.4363323129985824F, 0.0F);
		this.legFntRtTuff1Info[legTuffNumber] = new PartInfo(legFntRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff1[legTuffNumber] = new ModelRenderer(this, 79, 64); // legFntRtTuff1_2
		this.legFntRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legFntRtTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legFntRtTuff1Info[legTuffNumber] = new PartInfo(legFntRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff1[legTuffNumber] = new ModelRenderer(this, 81, 62); // legFntRtTuff1_3
		this.legFntRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legFntRtTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff1Info[legTuffNumber] = new PartInfo(legFntRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff1[legTuffNumber] = new ModelRenderer(this, 81, 60); // legFntRtTuff1_4
		this.legFntRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff1Info[legTuffNumber] = new PartInfo(legFntRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff1[legTuffNumber] = new ModelRenderer(this, 81, 58); // legFntRtTuff1_5
		this.legFntRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff1Info[legTuffNumber] = new PartInfo(legFntRtTuff1[legTuffNumber]);

		this.legFntRtTuff1[0].setRotationPoint(-1.4F, 3.5F, 2.0F); // legFntRtTuff1_1
		this.setRotateAngle(legFntRtTuff1[0], 1.2217304763960306F, -0.4363323129985824F, 0.0F);
		this.legFntRtTuff1_1SitInfo = new PartInfo(legFntRtTuff1[0]);

		legTuffNumber = 0;
		this.legFntRtTuff2[legTuffNumber] = new ModelRenderer(this, 73, 66); // legFntRtTuff2_1
		this.legFntRtTuff2[legTuffNumber].setRotationPoint(-1.6F, 4.4F, 2.0F);
		this.legFntRtTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legFntRtTuff2[legTuffNumber], 0.2617993877991494F, -0.6108652381980153F, 0.0F);
		this.legFntRtTuff2Info[legTuffNumber] = new PartInfo(legFntRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff2[legTuffNumber] = new ModelRenderer(this, 73, 62); // legFntRtTuff2_2
		this.legFntRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legFntRtTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legFntRtTuff2Info[legTuffNumber] = new PartInfo(legFntRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff2[legTuffNumber] = new ModelRenderer(this, 75, 60); // legFntRtTuff2_3
		this.legFntRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legFntRtTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff2Info[legTuffNumber] = new PartInfo(legFntRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff2[legTuffNumber] = new ModelRenderer(this, 75, 58); // legFntRtTuff2_4
		this.legFntRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff2Info[legTuffNumber] = new PartInfo(legFntRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff2[legTuffNumber] = new ModelRenderer(this, 75, 56); // legFntRtTuff2_5
		this.legFntRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff2Info[legTuffNumber] = new PartInfo(legFntRtTuff2[legTuffNumber]);

		this.legFntRtTuff2[0].setRotationPoint(-1.6F, 4.4F, 2.0F); // legFntRtTuff2_1
		this.setRotateAngle(legFntRtTuff2[0], 1.1344640137963142F, -0.6108652381980153F, 0.0F);
		this.legFntRtTuff2_1SitInfo = new PartInfo(legFntRtTuff2[0]);

		legTuffNumber = 0;
		this.legFntRtTuff3[legTuffNumber] = new ModelRenderer(this, 65, 67); // legFntRtTuff3_1
		this.legFntRtTuff3[legTuffNumber].setRotationPoint(-1.2F, 5.5F, 2.0F);
		this.legFntRtTuff3[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legFntRtTuff3[legTuffNumber], -0.17453292519943295F, -0.4363323129985824F, 0.0F);
		this.legFntRtTuff3Info[legTuffNumber] = new PartInfo(legFntRtTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff3[legTuffNumber] = new ModelRenderer(this, 67, 65); // legFntRtTuff3_2
		this.legFntRtTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legFntRtTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff3Info[legTuffNumber] = new PartInfo(legFntRtTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff3[legTuffNumber] = new ModelRenderer(this, 67, 63); // legFntRtTuff3_3
		this.legFntRtTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff3Info[legTuffNumber] = new PartInfo(legFntRtTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff3[legTuffNumber] = new ModelRenderer(this, 67, 61); // legFntRtTuff3_4
		this.legFntRtTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff3Info[legTuffNumber] = new PartInfo(legFntRtTuff3[legTuffNumber]);

		this.legFntRtTuff3[0].setRotationPoint(-1.2F, 5.5F, 2.0F); // legFntRtTuff3_1
		this.setRotateAngle(legFntRtTuff3[0], 1.0471975511965976F, -0.4363323129985824F, 0.0F);
		this.legFntRtTuff3_1SitInfo = new PartInfo(legFntRtTuff3[0]);

		legTuffNumber = 0;
		this.legFntRtTuff4[legTuffNumber] = new ModelRenderer(this, 71, 62); // legFntRtTuff4_1
		this.legFntRtTuff4[legTuffNumber].setRotationPoint(-1.7F, 6.6F, 2.4F);
		this.legFntRtTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(legFntRtTuff4[legTuffNumber], -0.4363323129985824F, -0.4363323129985824F, 0.0F);
		this.legFntRtTuff4Info[legTuffNumber] = new PartInfo(legFntRtTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff4[legTuffNumber] = new ModelRenderer(this, 71, 60); // legFntRtTuff4_2
		this.legFntRtTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff4Info[legTuffNumber] = new PartInfo(legFntRtTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legFntRtTuff4[legTuffNumber] = new ModelRenderer(this, 71, 58); // legFntRtTuff4_3
		this.legFntRtTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legFntRtTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legFntRtTuff4Info[legTuffNumber] = new PartInfo(legFntRtTuff4[legTuffNumber]);

		this.legFntRtTuff4[0].setRotationPoint(-1.7F, 6.6F, 2.4F); // legFntRtTuff4_1
		this.setRotateAngle(legFntRtTuff4[0], 1.0471975511965976F, -0.4363323129985824F, 0.0F);
		this.legFntRtTuff4_1SitInfo = new PartInfo(legFntRtTuff4[0]);

		legTuffNumber = 0;
		this.legBckLftTuff1[legTuffNumber] = new ModelRenderer(this, 87, 83); // legBckLftTuff1_1
		this.legBckLftTuff1[legTuffNumber].setRotationPoint(1.4F, 1.0F, 2.0F);
		this.legBckLftTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legBckLftTuff1[legTuffNumber], 0.6108652381980153F, 0.4363323129985824F, 0.0F);
		this.legBckLftTuff1Info[legTuffNumber] = new PartInfo(legBckLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff1[legTuffNumber] = new ModelRenderer(this, 87, 79); // legBckLftTuff1_2
		this.legBckLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legBckLftTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legBckLftTuff1Info[legTuffNumber] = new PartInfo(legBckLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff1[legTuffNumber] = new ModelRenderer(this, 89, 77); // legBckLftTuff1_3
		this.legBckLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legBckLftTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff1Info[legTuffNumber] = new PartInfo(legBckLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff1[legTuffNumber] = new ModelRenderer(this, 89, 75); // legBckLftTuff1_4
		this.legBckLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff1Info[legTuffNumber] = new PartInfo(legBckLftTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff1[legTuffNumber] = new ModelRenderer(this, 89, 73); // legBckLftTuff1_5
		this.legBckLftTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff1Info[legTuffNumber] = new PartInfo(legBckLftTuff1[legTuffNumber]);

		this.legBckLftTuff1[0].setRotationPoint(1.4F, 1.0F, 2.0F); // legBckLftTuff1_1
		this.setRotateAngle(legBckLftTuff1[0], 0.0F, 1.48352986419518F, -0.9599310885968813F);
		this.legBckLftTuff1_1SitInfo = new PartInfo(legBckLftTuff1[0]);

		legTuffNumber = 0;
		this.legBckLftTuff2[legTuffNumber] = new ModelRenderer(this, 94, 81); // legBckLftTuff2_1
		this.legBckLftTuff2[legTuffNumber].setRotationPoint(1.6F, 2.0F, 2.0F);
		this.legBckLftTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legBckLftTuff2[legTuffNumber], 0.2617993877991494F, 0.6108652381980153F, 0.0F);
		this.legBckLftTuff2Info[legTuffNumber] = new PartInfo(legBckLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff2[legTuffNumber] = new ModelRenderer(this, 94, 77); // legBckLftTuff2_2
		this.legBckLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legBckLftTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legBckLftTuff2Info[legTuffNumber] = new PartInfo(legBckLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff2[legTuffNumber] = new ModelRenderer(this, 96, 75); // legBckLftTuff2_3
		this.legBckLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legBckLftTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff2Info[legTuffNumber] = new PartInfo(legBckLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff2[legTuffNumber] = new ModelRenderer(this, 96, 73); // legBckLftTuff2_4
		this.legBckLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff2Info[legTuffNumber] = new PartInfo(legBckLftTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff2[legTuffNumber] = new ModelRenderer(this, 96, 71); // legBckLftTuff2_5
		this.legBckLftTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff2Info[legTuffNumber] = new PartInfo(legBckLftTuff2[legTuffNumber]);

		this.legBckLftTuff2[0].setRotationPoint(1.6F, 2.0F, 2.0F); // legBckLftTuff2_1
		this.setRotateAngle(legBckLftTuff2[0], 0.0F, 1.48352986419518F, -0.5235987755982988F);
		this.legBckLftTuff2_1SitInfo = new PartInfo(legBckLftTuff2[0]);

		legTuffNumber = 0;
		this.legBckLftTuff3[legTuffNumber] = new ModelRenderer(this, 100, 84); // legBckLftTuff3_1
		this.legBckLftTuff3[legTuffNumber].setRotationPoint(1.2F, 3.1F, 2.0F);
		this.legBckLftTuff3[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legBckLftTuff3[legTuffNumber], -0.17453292519943295F, 0.4363323129985824F, 0.0F);
		this.legBckLftTuff3Info[legTuffNumber] = new PartInfo(legBckLftTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff3[legTuffNumber] = new ModelRenderer(this, 103, 82); // legBckLftTuff3_2
		this.legBckLftTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legBckLftTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff3Info[legTuffNumber] = new PartInfo(legBckLftTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff3[legTuffNumber] = new ModelRenderer(this, 103, 80); // legBckLftTuff3_3
		this.legBckLftTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff3Info[legTuffNumber] = new PartInfo(legBckLftTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff3[legTuffNumber] = new ModelRenderer(this, 103, 78); // legBckLftTuff3_4
		this.legBckLftTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff3Info[legTuffNumber] = new PartInfo(legBckLftTuff3[legTuffNumber]);

		this.legBckLftTuff3[0].setRotationPoint(1.2F, 3.1F, 2.0F); // legBckLftTuff3_1
		this.setRotateAngle(legBckLftTuff3[0], 0.0F, 1.48352986419518F, 0.0F);
		this.legBckLftTuff3_1SitInfo = new PartInfo(legBckLftTuff3[0]);

		legTuffNumber = 0;
		this.legBckLftTuff4[legTuffNumber] = new ModelRenderer(this, 102, 75); // legBckLftTuff4_1
		this.legBckLftTuff4[legTuffNumber].setRotationPoint(1.7F, 4.2F, 2.4F);
		this.legBckLftTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(legBckLftTuff4[legTuffNumber], -0.4363323129985824F, 0.4363323129985824F, 0.0F);
		this.legBckLftTuff4Info[legTuffNumber] = new PartInfo(legBckLftTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff4[legTuffNumber] = new ModelRenderer(this, 102, 73); // legBckLftTuff4_2
		this.legBckLftTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff4Info[legTuffNumber] = new PartInfo(legBckLftTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legBckLftTuff4[legTuffNumber] = new ModelRenderer(this, 102, 71); // legBckLftTuff4_3
		this.legBckLftTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckLftTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckLftTuff4Info[legTuffNumber] = new PartInfo(legBckLftTuff4[legTuffNumber]);

		this.legBckLftTuff4[0].setRotationPoint(1.7F, 4.2F, 2.4F); // legBckLftTuff4_1
		this.setRotateAngle(legBckLftTuff4[0], 0.0F, 1.48352986419518F, 0.3490658503988659F);
		this.legBckLftTuff4_1SitInfo = new PartInfo(legBckLftTuff4[0]);

		legTuffNumber = 0;
		this.legBckRtTuff1[legTuffNumber] = new ModelRenderer(this, 79, 83); // legBckRtTuff1_1
		this.legBckRtTuff1[legTuffNumber].setRotationPoint(-1.4F, 1.0F, 2.0F);
		this.legBckRtTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legBckRtTuff1[legTuffNumber], 0.6108652381980153F, -0.4363323129985824F, 0.0F);
		this.legBckRtTuff1Info[legTuffNumber] = new PartInfo(legBckRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff1[legTuffNumber] = new ModelRenderer(this, 79, 79); // legBckRtTuff1_2
		this.legBckRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legBckRtTuff1[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legBckRtTuff1Info[legTuffNumber] = new PartInfo(legBckRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff1[legTuffNumber] = new ModelRenderer(this, 81, 77); // legBckRtTuff1_3
		this.legBckRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legBckRtTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff1Info[legTuffNumber] = new PartInfo(legBckRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff1[legTuffNumber] = new ModelRenderer(this, 81, 75); // legBckRtTuff1_4
		this.legBckRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff1Info[legTuffNumber] = new PartInfo(legBckRtTuff1[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff1[legTuffNumber] = new ModelRenderer(this, 81, 73); // legBckRtTuff1_5
		this.legBckRtTuff1[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff1[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff1Info[legTuffNumber] = new PartInfo(legBckRtTuff1[legTuffNumber]);

		this.legBckRtTuff1[0].setRotationPoint(-1.4F, 1.0F, 2.0F); // legBckRtTuff1_1
		this.setRotateAngle(legBckRtTuff1[0], 0.0F, -1.48352986419518F, 0.9599310885968813F);
		this.legBckRtTuff1_1SitInfo = new PartInfo(legBckRtTuff1[0]);

		legTuffNumber = 0;
		this.legBckRtTuff2[legTuffNumber] = new ModelRenderer(this, 72, 81); // legBckRtTuff2_1
		this.legBckRtTuff2[legTuffNumber].setRotationPoint(-1.6F, 2.0F, 2.0F);
		this.legBckRtTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legBckRtTuff2[legTuffNumber], 0.2617993877991494F, -0.6108652381980153F, 0.0F);
		this.legBckRtTuff2Info[legTuffNumber] = new PartInfo(legBckRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff2[legTuffNumber] = new ModelRenderer(this, 72, 77); // legBckRtTuff2_2
		this.legBckRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.legBckRtTuff2[legTuffNumber].addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
		this.legBckRtTuff2Info[legTuffNumber] = new PartInfo(legBckRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff2[legTuffNumber] = new ModelRenderer(this, 74, 75); // legBckRtTuff2_3
		this.legBckRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legBckRtTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff2Info[legTuffNumber] = new PartInfo(legBckRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff2[legTuffNumber] = new ModelRenderer(this, 74, 73); // legBckRtTuff2_4
		this.legBckRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff2Info[legTuffNumber] = new PartInfo(legBckRtTuff2[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff2[legTuffNumber] = new ModelRenderer(this, 74, 71); // legBckRtTuff2_5
		this.legBckRtTuff2[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff2[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff2Info[legTuffNumber] = new PartInfo(legBckRtTuff2[legTuffNumber]);

		this.legBckRtTuff2[0].setRotationPoint(-1.6F, 2.0F, 2.0F); // legBckRtTuff2_1
		this.setRotateAngle(legBckRtTuff2[0], 0.0F, -1.48352986419518F, 0.5235987755982988F);
		this.legBckRtTuff2_1SitInfo = new PartInfo(legBckRtTuff2[0]);

		legTuffNumber = 0;
		this.legBckRtTuff3[legTuffNumber] = new ModelRenderer(this, 66, 84); // legBckRtTuff3_1
		this.legBckRtTuff3[legTuffNumber].setRotationPoint(-1.2F, 3.1F, 2.0F);
		this.legBckRtTuff3[legTuffNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(legBckRtTuff3[legTuffNumber], -0.17453292519943295F, -0.4363323129985824F, 0.0F);
		this.legBckRtTuff3Info[legTuffNumber] = new PartInfo(legBckRtTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff3[legTuffNumber] = new ModelRenderer(this, 67, 82); // legBckRtTuff3_2
		this.legBckRtTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.legBckRtTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff3Info[legTuffNumber] = new PartInfo(legBckRtTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff3[legTuffNumber] = new ModelRenderer(this, 67, 80); // legBckRtTuff3_3
		this.legBckRtTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff3Info[legTuffNumber] = new PartInfo(legBckRtTuff3[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff3[legTuffNumber] = new ModelRenderer(this, 67, 78); // legBckRtTuff3_4
		this.legBckRtTuff3[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff3[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff3Info[legTuffNumber] = new PartInfo(legBckRtTuff3[legTuffNumber]);

		this.legBckRtTuff3[0].setRotationPoint(-1.2F, 3.1F, 2.0F); // legBckRtTuff3_1
		this.setRotateAngle(legBckRtTuff3[0], 0.0F, -1.48352986419518F, 0.0F);
		this.legBckRtTuff3_1SitInfo = new PartInfo(legBckRtTuff3[0]);

		legTuffNumber = 0;
		this.legBckRtTuff4[legTuffNumber] = new ModelRenderer(this, 68, 75); // legBckRtTuff4_1
		this.legBckRtTuff4[legTuffNumber].setRotationPoint(-1.7F, 4.2F, 2.4F);
		this.legBckRtTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(legBckRtTuff4[legTuffNumber], -0.4363323129985824F, -0.4363323129985824F, 0.0F);
		this.legBckRtTuff4Info[legTuffNumber] = new PartInfo(legBckRtTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff4[legTuffNumber] = new ModelRenderer(this, 68, 73); // legBckRtTuff4_2
		this.legBckRtTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff4Info[legTuffNumber] = new PartInfo(legBckRtTuff4[legTuffNumber]);
		legTuffNumber++;
		this.legBckRtTuff4[legTuffNumber] = new ModelRenderer(this, 68, 71); // legBckRtTuff4_3
		this.legBckRtTuff4[legTuffNumber].setRotationPoint(0.0F, 0.0F, 0.7F);
		this.legBckRtTuff4[legTuffNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 1, 0.0F);
		this.legBckRtTuff4Info[legTuffNumber] = new PartInfo(legBckRtTuff4[legTuffNumber]);

		this.legBckRtTuff4[0].setRotationPoint(-1.7F, 4.2F, 2.4F); // legBckRtTuff4_1
		this.setRotateAngle(legBckRtTuff4[0], 0.0F, -1.48352986419518F, -0.3490658503988659F);
		this.legBckRtTuff4_1SitInfo = new PartInfo(legBckRtTuff4[0]);

		this.neckJoint = new ModelRenderer(this, 0, 0);
		this.neckJoint.setRotationPoint(0.0F, -3.4F, -9.0F);
		this.neckJoint.addBox(-1.5F, -1.5F, -5.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, -0.7853981633974483F, 0.0F, 0.0F);
		this.neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 67, 7);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-5.5F, -5.0F, -7.5F, 11, 10, 9, 0.0F);
		this.neckInfo = new PartInfo(neck);
		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, 0.0F, -9.0F);
		this.headJoint.addBox(-2.5F, -2.5F, -2.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, 0.7853981633974483F, 0.0F, 0.0F);
		this.headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 4, 39);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-5.0F, -5.5F, -5.0F, 10, 10, 10, 0.0F);
		this.headInfo = new PartInfo(head);

		this.muzzle = new ModelRenderer(this, 17, 60);
		this.muzzle.setRotationPoint(0.0F, 2.0F, -5.5F);
		this.muzzle.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 3, 0.0F);
		this.setRotateAngle(muzzle, 0.17453292519943295F, 0.0F, 0.0F);
		this.muzzle.setTextureOffset(21, 67).addBox(-1.0F, -1.9F, -2.7F, 2, 2, 1, 0.0F); // nose

		this.headHair = new ModelRenderer(this, 1, 25);
		this.headHair.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.headHair.addBox(-5.51F, -2.5F, -5.5F, 11, 3, 11, 0.0F);
		this.headHairMid = new ModelRenderer(this, 1, 11);
		this.headHairMid.setRotationPoint(0.0F, -7.7F, 0.0F);
		this.headHairMid.addBox(-5.5F, 0.0F, -5.7F, 11, 3, 11, 0.0F);
		this.setRotateAngle(headHairMid, 0.08726646259971647F, 0.0F, 0.0F);
		this.headHairTop = new ModelRenderer(this, 9, 2);
		this.headHairTop.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.headHairTop.addBox(-3.5F, -6.0F, -3.6F, 7, 2, 7, 0.0F);
		this.setRotateAngle(headHairTop, 0.08726646259971647F, 0.0F, 0.0F);

		this.headGem = new ModelRenderer(this, 0, 2);
		this.headGem.setRotationPoint(0.0F, -5.6F, -5.6F);
		this.headGem.addBox(-2.0F, -1.0F, -0.7F, 4, 2, 1, 0.0F);
		this.headGemTop = new ModelRenderer(this, 1, 0);
		this.headGemTop.setRotationPoint(0.0F, -5.6F, -5.6F);
		this.headGemTop.addBox(-1.5F, -1.5F, -0.6F, 3, 1, 1, 0.0F);
		this.headGemBot = new ModelRenderer(this, 2, 5);
		this.headGemBot.setRotationPoint(0.0F, -5.6F, -5.6F);
		this.headGemBot.addBox(-1.0F, 0.5F, -0.6F, 2, 1, 1, 0.0F);
		this.headGemBotTip = new ModelRenderer(this, 3, 7);
		this.headGemBotTip.setRotationPoint(0.0F, -5.6F, -5.6F);
		this.headGemBotTip.addBox(-0.5F, 0.9F, -0.4F, 1, 1, 1, 0.0F);

		int headBangNumber = 0;
		this.headBang[headBangNumber] = new ModelRenderer(this, 110, 0); // headBang1
		this.headBang[headBangNumber].setRotationPoint(3.7F, -4.6F, -4.9F);
		this.headBang[headBangNumber].addBox(-4.0F, -1.6F, -1.0F, 7, 5, 2, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], -0.2792526803190927F, 0.0F, -0.3490658503988659F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);
		headBangNumber++;
		this.headBang[headBangNumber] = new ModelRenderer(this, 111, 7); // headBang2
		this.headBang[headBangNumber].setRotationPoint(-0.4F, 3.2F, 0.2F);
		this.headBang[headBangNumber].addBox(-3.0F, -0.6F, -1.0F, 6, 3, 2, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], 0.2617993877991494F, 0.0F, 0.08726646259971647F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);
		headBangNumber++;
		this.headBang[headBangNumber] = new ModelRenderer(this, 111, 12); // headBang3
		this.headBang[headBangNumber].setRotationPoint(-0.7F, 2.0F, 0.4F);
		this.headBang[headBangNumber].addBox(-2.5F, -0.6F, -1.0F, 6, 3, 2, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], 0.0F, 0.08726646259971647F, 0.17453292519943295F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);
		headBangNumber++;
		this.headBang[headBangNumber] = new ModelRenderer(this, 112, 17); // headBang4
		this.headBang[headBangNumber].setRotationPoint(-0.2F, 1.6F, -0.2F);
		this.headBang[headBangNumber].addBox(-2.0F, -0.4F, -0.5F, 5, 3, 2, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], 0.08726646259971647F, 0.0F, 0.17453292519943295F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);
		headBangNumber++;
		this.headBang[headBangNumber] = new ModelRenderer(this, 113, 22); // headBang5
		this.headBang[headBangNumber].setRotationPoint(0.0F, 2.4F, 0.2F);
		this.headBang[headBangNumber].addBox(-1.7F, -0.4F, -0.5F, 4, 3, 2, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], -0.08726646259971647F, 0.0F, 0.08726646259971647F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);
		headBangNumber++;
		this.headBang[headBangNumber] = new ModelRenderer(this, 115, 27); // headBang6
		this.headBang[headBangNumber].setRotationPoint(0.3F, 2.6F, 0.5F);
		this.headBang[headBangNumber].addBox(-1.5F, -0.4F, -0.5F, 3, 2, 1, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], 0.0F, 0.0F, -0.08726646259971647F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);
		headBangNumber++;
		this.headBang[headBangNumber] = new ModelRenderer(this, 116, 30); // headBang7
		this.headBang[headBangNumber].setRotationPoint(0.0F, 1.7F, 0.0F);
		this.headBang[headBangNumber].addBox(-1.0F, -0.4F, -0.5F, 2, 2, 1, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], 0.0F, 0.0F, -0.08726646259971647F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);
		headBangNumber++;
		this.headBang[headBangNumber] = new ModelRenderer(this, 117, 33); // headBang8
		this.headBang[headBangNumber].setRotationPoint(0.0F, 1.7F, 0.0F);
		this.headBang[headBangNumber].addBox(-0.5F, -0.4F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(headBang[headBangNumber], 0.0F, 0.0F, -0.08726646259971647F);
		this.headBangInfo[headBangNumber] = new PartInfo(headBang[headBangNumber]);

		this.headHornBase = new ModelRenderer(this, 42, 88);
		this.headHornBase.setRotationPoint(-5.0F, -0.7F, 0.0F);
		this.headHornBase.addBox(-2.5F, -1.5F, -0.5F, 3, 3, 1, 0.0F);
		this.headHorn1 = new ModelRenderer(this, 28, 81);
		this.headHorn1.setRotationPoint(-2.5F, 0.0F, 0.0F);
		this.headHorn1.addBox(-6.0F, -5.5F, -0.51F, 6, 8, 1, 0.0F);
		this.headHorn2 = new ModelRenderer(this, 28, 75);
		this.headHorn2.setRotationPoint(-2.7F, -5.5F, 0.0F);
		this.headHorn2.addBox(-3.0F, -3.3F, -0.5F, 6, 5, 1, 0.0F);
		this.setRotateAngle(headHorn2, 0.0F, 0.0F, 0.4363323129985824F);
		this.headHorn3 = new ModelRenderer(this, 29, 69);
		this.headHorn3.setRotationPoint(-0.2F, -3.3F, 0.0F);
		this.headHorn3.addBox(-2.5F, -4.4F, -0.51F, 5, 5, 1, 0.0F);
		this.setRotateAngle(headHorn3, 0.0F, 0.0F, -0.17453292519943295F);
		this.headHorn4 = new ModelRenderer(this, 31, 65);
		this.headHorn4.setRotationPoint(0.1F, -4.5F, 0.0F);
		this.headHorn4.addBox(-1.5F, -2.6F, -0.5F, 3, 3, 1, 0.0F);
		this.setRotateAngle(headHorn4, 0.0F, 0.0F, -0.17453292519943295F);
		this.headHorn5 = new ModelRenderer(this, 32, 62);
		this.headHorn5.setRotationPoint(0.1F, -2.7F, 0.0F);
		this.headHorn5.addBox(-1.0F, -1.7F, -0.51F, 2, 2, 1, 0.0F);
		this.setRotateAngle(headHorn5, 0.0F, 0.0F, -0.17453292519943295F);
		this.headHorn6 = new ModelRenderer(this, 33, 59);
		this.headHorn6.setRotationPoint(0.1F, -1.8F, 0.0F);
		this.headHorn6.addBox(-0.5F, -1.7F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(headHorn6, 0.0F, 0.0F, -0.17453292519943295F);

		this.headHornBot = new ModelRenderer(this, 30, 90);
		this.headHornBot.setRotationPoint(-3.0F, 2.4F, 0.0F);
		this.headHornBot.addBox(-2.0F, -0.7F, -0.5F, 4, 2, 1, 0.0F);
		this.setRotateAngle(headHornBot, 0.0F, 0.0F, -0.2617993877991494F);
		this.headHornBotTip = new ModelRenderer(this, 32, 93);
		this.headHornBotTip.setRotationPoint(0.0F, 1.3F, 0.0F);
		this.headHornBotTip.addBox(-1.0F, -0.5F, -0.51F, 2, 2, 1, 0.0F);
		this.setRotateAngle(headHornBotTip, 0.0F, 0.0F, -0.2617993877991494F);

		this.headHornEdge1 = new ModelRenderer(this, 26, 116);
		this.headHornEdge1.setRotationPoint(-3.0F, 0.0F, 0.0F);
		this.headHornEdge1.addBox(-4.9F, -5.5F, 0.0F, 9, 11, 1, 0.0F);
		this.setRotateAngle(headHornEdge1, 0.0F, 0.0F, 0.06981317007977318F);
		this.headHornEdge2 = new ModelRenderer(this, 27, 106);
		this.headHornEdge2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headHornEdge2.addBox(-4.0F, -7.9F, 0.01F, 8, 9, 1, 0.0F);
		this.setRotateAngle(headHornEdge2, 0.0F, 0.0F, -0.15707963267948966F);
		this.headHornEdge3 = new ModelRenderer(this, 29, 96);
		this.headHornEdge3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headHornEdge3.addBox(-3.0F, -7.9F, 0.0F, 6, 9, 1, 0.0F);
		this.setRotateAngle(headHornEdge3, 0.0F, 0.0F, -0.17453292519943295F);

		this.headHornSmall = new ModelRenderer(this, 21, 74);
		this.headHornSmall.setRotationPoint(5.0F, -6.0F, 0.0F);
		this.headHornSmall.addBox(-0.5F, -2.5F, 0.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(headHornSmall, 0.0F, 0.0F, -0.2617993877991494F);
		this.headHornSmallTip = new ModelRenderer(this, 22, 71);
		this.headHornSmallTip.setRotationPoint(0.6F, -2.5F, 0.0F);
		this.headHornSmallTip.addBox(-0.5F, -1.8F, 0.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(headHornSmallTip, 0.0F, 0.0F, 0.2617993877991494F);
		this.headHornSmallBlade = new ModelRenderer(this, 12, 71);
		this.headHornSmallBlade.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headHornSmallBlade.addBox(-1.0F, -5.8F, 0.5F, 3, 7, 1, 0.0F);

		this.tail1 = new ModelRenderer(this, 0, 117);
		this.tail1.setRotationPoint(0.0F, -4.0F, 10.5F);
		this.tail1.addBox(-0.5F, -1.5F, -1.0F, 1, 3, 8, 0.0F);
		this.setRotateAngle(tail1, 0.47123889803846897F, 0.0F, 0.0F);
		this.tail2 = new ModelRenderer(this, 0, 107);
		this.tail2.setRotationPoint(0.0F, 0.0F, 6.5F);
		this.tail2.addBox(-0.51F, -1.5F, -0.3F, 1, 3, 7, 0.0F);
		this.setRotateAngle(tail2, -0.2617993877991494F, 0.0F, 0.0F);
		this.tail3 = new ModelRenderer(this, 2, 100);
		this.tail3.setRotationPoint(0.0F, -0.5F, 6.5F);
		this.tail3.addBox(-0.5F, -1.0F, -0.3F, 1, 2, 5, 0.0F);
		this.setRotateAngle(tail3, -0.17453292519943295F, 0.0F, 0.0F);
		this.tailEdge1 = new ModelRenderer(this, 10, 114);
		this.tailEdge1.setRotationPoint(0.0F, 0.0F, -1.0F);
		this.tailEdge1.addBox(-1.0F, -2.6F, 1.0F, 1, 4, 7, 0.0F);
		this.setRotateAngle(tailEdge1, -0.45378560551852565F, 0.0F, 0.0F);
		this.tailEdge2 = new ModelRenderer(this, 11, 106);
		this.tailEdge2.setRotationPoint(0.0F, -3.0F, 8.0F);
		this.tailEdge2.addBox(-1.01F, 0.8F, -0.8F, 1, 3, 5, 0.0F);
		this.setRotateAngle(tailEdge2, 0.19198621771937624F, 0.0F, 0.0F);
		this.tailEdge3 = new ModelRenderer(this, 11, 97);
		this.tailEdge3.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.tailEdge3.addBox(-1.02F, -0.2F, -0.6F, 1, 3, 5, 0.0F);
		this.setRotateAngle(tailEdge3, -0.17453292519943295F, 0.0F, 0.0F);
		this.tailEdge4 = new ModelRenderer(this, 0, 89);
		this.tailEdge4.setRotationPoint(0.0F, -1.0F, 4.4F);
		this.tailEdge4.addBox(-1.02F, -1.0F, 0.0F, 1, 4, 7, 0.0F);

		this.backFluffLft = new ModelRenderer(this, 87, 46);
		this.backFluffLft.setRotationPoint(4.0F, -4.0F, -9.8F);
		this.backFluffLft.addBox(-3.0F, -6.5F, -1.0F, 6, 8, 2, 0.0F);
		this.setRotateAngle(backFluffLft, -0.3490658503988659F, 0.0F, 0.8726646259971648F);
		this.backFluffRt = new ModelRenderer(this, 71, 46);
		this.backFluffRt.setRotationPoint(-4.0F, -4.0F, -9.8F);
		this.backFluffRt.addBox(-3.0F, -6.5F, -1.0F, 6, 8, 2, 0.0F);
		this.setRotateAngle(backFluffRt, -0.3490658503988659F, 0.0F, -0.8726646259971648F);

		this.backFluffLft1 = new ModelRenderer(this, 87, 39);
		this.backFluffLft1.setRotationPoint(-2.0F, -6.2F, -0.2F);
		this.backFluffLft1.addBox(-2.0F, -4.5F, -1.0F, 4, 5, 2, 0.0F);
		this.setRotateAngle(backFluffLft1, 0.08726646259971647F, 0.0F, -0.33161255787892263F);

		this.backFluffLft1Top = new ModelRenderer(this, 87, 33);
		this.backFluffLft1Top.setRotationPoint(-1.5F, -1.6F, 0.0F);
		this.backFluffLft1Top.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.setRotateAngle(backFluffLft1Top, 0.0F, 0.0F, -0.5235987755982988F);
		this.backFluffLft1Top1_1 = new ModelRenderer(this, 87, 30);
		this.backFluffLft1Top1_1.setRotationPoint(-0.3F, -3.4F, 0.0F);
		this.backFluffLft1Top1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft1Top1_2 = new ModelRenderer(this, 87, 27);
		this.backFluffLft1Top1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffLft1Top1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft1Top2 = new ModelRenderer(this, 91, 29);
		this.backFluffLft1Top2.setRotationPoint(0.3F, -3.3F, -0.3F);
		this.backFluffLft1Top2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffLft1Top2, 0.0F, 0.0F, 0.2617993877991494F);

		this.backFluffLft1Mid = new ModelRenderer(this, 95, 33);
		this.backFluffLft1Mid.setRotationPoint(-1.0F, -4.6F, 0.0F);
		this.backFluffLft1Mid.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.setRotateAngle(backFluffLft1Mid, 0.08726646259971647F, 0.0F, -0.2617993877991494F);
		this.backFluffLft1Mid1_1 = new ModelRenderer(this, 95, 30);
		this.backFluffLft1Mid1_1.setRotationPoint(-0.3F, -3.4F, 0.0F);
		this.backFluffLft1Mid1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft1Mid1_2 = new ModelRenderer(this, 95, 27);
		this.backFluffLft1Mid1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffLft1Mid1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft1Mid2 = new ModelRenderer(this, 99, 29);
		this.backFluffLft1Mid2.setRotationPoint(0.3F, -3.3F, -0.3F);
		this.backFluffLft1Mid2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffLft1Mid2, 0.0F, 0.0F, 0.2617993877991494F);

		this.backFluffLft1Bot = new ModelRenderer(this, 103, 34);
		this.backFluffLft1Bot.setRotationPoint(0.8F, -4.6F, 0.0F);
		this.backFluffLft1Bot.addBox(-1.0F, -2.5F, -1.01F, 2, 3, 2, 0.0F);
		this.backFluffLft1Bot1_1 = new ModelRenderer(this, 103, 31);
		this.backFluffLft1Bot1_1.setRotationPoint(-0.4F, -2.4F, 0.0F);
		this.backFluffLft1Bot1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft1Bot1_2 = new ModelRenderer(this, 103, 28);
		this.backFluffLft1Bot1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffLft1Bot1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft1Bot2 = new ModelRenderer(this, 107, 30);
		this.backFluffLft1Bot2.setRotationPoint(0.3F, -2.3F, -0.3F);
		this.backFluffLft1Bot2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffLft1Bot2, 0.0F, 0.0F, 0.2617993877991494F);

		this.backFluffLft2 = new ModelRenderer(this, 105, 51);
		this.backFluffLft2.setRotationPoint(0.0F, -6.2F, 0.0F);
		this.backFluffLft2.addBox(-2.0F, -3.5F, -1.01F, 4, 4, 2, 0.0F);
		this.backFluffLft2Mid = new ModelRenderer(this, 107, 45);
		this.backFluffLft2Mid.setRotationPoint(0.0F, -3.6F, 0.0F);
		this.backFluffLft2Mid.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.backFluffLft2Mid1_1 = new ModelRenderer(this, 107, 42);
		this.backFluffLft2Mid1_1.setRotationPoint(-0.3F, -3.4F, 0.0F);
		this.backFluffLft2Mid1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft2Mid1_2 = new ModelRenderer(this, 107, 39);
		this.backFluffLft2Mid1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffLft2Mid1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft2Mid2 = new ModelRenderer(this, 111, 41);
		this.backFluffLft2Mid2.setRotationPoint(0.3F, -3.3F, -0.3F);
		this.backFluffLft2Mid2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffLft2Mid2, 0.0F, 0.0F, 0.2617993877991494F);

		this.backFluffLft3 = new ModelRenderer(this, 117, 51);
		this.backFluffLft3.setRotationPoint(2.0F, -3.2F, 0.1F);
		this.backFluffLft3.addBox(-1.5F, -3.5F, -1.0F, 3, 4, 2, 0.0F);
		this.setRotateAngle(backFluffLft3, -0.08726646259971647F, 0.0F, 0.2617993877991494F);
		this.backFluffLft3Mid = new ModelRenderer(this, 118, 45);
		this.backFluffLft3Mid.setRotationPoint(0.0F, -3.6F, 0.0F);
		this.backFluffLft3Mid.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.backFluffLft3Mid1_1 = new ModelRenderer(this, 118, 42);
		this.backFluffLft3Mid1_1.setRotationPoint(-0.3F, -3.4F, 0.0F);
		this.backFluffLft3Mid1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft3Mid1_2 = new ModelRenderer(this, 118, 39);
		this.backFluffLft3Mid1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffLft3Mid1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffLft3Mid2 = new ModelRenderer(this, 122, 41);
		this.backFluffLft3Mid2.setRotationPoint(0.3F, -3.3F, -0.3F);
		this.backFluffLft3Mid2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffLft3Mid2, 0.0F, 0.0F, 0.2617993877991494F);

		this.backFluffRt1 = new ModelRenderer(this, 75, 39);
		this.backFluffRt1.setRotationPoint(2.0F, -6.2F, -0.2F);
		this.backFluffRt1.addBox(-2.0F, -4.5F, -1.0F, 4, 5, 2, 0.0F);
		this.setRotateAngle(backFluffRt1, 0.08726646259971647F, 0.0F, 0.33161255787892263F);

		this.backFluffRt1Top = new ModelRenderer(this, 79, 33);
		this.backFluffRt1Top.setRotationPoint(1.5F, -1.6F, 0.0F);
		this.backFluffRt1Top.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.setRotateAngle(backFluffRt1Top, 0.0F, 0.0F, 0.5235987755982988F);
		this.backFluffRt1Top1_1 = new ModelRenderer(this, 83, 30);
		this.backFluffRt1Top1_1.setRotationPoint(0.3F, -3.4F, 0.0F);
		this.backFluffRt1Top1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt1Top1_2 = new ModelRenderer(this, 83, 27);
		this.backFluffRt1Top1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffRt1Top1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt1Top2 = new ModelRenderer(this, 79, 29);
		this.backFluffRt1Top2.setRotationPoint(-0.3F, -3.3F, -0.3F);
		this.backFluffRt1Top2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffRt1Top2, 0.0F, 0.0F, -0.2617993877991494F);

		this.backFluffRt1Mid = new ModelRenderer(this, 71, 33);
		this.backFluffRt1Mid.setRotationPoint(1.0F, -4.6F, 0.0F);
		this.backFluffRt1Mid.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.setRotateAngle(backFluffRt1Mid, 0.08726646259971647F, 0.0F, 0.2617993877991494F);
		this.backFluffRt1Mid1_1 = new ModelRenderer(this, 75, 30);
		this.backFluffRt1Mid1_1.setRotationPoint(0.3F, -3.4F, 0.0F);
		this.backFluffRt1Mid1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt1Mid1_2 = new ModelRenderer(this, 75, 27);
		this.backFluffRt1Mid1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffRt1Mid1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt1Mid2 = new ModelRenderer(this, 71, 29);
		this.backFluffRt1Mid2.setRotationPoint(-0.3F, -3.3F, -0.3F);
		this.backFluffRt1Mid2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffRt1Mid2, 0.0F, 0.0F, -0.2617993877991494F);

		this.backFluffRt1Bot = new ModelRenderer(this, 63, 34);
		this.backFluffRt1Bot.setRotationPoint(-0.8F, -4.6F, 0.0F);
		this.backFluffRt1Bot.addBox(-1.0F, -2.5F, -1.01F, 2, 3, 2, 0.0F);
		this.backFluffRt1Bot1_1 = new ModelRenderer(this, 67, 31);
		this.backFluffRt1Bot1_1.setRotationPoint(0.4F, -2.4F, 0.0F);
		this.backFluffRt1Bot1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt1Bot1_2 = new ModelRenderer(this, 67, 28);
		this.backFluffRt1Bot1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffRt1Bot1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt1Bot2 = new ModelRenderer(this, 63, 30);
		this.backFluffRt1Bot2.setRotationPoint(-0.3F, -2.3F, -0.3F);
		this.backFluffRt1Bot2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffRt1Bot2, 0.0F, 0.0F, -0.2617993877991494F);

		this.backFluffRt2 = new ModelRenderer(this, 57, 51);
		this.backFluffRt2.setRotationPoint(0.0F, -6.2F, 0.0F);
		this.backFluffRt2.addBox(-2.0F, -3.5F, -1.01F, 4, 4, 2, 0.0F);
		this.backFluffRt2Mid = new ModelRenderer(this, 59, 45);
		this.backFluffRt2Mid.setRotationPoint(0.0F, -3.6F, 0.0F);
		this.backFluffRt2Mid.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.backFluffRt2Mid1_1 = new ModelRenderer(this, 63, 42);
		this.backFluffRt2Mid1_1.setRotationPoint(0.3F, -3.4F, 0.0F);
		this.backFluffRt2Mid1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt2Mid1_2 = new ModelRenderer(this, 63, 39);
		this.backFluffRt2Mid1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffRt2Mid1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt2Mid2 = new ModelRenderer(this, 59, 41);
		this.backFluffRt2Mid2.setRotationPoint(-0.3F, -3.3F, -0.3F);
		this.backFluffRt2Mid2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffRt2Mid2, 0.0F, 0.0F, -0.2617993877991494F);

		this.backFluffRt3 = new ModelRenderer(this, 47, 51);
		this.backFluffRt3.setRotationPoint(-2.0F, -3.2F, 0.1F);
		this.backFluffRt3.addBox(-1.5F, -3.5F, -1.0F, 3, 4, 2, 0.0F);
		this.setRotateAngle(backFluffRt3, -0.08726646259971647F, 0.0F, -0.2617993877991494F);
		this.backFluffRt3Mid = new ModelRenderer(this, 48, 45);
		this.backFluffRt3Mid.setRotationPoint(0.0F, -3.6F, 0.0F);
		this.backFluffRt3Mid.addBox(-1.0F, -3.5F, -1.01F, 2, 4, 2, 0.0F);
		this.backFluffRt3Mid1_1 = new ModelRenderer(this, 52, 42);
		this.backFluffRt3Mid1_1.setRotationPoint(0.3F, -3.4F, 0.0F);
		this.backFluffRt3Mid1_1.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt3Mid1_2 = new ModelRenderer(this, 52, 39);
		this.backFluffRt3Mid1_2.setRotationPoint(0.0F, -1.7F, 0.0F);
		this.backFluffRt3Mid1_2.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		this.backFluffRt3Mid2 = new ModelRenderer(this, 48, 41);
		this.backFluffRt3Mid2.setRotationPoint(-0.3F, -3.3F, -0.3F);
		this.backFluffRt3Mid2.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(backFluffRt3Mid2, 0.0F, 0.0F, -0.2617993877991494F);


//
//		this.legFntLft1Joint.addChild(this.legFntLft1);
//		this.head.addChild(this.headGemTop);
//		this.head.addChild(this.nose);
//		this.bodyJoint.addChild(this.body);
//		this.legBckRt3.addChild(this.legBckRtSpikeMid);
//		this.legFntLftTuff3_2.addChild(this.legFntLftTuff3_3);
//		this.legBckLftTuff3_2.addChild(this.legBckLftTuff3_3);
//		this.headHornBase.addChild(this.headHorn1);
//		this.legFntLftTuff1_4.addChild(this.legFntLftTuff1_5);
//		this.headBang1.addChild(this.headBang2);
//		this.backFluffLft3Mid.addChild(this.backFluffLft3Mid2);
//		this.neckJoint.addChild(this.neck);
//		this.legFntLftTuff2_4.addChild(this.legFntLftTuff2_5);
//		this.legBckLft1.addChild(this.legBckLft2Joint);
//		this.headBang2.addChild(this.headBang3);
//		this.backFluffLft3.addChild(this.backFluffLft3Mid);
//		this.legBckLft3.addChild(this.legBckLftTuff1_1);
//		this.legFntLftTuff1_1.addChild(this.legFntLftTuff1_2);
//		this.head.addChild(this.headHair);
//		this.head.addChild(this.muzzle);
//		this.body.addChild(this.legBckRt1Joint);
//		this.legBckLft3.addChild(this.legBckLftSpikeTip);
//		this.backFluffRt2Mid.addChild(this.backFluffRt2Mid2);
//		this.legBckRtTuff2_4.addChild(this.legBckRtTuff2_5);
//		this.backFluffLft3Mid.addChild(this.backFluffLft3Mid1_1);
//		this.legBckLft2Joint.addChild(this.legBckLft2);
//		this.legFntLft2.addChild(this.legFntLftSpikeMid);
//		this.backFluffRt3Mid.addChild(this.backFluffRt3Mid2);
//		this.legFntRtTuff3_1.addChild(this.legFntRtTuff3_2);
//		this.legBckLftTuff2_1.addChild(this.legBckLftTuff2_2);
//		this.headJoint.addChild(this.head);
//		this.headHorn2.addChild(this.headHorn3);
//		this.legFntLftTuff3_3.addChild(this.legFntLftTuff3_4);
//		this.legFntLftTuff1_3.addChild(this.legFntLftTuff1_4);
//		this.legBckLftTuff1_1.addChild(this.legBckLftTuff1_2);
//		this.legBckRtTuff3_2.addChild(this.legBckRtTuff3_3);
//		this.backFluffRt.addChild(this.backFluffRt1);
//		this.headHorn1.addChild(this.headHorn2);
//		this.backFluffLft2Mid1_1.addChild(this.backFluffLft2Mid1_2);
//		this.legFntRt2.addChild(this.legFntRtTuff2_1);
//		this.legBckLftTuff2_3.addChild(this.legBckLftTuff2_4);
//		this.legBckRt3.addChild(this.legBckRtSpikeTip);
//		this.legFntRtTuff2_2.addChild(this.legFntRtTuff2_3);
//		this.body.addChild(this.backFluffRt);
//		this.legFntLft2Joint.addChild(this.legFntLft2);
//		this.backFluffRt.addChild(this.backFluffRt2);
//		this.headBang6.addChild(this.headBang7);
//		this.backFluffRt3Mid.addChild(this.backFluffRt3Mid1_1);
//		this.legBckRt1.addChild(this.legBckRt2Joint);
//		this.body.addChild(this.neckJoint);
//		this.legBckLft1Joint.addChild(this.legBckLft1);
//		this.backFluffLft1Bot1_1.addChild(this.backFluffLft1Bot1_2);
//		this.backFluffRt3Mid1_1.addChild(this.backFluffRt3Mid1_2);
//		this.body.addChild(this.legFntRt1Joint);
//		this.legBckLft3.addChild(this.legBckLftSpikeMid);
//		this.legFntRtTuff3_2.addChild(this.legFntRtTuff3_3);
//		this.backFluffLft1Mid1_1.addChild(this.backFluffLft1Mid1_2);
//		this.legBckLftTuff4_2.addChild(this.legBckLftTuff4_3);
//		this.legBckRtTuff4_1.addChild(this.legBckRtTuff4_2);
//		this.neck.addChild(this.headJoint);
//		this.legBckRtTuff3_1.addChild(this.legBckRtTuff3_2);
//		this.legBckRt1Joint.addChild(this.legBckRt1);
//		this.legBckRtTuff4_2.addChild(this.legBckRtTuff4_3);
//		this.backFluffLft3Mid1_1.addChild(this.backFluffLft3Mid1_2);
//		this.legFntLftTuff4_2.addChild(this.legFntLftTuff4_3);
//		this.backFluffRt1Top.addChild(this.backFluffRt1Top1_1);
//		this.backFluffLft2Mid.addChild(this.backFluffLft2Mid1_1);
//		this.head.addChild(this.headHairMid);
//		this.legFntLft2.addChild(this.legFntLftSpikeTip);
//		this.tailEdge1.addChild(this.tailEdge2);
//		this.backFluffRt1Mid.addChild(this.backFluffRt1Mid2);
//		this.backFluffLft.addChild(this.backFluffLft2);
//		this.legBckRt3.addChild(this.legBckRtTuff3_1);
//		this.legFntRt1Joint.addChild(this.legFntRt1);
//		this.legFntRtTuff3_3.addChild(this.legFntRtTuff3_4);
//		this.head.addChild(this.headHornSmall);
//		this.legFntLft2.addChild(this.legFntLftTuff2_1);
//		this.legFntRtTuff2_1.addChild(this.legFntRtTuff2_2);
//		this.legBckLftTuff2_4.addChild(this.legBckLftTuff2_5);
//		this.legBckLftTuff4_1.addChild(this.legBckLftTuff4_2);
//		this.legBckRt3.addChild(this.legBckRtTuff2_1);
//		this.body.addChild(this.backFluffLft);
//		this.tail2.addChild(this.tail3);
//		this.headHornBot.addChild(this.headHornBotTip);
//		this.backFluffRt1Top1_1.addChild(this.backFluffRt1Top1_2);
//		this.legBckLftTuff1_3.addChild(this.legBckLftTuff1_4);
//		this.legFntRtTuff4_1.addChild(this.legFntRtTuff4_2);
//		this.legBckLft2.addChild(this.legBckLft3Joint);
//		this.backFluffRt1Top.addChild(this.backFluffRt1Top2);
//		this.body.addChild(this.tail1);
//		this.legFntRt2.addChild(this.legFntRtSpike);
//		this.legFntRt2.addChild(this.legFntRtTuff3_1);
//		this.legBckLftTuff1_2.addChild(this.legBckLftTuff1_3);
//		this.legFntLftTuff2_3.addChild(this.legFntLftTuff2_4);
//		this.headBang5.addChild(this.headBang6);
//		this.head.addChild(this.headGemBot);
//		this.legBckRt2Joint.addChild(this.legBckRt2);
//		this.legBckLft3.addChild(this.legBckLftSpike);
//		this.legFntLftTuff1_2.addChild(this.legFntLftTuff1_3);
//		this.backFluffLft.addChild(this.backFluffLft3);
//		this.legFntRt2.addChild(this.legFntRtSpikeTip);
//		this.headHorn2.addChild(this.headHornEdge2);
//		this.legBckLft3.addChild(this.legBckLftTuff2_1);
//		this.backFluffRt3.addChild(this.backFluffRt3Mid);
//		this.legBckLftTuff3_1.addChild(this.legBckLftTuff3_2);
//		this.headHornSmall.addChild(this.headHornSmallBlade);
//		this.body.addChild(this.legBckLft1Joint);
//		this.headBang7.addChild(this.headBang8);
//		this.legBckRt2.addChild(this.legBckRt3Joint);
//		this.legBckLftTuff1_4.addChild(this.legBckLftTuff1_5);
//		this.backFluffRt1Mid.addChild(this.backFluffRt1Mid1_1);
//		this.tail1.addChild(this.tailEdge1);
//		this.legFntRtTuff1_2.addChild(this.legFntRtTuff1_3);
//		this.legBckRtTuff2_3.addChild(this.legBckRtTuff2_4);
//		this.backFluffLft1Mid.addChild(this.backFluffLft1Mid2);
//		this.backFluffLft.addChild(this.backFluffLft1);
//		this.tailEdge2.addChild(this.tailEdge3);
//		this.backFluffRt1Bot1_1.addChild(this.backFluffRt1Bot1_2);
//		this.legFntLft1.addChild(this.legFntLft2Joint);
//		this.backFluffRt1Bot.addChild(this.backFluffRt1Bot2);
//		this.legFntRt2.addChild(this.legFntRtSpikeMid);
//		this.headHorn1.addChild(this.headHornEdge1);
//		this.backFluffLft1Mid.addChild(this.backFluffLft1Mid1_1);
//		this.legBckLftTuff3_3.addChild(this.legBckLftTuff3_4);
//		this.head.addChild(this.headGemBotTip);
//		this.body.addChild(this.legFntLft1Joint);
//		this.backFluffLft2.addChild(this.backFluffLft2Mid);
//		this.legFntLftTuff4_1.addChild(this.legFntLftTuff4_2);
//		this.legBckRt3.addChild(this.legBckRtSpike);
//		this.headBang4.addChild(this.headBang5);
//		this.backFluffLft1Bot.addChild(this.backFluffLft1Bot1_1);
//		this.headHorn4.addChild(this.headHornEdge3);
//		this.legBckRtTuff1_4.addChild(this.legBckRtTuff1_5);
//		this.legBckLft3.addChild(this.legBckLftTuff4_1);
//		this.legFntRtTuff2_4.addChild(this.legFntRtTuff2_5);
//		this.legBckRtTuff2_1.addChild(this.legBckRtTuff2_2);
//		this.head.addChild(this.headBang1);
//		this.backFluffRt1.addChild(this.backFluffRt1Top);
//		this.backFluffLft1.addChild(this.backFluffLft1Top);
//		this.legFntLftTuff2_1.addChild(this.legFntLftTuff2_2);
//		this.legFntLftTuff2_2.addChild(this.legFntLftTuff2_3);
//		this.legFntRt2Joint.addChild(this.legFntRt2);
//		this.legBckLft3Joint.addChild(this.legBckLft3);
//		this.backFluffRt1.addChild(this.backFluffRt1Mid);
//		this.legFntRt2.addChild(this.legFntRtTuff4_1);
//		this.backFluffLft1.addChild(this.backFluffLft1Mid);
//		this.bodyJoint.addChild(this.bodyBck);
//		this.backFluffLft1Top.addChild(this.backFluffLft1Top1_1);
//		this.headBang3.addChild(this.headBang4);
//		this.legFntLftTuff3_1.addChild(this.legFntLftTuff3_2);
//		this.legBckRtTuff1_2.addChild(this.legBckRtTuff1_3);
//		this.backFluffRt2.addChild(this.backFluffRt2Mid);
//		this.backFluffRt2Mid1_1.addChild(this.backFluffRt2Mid1_2);
//		this.headHorn4.addChild(this.headHorn5);
//		this.legFntRtTuff1_4.addChild(this.legFntRtTuff1_5);
//		this.tail1.addChild(this.tail2);
//		this.headHorn3.addChild(this.headHorn4);
//		this.legBckRt3.addChild(this.legBckRtTuff1_1);
//		this.legBckRtTuff2_2.addChild(this.legBckRtTuff2_3);
//		this.legBckRt3.addChild(this.legBckRtTuff4_1);
//		this.legFntLft2.addChild(this.legFntLftTuff4_1);
//		this.legFntRt2.addChild(this.legFntRtTuff1_1);
//		this.tailEdge3.addChild(this.tailEdge4);
//		this.headHornSmall.addChild(this.headHornSmallTip);
//		this.backFluffLft1Bot.addChild(this.backFluffLft1Bot2);
//		this.head.addChild(this.headGem);
//		this.legBckRtTuff1_3.addChild(this.legBckRtTuff1_4);
//		this.legBckRtTuff3_3.addChild(this.legBckRtTuff3_4);
//		this.head.addChild(this.headHairTop);
//		this.backFluffLft1Top.addChild(this.backFluffLft1Top2);
//		this.legFntRt1.addChild(this.legFntRt2Joint);
//		this.legFntRtTuff1_3.addChild(this.legFntRtTuff1_4);
//		this.head.addChild(this.headHornBase);
//		this.headHorn1.addChild(this.headHornBot);
//		this.legFntLft2.addChild(this.legFntLftSpike);
//		this.headHorn5.addChild(this.headHorn6);
//		this.legBckLft3.addChild(this.legBckLftTuff3_1);
//		this.legBckRt3Joint.addChild(this.legBckRt3);
//		this.legFntRtTuff1_1.addChild(this.legFntRtTuff1_2);
//		this.backFluffRt.addChild(this.backFluffRt3);
//		this.legBckRtTuff1_1.addChild(this.legBckRtTuff1_2);
//		this.legBckLftTuff2_2.addChild(this.legBckLftTuff2_3);
//		this.backFluffLft1.addChild(this.backFluffLft1Bot);
//		this.backFluffRt1Bot.addChild(this.backFluffRt1Bot1_1);
//		this.legFntLft2.addChild(this.legFntLftTuff1_1);
//		this.backFluffLft2Mid.addChild(this.backFluffLft2Mid2);
//		this.legFntRtTuff2_3.addChild(this.legFntRtTuff2_4);
//		this.backFluffRt2Mid.addChild(this.backFluffRt2Mid1_1);
//		this.backFluffRt1Mid1_1.addChild(this.backFluffRt1Mid1_2);
//		this.legFntRtTuff4_2.addChild(this.legFntRtTuff4_3);
//		this.backFluffRt1.addChild(this.backFluffRt1Bot);
//		this.legFntLft2.addChild(this.legFntLftTuff3_1);
//		this.backFluffLft1Top1_1.addChild(this.backFluffLft1Top1_2);

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		this.bodyJoint.render(f5);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}