package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.ArrayList;
import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.BlockTabletManufactory;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.recipes.CraftingInventoryMatrix;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesTabletManufactory;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTabletManufactory extends TileEntity implements ISidedInventory, IAnimatedEntity
{
	private IdleAnimationClock barsIdleAnimationClock[] = new IdleAnimationClock[6];
	private IdleAnimationClock rotationIdleAnimationClock;
	private IdleAnimationClock verticalShiftIdleAnimationClock;

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	private int textureAnimationClock = 0;

	private String localizedName;

	public static final int slotTabletItemID = 1;
	public static final int slotFuelItemID = 4; // Will control cook times
	public static final int slotProductItemID = 9; // slot 8 is skipped
	public static final int[] slotSideItemsItemID = {0,2,3,5,6,7}; // Moving Left to right; top to bottom with side slots

	private static final int[] slotsTop = new int[]{0};
	private static final int[] slotsBottom = new int[]{1};
	private static final int[] slotsSide = new int[]{1};

	private ItemStack productSlot;

	public int manufactureTime;

	private ItemStack producingStack = null;
	public CraftingInventoryMatrix manufacturingCraftingMatrix = new CraftingInventoryMatrix();

	public TileEntityTabletManufactory()
	{
		setClockDefaults();
		
		manufacturingCraftingMatrix = new CraftingInventoryMatrix();
	}

	@Override
	public void updateEntity() 
	{
		boolean isManufacturingFlag = false;

		if (BlockTabletManufactory.isPylonNearby(this.worldObj, this.xCoord, this.yCoord, this.zCoord) == true)
		{
			if (!this.worldObj.isRemote) 
			{	
				// This determines how long items smelt
				if(this.canManufacture())
				{
					this.manufactureTime++;

					if(this.manufactureTime == getItemManufactureTime(manufacturingCraftingMatrix.getStackInSlot(this.slotFuelItemID)))
					{
						this.manufactureTime = 0;
						this.manufactureItem();
						isManufacturingFlag = true;
					}
					/*
				System.out.println( "Test Cook Time Code" );
				System.out.println( Integer.toString( getItemCookTime(this.slots[slotSmeltItemID]) ) );
					 */
				}
				else
				{
					this.manufactureTime = 0;
				}
			}

			incrementPartClocks();
		}

		if(this.canManufacture())
		{
			isManufacturingFlag = true;

			BlockTabletManufactory.updateTabletManufactoryBlockState(this.canManufacture(), worldObj, this.xCoord, this.yCoord, this.zCoord);
		}

		textureAnimationClock++;

		if(textureAnimationClock > (14) + 40)
		{
			textureAnimationClock = 0;
		}

		if(isManufacturingFlag)
		{
			this.markDirty();
		}
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	public void updateInput()
	{
		this.producingStack = RecipesTabletManufactory.findMatchingRecipe(this.manufacturingCraftingMatrix, this.worldObj);
/*
		System.out.println( "Test Crafting Matrix Content" );
		for(int i = 0; i < this.manufacturingCraftingMatrix.getSizeInventory(); i++)
		{
			if(this.manufacturingCraftingMatrix.getStackInSlot(i) != null)
			{
				System.out.println( this.manufacturingCraftingMatrix.getStackInSlot(i).getDisplayName() );
			}
			else
			{
			System.out.println( "Slot: " + i + " is Null" );
			}
		}*/
	}

	private boolean canManufacture()
	{
		ItemStack itemstack = this.producingStack;

		if (itemstack == null)
		{
			return false;
		}
		if (this.productSlot == null)
		{
			return true;
		}
		if (!this.productSlot.isItemEqual(itemstack))
		{
			return false;
		}

		int result = this.productSlot.stackSize + itemstack.stackSize;
		return result <= this.getInventoryStackLimit() && result <= itemstack.getMaxStackSize();
	}

	public static boolean isItemManufactoryInput(ItemStack stack)
	{
		for (IRecipe recipe : RecipesTabletManufactory.getRecipeList())
		{
			if (recipe instanceof ShapedRecipes)
			{
				for (ItemStack itemstack1 : ((ShapedRecipes) recipe).recipeItems)
				{
					if (stack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || stack.getItemDamage() == itemstack1.getItemDamage()))
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	public void manufactureItem()
	{
		if (this.canManufacture())
		{
			ItemStack resultItemStack = this.producingStack;

			if (this.productSlot == null)
			{
				this.productSlot = resultItemStack.copy();
			}
			else if (this.productSlot.isItemEqual(resultItemStack))
			{
				if (this.productSlot.stackSize + resultItemStack.stackSize > 64)
				{
					for (int i = 0; i < this.productSlot.stackSize + resultItemStack.stackSize - 64; i++)
					{
						float var = 0.7F;
						double dx = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dy = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						double dz = this.worldObj.rand.nextFloat() * var + (1.0F - var) * 0.5D;
						EntityItem entityitem = new EntityItem(this.worldObj, this.xCoord + dx, this.yCoord + dy, this.zCoord + dz, new ItemStack(resultItemStack.getItem(), 1, resultItemStack.getItemDamage()));

						entityitem.delayBeforeCanPickup = 10;

						this.worldObj.spawnEntityInWorld(entityitem);
					}
				}

				this.productSlot.stackSize += resultItemStack.stackSize;
			}

			for (int i = 0; i < this.manufacturingCraftingMatrix.getSizeInventory(); i++)
			{
				this.manufacturingCraftingMatrix.decrStackSize(i, 1);
			}
			this.updateInput();
		}
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);

		NBTTagList list = nbt.getTagList("Items", 10);

		for(int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound compound = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");

			if(b >= 0 && b < this.manufacturingCraftingMatrix.getSizeInventory())
			{
				this.manufacturingCraftingMatrix.setInventorySlotContents(b, ItemStack.loadItemStackFromNBT(compound));
			}
			else if(b == this.slotProductItemID)
			{
				this.productSlot = ItemStack.loadItemStackFromNBT(compound);
			}
		}

		this.manufactureTime = nbt.getShort("ManufactureTime");

		if(nbt.hasKey("CustomName"))
		{
			this.localizedName = nbt.getString("CustomName");
		}

		this.updateInput();
	}

	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);

		nbt.setShort("ManufactureTime", (short)this.manufactureTime);

		NBTTagList list = new NBTTagList();

		if(this.productSlot != null)
		{
			NBTTagCompound compound = new NBTTagCompound();
			compound.setByte("Slot", (byte)this.slotProductItemID);
			this.productSlot.writeToNBT(compound);
			list.appendTag(compound);
		}

		for (int i = 0; i < this.manufacturingCraftingMatrix.getSizeInventory(); ++i)
		{
			if (this.manufacturingCraftingMatrix.getStackInSlot(i) != null)
			{
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte) (i));
				this.manufacturingCraftingMatrix.getStackInSlot(i).writeToNBT(compound);
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
	public int getSizeInventory()
	{
		return this.manufacturingCraftingMatrix.getSizeInventory() + 1;
	}

	@Override
	public ItemStack getStackInSlot(int slotID)
	{
		if (slotID < manufacturingCraftingMatrix.getSizeInventory())
		{
			return this.manufacturingCraftingMatrix.getStackInSlot(slotID);
		}

		return this.productSlot;
	}

	@Override
	public ItemStack decrStackSize(int slotNumber, int decreaseAmount)
	{
		if (slotNumber < this.manufacturingCraftingMatrix.getSizeInventory())
		{
			ItemStack result = this.manufacturingCraftingMatrix.decrStackSize(slotNumber, decreaseAmount);
			if (result != null)
			{
				this.updateInput();
			}
			return result;
		}

		if (this.productSlot != null)
		{
			ItemStack par3ItemStack;

			if (this.productSlot.stackSize <= decreaseAmount)
			{
				par3ItemStack = this.productSlot;
				this.productSlot = null;
				return par3ItemStack;
			}
			else
			{
				par3ItemStack = this.productSlot.splitStack(decreaseAmount);

				if (this.productSlot.stackSize == 0)
				{
					this.productSlot = null;
				}

				return par3ItemStack;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotNumber)
	{
		if (slotNumber < this.manufacturingCraftingMatrix.getSizeInventory())
		{
			return this.manufacturingCraftingMatrix.getStackInSlotOnClosing(slotNumber);
		}

		if (this.productSlot != null)
		{
			ItemStack par2ItemStack = this.productSlot;
			this.productSlot = null;
			return par2ItemStack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slotNumber, ItemStack par2ItemStack)
	{
		if (slotNumber < this.manufacturingCraftingMatrix.getSizeInventory())
		{
			this.manufacturingCraftingMatrix.setInventorySlotContents(slotNumber, par2ItemStack);
			this.updateInput();
		}
		else
		{
			this.productSlot = par2ItemStack;

			if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
			{
				par2ItemStack.stackSize = this.getInventoryStackLimit();
			}
		}
	}

	@Override
	public String getInventoryName()
	{
		return this.isInventoryNameLocalized() ? this.localizedName : "Tablet Manufactory";
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemStack)
	{
		if (slotID < this.manufacturingCraftingMatrix.getSizeInventory())
		{
			if (this.producingStack != null)
			{
				ItemStack stackInSlot = this.getStackInSlot(slotID);
				return stackInSlot != null && stackInSlot.isItemEqual(itemStack);
			}

			return TileEntityTabletManufactory.isItemManufactoryInput(itemStack);
		}

		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
		if (side == 0) return new int[] { 1 };
		int[] slots = new int[] { 0, 1, 2, 3, 4, 5, 6, 7};
		ArrayList<Integer> removeSlots = new ArrayList();

		for (int i = 0; i < 8; i++)
		{
			if (removeSlots.contains(i)) continue;
			ItemStack stack1 = this.getStackInSlot(i);
			if (stack1 == null || stack1.stackSize <= 0) continue;

			for (int j = i + 1; j < 7; j++)
			{
				if (removeSlots.contains(j)) continue;
				ItemStack stack2 = this.getStackInSlot(j);
				if (stack2 == null) continue;

				if (stack1.isItemEqual(stack2))
				{
					if (stack2.stackSize >= stack1.stackSize)
						removeSlots.add(j);
					else
						removeSlots.add(i);
					break;
				}
			}
		}

		if (removeSlots.size() > 0)
		{
			int[] returnSlots = new int[slots.length - removeSlots.size()];
			int j = 0;
			for (int i = 0; i < slots.length; i++)
			{
				if (i > 0 && removeSlots.contains(slots[i])) { continue; }
				returnSlots[j] = slots[i];
				j++;    			
			}

			return returnSlots;
		}

		return slots;
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack par2ItemStack, int par3)
	{
		return this.isItemValidForSlot(slotID, par2ItemStack);
	}

	@Override
	public boolean canExtractItem(int slotID, ItemStack par2ItemStack, int par3)
	{
		return slotID == this.slotProductItemID;
	}

	public boolean isInventoryNameLocalized()
	{
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public void setGuiDisplayName(String displayName)
	{
		this.localizedName = displayName;
	}

	public int getItemManufactureTime(ItemStack itemStack)
	{
		if(itemStack == null)
		{
			return 200;
		}
		else
		{
			Item item = itemStack.getItem();

			if(item == PokemonMDItem.vespeneCrystal) return 300;
			if(item == PokemonMDItem.vespeneFuelRod) return 900;
			if(item == PokemonMDItem.emeraldOfChaos) return 3500;

			return 200;
		}
	}

	public int getManufactureProgressScaled(int manufactureIconWidth) 
	{
		return this.manufactureTime * manufactureIconWidth / this.getItemManufactureTime(this.manufacturingCraftingMatrix.getStackInSlot(slotFuelItemID));
	}

	/*
	public boolean areAllInventorySlotsFull()
	{
		return this.slots[slotTabletItemID] != null && 
				this.slots[slotFuelItemID] != null && 
				this.slots[slotSideItemsItemID[0]] != null && 
				this.slots[slotSideItemsItemID[1]] != null && 
				this.slots[slotSideItemsItemID[2]] != null && 
				this.slots[slotSideItemsItemID[3]] != null && 
				this.slots[slotSideItemsItemID[4]] != null && 
				this.slots[slotSideItemsItemID[5]] != null;
	}

	public TabletManufactoryRecipe assembleInventoryToRecipe()
	{
		if(areAllInventorySlotsFull())
		{
			return new TabletManufactoryRecipe(this.slots[slotTabletItemID].getItem(), this.slots[slotFuelItemID].getItem(),
					this.slots[slotSideItemsItemID[0]].getItem(), this.slots[slotSideItemsItemID[1]].getItem(),
					this.slots[slotSideItemsItemID[2]].getItem(), this.slots[slotSideItemsItemID[3]].getItem(),
					this.slots[slotSideItemsItemID[4]].getItem(), this.slots[slotSideItemsItemID[5]].getItem());
		}
		else
			return null;
	}*/



	/*
	public void manufactureItem()
	{
		if(this.canManufacture())
		{
			ItemStack itemStack = RecipesTabletManufactory.instance().getManufactureResult(assembleInventoryToRecipe());

			if(this.slots[slotProductItemID] == null)
			{
				this.slots[slotProductItemID] = itemStack.copy();
			}

			decreaseInventory(slotTabletItemID);
			decreaseInventory(slotFuelItemID);
			decreaseInventory(slotSideItemsItemID[0]);
			decreaseInventory(slotSideItemsItemID[1]);
			decreaseInventory(slotSideItemsItemID[2]);
			decreaseInventory(slotSideItemsItemID[3]);
			decreaseInventory(slotSideItemsItemID[4]);
			decreaseInventory(slotSideItemsItemID[5]);
		}
	}*/


	/*
	@Override
	public int[] getAccessibleSlotsFromSide(int sideNumber) 
	{
		return sideNumber == 0 ? slotsBottom : (sideNumber == 1 ? slotsTop : slotsSide);
	}
	 */

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public void incrementPartClocks()
	{
		for(int i = 0; i < barsIdleAnimationClock.length; i++)
		{
			barsIdleAnimationClock[i].incrementClocks();
		}

		rotationIdleAnimationClock.incrementClocks();
		verticalShiftIdleAnimationClock.incrementClocks();
	}

	public int getTextureID()
	{
		if(textureAnimationClock < 40)
		{
			return 1;
		}

		for(int i = 2; i <= 14; i++)
		{
			if(textureAnimationClock < (i - 1) + 40)
			{
				return i;
			}
		}

		return 1;
	}

	public IdleAnimationClock getBarsAnimationClock(int partNumber) 
	{
		return barsIdleAnimationClock[partNumber];
	}

	public IdleAnimationClock getRotationAnimationClock() 
	{
		return rotationIdleAnimationClock;
	}

	public IdleAnimationClock getVerticalFloatAnimationClock() 
	{
		return verticalShiftIdleAnimationClock;
	}

	public void setClockDefaults()
	{
		setBarsClockDefaults();
		setRotationClockDefaults();
		setVerticalShiftClockDefaults();
	}

	public void setBarsClockDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		for(int i = 0; i < barsIdleAnimationClock.length; i++)
		{
			barsIdleAnimationClock[i] = new IdleAnimationClock(4, 0, 0);

			barsIdleAnimationClock[i].setPhaseDurationX(0, 30);
			barsIdleAnimationClock[i].setPhaseDurationX(1, 15);
			barsIdleAnimationClock[i].setPhaseDurationX(2, 30);
			barsIdleAnimationClock[i].setPhaseDurationX(3, 15);

			float frequencyX = 0.1F;

			int startingClockX = (int)(((float)(barsIdleAnimationClock.length - i) / (float)barsIdleAnimationClock.length) * (float)barsIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;

			while(startingClockX > barsIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= barsIdleAnimationClock[i].getTotalDurationLengthX();
			}

			barsIdleAnimationClock[i].setClockX(startingClockX);
		}
	}

	public void setRotationClockDefaults()
	{
		Random rand = new Random();

		int startingClockY = rand.nextInt(100);

		rotationIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		rotationIdleAnimationClock.setPhaseDurationY(0, 250);

		while(startingClockY > rotationIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= rotationIdleAnimationClock.getTotalDurationLengthY();
		}

		rotationIdleAnimationClock.setClockY(startingClockY);
	}

	public void setVerticalShiftClockDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		verticalShiftIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		verticalShiftIdleAnimationClock.setPhaseDurationY(0, 80);

		float frequencyY = 0.35F;

		int startingClockY = randomInt;

		while(startingClockY > verticalShiftIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= verticalShiftIdleAnimationClock.getTotalDurationLengthY();
		}

		verticalShiftIdleAnimationClock.setClockY(startingClockY);
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