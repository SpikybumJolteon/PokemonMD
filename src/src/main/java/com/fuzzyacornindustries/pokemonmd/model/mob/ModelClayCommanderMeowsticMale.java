package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AIClayCommanderMeowsticPsychic;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayCommanderMeowsticMale;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelClayCommanderMeowsticMale extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer body;
	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	public PartInfo bodyInfo;
	public PartInfo neckJointInfo;
	public PartInfo neckInfo;

	public ModelRenderer legRt;
	public ModelRenderer legLft;
	public PartInfo legRtInfo;
	public PartInfo legLftInfo;

	public ModelRenderer bodyWaistHairLft;
	public ModelRenderer bodyWaistHairRt;
	public PartInfo bodyWaistHairLftInfo;
	public PartInfo bodyWaistHairRtInfo;

	public ModelRenderer bodyUpperHairFnt;
	public ModelRenderer bodyUpperHairBck;
	public PartInfo bodyUpperHairFntInfo;
	public PartInfo bodyUpperHairBckInfo;

	public ModelRenderer armRt;
	public ModelRenderer armLft;
	public PartInfo armRtInfo;
	public PartInfo armLftInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	public ModelRenderer muzzle;
	public PartInfo headJointInfo;
	public PartInfo headInfo;

	public ModelRenderer headHairRt;
	public ModelRenderer headHairLft;
	public PartInfo headHairRtInfo;
	public PartInfo headHairLftInfo;

	public ModelRenderer earRt[][] = new ModelRenderer[2][2];
	public PartInfo earRtInfo[][] = new PartInfo[earRt.length][earRt[0].length];

	public ModelRenderer earLft[][] = new ModelRenderer[2][2];
	public PartInfo earLftInfo[][] = new PartInfo[earLft.length][earLft[0].length];

	public ModelRenderer tailLft[][] = new ModelRenderer[5][2];
	public PartInfo tailLftInfo[][] = new PartInfo[tailLft.length][tailLft[0].length];

	public ModelRenderer tailRt[][] = new ModelRenderer[5][2];
	public PartInfo tailRtInfo[][] = new PartInfo[tailRt.length][tailRt[0].length];

	public ModelClayCommanderMeowsticMale() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		int jointNumber = 0;
		int partNumber = 1;

		this.body = new ModelRenderer(this, 56, 27);
		this.body.setRotationPoint(0.0F, 21.5F, 0.0F);
		this.body.addBox(-1.0F, -2.5F, -1.0F, 2, 3, 2, 0.0F);
		bodyInfo = new PartInfo(body);
		this.neckJoint = new ModelRenderer(this, 0, 7);
		this.neckJoint.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.neckJoint.addBox(-0.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 0, 7);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
		neckInfo = new PartInfo(neck);

		this.legRt = new ModelRenderer(this, 46, 28);
		this.legRt.setRotationPoint(-0.4F, 0.0F, 0.0F);
		this.legRt.addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		legRtInfo = new PartInfo(legRt);
		this.legLft = new ModelRenderer(this, 51, 28);
		this.legLft.setRotationPoint(0.4F, 0.0F, 0.0F);
		this.legLft.addBox(-0.5F, -0.5F, -0.49F, 1, 3, 1, 0.0F);
		legLftInfo = new PartInfo(legLft);

		this.bodyWaistHairLft = new ModelRenderer(this, 58, 24);
		this.bodyWaistHairLft.setRotationPoint(0.5F, 0.0F, -0.2F);
		this.bodyWaistHairLft.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(bodyWaistHairLft, 0.0F, -0.0F, 0.5235987755982988F);
		bodyWaistHairLftInfo = new PartInfo(bodyWaistHairLft);
		this.bodyWaistHairRt = new ModelRenderer(this, 51, 24);
		this.bodyWaistHairRt.setRotationPoint(-0.5F, 0.0F, -0.2F);
		this.bodyWaistHairRt.addBox(-1.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(bodyWaistHairRt, 0.0F, -0.0F, -0.5235987755982988F);
		bodyWaistHairRtInfo = new PartInfo(bodyWaistHairRt);

		this.bodyUpperHairFnt = new ModelRenderer(this, 53, 21);
		this.bodyUpperHairFnt.setRotationPoint(0.0F, -2.0F, -0.5F);
		this.bodyUpperHairFnt.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(bodyUpperHairFnt, 0.5235987755982988F, -0.0F, 0.0F);
		bodyUpperHairFntInfo = new PartInfo(bodyUpperHairFnt);
		this.bodyUpperHairBck = new ModelRenderer(this, 58, 21);
		this.bodyUpperHairBck.setRotationPoint(0.0F, -2.0F, 0.5F);
		this.bodyUpperHairBck.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(bodyUpperHairBck, -0.5235987755982988F, -0.0F, 0.0F);
		bodyUpperHairBckInfo = new PartInfo(bodyUpperHairBck);

		this.armRt = new ModelRenderer(this, 47, 16);
		this.armRt.setRotationPoint(-1.0F, -1.7F, 0.0F);
		this.armRt.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
		armRtInfo = new PartInfo(armRt);
		this.armLft = new ModelRenderer(this, 56, 16);
		this.armLft.setRotationPoint(1.0F, -1.7F, 0.0F);
		this.armLft.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
		armLftInfo = new PartInfo(armLft);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.headJoint.addBox(-1.5F, -3.0F, -1.5F, 0, 0, 0, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
		headInfo = new PartInfo(head);
		this.muzzle = new ModelRenderer(this, 10, 0);
		this.muzzle.setRotationPoint(0.0F, -0.6F, -1.1F);
		this.muzzle.addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		this.setRotateAngle(muzzle, 0.17453292519943295F, -0.0F, 0.0F);

		this.headHairRt = new ModelRenderer(this, 6, 7);
		this.headHairRt.setRotationPoint(-0.5F, -3.3F, -1.0F);
		this.headHairRt.addBox(-0.5F, -0.5F, -1.1F, 1, 1, 2, 0.0F);
		this.setRotateAngle(headHairRt, 0.5235987755982988F, 0.17453292519943295F, 0.0F);
		headHairRtInfo = new PartInfo(headHairRt);
		this.headHairLft = new ModelRenderer(this, 13, 7);
		this.headHairLft.setRotationPoint(0.3F, -3.2F, -1.0F);
		this.headHairLft.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
		this.setRotateAngle(headHairLft, 0.5235987755982988F, -0.0F, 0.0F);
		headHairLftInfo = new PartInfo(headHairLft);

		int earRtNumber = 0;
		this.earRt[earRtNumber][jointNumber] = new ModelRenderer(this, 0, 16); // earRtBaseJoint
		this.earRt[earRtNumber][jointNumber].setRotationPoint(-1.3F, -3.0F, 0.0F);
		this.earRt[earRtNumber][jointNumber].addBox(-0.5F, -2.5F, 0.0F, 0, 0, 0, 0.0F);
		earRtInfo[earRtNumber][jointNumber]= new PartInfo(earRt[earRtNumber][jointNumber]);
		this.earRt[earRtNumber][partNumber] = new ModelRenderer(this, 0, 16); // earRtBase
		this.earRt[earRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.5F);
		this.earRt[earRtNumber][partNumber].addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F);
		earRtInfo[earRtNumber][partNumber]= new PartInfo(earRt[earRtNumber][partNumber]);
		earRtNumber++;
		this.earRt[earRtNumber][jointNumber] = new ModelRenderer(this, 0, 11); // earRtEndJoint
		this.earRt[earRtNumber][jointNumber].setRotationPoint(0.0F, -2.5F, 0.0F);
		this.earRt[earRtNumber][jointNumber].addBox(-0.5F, -0.5F, -2.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earRt[earRtNumber][jointNumber], 0.9599310885968813F, 0.17453292519943295F, 0.0F);
		earRtInfo[earRtNumber][jointNumber]= new PartInfo(earRt[earRtNumber][jointNumber]);
		this.earRt[earRtNumber][partNumber] = new ModelRenderer(this, 0, 11); // earRtEnd
		this.earRt[earRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earRt[earRtNumber][partNumber].addBox(-0.5F, -0.5F, -2.8F, 1, 1, 3, 0.0F);
		earRtInfo[earRtNumber][partNumber]= new PartInfo(earRt[earRtNumber][partNumber]);

		int earLftNumber = 0;
		this.earLft[earLftNumber][jointNumber] = new ModelRenderer(this, 13, 16); // earLftBaseJoint
		this.earLft[earLftNumber][jointNumber].setRotationPoint(1.3F, -3.0F, 0.5F);
		this.earLft[earLftNumber][jointNumber].addBox(-0.5F, -2.5F, -0.5F, 0, 0, 0, 0.0F);
		earLftInfo[earLftNumber][jointNumber]= new PartInfo(earLft[earLftNumber][jointNumber]);
		this.earLft[earLftNumber][partNumber] = new ModelRenderer(this, 13, 16); // earLftBase
		this.earLft[earLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft[earLftNumber][partNumber].addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F);
		earLftInfo[earLftNumber][partNumber]= new PartInfo(earLft[earLftNumber][partNumber]);
		earLftNumber++;
		this.earLft[earLftNumber][jointNumber] = new ModelRenderer(this, 9, 11); // earLftEndJoint
		this.earLft[earLftNumber][jointNumber].setRotationPoint(0.0F, -2.5F, 0.0F);
		this.earLft[earLftNumber][jointNumber].addBox(-0.5F, -0.5F, -2.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(earLft[earLftNumber][jointNumber], 0.9599310885968813F, -0.17453292519943295F, 0.0F);
		earLftInfo[earLftNumber][jointNumber]= new PartInfo(earLft[earLftNumber][jointNumber]);
		this.earLft[earLftNumber][partNumber] = new ModelRenderer(this, 9, 11); // earLftEnd
		this.earLft[earLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.earLft[earLftNumber][partNumber].addBox(-0.5F, -0.5F, -2.8F, 1, 1, 3, 0.0F);
		earLftInfo[earLftNumber][partNumber]= new PartInfo(earLft[earLftNumber][partNumber]);

		int tailLftNumber = 0;
		this.tailLft[tailLftNumber][jointNumber] = new ModelRenderer(this, 35, 0); // tailLft1Joint
		this.tailLft[tailLftNumber][jointNumber].setRotationPoint(0.3F, -0.1F, 0.5F);
		this.tailLft[tailLftNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		tailLftInfo[tailLftNumber][jointNumber]= new PartInfo(tailLft[tailLftNumber][jointNumber]);
		this.tailLft[tailLftNumber][partNumber] = new ModelRenderer(this, 35, 0); // tailLft1
		this.tailLft[tailLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailLft[tailLftNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 2, 0.0F);
		tailLftInfo[tailLftNumber][partNumber]= new PartInfo(tailLft[tailLftNumber][partNumber]);
		tailLftNumber++;
		this.tailLft[tailLftNumber][jointNumber] = new ModelRenderer(this, 34, 4); // tailLft2Joint
		this.tailLft[tailLftNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.5F);
		this.tailLft[tailLftNumber][jointNumber].addBox(-1.0F, -1.0F, -0.4F, 0, 0, 0, 0.0F);
		tailLftInfo[tailLftNumber][jointNumber]= new PartInfo(tailLft[tailLftNumber][jointNumber]);
		this.tailLft[tailLftNumber][partNumber] = new ModelRenderer(this, 34, 4); // tailLft2
		this.tailLft[tailLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailLft[tailLftNumber][partNumber].addBox(-1.0F, -1.0F, -0.4F, 2, 2, 2, 0.0F);
		tailLftInfo[tailLftNumber][partNumber]= new PartInfo(tailLft[tailLftNumber][partNumber]);
		tailLftNumber++;
		this.tailLft[tailLftNumber][jointNumber] = new ModelRenderer(this, 34, 9); // tailLft3Joint
		this.tailLft[tailLftNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
		this.tailLft[tailLftNumber][jointNumber].addBox(-1.0F, -1.0F, -0.2F, 0, 0, 0, 0.0F);
		tailLftInfo[tailLftNumber][jointNumber]= new PartInfo(tailLft[tailLftNumber][jointNumber]);
		this.tailLft[tailLftNumber][partNumber] = new ModelRenderer(this, 34, 9); // tailLft3
		this.tailLft[tailLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailLft[tailLftNumber][partNumber].addBox(-0.99F, -1.01F, -0.2F, 2, 2, 2, 0.0F);
		tailLftInfo[tailLftNumber][partNumber]= new PartInfo(tailLft[tailLftNumber][partNumber]);
		tailLftNumber++;
		this.tailLft[tailLftNumber][jointNumber] = new ModelRenderer(this, 34, 14); // tailLft4Joint
		this.tailLft[tailLftNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
		this.tailLft[tailLftNumber][jointNumber].addBox(-1.0F, -1.0F, -0.2F, 0, 0, 0, 0.0F);
		tailLftInfo[tailLftNumber][jointNumber]= new PartInfo(tailLft[tailLftNumber][jointNumber]);
		this.tailLft[tailLftNumber][partNumber] = new ModelRenderer(this, 34, 14); // tailLft4
		this.tailLft[tailLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailLft[tailLftNumber][partNumber].addBox(-1.0F, -1.0F, -0.2F, 2, 2, 2, 0.0F);
		tailLftInfo[tailLftNumber][partNumber]= new PartInfo(tailLft[tailLftNumber][partNumber]);
		tailLftNumber++;
		this.tailLft[tailLftNumber][jointNumber] = new ModelRenderer(this, 35, 19); // tailLft5Joint
		this.tailLft[tailLftNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.5F);
		this.tailLft[tailLftNumber][jointNumber].addBox(-0.5F, -0.5F, -0.4F, 0, 0, 0, 0.0F);
		tailLftInfo[tailLftNumber][jointNumber]= new PartInfo(tailLft[tailLftNumber][jointNumber]);
		this.tailLft[tailLftNumber][partNumber] = new ModelRenderer(this, 35, 19); // tailLft5
		this.tailLft[tailLftNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailLft[tailLftNumber][partNumber].addBox(-0.5F, -0.5F, -0.4F, 1, 1, 2, 0.0F);
		tailLftInfo[tailLftNumber][partNumber]= new PartInfo(tailLft[tailLftNumber][partNumber]);

		int tailRtNumber = 0;
		this.tailRt[tailRtNumber][jointNumber] = new ModelRenderer(this, 26, 0); // tailRt1Joint
		this.tailRt[tailRtNumber][jointNumber].setRotationPoint(-0.3F, -0.1F, 0.5F);
		this.tailRt[tailRtNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		tailRtInfo[tailRtNumber][jointNumber]= new PartInfo(tailRt[tailRtNumber][jointNumber]);
		this.tailRt[tailRtNumber][partNumber] = new ModelRenderer(this, 26, 0); // tailRt1
		this.tailRt[tailRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailRt[tailRtNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 2, 0.0F);
		tailRtInfo[tailRtNumber][partNumber]= new PartInfo(tailRt[tailRtNumber][partNumber]);
		tailRtNumber++;
		this.tailRt[tailRtNumber][jointNumber] = new ModelRenderer(this, 25, 4); // tailRt2Joint
		this.tailRt[tailRtNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.5F);
		this.tailRt[tailRtNumber][jointNumber].addBox(-1.0F, -1.0F, -0.4F, 0, 0, 0, 0.0F);
		tailRtInfo[tailRtNumber][jointNumber]= new PartInfo(tailRt[tailRtNumber][jointNumber]);
		this.tailRt[tailRtNumber][partNumber] = new ModelRenderer(this, 25, 4); // tailRt2
		this.tailRt[tailRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailRt[tailRtNumber][partNumber].addBox(-1.0F, -1.0F, -0.4F, 2, 2, 2, 0.0F);
		tailRtInfo[tailRtNumber][partNumber]= new PartInfo(tailRt[tailRtNumber][partNumber]);
		tailRtNumber++;
		this.tailRt[tailRtNumber][jointNumber] = new ModelRenderer(this, 25, 9); // tailRt3Joint
		this.tailRt[tailRtNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
		this.tailRt[tailRtNumber][jointNumber].addBox(-1.01F, -1.0F, -0.2F, 0, 0, 0, 0.0F);
		tailRtInfo[tailRtNumber][jointNumber]= new PartInfo(tailRt[tailRtNumber][jointNumber]);
		this.tailRt[tailRtNumber][partNumber] = new ModelRenderer(this, 25, 9); // tailRt3
		this.tailRt[tailRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailRt[tailRtNumber][partNumber].addBox(-1.01F, -1.01F, -0.2F, 2, 2, 2, 0.0F);
		tailRtInfo[tailRtNumber][partNumber]= new PartInfo(tailRt[tailRtNumber][partNumber]);
		tailRtNumber++;
		this.tailRt[tailRtNumber][jointNumber] = new ModelRenderer(this, 25, 14); // tailRt4Joint
		this.tailRt[tailRtNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.3F);
		this.tailRt[tailRtNumber][jointNumber].addBox(-1.0F, -1.0F, -0.2F, 0, 0, 0, 0.0F);
		tailRtInfo[tailRtNumber][jointNumber]= new PartInfo(tailRt[tailRtNumber][jointNumber]);
		this.tailRt[tailRtNumber][partNumber] = new ModelRenderer(this, 25, 14); // tailRt4
		this.tailRt[tailRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailRt[tailRtNumber][partNumber].addBox(-1.0F, -1.0F, -0.2F, 2, 2, 2, 0.0F);
		tailRtInfo[tailRtNumber][partNumber]= new PartInfo(tailRt[tailRtNumber][partNumber]);
		tailRtNumber++;
		this.tailRt[tailRtNumber][jointNumber] = new ModelRenderer(this, 26, 19); // tailRt5Joint
		this.tailRt[tailRtNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.5F);
		this.tailRt[tailRtNumber][jointNumber].addBox(-0.5F, -0.5F, -0.4F, 0, 0, 0, 0.0F);
		tailRtInfo[tailRtNumber][jointNumber]= new PartInfo(tailRt[tailRtNumber][jointNumber]);
		this.tailRt[tailRtNumber][partNumber] = new ModelRenderer(this, 26, 19); // tailRt5
		this.tailRt[tailRtNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailRt[tailRtNumber][partNumber].addBox(-0.5F, -0.5F, -0.4F, 1, 1, 2, 0.0F);
		tailRtInfo[tailRtNumber][partNumber]= new PartInfo(tailRt[tailRtNumber][partNumber]);

		this.body.addChild(this.armLft);
		this.body.addChild(this.armRt);
		this.body.addChild(this.bodyUpperHairBck);
		this.body.addChild(this.bodyUpperHairFnt);
		this.body.addChild(this.bodyWaistHairLft);
		this.body.addChild(this.bodyWaistHairRt);
		this.body.addChild(this.legLft);
		this.body.addChild(this.legRt);
		this.body.addChild(this.neckJoint);
		this.body.addChild(this.tailLft[0][0]);
		this.body.addChild(this.tailRt[0][0]);

		this.head.addChild(this.earLft[0][0]);
		this.head.addChild(this.earRt[0][0]);
		this.head.addChild(this.headHairLft);
		this.head.addChild(this.headHairRt);
		this.head.addChild(this.muzzle);
		this.headJoint.addChild(this.head);

		this.neck.addChild(this.headJoint);
		this.neckJoint.addChild(this.neck);

		this.earLft[0][0].addChild(this.earLft[0][1]); // earLftBase      * earLftEndJoint
		this.earLft[0][1].addChild(this.earLft[1][0]); // earLftBaseJoint * earLftBase
		this.earLft[1][0].addChild(this.earLft[1][1]); // earLftEndJoint  * earLftEnd

		this.earRt[0][0].addChild(this.earRt[0][1]); // earRtBase      * earRtEndJoint
		this.earRt[0][1].addChild(this.earRt[1][0]); // earRtBaseJoint * earRtBase
		this.earRt[1][0].addChild(this.earRt[1][1]); // earRtEndJoint  * earRtEnd

		this.tailLft[0][0].addChild(this.tailLft[0][1]); // tailLft1Joint * tailLft1
		this.tailLft[0][1].addChild(this.tailLft[1][0]); // tailLft1      * tailLft2Joint
		this.tailLft[1][0].addChild(this.tailLft[1][1]); // tailLft2Joint * tailLft2
		this.tailLft[1][1].addChild(this.tailLft[2][0]); // tailLft2      * tailLft3Joint
		this.tailLft[2][0].addChild(this.tailLft[2][1]); // tailLft3Joint * tailLft3
		this.tailLft[2][1].addChild(this.tailLft[3][0]); // tailLft3      * tailLft4Joint
		this.tailLft[3][0].addChild(this.tailLft[3][1]); // tailLft4Joint * tailLft4
		this.tailLft[3][1].addChild(this.tailLft[4][0]); // tailLft4      * tailLft5Joint
		this.tailLft[4][0].addChild(this.tailLft[4][1]); // tailLft5Joint * tailLft5

		this.tailRt[0][0].addChild(this.tailRt[0][1]); // tailRt1Joint * tailRt1
		this.tailRt[0][1].addChild(this.tailRt[1][0]); // tailRt1      * tailRt2Joint
		this.tailRt[1][0].addChild(this.tailRt[1][1]); // tailRt2Joint * tailRt2
		this.tailRt[1][1].addChild(this.tailRt[2][0]); // tailRt2      * tailRt3Joint
		this.tailRt[2][0].addChild(this.tailRt[2][1]); // tailRt3Joint * tailRt3
		this.tailRt[2][1].addChild(this.tailRt[3][0]); // tailRt3      * tailRt4Joint
		this.tailRt[3][0].addChild(this.tailRt[3][1]); // tailRt4Joint * tailRt4
		this.tailRt[3][1].addChild(this.tailRt[4][0]); // tailRt4      * tailRt5Joint
		this.tailRt[4][0].addChild(this.tailRt[4][1]); // tailRt5Joint * tailRt5

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

		float idleDampener = 1F;

		if(animationDeployer.getEntity().getAnimationID() == EntityClayCommanderMeowsticMale.actionIDPsychic)
		{
			idleDampener = animatePsychic(animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		}
		
		/*
		System.out.println( "Test Animation Tick Code in Animate Class" );
		System.out.println( Integer.toString(animationDeployer.getEntity().getAnimationID()));
		System.out.println( Float.toString( animationDeployer.getEntity().getAnimationTick() + MainRegistry.proxy.getPartialTick() ) );
		*/

		animateHead((EntityClayCommanderMeowsticMale)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateArms((EntityClayCommanderMeowsticMale)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityClayCommanderMeowsticMale)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityClayCommanderMeowsticMale)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		armLftInfo.resetNewAngles();
		armRtInfo.resetNewAngles();

		for(int i = 0; i < earRtInfo.length; i++)
		{
			earRtInfo[i][0].resetNewAngles();
			earRtInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < earLftInfo.length; i++)
		{
			earLftInfo[i][0].resetNewAngles();
			earLftInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < tailLft.length; i++)
		{
			tailLftInfo[i][0].resetNewAngles();
			tailLftInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < tailRt.length; i++)
		{
			tailRtInfo[i][0].resetNewAngles();
			tailRtInfo[i][1].resetNewAngles();
		}
	}

	public float animatePsychic(IAnimatedEntity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float idleDampener = 1F;

		float tick = animationDeployer.getEntity().getAnimationTick() + PokemonMDMain.proxy.getPartialTick();

		float firstPhaseEnd = 40;
		float secondPhaseEnd = 65;
		float thirdPhaseEnd = 85;
		float endDuration = 110;

		if(tick < firstPhaseEnd && tick > 0)
		{
			idleDampener = (1F + (float)MathHelper.cos(PI*(tick/firstPhaseEnd)));
		}
		else if(tick < thirdPhaseEnd)
		{
			idleDampener = 0;
		}
		else if(tick < endDuration)
		{
			idleDampener = (1F + (float)MathHelper.cos(PI + PI * ((tick - secondPhaseEnd)/(endDuration - secondPhaseEnd))));
		}

		/*
		 * Ear raise animation
		 */
		float earTick = tick;

		float earRaiseDuration = firstPhaseEnd - 0;
		float earFlickDuration = thirdPhaseEnd - secondPhaseEnd;
		float earReturnDuration = endDuration - thirdPhaseEnd;

		float earRaiseRotateX = (float)Math.toRadians(-125);
		float earFlickAmplitudeX = (float)Math.toRadians(-30);

		Vector3f earRaiseVector = new Vector3f(0, 0, 0);

		if(tick < firstPhaseEnd)
		{
			earTick = tick;

			earRaiseVector.addToX(earRaiseRotateX * 
					(1 - (float)MathHelper.cos(((PI/2) * ((earRaiseDuration - earTick)/earRaiseDuration)) - (PI/2))));
		}
		else if(tick < secondPhaseEnd)
		{
			earRaiseVector.addToX(earRaiseRotateX);
		}
		else if(tick < thirdPhaseEnd)
		{
			earTick = tick - secondPhaseEnd;
			earRaiseVector.addToX(earRaiseRotateX + earFlickAmplitudeX *
					(float)MathHelper.cos((2 * PI * ((earFlickDuration - earTick)/earFlickDuration)) + PI/2));
		}
		else if(tick < endDuration)
		{
			earTick = tick - thirdPhaseEnd;
			
			earRaiseVector.addToX(earRaiseRotateX * 
					(float)MathHelper.cos(((PI/2) * ((earReturnDuration - earTick)/earReturnDuration)) - (PI/2)));
		}
		
		earLftInfo[1][1].setNewRotatesWithVector(earRaiseVector);
		earRtInfo[1][1].setNewRotatesWithVector(earRaiseVector);

		return idleDampener;
	}

	public void animateHead(EntityClayCommanderMeowsticMale entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.6F, 0.6F);

		/* ******* Ears ******** */
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockEars();

		float idleAmplitudeX = 0.15F;
		float idleAmplitudeZ = 0.15F;

		// + (float)Math.toRadians(45)
		float movementFrequency = 2.0F;
		float movementAmplitude = 0.15F;

		float angleChangeX = 0; 
		float angleChangeZ = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI * 2) * idleAmplitudeX;
		angleChangeZ += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeZ;

		earLftInfo[1][1].setNewRotateX(earLftInfo[1][1].getNewRotateX() + angleChangeX);
		earLftInfo[0][1].setNewRotateZ(earLftInfo[0][1].getNewRotateZ() + angleChangeZ);

		earRtInfo[1][1].setNewRotateX(earRtInfo[1][1].getNewRotateX() + angleChangeX);
		earRtInfo[0][1].setNewRotateZ(earRtInfo[0][1].getNewRotateZ() - angleChangeZ);
	}

	public void animateArms(EntityClayCommanderMeowsticMale entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockArms();

		float idleAmplitudeX = 0.55F;

		// + (float)Math.toRadians(45)
		float movementFrequency = 2.0F;
		float movementAmplitude = 0.7F;

		float angleChangeX = 0; 
		float angleChangeY = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX;

		armLftInfo.setNewRotateX(armLftInfo.getNewRotateX() + angleChangeX);
		armLftInfo.setNewRotateY(armLftInfo.getNewRotateY() + angleChangeY + (float)Math.toRadians(-45));

		armRtInfo.setNewRotateX(armRtInfo.getNewRotateX() - angleChangeX);
		armRtInfo.setNewRotateY(armRtInfo.getNewRotateY() + angleChangeY + (float)Math.toRadians(45));
	}

	public void animateLegs(EntityClayCommanderMeowsticMale entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float frequency = 1.7F;
		float amplitude = 0.6F;

		this.legRt.rotateAngleX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
		this.legLft.rotateAngleX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
	}

	public void animateTail(EntityClayCommanderMeowsticMale entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		tailLftInfo[0][0].setNewRotateY((float)Math.toRadians(-45));
		tailRtInfo[0][0].setNewRotateY((float)Math.toRadians(45));

		for(int i = 0; i < tailLftInfo.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(0, i);

			applyTailAnimations(currentIdleAnimationClock, tailLftInfo[i][1], i, distanceMoved, horzVelocity);
		}

		for(int i = 0; i < tailRtInfo.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(1, i);

			applyTailAnimations(currentIdleAnimationClock, tailRtInfo[i][1], i, distanceMoved, horzVelocity);
		}
	}

	public void applyTailAnimations(IdleAnimationClock currentIdleAnimationClock, PartInfo tailPartInfo, int i, float distanceMoved, float horzVelocity)
	{
		float movementFrequency = 1.0F;
		float movementAmplitude = 0.10F * i;

		float amplitudeTailX = 0.60F;
		float amplitudeTailY = 0.50F;

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * amplitudeTailX * 
				( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * amplitudeTailY * 
				( 1 - (Math.pow(Math.E, -0.4F * (float)(i + 1))));

		tailPartInfo.setNewRotateX(tailPartInfo.getNewRotates().getX() + angleChangeX);
		tailPartInfo.setNewRotateY(tailPartInfo.getNewRotates().getY() + angleChangeY);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());

		for(int i = 0; i < earLft.length; i++)
		{
			this.animationDeployer.rotate(earLft[i][0], earLftInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(earLft[i][1], earLftInfo[i][1].getNewRotates());
		}

		for(int i = 0; i < earRt.length; i++)
		{
			this.animationDeployer.rotate(earRt[i][0], earRtInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(earRt[i][1], earRtInfo[i][1].getNewRotates());
		}

		for(int i = 0; i < tailLft.length; i++)
		{
			this.animationDeployer.rotate(tailLft[i][0], tailLftInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tailLft[i][1], tailLftInfo[i][1].getNewRotates());

			this.animationDeployer.rotate(tailRt[i][0], tailRtInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tailRt[i][1], tailRtInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}