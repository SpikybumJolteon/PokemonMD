package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.BlockVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.recipes.FuelsVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVerdantPurifier;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVerdantPurifier extends TileEntity implements ISidedInventory, IAnimatedEntity
{
	private IdleAnimationClock petalsIdleAnimationClock;
	private IdleAnimationClock chamberIdleAnimationClock;
	private IdleAnimationClock chamberShiftIdleAnimationClock;
	private IdleAnimationClock verticalShiftIdleAnimationClock[] = new IdleAnimationClock[2];

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	private static final int[] slotsTop = new int[] { 0 };
	private static final int[] slotsBottom = new int[] { 2, 1 };
	private static final int[] slotsSides = new int[] { 1 };

	private ItemStack[] purifierInventoryStacks = new ItemStack[3];

	public int purifierFuelTime; // furnaceBurnTime equivalent
	public int currentFuelTime; // currentBurnTime equivalent
	public int purifierDurationTime; // furnaceCookTime equivalent

	private String purifierName;
	
	public final static int purificationTime = 200;
	public final static int cycleTime = 198;

	public TileEntityVerdantPurifier()
	{
		animationID = actionIDNone;
		animationTick = 0;
		
		setClockDefaults();
	}

	public void furnaceName(String string)
	{
		this.purifierName = string;
	}

	@Override
	public int getSizeInventory() 
	{
		return this.purifierInventoryStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) 
	{
		return this.purifierInventoryStacks[slot];
	}

	@Override
	public ItemStack decrStackSize(int inventoryStackID, int maximumStackSize) 
	{
		if (this.purifierInventoryStacks[inventoryStackID] != null) 
		{
			ItemStack itemstack;

			if (this.purifierInventoryStacks[inventoryStackID].stackSize <= maximumStackSize) 
			{
				itemstack = this.purifierInventoryStacks[inventoryStackID];
				this.purifierInventoryStacks[inventoryStackID] = null;
				return itemstack;
			} 
			else 
			{
				itemstack = this.purifierInventoryStacks[inventoryStackID].splitStack(maximumStackSize);

				if (this.purifierInventoryStacks[inventoryStackID].stackSize == 0) 
				{
					this.purifierInventoryStacks[inventoryStackID] = null;
				}
				return itemstack;
			}
		} 
		else 
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) 
	{
		if (this.purifierInventoryStacks[slot] != null) 
		{
			ItemStack itemstack = this.purifierInventoryStacks[slot];
			this.purifierInventoryStacks[slot] = null;
			return itemstack;
		} 
		else 
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) 
	{
		this.purifierInventoryStacks[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) 
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() 
	{
		return this.hasCustomInventoryName() ? this.purifierName : "Verdant Purifier";
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return this.purifierName != null && this.purifierName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	public void readFromNBT(NBTTagCompound tagCompound) 
	{
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.purifierInventoryStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < tagList.tagCount(); ++i) 
		{
			NBTTagCompound tabCompound1 = tagList.getCompoundTagAt(i);
			byte byte0 = tabCompound1.getByte("Slot");

			if (byte0 >= 0 && byte0 < this.purifierInventoryStacks.length) 
			{
				this.purifierInventoryStacks[byte0] = ItemStack.loadItemStackFromNBT(tabCompound1);
			}
		}

		this.purifierFuelTime = tagCompound.getShort("PurifyTime");
		this.purifierDurationTime = tagCompound.getShort("PurifyDurationTime");
		this.currentFuelTime = getItemPurificationFuelTime(this.purifierInventoryStacks[1]);

		if (tagCompound.hasKey("CustomName", 8)) 
		{
			this.purifierName = tagCompound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tagCompound) 
	{
		super.writeToNBT(tagCompound);

		tagCompound.setShort("PurifyTime", (short) this.purifierFuelTime);
		tagCompound.setShort("PurifyDurationTime", (short) this.purifierFuelTime);

		NBTTagList tagList = new NBTTagList();

		for (int i = 0; i < this.purifierInventoryStacks.length; ++i) 
		{
			if (this.purifierInventoryStacks[i] != null) 
			{
				NBTTagCompound tagCompound1 = new NBTTagCompound();
				tagCompound1.setByte("Slot", (byte) i);
				this.purifierInventoryStacks[i].writeToNBT(tagCompound1);
				tagList.appendTag(tagCompound1);
			}
		}

		tagCompound.setTag("Items", tagList);

		if (this.hasCustomInventoryName()) 
		{
			tagCompound.setString("CustomName", this.purifierName);
		}
	}

	@SideOnly(Side.CLIENT)
	public int getPurificationProgressScaled(int par1) 
	{
		return this.purifierDurationTime * par1 / purificationTime;
	}

	@SideOnly(Side.CLIENT)
	public int getPurificationTimeRemainingScaled(int par1) 
	{
		if (this.currentFuelTime == 0) 
		{
			this.currentFuelTime = purificationTime;
		}

		//System.out.println( "Test Cook Time Code" );
		//System.out.println(Integer.toString(this.furnaceBurnTime) + " " + Integer.toString(par1) + " " + Integer.toString(this.currentBurnTime) );
		//System.out.println(Integer.toString(this.furnaceBurnTime * par1 / this.currentBurnTime));

		return this.purifierFuelTime * par1 / this.currentFuelTime;
	}

	public boolean isPurifying() 
	{
		return this.purifierFuelTime > 0;
	}

	public void updateEntity() 
	{
		boolean flag = this.purifierFuelTime > 0;
		boolean flag1 = false;

		if (BlockVerdantPurifier.isPylonNearby(this.worldObj, this.xCoord, this.yCoord, this.zCoord) == true)
		{
			if (this.purifierFuelTime > 0) 
			{
				--this.purifierFuelTime;
			}

			if (!this.worldObj.isRemote) 
			{
				if (this.purifierFuelTime == 0 && this.canPurify()) 
				{
					//System.out.println("Before");
					//System.out.println(Integer.toString(this.furnaceBurnTime) + " " + Integer.toString(this.currentBurnTime) + " " + getItemBurnTime(this.furnaceItemStacks[1]));

					this.currentFuelTime = this.purifierFuelTime = getItemPurificationFuelTime(this.purifierInventoryStacks[1]);

					//System.out.println("After");
					//System.out.println(Integer.toString(this.furnaceBurnTime) + " " + Integer.toString(this.currentBurnTime) + " " + getItemBurnTime(this.furnaceItemStacks[1]));
					//System.out.println("--------------------");
					
					if (this.purifierFuelTime > 0) 
					{
						flag1 = true;

						if (this.purifierInventoryStacks[1] != null) 
						{
							--this.purifierInventoryStacks[1].stackSize;

							if (this.purifierInventoryStacks[1].stackSize == 0) 
							{
								this.purifierInventoryStacks[1] = purifierInventoryStacks[1].getItem().getContainerItem(this.purifierInventoryStacks[1]);
							}
						}
					}
				}

				if (this.isPurifying() && this.canPurify()) 
				{
					++this.purifierDurationTime;

					if (this.purifierDurationTime == purificationTime) 
					{
						this.purifierDurationTime = 0;
						this.purifyItem();
						flag1 = true;
					}
				} 
				else 
				{
					this.purifierDurationTime = 0;
				}
			}

			incrementPartClocks();
		}

		if (flag != this.purifierFuelTime > 0) 
		{
			flag1 = true;

			BlockVerdantPurifier.updateBlockState(this.purifierFuelTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}

		if (flag1) 
		{
			this.markDirty();
		}

	}

	private boolean canPurify() 
	{
		if (this.purifierInventoryStacks[0] == null) 
		{
			return false;
		} 
		else 
		{
			ItemStack resaultingItemstack = RecipesVerdantPurifier.instance().getPurifyingResult(this.purifierInventoryStacks[0]);

			if (resaultingItemstack == null) return false;

			if (this.purifierInventoryStacks[2] == null) return true;

			if (!this.purifierInventoryStacks[2].isItemEqual(resaultingItemstack)) return false;

			int result = purifierInventoryStacks[2].stackSize + resaultingItemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.purifierInventoryStacks[2].getMaxStackSize();
		}
	}

	public void purifyItem() 
	{
		if (this.canPurify()) 
		{
			ItemStack resaultingItemstack = RecipesVerdantPurifier.instance().getPurifyingResult(this.purifierInventoryStacks[0]);

			if (this.purifierInventoryStacks[2] == null) 
			{
				this.purifierInventoryStacks[2] = resaultingItemstack.copy();
			} 
			else if (this.purifierInventoryStacks[2].getItem() == resaultingItemstack.getItem()) 
			{
				this.purifierInventoryStacks[2].stackSize += resaultingItemstack.stackSize;
			}

			--this.purifierInventoryStacks[0].stackSize;

			if(this.purifierInventoryStacks[0].stackSize <= 0)
			{
				this.purifierInventoryStacks[0] = null;
			}
		}
	}

	public static int getItemPurificationFuelTime(ItemStack itemstack)
	{
		if(itemstack == null)
		{
			return 0;
		}
		else
		{
			return FuelsVerdantPurifier.instance().getVerdantPurifierFuelTime(itemstack);
			
			//Item item = itemstack.getItem();

			
			/*
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
			{
				Block block = Block.getBlockFromItem(item);

				if(block == Blocks.pumpkin)
				{
					return cycleTime * 2;
				}
				else if(block == Blocks.melon_block)
				{
					return cycleTime * 2;
				}
				else if(block == Blocks.cactus)
				{
					return cycleTime / 2 ;
				}
				else if(block == Blocks.leaves || block == Blocks.leaves2 || block == Blocks.vine)
				{
					return cycleTime / 4;
				}
				else if(block == Blocks.waterlily)
				{
					return cycleTime * 4;
				}
				else if(block == Blocks.sapling)
				{
					return cycleTime;
				}
				else
				{
					return GameRegistry.getFuelValue(itemstack);
				}
			}

			if(item == Items.reeds) return cycleTime / 2;
			if(item == Items.wheat) return cycleTime;
			if(item == Items.wheat_seeds) return cycleTime / 4;
			if(item == Items.apple) return cycleTime * 2;
			if(item == Items.potato) return cycleTime;
			if(item == Items.carrot) return cycleTime;
			if(item == Items.melon) return cycleTime / 2;
			if(item == PokemonMDItem.colbertaBerry) return cycleTime * 2;
			if(item == PokemonMDItem.oranianBerry) return cycleTime / 2;
			if(item == PokemonMDItem.passhauraBerry) return cycleTime;
			if(item == PokemonMDItem.pechitaBerry) return cycleTime;
			if(item == PokemonMDItem.rawstettaBerry) return cycleTime;

			//if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("EMERALD")) return 300;
*/
			//return GameRegistry.getFuelValue(itemstack);
		}
	}

	public static boolean isItemFuel(ItemStack itemstack)
	{
		return getItemPurificationFuelTime(itemstack) > 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) 
	{
		return par1 == 2 ? false : (par1 == 1 ? isItemFuel(itemstack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) 
	{
		return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int par1, ItemStack itemstack, int par3) 
	{
		return this.isItemValidForSlot(par1, itemstack);
	}

	@Override
	public boolean canExtractItem(int par1, ItemStack itemstack, int par3)
	{
		return par3 != 0 || par1 != 1 || itemstack.getItem() == Items.bucket;
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getIdleAnimationClockPetals() 
	{
		return petalsIdleAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockChamber() 
	{

		return chamberIdleAnimationClock;
	}
	
	public IdleAnimationClock getIdleAnimationClockVerticalShift(int partNumber) 
	{
		return verticalShiftIdleAnimationClock[partNumber];
	}

	public void incrementPartClocks()
	{
		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i].incrementClocks();
		}

		chamberIdleAnimationClock.incrementClocks();
		petalsIdleAnimationClock.incrementClocks();
	}
	
	public void setClockDefaults()
	{
		setVerticalShiftDefaults();
		setChamberDefaults();
		setPetalsClockDefaults();
	}

	public void setVerticalShiftDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			verticalShiftIdleAnimationClock[i].setPhaseDurationX(0, 80);
			verticalShiftIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float frequencyY = 0.15F;

			int startingClockX = (int)(((float)(verticalShiftIdleAnimationClock.length - i) / (float)verticalShiftIdleAnimationClock.length) * (float)verticalShiftIdleAnimationClock[i].getTotalDurationLengthX() * frequencyY) + randomInt;
			int startingClockY = (int)(((float)(verticalShiftIdleAnimationClock.length - i) / (float)verticalShiftIdleAnimationClock.length) * (float)verticalShiftIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > verticalShiftIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= verticalShiftIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > verticalShiftIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= verticalShiftIdleAnimationClock[i].getTotalDurationLengthY();
			}

			verticalShiftIdleAnimationClock[i].setClockX(startingClockX);
			verticalShiftIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	public void setChamberDefaults()
	{
		Random rand = new Random();

		int startingClockX = rand.nextInt(100);
		int startingClockY = rand.nextInt(100);
		int startingClockZ = rand.nextInt(100);

		chamberIdleAnimationClock = new IdleAnimationClock(1, 1, 1);

		chamberIdleAnimationClock.setPhaseDurationX(0, 200);
		chamberIdleAnimationClock.setPhaseDurationY(0, 350);
		chamberIdleAnimationClock.setPhaseDurationZ(0, 230);

		while(startingClockX > chamberIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= chamberIdleAnimationClock.getTotalDurationLengthX();
		}

		while(startingClockY > chamberIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= chamberIdleAnimationClock.getTotalDurationLengthY();
		}

		while(startingClockZ > chamberIdleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= chamberIdleAnimationClock.getTotalDurationLengthZ();
		}

		chamberIdleAnimationClock.setClockX(startingClockX);
		chamberIdleAnimationClock.setClockY(startingClockY);
		chamberIdleAnimationClock.setClockZ(startingClockZ);
	}

	public void setPetalsClockDefaults()
	{
		Random rand = new Random();

		int startingClockX = rand.nextInt(100);
		int startingClockY = rand.nextInt(100);

		petalsIdleAnimationClock = new IdleAnimationClock(4, 1, 0);

		petalsIdleAnimationClock.setPhaseDurationX(0, 110);
		petalsIdleAnimationClock.setPhaseDurationX(1, 80);
		petalsIdleAnimationClock.setPhaseDurationX(2, 40);
		petalsIdleAnimationClock.setPhaseDurationX(3, 100);

		petalsIdleAnimationClock.setPhaseDurationY(0, 500);

		while(startingClockX > petalsIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= petalsIdleAnimationClock.getTotalDurationLengthX();
		}

		while(startingClockY > petalsIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= petalsIdleAnimationClock.getTotalDurationLengthY();
		}

		//petalsIdleAnimationClock.setClockX(startingClockX);
		petalsIdleAnimationClock.setClockY(startingClockY);
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