package com.fuzzyacornindustries.pokemonmd.container;

import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;
import com.fuzzyacornindustries.pokemonmd.item.turret.TurretDefenseItem;
import com.fuzzyacornindustries.pokemonmd.item.turret.TurretPowerItem;
import com.fuzzyacornindustries.pokemonmd.item.turret.TurretUtilityItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPrototurret extends Container 
{
	private EntityPrototurret prototurret;

	public final int powerItemSlotX = 91;
	public final int powerItemSlotY = 38;

	public final int defenseItemSlotX = 117;
	public final int defenseItemSlotY = 38;

	public final int utilityItemSlotX = 143;
	public final int utilityItemSlotY = 38;
	
	private int numberInTurretInventory = 0;

	public final int playerToolbarInventorySize = 9;
	public final int playerSecondaryInventorySize = 27;
	public final int playerTotalInventorySize = 36;

	public ContainerPrototurret(InventoryPlayer inventory, EntityPrototurret entity)
	{
		this.prototurret = entity;

		numberInTurretInventory = 0;
		this.addSlotToContainer(new Slot(prototurret.prototurretInventory, EntityPrototurret.powerItemSlotID, powerItemSlotX, powerItemSlotY));
		numberInTurretInventory++;
		this.addSlotToContainer(new Slot(prototurret.prototurretInventory, EntityPrototurret.defenseItemSlotID, defenseItemSlotX, defenseItemSlotY));
		numberInTurretInventory++;
		this.addSlotToContainer(new Slot(prototurret.prototurretInventory, EntityPrototurret.utilityItemSlotID, utilityItemSlotX, utilityItemSlotY));
		numberInTurretInventory++;

		int slotSize = 18;
		
		int inventoryColumns = 9;
		int mainInventoryRows = 3;

		for(int i = 0; i < mainInventoryRows; i++)
		{
			for(int j = 0; j < inventoryColumns; j++)
			{
				this.addSlotToContainer(new Slot(inventory, j + i * inventoryColumns + inventoryColumns, 8 + j * slotSize, 84 + i * slotSize));
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

		//icrafting.sendProgressBarUpdate(this, smeltItemSlotID, this.vespeneCondenser.cookTime);
	}

	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber)
	{
		ItemStack itemStack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotNumber);

		if(slot != null && slot.getHasStack())
		{
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();

			if(slotNumber == EntityPrototurret.getPowerItemSlotID())
			{
				if(!this.mergeItemStack(itemStack1, numberInTurretInventory, numberInTurretInventory + playerTotalInventorySize, true))
				{
					return null;
				}

				slot.onSlotChange(itemStack1, itemStack);
			}
			else if(slotNumber == EntityPrototurret.getDefenseItemSlotID())
			{
				if(!this.mergeItemStack(itemStack1, numberInTurretInventory, numberInTurretInventory + playerTotalInventorySize, true))
				{
					return null;
				}

				slot.onSlotChange(itemStack1, itemStack);
			}	
			else if(slotNumber == EntityPrototurret.getUtilityItemSlotID())
			{
				if(!this.mergeItemStack(itemStack1, numberInTurretInventory, numberInTurretInventory + playerTotalInventorySize, true))
				{
					return null;
				}

				slot.onSlotChange(itemStack1, itemStack);
			}	
			else if(isAnEntitySlotNumber(slotNumber))
			{
				if(itemStack1.getItem() instanceof TurretPowerItem)
				{
					if(!this.mergeItemStack(itemStack1, EntityPrototurret.getPowerItemSlotID(), EntityPrototurret.getPowerItemSlotID() + 1, false))
					{
						return null;
					}
				}
				else if(itemStack1.getItem() instanceof TurretDefenseItem)
				{
					if(!this.mergeItemStack(itemStack1, EntityPrototurret.getDefenseItemSlotID(), EntityPrototurret.getDefenseItemSlotID() + 1, false))
					{
						return null;
					}
				}
				else if(itemStack1.getItem() instanceof TurretUtilityItem)
				{
					if(!this.mergeItemStack(itemStack1, EntityPrototurret.getUtilityItemSlotID(), EntityPrototurret.getUtilityItemSlotID() + 1, false))
					{
						return null;
					}
				}
				else if(slotNumber >= numberInTurretInventory && slotNumber < numberInTurretInventory + playerSecondaryInventorySize)
				{
					if(!this.mergeItemStack(itemStack1, numberInTurretInventory + playerSecondaryInventorySize, 
							numberInTurretInventory + playerTotalInventorySize, false))
					{
						return null;
					}
				}
				else if(slotNumber >= numberInTurretInventory + playerSecondaryInventorySize 
						&& slotNumber < numberInTurretInventory + playerTotalInventorySize)
				{
					if(!this.mergeItemStack(itemStack1, numberInTurretInventory, numberInTurretInventory + playerSecondaryInventorySize, false))
					{
						return null;
					}
				}
			}
			else if(!this.mergeItemStack(itemStack1, numberInTurretInventory, numberInTurretInventory + playerTotalInventorySize, false))
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
	
	@SuppressWarnings("unused")
	public boolean isAnEntitySlotNumber(int slotNumber)
	{
		for(int i = 0; i < numberInTurretInventory; i++)
		{
			if(slotNumber == i);
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean canInteractWith(EntityPlayer player) 
	{
		return true;
		//return this.prototurret.isUseableByPlayer(player);
	}
}