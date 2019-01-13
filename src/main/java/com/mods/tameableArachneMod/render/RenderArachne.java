package com.mods.tameableArachneMod.render;

import com.mods.tameableArachneMod.entity.EntityArachne;
import com.mods.tameableArachneMod.model.ModelArachne;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArachne extends RenderLiving<EntityArachne>
{
    private static final ResourceLocation arachneTextures_00 = new ResourceLocation("tameable_arachne:textures/entity/arachne/arachne_00.png");
    private static final ResourceLocation tamedArachneTextures_00 = new ResourceLocation("tameable_arachne:textures/entity/arachne/arachne_tame_00.png");
    private static final ResourceLocation arachneTextures_01 = new ResourceLocation("tameable_arachne:textures/entity/arachne/arachne_01.png");
    private static final ResourceLocation tamedArachneTextures_01 = new ResourceLocation("tameable_arachne:textures/entity/arachne/arachne_tame_01.png");

    public RenderArachne(RenderManager manager)
    {
        super(manager, new ModelArachne(), 0.6f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityArachne entity)
    {
        if (entity.getTextureNo() == 1)
        {
            return entity.isTamed() ? tamedArachneTextures_01 : arachneTextures_01;
        }

        return entity.isTamed() ? tamedArachneTextures_00 : arachneTextures_00;
    }
}