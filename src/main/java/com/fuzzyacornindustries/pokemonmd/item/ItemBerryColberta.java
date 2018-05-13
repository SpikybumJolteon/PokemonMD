package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemBerryColberta extends BerryItem
{
	String itemName = "colbertaberry";
	
	private boolean alwaysEdible;

	public ItemBerryColberta(int healAmount, float saturation)
	{
		super(healAmount, saturation, PokemonMDBlock.colbertaBerryPlant, Blocks.farmland, 2F);
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
		parList.add("cures the blindness effect.");
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
		if (player.isPotionActive(Potion.blindness.id))
		{
			player.removePotionEffect(Potion.blindness.id);
		}
	}

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
		if (player.canEat(this.alwaysEdible) || player.isPotionActive(Potion.blindness.id))
        {
			player.setItemInUse(heldItemStack, this.getMaxItemUseDuration(heldItemStack));
        }
		
		return heldItemStack;
	}
	
    @Override
	public ItemFood setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }
}