package com.fuzzyacornindustries.pokemonmd.model.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClayTorracat extends ModelBase 
{
    public ModelRenderer body;
    
    public ModelRenderer bodyArmorFntMain;
    public ModelRenderer bodyArmorFntBot;
    public ModelRenderer bodyArmorFntBck;
    public ModelRenderer bodyArmorFntBckBot;
    public ModelRenderer bodyArmorBckMain;
    public ModelRenderer bodyArmorBckFnt;
    public ModelRenderer bodyArmorBckBot;
    public ModelRenderer bodyArmorBckFntBot;
    
    public ModelRenderer legFntLft1;
    public ModelRenderer legFntLft2;
    public ModelRenderer legFntRt1;
    public ModelRenderer legFntRt2;
    public ModelRenderer legBckLft1;
    public ModelRenderer legBckLft2;
    public ModelRenderer legBckRt1;
    public ModelRenderer legBckRt2;
    
    public ModelRenderer armorFlapFntLftJoint;
    public ModelRenderer armorFlapFntLft;
    public ModelRenderer armorFlapFntLftMid;
    public ModelRenderer armorFlapFntLftTip;
    
    public ModelRenderer armorFlapFntRtJoint;
    public ModelRenderer armorFlapFntRt;
    public ModelRenderer armorFlapFntRtMid;
    public ModelRenderer armorFlapFntRtTip;
    
    public ModelRenderer armorFlapBckLftJoint;
    public ModelRenderer armorFlapBckLft;
    public ModelRenderer armorFlapBckLftMid;
    public ModelRenderer armorFlapBckLftTip;
    
    public ModelRenderer armorFlapBckRtJoint;
    public ModelRenderer armorFlapBckRt;
    public ModelRenderer armorFlapBckRtMid;
    public ModelRenderer armorFlapBckRtTip;
    
    public ModelRenderer neckJoint;
    public ModelRenderer neck;

    public ModelRenderer bell1;
    public ModelRenderer bell2;
    
    public ModelRenderer headJoint;
    public ModelRenderer head;
    
    public ModelRenderer muzzle;
    public ModelRenderer nose;
    
    public ModelRenderer helmet;
    public ModelRenderer helmetBack;
    public ModelRenderer helmetSideLftTop;
    public ModelRenderer helmetSideLftBot;
    public ModelRenderer helmetSideRtTop;
    public ModelRenderer helmetSideRtBot;
    public ModelRenderer helmetTop;
    public ModelRenderer helmetStem;
    public ModelRenderer helmetCrest;
    
    public ModelRenderer checkTuffLftTop;
    public ModelRenderer checkTuffLftBot;
    public ModelRenderer checkTuffLftFnt;
    public ModelRenderer checkTuffRtTop;
    public ModelRenderer checkTuffRtBot;
    public ModelRenderer checkTuffRtFnt;
    
    public ModelRenderer earLftJoint;
    public ModelRenderer earLft;
    public ModelRenderer earLftTip;
    public ModelRenderer earRtJoint;
    public ModelRenderer earRt;
    public ModelRenderer earRtTip;

    public ModelRenderer tail1Joint;
    public ModelRenderer tail1;
    public ModelRenderer tail2Joint;
    public ModelRenderer tail2;
    public ModelRenderer tail3Joint;
    public ModelRenderer tail3;
    public ModelRenderer tail4Joint;
    public ModelRenderer tail4;
    public ModelRenderer tail5Joint;
    public ModelRenderer tail5;
    public ModelRenderer tail6Joint;
    public ModelRenderer tail6;
    public ModelRenderer tail7Joint;
    public ModelRenderer tail7;
    
    public ModelRenderer tailTipLftTop;
    public ModelRenderer tailTipRtTop;
    public ModelRenderer tailTipLftBot;
    public ModelRenderer tailTipRtBot;

    public ModelClayTorracat() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.body = new ModelRenderer(this, 39, 52);
        this.body.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.body.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 8, 0.0F);
        this.bodyArmorFntMain = new ModelRenderer(this, 0, 52);
        this.bodyArmorFntMain.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorFntMain.addBox(-2.5F, -2.2F, -4.3F, 5, 4, 3, 0.0F);
        this.bodyArmorFntBot = new ModelRenderer(this, 0, 60);
        this.bodyArmorFntBot.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorFntBot.addBox(-2.51F, 1.1F, -4.29F, 5, 1, 3, 0.0F);
        this.bodyArmorFntBck = new ModelRenderer(this, 2, 43);
        this.bodyArmorFntBck.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorFntBck.addBox(-2.51F, -2.19F, -1.7F, 5, 4, 1, 0.0F);
        this.bodyArmorFntBckBot = new ModelRenderer(this, 2, 49);
        this.bodyArmorFntBckBot.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorFntBckBot.addBox(-2.52F, 1.1F, -1.69F, 5, 1, 1, 0.0F);
        this.bodyArmorBckMain = new ModelRenderer(this, 17, 52);
        this.bodyArmorBckMain.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorBckMain.addBox(-2.5F, -2.2F, 1.4F, 5, 4, 3, 0.0F);
        this.bodyArmorBckFnt = new ModelRenderer(this, 19, 43);
        this.bodyArmorBckFnt.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorBckFnt.addBox(-2.51F, -2.19F, 0.7F, 5, 4, 1, 0.0F);
        this.bodyArmorBckBot = new ModelRenderer(this, 17, 60);
        this.bodyArmorBckBot.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorBckBot.addBox(-2.51F, 1.1F, 1.39F, 5, 1, 3, 0.0F);
        this.bodyArmorBckFntBot = new ModelRenderer(this, 19, 49);
        this.bodyArmorBckFntBot.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.bodyArmorBckFntBot.addBox(-2.52F, 1.1F, 0.69F, 5, 1, 1, 0.0F);

        this.legFntLft1 = new ModelRenderer(this, 56, 38);
        this.legFntLft1.setRotationPoint(1.2F, 0.6F, -2.0F);
        this.legFntLft1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(legFntLft1, 0.17453292519943295F, 0.0F, 0.0F);
        this.legFntLft2 = new ModelRenderer(this, 56, 42);
        this.legFntLft2.setRotationPoint(0.0F, 1.1F, 0.0F);
        this.legFntLft2.addBox(-1.01F, -0.5F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(legFntLft2, -0.3490658503988659F, 0.0F, 0.0F);
        this.legFntRt1 = new ModelRenderer(this, 38, 38);
        this.legFntRt1.setRotationPoint(-1.2F, 0.6F, -2.0F);
        this.legFntRt1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(legFntRt1, 0.17453292519943295F, 0.0F, 0.0F);
        this.legFntRt2 = new ModelRenderer(this, 38, 42);
        this.legFntRt2.setRotationPoint(0.0F, 1.1F, 0.0F);
        this.legFntRt2.addBox(-0.99F, -0.5F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(legFntRt2, -0.3490658503988659F, 0.0F, 0.0F);
        this.legBckLft1 = new ModelRenderer(this, 56, 49);
        this.legBckLft1.setRotationPoint(1.2F, 0.6F, 2.3F);
        this.legBckLft1.addBox(-1.0F, -0.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(legBckLft1, -0.17453292519943295F, 0.0F, 0.0F);
        this.legBckLft2 = new ModelRenderer(this, 56, 54);
        this.legBckLft2.setRotationPoint(0.0F, 2.7F, 0.7F);
        this.legBckLft2.addBox(-1.01F, -1.2F, -0.9F, 2, 3, 2, 0.0F);
        this.legBckRt1 = new ModelRenderer(this, 38, 49);
        this.legBckRt1.setRotationPoint(-1.2F, 0.6F, 2.3F);
        this.legBckRt1.addBox(-1.0F, -0.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(legBckRt1, -0.17453292519943295F, 0.0F, 0.0F);
        this.legBckRt2 = new ModelRenderer(this, 38, 54);
        this.legBckRt2.setRotationPoint(0.0F, 2.7F, 0.7F);
        this.legBckRt2.addBox(-0.99F, -1.2F, -0.9F, 2, 3, 2, 0.0F);

        this.armorFlapFntLftJoint = new ModelRenderer(this, 0, 0);
        this.armorFlapFntLftJoint.setRotationPoint(2.3F, 1.5F, -2.4F);
        this.armorFlapFntLftJoint.addBox(-0.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F);
        this.armorFlapFntLft = new ModelRenderer(this, 8, 33);
        this.armorFlapFntLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapFntLft.addBox(-0.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.armorFlapFntLftMid = new ModelRenderer(this, 9, 37);
        this.armorFlapFntLftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapFntLftMid.addBox(-0.51F, 0.8F, -1.0F, 1, 1, 2, 0.0F);
        this.armorFlapFntLftTip = new ModelRenderer(this, 10, 40);
        this.armorFlapFntLftTip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapFntLftTip.addBox(-0.52F, 1.4F, -0.5F, 1, 1, 1, 0.0F);

        this.armorFlapFntRtJoint = new ModelRenderer(this, 0, 0);
        this.armorFlapFntRtJoint.setRotationPoint(-2.3F, 1.5F, -2.4F);
        this.armorFlapFntRtJoint.addBox(-0.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F);
        this.armorFlapFntRt = new ModelRenderer(this, 0, 33);
        this.armorFlapFntRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapFntRt.addBox(-0.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.armorFlapFntRtMid = new ModelRenderer(this, 1, 37);
        this.armorFlapFntRtMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapFntRtMid.addBox(-0.49F, 0.8F, -1.0F, 1, 1, 2, 0.0F);
        this.armorFlapFntRtTip = new ModelRenderer(this, 2, 40);
        this.armorFlapFntRtTip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapFntRtTip.addBox(-0.48F, 1.4F, -0.5F, 1, 1, 1, 0.0F);

        this.armorFlapBckLftJoint = new ModelRenderer(this, 0, 0);
        this.armorFlapBckLftJoint.setRotationPoint(2.3F, 1.5F, 2.6F);
        this.armorFlapBckLftJoint.addBox(-0.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F);
        this.armorFlapBckLft = new ModelRenderer(this, 25, 33);
        this.armorFlapBckLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapBckLft.addBox(-0.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.armorFlapBckLftMid = new ModelRenderer(this, 26, 37);
        this.armorFlapBckLftMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapBckLftMid.addBox(-0.51F, 0.8F, -1.0F, 1, 1, 2, 0.0F);
        this.armorFlapBckLftTip = new ModelRenderer(this, 27, 40);
        this.armorFlapBckLftTip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapBckLftTip.addBox(-0.52F, 1.4F, -0.5F, 1, 1, 1, 0.0F);

        this.armorFlapBckRtJoint = new ModelRenderer(this, 0, 0);
        this.armorFlapBckRtJoint.setRotationPoint(-2.3F, 1.5F, 2.6F);
        this.armorFlapBckRtJoint.addBox(-0.5F, 0.0F, -1.5F, 0, 0, 0, 0.0F);
        this.armorFlapBckRt = new ModelRenderer(this, 17, 33);
        this.armorFlapBckRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapBckRt.addBox(-0.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.armorFlapBckRtMid = new ModelRenderer(this, 18, 37);
        this.armorFlapBckRtMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapBckRtMid.addBox(-0.49F, 0.8F, -1.0F, 1, 1, 2, 0.0F);
        this.armorFlapBckRtTip = new ModelRenderer(this, 19, 40);
        this.armorFlapBckRtTip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armorFlapBckRtTip.addBox(-0.48F, 1.4F, -0.5F, 1, 1, 1, 0.0F);

        this.neckJoint = new ModelRenderer(this, 0, 0);
        this.neckJoint.setRotationPoint(0.0F, -1.0F, -3.0F);
        this.neckJoint.addBox(-1.0F, -1.0F, -3.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(neckJoint, -0.7853981633974483F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 9, 19);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);

        this.bell1 = new ModelRenderer(this, 6, 25);
        this.bell1.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.bell1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(bell1, 0.7853981633974483F, 0.7853981633974483F, 0.7853981633974483F);
        this.bell2 = new ModelRenderer(this, 14, 25);
        this.bell2.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.bell2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(bell2, -2.530727415391778F, -2.530727415391778F, -2.530727415391778F);

        this.headJoint = new ModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, 0.0F, -3.3F);
        this.headJoint.addBox(-2.0F, -3.0F, -2.3F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headJoint, 0.7853981633974483F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 6, 3);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-2.0F, -3.0F, -2.3F, 4, 4, 4, 0.0F);

        this.muzzle = new ModelRenderer(this, 11, 12);
        this.muzzle.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.muzzle.addBox(-1.0F, -1.0F, -0.8F, 2, 2, 1, 0.0F);
        this.setRotateAngle(muzzle, 0.17453292519943295F, 0.0F, 0.0F);
        this.nose = new ModelRenderer(this, 12, 16);
        this.nose.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.nose.addBox(-0.5F, -0.95F, -1.1F, 1, 1, 1, 0.0F);
        this.setRotateAngle(nose, 0.17453292519943295F, 0.0F, 0.0F);

        this.helmet = new ModelRenderer(this, 38, 13);
        this.helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.helmet.addBox(-2.5F, -3.3F, -2.8F, 5, 1, 5, 0.0F);
        this.helmetBack = new ModelRenderer(this, 40, 19);
        this.helmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.helmetBack.addBox(-2.5F, -2.3F, -0.8F, 5, 2, 3, 0.0F);
        this.helmetSideLftTop = new ModelRenderer(this, 56, 17);
        this.helmetSideLftTop.setRotationPoint(2.0F, -1.7F, 0.3F);
        this.helmetSideLftTop.addBox(-0.2F, -1.0F, -1.7F, 1, 2, 3, 0.0F);
        this.setRotateAngle(helmetSideLftTop, 0.3490658503988659F, -0.08726646259971647F, -0.4363323129985824F);
        this.helmetSideLftBot = new ModelRenderer(this, 56, 22);
        this.helmetSideLftBot.setRotationPoint(2.0F, -0.7F, 0.3F);
        this.helmetSideLftBot.addBox(-0.2F, -1.0F, -1.7F, 1, 2, 3, 0.0F);
        this.setRotateAngle(helmetSideLftBot, 0.3490658503988659F, -0.08726646259971647F, -0.4363323129985824F);
        this.helmetSideRtTop = new ModelRenderer(this, 32, 17);
        this.helmetSideRtTop.setRotationPoint(-2.0F, -1.7F, 0.3F);
        this.helmetSideRtTop.addBox(-0.7F, -1.0F, -1.7F, 1, 2, 3, 0.0F);
        this.setRotateAngle(helmetSideRtTop, 0.3490658503988659F, 0.08726646259971647F, 0.4363323129985824F);
        this.helmetSideRtBot = new ModelRenderer(this, 32, 22);
        this.helmetSideRtBot.setRotationPoint(-2.0F, -0.7F, 0.3F);
        this.helmetSideRtBot.addBox(-0.7F, -1.0F, -1.7F, 1, 2, 3, 0.0F);
        this.setRotateAngle(helmetSideRtBot, 0.3490658503988659F, 0.08726646259971647F, 0.4363323129985824F);
        this.helmetTop = new ModelRenderer(this, 40, 8);
        this.helmetTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.helmetTop.addBox(-2.0F, -3.8F, -2.3F, 4, 1, 4, 0.0F);
        this.helmetStem = new ModelRenderer(this, 46, 5);
        this.helmetStem.setRotationPoint(0.0F, -3.3F, -2.1F);
        this.helmetStem.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(helmetStem, -0.17453292519943295F, 0.0F, 0.0F);
        this.helmetCrest = new ModelRenderer(this, 43, 0);
        this.helmetCrest.setRotationPoint(0.0F, -3.3F, -2.1F);
        this.helmetCrest.addBox(-2.0F, -4.8F, -0.51F, 4, 4, 1, 0.0F);
        this.setRotateAngle(helmetCrest, -0.17453292519943295F, 0.0F, 0.0F);

        this.checkTuffLftTop = new ModelRenderer(this, 18, 12);
        this.checkTuffLftTop.setRotationPoint(1.9F, -0.1F, -0.5F);
        this.checkTuffLftTop.addBox(-1.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(checkTuffLftTop, 0.0F, -0.4363323129985824F, 0.3490658503988659F);
        this.checkTuffLftBot = new ModelRenderer(this, 17, 15);
        this.checkTuffLftBot.setRotationPoint(1.9F, 0.4F, -0.5F);
        this.checkTuffLftBot.addBox(-1.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(checkTuffLftBot, 0.0F, -0.5235987755982988F, 0.7330382858376184F);
        this.checkTuffLftFnt = new ModelRenderer(this, 17, 18);
        this.checkTuffLftFnt.setRotationPoint(1.5F, 0.9F, -1.6F);
        this.checkTuffLftFnt.addBox(-0.5F, -0.5F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(checkTuffLftFnt, 0.17453292519943295F, 0.0F, -0.2617993877991494F);
        this.checkTuffRtTop = new ModelRenderer(this, 0, 12);
        this.checkTuffRtTop.setRotationPoint(-1.9F, -0.1F, -0.5F);
        this.checkTuffRtTop.addBox(-3.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotateAngle(checkTuffRtTop, 0.0F, 0.4363323129985824F, -0.3490658503988659F);
        this.checkTuffRtBot = new ModelRenderer(this, 3, 15);
        this.checkTuffRtBot.setRotationPoint(-1.9F, 0.4F, -0.5F);
        this.checkTuffRtBot.addBox(-2.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(checkTuffRtBot, 0.0F, 0.5235987755982988F, -0.7330382858376184F);
        this.checkTuffRtFnt = new ModelRenderer(this, 7, 18);
        this.checkTuffRtFnt.setRotationPoint(-1.5F, 0.9F, -1.6F);
        this.checkTuffRtFnt.addBox(-0.5F, -0.5F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(checkTuffRtFnt, 0.17453292519943295F, 0.0F, 0.2617993877991494F);

        this.earLftJoint = new ModelRenderer(this, 0, 0);
        this.earLftJoint.setRotationPoint(1.7F, -3.0F, 0.0F);
        this.earLftJoint.addBox(-1.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earLftJoint, 0.0F, 0.0F, 0.2617993877991494F);
        this.earLft = new ModelRenderer(this, 19, 2);
        this.earLft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earLft.addBox(-1.0F, -2.0F, -0.5F, 2, 3, 1, 0.0F);
        this.earLftTip = new ModelRenderer(this, 20, 0);
        this.earLftTip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earLftTip.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.earRtJoint = new ModelRenderer(this, 0, 0);
        this.earRtJoint.setRotationPoint(-1.7F, -3.0F, 0.0F);
        this.earRtJoint.addBox(-1.0F, -2.0F, -0.5F, 0, 0, 0, 0.0F);
        this.setRotateAngle(earRtJoint, 0.0F, 0.0F, -0.2617993877991494F);
        this.earRt = new ModelRenderer(this, 3, 2);
        this.earRt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earRt.addBox(-1.0F, -2.0F, -0.5F, 2, 3, 1, 0.0F);
        this.earRtTip = new ModelRenderer(this, 4, 0);
        this.earRtTip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.earRtTip.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);

        this.tail1Joint = new ModelRenderer(this, 0, 0);
        this.tail1Joint.setRotationPoint(0.0F, -1.3F, 3.9F);
        this.tail1Joint.addBox(-0.5F, -0.5F, -0.5F, 0, 0, 0, 0.0F);
        this.tail1 = new ModelRenderer(this, 48, 48);
        this.tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 2, 0.0F);
        this.tail2Joint = new ModelRenderer(this, 0, 0);
        this.tail2Joint.setRotationPoint(0.0F, 0.0F, 1.4F);
        this.tail2Joint.addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.tail2 = new ModelRenderer(this, 48, 45);
        this.tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail2.addBox(-0.5F, -0.5F, -0.2F, 1, 1, 2, 0.0F);
        this.tail3Joint = new ModelRenderer(this, 0, 0);
        this.tail3Joint.setRotationPoint(0.0F, 0.0F, 1.4F);
        this.tail3Joint.addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.tail3 = new ModelRenderer(this, 47, 41);
        this.tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail3.addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
        this.tail4Joint = new ModelRenderer(this, 0, 0);
        this.tail4Joint.setRotationPoint(0.0F, 0.0F, 1.4F);
        this.tail4Joint.addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.tail4 = new ModelRenderer(this, 47, 37);
        this.tail4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail4.addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
        this.tail5Joint = new ModelRenderer(this, 0, 0);
        this.tail5Joint.setRotationPoint(0.0F, 0.0F, 1.4F);
        this.tail5Joint.addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.tail5 = new ModelRenderer(this, 47, 33);
        this.tail5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail5.addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
        this.tail6Joint = new ModelRenderer(this, 0, 0);
        this.tail6Joint.setRotationPoint(0.0F, 0.0F, 1.4F);
        this.tail6Joint.addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.tail6 = new ModelRenderer(this, 47, 29);
        this.tail6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail6.addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);
        this.tail7Joint = new ModelRenderer(this, 0, 0);
        this.tail7Joint.setRotationPoint(0.0F, 0.0F, 1.4F);
        this.tail7Joint.addBox(-0.5F, -0.5F, -0.2F, 0, 0, 0, 0.0F);
        this.tail7 = new ModelRenderer(this, 47, 25);
        this.tail7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail7.addBox(-1.0F, -1.0F, -0.3F, 2, 2, 2, 0.0F);

        this.tailTipLftTop = new ModelRenderer(this, 56, 30);
        this.tailTipLftTop.setRotationPoint(0.4F, -0.4F, 1.3F);
        this.tailTipLftTop.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipLftTop, 0.3490658503988659F, 0.3490658503988659F, 0.0F);
        this.tailTipRtTop = new ModelRenderer(this, 40, 30);
        this.tailTipRtTop.setRotationPoint(-0.4F, -0.4F, 1.3F);
        this.tailTipRtTop.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipRtTop, 0.3490658503988659F, -0.3490658503988659F, 0.0F);
        this.tailTipLftBot = new ModelRenderer(this, 56, 34);
        this.tailTipLftBot.setRotationPoint(0.4F, 0.4F, 1.3F);
        this.tailTipLftBot.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipLftBot, -0.3490658503988659F, 0.3490658503988659F, 0.0F);
        this.tailTipRtBot = new ModelRenderer(this, 40, 34);
        this.tailTipRtBot.setRotationPoint(-0.4F, 0.4F, 1.3F);
        this.tailTipRtBot.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(tailTipRtBot, -0.3490658503988659F, -0.3490658503988659F, 0.0F);
        
        
        
        this.armorFlapBckLftJoint.addChild(this.armorFlapBckLftMid);
        this.armorFlapFntRtJoint.addChild(this.armorFlapFntRtMid);
        this.armorFlapBckRtJoint.addChild(this.armorFlapBckRtMid);
        this.head.addChild(this.nose);
        this.tail7.addChild(this.tailTipRtBot);
        this.head.addChild(this.checkTuffRtBot);
        this.body.addChild(this.legFntLft1);
        this.tail7.addChild(this.tailTipLftBot);
        this.armorFlapFntLftJoint.addChild(this.armorFlapFntLft);
        this.tail7.addChild(this.tailTipRtTop);
        this.armorFlapFntRtJoint.addChild(this.armorFlapFntRt);
        this.tail4Joint.addChild(this.tail4);
        this.head.addChild(this.helmetCrest);
        this.neck.addChild(this.bell1);
        this.earRtJoint.addChild(this.earRt);
        this.armorFlapBckRtJoint.addChild(this.armorFlapBckRtTip);
        this.head.addChild(this.muzzle);
        this.head.addChild(this.helmetSideRtBot);
        this.body.addChild(this.armorFlapFntLftJoint);
        this.head.addChild(this.checkTuffLftTop);
        this.body.addChild(this.armorFlapBckLftJoint);
        this.tail1Joint.addChild(this.tail1);
        this.head.addChild(this.checkTuffLftBot);
        this.head.addChild(this.helmetStem);
        this.headJoint.addChild(this.head);
        this.head.addChild(this.helmetSideRtTop);
        this.head.addChild(this.checkTuffRtFnt);
        this.tail3.addChild(this.tail4Joint);
        this.body.addChild(this.legFntRt1);
        this.armorFlapFntRtJoint.addChild(this.armorFlapFntRtTip);
        this.tail6Joint.addChild(this.tail6);
        this.earLftJoint.addChild(this.earLftTip);
        this.legBckLft1.addChild(this.legBckLft2);
        this.body.addChild(this.armorFlapBckRtJoint);
        this.head.addChild(this.helmetBack);
        this.body.addChild(this.armorFlapFntRtJoint);
        this.tail2Joint.addChild(this.tail2);
        this.body.addChild(this.legBckLft1);
        this.tail7.addChild(this.tailTipLftTop);
        this.head.addChild(this.earLftJoint);
        this.neck.addChild(this.bell2);
        this.head.addChild(this.helmetSideLftBot);
        this.legFntRt1.addChild(this.legFntRt2);
        this.body.addChild(this.neckJoint);
        this.armorFlapFntLftJoint.addChild(this.armorFlapFntLftMid);
        this.head.addChild(this.helmet);
        this.head.addChild(this.helmetTop);
        this.legFntLft1.addChild(this.legFntLft2);
        this.neckJoint.addChild(this.neck);
        this.armorFlapBckRtJoint.addChild(this.armorFlapBckRt);
        this.neck.addChild(this.headJoint);
        this.tail5.addChild(this.tail6Joint);
        this.tail5Joint.addChild(this.tail5);
        this.earLftJoint.addChild(this.earLft);
        this.head.addChild(this.checkTuffRtTop);
        this.earRtJoint.addChild(this.earRtTip);
        this.tail6.addChild(this.tail7Joint);
        this.body.addChild(this.legBckRt1);
        this.tail3Joint.addChild(this.tail3);
        this.tail1.addChild(this.tail2Joint);
        this.armorFlapFntLftJoint.addChild(this.armorFlapFntLftTip);
        this.head.addChild(this.checkTuffLftFnt);
        this.body.addChild(this.tail1Joint);
        this.armorFlapBckLftJoint.addChild(this.armorFlapBckLftTip);
        this.head.addChild(this.helmetSideLftTop);
        this.tail7Joint.addChild(this.tail7);
        this.tail4.addChild(this.tail5Joint);
        this.head.addChild(this.earRtJoint);
        this.armorFlapBckLftJoint.addChild(this.armorFlapBckLft);
        this.tail2.addChild(this.tail3Joint);
        this.legBckRt1.addChild(this.legBckRt2);
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