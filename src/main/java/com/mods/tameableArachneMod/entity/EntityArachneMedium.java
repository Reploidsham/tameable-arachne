package com.mods.tameableArachneMod.entity;

import com.mods.tameableArachneMod.TameableArachneCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityArachneMedium extends EntityArachne
{
    public EntityArachneMedium(World world)
    {
        super(world);
        this.setSize(1.2F, 1.8F);
        this.knockbackFactor = 0.4F;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
    }

    @Override
    public boolean isAIEnabled()
    {
        return true;
    }

    @Override
    public void setAttackTarget(EntityLivingBase p_70624_1_)
    {
        super.setAttackTarget(p_70624_1_);

        if (p_70624_1_ == null)
        {
            this.setAngry(false);
        }
        else if (!this.isTamed())
        {
            this.setAngry(true);
        }
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 4;
    }

    @Override
    public boolean canMateWith(EntityAnimal mate)
    {
        if (mate == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(mate instanceof EntityArachneMedium))
        {
            return false;
        }
        else
        {
            EntityArachneMedium arachne = (EntityArachneMedium) mate;

            return !arachne.isTamed() ? false : (arachne.isSitting() ? false : this.isInLove() && arachne.isInLove());
        }
    }

    @Override
    public int getHpValue()
    {
        int cnt = this.getAddHp();
        return TameableArachneCore.ArachneMediumBaseHp + (cnt * TameableArachneCore.HpUp);
    }

    @Override
    public int getAttackValue()
    {
        int cnt = this.getAddAttack();
        if (isNameBonus())
        {
            cnt = cnt + TameableArachneCore.NameBonusValue;
        }
        return TameableArachneCore.ArachneMediumBaseAttack + (cnt * TameableArachneCore.AttackUp);
    }

    @Override
    public int getDefenseValue()
    {
        int cnt = this.getAddDefense();
        if (isNameBonus())
        {
            cnt = cnt + TameableArachneCore.NameBonusValue;
        }
        return TameableArachneCore.ArachneMediumBaseDefense + (cnt * TameableArachneCore.DefenseUp);
    }

    private boolean isNameBonus()
    {
        boolean ret = false;
        if (TameableArachneCore.NameBonus)
        {
            try
            {
                String customName = this.getCustomNameTag();
                if (customName != null && !customName.equals(""))
                {
                    ret = true;
                }
            }
            catch (Exception e)
            {}
        }
        return ret;
    }
}