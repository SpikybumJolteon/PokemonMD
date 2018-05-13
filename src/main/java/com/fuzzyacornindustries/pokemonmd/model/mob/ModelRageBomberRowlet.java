package com.fuzzyacornindustries.pokemonmd.model.mob;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityRageBomberRowlet;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySnowSorceressBraixen;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRageBomberRowlet extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer body;
	PartInfo bodyInfo;

	public ModelRenderer talonLft;
	public ModelRenderer talonRt;
	PartInfo talonLftInfo;
	PartInfo talonRtInfo;

	public ModelRenderer tailFeather;
	public ModelRenderer chestLeafLft;
	public ModelRenderer chestLeafRt;
	PartInfo tailFeatherInfo;

	public ModelRenderer headJoint;
	public ModelRenderer head;
	PartInfo headJointInfo;
	PartInfo headInfo;

	public ModelRenderer beakTop;
	public ModelRenderer beakBot;
	PartInfo beakBotInfo;

	public ModelRenderer headLeaf;
	PartInfo headLeafInfo;

	public ModelRenderer wingLftJoint;
	public ModelRenderer wingLft[] = new ModelRenderer[3];
	PartInfo wingLftJointInfo;
	PartInfo wingLftInfo[] = new PartInfo[wingLft.length];

	public ModelRenderer wingRtJoint;
	public ModelRenderer wingRt[] = new ModelRenderer[3];
	PartInfo wingRtJointInfo;
	PartInfo wingRtInfo[] = new PartInfo[wingLft.length];

	public ModelRageBomberRowlet() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.body = new ModelRenderer(this, 44, 25);
		this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.body.addBox(-2.5F, -1.0F, -2.5F, 5, 2, 5, 0.0F);
		bodyInfo = new PartInfo(body);

		this.talonLft = new ModelRenderer(this, 56, 17);
		this.talonLft.setRotationPoint(1.0F, 1.0F, 0.0F);
		this.talonLft.addBox(-1.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
		this.talonLft.setTextureOffset(54, 20).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 3, 0.0F); // talonLftEnd
		talonLftInfo = new PartInfo(talonLft);
		this.talonRt = new ModelRenderer(this, 46, 17);
		this.talonRt.setRotationPoint(-1.0F, 1.0F, 0.0F);
		this.talonRt.addBox(-1.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
		this.talonRt.setTextureOffset(44, 20).addBox(-1.0F, 0.0F, -2.0F, 2, 1, 3, 0.0F); // talonRtEnd
		talonRtInfo = new PartInfo(talonRt);

		this.tailFeather = new ModelRenderer(this, 30, 22);
		this.tailFeather.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.tailFeather.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 3, 0.0F);
		this.tailFeather.setTextureOffset(33, 27).addBox(-1.0F, -0.49F, 2.3F, 2, 1, 1, 0.0F); // tailFeatherMid
		this.tailFeather.setTextureOffset(34, 30).addBox(-0.5F, -0.48F, 2.7F, 1, 1, 1, 0.0F); // tailFeatherEnd
		tailFeatherInfo = new PartInfo(tailFeather);

		this.chestLeafLft = new ModelRenderer(this, 42, 25);
		this.chestLeafLft.setRotationPoint(0.0F, -0.4F, -2.5F);
		this.chestLeafLft.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(chestLeafLft, 0.0F, 0.3490658503988659F, 0.0F);
		this.chestLeafRt = new ModelRenderer(this, 42, 27);
		this.chestLeafRt.setRotationPoint(0.0F, -0.4F, -2.5F);
		this.chestLeafRt.addBox(-1.5F, -0.51F, -0.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(chestLeafRt, 0.0F, -0.3490658503988659F, 0.0F);

		this.headJoint = new ModelRenderer(this, 0, 0);
		this.headJoint.setRotationPoint(0.0F, -2.0F, -0.01F);
		this.headJoint.addBox(-2.5F, -2.0F, -2.5F, 0, 0, 0, 0.0F);
		headJointInfo = new PartInfo(headJoint);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.addBox(-2.5F, -3.0F, -2.5F, 5, 4, 5, 0.0F);
		this.head.setTextureOffset(4, 10).addBox(-2.0F, 0.5F, -2.0F, 4, 1, 4, 0.0F); // headMidBot
		this.head.setTextureOffset(19, 15).addBox(-2.0F, -4.0F, -2.0F, 4, 1, 4, 0.0F); // headMidTop
		this.head.setTextureOffset(21, 10).addBox(-1.5F, -4.5F, -1.5F, 3, 1, 3, 0.0F); // headTop
		this.head.setTextureOffset(6, 16).addBox(-1.5F, 1.0F, -1.5F, 3, 1, 3, 0.0F); // headBot
		headInfo = new PartInfo(head);

		this.beakTop = new ModelRenderer(this, 0, 10);
		this.beakTop.setRotationPoint(0.0F, 0.0F, -2.0F);
		this.beakTop.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(beakTop, -0.2617993877991494F, 0.0F, 0.0F);
		this.beakBot = new ModelRenderer(this, 0, 14);
		this.beakBot.setRotationPoint(0.0F, 0.0F, -2.0F);
		this.beakBot.addBox(-0.51F, -0.5F, -0.9F, 1, 1, 1, 0.0F);
		this.setRotateAngle(beakBot, 0.2617993877991494F, 0.0F, 0.0F);
		beakBotInfo = new PartInfo(beakBot);

		this.headLeaf = new ModelRenderer(this, 16, 0);
		this.headLeaf.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.headLeaf.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		this.setRotateAngle(headLeaf, -0.2617993877991494F, 0.0F, 0.0F);
		headLeafInfo = new PartInfo(headLeaf);

		int wingFeatherNumber = 0;
		this.wingLftJoint = new ModelRenderer(this, 0, 0);
		this.wingLftJoint.setRotationPoint(2.0F, -1.0F, 0.0F);
		this.wingLftJoint.addBox(0.0F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		wingLftJointInfo = new PartInfo(wingLftJoint);
		this.wingLft[wingFeatherNumber] = new ModelRenderer(this, 49, 8); // wingLftFnt
		this.wingLft[wingFeatherNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingLft[wingFeatherNumber].addBox(-0.01F, -0.49F, -1.5F, 4, 1, 2, 0.0F);
		this.setRotateAngle(wingLft[wingFeatherNumber], 0.0F, 0.3490658503988659F, 0.0F);
		this.wingLft[wingFeatherNumber].setTextureOffset(60, 8).addBox(3.99F, -0.49F, -1.0F, 1, 1, 1, 0.0F); // wingLftFntTip
		wingLftInfo[wingFeatherNumber] = new PartInfo(wingLft[wingFeatherNumber]);
		wingFeatherNumber++;
		this.wingLft[wingFeatherNumber] = new ModelRenderer(this, 49, 4); // wingLftMid
		this.wingLft[wingFeatherNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingLft[wingFeatherNumber].addBox(0.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		this.wingLft[wingFeatherNumber].setTextureOffset(60, 4).addBox(4.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F); // wingLftMidTip
		wingLftInfo[wingFeatherNumber] = new PartInfo(wingLft[wingFeatherNumber]);
		wingFeatherNumber++;
		this.wingLft[wingFeatherNumber] = new ModelRenderer(this, 49, 0); // wingLftBck
		this.wingLft[wingFeatherNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingLft[wingFeatherNumber].addBox(-0.01F, -0.49F, -0.5F, 4, 1, 2, 0.0F);
		this.setRotateAngle(wingLft[wingFeatherNumber], 0.0F, -0.3490658503988659F, 0.0F);
		this.wingLft[wingFeatherNumber].setTextureOffset(60, 0).addBox(3.99F, -0.49F, 0.0F, 1, 1, 1, 0.0F); // wingLftBckTip
		wingLftInfo[wingFeatherNumber] = new PartInfo(wingLft[wingFeatherNumber]);

		wingFeatherNumber = 0;
		this.wingRtJoint = new ModelRenderer(this, 0, 0);
		this.wingRtJoint.setRotationPoint(-2.0F, -1.0F, 0.0F);
		this.wingRtJoint.addBox(0.0F, -0.5F, -1.0F, 0, 0, 0, 0.0F);
		wingRtJointInfo = new PartInfo(wingRtJoint);
		this.wingRt[wingFeatherNumber] = new ModelRenderer(this, 36, 8); // wingRtFnt
		this.wingRt[wingFeatherNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingRt[wingFeatherNumber].addBox(-3.99F, -0.49F, -1.5F, 4, 1, 2, 0.0F);
		this.setRotateAngle(wingRt[wingFeatherNumber], 0.0F, -0.3490658503988659F, 0.0F);
		this.wingRt[wingFeatherNumber].setTextureOffset(33, 8).addBox(-4.99F, -0.49F, -1.0F, 1, 1, 1, 0.0F); // wingRtFntTip
		wingRtInfo[wingFeatherNumber] = new PartInfo(wingRt[wingFeatherNumber]);
		wingFeatherNumber++;
		this.wingRt[wingFeatherNumber] = new ModelRenderer(this, 36, 4); // wingRtMid
		this.wingRt[wingFeatherNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingRt[wingFeatherNumber].addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		this.wingRt[wingFeatherNumber].setTextureOffset(33, 4).addBox(-5.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F); // wingRtMidTip
		wingRtInfo[wingFeatherNumber] = new PartInfo(wingRt[wingFeatherNumber]);
		wingFeatherNumber++;
		this.wingRt[wingFeatherNumber] = new ModelRenderer(this, 36, 0); // wingRtBck
		this.wingRt[wingFeatherNumber].setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingRt[wingFeatherNumber].addBox(-3.99F, -0.49F, -0.5F, 4, 1, 2, 0.0F);
		this.setRotateAngle(wingRt[wingFeatherNumber], 0.0F, 0.3490658503988659F, 0.0F);
		this.wingRt[wingFeatherNumber].setTextureOffset(33, 0).addBox(-4.99F, -0.49F, 0.0F, 1, 1, 1, 0.0F); // wingRtBckTip
		wingRtInfo[wingFeatherNumber] = new PartInfo(wingRt[wingFeatherNumber]);

		this.body.addChild(this.chestLeafLft);
		this.body.addChild(this.chestLeafRt);
		this.body.addChild(this.headJoint);
		this.body.addChild(this.tailFeather);
		this.body.addChild(this.talonLft);
		this.body.addChild(this.talonRt);
		this.body.addChild(this.wingLftJoint);
		this.body.addChild(this.wingRtJoint);

		this.headJoint.addChild(this.head);
		this.head.addChild(this.beakBot);
		this.head.addChild(this.beakTop);
		this.head.addChild(this.headLeaf);

		for(int i = 0; i < wingLft.length; i++)
		{
			this.wingLftJoint.addChild(this.wingLft[i]);
			this.wingRtJoint.addChild(this.wingRt[i]);
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

		float idleDampener = 1F;
		/*
		if(animationDeployer.getEntity().getAnimationID() == EntitySnowSorceressBraixen.actionIDSpell)
		{
			//idleDampener = animateSpell(animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		}
		 */	
		animateBody((EntityRageBomberRowlet)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener);
		animateHead((EntityRageBomberRowlet)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener);
		animateLegs((EntityRageBomberRowlet)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener);
		animateTail((EntityRageBomberRowlet)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize, idleDampener);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		headJointInfo.resetNewAngles();
		headInfo.resetNewAngles();

		headLeafInfo.resetNewAngles();

		bodyInfo.resetNewAngles();
		bodyInfo.resetNewPnt();

		talonRtInfo.resetNewAngles();
		talonLftInfo.resetNewAngles();

		wingLftJointInfo.resetNewAngles();
		wingRtJointInfo.resetNewAngles();

		for(int i = 0; i < wingLft.length; i++)
		{
			wingLftInfo[i].resetNewAngles();
			wingRtInfo[i].resetNewAngles();
		}
	}

	public void animateHead(EntityRageBomberRowlet entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(headInfo, yawHeadOffsetDifference, pitchRotation, 0.9F, 0.9F);

		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockIdleBobble();

		float idleAmplitudeX = 0.1F;

		// + (float)Math.toRadians(45)
		float movementFrequency = 1.2F;
		float movementAmplitude = 0.2F;
		float angleChangeX = PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, movementFrequency, movementAmplitude);

		angleChangeX += -MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * 2 * PI) * idleAmplitudeX + idleAmplitudeX;

		headLeafInfo.setNewRotateX(headLeafInfo.getNewRotateX() + angleChangeX);
	}

	public void animateBody(EntityRageBomberRowlet entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener)
	{

	}

	public void animateLegs(EntityRageBomberRowlet entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener)
	{
		float frequency = 1.4F;
		float amplitude = 0.8F;

		talonRtInfo.setNewRotateX(talonRtInfo.getNewRotateX() + PartAnimate.negCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude) * idleDampener);
		talonLftInfo.setNewRotateX(talonLftInfo.getNewRotateX() + PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, frequency, amplitude) * idleDampener);

	}

	public void animateTail(EntityRageBomberRowlet entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize, float idleDampener)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockTail();

		float idleAmplitudeX = 0.20F;
		float idleAmplitudeY = 0.45F;

		float moveFrequency = 1F;
		float moveAmplitude = 0.2F;

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = 0;

		angleChangeX += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2) * idleAmplitudeX
				+ PartAnimate.posCosRotateAnimationAdjusted(distanceMoved, horzVelocity, moveFrequency, moveAmplitude);
		angleChangeY += MathHelper.cos(currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2) * idleAmplitudeY;

		tailFeatherInfo.setNewRotateX(tailFeatherInfo.getNewRotateX() + angleChangeX);
		tailFeatherInfo.setNewRotateY(tailFeatherInfo.getNewRotateY() + angleChangeY);
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());

		this.animationDeployer.rotate(headJoint, headJointInfo.getNewRotates());
		this.animationDeployer.rotate(head, headInfo.getNewRotates());

		this.animationDeployer.rotate(headLeaf, headLeafInfo.getNewRotates());
		this.animationDeployer.rotate(body, bodyInfo.getNewRotates());
		this.animationDeployer.move(body, bodyInfo.getNewPnt());

		this.animationDeployer.rotate(talonRt, talonRtInfo.getNewRotates());
		this.animationDeployer.rotate(talonLft, talonLftInfo.getNewRotates());

		this.animationDeployer.rotate(wingLftJoint, wingLftJointInfo.getNewRotates());
		this.animationDeployer.rotate(wingRtJoint, wingRtJointInfo.getNewRotates());

		for(int i = 0; i < wingRt.length; i++)
		{
			this.animationDeployer.rotate(wingLft[i], wingLftInfo[i].getNewRotates());
			this.animationDeployer.rotate(wingRt[i], wingRtInfo[i].getNewRotates());
		}

		this.animationDeployer.applyChanges();
	}
}