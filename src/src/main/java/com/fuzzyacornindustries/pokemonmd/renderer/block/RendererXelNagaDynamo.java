package com.fuzzyacornindustries.pokemonmd.renderer.block;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.block.BlockXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.block.ModelXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaPylon;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RendererXelNagaDynamo extends TileEntitySpecialRenderer
{
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" +"textures/blocks/xelnagadynamo.png");
	private static final ResourceLocation textureGlow = new ResourceLocation(ModInfo.MODID + ":" +"textures/blocks/xelnagadynamoglows.png");
	private ModelXelNagaDynamo model;
	private ModelXelNagaDynamo modelGlow;

	public RendererXelNagaDynamo()
	{
		this.model = new ModelXelNagaDynamo();
		this.modelGlow = new ModelXelNagaDynamo();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F, (TileEntityXelNagaDynamo)tileEntity);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

		/* ************ */

		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(textureGlow);

		float f1 = 1.0F;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDisable(GL11.GL_LIGHTING);
		char c0 = 61680;
		int j = c0 % 65536;
		int k = c0 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);

		GL11.glPushMatrix();
		this.modelGlow.renderModel(0.0625F, (TileEntityXelNagaDynamo)tileEntity);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}