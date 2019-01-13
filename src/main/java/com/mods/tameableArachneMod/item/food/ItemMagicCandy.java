package com.mods.tameableArachneMod.item.food;

import java.util.Random;

import com.mods.tameableArachneMod.entity.EntityArachne;
import com.mods.tameableArachneMod.entity.EntityArachneMedium;
import com.mods.tameableArachneMod.entity.EntityHarpy;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemMagicCandy extends ItemFood
{
    public ItemMagicCandy(int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand)
    {
        if (target instanceof EntityLiving)
        {
            EntityLiving living = (EntityLiving) target;
            String customName = living.getCustomNameTag();
            World world = living.world;

            if (target instanceof EntityChicken)
            {
                if (!world.isRemote)
                {
                    EntityHarpy entity = new EntityHarpy(world);
                    entity.setLocationAndAngles(living.posX, living.posY, living.posZ, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
                    entity.rotationYawHead = entity.rotationYaw;
                    entity.renderYawOffset = entity.rotationYaw;
                    // entity.onSpawnWithEgg((IEntityLivingData) null);
                    world.spawnEntity(entity);
                    entity.playLivingSound();

                    if (customName != null && !customName.equals(""))
                    {
                        entity.setCustomNameTag(customName);
                        // entity.func_110163_bv();
                    }
                }

                playTameEffect(living, false);
                stack.shrink(1);
                living.setDead();

                return true;
            }
            else if (target instanceof EntitySpider)
            {
                if (!world.isRemote)
                {
                    Random rnd = new Random();

                    if (rnd.nextInt(2) == 0)
                    {
                        EntityArachne entity = new EntityArachne(world);
                        entity.setLocationAndAngles(living.posX, living.posY, living.posZ, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
                        entity.rotationYawHead = entity.rotationYaw;
                        entity.renderYawOffset = entity.rotationYaw;
                        // entity.onSpawnWithEgg((IEntityLivingData) null);
                        world.spawnEntity(entity);
                        entity.playLivingSound();

                        if (customName != null && !customName.equals(""))
                        {
                            entity.setCustomNameTag(customName);
                            // entity.func_110163_bv();
                        }
                    }
                    else
                    {
                        EntityArachneMedium entity = new EntityArachneMedium(world);
                        entity.setLocationAndAngles(living.posX, living.posY, living.posZ, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
                        entity.rotationYawHead = entity.rotationYaw;
                        entity.renderYawOffset = entity.rotationYaw;
                        // entity.onSpawnWithEgg((IEntityLivingData) null);
                        world.spawnEntity(entity);
                        entity.playLivingSound();

                        if (customName != null && !customName.equals(""))
                        {
                            entity.setCustomNameTag(customName);
                            // entity.func_110163_bv();
                        }
                    }
                }
                playTameEffect(living, false);
                stack.shrink(1);
                living.setDead();

                return true;
            }
        }

        return super.itemInteractionForEntity(stack, player, target, hand);
    }

    protected void playTameEffect(EntityLiving entityliving, boolean p_70908_1_)
    {
        Random rnd = new Random();
        EnumParticleTypes s = EnumParticleTypes.HEART;

        if (!p_70908_1_)
        {
            s = EnumParticleTypes.SMOKE_NORMAL;
        }

        for (int i = 0; i < 7; ++i)
        {
            double d0 = rnd.nextGaussian() * 0.02D;
            double d1 = rnd.nextGaussian() * 0.02D;
            double d2 = rnd.nextGaussian() * 0.02D;
            entityliving.world.spawnParticle(s, entityliving.posX + rnd.nextFloat() * entityliving.width * 2.0F - entityliving.width, entityliving.posY + 0.5D + rnd.nextFloat() * entityliving.height, entityliving.posZ + rnd.nextFloat() * entityliving.width * 2.0F - entityliving.width, d0, d1, d2);
        }
    }
}