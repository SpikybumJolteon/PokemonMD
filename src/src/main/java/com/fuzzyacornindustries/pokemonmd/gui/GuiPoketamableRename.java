package com.fuzzyacornindustries.pokemonmd.gui;

import java.text.DecimalFormat;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityOkamiEspeon;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.item.tamable.ItemPoketamableSummon;
import com.fuzzyacornindustries.pokemonmd.network.client.PoketamableNamePacket;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

/*
 * This class is heavily referenced from atomicstrykers'
 * Pet Bat modification.
 */
public class GuiPoketamableRename extends GuiScreen
{
	private final String screenTitle;
	private final ItemStack poketamableItemStack;
	private GuiTextField textfield;

	private double maxHealth;
	private double health;
	private float attackStrength;

	private boolean hasFireImmunityEssence;
	private boolean hasDrowningImmunityEssence;
	private boolean hasFallImmunityEssence;
	private boolean hasBlockSuffocationAvoidanceEssence;
	private boolean hasToxinImmunityEssence;

	public GuiPoketamableRename(ItemStack stack)
	{
		poketamableItemStack = stack;
		screenTitle = "Poketamable Information";

		maxHealth = (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("pokemonmd").getFloat("maxhealth") != 0) ? stack.getTagCompound().getCompoundTag("pokemonmd").getFloat("maxhealth") : 0F;
		health = (stack.getTagCompound() != null && stack.stackTagCompound.getCompoundTag("display").getString("Name") != "") ? stack.getTagCompound().getCompoundTag("pokemonmd").getFloat("health") : 0F;
		attackStrength = (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("pokemonmd").getFloat("attackpower") != 0) ? stack.getTagCompound().getCompoundTag("pokemonmd").getFloat("attackpower") : 0F;

		hasFireImmunityEssence = (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("pokemonmd").getInteger("fireimmunity") == 1) ? true : false;
		hasDrowningImmunityEssence = (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("pokemonmd").getInteger("drowningimmunity") == 1) ? true : false;
		hasFallImmunityEssence = (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("pokemonmd").getInteger("fallimmunity") == 1) ? true : false;
		hasBlockSuffocationAvoidanceEssence = (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("pokemonmd").getInteger("blocksuffocationavoidance") == 1) ? true : false;
		hasToxinImmunityEssence = (stack.getTagCompound() != null && stack.getTagCompound().getCompoundTag("pokemonmd").getInteger("toxinimmunity") == 1) ? true : false;

	}

	@Override
	public void initGui()
	{
		super.initGui();
		Keyboard.enableRepeatEvents(true);

		textfield = new GuiTextField(fontRendererObj, this.width / 2 - 75, 60, 150, 20);
		textfield.setTextColor(-1);
		textfield.setMaxStringLength(30);
		textfield.setFocused(true);
		textfield.setText(ItemPoketamableSummon.getPoketamableNameFromItemStack(poketamableItemStack));
	}

	@Override
	public void onGuiClosed()
	{
		super.onGuiClosed();

		Keyboard.enableRepeatEvents(false);
	}

	@Override
	protected void keyTyped(char par1, int par2)
	{
		if (textfield.textboxKeyTyped(par1, par2))
		{
			if (!textfield.getText().equals(""))
			{
				PokemonMDMain.modInstance.networkHelper.sendPacketToServer(new PoketamableNamePacket(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), textfield.getText()));
			}
		}
		else
		{
			super.keyTyped(par1, par2);
		}
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		this.textfield.mouseClicked(par1, par2, par3);
	}

	@Override
	public void updateScreen()
	{
		textfield.updateCursorCounter();
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		this.drawDefaultBackground();

		int x = this.width / 2;
		this.drawCenteredString(this.fontRendererObj, this.screenTitle, x, 40, 0x0000AA);

		DecimalFormat df = new DecimalFormat("#.##");

		int y = 100;
		drawCenteredString(fontRendererObj, (EnumChatFormatting.BOLD + "Health "
				+ EnumChatFormatting.RESET + df.format(health) + " / " + df.format(maxHealth)), x, y, 0xFFFFFF);
		y += 12;
		drawCenteredString(fontRendererObj, (EnumChatFormatting.BOLD + "Attack Power "
				+ EnumChatFormatting.RESET + df.format(attackStrength)), x, y, 0xFFFFFF);
		y += 12;

		if(this.hasFireImmunityEssence || this.hasDrowningImmunityEssence || this.hasFallImmunityEssence || this.hasBlockSuffocationAvoidanceEssence)
		{	
			y += 12;
			drawCenteredString(fontRendererObj, (EnumChatFormatting.BOLD + "Essences Possessed"), x, y, 0xFFFFFF);
			
			if(this.hasBlockSuffocationAvoidanceEssence)
			{
				y += 12;
				drawCenteredString(fontRendererObj, ("-Block Suffocation Avoidance"), x, y, 0xbe802a);
			}

			if(this.hasDrowningImmunityEssence)
			{
				y += 12;
				drawCenteredString(fontRendererObj, ("-Drowning Immunity"), x, y, 0x449bff);
			}

			if(this.hasFallImmunityEssence)
			{
				y += 12;
				drawCenteredString(fontRendererObj, ("-Fall Damage Immunity"), x, y, 0xe324ff);
			}

			if(this.hasFireImmunityEssence)
			{
				y += 12;
				drawCenteredString(fontRendererObj, ("-Fire Immunity"), x, y, 0xffbb00);
			}

			if(this.hasToxinImmunityEssence)
			{
				y += 12;
				drawCenteredString(fontRendererObj, ("-Poison & Wither Immunity"), x, y, 0x59cd01);
			}
		}

		GL11.glPushMatrix();
		GL11.glTranslatef((float) (this.width / 2), 0.0F, 50.0F);
		float var4 = 93.75F;
		GL11.glScalef(-var4, -var4, -var4);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glPopMatrix();
		textfield.drawTextBox();
		super.drawScreen(par1, par2, par3);
	}
}