package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBerryPechita extends BerryItem
{
	String itemName = "pechitaberry";
	
	private boolean alwaysEdible;

	public ItemBerryPechita(int healAmount, float saturation)
	{
		super(healAmount, saturation, PokemonMDBlock.pechitaBerryPlant, Blocks.farmland, 2F);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":berries/" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	public String getItemName()
	{
		return itemName;
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A berry food item that");
		parList.add("cures the poison effect.");
	}

	@Override
	public ItemStack onEaten(ItemStack heldItemStack, World world, EntityPlayer player)
	{
		--heldItemStack.stackSize;
		player.getFoodStats().func_151686_a(this, heldItemStack);
		this.onFoodEaten(heldItemStack, world, player);
		return heldItemStack;
	}

	@Override
	protected void onFoodEaten(ItemStack heldItemStack, World world, EntityPlayer player)
	{
		if (player.isPotionActive(Potion.poison.id))
		{
			player.removePotionEffect(Potion.poison.id);
		}
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 16;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack heldItemStack, World world, EntityPlayer player)
	{
		if (player.canEat(this.alwaysEdible) || player.isPotionActive(Potion.poison.id))
        {
			player.setItemInUse(heldItemStack, this.getMaxItemUseDuration(heldItemStack));
        }
		
		return heldItemStack;
	}
	
	/**
     * Set the field 'alwaysEdible' to true, and make the food edible even if the player don't need to eat.
     */
    @Override
	public ItemFood setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }
}