package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemStack;

public interface IWeapon 
{
	/**
	 * Return true if the ItemStack is considered a sword.
	 * Consider returning !{@link WeaponRegistry#isSwordForbidden} to allow users to choose the item's sword status.
	 */
	boolean isSword(ItemStack stack);

	/**
	 * Return true if the ItemStack is considered a weapon
	 * (should return true if {@link #isSword} returns true)
	 * Consider returning !{@link WeaponRegistry#isWeaponForbidden} to allow users to choose the item's weapon status.
	 */
	boolean isWeapon(ItemStack stack);
}