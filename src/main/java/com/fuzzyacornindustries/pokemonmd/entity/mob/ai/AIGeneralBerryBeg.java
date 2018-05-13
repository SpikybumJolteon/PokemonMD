package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.fuzzyacornindustries.pokemonmd.entity.mob.tamable.TamablePokemon;
import com.fuzzyacornindustries.pokemonmd.item.BerryItem;

public class AIGeneralBerryBeg extends EntityAIBase
{
    private TamablePokemon tameable;
    private EntityPlayer thePlayer;
    private World worldObject;
    private float minPlayerDistance;
    private int field_75384_e;
    private static final String __OBFID = "CL_00001576";

    public AIGeneralBerryBeg(TamablePokemon tameable, float p_i1617_2_)
    {
        this.tameable = tameable;
        this.worldObject = tameable.worldObj;
        this.minPlayerDistance = p_i1617_2_;
        this.setMutexBits(2);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        this.thePlayer = this.worldObject.getClosestPlayerToEntity(this.tameable, (double)this.minPlayerDistance);
        return this.thePlayer == null ? false : this.hasPlayerGotBerryInHand(this.thePlayer);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.thePlayer.isEntityAlive() ? false : (this.tameable.getDistanceSqToEntity(this.thePlayer) > (double)(this.minPlayerDistance * this.minPlayerDistance) ? false : this.field_75384_e > 0 && this.hasPlayerGotBerryInHand(this.thePlayer));
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.tameable.func_70918_i(true);
        this.field_75384_e = 40 + this.tameable.getRNG().nextInt(40);
        this.tameable.isBegging = true;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.tameable.func_70918_i(false);
        this.thePlayer = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.tameable.getLookHelper().setLookPosition(this.thePlayer.posX, this.thePlayer.posY + (double)this.thePlayer.getEyeHeight(), this.thePlayer.posZ, 10.0F, (float)this.tameable.getVerticalFaceSpeed());
        --this.field_75384_e;
    }

    /**
     * Gets if the Player has the Bone in the hand.
     */
    private boolean hasPlayerGotBerryInHand(EntityPlayer p_75382_1_)
    {
        ItemStack itemstack = p_75382_1_.inventory.getCurrentItem();
        return itemstack == null ? false : (itemstack.getItem() instanceof BerryItem ? true : false);
    }
}