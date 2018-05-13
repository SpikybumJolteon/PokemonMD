package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.JointAnimation;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityZealotPawniard;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZealotPawniard extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer spikeUpRt;
	public ModelRenderer spikeUpLft;
	public ModelRenderer spikeBotRt;
	public ModelRenderer spikeBotLft;

	public ModelRenderer legRt;
	public ModelRenderer legLft;

	public ModelRenderer armLftJoint;
	public ModelRenderer armLft;
	public ModelRenderer armLftForeJoint;
	public ModelRenderer armLftFore;
	PartInfo armLftJointInfo;
	PartInfo armLftInfo;
	PartInfo armLftForeJointInfo;
	PartInfo armLftForeInfo;

	public ModelRenderer armRtJoint;
	public ModelRenderer armRt;
	public ModelRenderer armRtForeJoint;
	public ModelRenderer armRtFore;
	PartInfo armRtJointInfo;
	PartInfo armRtInfo;
	PartInfo armRtForeJointInfo;
	PartInfo armRtForeInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer headPlate;
	public ModelRenderer headBladeHorz;
	public ModelRenderer headBladeVert;

	public ModelZealotPawniard() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.body = new ModelRenderer(this, 56, 26);
		this.body.setRotationPoint(0.0F, 21.0F, 0.0F);
		this.body.addBox(-1.0F, -3.0F, -1.0F, 2, 4, 2, 0.0F);
		bodyInfo = new PartInfo(body);

		this.spikeUpRt = new ModelRenderer(this, 49, 9); // spikeUpRtHorz
		this.spikeUpRt.setRotationPoint(-0.7F, -1.0F, -1.0F);
		this.spikeUpRt.addBox(-0.7F, -1.0F, -1.5F, 1, 1, 2, 0.0F);
		this.spikeUpRt.setTextureOffset(50, 13).addBox(-1.0F, -0.3F, -1.0F, 1, 1, 2, 0.0F); // spikeUpRtVert
		this.spikeUpLft = new ModelRenderer(this, 49, 18); // spikeUpLftHorz
		this.spikeUpLft.setRotationPoint(0.7F, -1.0F, -1.0F);
		this.spikeUpLft.addBox(-0.8F, -1.0F, -1.5F, 1, 1, 2, 0.0F);
		this.spikeUpLft.setTextureOffset(50, 22).addBox(-1.0F, -0.3F, -1.0F, 1, 1, 2, 0.0F); // spikeUpLftVert
		this.spikeBotRt = new ModelRenderer(this, 57, 9); // spikeBotRtHorz
		this.spikeBotRt.setRotationPoint(-0.7F, -0.2F, -1.0F);
		this.spikeBotRt.addBox(-0.2F, -0.8F, -1.5F, 1, 1, 2, 0.0F);
		this.spikeBotRt.setTextureOffset(58, 13).addBox(0.0F, -0.1F, -1.0F, 1, 1, 2, 0.0F); // spikeBotRtVert
		this.spikeBotLft = new ModelRenderer(this, 57, 18); // spikeBotLftHorz
		this.spikeBotLft.setRotationPoint(0.7F, -0.2F, -1.0F);
		this.spikeBotLft.addBox(-0.3F, -0.8F, -1.5F, 1, 1, 2, 0.0F);
		this.spikeBotLft.setTextureOffset(58, 22).addBox(0.0F, 0.0F, -1.0F, 1, 1, 2, 0.0F); // spikeBotLftVert

		this.legRt = new ModelRenderer(this, 43, 28);
		this.legRt.setRotationPoint(-0.6F, 0.5F, 0.0F);
		this.legRt.addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);
		this.legLft = new ModelRenderer(this, 48, 28);
		this.legLft.setRotationPoint(0.6F, 0.5F, 0.0F);
		this.legLft.addBox(-0.5F, -0.5F, -0.5F, 1, 3, 1, 0.0F);

		this.armLftJoint = new ModelRenderer(this, 44, 2);
		this.armLftJoint.setRotationPoint(0.8F, -1.3F, 0.0F);
		this.armLftJoint.addBox(-0.3F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftJoint, 0.0F, -0.0F, 0.5235987755982988F);
		armLftJointInfo = new PartInfo(armLftJoint);
		this.armLft = new ModelRenderer(this, 44, 2);
		this.armLft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLft.addBox(-0.3F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		armLftInfo = new PartInfo(armLft);
		this.armLftForeJoint = new ModelRenderer(this, 51, 2);
		this.armLftForeJoint.setRotationPoint(1.5F, 0.0F, 0.0F);
		this.armLftForeJoint.addBox(-0.3F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armLftForeJoint, 0.0F, 1.0471975511965976F, 0.0F);
		armLftForeJointInfo = new PartInfo(armLftForeJoint);
		this.armLftFore = new ModelRenderer(this, 51, 2);
		this.armLftFore.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLftFore.addBox(-0.3F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.armLftFore.setTextureOffset(58, 0).addBox(1.0F, -0.2F, 0.0F, 2, 1, 1, 0.0F); // armLftForeBladeVert
		this.armLftFore.setTextureOffset(58, 3).addBox(1.0F, 0.0F, -0.2F, 2, 1, 1, 0.0F); // armLftForeBladeHorz
		armLftForeInfo = new PartInfo(armLftFore);

		this.armRtJoint = new ModelRenderer(this, 37, 0);
		this.armRtJoint.setRotationPoint(-0.8F, -1.3F, 0.0F);
		this.armRtJoint.addBox(-1.8F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtJoint, 0.0F, 0.0F, -0.5235987755982988F);
		armRtJointInfo = new PartInfo(armRtJoint);
		this.armRt = new ModelRenderer(this, 37, 0);
		this.armRt.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRt.addBox(-1.8F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		armRtInfo = new PartInfo(armRt);
		this.armRtForeJoint = new ModelRenderer(this, 30, 0);
		this.armRtForeJoint.setRotationPoint(-1.5F, 0.0F, 0.0F);
		this.armRtForeJoint.addBox(-1.8F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
		this.setRotateAngle(armRtForeJoint, 0.0F, -1.0471975511965976F, 0.0F);
		armRtForeJointInfo = new PartInfo(armRtForeJoint);
		this.armRtFore = new ModelRenderer(this, 30, 0);
		this.armRtFore.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRtFore.addBox(-1.8F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.armRtFore.setTextureOffset(23, 0).addBox(-3.0F, -0.2F, 0.0F, 2, 1, 1, 0.0F); // armRtForeBladeVert
		this.armRtFore.setTextureOffset(23, 3).addBox(-2.9F, 0.0F, -0.2F, 2, 1, 1, 0.0F); // armRtForeBladeHorz
		armRtForeInfo = new PartInfo(armRtFore);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -2.5F, 0.0F);
		this.headJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-1.5F, -1.5F, -1.5F, 3, 2, 3, 0.0F);
		this.head.setTextureOffset(2, 6).addBox(-2.0F, -3.0F, -2.0F, 4, 2, 1, 0.0F); // headHelmetFront
		this.head.setTextureOffset(0, 10).addBox(-2.0F, -3.0F, -1.0F, 4, 3, 3, 0.0F); // headHelmetMain
		this.head.setTextureOffset(1, 17).addBox(-1.5F, -3.5F, -1.5F, 3, 1, 3, 0.0F); // headHelmetMidTop
		this.head.setTextureOffset(3, 22).addBox(-1.0F, -4.0F, -1.0F, 2, 1, 2, 0.0F); // headHelmetTop
		headInfo = new PartInfo(head);

		this.headPlate = new ModelRenderer(this, 15, 6);
		this.headPlate.setRotationPoint(0.0F, -2.0F, -2.0F);
		this.headPlate.addBox(-1.5F, -1.5F, -0.5F, 2, 2, 1, 0.0F);
		this.setRotateAngle(headPlate, 0.0F, -0.0F, 0.7853981633974483F);
		this.headPlate.setTextureOffset(14, 0).addBox(-3.0F, -3.0F, -0.3F, 3, 3, 1, 0.0F); // headPlateUpper
		this.headBladeHorz = new ModelRenderer(this, 15, 10);
		this.headBladeHorz.setRotationPoint(0.0F, -2.3F, -2.0F);
		this.headBladeHorz.addBox(-0.8F, -0.6F, -2.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(headBladeHorz, -0.6981317007977318F, -0.0F, 0.0F);
		this.headBladeVert = new ModelRenderer(this, 15, 15);
		this.headBladeVert.setRotationPoint(0.0F, -2.3F, -2.0F);
		this.headBladeVert.addBox(0.0F, -1.3F, -3.3F, 1, 2, 3, 0.0F);
		this.setRotateAngle(headBladeVert, -0.5235987755982988F, -0.0F, 0.0F);

		this.body.addChild(this.armLftJoint);
		this.armLftJoint.addChild(this.armLft);
		this.armLftForeJoint.addChild(this.armLftFore);
		this.armLft.addChild(this.armLftForeJoint);
		this.body.addChild(this.armRtJoint);
		this.armRtJoint.addChild(this.armRt);
		this.armRt.addChild(this.armRtForeJoint);
		this.armRtForeJoint.addChild(this.armRtFore);

		this.body.addChild(this.legLft);
		this.body.addChild(this.legRt);

		this.body.addChild(this.spikeBotLft);
		this.body.addChild(this.spikeBotRt);
		this.body.addChild(this.spikeUpLft);
		this.body.addChild(this.spikeUpRt);
		this.head.addChild(this.headBladeHorz);
		this.head.addChild(this.headBladeVert);

		this.body.addChild(this.headJoint);
		this.headJoint.addChild(this.head);
		this.head.addChild(this.headPlate);

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

		animateHead((EntityZealotPawniard)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateArms((EntityZealotPawniard)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateLegs((EntityZealotPawniard)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		armRtJointInfo.resetNewAngles();
		armRtInfo.resetNewAngles();
		armRtForeJointInfo.resetNewAngles();
		armRtForeInfo.resetNewAngles();

		armLftJointInfo.resetNewAngles();
		armLftInfo.resetNewAngles();
		armLftForeJointInfo.resetNewAngles();
		armLftForeInfo.resetNewAngles();
	}

	public void animateHead(EntityZealotPawniard entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.8F, 0.8F);
	}

	public void animateArms(EntityZealotPawniard entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockArms();

		float moveFrequencyY = 1.4F;
		float moveAmplitudeY = 0.3F;

		float angleChangeY = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyY, moveAmplitudeY);

		float idleAmplitudeZ = 0.15F;

		// + (float)Math.toRadians(45)
		float angleChangeZ = 0;

		angleChangeZ += MathHelper.sin(currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * 2 * PI + PI) * idleAmplitudeZ;

		armLftInfo.setNewRotateY(armLftInfo.getNewRotateY() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyY, moveAmplitudeY));
		armRtInfo.setNewRotateY(armRtInfo.getNewRotateY() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyY, moveAmplitudeY));

		armLftForeInfo.setNewRotateY(armLftForeInfo.getNewRotateY() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyY, moveAmplitudeY * 2.5F));
		armRtForeInfo.setNewRotateY(armRtForeInfo.getNewRotateY() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequencyY, moveAmplitudeY * 2.5F));

		armLftInfo.setNewRotateZ(armLftInfo.getNewRotateZ() + angleChangeZ);
		armRtInfo.setNewRotateZ(armRtInfo.getNewRotateZ() - angleChangeZ);

		armLftForeInfo.setNewRotateZ(armLftForeInfo.getNewRotateZ() + angleChangeZ * 2.5F);
		armRtForeInfo.setNewRotateZ(armRtForeInfo.getNewRotateZ() - angleChangeZ * 2.5F);
	}

	public void animateLegs(EntityZealotPawniard entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float frequency = 1.4F;
		float amplitude = 0.6F;

		this.legRt.rotateAngleX = PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
		this.legLft.rotateAngleX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(armLftJoint, armLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLft, armLftInfo.getNewRotates());
		this.animationDeployer.rotate(armLftForeJoint, armLftForeJointInfo.getNewRotates());
		this.animationDeployer.rotate(armLftFore, armLftForeInfo.getNewRotates());

		this.animationDeployer.rotate(armRtJoint, armRtJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRt, armRtInfo.getNewRotates());
		this.animationDeployer.rotate(armRtForeJoint, armRtForeJointInfo.getNewRotates());
		this.animationDeployer.rotate(armRtFore, armRtForeInfo.getNewRotates());

		this.animationDeployer.applyChanges();
	}
}