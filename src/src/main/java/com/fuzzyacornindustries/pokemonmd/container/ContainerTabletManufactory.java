package com.fuzzyacornindustries.pokemonmd.container;

import com.fuzzyacornindustries.pokemonmd.item.ItemClayTablet;
import com.fuzzyacornindustries.pokemonmd.item.VespeneFuel;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityTabletManufactory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerTabletManufactory extends Container 
{
	private TileEntityTabletManufactory tabletManufactory;

	/* How long time left before finished manufacturing */
	public int lastManufactureTime;

	static int slotSize = 18;

	/* Tablet Item Slot */
	public static int tabletItemSlotID;
	public static final int tabletItemSlotX = 50;
	public static final int tabletItemSlotY = 23;

	/* Fuel Item Slot */
	public static int fuelItemSlotID;
	public static final int fuelItemSlotX = 50;
	public static final int fuelItemSlotY = 44;

	/* Side Item Slots */
	public static int[] sideItemSlotID = new int[6];
	public static final int sideItemsLftColumnX = 27;
	public static final int sideItemsRtColumnX = 73;
	public static final int sideItemsRow1Y = 16;
	public static final int sideItemsRow2Y = sideItemsRow1Y + slotSize;
	public static final int sideItemsRow3Y = sideItemsRow2Y + slotSize;

	/* Product Item Slot */
	public static int productItemSlotID;
	public static final int productItemSlotX = 134;
	public static final int productItemSlotY = 34;

	public ContainerTabletManufactory(InventoryPlayer inventory, TileEntityTabletManufactory tileEntity)
	{
		this.tabletManufactory = tileEntity;
        tileEntity.manufacturingCraftingMatrix.eventHandler = this;

		tabletItemSlotID = TileEntityTabletManufactory.slotTabletItemID;
		fuelItemSlotID = TileEntityTabletManufactory.slotFuelItemID;
		productItemSlotID = TileEntityTabletManufactory.slotProductItemID;
		
		for(int i = 0; i < sideItemSlotID.length; i++)
		{
			sideItemSlotID[i] = TileEntityTabletManufactory.slotSideItemsItemID[i];
		}

		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, sideItemSlotID[0], sideItemsLftColumnX, sideItemsRow1Y));
		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, tabletItemSlotID, tabletItemSlotX, tabletItemSlotY));
		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, sideItemSlotID[1], sideItemsRtColumnX, sideItemsRow1Y));
		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, sideItemSlotID[2], sideItemsLftColumnX, sideItemsRow2Y));
		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, fuelItemSlotID, fuelItemSlotX, fuelItemSlotY));
		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, sideItemSlotID[3], sideItemsRtColumnX, sideItemsRow2Y));
		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, sideItemSlotID[4], sideItemsLftColumnX, sideItemsRow3Y));
		this.addSlotToContainer(new Slot(tileEntity.manufacturingCraftingMatrix, sideItemSlotID[5], sideItemsRtColumnX, sideItemsRow3Y));

		this.addSlotToContainer(new SlotFurnace(inventory.player, tileEntity, productItemSlotID, productItemSlotX, productItemSlotY));

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

		icrafting.sendProgressBarUpdate(this, tabletItemSlotID, this.tabletManufactory.manufactureTime);
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for(int i = 0; i < this.crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if(this.lastManufactureTime != this.tabletManufactory.manufactureTime)
			{
				icrafting.sendProgressBarUpdate(this, tabletItemSlotID, this.tabletManufactory.manufactureTime);
			}
		}

		this.lastManufactureTime = this.tabletManufactory.manufactureTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slotNumber, int newValue)
	{
		if(slotNumber == tabletItemSlotID) this.tabletManufactory.manufactureTime = newValue;
	}

    @Override
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        super.onCraftMatrixChanged(par1IInventory);
        this.tabletManufactory.updateInput();
    }
    
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber)
	{
		ItemStack itemStack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotNumber);

		int firstInventorySlot = this.productItemSlotID + 1;
		int inventoryRowLength = 9;
		int inventoryStorageLength = inventoryRowLength * 3;
		int inventoryTotalLength = inventoryRowLength * 4;
		
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();

			if(slotNumber == this.productItemSlotID)
			{
				if(!this.mergeItemStack(itemStack1, firstInventorySlot, firstInventorySlot + inventoryTotalLength, true))
				{
					return null;
				}

				slot.onSlotChange(itemStack1, itemStack);
			}	
			else if(slotNumber >= firstInventorySlot)
			{
				/*
				if(itemStack1.getItem() instanceof ItemClayTablet)
				{
					if(!this.mergeItemStack(itemStack1, this.tabletItemSlotID, this.tabletItemSlotID + 1, false))
					{
						return null;
					}
				}
				else if(itemStack1.getItem() instanceof VespeneFuel)
				{
					if(!this.mergeItemStack(itemStack1, this.fuelItemSlotID, this.fuelItemSlotID + 1, false))
					{	
						return null;
					}
				}
				*/
				if(slotNumber >= firstInventorySlot && slotNumber < firstInventorySlot + inventoryStorageLength - 1)
				{
					if(!this.mergeItemStack(itemStack1, firstInventorySlot + inventoryStorageLength, firstInventorySlot + inventoryTotalLength - 1, false))
					{
						return null;
					}
				}
				else if(slotNumber >= firstInventorySlot + inventoryStorageLength && slotNumber < firstInventorySlot + inventoryTotalLength - 1)
				{
					if(!this.mergeItemStack(itemStack1, firstInventorySlot, firstInventorySlot + inventoryStorageLength, false))
					{
						return null;
					}
				}
			}
			else if(!this.mergeItemStack(itemStack1, firstInventorySlot, firstInventorySlot + inventoryTotalLength - 1, false))
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
		return this.tabletManufactory.isUseableByPlayer(player);
	}
}