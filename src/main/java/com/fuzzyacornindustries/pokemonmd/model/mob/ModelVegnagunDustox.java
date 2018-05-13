package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityVegnagunDustox;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVegnagunDustox extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

    public ModelRenderer body;
	PartInfo bodyInfo;
    
    public ModelRenderer hornRt;
    public ModelRenderer hornRtMid;
    public ModelRenderer hornRtEnd;
    public ModelRenderer hornRtEndTip;
    public ModelRenderer hornLft;
    public ModelRenderer hornLftMid;
    public ModelRenderer hornLftEnd;
    public ModelRenderer hornLftEndTip;

    public ModelRenderer sideHornRt;
    public ModelRenderer sideHornRtEnd;
    public ModelRenderer sideHornLft;
    public ModelRenderer sideHornLftEnd;

    public ModelRenderer leg[][][] = new ModelRenderer[4][3][2];
	public PartInfo legInfo[][][] = new PartInfo[leg.length][leg[0].length][leg[0][0].length];

	public ModelRenderer wing[][] = new ModelRenderer[4][2];
	PartInfo wingInfo[][] = new PartInfo[wing.length][wing[0].length];

    public ModelRenderer gunBarrelJoint;
    public ModelRenderer gunBarrel;
    public ModelRenderer gunBarrelEnd;
    public ModelRenderer gunBarrelEdges;
	PartInfo gunBarrelJointInfo;
	PartInfo gunBarrelInfo;

    public ModelVegnagunDustox() 
    {
        this.textureWidth = 128;
        this.textureHeight = 64;

		int jointNumber = 0;
		int partNumber = 1;

        this.body = new ModelRenderer(this, 33, 49);
        this.body.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.body.addBox(-4.0F, -6.0F, -4.0F, 8, 7, 8, 0.0F);
        this.setRotateAngle(body, 0.3490658503988659F, 0.0F, 0.0F);
        this.body.setTextureOffset(22, 41).addBox(-3.0F, -8.0F, -3.0F, 6, 2, 6, 0.0F); // bodyTop
        this.body.setTextureOffset(25, 50).addBox(-2.0F, -9.0F, -2.0F, 4, 1, 4, 0.0F); // bodyTopTip
        this.body.setTextureOffset(0, 37).addBox(-3.5F, 1.0F, -3.5F, 7, 3, 7, 0.0F); // bodyMid
        this.body.setTextureOffset(0, 47).addBox(-3.0F, 3.5F, -3.0F, 6, 3, 6, 0.0F); // 
        this.body.setTextureOffset(13, 56).addBox(-2.5F, 6.0F, -2.5F, 5, 2, 5, 0.0F); // bodyBot
        this.body.setTextureOffset(0, 59).addBox(-2.0F, 8.0F, -2.0F, 4, 1, 4, 0.0F); // bodyBotTip
        bodyInfo = new PartInfo(body);

        this.hornRt = new ModelRenderer(this, 66, 13);
        this.hornRt.setRotationPoint(-2.5F, -6.3F, -2.0F);
        this.hornRt.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(hornRt, -0.3490658503988659F, 1.0471975511965976F, 0.0F);
        this.hornRtMid = new ModelRenderer(this, 66, 21);
        this.hornRtMid.setRotationPoint(0.0F, 0.0F, -5.4F);
        this.hornRtMid.addBox(-1.0F, -1.0F, -5.6F, 2, 2, 6, 0.0F);
        this.setRotateAngle(hornRtMid, -0.4363323129985824F, -1.1344640137963142F, 0.0F);
        this.hornRtEnd = new ModelRenderer(this, 70, 29);
        this.hornRtEnd.setRotationPoint(0.0F, 0.0F, -5.1F);
        this.hornRtEnd.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 2, 0.0F);
        this.setRotateAngle(hornRtEnd, -0.7853981633974483F, 0.3490658503988659F, -0.3490658503988659F);
        this.hornRtEndTip = new ModelRenderer(this, 70, 33);
        this.hornRtEndTip.setRotationPoint(0.0F, 0.0F, -5.1F);
        this.hornRtEndTip.addBox(-0.5F, -0.5F, -4.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(hornRtEndTip, -0.7853981633974483F, 0.3490658503988659F, -0.3490658503988659F);

        this.hornLft = new ModelRenderer(this, 83, 13);
        this.hornLft.setRotationPoint(2.5F, -6.3F, -2.0F);
        this.hornLft.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(hornLft, -0.3490658503988659F, -1.0471975511965976F, 0.0F);
        this.hornLftMid = new ModelRenderer(this, 83, 21);
        this.hornLftMid.setRotationPoint(0.0F, 0.0F, -5.4F);
        this.hornLftMid.addBox(-1.0F, -1.0F, -5.6F, 2, 2, 6, 0.0F);
        this.setRotateAngle(hornLftMid, -0.4363323129985824F, 1.1344640137963142F, 0.0F);
        this.hornLftEnd = new ModelRenderer(this, 87, 29);
        this.hornLftEnd.setRotationPoint(0.0F, 0.0F, -5.1F);
        this.hornLftEnd.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 2, 0.0F);
        this.setRotateAngle(hornLftEnd, -0.7853981633974483F, -0.3490658503988659F, 0.3490658503988659F);
        this.hornLftEndTip = new ModelRenderer(this, 87, 33);
        this.hornLftEndTip.setRotationPoint(0.0F, 0.0F, -5.1F);
        this.hornLftEndTip.addBox(-0.5F, -0.5F, -4.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(hornLftEndTip, -0.7853981633974483F, -0.3490658503988659F, 0.3490658503988659F);

        this.sideHornRt = new ModelRenderer(this, 41, 34);
        this.sideHornRt.setRotationPoint(-3.0F, -4.0F, -3.0F);
        this.sideHornRt.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 4, 0.0F);
        this.setRotateAngle(sideHornRt, 0.7853981633974483F, 0.0F, 0.4363323129985824F);
        this.sideHornRtEnd = new ModelRenderer(this, 41, 40);
        this.sideHornRtEnd.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.sideHornRtEnd.addBox(-1.0F, -1.0F, -3.1F, 2, 2, 4, 0.0F);
        this.setRotateAngle(sideHornRtEnd, -1.2217304763960306F, 0.0F, 0.4363323129985824F);
        this.sideHornLft = new ModelRenderer(this, 53, 34);
        this.sideHornLft.setRotationPoint(3.0F, -4.0F, -3.0F);
        this.sideHornLft.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 4, 0.0F);
        this.setRotateAngle(sideHornLft, 0.7853981633974483F, 0.0F, -0.4363323129985824F);
        this.sideHornLftEnd = new ModelRenderer(this, 53, 40);
        this.sideHornLftEnd.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.sideHornLftEnd.addBox(-1.0F, -1.0F, -3.1F, 2, 2, 4, 0.0F);
        this.setRotateAngle(sideHornLftEnd, -1.2217304763960306F, 0.0F, -0.4363323129985824F);

        int legNumber = 0;
        int legSegmentNumber = 0;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 0, 0); // legFntRt1Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(-2.0F, 0.0F, -3.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.5F, -1.5F, 2, 3, 2, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 0, 0); // legFntRt1
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.5F, -1.5F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 0, 5); // legFntRt2Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 1.5F, -0.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.1F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -1.1344640137963142F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 0, 5); // legFntRt2
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.09F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 0, 10); // legFntRt3Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.4F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], 1.48352986419518F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 0, 10); // legFntRt3
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.4F, -1.0F, 2, 6, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber = 0;
        legNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 0, 19); // legBckRt1Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(-2.1F, 3.0F, -2.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 0, 19); // legBckRt1
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.5F, -1.5F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 0, 24); // legBckRt2Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 1.5F, -0.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.1F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -1.2217304763960306F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 0, 24); // legBckRt2
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.01F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 0, 29); // legBckRt3Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.4F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], 1.7453292519943295F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 0, 29); // legBckRt3
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.4F, -1.0F, 2, 4, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber = 0;
        legNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 9, 0); // legFntLft1Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(2.0F, 0.0F, -3.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -0.5235987755982988F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 9, 0); // legFntLft1
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.5F, -1.5F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 9, 5); // legFntLft2Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 1.5F, -0.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-0.9F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -1.1344640137963142F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 9, 5); // legFntLft2
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-0.99F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 9, 10); // legFntLft3Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.4F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], 1.48352986419518F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 9, 10); // legFntLft3
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.4F, -1.0F, 2, 6, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber = 0;
        legNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 9, 19); // legBckLft1Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(2.1F, 3.0F, -2.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -0.2617993877991494F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 9, 19); // legBckLft1
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.5F, -1.5F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 9, 24); // legBckLft2Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 1.5F, -0.5F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-0.9F, 0.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], -1.2217304763960306F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 9, 24); // legBckLft2
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-0.99F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);
        legSegmentNumber++;
        this.leg[legNumber][legSegmentNumber][jointNumber] = new ModelRenderer(this, 9, 29); // legBckLft3Joint
        this.leg[legNumber][legSegmentNumber][jointNumber].setRotationPoint(0.0F, 2.5F, 0.0F);
        this.leg[legNumber][legSegmentNumber][jointNumber].addBox(-1.0F, -0.4F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leg[legNumber][legSegmentNumber][jointNumber], 1.7453292519943295F, 0.0F, 0.0F);
        legInfo[legNumber][legSegmentNumber][jointNumber] = new PartInfo(leg[legNumber][legSegmentNumber][jointNumber]);
        this.leg[legNumber][legSegmentNumber][partNumber] = new ModelRenderer(this, 9, 29); // legBckLft3
        this.leg[legNumber][legSegmentNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leg[legNumber][legSegmentNumber][partNumber].addBox(-1.0F, -0.4F, -1.0F, 2, 4, 2, 0.0F);
        legInfo[legNumber][legSegmentNumber][partNumber] = new PartInfo(leg[legNumber][legSegmentNumber][partNumber]);

        int wingNumber = 0;
        this.wing[wingNumber][jointNumber] = new ModelRenderer(this, 66, 57); // wingTopRtJoint
        this.wing[wingNumber][jointNumber].setRotationPoint(-3.5F, -2.0F, 0.0F);
        this.wing[wingNumber][jointNumber].addBox(-5.0F, -3.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(wing[wingNumber][jointNumber], 0.0F, 0.12217304763960307F, 0.3490658503988659F);
        wingInfo[wingNumber][jointNumber] = new PartInfo(wing[wingNumber][jointNumber]);
        this.wing[wingNumber][partNumber] = new ModelRenderer(this, 66, 57); // wingTopRt
        this.wing[wingNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wing[wingNumber][partNumber].addBox(-5.0F, -3.0F, -0.5F, 7, 6, 1, 0.0F);
        this.wing[wingNumber][partNumber].setTextureOffset(82, 52).addBox(-27.0F, -3.0F, 0.0F, 22, 11, 1, 0.0F); // wingTopRtTip
        wingInfo[wingNumber][partNumber] = new PartInfo(wing[wingNumber][partNumber]);
        wingNumber++;
        this.wing[wingNumber][jointNumber] = new ModelRenderer(this, 66, 44); // wingBotRtJoint
        this.wing[wingNumber][jointNumber].setRotationPoint(-2.5F, 3.0F, 0.5F);
        this.wing[wingNumber][jointNumber].addBox(-6.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(wing[wingNumber][jointNumber], 0.0F, 0.0F, -0.10471975511965977F);
        wingInfo[wingNumber][jointNumber] = new PartInfo(wing[wingNumber][jointNumber]);
        this.wing[wingNumber][partNumber] = new ModelRenderer(this, 66, 44); // wingBotRt
        this.wing[wingNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wing[wingNumber][partNumber].addBox(-6.0F, -2.0F, -0.5F, 7, 5, 1, 0.0F);
        this.wing[wingNumber][partNumber].setTextureOffset(100, 30).addBox(-19.0F, -2.0F, 0.0F, 13, 9, 1, 0.0F); // wingBotRtTip
        wingInfo[wingNumber][partNumber] = new PartInfo(wing[wingNumber][partNumber]);
        wingNumber++;
        this.wing[wingNumber][jointNumber] = new ModelRenderer(this, 66, 50); // wingTopLftJoint
        this.wing[wingNumber][jointNumber].setRotationPoint(3.5F, -2.0F, 0.0F);
        this.wing[wingNumber][jointNumber].addBox(-1.0F, -3.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(wing[wingNumber][jointNumber], 0.0F, -0.12217304763960307F, -0.3490658503988659F);
        wingInfo[wingNumber][jointNumber] = new PartInfo(wing[wingNumber][jointNumber]);
        this.wing[wingNumber][partNumber] = new ModelRenderer(this, 66, 50); // wingTopLft
        this.wing[wingNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wing[wingNumber][partNumber].addBox(-1.0F, -3.0F, -0.5F, 7, 6, 1, 0.0F);
        this.wing[wingNumber][partNumber].setTextureOffset(82, 40).addBox(6.0F, -3.0F, 0.0F, 22, 11, 1, 0.0F); // wingTopLftTip
        wingInfo[wingNumber][partNumber] = new PartInfo(wing[wingNumber][partNumber]);
        wingNumber++;
        this.wing[wingNumber][jointNumber] = new ModelRenderer(this, 66, 38); // wingBotLftJoint
        this.wing[wingNumber][jointNumber].setRotationPoint(2.5F, 3.0F, 0.5F);
        this.wing[wingNumber][jointNumber].addBox(0.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(wing[wingNumber][jointNumber], 0.0F, 0.0F, 0.10471975511965977F);
        wingInfo[wingNumber][jointNumber] = new PartInfo(wing[wingNumber][jointNumber]);
        this.wing[wingNumber][partNumber] = new ModelRenderer(this, 66, 38); // wingBotLft
        this.wing[wingNumber][partNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wing[wingNumber][partNumber].addBox(0.0F, -2.0F, -0.5F, 7, 5, 1, 0.0F);
        this.wing[wingNumber][partNumber].setTextureOffset(100, 20).addBox(7.0F, -2.0F, 0.0F, 13, 9, 1, 0.0F); // wingBotLftTip
        wingInfo[wingNumber][partNumber] = new PartInfo(wing[wingNumber][partNumber]);

        this.gunBarrelJoint = new ModelRenderer(this, 104, 8);
        this.gunBarrelJoint.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.gunBarrelJoint.addBox(-1.0F, -1.0F, -10.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(gunBarrelJoint, -0.3490658503988659F, 0.0F, 0.0F);
        gunBarrelJointInfo = new PartInfo(gunBarrelJoint);
        this.gunBarrel = new ModelRenderer(this, 104, 8);
        this.gunBarrel.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gunBarrel.addBox(-1.0F, -1.0F, -10.0F, 2, 2, 10, 0.0F);
        this.gunBarrelEdges = new ModelRenderer(this, 92, 0); // gunBarrelTop
        this.gunBarrelEdges.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gunBarrelEdges.addBox(-0.9F, -0.9F, -10.02F, 1, 1, 10, 0.0F);
        this.setRotateAngle(gunBarrelEdges, 0.0F, 0.0F, 0.7853981633974483F);
        this.gunBarrelEdges.setTextureOffset(80, 1).addBox(-0.1F, -0.1F, -10.03F, 1, 1, 10, 0.0F); // gunBarrelBot
        this.gunBarrelEdges.setTextureOffset(68, 0).addBox(-0.1F, -0.9F, -10.04F, 1, 1, 10, 0.0F); // gunBarrelLft
        this.gunBarrelEdges.setTextureOffset(56, 1).addBox(-0.9F, -0.1F, -10.05F, 1, 1, 10, 0.0F); // gunBarrelRt
        this.gunBarrelEnd = new ModelRenderer(this, 104, 0); // gunBarrelCannonTop
        this.gunBarrelEnd.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gunBarrelEnd.addBox(-1.5F, -1.5F, -13.0F, 3, 1, 3, 0.0F);
        this.gunBarrelEnd.setTextureOffset(116, 1).addBox(-1.5F, 0.5F, -13.0F, 3, 1, 3, 0.0F); // gunBarrelCannonBot
        this.gunBarrelEnd.setTextureOffset(104, 5).addBox(-1.5F, -0.5F, -13.0F, 1, 1, 3, 0.0F); // gunBarrelCannonRt
        this.gunBarrelEnd.setTextureOffset(110, 4).addBox(0.5F, -0.5F, -13.0F, 1, 1, 3, 0.0F); // gunBarrelCannonLft
        
        this.body.addChild(this.gunBarrelJoint);
        this.body.addChild(this.hornLft);
        this.body.addChild(this.hornRt);
        this.body.addChild(this.sideHornLft);
        this.body.addChild(this.sideHornRt);
        this.body.addChild(this.leg[0][0][0]);
        this.body.addChild(this.leg[1][0][0]);
        this.body.addChild(this.leg[2][0][0]);
        this.body.addChild(this.leg[3][0][0]);
        this.body.addChild(this.wing[0][0]);
        this.body.addChild(this.wing[1][0]);
        this.body.addChild(this.wing[2][0]);
        this.body.addChild(this.wing[3][0]);

        this.gunBarrelJoint.addChild(this.gunBarrel);
        this.gunBarrel.addChild(this.gunBarrelEdges);
        this.gunBarrel.addChild(this.gunBarrelEnd);
        
        this.hornLft.addChild(this.hornLftMid);
        this.hornLftMid.addChild(this.hornLftEnd);
        this.hornLftMid.addChild(this.hornLftEndTip);
        this.hornRt.addChild(this.hornRtMid);
        this.hornRtMid.addChild(this.hornRtEnd);
        this.hornRtMid.addChild(this.hornRtEndTip);

        this.sideHornLft.addChild(this.sideHornLftEnd);
        this.sideHornRt.addChild(this.sideHornRtEnd);

        this.leg[0][0][0].addChild(this.leg[0][0][1]);
        this.leg[1][0][0].addChild(this.leg[1][0][1]);
        this.leg[2][0][0].addChild(this.leg[2][0][1]);
        this.leg[3][0][0].addChild(this.leg[3][0][1]);
        
        for(int i = 0; i < leg.length; i++)
        {
        	for(int j = 1; j < leg[i].length; j++)
        	{
    	        this.leg[i][j - 1][1].addChild(this.leg[i][j][0]);
    	        this.leg[i][j][0].addChild(this.leg[i][j][1]);	
        	}
        }
        
        for(int i = 0; i < wing.length; i++)
        {
        	this.wing[i][0].addChild(this.wing[i][1]);
        }

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

		animateBody((EntityVegnagunDustox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateWings((EntityVegnagunDustox)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		bodyInfo.resetNewAngles();
		bodyInfo.resetNewPnt();

		for(int i = 0; i < wingInfo.length; i++)
		{
			wingInfo[i][0].resetNewAngles();
			wingInfo[i][1].resetNewAngles();
		}
		
		for(int i = 0; i < legInfo.length; i++)
		{
			for(int j = 0; j < legInfo[i].length; j++)
			{
				legInfo[i][j][0].resetNewAngles();
				legInfo[i][j][1].resetNewAngles();
			}
		}
	}

	public void animateBody(EntityVegnagunDustox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimate(body, bodyInfo, yawHeadOffsetDifference, pitchRotation);
		bodyInfo.setNewRotatesWithVector(PartInfo.rotatesToVector(body));

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockBodyFloat();

		float idleAmplitudeX = 1.5F;
		float idleAmplitudeY = 1.5F;
		float idleAmplitudeZ = 2.0F;

		float pointChangeX = 0;
		float pointChangeY = 0;
		float pointChangeZ = 0;

		pointChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX;
		pointChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * 2 * PI) * idleAmplitudeY;
		pointChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI) * idleAmplitudeZ;

		bodyInfo.setNewPnt(new Vector3f(bodyInfo.getNewPnt().getX() + pointChangeX,
				bodyInfo.getNewPnt().getY() + pointChangeY,
				bodyInfo.getNewPnt().getZ() + pointChangeZ));
		
		/*
		 * Body tilt code
		 */
		float angleAmplitudeX = (float)Math.toRadians(5);
		float angleAmplitudeY = (float)Math.toRadians(5);
		float angleAmplitudeZ = (float)Math.toRadians(5);

		float angleChangeX = 0;
		float angleChangeY = 0;
		float angleChangeZ = 0;

		angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI + PI/2) * angleAmplitudeX;
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * 2 * PI + PI/2) * angleAmplitudeY;
		angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI + PI/2) * angleAmplitudeZ;

		bodyInfo.setNewRotateX(bodyInfo.getNewRotateX() + angleChangeX);
		bodyInfo.setNewRotateY(bodyInfo.getNewRotateY() + angleChangeY);
		bodyInfo.setNewRotateZ(bodyInfo.getNewRotateZ() + angleChangeZ);

		/*
		 * Legs animation coding
		 */
		for(int i = 0; i < leg.length; i++)
		{
			for(int j = 0; j < leg[i].length; j++)
			{
			currentIdleAnimationClock = entity.getIdleAnimationClockLegs(i, j);
			animateLegSway(currentIdleAnimationClock, legInfo[i][j][1]);
			}
		}
	}
	
	public void animateLegSway(IdleAnimationClock currentIdleAnimationClock, PartInfo legInfo)
	{
		float legsAmplitudeX = 0.15F;
		float legsAmplitudeY = 0.15F;
		float legsAmplitudeZ = 0.15F;

		float legsAngleChangeX = 0;
		float legsAngleChangeY = 0;
		float legsAngleChangeZ = 0;
		
		legsAngleChangeX += legInfo.getNewRotateX();
		legsAngleChangeY += legInfo.getNewRotateY();
		legsAngleChangeZ += legInfo.getNewRotateZ();

		legsAngleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI) * legsAmplitudeX;
		legsAngleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * 2 * PI) * legsAmplitudeY;
		legsAngleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * legsAmplitudeZ;

		legInfo.setNewRotatesWithVector(new Vector3f(legsAngleChangeX, legsAngleChangeY, legsAngleChangeZ));
	}

	public void animateWings(EntityVegnagunDustox entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockWings();

		float motionAmplitudeY = 0.5F;

		float amplitudeY = 0.6F;

		float angleChangeX = 0;
		float angleChangeY = 0;
		float angleChangeZ = 0;

		angleChangeX += 0;
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * 2 * PI + PI) * amplitudeY;
		angleChangeZ += 0;

		wingInfo[0][1].setNewRotatesWithVector(new Vector3f(wingInfo[0][1].getNewRotates().getX() + angleChangeX,
				wingInfo[0][1].getNewRotates().getY() + angleChangeY,
				wingInfo[0][1].getNewRotates().getZ() + angleChangeZ));

		wingInfo[1][1].setNewRotatesWithVector(new Vector3f(wingInfo[1][1].getNewRotates().getX() + angleChangeX,
				wingInfo[1][1].getNewRotates().getY() + angleChangeY,
				wingInfo[1][1].getNewRotates().getZ() + angleChangeZ));

		angleChangeY = angleChangeY * -1;

		wingInfo[2][1].setNewRotatesWithVector(new Vector3f(wingInfo[2][1].getNewRotates().getX() + angleChangeX,
				wingInfo[2][1].getNewRotates().getY() + angleChangeY,
				wingInfo[2][1].getNewRotates().getZ() + angleChangeZ));

		wingInfo[3][1].setNewRotatesWithVector(new Vector3f(wingInfo[3][1].getNewRotates().getX() + angleChangeX,
				wingInfo[3][1].getNewRotates().getY() + angleChangeY,
				wingInfo[3][1].getNewRotates().getZ() + angleChangeZ));
	}
	
	public void deployAnimations()
	{
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.move(body, bodyInfo.getNewPnt());

		for(int i = 0; i < leg.length; i++)
		{
			for(int j = 0; j < leg[i].length; j++)
			{
				this.animationDeployer.rotate(leg[i][j][0], legInfo[i][j][0].getNewRotates());
				this.animationDeployer.rotate(leg[i][j][1], legInfo[i][j][1].getNewRotates());
			}
		}

		for(int i = 0; i < wing.length; i++)
		{
			this.animationDeployer.rotate(wing[i][0], wingInfo[i][0].getNewRotates());
			this.animationDeployer.rotate(wing[i][1], wingInfo[i][1].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}