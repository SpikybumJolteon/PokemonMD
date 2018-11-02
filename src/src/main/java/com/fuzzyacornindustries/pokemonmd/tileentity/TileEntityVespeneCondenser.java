package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.BlockVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVespeneCondenser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVespeneCondenser extends TileEntity implements ISidedInventory, IAnimatedEntity
{
	private IdleAnimationClock rotationIdleAnimationClock[] = new IdleAnimationClock[4];
	private IdleAnimationClock verticalShiftIdleAnimationClock[] = new IdleAnimationClock[4];
	private IdleAnimationClock coreShiftIdleAnimationClock;

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	private String localizedName;
	
	public enum slotEnum 
    {
        INPUT_SLOT, OUTPUT_SLOT
    }
	
	private static final int[] slotsTop = new int[]{slotEnum.INPUT_SLOT.ordinal()};
	private static final int[] slotsBottom = new int[]{slotEnum.OUTPUT_SLOT.ordinal()};
	private static final int[] slotsSide = new int[]{slotEnum.OUTPUT_SLOT.ordinal()};

	private ItemStack[] slots = new ItemStack[2];

	/* How long time left before finished cooking*/
	public int cookTime;

	public TileEntityVespeneCondenser()
	{
		animationID = actionIDNone;
		animationTick = 0;
		
		setClockDefaults();
	}

	public int getSizeInventory()
	{
		return this.slots.length;
	}

	public String getInventoryName()
	{
		return this.isInventoryNameLocalized() ? this.localizedName : "Vespene Condenser";
	}

	public boolean isInventoryNameLocalized()
	{
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public void setGuiDisplayName(String displayName)
	{
		this.localizedName = displayName;
	}

	@Override
	public void updateEntity() 
	{
		boolean isBurningFlag = false;
		
		if (BlockVespeneCondenser.isPylonNearby(this.worldObj, this.xCoord, this.yCoord, this.zCoord) == true)
		{
			if (!this.worldObj.isRemote) 
			{	
				// This determines how long items smelt
				if(this.canSmelt())
				{
					this.cookTime++;

					if(this.cookTime == getItemCookTime(this.slots[slotEnum.INPUT_SLOT.ordinal()]))
					{
						this.cookTime = 0;
						this.smeltItem();
						isBurningFlag = true;
					}
					/*
				System.out.println( "Test Cook Time Code" );
				System.out.println( Integer.toString( getItemCookTime(this.slots[slotSmeltItemID]) ) );
					 */
				}
				else
				{
					this.cookTime = 0;
				}
			}

			incrementPartClocks();
		}

		if(this.canSmelt())
		{
			isBurningFlag = true;

			BlockVespeneCondenser.updateVespeneCondenserBlockState(this.canSmelt(), worldObj, this.xCoord, this.yCoord, this.zCoord);
		}

		if(isBurningFlag)
		{
			this.markDirty();
		}
	}

	@Override
	public ItemStack getStackInSlot(int slotNumber) 
	{
		return this.slots[slotNumber];
	}

	@Override
	public ItemStack decrStackSize(int slotNumber, int j) 
	{
		if(this.slots[slotNumber] != null)
		{
			ItemStack itemStack;

			if(this.slots[slotNumber].stackSize <= j)
			{
				itemStack = this.slots[slotNumber];

				this.slots[slotNumber] = null;

				return itemStack;
			}
			else
			{
				itemStack = this.slots[slotNumber].splitStack(j);

				if(this.slots[slotNumber].stackSize == 0)
				{
					this.slots[slotNumber] = null;
				}

				return itemStack;
			}
		}

		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotNumber) 
	{
		if(this.slots[slotNumber] != null)
		{
			ItemStack itemStack = this.slots[slotNumber];
			this.slots[slotNumber] = null;
			return itemStack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slotNumber, ItemStack itemStack) 
	{
		this.slots[slotNumber] = itemStack;

		if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
		{
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);

		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];

		for(int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound compound = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");

			if(b >= 0 && b < this.slots.length)
			{
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}

		this.cookTime = nbt.getInteger("CookTime");

		if(nbt.hasKey("CustomName"))
		{
			this.localizedName = nbt.getString("CustomName");
		}

	}

	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		nbt.setInteger("CookTime", (int)this.cookTime);

		NBTTagList list = new NBTTagList();

		for(int i = 0; i < this.slots.length; i++)
		{
			if(this.slots[i] != null)
			{
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}

		nbt.setTag("Items", list);

		if(this.isInventoryNameLocalized())
		{
			nbt.setString("CustomName", this.localizedName);
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) 
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub

	}

	public boolean canSmelt()
	{
		if(this.slots[slotEnum.INPUT_SLOT.ordinal()] == null)
		{
			return false;
		}
		else
		{
			ItemStack itemStack = RecipesVespeneCondenser.instance().getCondensingResult(this.slots[slotEnum.INPUT_SLOT.ordinal()]);

			if(itemStack == null)
				return false;
			if(this.slots[slotEnum.OUTPUT_SLOT.ordinal()] == null)
				return true;
			if(!this.slots[slotEnum.OUTPUT_SLOT.ordinal()].isItemEqual(itemStack))
				return false;

			int result = this.slots[slotEnum.OUTPUT_SLOT.ordinal()].stackSize + itemStack.stackSize;

			return(result <= getInventoryStackLimit() && result <= this.slots[slotEnum.OUTPUT_SLOT.ordinal()].getMaxStackSize());
		}
	}

	public void smeltItem()
	{
		if(this.canSmelt())
		{
			ItemStack itemStack = RecipesVespeneCondenser.instance().getCondensingResult(this.slots[slotEnum.INPUT_SLOT.ordinal()]);

			if(this.slots[slotEnum.OUTPUT_SLOT.ordinal()] == null)
			{
				this.slots[slotEnum.OUTPUT_SLOT.ordinal()] = itemStack.copy();
			}
			else if(this.slots[slotEnum.OUTPUT_SLOT.ordinal()].isItemEqual(itemStack))
			{
				this.slots[slotEnum.OUTPUT_SLOT.ordinal()].stackSize += itemStack.stackSize;
			}

			--this.slots[slotEnum.INPUT_SLOT.ordinal()].stackSize;

			if(this.slots[slotEnum.INPUT_SLOT.ordinal()].stackSize <= 0)
			{
				this.slots[slotEnum.INPUT_SLOT.ordinal()] = null;
			}
		}
	}

	public int getItemCookTime(ItemStack itemStack)
	{
		if(itemStack == null)
		{
			return 200;
		}
		else
		{
			return RecipesVespeneCondenser.instance().getVespeneCondenserItemDuration(itemStack);
		}
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) 
	{
		return i == slotEnum.OUTPUT_SLOT.ordinal();
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int sideNumber) 
	{
		return sideNumber == 0 ? slotsBottom : (sideNumber == 1 ? slotsTop : slotsSide);
	}

	// These functions are behind automation with Hoppers
	@Override
	public boolean canInsertItem(int i, ItemStack itemStack, int j) 
	{
		return this.isItemValidForSlot(i, itemStack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) 
	{
		return j != 0 || i != 1; // Add another || statement to add items to be removed automatically.
	}

	public static int getSlotSmeltItemID()
	{
		return slotEnum.INPUT_SLOT.ordinal();
	}

	public static int getSlotProductItemID()
	{
		return slotEnum.OUTPUT_SLOT.ordinal();
	}

	public int getCookProgressScaled(int cookIconWidth) 
	{
		return this.cookTime * cookIconWidth / this.getItemCookTime(this.slots[slotEnum.INPUT_SLOT.ordinal()]);
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public void incrementPartClocks()
	{
		for(int i = 0; i < rotationIdleAnimationClock.length; i++)
		{
			rotationIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i].incrementClocks();
		}

		coreShiftIdleAnimationClock.incrementClocks();
	}

	public IdleAnimationClock getIdleAnimationClockRotation(int partNumber) 
	{
		return rotationIdleAnimationClock[partNumber];
	}

	public IdleAnimationClock getIdleAnimationClockVerticalShift(int partNumber) 
	{
		return verticalShiftIdleAnimationClock[partNumber];
	}

	public IdleAnimationClock getIdleAnimationClockCoreShift() 
	{
		return coreShiftIdleAnimationClock;
	}	
	
	public void setClockDefaults()
	{
		setVerticalShiftClockDefaults();
		setRotationClockDefaults();
		setCoreShiftClockDefaults();
	}

	public void setVerticalShiftClockDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i] = new IdleAnimationClock(0, 1, 0);

			verticalShiftIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float frequencyY = 0.35F;

			int startingClockY = (int)(((float)(verticalShiftIdleAnimationClock.length - i) / (float)verticalShiftIdleAnimationClock.length) * (float)verticalShiftIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockY > verticalShiftIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= verticalShiftIdleAnimationClock[i].getTotalDurationLengthY();
			}

			verticalShiftIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	public void setRotationClockDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		for(int i = 0; i < rotationIdleAnimationClock.length; i++)
		{
			rotationIdleAnimationClock[i] = new IdleAnimationClock(0, 1, 0);

			rotationIdleAnimationClock[i].setPhaseDurationY(0, 300);

			float frequencyY = 0.35F;

			int startingClockY = (int)(((float)(rotationIdleAnimationClock.length - i) / (float)rotationIdleAnimationClock.length) * (float)rotationIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockY > rotationIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= rotationIdleAnimationClock[i].getTotalDurationLengthY();
			}

			rotationIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	public void setCoreShiftClockDefaults()
	{
		Random rand = new Random();

		int startingClockY = rand.nextInt(100);

		coreShiftIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		coreShiftIdleAnimationClock.setPhaseDurationY(0, 40);

		while(startingClockY > coreShiftIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= coreShiftIdleAnimationClock.getTotalDurationLengthY();
		}

		coreShiftIdleAnimationClock.setClockY(startingClockY);
	}

	@Override
	public void setAnimationID(int id) 
	{
		animationID = id;
	}

	@Override
	public void setAnimationTick(int tick) 
	{
		animationTick = tick;	
	}

	@Override
	public int getAnimationID() 
	{
		return animationID;
	}

	@Override
	public int getAnimationTick() 
	{
		return animationTick;
	}
}