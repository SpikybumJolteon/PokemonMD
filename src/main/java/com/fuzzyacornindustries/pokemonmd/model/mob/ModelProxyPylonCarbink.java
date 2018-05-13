package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityProxyPylonCarbink;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZealotPawniard;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelProxyPylonCarbink extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer bodyCrystalBotLft;
	public ModelRenderer bodyCrystalLft;
	public ModelRenderer bodyCrystalFnt;
	public ModelRenderer bodyCrystalBotRt;
	public ModelRenderer bodyCrystalBck;

	public ModelRenderer collarCrystalNE;
	public ModelRenderer collarCrystalE;
	public ModelRenderer collarCrystalSE;
	public ModelRenderer collarCrystalS;
	public ModelRenderer collarCrystalSW;
	public ModelRenderer collarCrystalW;
	public ModelRenderer collarCrystalNW;
	public ModelRenderer collarCrystalN;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer earRtJoint;
	public ModelRenderer earRt;
	public ModelRenderer earLftJoint;
	public ModelRenderer earLft;
	PartInfo earRtJointInfo;
	PartInfo earRtInfo;
	PartInfo earLftJointInfo;
	PartInfo earLftInfo;

	public ModelRenderer barrierPebbleJoint;
	PartInfo barrierPebbleJointInfo;

	public ModelRenderer barrierPebble[] = new ModelRenderer[8];
	PartInfo barrierPebbleInfo[] = new PartInfo[barrierPebble.length];

	public ModelRenderer barrierArmsJoint;
	PartInfo barrierArmsJointInfo;

	public ModelRenderer barrierArm1BigJoint;
	public ModelRenderer barrierArm1BigFntTop;
	public ModelRenderer barrierArm1BigFntMid;
	public ModelRenderer barrierArm1BigFntBase;
	public ModelRenderer barrierArm1BigFntBot;
	PartInfo barrierArm1BigJointInfo;

	public ModelRenderer barrierArm2SmallJoint;
	public ModelRenderer barrierArm2SmallRtTop;
	public ModelRenderer barrierArm2SmallRtMid;
	public ModelRenderer barrierArm2SmallRtBase;
	public ModelRenderer barrierArm2SmallRtBot;
	PartInfo barrierArm2SmallJointInfo;

	public ModelRenderer barrierArm3BigJoint;
	public ModelRenderer barrierArm3BigBckTop;
	public ModelRenderer barrierArm3BigBckMid;
	public ModelRenderer barrierArm3BigBckBase;
	public ModelRenderer barrierArm3BigBckBot;
	PartInfo barrierArm3BigJointInfo;

	public ModelRenderer barrierArm4SmallJoint;
	public ModelRenderer barrierArm4SmallLftTop;
	public ModelRenderer barrierArm4SmallLftMid;
	public ModelRenderer barrierArm4SmallLftBase;
	public ModelRenderer barrierArm4SmallLftBot;
	PartInfo barrierArm4SmallJointInfo;

	public ModelProxyPylonCarbink() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.body = new ModelRenderer(this, 19, 24);
		this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
		this.body.addBox(-2.5F, -1.5F, -2.5F, 5, 3, 5, 0.0F);
		this.body.setTextureOffset(35, 23).addBox(-1.5F, 1.0F, -1.5F, 3, 2, 3, 0.0F); // bodyLowMid
		this.body.setTextureOffset(40, 29).addBox(-1.0F, 3.0F, -1.0F, 2, 1, 2, 0.0F); // bodyLowTip
		bodyInfo = new PartInfo(body);

		this.bodyCrystalBotLft = new ModelRenderer(this, 44, 0);
		this.bodyCrystalBotLft.setRotationPoint(1.0F, 2.7F, -0.6F);
		this.bodyCrystalBotLft.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
		this.setRotateAngle(bodyCrystalBotLft, 0.12391837689159739F, 0.3272492347489368F, 0.3694862026471996F);
		this.bodyCrystalLft = new ModelRenderer(this, 46, 5);
		this.bodyCrystalLft.setRotationPoint(2.3F, 0.4F, -1.3F);
		this.bodyCrystalLft.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(bodyCrystalLft, 0.7450810576763792F, 0.11187560505283653F, 0.8801695417807404F);
		this.bodyCrystalFnt = new ModelRenderer(this, 46, 8);
		this.bodyCrystalFnt.setRotationPoint(0.5F, 0.0F, -2.5F);
		this.bodyCrystalFnt.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(bodyCrystalFnt, 0.8936085770210968F, 0.9025097562062678F, 0.7504915783575618F);
		this.bodyCrystalBotRt = new ModelRenderer(this, 46, 11);
		this.bodyCrystalBotRt.setRotationPoint(-1.5F, 2.0F, -0.5F);
		this.bodyCrystalBotRt.addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(bodyCrystalBotRt, 0.38257617203715705F, 0.7583455599915362F, -0.3256784384221419F);
		this.bodyCrystalBck = new ModelRenderer(this, 46, 15);
		this.bodyCrystalBck.setRotationPoint(-1.5F, 0.6F, 2.5F);
		this.bodyCrystalBck.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(bodyCrystalBck, 0.8936085770210968F, 0.9025097562062678F, 0.7504915783575618F);

		this.collarCrystalNE = new ModelRenderer(this, 56, 0);
		this.collarCrystalNE.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalNE.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalNE, -2.6179938779914944F, -0.7853981633974483F, 0.0F);
		this.collarCrystalE = new ModelRenderer(this, 56, 4);
		this.collarCrystalE.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalE.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalE, -2.792526803190927F, -1.5707963267948966F, 0.0F);
		this.collarCrystalSE = new ModelRenderer(this, 56, 8);
		this.collarCrystalSE.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalSE.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalSE, 0.5235987755982988F, -0.7853981633974483F, 0.0F);
		this.collarCrystalS = new ModelRenderer(this, 56, 12);
		this.collarCrystalS.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalS.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalS, 0.3490658503988659F, -0.0F, 0.0F);
		this.collarCrystalSW = new ModelRenderer(this, 56, 16);
		this.collarCrystalSW.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalSW.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalSW, 0.5235987755982988F, 0.7853981633974483F, 0.0F);
		this.collarCrystalW = new ModelRenderer(this, 56, 20);
		this.collarCrystalW.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalW.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalW, -2.792526803190927F, 1.5707963267948966F, 0.0F);
		this.collarCrystalNW = new ModelRenderer(this, 56, 24);
		this.collarCrystalNW.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalNW.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalNW, -2.6179938779914944F, 0.7853981633974483F, 0.0F);
		this.collarCrystalN = new ModelRenderer(this, 56, 28);
		this.collarCrystalN.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.collarCrystalN.addBox(-1.0F, -0.5F, 1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(collarCrystalN, -2.705260340591211F, -0.0F, 0.0F);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.headJoint.addBox(-1.5F, -2.5F, -1.5F, 0, 0, 0, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-1.5F, -2.5F, -1.5F, 3, 3, 3, 0.0F);
		headInfo = new PartInfo(head);

		this.earRtJoint = new ModelRenderer(this, 0, 7);
		this.earRtJoint.setRotationPoint(-1.0F, -2.0F, 0.0F);
		this.earRtJoint.addBox(-1.0F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.0F, 0.0F, 0.5235987755982988F);
		earRtJointInfo = new PartInfo(earRtJoint);
		this.earRt = new ModelRenderer(this, 0, 7);
		this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt.addBox(-1.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.earRt.setTextureOffset(3, 8).addBox(-3.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F); // earRtMid
		this.earRt.setTextureOffset(10, 7).addBox(-4.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F); // earRtTip
		earRtInfo = new PartInfo(earRt);
		this.earLftJoint = new ModelRenderer(this, 0, 12);
		this.earLftJoint.setRotationPoint(1.0F, -2.0F, 0.0F);
		this.earLftJoint.addBox(0.0F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.0F, 0.0F, -0.5235987755982988F);
		earLftJointInfo = new PartInfo(earLftJoint);
		this.earLft = new ModelRenderer(this, 0, 12);
		this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft.addBox(0.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.earLft.setTextureOffset(3, 13).addBox(1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F); // earLftMid
		this.earLft.setTextureOffset(10, 12).addBox(3.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F); // earLftTip
		earLftInfo = new PartInfo(earLft);

		this.barrierPebbleJoint = new ModelRenderer(this, 51, 0);
		this.barrierPebbleJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebbleJoint.addBox(-0.5F, -0.5F, -5.0F, 0, 0, 0, 0.0F);
		barrierPebbleJointInfo = new PartInfo(barrierPebbleJoint);

		int barrierPebbleNumber = 0;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 0); // barrierPebble1
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierPebble[barrierPebbleNumber], 0.0F, 3.141592653589793F, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);
		barrierPebbleNumber++;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 3); // barrierPebble2
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierPebble[barrierPebbleNumber], 0.0F, 2.356194490192345F, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);
		barrierPebbleNumber++;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 6); // barrierPebble3
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierPebble[barrierPebbleNumber], 0.0F, 1.5707963267948966F, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);
		barrierPebbleNumber++;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 9); // barrierPebble4
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierPebble[barrierPebbleNumber], 0.0F, 0.7853981633974483F, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);
		barrierPebbleNumber++;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 12); // barrierPebble5
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);
		barrierPebbleNumber++;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 15); // barrierPebble6
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierPebble[barrierPebbleNumber], 0.0F, -0.7853981633974483F, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);
		barrierPebbleNumber++;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 18); // barrierPebble7
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierPebble[barrierPebbleNumber], 0.0F, -1.5707963267948966F, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);
		barrierPebbleNumber++;
		this.barrierPebble[barrierPebbleNumber] = new ModelRenderer(this, 51, 21); // barrierPebble8
		this.barrierPebble[barrierPebbleNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierPebble[barrierPebbleNumber].addBox(-0.5F, -0.5F, -5.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierPebble[barrierPebbleNumber], 0.0F, -2.356194490192345F, 0.0F);
		barrierPebbleInfo[barrierPebbleNumber] = new PartInfo(barrierPebble[barrierPebbleNumber]);

		this.barrierArmsJoint = new ModelRenderer(this, 17, 0);
		this.barrierArmsJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArmsJoint.addBox(-0.5F, -7.6F, -3.8F, 0, 0, 0, 0.0F);
		barrierArmsJointInfo = new PartInfo(barrierArmsJoint);

		this.barrierArm1BigJoint = new ModelRenderer(this, 17, 0);
		this.barrierArm1BigJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm1BigJoint.addBox(-0.5F, -7.6F, -3.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(barrierArm1BigJoint, 0.0F, 3.141592653589793F, 0.0F);
		barrierArm1BigJointInfo = new PartInfo(barrierArm1BigJoint);
		this.barrierArm1BigFntTop = new ModelRenderer(this, 17, 0);
		this.barrierArm1BigFntTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm1BigFntTop.addBox(-0.5F, -7.6F, -3.8F, 1, 3, 1, 0.0F);
		this.setRotateAngle(barrierArm1BigFntTop, 0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm1BigFntMid = new ModelRenderer(this, 16, 5);
		this.barrierArm1BigFntMid.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm1BigFntMid.addBox(-0.99F, -1.77F, -5.96F, 2, 4, 1, 0.0F);
		this.setRotateAngle(barrierArm1BigFntMid, -0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm1BigFntBase = new ModelRenderer(this, 16, 11);
		this.barrierArm1BigFntBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm1BigFntBase.addBox(-1.0F, -2.1F, -6.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(barrierArm1BigFntBase, 0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm1BigFntBot = new ModelRenderer(this, 17, 15);
		this.barrierArm1BigFntBot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm1BigFntBot.addBox(-0.5F, -0.1F, -6.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(barrierArm1BigFntBot, 0.3490658503988659F, 0.0F, 0.0F);

		this.barrierArm2SmallJoint = new ModelRenderer(this, 24, 0);
		this.barrierArm2SmallJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm2SmallJoint.addBox(-0.4F, 0.2F, -6.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(barrierArm2SmallJoint, 0.0F, 1.5707963267948966F, 0.0F);
		barrierArm2SmallJointInfo = new PartInfo(barrierArm2SmallJoint);
		this.barrierArm2SmallRtTop = new ModelRenderer(this, 24, 0);
		this.barrierArm2SmallRtTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm2SmallRtTop.addBox(-0.4F, 0.24F, -5.96F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierArm2SmallRtTop, -0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm2SmallRtMid = new ModelRenderer(this, 23, 3);
		this.barrierArm2SmallRtMid.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm2SmallRtMid.addBox(-0.99F, 1.24F, -5.96F, 2, 1, 1, 0.0F);
		this.setRotateAngle(barrierArm2SmallRtMid, -0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm2SmallRtBase = new ModelRenderer(this, 23, 6);
		this.barrierArm2SmallRtBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm2SmallRtBase.addBox(-1.0F, -2.1F, -6.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(barrierArm2SmallRtBase, 0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm2SmallRtBot = new ModelRenderer(this, 24, 10);
		this.barrierArm2SmallRtBot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm2SmallRtBot.addBox(-0.5F, -0.1F, -6.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierArm2SmallRtBot, 0.3490658503988659F, 0.0F, 0.0F);

		this.barrierArm3BigJoint = new ModelRenderer(this, 31, 0);
		this.barrierArm3BigJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm3BigJoint.addBox(-0.5F, -7.6F, -3.8F, 0, 0, 0, 0.0F);
		barrierArm3BigJointInfo = new PartInfo(barrierArm3BigJoint);
		this.barrierArm3BigBckTop = new ModelRenderer(this, 31, 0);
		this.barrierArm3BigBckTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm3BigBckTop.addBox(-0.5F, -7.6F, -3.8F, 1, 3, 1, 0.0F);
		this.setRotateAngle(barrierArm3BigBckTop, 0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm3BigBckMid = new ModelRenderer(this, 30, 5);
		this.barrierArm3BigBckMid.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm3BigBckMid.addBox(-0.99F, -1.77F, -5.96F, 2, 4, 1, 0.0F);
		this.setRotateAngle(barrierArm3BigBckMid, -0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm3BigBckBase = new ModelRenderer(this, 30, 11);
		this.barrierArm3BigBckBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm3BigBckBase.addBox(-1.0F, -2.1F, -6.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(barrierArm3BigBckBase, 0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm3BigBckBot = new ModelRenderer(this, 31, 15);
		this.barrierArm3BigBckBot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm3BigBckBot.addBox(-0.5F, -0.1F, -6.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(barrierArm3BigBckBot, 0.3490658503988659F, 0.0F, 0.0F);

		this.barrierArm4SmallJoint = new ModelRenderer(this, 38, 0);
		this.barrierArm4SmallJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm4SmallJoint.addBox(-0.4F, 0.2F, -6.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(barrierArm4SmallJoint, 0.0F, -1.5707963267948966F, 0.0F);
		barrierArm4SmallJointInfo = new PartInfo(barrierArm4SmallJoint);
		this.barrierArm4SmallLftTop = new ModelRenderer(this, 38, 0);
		this.barrierArm4SmallLftTop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm4SmallLftTop.addBox(-0.4F, 0.24F, -5.96F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierArm4SmallLftTop, -0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm4SmallLftMid = new ModelRenderer(this, 37, 3);
		this.barrierArm4SmallLftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm4SmallLftMid.addBox(-0.99F, 1.24F, -5.96F, 2, 1, 1, 0.0F);
		this.setRotateAngle(barrierArm4SmallLftMid, -0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm4SmallLftBase = new ModelRenderer(this, 37, 6);
		this.barrierArm4SmallLftBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm4SmallLftBase.addBox(-1.0F, -2.1F, -6.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(barrierArm4SmallLftBase, 0.3490658503988659F, 0.0F, 0.0F);
		this.barrierArm4SmallLftBot = new ModelRenderer(this, 38, 10);
		this.barrierArm4SmallLftBot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrierArm4SmallLftBot.addBox(-0.5F, -0.1F, -6.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(barrierArm4SmallLftBot, 0.3490658503988659F, 0.0F, 0.0F);

		this.body.addChild(this.barrierArmsJoint);
		this.body.addChild(this.barrierPebbleJoint);
		this.body.addChild(this.bodyCrystalBck);
		this.body.addChild(this.bodyCrystalBotLft);
		this.body.addChild(this.bodyCrystalBotRt);
		this.body.addChild(this.bodyCrystalFnt);
		this.body.addChild(this.bodyCrystalLft);
		this.body.addChild(this.collarCrystalE);
		this.body.addChild(this.collarCrystalN);
		this.body.addChild(this.collarCrystalNE);
		this.body.addChild(this.collarCrystalNW);
		this.body.addChild(this.collarCrystalS);
		this.body.addChild(this.collarCrystalSE);
		this.body.addChild(this.collarCrystalSW);
		this.body.addChild(this.collarCrystalW);
		this.body.addChild(this.headJoint);

		this.barrierArmsJoint.addChild(this.barrierArm1BigJoint);
		this.barrierArmsJoint.addChild(this.barrierArm2SmallJoint);
		this.barrierArmsJoint.addChild(this.barrierArm3BigJoint);
		this.barrierArmsJoint.addChild(this.barrierArm4SmallJoint);
		this.barrierArm1BigJoint.addChild(this.barrierArm1BigFntBase);
		this.barrierArm1BigJoint.addChild(this.barrierArm1BigFntBot);
		this.barrierArm1BigJoint.addChild(this.barrierArm1BigFntMid);
		this.barrierArm1BigJoint.addChild(this.barrierArm1BigFntTop);
		this.barrierArm2SmallJoint.addChild(this.barrierArm2SmallRtBase);
		this.barrierArm2SmallJoint.addChild(this.barrierArm2SmallRtBot);
		this.barrierArm2SmallJoint.addChild(this.barrierArm2SmallRtMid);
		this.barrierArm2SmallJoint.addChild(this.barrierArm2SmallRtTop);
		this.barrierArm3BigJoint.addChild(this.barrierArm3BigBckBase);
		this.barrierArm3BigJoint.addChild(this.barrierArm3BigBckBot);
		this.barrierArm3BigJoint.addChild(this.barrierArm3BigBckMid);
		this.barrierArm3BigJoint.addChild(this.barrierArm3BigBckTop);
		this.barrierArm4SmallJoint.addChild(this.barrierArm4SmallLftBase);
		this.barrierArm4SmallJoint.addChild(this.barrierArm4SmallLftBot);
		this.barrierArm4SmallJoint.addChild(this.barrierArm4SmallLftMid);
		this.barrierArm4SmallJoint.addChild(this.barrierArm4SmallLftTop);

		for(int i = 0; i < barrierPebble.length; i++)
		{
			this.barrierPebbleJoint.addChild(this.barrierPebble[i]);
		}

		this.headJoint.addChild(this.head);
		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earRtJoint);

		this.earLftJoint.addChild(this.earLft);
		this.earRtJoint.addChild(this.earRt);

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

		animateHead((EntityProxyPylonCarbink)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateVerticalFloat((EntityProxyPylonCarbink)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateBarrierPebbles((EntityProxyPylonCarbink)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateBarrierArms((EntityProxyPylonCarbink)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		headInfo.resetNewAngles();
		
		bodyInfo.resetNewAngles();
		bodyInfo.resetNewPnt();
		
		barrierArmsJointInfo.resetNewAngles();

		barrierArm1BigJointInfo.resetNewAngles();
		barrierArm2SmallJointInfo.resetNewAngles();
		barrierArm3BigJointInfo.resetNewAngles();
		barrierArm4SmallJointInfo.resetNewAngles();

		for(int i = 0; i < barrierPebble.length; i++)
		{
			barrierPebbleInfo[i].resetNewAngles();
		}
	}

	public void animateHead(EntityProxyPylonCarbink entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.8F, 0.8F);
	}
	
	public void animateVerticalFloat(EntityProxyPylonCarbink entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockVerticalFloat();

		float amplitudeShiftY = 1.0F;

		bodyInfo.setNewPointY(bodyInfo.getNewPnt().getY() + MathHelper.cos(2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredY(0)) * amplitudeShiftY);
	}

	public void animateBarrierPebbles(EntityProxyPylonCarbink entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock idleAnimationClockForX = entity.getIdleAnimationClockBarrierPebbles();

		for(int i = 0; i < barrierPebble.length; i++)
		{
			float xAngleMaximum = 0.25F;
			float idleFrequencyX = 4F;

			if (i % 2 == 0)
			{
				// even
				barrierPebbleInfo[i].setNewRotateY(barrierPebbleInfo[i].getNewRotateY() + (2F * PI * idleAnimationClockForX.getPhaseDurationCoveredX(0)));

				barrierPebbleInfo[i].setNewRotateX(MathHelper.cos((2 * PI * idleAnimationClockForX.getPhaseDurationCoveredX(0)) * idleFrequencyX) * xAngleMaximum);
			} 
			else
			{
				// odd
				barrierPebbleInfo[i].setNewRotateY(barrierPebbleInfo[i].getNewRotateY() - (2F * PI * idleAnimationClockForX.getPhaseDurationCoveredX(0)) + PI/4);

				barrierPebbleInfo[i].setNewRotateX(-MathHelper.cos(2 * PI * idleAnimationClockForX.getPhaseDurationCoveredX(0) * idleFrequencyX) * xAngleMaximum);
			}
		}
	}

	public void animateBarrierArms(EntityProxyPylonCarbink entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBarrierArms();

		barrierArmsJointInfo.setNewRotateY(barrierArmsJointInfo.getNewRotateY() - (2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredX(0)));
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(head, headInfo.getNewRotates());
		
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.move(body, bodyInfo.getNewPnt());
	
		this.animationDeployer.rotate(barrierArmsJoint, barrierArmsJointInfo.getNewRotates());
		
		this.animationDeployer.rotate(barrierArm1BigJoint, barrierArm1BigJointInfo.getNewRotates());
		this.animationDeployer.rotate(barrierArm2SmallJoint, barrierArm2SmallJointInfo.getNewRotates());
		this.animationDeployer.rotate(barrierArm3BigJoint, barrierArm3BigJointInfo.getNewRotates());
		this.animationDeployer.rotate(barrierArm4SmallJoint, barrierArm4SmallJointInfo.getNewRotates());

		for(int i = 0; i < barrierPebble.length; i++)
		{
			this.animationDeployer.rotate(barrierPebble[i], barrierPebbleInfo[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}