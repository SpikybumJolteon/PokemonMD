package com.fuzzyacornindustries.pokemonmd.renderer.block;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.model.block.ModelPrototurretBlock;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RendererPrototurret extends TileEntitySpecialRenderer
{
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" +"textures/blocks/prototurret.png");
	private ModelPrototurretBlock model;
	
	public RendererPrototurret()
	{
		this.model = new ModelPrototurretBlock();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 180F, 0F, 1F);
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F, tileEntity);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}