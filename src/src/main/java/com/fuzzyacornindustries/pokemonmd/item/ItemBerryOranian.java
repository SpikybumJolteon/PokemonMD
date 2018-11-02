package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlock;
import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBerryOranian extends BerryItem
{
	String itemName = "oranianberry";
	
	private boolean alwaysEdible;

	public ItemBerryOranian(int healAmount, float saturation)
	{
		super(healAmount, saturation, PokemonMDBlock.oranianBerryPlant, Blocks.farmland, 6F);
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
		parList.add("heals health.");
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
		if (player.getHealth() < player.getMaxHealth() && player.getHealth() > 0);
		{
			player.heal(1F);
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 16;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack heldItemStack, World world, EntityPlayer player)
	{
		if (player.canEat(this.alwaysEdible) || player.getHealth() < player.getMaxHealth())
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