package com.fuzzyacornindustries.pokemonmd.entity.mob.ai;

import com.fuzzyacornindustries.pokemonmd.entity.mob.turret.EntityPrototurret;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class AIPrototurretStop extends EntityAIBase
{
    private EntityPrototurret theEntity;
    /** If the turret is stopped. */
    private boolean isStopped;
    private static final String __OBFID = "CL_00001613";

    public AIPrototurretStop(EntityPrototurret p_i1654_1_)
    {
        this.theEntity = p_i1654_1_;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.theEntity.isTamed())
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.theEntity.getOwner();
            return entitylivingbase == null ? true : (this.theEntity.getDistanceSqToEntity(entitylivingbase) < 144.0D && entitylivingbase.getAITarget() != null ? false : this.isStopped);
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.theEntity.getNavigator().clearPathEntity();
        this.theEntity.setStopped(true);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.theEntity.setStopped(false);
    }

    /**
     * Sets the sitting flag.
     */
    public void setStopped(boolean p_75270_1_)
    {
        this.isStopped = p_75270_1_;
    }
}