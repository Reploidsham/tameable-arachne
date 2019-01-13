package com.mods.tameableArachneMod.render;

import com.mods.tameableArachneMod.entity.EntityArachneMedium;
import com.mods.tameableArachneMod.model.ModelArachneMedium;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArachneMedium extends RenderLiving<EntityArachneMedium>
{
    private static final ResourceLocation arachneMediumTextures_00 = new ResourceLocation("tameable_arachne:textures/entity/arachne_medium/arachne_medium_00.png");
    private static final ResourceLocation tamedArachneMediumTextures_00 = new ResourceLocation("tameable_arachne:textures/entity/arachne_medium/arachne_medium_tame_00.png");
    private static final ResourceLocation arachneMediumTextures_01 = new ResourceLocation("tameable_arachne:textures/entity/arachne_medium/arachne_medium_01.png");
    private static final ResourceLocation tamedArachneMediumTextures_01 = new ResourceLocation("tameable_arachne:textures/entity/arachne_medium/arachne_medium_tame_01.png");

    public RenderArachneMedium(RenderManager manager)
    {
        super(manager, new ModelArachneMedium(), 0.6f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityArachneMedium entity)
    {
        if (entity.getTextureNo() == 1)
        {
            return entity.isTamed() ? tamedArachneMediumTextures_01 : arachneMediumTextures_01;
        }

        return entity.isTamed() ? tamedArachneMediumTextures_00 : arachneMediumTextures_00;
    }
}