package com.fuzzyacornindustries.pokemonmd.model.turret;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.PartAnimate;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityClayCommanderMeowsticMale;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntityProxyPylonCarbink;
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPrototurret extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer turretCenterJoint;
	PartInfo turretCenterJointInfo;

	public ModelRenderer barrelBase;
	PartInfo barrelBaseInfo;

	public ModelRenderer barrelBaseTop;

	public ModelRenderer barrelMainJoint;
	public ModelRenderer barrelMain;
	PartInfo barrelMainJointInfo;

	public ModelRenderer panelsJoint;
	PartInfo panelsJointInfo;

	public ModelRenderer panel[] = new ModelRenderer[4];
	PartInfo panelInfo[] = new PartInfo[panel.length];

	public ModelPrototurret() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.turretCenterJoint = new ModelRenderer(this, 0, 0);
		this.turretCenterJoint.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.turretCenterJoint.addBox(-2.0F, -3.2F, -1.0F, 0, 0, 0, 0.0F);
		turretCenterJointInfo = new PartInfo(turretCenterJoint);

		this.barrelBase = new ModelRenderer(this, 0, 0);
		this.barrelBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrelBase.addBox(-2.0F, -3.2F, -1.0F, 4, 3, 2, 0.0F);
		this.barrelBase.setTextureOffset(0, 6).addBox(-1.0F, -3.2F, -2.0F, 2, 2, 1, 0.0F); // barrelBaseFront
		this.barrelBase.setTextureOffset(0, 10).addBox(-1.0F, -3.2F, 1.0F, 2, 3, 1, 0.0F); // barrelBaseBack
		this.barrelBase.setTextureOffset(7, 11).addBox(-1.0F, -3.2F, 2.0F, 2, 2, 2, 0.0F); // barrelBaseBackFar
		barrelBaseInfo = new PartInfo(barrelBase);

		this.barrelBaseTop = new ModelRenderer(this, 7, 6);
		this.barrelBaseTop.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.barrelBaseTop.addBox(-1.0F, -2.5F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(barrelBaseTop, -0.6981317007977318F, -0.0F, 0.0F);

		this.barrelMainJoint = new ModelRenderer(this, 44, 22);
		this.barrelMainJoint.setRotationPoint(0.0F, -2.5F, 0.0F);
		this.barrelMainJoint.addBox(-0.5F, -0.5F, -7.5F, 0, 0, 0, 0.0F);
		barrelMainJointInfo = new PartInfo(barrelMainJoint);
		this.barrelMain = new ModelRenderer(this, 44, 22);
		this.barrelMain.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrelMain.addBox(-0.5F, -0.5F, -7.5F, 1, 1, 9, 0.0F);
		this.barrelMain.setTextureOffset(42, 25).addBox(-1.0F, -0.7F, -6.8F, 2, 2, 3, 0.0F); // barrelPump

		this.panelsJoint = new ModelRenderer(this, 58, 0);
		this.panelsJoint.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.panelsJoint.addBox(-1.0F, 0.3F, -2.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(panelsJoint, -0.0029670597283903604F, -0.027401669256310976F, 0.0F);
		panelsJointInfo = new PartInfo(panelsJoint);

		int panelNumber = 0;
		this.panel[panelNumber] = new ModelRenderer(this, 58, 0); // panel1
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, 3.141592653589793F, 0.0F);
		panelInfo[panelNumber]= new PartInfo(panel[panelNumber]);
		panelNumber++;
		this.panel[panelNumber] = new ModelRenderer(this, 51, 0); // panel2
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, 1.5707963267948966F, 0.0F);
		panelInfo[panelNumber]= new PartInfo(panel[panelNumber]);
		panelNumber++;
		this.panel[panelNumber] = new ModelRenderer(this, 44, 0); // panel3
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, 0.0F, 0.0F);
		panelInfo[panelNumber]= new PartInfo(panel[panelNumber]);
		panelNumber++;
		this.panel[panelNumber] = new ModelRenderer(this, 37, 0); // panel4
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, -1.5707963267948966F, 0.0F);
		panelInfo[panelNumber]= new PartInfo(panel[panelNumber]);

		this.turretCenterJoint.addChild(this.barrelBase);
		this.barrelBase.addChild(this.barrelBaseTop);

		this.barrelBase.addChild(this.barrelMainJoint);
		this.barrelMainJoint.addChild(this.barrelMain);

		this.turretCenterJoint.addChild(this.panelsJoint);

		for(int i = 0; i < panel.length; i++)
		{
			this.panelsJoint.addChild(this.panel[i]);
		}

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
	{
		animate(entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		this.turretCenterJoint.render(modelSize);
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

		if(animationDeployer.getEntity().getAnimationID() == EntityPrototurret.actionIDFireRound)
		{
			animateRecoil(animationDeployer.getEntity(), distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		}
		
		animateTurretTop((EntityPrototurret)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animateVerticalFloat((EntityPrototurret)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);
		animatePanels((EntityPrototurret)entity, distanceMoved, horzVelocity, yawRotationDifference, yawHeadOffsetDifference, pitchRotation, modelSize);

		deployAnimations();
	}

	public void resetPartInfos()
	{	
		turretCenterJointInfo.resetNewAngles();
		turretCenterJointInfo.resetNewPnt();

		barrelBaseInfo.resetNewAngles();
		
		barrelMainJointInfo.resetNewAngles();
		barrelMainJointInfo.resetNewPnt();

		panelsJointInfo.resetNewAngles();
		
		for(int i = 0; i < panel.length; i++)
		{
			panelInfo[i].resetNewAngles();
		}
	}

	public void animateRecoil(IAnimatedEntity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		float idleDampener = 1F;

		float tick = animationDeployer.getEntity().getAnimationTick() + PokemonMDMain.proxy.getPartialTick();

		float firstPhaseEnd = 2; // Nothing happens/pause
		float secondPhaseEnd = 4;
		float endDuration = 20;

		/*
		 * Recoil animation
		 */
		float barrelTick = tick;

		float barrelRecoilDuration = secondPhaseEnd - firstPhaseEnd;
		float barrelReturnDuration = endDuration - secondPhaseEnd;

		float barrelShiftZ = 2F;

		Vector3f barrelShiftVector = new Vector3f(0, 0, 0);

		if(tick > firstPhaseEnd && tick < secondPhaseEnd)
		{
			barrelTick = tick - firstPhaseEnd;
			barrelShiftVector.addToZ(barrelShiftZ *
					(float)MathHelper.cos((2 * PI * ((barrelRecoilDuration - barrelTick)/barrelRecoilDuration)) + PI/2));
			
			barrelShiftVector.addToZ(barrelShiftZ);
		}
		else if(tick < endDuration)
		{
			barrelTick = tick - secondPhaseEnd;
			
			barrelShiftVector.addToZ(barrelShiftZ * 
					(float)MathHelper.cos(((PI/2) * ((barrelReturnDuration - barrelTick)/barrelReturnDuration)) - (PI/2)));
		}
		
		barrelMainJointInfo.setNewPnt(Vector3f.vectorPlusVector(barrelShiftVector, barrelMainJointInfo.getNewPnt()));
	}
	
	public void animateTurretTop(EntityPrototurret entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		PartAnimate.headAnimateInfoOnlyWithAngleModifiers(barrelBaseInfo, yawHeadOffsetDifference, pitchRotation, 0.8F, 0.8F);
	}
	
	public void animateVerticalFloat(EntityPrototurret entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockVerticalFloat();

		float amplitudeShiftY = 1.0F;

		turretCenterJointInfo.setNewPointY(turretCenterJointInfo.getNewPnt().getY() + MathHelper.cos(2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredY(0)) * amplitudeShiftY);
	}

	public void animatePanels(EntityPrototurret entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize)
	{
		IdleAnimationClock currentIdleAnimationClock = entity.getIdleAnimationClockPanel();

		panelsJointInfo.setNewRotateY(panelsJointInfo.getNewRotateY() - (2F * PI * currentIdleAnimationClock.getPhaseDurationCoveredY(0)));
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(barrelBase, barrelBaseInfo.getNewRotates());
		
		this.animationDeployer.rotate(turretCenterJoint, turretCenterJointInfo.getNewRotates());
		this.animationDeployer.move(turretCenterJoint, turretCenterJointInfo.getNewPnt());

		this.animationDeployer.rotate(barrelMainJoint, barrelMainJointInfo.getNewRotates());
		this.animationDeployer.move(barrelMainJoint, barrelMainJointInfo.getNewPnt());
		
		this.animationDeployer.rotate(panelsJoint, panelsJointInfo.getNewRotates());
		/*
		for(int i = 0; i < panel.length; i++)
		{
			this.animationDeployer.rotate(panel[i], panelInfo[i].getNewRotates());
		}*/

		this.animationDeployer.applyChanges();
	}
}