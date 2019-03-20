package com.mods.tameableArachneMod.entity;

import com.mods.tameableArachneMod.TameableArachneCore;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityHarpy extends EntityArachne
{
    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;

    public EntityHarpy(World world)
    {
        super(world);
        this.setSize(0.3F, 1.5F);
        this.setTamed(false);
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        SoundType soundtype = blockIn.getSoundType(world.getBlockState(pos), world, pos, this);

        if (this.world.getBlockState(pos.up()).getBlock() == Blocks.SNOW_LAYER)
        {
            soundtype = Blocks.SNOW_LAYER.getSoundType();
            this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
        }
        else if (!blockIn.getDefaultState().getMaterial().isLiquid())
        {
            this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
        }
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getHpValue());
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();

        this.dataManager.set(EntityArachne.TYPE, this.rand.nextInt(14));
    }

    @Override
    protected void magicCandyThing()
    {
        int texture = this.getTextureNo() + 1;

        this.setTextureNo(texture > 13 ? 0 : texture);
    }

    @Override
    protected Item getDropItem()
    {
        return Items.FEATHER;
    }

    @Override
    public boolean attackEntityAsMob(Entity item)
    {
        try
        {
            if (this.rand.nextInt(100) < TameableArachneCore.HarpyAddDropRate)
            {
                ItemStack dropItem = this.getEntityDropItem(item);

                if (dropItem != null)
                {
                    item.entityDropItem(dropItem, item.height / 2F);
                }
            }
        }
        catch (Exception e)
        {}

        int i = this.getAttackValue();
        return item.attackEntityFrom(DamageSource.causeMobDamage(this), i);
    }

    private ItemStack getEntityDropItem(Entity entity)
    {
        ItemStack itemStack = null;

        if (entity instanceof EntityLiving)
        {
            if (entity instanceof EntityChicken)
            {
                itemStack = new ItemStack(Items.FEATHER, 1, 0);
            }
            else if (entity instanceof EntityCow)
            {
                itemStack = new ItemStack(Items.LEATHER, 1, 0);
            }
            else if (entity instanceof EntityHorse)
            {
                itemStack = new ItemStack(Items.LEATHER, 1, 0);
            }
            else if (entity instanceof EntityPig)
            {
                itemStack = new ItemStack(entity.isBurning() ? Items.COOKED_PORKCHOP : Items.PORKCHOP, 1, 0);
            }
            else if (entity instanceof EntitySheep)
            {
                itemStack = new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, ((EntitySheep) entity).getFleeceColor().getMetadata());
            }
            else if (entity instanceof EntityOcelot)
            {
                itemStack = new ItemStack(Items.LEATHER, 1, 0);
            }
            else if (entity instanceof EntityWolf)
            {
                itemStack = new ItemStack(Items.LEATHER, 1, 0);
            }
            else if (entity instanceof EntitySnowman)
            {
                itemStack = new ItemStack(Items.SNOWBALL, 1, 0);
            }
            else if (entity instanceof EntitySquid)
            {
                itemStack = new ItemStack(Items.DYE, 1, 0);
            }
            else if (entity instanceof EntityBlaze)
            {
                itemStack = new ItemStack(Items.BLAZE_ROD, 1, 0);
            }
            else if (entity instanceof EntityCreeper)
            {
                itemStack = new ItemStack(Items.GUNPOWDER, 1, 0);
            }
            else if (entity instanceof EntityEnderman)
            {
                itemStack = new ItemStack(Items.ENDER_PEARL, 1, 0);
            }
            else if (entity instanceof EntitySkeleton)
            {
                itemStack = new ItemStack(Items.BONE, 1, 0);
            }
            else if (entity instanceof EntitySpider)
            {
                itemStack = new ItemStack(Items.STRING, 1, 0);
            }
            else if (entity instanceof EntityZombie)
            {
                itemStack = new ItemStack(Items.ROTTEN_FLESH, 1, 0);
            }
            else if (entity instanceof EntityGhast)
            {
                itemStack = new ItemStack(Items.GUNPOWDER, 1, 0);
            }
            else if (entity instanceof EntitySlime)
            {
                itemStack = new ItemStack(Items.SLIME_BALL, 1, 0);
            }
            else if (entity instanceof EntityArachne)
            {
                itemStack = new ItemStack(Items.STRING, 1, 0);
            }
            else if (entity instanceof EntityArachneMedium)
            {
                itemStack = new ItemStack(Items.STRING, 1, 0);
            }
            else if (entity instanceof EntityHarpy)
            {
                itemStack = new ItemStack(Items.FEATHER, 1, 0);
            }
            else
            {
                itemStack = null;
            }
        }
        return itemStack;
    }

    @Override
    public void fall(float distance, float damageMultiplier)
    {}

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 8;
    }

    @Override
    public boolean canMateWith(EntityAnimal p_70878_1_)
    {
        if (p_70878_1_ == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(p_70878_1_ instanceof EntityHarpy))
        {
            return false;
        }
        else
        {
            EntityHarpy entitylamia = (EntityHarpy) p_70878_1_;
            return !entitylamia.isTamed() ? false : (entitylamia.isSitting() ? false : this.isInLove() && entitylamia.isInLove());
        }
    }

    @Override
    protected boolean canDespawn()
    {
        return !this.isTamed() && this.ticksExisted > 24000;
    }

    @Override
    public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
    {
        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))
        {
            if (p_142018_1_ instanceof EntityHarpy)
            {
                EntityHarpy entitylamia = (EntityHarpy) p_142018_1_;

                if (entitylamia.isTamed() && entitylamia.getOwner() == p_142018_2_)
                {
                    return false;
                }
            }

            return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer) p_142018_2_).canAttackPlayer((EntityPlayer) p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse) p_142018_1_).isTame();
        }
        else
        {
            return false;
        }
    }

    @Override
    public int getHpValue()
    {
        int cnt = this.getAddHp();
        return TameableArachneCore.HarpyBaseHp + (cnt * TameableArachneCore.HpUp);
    }

    @Override
    public int getAttackValue()
    {
        int cnt = this.getAddAttack();
        if (isNameBonus())
        {
            cnt = cnt + TameableArachneCore.NameBonusValue;
        }
        return TameableArachneCore.HarpyBaseAttack + (cnt * TameableArachneCore.AttackUp);
    }

    @Override
    public int getDefenseValue()
    {
        int cnt = this.getAddDefense();
        if (isNameBonus())
        {
            cnt = cnt + TameableArachneCore.NameBonusValue;
        }
        return TameableArachneCore.HarpyBaseDefense + (cnt * TameableArachneCore.DefenseUp);
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
