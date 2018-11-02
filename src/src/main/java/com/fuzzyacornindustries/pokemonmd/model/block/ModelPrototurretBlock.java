package com.fuzzyacornindustries.pokemonmd.model.block;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class ModelPrototurretBlock extends ModelBase 
{
	public ModelRenderer turretCenterJoint;

	public ModelRenderer barrelBase;

	public ModelRenderer barrelBaseTop;

	public ModelRenderer barrelMainJoint;
	public ModelRenderer barrelMain;

	public ModelRenderer panelsJoint;

	public ModelRenderer panel[] = new ModelRenderer[4];

	public ModelPrototurretBlock() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.turretCenterJoint = new ModelRenderer(this, 0, 0);
		this.turretCenterJoint.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.turretCenterJoint.addBox(-2.0F, -3.2F, -1.0F, 0, 0, 0, 0.0F);

		this.barrelBase = new ModelRenderer(this, 0, 0);
		this.barrelBase.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrelBase.addBox(-2.0F, -3.2F, -1.0F, 4, 3, 2, 0.0F);
		this.barrelBase.setTextureOffset(0, 6).addBox(-1.0F, -3.2F, -2.0F, 2, 2, 1, 0.0F); // barrelBaseFront
		this.barrelBase.setTextureOffset(0, 10).addBox(-1.0F, -3.2F, 1.0F, 2, 3, 1, 0.0F); // barrelBaseBack
		this.barrelBase.setTextureOffset(7, 11).addBox(-1.0F, -3.2F, 2.0F, 2, 2, 2, 0.0F); // barrelBaseBackFar

		this.barrelBaseTop = new ModelRenderer(this, 7, 6);
		this.barrelBaseTop.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.barrelBaseTop.addBox(-1.0F, -2.5F, -0.5F, 2, 3, 1, 0.0F);
		this.setRotateAngle(barrelBaseTop, -0.6981317007977318F, -0.0F, 0.0F);

		this.barrelMainJoint = new ModelRenderer(this, 44, 22);
		this.barrelMainJoint.setRotationPoint(0.0F, -2.5F, 0.0F);
		this.barrelMainJoint.addBox(-0.5F, -0.5F, -7.5F, 0, 0, 0, 0.0F);
		this.barrelMain = new ModelRenderer(this, 44, 22);
		this.barrelMain.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.barrelMain.addBox(-0.5F, -0.5F, -7.5F, 1, 1, 9, 0.0F);
		this.barrelMain.setTextureOffset(42, 25).addBox(-1.0F, -0.7F, -6.8F, 2, 2, 3, 0.0F); // barrelPump

		this.panelsJoint = new ModelRenderer(this, 58, 0);
		this.panelsJoint.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.panelsJoint.addBox(-1.0F, 0.3F, -2.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(panelsJoint, -0.0029670597283903604F, -0.027401669256310976F, 0.0F);

		int panelNumber = 0;
		this.panel[panelNumber] = new ModelRenderer(this, 58, 0); // panel1
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, 3.141592653589793F, 0.0F);
		panelNumber++;
		this.panel[panelNumber] = new ModelRenderer(this, 51, 0); // panel2
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, 1.5707963267948966F, 0.0F);
		panelNumber++;
		this.panel[panelNumber] = new ModelRenderer(this, 44, 0); // panel3
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, 0.0F, 0.0F);
		panelNumber++;
		this.panel[panelNumber] = new ModelRenderer(this, 37, 0); // panel4
		this.panel[panelNumber].setRotationPoint(0.0F, 0.5F, 0.0F);
		this.panel[panelNumber].addBox(-1.0F, 1.0F, -2.0F, 2, 3, 1, 0.0F);
		this.setRotateAngle(panel[panelNumber], -0.3490658503988659F, -1.5707963267948966F, 0.0F);

		this.turretCenterJoint.addChild(this.barrelBase);
		this.turretCenterJoint.addChild(this.barrelBaseTop);

		this.barrelBase.addChild(this.barrelMainJoint);
		this.barrelMainJoint.addChild(this.barrelMain);

		this.turretCenterJoint.addChild(this.panelsJoint);

		for(int i = 0; i < panel.length; i++)
		{
			this.panelsJoint.addChild(this.panel[i]);
		}
	}

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    {
        this.turretCenterJoint.render(f5);
    }
    
    public void renderModel(float f, TileEntity tileEntity)
	{	
        this.turretCenterJoint.render(f);
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