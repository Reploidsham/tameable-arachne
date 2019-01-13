package com.mods.tameableArachneMod.render;

import com.mods.tameableArachneMod.entity.EntityHarpy;
import com.mods.tameableArachneMod.model.ModelHarpy;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHarpy extends RenderLiving<EntityHarpy>
{
    private static final ResourceLocation harpyTextures_00 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_00.png");
    private static final ResourceLocation tamedHarpyTextures_00 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_00.png");
    private static final ResourceLocation harpyTextures_01 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_01.png");
    private static final ResourceLocation tamedHarpyTextures_01 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_01.png");
    private static final ResourceLocation harpyTextures_02 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_02.png");
    private static final ResourceLocation tamedHarpyTextures_02 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_02.png");
    private static final ResourceLocation harpyTextures_03 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_03.png");
    private static final ResourceLocation tamedHarpyTextures_03 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_03.png");
    private static final ResourceLocation harpyTextures_04 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_04.png");
    private static final ResourceLocation tamedHarpyTextures_04 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_04.png");
    private static final ResourceLocation harpyTextures_05 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_05.png");
    private static final ResourceLocation tamedHarpyTextures_05 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_05.png");
    private static final ResourceLocation harpyTextures_06 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_06.png");
    private static final ResourceLocation tamedHarpyTextures_06 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_06.png");

    public RenderHarpy(RenderManager manager)
    {
        super(manager, new ModelHarpy(), 0.3f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHarpy entity)
    {
        boolean tamed = entity.isTamed();
        int id = entity.getTextureNo();

        if (id == 1) return tamed ? tamedHarpyTextures_01 : harpyTextures_01;
        if (id == 2) return tamed ? tamedHarpyTextures_02 : harpyTextures_02;
        if (id == 3) return tamed ? tamedHarpyTextures_03 : harpyTextures_03;
        if (id == 4) return tamed ? tamedHarpyTextures_04 : harpyTextures_04;
        if (id == 5) return tamed ? tamedHarpyTextures_05 : harpyTextures_05;
        if (id == 6) return tamed ? tamedHarpyTextures_06 : harpyTextures_06;

        return tamed ? tamedHarpyTextures_00 : harpyTextures_00;
    }

    @Override
    protected float handleRotationFloat(EntityHarpy entity, float partialTick)
    {
        float f1 = entity.field_70888_h + (entity.field_70886_e - entity.field_70888_h) * partialTick;
        float f2 = entity.field_70884_g + (entity.destPos - entity.field_70884_g) * partialTick;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }
}