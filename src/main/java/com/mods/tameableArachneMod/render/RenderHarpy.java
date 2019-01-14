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
    private static final ResourceLocation harpyTextures_07 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_07.png");
    private static final ResourceLocation tamedHarpyTextures_07 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_07.png");
    private static final ResourceLocation harpyTextures_08 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_08.png");
    private static final ResourceLocation tamedHarpyTextures_08 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_08.png");
    private static final ResourceLocation harpyTextures_09 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_09.png");
    private static final ResourceLocation tamedHarpyTextures_09 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_09.png");
    private static final ResourceLocation harpyTextures_10 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_10.png");
    private static final ResourceLocation tamedHarpyTextures_10 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_10.png");
    private static final ResourceLocation harpyTextures_11 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_11.png");
    private static final ResourceLocation tamedHarpyTextures_11 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_11.png");
    private static final ResourceLocation harpyTextures_12 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_12.png");
    private static final ResourceLocation tamedHarpyTextures_12 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_12.png");
    private static final ResourceLocation harpyTextures_13 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_13.png");
    private static final ResourceLocation tamedHarpyTextures_13 = new ResourceLocation("tameable_arachne:textures/entity/harpy/harpy_tame_13.png");
	
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
        if (id == 7) return tamed ? tamedHarpyTextures_07 : harpyTextures_07;
        if (id == 8) return tamed ? tamedHarpyTextures_08 : harpyTextures_08;
        if (id == 9) return tamed ? tamedHarpyTextures_09 : harpyTextures_09;
        if (id == 10) return tamed ? tamedHarpyTextures_10 : harpyTextures_10;
        if (id == 11) return tamed ? tamedHarpyTextures_11 : harpyTextures_11;
        if (id == 12) return tamed ? tamedHarpyTextures_12 : harpyTextures_12;
		if (id == 13) return tamed ? tamedHarpyTextures_13 : harpyTextures_13;
		
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
