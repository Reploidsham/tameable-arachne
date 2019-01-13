package com.mods.tameableArachneMod.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.potion.Potion;

public class EntityAIRemoveEffectOfOwner extends EntityAIBase
{
    private EntityTameable thePet;
    private EntityLivingBase theOwner;
    private float effectRange;
    private Potion posionId;

    public EntityAIRemoveEffectOfOwner(EntityTameable animal, float effectRange, Potion effect)
    {
        this.thePet = animal;
        this.effectRange = effectRange;
        this.posionId = effect;
        this.setMutexBits(8);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.thePet.getOwner();

        if (entitylivingbase == null)
        {
            return false;
        }
        else if (this.thePet.getDistanceSq(entitylivingbase) > this.effectRange * this.effectRange)
        {
            return false;
        }
        else
        {
            this.theOwner = entitylivingbase;
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return this.thePet.getDistanceSq(this.theOwner) < this.effectRange * this.effectRange;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting()
    {}

    /**
     * Resets the task
     */
    @Override
    public void resetTask()
    {
        this.theOwner = null;
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask()
    {
        if (this.theOwner.isPotionActive(this.posionId))
        {
            this.theOwner.removePotionEffect(this.posionId);
        }
    }
}