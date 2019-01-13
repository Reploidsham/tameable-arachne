package com.mods.tameableArachneMod.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityAIAddEffectToOwner extends EntityAIBase
{
    private EntityTameable thePet;
    private EntityLivingBase theOwner;
    World theWorld;
    private float effectRange;
    private Potion posionId;
    private int effectTime;
    private int effectLevel;

    public EntityAIAddEffectToOwner(EntityTameable animal, float range, Potion potion, int duration, int amplifier)
    {
        this.thePet = animal;
        this.theWorld = animal.world;
        this.effectRange = range;
        this.posionId = potion;
        this.effectTime = duration;
        this.effectLevel = amplifier;
        this.setMutexBits(10);
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
        this.theOwner.addPotionEffect(new PotionEffect(this.posionId, this.effectTime, this.effectLevel));
    }
}