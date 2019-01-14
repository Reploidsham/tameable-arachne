package com.mods.tameableArachneMod;

import com.mods.tameableArachneMod.entity.EntityArachne;
import com.mods.tameableArachneMod.entity.EntityArachneMedium;
import com.mods.tameableArachneMod.entity.EntityHarpy;
import com.mods.tameableArachneMod.item.food.ItemMagicCandy;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TameableArachneCore.MODID, name = TameableArachneCore.MODNAME, version = TameableArachneCore.VERSION)
public class TameableArachneCore
{
    public static final String MODID = "tameable_arachne";
    public static final String MODNAME = "Tameable Arachne";
    public static final String VERSION = "1.01";

    public static boolean ArachneSpawnFlg = true;
    public static int ArachneEntityId = 180;
    public static int ArachneBaseHp = 20;
    public static int ArachneBaseAttack = 4;
    public static int ArachneBaseDefense = 2;

    public static boolean ArachneMediumSpawnFlg = true;
    public static int ArachneMediumEntityId = 181;
    public static int ArachneMediumBaseHp = 30;
    public static int ArachneMediumBaseAttack = 6;
    public static int ArachneMediumBaseDefense = 3;

    public static boolean HarpySpawnFlg = true;
    public static int HarpyEntityId = 182;
    public static int HarpyBaseHp = 20;
    public static int HarpyBaseAttack = 2;
    public static int HarpyBaseDefense = 6;
    public static int HarpyAddDropRate = 30;

    public static int HpUp = 2;
    public static int AttackUp = 1;
    public static int DefenseUp = 1;
    public static int PowerUpLimit = 16;
    public static boolean NameBonus = true;
    public static int NameBonusValue = 1;
    public static boolean AutoHeal = true;
    public static int AutoHealValue = 1;
    public static int AutoHealInterval = 50;
    public static boolean CraftSpawnEgg = false;
    public static int ProtectionLimit = 80;
    public static int FireProtectionLimit = 80;
    public static int FallProtectionLimit = 80;
    public static int BlastProtectionLimit = 80;
    public static int ProjectileProtectionLimit = 80;

    public static Item magicCandy;

    @SidedProxy(clientSide = "com.mods.tameableArachneMod.TameableArachneClientProxy", serverSide = "com.mods.tameableArachneMod.TameableArachneCommonProxy")
    public static TameableArachneCommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

        try
        {
            cfg.load();

            ArachneSpawnFlg = cfg.get("spown", "arachneSpawnFlg", true).getBoolean();
            ArachneEntityId = cfg.get("entityid", "arachneEntityId", 180).getInt();
            ArachneBaseHp = cfg.get("arachne", "arachneBaseHp", 20).getInt();
            ArachneBaseAttack = cfg.get("arachne", "arachneBaseAttack", 4).getInt();
            ArachneBaseDefense = cfg.get("arachne", "arachneBaseDefense", 2).getInt();

            ArachneMediumSpawnFlg = cfg.get("spown", "arachneMediumSpawnFlg", true).getBoolean();
            ArachneMediumEntityId = cfg.get("entityid", "arachneMediumEntityId", 181).getInt();
            ArachneMediumBaseHp = cfg.get("arachne medium", "arachneMediumBaseHp", 30).getInt();
            ArachneMediumBaseAttack = cfg.get("arachne medium", "arachneMediumBaseAttack", 6).getInt();
            ArachneMediumBaseDefense = cfg.get("arachne medium", "arachneMediumBaseDefense", 3).getInt();

            HarpySpawnFlg = cfg.get("spown", "harpySpawnFlg", true).getBoolean();
            HarpyEntityId = cfg.get("entityid", "harpyEntityId", 182).getInt();
            HarpyBaseHp = cfg.get("harpy", "harpyBaseHp", 20).getInt();
            HarpyBaseAttack = cfg.get("harpy", "harpyBaseAttack", 2).getInt();
            HarpyBaseDefense = cfg.get("harpy", "harpyBaseDefense", 6).getInt();
            HarpyAddDropRate = cfg.get("harpy", "harpyAddDropRate", 30).getInt();

            HpUp = cfg.get("entity", "hpUp", 2).getInt();
            AttackUp = cfg.get("entity", "attackUp", 1).getInt();
            DefenseUp = cfg.get("entity", "defenseUp", 1).getInt();
            PowerUpLimit = cfg.get("entity", "powerUpLimit", 16).getInt();
            NameBonus = cfg.get("entity", "nameBonus", true).getBoolean();
            NameBonusValue = cfg.get("entity", "nameBonusValue", 1).getInt();
            AutoHeal = cfg.get("entity", "autoHeal", true).getBoolean();
            AutoHealValue = cfg.get("entity", "autoHealValue", 1).getInt();
            AutoHealInterval = cfg.get("entity", "autoHealInterval", 50).getInt();
            CraftSpawnEgg = cfg.get("recipe", "craftSpawnEgg", false).getBoolean();
            ProtectionLimit = cfg.get("entity", "protectionLimit", 80).getInt();
            FireProtectionLimit = cfg.get("entity", "fireProtectionLimit", 80).getInt();
            FallProtectionLimit = cfg.get("entity", "fallProtectionLimit", 80).getInt();
            BlastProtectionLimit = cfg.get("entity", "blastProtectionLimit", 80).getInt();
            ProjectileProtectionLimit = cfg.get("entity", "projectileProtectionLimit", 80).getInt();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cfg.save();
        }

        ForgeRegistries.ITEMS.register(magicCandy = new ItemMagicCandy(2, 1F, false).setUnlocalizedName("magic_candy").setRegistryName("tameable_arachne:magic_candy"));

        proxy.registerRenderInformation();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ResourceLocation group = new ResourceLocation(TameableArachneCore.MODID, "tameable");

        if (ArachneEntityId > 0)
        {
            ResourceLocation name = new ResourceLocation(TameableArachneCore.MODID, "tame_arachne");
            EntityRegistry.registerModEntity(name, EntityArachne.class, "tame_arachne", ArachneEntityId, this, 80, 3, true, 0x0f1230, 0xa9b0f6);

            if (ArachneSpawnFlg)
            {
                EntityRegistry.addSpawn(EntityArachne.class, 35, 1, 4, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.JUNGLE, Biomes.BIRCH_FOREST, Biomes.ROOFED_FOREST, Biomes.FOREST_HILLS, Biomes.BIRCH_FOREST_HILLS, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE);
            }
            if (CraftSpawnEgg)
            {
                ItemStack egg = new ItemStack(Items.SPAWN_EGG);
                ItemMonsterPlacer.applyEntityIdToItemStack(egg, name);

                GameRegistry.addShapedRecipe(new ResourceLocation(TameableArachneCore.MODID, "tame_arachne"), group, egg, "SYS", "YEY", "SYS", 'S', Items.STRING, 'Y', Items.SPIDER_EYE, 'E', Items.EGG);
            }
        }

        if (ArachneMediumEntityId > 0)
        {
            ResourceLocation name = new ResourceLocation(TameableArachneCore.MODID, "tame_arachne_medium");
            EntityRegistry.registerModEntity(name, EntityArachneMedium.class, "tame_arachne_medium", ArachneMediumEntityId, this, 80, 3, true, 0x201a1d, 0x95002c);

            if (ArachneMediumSpawnFlg)
            {
                EntityRegistry.addSpawn(EntityArachneMedium.class, 25, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.JUNGLE, Biomes.BIRCH_FOREST, Biomes.ROOFED_FOREST, Biomes.FOREST_HILLS, Biomes.BIRCH_FOREST_HILLS, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE);
            }
            if (CraftSpawnEgg)
            {
                ItemStack egg = new ItemStack(Items.SPAWN_EGG);
                ItemMonsterPlacer.applyEntityIdToItemStack(egg, name);

                GameRegistry.addShapedRecipe(new ResourceLocation(TameableArachneCore.MODID, "tame_arachne_medium"), group, egg, "YSY", "SES", "YSY", 'S', Items.STRING, 'Y', Items.SPIDER_EYE, 'E', Items.EGG);
            }
        }

        if (HarpyEntityId > 0)
        {
            ResourceLocation name = new ResourceLocation(TameableArachneCore.MODID, "tame_harpy");
            EntityRegistry.registerModEntity(name, EntityHarpy.class, "tame_harpy", HarpyEntityId, this, 80, 3, true, 0x126dbf, 0xe6e7ff);

            if (HarpySpawnFlg)
            {
                EntityRegistry.addSpawn(EntityHarpy.class, 30, 1, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.JUNGLE, Biomes.BIRCH_FOREST, Biomes.ROOFED_FOREST, Biomes.FOREST_HILLS, Biomes.BIRCH_FOREST_HILLS, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE);
            }
            if (CraftSpawnEgg)
            {
                ItemStack egg = new ItemStack(Items.SPAWN_EGG);
                ItemMonsterPlacer.applyEntityIdToItemStack(egg, name);

                GameRegistry.addShapedRecipe(new ResourceLocation(TameableArachneCore.MODID, "tame_harpy"), group, egg, "FFF", "FEF", "FFF", 'F', Items.FEATHER, 'E', Items.EGG);
            }
        }

        GameRegistry.addShapedRecipe(new ResourceLocation(TameableArachneCore.MODID, "diamond_magic_candy"), group, new ItemStack(magicCandy, 8), "PKP", "KDK", "PKP", 'P', Items.PAPER, 'K', new ItemStack(Items.DYE, 1, 15), 'D', Items.DIAMOND);
        GameRegistry.addShapedRecipe(new ResourceLocation(TameableArachneCore.MODID, "emerald_magic_candy"), group, new ItemStack(magicCandy, 8), "PKP", "KDK", "PKP", 'P', Items.PAPER, 'K', new ItemStack(Items.DYE, 1, 15), 'D', Items.EMERALD);
    }
}
