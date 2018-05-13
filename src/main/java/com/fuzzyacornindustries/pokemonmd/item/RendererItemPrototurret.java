package com.fuzzyacornindustries.pokemonmd.item;

import com.fuzzyacornindustries.pokemonmd.model.block.ModelPrototurretBlock;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityPrototurret;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RendererItemPrototurret implements IItemRenderer
{
	private ModelPrototurretBlock model;

	public RendererItemPrototurret()
	{
		model = new ModelPrototurretBlock();
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityPrototurret(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}