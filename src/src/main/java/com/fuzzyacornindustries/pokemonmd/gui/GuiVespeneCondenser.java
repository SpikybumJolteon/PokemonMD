package com.fuzzyacornindustries.pokemonmd.gui;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.container.ContainerVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiVespeneCondenser extends GuiContainer
{
	private static final ResourceLocation guiTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/guis/vespenecondensergui.png");

	public TileEntityVespeneCondenser vespeneCondenser;

	public static final int cookIconWidth = 26;
	public static final int cookIconHeight = 17;
	public static final int cookIconStartX = 176;
	public static final int cookIconStartY = 0;
	public static final int cookIconDrawX = 75;
	public static final int cookIconDrawY = 36;

	public GuiVespeneCondenser(InventoryPlayer inventoryPlayer, TileEntityVespeneCondenser tileEntity) 
	{
		super(new ContainerVespeneCondenser(inventoryPlayer, tileEntity));

		this.vespeneCondenser = tileEntity;

		// Main Window Size
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String name = this.vespeneCondenser.hasCustomInventoryName() ? this.vespeneCondenser.getInventoryName() : I18n.format(this.vespeneCondenser.getInventoryName(), new Object[0]);

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

		k = this.vespeneCondenser.getCookProgressScaled(cookIconWidth);
		this.drawTexturedModalRect(guiLeft + cookIconDrawX, guiTop + cookIconDrawY, 
				cookIconStartX, cookIconStartY, 
				k, cookIconHeight);
		
		/*
		System.out.println( "Test Cook Time Code" );
		System.out.println( Integer.toString( k ) );
		*/
	}
}