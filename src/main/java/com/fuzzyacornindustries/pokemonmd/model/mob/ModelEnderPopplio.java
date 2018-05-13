package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityEnderPopplio;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderPopplio extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

    public ModelRenderer bodyBotJoint;
    public ModelRenderer bodyBot;
    public ModelRenderer bodyTopJoint;
    public ModelRenderer bodyTop;
    public ModelRenderer neckJoint;
    public ModelRenderer neck;
	PartInfo bodyBotJointInfo;
	PartInfo bodyBotInfo;
	PartInfo bodyTopJointInfo;
	PartInfo bodyTopInfo;
	PartInfo neckJointInfo;
	PartInfo neckInfo;
    
    public ModelRenderer footFinLft;
    public ModelRenderer footFinRt;
	PartInfo footFinLftInfo;
	PartInfo footFinRtInfo;
    
    public ModelRenderer armLftJoint;
    public ModelRenderer armLft;
    public ModelRenderer armLftForearmJoint;
    public ModelRenderer armLftForearm;
	PartInfo armLftJointInfo;
	PartInfo armLftInfo;
	PartInfo armLftForearmJointInfo;
	PartInfo armLftForearmInfo;
    
    public ModelRenderer armRtJoint;
    public ModelRenderer armRt;
    public ModelRenderer armRtForearmJoint;
    public ModelRenderer armRtForearm;
	PartInfo armRtJointInfo;
	PartInfo armRtInfo;
	PartInfo armRtForearmJointInfo;
	PartInfo armRtForearmInfo;
    
    public ModelRenderer headJoint;
    public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;
    
    public ModelRenderer muzzle;
    public ModelRenderer nose;
	PartInfo noseInfo;
    
    public ModelRenderer earLft;
    public ModelRenderer earRt;
	PartInfo earLftInfo;
	PartInfo earRtInfo;

    public ModelEnderPopplio() 
    {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.bodyBotJoint = new ModelRenderer(this, 0, 0);
        this.bodyBotJoint.setRotationPoint(0.0F, 23.5F, -1.0F);
        this.bodyBotJoint.addBox(-1.0F, -4.0F, -0.5F, 0, 0, 0, 0.0F);
        bodyBotJointInfo = new PartInfo(bodyBotJoint);
        this.bodyBot = new ModelRenderer(this, 54, 24);
        this.bodyBot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyBot.addBox(-1.0F, -4.0F, -0.5F, 2, 4, 2, 0.0F);
        bodyBotInfo = new PartInfo(bodyBot);
        this.bodyTopJoint = new ModelRenderer(this, 0, 0);
        this.bodyTopJoint.setRotationPoint(0.0F, -3.0F, 0.5F);
        this.bodyTopJoint.addBox(-1.5F, -4.0F, -1.5F, 0, 0, 0, 0.0F);
        bodyTopJointInfo = new PartInfo(bodyTopJoint);
        this.bodyTop = new ModelRenderer(this, 52, 16);
        this.bodyTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyTop.addBox(-1.5F, -4.0F, -1.5F, 3, 4, 3, 0.0F);
        bodyTopInfo = new PartInfo(bodyTop);
        this.neckJoint = new ModelRenderer(this, 0, 0);
        this.neckJoint.setRotationPoint(0.0F, -3.8F, 0.0F);
        this.neckJoint.addBox(-1.0F, -1.5F, -1.0F, 0, 0, 0, 0.0F);
        neckJointInfo = new PartInfo(neckJoint);
        this.neck = new ModelRenderer(this, 54, 11);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-1.0F, -1.5F, -1.0F, 2, 2, 2, 0.0F);
		this.neck.setTextureOffset(31, 24).addBox(-3.5F, 0.0F, -3.5F, 7, 1, 7, 0.0F); // mane
		neckInfo = new PartInfo(neck);

        this.footFinLft = new ModelRenderer(this, 13, 27);
        this.footFinLft.setRotationPoint(1.0F, -0.5F, 0.5F);
        this.footFinLft.addBox(-1.0F, 0.0F, -0.5F, 2, 1, 4, 0.0F);
        this.setRotateAngle(footFinLft, 0.0F, 1.5707963267948966F, 0.0F);
        footFinLftInfo = new PartInfo(footFinLft);
        this.footFinRt = new ModelRenderer(this, 0, 27);
        this.footFinRt.setRotationPoint(-1.0F, -0.5F, 0.5F);
        this.footFinRt.addBox(-1.0F, 0.0F, -0.5F, 2, 1, 4, 0.0F);
        this.setRotateAngle(footFinRt, 0.0F, -1.5707963267948966F, 0.0F);
        footFinRtInfo = new PartInfo(footFinRt);

        this.armLftJoint = new ModelRenderer(this, 0, 0);
        this.armLftJoint.setRotationPoint(1.5F, -3.0F, 0.0F);
        this.armLftJoint.addBox(-1.0F, -0.5F, -3.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armLftJoint, 0.6981317007977318F, -1.1344640137963142F, 0.0F);
        armLftJointInfo = new PartInfo(armLftJoint);
        this.armLft = new ModelRenderer(this, 13, 11);
        this.armLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armLft.addBox(-1.0F, -0.5F, -3.5F, 2, 1, 4, 0.0F);
        armLftInfo = new PartInfo(armLft);
        this.armLftForearmJoint = new ModelRenderer(this, 0, 0);
        this.armLftForearmJoint.setRotationPoint(0.0F, 0.0F, -3.3F);
        this.armLftForearmJoint.addBox(-1.0F, -0.5F, -3.7F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armLftForearmJoint, -0.5235987755982988F, 0.0F, 0.0F);
        armLftForearmJointInfo = new PartInfo(armLftForearmJoint);
        this.armLftForearm = new ModelRenderer(this, 13, 17);
        this.armLftForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armLftForearm.addBox(-1.0F, -0.5F, -3.7F, 2, 1, 4, 0.0F);
        armLftForearmInfo = new PartInfo(armLftForearm);

        this.armRtJoint = new ModelRenderer(this, 0, 0);
        this.armRtJoint.setRotationPoint(-1.5F, -3.0F, 0.0F);
        this.armRtJoint.addBox(-1.0F, -0.5F, -3.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armRtJoint, 0.6981317007977318F, 1.1344640137963142F, 0.0F);
        armRtJointInfo = new PartInfo(armRtJoint);
        this.armRt = new ModelRenderer(this, 0, 11);
        this.armRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armRt.addBox(-1.0F, -0.5F, -3.5F, 2, 1, 4, 0.0F);
        armRtInfo = new PartInfo(armRt);
        this.armRtForearmJoint = new ModelRenderer(this, 0, 0);
        this.armRtForearmJoint.setRotationPoint(0.0F, 0.0F, -3.3F);
        this.armRtForearmJoint.addBox(-1.0F, -0.5F, -3.7F, 0, 0, 0, 0.0F);
        this.setRotateAngle(armRtForearmJoint, -0.5235987755982988F, 0.0F, 0.0F);
        armRtForearmJointInfo = new PartInfo(armRtForearmJoint);
        this.armRtForearm = new ModelRenderer(this, 0, 17);
        this.armRtForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armRtForearm.addBox(-1.0F, -0.5F, -3.7F, 2, 1, 4, 0.0F);
        armRtForearmInfo = new PartInfo(armRtForearm);

        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.headJoint.addBox(-2.5F, -5.0F, -3.0F, 0, 0, 0, 0.0F);
        headJointInfo = new PartInfo(headJoint);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-2.5F, -5.0F, -3.0F, 5, 5, 5, 0.0F);
        headInfo = new PartInfo(head);

        this.muzzle = new ModelRenderer(this, 27, 8);
        this.muzzle.setRotationPoint(0.0F, -1.5F, -2.5F);
        this.muzzle.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
		this.muzzle.setTextureOffset(28, 13).addBox(-0.5F, -0.5F, -3.5F, 1, 1, 2, 0.0F); // muzzleEnd
        this.nose = new ModelRenderer(this, 27, 17);
        this.nose.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.nose.addBox(-1.0F, -1.0F, -1.8F, 2, 2, 2, 0.0F);
        noseInfo = new PartInfo(nose);
 
        this.earLft = new ModelRenderer(this, 21, 0);
        this.earLft.setRotationPoint(2.0F, -2.5F, -0.5F);
        this.earLft.addBox(-0.5F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(earLft, 0.0F, 0.0F, 0.6981317007977318F);
        earLftInfo = new PartInfo(earLft);
        this.earRt = new ModelRenderer(this, 21, 4);
        this.earRt.setRotationPoint(-2.0F, -2.5F, -0.5F);
        this.earRt.addBox(-3.5F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(earRt, 0.0F, 0.0F, -0.6981317007977318F);
        earRtInfo = new PartInfo(earRt);

        this.bodyBotJoint.addChild(this.bodyBot);
        this.bodyBotJoint.addChild(this.footFinLft);
        this.bodyBotJoint.addChild(this.footFinRt);

        this.bodyBot.addChild(this.bodyTopJoint);
        this.bodyTopJoint.addChild(this.bodyTop);

        this.bodyTop.addChild(this.armLftJoint);
        this.bodyTop.addChild(this.armRtJoint);
        this.bodyTop.addChild(this.neckJoint);

        this.neckJoint.addChild(this.neck);

        this.neck.addChild(this.headJoint);

        this.headJoint.addChild(this.head);
        this.head.addChild(this.earLft);
        this.head.addChild(this.earRt);
        this.head.addChild(this.muzzle);

        this.muzzle.addChild(this.nose);

        this.armLftJoint.addChild(this.armLft);
        this.armLft.addChild(this.armLftForearmJoint);
        this.armLftForearmJoint.addChild(this.armLftForearm);

        this.armRtJoint.addChild(this.armRt);
        this.armRt.addChild(this.armRtForearmJoint);
        this.armRtForearmJoint.addChild(this.armRtForearm);

		animationDeployer = new AnimationDeployer(this);
    }

    @Override
    public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
    { 
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

        this.bodyBotJoint.render(modelSize);
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
		/*
		if(animationDeployer.getEntity().getAnimationID() == EntitySnowSorceressBraixen.actionIDSpell)
		{
			//idleDampener = animateSpell(animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		}
		 */	
		animateBody((EntityEnderPopplio)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener);
		animateHead((EntityEnderPopplio)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener);
		animateArms((EntityEnderPopplio)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		bodyBotJointInfo.resetNewAngles();
		bodyBotJointInfo.resetNewPnt();

		bodyBotInfo.resetNewAngles();
		bodyTopJointInfo.resetNewAngles();
		bodyTopInfo.resetNewAngles();
		neckJointInfo.resetNewAngles();
		neckInfo.resetNewAngles();
		
		footFinLftInfo.resetNewAngles();
		footFinRtInfo.resetNewAngles();

		armLftJointInfo.resetNewAngles();
		armLftInfo.resetNewAngles();
		armLftForearmJointInfo.resetNewAngles();
		armLftForearmInfo.resetNewAngles();
		
		armRtJointInfo.resetNewAngles();
		armRtInfo.resetNewAngles();
		armRtForearmJointInfo.resetNewAngles();
		armRtForearmInfo.resetNewAngles();
		
		noseInfo.resetNewAngles();
		earLftInfo.resetNewAngles();
		earRtInfo.resetNewAngles();
	}

	public void animateHead(EntityEnderPopplio entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.9F, 0.9F);
	}

	public void animateBody(EntityEnderPopplio entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener)
	{

	}

	public void animateArms(EntityEnderPopplio entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener)
	{

	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(bodyBotJoint, bodyBotJointInfo.getNewRotates());
		this.animationDeployer.move(bodyBotJoint, bodyBotJointInfo.getNewPnt());

		this.animationDeployer.rotate(bodyBot, bodyBotInfo.getNewRotates());
		this.animationDeployer.rotate(bodyTopJoint, bodyTopJointInfo.getNewRotates());
		this.animationDeployer.rotate(bodyTopJoint, bodyTopJointInfo.getNewRotates());
		this.animationDeployer.rotate(bodyTop, bodyTopInfo.getNewRotates());
		this.animationDeployer.rotate(neckJoint, neckJointInfo.getNewRotates());
		this.animationDeployer.rotate(neck, neckInfo.getNewRotates());

		this.animationDeployer.rotate(footFinLft, footFinLftInfo.getNewRotates());
		this.animationDeployer.rotate(footFinRt, footFinRtInfo.getNewRotates());

		this.animationDeployer.rotate(armLftJoint, armLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armLftForearmJoint, armLftForearmJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLftForearm, armLftForearmInfo.getNewRotates());		

		this.animationDeployer.rotate(armRtJoint, armRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());
		this.animationDeployer.rotate(armRtForearmJoint, armRtForearmJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRtForearm, armRtForearmInfo.getNewRotates());

		this.animationDeployer.rotate(nose, noseInfo.getNewRotates());

		this.animationDeployer.rotate(earLft, earLftInfo.getNewRotates());
		this.animationDeployer.rotate(earRt, earRtInfo.getNewRotates());
		
		this.animationDeployer.applyChanges();
	}
}