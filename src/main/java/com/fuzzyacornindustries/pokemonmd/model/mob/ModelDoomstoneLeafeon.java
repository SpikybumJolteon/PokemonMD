package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDoomstoneLeafeon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySwordieMienshao;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDoomstoneLeafeon extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer block;
	PartInfo blockInfo;

	public ModelRenderer spine;
	public ModelRenderer pelvis;

	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	PartInfo neckJointInfo;
	PartInfo neckInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	public ModelRenderer muzzle;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer headLeafJoint;
	public ModelRenderer headLeaf;
	PartInfo headLeafJointInfo;
	PartInfo headLeafInfo;

	public ModelRenderer shoulder;
	public ModelRenderer armRtJoint;
	public ModelRenderer armRt;
	public ModelRenderer forearmRtJoint;
	public ModelRenderer forearmRt;
	public ModelRenderer wristRtJoint;
	public ModelRenderer wristRt;
	PartInfo armRtJointInfo;
	PartInfo armRtInfo;
	PartInfo forearmRtJointInfo;
	PartInfo forearmRtInfo;
	PartInfo wristRtJointInfo;
	PartInfo wristRtInfo;

	public ModelRenderer toeRt[][][] = new ModelRenderer[2][2][2];
	PartInfo toeRtInfo[][][] = new PartInfo[toeRt.length][toeRt[0].length][toeRt[0][0].length];

	public ModelRenderer forearmLftJoint;
	public ModelRenderer forearmLft;
	public ModelRenderer wristLftJoint;
	public ModelRenderer wristLft;
	PartInfo forearmLftJointInfo;
	PartInfo forearmLftInfo;
	PartInfo wristLftJointInfo;
	PartInfo wristLftInfo;

	public ModelRenderer toeLft[][][] = new ModelRenderer[2][2][2];
	PartInfo toeLftInfo[][][] = new PartInfo[toeLft.length][toeLft[0].length][toeLft[0][0].length];

	public ModelRenderer legLft;
	public ModelRenderer legLftCalf;
	public ModelRenderer legLftHind;
	public ModelRenderer legRt;
	public ModelRenderer legRtCalf;
	public ModelRenderer legRtHind;
	PartInfo legLftInfo;
	PartInfo legRtInfo;

	public ModelRenderer tailJoint;
	public ModelRenderer tail;
	PartInfo tailJointInfo;
	PartInfo tailInfo;

	public ModelDoomstoneLeafeon() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.block = new ModelRenderer(this, 16, 40);
		this.block.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.block.addBox(-8.0F, -8.0F, -4.0F, 16, 16, 8, 0.0F);
		blockInfo = new PartInfo(block);

		this.spine = new ModelRenderer(this, 0, 57);
		this.spine.setRotationPoint(-1.0F, 0.0F, 2.0F);
		this.spine.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 6, 0.0F);
		this.setRotateAngle(spine, 0.0F, -0.3490658503988659F, 0.0F);
		this.spine.setTextureOffset(2, 54).addBox(-2.0F, -0.4F, 4.0F, 4, 1, 1, 0.0F); // pelvis
		this.pelvis = new ModelRenderer(this, 2, 54);
		this.pelvis.setRotationPoint(0.0F, 0.0F, 0.5F);
		this.pelvis.addBox(-2.0F, -0.4F, 4.0F, 4, 1, 1, 0.0F);

		this.neckJoint = new ModelRenderer(this, 17, 0);
		this.neckJoint.setRotationPoint(2.0F, -0.4F, -4.0F);
		this.neckJoint.addBox(-0.5F, -0.5F, -3.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, -0.3490658503988659F, -0.3490658503988659F, 0.0F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 17, 0);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
		neckInfo = new PartInfo(neck);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, 0.0F, -3.0F);
		this.headJoint.addBox(-2.0F, -2.5F, -3.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, 0.3490658503988659F, 0.31869712141416456F, 0.1244419756671957F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -2.5F, -3.5F, 4, 4, 4, 0.0F);
		headInfo = new PartInfo(head);
		this.muzzle = new ModelRenderer(this, 0, 9);
		this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muzzle.addBox(-1.0F, -1.5F, -4.5F, 2, 2, 2, 0.0F);
		this.setRotateAngle(muzzle, 0.2617993877991494F, -0.0F, 0.0F);

		this.headLeafJoint = new ModelRenderer(this, 2, 23);
		this.headLeafJoint.setRotationPoint(0.0F, -2.5F, -2.0F);
		this.headLeafJoint.addBox(-0.5F, -1.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headLeafJoint, -0.7853981633974483F, 0.0F, 0.0F);
		headLeafJointInfo = new PartInfo(headLeafJoint);
		this.headLeaf = new ModelRenderer(this, 2, 23);
		this.headLeaf.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headLeaf.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
		this.headLeaf.setTextureOffset(0, 20).addBox(-1.5F, -2.0F, -0.4F, 3, 1, 1, 0.0F); // headLeafLower
		this.headLeaf.setTextureOffset(1, 17).addBox(-1.0F, -3.0F, -0.4F, 2, 1, 1, 0.0F); // headLeafMid
		this.headLeaf.setTextureOffset(2, 14).addBox(-0.5F, -4.0F, -0.4F, 1, 1, 1, 0.0F); // headLeafTop
		headLeafInfo = new PartInfo(headLeaf);

		this.shoulder = new ModelRenderer(this, 19, 6);
		this.shoulder.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.shoulder.addBox(-0.5F, -0.5F, -1.2F, 1, 1, 2, 0.0F);
		this.setRotateAngle(shoulder, 0.5235987755982988F, 0.7853981633974483F, 0.0F);
		this.armRtJoint = new ModelRenderer(this, 48, 3);
		this.armRtJoint.setRotationPoint(0.0F, 0.0F, -1.1F);
		this.armRtJoint.addBox(-0.5F, -0.5F, -2.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtJoint, -0.6829473363053812F, -0.6373942428283291F, 0.40980330836826856F);
		armRtJointInfo = new PartInfo(armRtJoint);
		this.armRt = new ModelRenderer(this, 48, 3);
		this.armRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRt.addBox(-0.5F, -0.5F, -2.8F, 1, 1, 3, 0.0F);
		this.setRotateAngle(armRt, 0.5235987755982988F, 0.0F, 0.0F);
		armRtInfo = new PartInfo(armRt);
		this.forearmRtJoint = new ModelRenderer(this, 46, 8);
		this.forearmRtJoint.setRotationPoint(0.0F, 0.0F, -2.6F);
		this.forearmRtJoint.addBox(-0.5F, -0.5F, -5.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(forearmRtJoint, -0.5235987755982988F, 0.0F, 0.0F);
		forearmRtJointInfo = new PartInfo(forearmRtJoint);
		this.forearmRt = new ModelRenderer(this, 46, 8);
		this.forearmRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.forearmRt.addBox(-0.5F, -0.5F, -5.8F, 1, 1, 6, 0.0F);
		this.setRotateAngle(forearmRt, -0.08726646259971647F, -0.5235987755982988F, 0.0F);
		forearmRtInfo = new PartInfo(forearmRt);
		this.wristRtJoint = new ModelRenderer(this, 57, 16);
		this.wristRtJoint.setRotationPoint(0.0F, 0.0F, -5.5F);
		this.wristRtJoint.addBox(-1.0F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(wristRtJoint, 0.6108652381980153F, 0.0F, 0.0F);
		wristRtJointInfo = new PartInfo(wristRtJoint);
		this.wristRt = new ModelRenderer(this, 57, 16);
		this.wristRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wristRt.addBox(-1.0F, -0.5F, -0.8F, 2, 1, 1, 0.0F);
		wristRtInfo = new PartInfo(wristRt);

		int toeRtNumber = 0;
		int toeRtToeNumber = 0;
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber] = new ModelRenderer(this, 55, 19); // toeRtRt1Joint
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].setRotationPoint(-0.6F, 0.0F, -0.7F);
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(toeRt[toeRtNumber][toeRtToeNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][jointNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][jointNumber]);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber] = new ModelRenderer(this, 55, 19); // toeRtRt1
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][partNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][partNumber]);
		toeRtToeNumber++;
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber] = new ModelRenderer(this, 55, 22); // toeRtRt2Joint
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -0.7F);
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(toeRt[toeRtNumber][toeRtToeNumber][jointNumber], 0.7853981633974483F, 0.0F, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][jointNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][jointNumber]);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber] = new ModelRenderer(this, 55, 22); // toeRtRt2
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].addBox(-0.51F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][partNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][partNumber]);
		toeRtNumber++;
		toeRtToeNumber = 0;
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber] = new ModelRenderer(this, 60, 19); // toeRtLft1Joint
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].setRotationPoint(0.6F, 0.0F, -0.7F);
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(toeRt[toeRtNumber][toeRtToeNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][jointNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][jointNumber]);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber] = new ModelRenderer(this, 60, 19); // toeRtLft1
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][partNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][partNumber]);
		toeRtToeNumber++;
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber] = new ModelRenderer(this, 60, 22); // toeRtLft2Joint
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -0.7F);
		this.toeRt[toeRtNumber][toeRtToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(toeRt[toeRtNumber][toeRtToeNumber][jointNumber], 0.7853981633974483F, 0.0F, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][jointNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][jointNumber]);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber] = new ModelRenderer(this, 60, 22); // toeRtLft2
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeRt[toeRtNumber][toeRtToeNumber][partNumber].addBox(-0.49F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeRtInfo[toeRtNumber][toeRtToeNumber][partNumber] = new PartInfo(toeRt[toeRtNumber][toeRtToeNumber][partNumber]);

		this.forearmLftJoint = new ModelRenderer(this, 56, 0);
		this.forearmLftJoint.setRotationPoint(3.3F, 3.2F, -3.6F);
		this.forearmLftJoint.addBox(-0.5F, -0.5F, -2.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(forearmLftJoint, 0.3490658503988659F, -0.0F, 0.0F);
		forearmLftJointInfo = new PartInfo(forearmLftJoint);
		this.forearmLft = new ModelRenderer(this, 56, 0);
		this.forearmLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.forearmLft.addBox(-0.5F, -0.5F, -2.8F, 1, 1, 3, 0.0F);
		forearmLftInfo = new PartInfo(forearmLft);
		this.wristLftJoint = new ModelRenderer(this, 57, 5);
		this.wristLftJoint.setRotationPoint(0.0F, 0.0F, -2.7F);
		this.wristLftJoint.addBox(-1.0F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(wristLftJoint, 0.4363323129985824F, 0.0F, 0.0F);
		wristLftJointInfo = new PartInfo(wristLftJoint);
		this.wristLft = new ModelRenderer(this, 57, 5);
		this.wristLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wristLft.addBox(-1.0F, -0.5F, -0.8F, 2, 1, 1, 0.0F);
		wristLftInfo = new PartInfo(wristLft);

		int toeLftNumber = 0;
		int toeLftToeNumber = 0;
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber] = new ModelRenderer(this, 55, 8); // toeLftRt1Joint
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].setRotationPoint(-0.6F, 0.0F, -0.7F);
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(toeLft[toeLftNumber][toeLftToeNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][jointNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][jointNumber]);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber] = new ModelRenderer(this, 55, 8); // toeLftRt1
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][partNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][partNumber]);
		toeLftToeNumber++;
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber] = new ModelRenderer(this, 55, 11); // toeLftRt2Joint
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -0.7F);
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].addBox(-0.51F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		this.setRotateAngle(toeLft[toeLftNumber][toeLftToeNumber][jointNumber], 0.7853981633974483F, 0.0F, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][jointNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][jointNumber]);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber] = new ModelRenderer(this, 55, 11); // toeLftRt2
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].addBox(-0.51F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][partNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][partNumber]);
		toeLftNumber++;
		toeLftToeNumber = 0;
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber] = new ModelRenderer(this, 60, 8); // toeLftLft1Joint
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].setRotationPoint(0.6F, 0.0F, -0.7F);
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(toeLft[toeLftNumber][toeLftToeNumber][jointNumber], 0.6981317007977318F, 0.0F, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][jointNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][jointNumber]);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber] = new ModelRenderer(this, 60, 8); // toeLftLft1
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][partNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][partNumber]);
		toeLftToeNumber++;
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber] = new ModelRenderer(this, 60, 11); // toeLftLft2Joint
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -0.7F);
		this.toeLft[toeLftNumber][toeLftToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(toeLft[toeLftNumber][toeLftToeNumber][jointNumber], 0.7853981633974483F, 0.0F, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][jointNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][jointNumber]);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber] = new ModelRenderer(this, 60, 11); // toeLftLft2
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.toeLft[toeLftNumber][toeLftToeNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F);
		toeLftInfo[toeLftNumber][toeLftToeNumber][partNumber] = new PartInfo(toeLft[toeLftNumber][toeLftToeNumber][partNumber]);

		this.legLft = new ModelRenderer(this, 48, 23);
		this.legLft.setRotationPoint(1.6F, 0.0F, 5.0F);
		this.legLft.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		legLftInfo = new PartInfo(legLft);
		this.legLftCalf = new ModelRenderer(this, 48, 29);
		this.legLftCalf.setRotationPoint(0.0F, 3.8F, 0.0F);
		this.legLftCalf.addBox(-0.4F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(legLftCalf, 1.3962634015954636F, 0.0F, 0.0F);
		this.legLftHind = new ModelRenderer(this, 48, 34);
		this.legLftHind.setRotationPoint(0.0F, 2.3F, 0.0F);
		this.legLftHind.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(legLftHind, -1.3962634015954636F, 0.0F, 0.0F);

		this.legRt = new ModelRenderer(this, 43, 23);
		this.legRt.setRotationPoint(-1.6F, 0.0F, 5.0F);
		this.legRt.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		legRtInfo = new PartInfo(legRt);
		this.legRtCalf = new ModelRenderer(this, 43, 29);
		this.legRtCalf.setRotationPoint(0.0F, 3.8F, 0.0F);
		this.legRtCalf.addBox(-0.6F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(legRtCalf, 1.3962634015954636F, 0.0F, 0.0F);
		this.legRtHind = new ModelRenderer(this, 43, 34);
		this.legRtHind.setRotationPoint(0.0F, 2.3F, 0.0F);
		this.legRtHind.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(legRtHind, -1.3962634015954636F, 0.0F, 0.0F);

		this.tailJoint = new ModelRenderer(this, 26, 31);
		this.tailJoint.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.tailJoint.addBox(-0.5F, -0.5F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tailJoint, 0.08726646259971647F, 0.0F, 0.0F);
		tailJointInfo = new PartInfo(tailJoint);
		this.tail = new ModelRenderer(this, 26, 31);
		this.tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 7, 0.0F);
		this.tail.setTextureOffset(31, 14).addBox(-1.0F, -0.3F, 1.0F, 2, 1, 1, 0.0F); // tail1
		this.tail.setTextureOffset(27, 17).addBox(-2.0F, -0.3F, 2.0F, 4, 1, 3, 0.0F); // tail2
		this.tail.setTextureOffset(30, 22).addBox(-1.5F, -0.3F, 5.0F, 3, 1, 1, 0.0F); // tail3
		this.tail.setTextureOffset(31, 25).addBox(-1.0F, -0.3F, 6.0F, 2, 1, 1, 0.0F); // tail4
		this.tail.setTextureOffset(32, 28).addBox(-0.5F, -0.3F, 7.0F, 1, 1, 1, 0.0F); // tail5
		tailInfo = new PartInfo(tail);

		this.block.addChild(this.forearmLftJoint);
		this.block.addChild(this.neckJoint);
		this.block.addChild(this.shoulder);
		this.block.addChild(this.spine);

		this.neckJoint.addChild(this.neck);
		this.neck.addChild(this.headJoint);

		this.headJoint.addChild(this.head);
		this.head.addChild(this.headLeafJoint);
		this.head.addChild(this.muzzle);
		this.headLeafJoint.addChild(this.headLeaf);

		this.legLft.addChild(this.legLftCalf);
		this.legLftCalf.addChild(this.legLftHind);
		this.legRt.addChild(this.legRtCalf);
		this.legRtCalf.addChild(this.legRtHind);

		this.spine.addChild(this.legLft);
		this.spine.addChild(this.legRt);
		this.spine.addChild(this.pelvis);
		this.spine.addChild(this.tailJoint);
		this.tailJoint.addChild(this.tail);

		this.shoulder.addChild(this.armRtJoint);
		this.armRtJoint.addChild(this.armRt);
		this.armRt.addChild(this.forearmRtJoint);
		this.forearmRtJoint.addChild(this.forearmRt);
		this.forearmRt.addChild(this.wristRtJoint);

		this.wristRtJoint.addChild(this.wristRt);
		this.wristRt.addChild(this.toeRt[0][0][0]); // toeRtRt1Joint
		this.wristRt.addChild(this.toeRt[1][0][0]); // toeRtLft1Joint

		this.toeRt[0][0][0].addChild(this.toeRt[0][0][1]); // toeRtRt1Joint * toeRtRt1
		this.toeRt[0][0][1].addChild(this.toeRt[0][1][0]); // toeRtRt1 * toeRtRt2Joint
		this.toeRt[0][1][0].addChild(this.toeRt[0][1][1]); // toeRtRt2Joint * toeRtRt2

		this.toeRt[1][0][0].addChild(this.toeRt[1][0][1]); // toeRtLft1Joint * toeRtLft1
		this.toeRt[1][0][1].addChild(this.toeRt[1][1][0]); // toeRtLft1 * toeRtLft2Joint
		this.toeRt[1][1][0].addChild(this.toeRt[1][1][1]); // toeRtLft2Joint * toeRtLft2

		this.forearmLftJoint.addChild(this.forearmLft);
		this.forearmLft.addChild(this.wristLftJoint);
		this.wristLftJoint.addChild(this.wristLft);
		this.wristLft.addChild(this.toeLft[0][0][0]); // toeLftRt1Joint
		this.wristLft.addChild(this.toeLft[1][0][0]); // toeLftLft1Joint

		this.toeLft[0][0][0].addChild(this.toeLft[0][0][1]); // toeLftRt1Joint * toeLftRt1
		this.toeLft[0][0][1].addChild(this.toeLft[0][1][0]); // toeLftRt1 * toeLftRt2Joint
		this.toeLft[0][1][0].addChild(this.toeLft[0][1][1]); // toeLftRt2Joint * toeLftRt2

		this.toeLft[1][0][0].addChild(this.toeLft[1][0][1]); // toeLftLft1Joint * toeLftLft1
		this.toeLft[1][0][1].addChild(this.toeLft[1][1][0]); // toeLftLft1 * toeLftLft2Joint
		this.toeLft[1][1][0].addChild(this.toeLft[1][1][1]); // toeLftLft2Joint * toeLftLft2

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{ 
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		this.block.render(modelSize);
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

		animateHead((EntityDoomstoneLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateArms((EntityDoomstoneLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityDoomstoneLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityDoomstoneLeafeon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		legRtInfo.resetNewAngles();
		legLftInfo.resetNewAngles();

		armRtJointInfo.resetNewAngles();
		armRtInfo.resetNewAngles();
		forearmRtJointInfo.resetNewAngles();
		forearmRtInfo.resetNewAngles();
		wristRtJointInfo.resetNewAngles();

		forearmLftJointInfo.resetNewAngles();
		forearmLftInfo.resetNewAngles();
		wristLftJointInfo.resetNewAngles();
		wristLftInfo.resetNewAngles();

		for(int i = 0; i < toeRtInfo.length; i++)
		{
			for(int j = 0; j < toeRtInfo[i].length; j++)
			{
				toeRtInfo[i][j][0].resetNewAngles();
				toeRtInfo[i][j][1].resetNewAngles();
			}
		}

		for(int i = 0; i < toeLftInfo.length; i++)
		{
			for(int j = 0; j < toeLftInfo[i].length; j++)
			{
				toeLftInfo[i][j][0].resetNewAngles();
				toeLftInfo[i][j][1].resetNewAngles();
			}
		}

		tailInfo.resetNewAngles();
		tailInfo.resetNewAngles();
	}

	public void animateHead(EntityDoomstoneLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckJointInfo, yawHeadOffsetDifference, pitchRotation, 0.2F, 0.2F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble();

		float idleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		float movementFrequency = 1.2F;
		float movementAmplitude = 0.1F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX);

		JointAnimation.reverseJointRotatesChange(neckInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.4F, 0.4F);
	}

	public void animateArms(EntityDoomstoneLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float moveFrequency = 1.4F;
		float moveAmplitude = 0.3F;

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockArm(0);

		float idleAmplitudeX = 0.1F;
		float idleAmplitudeY = 0.2F;

		armRtJointInfo.setNewRotateX(armRtJointInfo.getNewRotateX() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX);
		armRtJointInfo.setNewRotateY(armRtJointInfo.getNewRotateY() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY);

		currentIdleAnimationClock = entity.getIdleAnimationClockArm(1);

		idleAmplitudeX = 0.2F;
		idleAmplitudeY = 0.2F;

		forearmRtJointInfo.setNewRotateX(forearmRtJointInfo.getNewRotateX() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX);
		forearmRtJointInfo.setNewRotateY(forearmRtJointInfo.getNewRotateY() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY);

		forearmLftJointInfo.setNewRotateX(forearmLftJointInfo.getNewRotateX() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 + PI) * idleAmplitudeX);
		forearmLftJointInfo.setNewRotateY(forearmLftJointInfo.getNewRotateY() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2 + PI) * idleAmplitudeY);

		currentIdleAnimationClock = entity.getIdleAnimationClockArm(2);

		for(int i = 0; i < toeRt[0].length; i ++)
		{
			idleAmplitudeX = 0.4F;
			idleAmplitudeY = 0.2F;

			toeRtInfo[0][i][1].setNewRotateX(toeRtInfo[0][i][1].getNewRotateX() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 + PI) * idleAmplitudeX);
			toeRtInfo[0][i][1].setNewRotateY(toeRtInfo[0][i][1].getNewRotateY() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2 + PI) * idleAmplitudeY);
		}

		for(int i = 0; i < toeRt[0].length; i ++)
		{
			idleAmplitudeX = 0.4F;
			idleAmplitudeY = 0.2F;

			toeLftInfo[0][i][1].setNewRotateX(toeLftInfo[0][i][1].getNewRotateX() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX);
			toeLftInfo[0][i][1].setNewRotateY(toeLftInfo[0][i][1].getNewRotateY() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY);
		}

		currentIdleAnimationClock = entity.getIdleAnimationClockArm(3);

		for(int i = 0; i < toeLft[1].length; i ++)
		{
			idleAmplitudeX = 0.4F;
			idleAmplitudeY = 0.2F;

			toeRtInfo[1][i][1].setNewRotateX(toeRtInfo[1][i][1].getNewRotateX() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 + PI) * idleAmplitudeX);
			toeRtInfo[1][i][1].setNewRotateY(toeRtInfo[1][i][1].getNewRotateY() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2 + PI) * idleAmplitudeY);
		}

		for(int i = 0; i < toeLft[1].length; i ++)
		{
			idleAmplitudeX = 0.4F;
			idleAmplitudeY = 0.2F;

			toeLftInfo[1][i][1].setNewRotateX(toeLftInfo[1][i][1].getNewRotateX() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX);
			toeLftInfo[1][i][1].setNewRotateY(toeLftInfo[1][i][1].getNewRotateY() + MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY);
		}
	}

	public void animateLegs(EntityDoomstoneLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float frequency = 1.4F;
		float amplitude = 0.4F;

		this.legRt.rotateAngleX = legRtInfo.getNewRotateX() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
		this.legLft.rotateAngleX = legLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
	}

	public void animateTail(EntityDoomstoneLeafeon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail();

		float idleAmplitudeX = 0.08F;
		float idleAmplitudeY = 0.20F;

		float moveFrequency = 1F;
		float moveAmplitude = 0.1F;

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = 0;

		angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX
				+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY;

		tailInfo.setNewRotateX(tailInfo.getNewRotateX() + angleChangeX);
		tailInfo.setNewRotateY(tailInfo.getNewRotateY() + angleChangeY);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(armRtJoint, armRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());
		this.animationDeployer.rotate(forearmRtJoint, forearmRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(forearmRt, forearmRtInfo.getNewRotates());
		this.animationDeployer.rotate(wristRtJoint, wristRtJointInfo.getNewRotates());

		this.animationDeployer.rotate(forearmLftJoint, forearmLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(forearmLft, forearmLftInfo.getNewRotates());
		this.animationDeployer.rotate(wristLftJoint, wristLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(wristLft, wristLftInfo.getNewRotates());
		
		for(int i = 0; i < toeLft.length; i++)
		{
			for(int j = 0; j < toeLft[i].length; j++)
			{
				this.animationDeployer.rotate(toeLft[i][j][0], toeLftInfo[i][j][0].getNewRotates());
				this.animationDeployer.rotate(toeLft[i][j][1], toeLftInfo[i][j][1].getNewRotates());
			}
		}

		for(int i = 0; i < toeRt.length; i++)
		{
			for(int j = 0; j < toeRt[i].length; j++)
			{
				this.animationDeployer.rotate(toeRt[i][j][0], toeRtInfo[i][j][0].getNewRotates());
				this.animationDeployer.rotate(toeRt[i][j][1], toeRtInfo[i][j][1].getNewRotates());
			}
		}

		this.animationDeployer.rotate(tailJoint, tailJointInfo.getNewRotates());
		this.animationDeployer.rotate(tail, tailInfo.getNewRotates());

		this.animationDeployer.applyChanges();
	}
}