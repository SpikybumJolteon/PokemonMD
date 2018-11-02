package com.fuzzyacornindustries.pokemonmd.model.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBanelingNincada extends ModelBase 
{
    public ModelRenderer body;
    public ModelRenderer bodyNeck;
    public ModelRenderer bodyFnt;
    public ModelRenderer bodyBck;
    
    public ModelRenderer legFntLftJoint;
    public ModelRenderer legFntLft;
    public ModelRenderer legFntRtJoint;
    public ModelRenderer legFntRt;
    public ModelRenderer legBckLftJoint;
    public ModelRenderer legBckLft;
    public ModelRenderer legBckRtJoint;
    public ModelRenderer legBckRt;
    
    public ModelRenderer headJoint;
    public ModelRenderer head;
    public ModelRenderer headFace;
    
    public ModelRenderer mandibleLft;
    public ModelRenderer mandibleLftTip;
    public ModelRenderer mandibleRt;
    public ModelRenderer mandibleRtTip;

    public ModelRenderer sacLftBotFntJoint;
    public ModelRenderer sacLftBotFnt;
    public ModelRenderer sacLftBotBckJoint;
    public ModelRenderer sacLftBotBck;

    public ModelRenderer sacLftTopFntJoint;
    public ModelRenderer sacLftTopFnt;
    public ModelRenderer sacLftTopBckJoint;
    public ModelRenderer sacLftTopBck;

    public ModelRenderer sacTopLftFntJoint;
    public ModelRenderer sacTopLftFnt;
    public ModelRenderer sacTopLftBckJoint;
    public ModelRenderer sacTopLftBck;
    public ModelRenderer sacTopRtFntJoint;
    public ModelRenderer sacTopRtFnt;
    public ModelRenderer sacTopRtBckJoint;
    public ModelRenderer sacTopRtBck;
    
    public ModelRenderer sacBackRtJoint;
    public ModelRenderer sacBackRt;
    public ModelRenderer sacBackLftJoint;
    public ModelRenderer sacBackLft;

    public ModelRenderer sacRtTopFntJoint;
    public ModelRenderer sacRtTopFnt;
    public ModelRenderer sacRtTopBckJoint;
    public ModelRenderer sacRtTopBck;
    
    public ModelRenderer sacRtBotFntJoint;
    public ModelRenderer sacRtBotFnt;
    public ModelRenderer sacRtBotBckJoint;
    public ModelRenderer sacRtBotBck;
    
    public ModelRenderer wingLft;
    public ModelRenderer wingRt;
    
    public ModelBanelingNincada() 
    {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.body = new ModelRenderer(this, 40, 22);
        this.body.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.body.addBox(-3.5F, -2.0F, -2.5F, 7, 5, 5, 0.0F);
        this.bodyNeck = new ModelRenderer(this, 52, 0);
        this.bodyNeck.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyNeck.addBox(-2.5F, -2.0F, -4.5F, 5, 4, 1, 0.0F);
        this.bodyFnt = new ModelRenderer(this, 48, 8);
        this.bodyFnt.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyFnt.addBox(-3.5F, -3.0F, -3.5F, 7, 6, 1, 0.0F);
        this.bodyBck = new ModelRenderer(this, 48, 15);
        this.bodyBck.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyBck.addBox(-3.5F, -3.0F, 2.5F, 7, 6, 1, 0.0F);

        this.legFntLftJoint = new ModelRenderer(this, 39, 4);
        this.legFntLftJoint.setRotationPoint(2.0F, 2.5F, -2.0F);
        this.legFntLftJoint.addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntLftJoint, 0.0F, 0.0F, 0.6108652381980153F);
        this.legFntLft = new ModelRenderer(this, 39, 4);
        this.legFntLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntLft.addBox(-1.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.legFntRtJoint = new ModelRenderer(this, 39, 0);
        this.legFntRtJoint.setRotationPoint(-2.0F, 2.5F, -2.0F);
        this.legFntRtJoint.addBox(-3.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legFntRtJoint, 0.0F, 0.0F, -0.6108652381980153F);
        this.legFntRt = new ModelRenderer(this, 39, 0);
        this.legFntRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legFntRt.addBox(-3.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.legBckLftJoint = new ModelRenderer(this, 39, 4);
        this.legBckLftJoint.setRotationPoint(2.0F, 2.5F, 2.0F);
        this.legBckLftJoint.addBox(-1.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckLftJoint, 0.0F, -0.0F, 0.6108652381980153F);
        this.legBckLft = new ModelRenderer(this, 39, 4);
        this.legBckLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckLft.addBox(-1.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.legBckRtJoint = new ModelRenderer(this, 39, 0);
        this.legBckRtJoint.setRotationPoint(-2.0F, 2.5F, 2.0F);
        this.legBckRtJoint.addBox(-3.0F, -1.0F, -1.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(legBckRtJoint, 0.0F, 0.0F, -0.6108652381980153F);
        this.legBckRt = new ModelRenderer(this, 39, 0);
        this.legBckRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legBckRt.addBox(-3.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);

        this.headJoint = new ModelRenderer(this, 12, 0);
        this.headJoint.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.headJoint.addBox(-1.5F, -1.5F, -3.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headJoint, 0.17453292519943295F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 12, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3, 0.0F);
        this.headFace = new ModelRenderer(this, 0, 0);
        this.headFace.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFace.addBox(-1.6F, -1.0F, -3.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(headFace, -0.17453292519943295F, 0.0F, 0.0F);
        
        this.mandibleLft = new ModelRenderer(this, 5, 5);
        this.mandibleLft.setRotationPoint(1.2F, 1.5F, -3.0F);
        this.mandibleLft.addBox(0.0F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(mandibleLft, 0.17453292519943295F, 0.0F, 0.0F);
        this.mandibleLftTip = new ModelRenderer(this, 8, 3);
        this.mandibleLftTip.setRotationPoint(1.2F, 1.5F, -3.0F);
        this.mandibleLftTip.addBox(0.0F, -1.5F, -1.7F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mandibleLftTip, 0.17453292519943295F, -0.0F, 0.0F);
        this.mandibleRt = new ModelRenderer(this, 0, 4);
        this.mandibleRt.setRotationPoint(-1.2F, 1.5F, -3.0F);
        this.mandibleRt.addBox(-1.0F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(mandibleRt, 0.17453292519943295F, 0.0F, 0.0F);
        this.mandibleRtTip = new ModelRenderer(this, 8, 0);
        this.mandibleRtTip.setRotationPoint(-1.2F, 1.5F, -3.0F);
        this.mandibleRtTip.addBox(-1.0F, -1.5F, -1.7F, 1, 1, 1, 0.0F);
        this.setRotateAngle(mandibleRtTip, 0.17453292519943295F, -0.0F, 0.0F);

        this.sacLftBotFntJoint = new ModelRenderer(this, 36, 16);
        this.sacLftBotFntJoint.setRotationPoint(3.0F, 0.5F, -1.5F);
        this.sacLftBotFntJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacLftBotFntJoint, 0.0F, 0.0F, 0.4363323129985824F);
        this.sacLftBotFnt = new ModelRenderer(this, 36, 16);
        this.sacLftBotFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacLftBotFnt.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.sacLftBotBckJoint = new ModelRenderer(this, 25, 6);
        this.sacLftBotBckJoint.setRotationPoint(3.0F, 0.5F, 1.5F);
        this.sacLftBotBckJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacLftBotBckJoint, 0.0F, 0.0F, 0.4363323129985824F);
        this.sacLftBotBck = new ModelRenderer(this, 25, 6);
        this.sacLftBotBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacLftBotBck.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

        this.sacLftTopFntJoint = new ModelRenderer(this, 36, 10);
        this.sacLftTopFntJoint.setRotationPoint(3.0F, -2.0F, -1.4F);
        this.sacLftTopFntJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacLftTopFntJoint, 0.0F, 0.0F, -0.4363323129985824F);
        this.sacLftTopFnt = new ModelRenderer(this, 36, 10);
        this.sacLftTopFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacLftTopFnt.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

        this.sacLftTopBckJoint = new ModelRenderer(this, 25, 0);
        this.sacLftTopBckJoint.setRotationPoint(3.0F, -2.0F, 1.6F);
        this.sacLftTopBckJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacLftTopBckJoint, 0.0F, 0.0F, -0.4363323129985824F);
        this.sacLftTopBck = new ModelRenderer(this, 25, 0);
        this.sacLftTopBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacLftTopBck.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

        this.sacTopLftFntJoint = new ModelRenderer(this, 24, 26);
        this.sacTopLftFntJoint.setRotationPoint(1.5F, -3.0F, -1.3F);
        this.sacTopLftFntJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.sacTopLftFnt = new ModelRenderer(this, 24, 26);
        this.sacTopLftFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacTopLftFnt.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.sacTopLftBckJoint = new ModelRenderer(this, 24, 20);
        this.sacTopLftBckJoint.setRotationPoint(1.5F, -3.0F, 1.7F);
        this.sacTopLftBckJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.sacTopLftBck = new ModelRenderer(this, 24, 20);
        this.sacTopLftBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacTopLftBck.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.sacTopRtFntJoint = new ModelRenderer(this, 12, 26);
        this.sacTopRtFntJoint.setRotationPoint(-1.5F, -3.0F, -1.3F);
        this.sacTopRtFntJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.sacTopRtFnt = new ModelRenderer(this, 12, 26);
        this.sacTopRtFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacTopRtFnt.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.sacTopRtBckJoint = new ModelRenderer(this, 12, 20);
        this.sacTopRtBckJoint.setRotationPoint(-1.5F, -3.0F, 1.7F);
        this.sacTopRtBckJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.sacTopRtBck = new ModelRenderer(this, 12, 20);
        this.sacTopRtBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacTopRtBck.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

        this.sacBackRtJoint = new ModelRenderer(this, 12, 13);
        this.sacBackRtJoint.setRotationPoint(0.0F, 0.0F, 3.5F);
        this.sacBackRtJoint.addBox(-3.0F, -2.0F, -1.5F, 0, 0, 0, 0.0F);
        this.sacBackRt = new ModelRenderer(this, 12, 13);
        this.sacBackRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacBackRt.addBox(-3.0F, -2.0F, -1.5F, 3, 4, 3, 0.0F);
        this.sacBackLftJoint = new ModelRenderer(this, 24, 13);
        this.sacBackLftJoint.setRotationPoint(0.0F, 0.0F, 3.5F);
        this.sacBackLftJoint.addBox(0.0F, -2.0F, -1.5F, 0, 0, 0, 0.0F);
        this.sacBackLft = new ModelRenderer(this, 24, 13);
        this.sacBackLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacBackLft.addBox(0.0F, -2.0F, -1.5F, 3, 4, 3, 0.0F);

        this.sacRtTopFntJoint = new ModelRenderer(this, 0, 20);
        this.sacRtTopFntJoint.setRotationPoint(-3.0F, -2.0F, -1.4F);
        this.sacRtTopFntJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacRtTopFntJoint, 0.0F, 0.0F, 0.4363323129985824F);
        this.sacRtTopFnt = new ModelRenderer(this, 0, 20);
        this.sacRtTopFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacRtTopFnt.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.sacRtTopBckJoint = new ModelRenderer(this, 0, 8);
        this.sacRtTopBckJoint.setRotationPoint(-3.0F, -2.0F, 1.6F);
        this.sacRtTopBckJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacRtTopBckJoint, 0.0F, 0.0F, 0.4363323129985824F);
        this.sacRtTopBck = new ModelRenderer(this, 0, 8);
        this.sacRtTopBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacRtTopBck.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

        this.sacRtBotFntJoint = new ModelRenderer(this, 0, 26);
        this.sacRtBotFntJoint.setRotationPoint(-3.0F, 0.5F, -1.5F);
        this.sacRtBotFntJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacRtBotFntJoint, 0.0F, 0.0F, -0.4363323129985824F);
        this.sacRtBotFnt = new ModelRenderer(this, 0, 26);
        this.sacRtBotFnt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacRtBotFnt.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.sacRtBotBckJoint = new ModelRenderer(this, 0, 14);
        this.sacRtBotBckJoint.setRotationPoint(-3.0F, 0.5F, 1.5F);
        this.sacRtBotBckJoint.addBox(-1.5F, -1.5F, -1.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(sacRtBotBckJoint, 0.0F, 0.0F, -0.4363323129985824F);
        this.sacRtBotBck = new ModelRenderer(this, 0, 14);
        this.sacRtBotBck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sacRtBotBck.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);

        this.wingLft = new ModelRenderer(this, 19, 7);
        this.wingLft.setRotationPoint(3.1F, -3.5F, 1.7F);
        this.wingLft.addBox(-1.0F, -3.5F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(wingLft, -0.5235987755982988F, -0.0F, 0.0F);
        this.wingRt = new ModelRenderer(this, 13, 7);
        this.wingRt.setRotationPoint(-3.1F, -3.5F, 1.7F);
        this.wingRt.addBox(0.0F, -3.5F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(wingRt, -0.5235987755982988F, -0.0F, 0.0F);
        
        
        
        this.sacLftTopFntJoint.addChild(this.sacLftTopFnt);
        this.sacRtBotFntJoint.addChild(this.sacRtBotFnt);
        this.body.addChild(this.legFntLftJoint);
        this.sacTopLftBckJoint.addChild(this.sacTopLftBck);
        this.body.addChild(this.sacRtTopBckJoint);
        this.body.addChild(this.sacLftTopFntJoint);
        this.headFace.addChild(this.mandibleLft);
        this.body.addChild(this.sacBackLftJoint);
        this.sacBackLftJoint.addChild(this.sacBackLft);
        this.legFntRtJoint.addChild(this.legFntRt);
        this.head.addChild(this.headFace);
        this.body.addChild(this.wingLft);
        this.legFntLftJoint.addChild(this.legFntLft);
        this.sacTopRtBckJoint.addChild(this.sacTopRtBck);
        this.sacRtBotBckJoint.addChild(this.sacRtBotBck);
        this.body.addChild(this.sacTopRtFntJoint);
        this.body.addChild(this.legBckLftJoint);
        this.body.addChild(this.headJoint);
        this.body.addChild(this.sacBackRtJoint);
        this.body.addChild(this.sacTopRtBckJoint);
        this.body.addChild(this.sacRtBotFntJoint);
        this.body.addChild(this.wingRt);
        this.body.addChild(this.legBckRtJoint);
        this.headFace.addChild(this.mandibleRt);
        this.headFace.addChild(this.mandibleLftTip);
        this.legBckRtJoint.addChild(this.legBckRt);
        this.body.addChild(this.sacLftTopBckJoint);
        this.sacBackRtJoint.addChild(this.sacBackRt);
        this.sacRtTopBckJoint.addChild(this.sacRtTopBck);
        this.body.addChild(this.sacTopLftBckJoint);
        this.body.addChild(this.sacRtTopFntJoint);
        this.headJoint.addChild(this.head);
        this.body.addChild(this.sacRtBotBckJoint);
        this.legBckLftJoint.addChild(this.legBckLft);
        this.sacRtTopFntJoint.addChild(this.sacRtTopFnt);
        this.body.addChild(this.sacLftBotFntJoint);
        this.body.addChild(this.sacTopLftFntJoint);
        this.sacLftTopBckJoint.addChild(this.sacLftTopBck);
        this.body.addChild(this.legFntRtJoint);
        this.sacTopLftFntJoint.addChild(this.sacTopLftFnt);
        this.headFace.addChild(this.mandibleRtTip);
        this.sacLftBotFntJoint.addChild(this.sacLftBotFnt);
        this.sacLftBotBckJoint.addChild(this.sacLftBotBck);
        this.sacTopRtFntJoint.addChild(this.sacTopRtFnt);
        this.body.addChild(this.sacLftBotBckJoint);
    }

    @Override
    public void render(Entity entity, float distanceMoved, float horzVelocity, float yawRotationDifference, float yawHeadOffsetDifference, float pitchRotation, float modelSize) 
    {	
        this.body.render(modelSize);
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
}