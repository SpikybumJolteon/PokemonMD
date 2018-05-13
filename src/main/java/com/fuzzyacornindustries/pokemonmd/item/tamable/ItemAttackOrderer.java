package com.fuzzyacornindustries.pokemonmd.item.tamable;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetabs.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.library.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemAttackOrderer extends Item
{
	public static String itemName = "attackorderer";

	public ItemAttackOrderer()
	{
		super();

		this.maxStackSize = 1;
		this.setUnlocalizedName(itemName);
		this.setTextureName(ModInfo.MODID + ":" + getItemName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDTamables);
	}

	static public String getItemName()
	{
		return itemName;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Right click a mob to order your Poketamables");
		parList.add("to attack mob. Sneak + right click cancels");
		parList.add("all of your Poketamables' attack orders.");
		parList.add("Poketamables will ignore orders to attack");
		parList.add("your own or other player's Poketamables");
		parList.add("or player entities.");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{	
		if(!entityPlayer.isSneaking())
		{
			boolean returnBoolean = false;

			EntityLivingBase targetEntity = getTarget(entityPlayer, 30D);

			//System.out.println( "Test Entity Detected By Kill Order" );
			//System.out.println( Integer.toString( targetEntity.getEntityId() ) );

			if (entityPlayer.getCurrentEquippedItem() == null)
			{
				return null;
			}

			if(targetEntity != null)
			{
				if(targetEntity instanceof TamablePokemon && ((TamablePokemon) targetEntity).getOwner() instanceof EntityPlayer || targetEntity instanceof EntityPlayer)
				{
					return itemStack;
				}
				
				TamablePokemon poketamable;

				for (int i = 0; i < entityPlayer.worldObj.loadedEntityList.size(); i++)
				{
					if (entityPlayer.worldObj.loadedEntityList.get(i) instanceof TamablePokemon)
					{
						poketamable = (TamablePokemon)entityPlayer.worldObj.loadedEntityList.get(i);

						if (!poketamable.worldObj.isRemote && poketamable.getOwner() == entityPlayer && !poketamable.isSitting())
						{
							poketamable.setAttackTarget(targetEntity);
						}
					}
				}
			}
		}
		else
		{
			TamablePokemon poketamable;

			for (int i = 0; i < world.loadedEntityList.size(); i++)
			{
				if (world.loadedEntityList.get(i) instanceof TamablePokemon)
				{
					poketamable = (TamablePokemon) world.loadedEntityList.get(i);

					if (!poketamable.worldObj.isRemote && poketamable.getOwner() == entityPlayer && !poketamable.isSitting())
					{
						poketamable.setAttackTarget(null);
					}
				}
			}
		}

		return itemStack;
	}

	public EntityLivingBase getTarget(EntityPlayer entityPlayer, double range)
	{
		List list = entityPlayer.worldObj.getEntitiesWithinAABBExcludingEntity(entityPlayer, entityPlayer.boundingBox.expand(range, range, range));
		Entity entity;

		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				entity = (Entity)list.get(i);

				if (!entity.isDead)
				{
					if(entity instanceof EntityLivingBase)
					{
						Vec3 vec3d;
						Vec3 vec3d1;
						double d;
						double d1;
						double a;
						double b;
						double c;

						vec3d = entityPlayer.getLook(1.0F).normalize();
						vec3d1 = Vec3.createVectorHelper(entity.posX - entityPlayer.posX, (entity.boundingBox.minY + (double)(entity.height / 2.0F)) - (entityPlayer.posY + (double)entityPlayer.getEyeHeight()), entity.posZ - entityPlayer.posZ);
						d = vec3d1.lengthVector();
						vec3d1 = vec3d1.normalize();
						d1 = vec3d.dotProduct(vec3d1);
						if (d1 > 1.0D - 0.025000000000000001D / d)
						{
							if(entity instanceof EntityLivingBase)
							{
								//System.out.println("Looking at " + entity);

								return (EntityLivingBase)entity;
							}
						}
					}

				}
			}
		}

		return (null);
	}
}