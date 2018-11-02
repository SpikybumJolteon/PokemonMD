package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.IHeadMobMotionTracker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.IMobMotionTracker;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityDeathBlossomLurantis;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDeathBlossomLurantis extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public final float RUN_FREQUENCY = 0.6F;
	public final float WALK_FREQUENCY = 1.2F;
	public final float SNEAK_VELOCITY = 0.45F;

	float tempDistanceMoved = 0;

	public ModelRenderer bodyJoint;
	public ModelRenderer body;
	PartInfo bodyJointInfo;
	PartInfo bodyInfo;

	public ModelRenderer backPetalTopLft;
	public ModelRenderer backPetalTopRt;
	public ModelRenderer backPetalBotLft;
	public ModelRenderer backPetalBotRt;
	PartInfo backPetalTopLftInfo;
	PartInfo backPetalTopRtInfo;
	PartInfo backPetalBotLftInfo;
	PartInfo backPetalBotRtInfo;

	public ModelRenderer hipPetalLft[][] = new ModelRenderer[6][2];
	public PartInfo hipPetalLftInfo[][] = new PartInfo[hipPetalLft.length][hipPetalLft[0].length];

	public ModelRenderer hipPetalRt[][] = new ModelRenderer[6][2];
	public PartInfo hipPetalRtInfo[][] = new PartInfo[hipPetalRt.length][hipPetalRt[0].length];

	public ModelRenderer legLftJoint;
	public ModelRenderer legRtJoint;
	PartInfo legLftJointInfo;
	PartInfo legRtJointInfo;

	public ModelRenderer legLftMain[] = new ModelRenderer[2];
	public ModelRenderer legRtMain[] = new ModelRenderer[2];
	public PartInfo legLftMainInfo[] = new PartInfo[legLftMain.length];
	public PartInfo legRtMainInfo[] = new PartInfo[legRtMain.length];

	public ModelRenderer legLftLeggingJoint;
	public ModelRenderer legRtLeggingJoint;
	PartInfo legLftLeggingJointInfo;
	PartInfo legRtLeggingJointInfo;

	public ModelRenderer legLftLegging[] = new ModelRenderer[2];
	public ModelRenderer legRtLegging[] = new ModelRenderer[2];
	public PartInfo legLftLeggingInfo[] = new PartInfo[legLftLegging.length];
	public PartInfo legRtLeggingInfo[] = new PartInfo[legRtLegging.length];

	public ModelRenderer shoulderLft;
	public ModelRenderer armLftJoint;
	public ModelRenderer armLft;
	public ModelRenderer forearmLftJoint;
	public ModelRenderer forearmLft;
	PartInfo armLftJointInfo;
	PartInfo armLftInfo;
	PartInfo forearmLftJointInfo;
	PartInfo forearmLftInfo;

	public ModelRenderer clawLftJoint;
	public ModelRenderer clawLftTop2;
	public ModelRenderer clawLftTop1;
	public ModelRenderer clawLftBase;
	public ModelRenderer clawLftBot1;
	public ModelRenderer clawLftBot2;
	public ModelRenderer clawLftBot3;
	public ModelRenderer clawLftBot4;
	public ModelRenderer clawLftBot5;
	public ModelRenderer clawLftTooth1;
	public ModelRenderer clawLftTooth2;
	public ModelRenderer clawLftTooth3;
	PartInfo clawLftJointInfo;
	PartInfo clawLftBaseInfo;

	public ModelRenderer shoulderRt;
	public ModelRenderer armRtJoint;
	public ModelRenderer armRt;
	public ModelRenderer forearmRtJoint;
	public ModelRenderer forearmRt;
	PartInfo armRtJointInfo;
	PartInfo armRtInfo;
	PartInfo forearmRtJointInfo;
	PartInfo forearmRtInfo;

	public ModelRenderer clawRtJoint;
	public ModelRenderer clawRtTop2;
	public ModelRenderer clawRtTop1;
	public ModelRenderer clawRtBase;
	public ModelRenderer clawRtBot1;
	public ModelRenderer clawRtBot2;
	public ModelRenderer clawRtBot3;
	public ModelRenderer clawRtBot4;
	public ModelRenderer clawRtBot5;
	public ModelRenderer clawRtTooth1;
	public ModelRenderer clawRtTooth2;
	public ModelRenderer clawRtTooth3;
	PartInfo clawRtJointInfo;
	PartInfo clawRtBaseInfo;

	public ModelRenderer neck;
	PartInfo neckInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer eyeRt;
	public ModelRenderer eyeLft;
	PartInfo eyeRtInfo;
	PartInfo eyeLftInfo;

	public ModelRenderer headGem;

	public ModelRenderer cheekWhiskerLft[] = new ModelRenderer[4];
	public PartInfo cheekWhiskerLftInfo[] = new PartInfo[cheekWhiskerLft.length];

	public ModelRenderer cheekWhiskerRt[] = new ModelRenderer[4];
	public PartInfo cheekWhiskerRtInfo[] = new PartInfo[cheekWhiskerRt.length];

	public ModelRenderer antennaFntRt;
	public ModelRenderer antennaFntLft;
	PartInfo antennaFntRtInfo;
	PartInfo antennaFntLftInfo;

	public ModelRenderer antennaBckLft[] = new ModelRenderer[5];
	public PartInfo antennaBckLftInfo[] = new PartInfo[antennaBckLft.length];

	public ModelRenderer antennaBckLftSide[] = new ModelRenderer[2];
	public PartInfo antennaBckLftSideInfo[] = new PartInfo[antennaBckLftSide.length];

	public ModelRenderer antennaBckRt[] = new ModelRenderer[5];
	public PartInfo antennaBckRtInfo[] = new PartInfo[antennaBckRt.length];

	public ModelRenderer antennaBckRtSide[] = new ModelRenderer[2];
	public PartInfo antennaBckRtSideInfo[] = new PartInfo[antennaBckRtSide.length];

	public ModelDeathBlossomLurantis() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		int jointNumber = 0;
		int partNumber = 1;

		this.bodyJoint = new ModelRenderer(this, 0, 0);
		this.bodyJoint.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.bodyJoint.addBox(-1.5F, -4.5F, -0.99F, 0, 0, 0, 0.0F);
		this.bodyJointInfo = new PartInfo(bodyJoint);
		this.body = new ModelRenderer(this, 54, 25);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.addBox(-1.5F, -4.5F, -0.99F, 3, 5, 2, 0.0F);
		this.bodyInfo = new PartInfo(body);

		this.backPetalTopLft = new ModelRenderer(this, 56, 0);
		this.backPetalTopLft.setRotationPoint(0.7F, -2.0F, 0.9F);
		this.backPetalTopLft.addBox(-1.5F, -10.0F, 0.0F, 3, 10, 1, 0.0F);
		this.setRotateAngle(backPetalTopLft, -0.17453292519943295F, 0.0F, 0.5235987755982988F);
		this.backPetalTopLftInfo = new PartInfo(backPetalTopLft);
		this.backPetalTopRt = new ModelRenderer(this, 48, 0);
		this.backPetalTopRt.setRotationPoint(-0.7F, -2.0F, 0.9F);
		this.backPetalTopRt.addBox(-1.5F, -10.0F, 0.0F, 3, 10, 1, 0.0F);
		this.setRotateAngle(backPetalTopRt, -0.17453292519943295F, 0.0F, -0.5235987755982988F);
		this.backPetalTopRtInfo = new PartInfo(backPetalTopRt);
		this.backPetalBotLft = new ModelRenderer(this, 48, 11);
		this.backPetalBotLft.setRotationPoint(0.7F, -1.5F, 0.9F);
		this.backPetalBotLft.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 1, 0.0F);
		this.setRotateAngle(backPetalBotLft, 0.17453292519943295F, 0.0F, -0.5235987755982988F);
		this.backPetalBotLftInfo = new PartInfo(backPetalBotLft);
		this.backPetalBotRt = new ModelRenderer(this, 56, 11);
		this.backPetalBotRt.setRotationPoint(-0.7F, -1.5F, 0.9F);
		this.backPetalBotRt.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 1, 0.0F);
		this.setRotateAngle(backPetalBotRt, 0.17453292519943295F, 0.0F, 0.5235987755982988F);
		this.backPetalBotRtInfo = new PartInfo(backPetalBotRt);

		int hipPetalLftNumber = 0;
		this.hipPetalLft[hipPetalLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalLft1Joint
		this.hipPetalLft[hipPetalLftNumber][jointNumber].setRotationPoint(1.0F, -0.7F, -0.6F);
		this.hipPetalLft[hipPetalLftNumber][jointNumber].addBox(-1.0F, -0.5F, -1.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(hipPetalLft[hipPetalLftNumber][jointNumber], 0.0F, -0.9599310885968813F, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][jointNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][jointNumber]);
		this.hipPetalLft[hipPetalLftNumber][partNumber] = new ModelRenderer(this, 34, 1); // hipPetalLft1
		this.hipPetalLft[hipPetalLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalLft[hipPetalLftNumber][partNumber].addBox(-1.0F, -0.5F, -0.9F, 2, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalLft[hipPetalLftNumber][partNumber], 0.6981317007977318F, 0.0F, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][partNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][partNumber]);
		hipPetalLftNumber++;
		this.hipPetalLft[hipPetalLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalLft2Joint
		this.hipPetalLft[hipPetalLftNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalLft[hipPetalLftNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][jointNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][jointNumber]);
		this.hipPetalLft[hipPetalLftNumber][partNumber] = new ModelRenderer(this, 33, 3); // hipPetalLft2
		this.hipPetalLft[hipPetalLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalLft[hipPetalLftNumber][partNumber].addBox(-1.5F, -0.5F, -0.8F, 3, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalLft[hipPetalLftNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][partNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][partNumber]);
		hipPetalLftNumber++;
		this.hipPetalLft[hipPetalLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalLft3Joint
		this.hipPetalLft[hipPetalLftNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalLft[hipPetalLftNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][jointNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][jointNumber]);
		this.hipPetalLft[hipPetalLftNumber][partNumber] = new ModelRenderer(this, 33, 5); // hipPetalLft3
		this.hipPetalLft[hipPetalLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalLft[hipPetalLftNumber][partNumber].addBox(-1.5F, -0.5F, -0.8F, 3, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalLft[hipPetalLftNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][partNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][partNumber]);
		hipPetalLftNumber++;
		this.hipPetalLft[hipPetalLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalLft4Joint
		this.hipPetalLft[hipPetalLftNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalLft[hipPetalLftNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][jointNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][jointNumber]);
		this.hipPetalLft[hipPetalLftNumber][partNumber] = new ModelRenderer(this, 34, 7); // hipPetalLft4
		this.hipPetalLft[hipPetalLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalLft[hipPetalLftNumber][partNumber].addBox(-1.0F, -0.5F, -0.8F, 2, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalLft[hipPetalLftNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][partNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][partNumber]);
		hipPetalLftNumber++;
		this.hipPetalLft[hipPetalLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalLft5Joint
		this.hipPetalLft[hipPetalLftNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalLft[hipPetalLftNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][jointNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][jointNumber]);
		this.hipPetalLft[hipPetalLftNumber][partNumber] = new ModelRenderer(this, 34, 9); // hipPetalLft5
		this.hipPetalLft[hipPetalLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalLft[hipPetalLftNumber][partNumber].addBox(-1.0F, -0.5F, -0.8F, 2, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalLft[hipPetalLftNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][partNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][partNumber]);
		hipPetalLftNumber++;
		this.hipPetalLft[hipPetalLftNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalLft6Joint
		this.hipPetalLft[hipPetalLftNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalLft[hipPetalLftNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][jointNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][jointNumber]);
		this.hipPetalLft[hipPetalLftNumber][partNumber] = new ModelRenderer(this, 35, 11); // hipPetalLft6
		this.hipPetalLft[hipPetalLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalLft[hipPetalLftNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		this.hipPetalLftInfo[hipPetalLftNumber][partNumber] = new PartInfo(hipPetalLft[hipPetalLftNumber][partNumber]);

		int hipPetalRtNumber = 0;
		this.hipPetalRt[hipPetalRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalRt1Joint
		this.hipPetalRt[hipPetalRtNumber][jointNumber].setRotationPoint(-1.0F, -0.7F, -0.6F);
		this.hipPetalRt[hipPetalRtNumber][jointNumber].addBox(-1.0F, -0.5F, -1.7F, 0, 0, 0, 0.0F);
		this.setRotateAngle(hipPetalRt[hipPetalRtNumber][jointNumber], 0.0F, 0.9599310885968813F, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][jointNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][jointNumber]);
		this.hipPetalRt[hipPetalRtNumber][partNumber] = new ModelRenderer(this, 41, 0); // hipPetalRt1
		this.hipPetalRt[hipPetalRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalRt[hipPetalRtNumber][partNumber].addBox(-1.0F, -0.5F, -0.9F, 2, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalRt[hipPetalRtNumber][partNumber], 0.6981317007977318F, 0.0F, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][partNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][partNumber]);
		hipPetalRtNumber++;
		this.hipPetalRt[hipPetalRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalRt2Joint
		this.hipPetalRt[hipPetalRtNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalRt[hipPetalRtNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][jointNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][jointNumber]);
		this.hipPetalRt[hipPetalRtNumber][partNumber] = new ModelRenderer(this, 40, 2); // hipPetalRt2
		this.hipPetalRt[hipPetalRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalRt[hipPetalRtNumber][partNumber].addBox(-1.5F, -0.5F, -0.8F, 3, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalRt[hipPetalRtNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][partNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][partNumber]);
		hipPetalRtNumber++;
		this.hipPetalRt[hipPetalRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalRt3Joint
		this.hipPetalRt[hipPetalRtNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalRt[hipPetalRtNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][jointNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][jointNumber]);
		this.hipPetalRt[hipPetalRtNumber][partNumber] = new ModelRenderer(this, 40, 4); // hipPetalRt3
		this.hipPetalRt[hipPetalRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalRt[hipPetalRtNumber][partNumber].addBox(-1.5F, -0.5F, -0.8F, 3, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalRt[hipPetalRtNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][partNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][partNumber]);
		hipPetalRtNumber++;
		this.hipPetalRt[hipPetalRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalRt4Joint
		this.hipPetalRt[hipPetalRtNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalRt[hipPetalRtNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][jointNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][jointNumber]);
		this.hipPetalRt[hipPetalRtNumber][partNumber] = new ModelRenderer(this, 41, 6); // hipPetalRt4
		this.hipPetalRt[hipPetalRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalRt[hipPetalRtNumber][partNumber].addBox(-1.0F, -0.5F, -0.8F, 2, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalRt[hipPetalRtNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][partNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][partNumber]);
		hipPetalRtNumber++;
		this.hipPetalRt[hipPetalRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalRt5Joint
		this.hipPetalRt[hipPetalRtNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalRt[hipPetalRtNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][jointNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][jointNumber]);
		this.hipPetalRt[hipPetalRtNumber][partNumber] = new ModelRenderer(this, 41, 8); // hipPetalRt5
		this.hipPetalRt[hipPetalRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalRt[hipPetalRtNumber][partNumber].addBox(-1.0F, -0.5F, -0.8F, 2, 1, 1, 0.0F);
		this.setRotateAngle(hipPetalRt[hipPetalRtNumber][partNumber], 0.17453292519943295F, 0.0F, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][partNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][partNumber]);
		hipPetalRtNumber++;
		this.hipPetalRt[hipPetalRtNumber][jointNumber] = new ModelRenderer(this, 0, 0); // hipPetalRt6Joint
		this.hipPetalRt[hipPetalRtNumber][jointNumber].setRotationPoint(0.0F, 0.05F, -0.8F);
		this.hipPetalRt[hipPetalRtNumber][jointNumber].addBox(-1.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][jointNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][jointNumber]);
		this.hipPetalRt[hipPetalRtNumber][partNumber] = new ModelRenderer(this, 42, 10); // hipPetalRt6
		this.hipPetalRt[hipPetalRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipPetalRt[hipPetalRtNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		this.hipPetalRtInfo[hipPetalRtNumber][partNumber] = new PartInfo(hipPetalRt[hipPetalRtNumber][partNumber]);

		this.legLftJoint = new ModelRenderer(this, 0, 0);
		this.legLftJoint.setRotationPoint(0.6F, 0.0F, 0.0F);
		this.legLftJoint.addBox(-1.0F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		this.legLftJointInfo = new PartInfo(legLftJoint);
		this.legRtJoint = new ModelRenderer(this, 0, 0);
		this.legRtJoint.setRotationPoint(-0.6F, 0.0F, 0.0F);
		this.legRtJoint.addBox(-1.0F, -0.5F, -1.01F, 0, 0, 0, 0.0F);
		this.legRtJointInfo = new PartInfo(legRtJoint);

		int legPartNumber = 0;
		this.legLftMain[legPartNumber] = new ModelRenderer(this, 45, 23); // legLftMain1
		this.legLftMain[legPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legLftMain[legPartNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.legLftMainInfo[legPartNumber] = new PartInfo(legLftMain[legPartNumber]);
		legPartNumber++;
		this.legLftMain[legPartNumber] = new ModelRenderer(this, 45, 27); // legLftMain2
		this.legLftMain[legPartNumber].setRotationPoint(0.0F, 2.2F, 0.0F);
		this.legLftMain[legPartNumber].addBox(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
		this.legLftMainInfo[legPartNumber] = new PartInfo(legLftMain[legPartNumber]);
		legPartNumber = 0;
		this.legRtMain[legPartNumber] = new ModelRenderer(this, 40, 23); // legRtMain1
		this.legRtMain[legPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legRtMain[legPartNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.legRtMainInfo[legPartNumber] = new PartInfo(legRtMain[legPartNumber]);
		legPartNumber++;
		this.legRtMain[legPartNumber] = new ModelRenderer(this, 40, 27); // legRtMain2
		this.legRtMain[legPartNumber].setRotationPoint(0.0F, 2.2F, 0.0F);
		this.legRtMain[legPartNumber].addBox(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
		this.legRtMainInfo[legPartNumber] = new PartInfo(legRtMain[legPartNumber]);

		this.legLftLeggingJoint = new ModelRenderer(this, 0, 0);
		this.legLftLeggingJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legLftLeggingJoint.addBox(-1.0F, -0.5F, -1.01F, 0, 0, 0, 0.0F);
		this.legLftLeggingJointInfo = new PartInfo(legLftLeggingJoint);
		this.legRtLeggingJoint = new ModelRenderer(this, 0, 0);
		this.legRtLeggingJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legRtLeggingJoint.addBox(-1.3F, -0.5F, -1.01F, 0, 0, 0, 0.0F);
		this.legRtLeggingJointInfo = new PartInfo(legRtLeggingJoint);

		legPartNumber = 0;
		this.legLftLegging[legPartNumber] = new ModelRenderer(this, 48, 19); // legLftLegging1
		this.legLftLegging[legPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legLftLegging[legPartNumber].addBox(-0.9F, -0.6F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(legLftLegging[legPartNumber], 0.0F, 0.0F, -0.06981317007977318F);
		this.legLftLeggingInfo[legPartNumber] = new PartInfo(legLftLegging[legPartNumber]);
		legPartNumber++;
		this.legLftLegging[legPartNumber] = new ModelRenderer(this, 56, 19); // legLftLegging2
		this.legLftLegging[legPartNumber].setRotationPoint(0.0F, 1.7F, 0.0F);
		this.legLftLegging[legPartNumber].addBox(-0.9F, -0.2F, -1.0F, 2, 3, 2, 0.0F);
		this.legLftLeggingInfo[legPartNumber] = new PartInfo(legLftLegging[legPartNumber]);
		legPartNumber = 0;
		this.legRtLegging[legPartNumber] = new ModelRenderer(this, 31, 21); // legRtLegging1
		this.legRtLegging[legPartNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legRtLegging[legPartNumber].addBox(-1.1F, -0.6F, -1.01F, 2, 3, 2, 0.0F);
		this.setRotateAngle(legRtLegging[legPartNumber], 0.0F, 0.0F, 0.06981317007977318F);
		this.legRtLeggingInfo[legPartNumber] = new PartInfo(legRtLegging[legPartNumber]);
		legPartNumber++;
		this.legRtLegging[legPartNumber] = new ModelRenderer(this, 31, 26); // legRtLegging2
		this.legRtLegging[legPartNumber].setRotationPoint(0.0F, 1.7F, 0.0F);
		this.legRtLegging[legPartNumber].addBox(-1.1F, -0.2F, -1.01F, 2, 3, 2, 0.0F);
		this.legRtLeggingInfo[legPartNumber] = new PartInfo(legRtLegging[legPartNumber]);

		this.shoulderLft = new ModelRenderer(this, 27, 0);
		this.shoulderLft.setRotationPoint(1.5F, -3.9F, 0.0F);
		this.shoulderLft.addBox(-0.01F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.armLftJoint = new ModelRenderer(this, 0, 0);
		this.armLftJoint.setRotationPoint(0.5F, 0.0F, 0.0F);
		this.armLftJoint.addBox(-0.5F, -0.5F, -3.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftJoint, 0.9599310885968813F, -0.6981317007977318F, 0.0F);
		this.armLftJointInfo = new PartInfo(armLftJoint);
		this.armLft = new ModelRenderer(this, 25, 2);
		this.armLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLft.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		this.armLftInfo = new PartInfo(armLft);
		this.forearmLftJoint = new ModelRenderer(this, 0, 0);
		this.forearmLftJoint.setRotationPoint(0.0F, 0.0F, -2.7F);
		this.forearmLftJoint.addBox(-0.5F, -0.5F, -2.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(forearmLftJoint, -1.2217304763960306F, 0.0F, 0.0F);
		this.forearmLftJointInfo = new PartInfo(forearmLftJoint);
		this.forearmLft = new ModelRenderer(this, 25, 6);
		this.forearmLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.forearmLft.addBox(-0.49F, -0.5F, -2.8F, 1, 1, 3, 0.0F);
		this.forearmLftInfo = new PartInfo(forearmLft);

		this.clawLftJoint = new ModelRenderer(this, 0, 0);
		this.clawLftJoint.setRotationPoint(0.0F, 0.0F, -2.7F);
		this.clawLftJoint.addBox(-0.5F, -1.3F, -0.9F, 0, 0, 0, 0.0F);
		this.clawLftJointInfo = new PartInfo(clawLftJoint);
		this.clawLftTop2 = new ModelRenderer(this, 26, 11);
		this.clawLftTop2.setRotationPoint(0.0F, -0.9F, 0.0F);
		this.clawLftTop2.addBox(-0.6F, -0.7F, -0.4F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawLftTop2, -0.08726646259971647F, 0.0F, 0.0F);
		this.clawLftTop1 = new ModelRenderer(this, 25, 13);
		this.clawLftTop1.setRotationPoint(0.01F, -1.3F, -0.2F);
		this.clawLftTop1.addBox(-1.0F, -1.1F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(clawLftTop1, -0.17453292519943295F, 0.0F, 0.0F);
		this.clawLftBase = new ModelRenderer(this, 25, 15);
		this.clawLftBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.clawLftBase.addBox(-1.0F, -1.5F, -0.7F, 2, 3, 1, 0.0F);
		this.clawLftBaseInfo = new PartInfo(clawLftBase);
		this.clawLftBot1 = new ModelRenderer(this, 25, 19);
		this.clawLftBot1.setRotationPoint(0.01F, 1.5F, -0.2F);
		this.clawLftBot1.addBox(-1.0F, -0.1F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(clawLftBot1, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawLftBot2 = new ModelRenderer(this, 25, 21);
		this.clawLftBot2.setRotationPoint(0.0F, 0.8F, 0.0F);
		this.clawLftBot2.addBox(-1.0F, 0.0F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(clawLftBot2, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawLftBot3 = new ModelRenderer(this, 26, 23);
		this.clawLftBot3.setRotationPoint(0.0F, 0.8F, 0.0F);
		this.clawLftBot3.addBox(-0.51F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawLftBot3, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawLftBot4 = new ModelRenderer(this, 26, 25);
		this.clawLftBot4.setRotationPoint(0.0F, 0.8F, 0.0F);
		this.clawLftBot4.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawLftBot4, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawLftBot5 = new ModelRenderer(this, 26, 27);
		this.clawLftBot5.setRotationPoint(0.01F, 0.8F, 0.0F);
		this.clawLftBot5.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawLftBot5, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawLftTooth1 = new ModelRenderer(this, 31, 13);
		this.clawLftTooth1.setRotationPoint(-0.3F, 1.0F, 0.2F);
		this.clawLftTooth1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawLftTooth1, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
		this.clawLftTooth2 = new ModelRenderer(this, 31, 15);
		this.clawLftTooth2.setRotationPoint(-0.2F, -0.3F, 0.45F);
		this.clawLftTooth2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawLftTooth2, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
		this.clawLftTooth3 = new ModelRenderer(this, 31, 17);
		this.clawLftTooth3.setRotationPoint(-0.2F, -0.4F, 0.45F);
		this.clawLftTooth3.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawLftTooth3, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);

		this.shoulderRt = new ModelRenderer(this, 18, 0);
		this.shoulderRt.setRotationPoint(-1.5F, -3.9F, 0.0F);
		this.shoulderRt.addBox(-0.99F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.armRtJoint = new ModelRenderer(this, 0, 0);
		this.armRtJoint.setRotationPoint(-0.5F, 0.0F, 0.0F);
		this.armRtJoint.addBox(-0.5F, -0.5F, -3.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtJoint, 0.9599310885968813F, 0.6981317007977318F, 0.0F);
		this.armRtJointInfo = new PartInfo(armRtJoint);
		this.armRt = new ModelRenderer(this, 16, 2);
		this.armRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRt.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		this.armRtInfo = new PartInfo(armRt);
		this.forearmRtJoint = new ModelRenderer(this, 0, 0);
		this.forearmRtJoint.setRotationPoint(0.0F, 0.0F, -2.7F);
		this.forearmRtJoint.addBox(-0.5F, -0.5F, -2.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(forearmRtJoint, -1.2217304763960306F, 0.0F, 0.0F);
		this.forearmRtJointInfo = new PartInfo(forearmRtJoint);
		this.forearmRt = new ModelRenderer(this, 16, 6);
		this.forearmRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.forearmRt.addBox(-0.51F, -0.5F, -2.8F, 1, 1, 3, 0.0F);
		this.forearmRtInfo = new PartInfo(forearmRt);

		this.clawRtJoint = new ModelRenderer(this, 0, 0);
		this.clawRtJoint.setRotationPoint(0.0F, 0.0F, -2.7F);
		this.clawRtJoint.addBox(-0.5F, -1.3F, -0.9F, 0, 0, 0, 0.0F);
		this.clawRtJointInfo = new PartInfo(clawRtJoint);
		this.clawRtTop2 = new ModelRenderer(this, 19, 11);
		this.clawRtTop2.setRotationPoint(0.0F, -0.9F, 0.0F);
		this.clawRtTop2.addBox(-0.6F, -0.7F, -0.4F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawRtTop2, -0.08726646259971647F, 0.0F, 0.0F);
		this.clawRtTop1 = new ModelRenderer(this, 18, 13);
		this.clawRtTop1.setRotationPoint(0.01F, -1.3F, -0.2F);
		this.clawRtTop1.addBox(-1.0F, -1.1F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(clawRtTop1, -0.17453292519943295F, 0.0F, 0.0F);
		this.clawRtBase = new ModelRenderer(this, 18, 15);
		this.clawRtBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.clawRtBase.addBox(-1.0F, -1.5F, -0.7F, 2, 3, 1, 0.0F);
		this.clawRtBaseInfo = new PartInfo(clawRtBase);
		this.clawRtBot1 = new ModelRenderer(this, 18, 19);
		this.clawRtBot1.setRotationPoint(0.01F, 1.5F, -0.2F);
		this.clawRtBot1.addBox(-1.0F, -0.1F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(clawRtBot1, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawRtBot2 = new ModelRenderer(this, 18, 21);
		this.clawRtBot2.setRotationPoint(0.0F, 0.8F, 0.0F);
		this.clawRtBot2.addBox(-1.0F, 0.0F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(clawRtBot2, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawRtBot3 = new ModelRenderer(this, 19, 23);
		this.clawRtBot3.setRotationPoint(0.0F, 0.8F, 0.0F);
		this.clawRtBot3.addBox(-0.51F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawRtBot3, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawRtBot4 = new ModelRenderer(this, 19, 25);
		this.clawRtBot4.setRotationPoint(0.0F, 0.8F, 0.0F);
		this.clawRtBot4.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawRtBot4, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawRtBot5 = new ModelRenderer(this, 19, 27);
		this.clawRtBot5.setRotationPoint(0.01F, 0.8F, 0.0F);
		this.clawRtBot5.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawRtBot5, 0.17453292519943295F, 0.0F, 0.0F);
		this.clawRtTooth1 = new ModelRenderer(this, 14, 13);
		this.clawRtTooth1.setRotationPoint(-0.3F, 1.0F, 0.2F);
		this.clawRtTooth1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawRtTooth1, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
		this.clawRtTooth2 = new ModelRenderer(this, 14, 15);
		this.clawRtTooth2.setRotationPoint(-0.2F, -0.3F, 0.45F);
		this.clawRtTooth2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawRtTooth2, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
		this.clawRtTooth3 = new ModelRenderer(this, 14, 17);
		this.clawRtTooth3.setRotationPoint(-0.2F, -0.4F, 0.45F);
		this.clawRtTooth3.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(clawRtTooth3, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);

		this.neck = new ModelRenderer(this, 13, 0);
		this.neck.setRotationPoint(0.0F, -4.5F, 0.0F);
		this.neck.addBox(-0.5F, -2.0F, -0.5F, 1, 3, 1, 0.0F);
		this.neckInfo = new PartInfo(neck);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.headJoint.addBox(-1.5F, -2.5F, -1.5F, 0, 0, 0, 0.0F);
		this.headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-1.5F, -2.5F, -1.5F, 3, 3, 3, 0.0F);
		this.head.setTextureOffset(38, 14).addBox(-1.51F, -1.5F, -1.52F, 3, 2, 1, 0.0F); // headFace
		this.headInfo = new PartInfo(head);

		this.eyeRt = new ModelRenderer(this, 12, 4);
		this.eyeRt.setRotationPoint(-1.0F, -1.0F, -1.51F);
		this.eyeRt.addBox(-0.25F, -0.2F, 0.0F, 1, 1, 1, 0.0F);
		this.eyeRtInfo = new PartInfo(eyeRt);
		this.eyeLft = new ModelRenderer(this, 12, 4);
		this.eyeLft.mirror = true;
		this.eyeLft.setRotationPoint(1.0F, -1.0F, -1.51F);
		this.eyeLft.addBox(-0.75F, -0.2F, 0.0F, 1, 1, 1, 0.0F);
		this.eyeLftInfo = new PartInfo(eyeLft);

		this.headGem = new ModelRenderer(this, 9, 0);
		this.headGem.setRotationPoint(0.0F, -1.78F, -1.0F);
		this.headGem.addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		this.setRotateAngle(headGem, 0.0F, 0.0F, 0.7853981633974483F);

		int cheekWhiskerLftNumber = 0;
		this.cheekWhiskerLft[cheekWhiskerLftNumber] = new ModelRenderer(this, 0, 9); // cheekWhiskerLft1
		this.cheekWhiskerLft[cheekWhiskerLftNumber].setRotationPoint(1.0F, -0.1F, -0.8F);
		this.cheekWhiskerLft[cheekWhiskerLftNumber].addBox(0.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(cheekWhiskerLft[cheekWhiskerLftNumber], 0.3490658503988659F, 0.0F, 0.3490658503988659F);
		this.cheekWhiskerLftInfo[cheekWhiskerLftNumber] = new PartInfo(cheekWhiskerLft[cheekWhiskerLftNumber]);
		cheekWhiskerLftNumber++;
		this.cheekWhiskerLft[cheekWhiskerLftNumber] = new ModelRenderer(this, 4, 9); // cheekWhiskerLft2
		this.cheekWhiskerLft[cheekWhiskerLftNumber].setRotationPoint(1.0F, 0.0F, 0.0F);
		this.cheekWhiskerLft[cheekWhiskerLftNumber].addBox(-0.2F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.cheekWhiskerLftInfo[cheekWhiskerLftNumber] = new PartInfo(cheekWhiskerLft[cheekWhiskerLftNumber]);
		cheekWhiskerLftNumber++;
		this.cheekWhiskerLft[cheekWhiskerLftNumber] = new ModelRenderer(this, 8, 9); // cheekWhiskerLft3
		this.cheekWhiskerLft[cheekWhiskerLftNumber].setRotationPoint(0.8F, 0.0F, 0.0F);
		this.cheekWhiskerLft[cheekWhiskerLftNumber].addBox(-0.2F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.cheekWhiskerLftInfo[cheekWhiskerLftNumber] = new PartInfo(cheekWhiskerLft[cheekWhiskerLftNumber]);
		cheekWhiskerLftNumber++;
		this.cheekWhiskerLft[cheekWhiskerLftNumber] = new ModelRenderer(this, 12, 9); // cheekWhiskerLft4
		this.cheekWhiskerLft[cheekWhiskerLftNumber].setRotationPoint(0.8F, 0.0F, 0.0F);
		this.cheekWhiskerLft[cheekWhiskerLftNumber].addBox(-0.2F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.cheekWhiskerLftInfo[cheekWhiskerLftNumber] = new PartInfo(cheekWhiskerLft[cheekWhiskerLftNumber]);

		int cheekWhiskerRtNumber = 0;
		this.cheekWhiskerRt[cheekWhiskerRtNumber] = new ModelRenderer(this, 12, 7); // cheekWhiskerRt1
		this.cheekWhiskerRt[cheekWhiskerRtNumber].setRotationPoint(-1.0F, -0.1F, -0.8F);
		this.cheekWhiskerRt[cheekWhiskerRtNumber].addBox(-1.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(cheekWhiskerRt[cheekWhiskerRtNumber], 0.3490658503988659F, 0.0F, -0.3490658503988659F);
		this.cheekWhiskerRtInfo[cheekWhiskerRtNumber] = new PartInfo(cheekWhiskerRt[cheekWhiskerRtNumber]);
		cheekWhiskerRtNumber++;
		this.cheekWhiskerRt[cheekWhiskerRtNumber] = new ModelRenderer(this, 8, 7); // cheekWhiskerRt2
		this.cheekWhiskerRt[cheekWhiskerRtNumber].setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.cheekWhiskerRt[cheekWhiskerRtNumber].addBox(-0.8F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.cheekWhiskerRtInfo[cheekWhiskerRtNumber] = new PartInfo(cheekWhiskerRt[cheekWhiskerRtNumber]);
		cheekWhiskerRtNumber++;
		this.cheekWhiskerRt[cheekWhiskerRtNumber] = new ModelRenderer(this, 4, 7); // cheekWhiskerRt3
		this.cheekWhiskerRt[cheekWhiskerRtNumber].setRotationPoint(-0.8F, 0.0F, 0.0F);
		this.cheekWhiskerRt[cheekWhiskerRtNumber].addBox(-0.8F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.cheekWhiskerRtInfo[cheekWhiskerRtNumber] = new PartInfo(cheekWhiskerRt[cheekWhiskerRtNumber]);
		cheekWhiskerRtNumber++;
		this.cheekWhiskerRt[cheekWhiskerRtNumber] = new ModelRenderer(this, 0, 7); // cheekWhiskerRt4
		this.cheekWhiskerRt[cheekWhiskerRtNumber].setRotationPoint(-0.8F, 0.0F, 0.0F);
		this.cheekWhiskerRt[cheekWhiskerRtNumber].addBox(-0.8F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.cheekWhiskerRtInfo[cheekWhiskerRtNumber] = new PartInfo(cheekWhiskerRt[cheekWhiskerRtNumber]);

		this.antennaFntRt = new ModelRenderer(this, 4, 12);
		this.antennaFntRt.setRotationPoint(-0.7F, -2.5F, -1.0F);
		this.antennaFntRt.addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(antennaFntRt, -0.3490658503988659F, 0.0F, -0.17453292519943295F);
		this.antennaFntRtInfo = new PartInfo(antennaFntRt);
		this.antennaFntLft = new ModelRenderer(this, 9, 12);
		this.antennaFntLft.setRotationPoint(0.7F, -2.5F, -1.0F);
		this.antennaFntLft.addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(antennaFntLft, -0.3490658503988659F, 0.0F, 0.17453292519943295F);
		this.antennaFntLftInfo = new PartInfo(antennaFntLft);

		int antennaBckLftNumber = 0;
		this.antennaBckLft[antennaBckLftNumber] = new ModelRenderer(this, 9, 30); // antennaBckLft1
		this.antennaBckLft[antennaBckLftNumber].setRotationPoint(1.2F, -2.2F, 0.0F);
		this.antennaBckLft[antennaBckLftNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(antennaBckLft[antennaBckLftNumber], -0.3490658503988659F, 0.0F, 0.4363323129985824F);
		this.antennaBckLftInfo[antennaBckLftNumber] = new PartInfo(antennaBckLft[antennaBckLftNumber]);
		antennaBckLftNumber++;
		this.antennaBckLft[antennaBckLftNumber] = new ModelRenderer(this, 8, 28); // antennaBckLft2
		this.antennaBckLft[antennaBckLftNumber].setRotationPoint(0.0F, -0.4F, 0.0F);
		this.antennaBckLft[antennaBckLftNumber].addBox(-1.0F, -0.9F, -0.5F, 2, 1, 1, 0.0F);
		this.antennaBckLftInfo[antennaBckLftNumber] = new PartInfo(antennaBckLft[antennaBckLftNumber]);
		antennaBckLftNumber++;
		this.antennaBckLft[antennaBckLftNumber] = new ModelRenderer(this, 8, 26); // antennaBckLft3
		this.antennaBckLft[antennaBckLftNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckLft[antennaBckLftNumber].addBox(-1.0F, -0.8F, -0.5F, 2, 1, 1, 0.0F);
		this.antennaBckLftInfo[antennaBckLftNumber] = new PartInfo(antennaBckLft[antennaBckLftNumber]);
		antennaBckLftNumber++;
		this.antennaBckLft[antennaBckLftNumber] = new ModelRenderer(this, 8, 24); // antennaBckLft4
		this.antennaBckLft[antennaBckLftNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckLft[antennaBckLftNumber].addBox(-1.0F, -0.8F, -0.5F, 2, 1, 1, 0.0F);
		this.antennaBckLftInfo[antennaBckLftNumber] = new PartInfo(antennaBckLft[antennaBckLftNumber]);
		antennaBckLftNumber++;
		this.antennaBckLft[antennaBckLftNumber] = new ModelRenderer(this, 9, 22); // antennaBckLft5
		this.antennaBckLft[antennaBckLftNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckLft[antennaBckLftNumber].addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
		this.antennaBckLftInfo[antennaBckLftNumber] = new PartInfo(antennaBckLft[antennaBckLftNumber]);

		antennaBckLftNumber = 0;
		this.antennaBckLftSide[antennaBckLftNumber] = new ModelRenderer(this, 9, 19); // antennaBckLftSide1
		this.antennaBckLftSide[antennaBckLftNumber].setRotationPoint(0.7F, -0.8F, 0.05F);
		this.antennaBckLftSide[antennaBckLftNumber].addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(antennaBckLftSide[antennaBckLftNumber], -0.17453292519943295F, 0.0F, 0.3490658503988659F);
		this.antennaBckLftSideInfo[antennaBckLftNumber] = new PartInfo(antennaBckLftSide[antennaBckLftNumber]);
		antennaBckLftNumber++;
		this.antennaBckLftSide[antennaBckLftNumber] = new ModelRenderer(this, 9, 17); // antennaBckLftSide2
		this.antennaBckLftSide[antennaBckLftNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckLftSide[antennaBckLftNumber].addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(antennaBckLftSide[antennaBckLftNumber], -0.17453292519943295F, 0.0F, 0.3490658503988659F);
		this.antennaBckLftSideInfo[antennaBckLftNumber] = new PartInfo(antennaBckLftSide[antennaBckLftNumber]);

		int antennaBckRtNumber = 0;
		this.antennaBckRt[antennaBckRtNumber] = new ModelRenderer(this, 2, 30); // antennaBckRt1
		this.antennaBckRt[antennaBckRtNumber].setRotationPoint(-1.2F, -2.2F, 0.0F);
		this.antennaBckRt[antennaBckRtNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(antennaBckRt[antennaBckRtNumber], -0.3490658503988659F, 0.0F, -0.4363323129985824F);
		this.antennaBckRtInfo[antennaBckRtNumber] = new PartInfo(antennaBckRt[antennaBckRtNumber]);
		antennaBckRtNumber++;
		this.antennaBckRt[antennaBckRtNumber] = new ModelRenderer(this, 1, 28); // antennaBckRt2
		this.antennaBckRt[antennaBckRtNumber].setRotationPoint(0.0F, -0.4F, 0.0F);
		this.antennaBckRt[antennaBckRtNumber].addBox(-1.0F, -0.9F, -0.5F, 2, 1, 1, 0.0F);
		this.antennaBckRtInfo[antennaBckRtNumber] = new PartInfo(antennaBckRt[antennaBckRtNumber]);
		antennaBckRtNumber++;
		this.antennaBckRt[antennaBckRtNumber] = new ModelRenderer(this, 1, 26); // antennaBckRt3
		this.antennaBckRt[antennaBckRtNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckRt[antennaBckRtNumber].addBox(-1.0F, -0.8F, -0.5F, 2, 1, 1, 0.0F);
		this.antennaBckRtInfo[antennaBckRtNumber] = new PartInfo(antennaBckRt[antennaBckRtNumber]);
		antennaBckRtNumber++;
		this.antennaBckRt[antennaBckRtNumber] = new ModelRenderer(this, 1, 24); // antennaBckRt4
		this.antennaBckRt[antennaBckRtNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckRt[antennaBckRtNumber].addBox(-1.0F, -0.8F, -0.5F, 2, 1, 1, 0.0F);
		this.antennaBckRtInfo[antennaBckRtNumber] = new PartInfo(antennaBckRt[antennaBckRtNumber]);
		antennaBckRtNumber++;
		this.antennaBckRt[antennaBckRtNumber] = new ModelRenderer(this, 2, 22); // antennaBckRt5
		this.antennaBckRt[antennaBckRtNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckRt[antennaBckRtNumber].addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
		this.antennaBckRtInfo[antennaBckRtNumber] = new PartInfo(antennaBckRt[antennaBckRtNumber]);

		antennaBckRtNumber = 0;
		this.antennaBckRtSide[antennaBckRtNumber] = new ModelRenderer(this, 2, 19); // antennaBckRtSide1
		this.antennaBckRtSide[antennaBckRtNumber].setRotationPoint(-0.7F, -0.8F, 0.05F);
		this.antennaBckRtSide[antennaBckRtNumber].addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(antennaBckRtSide[antennaBckRtNumber], -0.17453292519943295F, 0.0F, -0.3490658503988659F);
		this.antennaBckRtSideInfo[antennaBckRtNumber] = new PartInfo(antennaBckRtSide[antennaBckRtNumber]);
		antennaBckRtNumber++;
		this.antennaBckRtSide[antennaBckRtNumber] = new ModelRenderer(this, 2, 17); // antennaBckRtSide2
		this.antennaBckRtSide[antennaBckRtNumber].setRotationPoint(0.0F, -0.8F, 0.0F);
		this.antennaBckRtSide[antennaBckRtNumber].addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(antennaBckRtSide[antennaBckRtNumber], -0.17453292519943295F, 0.0F, -0.3490658503988659F);
		this.antennaBckRtSideInfo[antennaBckRtNumber] = new PartInfo(antennaBckRtSide[antennaBckRtNumber]);

		this.bodyJoint.addChild(this.body);
		this.bodyJoint.addChild(this.hipPetalLft[0][0]);
		this.bodyJoint.addChild(this.hipPetalRt[0][0]);
		this.bodyJoint.addChild(this.legLftJoint);
		this.bodyJoint.addChild(this.legRtJoint);

		this.body.addChild(this.backPetalBotLft);
		this.body.addChild(this.backPetalBotRt);
		this.body.addChild(this.backPetalTopLft);
		this.body.addChild(this.backPetalTopRt);
		this.body.addChild(this.neck);
		this.body.addChild(this.shoulderLft);
		this.body.addChild(this.shoulderRt);

		for(int i = 0; i < hipPetalLft.length - 1; i++)
		{
			this.hipPetalLft[i][0].addChild(this.hipPetalLft[i][1]);
			this.hipPetalLft[i][1].addChild(this.hipPetalLft[i + 1][0]);

			this.hipPetalRt[i][0].addChild(this.hipPetalRt[i][1]);
			this.hipPetalRt[i][1].addChild(this.hipPetalRt[i + 1][0]);
		}

		this.hipPetalLft[hipPetalLft.length - 1][0].addChild(this.hipPetalLft[hipPetalLft.length - 1][1]);
		this.hipPetalRt[hipPetalRt.length - 1][0].addChild(this.hipPetalRt[hipPetalRt.length - 1][1]);

		this.legLftJoint.addChild(this.legLftLeggingJoint);
		this.legLftJoint.addChild(this.legLftMain[0]);
		this.legLftMain[0].addChild(this.legLftMain[1]);
		this.legLftLeggingJoint.addChild(this.legLftLegging[0]);
		this.legLftLegging[0].addChild(this.legLftLegging[1]);
		this.legRtJoint.addChild(this.legRtLeggingJoint);
		this.legRtJoint.addChild(this.legRtMain[0]);
		this.legRtMain[0].addChild(this.legRtMain[1]);
		this.legRtLeggingJoint.addChild(this.legRtLegging[0]);
		this.legRtLegging[0].addChild(this.legRtLegging[1]);

		this.shoulderLft.addChild(this.armLftJoint);
		this.armLftJoint.addChild(this.armLft);
		this.armLft.addChild(this.forearmLftJoint);
		this.forearmLftJoint.addChild(this.forearmLft);
		this.forearmLft.addChild(this.clawLftJoint);

		this.shoulderRt.addChild(this.armRtJoint);
		this.armRtJoint.addChild(this.armRt);
		this.armRt.addChild(this.forearmRtJoint);
		this.forearmRtJoint.addChild(this.forearmRt);
		this.forearmRt.addChild(this.clawRtJoint);

		this.clawLftBase.addChild(this.clawLftBot1);
		this.clawLftBase.addChild(this.clawLftTooth1);
		this.clawLftBase.addChild(this.clawLftTop1);
		this.clawLftBot1.addChild(this.clawLftBot2);
		this.clawLftBot2.addChild(this.clawLftBot3);
		this.clawLftBot2.addChild(this.clawLftTooth2);
		this.clawLftBot3.addChild(this.clawLftBot4);
		this.clawLftBot3.addChild(this.clawLftTooth3);
		this.clawLftBot4.addChild(this.clawLftBot5);
		this.clawLftJoint.addChild(this.clawLftBase);
		this.clawLftTop1.addChild(this.clawLftTop2);

		this.clawRtBase.addChild(this.clawRtBot1);
		this.clawRtBase.addChild(this.clawRtTooth1);
		this.clawRtBase.addChild(this.clawRtTop1);
		this.clawRtBot1.addChild(this.clawRtBot2);
		this.clawRtBot2.addChild(this.clawRtBot3);
		this.clawRtBot2.addChild(this.clawRtTooth2);
		this.clawRtBot3.addChild(this.clawRtBot4);
		this.clawRtBot3.addChild(this.clawRtTooth3);
		this.clawRtBot4.addChild(this.clawRtBot5);
		this.clawRtJoint.addChild(this.clawRtBase);
		this.clawRtTop1.addChild(this.clawRtTop2);

		this.neck.addChild(this.headJoint);
		this.headJoint.addChild(this.head);

		this.head.addChild(this.antennaBckLft[0]);
		this.head.addChild(this.antennaBckRt[0]);
		this.head.addChild(this.antennaFntLft);
		this.head.addChild(this.antennaFntRt);
		this.head.addChild(this.cheekWhiskerLft[0]);
		this.head.addChild(this.cheekWhiskerRt[0]);
		this.head.addChild(this.eyeLft);
		this.head.addChild(this.eyeRt);
		this.head.addChild(this.headGem);

		for(int i = 0; i < antennaBckLft.length - 1; i++)
		{
			this.antennaBckLft[i].addChild(this.antennaBckLft[i + 1]);
			this.antennaBckRt[i].addChild(this.antennaBckRt[i + 1]);
		}

		this.antennaBckLft[1].addChild(this.antennaBckLftSide[0]);
		this.antennaBckLftSide[0].addChild(this.antennaBckLftSide[1]);
		this.antennaBckRt[1].addChild(this.antennaBckRtSide[0]);
		this.antennaBckRtSide[0].addChild(this.antennaBckRtSide[1]);

		for(int i = 0; i < cheekWhiskerLft.length - 1; i++)
		{
			this.cheekWhiskerLft[i].addChild(this.cheekWhiskerLft[i + 1]);
			this.cheekWhiskerRt[i].addChild(this.cheekWhiskerRt[i + 1]);
		}

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
		/* Static references to array lengths in Entity class from Model class
		 * makes the glow/normal models not animate in sync. */
		this.animationDeployer.update((IAnimatedEntity)entity);
		resetPartInfos();

		float angularVelocity = ((IMobMotionTracker)entity).getAngularVelocity();
		float headAngularVelocity = ((IHeadMobMotionTracker)entity).getHeadAngularVelocity();
		float verticleVelocity = ((IMobMotionTracker)entity).getHeightVelocity();

		float idleDampener = 1F;
		/*
		if(!((EntityDeathBlossomLurantis)entity).isSitting())
		{
			if(animationDeployer.getEntity().getAnimationID() == LibraryOkamiPokemonAttackID.GLAIVE_SLASH || 
					animationDeployer.getEntity().getAnimationID() == LibraryOkamiPokemonAttackID.GLAIVE_SLASH_REVERSE)
			{
				idleDampener = animateSlash(animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
			}
		}
		 */
		/*
		float tempBaseVelocity = 0.9F;
		tempDistanceMoved += 0.45F;

		animateBody((EntityDeathBlossomLurantis)entity, tempDistanceMoved, tempBaseVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, angularVelocity, verticleVelocity);
		animateHead((EntityDeathBlossomLurantis)entity, tempDistanceMoved, tempBaseVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, headAngularVelocity, angularVelocity, verticleVelocity);
		animateLegs((EntityDeathBlossomLurantis)entity, tempDistanceMoved, tempBaseVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity);
		 */
		animateBody((EntityDeathBlossomLurantis)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, angularVelocity, verticleVelocity);
		animateHead((EntityDeathBlossomLurantis)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, headAngularVelocity, angularVelocity, verticleVelocity);
		animateLegs((EntityDeathBlossomLurantis)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, angularVelocity, verticleVelocity);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		bodyInfo.resetNewAngles();
		bodyJointInfo.resetNewAngles();
		bodyJointInfo.resetNewPnt();

		armLftJointInfo.resetNewAngles();
		armLftInfo.resetNewAngles();
		forearmLftJointInfo.resetNewAngles();
		forearmLftInfo.resetNewAngles();
		clawLftJointInfo.resetNewAngles();

		armRtJointInfo.resetNewAngles();
		armRtInfo.resetNewAngles();
		forearmRtJointInfo.resetNewAngles();
		forearmRtInfo.resetNewAngles();
		clawRtJointInfo.resetNewAngles();

		legLftJointInfo.resetNewAngles();
		legRtJointInfo.resetNewAngles();

		for(int i = 0; i < legRtMain.length; i++)
		{
			legRtMainInfo[i].resetNewAngles();
			legLftMainInfo[i].resetNewAngles();
		}

		for(int i = 0; i < legRtLegging.length; i++)
		{
			legRtLeggingInfo[i].resetNewAngles();
			legLftLeggingInfo[i].resetNewAngles();
		}

		for(int i = 0; i < hipPetalRt.length; i++)
		{
			for(int j = 0; j < hipPetalRt[i].length; j++)
			{
				hipPetalRtInfo[i][j].resetNewAngles();
				hipPetalLftInfo[i][j].resetNewAngles();
			}
		}

		for(int i = 0; i < cheekWhiskerLft.length; i++)
		{
			cheekWhiskerLftInfo[i].resetNewAngles();
			cheekWhiskerRtInfo[i].resetNewAngles();
		}

		antennaFntRtInfo.resetNewAngles();
		antennaFntLftInfo.resetNewAngles();

		for(int i = 0; i < antennaBckLft.length; i++)
		{
			antennaBckLftInfo[i].resetNewAngles();
			antennaBckRtInfo[i].resetNewAngles();
		}

		for(int i = 0; i < antennaBckLftSide.length; i++)
		{
			antennaBckLftSideInfo[i].resetNewAngles();
			antennaBckRtSideInfo[i].resetNewAngles();
		}
	}

	public void animateBody(EntityDeathBlossomLurantis entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float angularVelocity, float verticalVelocity)
	{
		if(!entity.isSitting())
		{
			float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
			float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

			float walkMaximumChangeY = 0.75F;
			float runMaximumChangeY = 1.1F;

			float walkCyclePointChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI + PI/2) * walkMaximumChangeY * (1 - horzVelocity);
			float runCyclePointChange = MathHelper.cos(2 * runCycleInterval * 2 * PI + PI/2) * runMaximumChangeY * horzVelocity;

			float defaultNonSitPointShiftY = 0.5F;

			bodyJointInfo.setNewPointY(bodyJointInfo.getNewPointY() + (walkCyclePointChange + runCyclePointChange) * horzVelocity * (1F - Math.abs(verticalVelocity)) + defaultNonSitPointShiftY);

			float bodyWalkAngle = (float)Math.toRadians(3);
			float bodyRunAngle = (float)Math.toRadians(5);

			float defaultNonSitAngleShiftX = (float)Math.toRadians(-10);

			float walkCycleAngleChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI + PI/2) * bodyWalkAngle * (1 - horzVelocity)
					+ bodyWalkAngle * (1 - horzVelocity);
			float runCycleAngleChange = MathHelper.cos(2 * runCycleInterval * 2 * PI + PI/2) * bodyRunAngle * horzVelocity
					+ bodyRunAngle * horzVelocity;

			bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + (walkCycleAngleChange + runCycleAngleChange) * horzVelocity * idleDampener);

			/* ******************* */
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBody();

			float idleAmplitudeX = 0.09F;

			float angleChangeX = (-MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX) * (1 - horzVelocity) + defaultNonSitAngleShiftX;

			bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() - angleChangeX * idleDampener * (1F - Math.abs(verticalVelocity)));
		}
		else
		{
			bodyInfo.setNewRotateX(0F);
		}
	}

	public void animateHead(EntityDeathBlossomLurantis entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float headAngularVelocity, float angularVelocity, float verticalVelocity)
	{
		JointAnimation.reverseJointRotatesChange(bodyInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.9F * idleDampener, 0.9F * idleDampener);

		if(!entity.isSitting())
		{
			float walkCycleInterval = (WALK_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);
			float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

			float walkAngle = (float)Math.toRadians(-3F);
			float runAngle = (float)Math.toRadians(-5);

			float walkCycleAngleChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity)
					+ walkAngle * (1 - horzVelocity);
			float runCycleAngleChange = MathHelper.cos(2 * runCycleInterval * 2 * PI) * runAngle * horzVelocity
					+ runAngle * horzVelocity;

			float newVerticalVelocity = 1.5F * verticalVelocity;

			if(newVerticalVelocity > 1F)
				newVerticalVelocity = 1F;
			else if(newVerticalVelocity < -1F)
				newVerticalVelocity = -1F;

			/* ******************* */
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBody();
			float angleChangeY = 0;
			float angleChangeZ = 0;

			float idleAmplitudeZ = (float)Math.toRadians(10);

			walkAngle = (float)Math.toRadians(5);
			runAngle = (float)Math.toRadians(10);

			float fallingTuffsAngle = (float)Math.toRadians(-25);
			float yawChangeAngle = -(float)Math.toRadians(15);

			float headTotalVelocity = headAngularVelocity + angularVelocity;

			for(int i = 0; i < cheekWhiskerLft.length; i++)
			{
				walkCycleAngleChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity);
				runCycleAngleChange = MathHelper.cos(2 * runCycleInterval * 2 * PI) * runAngle * horzVelocity;

				cheekWhiskerLftInfo[i].setNewRotateZ(cheekWhiskerLftInfo[i].getNewRotateZ() 
						+ ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
								- fallingTuffsAngle * newVerticalVelocity));
				cheekWhiskerRtInfo[i].setNewRotateZ(cheekWhiskerRtInfo[i].getNewRotateZ() 
						- ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
								- fallingTuffsAngle * newVerticalVelocity));

				angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI
						- ((float)(i + 2) * (PI/(float)4))) * idleAmplitudeZ * (1 - horzVelocity);

				cheekWhiskerLftInfo[i].setNewRotateZ(cheekWhiskerLftInfo[i].getNewRotateZ() 
						+ (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));
				cheekWhiskerRtInfo[i].setNewRotateZ(cheekWhiskerRtInfo[i].getNewRotateZ() 
						- (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));

				angleChangeY += headTotalVelocity * yawChangeAngle * ((float)i / (float)(cheekWhiskerLft.length - 1));

				cheekWhiskerLftInfo[i].setNewRotateY(cheekWhiskerLftInfo[i].getNewRotateY() + angleChangeY);
				cheekWhiskerRtInfo[i].setNewRotateY(cheekWhiskerRtInfo[i].getNewRotateY() + angleChangeY);
			}

			/* ******************* */
			idleAmplitudeZ = (float)Math.toRadians(10);
			float idleAmplitudeX = (float)Math.toRadians(1);

			walkAngle = (float)Math.toRadians(5);
			runAngle = (float)Math.toRadians(10);

			float fallingAntennaBckAngle = (float)Math.toRadians(-20);
			yawChangeAngle = -(float)Math.toRadians(8);

			float angleChangeX = 0;

			for(int i = 0; i < antennaBckLft.length; i++)
			{
				walkCycleAngleChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity);
				runCycleAngleChange = MathHelper.cos(2 * runCycleInterval * 2 * PI) * runAngle * horzVelocity;

				antennaBckLftInfo[i].setNewRotateZ(antennaBckLftInfo[i].getNewRotateZ() 
						+ ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
								- fallingAntennaBckAngle * (newVerticalVelocity <= -0.3F ? -0.3F : newVerticalVelocity)));
				antennaBckRtInfo[i].setNewRotateZ(antennaBckRtInfo[i].getNewRotateZ() 
						- ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
								- fallingAntennaBckAngle * (newVerticalVelocity <= -0.3F ? -0.3F : newVerticalVelocity)));

				angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI
						- ((float)(i + 2) * (PI/(float)4))) * idleAmplitudeZ * (1 - horzVelocity);

				antennaBckLftInfo[i].setNewRotateZ(antennaBckLftInfo[i].getNewRotateZ() 
						+ (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));
				antennaBckRtInfo[i].setNewRotateZ(antennaBckRtInfo[i].getNewRotateZ() 
						- (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));

				angleChangeX += headTotalVelocity * yawChangeAngle * ((float)i / (float)(antennaBckLft.length - 1));

				angleChangeX += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI
						- ((float)(i + 2) * (PI/(float)4))) * idleAmplitudeX * (1 - horzVelocity);

				antennaBckLftInfo[i].setNewRotateX(antennaBckLftInfo[i].getNewRotateX() + angleChangeX);
				antennaBckRtInfo[i].setNewRotateX(antennaBckRtInfo[i].getNewRotateX() - angleChangeX);

				if(i > antennaBckLft.length - antennaBckLftSide.length)
				{
					int current_i = i - (antennaBckLft.length - antennaBckLftSide.length);

					antennaBckLftSideInfo[current_i].setNewRotateZ(antennaBckLftSideInfo[current_i].getNewRotateZ() 
							+ ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
									- fallingAntennaBckAngle * (newVerticalVelocity <= -0.3F ? -0.3F : newVerticalVelocity)));
					antennaBckRtSideInfo[current_i].setNewRotateZ(antennaBckRtSideInfo[current_i].getNewRotateZ() 
							- ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
									- fallingAntennaBckAngle * (newVerticalVelocity <= -0.3F ? -0.3F : newVerticalVelocity)));

					antennaBckLftSideInfo[current_i].setNewRotateZ(antennaBckLftSideInfo[current_i].getNewRotateZ() 
							+ (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));
					antennaBckRtSideInfo[current_i].setNewRotateZ(antennaBckRtSideInfo[current_i].getNewRotateZ() 
							- (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));

					antennaBckLftSideInfo[current_i].setNewRotateX(antennaBckLftSideInfo[current_i].getNewRotateX() + angleChangeX);
					antennaBckRtSideInfo[current_i].setNewRotateX(antennaBckRtSideInfo[current_i].getNewRotateX() - angleChangeX);
				}
			}

			/* ******************* */
			idleAmplitudeZ = (float)Math.toRadians(10);
			idleAmplitudeX = (float)Math.toRadians(1);

			walkAngle = (float)Math.toRadians(5);
			runAngle = (float)Math.toRadians(10);

			float fallingAntennaFntAngle = (float)Math.toRadians(-20);
			yawChangeAngle = -(float)Math.toRadians(8);

			angleChangeX = 0;

			walkCycleAngleChange = MathHelper.cos(2 * walkCycleInterval * 2 * PI) * walkAngle * (1 - horzVelocity);
			runCycleAngleChange = MathHelper.cos(2 * runCycleInterval * 2 * PI) * runAngle * horzVelocity;

			antennaFntLftInfo.setNewRotateZ(antennaFntLftInfo.getNewRotateZ() 
					+ ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
							- fallingAntennaFntAngle * (newVerticalVelocity <= -0.3F ? -0.3F : newVerticalVelocity)));
			antennaFntRtInfo.setNewRotateZ(antennaFntRtInfo.getNewRotateZ() 
					- ((walkCycleAngleChange + runCycleAngleChange) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) 
							- fallingAntennaFntAngle * (newVerticalVelocity <= -0.3F ? -0.3F : newVerticalVelocity)));

			angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeZ * (1 - horzVelocity);

			antennaFntLftInfo.setNewRotateZ(antennaFntLftInfo.getNewRotateZ() 
					+ (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));
			antennaFntRtInfo.setNewRotateZ(antennaFntRtInfo.getNewRotateZ() 
					- (angleChangeZ * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity))));

			angleChangeX += headTotalVelocity * yawChangeAngle;

			angleChangeX += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX * (1 - horzVelocity);

			antennaFntLftInfo.setNewRotateX(antennaFntLftInfo.getNewRotateX() + angleChangeX);
			antennaFntRtInfo.setNewRotateX(antennaFntRtInfo.getNewRotateX() - angleChangeX);

			/*
			float idleAmplitudeZ = 0.13F;

			// + (float)Math.toRadians(45)
			float angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI) * idleAmplitudeZ * (1 - horzVelocity);

			earRtInfo.setNewRotateZ(earRtInfo.getNewRotateZ() - angleChangeZ);
			earLftInfo.setNewRotateZ(earLftInfo.getNewRotateZ() + angleChangeZ);

			/* ******************* */
			/*
			idleAmplitudeZ = 0.18F;

			for(int i = 0; i < cheekWhiskerLft.length; i++)
			{
				angleChangeZ = MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI
						- ((i + 2) * (PI/2))) * idleAmplitudeZ * (1 - horzVelocity);

				cheekWhiskerLftInfo[i].setNewRotateZ(cheekWhiskerLftInfo[i].getNewRotateZ() - angleChangeZ);
				cheekWhiskerRtInfo[i].setNewRotateZ(cheekWhiskerRtInfo[i].getNewRotateZ() + angleChangeZ);
			}*/
		}

		if(entity.isTamed())
		{
			float healthChangeAngle = (float)Math.toRadians(-75);

			antennaFntLftInfo.setNewRotateZ(antennaFntLftInfo.getNewRotateZ() - (1F - entity.getHealthPercent()) * healthChangeAngle);
			antennaFntRtInfo.setNewRotateZ(antennaFntRtInfo.getNewRotateZ() + (1F - entity.getHealthPercent()) * healthChangeAngle);
		}
	}

	public void animateLegs(EntityDeathBlossomLurantis entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float angularVelocity, float verticalVelocity)
	{
		if(!entity.isSitting())
		{
			float legRunStartAngles[][] = new float[2][2];
			float leggingIdleAngles[] = new float[2];
			float legsRunAngleChange[][] = new float[2][4];

			legRunStartAngles[0][0] = (float)Math.toRadians(-30);
			legRunStartAngles[0][1] = (float)Math.toRadians(40);

			legRunStartAngles[1][0] = (float)Math.toRadians(-10);
			legRunStartAngles[1][1] = (float)Math.toRadians(45);

			leggingIdleAngles[0] = (float)Math.toRadians(30);
			leggingIdleAngles[1] = (float)Math.toRadians(30);

			// These indicate amount of change between phases
			legsRunAngleChange[0][0] = (float)Math.toRadians(-65); // at 0      
			legsRunAngleChange[0][1] = (float)Math.toRadians(65); // at PI/2   
			legsRunAngleChange[0][2] = (float)Math.toRadians(65); // at PI     
			legsRunAngleChange[0][3] = (float)Math.toRadians(-65); // at 3PI/2 

			legsRunAngleChange[1][0] = (float)Math.toRadians(-10); // at 0     
			legsRunAngleChange[1][1] = (float)Math.toRadians(10); // at PI/2 
			legsRunAngleChange[1][2] = (float)Math.toRadians(90); // at PI    
			legsRunAngleChange[1][3] = (float)Math.toRadians(-90); // at 3PI/2 

			float moveModifierOtherAngles = 1F;

			if(horzVelocity < SNEAK_VELOCITY)
			{
				moveModifierOtherAngles = (float)(Math.pow(Math.E, -5F * (horzVelocity/SNEAK_VELOCITY)));
			}
			else
			{
				moveModifierOtherAngles = 0;
			}

			float hipPetalAmplitudeX = (float)Math.toRadians(-5);
			float hipPetalFallAngle = (float)Math.toRadians(25);
			float yawChangeAngle = (float)Math.toRadians(-15);
			float idleAmplitudeY = (float)Math.toRadians(-5);

			float newVerticalVelocity = verticalVelocity * 2F;
			
			if(newVerticalVelocity > 1F)
				newVerticalVelocity = 1F;
			else if(newVerticalVelocity < -1F)
				newVerticalVelocity = -1F;
			
			float jumpAngleChange = (float)Math.toRadians(30);

			float runCycleAngleChange;

			float runCycleInterval = (RUN_FREQUENCY * distanceMoved % (2 * PI))/(2 * PI);

			runCycleAngleChange = calculateRunLegAngleChange(runCycleInterval, 
					legLftJointInfo.getNewRotateX(), legRunStartAngles[0][0] * (1F - horzVelocity), legsRunAngleChange[0]) * horzVelocity;
			legLftJointInfo.setNewRotateX((legLftJointInfo.getNewRotateX() + runCycleAngleChange * horzVelocity * idleDampener) 
					* (1F - Math.abs(verticalVelocity)) + legRunStartAngles[0][0] * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity)));

			runCycleAngleChange = calculateRunLegAngleChange(runCycleInterval, 
					legLftMainInfo[1].getNewRotateX(), legRunStartAngles[0][1] * (1F - horzVelocity), legsRunAngleChange[1]) * horzVelocity;
			legLftMainInfo[1].setNewRotateX((legLftMainInfo[1].getNewRotateX() + runCycleAngleChange * horzVelocity * idleDampener) 
					* (1F - Math.abs(verticalVelocity)) + legRunStartAngles[0][1] * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity)));

			runCycleAngleChange = calculateRunLegAngleChange(runCycleInterval, 
					legLftLeggingInfo[1].getNewRotateX(), leggingIdleAngles[0] * (1F - horzVelocity), legsRunAngleChange[1]) * horzVelocity;
			legLftLeggingInfo[1].setNewRotateX((legLftLeggingInfo[1].getNewRotateX() + runCycleAngleChange * horzVelocity * idleDampener) 
					* (1F - Math.abs(verticalVelocity)) + leggingIdleAngles[0] * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity)));

			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBody();

			float angleChangeY = 0;

			for(int i = 0; i < hipPetalLft.length; i++)
			{
				hipPetalLftInfo[i][1].setNewRotateX(hipPetalLftInfo[i][1].getNewRotateX() + 
						(MathHelper.sin((RUN_FREQUENCY * distanceMoved - PI/2F) % (2 * PI)) * hipPetalAmplitudeX + hipPetalAmplitudeX) * horzVelocity * (1F - Math.abs(newVerticalVelocity))+ 
						hipPetalFallAngle * (newVerticalVelocity >= 0 ? newVerticalVelocity * 0.1F : newVerticalVelocity));

				angleChangeY = angularVelocity * yawChangeAngle * ((float)i / (float)(hipPetalLft.length - 1));

				angleChangeY += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI
						- ((float)(i + 2) * (PI/(float)4))) * idleAmplitudeY * (1 - horzVelocity);

				hipPetalLftInfo[i][1].setNewRotateY(hipPetalLftInfo[i][1].getNewRotateY() + angleChangeY);
			}

			float oppositeRunCycleInterval = (((RUN_FREQUENCY * distanceMoved) + PI) % (2 * PI))/(2 * PI);

			runCycleAngleChange = calculateRunLegAngleChange(oppositeRunCycleInterval, 
					legRtJointInfo.getNewRotateX(), legRunStartAngles[1][0] * (1F - horzVelocity), legsRunAngleChange[0]) * horzVelocity;
			legRtJointInfo.setNewRotateX((legRtJointInfo.getNewRotateX() + runCycleAngleChange * horzVelocity * idleDampener) 
					* (1F - Math.abs(verticalVelocity)) + legRunStartAngles[1][0] * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity)));

			runCycleAngleChange = calculateRunLegAngleChange(oppositeRunCycleInterval, 
					legRtMainInfo[1].getNewRotateX(), legRunStartAngles[1][1] * (1F - horzVelocity), legsRunAngleChange[1]) * horzVelocity;
			legRtMainInfo[1].setNewRotateX((legRtMainInfo[1].getNewRotateX() + runCycleAngleChange * horzVelocity * idleDampener) 
					* (1F - Math.abs(verticalVelocity)) + legRunStartAngles[1][1] * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity)));

			runCycleAngleChange = calculateRunLegAngleChange(oppositeRunCycleInterval, 
					legRtLeggingInfo[1].getNewRotateX(), leggingIdleAngles[1] * (1F - horzVelocity), legsRunAngleChange[1]) * horzVelocity;
			legRtLeggingInfo[1].setNewRotateX((legRtLeggingInfo[1].getNewRotateX() + runCycleAngleChange * horzVelocity * idleDampener) 
					* (1F - Math.abs(verticalVelocity)) + leggingIdleAngles[1] * (1F - horzVelocity) * (1F - Math.abs(newVerticalVelocity)));

			for(int i = 0; i < hipPetalRt.length; i++)
			{
				hipPetalRtInfo[i][1].setNewRotateX(hipPetalRtInfo[i][1].getNewRotateX() + 
						(MathHelper.sin((RUN_FREQUENCY * distanceMoved + PI/2F) % (2 * PI)) * hipPetalAmplitudeX + hipPetalAmplitudeX) * horzVelocity * (1F - Math.abs(newVerticalVelocity)) + 
						hipPetalFallAngle * (newVerticalVelocity >= 0 ? newVerticalVelocity * 0.1F : newVerticalVelocity));

				angleChangeY = angularVelocity * yawChangeAngle * ((float)i / (float)(hipPetalRt.length - 1));

				angleChangeY += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI
						- ((float)(i + 2) * (PI/(float)4))) * idleAmplitudeY * (1 - horzVelocity);

				hipPetalRtInfo[i][1].setNewRotateY(hipPetalRtInfo[i][1].getNewRotateY() + angleChangeY);
			}
		}
		else
		{
			legRtJointInfo.setNewRotates(legRtJointInfo.getNewRotateX(), 0F, 0F);
			legLftJointInfo.setNewRotates(legLftJointInfo.getNewRotateX(), 0F, 0F);
		}
	}

	public float calculateRunLegAngleChange(float cycleInterval, float currentLegAngle, 
			float startingRunLegAngle, float legAngleChange[])
	{
		float newAngle = 0;

		float angleChangeFromStarting = startingRunLegAngle - currentLegAngle;

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

	public void deployAnimations()
	{
		this.animationDeployer.move(bodyJoint, bodyJointInfo.getNewPnt());
		this.animationDeployer.rotate(bodyJoint, bodyJointInfo.getNewRotates());

		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(armRtJoint, armRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());
		this.animationDeployer.rotate(forearmRtJoint, forearmRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(forearmRt, forearmRtInfo.getNewRotates());
		this.animationDeployer.rotate(clawRtJoint, clawRtJointInfo.getNewRotates());

		this.animationDeployer.rotate(armLftJoint, armLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(forearmLftJoint, forearmLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(forearmLft, forearmLftInfo.getNewRotates());
		this.animationDeployer.rotate(clawLftJoint, clawLftJointInfo.getNewRotates());

		this.animationDeployer.rotate(legLftJoint, legLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(legRtJoint, legRtJointInfo.getNewRotates());

		for(int i = 0; i < legRtMain.length; i++)
		{
			this.animationDeployer.rotate(legRtMain[i], legRtMainInfo[i].getNewRotates());
			this.animationDeployer.rotate(legLftMain[i], legLftMainInfo[i].getNewRotates());
		}

		for(int i = 0; i < legRtLegging.length; i++)
		{
			this.animationDeployer.rotate(legRtLegging[i], legRtLeggingInfo[i].getNewRotates());
			this.animationDeployer.rotate(legLftLegging[i], legLftLeggingInfo[i].getNewRotates());
		}

		for(int i = 0; i < hipPetalRt.length; i++)
		{
			for(int j = 0; j < hipPetalRt[i].length; j++)
			{
				this.animationDeployer.rotate(hipPetalRt[i][j], hipPetalRtInfo[i][j].getNewRotates());
				this.animationDeployer.rotate(hipPetalLft[i][j], hipPetalLftInfo[i][j].getNewRotates());
			}
		}

		for(int i = 0; i < cheekWhiskerLft.length; i++)
		{
			this.animationDeployer.rotate(cheekWhiskerLft[i], cheekWhiskerLftInfo[i].getNewRotates());
			this.animationDeployer.rotate(cheekWhiskerRt[i], cheekWhiskerRtInfo[i].getNewRotates());
		}

		this.animationDeployer.rotate(antennaFntRt, antennaFntRtInfo.getNewRotates());
		this.animationDeployer.rotate(antennaFntLft, antennaFntLftInfo.getNewRotates());

		for(int i = 0; i < antennaBckLft.length; i++)
		{
			this.animationDeployer.rotate(antennaBckLft[i], antennaBckLftInfo[i].getNewRotates());
			this.animationDeployer.rotate(antennaBckRt[i], antennaBckRtInfo[i].getNewRotates());
		}

		for(int i = 0; i < antennaBckLftSide.length; i++)
		{
			this.animationDeployer.rotate(antennaBckLftSide[i], antennaBckLftSideInfo[i].getNewRotates());
			this.animationDeployer.rotate(antennaBckRtSide[i], antennaBckRtSideInfo[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}