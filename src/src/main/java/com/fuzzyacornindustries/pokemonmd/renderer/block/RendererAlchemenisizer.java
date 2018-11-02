package com.fuzzyacornindustries.pokemonmd.renderer.block;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.block.ModelAlchemenisizer;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityAlchemenisizer;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RendererAlchemenisizer extends TileEntitySpecialRenderer
{
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" +"textures/blocks/alchemenisizer.png");
	private static final ResourceLocation textureGlow = new ResourceLocation(ModInfo.MODID + ":" +"textures/blocks/alchemenisizer_glows.png");
	private ModelAlchemenisizer model;
	private ModelAlchemenisizer modelGlow;

	public RendererAlchemenisizer()
	{
		this.model = new ModelAlchemenisizer();
		this.modelGlow = new ModelAlchemenisizer();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F, (TileEntityAlchemenisizer)tileEntity);
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
		this.modelGlow.renderModel(0.0625F, (TileEntityAlchemenisizer)tileEntity);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}