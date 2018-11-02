package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.IMobMotionTracker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibrarySmeetaLiepardAttackID;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntitySmeetaLiepard;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSmeetaLiepard extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public final float RUN_FREQUENCY = 1.2F;
	public final float WALK_FREQUENCY = 1.2F;
	public final float WALK_MAX = 0.4F;
	public final float RUN_MIN = 0.5F;

	public ModelRenderer bodyJoint;
	public ModelRenderer body;
	PartInfo bodyJointInfo;
	PartInfo bodyInfo;
	PartInfo bodySitInfo;

	public ModelRenderer legFntLft[][] = new ModelRenderer[2][2];
	PartInfo legFntLftInfo[][] = new PartInfo[legFntLft.length][2];
	PartInfo legFntLftSitInfo[][] = new PartInfo[legFntLft.length][2];

	public ModelRenderer legFntRt[][] = new ModelRenderer[2][2];
	PartInfo legFntRtInfo[][] = new PartInfo[legFntRt.length][2];
	PartInfo legFntRtSitInfo[][] = new PartInfo[legFntRt.length][2];

	public ModelRenderer legBckLft[][] = new ModelRenderer[3][2];
	PartInfo legBckLftInfo[][] = new PartInfo[legBckLft.length][2];
	PartInfo legBckLftSitInfo[][] = new PartInfo[legBckLft.length][2];

	public ModelRenderer legBckRt[][] = new ModelRenderer[3][2];
	PartInfo legBckRtInfo[][] = new PartInfo[legBckRt.length][2];
	PartInfo legBckRtSitInfo[][] = new PartInfo[legBckRt.length][2];

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	PartInfo neckJointInfo;
	PartInfo neckJointSitInfo;
	PartInfo neckInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer muzzle;

	public ModelRenderer whiskerLftTop;
	public ModelRenderer whiskerLftBot;
	public ModelRenderer whiskerRtTop;
	public ModelRenderer whiskerRtBot;
	PartInfo whiskerLftTopInfo;
	PartInfo whiskerLftBotInfo;
	PartInfo whiskerRtTopInfo;
	PartInfo whiskerRtBotInfo;

	public ModelRenderer earLftJoint;
	PartInfo earLftJointInfo;

	public ModelRenderer earLft[] = new ModelRenderer[6];
	PartInfo earLftInfo[] = new PartInfo[earLft.length];

	public ModelRenderer earRtJoint;
	PartInfo earRtJointInfo;

	public ModelRenderer earRt[] = new ModelRenderer[6];
	PartInfo earRtInfo[] = new PartInfo[earRt.length];

	public ModelRenderer tailFlareLongLftJoint;
	public ModelRenderer tailFlareShortLftJoint;
	public ModelRenderer tailThreadLftJoint;
	public ModelRenderer tailMidJoint;
	public ModelRenderer tailThreadRtJoint;
	public ModelRenderer tailFlareShortRtJoint;
	public ModelRenderer tailFlareLongRtJoint;
	PartInfo tailFlareLongLftJointInfo;
	PartInfo tailFlareShortLftJointInfo;
	PartInfo tailThreadLftJointInfo;
	PartInfo tailMidJointInfo;
	PartInfo tailThreadRtJointInfo;
	PartInfo tailFlareShortRtJointInfo;
	PartInfo tailFlareLongRtJointInfo;

	PartInfo tailFlareLongLftJointSitInfo;
	PartInfo tailFlareShortLftJointSitInfo;
	PartInfo tailThreadLftJointSitInfo;
	PartInfo tailMidJointSitInfo;
	PartInfo tailThreadRtJointSitInfo;
	PartInfo tailFlareShortRtJointSitInfo;
	PartInfo tailFlareLongRtJointSitInfo;

	public ModelRenderer tailFlareLongLft[] = new ModelRenderer[6];
	PartInfo tailFlareLongLftInfo[] = new PartInfo[tailFlareLongLft.length];
	PartInfo tailFlareLongLftSitInfo[] = new PartInfo[tailFlareLongLft.length];

	public ModelRenderer tailFlareShortLft[] = new ModelRenderer[5];
	PartInfo tailFlareShortLftInfo[] = new PartInfo[tailFlareShortLft.length];
	PartInfo tailFlareShortLftSitInfo[] = new PartInfo[tailFlareShortLft.length];

	public ModelRenderer tailThreadLft[] = new ModelRenderer[6];
	PartInfo tailThreadLftInfo[] = new PartInfo[tailThreadLft.length];
	PartInfo tailThreadLftSitInfo[] = new PartInfo[tailThreadLft.length];

	public ModelRenderer tailMid[] = new ModelRenderer[7];
	PartInfo tailMidInfo[] = new PartInfo[tailMid.length];
	PartInfo tailMidSitInfo[] = new PartInfo[tailMid.length];

	public ModelRenderer tailMidTuff[] = new ModelRenderer[3];
	PartInfo tailMidTuffInfo[] = new PartInfo[tailMidTuff.length];
	PartInfo tailMidTuffSitInfo[] = new PartInfo[tailMidTuff.length];

	public ModelRenderer tailThreadRt[] = new ModelRenderer[6];
	PartInfo tailThreadRtInfo[] = new PartInfo[tailThreadRt.length];
	PartInfo tailThreadRtSitInfo[] = new PartInfo[tailThreadRt.length];

	public ModelRenderer tailFlareShortRt[] = new ModelRenderer[5];
	PartInfo tailFlareShortRtInfo[] = new PartInfo[tailFlareShortRt.length];
	PartInfo tailFlareShortRtSitInfo[] = new PartInfo[tailFlareShortRt.length];

	public ModelRenderer tailFlareLongRt[] = new ModelRenderer[6];
	PartInfo tailFlareLongRtInfo[] = new PartInfo[tailFlareLongRt.length];
	PartInfo tailFlareLongRtSitInfo[] = new PartInfo[tailFlareLongRt.length];

	public ModelSmeetaLiepard() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		int jointNumber = 0;
		int partNumber = 1;

		this.bodyJoint = new ModelRenderer(this, 46, 23);
		this.bodyJoint.setRotationPoint(0.0F, 16.5F, 0.0F);
		this.bodyJointInfo = new PartInfo(bodyJoint);

		this.body = new ModelRenderer(this, 46, 23);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-1.5F, -2.0F, -4.5F, 3, 4, 5, 0.0F);
		this.body.setTextureOffset(47, 16).addBox(-1.5F, -2.0F, 0.5F, 3, 3, 4, 0.0F); // bodyBack
		this.bodyInfo = new PartInfo(body);

		this.body.setRotationPoint(0.0F, 4.5F, 0.0F);
		this.setRotateAngle(body, -0.9599310885968813F, 0.0F, 0.0F);
		this.bodySitInfo = new PartInfo(body);

		int legPartNumber = 0;
		this.legFntLft[legPartNumber][jointNumber] = new ModelRenderer(this, 55, 4); // legFntLft1Joint
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(1.2F, -0.5F, -3.2F);
		this.legFntLft[legPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.legFntLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber] = new ModelRenderer(this, 55, 4); // legFntLft1
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLft[legPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.legFntLftInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntLft[legPartNumber][jointNumber] = new ModelRenderer(this, 55, 8); // legFntLft2Joint
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
		this.legFntLft[legPartNumber][jointNumber].addBox(-0.51F, -0.3F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legFntLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber] = new ModelRenderer(this, 55, 8); // legFntLft2
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLft[legPartNumber][partNumber].addBox(-0.51F, -0.3F, -0.5F, 1, 6, 1, 0.0F);
		this.legFntLftInfo[legPartNumber][partNumber] = new PartInfo(this.legFntLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(1.2F, -0.5F, -3.2F); // legFntLft1Joint
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], 1.48352986419518F, 0.0F, 0.0F);
		this.legFntLftSitInfo[legPartNumber][jointNumber] = new PartInfo(legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntLft1
		this.legFntLftSitInfo[legPartNumber][partNumber] = new PartInfo(legFntLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F); // legFntLft2Joint
		this.setRotateAngle(legFntLft[legPartNumber][jointNumber], -1.1344640137963142F, 0.0F, 0.0F);
		this.legFntLftSitInfo[legPartNumber][jointNumber] = new PartInfo(legFntLft[legPartNumber][jointNumber]);
		this.legFntLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntLft2
		this.legFntLftSitInfo[legPartNumber][partNumber] = new PartInfo(legFntLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legFntRt[legPartNumber][jointNumber] = new ModelRenderer(this, 49, 4); // legFntRt1Joint
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(-1.2F, -0.5F, -3.2F);
		this.legFntRt[legPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.legFntRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber] = new ModelRenderer(this, 49, 4); // legFntRt1
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntRt[legPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.legFntRtInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntRt[legPartNumber][jointNumber] = new ModelRenderer(this, 49, 8); // legFntRt2Joint
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
		this.legFntRt[legPartNumber][jointNumber].addBox(-0.49F, -0.3F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legFntRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber] = new ModelRenderer(this, 49, 8); // legFntRt2
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntRt[legPartNumber][partNumber].addBox(-0.49F, -0.3F, -0.5F, 1, 6, 1, 0.0F);
		this.legFntRtInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(-1.2F, -0.5F, -3.2F); // legFntRt1Joint
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], 1.48352986419518F, 0.0F, 0.0F);
		this.legFntRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntRt1
		this.legFntRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legFntRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F); // legFntRt2Joint
		this.setRotateAngle(legFntRt[legPartNumber][jointNumber], -1.1344640137963142F, 0.0F, 0.0F);
		this.legFntRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legFntRt[legPartNumber][jointNumber]);
		this.legFntRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legFntRt2
		this.legFntRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legFntRt[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 60, 6); // legBckLft1Joint
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(1.2F, -0.5F, 3.0F);
		this.legBckLft[legPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 6); // legBckLft1
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLft[legPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 60, 11); // legBckLft2Joint
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 3.2F, 0.0F);
		this.legBckLft[legPartNumber][jointNumber].addBox(-0.51F, -0.2F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 11); // legBckLft2
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLft[legPartNumber][partNumber].addBox(-0.51F, -0.2F, -0.5F, 1, 3, 1, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber] = new ModelRenderer(this, 60, 15); // legBckLft3Joint
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.6F, 0.0F);
		this.legBckLft[legPartNumber][jointNumber].addBox(-0.5F, -0.2F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -0.6981317007977318F, 0.0F, 0.0F);
		this.legBckLftInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber] = new ModelRenderer(this, 60, 15); // legBckLft3
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckLft[legPartNumber][partNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 3, 1, 0.0F);
		this.legBckLftInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(1.2F, -0.5F, 3.0F); // legBckLft1Joint
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -1.0821041362364843F, -0.13962634015954636F, -0.2617993877991494F);
		this.legBckLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckLft1
		this.legBckLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 3.2F, 0.0F); // legBckLft2Joint
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], 2.356194490192345F, 0.0F, 0.0F);
		this.legBckLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckLft2
		this.legBckLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckLft[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.6F, 0.0F); // legBckLft3Joint
		this.setRotateAngle(legBckLft[legPartNumber][jointNumber], -1.902408884673819F, 0.0F, 0.0F);
		this.legBckLftSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckLft[legPartNumber][jointNumber]);
		this.legBckLft[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckLft3
		this.legBckLftSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckLft[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 44, 6); // legBckRt1Joint
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(-1.2F, -0.5F, 3.0F);
		this.legBckRt[legPartNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 44, 6); // legBckRt1
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRt[legPartNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 44, 11); // legBckRt2Joint
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 3.2F, 0.0F);
		this.legBckRt[legPartNumber][jointNumber].addBox(-0.49F, -0.2F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 44, 11); // legBckRt2
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRt[legPartNumber][partNumber].addBox(-0.49F, -0.2F, -0.5F, 1, 3, 1, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber] = new ModelRenderer(this, 44, 15); // legBckRt3Joint
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.6F, 0.0F);
		this.legBckRt[legPartNumber][jointNumber].addBox(-0.5F, -0.2F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -0.6981317007977318F, 0.0F, 0.0F);
		this.legBckRtInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber] = new ModelRenderer(this, 44, 15); // legBckRt3
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRt[legPartNumber][partNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 3, 1, 0.0F);
		this.legBckRtInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);

		legPartNumber = 0;
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(-1.2F, -0.5F, 3.0F); // legBckRt1Joint
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -1.0821041362364843F, 0.13962634015954636F, 0.2617993877991494F);
		this.legBckRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckRt1
		this.legBckRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 3.2F, 0.0F); // legBckRt2Joint
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], 2.356194490192345F, 0.0F, 0.0F);
		this.legBckRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckRt2
		this.legBckRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);
		legPartNumber++;
		this.legBckRt[legPartNumber][jointNumber].setRotationPoint(0.0F, 2.6F, 0.0F); // legBckRt3Joint
		this.setRotateAngle(legBckRt[legPartNumber][jointNumber], -1.902408884673819F, 0.0F, 0.0F);
		this.legBckRtSitInfo[legPartNumber][jointNumber] = new PartInfo(this.legBckRt[legPartNumber][jointNumber]);
		this.legBckRt[legPartNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // legBckRt3
		this.legBckRtSitInfo[legPartNumber][partNumber] = new PartInfo(this.legBckRt[legPartNumber][partNumber]);

		this.neckJoint = new ModelRenderer(this, 0, 0);
		this.neckJoint.setRotationPoint(0.0F, -1.0F, -3.5F);
		this.neckJoint.addBox(-1.0F, -1.0F, -3.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, -0.7853981633974483F, 0.0F, 0.0F);
		this.neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 1, 9);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
		this.neckInfo = new PartInfo(neck);

		this.neckJoint.setRotationPoint(0.0F, -1.0F, -3.5F);
		this.setRotateAngle(neckJoint, -0.2617993877991494F, 0.0F, 0.0F);
		this.neckJointSitInfo = new PartInfo(neckJoint);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, 0.0F, -2.5F);
		this.headJoint.addBox(-2.0F, -3.0F, -3.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, 0.7853981633974483F, 0.0F, 0.0F);
		this.headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -3.0F, -3.2F, 4, 4, 4, 0.0F);
		this.headInfo = new PartInfo(head);

		this.muzzle = new ModelRenderer(this, 13, 0);
		this.muzzle.setRotationPoint(0.0F, 0.0F, -3.5F);
		this.muzzle.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(muzzle, 0.17453292519943295F, 0.0F, 0.0F);
		this.muzzle.setTextureOffset(20, 0).addBox(-0.5F, -0.9F, -1.2F, 1, 1, 1, 0.0F); // nose

		this.whiskerLftTop = new ModelRenderer(this, 37, 6);
		this.whiskerLftTop.setRotationPoint(0.8F, -0.3F, -0.8F);
		this.whiskerLftTop.addBox(-0.2F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(whiskerLftTop, 0.0F, 0.0F, 0.2617993877991494F);
		this.whiskerLftTopInfo = new PartInfo(whiskerLftTop);
		this.whiskerLftBot = new ModelRenderer(this, 37, 8);
		this.whiskerLftBot.setRotationPoint(0.8F, 0.1F, -0.9F);
		this.whiskerLftBot.addBox(-0.2F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(whiskerLftBot, 0.0F, 0.0F, 0.5410520681182421F);
		this.whiskerLftBotInfo = new PartInfo(whiskerLftBot);
		this.whiskerRtTop = new ModelRenderer(this, 30, 6);
		this.whiskerRtTop.setRotationPoint(-0.8F, -0.3F, -0.8F);
		this.whiskerRtTop.addBox(-1.8F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(whiskerRtTop, 0.0F, 0.0F, -0.2617993877991494F);
		this.whiskerRtTopInfo = new PartInfo(whiskerRtTop);
		this.whiskerRtBot = new ModelRenderer(this, 30, 8);
		this.whiskerRtBot.setRotationPoint(-0.8F, 0.1F, -0.9F);
		this.whiskerRtBot.addBox(-1.8F, -0.5F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(whiskerRtBot, 0.0F, 0.0F, -0.5410520681182421F);
		this.whiskerRtBotInfo = new PartInfo(whiskerRtBot);

		this.earLftJoint = new ModelRenderer(this, 0, 0);
		this.earLftJoint.setRotationPoint(1.5F, -2.5F, 0.0F);
		this.earLftJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.6981317007977318F, -1.0471975511965976F, -0.6981317007977318F);
		this.earLftJointInfo = new PartInfo(earLftJoint);

		int earNumber = 0;
		this.earLft[earNumber] = new ModelRenderer(this, 25, 0); // earLft1
		this.earLft[earNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft[earNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLftInfo[earNumber] = new PartInfo(earLft[earNumber]);
		earNumber++;
		this.earLft[earNumber] = new ModelRenderer(this, 31, 0); // earLft2
		this.earLft[earNumber].setRotationPoint(0.9F, 0.0F, 0.0F);
		this.earLft[earNumber].addBox(-0.4F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLftInfo[earNumber] = new PartInfo(earLft[earNumber]);
		earNumber++;
		this.earLft[earNumber] = new ModelRenderer(this, 37, 0); // earLft3
		this.earLft[earNumber].setRotationPoint(1.5F, 0.0F, 0.0F);
		this.earLft[earNumber].addBox(-0.4F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLftInfo[earNumber] = new PartInfo(earLft[earNumber]);
		earNumber++;
		this.earLft[earNumber] = new ModelRenderer(this, 43, 0); // earLft4
		this.earLft[earNumber].setRotationPoint(1.5F, 0.0F, 0.0F);
		this.earLft[earNumber].addBox(-0.4F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earLftInfo[earNumber] = new PartInfo(earLft[earNumber]);
		earNumber++;
		this.earLft[earNumber] = new ModelRenderer(this, 49, 0); // earLft5
		this.earLft[earNumber].setRotationPoint(1.5F, 0.0F, 0.0F);
		this.earLft[earNumber].addBox(-0.3F, -0.7F, -0.5F, 2, 1, 1, 0.0F);
		this.earLftInfo[earNumber] = new PartInfo(earLft[earNumber]);
		earNumber++;
		this.earLft[earNumber] = new ModelRenderer(this, 55, 0); // earLft6
		this.earLft[earNumber].setRotationPoint(1.5F, 0.0F, 0.0F);
		this.earLft[earNumber].addBox(-0.3F, -0.7F, -0.5F, 2, 1, 1, 0.0F);
		this.earLftInfo[earNumber] = new PartInfo(earLft[earNumber]);

		this.earRtJoint = new ModelRenderer(this, 0, 0);
		this.earRtJoint.setRotationPoint(-1.5F, -2.5F, 0.0F);
		this.earRtJoint.addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.6981317007977318F, 1.0471975511965976F, 0.6981317007977318F);
		this.earRtJointInfo = new PartInfo(earRtJoint);

		earNumber = 0;
		this.earRt[earNumber] = new ModelRenderer(this, 42, 3); // earRt1
		this.earRt[earNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt[earNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRtInfo[earNumber] = new PartInfo(earRt[earNumber]);
		earNumber++;
		this.earRt[earNumber] = new ModelRenderer(this, 36, 3); // earRt2
		this.earRt[earNumber].setRotationPoint(-0.9F, 0.0F, 0.0F);
		this.earRt[earNumber].addBox(-1.6F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRtInfo[earNumber] = new PartInfo(earRt[earNumber]);
		earNumber++;
		this.earRt[earNumber] = new ModelRenderer(this, 30, 3); // earRt3
		this.earRt[earNumber].setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.earRt[earNumber].addBox(-1.6F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRtInfo[earNumber] = new PartInfo(earRt[earNumber]);
		earNumber++;
		this.earRt[earNumber] = new ModelRenderer(this, 24, 3); // earRt4
		this.earRt[earNumber].setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.earRt[earNumber].addBox(-1.6F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earRtInfo[earNumber] = new PartInfo(earRt[earNumber]);
		earNumber++;
		this.earRt[earNumber] = new ModelRenderer(this, 18, 5); // earRt5
		this.earRt[earNumber].setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.earRt[earNumber].addBox(-1.7F, -0.7F, -0.5F, 2, 1, 1, 0.0F);
		this.earRtInfo[earNumber] = new PartInfo(earRt[earNumber]);
		earNumber++;
		this.earRt[earNumber] = new ModelRenderer(this, 18, 7); // earRt6
		this.earRt[earNumber].setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.earRt[earNumber].addBox(-1.7F, -0.7F, -0.5F, 2, 1, 1, 0.0F);
		this.earRtInfo[earNumber] = new PartInfo(earRt[earNumber]);

		this.tailFlareLongLftJoint = new ModelRenderer(this, 36, 29);
		this.tailFlareLongLftJoint.setRotationPoint(0.6F, -1.2F, 4.5F);
		this.tailFlareLongLftJoint.addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		this.tailFlareLongLftJointInfo = new PartInfo(tailFlareLongLftJoint);
		this.tailFlareShortLftJoint = new ModelRenderer(this, 30, 28);
		this.tailFlareShortLftJoint.setRotationPoint(0.4F, -1.4F, 4.5F);
		this.tailFlareShortLftJoint.addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		this.tailFlareShortLftJointInfo = new PartInfo(tailFlareShortLftJoint);
		this.tailThreadLftJoint = new ModelRenderer(this, 24, 29);
		this.tailThreadLftJoint.setRotationPoint(0.2F, -1.4F, 4.5F);
		this.tailThreadLftJoint.addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		this.tailThreadLftJointInfo = new PartInfo(tailThreadLftJoint);
		this.tailMidJoint = new ModelRenderer(this, 18, 28);
		this.tailMidJoint.setRotationPoint(0.0F, -1.2F, 4.5F);
		this.tailMidJoint.addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		this.tailMidJointInfo = new PartInfo(tailMidJoint);
		this.tailThreadRtJoint = new ModelRenderer(this, 12, 29);
		this.tailThreadRtJoint.setRotationPoint(-0.2F, -1.4F, 4.5F);
		this.tailThreadRtJoint.addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		this.tailThreadRtJointInfo = new PartInfo(tailThreadRtJoint);
		this.tailFlareShortRtJoint = new ModelRenderer(this, 7, 28);
		this.tailFlareShortRtJoint.setRotationPoint(-0.4F, -1.4F, 4.5F);
		this.tailFlareShortRtJoint.addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		this.tailFlareShortRtJointInfo = new PartInfo(tailFlareShortRtJoint);
		this.tailFlareLongRtJoint = new ModelRenderer(this, 1, 29);
		this.tailFlareLongRtJoint.setRotationPoint(-0.6F, -1.2F, 4.5F);
		this.tailFlareLongRtJoint.addBox(-0.5F, -0.5F, -0.3F, 0, 0, 0, 0.0F);
		this.tailFlareLongRtJointInfo = new PartInfo(tailFlareLongRtJoint);

		this.tailFlareLongLftJoint.setRotationPoint(0.6F, -1.2F, 4.5F);
		this.setRotateAngle(tailFlareLongLftJoint, 0.8726646259971648F, 0.3490658503988659F, 0.0F);
		this.tailFlareLongLftJointSitInfo = new PartInfo(tailFlareLongLftJoint);
		this.tailFlareShortLftJoint.setRotationPoint(0.4F, -1.4F, 4.5F);
		this.setRotateAngle(tailFlareShortLftJoint, 0.8726646259971648F, 0.3490658503988659F, 0.0F);
		this.tailFlareShortLftJointSitInfo = new PartInfo(tailFlareShortLftJoint);
		this.tailThreadLftJoint.setRotationPoint(0.2F, -1.4F, 4.5F);
		this.setRotateAngle(tailThreadLftJoint, 0.8726646259971648F, 0.3490658503988659F, 0.0F);
		this.tailThreadLftJointSitInfo = new PartInfo(tailThreadLftJoint);
		this.tailMidJoint.setRotationPoint(0.0F, -1.2F, 4.5F);
		this.setRotateAngle(tailMidJoint, 0.8726646259971648F, 0.0F, 0.0F);
		this.tailMidJointSitInfo = new PartInfo(tailMidJoint);
		this.tailThreadRtJoint.setRotationPoint(-0.2F, -1.4F, 4.5F);
		this.setRotateAngle(tailThreadRtJoint, 0.8726646259971648F, -0.3490658503988659F, 0.0F);
		this.tailThreadRtJointSitInfo = new PartInfo(tailThreadRtJoint);
		this.tailFlareShortRtJoint.setRotationPoint(-0.4F, -1.4F, 4.5F);
		this.setRotateAngle(tailFlareShortRtJoint, 0.8726646259971648F, -0.3490658503988659F, 0.0F);
		this.tailFlareShortRtJointSitInfo = new PartInfo(tailFlareShortRtJoint);
		this.tailFlareLongRtJoint.setRotationPoint(-0.6F, -1.2F, 4.5F);
		this.setRotateAngle(tailFlareLongRtJoint, 0.8726646259971648F, -0.3490658503988659F, 0.0F);
		this.tailFlareLongRtJointSitInfo = new PartInfo(tailFlareLongRtJoint);

		int tailNumber = 0;
		this.tailFlareLongLft[tailNumber] = new ModelRenderer(this, 36, 29); // tailFlareLongLft1
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailFlareLongLft[tailNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongLft[tailNumber], -0.4363323129985824F, 0.9599310885968813F, 0.0F);
		this.tailFlareLongLftInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber] = new ModelRenderer(this, 36, 26); // tailFlareLongLft2
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongLftInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber] = new ModelRenderer(this, 36, 23); // tailFlareLongLft3
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongLft[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongLftInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber] = new ModelRenderer(this, 36, 20); // tailFlareLongLft4
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongLft[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongLftInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber] = new ModelRenderer(this, 35, 17); // tailFlareLongLft5
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongLft[tailNumber].addBox(-1.0F, -0.5F, -0.2F, 2, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongLft[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongLftInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber] = new ModelRenderer(this, 36, 14); // tailFlareLongLft6
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongLftInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);

		tailNumber = 0;
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // tailFlareLongLft1
		this.setRotateAngle(tailFlareLongLft[tailNumber], 0.0F, 0.9599310885968813F, 0.0F);
		this.tailFlareLongLftSitInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongLft2
		this.setRotateAngle(tailFlareLongLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongLftSitInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongLft3
		this.setRotateAngle(tailFlareLongLft[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongLftSitInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongLft4
		this.setRotateAngle(tailFlareLongLft[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongLftSitInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongLft5
		this.setRotateAngle(tailFlareLongLft[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongLftSitInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);
		tailNumber++;
		this.tailFlareLongLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongLft6
		this.setRotateAngle(tailFlareLongLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongLftSitInfo[tailNumber] = new PartInfo(tailFlareLongLft[tailNumber]);

		tailNumber = 0;
		this.tailFlareShortLft[tailNumber] = new ModelRenderer(this, 30, 28); // tailFlareShortLft1
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailFlareShortLft[tailNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortLft[tailNumber], -0.2617993877991494F, 0.6108652381980153F, 0.0F);
		this.tailFlareShortLftInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber] = new ModelRenderer(this, 30, 25); // tailFlareShortLft2
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortLftInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber] = new ModelRenderer(this, 30, 22); // tailFlareShortLft3
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortLftInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber] = new ModelRenderer(this, 29, 19); // tailFlareShortLft4
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortLft[tailNumber].addBox(-1.0F, -0.5F, -0.2F, 2, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortLft[tailNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.tailFlareShortLftInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber] = new ModelRenderer(this, 30, 16); // tailFlareShortLft5
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortLftInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);

		tailNumber = 0;
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // tailFlareShortLft1
		this.setRotateAngle(tailFlareShortLft[tailNumber], 0.0F, 0.6108652381980153F, 0.0F);
		this.tailFlareShortLftSitInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortLft2
		this.setRotateAngle(tailFlareShortLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortLftSitInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortLft3
		this.setRotateAngle(tailFlareShortLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortLftSitInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortLft4
		this.setRotateAngle(tailFlareShortLft[tailNumber], -0.17453292519943295F, 0.0F, 0.0F);
		this.tailFlareShortLftSitInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);
		tailNumber++;
		this.tailFlareShortLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortLft5
		this.setRotateAngle(tailFlareShortLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortLftSitInfo[tailNumber] = new PartInfo(tailFlareShortLft[tailNumber]);

		tailNumber = 0;
		this.tailThreadLft[tailNumber] = new ModelRenderer(this, 24, 29); // tailThreadLft1
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailThreadLft[tailNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadLft[tailNumber], -0.4363323129985824F, 0.2617993877991494F, 0.0F);
		this.tailThreadLftInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber] = new ModelRenderer(this, 24, 26); // tailThreadLft2
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadLftInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber] = new ModelRenderer(this, 24, 23); // tailThreadLft3
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadLft[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailThreadLftInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber] = new ModelRenderer(this, 24, 20); // tailThreadLft4
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadLft[tailNumber], -0.08726646259971647F, 0.0F, 0.0F);
		this.tailThreadLftInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber] = new ModelRenderer(this, 24, 17); // tailThreadLft5
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadLftInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber] = new ModelRenderer(this, 24, 14); // tailThreadLft6
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadLft[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadLftInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);

		tailNumber = 0;
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // tailThreadLft1
		this.setRotateAngle(tailThreadLft[tailNumber], 0.0F, 0.2617993877991494F, 0.0F);
		this.tailThreadLftSitInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadLft2
		this.setRotateAngle(tailThreadLft[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadLftSitInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadLft3
		this.setRotateAngle(tailThreadLft[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailThreadLftSitInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadLft4
		this.setRotateAngle(tailThreadLft[tailNumber], 0.08726646259971647F, 0.0F, 0.0F);
		this.tailThreadLftSitInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadLft5
		this.setRotateAngle(tailThreadLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadLftSitInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);
		tailNumber++;
		this.tailThreadLft[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadLft6
		this.setRotateAngle(tailThreadLft[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadLftSitInfo[tailNumber] = new PartInfo(tailThreadLft[tailNumber]);

		tailNumber = 0;
		this.tailMid[tailNumber] = new ModelRenderer(this, 18, 28); // tailMid1
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailMid[tailNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMid[tailNumber], -0.6108652381980153F, 0.0F, 0.0F);
		this.tailMidInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber] = new ModelRenderer(this, 18, 25); // tailMid2
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailMid[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMid[tailNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailMidInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber] = new ModelRenderer(this, 18, 22); // tailMid3
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailMid[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMid[tailNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailMidInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber] = new ModelRenderer(this, 18, 19); // tailMid4
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailMid[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMid[tailNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailMidInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber] = new ModelRenderer(this, 18, 16); // tailMid5
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailMid[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMid[tailNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailMidInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber] = new ModelRenderer(this, 17, 13); // tailMid6
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailMid[tailNumber].addBox(-1.0F, -0.5F, -0.2F, 2, 1, 2, 0.0F);
		this.setRotateAngle(tailMid[tailNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailMidInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber] = new ModelRenderer(this, 18, 10); // tailMid7
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailMid[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMid[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailMidInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);

		tailNumber = 0;
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // tailMid1
		this.tailMidSitInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailMid2
		this.setRotateAngle(tailMid[tailNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.tailMidSitInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailMid3
		this.setRotateAngle(tailMid[tailNumber], 0.5235987755982988F, 0.0F, 0.0F);
		this.tailMidSitInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailMid4
		this.setRotateAngle(tailMid[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailMidSitInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailMid5
		this.setRotateAngle(tailMid[tailNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.tailMidSitInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailMid6
		this.setRotateAngle(tailMid[tailNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.tailMidSitInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);
		tailNumber++;
		this.tailMid[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailMid7
		this.setRotateAngle(tailMid[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailMidSitInfo[tailNumber] = new PartInfo(tailMid[tailNumber]);

		tailNumber = 0;
		this.tailMidTuff[tailNumber] = new ModelRenderer(this, 12, 10); // tailMidTuff1
		this.tailMidTuff[tailNumber].setRotationPoint(0.0F, -0.4F, 0.3F);
		this.tailMidTuff[tailNumber].addBox(-0.5F, -0.5F, -1.6F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMidTuff[tailNumber], -0.8726646259971648F, 0.0F, 0.0F);
		this.tailMidTuffInfo[tailNumber] = new PartInfo(tailMidTuff[tailNumber]);
		tailNumber++;
		this.tailMidTuff[tailNumber] = new ModelRenderer(this, 24, 10); // tailMidTuff2_1
		this.tailMidTuff[tailNumber].setRotationPoint(0.0F, -0.2F, 1.2F);
		this.tailMidTuff[tailNumber].addBox(-0.5F, -0.5F, -1.6F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMidTuff[tailNumber], -1.3089969389957472F, 0.0F, 0.0F);
		this.tailMidTuffInfo[tailNumber] = new PartInfo(tailMidTuff[tailNumber]);
		tailNumber++;
		this.tailMidTuff[tailNumber] = new ModelRenderer(this, 30, 10); // tailMidTuff2_2
		this.tailMidTuff[tailNumber].setRotationPoint(0.0F, 0.0F, -1.5F);
		this.tailMidTuff[tailNumber].addBox(-0.5F, -0.5F, -1.8F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailMidTuff[tailNumber], 0.3141592653589793F, 0.0F, 0.0F);
		this.tailMidTuffInfo[tailNumber] = new PartInfo(tailMidTuff[tailNumber]);

		tailNumber = 0;
		this.tailThreadRt[tailNumber] = new ModelRenderer(this, 12, 29); // tailThreadRt1
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailThreadRt[tailNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadRt[tailNumber], -0.4363323129985824F, -0.2617993877991494F, 0.0F);
		this.tailThreadRtInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber] = new ModelRenderer(this, 12, 26); // tailThreadRt2
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadRtInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber] = new ModelRenderer(this, 12, 23); // tailThreadRt3
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadRt[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailThreadRtInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber] = new ModelRenderer(this, 12, 20); // tailThreadRt4
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadRt[tailNumber], -0.08726646259971647F, 0.0F, 0.0F);
		this.tailThreadRtInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber] = new ModelRenderer(this, 12, 17); // tailThreadRt5
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadRtInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber] = new ModelRenderer(this, 12, 14); // tailThreadRt6
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailThreadRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailThreadRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadRtInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);

		tailNumber = 0;
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // tailThreadRt1
		this.setRotateAngle(tailThreadRt[tailNumber], 0.0F, -0.2617993877991494F, 0.0F);
		this.tailThreadRtSitInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadRt2
		this.setRotateAngle(tailThreadRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadRtSitInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadRt3
		this.setRotateAngle(tailThreadRt[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailThreadRtSitInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadRt4
		this.setRotateAngle(tailThreadRt[tailNumber], 0.08726646259971647F, 0.0F, 0.0F);
		this.tailThreadRtSitInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadRt5
		this.setRotateAngle(tailThreadRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadRtSitInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);
		tailNumber++;
		this.tailThreadRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailThreadRt6
		this.setRotateAngle(tailThreadRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailThreadRtSitInfo[tailNumber] = new PartInfo(tailThreadRt[tailNumber]);

		tailNumber = 0;
		this.tailFlareShortRt[tailNumber] = new ModelRenderer(this, 7, 28); // tailFlareShortRt1
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailFlareShortRt[tailNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortRt[tailNumber], -0.2617993877991494F, -0.6108652381980153F, 0.0F);
		this.tailFlareShortRtInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber] = new ModelRenderer(this, 7, 25); // tailFlareShortRt2
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortRtInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber] = new ModelRenderer(this, 7, 22); // tailFlareShortRt3
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortRtInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber] = new ModelRenderer(this, 6, 19); // tailFlareShortRt4
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortRt[tailNumber].addBox(-1.0F, -0.5F, -0.2F, 2, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortRt[tailNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.tailFlareShortRtInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber] = new ModelRenderer(this, 7, 16); // tailFlareShortRt5
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareShortRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareShortRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortRtInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);

		tailNumber = 0;
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // tailFlareShortRt1
		this.setRotateAngle(tailFlareShortRt[tailNumber], 0.0F, -0.6108652381980153F, 0.0F);
		this.tailFlareShortRtSitInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortRt2
		this.setRotateAngle(tailFlareShortRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortRtSitInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortRt3
		this.setRotateAngle(tailFlareShortRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortRtSitInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortRt4
		this.setRotateAngle(tailFlareShortRt[tailNumber], -0.17453292519943295F, 0.0F, 0.0F);
		this.tailFlareShortRtSitInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);
		tailNumber++;
		this.tailFlareShortRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareShortRt5
		this.setRotateAngle(tailFlareShortRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareShortRtSitInfo[tailNumber] = new PartInfo(tailFlareShortRt[tailNumber]);

		tailNumber = 0;
		this.tailFlareLongRt[tailNumber] = new ModelRenderer(this, 1, 29); // tailFlareLongRt1
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailFlareLongRt[tailNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongRt[tailNumber], -0.4363323129985824F, -0.9599310885968813F, 0.0F);
		this.tailFlareLongRtInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber] = new ModelRenderer(this, 1, 26); // tailFlareLongRt2
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongRtInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber] = new ModelRenderer(this, 1, 23); // tailFlareLongRt3
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongRt[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongRtInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber] = new ModelRenderer(this, 1, 20); // tailFlareLongRt4
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongRt[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongRtInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber] = new ModelRenderer(this, 0, 17); // tailFlareLongRt5
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongRt[tailNumber].addBox(-1.0F, -0.5F, -0.2F, 2, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongRt[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongRtInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber] = new ModelRenderer(this, 1, 14); // tailFlareLongRt6
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tailFlareLongRt[tailNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(tailFlareLongRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongRtInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);

		tailNumber = 0;
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 0.0F); // tailFlareLongRt1
		this.setRotateAngle(tailFlareLongRt[tailNumber], 0.0F, -0.9599310885968813F, 0.0F);
		this.tailFlareLongRtSitInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongRt2
		this.setRotateAngle(tailFlareLongRt[tailNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongRtSitInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongRt3
		this.setRotateAngle(tailFlareLongRt[tailNumber], 0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongRtSitInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongRt4
		this.setRotateAngle(tailFlareLongRt[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongRtSitInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongRt5
		this.setRotateAngle(tailFlareLongRt[tailNumber], -0.2617993877991494F, 0.0F, 0.0F);
		this.tailFlareLongRtSitInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);
		tailNumber++;
		this.tailFlareLongRt[tailNumber].setRotationPoint(0.0F, 0.0F, 1.7F); // tailFlareLongRt6
		this.setRotateAngle(tailFlareLongRt[tailNumber], -0.3490658503988659F, 0.0F, 0.0F);
		this.tailFlareLongRtSitInfo[tailNumber] = new PartInfo(tailFlareLongRt[tailNumber]);

		this.bodyJoint.addChild(this.body);

		this.body.addChild(this.legBckLft[0][0]);
		this.body.addChild(this.legBckRt[0][0]);
		this.body.addChild(this.legFntLft[0][0]);
		this.body.addChild(this.legFntRt[0][0]);

		this.body.addChild(this.neckJoint);

		this.body.addChild(this.tailFlareLongLftJoint);
		this.body.addChild(this.tailFlareLongRtJoint);
		this.body.addChild(this.tailFlareShortLftJoint);
		this.body.addChild(this.tailFlareShortRtJoint);
		this.body.addChild(this.tailMidJoint);
		this.body.addChild(this.tailThreadLftJoint);
		this.body.addChild(this.tailThreadRtJoint);

		this.neckJoint.addChild(this.neck);
		this.neck.addChild(this.headJoint);

		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earRtJoint);
		this.head.addChild(this.muzzle);
		this.headJoint.addChild(this.head);

		this.muzzle.addChild(this.whiskerLftBot);
		this.muzzle.addChild(this.whiskerLftTop);
		this.muzzle.addChild(this.whiskerRtBot);
		this.muzzle.addChild(this.whiskerRtTop);

		this.earLftJoint.addChild(this.earLft[0]);
		this.earRtJoint.addChild(this.earRt[0]);

		for(int i = 0; i < earLft.length - 1; i++)
		{
			this.earLft[i].addChild(earLft[i + 1]);
			this.earRt[i].addChild(earRt[i + 1]);
		}

		this.legFntLft[0][0].addChild(this.legFntLft[0][1]);
		this.legFntLft[0][1].addChild(this.legFntLft[1][0]);
		this.legFntLft[1][0].addChild(this.legFntLft[1][1]);

		this.legFntRt[0][0].addChild(this.legFntRt[0][1]);
		this.legFntRt[0][1].addChild(this.legFntRt[1][0]);
		this.legFntRt[1][0].addChild(this.legFntRt[1][1]);

		this.legBckLft[0][0].addChild(this.legBckLft[0][1]);
		this.legBckLft[0][1].addChild(this.legBckLft[1][0]);
		this.legBckLft[1][0].addChild(this.legBckLft[1][1]);
		this.legBckLft[1][1].addChild(this.legBckLft[2][0]);
		this.legBckLft[2][0].addChild(this.legBckLft[2][1]);

		this.legBckRt[0][0].addChild(this.legBckRt[0][1]);
		this.legBckRt[0][1].addChild(this.legBckRt[1][0]);
		this.legBckRt[1][0].addChild(this.legBckRt[1][1]);
		this.legBckRt[1][1].addChild(this.legBckRt[2][0]);
		this.legBckRt[2][0].addChild(this.legBckRt[2][1]);

		this.tailFlareLongLftJoint.addChild(this.tailFlareLongLft[0]);
		this.tailFlareShortLftJoint.addChild(this.tailFlareShortLft[0]);
		this.tailThreadLftJoint.addChild(this.tailThreadLft[0]);
		this.tailMidJoint.addChild(this.tailMid[0]);
		this.tailThreadRtJoint.addChild(this.tailThreadRt[0]);
		this.tailFlareShortRtJoint.addChild(this.tailFlareShortRt[0]);
		this.tailFlareLongRtJoint.addChild(this.tailFlareLongRt[0]);

		for(int i = 0; i < tailFlareLongLft.length - 1; i++)
		{
			this.tailFlareLongLft[i].addChild(this.tailFlareLongLft[i + 1]);
			this.tailFlareLongRt[i].addChild(this.tailFlareLongRt[i + 1]);
		}

		for(int i = 0; i < tailFlareShortLft.length - 1; i++)
		{
			this.tailFlareShortLft[i].addChild(this.tailFlareShortLft[i + 1]);
			this.tailFlareShortRt[i].addChild(this.tailFlareShortRt[i + 1]);
		}

		for(int i = 0; i < tailThreadLft.length - 1; i++)
		{
			this.tailThreadLft[i].addChild(this.tailThreadLft[i + 1]);
			this.tailThreadRt[i].addChild(this.tailThreadRt[i + 1]);
		}

		for(int i = 0; i < tailMid.length - 1; i++)
		{
			this.tailMid[i].addChild(this.tailMid[i + 1]);
		}

		this.tailMid[5].addChild(this.tailMidTuff[0]);
		this.tailMid[5].addChild(this.tailMidTuff[1]);
		this.tailMidTuff[1].addChild(this.tailMidTuff[2]);

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float ageInTicks, float netHeadYaw, float headPitch, float modelScale)
	{
		animate(entity, distanceMoved, horzVelocity, ageInTicks, netHeadYaw, headPitch, modelScale);

		this.bodyJoint.render(modelScale);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void animate(Entity entity, float distanceMoved, float horzVelocity, float ageInTicks, float netHeadYaw, float headPitch, float modelSize)
	{	
		this.animationDeployer.update((IAnimatedEntity)entity);
		resetPartInfos();

		float angularVelocity = ((IMobMotionTracker)entity).getAngularVelocity();
		float verticleVelocity = (float)((IMobMotionTracker)entity).getHeightVelocity();

		float idleDampener = 1F;

		if(!((EntitySmeetaLiepard)entity).isSitting())
		{
			if(animationDeployer.getEntity().getAnimationID() == LibrarySmeetaLiepardAttackID.POUNCE)
			{
				idleDampener = animatePounce(animationDeployer.getEntity(), distanceMoved, horzVelocity, ageInTicks, netHeadYaw, headPitch, modelSize);
			}
		}

		animateBody((EntitySmeetaLiepard)entity, distanceMoved, horzVelocity, ageInTicks, netHeadYaw, headPitch, modelSize, idleDampener, angularVelocity, verticleVelocity);
		animateHead((EntitySmeetaLiepard)entity, distanceMoved, horzVelocity, ageInTicks, netHeadYaw, headPitch, modelSize, idleDampener, verticleVelocity);
		animateLegs((EntitySmeetaLiepard)entity, distanceMoved, horzVelocity, ageInTicks, netHeadYaw, headPitch, modelSize, idleDampener, verticleVelocity);
		animateTail((EntitySmeetaLiepard)entity, distanceMoved, horzVelocity, ageInTicks, netHeadYaw, headPitch, modelSize, idleDampener, angularVelocity, verticleVelocity);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyJointInfo.resetNewAngles();

		bodyInfo.resetNewAngles();
		bodyInfo.resetNewPnt();

		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		earRtJointInfo.resetNewAngles();
		earLftJointInfo.resetNewAngles();

		for(int i = 0; i < earRtInfo.length; i++)
		{
			earRtInfo[i].resetNewAngles();
			earLftInfo[i].resetNewAngles();
		}

		for(int i = 0; i < legFntRtInfo.length; i++)
		{
			legFntRtInfo[i][0].resetNewAngles();
			legFntRtInfo[i][1].resetNewAngles();
			legFntLftInfo[i][0].resetNewAngles();
			legFntLftInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < legBckRtInfo.length; i++)
		{
			legBckRtInfo[i][0].resetNewAngles();
			legBckRtInfo[i][1].resetNewAngles();
			legBckLftInfo[i][0].resetNewAngles();
			legBckLftInfo[i][1].resetNewAngles();
		}

		tailFlareLongLftJointInfo.resetNewAngles();
		tailFlareShortLftJointInfo.resetNewAngles();
		tailThreadLftJointInfo.resetNewAngles();
		tailMidJointInfo.resetNewAngles();
		tailThreadRtJointInfo.resetNewAngles();
		tailFlareShortRtJointInfo.resetNewAngles();
		tailFlareLongRtJointInfo.resetNewAngles();

		for(int i = 0; i < tailFlareLongLftInfo.length; i++)
		{
			tailFlareLongLftInfo[i].resetNewAngles();
			tailFlareLongRtInfo[i].resetNewAngles();
		}

		for(int i = 0; i < tailFlareShortLftInfo.length; i++)
		{
			tailFlareShortLftInfo[i].resetNewAngles();
			tailFlareShortRtInfo[i].resetNewAngles();
		}

		for(int i = 0; i < tailThreadLftInfo.length; i++)
		{
			tailThreadLftInfo[i].resetNewAngles();
			tailThreadRtInfo[i].resetNewAngles();
		}

		for(int i = 0; i < tailMidInfo.length; i++)
		{
			tailMidInfo[i].resetNewAngles();
		}

		for(int i = 0; i < tailMidTuffInfo.length; i++)
		{
			tailMidTuffInfo[i].resetNewAngles();
		}
	}

	public float animatePounce(IAnimatedEntity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float idleDampener = 1F;

		float tick = animationDeployer.getEntity().getAnimationTick() + PokemonMDMain.proxy.getPartialTick();

		float firstPhaseEnd = 4;
		float secondPhaseEnd = 18;
		float endDuration = 20;

		if(tick < firstPhaseEnd && tick > 0)
		{
			idleDampener = (1F + (float)MathHelper.cos(PI*(tick/firstPhaseEnd)));
		}
		else if(tick < secondPhaseEnd)
		{
			idleDampener = 0;
		}
		else if(tick < endDuration)
		{
			idleDampener = (1F + (float)MathHelper.cos(PI + PI * ((tick - secondPhaseEnd)/(endDuration - secondPhaseEnd))));
		}

		Vector3f bodyJointAngleChanges = new Vector3f(0,0,0);
		Vector3f bodyJointPointChanges = new Vector3f(0,0,0);

		Vector3f neckJointAngleChanges = new Vector3f(0,0,0);

		Vector3f headJointAngleChanges = new Vector3f(0,0,0);

		Vector3f earsAngleChanges = new Vector3f(0,0,0);

		Vector3f legFntJointAngleChanges[] = new Vector3f[]{new Vector3f(0,0,0), new Vector3f(0,0,0)};
		Vector3f legBckJointAngleChanges[] = new Vector3f[]{new Vector3f(0,0,0), new Vector3f(0,0,0), new Vector3f(0,0,0)};

		Vector3f tailsAngleChanges = new Vector3f(0,0,0);

		/* *************************************/
		/* ******** Animation Timers ***********/
		/* *************************************/
		/* ******** First Phase Timers *********/
		float firstPhaseDurationStart = 0;
		float firstPhaseDurationEnd = firstPhaseEnd;
		float firstPhaseDuration = firstPhaseEnd;

		/* ******** Mid Phase Timers *********/
		float midPhaseDurationStart = firstPhaseEnd;
		float midPhaseDurationEnd = secondPhaseEnd;
		float midPhaseDuration = secondPhaseEnd - firstPhaseEnd;

		/* ******** End Phase Timers *********/
		float endPhaseDurationStart = secondPhaseEnd;
		float endPhaseDurationEnd = endDuration;
		float endPhaseDuration = endDuration - secondPhaseEnd;

		/* *************************************/
		/* ********** Phase Vectors ************/
		/* *************************************/
		/* ******* First Phase Vectors *********/
		/*Vector3f bodyFirstPhaseChanges = new Vector3f(
				(float)Math.toRadians(0),
				(float)Math.toRadians(45),
				(float)Math.toRadians(0));

		Vector3f bodyPntFirstPhaseChanges = new Vector3f(
				-3.5F,
				3.0F,
				0F);

		Vector3f neckJointFirstPhaseChanges = new Vector3f(
				(float)Math.toRadians(75),
				(float)Math.toRadians(0),
				(float)Math.toRadians(0));

		Vector3f neckFirstPhaseChanges = new Vector3f(
				(float)Math.toRadians(0),
				(float)Math.toRadians(45),
				(float)Math.toRadians(0));

		Vector3f headJointFirstPhaseChanges = new Vector3f(
				(float)Math.toRadians(35),
				(float)Math.toRadians(0),
				(float)Math.toRadians(0));

		Vector3f headFirstPhaseChanges = new Vector3f(
				(float)Math.toRadians(0),
				(float)Math.toRadians(20),
				(float)Math.toRadians(0));
		 */
		Vector3f legFntJointFirstPhaseChanges[] = new Vector3f[]{
				new Vector3f(
						(float)Math.toRadians(10),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0)),
				new Vector3f(
						(float)Math.toRadians(-10),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0))
		};

		Vector3f legBckJointFirstPhaseChanges[] = new Vector3f[]{
				new Vector3f(
						(float)Math.toRadians(-10),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0)),
				new Vector3f(
						(float)Math.toRadians(10),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0)),
				new Vector3f(
						(float)Math.toRadians(-10),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0))
		};

		/* ******* Mid Phase Vectors *********/
		Vector3f bodyJointMidPhaseChanges = new Vector3f(
				(float)Math.toRadians(360),
				(float)Math.toRadians(0),
				(float)Math.toRadians(0));
		/*
		Vector3f bodyPntMidPhaseChanges = new Vector3f(
				7.0F,
				0F,
				0F);
		 */
		Vector3f neckJointMidPhaseChanges = new Vector3f(
				(float)Math.toRadians(75),
				(float)Math.toRadians(0),
				(float)Math.toRadians(0));
		/*
		Vector3f neckMidPhaseChanges = new Vector3f(
				(float)Math.toRadians(0),
				(float)Math.toRadians(-90),
				(float)Math.toRadians(0));
		 */
		Vector3f headJointMidPhaseChanges = new Vector3f(
				(float)Math.toRadians(40),
				(float)Math.toRadians(0),
				(float)Math.toRadians(0));

		Vector3f earsMidPhaseChanges = new Vector3f(
				(float)Math.toRadians(0),
				(float)Math.toRadians(0),
				(float)Math.toRadians(23));

		Vector3f legFntJointMidPhaseChanges[] = new Vector3f[]{
				new Vector3f(
						(float)Math.toRadians(50),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0)),
				new Vector3f(
						(float)Math.toRadians(-100),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0))
		};

		Vector3f legBckJointMidPhaseChanges[] = new Vector3f[]{
				new Vector3f(
						(float)Math.toRadians(-40),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0)),
				new Vector3f(
						(float)Math.toRadians(60),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0)),
				new Vector3f(
						(float)Math.toRadians(-80),
						(float)Math.toRadians(0),
						(float)Math.toRadians(0))
		};

		Vector3f tailsMidPhaseChanges = new Vector3f(
				(float)Math.toRadians(-28),
				(float)Math.toRadians(0),
				(float)Math.toRadians(0));

		/* ******* End Phase Vectors *********/


		/* *************************************/
		/* ***** First Phase Animations ********/
		/* *************************************/
		float firstPhaseDurationCovered = PartAnimate.calculateDuration(tick, 0, firstPhaseDurationEnd);
		/*
		PartAnimate.changeOverDurationSCurve(bodyJointAngleChanges, bodyFirstPhaseChanges,
				firstPhaseDurationCovered);

		PartAnimate.changeOverDurationSCurve(bodyJointPointChanges, bodyPntFirstPhaseChanges,
				firstPhaseDurationCovered);

		PartAnimate.changeOverDurationSCurve(neckJointAngleChanges, neckJointFirstPhaseChanges,
				firstPhaseDurationCovered);

		PartAnimate.changeOverDurationSCurve(neckAngleChanges, neckFirstPhaseChanges,
				firstPhaseDurationCovered);

		PartAnimate.changeOverDurationSCurve(headJointAngleChanges, headJointFirstPhaseChanges,
				firstPhaseDurationCovered);

		PartAnimate.changeOverDurationSCurve(headAngleChanges, headFirstPhaseChanges,
				firstPhaseDurationCovered);
		 */
		for(int i = 0; i < legFntJointAngleChanges.length; i++)
		{
			PartAnimate.changeOverDurationSCurve(legFntJointAngleChanges[i], legFntJointFirstPhaseChanges[i],
					firstPhaseDurationCovered);
		}

		for(int i = 0; i < legBckJointAngleChanges.length; i++)
		{
			PartAnimate.changeOverDurationSCurve(legBckJointAngleChanges[i], legBckJointFirstPhaseChanges[i],
					firstPhaseDurationCovered);
		}

		/* *************************************/
		/* ******* Mid Phase Animations ********/
		/* *************************************/
		float midPhaseDurationCovered = PartAnimate.calculateDuration(tick, midPhaseDurationStart, midPhaseDurationEnd);

		PartAnimate.changeOverDurationSCurve(bodyJointAngleChanges, bodyJointMidPhaseChanges,
				midPhaseDurationCovered);
		/*
		PartAnimate.changeOverDurationSCurve(bodyJointPointChanges, bodyPntMidPhaseChanges,
				midPhaseDurationCovered);
		 */
		PartAnimate.changeOverDurationUCurve(neckJointAngleChanges, neckJointMidPhaseChanges,
				midPhaseDurationCovered);
		/*
		PartAnimate.changeOverDurationSCurve(neckAngleChanges, neckMidPhaseChanges,
				midPhaseDurationCovered);
		 */
		PartAnimate.changeOverDurationUCurve(headJointAngleChanges, headJointMidPhaseChanges,
				midPhaseDurationCovered);

		PartAnimate.changeOverDurationUCurve(earsAngleChanges, earsMidPhaseChanges,
				midPhaseDurationCovered);

		for(int i = 0; i < legFntJointAngleChanges.length; i++)
		{
			PartAnimate.changeOverDurationUCurve(legFntJointAngleChanges[i], legFntJointMidPhaseChanges[i],
					midPhaseDurationCovered);
		}

		for(int i = 0; i < legBckJointAngleChanges.length; i++)
		{
			PartAnimate.changeOverDurationUCurve(legBckJointAngleChanges[i], legBckJointMidPhaseChanges[i],
					midPhaseDurationCovered);
		}

		PartAnimate.changeOverDurationUCurve(tailsAngleChanges, tailsMidPhaseChanges,
				midPhaseDurationCovered);

		/* *************************************/
		/* ******* End Phase Animations ********/
		/* *************************************/
		float returnDampener = 1 - PartAnimate.calculateDuration(tick, midPhaseDurationEnd, endDuration);

		//bodyJointAngleChanges.multiplyVector(returnDampener);
		//bodyJointPointChanges.multiplyVector(returnDampener);

		neckJointAngleChanges.multiplyVector(returnDampener);

		headJointAngleChanges.multiplyVector(returnDampener);

		earsAngleChanges.multiplyVector(returnDampener);

		for(int i = 0; i < legFntJointAngleChanges.length; i++)
		{
			legFntJointAngleChanges[i].multiplyVector(returnDampener);
		}

		for(int i = 0; i < legBckJointAngleChanges.length; i++)
		{
			legBckJointAngleChanges[i].multiplyVector(returnDampener);
		}

		tailsAngleChanges.multiplyVector(returnDampener);

		/* *************************************/

		for(int i = 0; i < tailFlareLongLftInfo.length; i++)
		{
			tailFlareLongLftInfo[i].setNewRotateX(tailFlareLongLftInfo[i].getNewRotateX() * idleDampener);
			tailFlareLongRtInfo[i].setNewRotateX(tailFlareLongRtInfo[i].getNewRotateX() * idleDampener);

			PartAnimate.applyRotationChangeVectorToInfo(tailFlareLongLftInfo[i], tailsAngleChanges);
			PartAnimate.applyRotationChangeVectorToInfo(tailFlareLongRtInfo[i], tailsAngleChanges);
		}

		for(int i = 0; i < tailFlareShortLftInfo.length; i++)
		{
			tailFlareShortLftInfo[i].setNewRotateX(tailFlareShortLftInfo[i].getNewRotateX() * idleDampener);
			tailFlareShortRtInfo[i].setNewRotateX(tailFlareShortRtInfo[i].getNewRotateX() * idleDampener);

			PartAnimate.applyRotationChangeVectorToInfo(tailFlareShortLftInfo[i], tailsAngleChanges);
			PartAnimate.applyRotationChangeVectorToInfo(tailFlareShortRtInfo[i], tailsAngleChanges);
		}

		for(int i = 0; i < tailThreadLftInfo.length; i++)
		{
			tailThreadLftInfo[i].setNewRotateX(tailThreadLftInfo[i].getNewRotateX() * idleDampener);
			tailThreadRtInfo[i].setNewRotateX(tailThreadRtInfo[i].getNewRotateX() * idleDampener);

			PartAnimate.applyRotationChangeVectorToInfo(tailThreadLftInfo[i], tailsAngleChanges);
			PartAnimate.applyRotationChangeVectorToInfo(tailThreadRtInfo[i], tailsAngleChanges);
		}

		for(int i = 0; i < tailMidInfo.length; i++)
		{
			tailMidInfo[i].setNewRotateX(tailMidInfo[i].getNewRotateX() * idleDampener);

			PartAnimate.applyRotationChangeVectorToInfo(tailMidInfo[i], tailsAngleChanges);
		}

		PartAnimate.applyRotationChangeVectorToInfo(bodyJointInfo, bodyJointAngleChanges);
		//PartAnimate.applyPointChangeVectorToInfo(bodyJointInfo, bodyJointPointChanges);

		PartAnimate.applyRotationChangeVectorToInfo(neckJointInfo, neckJointAngleChanges);
		//PartAnimate.applyRotationChangeVectorToInfo(neckInfo, neckAngleChanges);

		PartAnimate.applyRotationChangeVectorToInfo(headJointInfo, headJointAngleChanges);
		//PartAnimate.applyRotationChangeVectorToInfo(headInfo, headAngleChanges);

		for(int i = 0; i < earLftInfo.length; i++)
		{
			PartAnimate.applyRotationChangeVectorToInfo(earRtInfo[i], Vector3f.negative(earsAngleChanges));
			PartAnimate.applyRotationChangeVectorToInfo(earLftInfo[i], earsAngleChanges);
		}

		for(int i = 0; i < legFntJointAngleChanges.length; i++)
		{
			PartAnimate.applyRotationChangeVectorToInfo(legFntRtInfo[i][0], legFntJointAngleChanges[i]);
			PartAnimate.applyRotationChangeVectorToInfo(legFntLftInfo[i][0], legFntJointAngleChanges[i]);
		}

		for(int i = 0; i < legBckJointAngleChanges.length; i++)
		{
			PartAnimate.applyRotationChangeVectorToInfo(legBckLftInfo[i][0], legBckJointAngleChanges[i]);
			PartAnimate.applyRotationChangeVectorToInfo(legBckRtInfo[i][0], legBckJointAngleChanges[i]);
		}

		//PartAnimate.applyRotationChangeVectorToInfo(legBckRtInfo[0][0], legBckRtJoint1AngleChanges);
		//PartAnimate.applyRotationChangeVectorToInfo(legBckLftInfo[0][0], legBckLftJoint1AngleChanges);

		//PartAnimate.applyRotationChangeVectorToInfo(legBckRtInfo[1][0], legBckJoints2_3AngleChanges);
		//PartAnimate.applyRotationChangeVectorToInfo(legBckLftInfo[1][0], legBckJoints2_3AngleChanges);
		//PartAnimate.applyRotationChangeVectorToInfo(legBckRtInfo[2][0], Vector3f.negative(legBckJoints2_3AngleChanges));
		//PartAnimate.applyRotationChangeVectorToInfo(legBckLftInfo[2][0], Vector3f.negative(legBckJoints2_3AngleChanges));

		//PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckJointInfo, yawHeadOffsetDifference, pitchRotation, (1F - idleDampener) * 1.2F, 0);

		return idleDampener;
	}

	public void animateBody(EntitySmeetaLiepard entity, float distanceMoved, float horzVelocity, float ageInTicks, float netHeadYaw, float headPitch, float modelSize, float idleDampener, float angularVelocity, float verticalVelocity)
	{
		float tempIdleDampener = 1F;

		if(entity.getAnimationID() == LibrarySmeetaLiepardAttackID.POUNCE)
		{
			tempIdleDampener = idleDampener;
		}

		if(!entity.isSitting())
		{
			float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
			float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

			float bodyWalkAngle = (float)Math.toRadians(10);
			float bodyRunAngle = (float)Math.toRadians(18);

			float walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI + PI/2) * bodyWalkAngle * (1 - horzVelocity);
			float runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI + PI/2) * bodyRunAngle * horzVelocity;

			float bodyJumpAngle = (float)Math.toRadians(-60);
			float verticalVelocityChangeAngle = (float)Math.toRadians(10);

			float newVerticalVelocity = 1.5F * verticalVelocity;

			float maximumChangeY = 1.0F;
			float runCyclePointChange = (MathHelper.cos(2F * runCycleInterval * PI + PI) * maximumChangeY + maximumChangeY) * horzVelocity;

			if(newVerticalVelocity > 1F)
				newVerticalVelocity = 1F;
			else if(newVerticalVelocity < -1F)
				newVerticalVelocity = -1F;

			bodyInfo.setNewPointY(bodyInfo.getNewPointY() + runCyclePointChange * horzVelocity * (1F - Math.abs(newVerticalVelocity)) * tempIdleDampener);

			bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
					+ bodyJumpAngle * newVerticalVelocity) * tempIdleDampener);
		}
		else
		{
			bodyInfo.setNewRotateX(bodySitInfo.getNewRotateX());
			bodyInfo.setNewPointY(bodySitInfo.getNewPointY());
		}
	}

	public void animateHead(EntitySmeetaLiepard entity, float distanceMoved, float horzVelocity, float ageInTicks, float netHeadYaw, float headPitch, float modelSize, float idleDampener, float verticalVelocity)
	{
		float tempIdleDampener = 1F;

		if(entity.getAnimationID() == LibrarySmeetaLiepardAttackID.POUNCE)
		{
			tempIdleDampener = idleDampener;
		}

		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, neckJointInfo, tempIdleDampener);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckInfo, netHeadYaw, headPitch, 0.2F * tempIdleDampener, 0.2F * tempIdleDampener);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBody();

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float fallingEarAngle = (float)Math.toRadians(10);

		float idleAmplitudeX = 0.1F;

		if(entity.isSitting())
		{
			idleAmplitudeX *= 0.5F;
		}
		else
		{
			float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
			float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

			float walkAngle = (float)Math.toRadians(4);
			float runAngle = (float)Math.toRadians(8);

			float walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity)
					+ walkAngle * (1 - horzVelocity);
			float runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI) * runAngle * horzVelocity
					+ runAngle * horzVelocity;

			neckInfo.setNewRotateX(neckInfo.getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocity * tempIdleDampener);

			/* ******************* */
			walkAngle = (float)Math.toRadians(2);
			runAngle = (float)Math.toRadians(4);

			walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity)
					+ walkAngle * (1 - horzVelocity);
			runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI) * runAngle * horzVelocity
					+ runAngle * horzVelocity;

			for(int i = 0; i < earLftInfo.length; i++)
			{
				earLftInfo[i].setNewRotateZ(earLftInfo[i].getNewRotateZ() + (((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity))
						+ fallingEarAngle * newVerticalVelocity)) * tempIdleDampener);
				earRtInfo[i].setNewRotateZ(earRtInfo[i].getNewRotateZ() - (((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity))
						+ fallingEarAngle * newVerticalVelocity)) * tempIdleDampener);
			}
		}

		float angleChangeX = -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX * tempIdleDampener);

		JointAnimation.reverseJointRotatesChangeWithIdleDampener(neckInfo, headJointInfo, tempIdleDampener);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, netHeadYaw, headPitch, 0.9F * tempIdleDampener, 0.9F * tempIdleDampener);

		/* *************** */
		float idleAmplitudeZ = 0.08F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ * (1 - horzVelocity);

		for(int i = 0; i < earLftInfo.length; i++)
		{
			earLftInfo[i].setNewRotateZ(earLftInfo[i].getNewRotateZ() + angleChangeZ * tempIdleDampener);
			earRtInfo[i].setNewRotateZ(earRtInfo[i].getNewRotateZ() - angleChangeZ * tempIdleDampener);
		}

		if(entity.isTamed())
		{
			for(int i = 0; i < earLftInfo.length; i++)
			{
				float healthChangeAngle = (float)Math.toRadians(-20);

				earLftInfo[i].setNewRotateZ(earLftInfo[i].getNewRotateZ() - (1F - entity.getHealthPercent()) * healthChangeAngle * tempIdleDampener);
				earRtInfo[i].setNewRotateZ(earRtInfo[i].getNewRotateZ() + (1F - entity.getHealthPercent()) * healthChangeAngle * tempIdleDampener);
			}
		}
	}

	public void animateLegs(EntitySmeetaLiepard entity, float distanceMoved, float horzVelocity, float ageInTicks, float netHeadYaw, float headPitch, float modelSize, float idleDampener, float verticalVelocity)
	{
		float tempIdleDampener = 1F;

		if(entity.getAnimationID() == LibrarySmeetaLiepardAttackID.POUNCE)
		{
			tempIdleDampener = idleDampener;
		}

		if(!entity.isSitting())
		{
			JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, legFntRtInfo[0][0], tempIdleDampener);
			JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, legFntLftInfo[0][0], tempIdleDampener);
			JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, legBckRtInfo[0][0], tempIdleDampener);
			JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, legBckLftInfo[0][0], tempIdleDampener);

			/* ******* Relative Angles/Absolute Commented Out ******* */
			float legFntWalkStartAngles[] = new float[2];

			legFntWalkStartAngles[0] = (float)Math.toRadians(45);
			legFntWalkStartAngles[1] = (float)Math.toRadians(-25);

			float legFntWalkAngles[][] = new float[2][4];

			// legFntWalkAngles[0][0] = (float)Math.toRadians(50);
			// legFntWalkAngles[0][1] = (float)Math.toRadians(40);
			// legFntWalkAngles[0][2] = (float)Math.toRadians(-20);
			// legFntWalkAngles[0][3] = (float)Math.toRadians(45);

			legFntWalkAngles[0][0] = (float)Math.toRadians(5);
			legFntWalkAngles[0][1] = (float)Math.toRadians(-10);
			legFntWalkAngles[0][2] = (float)Math.toRadians(-60);
			legFntWalkAngles[0][3] = (float)Math.toRadians(65);

			// legFntWalkAngles[1][0] = (float)Math.toRadians(-25);
			// legFntWalkAngles[1][1] = (float)Math.toRadians(-90);
			// legFntWalkAngles[1][2] = (float)Math.toRadians(-13);
			// legFntWalkAngles[1][3] = (float)Math.toRadians(-45);

			legFntWalkAngles[1][0] = (float)Math.toRadians(20);
			legFntWalkAngles[1][1] = (float)Math.toRadians(-75);
			legFntWalkAngles[1][2] = (float)Math.toRadians(77);
			legFntWalkAngles[1][3] = (float)Math.toRadians(-32);

			float legBckWalkStartAngles[] = new float[3];

			legBckWalkStartAngles[0] = (float)Math.toRadians(30);
			legBckWalkStartAngles[1] = (float)Math.toRadians(60);
			legBckWalkStartAngles[2] = (float)Math.toRadians(-30);

			float legBckWalkAngles[][] = new float[3][4];
			float tempAdjust = (float)Math.toRadians(5);

			// legBckWalkAngles[0][0] = (float)Math.toRadians(-30);
			// legBckWalkAngles[0][1] = (float)Math.toRadians(-20);
			// legBckWalkAngles[0][2] = (float)Math.toRadians(40);
			// legBckWalkAngles[0][3] = (float)Math.toRadians(20);

			legBckWalkAngles[0][0] = (float)Math.toRadians(-50);// - tempAdjust;
			legBckWalkAngles[0][1] = (float)Math.toRadians(10);// + tempAdjust;
			legBckWalkAngles[0][2] = (float)Math.toRadians(60);// + tempAdjust;
			legBckWalkAngles[0][3] = (float)Math.toRadians(-20);// - tempAdjust;

			// legBckWalkAngles[1][0] = (float)Math.toRadians(60);
			// legBckWalkAngles[1][1] = (float)Math.toRadians(55);
			// legBckWalkAngles[1][2] = (float)Math.toRadians(15);
			// legBckWalkAngles[1][3] = (float)Math.toRadians(65);

			legBckWalkAngles[1][0] = (float)Math.toRadians(-5) - tempAdjust;
			legBckWalkAngles[1][1] = (float)Math.toRadians(-5) - tempAdjust;
			legBckWalkAngles[1][2] = (float)Math.toRadians(-40) - tempAdjust;
			legBckWalkAngles[1][3] = (float)Math.toRadians(50) + tempAdjust;

			// legBckWalkAngles[2][0] = (float)Math.toRadians(-70);
			// legBckWalkAngles[2][1] = (float)Math.toRadians(-60);
			// legBckWalkAngles[2][2] = (float)Math.toRadians(-45);
			// legBckWalkAngles[2][3] = (float)Math.toRadians(-5);

			legBckWalkAngles[2][0] = (float)Math.toRadians(-65) - tempAdjust;
			legBckWalkAngles[2][1] = (float)Math.toRadians(10) + tempAdjust;
			legBckWalkAngles[2][2] = (float)Math.toRadians(15) + tempAdjust;
			legBckWalkAngles[2][3] = (float)Math.toRadians(40) + tempAdjust;

			float legFntRunStartAngles[] = new float[2];

			legFntRunStartAngles[0] = (float)Math.toRadians(35);
			legFntRunStartAngles[1] = (float)Math.toRadians(-5);

			float legFntRunAngles[][] = new float[2][4];

			// legFntRunAngles[0][0] = (float)Math.toRadians(75);
			// legFntRunAngles[0][1] = (float)Math.toRadians(20);
			// legFntRunAngles[0][2] = (float)Math.toRadians(-30);
			// legFntRunAngles[0][3] = (float)Math.toRadians(60);

			legFntRunAngles[0][0] = (float)Math.toRadians(15);
			legFntRunAngles[0][1] = (float)Math.toRadians(-55);
			legFntRunAngles[0][2] = (float)Math.toRadians(-50);
			legFntRunAngles[0][3] = (float)Math.toRadians(90);

			// legFntRunAngles[1][0] = (float)Math.toRadians(-40);
			// legFntRunAngles[1][1] = (float)Math.toRadians(-90);
			// legFntRunAngles[1][2] = (float)Math.toRadians(-25);
			// legFntRunAngles[1][3] = (float)Math.toRadians(-5);

			legFntRunAngles[1][0] = (float)Math.toRadians(-35);
			legFntRunAngles[1][1] = (float)Math.toRadians(-50);
			legFntRunAngles[1][2] = (float)Math.toRadians(65);
			legFntRunAngles[1][3] = (float)Math.toRadians(20);

			float legBckRunStartAngles[] = new float[3];

			legBckRunStartAngles[0] = (float)Math.toRadians(30);
			legBckRunStartAngles[1] = (float)Math.toRadians(60);
			legBckRunStartAngles[2] = (float)Math.toRadians(-30);

			float legBckRunAngles[][] = new float[3][4];
			tempAdjust = (float)Math.toRadians(5);
			// legBckRunAngles[0][0] = (float)Math.toRadians(-35);
			// legBckRunAngles[0][1] = (float)Math.toRadians(-65);
			// legBckRunAngles[0][2] = (float)Math.toRadians(10);
			// legBckRunAngles[0][3] = (float)Math.toRadians(40);

			legBckRunAngles[0][0] = (float)Math.toRadians(-75);// - tempAdjust;
			legBckRunAngles[0][1] = (float)Math.toRadians(-30);// - tempAdjust;
			legBckRunAngles[0][2] = (float)Math.toRadians(75);// + tempAdjust;
			legBckRunAngles[0][3] = (float)Math.toRadians(30);// + tempAdjust;

			// legBckRunAngles[1][0] = (float)Math.toRadians(110);
			// legBckRunAngles[1][1] = (float)Math.toRadians(55);
			// legBckRunAngles[1][2] = (float)Math.toRadians(65);
			// legBckRunAngles[1][3] = (float)Math.toRadians(75);

			legBckRunAngles[1][0] = (float)Math.toRadians(35) + tempAdjust;
			legBckRunAngles[1][1] = (float)Math.toRadians(-55) - tempAdjust;
			legBckRunAngles[1][2] = (float)Math.toRadians(10) + tempAdjust;
			legBckRunAngles[1][3] = (float)Math.toRadians(10) + tempAdjust;

			// legBckRunAngles[2][0] = (float)Math.toRadians(-85);
			// legBckRunAngles[2][1] = (float)Math.toRadians(-55);
			// legBckRunAngles[2][2] = (float)Math.toRadians(-70);
			// legBckRunAngles[2][3] = (float)Math.toRadians(-30);

			legBckRunAngles[2][0] = (float)Math.toRadians(-55) - tempAdjust;
			legBckRunAngles[2][1] = (float)Math.toRadians(30) + tempAdjust;
			legBckRunAngles[2][2] = (float)Math.toRadians(-15) - tempAdjust;
			legBckRunAngles[2][3] = (float)Math.toRadians(40) + tempAdjust;

			float walkRatio = 0;
			float runRatio = 0;

			if(horzVelocity > 0)
			{
				if(horzVelocity >= this.WALK_MAX)
				{
					runRatio = (horzVelocity - this.WALK_MAX) / (1F - this.WALK_MAX);
				}

				if(horzVelocity <= this.RUN_MIN)
				{
					walkRatio = 1F - ((this.RUN_MIN - horzVelocity) / this.RUN_MIN);
				}
			}

			float horzVelocityModifier = horzVelocity * 3F > 1F ?  1F : horzVelocity * 3F;

			float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
			float walkOppositeCycleInterval = ((WALK_FREQUENCY * distanceMoved + PI) % (2 * PI))/(2 * PI);
			float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
			float runOppositeCycleInterval = ((RUN_FREQUENCY * distanceMoved + (PI/3F)) % (2 * PI))/(2 * PI);

			float newVerticalVelocity = 2F * verticalVelocity;

			if(newVerticalVelocity > 1F)
				newVerticalVelocity = 1F;
			else if(newVerticalVelocity < -1F)
				newVerticalVelocity = -1F;

			for(int i = 0; i < legFntRt.length; i++)
			{
				float walkCycleAngleChange = 0;
				float runCycleAngleChange = 0;

				walkCycleAngleChange = calculateMoveLegAngleChange(walkCycleInterval, 
						legFntRtInfo[i][0].getNewRotateX(), legFntWalkStartAngles[i], legFntWalkAngles[i]) * walkRatio;

				runCycleAngleChange = calculateMoveLegAngleChange(runCycleInterval, 
						legFntRtInfo[i][0].getNewRotateX(), legFntRunStartAngles[i], legFntRunAngles[i]) * runRatio;

				legFntRtInfo[i][0].setNewRotateX((legFntRtInfo[i][0].getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocityModifier * (1F - Math.abs(newVerticalVelocity)) * tempIdleDampener));

				walkCycleAngleChange = calculateMoveLegAngleChange(walkOppositeCycleInterval, 
						legFntLftInfo[i][0].getNewRotateX(), legFntWalkStartAngles[i], legFntWalkAngles[i]) * walkRatio;

				runCycleAngleChange = calculateMoveLegAngleChange(runOppositeCycleInterval, 
						legFntLftInfo[i][0].getNewRotateX(), legFntRunStartAngles[i], legFntRunAngles[i]) * runRatio;

				legFntLftInfo[i][0].setNewRotateX((legFntLftInfo[i][0].getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocityModifier * (1F - Math.abs(newVerticalVelocity)) * tempIdleDampener));
			}

			for(int i = 0; i < legBckRt.length; i++)
			{
				float walkCycleAngleChange = 0;
				float runCycleAngleChange = 0;

				walkCycleAngleChange = calculateMoveLegAngleChange(walkCycleInterval, 
						legBckRtInfo[i][0].getNewRotateX(), legBckWalkStartAngles[i], legBckWalkAngles[i]) * walkRatio;

				runCycleAngleChange = calculateMoveLegAngleChange(runCycleInterval, 
						legBckRtInfo[i][0].getNewRotateX(), legBckRunStartAngles[i], legBckRunAngles[i]) * runRatio;

				legBckRtInfo[i][0].setNewRotateX((legBckRtInfo[i][0].getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocityModifier * (1F - Math.abs(newVerticalVelocity)) * tempIdleDampener));

				walkCycleAngleChange = calculateMoveLegAngleChange(walkOppositeCycleInterval, 
						legBckLftInfo[i][0].getNewRotateX(), legBckWalkStartAngles[i], legBckWalkAngles[i]) * walkRatio;

				runCycleAngleChange = calculateMoveLegAngleChange(runOppositeCycleInterval, 
						legBckLftInfo[i][0].getNewRotateX(), legBckRunStartAngles[i], legBckRunAngles[i]) * runRatio;

				legBckLftInfo[i][0].setNewRotateX((legBckLftInfo[i][0].getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocityModifier * (1F - Math.abs(newVerticalVelocity)) * tempIdleDampener));
			}

			float fallingModifier = 0;

			if(newVerticalVelocity < 0)
				fallingModifier = newVerticalVelocity;

			float fallingLegAngle = (float)Math.toRadians(25);

			legFntRtInfo[0][0].setNewRotateX(legFntRtInfo[0][0].getNewRotateX() + fallingLegAngle * fallingModifier * tempIdleDampener);
			legFntLftInfo[0][0].setNewRotateX(legFntLftInfo[0][0].getNewRotateX() + fallingLegAngle * fallingModifier * tempIdleDampener);
		}
		else
		{
			for(int i = 0; i < legFntRtInfo.length; i++)
			{
				legFntRtInfo[i][0].setNewRotatesWithVector(legFntRtSitInfo[i][0].getNewRotates());
				legFntRtInfo[i][1].setNewRotatesWithVector(legFntRtSitInfo[i][1].getNewRotates());
				legFntLftInfo[i][0].setNewRotatesWithVector(legFntLftSitInfo[i][0].getNewRotates());
				legFntLftInfo[i][1].setNewRotatesWithVector(legFntLftSitInfo[i][1].getNewRotates());
			}

			for(int i = 0; i < legBckRtInfo.length; i++)
			{
				legBckRtInfo[i][0].setNewRotatesWithVector(legBckRtSitInfo[i][0].getNewRotates());
				legBckRtInfo[i][1].setNewRotatesWithVector(legBckRtSitInfo[i][1].getNewRotates());
				legBckLftInfo[i][0].setNewRotatesWithVector(legBckLftSitInfo[i][0].getNewRotates());
				legBckLftInfo[i][1].setNewRotatesWithVector(legBckLftSitInfo[i][1].getNewRotates());
			}
		}
	}

	public float calculateMoveLegAngleChange(float cycleInterval, float standingLegAngle, 
			float startingRunLegAngle, float legAngleChange[])
	{
		float newAngle = 0;

		float angleChangeFromStarting = startingRunLegAngle - standingLegAngle;

		if(cycleInterval <= 0.25F && cycleInterval >= 0)
		{
			float subInterval = cycleInterval/0.25F;

			newAngle =  angleChangeFromStarting
					+ subInterval * legAngleChange[0];
		}
		else if(cycleInterval <= 0.5F)
		{
			float subInterval = (cycleInterval - 0.25F)/0.25F;

			newAngle = angleChangeFromStarting + legAngleChange[0]
					+ subInterval * legAngleChange[1];
		}
		else if(cycleInterval <= 0.75F)
		{
			float subInterval = (cycleInterval - 0.5F)/0.25F;

			newAngle = angleChangeFromStarting + legAngleChange[0] + legAngleChange[1]
					+ subInterval * legAngleChange[2];
		}
		else if(cycleInterval <= 1F)
		{
			float subInterval = (cycleInterval - 0.75F)/0.25F;

			newAngle = angleChangeFromStarting + legAngleChange[0] + legAngleChange[1] + legAngleChange[2]
					+ subInterval * legAngleChange[3];
		}

		return newAngle;
	}

	public void animateTail(EntitySmeetaLiepard entity, float distanceMoved, float horzVelocity, float ageInTicks, float netHeadYaw, float headPitch, float modelSize, float idleDampener, float angularVelocity, float verticalVelocity)
	{
		float tempIdleDampener = 1F;

		if(entity.getAnimationID() == LibrarySmeetaLiepardAttackID.POUNCE)
		{
			tempIdleDampener = idleDampener;
		}

		if(entity.isSitting())
		{
			tailMidJointInfo.setNewRotateX(tailMidJointSitInfo.getNewRotateX());

			tailThreadRtJointInfo.setNewRotateX(tailThreadRtJointSitInfo.getNewRotateX());
			tailThreadLftJointInfo.setNewRotateX(tailThreadLftJointSitInfo.getNewRotateX());

			tailFlareShortRtJointInfo.setNewRotateX(tailFlareShortRtJointSitInfo.getNewRotateX());
			tailFlareShortLftJointInfo.setNewRotateX(tailFlareShortLftJointSitInfo.getNewRotateX());

			tailFlareLongRtJointInfo.setNewRotateX(tailFlareLongRtJointSitInfo.getNewRotateX());
			tailFlareLongLftJointInfo.setNewRotateX(tailFlareLongLftJointSitInfo.getNewRotateX());
		}

		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, tailMidJointInfo, tempIdleDampener);

		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, tailThreadRtJointInfo, tempIdleDampener);
		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, tailThreadLftJointInfo, tempIdleDampener);

		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, tailFlareShortRtJointInfo, tempIdleDampener);
		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, tailFlareShortLftJointInfo, tempIdleDampener);

		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, tailFlareLongRtJointInfo, tempIdleDampener);
		JointAnimation.reverseJointRotatesChangeWithIdleDampener(bodyInfo, tailFlareLongLftJointInfo, tempIdleDampener);

		float yawChangeAngle = -(float)Math.toRadians(15);
		float verticalVelocityChangeAngle = (float)Math.toRadians(-6);

		float bodyJumpAngle = (float)Math.toRadians(-55);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float absoluteMoveVelocity = horzVelocity + Math.abs(newVerticalVelocity);

		if(absoluteMoveVelocity > 1F)
			absoluteMoveVelocity = 1F;

		tailMidJointInfo.setNewRotateX(tailMidJointInfo.getNewRotateX() + bodyJumpAngle * newVerticalVelocity * tempIdleDampener);

		tailThreadRtJointInfo.setNewRotateX(tailThreadRtJointInfo.getNewRotateX() + bodyJumpAngle * newVerticalVelocity * tempIdleDampener);
		tailThreadLftJointInfo.setNewRotateX(tailThreadLftJointInfo.getNewRotateX() + bodyJumpAngle * newVerticalVelocity * tempIdleDampener);

		for(int i = 0; i < tailMid.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			if(entity.isSitting())
			{
				tailMidInfo[i].setNewRotateX(tailMidSitInfo[i].getNewRotateX());
			}

			this.individualTailAnimation(entity, tailMidInfo[i], currentIdleAnimationClock,
					absoluteMoveVelocity, distanceMoved, horzVelocity, angularVelocity, newVerticalVelocity,
					verticalVelocityChangeAngle, yawChangeAngle, i, tailMid.length, 0F, false, tempIdleDampener);
		}

		for(int i = 0; i < tailThreadRt.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			if(entity.isSitting())
			{
				tailThreadRtInfo[i].setNewRotateX(tailThreadRtSitInfo[i].getNewRotateX());
				tailThreadLftInfo[i].setNewRotateX(tailThreadLftSitInfo[i].getNewRotateX());
			}

			this.individualTailAnimation(entity, tailThreadRtInfo[i], currentIdleAnimationClock,
					absoluteMoveVelocity, distanceMoved, horzVelocity, angularVelocity, newVerticalVelocity,
					verticalVelocityChangeAngle, yawChangeAngle, i, tailThreadRt.length, PI / 8F, true, tempIdleDampener);

			this.individualTailAnimation(entity, tailThreadLftInfo[i], currentIdleAnimationClock,
					absoluteMoveVelocity, distanceMoved, horzVelocity, angularVelocity, newVerticalVelocity,
					verticalVelocityChangeAngle, yawChangeAngle, i, tailThreadLft.length, -PI / 8F, true, tempIdleDampener);
		}

		for(int i = 0; i < tailFlareShortRt.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			if(entity.isSitting())
			{
				tailFlareShortRtInfo[i].setNewRotateX(tailFlareShortRtSitInfo[i].getNewRotateX());
				tailFlareShortLftInfo[i].setNewRotateX(tailFlareShortLftSitInfo[i].getNewRotateX());
			}

			this.individualTailAnimation(entity, tailFlareShortRtInfo[i], currentIdleAnimationClock,
					absoluteMoveVelocity, distanceMoved, horzVelocity, angularVelocity, newVerticalVelocity,
					verticalVelocityChangeAngle, yawChangeAngle, i, tailFlareShortRt.length, PI / 4F, false, tempIdleDampener);

			this.individualTailAnimation(entity, tailFlareShortLftInfo[i], currentIdleAnimationClock,
					absoluteMoveVelocity, distanceMoved, horzVelocity, angularVelocity, newVerticalVelocity,
					verticalVelocityChangeAngle, yawChangeAngle, i, tailFlareShortLft.length, -PI / 4F, false, tempIdleDampener);
		}

		for(int i = 0; i < tailFlareLongRt.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			if(entity.isSitting())
			{
				tailFlareLongRtInfo[i].setNewRotateX(tailFlareLongRtSitInfo[i].getNewRotateX());
				tailFlareLongLftInfo[i].setNewRotateX(tailFlareLongLftSitInfo[i].getNewRotateX());
			}

			this.individualTailAnimation(entity, tailFlareLongRtInfo[i], currentIdleAnimationClock,
					absoluteMoveVelocity, distanceMoved, horzVelocity, angularVelocity, newVerticalVelocity,
					verticalVelocityChangeAngle, yawChangeAngle, i, tailFlareLongRt.length, 3F * PI / 8F, true, tempIdleDampener);

			this.individualTailAnimation(entity, tailFlareLongLftInfo[i], currentIdleAnimationClock,
					absoluteMoveVelocity, distanceMoved, horzVelocity, angularVelocity, newVerticalVelocity,
					verticalVelocityChangeAngle, yawChangeAngle, i, tailFlareLongLft.length, -3F * PI / 8F, true, tempIdleDampener);
		}
	}

	public void individualTailAnimation(EntitySmeetaLiepard entity, PartInfo partInfo, IdleAnimationClock currentIdleAnimationClock,
			float absoluteMoveVelocity, float distanceMoved, float horzVelocity, float angularVelocity,
			float newVerticalVelocity, float verticalVelocityChangeAngle, float yawChangeAngle,
			int partNumber, int partArrayLength, float phaseOffset, boolean inverseXAnimation, float tempIdleDampener)
	{
		float healthChangeAngle = entity.isTamed() ? (float)Math.toRadians(-8) : 0;

		float idleAmplitudeX = 0.18F;
		float idleAmplitudeY = 0.08F;

		float moveAmplitudeX = (float)Math.toRadians(20);

		float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
		float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = 0;

		float acceleratedAbsoluteMoveVelocity = absoluteMoveVelocity * 1.75F;

		if(acceleratedAbsoluteMoveVelocity > 1F)
			acceleratedAbsoluteMoveVelocity = 1F;

		// Idle Animations
		angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 + phaseOffset) * idleAmplitudeX 
				* (1F - acceleratedAbsoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.5F) * (inverseXAnimation ? -1F : 1F);
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2 + phaseOffset) * idleAmplitudeY
				* (1F - acceleratedAbsoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.75F);

		// Movement Animations
		float walkCycleAngleChange = (PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - (2F * PI * ((float)partNumber / (float)(tailMid.length - 1))), absoluteMoveVelocity, WALK_FREQUENCY, moveAmplitudeX) * (1 - horzVelocity));
		float runCycleAngleChange = (PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - (2F * PI * ((float)partNumber / (float)(tailMid.length - 1))), absoluteMoveVelocity, RUN_FREQUENCY, moveAmplitudeX) * horzVelocity);

		angleChangeX += ((walkCycleAngleChange + runCycleAngleChange)) + newVerticalVelocity * (newVerticalVelocity < 0 ? verticalVelocityChangeAngle : verticalVelocityChangeAngle * 2.5F);
		angleChangeY += angularVelocity * yawChangeAngle;

		// Tamable Animation
		angleChangeX += (entity.isTamed() ? (1F - entity.getHealthPercent()) * healthChangeAngle : 0);

		// Part Number Dampener
		angleChangeX *= (1F - (Math.pow(Math.E, -0.95F * (float)(partNumber + 1))));
		angleChangeY *= (1F - (Math.pow(Math.E, -0.95F * (float)(partNumber + 1))));

		partInfo.setNewRotateX(partInfo.getNewRotateX() * (1F - (acceleratedAbsoluteMoveVelocity * tempIdleDampener)) + (angleChangeX * (entity.isSitting() ? 0.5F : 1.0F)) * tempIdleDampener);// - partInfo.getDefaultRotates().getX() * (1F - tempIdleDampener));
		partInfo.setNewRotateY(partInfo.getNewRotateY() + angleChangeY * (entity.isSitting() ? 0.5F : 1.0F) * tempIdleDampener);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(bodyJoint, bodyJointInfo.getNewRotates());

		this.animationDeployer.move(body, bodyInfo.getNewPnt());
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());

		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(earLftJoint, earLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(earRtJoint, earRtJointInfo.getNewRotates());

		for(int i = 0; i < earLftInfo.length; i++)
		{
			this.animationDeployer.rotate(earLft[i], earLftInfo[i].getNewRotates());
			this.animationDeployer.rotate(earRt[i], earRtInfo[i].getNewRotates());
		}

		for(int i = 0; i < legFntLftInfo.length; i++)
		{
			this.animationDeployer.rotate(legFntLft[i][0], legFntLftInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(legFntLft[i][1], legFntLftInfo[i][1].getNewRotates());
			this.animationDeployer.rotate(legFntRt[i][0], legFntRtInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(legFntRt[i][1], legFntRtInfo[i][1].getNewRotates());
		}

		for(int i = 0; i < legBckLftInfo.length; i++)
		{
			this.animationDeployer.rotate(legBckLft[i][0], legBckLftInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(legBckLft[i][1], legBckLftInfo[i][1].getNewRotates());
			this.animationDeployer.rotate(legBckRt[i][0], legBckRtInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(legBckRt[i][1], legBckRtInfo[i][1].getNewRotates());
		}

		this.animationDeployer.rotate(tailFlareLongLftJoint, tailFlareLongLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(tailFlareShortLftJoint, tailFlareShortLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(tailThreadLftJoint, tailThreadLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(tailMidJoint, tailMidJointInfo.getNewRotates());
		this.animationDeployer.rotate(tailThreadRtJoint, tailThreadRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(tailFlareShortRtJoint, tailFlareShortRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(tailFlareLongRtJoint, tailFlareLongRtJointInfo.getNewRotates());

		for(int i = 0; i < tailFlareLongLftInfo.length; i++)
		{
			this.animationDeployer.rotate(tailFlareLongLft[i], tailFlareLongLftInfo[i].getNewRotates());
			this.animationDeployer.rotate(tailFlareLongRt[i], tailFlareLongRtInfo[i].getNewRotates());
		}

		for(int i = 0; i < tailFlareShortLftInfo.length; i++)
		{
			this.animationDeployer.rotate(tailFlareShortLft[i], tailFlareShortLftInfo[i].getNewRotates());
			this.animationDeployer.rotate(tailFlareShortRt[i], tailFlareShortRtInfo[i].getNewRotates());
		}

		for(int i = 0; i < tailThreadLftInfo.length; i++)
		{
			this.animationDeployer.rotate(tailThreadLft[i], tailThreadLftInfo[i].getNewRotates());
			this.animationDeployer.rotate(tailThreadRt[i], tailThreadRtInfo[i].getNewRotates());
		}

		for(int i = 0; i < tailMidInfo.length; i++)
		{
			this.animationDeployer.rotate(tailMid[i], tailMidInfo[i].getNewRotates());
		}

		for(int i = 0; i < tailMidTuffInfo.length; i++)
		{
			this.animationDeployer.rotate(tailMidTuff[i], tailMidTuffInfo[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}