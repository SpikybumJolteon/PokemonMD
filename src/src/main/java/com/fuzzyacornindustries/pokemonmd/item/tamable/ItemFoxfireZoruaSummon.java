package com.fuzzyacornindustries.pokemonmd.item.tamable;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxfireZorua;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFoxfireZoruaSummon extends ItemPoketamableSummon
{
	public static String itemName = "foxfirezoruasummon";

	protected EntityLiving entityToSpawn = null;

	public ItemFoxfireZoruaSummon()
	{
		itemName = "foxfirezoruasummon";

		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + "tamables/" + getItemName());
	}

	static public String getItemName()
	{
		return itemName;
	}

	@Override
	public Entity spawnEntity(World parWorld, EntityPlayer parPlayer, ItemStack par1ItemStack, double parX, double parY, double parZ)
	{
		if (!parWorld.isRemote)
		{
			entityToSpawn = toPoketamableEntity(parWorld, par1ItemStack, parPlayer);
			entityToSpawn.setLocationAndAngles(parX, parY + 1D, parZ, MathHelper.wrapAngleTo180_float(parWorld.rand.nextFloat() * 360.0F), 0.0F);

			parWorld.spawnEntityInWorld(entityToSpawn);
			entityToSpawn.worldObj.playSoundAtEntity(entityToSpawn, ModInfo.MODID + ":mob." + EntityFoxfireZorua.getMobName() + ".living", 3.0F, 1.0F);
		}

		return entityToSpawn;
	}

	public static ItemStack fromPoketamableEntity(EntityFoxfireZorua poketamableEntity)
	{
		if (poketamableEntity.worldObj.isRemote)
		{
			return null;
		}

		ItemStack poketamableStack = new ItemStack(PokemonMDItem.foxfireZoruaSummon);

		retrieveEntityStats(poketamableEntity, poketamableStack);

		return poketamableStack;
	}

	public static EntityFoxfireZorua toPoketamableEntity(World world, ItemStack poketamableStack, EntityPlayer player)
	{
		EntityFoxfireZorua poketamableEntity = new EntityFoxfireZorua(world);

		applyEntityStats(poketamableEntity, poketamableStack, player);
		
		String name = poketamableStack.stackTagCompound != null ? poketamableStack.stackTagCompound.getCompoundTag("display").getString("Name") : "Foxfire Zorua";
		if (name.equals("")) name = "Foxfire Zorua";
		poketamableEntity.setName(name);

		return poketamableEntity;
	}
}