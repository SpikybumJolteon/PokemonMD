package com.fuzzyacornindustries.pokemonmd.gui;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.container.ContainerTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityTabletManufactory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiTabletManufactory extends GuiContainer
{
	private static final ResourceLocation guiTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/guis/tabletmanufactorygui.png");

	private TileEntityTabletManufactory tabletManufactory;

	public static final int manufactureIconWidth = 45;
	public static final int manufactureIconHeight = 25;
	public static final int manufactureIconStartX = 176;
	public static final int manufactureIconStartY = 0;
	public static final int manufactureIconDrawX = 89;
	public static final int manufactureIconDrawY = 32;
	
	public GuiTabletManufactory(InventoryPlayer inventoryPlayer, TileEntityTabletManufactory tileEntity) 
	{
		super(new ContainerTabletManufactory(inventoryPlayer, tileEntity));

		this.tabletManufactory = tileEntity;

		// Main Window Size
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String name = this.tabletManufactory.hasCustomInventoryName() ? this.tabletManufactory.getInventoryName() : I18n.format(this.tabletManufactory.getInventoryName(), new Object[0]);

		int pixelsFromTop = 6;
		int fontColor = 4210752; // White

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, pixelsFromTop, fontColor);

		int pixelsFromImageLeftSide = 8;
		int pixelsFromImageBottomToAboveInventory = 94 - 2;

		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), pixelsFromImageLeftSide, this.ySize - pixelsFromImageBottomToAboveInventory, fontColor);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);

		this.mc.getTextureManager().bindTexture(guiTexture);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);

		int k;

		k = this.tabletManufactory.getManufactureProgressScaled(manufactureIconWidth);
		this.drawTexturedModalRect(guiLeft + manufactureIconDrawX, guiTop + manufactureIconDrawY, 
				manufactureIconStartX, manufactureIconStartY, 
				k, manufactureIconHeight);
	}
}