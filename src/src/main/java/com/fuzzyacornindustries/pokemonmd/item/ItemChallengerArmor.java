package com.fuzzyacornindustries.pokemonmd.item;

import com.fuzzyacornindustries.pokemonmd.ClientProxy;
import com.fuzzyacornindustries.pokemonmd.PokemonMDMain;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemChallengerArmor extends ItemArmor
{
	public String basePath = "challengerarmor/";
	public String baseName = "challenger";

	public ItemChallengerArmor(int armorIDNumber)
	{
		super(PokemonMDItem.challengerArmorMaterial, PokemonMDMain.proxy.addArmor("challengerarmor"), armorIDNumber);
		
		String pieceName;
		
		if(armorIDNumber == 0)
		{
			pieceName = baseName + "helmet";
		}
		else if(armorIDNumber == 1)
		{
			pieceName = baseName + "chestplate";
		}
		else if(armorIDNumber == 2)
		{
			pieceName = baseName + "leggings";
		}
		else
		{
			pieceName = baseName + "boots";
		}

		this.setTextureName(ModInfo.MODID + ":" + basePath + pieceName);
		this.setUnlocalizedName(pieceName);

		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel (EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		ModelBiped armorModel = ClientProxy.armorModels.get(this);
		
		if(armorModel != null)
		{
    		armorModel.bipedHead.showModel = armorSlot == 0;
    		armorModel.bipedHeadwear.showModel = false;
    		armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
    		armorModel.bipedRightArm.showModel = armorSlot == 1;
    		armorModel.bipedLeftArm.showModel = armorSlot == 1;
    		armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
    		armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
    		
    		armorModel.isSneak = entityLiving.isSneaking();
    		armorModel.isRiding = entityLiving.isRiding();
    		armorModel.isChild = entityLiving.isChild();
    		
    		armorModel.heldItemRight = 0;
    		armorModel.aimedBow = false;
    		
    		EntityPlayer player = (EntityPlayer)entityLiving;
    		
    		ItemStack held_item = player.getEquipmentInSlot(0);
    		
    		if (held_item != null){
    			armorModel.heldItemRight = 1;
    			
    			if (player.getItemInUseCount() > 0){
    				
    				EnumAction enumaction = held_item.getItemUseAction();
    				
    				if (enumaction == EnumAction.bow)
    				{
    					armorModel.aimedBow = true;
    				}
    				else if (enumaction == EnumAction.block)
    				{
    					armorModel.heldItemRight = 3;
    				}
    			}
    		}
		}
		
		return armorModel;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == PokemonMDItem.challengerHelmet || 
				stack.getItem() == PokemonMDItem.challengerChestplate || 
				stack.getItem() == PokemonMDItem.challengerBoots)
		{
			return ModInfo.MODID + ":textures/armor/challengerarmor1.png";
		}
		else if(stack.getItem() == PokemonMDItem.challengerLeggings)
		{
			return ModInfo.MODID + ":textures/armor/challengerarmor2.png";
		}
		else
		{
			return null;
		}
	}
}