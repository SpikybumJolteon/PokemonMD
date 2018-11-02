package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.IMobMotionTracker;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSunIdolEspeon extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public final float RUN_FREQUENCY = 0.45F;
	
    public ModelRenderer bodyChest;
    public ModelRenderer bodyBellyJoint;
    public ModelRenderer bodyBelly;
	PartInfo bodyChestInfo;
	PartInfo bodyBellyJointInfo;
	PartInfo bodyBellyInfo;
	
    public ModelRenderer legFntLftJoint;
    public ModelRenderer legFntLft;
    public ModelRenderer legFntRtJoint;
    public ModelRenderer legFntRt;
	PartInfo legFntLftJointInfo;
	PartInfo legFntLftInfo;
	PartInfo legFntRtJointInfo;
	PartInfo legFntRtInfo;
    
    public ModelRenderer legBckLftJoint;
    public ModelRenderer legBckLft;
    public ModelRenderer legBckRtJoint;
    public ModelRenderer legBckRt;
	PartInfo legBckLftJointInfo;
	PartInfo legBckLftInfo;
	PartInfo legBckRtJointInfo;
	PartInfo legBckRtInfo;

    public ModelRenderer neckJoint;
    public ModelRenderer neck;
    public ModelRenderer headJoint;
    public ModelRenderer head;
    public ModelRenderer muzzle;
	PartInfo neckJointInfo;
	PartInfo neckInfo;
	PartInfo headJointInfo;
	PartInfo headInfo;
    
    public ModelRenderer earLftJoint;
    public ModelRenderer earLft;
	PartInfo earLftInfo;
    
    public ModelRenderer earRtJoint;
    public ModelRenderer earRt;
	PartInfo earRtInfo;

	public ModelRenderer tail[][] = new ModelRenderer[4][2];
	PartInfo tailInfo[][] = new PartInfo[tail.length][2];

	public ModelRenderer tailFork[][][] = new ModelRenderer[2][5][2];
	PartInfo tailForkInfo[][][] = new PartInfo[tailFork.length][tailFork[0].length][2];

    public ModelRenderer wingLftJoint;
    public ModelRenderer wingLftFnt;
    public ModelRenderer wingLftBck;
	PartInfo wingLftJointInfo;

	public ModelRenderer wingLft[][] = new ModelRenderer[4][2];
	PartInfo wingLftInfo[][] = new PartInfo[wingLft.length][2];
    
    public ModelRenderer wingRtJoint;
    public ModelRenderer wingRtFnt;
    public ModelRenderer wingRtBck;
	PartInfo wingRtJointInfo;

	public ModelRenderer wingRt[][] = new ModelRenderer[4][2];
	PartInfo wingRtInfo[][] = new PartInfo[wingRt.length][2];

    public ModelRenderer wingBckJoint;
    public ModelRenderer wingBck;
	PartInfo wingBckJointInfo;

    public ModelSunIdolEspeon() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

		int leftSide = 0;
		int rightSide = 1;

        this.bodyChest = new ModelRenderer(this, 31, 56);
        this.bodyChest.setRotationPoint(0.0F, 15.5F, -3.0F);
        this.bodyChest.addBox(-1.5F, -1.0F, -0.5F, 3, 4, 4, 0.0F);
        bodyChestInfo = new PartInfo(bodyChest);
        this.bodyBellyJoint = new ModelRenderer(this, 46, 55);
        this.bodyBellyJoint.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.bodyBellyJoint.addBox(-1.5F, -1.0F, -0.5F, 0, 0, 0, 0.0F);
        bodyBellyJointInfo = new PartInfo(bodyBellyJoint);
        this.bodyBelly = new ModelRenderer(this, 46, 55);
        this.bodyBelly.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyBelly.addBox(-1.5F, -1.0F, -0.5F, 3, 3, 6, 0.0F);
        bodyBellyInfo = new PartInfo(bodyBelly);

        this.legFntLftJoint = new ModelRenderer(this, 55, 47);
        this.legFntLftJoint.setRotationPoint(0.8F, 2.5F, -2.0F);
        this.legFntLftJoint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntLftJoint, 0.5235987755982988F, 0.0F, 0.0F);
        legFntLftJointInfo = new PartInfo(legFntLftJoint);
        this.legFntLft = new ModelRenderer(this, 55, 47);
        this.legFntLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntLft.addBox(-0.5F, -0.5F, -0.5F, 1, 6, 1, 0.0F);
        legFntLftInfo = new PartInfo(legFntLft);
        this.legFntRtJoint = new ModelRenderer(this, 50, 47);
        this.legFntRtJoint.setRotationPoint(-0.8F, 2.5F, -2.0F);
        this.legFntRtJoint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntRtJoint, 0.5235987755982988F, 0.0F, 0.0F);
        legFntRtJointInfo = new PartInfo(legFntRtJoint);
        this.legFntRt = new ModelRenderer(this, 50, 47);
        this.legFntRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntRt.addBox(-0.5F, -0.5F, -0.5F, 1, 6, 1, 0.0F);
        legFntRtInfo = new PartInfo(legFntRt);

        this.legBckLftJoint = new ModelRenderer(this, 60, 49);
        this.legBckLftJoint.setRotationPoint(0.8F, 1.5F, 3.5F);
        this.legBckLftJoint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckLftJoint, 0.5235987755982988F, 0.0F, 0.0F);
        legBckLftJointInfo = new PartInfo(legBckLftJoint);
        this.legBckLft = new ModelRenderer(this, 60, 49);
        this.legBckLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckLft.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.legBckLft.setTextureOffset(60, 55).addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F); // legBckLftHind
		legBckLftInfo = new PartInfo(legBckLft);
        this.legBckRtJoint = new ModelRenderer(this, 45, 49);
        this.legBckRtJoint.setRotationPoint(-0.8F, 1.5F, 3.5F);
        this.legBckRtJoint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckRtJoint, 0.5235987755982988F, 0.0F, 0.0F);
        legBckRtJointInfo = new PartInfo(legBckRtJoint);
        this.legBckRt = new ModelRenderer(this, 45, 49);
        this.legBckRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckRt.addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F);
		this.legBckRt.setTextureOffset(45, 55).addBox(-0.5F, -0.5F, -0.5F, 1, 4, 1, 0.0F); // legBckRtHind
		legBckRtInfo = new PartInfo(legBckRt);

        this.neckJoint = new ModelRenderer(this, 20, 59);
        this.neckJoint.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.neckJoint.addBox(-0.5F, -0.5F, -3.5F, 0, 0, 0, 0.0F);
        neckJointInfo = new PartInfo(neckJoint);
        this.neck = new ModelRenderer(this, 20, 59);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
        neckInfo = new PartInfo(neck);
        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.headJoint.addBox(-1.5F, -2.0F, -2.0F, 0, 0, 0, 0.0F);
        headJointInfo = new PartInfo(headJoint);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-1.5F, -2.0F, -2.0F, 3, 3, 3, 0.0F);
        headInfo = new PartInfo(head);
        this.muzzle = new ModelRenderer(this, 4, 7);
        this.muzzle.setRotationPoint(0.0F, 0.1F, -1.6F);
        this.muzzle.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(muzzle, 0.17453292519943295F, -0.0F, 0.0F);

        this.earLftJoint = new ModelRenderer(this, 14, 5);
        this.earLftJoint.setRotationPoint(1.0F, -1.0F, 0.0F);
        this.earLftJoint.addBox(-0.5F, -1.2F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earLftJoint, 0.0F, 0.0F, -0.3490658503988659F);
        this.earLft = new ModelRenderer(this, 14, 5);
        this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earLft.addBox(-0.5F, -1.2F, -0.5F, 2, 3, 1, 0.0F);
		this.earLft.setTextureOffset(21, 5).addBox(1.5F, -1.0F, -0.5F, 2, 2, 1, 0.0F); // earLftMid
		this.earLft.setTextureOffset(28, 5).addBox(3.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F); // earLftTip
		earLftInfo = new PartInfo(earLft);

        this.earRtJoint = new ModelRenderer(this, 27, 0);
        this.earRtJoint.setRotationPoint(-1.0F, -1.0F, 0.0F);
        this.earRtJoint.addBox(-1.5F, -1.2F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earRtJoint, 0.0F, 0.0F, 0.3490658503988659F);
        this.earRt = new ModelRenderer(this, 27, 0);
        this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earRt.addBox(-1.5F, -1.2F, -0.5F, 2, 3, 1, 0.0F);
		this.earRt.setTextureOffset(20, 0).addBox(-3.5F, -1.0F, -0.5F, 2, 2, 1, 0.0F); // earRtMid
		this.earRt.setTextureOffset(15, 0).addBox(-4.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F); // earRtTip
		earRtInfo = new PartInfo(earRt);

		int tailNumber = 0;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 51, 42); // tail1Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 4.5F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 51, 42); // tail1
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 52, 38); // tail2Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 2.3F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 52, 38); // tail2
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 52, 34); // tail3Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 52, 34); // tail3
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);
		tailNumber++;
        this.tail[tailNumber][jointNumber] = new ModelRenderer(this, 52, 30); // tail4Joint
        this.tail[tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tail[tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
		this.tailInfo[tailNumber][jointNumber] = new PartInfo(this.tail[tailNumber][jointNumber]);
        this.tail[tailNumber][partNumber] = new ModelRenderer(this, 52, 30); // tail4
        this.tail[tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail[tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailInfo[tailNumber][partNumber] = new PartInfo(this.tail[tailNumber][partNumber]);

		tailNumber = 0;
        this.tailFork[rightSide][tailNumber][jointNumber] = new ModelRenderer(this, 48, 26); // tailForkRt1Joint
        this.tailFork[rightSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[rightSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[rightSide][tailNumber][jointNumber], 0.0F, 0.3490658503988659F, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][jointNumber]);
        this.tailFork[rightSide][tailNumber][partNumber] = new ModelRenderer(this, 48, 26); // tailForkRt1
        this.tailFork[rightSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[rightSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][partNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[rightSide][tailNumber][jointNumber] = new ModelRenderer(this, 48, 22); // tailForkRt2Joint
        this.tailFork[rightSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[rightSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[rightSide][tailNumber][jointNumber], 0.0F, -0.08726646259971647F, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][jointNumber]);
        this.tailFork[rightSide][tailNumber][partNumber] = new ModelRenderer(this, 48, 22); // tailForkRt2
        this.tailFork[rightSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[rightSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][partNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[rightSide][tailNumber][jointNumber] = new ModelRenderer(this, 48, 18); // tailForkRt3Joint
        this.tailFork[rightSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[rightSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[rightSide][tailNumber][jointNumber], 0.0F, -0.08726646259971647F, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][jointNumber]);
        this.tailFork[rightSide][tailNumber][partNumber] = new ModelRenderer(this, 48, 18); // tailForkRt3
        this.tailFork[rightSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[rightSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][partNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[rightSide][tailNumber][jointNumber] = new ModelRenderer(this, 48, 14); // tailForkRt4Joint
        this.tailFork[rightSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[rightSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[rightSide][tailNumber][jointNumber], 0.0F, -0.08726646259971647F, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][jointNumber]);
        this.tailFork[rightSide][tailNumber][partNumber] = new ModelRenderer(this, 48, 14); // tailForkRt4
        this.tailFork[rightSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[rightSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][partNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[rightSide][tailNumber][jointNumber] = new ModelRenderer(this, 48, 10); // tailForkRt5Joint
        this.tailFork[rightSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[rightSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[rightSide][tailNumber][jointNumber], 0.0F, -0.08726646259971647F, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][jointNumber]);
        this.tailFork[rightSide][tailNumber][partNumber] = new ModelRenderer(this, 48, 10); // tailForkRt5
        this.tailFork[rightSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[rightSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[rightSide][tailNumber][partNumber] = new PartInfo(this.tailFork[rightSide][tailNumber][partNumber]);

		tailNumber = 0;
        this.tailFork[leftSide][tailNumber][jointNumber] = new ModelRenderer(this, 56, 26); // tailForkLft1Joint
        this.tailFork[leftSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[leftSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[leftSide][tailNumber][jointNumber], 0.0F, -0.3490658503988659F, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][jointNumber]);
        this.tailFork[leftSide][tailNumber][partNumber] = new ModelRenderer(this, 56, 26); // tailForkLft1
        this.tailFork[leftSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[leftSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][partNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[leftSide][tailNumber][jointNumber] = new ModelRenderer(this, 56, 22); // tailForkLft2Joint
        this.tailFork[leftSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[leftSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[leftSide][tailNumber][jointNumber], 0.0F, 0.08726646259971647F, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][jointNumber]);
        this.tailFork[leftSide][tailNumber][partNumber] = new ModelRenderer(this, 56, 22); // tailForkLft2
        this.tailFork[leftSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[leftSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][partNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[leftSide][tailNumber][jointNumber] = new ModelRenderer(this, 56, 18); // tailForkLft3Joint
        this.tailFork[leftSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[leftSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[leftSide][tailNumber][jointNumber], 0.0F, 0.08726646259971647F, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][jointNumber]);
        this.tailFork[leftSide][tailNumber][partNumber] = new ModelRenderer(this, 56, 18); // tailForkLft3
        this.tailFork[leftSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[leftSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][partNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[leftSide][tailNumber][jointNumber] = new ModelRenderer(this, 56, 14); // tailForkLft4Joint
        this.tailFork[leftSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[leftSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[leftSide][tailNumber][jointNumber], 0.0F, 0.08726646259971647F, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][jointNumber]);
        this.tailFork[leftSide][tailNumber][partNumber] = new ModelRenderer(this, 56, 14); // tailForkLft4
        this.tailFork[leftSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[leftSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][partNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][partNumber]);
		tailNumber++;
        this.tailFork[leftSide][tailNumber][jointNumber] = new ModelRenderer(this, 56, 10); // tailForkLft5Joint
        this.tailFork[leftSide][tailNumber][jointNumber].setRotationPoint(0.0F, 0.0F, 1.7F);
        this.tailFork[leftSide][tailNumber][jointNumber].addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.setRotateAngle(tailFork[leftSide][tailNumber][jointNumber], 0.0F, 0.08726646259971647F, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][jointNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][jointNumber]);
        this.tailFork[leftSide][tailNumber][partNumber] = new ModelRenderer(this, 56, 10); // tailForkLft5
        this.tailFork[leftSide][tailNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFork[leftSide][tailNumber][partNumber].addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
		this.tailForkInfo[leftSide][tailNumber][partNumber] = new PartInfo(this.tailFork[leftSide][tailNumber][partNumber]);

        this.wingLftJoint = new ModelRenderer(this, 25, 39);
        this.wingLftJoint.setRotationPoint(4.5F, -5.0F, 0.0F);
        this.wingLftJoint.addBox(-1.0F, -0.5F, -4.6F, 0, 0, 0, 0.0F);
        this.wingLftFnt = new ModelRenderer(this, 25, 39);
        this.wingLftFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wingLftFnt.addBox(-1.0F, -0.5F, -4.6F, 2, 1, 5, 0.0F);
        this.setRotateAngle(wingLftFnt, 0.0F, 0.17453292519943295F, 0.0F);
        this.wingLftBck = new ModelRenderer(this, 25, 33);
        this.wingLftBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wingLftBck.addBox(-1.0F, -0.4F, -0.3F, 2, 1, 5, 0.0F);
        this.setRotateAngle(wingLftBck, 0.0F, -0.17453292519943295F, 0.0F);

        int wingBaseNumber = 0;
        int wingEndNumber = 1;
        
        int wingNumber = 0;
        this.wingLft[wingNumber][wingBaseNumber] = new ModelRenderer(this, 34, 40); // wingLft1Base
        this.wingLft[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, -3.5F);
        this.wingLft[wingNumber][wingBaseNumber].addBox(0.0F, -0.4F, -1.0F, 6, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingBaseNumber], 0.0F, 0.5235987755982988F, 0.0F);
		this.wingLftInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingLft[wingNumber][wingBaseNumber]);
        this.wingLft[wingNumber][wingEndNumber] = new ModelRenderer(this, 36, 45); // wingLft1End
        this.wingLft[wingNumber][wingEndNumber].setRotationPoint(5.0F, 0.0F, 0.0F);
        this.wingLft[wingNumber][wingEndNumber].addBox(0.0F, -0.5F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingEndNumber], 0.0F, 0.5235987755982988F, 0.0F);
		this.wingLftInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingLft[wingNumber][wingEndNumber]);
        wingNumber++;
        this.wingLft[wingNumber][wingBaseNumber] = new ModelRenderer(this, 25, 27); // wingLft2Base
        this.wingLft[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, -1.1F);
        this.wingLft[wingNumber][wingBaseNumber].addBox(0.0F, -0.4F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingBaseNumber], 0.0F, 0.17453292519943295F, 0.0F);
		this.wingLftInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingLft[wingNumber][wingBaseNumber]);
        this.wingLft[wingNumber][wingEndNumber] = new ModelRenderer(this, 36, 30); // wingLft2End
        this.wingLft[wingNumber][wingEndNumber].setRotationPoint(4.0F, 0.0F, 0.0F);
        this.wingLft[wingNumber][wingEndNumber].addBox(0.0F, -0.5F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingEndNumber], 0.0F, 0.3490658503988659F, 0.0F);
		this.wingLftInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingLft[wingNumber][wingEndNumber]);
        wingNumber++;
        this.wingLft[wingNumber][wingBaseNumber] = new ModelRenderer(this, 25, 21); // wingLft3Base
        this.wingLft[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
        this.wingLft[wingNumber][wingBaseNumber].addBox(0.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingBaseNumber], 0.0F, 0.17453292519943295F, 0.0F);
		this.wingLftInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingLft[wingNumber][wingBaseNumber]);
        this.wingLft[wingNumber][wingEndNumber] = new ModelRenderer(this, 35, 24); // wingLft3End
        this.wingLft[wingNumber][wingEndNumber].setRotationPoint(3.0F, 0.0F, 0.0F);
        this.wingLft[wingNumber][wingEndNumber].addBox(0.0F, -0.4F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingEndNumber], 0.0F, 0.17453292519943295F, 0.0F);
		this.wingLftInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingLft[wingNumber][wingEndNumber]);
        wingNumber++;
        this.wingLft[wingNumber][wingBaseNumber] = new ModelRenderer(this, 25, 17); // wingLft4Base
        this.wingLft[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, 3.6F);
        this.wingLft[wingNumber][wingBaseNumber].addBox(0.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingBaseNumber], 0.0F, -0.17453292519943295F, 0.0F);
		this.wingLftInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingLft[wingNumber][wingBaseNumber]);
        this.wingLft[wingNumber][wingEndNumber] = new ModelRenderer(this, 37, 17); // wingLft4End
        this.wingLft[wingNumber][wingEndNumber].setRotationPoint(3.0F, 0.0F, 0.0F);
        this.wingLft[wingNumber][wingEndNumber].addBox(0.0F, -0.4F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(wingLft[wingNumber][wingEndNumber], 0.0F, 0.3490658503988659F, 0.0F);
		this.wingLftInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingLft[wingNumber][wingEndNumber]);

        this.wingRtJoint = new ModelRenderer(this, 11, 39);
        this.wingRtJoint.setRotationPoint(-4.5F, -5.0F, 0.0F);
        this.wingRtJoint.addBox(-1.0F, -0.5F, -4.6F, 0, 0, 0, 0.0F);
        this.wingRtFnt = new ModelRenderer(this, 11, 39);
        this.wingRtFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wingRtFnt.addBox(-1.0F, -0.5F, -4.6F, 2, 1, 5, 0.0F);
        this.setRotateAngle(wingRtFnt, 0.0F, -0.17453292519943295F, 0.0F);
        this.wingRtBck = new ModelRenderer(this, 11, 33);
        this.wingRtBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wingRtBck.addBox(-1.0F, -0.4F, -0.3F, 2, 1, 5, 0.0F);
        this.setRotateAngle(wingRtBck, 0.0F, 0.17453292519943295F, 0.0F);
        
        wingNumber = 0;
        this.wingRt[wingNumber][wingBaseNumber] = new ModelRenderer(this, 0, 41); // wingRt1Base
        this.wingRt[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, -3.5F);
        this.wingRt[wingNumber][wingBaseNumber].addBox(-6.0F, -0.4F, -1.0F, 6, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingBaseNumber], 0.0F, -0.5235987755982988F, 0.0F);
		this.wingRtInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingRt[wingNumber][wingBaseNumber]);
        this.wingRt[wingNumber][wingEndNumber] = new ModelRenderer(this, 0, 45); // wingRt1End
        this.wingRt[wingNumber][wingEndNumber].setRotationPoint(-5.0F, 0.0F, 0.0F);
        this.wingRt[wingNumber][wingEndNumber].addBox(-5.0F, -0.5F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingEndNumber], 0.0F, -0.5235987755982988F, 0.0F);
		this.wingRtInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingRt[wingNumber][wingEndNumber]);
        wingNumber++;
        this.wingRt[wingNumber][wingBaseNumber] = new ModelRenderer(this, 11, 27); // wingRt2Base
        this.wingRt[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, -1.1F);
        this.wingRt[wingNumber][wingBaseNumber].addBox(-5.0F, -0.4F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingBaseNumber], 0.0F, -0.17453292519943295F, 0.0F);
		this.wingRtInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingRt[wingNumber][wingBaseNumber]);
        this.wingRt[wingNumber][wingEndNumber] = new ModelRenderer(this, 0, 30); // wingRt2End
        this.wingRt[wingNumber][wingEndNumber].setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.wingRt[wingNumber][wingEndNumber].addBox(-5.0F, -0.5F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingEndNumber], 0.0F, -0.3490658503988659F, 0.0F);
		this.wingRtInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingRt[wingNumber][wingEndNumber]);
        wingNumber++;
        this.wingRt[wingNumber][wingBaseNumber] = new ModelRenderer(this, 13, 21); // wingRt3Base
        this.wingRt[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, 1.2F);
        this.wingRt[wingNumber][wingBaseNumber].addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingBaseNumber], 0.0F, -0.17453292519943295F, 0.0F);
		this.wingRtInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingRt[wingNumber][wingBaseNumber]);
        this.wingRt[wingNumber][wingEndNumber] = new ModelRenderer(this, 1, 24); // wingRt3End
        this.wingRt[wingNumber][wingEndNumber].setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.wingRt[wingNumber][wingEndNumber].addBox(-5.0F, -0.4F, -1.0F, 5, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingEndNumber], 0.0F, -0.17453292519943295F, 0.0F);
		this.wingRtInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingRt[wingNumber][wingEndNumber]);
        wingNumber++;
        this.wingRt[wingNumber][wingBaseNumber] = new ModelRenderer(this, 13, 17); // wingRt4Base
        this.wingRt[wingNumber][wingBaseNumber].setRotationPoint(0.0F, 0.0F, 3.6F);
        this.wingRt[wingNumber][wingBaseNumber].addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingBaseNumber], 0.0F, 0.17453292519943295F, 0.0F);
		this.wingRtInfo[wingNumber][wingBaseNumber] = new PartInfo(this.wingRt[wingNumber][wingBaseNumber]);
        this.wingRt[wingNumber][wingEndNumber] = new ModelRenderer(this, 1, 17); // wingRt4End
        this.wingRt[wingNumber][wingEndNumber].setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.wingRt[wingNumber][wingEndNumber].addBox(-4.0F, -0.4F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(wingRt[wingNumber][wingEndNumber], 0.0F, -0.3490658503988659F, 0.0F);
		this.wingRtInfo[wingNumber][wingEndNumber] = new PartInfo(this.wingRt[wingNumber][wingEndNumber]);

        this.wingBckJoint = new ModelRenderer(this, 5, 61);
        this.wingBckJoint.setRotationPoint(0.0F, -5.0F, 4.0F);
        this.wingBckJoint.addBox(-1.0F, -0.5F, 0.0F, 0, 0, 0, 0.0F);
        wingBckJointInfo = new PartInfo(wingBckJoint);
        this.wingBck = new ModelRenderer(this, 5, 61);
        this.wingBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wingBck.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
		this.wingBck.setTextureOffset(0, 62).addBox(-2.0F, -0.5F, 0.5F, 1, 1, 1, 0.0F); // wingBckRt
		this.wingBck.setTextureOffset(14, 62).addBox(1.0F, -0.5F, 0.5F, 1, 1, 1, 0.0F); // wingBckLft
		this.wingBck.setTextureOffset(7, 58).addBox(-0.5F, -0.5F, 2.0F, 1, 1, 1, 0.0F); // wingBckMid
		this.wingBck.setTextureOffset(6, 55).addBox(-1.0F, -0.5F, 3.0F, 2, 1, 1, 0.0F); // wingBckEnd
		this.wingBck.setTextureOffset(5, 50).addBox(-0.5F, -0.5F, 4.0F, 1, 1, 3, 0.0F); // wingBckEndTip

        this.bodyChest.addChild(this.bodyBellyJoint);

        this.bodyBellyJoint.addChild(this.bodyBelly);
        this.bodyBellyJoint.addChild(this.wingBckJoint);
        this.bodyBellyJoint.addChild(this.wingLftJoint);
        this.bodyBellyJoint.addChild(this.wingRtJoint);
        
        this.bodyBelly.addChild(this.neckJoint);
        this.bodyBelly.addChild(this.legBckLftJoint);
        this.bodyBelly.addChild(this.legBckRtJoint);
        this.bodyBelly.addChild(this.legFntLftJoint);
        this.bodyBelly.addChild(this.legFntRtJoint);
        this.bodyBelly.addChild(this.tail[0][0]);

        this.neckJoint.addChild(this.neck);
        this.neck.addChild(this.headJoint);
        
        this.headJoint.addChild(this.head);
        this.head.addChild(this.earLftJoint);
        this.head.addChild(this.earRtJoint);
        this.head.addChild(this.muzzle);
        
        this.earLftJoint.addChild(this.earLft);
        this.earRtJoint.addChild(this.earRt);
        
        this.legFntLftJoint.addChild(this.legFntLft);
        this.legFntRtJoint.addChild(this.legFntRt);
        this.legBckLftJoint.addChild(this.legBckLft);
        this.legBckRtJoint.addChild(this.legBckRt);

		for(int i = 0; i < tail.length - 1; i++)
		{
			this.tail[i][0].addChild(this.tail[i][1]);
			this.tail[i][1].addChild(this.tail[i + 1][0]);
		}

		this.tail[tail.length - 1][0].addChild(tail[tail.length - 1][1]);

		this.tail[tail.length - 1][1].addChild(this.tailFork[leftSide][0][0]);
		this.tail[tail.length - 1][1].addChild(this.tailFork[rightSide][0][0]);

		for(int i = 0; i < tailFork.length; i++)
		{
			for(int j = 0; j < tailFork[i].length - 1; j++)
			{
				this.tailFork[i][j][0].addChild(this.tailFork[i][j][1]);
				this.tailFork[i][j][1].addChild(this.tailFork[i][j + 1][0]);
			}
		}

        this.wingLftJoint.addChild(this.wingLftBck);
        this.wingLftJoint.addChild(this.wingLftFnt);

        this.wingLftFnt.addChild(this.wingLft[0][0]);
        this.wingLftFnt.addChild(this.wingLft[1][0]);
        this.wingLftBck.addChild(this.wingLft[2][0]);
        this.wingLftBck.addChild(this.wingLft[3][0]);

        this.wingLft[0][0].addChild(this.wingLft[0][1]);
        this.wingLft[1][0].addChild(this.wingLft[1][1]);
        this.wingLft[2][0].addChild(this.wingLft[2][1]);
        this.wingLft[3][0].addChild(this.wingLft[3][1]);

        this.wingRtFnt.addChild(this.wingRt[0][0]);
        this.wingRtFnt.addChild(this.wingRt[1][0]);
        this.wingRtBck.addChild(this.wingRt[2][0]);
        this.wingRtBck.addChild(this.wingRt[3][0]);

        this.wingRt[0][0].addChild(this.wingRt[0][1]);
        this.wingRt[1][0].addChild(this.wingRt[1][1]);
        this.wingRt[2][0].addChild(this.wingRt[2][1]);
        this.wingRt[3][0].addChild(this.wingRt[3][1]);
        
        this.wingRtJoint.addChild(this.wingRtBck);
        this.wingRtJoint.addChild(this.wingRtFnt);

        this.wingBckJoint.addChild(this.wingBck);

		animationDeployer = new AnimationDeployer(this);
    }

    @Override
    public void render(Entity entity, float distanceMoved, float horzVelocity, float ageInTicks, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{
		animate(entity, distanceMoved, horzVelocity, ageInTicks, yawHeadOffsetDifference, pitchRotation, modelSize);

        this.bodyChest.render(modelSize);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	public void animate(Entity entity, float distanceMoved, float horzVelocity, float ageInTicks, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{	
		this.animationDeployer.update((IAnimatedEntity)entity);
		resetPartInfos();

		float angularVelocity = ((IMobMotionTracker)entity).getAngularVelocity();
		float verticleVelocity = (float)((IMobMotionTracker)entity).getHeightVelocity();

		float idleDampener = 1F;

		float tick = animationDeployer.getEntity().getAnimationTick() + PokemonMDMain.proxy.getPartialTick();

		//if(animationDeployer.getEntity().getAnimationID() == LibraryNecromancerDelphoxAttackID.FLAMETHROWER)
		//{
			//idleDampener = animateMajorCast(animationDeployer.getEntity(), distanceMoved, horzVelocity, ageInTicks, yawHeadOffsetDifference, pitchRotation, modelSize);
		//}
/*
		animateBody((EntitySunIdolEspeon)entity, distanceMoved, horzVelocity, ageInTicks, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateHead((EntitySunIdolEspeon)entity, distanceMoved, horzVelocity, ageInTicks, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateLegs((EntitySunIdolEspeon)entity, distanceMoved, horzVelocity, ageInTicks, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateTail((EntitySunIdolEspeon)entity, distanceMoved, horzVelocity, ageInTicks, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
		animateWings((EntitySunIdolEspeon)entity, distanceMoved, horzVelocity, ageInTicks, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener, verticleVelocity, angularVelocity);
*/
		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyChestInfo.resetNewAngles();
		bodyChestInfo.resetNewPnt();

		bodyBellyJointInfo.resetNewAngles();
		bodyBellyInfo.resetNewAngles();

		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		earLftInfo.resetNewAngles();
		earRtInfo.resetNewAngles();

		legFntRtJointInfo.resetNewAngles();
		legFntLftJointInfo.resetNewAngles();
		legBckRtJointInfo.resetNewAngles();
		legBckLftJointInfo.resetNewAngles();
		legFntRtInfo.resetNewAngles();
		legFntLftInfo.resetNewAngles();
		legBckRtInfo.resetNewAngles();
		legBckLftInfo.resetNewAngles();

		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i][0].resetNewAngles();
			tailInfo[i][1].resetNewAngles();
		}

		for(int i = 0; i < tailFork.length; i++)
		{
			for(int j = 0; j < tailFork[i].length - 1; j++)
			{
				this.tailForkInfo[i][j][0].resetNewAngles();
				this.tailForkInfo[i][j][1].resetNewAngles();
			}
		}

		wingRtJointInfo.resetNewAngles();
		wingLftJointInfo.resetNewAngles();

		for(int i = 0; i < wingRt.length; i++)
		{
			wingRtInfo[i][0].resetNewAngles();
			wingRtInfo[i][1].resetNewAngles();
			wingLftInfo[i][0].resetNewAngles();
			wingLftInfo[i][1].resetNewAngles();
		}
	}
	/*
	public void animateBody(EntitySunIdolEspeon entity, float distanceMoved, float horzVelocity, float ageInTicks, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity)
	{
		
	}
	
	public void animateHead(EntitySunIdolEspeon entity, float distanceMoved, float horzVelocity, float ageInTicks, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity)
	{
		
	}
	
	public void animateLegs(EntitySunIdolEspeon entity, float distanceMoved, float horzVelocity, float ageInTicks, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity)
	{
		
	}
	
	public void animateTail(EntitySunIdolEspeon entity, float distanceMoved, float horzVelocity, float ageInTicks, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity)
	{
		
	}
	
	public void animateWings(EntitySunIdolEspeon entity, float distanceMoved, float horzVelocity, float ageInTicks, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener, float verticalVelocity)
	{
		
	}*/
	
	public void deployAnimations()
	{
		this.animationDeployer.rotate(bodyChest, bodyChestInfo.getNewRotates());
		this.animationDeployer.move(bodyChest, bodyChestInfo.getNewPnt());

		this.animationDeployer.rotate(bodyBellyJoint, bodyBellyJointInfo.getNewRotates());
		this.animationDeployer.rotate(bodyBelly, bodyBellyInfo.getNewRotates());

		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(earLft, earLftInfo.getNewRotates());
		this.animationDeployer.rotate(earRt, earRtInfo.getNewRotates());

		this.animationDeployer.rotate(legFntRt, legFntRtInfo.getNewRotates());
		this.animationDeployer.rotate(legFntLft, legFntLftInfo.getNewRotates());
		this.animationDeployer.rotate(legBckRt, legBckRtInfo.getNewRotates());
		this.animationDeployer.rotate(legBckLft, legBckLftInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i][0], tailInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(tail[i][1], tailInfo[i][1].getNewRotates());
		}

		this.animationDeployer.rotate(wingRtJoint, wingRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(wingLftJoint, wingLftJointInfo.getNewRotates());

		for(int i = 0; i < wingRt.length; i++)
		{
			this.animationDeployer.rotate(wingRt[i][0], wingRtInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(wingRt[i][1], wingRtInfo[i][1].getNewRotates());
			this.animationDeployer.rotate(wingLft[i][0], wingLftInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(wingLft[i][1], wingLftInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}