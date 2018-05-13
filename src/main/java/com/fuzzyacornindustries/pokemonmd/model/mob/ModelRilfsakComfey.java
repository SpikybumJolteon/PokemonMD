package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityRilfsakComfey;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRilfsakComfey extends ModelBase 
{
	public final float moveFrequency = 0.7F;
	
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer headLeafRt;
	public ModelRenderer headLeafMid;
	public ModelRenderer headLeafLft;
	PartInfo headLeafRtInfo;
	PartInfo headLeafMidInfo;
	PartInfo headLeafLftInfo;

	public ModelRenderer browLft;
	public ModelRenderer browRt;
	PartInfo browLftInfo;
	PartInfo browRtInfo;

    public ModelRenderer armRt;
    public ModelRenderer armLft;
	PartInfo armRtInfo;
	PartInfo armLftInfo;
    
	public ModelRenderer tail[] = new ModelRenderer[14];
	PartInfo tailInfo[] = new PartInfo[tail.length];

	public ModelRenderer tail3Rose1;
	public ModelRenderer tail3Rose2;

	public ModelRenderer tail4ThornLft;
	public ModelRenderer tail4ThornRt;

	public ModelRenderer tail5Rose1;
	public ModelRenderer tail5Rose2;

	public ModelRenderer tail6Rose1;
	public ModelRenderer tail6Rose2;

	public ModelRenderer tail7ThornLft;
	public ModelRenderer tail7ThornRt;

	public ModelRenderer tail8Rose1;
	public ModelRenderer tail8Rose2;

	public ModelRenderer tail9Rose1;
	public ModelRenderer tail9Rose2;

	public ModelRenderer tail10ThornLft;
	public ModelRenderer tail10ThornRt;

	public ModelRenderer tail11Rose1;
	public ModelRenderer tail11Rose2;

	public ModelRenderer tail12Rose1;
	public ModelRenderer tail12Rose2;

	public ModelRenderer tail13Rose1;
	public ModelRenderer tail13Rose2;

	public ModelRenderer tailTip1;
	public ModelRenderer tailTip2;
	public ModelRenderer tailTip3;

	public ModelRilfsakComfey() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, 11.0F, 0.0F);
		this.headJoint.addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		headInfo = new PartInfo(head);

		this.headLeafRt = new ModelRenderer(this, 0, 5);
		this.headLeafRt.setRotationPoint(-0.5F, -0.9F, -0.6F);
		this.headLeafRt.addBox(-1.0F, -2.5F, 0.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(headLeafRt, -0.5235987755982988F, 0.0F, -0.6981317007977318F);
		headLeafRtInfo = new PartInfo(headLeafRt);
		this.headLeafMid = new ModelRenderer(this, 7, 5);
		this.headLeafMid.setRotationPoint(0.0F, -0.9F, -0.9F);
		this.headLeafMid.addBox(-1.0F, -3.0F, 0.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(headLeafMid, -0.5235987755982988F, 0.0F, 0.0F);
		headLeafMidInfo = new PartInfo(headLeafMid);
		this.headLeafLft = new ModelRenderer(this, 14, 5);
		this.headLeafLft.setRotationPoint(0.5F, -0.9F, -0.6F);
		this.headLeafLft.addBox(-1.0F, -2.5F, 0.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(headLeafLft, -0.5235987755982988F, 0.0F, 0.6981317007977318F);
		headLeafLftInfo = new PartInfo(headLeafLft);

		this.browLft = new ModelRenderer(this, 11, 10);
		this.browLft.setRotationPoint(0.7F, -0.8F, -1.0F);
		this.browLft.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(browLft, 0.0F, 0.3490658503988659F, 0.4363323129985824F);
		browLftInfo = new PartInfo(browLft);
		this.browRt = new ModelRenderer(this, 3, 10);
		this.browRt.setRotationPoint(-0.7F, -0.8F, -1.0F);
		this.browRt.addBox(-1.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(browRt, 0.0F, -0.3490658503988659F, -0.4363323129985824F);
		browRtInfo = new PartInfo(browRt);

		this.armLft = new ModelRenderer(this, 16, 0);
        this.armLft.setRotationPoint(0.8F, 1.3F, -0.5F);
        this.armLft.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(armLft, 0.7853981633974483F, -0.5235987755982988F, 0.0F);
        armLftInfo = new PartInfo(armLft);
        this.armRt = new ModelRenderer(this, 9, 0);
        this.armRt.setRotationPoint(-0.8F, 1.3F, -0.5F);
        this.armRt.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(armRt, 0.7853981633974483F, 0.5235987755982988F, 0.0F);
        armRtInfo = new PartInfo(armRt);
        
		int tailNumber = 0;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 0); // tail1
		this.tail[tailNumber].setRotationPoint(0.0F, 0.8F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 2); // tail2
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 4); // tail3
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 6); // tail4
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 8); // tail5
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 10); // tail6
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 12); // tail7
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 14); // tail8
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 16); // tail9
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 18); // tail10
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 20); // tail11
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 22); // tail12
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 24); // tail13
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);
		tailNumber++;
		this.tail[tailNumber] = new ModelRenderer(this, 32, 26); // tail14
		this.tail[tailNumber].setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tail[tailNumber].addBox(-0.5F, -0.2F, -0.5F, 1, 1, 1, 0.0F);
		tailInfo[tailNumber] = new PartInfo(tail[tailNumber]);

		this.tail3Rose1 = new ModelRenderer(this, 27, 4);
		this.tail3Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail3Rose1.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail3Rose1, 0.0F, -0.5235987755982988F, 0.0F);
		this.tail3Rose2 = new ModelRenderer(this, 27, 4);
		this.tail3Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail3Rose2.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail3Rose2, 0.0F, -0.8726646259971648F, -0.5235987755982988F);

		this.tail4ThornLft = new ModelRenderer(this, 37, 6);
		this.tail4ThornLft.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail4ThornLft.addBox(0.5F, -0.4F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(tail4ThornLft, -0.5235987755982988F, 0.0F, 0.0F);
		this.tail4ThornRt = new ModelRenderer(this, 25, 6);
		this.tail4ThornRt.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail4ThornRt.addBox(-2.5F, -0.4F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(tail4ThornRt, -0.5235987755982988F, 0.0F, 0.0F);

		this.tail5Rose1 = new ModelRenderer(this, 27, 8);
		this.tail5Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail5Rose1.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail5Rose1, 0.0F, 0.5235987755982988F, 0.0F);
		this.tail5Rose2 = new ModelRenderer(this, 27, 8);
		this.tail5Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail5Rose2.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail5Rose2, 0.0F, 0.7853981633974483F, 0.5235987755982988F);

		this.tail6Rose1 = new ModelRenderer(this, 37, 10);
		this.tail6Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail6Rose1.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail6Rose1, 0.0F, 0.5235987755982988F, 0.0F);
		this.tail6Rose2 = new ModelRenderer(this, 37, 10);
		this.tail6Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail6Rose2.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail6Rose2, 0.0F, 0.8726646259971648F, 0.6108652381980153F);

		this.tail7ThornLft = new ModelRenderer(this, 37, 12);
		this.tail7ThornLft.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail7ThornLft.addBox(0.5F, -0.4F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(tail7ThornLft, -0.5235987755982988F, 0.0F, 0.0F);
		this.tail7ThornRt = new ModelRenderer(this, 25, 12);
		this.tail7ThornRt.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail7ThornRt.addBox(-2.5F, -0.4F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(tail7ThornRt, -0.5235987755982988F, 0.0F, 0.0F);

		this.tail8Rose1 = new ModelRenderer(this, 37, 14);
		this.tail8Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail8Rose1.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail8Rose1, 0.0F, -0.5235987755982988F, 0.0F);
		this.tail8Rose2 = new ModelRenderer(this, 37, 14);
		this.tail8Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail8Rose2.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail8Rose2, 0.0F, -0.9599310885968813F, -0.6981317007977318F);

		this.tail9Rose1 = new ModelRenderer(this, 27, 16);
		this.tail9Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail9Rose1.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail9Rose1, 0.0F, 0.5235987755982988F, 0.0F);
		this.tail9Rose2 = new ModelRenderer(this, 27, 16);
		this.tail9Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail9Rose2.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail9Rose2, 0.0F, 0.7853981633974483F, -0.5235987755982988F);

		this.tail10ThornLft = new ModelRenderer(this, 37, 18);
		this.tail10ThornLft.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail10ThornLft.addBox(0.5F, -0.4F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(tail10ThornLft, -0.5235987755982988F, 0.0F, 0.0F);
		this.tail10ThornRt = new ModelRenderer(this, 25, 18);
		this.tail10ThornRt.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail10ThornRt.addBox(-2.5F, -0.4F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(tail10ThornRt, -0.5235987755982988F, 0.0F, 0.0F);

		this.tail11Rose1 = new ModelRenderer(this, 27, 20);
		this.tail11Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail11Rose1.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail11Rose1, 0.0F, -0.5235987755982988F, 0.0F);
		this.tail11Rose2 = new ModelRenderer(this, 27, 20);
		this.tail11Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail11Rose2.addBox(-1.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail11Rose2, 0.0F, -0.6981317007977318F, 0.4363323129985824F);

		this.tail12Rose1 = new ModelRenderer(this, 37, 22);
		this.tail12Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail12Rose1.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail12Rose1, 0.0F, -0.5235987755982988F, 0.0F);
		this.tail12Rose2 = new ModelRenderer(this, 37, 22);
		this.tail12Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail12Rose2.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail12Rose2, 0.0F, -0.6981317007977318F, -0.8726646259971648F);

		this.tail13Rose1 = new ModelRenderer(this, 37, 24);
		this.tail13Rose1.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail13Rose1.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail13Rose1, 0.0F, 0.5235987755982988F, 0.0F);
		this.tail13Rose2 = new ModelRenderer(this, 37, 24);
		this.tail13Rose2.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.tail13Rose2.addBox(0.3F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.setRotateAngle(tail13Rose2, 0.0F, 0.6108652381980153F, 0.6981317007977318F);

		this.tailTip1 = new ModelRenderer(this, 37, 29);
		this.tailTip1.setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tailTip1.addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(tailTip1, 0.5235987755982988F, 1.0471975511965976F, 0.0F);
		this.tailTip2 = new ModelRenderer(this, 32, 29);
		this.tailTip2.setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tailTip2.addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(tailTip2, 0.5235987755982988F, -1.0471975511965976F, 0.0F);
		this.tailTip3 = new ModelRenderer(this, 27, 29);
		this.tailTip3.setRotationPoint(0.0F, 0.7F, 0.0F);
		this.tailTip3.addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(tailTip3, 0.5235987755982988F, 3.141592653589793F, 0.0F);

		this.headJoint.addChild(this.head);
		this.headJoint.addChild(this.tail[0]);

		this.head.addChild(this.browLft);
		this.head.addChild(this.browRt);
		this.head.addChild(this.headLeafLft);
		this.head.addChild(this.headLeafMid);
		this.head.addChild(this.headLeafRt);
        this.head.addChild(this.armRt);
        this.head.addChild(this.armLft);

		for(int i = 0; i < tail.length - 1; i++)
		{
			this.tail[i].addChild(tail[i + 1]);
		}

		this.tail[2].addChild(this.tail3Rose1);
		this.tail[2].addChild(this.tail3Rose2);
		this.tail[3].addChild(this.tail4ThornLft);
		this.tail[3].addChild(this.tail4ThornRt);
		this.tail[4].addChild(this.tail5Rose1);
		this.tail[4].addChild(this.tail5Rose2);
		this.tail[5].addChild(this.tail6Rose1);
		this.tail[5].addChild(this.tail6Rose2);
		this.tail[6].addChild(this.tail7ThornLft);
		this.tail[6].addChild(this.tail7ThornRt);
		this.tail[7].addChild(this.tail8Rose1);
		this.tail[7].addChild(this.tail8Rose2);
		this.tail[8].addChild(this.tail9Rose1);
		this.tail[8].addChild(this.tail9Rose2);
		this.tail[9].addChild(this.tail10ThornLft);
		this.tail[9].addChild(this.tail10ThornRt);
		this.tail[10].addChild(this.tail11Rose1);
		this.tail[10].addChild(this.tail11Rose2);
		this.tail[11].addChild(this.tail12Rose1);
		this.tail[11].addChild(this.tail12Rose2);
		this.tail[12].addChild(this.tail13Rose1);
		this.tail[12].addChild(this.tail13Rose2);
		this.tail[13].addChild(this.tailTip1);
		this.tail[13].addChild(this.tailTip2);
		this.tail[13].addChild(this.tailTip3);

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{ 
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		this.headJoint.render(modelSize);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
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

		animateHead((EntityRilfsakComfey)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateTail((EntityRilfsakComfey)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		headJointInfo.resetNewPnt();

		headInfo.resetNewAngles();
		
		headLeafLftInfo.resetNewAngles();
		headLeafMidInfo.resetNewAngles();
		headLeafRtInfo.resetNewAngles();

		browLftInfo.resetNewAngles();
		browRtInfo.resetNewAngles();

		armLftInfo.resetNewAngles();
		armRtInfo.resetNewAngles();
		
		for(int i = 0; i < tail.length; i++)
		{
			tailInfo[i].resetNewAngles();
		}
	}

	public void animateHead(EntityRilfsakComfey entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnly(headInfo, yawHeadOffsetDifference, pitchRotation);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockLeaves();

		float moveAmplitudeZ = 0.07F;

		float moveAngleZ = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitudeZ);

		float idleAmplitudeZ = 0.12F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = moveAngleZ;

		angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI) * idleAmplitudeZ;

		browRtInfo.setNewRotateZ(browRtInfo.getNewRotateZ() - angleChangeZ);
		browLftInfo.setNewRotateZ(browLftInfo.getNewRotateZ() + angleChangeZ);

		headLeafLftInfo.setNewRotateZ(headLeafLftInfo.getNewRotateZ() + angleChangeZ * 2F);
		headLeafMidInfo.setNewRotateZ(headLeafMidInfo.getNewRotateZ() + angleChangeZ * 2F);
		headLeafRtInfo.setNewRotateZ(headLeafRtInfo.getNewRotateZ() + angleChangeZ * 2F);

		armRtInfo.setNewRotateX(armRtInfo.getNewRotateX() + angleChangeZ);
		armLftInfo.setNewRotateX(armLftInfo.getNewRotateX() + angleChangeZ);
		
		armRtInfo.setNewRotateY(armRtInfo.getNewRotateY() - angleChangeZ * 0.5F);
		armLftInfo.setNewRotateY(armLftInfo.getNewRotateY() + angleChangeZ * 0.5F);
	}

	public void animateTail(EntityRilfsakComfey entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		for(int i = 0; i < tail.length; i++)
		{
			IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail(i);

			float movementVelocity = horzVelocity * 2F;
			
			if(movementVelocity >= 1F)
				movementVelocity = 1F;
			
			float idleAmplitudeX = 0.12F * (1F - horzVelocity);
			float idleAmplitudeZ = 0.2F * (1F - horzVelocity);

			float moveAmplitudeX = 0.11F;
			
			float moveAngleX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved - PI/4F * (float)i, movementVelocity, moveFrequency, moveAmplitudeX) + movementVelocity * (float)Math.toRadians(5);

			// + (float)Math.toRadians(45)
			float angleChangeX = 0;
			float angleChangeZ = 0;

			angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX + moveAngleX;
			angleChangeZ += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2) * idleAmplitudeZ;

			tailInfo[i].setNewRotateX(tailInfo[i].getNewRotateX() + angleChangeX);
			tailInfo[i].setNewRotateZ(tailInfo[i].getNewRotateZ() + angleChangeZ);
		}
	}

	public void deployAnimations()
	{
		this.animationDeployer.move(headJoint, headJointInfo.getNewPnt());

		this.animationDeployer.rotate(head, headInfo.getNewRotates());
		
		this.animationDeployer.rotate(headLeafLft, headLeafLftInfo.getNewRotates());
		this.animationDeployer.rotate(headLeafMid, headLeafMidInfo.getNewRotates());
		this.animationDeployer.rotate(headLeafRt, headLeafRtInfo.getNewRotates());

		this.animationDeployer.rotate(browLft, browLftInfo.getNewRotates());
		this.animationDeployer.rotate(browRt, browRtInfo.getNewRotates());

		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());

		for(int i = 0; i < tail.length; i++)
		{
			this.animationDeployer.rotate(tail[i], tailInfo[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}