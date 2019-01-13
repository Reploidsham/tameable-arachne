package com.mods.tameableArachneMod.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityAIFollowBunnyOwner extends EntityAIBase
{
    private EntityTameable thePet;
    private EntityLivingBase theOwner;
    World theWorld;
    private double field_75336_f;
    private PathNavigate petPathfinder;
    private int field_75343_h;
    float maxDist;
    float minDist;
    private boolean lastSwim;

    public EntityAIFollowBunnyOwner(EntityTameable animal, double p_i1625_2_, float min, float max)
    {
        this.thePet = animal;
        this.theWorld = animal.world;
        this.field_75336_f = p_i1625_2_;
        this.petPathfinder = animal.getNavigator();
        this.minDist = min;
        this.maxDist = max;
        this.setMutexBits(3);
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
        else if (this.thePet.isSitting())
        {
            return false;
        }
        else if (this.thePet.getDistanceSq(entitylivingbase) < this.minDist * this.minDist)
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
        return !this.petPathfinder.noPath() && this.thePet.getDistanceSq(this.theOwner) > this.maxDist * this.maxDist && !this.thePet.isSitting();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting()
    {
        this.field_75343_h = 0;
        this.lastSwim = this.thePet.getNavigator().getNodeProcessor().getCanSwim();
        this.thePet.getNavigator().getNodeProcessor().setCanSwim(false);
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask()
    {
        this.theOwner = null;
        this.petPathfinder.clearPath();
        this.thePet.getNavigator().getNodeProcessor().setCanSwim(this.lastSwim);
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask()
    {
        this.thePet.getLookHelper().setLookPositionWithEntity(this.theOwner, 10.0F, this.thePet.getVerticalFaceSpeed());

        if (!this.thePet.isSitting())
        {
            if (--this.field_75343_h <= 0)
            {
                this.field_75343_h = 10;

                if (!this.petPathfinder.tryMoveToEntityLiving(this.theOwner, this.field_75336_f))
                {
                    if (!this.thePet.getLeashed())
                    {
                        if (this.thePet.getDistanceSq(this.theOwner) >= 144.0D)
                        {
                            int i = MathHelper.floor(this.theOwner.posX) - 2;
                            int j = MathHelper.floor(this.theOwner.posZ) - 2;
                            int k = MathHelper.floor(this.theOwner.getEntityBoundingBox().minY);

                            for (int l = 0; l <= 4; ++l)
                            {
                                for (int i1 = 0; i1 <= 4; ++i1)
                                {
                                    BlockPos pos = new BlockPos(i + l, k - 1, j + i1);

                                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.theWorld.getTopSolidOrLiquidBlock(pos).getY() > 0 && !this.theWorld.getBlockState(new BlockPos(i + l, k, j + i1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l, k + 1, j + i1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l + 1, k, j + i1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l + 1, k + 1, j + i1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l - 1, k, j + i1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l - 1, k + 1, j + i1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l, k, j + i1 + 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l, k + 1, j + i1 + 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l, k, j + i1 - 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l, k + 1, j + i1 - 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l + 1, k, j + i1 + 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l + 1, k + 1, j + i1 + 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l + 1, k, j + i1 - 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l + 1, k + 1, j + i1 - 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l - 1, k, j + i1 + 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l - 1, k + 1, j + i1 + 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l - 1, k, j + i1 - 1)).isNormalCube() && !this.theWorld.getBlockState(new BlockPos(i + l - 1, k + 1, j + i1 - 1)).isNormalCube())
                                    {
                                        this.thePet.setLocationAndAngles(i + l + 0.5F, k, j + i1 + 0.5F, this.thePet.rotationYaw, this.thePet.rotationPitch);
                                        this.petPathfinder.clearPath();

                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}