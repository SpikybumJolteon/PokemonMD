package com.fuzzyacornindustries.pokemonmd.gui;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.container.ContainerPrototurret;
import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GuiPrototurret extends GuiContainer
{
	private static final ResourceLocation guiTexture = new ResourceLocation(ModInfo.MODID + ":" +"textures/guis/prototurretgui.png");

	public EntityPrototurret prototurret;

	public GuiPrototurret(InventoryPlayer inventoryPlayer, EntityPrototurret entity) 
	{
		super(new ContainerPrototurret(inventoryPlayer, entity));

		this.prototurret = entity;

		// Main Window Size
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String name = "Prototurret";

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
		/*
		int k;

		int cookIconWidth = 26;
		int cookIconHeight = 17;
		int cookIconStartX = 176;
		int cookIconStartY = 0;
		int cookIconDrawX = 75;
		int cookIconDrawY = 36;

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