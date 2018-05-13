package com.fuzzyacornindustries.pokemonmd.gui;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.container.ContainerVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiVerdantPurifier extends GuiContainer
{
	private static final ResourceLocation verdantPurifierGuiTextures = new ResourceLocation(ModInfo.MODID + ":" +"textures/guis/verdantpurifiergui.png");
	
	private TileEntityVerdantPurifier tileVerdantPurifier;
	
	public GuiVerdantPurifier(InventoryPlayer invPlayer, TileEntityVerdantPurifier tile)
	{
		super(new ContainerVerdantPurifier(invPlayer, tile));
		this.tileVerdantPurifier = tile;
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String string = this.tileVerdantPurifier.hasCustomInventoryName() ? this.tileVerdantPurifier.getInventoryName() : I18n.format(this.tileVerdantPurifier.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(verdantPurifierGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		
		if (this.tileVerdantPurifier.isPurifying())
		{
			i1 = this.tileVerdantPurifier.getPurificationTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}
		
		i1 = this.tileVerdantPurifier.getPurificationProgressScaled(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}
}