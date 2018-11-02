package com.fuzzyacornindustries.pokemonmd.render.item;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.item.ItemBowOfKindred;
import com.fuzzyacornindustries.pokemonmd.utility.RenderUtilities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

/**
 * 
 * Renders custom bow in 1st and 3rd person
 * 
 * Parts of this code were adapted from Zelda Sword Skills,
 * which was adapted from Battlegear2's BowRenderer
 * so thanks to them for having an open-source project.
 *
 */
@SideOnly(Side.CLIENT)
public class RenderItemBowOfKindred implements IItemRenderer
{
	/** Used for default arrow rendering */
	private static final ItemStack vanillaArrow = new ItemStack(Items.arrow);

	/** Standard item scale value is 0.5F */
	private final float scale;

	public RenderItemBowOfKindred(float scale) 
	{
		this.scale = scale;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		switch (type)
		{
		case EQUIPPED_FIRST_PERSON:
			renderEquippedBow(item, (EntityLivingBase) data[1], true);
			break;
		case EQUIPPED:
			renderEquippedBow(item, (EntityLivingBase) data[1], false);
			break;
		default:
		}
	}

	private void renderEquippedBow(ItemStack stack, EntityLivingBase entity, boolean firstPerson) 
	{
		float sizeModifier = 5.5F;

		GL11.glPushMatrix();

		char c0 = 61680;
		int j = c0 % 65536;
		int k = c0 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);

		Tessellator tessellator = Tessellator.instance;

		if (entity instanceof EntityPlayer) 
		{
			float f = scale;

			f *= 1.75F;

			EntityPlayer player = (EntityPlayer) entity;

			int useDuration = player.getItemInUseDuration();


			if (!firstPerson) 
			{
				if (useDuration > 0) 
				{
					GL11.glRotated(90.0D, 0.02D, 0.01D, 0.0D);	
					GL11.glTranslatef(0F, -0.225F * scale, 0.05F * scale);
				}
				else
				{
					//GL11.glTranslated(0.1D, -0.3D, 0.2D);
					GL11.glTranslatef(-0.2F, -0.225F * scale, 0.05F * scale);
				}
			}
			else
			{
				if (useDuration > 0) 
				{
					int drawAmount = (useDuration > 17 ? 2 : (useDuration > 13 ? 1 : 0));

					GL11.glRotated(90.0D, 0.0025D, 0.005D, 0.0D);	
					GL11.glTranslatef(-0.4F - 0.03F * drawAmount, -0.1F - 0.03F * drawAmount, 0.55F);
				}
			}

			GL11.glScalef(f, f, f);

			IIcon icon = stack.getItem().getIcon(stack, 0, player, player.getItemInUse(), player.getItemInUseCount());
			ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
			/*
			if (useDuration > 0) 
			{
				int drawAmount = (useDuration > 17 ? 2 : (useDuration > 13 ? 1 : 0));

				ItemStack arrowStack = (stack.getItem() instanceof ItemBowOfKindred ? ((ItemBowOfKindred) stack.getItem()).getArrow(player) : vanillaArrow);
				ItemStack arrowStack = vanillaArrow;

				if (PokemonMDMain.isBG2Enabled) 
				{
					ItemStack quiverArrow = BattlegearEvents.getQuiverArrow(stack, player);

					if (quiverArrow != null) 
					{
						arrowStack = quiverArrow;
					}
				}

				if (arrowStack != null) 
				{
					icon = arrowStack.getIconIndex();
					GL11.glPushMatrix();

					// Thanks to BG2 team for the translation calculations:
					GL11.glTranslatef(-(-3F+drawAmount)/16F, -(-3F+drawAmount)/16F, firstPerson?-0.5F/16F:0.5F/16F);
					ItemRenderer.renderItemIn2D(tessellator, icon.getMinU(), icon.getMinV(), icon.getMaxU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
					GL11.glPopMatrix();
				}
			}*/
		} 
		else 
		{
			IIcon icon = stack.getItem().getIcon(stack, 0);
			ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
		}

		if (stack.hasEffect(0)) 
		{
			RenderUtilities.renderEnchantmentEffects(tessellator);
		}

		GL11.glPopMatrix();
	}
}