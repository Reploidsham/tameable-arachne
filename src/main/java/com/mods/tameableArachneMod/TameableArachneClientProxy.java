package com.mods.tameableArachneMod;

import com.mods.tameableArachneMod.entity.EntityArachne;
import com.mods.tameableArachneMod.entity.EntityArachneMedium;
import com.mods.tameableArachneMod.entity.EntityHarpy;
import com.mods.tameableArachneMod.render.RenderArachne;
import com.mods.tameableArachneMod.render.RenderArachneMedium;
import com.mods.tameableArachneMod.render.RenderHarpy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TameableArachneClientProxy extends TameableArachneCommonProxy
{
    @Override
    public void registerRenderInformation()
    {
        if (TameableArachneCore.magicCandy != null)
        {
            ModelLoader.setCustomModelResourceLocation(TameableArachneCore.magicCandy, 0, new ModelResourceLocation(TameableArachneCore.MODID + ":magic_candy#inventory"));
        }

        if (TameableArachneCore.ArachneEntityId > 0)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityArachne.class, new IRenderFactory<EntityArachne>()
            {
                @Override
                public RenderArachne createRenderFor(RenderManager manager)
                {
                    return new RenderArachne(manager);
                }
            });
        }
        if (TameableArachneCore.ArachneMediumEntityId > 0)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityArachneMedium.class, new IRenderFactory<EntityArachneMedium>()
            {
                @Override
                public RenderArachneMedium createRenderFor(RenderManager manager)
                {
                    return new RenderArachneMedium(manager);
                }
            });
        }
        if (TameableArachneCore.HarpyEntityId > 0)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityHarpy.class, new IRenderFactory<EntityHarpy>()
            {
                @Override
                public RenderHarpy createRenderFor(RenderManager manager)
                {
                    return new RenderHarpy(manager);
                }
            });
        }
    }
}
