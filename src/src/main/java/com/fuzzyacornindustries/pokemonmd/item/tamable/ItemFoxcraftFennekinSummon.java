package com.fuzzyacornindustries.pokemonmd.item.tamable;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.EntityFoxcraftFennekin;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItem;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFoxcraftFennekinSummon extends ItemPoketamableSummon
{
    public ItemFoxcraftFennekinSummon()
    {
    	itemName = "foxcraftfennekinsummon";
    	
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
			entityToSpawn.worldObj.playSoundAtEntity(entityToSpawn, ModInfo.MODID + ":mob." + EntityFoxcraftFennekin.getMobName() + ".living", 3.0F, 1.0F);
		}

		return entityToSpawn;
	}

	public static ItemStack fromPoketamableEntity(EntityFoxcraftFennekin poketamableEntity)
	{
		if (poketamableEntity.worldObj.isRemote)
		{
			return null;
		}

		ItemStack poketamableStack = new ItemStack(PokemonMDItem.foxcraftFennekinSummon);

		retrieveEntityStats(poketamableEntity, poketamableStack);

		return poketamableStack;
	}

	public static EntityFoxcraftFennekin toPoketamableEntity(World world, ItemStack poketamableStack, EntityPlayer player)
	{
		EntityFoxcraftFennekin poketamableEntity = new EntityFoxcraftFennekin(world);

		applyEntityStats(poketamableEntity, poketamableStack, player);

		String name = poketamableStack.stackTagCompound != null ? poketamableStack.stackTagCompound.getCompoundTag("display").getString("Name") : "Foxcraft Fennekin";
		if (name.equals("")) name = "Foxcraft Fennekin";
		poketamableEntity.setName(name);

		return poketamableEntity;
	}
}