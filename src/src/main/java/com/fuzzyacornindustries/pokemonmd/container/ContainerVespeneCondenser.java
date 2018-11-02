package com.fuzzyacornindustries.pokemonmd.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerVespeneCondenser extends Container 
{
	private TileEntityVespeneCondenser vespeneCondenser;

	/* How long time left before finished cooking*/
	public int lastCookTime;

	/* Smelt Item Slot */
	public static final int smeltItemSlotX = 55;
	public static final int smeltItemSlotY = 37;

	/* Smelt Item Slot */
	public static final int productItemSlotX = 105;
	public static final int productItemSlotY = 37;

	public ContainerVespeneCondenser(InventoryPlayer inventory, TileEntityVespeneCondenser tileEntity)
	{
		this.vespeneCondenser = tileEntity;

		this.addSlotToContainer(new Slot(tileEntity, TileEntityVespeneCondenser.getSlotSmeltItemID(), smeltItemSlotX, smeltItemSlotY));
		this.addSlotToContainer(new SlotVespeneCondenserOutput(inventory.player, tileEntity, TileEntityVespeneCondenser.slotEnum.OUTPUT_SLOT.ordinal(), productItemSlotX, productItemSlotY));

		int slotSize = 18;

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * slotSize, 84 + i * slotSize));
			}
		}

		for(int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * slotSize, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting icrafting)
	{
		super.addCraftingToCrafters(icrafting);

		icrafting.sendProgressBarUpdate(this, TileEntityVespeneCondenser.slotEnum.INPUT_SLOT.ordinal(), this.vespeneCondenser.cookTime);
	}

	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for(int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if(this.lastCookTime != this.vespeneCondenser.cookTime)
			{
				icrafting.sendProgressBarUpdate(this, TileEntityVespeneCondenser.getSlotSmeltItemID(), this.vespeneCondenser.cookTime);
			}
		}

		this.lastCookTime = this.vespeneCondenser.cookTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slotNumber, int newValue)
	{
		if(slotNumber == TileEntityVespeneCondenser.slotEnum.INPUT_SLOT.ordinal()) this.vespeneCondenser.cookTime = newValue;
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber)
	{
		ItemStack itemStack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotNumber);

		if(slot != null && slot.getHasStack())
		{
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();

			if(slotNumber == TileEntityVespeneCondenser.slotEnum.OUTPUT_SLOT.ordinal())
			{
				if(!this.mergeItemStack(itemStack1, 2, 38, true))
				{
					return null;
				}

				slot.onSlotChange(itemStack1, itemStack);
			}	
			else if(slotNumber != TileEntityVespeneCondenser.slotEnum.INPUT_SLOT.ordinal())
			{
				if(RecipesVespeneCondenser.instance().getCondensingResult(itemStack1) != null)
				{
					if(!this.mergeItemStack(itemStack1, 0, 1, false))
					{
						return null;
					}
				}
				else if(slotNumber >= 2 && slotNumber < 29)
				{
					if(!this.mergeItemStack(itemStack1, 29, 38, false))
					{
						return null;
					}
				}
				else if(slotNumber >= 29 && slotNumber < 38)
				{
					if(!this.mergeItemStack(itemStack1, 2, 29, false))
					{
						return null;
					}
				}
			}
			else if(!this.mergeItemStack(itemStack1, 2, 38, false))
			{
				return null;
			}
			
			if(itemStack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if(itemStack1.stackSize == itemStack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemStack1);
		}

		return itemStack;
	}

	public boolean canInteractWith(EntityPlayer player) 
	{
		return this.vespeneCondenser.isUseableByPlayer(player);
	}
}