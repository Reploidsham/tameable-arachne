package com.mods.tameableArachneMod.entity;

import java.text.NumberFormat;

import com.mods.tameableArachneMod.TameableArachneCore;
import com.mods.tameableArachneMod.entity.ai.EntityAIFollowArachneOwner;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityArachne extends EntityTameable
{
    public static final DataParameter<Float> LAST_HEALTH = EntityDataManager.createKey(EntityArachne.class, DataSerializers.FLOAT);
    public static final DataParameter<Byte> FLAG = EntityDataManager.createKey(EntityArachne.class, DataSerializers.BYTE);
    public static final DataParameter<Integer> TYPE = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> ADD_HP = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> ADD_ATTACK = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> ADD_DEFENSE = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> PROTECTION = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> FIRE_PROTO = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> FALL_PROTO = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> BLAST_PROTO = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> PROJECTILE_PROTO = EntityDataManager.createKey(EntityArachne.class, DataSerializers.VARINT);

    private float field_70926_e;
    private float field_70924_f;

    private int attackTimer;

    private int randmTimer;
    private int winkTimer;
    protected float knockbackFactor = 0.6F;

    public EntityArachne(World world)
    {
        super(world);
        this.setSize(1.1F, 1.2F);
        this.setTamed(false);
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();

        this.getNavigator().getNodeProcessor().setCanSwim(false);
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowArachneOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getHpValue());
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    @Override
    public void setAttackTarget(EntityLivingBase target)
    {
        super.setAttackTarget(target);

        if (target == null)
        {
            this.setAngry(false);
        }
        else if (!this.isTamed())
        {
            this.setAngry(true);
        }
    }

    @Override
    protected void updateAITasks()
    {
        super.updateAITasks();

        this.dataManager.set(LAST_HEALTH, this.getHealth());
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();

        // 18 - 20
        this.dataManager.register(LAST_HEALTH, this.getHealth());
        this.dataManager.register(FLAG, (byte) 0);
        this.dataManager.register(TYPE, this.rand.nextInt(8) == 0 ? 1 : 0);

        // 21 - 23
        this.dataManager.register(ADD_HP, 0);
        this.dataManager.register(ADD_ATTACK, 0);
        this.dataManager.register(ADD_DEFENSE, 0);

        // 24 - 28
        this.dataManager.register(PROTECTION, 0);
        this.dataManager.register(FIRE_PROTO, 0);
        this.dataManager.register(FALL_PROTO, 0);
        this.dataManager.register(BLAST_PROTO, 0);
        this.dataManager.register(PROJECTILE_PROTO, 0);
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setBoolean("Angry", this.isAngry());
        tag.setInteger("TextureNo", this.getTextureNo());
        tag.setInteger("AddHp", this.getAddHp());
        tag.setInteger("AddAttack", this.getAddAttack());
        tag.setInteger("AddDefense", this.getAddDefense());

        tag.setInteger("Protection", this.getProtection());
        tag.setInteger("FireProtection", this.getFireProtection());
        tag.setInteger("FallProtection", this.getFallProtection());
        tag.setInteger("BlastProtection", this.getBlastProtection());
        tag.setInteger("ProjectileProtection", this.getProjectileProtection());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        this.setAngry(tag.getBoolean("Angry"));
        this.setTextureNo(tag.getInteger("TextureNo"));
        this.setAddHp(tag.getInteger("AddHp"));
        this.setAddAttack(tag.getInteger("AddAttack"));
        this.setAddDefense(tag.getInteger("AddDefense"));

        this.setProtection(tag.getInteger("Protection"));
        this.setFireProtection(tag.getInteger("FireProtection"));
        this.setFallProtection(tag.getInteger("FallProtection"));
        this.setBlastProtection(tag.getInteger("BlastProtection"));
        this.setProjectileProtection(tag.getInteger("ProjectileProtection"));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    @Override
    protected Item getDropItem()
    {
        return Items.STRING;
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }

        if (TameableArachneCore.AutoHeal)
        {
            if (this.ticksExisted % TameableArachneCore.AutoHealInterval == 0)
            {
                if (this.dataManager.get(LAST_HEALTH) < this.getHpValue())
                {
                    this.heal(TameableArachneCore.AutoHealValue);
                }
            }
        }

        if (this.winkTimer > 0)
        {
            --this.winkTimer;

            if (this.winkTimer == 0)
            {
                this.winkTimer = -1;
            }
        }
        else if (this.randmTimer > 0)
        {
            --this.randmTimer;

            if (this.randmTimer == 0)
            {
                this.randmTimer = -1;
                this.winkTimer = 3;
            }
        }
        else
        {
            if (this.ticksExisted % 120 == 0)
            {
                randmTimer = this.rand.nextInt(75);
            }
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.field_70924_f = this.field_70926_e;

        if (this.func_70922_bv())
        {
            this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
        }
        else
        {
            this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
        }

        if (this.func_70922_bv())
        {
            // this.numTicksToChaseTarget = 10;
        }
    }

    @Override
    public float getEyeHeight()
    {
        return this.height * 0.9F;
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(float p_70917_1_)
    {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * p_70917_1_) * 0.15F * (float) Math.PI;
    }

    @Override
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            if (damage >= 1.0F && getProtection() > 0)
            {
                damage = damage * ((100F - getProtection()) / 100F);
            }
            if (source.isFireDamage() && damage >= 1.0F && getFireProtection() > 0)
            {
                damage = damage * ((100F - getFireProtection()) / 100F);
            }
            if (source == DamageSource.FALL && damage >= 1.0F && getFallProtection() > 0)
            {
                damage = damage * ((100F - getFallProtection()) / 100F);
            }
            if (source.isExplosion() && damage >= 1.0F && getBlastProtection() > 0)
            {
                damage = damage * ((100F - getBlastProtection()) / 100F);
            }
            if (source.isProjectile() && damage >= 1.0F && getProjectileProtection() > 0)
            {
                damage = damage * ((100F - getProjectileProtection()) / 100F);
            }

            if (damage < 1.0F)
            {
                return false;
            }

            Entity entity = source.getTrueSource();

            if (this.aiSit != null)
            {
                this.aiSit.setSitting(false);
            }

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                damage = (damage + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, damage);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        this.attackTimer = 12;
        this.world.setEntityState(this, (byte) 4);

        int i = this.getAttackValue();

        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 4 && this.attackTimer < 1)
        {
            this.attackTimer = 12;
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
    }

    @SideOnly(Side.CLIENT)
    public int getWinkTimer()
    {
        return this.winkTimer;
    }

    @Override
    public int getTotalArmorValue()
    {
        return this.getDefenseValue();
    }

    @Override
    public void setTamed(boolean p_70903_1_)
    {
        super.setTamed(p_70903_1_);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);

        if (!stack.isEmpty())
        {
            if (stack.getItem() == TameableArachneCore.magicCandy)
            {
                if (!this.isTamed() || (this.isTamed() && this.isOwner(player)))
                {
                    if (!player.capabilities.isCreativeMode)
                    {
                        stack.shrink(1);
                    }

                    if (!this.world.isRemote)
                    {
                        this.magicCandyThing();
                    }

                    this.playTameEffect(false);

                    if (stack.isEmpty())
                    {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                    }

                    return true;
                }
            }
        }

        if (this.isTamed())
        {
            if (!stack.isEmpty())
            {
                if (this.isOwner(player))
                {
                    if (stack.getItem() == Items.BUCKET)
                    {
                        stack.shrink(1);

                        if (stack.getCount() == 1)
                        {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.MILK_BUCKET));
                        }
                        else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET)))
                        {
                            player.dropItem(new ItemStack(Items.MILK_BUCKET, 1, 0), false);
                        }

                        this.playTameEffect(true);

                        return true;
                    }

                    if (this.canPowerUp())
                    {
                        if (stack.getItem() == Items.GOLD_INGOT)
                        {
                            if (!player.capabilities.isCreativeMode)
                            {
                                stack.shrink(1);
                            }

                            this.setAddHp(this.getAddHp() + 1);
                            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getHpValue());
                            this.playTameEffect(true);

                            if (stack.getCount() <= 0)
                            {
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                            }

                            return true;
                        }

                        if (stack.getItem() == Items.DIAMOND)
                        {
                            if (!player.capabilities.isCreativeMode)
                            {
                                stack.shrink(1);
                            }

                            this.setAddAttack(this.getAddAttack() + 1);
                            this.playTameEffect(true);

                            if (stack.isEmpty())
                            {
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                            }

                            return true;
                        }

                        if (stack.getItem() == Items.IRON_INGOT)
                        {
                            if (!player.capabilities.isCreativeMode)
                            {
                                stack.shrink(1);
                            }

                            this.setAddDefense(this.getAddDefense() + 1);
                            this.playTameEffect(true);

                            if (stack.isEmpty())
                            {
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                            }

                            return true;
                        }
                    }

                    if (this.getAddHp() > 0 && stack.getItem() == Item.getItemFromBlock(Blocks.GOLD_BLOCK))
                    {
                        this.setAddHp(this.getAddHp() - 1);
                        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getHpValue());
                        this.heal(0F);
                        this.playTameEffect(false);

                        return true;
                    }

                    if (this.getAddAttack() > 0 && stack.getItem() == Item.getItemFromBlock(Blocks.DIAMOND_BLOCK))
                    {
                        this.setAddAttack(this.getAddAttack() - 1);
                        this.playTameEffect(false);

                        return true;
                    }

                    if (this.getAddDefense() > 0 && stack.getItem() == Item.getItemFromBlock(Blocks.IRON_BLOCK))
                    {
                        this.setAddDefense(this.getAddDefense() - 1);
                        this.playTameEffect(false);

                        return true;
                    }

                    if (stack.hasTagCompound())
                    {
                        NBTTagList nbttaglist = stack.getEnchantmentTagList();

                        if (nbttaglist != null)
                        {
                            boolean update = false;
                            for (int i = 0; i < nbttaglist.tagCount(); ++i)
                            {
                                short short1 = nbttaglist.getCompoundTagAt(i).getShort("id");
                                short short2 = nbttaglist.getCompoundTagAt(i).getShort("lvl");

                                Enchantment ench = Enchantment.getEnchantmentByID(short1);
                                if (ench instanceof EnchantmentProtection)
                                {
                                    EnchantmentProtection.Type type = ((EnchantmentProtection) ench).protectionType;

                                    switch (type)
                                    {
                                        case ALL:
                                            if (canUpFireProtection())
                                            {
                                                int temp = getFireProtection() + (2 * short2);
                                                if (temp > TameableArachneCore.FireProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.FireProtectionLimit;
                                                }
                                                setFireProtection(temp);
                                                update = true;
                                            }
                                            if (canUpFallProtection())
                                            {
                                                int temp = getFallProtection() + (2 * short2);
                                                if (temp > TameableArachneCore.FallProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.FallProtectionLimit;
                                                }
                                                setFallProtection(temp);
                                                update = true;
                                            }
                                            if (canUpBlastProtection())
                                            {
                                                int temp = getBlastProtection() + (2 * short2);
                                                if (temp > TameableArachneCore.BlastProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.BlastProtectionLimit;
                                                }
                                                setBlastProtection(temp);
                                                update = true;
                                            }
                                            if (canUpProjectileProtection())
                                            {
                                                int temp = getProjectileProtection() + (2 * short2);
                                                if (temp > TameableArachneCore.ProjectileProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.ProjectileProtectionLimit;
                                                }
                                                setProjectileProtection(temp);
                                                update = true;
                                            }
                                        break;

                                        case FIRE:
                                            if (canUpFireProtection())
                                            {
                                                int temp = getFireProtection() + (10 * short2);
                                                if (temp > TameableArachneCore.FireProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.FireProtectionLimit;
                                                }
                                                setFireProtection(temp);
                                                update = true;
                                            }
                                        break;

                                        case FALL:
                                            if (canUpFallProtection())
                                            {
                                                int temp = getFallProtection() + (10 * short2);
                                                if (temp > TameableArachneCore.FallProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.FallProtectionLimit;
                                                }
                                                setFallProtection(temp);
                                                update = true;
                                            }
                                        break;

                                        case EXPLOSION:
                                            if (canUpBlastProtection())
                                            {
                                                int temp = getBlastProtection() + (10 * short2);
                                                if (temp > TameableArachneCore.BlastProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.BlastProtectionLimit;
                                                }
                                                setBlastProtection(temp);
                                                update = true;
                                            }
                                        break;

                                        case PROJECTILE:
                                            if (canUpProjectileProtection())
                                            {
                                                int temp = getProjectileProtection() + (10 * short2);
                                                if (temp > TameableArachneCore.ProjectileProtectionLimit)
                                                {
                                                    temp = TameableArachneCore.ProjectileProtectionLimit;
                                                }
                                                setProjectileProtection(temp);
                                                update = true;
                                            }
                                        break;

                                        default:
                                        break;
                                    }
                                }
                            }

                            if (update)
                            {
                                if (!player.capabilities.isCreativeMode)
                                {
                                    stack.getTagCompound().removeTag("ench");
                                }

                                this.playTameEffect(true);

                                return true;
                            }
                        }
                    }
                }

                if (stack.getItem() == Items.BOOK)
                {
                    if (this.world.isRemote)
                    {
                        NumberFormat format = NumberFormat.getInstance();
                        format.setMaximumFractionDigits(1);
                        float hp = this.dataManager.get(LAST_HEALTH) / 2F;
                        float maxHp = getHpValue() / 2F;
                        float attack = getAttackValue() / 2F;
                        float defense = getDefenseValue() / 2F;
                        int powerups = this.getAddHp() + this.getAddAttack() + this.getAddDefense();

                        player.sendMessage(new TextComponentString("HP:" + format.format(hp) + "/" + format.format(maxHp) + " Attack:" + format.format(attack) + " Defense:" + format.format(defense) + " PowerUp:" + powerups));
                        player.sendMessage(new TextComponentString("Protections Fire:" + getFireProtection() + " Fall:" + getFallProtection() + " Blast:" + getBlastProtection() + " Projectile:" + getProjectileProtection() + ""));
                    }

                    return true;
                }

                if (stack.getItem() == Items.CHICKEN)
                {
                    if (this.dataManager.get(LAST_HEALTH) < this.getHpValue())
                    {
                        if (!player.capabilities.isCreativeMode)
                        {
                            stack.shrink(1);
                        }

                        float healValue = this.getHpValue() / 2;
                        this.heal(healValue);

                        if (stack.isEmpty())
                        {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                        }

                        return true;
                    }
                }
            }

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack))
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                // this.setPathToEntity((PathEntity) null);
                this.setAttackTarget((EntityLivingBase) null);
            }
        }
        else if (!stack.isEmpty() && stack.getItem() == Items.CHICKEN && !this.isAngry())
        {
            if (!player.capabilities.isCreativeMode)
            {
                stack.shrink(1);
            }

            if (stack.isEmpty())
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
            }

            if (!this.world.isRemote)
            {
                if (this.rand.nextInt(2) == 0)
                {
                    this.setTamed(true);
                    // this.setPathToEntity((PathEntity) null);
                    this.setAttackTarget((EntityLivingBase) null);
                    this.aiSit.setSitting(true);
                    this.setHealth(this.getHpValue());
                    this.setOwnerId(player.getUniqueID());
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    protected void magicCandyThing()
    {
        this.setTextureNo(this.getTextureNo() == 0 ? 1 : 0);
    }

    @Override
    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
        return false;
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 8;
    }

    public boolean isAngry()
    {
        return (this.dataManager.get(EntityTameable.TAMED) & 2) != 0;
    }

    public void setAngry(boolean p_70916_1_)
    {
        byte b0 = this.dataManager.get(EntityTameable.TAMED);

        if (p_70916_1_)
        {
            this.dataManager.set(EntityTameable.TAMED, (byte) (b0 | 2));
        }
        else
        {
            this.dataManager.set(EntityTameable.TAMED, (byte) (b0 & -3));
        }
    }

    @Override
    public EntityArachne createChild(EntityAgeable p_90011_1_)
    {
        return null;
    }

    public boolean func_70922_bv()
    {
        return this.dataManager.get(FLAG) == 1;
    }

    public void func_70918_i(boolean flag)
    {
        this.dataManager.set(FLAG, (byte) (flag ? 1 : 0));
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
        else if (!(mate instanceof EntityArachne))
        {
            return false;
        }
        else
        {
            EntityArachne arachne = (EntityArachne) mate;

            return !arachne.isTamed() ? false : (arachne.isSitting() ? false : this.isInLove() && arachne.isInLove());
        }
    }

    @Override
    protected boolean canDespawn()
    {
        return !this.isTamed() && this.ticksExisted > 24000;
    }

    public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
    {
        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))
        {
            if (p_142018_1_ instanceof EntityArachne)
            {
                EntityArachne entitylamia = (EntityArachne) p_142018_1_;

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
    public void setInWeb()
    {}

    @Override
    public boolean isPotionApplicable(PotionEffect effect)
    {
        return effect.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(effect);
    }

    /**
     * knocks back this entity
     */
    @Override
    public void knockBack(Entity p_70653_1_, float p_70653_2_, double p_70653_3_, double p_70653_5_)
    {
        if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue())
        {
            this.isAirBorne = true;
            float f1 = MathHelper.sqrt(p_70653_3_ * p_70653_3_ + p_70653_5_ * p_70653_5_);
            float f2 = 0.4F * this.knockbackFactor;
            this.motionX /= 2.0D;
            this.motionY /= 2.0D;
            this.motionZ /= 2.0D;
            this.motionX -= p_70653_3_ / f1 * f2;
            this.motionY += f2;
            this.motionZ -= p_70653_5_ / f1 * f2;

            if (this.motionY > 0.4000000059604645D)
            {
                this.motionY = 0.4000000059604645D;
            }
        }
    }

    public int getTextureNo()
    {
        return this.dataManager.get(TYPE);
    }

    public void setTextureNo(int type)
    {
        this.dataManager.set(TYPE, type);
    }

    public int getAddHp()
    {
        return this.dataManager.get(ADD_HP);
    }

    public void setAddHp(int par1)
    {
        this.dataManager.set(ADD_HP, par1);
    }

    public int getAddAttack()
    {
        return this.dataManager.get(ADD_ATTACK);
    }

    public void setAddAttack(int par1)
    {
        this.dataManager.set(ADD_ATTACK, par1);
    }

    public int getAddDefense()
    {
        return this.dataManager.get(ADD_DEFENSE);
    }

    public void setAddDefense(int par1)
    {
        this.dataManager.set(ADD_DEFENSE, par1);
    }

    public int getHpValue()
    {
        int cnt = this.getAddHp();
        return TameableArachneCore.ArachneBaseHp + (cnt * TameableArachneCore.HpUp);
    }

    public int getAttackValue()
    {
        int cnt = this.getAddAttack();
        if (isNameBonus())
        {
            cnt = cnt + TameableArachneCore.NameBonusValue;
        }
        return TameableArachneCore.ArachneBaseAttack + (cnt * TameableArachneCore.AttackUp);
    }

    public int getDefenseValue()
    {
        int cnt = this.getAddDefense();
        if (isNameBonus())
        {
            cnt = cnt + TameableArachneCore.NameBonusValue;
        }
        return TameableArachneCore.ArachneBaseDefense + (cnt * TameableArachneCore.DefenseUp);
    }

    private boolean canPowerUp()
    {
        int totalValue = 0;
        totalValue = this.getAddHp() + this.getAddAttack() + this.getAddDefense();
        if (totalValue < TameableArachneCore.PowerUpLimit)
        {
            return true;
        }
        else
        {
            return false;
        }
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

    public int getProtection()
    {
        return this.dataManager.get(PROTECTION);
    }

    public void setProtection(int par1)
    {
        this.dataManager.set(PROTECTION, par1);
    }

    public int getFireProtection()
    {
        return this.dataManager.get(FIRE_PROTO);
    }

    public void setFireProtection(int par1)
    {
        this.dataManager.set(FIRE_PROTO, par1);
    }

    public int getFallProtection()
    {
        return this.dataManager.get(FALL_PROTO);
    }

    public void setFallProtection(int par1)
    {
        this.dataManager.set(FALL_PROTO, par1);
    }

    public int getBlastProtection()
    {
        return this.dataManager.get(BLAST_PROTO);
    }

    public void setBlastProtection(int par1)
    {
        this.dataManager.set(BLAST_PROTO, par1);
    }

    public int getProjectileProtection()
    {
        return this.dataManager.get(PROJECTILE_PROTO);
    }

    public void setProjectileProtection(int par1)
    {
        this.dataManager.set(PROJECTILE_PROTO, par1);
    }

    private boolean canUpProtection()
    {
        return getProtection() < TameableArachneCore.ProtectionLimit;
    }

    private boolean canUpFireProtection()
    {
        return getFireProtection() < TameableArachneCore.FireProtectionLimit;
    }

    private boolean canUpFallProtection()
    {
        return getFallProtection() < TameableArachneCore.FallProtectionLimit;
    }

    private boolean canUpBlastProtection()
    {
        return getBlastProtection() < TameableArachneCore.BlastProtectionLimit;
    }

    private boolean canUpProjectileProtection()
    {
        return getProjectileProtection() < TameableArachneCore.ProjectileProtectionLimit;
    }
}