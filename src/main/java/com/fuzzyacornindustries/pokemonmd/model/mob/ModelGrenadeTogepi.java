package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityGrenadeTogepi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGrenadeTogepi extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

    public ModelRenderer egg;
	PartInfo eggInfo;
    
    public ModelRenderer legRt;
    public ModelRenderer legLft;
    
    public ModelRenderer armRt;
    public ModelRenderer armLft;
	PartInfo armRtInfo;
	PartInfo armLftInfo;
    
    public ModelRenderer headJoint;
    public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;
    
    public ModelRenderer headSpikeFnt;
    public ModelRenderer headSpikeFntLft;
    public ModelRenderer headSpikeFntRt;
    public ModelRenderer headSpikeBckRt;
    public ModelRenderer headSpikeBckLft;
	PartInfo headSpikeFntInfo;
	PartInfo headSpikeFntLftInfo;
	PartInfo headSpikeFntRtInfo;
	PartInfo headSpikeBckRtInfo;
	PartInfo headSpikeBckLftInfo;

    public ModelGrenadeTogepi() 
    {
        this.textureWidth = 64;
        this.textureHeight = 32;

		int jointNumber = 0;
		int partNumber = 1;

        this.egg = new ModelRenderer(this, 40, 22);
        this.egg.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.egg.addBox(-3.0F, -2.0F, -3.0F, 6, 4, 6, 0.0F);
        this.egg.setTextureOffset(44, 16).addBox(-2.0F, 2.0F, -2.0F, 4, 1, 4, 0.0F); // eggBot
        eggInfo = new PartInfo(egg);

        this.legRt = new ModelRenderer(this, 31, 28);
        this.legRt.setRotationPoint(-0.9F, 3.0F, 0.0F);
        this.legRt.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.legLft = new ModelRenderer(this, 22, 28);
        this.legLft.setRotationPoint(0.9F, 3.0F, -0.1F);
        this.legLft.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);

        this.armRt = new ModelRenderer(this, 30, 25);
        this.armRt.setRotationPoint(-2.5F, 0.0F, -1.0F);
        this.armRt.addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        armRtInfo = new PartInfo(armRt);
        this.armLft = new ModelRenderer(this, 23, 25);
        this.armLft.setRotationPoint(2.5F, 0.0F, -1.0F);
        this.armLft.addBox(0.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        armLftInfo = new PartInfo(armLft);

        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.headJoint.addBox(-2.0F, -2.5F, -2.0F, 0, 0, 0, 0.0F);
        headJointInfo = new PartInfo(headJoint);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-2.0F, -2.5F, -2.0F, 4, 3, 4, 0.0F);
        headInfo = new PartInfo(head);

        this.headSpikeFnt = new ModelRenderer(this, 5, 11);
        this.headSpikeFnt.setRotationPoint(0.0F, -2.5F, -1.5F);
        this.headSpikeFnt.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(headSpikeFnt, 0.5235987755982988F, -0.0F, 0.0F);
        this.headSpikeFnt.setTextureOffset(6, 8).addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F); // headSpikeFntTip
        headSpikeFntInfo = new PartInfo(headSpikeFnt);
        this.headSpikeFntLft = new ModelRenderer(this, 0, 18);
        this.headSpikeFntLft.setRotationPoint(1.5F, -2.5F, -0.5F);
        this.headSpikeFntLft.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(headSpikeFntLft, 0.6981317007977318F, -0.0F, 0.6108652381980153F);
        this.headSpikeFntLft.setTextureOffset(1, 15).addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F); // headSpikeFntLftTip
        headSpikeFntLftInfo = new PartInfo(headSpikeFntLft);
        this.headSpikeFntRt = new ModelRenderer(this, 7, 18);
        this.headSpikeFntRt.setRotationPoint(-1.5F, -2.5F, -0.5F);
        this.headSpikeFntRt.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(headSpikeFntRt, 0.6981317007977318F, -0.0F, -0.6108652381980153F);
        this.headSpikeFntRt.setTextureOffset(8, 15).addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F); // headSpikeFntRtTip
        headSpikeFntRtInfo = new PartInfo(headSpikeFntRt);
        this.headSpikeBckRt = new ModelRenderer(this, 7, 26);
        this.headSpikeBckRt.setRotationPoint(-1.0F, -2.5F, 1.5F);
        this.headSpikeBckRt.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(headSpikeBckRt, -0.6108652381980153F, -0.0F, -0.5585053606381855F);
        this.headSpikeBckRt.setTextureOffset(8, 23).addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F); // headSpikeBckRtTip
        headSpikeBckRtInfo = new PartInfo(headSpikeBckRt);
        this.headSpikeBckLft = new ModelRenderer(this, 0, 26);
        this.headSpikeBckLft.setRotationPoint(1.0F, -2.5F, 1.5F);
        this.headSpikeBckLft.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(headSpikeBckLft, -0.6108652381980153F, -0.0F, 0.5585053606381855F);
        this.headSpikeBckLft.setTextureOffset(1, 23).addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F); // headSpikeBckLftTip
        headSpikeBckLftInfo = new PartInfo(headSpikeBckLft);

        this.egg.addChild(this.headJoint);
        this.egg.addChild(this.armLft);
        this.egg.addChild(this.armRt);
        this.egg.addChild(this.legLft);
        this.egg.addChild(this.legRt);
        
        this.headJoint.addChild(this.head);
        
        this.head.addChild(this.headSpikeBckLft);
        this.head.addChild(this.headSpikeBckRt);
        this.head.addChild(this.headSpikeFnt);
        this.head.addChild(this.headSpikeFntLft);
        this.head.addChild(this.headSpikeFntRt);

		animationDeployer = new AnimationDeployer(this);
    }

    @Override
    public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
    {
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		
        this.egg.render(modelSize);
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

		animateHead((EntityGrenadeTogepi)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateArms((EntityGrenadeTogepi)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityGrenadeTogepi)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		eggInfo.resetNewAngles();
		
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();
		
		armRtInfo.resetNewAngles();
		armLftInfo.resetNewAngles();
	}

	public void animateHead(EntityGrenadeTogepi entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.6F, 0.6F);
	}

	public void animateArms(EntityGrenadeTogepi entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockArms();

		float moveFrequencyY = 2.0F;
		float moveAmplitudeY = 0.45F;

		float angleChangeY = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyY, moveAmplitudeY);

		float idleAmplitudeZ = 0.20F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = 0;

		angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI + PI) * idleAmplitudeZ;

		armRtInfo.setNewRotateY(armRtInfo.getNewRotateY() + angleChangeY);
		armRtInfo.setNewRotateZ(armRtInfo.getNewRotateZ() - angleChangeZ);
		armLftInfo.setNewRotateY(armLftInfo.getNewRotateY() + angleChangeY);
		armLftInfo.setNewRotateZ(armLftInfo.getNewRotateZ() + angleChangeZ);
	}

	public void animateLegs(EntityGrenadeTogepi entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float frequency = 2.0F;
		float amplitude = 0.6F;

		this.legRt.rotateAngleX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
		this.legLft.rotateAngleX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(egg, eggInfo.getNewRotates());
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());

		this.animationDeployer.applyChanges();
	}
}