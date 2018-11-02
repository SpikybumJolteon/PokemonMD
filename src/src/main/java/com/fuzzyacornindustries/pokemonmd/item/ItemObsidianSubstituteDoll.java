package com.fuzzyacornindustries.pokemonmd.item;

import com.fuzzyacornindustries.pokemonmd.entity.mob.ability.EntitySubstituteDoll;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemObsidianSubstituteDoll extends ItemSubstituteDoll
{
	public static String itemName = "obsidiansubstitutedollitem";
	
	protected EntityLiving entityToSpawn = null;
	
    public ItemObsidianSubstituteDoll()
    {
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + "obsidiansubstitutedollitem");
    }

	@Override
	public Entity spawnEntity(World parWorld, EntityPlayer parPlayer, double parX, double parY, double parZ)
	{
		if (!parWorld.isRemote)
		{
			String entityToSpawnNameFull = ModInfo.MODID + "." + EntitySubstituteDoll.getMobName();
			
			if (EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull))
			{
				entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, parWorld);
				entityToSpawn.setLocationAndAngles(parX, parY, parZ, MathHelper.wrapAngleTo180_float(parWorld.rand.nextFloat() * 360.0F), 0.0F);

				((EntitySubstituteDoll)entityToSpawn).setDollType(EntitySubstituteDoll.OBSIDIAN_ID);

				parWorld.spawnEntityInWorld(entityToSpawn);
				entityToSpawn.onSpawnWithEgg((IEntityLivingData)null);
				entityToSpawn.playLivingSound();
			}
			else
			{
				//DEBUG
				System.out.println("Entity not found " + EntitySubstituteDoll.getMobName());
			}
		}

		return entityToSpawn;
	}
}