package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityDoomstoneGlaceon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDoomstoneGlaceon extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer block;
	PartInfo blockInfo;

	public ModelRenderer spine;

	public ModelRenderer shoulders;
	public ModelRenderer neckJoint;
	public ModelRenderer neck;
	PartInfo neckJointInfo;
	PartInfo neckInfo;

	public ModelRenderer legFntRtJoint;
	public ModelRenderer legFntRt;
	public ModelRenderer legFntRtWristJoint;
	public ModelRenderer legFntRtWrist;
	PartInfo legFntRtJointInfo;
	PartInfo legFntRtInfo;
	PartInfo legFntRtWristJointInfo;
	PartInfo legFntRtWristInfo;

	public ModelRenderer legFntLftJoint;
	public ModelRenderer legFntLft;
	public ModelRenderer legFntLftForelegJoint;
	public ModelRenderer legFntLftForeleg;
	PartInfo legFntLftJointInfo;
	PartInfo legFntLftInfo;
	PartInfo legFntLftForelegJointInfo;
	PartInfo legFntLftForelegInfo;

	public ModelRenderer legFntLftToes[][][] = new ModelRenderer[2][2][2];
	PartInfo legFntLftToesInfo[][][] = new PartInfo[legFntLftToes.length][legFntLftToes[0].length][legFntLftToes[0][0].length];

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer muzzle;
	public ModelRenderer headPiece;

	public ModelRenderer legBckLftBase;
	public ModelRenderer legBckLftHind;
	public ModelRenderer legBckLftPaw;

	public ModelRenderer legBckRtBase;
	public ModelRenderer legBckRtHind;
	public ModelRenderer legBckRtPawJoint;
	public ModelRenderer legBckRtPaw;
	PartInfo legBckRtPawJointInfo;
	PartInfo legBckRtPawInfo;

	public ModelRenderer tail[][] = new ModelRenderer[18][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][tail[0].length];

	public ModelDoomstoneGlaceon() 
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		this.block = new ModelRenderer(this, 32, 42);
		this.block.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.block.addBox(-5.0F, -16.0F, -3.0F, 10, 16, 6, 0.0F);
		this.setRotateAngle(block, 0.0F, -0.5235987755982988F, 0.0F);
		this.block.setTextureOffset(43, 14).addBox(-3.0F, -3.0F, -4.0F, 2, 3, 1, 0.0F); // blockFntRt
		this.block.setTextureOffset(37, 19).addBox(-1.0F, -5.0F, -4.8F, 4, 5, 2, 0.0F); // blockFntMid
		this.block.setTextureOffset(50, 10).addBox(2.0F, -10.0F, -3.9F, 4, 10, 3, 0.0F); // blockFntLft
		this.block.setTextureOffset(56, 24).addBox(-5.4F, -8.0F, 2.9F, 3, 8, 1, 0.0F); // blockBckRt
		this.block.setTextureOffset(36, 27).addBox(-2.53F, -12.0F, 2.8F, 4, 12, 2, 0.0F); // blockBckMid
		this.block.setTextureOffset(50, 34).addBox(-0.6F, -4.0F, 2.8F, 4, 4, 3, 0.0F); // blockBckLft
		blockInfo = new PartInfo(block);

		this.spine = new ModelRenderer(this, 9, 53);
		this.spine.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.spine.addBox(0.0F, 0.0F, -3.0F, 1, 1, 10, 0.0F);
		this.setRotateAngle(spine, -0.17453292519943295F, 1.0471975511965976F, 0.0F);
		this.spine.setTextureOffset(0, 49).addBox(-1.0F, 0.5F, -3.0F, 3, 3, 4, 0.0F); // ribs
		this.spine.setTextureOffset(0, 60).addBox(-2.0F, 0.5F, 4.5F, 5, 1, 1, 0.0F); // hips

		this.shoulders = new ModelRenderer(this, 0, 57);
		this.shoulders.setRotationPoint(0.5F, 0.5F, -3.5F);
		this.shoulders.addBox(-3.0F, -0.5F, -0.5F, 6, 1, 1, 0.0F);
		this.setRotateAngle(shoulders, 0.0F, -0.3490658503988659F, 0.0F);
		this.neckJoint = new ModelRenderer(this, 9, 9);
		this.neckJoint.setRotationPoint(0.2F, 0.0F, -0.2F);
		this.neckJoint.addBox(-0.5F, -0.5F, -3.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(neckJoint, -0.3490658503988659F, -0.17453292519943295F, -0.08726646259971647F);
		neckJointInfo = new PartInfo(neckJoint);
		this.neck = new ModelRenderer(this, 9, 9);
		this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 4, 0.0F);
		neckInfo = new PartInfo(neck);

		this.legFntRtJoint = new ModelRenderer(this, 0, 37);
		this.legFntRtJoint.setRotationPoint(-2.5F, 0.0F, 0.0F);
		this.legFntRtJoint.addBox(-0.5F, -0.3F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntRtJoint, -0.08726646259971647F, 0.0F, 0.0F);
		legFntRtJointInfo = new PartInfo(legFntRtJoint);
		this.legFntRt = new ModelRenderer(this, 0, 37);
		this.legFntRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntRt.addBox(-0.5F, -0.3F, -0.5F, 1, 6, 1, 0.0F);
		legFntRtInfo = new PartInfo(legFntRt);
		this.legFntRtWristJoint = new ModelRenderer(this, 0, 45);
		this.legFntRtWristJoint.setRotationPoint(0.0F, 5.5F, 0.0F);
		this.legFntRtWristJoint.addBox(-0.5F, 0.0F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntRtWristJoint, 0.2617993877991494F, 0.0F, 0.0F);
		legFntRtWristJointInfo = new PartInfo(legFntRtWristJoint);
		this.legFntRtWrist = new ModelRenderer(this, 0, 45);
		this.legFntRtWrist.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntRtWrist.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
		legFntRtWristInfo = new PartInfo(legFntRtWrist);

		this.legFntLftJoint = new ModelRenderer(this, 7, 36);
		this.legFntLftJoint.setRotationPoint(2.6F, 0.0F, 0.0F);
		this.legFntLftJoint.addBox(-0.5F, -0.5F, -2.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLftJoint, 0.8196066167365371F, -0.17453292519943295F, -0.6373942428283291F);
		legFntLftJointInfo = new PartInfo(legFntLftJoint);
		this.legFntLft = new ModelRenderer(this, 7, 36);
		this.legFntLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLft.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
		legFntLftInfo = new PartInfo(legFntLft);
		this.legFntLftForelegJoint = new ModelRenderer(this, 5, 42);
		this.legFntLftForelegJoint.setRotationPoint(0.0F, 0.0F, -2.0F);
		this.legFntLftForelegJoint.addBox(-0.5F, -0.5F, -4.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLftForelegJoint, -0.8651597102135892F, -0.0F, -0.27314402793711257F);
		legFntLftForelegJointInfo = new PartInfo(legFntLftForelegJoint);
		this.legFntLftForeleg = new ModelRenderer(this, 5, 42);
		this.legFntLftForeleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLftForeleg.addBox(-0.5F, -0.5F, -4.5F, 1, 1, 5, 0.0F);
		legFntLftForelegInfo = new PartInfo(legFntLftForeleg);

		int legFntLftNumber = 0;
		int legFntLftToeNumber = 0;
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber] = new ModelRenderer(this, 5, 41); // legFntLftToeRt1Joint
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].setRotationPoint(-0.5F, 0.0F, -4.5F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.8F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber], 0.6829473363053812F, 0.27314402793711257F, 0.045553093477052F);
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][jointNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber]);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber] = new ModelRenderer(this, 5, 41); // legFntLftToeRt1
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].addBox(-0.5F, -0.5F, -0.8F, 1, 1, 1, 0.0F); 
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][partNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber]);       
		legFntLftToeNumber++;
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber] = new ModelRenderer(this, 5, 44); // legFntLftToeRt2Joint
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -0.5F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.9F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber], 0.6373942428283291F, 0.0F, 0.0F);
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][jointNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber]);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber] = new ModelRenderer(this, 5, 44); // legFntLftToeRt2
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][partNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber]); 
		legFntLftNumber++;
		legFntLftToeNumber = 0;
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber] = new ModelRenderer(this, 13, 41); // legFntLftToeLft1Joint
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].setRotationPoint(0.5F, 0.0F, -4.5F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.9F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber], 0.40980330836826856F, 0.0F, 0.27314402793711257F);
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][jointNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber]);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber] = new ModelRenderer(this, 13, 41); // legFntLftToeLft1
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].addBox(-0.5F, -0.5F, -0.9F, 1, 1, 1, 0.0F);
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][partNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber]); 
		legFntLftToeNumber++;
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber] = new ModelRenderer(this, 13, 44); // legFntLftToeLft2Joint
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].setRotationPoint(0.0F, 0.0F, -0.5F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber].addBox(-0.5F, -0.5F, -0.9F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber], 0.6829473363053812F, 0.0F, 0.0F);
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][jointNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][jointNumber]);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber] = new ModelRenderer(this, 13, 44); // legFntLftToeLft2
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber].addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
		legFntLftToesInfo[legFntLftNumber][legFntLftToeNumber][partNumber] = new PartInfo(legFntLftToes[legFntLftNumber][legFntLftToeNumber][partNumber]); 

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, 0.0F, -2.5F);
		this.headJoint.addBox(-2.0F, -3.0F, -3.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(headJoint, 0.5235987755982988F, -0.0F, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.0F, -3.0F, -3.5F, 4, 4, 4, 0.0F);
		headInfo = new PartInfo(head);

		this.muzzle = new ModelRenderer(this, 0, 9);
		this.muzzle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.muzzle.addBox(-1.0F, -1.3F, -4.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(muzzle, 0.17453292519943295F, -0.0F, 0.0F);
		this.headPiece = new ModelRenderer(this, 0, 19);
		this.headPiece.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headPiece.addBox(-1.0F, -4.0F, -4.0F, 2, 2, 3, 0.0F);
		this.headPiece.setTextureOffset(0, 14).addBox(-2.5F, -3.8F, -3.6F, 2, 2, 2, 0.0F); // headPieceRt
		this.headPiece.setTextureOffset(0, 25).addBox(0.5F, -3.8F, -3.6F, 2, 2, 2, 0.0F); // headPieceLft

		this.legBckLftBase = new ModelRenderer(this, 27, 46);
		this.legBckLftBase.setRotationPoint(2.5F, 1.0F, 5.0F);
		this.legBckLftBase.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(legBckLftBase, -0.8726646259971648F, 0.08726646259971647F, 0.0F);
		this.legBckLftHind = new ModelRenderer(this, 27, 52);
		this.legBckLftHind.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.legBckLftHind.addBox(-0.51F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(legBckLftHind, 1.5707963267948966F, 0.0F, 0.0F);
		this.legBckLftPaw = new ModelRenderer(this, 27, 57);
		this.legBckLftPaw.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.legBckLftPaw.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(legBckLftPaw, -1.9198621771937625F, 0.0F, 0.0F);

		this.legBckRtBase = new ModelRenderer(this, 22, 46);
		this.legBckRtBase.setRotationPoint(-1.5F, 1.1F, 5.0F);
		this.legBckRtBase.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.setRotateAngle(legBckRtBase, -0.3490658503988659F, -0.2617993877991494F, 0.0F);
		this.legBckRtHind = new ModelRenderer(this, 22, 52);
		this.legBckRtHind.setRotationPoint(0.0F, 3.5F, 0.0F);
		this.legBckRtHind.addBox(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(legBckRtHind, 2.6179938779914944F, 0.0F, 0.0F);
		this.legBckRtPawJoint = new ModelRenderer(this, 22, 57);
		this.legBckRtPawJoint.setRotationPoint(0.0F, 2.5F, 0.0F);
		this.legBckRtPawJoint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(legBckRtPawJoint, -1.7453292519943295F, -0.0F, 0.0F);
		legBckRtPawJointInfo = new PartInfo(legBckRtPawJoint);
		this.legBckRtPaw = new ModelRenderer(this, 22, 57);
		this.legBckRtPaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legBckRtPaw.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		legBckRtPawInfo = new PartInfo(legBckRtPaw);

		int tailNumber = 0;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 0); // tail1Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.5F, 0.5F, 6.8F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 0); // tail1
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 2); // tail2Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 2); // tail2
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 4); // tail3Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 4); // tail3
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 6); // tail4Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 6); // tail4
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 8); // tail5Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 8); // tail5
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 10); // tail6Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 10); // tail6
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 12); // tail7Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 12); // tail7
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 14); // tail8Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 14); // tail8
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 16); // tail9Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], 0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 16); // tail9
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 18); // tail10Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 18); // tail10
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 20); // tail11Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 20); // tail11
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 22); // tail12Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 22); // tail12
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 24); // tail13Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 24); // tail13
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 26); // tail14Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 26); // tail14
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 28); // tail15Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 28); // tail15
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 30); // tail16Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 30); // tail16
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 32); // tail17Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 32); // tail17
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);
		tailNumber++;
		this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 25, 34); // tail18Joint
		this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 0.6F);
		this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.setRotateAngle(tail[tailNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
		tailInfo[tailNumber][jointNumber] = new PartInfo(tail[tailNumber][jointNumber]);
		this.tail[tailNumber][partNumber] = new ModelRenderer(this, 25, 34); // tail18
		this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber][partNumber] = new PartInfo(tail[tailNumber][partNumber]);

		this.block.addChild(this.spine);

		this.spine.addChild(this.legBckLftBase);
		this.spine.addChild(this.legBckRtBase);
		this.spine.addChild(this.shoulders);
		this.spine.addChild(this.tail[0][0]); // tail1Joint

		this.headJoint.addChild(this.head);
		this.head.addChild(this.headPiece);
		this.head.addChild(this.muzzle);

		this.legBckLftBase.addChild(this.legBckLftHind);
		this.legBckLftHind.addChild(this.legBckLftPaw);
		this.legBckRtBase.addChild(this.legBckRtHind);
		this.legBckRtHind.addChild(this.legBckRtPawJoint);
		this.legBckRtPawJoint.addChild(this.legBckRtPaw);

		this.legFntLftJoint.addChild(this.legFntLft);
		this.legFntLft.addChild(this.legFntLftForelegJoint);
		this.legFntLftForelegJoint.addChild(this.legFntLftForeleg);
		this.legFntLftForeleg.addChild(this.legFntLftToes[0][0][0]); // legFntLftToeRt1Joint
		this.legFntLftForeleg.addChild(this.legFntLftToes[1][0][0]); // legFntLftToeLft1Joint

		this.legFntLftToes[0][0][0].addChild(this.legFntLftToes[0][0][1]); // legFntLftToeRt1Joint * legFntLftToeRt1
		this.legFntLftToes[0][0][1].addChild(this.legFntLftToes[0][1][0]); // legFntLftToeRt1 * legFntLftToeRt2Joint
		this.legFntLftToes[0][1][0].addChild(this.legFntLftToes[0][1][1]); // legFntLftToeRt2Joint * legFntLftToeRt2

		this.legFntLftToes[1][0][0].addChild(this.legFntLftToes[1][0][1]); // legFntLftToeLft1Joint * legFntLftToeLft1
		this.legFntLftToes[1][0][1].addChild(this.legFntLftToes[1][1][0]); // legFntLftToeLft1 * legFntLftToeLft2Joint
		this.legFntLftToes[1][1][0].addChild(this.legFntLftToes[1][1][1]); // legFntLftToeLft2Joint * legFntLftToeLft2

		this.legFntRtJoint.addChild(this.legFntRt);
		this.legFntRt.addChild(this.legFntRtWristJoint);
		this.legFntRtWristJoint.addChild(this.legFntRtWrist);

		this.shoulders.addChild(this.legFntLftJoint);
		this.shoulders.addChild(this.legFntRtJoint);
		this.shoulders.addChild(this.neckJoint);

		this.neckJoint.addChild(this.neck);
		this.neck.addChild(this.headJoint);

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
		this.tail[10][1].addChild(this.tail[11][0]); // tail11 * tail12Joint
		this.tail[11][0].addChild(this.tail[11][1]); // tail12Joint * tail12
		this.tail[11][1].addChild(this.tail[12][0]); // tail12 * tail13Joint
		/*
		this.tail[12][0].addChild(this.tail[12][1]); // tail13Joint * tail13
		this.tail[12][1].addChild(this.tail[13][0]); // tail13 * tail14Joint
		this.tail[13][0].addChild(this.tail[13][1]); // tail14Joint * tail14
		this.tail[13][1].addChild(this.tail[14][0]); // tail14 * tail15Joint
		this.tail[14][0].addChild(this.tail[14][1]); // tail15Joint * tail15
		this.tail[14][1].addChild(this.tail[15][0]); // tail15 * tail16Joint
		this.tail[15][0].addChild(this.tail[15][1]); // tail16Joint * tail16
		this.tail[15][1].addChild(this.tail[16][0]); // tail16 * tail17Joint
		this.tail[16][0].addChild(this.tail[16][1]); // tail17Joint * tail17
		this.tail[16][1].addChild(this.tail[17][0]); // tail17 * tail18Joint
		this.tail[17][0].addChild(this.tail[17][1]); // tail18Joint * tail18
*/
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

		animateHead((EntityDoomstoneGlaceon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityDoomstoneGlaceon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityDoomstoneGlaceon)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		legFntRtJointInfo.resetNewAngles();
		legFntRtInfo.resetNewAngles();
		legFntRtWristJointInfo.resetNewAngles();
		legFntRtWristInfo.resetNewAngles();

		legFntLftJointInfo.resetNewAngles();
		legFntLftInfo.resetNewAngles();
		legFntLftForelegJointInfo.resetNewAngles();
		legFntLftForelegInfo.resetNewAngles();

		for(int i = 0; i < legFntLftToes.length; i++)
		{
			for(int j = 0; j < legFntLftToes[i].length; j++)
			{
				legFntLftToesInfo[i][j][0].resetNewAngles();
				legFntLftToesInfo[i][j][1].resetNewAngles();
			}
		}

		PartInfo legFntLftToesInfo[][][] = new PartInfo[legFntLftToes.length][legFntLftToes[0].length][legFntLftToes[0][0].length];


		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}
	}

	public void animateHead(EntityDoomstoneGlaceon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(neckJointInfo, yawHeadOffsetDifference, pitchRotation, 0.4F, 0.4F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockNeckBobble();

		float idleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		float movementFrequency = 2.0F;
		float movementAmplitude = 0.2F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		neckInfo.setNewRotateX(neckInfo.getNewRotateX() + angleChangeX);

		JointAnimation.reverseJointRotatesChange(neckInfo, headJointInfo);

		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.6F, 0.6F);
	}

	public void animateLegs(EntityDoomstoneGlaceon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float moveFrequency = 1.4F;
		float moveAmplitude = 0.3F;

		this.legBckRtPaw.rotateAngleX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);
		this.legFntRt.rotateAngleX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockArm(0);

		float idleAmplitudeX = 0.1F;
		float idleAmplitudeY = 0.2F;
		
		legFntLftInfo.setNewRotateX(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX);
		legFntLftInfo.setNewRotateY(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY);
		
		currentIdleAnimationClock = entity.getIdleAnimationClockArm(1);
		
		idleAmplitudeX = 0.2F;
		idleAmplitudeY = 0.2F;
		
		legFntLftForelegInfo.setNewRotateX(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX);
		legFntLftForelegInfo.setNewRotateY(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY);
		
		currentIdleAnimationClock = entity.getIdleAnimationClockArm(2);
		
		for(int i = 0; i < legFntLftToes[0].length; i ++)
		{
			idleAmplitudeX = 0.4F;
			idleAmplitudeY = 0.2F;
			
			legFntLftToesInfo[0][i][1].setNewRotateX(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 + PI) * idleAmplitudeX);
			legFntLftToesInfo[0][i][1].setNewRotateY(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2 + PI) * idleAmplitudeY);
		}

		currentIdleAnimationClock = entity.getIdleAnimationClockArm(3);
		
		for(int i = 0; i < legFntLftToes[1].length; i ++)
		{
			idleAmplitudeX = 0.4F;
			idleAmplitudeY = 0.2F;
			
			legFntLftToesInfo[1][i][1].setNewRotateX(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2 + PI) * idleAmplitudeX);
			legFntLftToesInfo[1][i][1].setNewRotateY(MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2 + PI) * idleAmplitudeY);
		}
	}

	public void animateTail(EntityDoomstoneGlaceon entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float idleAmplitudeX = 0.08F;
			float idleAmplitudeY = 0.20F;

			float moveFrequency = 1F;
			float moveAmplitude = 0.1F;

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeY = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX;
			angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY
					+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);

			tailInfo[i][1].setNewRotateX(tailInfo[i][1].getNewRotateX() + angleChangeX);
			tailInfo[i][1].setNewRotateY(tailInfo[i][1].getNewRotateY() + angleChangeY);
		}
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(legFntLftJoint, legFntLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLftForelegJoint, legFntLftForelegJointInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLftForeleg, legFntLftForelegInfo.getNewRotates());

		for(int i = 0; i < legFntLftToes.length; i++)
		{
			for(int j = 0; j < legFntLftToes[i].length; j++)
			{
				this.animationDeployer.rotate(legFntLftToes[i][j][0], legFntLftToesInfo[i][j][0].getNewRotates());
				this.animationDeployer.rotate(legFntLftToes[i][j][1], legFntLftToesInfo[i][j][1].getNewRotates());
			}
		}
		
		this.animationDeployer.rotate(legFntLftJoint, legFntLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLftForelegJoint, legFntLftForelegJointInfo.getNewRotates());
		this.animationDeployer.rotate(legFntRtWrist, legFntRtWristInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}