package com.fuzzyacornindustries.pokemonmd.render.projectile;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.fuzzyacornindustries.pokemonmd.entity.projectile.EntityBlightOoze;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBlightOoze extends Render
{
	private static final ResourceLocation projectileTexture = new ResourceLocation(ModInfo.MODID + ":" + "textures/projectiles/blightooze.png");
	
    public RenderBlightOoze()
    {
        this.shadowSize = 0F;
        this.shadowOpaque = 0F;
    }

    public void doRender(EntityBlightOoze particleEntity, double parX, double parY, double parZ, float p_76986_8_, float partialTickTime)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)parX, (float)parY, (float)parZ);
        this.bindEntityTexture(particleEntity);
        
        // Seems to determine what percentage of texture
        // fills up the square area dedicated to particle
        float texturePortionXStart = 0F;
        float texturePortionXEnd = 1F;
        float texturePortionYStart = 0F;
        float texturePortionYEnd = 1F;
        
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.25F;
        
        int particleBrightness = particleEntity.getBrightnessForRender(partialTickTime);
        
        int k = particleBrightness % 65536;
        int l = particleBrightness / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)k / 1.0F, (float)l / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        float f10 = 255.0F;
        int i1 = (int)f10;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        
        float particleScale = 0.8F;
        GL11.glScalef(particleScale, particleScale, particleScale);
        
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(0.0F - f7), (double)(0.0F - f8), 0.0D, (double)texturePortionXStart, (double)texturePortionYEnd);
        tessellator.addVertexWithUV((double)(f6 - f7), (double)(0.0F - f8), 0.0D, (double)texturePortionXEnd, (double)texturePortionYEnd);
        tessellator.addVertexWithUV((double)(f6 - f7), (double)(1.0F - f8), 0.0D, (double)texturePortionXEnd, (double)texturePortionYStart);
        tessellator.addVertexWithUV((double)(0.0F - f7), (double)(1.0F - f8), 0.0D, (double)texturePortionXStart, (double)texturePortionYStart);
        tessellator.draw();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityBlightOoze particleEntity)
    {
		return projectileTexture;
    }

    protected ResourceLocation getEntityTexture(Entity particleEntity)
    {
        return this.getEntityTexture((EntityBlightOoze)particleEntity);
    }

    public void doRender(Entity particleEntity, double parX, double parY, double parZ, float p_76986_8_, float partialTickTime)
    {
        this.doRender((EntityBlightOoze)particleEntity, parX, parY, parZ, p_76986_8_, partialTickTime);
    }
}