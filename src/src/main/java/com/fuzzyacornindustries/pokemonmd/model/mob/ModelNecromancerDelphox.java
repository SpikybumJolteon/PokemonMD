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
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityNecromancerDelphox;
import com.fuzzyacornindustries.pokemonmd.entity.mob.libraries.LibraryNecromancerDelphoxAttackID;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNecromancerDelphox extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public final float RUN_FREQUENCY = 0.7F;
	public final float WALK_FREQUENCY = 1.2F;
	public final float SNEAK_VELOCITY = 0.45F;

	public ModelRenderer bodyJoint;
	public ModelRenderer body;
	public PartInfo bodyJointInfo;
	public PartInfo bodyInfo;

	public ModelRenderer bodySkull;
	public ModelRenderer chestFurBot;
	public ModelRenderer chestFurLowRt;
	public ModelRenderer chestFurLowLft;
	public ModelRenderer chestFurMidRt;
	public ModelRenderer chestFurMidLft;
	public ModelRenderer chestFurTopLft;
	public ModelRenderer chestFurTopRt;
	public ModelRenderer chestFurTopMid;

	public ModelRenderer shoulderFur[][] = new ModelRenderer[6][2];
	public PartInfo shoulderFurInfo[][] = new PartInfo[shoulderFur.length][shoulderFur[0].length];

	public ModelRenderer legLftJoint;
	public ModelRenderer legLft;
	public ModelRenderer legRtJoint;
	public ModelRenderer legRt;
	public PartInfo legLftJointInfo;
	public PartInfo legLftInfo;
	public PartInfo legRtJointInfo;
	public PartInfo legRtInfo;

	public ModelRenderer bodySkirtFnt[] = new ModelRenderer[7];
	public ModelRenderer bodySkirtRt[] = new ModelRenderer[7];
	public ModelRenderer bodySkirtLft[] = new ModelRenderer[7];
	public ModelRenderer bodySkirtBck[] = new ModelRenderer[7];
	public PartInfo bodySkirtFntInfo[] = new PartInfo [bodySkirtFnt.length];
	public PartInfo bodySkirtRtInfo[] = new PartInfo [bodySkirtRt.length];
	public PartInfo bodySkirtLftInfo[] = new PartInfo [bodySkirtLft.length];
	public PartInfo bodySkirtBckInfo[] = new PartInfo [bodySkirtBck.length];

	public ModelRenderer shoulderLft;
	public ModelRenderer shoulderRt;

	public ModelRenderer armLftJoint;
	public ModelRenderer armLft;
	public ModelRenderer armLftForearmJoint;
	public ModelRenderer armLftForearm;
	public PartInfo armLftJointInfo;
	public PartInfo armLftInfo;
	public PartInfo armLftForearmJointInfo;
	public PartInfo armLftForearmInfo;

	public ModelRenderer armLftForearmFluff[] = new ModelRenderer[6];
	public PartInfo armLftForearmFluffInfo[] = new PartInfo[armLftForearmFluff.length];

	public ModelRenderer armRtJoint;
	public ModelRenderer armRt;
	public ModelRenderer armRtForearmJoint;
	public ModelRenderer armRtForearm;
	public PartInfo armRtJointInfo;
	public PartInfo armRtInfo;
	public PartInfo armRtForearmJointInfo;
	public PartInfo armRtForearmInfo;

	public ModelRenderer armRtForearmFluff[] = new ModelRenderer[6];
	public PartInfo armRtForearmFluffInfo[] = new PartInfo[armRtForearmFluff.length];

	public ModelRenderer staffJoint;
	public ModelRenderer staff;
	public PartInfo staffJointInfo;
	public PartInfo staffInfo;

	public ModelRenderer wingLftJoint;
	public PartInfo wingLftJointInfo;
	public ModelRenderer wingLft[] = new ModelRenderer[10];
	public PartInfo wingLftInfo[] = new PartInfo[wingLft.length];

	public ModelRenderer wingRtJoint;
	public PartInfo wingRtJointInfo;
	public ModelRenderer wingRt[] = new ModelRenderer[10];
	public PartInfo wingRtInfo[] = new PartInfo[wingRt.length];

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	public PartInfo neckJointInfo;
	public PartInfo neckInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	public PartInfo headJointInfo;
	public PartInfo headInfo;

	public ModelRenderer muzzle;
	public ModelRenderer headSkull;

	public ModelRenderer earLftJoint;
	public ModelRenderer earLft;
	public PartInfo earLftJointInfo;
	public PartInfo earLftInfo;

	public ModelRenderer earRtJoint;
	public ModelRenderer earRt;
	public PartInfo earRtJointInfo;
	public PartInfo earRtInfo;

	public ModelRenderer earTuff[][][] = new ModelRenderer[2][3][4];
	public PartInfo earTuffInfo[][][] = new PartInfo[earTuff.length][earTuff[0].length][earTuff[0][0].length];

	public ModelRenderer tail[][] = new ModelRenderer[10][2];
	public PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelNecromancerDelphox() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.bodyJoint = new ModelRenderer(this, 48, 0);
		this.bodyJoint.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.bodyJoint.addBox(-2.0F, -11.0F, -2.0F, 0, 0, 0, 0.0F);
		this.bodyJointInfo = new PartInfo(this.bodyJoint);
		this.body = new ModelRenderer(this, 48, 0);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-2.0F, -10.0F, -2.0F, 4, 11, 4, 0.0F);
		this.bodyInfo = new PartInfo(this.body);

		this.bodySkull = new ModelRenderer(this, 44, 0);
		this.bodySkull.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.bodySkull.addBox(-1.5F, -3.5F, -3.0F, 3, 3, 1, 0.0F);
		this.chestFurBot = new ModelRenderer(this, 26, 16);
		this.chestFurBot.setRotationPoint(0.0F, -5.5F, -2.0F);
		this.chestFurBot.addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(chestFurBot, -0.3490658503988659F, -0.0F, 0.0F);
		this.chestFurLowRt = new ModelRenderer(this, 30, 15);
		this.chestFurLowRt.setRotationPoint(-0.3F, -5.5F, -2.3F);
		this.chestFurLowRt.addBox(-0.5F, -0.5F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(chestFurLowRt, -0.5235987755982988F, -0.0F, 0.4363323129985824F);
		this.chestFurLowLft = new ModelRenderer(this, 30, 15);
		this.chestFurLowLft.setRotationPoint(0.3F, -5.5F, -2.3F);
		this.chestFurLowLft.addBox(-0.5F, -0.5F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(chestFurLowLft, -0.5235987755982988F, -0.0F, -0.4363323129985824F);
		this.chestFurMidRt = new ModelRenderer(this, 30, 15);
		this.chestFurMidRt.setRotationPoint(-1.0F, -6.5F, -2.0F);
		this.chestFurMidRt.addBox(-0.5F, -0.5F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(chestFurMidRt, -0.4363323129985824F, -0.0F, 0.7853981633974483F);
		this.chestFurMidLft = new ModelRenderer(this, 30, 15);
		this.chestFurMidLft.setRotationPoint(1.0F, -6.5F, -2.0F);
		this.chestFurMidLft.addBox(-0.5F, -0.5F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(chestFurMidLft, -0.4363323129985824F, -0.0F, -0.7853981633974483F);
		this.chestFurTopLft = new ModelRenderer(this, 33, 16);
		this.chestFurTopLft.setRotationPoint(0.5F, -8.5F, -2.0F);
		this.chestFurTopLft.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(chestFurTopLft, 0.08726646259971647F, -0.4363323129985824F, 0.0F);
		this.chestFurTopRt = new ModelRenderer(this, 33, 16);
		this.chestFurTopRt.setRotationPoint(-0.5F, -8.5F, -2.0F);
		this.chestFurTopRt.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(chestFurTopRt, 0.08726646259971647F, 0.4363323129985824F, 0.0F);
		this.chestFurTopMid = new ModelRenderer(this, 33, 16);
		this.chestFurTopMid.setRotationPoint(0.0F, -8.5F, -2.0F);
		this.chestFurTopMid.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
		this.setRotateAngle(chestFurTopMid, -0.3490658503988659F, -0.0F, 0.0F);

		int shoulderFurNumber = 0;
		int shoulderFurBaseNumber = 0;
		int shoulderFurTipNumber = 1;
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber] = new ModelRenderer(this, 0, 4); // shoulderFurRtFnt
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].setRotationPoint(-1.7F, -9.7F, -0.5F);
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].addBox(-1.2F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(shoulderFur[shoulderFurNumber][shoulderFurBaseNumber], -0.4410447019789671F, -0.5871287603708925F, 0.31607912753617307F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurBaseNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber]);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber] = new ModelRenderer(this, 6, 4); // shoulderFurRtFntTip
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].addBox(-1.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurTipNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber]);
		shoulderFurNumber++;
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber] = new ModelRenderer(this, 0, 4); // shoulderFurRtMid
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].setRotationPoint(-2.0F, -9.5F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].addBox(-1.5F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(shoulderFur[shoulderFurNumber][shoulderFurBaseNumber], 0.0F, -0.0F, 0.5235987755982988F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurBaseNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber]);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber] = new ModelRenderer(this, 10, 4); // shoulderFurRtMidTip
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurTipNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber]);
		shoulderFurNumber++;
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber] = new ModelRenderer(this, 0, 4); // shoulderFurRtBck
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].setRotationPoint(-1.7F, -9.7F, 0.5F);
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].addBox(-1.2F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(shoulderFur[shoulderFurNumber][shoulderFurBaseNumber], 0.4410447019789671F, 0.5871287603708925F, 0.31607912753617307F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurBaseNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber]);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber] = new ModelRenderer(this, 6, 4); // shoulderFurRtBckTip
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].addBox(-1.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurTipNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber]);
		shoulderFurNumber++;
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber] = new ModelRenderer(this, 13, 0); // shoulderFurLftFnt
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].setRotationPoint(1.7F, -9.7F, -0.5F);
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].addBox(-0.8F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(shoulderFur[shoulderFurNumber][shoulderFurBaseNumber], -0.4410447019789671F, 0.5871287603708925F, -0.31607912753617307F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurBaseNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber]);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber] = new ModelRenderer(this, 11, 0); // shoulderFurLftFntTip
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].setRotationPoint(1.0F, 0.0F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].addBox(0.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurTipNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber]);
		shoulderFurNumber++;
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber] = new ModelRenderer(this, 13, 0); // shoulderFurLftMid
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].setRotationPoint(2.0F, -9.5F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].addBox(-0.5F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(shoulderFur[shoulderFurNumber][shoulderFurBaseNumber], 0.0F, 0.0F, -0.5235987755982988F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurBaseNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber]);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber] = new ModelRenderer(this, 15, 3); // shoulderFurLftMidTip
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].setRotationPoint(1.0F, 0.0F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].addBox(0.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurTipNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber]);
		shoulderFurNumber++;
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber] = new ModelRenderer(this, 13, 0); // shoulderFurLftBck
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].setRotationPoint(1.7F, -9.7F, 0.5F);
		this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber].addBox(-0.8F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(shoulderFur[shoulderFurNumber][shoulderFurBaseNumber], 0.4410447019789671F, -0.5871287603708925F, -0.31607912753617307F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurBaseNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurBaseNumber]);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber] = new ModelRenderer(this, 11, 0); // shoulderFurLftBckTip
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].setRotationPoint(1.0F, 0.0F, 0.0F);
		this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber].addBox(0.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.shoulderFurInfo[shoulderFurNumber][shoulderFurTipNumber] = new PartInfo(this.shoulderFur[shoulderFurNumber][shoulderFurTipNumber]);

		this.legRtJoint = new ModelRenderer(this, 36, 47);
		this.legRtJoint.setRotationPoint(-0.9F, 0.5F, 0.0F);
		this.legRtJoint.addBox(-1.0F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legRtJoint, -0.2617993877991494F, 0.0F, 0.0F);
		this.legRtJointInfo = new PartInfo(this.legRtJoint);
		this.legRt = new ModelRenderer(this, 36, 47);
		this.legRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legRt.addBox(-1.0F, -0.5F, -1.0F, 2, 6, 2, 0.0F);
		this.legRt.setTextureOffset(36, 55).addBox(-1.0F, 3.5F, 1.0F, 2, 6, 2, 0.0F); // legRtHind
		this.legRtInfo = new PartInfo(this.legRt);
		this.legLftJoint = new ModelRenderer(this, 36, 47);
		this.legLftJoint.setRotationPoint(0.9F, 0.5F, 0.1F);
		this.legLftJoint.addBox(-1.0F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legLftJoint, -0.2617993877991494F, 0.0F, 0.0F);
		this.legLftJointInfo = new PartInfo(this.legLftJoint);
		this.legLft = new ModelRenderer(this, 36, 47);
		this.legLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legLft.addBox(-1.0F, -0.5F, -1.0F, 2, 6, 2, 0.0F);
		this.legLft.setTextureOffset(36, 55).addBox(-1.0F, 3.5F, 1.0F, 2, 6, 2, 0.0F); // legLftHind
		this.legLftInfo = new PartInfo(this.legLft);

		int bodySkirtPartNumber = 0;
		this.bodySkirtFnt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 7); // bodySkirtFnt1
		this.bodySkirtFnt[bodySkirtPartNumber].setRotationPoint(0.0F, 0.5F, -1.5F);
		this.bodySkirtFnt[bodySkirtPartNumber].addBox(-2.01F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
		this.setRotateAngle(bodySkirtFnt[bodySkirtPartNumber], -0.3490658503988659F, -0.0F, 0.0F);
		this.bodySkirtFntInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtFnt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtFnt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 11); // bodySkirtFnt2
		this.bodySkirtFnt[bodySkirtPartNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.bodySkirtFnt[bodySkirtPartNumber].addBox(-2.5F, 0.0F, -1.0F, 5, 2, 2, 0.0F);
		this.bodySkirtFntInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtFnt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtFnt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 15); // bodySkirtFnt3
		this.bodySkirtFnt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtFnt[bodySkirtPartNumber].addBox(-3.0F, 0.0F, -1.0F, 6, 2, 2, 0.0F);
		this.bodySkirtFntInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtFnt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtFnt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 19); // bodySkirtFnt4
		this.bodySkirtFnt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtFnt[bodySkirtPartNumber].addBox(-3.5F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
		this.bodySkirtFntInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtFnt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtFnt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 23); // bodySkirtFnt5
		this.bodySkirtFnt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtFnt[bodySkirtPartNumber].addBox(-4.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
		this.bodySkirtFntInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtFnt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtFnt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 27); // bodySkirtFnt6
		this.bodySkirtFnt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtFnt[bodySkirtPartNumber].addBox(-4.5F, 0.0F, -1.0F, 9, 2, 2, 0.0F);
		this.bodySkirtFntInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtFnt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtFnt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 31); // bodySkirtFnt7
		this.bodySkirtFnt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtFnt[bodySkirtPartNumber].addBox(-5.0F, 0.0F, -1.0F, 10, 2, 2, 0.0F);
		this.bodySkirtFntInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtFnt[bodySkirtPartNumber]);

		bodySkirtPartNumber = 0;
		this.bodySkirtRt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 35); // bodySkirtRt1
		this.bodySkirtRt[bodySkirtPartNumber].setRotationPoint(-1.5F, 0.5F, 0.0F);
		this.bodySkirtRt[bodySkirtPartNumber].addBox(-1.99F, -1.5F, -1.0F, 4, 3, 2, 0.0F);
		this.setRotateAngle(bodySkirtRt[bodySkirtPartNumber], -0.3490658503988659F, 1.5707963267948966F, 0.0F);
		this.bodySkirtRtInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtRt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtRt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 40); // bodySkirtRt2
		this.bodySkirtRt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.0F, 0.0F);
		this.bodySkirtRt[bodySkirtPartNumber].addBox(-2.5F, 0.0F, -1.0F, 5, 2, 2, 0.0F);
		this.bodySkirtRtInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtRt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtRt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 44); // bodySkirtRt3
		this.bodySkirtRt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtRt[bodySkirtPartNumber].addBox(-3.0F, 0.0F, -1.0F, 6, 2, 2, 0.0F);
		this.bodySkirtRtInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtRt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtRt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 48); // bodySkirtRt4
		this.bodySkirtRt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtRt[bodySkirtPartNumber].addBox(-3.5F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
		this.bodySkirtRtInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtRt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtRt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 52); // bodySkirtRt5
		this.bodySkirtRt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtRt[bodySkirtPartNumber].addBox(-4.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
		this.bodySkirtRtInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtRt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtRt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 56); // bodySkirtRt6
		this.bodySkirtRt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtRt[bodySkirtPartNumber].addBox(-4.5F, 0.0F, -1.0F, 9, 2, 2, 0.0F);
		this.bodySkirtRtInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtRt[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtRt[bodySkirtPartNumber] = new ModelRenderer(this, 0, 60); // bodySkirtRt7
		this.bodySkirtRt[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtRt[bodySkirtPartNumber].addBox(-5.0F, 0.0F, -1.0F, 10, 2, 2, 0.0F);
		this.bodySkirtRtInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtRt[bodySkirtPartNumber]);

		bodySkirtPartNumber = 0;
		this.bodySkirtLft[bodySkirtPartNumber] = new ModelRenderer(this, 0, 35); // bodySkirtLft1
		this.bodySkirtLft[bodySkirtPartNumber].setRotationPoint(1.5F, 0.5F, 0.0F);
		this.bodySkirtLft[bodySkirtPartNumber].addBox(-2.0F, -1.5F, -1.0F, 4, 3, 2, 0.0F);
		this.setRotateAngle(bodySkirtLft[bodySkirtPartNumber], -0.3490658503988659F, -1.5707963267948966F, 0.0F);
		this.bodySkirtLftInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtLft[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtLft[bodySkirtPartNumber] = new ModelRenderer(this, 0, 40); // bodySkirtLft2
		this.bodySkirtLft[bodySkirtPartNumber].setRotationPoint(0.0F, 1.0F, 0.0F);
		this.bodySkirtLft[bodySkirtPartNumber].addBox(-2.5F, 0.0F, -1.0F, 5, 2, 2, 0.0F);
		this.bodySkirtLftInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtLft[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtLft[bodySkirtPartNumber] = new ModelRenderer(this, 0, 44); // bodySkirtLft3
		this.bodySkirtLft[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtLft[bodySkirtPartNumber].addBox(-3.0F, 0.0F, -1.0F, 6, 2, 2, 0.0F);
		this.bodySkirtLftInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtLft[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtLft[bodySkirtPartNumber] = new ModelRenderer(this, 0, 48); // bodySkirtLft4
		this.bodySkirtLft[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtLft[bodySkirtPartNumber].addBox(-3.5F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
		this.bodySkirtLftInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtLft[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtLft[bodySkirtPartNumber] = new ModelRenderer(this, 0, 52); // bodySkirtLft5
		this.bodySkirtLft[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtLft[bodySkirtPartNumber].addBox(-4.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
		this.bodySkirtLftInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtLft[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtLft[bodySkirtPartNumber] = new ModelRenderer(this, 0, 56); // bodySkirtLft6
		this.bodySkirtLft[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtLft[bodySkirtPartNumber].addBox(-4.5F, 0.0F, -1.0F, 9, 2, 2, 0.0F);
		this.bodySkirtLftInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtLft[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtLft[bodySkirtPartNumber] = new ModelRenderer(this, 0, 60); // bodySkirtLft7
		this.bodySkirtLft[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtLft[bodySkirtPartNumber].addBox(-5.0F, 0.0F, -1.0F, 10, 2, 2, 0.0F);
		this.bodySkirtLftInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtLft[bodySkirtPartNumber]);

		bodySkirtPartNumber = 0;
		this.bodySkirtBck[bodySkirtPartNumber] = new ModelRenderer(this, 0, 7); // bodySkirtBck1
		this.bodySkirtBck[bodySkirtPartNumber].setRotationPoint(0.0F, 0.5F, 1.5F);
		this.bodySkirtBck[bodySkirtPartNumber].addBox(-2.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
		this.setRotateAngle(bodySkirtBck[bodySkirtPartNumber], 0.4363323129985824F, 0.0F, 0.0F);
		this.bodySkirtBckInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtBck[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtBck[bodySkirtPartNumber] = new ModelRenderer(this, 0, 11); // bodySkirtBck2
		this.bodySkirtBck[bodySkirtPartNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.bodySkirtBck[bodySkirtPartNumber].addBox(-2.5F, 0.0F, -1.0F, 5, 2, 2, 0.0F);
		this.bodySkirtBckInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtBck[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtBck[bodySkirtPartNumber] = new ModelRenderer(this, 0, 15); // bodySkirtBck3
		this.bodySkirtBck[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtBck[bodySkirtPartNumber].addBox(-3.0F, 0.0F, -1.0F, 6, 2, 2, 0.0F);
		this.bodySkirtBckInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtBck[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtBck[bodySkirtPartNumber] = new ModelRenderer(this, 0, 19); // bodySkirtBck4
		this.bodySkirtBck[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtBck[bodySkirtPartNumber].addBox(-3.5F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
		this.bodySkirtBckInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtBck[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtBck[bodySkirtPartNumber] = new ModelRenderer(this, 0, 23); // bodySkirtBck5
		this.bodySkirtBck[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtBck[bodySkirtPartNumber].addBox(-4.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
		this.bodySkirtBckInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtBck[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtBck[bodySkirtPartNumber] = new ModelRenderer(this, 0, 27); // bodySkirtBck6
		this.bodySkirtBck[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtBck[bodySkirtPartNumber].addBox(-4.5F, 0.0F, -1.0F, 9, 2, 2, 0.0F);
		this.bodySkirtBckInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtBck[bodySkirtPartNumber]);
		bodySkirtPartNumber++;
		this.bodySkirtBck[bodySkirtPartNumber] = new ModelRenderer(this, 0, 31); // bodySkirtBck7
		this.bodySkirtBck[bodySkirtPartNumber].setRotationPoint(0.0F, 1.5F, 0.0F);
		this.bodySkirtBck[bodySkirtPartNumber].addBox(-5.0F, 0.0F, -1.0F, 10, 2, 2, 0.0F);
		this.bodySkirtBckInfo[bodySkirtPartNumber] = new PartInfo(this.bodySkirtBck[bodySkirtPartNumber]);

		this.shoulderLft = new ModelRenderer(this, 0, 0);
		this.shoulderLft.setRotationPoint(2.0F, -8.5F, 0.0F);
		this.shoulderLft.addBox(-0.5F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.shoulderRt = new ModelRenderer(this, 0, 0);
		this.shoulderRt.setRotationPoint(-2.0F, -8.5F, 0.0F);
		this.shoulderRt.addBox(-1.5F, -1.0F, -1.0F, 2, 2, 2, 0.0F);

		this.armLftJoint = new ModelRenderer(this, 48, 28);
		this.armLftJoint.setRotationPoint(1.0F, 0.0F, 0.0F);
		this.armLftJoint.addBox(-0.5F, -1.0F, -5.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftJoint, 0.9599310885968813F, -0.8726646259971648F, 0.0F);
		this.armLftJointInfo = new PartInfo(this.armLftJoint);
		this.armLft = new ModelRenderer(this, 48, 28);
		this.armLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLft.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 6, 0.0F);
		this.armLftInfo = new PartInfo(this.armLft);
		this.armLftForearmJoint = new ModelRenderer(this, 36, 22);
		this.armLftForearmJoint.setRotationPoint(0.0F, 0.0F, -4.5F);
		this.armLftForearmJoint.addBox(-1.0F, -1.0F, -6.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftForearmJoint, -0.8726646259971648F, 0.0F, 0.0F);
		this.armLftForearmJointInfo = new PartInfo(this.armLftForearmJoint);
		this.armLftForearm = new ModelRenderer(this, 36, 22);
		this.armLftForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftForearm.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
		this.setRotateAngle(armLftForearm, 0.0F, 0.5235987755982988F, 0.0F);
		this.armLftForearmInfo = new PartInfo(this.armLftForearm);

		int forearmFluffNumber = 0;
		this.armLftForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 52, 22); // armLftForearmFluff1
		this.armLftForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -5.0F);
		this.armLftForearmFluff[forearmFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(armLftForearmFluff[forearmFluffNumber], 0.0F, -0.0F, -0.08726646259971647F);
		this.armLftForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armLftForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armLftForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 56, 21); // armLftForearmFluff2
		this.armLftForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -4.2F);
		this.armLftForearmFluff[forearmFluffNumber].addBox(-0.51F, -0.5F, -0.5F, 1, 6, 1, 0.0F);
		this.setRotateAngle(armLftForearmFluff[forearmFluffNumber], 0.0F, -0.0F, -0.08726646259971647F);
		this.armLftForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armLftForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armLftForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 60, 26); // armLftForearmFluff3
		this.armLftForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -3.5F);
		this.armLftForearmFluff[forearmFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(armLftForearmFluff[forearmFluffNumber], 0.0F, -0.0F, -0.08726646259971647F);
		this.armLftForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armLftForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armLftForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 56, 36); // armLftForearmFluff4
		this.armLftForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -2.7F);
		this.armLftForearmFluff[forearmFluffNumber].addBox(-0.51F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(armLftForearmFluff[forearmFluffNumber], 0.0F, -0.0F, -0.08726646259971647F);
		this.armLftForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armLftForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armLftForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 60, 36); // armLftForearmFluff5
		this.armLftForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -1.9F);
		this.armLftForearmFluff[forearmFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(armLftForearmFluff[forearmFluffNumber], 0.0F, -0.0F, -0.08726646259971647F);
		this.armLftForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armLftForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armLftForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 50, 30); // armLftForearmFluff6
		this.armLftForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -1.2F);
		this.armLftForearmFluff[forearmFluffNumber].addBox(-0.51F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(armLftForearmFluff[forearmFluffNumber], 0.0F, -0.0F, -0.08726646259971647F);
		this.armLftForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armLftForearmFluff[forearmFluffNumber]);

		this.armRtJoint = new ModelRenderer(this, 48, 28);
		this.armRtJoint.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.armRtJoint.addBox(-1.0F, -1.0F, -5.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtJoint, (float)Math.toRadians(40), (float)Math.toRadians(80), 0.0F);
		this.armRtJointInfo = new PartInfo(this.armRtJoint);
		this.armRt = new ModelRenderer(this, 48, 28);
		this.armRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRt.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 6, 0.0F);
		this.armRtInfo = new PartInfo(this.armRt);
		this.armRtForearmJoint = new ModelRenderer(this, 36, 22);
		this.armRtForearmJoint.setRotationPoint(0.0F, 0.0F, -4.5F);
		this.armRtForearmJoint.addBox(-1.0F, -1.0F, -6.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtForearmJoint, (float)Math.toRadians(-20), 0.0F, 0.0F);
		this.armRtForearmJointInfo = new PartInfo(this.armRtForearmJoint);
		this.armRtForearm = new ModelRenderer(this, 36, 22);
		this.armRtForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtForearm.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
		this.setRotateAngle(armRtForearm, 0.0F, -0.5235987755982988F, 0.0F);
		this.armRtForearmInfo = new PartInfo(this.armRtForearm);

		forearmFluffNumber = 0;
		this.armRtForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 52, 22); // armRtForearmFluff1
		this.armRtForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -5.0F);
		this.armRtForearmFluff[forearmFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 5, 1, 0.0F);
		this.armRtForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armRtForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armRtForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 56, 21); // armRtForearmFluff2
		this.armRtForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -4.2F);
		this.armRtForearmFluff[forearmFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 6, 1, 0.0F);
		this.armRtForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armRtForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armRtForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 60, 26); // armRtForearmFluff3
		this.armRtForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -3.5F);
		this.armRtForearmFluff[forearmFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 7, 1, 0.0F);
		this.armRtForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armRtForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armRtForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 56, 36); // armRtForearmFluff4
		this.armRtForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -2.7F);
		this.armRtForearmFluff[forearmFluffNumber].addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
		this.armRtForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armRtForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armRtForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 60, 36); // armRtForearmFluff5
		this.armRtForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -1.9F);
		this.armRtForearmFluff[forearmFluffNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.armRtForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armRtForearmFluff[forearmFluffNumber]);
		forearmFluffNumber++;
		this.armRtForearmFluff[forearmFluffNumber] = new ModelRenderer(this, 50, 30); // armRtForearmFluff6
		this.armRtForearmFluff[forearmFluffNumber].setRotationPoint(0.0F, 0.5F, -1.2F);
		this.armRtForearmFluff[forearmFluffNumber].addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		this.armRtForearmFluffInfo[forearmFluffNumber] = new PartInfo(this.armRtForearmFluff[forearmFluffNumber]);

		this.staffJoint = new ModelRenderer(this, 48, 16);
		this.staffJoint.setRotationPoint(0.0F, 0.0F, -6.0F);
		this.staffJoint.addBox(-0.5F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(staffJoint, (float)Math.toRadians(50), (float)Math.toRadians(-15), 0.0F);
		this.staffJointInfo = new PartInfo(this.staffJoint);
		this.staff = new ModelRenderer(this, 48, 16);
		this.staff.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.staff.addBox(-0.5F, -2.0F, -0.5F, 1, 11, 1, 0.0F);
		this.staff.setTextureOffset(34, 22).addBox(-1.0F, -4.0F, -1.0F, 2, 2, 2, 0.0F); // staffJewel
		this.staff.setTextureOffset(36, 16).addBox(-1.5F, -7.0F, -1.0F, 3, 3, 3, 0.0F); // staffSkullBase
		this.staff.setTextureOffset(28, 9).addBox(-2.5F, -8.0F, -2.01F, 5, 5, 1, 0.0F); // staffSkullFace
		this.staff.setTextureOffset(30, 20).addBox(-1.0F, 8.5F, 0.0F, 2, 2, 1, 0.0F); // staffBotTip
		this.staffInfo = new PartInfo(this.staff);

		int wingNumber = 0;
		this.wingLftJoint = new ModelRenderer(this, 50, 57);
		this.wingLftJoint.setRotationPoint(1.2F, -7.5F, 1.5F);
		this.wingLftJoint.addBox(-0.5F, -4.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(wingLftJoint, -1.5707963267948966F, 1.2217304763960306F, 0.0F);
		this.wingLftJointInfo = new PartInfo(this.wingLftJoint);
		this.wingLft[wingNumber] = new ModelRenderer(this, 50, 57); // wingLft1
		this.wingLft[wingNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingLft[wingNumber].addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 56, 49); // wingLft2
		this.wingLft[wingNumber].setRotationPoint(0.0F, -3.7F, 0.0F);
		this.wingLft[wingNumber].addBox(-0.5F, -11.8F, -0.5F, 1, 12, 1, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], 0.08726646259971647F, 0.0F, 0.3490658503988659F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 60, 41); // wingLft3
		this.wingLft[wingNumber].setRotationPoint(0.0F, -11.6F, 0.0F);
		this.wingLft[wingNumber].addBox(-0.5F, -19.7F, -0.5F, 1, 20, 1, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], 1.3962634015954636F, 0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 46, 54); // wingLft4
		this.wingLft[wingNumber].setRotationPoint(0.0F, -19.4F, 0.0F);
		this.wingLft[wingNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 8, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], -0.08726646259971647F, 0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 34, 34); // wingLft5
		this.wingLft[wingNumber].setRotationPoint(0.0F, 0.0F, 7.6F);
		this.wingLft[wingNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 12, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 28, 47); // wingLft6
		this.wingLft[wingNumber].setRotationPoint(0.0F, 0.0F, 11.5F);
		this.wingLft[wingNumber].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 16, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 46, 47); // wingLftSubFnt1
		this.wingLft[wingNumber].setRotationPoint(0.0F, 0.3F, 7.2F);
		this.wingLft[wingNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 50, 47); // wingLftSubFnt2
		this.wingLft[wingNumber].setRotationPoint(0.0F, 6.3F, 0.0F);
		this.wingLft[wingNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 48, 36); // wingLftSubBck1
		this.wingLft[wingNumber].setRotationPoint(0.0F, 0.3F, 0.5F);
		this.wingLft[wingNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 9, 1, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], 1.3089969389957472F, -0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);
		wingNumber++;
		this.wingLft[wingNumber] = new ModelRenderer(this, 52, 36); // wingLftSubBck2
		this.wingLft[wingNumber].setRotationPoint(0.0F, 8.2F, 0.0F);
		this.wingLft[wingNumber].addBox(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
		this.setRotateAngle(wingLft[wingNumber], -0.4363323129985824F, -0.0F, 0.0F);
		this.wingLftInfo[wingNumber] = new PartInfo(this.wingLft[wingNumber]);

		wingNumber = 0;
		this.wingRtJoint = new ModelRenderer(this, 50, 57);
		this.wingRtJoint.setRotationPoint(-1.2F, -7.5F, 1.5F);
		this.wingRtJoint.addBox(-0.5F, -4.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(wingRtJoint, -1.5707963267948966F, -1.2217304763960306F, 0.0F);
		this.wingRtJointInfo = new PartInfo(this.wingRtJoint);
		this.wingRt[wingNumber] = new ModelRenderer(this, 50, 57); // wingRt1
		this.wingRt[wingNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingRt[wingNumber].addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 56, 49); // wingRt2
		this.wingRt[wingNumber].setRotationPoint(0.0F, -3.7F, 0.0F);
		this.wingRt[wingNumber].addBox(-0.5F, -11.8F, -0.5F, 1, 12, 1, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], 0.08726646259971647F, -0.0F, -0.3490658503988659F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 60, 41); // wingRt3
		this.wingRt[wingNumber].setRotationPoint(0.0F, -11.6F, 0.0F);
		this.wingRt[wingNumber].addBox(-0.5F, -19.7F, -0.5F, 1, 20, 1, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], 1.3962634015954636F, 0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 46, 54); // wingRt4
		this.wingRt[wingNumber].setRotationPoint(0.0F, -19.4F, 0.0F);
		this.wingRt[wingNumber].addBox(-0.5F, -0.5F, -0.3F, 1, 1, 8, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], -0.08726646259971647F, 0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 34, 34); // wingRt5
		this.wingRt[wingNumber].setRotationPoint(0.0F, 0.0F, 7.6F);
		this.wingRt[wingNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 12, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], -0.5235987755982988F, -0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 28, 47); // wingRt6
		this.wingRt[wingNumber].setRotationPoint(0.0F, 0.0F, 11.5F);
		this.wingRt[wingNumber].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 16, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], -0.4363323129985824F, 0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 46, 47); // wingRtSubFnt1
		this.wingRt[wingNumber].setRotationPoint(0.0F, 0.3F, 7.2F);
		this.wingRt[wingNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], 0.3490658503988659F, 0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 50, 47); // wingRtSubFnt2
		this.wingRt[wingNumber].setRotationPoint(0.0F, 6.3F, 0.0F);
		this.wingRt[wingNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], -0.5235987755982988F, 0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 48, 36); // wingRtSubBck1
		this.wingRt[wingNumber].setRotationPoint(0.0F, 0.3F, 0.5F);
		this.wingRt[wingNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 9, 1, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], 1.3089969389957472F, -0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);
		wingNumber++;
		this.wingRt[wingNumber] = new ModelRenderer(this, 52, 36); // wingRtSubBck2
		this.wingRt[wingNumber].setRotationPoint(0.0F, 8.2F, 0.0F);
		this.wingRt[wingNumber].addBox(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
		this.setRotateAngle(wingRt[wingNumber], -0.4363323129985824F, -0.0F, 0.0F);
		this.wingRtInfo[wingNumber] = new PartInfo(this.wingRt[wingNumber]);

		this.neckJoint = new ModelRenderer(this, 56, 15);
		this.neckJoint.setRotationPoint(0.0F, -9.0F, 0.0F);
		this.neckJoint.addBox(-1.0F, -3.5F, -1.0F, 0, 0, 0, 0.0F);
		this.neckJointInfo = new PartInfo(this.neckJoint);
		this.neck = new ModelRenderer(this, 56, 15);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-1.0F, -3.5F, -1.0F, 2, 4, 2, 0.0F);
		this.neckInfo = new PartInfo(this.neck);

		this.headJoint = new ModelRenderer(this, 32, 0);
		this.headJoint.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.headJoint.addBox(-2.0F, -3.0F, -2.0F, 0, 0, 0, 0.0F);
		this.headJointInfo = new PartInfo(this.headJoint);
		this.head = new ModelRenderer(this, 32, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -3.0F, -2.0F, 4, 4, 4, 0.0F);
		this.headInfo = new PartInfo(this.head);

		this.muzzle = new ModelRenderer(this, 44, 8);
		this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muzzle.addBox(-0.5F, -1.0F, -2.8F, 1, 1, 1, 0.0F);
		this.setRotateAngle(muzzle, 0.17453292519943295F, -0.0F, 0.0F);
		this.headSkull = new ModelRenderer(this, 24, 0);
		this.headSkull.setRotationPoint(-1.5F, -2.5F, -1.5F);
		this.headSkull.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3, 0.0F);
		this.setRotateAngle(headSkull, 1.1526154380170552F, -0.0F, -0.40893064374227134F);
		this.headSkull.setTextureOffset(35, 10).addBox(-2.0F, -1.1F, -3.0F, 4, 1, 5, 0.0F); // headSkullFace

		this.earLftJoint = new ModelRenderer(this, 24, 5);
		this.earLftJoint.setRotationPoint(1.5F, -3.0F, 0.0F);
		this.earLftJoint.addBox(-1.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLftJoint, 0.0F, -0.0F, 0.3490658503988659F);
		this.earLftJointInfo = new PartInfo(this.earLftJoint);
		this.earLft = new ModelRenderer(this, 24, 5);
		this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft.addBox(-1.0F, -2.0F, -0.5F, 3, 3, 1, 0.0F);
		this.earLft.setTextureOffset(22, 11).addBox(-0.5F, 1.0F, -0.5F, 2, 1, 1, 0.0F); // earLftLow
		this.earLft.setTextureOffset(21, 0).addBox(-0.5F, -4.0F, -0.5F, 2, 2, 1, 0.0F); // earLftMid
		this.earLft.setTextureOffset(24, 9).addBox(0.0F, -5.0F, -0.5F, 1, 1, 1, 0.0F); // earLftTip
		this.earLftInfo = new PartInfo(this.earLft);

		this.earRtJoint = new ModelRenderer(this, 24, 5);
		this.earRtJoint.setRotationPoint(-1.5F, -3.0F, 0.0F);
		this.earRtJoint.addBox(-2.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRtJoint, 0.0F, 0.0F, -0.3490658503988659F);
		this.earRtJointInfo = new PartInfo(this.earRtJoint);
		this.earRt = new ModelRenderer(this, 24, 5);
		this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt.addBox(-2.0F, -2.0F, -0.5F, 3, 3, 1, 0.0F);
		this.earRt.setTextureOffset(22, 11).addBox(-1.5F, 1.0F, -0.5F, 2, 1, 1, 0.0F); // earRtLow
		this.earRt.setTextureOffset(21, 0).addBox(-1.5F, -4.0F, -0.5F, 2, 2, 1, 0.0F); // earRtMid
		this.earRt.setTextureOffset(24, 9).addBox(-1.0F, -5.0F, -0.5F, 1, 1, 1, 0.0F); // earRtTip
		this.earRtInfo = new PartInfo(this.earRt);

		int earTuffLft = 0;
		int earTuffNumber = 0;
		int earTuffPart = 0;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 20, 6); // earTuffLftTop
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(2.0F, -2.5F, -0.5F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(earTuff[earTuffLft][earTuffNumber][earTuffPart], 0.0F, -0.0F, -0.7853981633974483F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 18, 5); // earTuffLftTopMid
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(0.4F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.2F, -1.5F, -0.51F, 2, 3, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 12, 10); // earTuffLftTopEnd
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(1.5F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.1F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 15, 13); // earTuffLftTopTip
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(1.8F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.1F, -0.5F, -0.49F, 1, 1, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);

		earTuffNumber++;
		earTuffPart = 0;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 18, 6); // earTuffLftMid
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(2.0F, -2.5F, -1.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(earTuff[earTuffLft][earTuffNumber][earTuffPart], 0.0F, 0.0F, -0.17453292519943295F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 16, 5); // earTuffLftMidMid
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(0.4F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.2F, -1.5F, -0.51F, 3, 3, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 12, 10); // earTuffLftMidEnd
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(2.5F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.1F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 15, 13); // earTuffLftMidTip
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(1.8F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.1F, -0.5F, -0.49F, 1, 1, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);

		earTuffNumber++;
		earTuffPart = 0;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 16, 6); // earTuffLftBot
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(2.0F, -2.2F, -0.7F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(0.0F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(earTuff[earTuffLft][earTuffNumber][earTuffPart], 0.0F, 0.0F, 0.3490658503988659F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 16, 5); // earTuffLftBotMid
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(0.6F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(0.2F, -1.5F, -0.51F, 2, 3, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 18, 9); // earTuffLftBotEnd
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(2.0F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.1F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart] = new ModelRenderer(this, 15, 13); // earTuffLftBotTip
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].setRotationPoint(0.8F, 0.0F, 0.0F);
		this.earTuff[earTuffLft][earTuffNumber][earTuffPart].addBox(-0.1F, -0.5F, -0.49F, 1, 1, 1, 0.0F);
		this.earTuffInfo[earTuffLft][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffLft][earTuffNumber][earTuffPart]);

		int earTuffRt = 1;
		earTuffNumber = 0;
		earTuffPart = 0;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 19, 5); // earTuffRtTop
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-2.0F, -2.5F, -0.5F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(earTuff[earTuffRt][earTuffNumber][earTuffPart], 0.0F, 0.0F, 0.7853981633974483F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 18, 5); // earTuffRtTopMid
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-0.4F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-1.8F, -1.5F, -0.51F, 2, 3, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 10, 6); // earTuffRtTopEnd
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-1.9F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 21, 3); // earTuffRtTopTip
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-1.8F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-0.9F, -0.5F, -0.49F, 1, 1, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);

		earTuffNumber++;
		earTuffPart = 0;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 19, 5); // earTuffRtMid
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-2.0F, -2.5F, -1.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(earTuff[earTuffRt][earTuffNumber][earTuffPart], 0.0F, 0.0F, 0.17453292519943295F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 16, 5); // earTuffRtMidMid
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-0.4F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-2.7F, -1.5F, -0.51F, 3, 3, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 10, 6); // earTuffRtMidEnd
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-2.5F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-1.6F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 21, 3); // earTuffRtMidTip
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-1.3F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-1.1F, -0.5F, -0.49F, 1, 1, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);

		earTuffNumber++;
		earTuffPart = 0;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 16, 6); // earTuffRtBot
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-2.0F, -2.2F, -0.7F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-1.0F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(earTuff[earTuffRt][earTuffNumber][earTuffPart], 0.0F, 0.0F, -0.3490658503988659F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 17, 5); // earTuffRtBotMid
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-0.6F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-2.2F, -1.5F, -0.51F, 2, 3, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 24, 13); // earTuffRtBotEnd
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-2.0F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-0.9F, -1.0F, -0.5F, 1, 2, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);
		earTuffPart++;
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart] = new ModelRenderer(this, 21, 3); // earTuffRtBotTip
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].setRotationPoint(-0.8F, 0.0F, 0.0F);
		this.earTuff[earTuffRt][earTuffNumber][earTuffPart].addBox(-0.9F, -0.5F, -0.49F, 1, 1, 1, 0.0F);
		this.earTuffInfo[earTuffRt][earTuffNumber][earTuffPart] = new PartInfo(this.earTuff[earTuffRt][earTuffNumber][earTuffPart]);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 16, 13); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, -1.0F, 1.5F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 16, 13); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 18, 18); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.2F);
		this.tail[tailNumber][jointNumber].addBox(-1.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 18, 18); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.5F, -1.5F, -0.5F, 3, 3, 2, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 22, 23); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.tail[tailNumber][jointNumber].addBox(-2.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 22, 23); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.0F, -2.0F, -0.5F, 4, 4, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 30); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
		this.tail[tailNumber][jointNumber].addBox(-2.5F, -2.5F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 30); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.5F, -2.5F, -0.5F, 5, 5, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 30, 38); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
		this.tail[tailNumber][jointNumber].addBox(-2.5F, -2.5F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 30, 38); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.5F, -2.5F, -0.5F, 5, 5, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 14, 38); // tail6Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.8F);
		this.tail[tailNumber][jointNumber].addBox(-2.5F, -2.5F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 14, 38); // tail6
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.5F, -2.5F, -0.5F, 5, 5, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 22, 46); // tail7Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.1F);
		this.tail[tailNumber][jointNumber].addBox(-2.0F, -2.0F, -0.6F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 22, 46); // tail7
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-2.0F, -2.0F, -0.6F, 4, 4, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 26, 53); // tail8Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.1F);
		this.tail[tailNumber][jointNumber].addBox(-1.5F, -1.5F, -0.6F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 26, 53); // tail8
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.5F, -1.5F, -0.6F, 3, 3, 2, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 28, 58); // tail9Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.tail[tailNumber][jointNumber].addBox(-1.0F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 28, 58); // tail9
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 2, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 24, 60); // tail10Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, 0.0F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 24, 60); // tail10
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);

		this.armLft.addChild(this.armLftForearmJoint);

		for(int i = 0; i < armLftForearmFluff.length; i++)
		{
			this.armLftForearm.addChild(this.armLftForearmFluff[i]);
			this.armRtForearm.addChild(this.armRtForearmFluff[i]);
		}

		this.armLftForearmJoint.addChild(this.armLftForearm);
		this.armLftJoint.addChild(this.armLft);
		this.armRt.addChild(this.armRtForearmJoint);

		this.armRtForearm.addChild(this.staffJoint);
		this.armRtForearmJoint.addChild(this.armRtForearm);
		this.armRtJoint.addChild(this.armRt);

		this.body.addChild(this.bodySkull);
		this.body.addChild(this.chestFurBot);
		this.body.addChild(this.chestFurLowLft);
		this.body.addChild(this.chestFurLowRt);
		this.body.addChild(this.chestFurMidLft);
		this.body.addChild(this.chestFurMidRt);
		this.body.addChild(this.chestFurTopLft);
		this.body.addChild(this.chestFurTopMid);
		this.body.addChild(this.chestFurTopRt);
		this.body.addChild(this.neckJoint);

		for(int i = 0; i < shoulderFur.length; i++)
		{
			this.body.addChild(this.shoulderFur[i][0]);
			this.shoulderFur[i][0].addChild(this.shoulderFur[i][1]);
		}

		this.body.addChild(this.shoulderLft);
		this.body.addChild(this.shoulderRt);
		this.body.addChild(this.tail[0][0]);
		this.body.addChild(this.wingLftJoint);
		this.body.addChild(this.wingRtJoint);
		this.bodyJoint.addChild(this.body);

		this.bodyJoint.addChild(this.bodySkirtBck[0]);
		this.bodyJoint.addChild(this.bodySkirtFnt[0]);
		this.bodyJoint.addChild(this.bodySkirtLft[0]);
		this.bodyJoint.addChild(this.bodySkirtRt[0]);

		for(int i = 0; i < bodySkirtBck.length - 1; i++)
		{
			this.bodySkirtBck[i].addChild(this.bodySkirtBck[i + 1]);
			this.bodySkirtFnt[i].addChild(this.bodySkirtFnt[i + 1]);
			this.bodySkirtRt[i].addChild(this.bodySkirtRt[i + 1]);
			this.bodySkirtLft[i].addChild(this.bodySkirtLft[i + 1]);
		}

		this.bodyJoint.addChild(this.legRtJoint);
		this.bodyJoint.addChild(this.legLftJoint);
		this.legRtJoint.addChild(this.legRt);
		this.legLftJoint.addChild(this.legLft);

		this.earLftJoint.addChild(this.earLft);
		this.earRtJoint.addChild(this.earRt);

		for(int i = 0; i < earTuff.length; i++)
		{
			for(int j = 0; j < earTuff[i].length; j++)
			{
				this.head.addChild(this.earTuff[i][j][0]);

				for(int k = 0; k < earTuff[i][j].length - 1; k++)
				{
					this.earTuff[i][j][k].addChild(this.earTuff[i][j][k + 1]);
				}
			}
		}

		this.head.addChild(this.earLftJoint);
		this.head.addChild(this.earRtJoint);
		this.head.addChild(this.headSkull);
		this.head.addChild(this.muzzle);
		this.headJoint.addChild(this.head);
		this.neck.addChild(this.headJoint);
		this.neckJoint.addChild(this.neck);

		this.shoulderLft.addChild(this.armLftJoint);
		this.shoulderRt.addChild(this.armRtJoint);
		this.staffJoint.addChild(this.staff);

		for(int i = 0; i < tail.length - 1; i++)
		{
			this.tail[i][0].addChild(this.tail[i][1]);
			this.tail[i][1].addChild(this.tail[i + 1][0]);
		}

		this.tail[tail.length - 1][0].addChild(this.tail[tail.length- 1][1]);

		this.wingLftJoint.addChild(this.wingLft[0]);
		this.wingRtJoint.addChild(this.wingRt[0]);

		for(int i = 0; i < wingLft.length - 5; i++)
		{
			this.wingLft[i].addChild(this.wingLft[i + 1]);
			this.wingRt[i].addChild(this.wingRt[i + 1]);
		}

		this.wingLft[3].addChild(this.wingLft[6]);
		this.wingLft[6].addChild(this.wingLft[7]);
		this.wingLft[4].addChild(this.wingLft[8]);
		this.wingLft[8].addChild(this.wingLft[9]);

		this.wingRt[3].addChild(this.wingRt[6]);
		this.wingRt[6].addChild(this.wingRt[7]);
		this.wingRt[4].addChild(this.wingRt[8]);
		this.wingRt[8].addChild(this.wingRt[9]);

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{ 
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		this.bodyJoint.render(modelSize);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void animate(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{	
		this.animationDeployer.update((IAnimatedEntity)entity);
		resetPartInfos();

		float angularVelocity = ((IMobMotionTracker)entity).getAngularVelocity();
		float verticleVelocity = (float)((IMobMotionTracker)entity).getHeightVelocity();

		float idleDampener = 1F;

		float tick = animationDeployer.getEntity().getAnimationTick() + PokemonMDMain.proxy.getPartialTick();

		if(animationDeployer.getEntity().getAnimationID() == LibraryNecromancerDelphoxAttackID.FLAMETHROWER)
		{
			idleDampener = animateMajorCast(animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		}

		animateBody((EntityNecromancerDelphox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateHead((EntityNecromancerDelphox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateArms((EntityNecromancerDelphox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateLegs((EntityNecromancerDelphox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateTail((EntityNecromancerDelphox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateWings((EntityNecromancerDelphox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyJointInfo.resetNewAngles();
		bodyJointInfo.resetNewPnt();

		bodyInfo.resetNewAngles();

		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		earLftInfo.resetNewAngles();
		earRtInfo.resetNewAngles();

		armLftJointInfo.resetNewAngles();
		armRtJointInfo.resetNewAngles();
		armLftInfo.resetNewAngles();
		armRtInfo.resetNewAngles();

		armLftForearmJointInfo.resetNewAngles();
		armRtForearmJointInfo.resetNewAngles();
		armLftForearmInfo.resetNewAngles();
		armRtForearmInfo.resetNewAngles();

		staffJointInfo.resetNewAngles();

		for(int i = 0; i < earTuffInfo.length; i++)
		{
			for(int j = 0; j < earTuffInfo[i].length; j++)
			{
				for(int k = 0; k < earTuffInfo[i][j].length; k++)
				{
					earTuffInfo[i][j][k].resetNewAngles();
				}
			}
		}

		for(int i = 0; i < armRtForearmFluff.length; i++)
		{
			armRtForearmFluffInfo[i].resetNewAngles();
			armLftForearmFluffInfo[i].resetNewAngles();
		}

		for(int i = 0; i < bodySkirtBck.length; i++)
		{
			bodySkirtBckInfo[i].resetNewAngles();
			bodySkirtFntInfo[i].resetNewAngles();
			bodySkirtRtInfo[i].resetNewAngles();
			bodySkirtLftInfo[i].resetNewAngles();
		}

		legRtInfo.resetNewAngles();
		legLftInfo.resetNewAngles();

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}

		wingRtJointInfo.resetNewAngles();
		wingLftJointInfo.resetNewAngles();

		for(int i = 0; i < wingRt.length; i++)
		{
			wingRtInfo[i].resetNewAngles();
			wingLftInfo[i].resetNewAngles();
		}
	}

	public float animateMajorCast(IAnimatedEntity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float idleDampener = 1F;

		float tick = animationDeployer.getEntity().getAnimationTick() + PokemonMDMain.proxy.getPartialTick();

		float firstPhaseEnd = 4; // Move arm to starting position
		float secondPhaseEnd = 20; // Spin staff
		float thirdPhaseEnd = 24; // Swing arm to cast position
		float fourthPhaseEnd = 40; // Spell cast
		float endDuration = 45; // Return to idle position

		if(tick < firstPhaseEnd && tick > 0)
		{
			idleDampener = (1F + (float)MathHelper.cos(PI*(tick/firstPhaseEnd)));
		}
		else if(tick < fourthPhaseEnd)
		{
			idleDampener = 0;
		}
		else if(tick < endDuration)
		{
			idleDampener = (1F + (float)MathHelper.cos(PI + PI * ((tick - secondPhaseEnd)/(endDuration - secondPhaseEnd))));
		}

		/*
		 * Arm animations
		 */
		Vector3f armRtJointChanges = new Vector3f(0,0,0);

		/* ******** First Phase - Move To Starting Position *********/
		/* ******** First Phase Timers *********/
		float firstPhaseDurationStart = 0F;
		float firstPhaseDurationEnd = firstPhaseEnd;

		/* ******** First Phase Vectors *********/
		Vector3f firstPhaseArmRtJointChanges = new Vector3f(
				(float)Math.toRadians(-10),
				(float)Math.toRadians(10),
				(float)Math.toRadians(0));

		/* ******** Second Phase - Spin Staff *********/
		/* ******** Second Phase Timers *********/
		float secondPhaseDurationStart = firstPhaseDurationEnd;
		float secondPhaseDurationEnd = secondPhaseEnd;
		float secondPhaseDuration = secondPhaseDurationEnd - secondPhaseDurationStart;

		/* ******** Second Phase Vectors *********/
		Vector3f secondPhaseArmRtJointChanges = new Vector3f(
				(float)Math.toRadians(0),
				(float)Math.toRadians(-75),
				(float)Math.toRadians(0));

		/* ******** Third Phase - Swing Arm To Cast *********/
		/* ******** Third Phase Timers *********/
		float thirdPhaseDurationStart = secondPhaseDurationEnd;
		float thirdPhaseDurationEnd = thirdPhaseEnd;
		float thirdPhaseDuration = thirdPhaseDurationEnd - thirdPhaseDurationStart;

		/* ******** Third Phase Vectors *********/
		Vector3f thirdPhaseArmRtJointChanges = new Vector3f(
				(float)Math.toRadians(0),
				(float)Math.toRadians(-85),
				(float)Math.toRadians(0));

		/* ******** Fourth Phase - Spell Cast *********/
		/* ******** Fourth Phase Timers *********/
		float fourthPhaseDurationStart = thirdPhaseDurationEnd;
		float fourthPhaseDurationEnd = fourthPhaseEnd;
		float fourthPhaseDuration = fourthPhaseDurationEnd - fourthPhaseDurationStart;

		/* ******** Fourth Phase Vectors *********/
		Vector3f fourthPhaseArmRtJointChanges = new Vector3f(
				(float)Math.toRadians(10),
				(float)Math.toRadians(0),
				(float)Math.toRadians(0));

		/*
		 * First Phase Animations - Move To Starting Position
		 */
		float firstPhaseDurationCovered = PartAnimate.calculateDuration(tick, firstPhaseDurationStart, firstPhaseDurationEnd);

		PartAnimate.changeOverDurationSCurve(armRtJointChanges, firstPhaseArmRtJointChanges,
				firstPhaseDurationCovered);

		/*
		 * Second Phase Animations - Spin Staff
		 */
		float secondPhaseDurationCovered = PartAnimate.calculateDuration(tick, secondPhaseDurationStart, secondPhaseDurationEnd);

		PartAnimate.changeOverDurationUCurve(armRtJointChanges, secondPhaseArmRtJointChanges,
				secondPhaseDurationCovered);

		/*
		 * Third Phase Animations - Swing Arm To Cast
		 */
		float thirdPhaseDurationCovered = PartAnimate.calculateDuration(tick, thirdPhaseDurationStart, thirdPhaseDurationEnd);

		PartAnimate.changeOverDurationSCurve(armRtJointChanges, thirdPhaseArmRtJointChanges,
				thirdPhaseDurationCovered);

		/*
		 * Fourth Phase Animations - Spell Cast
		 */
		float fourthPhaseDurationCovered = PartAnimate.calculateDuration(tick, fourthPhaseDurationStart, fourthPhaseDurationEnd);

		PartAnimate.changeOverDurationSCurve(armRtJointChanges, fourthPhaseArmRtJointChanges,
				fourthPhaseDurationCovered);

		/*
		 * Return to idle animations
		 */
		float returnDampener = 1 - PartAnimate.calculateDuration(tick, fourthPhaseDurationEnd, endDuration);

		armRtJointChanges.multiplyVector(returnDampener);

		PartAnimate.applyRotationChangeVectorToInfo(armRtJointInfo, armRtJointChanges);

		//PartAnimate.headAnimateInfoOnlyWithAngleModifiers(shoulderLftJointInfo, yawHeadOffsetDifference, pitchRotation, (1-idleDampener)*1.5F, 0);

		return idleDampener;
	}

	public void animateBody(EntityNecromancerDelphox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity, float angularVelocity)
	{
		float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
		float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

		float walkMaximumChangeY = 0.85F;
		float runMaximumChangeY = 1.2F;

		float walkCyclePointChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI + PI/2) * walkMaximumChangeY * (1 - horzVelocity);
		float runCyclePointChange = MathHelper.cos(2 * runCycleInterval * 2 * PI + PI/2) * runMaximumChangeY * horzVelocity;

		bodyJointInfo.setNewPointY(bodyJointInfo.getNewPointY() + (walkCyclePointChange + runCyclePointChange) * horzVelocity);

		float bodyWalkAngle = (float)Math.toRadians(3);
		float bodyRunAngle = (float)Math.toRadians(5);

		float walkCycleAngleChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI + PI/2) * bodyWalkAngle * (1 - horzVelocity)
				+ bodyWalkAngle * (1 - horzVelocity);
		float runCycleAngleChange = MathHelper.cos(2 * runCycleInterval * 2 * PI + PI/2) * bodyRunAngle * horzVelocity
				+ bodyRunAngle * horzVelocity;

		bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocity * idleDampener);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(0);

		float idleAmplitudeX = (float)Math.toRadians(3);

		float angleChangeX = (-MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX) * (1 - horzVelocity);

		bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + angleChangeX * idleDampener * (1F - Math.abs(verticalVelocity)));

		float yawChangeAngle = -(float)Math.toRadians(6);
		float verticalVelocityChangeAngle = (float)Math.toRadians(5);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		for(int i = 0; i < bodySkirtBck.length; i++)
		{
			currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(i);

			idleAmplitudeX = (float)Math.toRadians(1);
			float idleAmplitudeZ = (float)Math.toRadians(6);

			float moveAmplitudeY = (float)Math.toRadians(-3);
			float moveAmplitudeZ = (float)Math.toRadians(3);

			// + (float)Math.toRadians(45)
			angleChangeX = 0;
			float angleChangeY = 0;
			float angleChangeZ = 0;

			// Idle Animations
			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX 
					* (1F - horzVelocity) * (1F - Math.abs(angularVelocity) * 0.5F);
			angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeZ 
					* (1F - horzVelocity) * (1F - Math.abs(angularVelocity) * 0.5F);

			// Movement Animations
			angleChangeX += verticalVelocityChangeAngle * newVerticalVelocity;
			angleChangeY += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - (2F * PI * ((float)i / (float)(bodySkirtBck.length - 1))), horzVelocity, RUN_FREQUENCY, moveAmplitudeY) * (1F - Math.abs(newVerticalVelocity));
			angleChangeZ += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - (2F * PI * ((float)i / (float)(bodySkirtBck.length - 1))), horzVelocity, RUN_FREQUENCY, moveAmplitudeZ) * (1F - Math.abs(newVerticalVelocity))
					+ angularVelocity * yawChangeAngle;

			//- verticalVelocityChangeAngle * newVerticalVelocity 

			bodySkirtBckInfo[i].setNewRotateX(bodySkirtBckInfo[i].getNewRotateX() - angleChangeX);
			bodySkirtFntInfo[i].setNewRotateX(bodySkirtFntInfo[i].getNewRotateX() + angleChangeX);
			bodySkirtRtInfo[i].setNewRotateX(bodySkirtRtInfo[i].getNewRotateX() + angleChangeX);
			bodySkirtLftInfo[i].setNewRotateX(bodySkirtLftInfo[i].getNewRotateX() + angleChangeX);

			bodySkirtBckInfo[i].setNewRotateY(bodySkirtBckInfo[i].getNewRotateY() - angleChangeY);
			bodySkirtFntInfo[i].setNewRotateY(bodySkirtFntInfo[i].getNewRotateY() + angleChangeY);
			bodySkirtRtInfo[i].setNewRotateY(bodySkirtRtInfo[i].getNewRotateY() + angleChangeY);
			bodySkirtLftInfo[i].setNewRotateY(bodySkirtLftInfo[i].getNewRotateY() + angleChangeY);

			bodySkirtBckInfo[i].setNewRotateZ(bodySkirtBckInfo[i].getNewRotateZ() - angleChangeZ);
			bodySkirtFntInfo[i].setNewRotateZ(bodySkirtFntInfo[i].getNewRotateZ() + angleChangeZ);
			bodySkirtRtInfo[i].setNewRotateZ(bodySkirtRtInfo[i].getNewRotateZ() + angleChangeZ);
			bodySkirtLftInfo[i].setNewRotateZ(bodySkirtLftInfo[i].getNewRotateZ() + angleChangeZ);
		}
	}

	public void animateHead(EntityNecromancerDelphox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity, float angularVelocity)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.8F, 0.8F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(0);

		float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
		float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

		float walkAngle;
		float runAngle;

		float walkCycleAngleChange;
		float runCycleAngleChange;

		float idleAmplitudeZ;
		float angleChangeZ;

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float fallingEarAngle;

		// ********************************* //
		// ****** earsInfo Animations ****** //
		// ********************************* //
		// ****** Idle Animations ****** //
		idleAmplitudeZ = (float)Math.toRadians(15);

		// + (float)Math.toRadians(45)
		angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ * (1 - horzVelocity) * (1F - Math.abs(newVerticalVelocity));

		earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - angleChangeZ);
		earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + angleChangeZ);

		// ****** Movement Animations ****** //
		walkAngle = (float)Math.toRadians(6);
		runAngle = (float)Math.toRadians(12);

		walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity)
				+ walkAngle * (1 - horzVelocity);
		runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI) * runAngle * horzVelocity
				+ runAngle * horzVelocity;

		earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity))));
		earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity))));	

		// ****** Fall/Jump Animations ****** //
		fallingEarAngle = (float)Math.toRadians(40);

		earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + (fallingEarAngle * (newVerticalVelocity < 0 ? newVerticalVelocity * 0.5F : newVerticalVelocity)));
		earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - (fallingEarAngle * (newVerticalVelocity < 0 ? newVerticalVelocity * 0.5F : newVerticalVelocity)));	

		// ************************************* //
		// ****** earTuffsInfo Animations ****** //
		// ************************************* //
		for(int i = 0; i < earTuff[0].length; i++)
		{
			for(int j = 0; j < earTuff[0][i].length; j++)
			{
				currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(j);

				int earTuffLft = 0;
				int earTuffRt = 1;

				// ****** Idle Animations ****** //
				idleAmplitudeZ = (float)Math.toRadians(16);

				// + (float)Math.toRadians(45)
				angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ * (1 - horzVelocity) * (1F - Math.abs(newVerticalVelocity));

				earTuffInfo[earTuffLft][i][j].setNewRotateZ(earTuffInfo[earTuffLft][i][j].getNewRotateZ() + angleChangeZ);
				earTuffInfo[earTuffRt][i][j].setNewRotateZ(earTuffInfo[earTuffRt][i][j].getNewRotateZ() - angleChangeZ);

				// ****** Movement Animations ****** //
				walkAngle = (float)Math.toRadians(5);
				runAngle = (float)Math.toRadians(10);

				walkCycleAngleChange = MathHelper.cos(walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity)
						+ walkAngle * (1 - horzVelocity);
				runCycleAngleChange = MathHelper.cos(runCycleInterval * 2 * PI) * runAngle * horzVelocity
						+ runAngle * horzVelocity;

				earTuffInfo[earTuffLft][i][j].setNewRotateZ(earTuffInfo[earTuffLft][i][j].getNewRotateZ() + ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity))));
				earTuffInfo[earTuffRt][i][j].setNewRotateZ(earTuffInfo[earTuffRt][i][j].getNewRotateZ() - ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity))));	

				// ****** Fall/Jump Animations ****** //
				fallingEarAngle = (float)Math.toRadians(20);

				earTuffInfo[earTuffLft][i][j].setNewRotateZ(earTuffInfo[earTuffLft][i][j].getNewRotateZ() + (fallingEarAngle * (newVerticalVelocity < 0 ? newVerticalVelocity * 0.5F : newVerticalVelocity)));
				earTuffInfo[earTuffRt][i][j].setNewRotateZ(earTuffInfo[earTuffRt][i][j].getNewRotateZ() - (fallingEarAngle * (newVerticalVelocity < 0 ? newVerticalVelocity * 0.5F : newVerticalVelocity)));	
			}
		}
	}

	public void animateArms(EntityNecromancerDelphox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity, float angularVelocity)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, armLftJointInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, armRtJointInfo);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float angleChangeX = 0;
		float angleChangeY = 0;
		float angleChangeZ = 0;

		float idleAmplitudeX = 0;
		float idleAmplitudeY = 0;
		float idleAmplitudeZ = 0;

		float movementAmplitudeX = 0;
		float movementAmplitudeY = 0;
		float movementAmplitudeZ = 0;

		float movementChangeX = 0;
		float movementChangeY = 0;
		float movementChangeZ = 0;

		// *************************************** //
		// ****** armRtJointInfo Animations ****** //
		// *************************************** //
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(0);

		angleChangeX = 0;
		angleChangeY = 0;
		angleChangeZ = 0;

		// ****** Idle Animations ****** //
		idleAmplitudeX = (float)Math.toRadians(20);

		angleChangeX += (-MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX) * (1 - horzVelocity);

		// ****** Movement Animations ****** //
		movementAmplitudeX = (float)Math.toRadians(30);
		movementChangeX = (float)Math.toRadians(30);
		movementChangeY = (float)Math.toRadians(-75);
		movementChangeZ = (float)Math.toRadians(20);

		angleChangeX += PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, this.RUN_FREQUENCY, movementAmplitudeX) +
				movementChangeX * horzVelocity;
		angleChangeY += movementChangeY * horzVelocity;
		angleChangeZ += movementChangeZ * horzVelocity;

		// ****** Turn Animations ****** //
		movementChangeY = (float)Math.toRadians(-40);

		angleChangeY += movementChangeY * angularVelocity;

		// ****** Fall/Jump Animations ****** //
		angleChangeX *= (1F - Math.abs(newVerticalVelocity));
		angleChangeY *= (1F - Math.abs(newVerticalVelocity));

		// Fall
		movementChangeX = (float)Math.toRadians(80);

		angleChangeX += (verticalVelocity < 0F ? (verticalVelocity * movementChangeX) : 0);

		// Jump
		movementChangeX = (float)Math.toRadians(40);

		angleChangeX += (verticalVelocity > 0F ? (verticalVelocity * movementChangeX) : 0);

		// ****** Dampen Animations ****** //
		angleChangeX *= idleDampener;
		angleChangeY *= idleDampener;
		angleChangeZ *= idleDampener;

		// ****** Apply Animations ****** //
		armRtJointInfo.setNewRotateX(armRtJointInfo.getNewRotateX() + angleChangeX);
		armRtJointInfo.setNewRotateY(armRtJointInfo.getNewRotateY() + angleChangeY);
		armRtJointInfo.setNewRotateZ(armRtJointInfo.getNewRotateZ() + angleChangeZ);

		// ********************************************** //
		// ****** armRtForearmJointInfo Animations ****** //
		// ********************************************** //
		currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(1);

		angleChangeX = 0;
		angleChangeY = 0;

		// ****** Idle Animations ****** //
		angleChangeX += (-MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX) * (1 - horzVelocity);

		// ****** Movement Animations ****** //
		movementAmplitudeX = (float)Math.toRadians(25);
		movementChangeX = (float)Math.toRadians(-15);
		movementChangeY = (float)Math.toRadians(20);

		angleChangeX += PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, this.RUN_FREQUENCY, movementAmplitudeX) +
				movementChangeX * horzVelocity;
		angleChangeY += movementChangeY * horzVelocity;

		// ****** Fall/Jump Animations ****** //
		angleChangeX *= (1F - Math.abs(newVerticalVelocity));
		angleChangeY *= (1F - Math.abs(newVerticalVelocity));

		// ****** Dampen Animations ****** //
		angleChangeX *= idleDampener;
		angleChangeY *= idleDampener;

		// ****** Apply Animations ****** //
		armRtForearmJointInfo.setNewRotateX(armRtForearmJointInfo.getNewRotateX() + angleChangeX);
		armRtForearmJointInfo.setNewRotateY(armRtForearmJointInfo.getNewRotateY() + angleChangeY);

		// *************************************** //
		// ****** staffJointInfo Animations ****** //
		// *************************************** //
		currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(2);

		angleChangeX = 0;

		idleAmplitudeX = (float)Math.toRadians(30);

		// ****** Idle Animations ****** //
		angleChangeX += (-MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX) * (1 - horzVelocity);

		// ****** Movement Animations ****** //

		// ****** Fall/Jump Animations ****** //
		angleChangeX *= (1F - Math.abs(newVerticalVelocity));
		angleChangeY *= (1F - Math.abs(newVerticalVelocity));

		// ****** Dampen Animations ****** //
		angleChangeX *= idleDampener;
		angleChangeY *= idleDampener;

		// ****** Apply Animations ****** //
		staffJointInfo.setNewRotateX(staffJointInfo.getNewRotateX() + angleChangeX * idleDampener);

		// **************************************** //
		// ****** armLftJointInfo Animations ****** //
		// **************************************** //
		currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(0);

		angleChangeX = 0;
		angleChangeY = 0;
		angleChangeZ = 0;

		// ****** Idle Animations ****** //
		idleAmplitudeX = (float)Math.toRadians(10);

		angleChangeX += (-MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX) * (1 - horzVelocity);

		// ****** Movement Animations ****** //
		movementAmplitudeX = (float)Math.toRadians(30);
		movementChangeX = (float)Math.toRadians(30);
		movementChangeY = (float)Math.toRadians(75);
		movementChangeZ = (float)Math.toRadians(-20);

		angleChangeX += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, this.RUN_FREQUENCY, movementAmplitudeX) +
				movementChangeX * horzVelocity;
		angleChangeY += movementChangeY * horzVelocity;
		angleChangeZ += movementChangeZ * horzVelocity;

		// ****** Turn Animations ****** //
		movementChangeY = (float)Math.toRadians(-40);

		angleChangeY += movementChangeY * angularVelocity;

		// ****** Fall/Jump Animations ****** //
		angleChangeX *= (1F - Math.abs(newVerticalVelocity));
		angleChangeY *= (1F - Math.abs(newVerticalVelocity));

		// Fall
		movementChangeX = (float)Math.toRadians(80);

		angleChangeX += (verticalVelocity < 0F ? (verticalVelocity * movementChangeX) : 0);

		// Jump
		movementChangeX = (float)Math.toRadians(40);

		angleChangeX += (verticalVelocity > 0F ? (verticalVelocity * movementChangeX) : 0);

		// ****** Dampen Animations ****** //
		angleChangeX *= idleDampener;
		angleChangeY *= idleDampener;
		angleChangeZ *= idleDampener;

		// ****** Apply Animations ****** //
		armLftJointInfo.setNewRotateX(armLftJointInfo.getNewRotateX() + angleChangeX);
		armLftJointInfo.setNewRotateY(armLftJointInfo.getNewRotateY() + angleChangeY);
		armLftJointInfo.setNewRotateZ(armLftJointInfo.getNewRotateZ() + angleChangeZ);

		// ********************************************** //
		// ****** armRtForearmJointInfo Animations ****** //
		// ********************************************** //
		currentIdleAnimationClock = entity.getIdleAnimationClockBodySway(1);

		angleChangeX = 0;
		angleChangeY = 0;

		// ****** Idle Animations ****** //
		angleChangeX += (-MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX) * (1 - horzVelocity);

		// ****** Movement Animations ****** //
		movementAmplitudeX = (float)Math.toRadians(25);
		movementChangeX = (float)Math.toRadians(-15);
		movementChangeY = (float)Math.toRadians(-20);

		angleChangeX += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, this.RUN_FREQUENCY, movementAmplitudeX) +
				movementChangeX * horzVelocity;
		angleChangeY += movementChangeY * horzVelocity;

		// ****** Fall/Jump Animations ****** //
		angleChangeX *= (1F - Math.abs(newVerticalVelocity));
		angleChangeY *= (1F - Math.abs(newVerticalVelocity));

		// ****** Dampen Animations ****** //
		angleChangeX *= idleDampener;
		angleChangeY *= idleDampener;

		// ****** Apply Animations ****** //
		armLftForearmJointInfo.setNewRotateX(armLftForearmJointInfo.getNewRotateX() + angleChangeX);
		armLftForearmJointInfo.setNewRotateY(armLftForearmJointInfo.getNewRotateY() + angleChangeY);

		// ********************************************** //
		// ****** armForearmFluffInfo Animations ****** //
		// ********************************************** //
		for(int i = 0; i < armRtForearmFluff.length; i++)
		{
			angleChangeX = (float)Math.toRadians(-3);
			angleChangeZ = 0;

			// ****** Idle Animations ****** //
			idleAmplitudeX = (float)Math.toRadians(22);
			idleAmplitudeZ = (float)Math.toRadians(1);

			angleChangeX += (MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + (PI / 12F) * (float)i) * idleAmplitudeX) * (1 - horzVelocity);
			angleChangeZ += (MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + (PI / 8F) * (float)i) * idleAmplitudeZ) * (1 - horzVelocity);

			// ****** Movement Animations ****** //
			movementAmplitudeX = (float)Math.toRadians(35);
			movementChangeX = (float)Math.toRadians(35);

			angleChangeX += PartAnimate.posCosRotateAnimationAdjusted(distanceMoved - PI/2F - (float)i * PI/8F, horzVelocity, this.RUN_FREQUENCY, movementAmplitudeX) +
					movementChangeX * horzVelocity;

			// ****** Turn Animations ****** //
			movementChangeZ = (float)Math.toRadians(-40);

			angleChangeZ += movementChangeZ * angularVelocity;

			// ****** Fall/Jump Animations ****** //
			angleChangeX *= (1F - Math.abs(newVerticalVelocity));
			angleChangeZ *= (1F - Math.abs(newVerticalVelocity));

			// ****** Dampen Animations ****** //
			angleChangeX *= idleDampener;
			angleChangeZ *= idleDampener;

			// ****** Apply Animations ****** //
			armRtForearmFluffInfo[i].setNewRotateX(armRtForearmFluffInfo[i].getNewRotateX() + angleChangeX * idleDampener * (1F - Math.abs(verticalVelocity)));
			armRtForearmFluffInfo[i].setNewRotateZ(armRtForearmFluffInfo[i].getNewRotateZ() + angleChangeZ * idleDampener * (1F - Math.abs(verticalVelocity)));

			/* ******************* */

			angleChangeX = (float)Math.toRadians(-3);
			angleChangeZ = 0;

			// ****** Idle Animations ****** //
			idleAmplitudeX = (float)Math.toRadians(22);
			idleAmplitudeZ = (float)Math.toRadians(1);

			angleChangeX += (MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + (PI / 12F) * (float)i) * idleAmplitudeX) * (1 - horzVelocity);
			angleChangeZ += (MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + (PI / 8F) * (float)i) * idleAmplitudeZ) * (1 - horzVelocity);

			// ****** Movement Animations ****** //
			movementAmplitudeX = (float)Math.toRadians(35);
			movementChangeX = (float)Math.toRadians(35);

			angleChangeX += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - PI/2F - (float)i * PI/8F, horzVelocity, this.RUN_FREQUENCY, movementAmplitudeX) +
					movementChangeX * horzVelocity;

			// ****** Turn Animations ****** //
			movementChangeZ = (float)Math.toRadians(-40);

			angleChangeZ += movementChangeZ * angularVelocity;

			// ****** Fall/Jump Animations ****** //
			angleChangeX *= (1F - Math.abs(newVerticalVelocity));
			angleChangeZ *= (1F - Math.abs(newVerticalVelocity));

			// ****** Dampen Animations ****** //
			angleChangeX *= idleDampener;
			angleChangeZ *= idleDampener;

			// ****** Apply Animations ****** //
			armLftForearmFluffInfo[i].setNewRotateX(armLftForearmFluffInfo[i].getNewRotateX() + angleChangeX * idleDampener * (1F - Math.abs(verticalVelocity)));
			armLftForearmFluffInfo[i].setNewRotateZ(armLftForearmFluffInfo[i].getNewRotateZ() + angleChangeZ * idleDampener * (1F - Math.abs(verticalVelocity)));

		}
	}

	public void animateLegs(EntityNecromancerDelphox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity, float angularVelocity)
	{		
		float moveAmplitudeX = (float)Math.toRadians(10);

		float fallingLegAngle = (float)Math.toRadians(30);

		float newHorizontalVelocity = (2F * horzVelocity > 1F ? 1F : horzVelocity * 2F);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float fallingModifier = 0;

		if(newVerticalVelocity < 0)
			fallingModifier = newVerticalVelocity;

		float runAngleChangeX = 0;

		runAngleChangeX += PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, newHorizontalVelocity, this.RUN_FREQUENCY, moveAmplitudeX)
				* (1F - Math.abs(newVerticalVelocity));

		legRtInfo.setNewRotateX(legRtInfo.getNewRotateX() + (runAngleChangeX + fallingLegAngle * fallingModifier) * idleDampener);
		legLftInfo.setNewRotateX(legLftInfo.getNewRotateX() - (runAngleChangeX + fallingLegAngle * fallingModifier) * idleDampener);
	}

	public void animateTail(EntityNecromancerDelphox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity, float angularVelocity)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, tailInfo[0][0]);

		float yawChangeAngle = -(float)Math.toRadians(15);
		float verticalVelocityChangeAngle = (float)Math.toRadians(-9);

		float bodyJumpAngle = (float)Math.toRadians(-35);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float absoluteMoveVelocity = (horzVelocity + Math.abs(newVerticalVelocity)) * 1.5F;

		if(absoluteMoveVelocity > 1F)
			absoluteMoveVelocity = 1F;

		tailInfo[0][1].setNewRotateX(tailInfo[0][1].getNewRotateX() + bodyJumpAngle * newVerticalVelocity);

		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = (float)Math.toRadians(12);
			float idleAmplitudeY = (float)Math.toRadians(12);

			float moveAmplitudeX = (float)Math.toRadians(8);

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			// Idle Animations
			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX 
					* (1F - absoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.75F);
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY
					* (1F - absoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.75F);

			// Movement Animations
			angleChangeX += PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - (2F * PI * ((float)i / (float)(tail.length - 1))), horzVelocity, RUN_FREQUENCY, moveAmplitudeX) 
					+ verticalVelocityChangeAngle * newVerticalVelocity;
			angleChangeY += angularVelocity * yawChangeAngle;

			// Part Number Dampener
			angleChangeX *= (1F - (Math.pow(Math.E, -0.95F * (float)(i + 1))));
			angleChangeY *= (1F - (Math.pow(Math.E, -0.95F * (float)(i + 1))));

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}
	}

	public void animateWings(EntityNecromancerDelphox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity, float angularVelocity)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, wingLftJointInfo);
		JointAnimation.reverseJointRotatesChange(bodyInfo, wingRtJointInfo);

		float yawChangeAngle = -(float)Math.toRadians(15);
		float verticalVelocityChangeAngle = (float)Math.toRadians(-9);

		float bodyJumpAngle = (float)Math.toRadians(-35);

		float newVerticalVelocity = 1.5F * verticalVelocity;

		if(newVerticalVelocity > 1F)
			newVerticalVelocity = 1F;
		else if(newVerticalVelocity < -1F)
			newVerticalVelocity = -1F;

		float absoluteMoveVelocity = (horzVelocity + Math.abs(newVerticalVelocity)) * 1.5F;

		if(absoluteMoveVelocity > 1F)
			absoluteMoveVelocity = 1F;


		for(int i = 1; i < wingRt.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockWings(i);

			float idleAmplitudeX = (float)Math.toRadians(12);
			float idleAmplitudeY = (float)Math.toRadians(8);

			float moveAmplitudeX = (float)Math.toRadians(8);

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			// Idle Animations
			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX 
					* (1F - absoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.75F);
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY
					* (1F - absoluteMoveVelocity) * (1F - Math.abs(angularVelocity) * 0.75F);

			if(i == 2)
				angleChangeX *= -2.5F;
			else if(i == 3)
				if(angleChangeX > 0)
					angleChangeX *= 4.5F;
				else
					angleChangeX *= 2.5F;

			wingRtInfo[i].setNewRotateX(wingRtInfo[i].getNewRotateX() + angleChangeX);
			wingRtInfo[i].setNewRotateY(wingRtInfo[i].getNewRotateY() - angleChangeY);

			wingLftInfo[i].setNewRotateX(wingLftInfo[i].getNewRotateX() + angleChangeX);
			wingLftInfo[i].setNewRotateY(wingLftInfo[i].getNewRotateY() + angleChangeY);

			// Movement Animations
			angleChangeX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - (2F * PI * ((float)i / (float)(tail.length - 1))), horzVelocity, RUN_FREQUENCY, moveAmplitudeX) 
					+ verticalVelocityChangeAngle * newVerticalVelocity;
			angleChangeY = angularVelocity * yawChangeAngle;

			wingRtInfo[i].setNewRotateX(wingRtInfo[i].getNewRotateX() + angleChangeX);
			wingRtInfo[i].setNewRotateY(wingRtInfo[i].getNewRotateY() + angleChangeY);

			wingLftInfo[i].setNewRotateX(wingLftInfo[i].getNewRotateX() + angleChangeX);
			wingLftInfo[i].setNewRotateY(wingLftInfo[i].getNewRotateY() + angleChangeY);

			// ****** Fall/Jump Animations ****** //
			wingRtInfo[i].setNewRotateX(wingRtInfo[i].getNewRotateX() * (1F - Math.abs(verticalVelocity) * 0.5F));
			wingLftInfo[i].setNewRotateX(wingLftInfo[i].getNewRotateX() * (1F - Math.abs(verticalVelocity) * 0.5F));

		}

		// ****** Specific Part Fall/Jump Animations ****** //
		wingLftJointInfo.setNewRotateY(wingLftJointInfo.getNewRotateY() * (1F - horzVelocity));
		wingRtJointInfo.setNewRotateY(wingRtJointInfo.getNewRotateY() * (1F - horzVelocity));

		if(verticalVelocity < 0F)
		{
			float wingCornerPartAngleChange = (float)Math.toRadians(75);
			wingRtInfo[3].setNewRotateX(wingRtInfo[3].getNewRotateX() - wingCornerPartAngleChange * verticalVelocity);
			wingLftInfo[3].setNewRotateX(wingLftInfo[3].getNewRotateX() - wingCornerPartAngleChange * verticalVelocity);
		}
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(bodyJoint, bodyJointInfo.getNewRotates());
		this.animationDeployer.move(bodyJoint, bodyJointInfo.getNewPnt());

		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());

		this.animationDeployer.rotate(armLftJoint, armLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRtJoint, armRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());

		this.animationDeployer.rotate(armLftForearmJoint, armLftForearmJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRtForearmJoint, armRtForearmJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLftForearm, armLftForearmInfo.getNewRotates());
		this.animationDeployer.rotate(armRtForearm, armRtForearmInfo.getNewRotates());

		this.animationDeployer.rotate(staffJoint, staffJointInfo.getNewRotates());

		for(int i = 0; i < armRtForearmFluff.length; i++)
		{
			this.animationDeployer.rotate(armRtForearmFluff[i], armRtForearmFluffInfo[i].getNewRotates());
			this.animationDeployer.rotate(armLftForearmFluff[i], armLftForearmFluffInfo[i].getNewRotates());
		}

		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(earLft, earLftInfo.getNewRotates());
		this.animationDeployer.rotate(earRt, earRtInfo.getNewRotates());

		for(int i = 0; i < earTuffInfo.length; i++)
		{
			for(int j = 0; j < earTuffInfo[i].length; j++)
			{
				for(int k = 0; k < earTuffInfo[i][j].length; k++)
				{
					this.animationDeployer.rotate(earTuff[i][j][k], earTuffInfo[i][j][k].getNewRotates());
				}
			}
		}

		for(int i = 0; i < bodySkirtBck.length; i++)
		{
			this.animationDeployer.rotate(bodySkirtBck[i], bodySkirtBckInfo[i].getNewRotates());
			this.animationDeployer.rotate(bodySkirtFnt[i], bodySkirtFntInfo[i].getNewRotates());
			this.animationDeployer.rotate(bodySkirtRt[i], bodySkirtRtInfo[i].getNewRotates());
			this.animationDeployer.rotate(bodySkirtLft[i], bodySkirtLftInfo[i].getNewRotates());
		}

		this.animationDeployer.rotate(legRt, legRtInfo.getNewRotates());
		this.animationDeployer.rotate(legLft, legLftInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.rotate(wingRtJoint, wingRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(wingLftJoint, wingLftJointInfo.getNewRotates());

		for(int i = 0; i < wingRt.length; i++)
		{
			this.animationDeployer.rotate(wingRt[i], wingRtInfo[i].getNewRotates());
			this.animationDeployer.rotate(wingLft[i], wingLftInfo[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}