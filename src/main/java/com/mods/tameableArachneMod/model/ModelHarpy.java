package com.mods.tameableArachneMod.model;

import org.lwjgl.opengl.GL11;

import com.mods.tameableArachneMod.entity.EntityHarpy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHarpy extends ModelBase
{

    ModelRenderer head1;
    ModelRenderer face;
    ModelRenderer body1;
    ModelRenderer tail;
    ModelRenderer rightbreast;
    ModelRenderer leftbreast;
    ModelRenderer rightarm0;
    ModelRenderer rightarm1;
    ModelRenderer rightarm2;
    ModelRenderer rightarm3;
    ModelRenderer rightarm4;
    ModelRenderer leftarm0;
    ModelRenderer leftarm1;
    ModelRenderer leftarm2;
    ModelRenderer leftarm3;
    ModelRenderer leftarm4;
    ModelRenderer rightleg0;
    ModelRenderer rightleg1;
    ModelRenderer rightleg2;
    ModelRenderer rightleg4;
    ModelRenderer rightleg5;
    ModelRenderer rightleg6;
    ModelRenderer rightleg7;
    ModelRenderer rightleg8;
    ModelRenderer leftleg0;
    ModelRenderer leftleg1;
    ModelRenderer leftleg2;
    ModelRenderer leftleg4;
    ModelRenderer leftleg5;
    ModelRenderer leftleg6;
    ModelRenderer leftleg7;
    ModelRenderer leftleg8;

    public ModelHarpy()
    {
        textureWidth = 128;
        textureHeight = 64;

        head1 = new ModelRenderer(this);
        head1.setTextureOffset(0, 0).addBox(-4F, -8F, -4F, 8, 8, 8);
        head1.setTextureOffset(0, 16).addBox(-4F, 0F, -4F, 8, 8, 8);
        head1.setTextureOffset(32, 0).addBox(-4F, -8F, -4F, 8, 16, 8, 0.3F);

        face = new ModelRenderer(this, 24, 0);
        face.addBox(-4F, -8F, -4.01F, 8, 8, 0);

        body1 = new ModelRenderer(this);
        body1.setTextureOffset(0, 32).addBox(-3F, 0F, -2F, 6, 9, 4);
        body1.setTextureOffset(0, 45).addBox(-3.5F, 9F, -2F, 7, 2, 4);

        tail = new ModelRenderer(this, 110, 8);
        tail.addBox(-4.5F, 0F, 0F, 9, 12, 0);

        rightbreast = new ModelRenderer(this, 20, 32);
        rightbreast.addBox(-3F, 0F, 0F, 3, 3, 3);
        leftbreast = new ModelRenderer(this, 20, 38);
        leftbreast.addBox(0F, 0F, 0F, 3, 3, 3);

        rightarm0 = new ModelRenderer(this);
        rightarm1 = new ModelRenderer(this, 0, 51);
        rightarm1.addBox(-2F, -1F, -1F, 2, 11, 2);
        rightarm2 = new ModelRenderer(this, 16, 51);
        rightarm2.addBox(-1F, 0F, 0F, 2, 4, 2);
        rightarm3 = new ModelRenderer(this, 96, 22);
        rightarm3.addBox(0F, 0F, 0F, 0, 10, 7);
        rightarm4 = new ModelRenderer(this, 110, 20);
        rightarm4.addBox(-0.01F, 0F, -1F, 0, 13, 9);

        leftarm0 = new ModelRenderer(this);
        leftarm1 = new ModelRenderer(this, 8, 51);
        leftarm1.addBox(0F, -1F, -1F, 2, 11, 2);
        leftarm2 = new ModelRenderer(this, 16, 57);
        leftarm2.addBox(-1F, 0F, 0F, 2, 4, 2);
        leftarm3 = new ModelRenderer(this, 96, 44);
        leftarm3.addBox(0F, 0F, 0F, 0, 10, 7);
        leftarm4 = new ModelRenderer(this, 110, 42);
        leftarm4.addBox(0.01F, 0F, -1F, 0, 13, 9);

        rightleg0 = new ModelRenderer(this);
        rightleg1 = new ModelRenderer(this, 64, 0);
        rightleg1.addBox(-2F, 0F, -2F, 4, 7, 4);
        rightleg2 = new ModelRenderer(this);
        rightleg2.setTextureOffset(67, 11).addBox(-1.5F, 0F, 0F, 3, 2, 2);
        rightleg2.setTextureOffset(68, 15).addBox(-1F, 2F, 0F, 2, 2, 2);
        rightleg4 = new ModelRenderer(this, 68, 19);
        rightleg4.addBox(-1F, 0F, -2F, 2, 6, 2);
        rightleg5 = new ModelRenderer(this, 69, 27);
        rightleg5.addBox(-1F, 0F, 0F, 2, 3, 1);
        rightleg6 = new ModelRenderer(this, 70, 37);
        rightleg6.addBox(-0.5F, -2F, 0F, 1, 8, 1);
        rightleg7 = new ModelRenderer(this, 68, 31);
        rightleg7.addBox(-0.5F, 0F, 0F, 1, 5, 1);
        rightleg8 = new ModelRenderer(this, 72, 31);
        rightleg8.addBox(-0.5F, 0F, 0F, 1, 5, 1);

        leftleg0 = new ModelRenderer(this);
        leftleg1 = new ModelRenderer(this, 80, 0);
        leftleg1.addBox(-2F, 0F, -2F, 4, 7, 4);
        leftleg2 = new ModelRenderer(this);
        leftleg2.setTextureOffset(83, 11).addBox(-1.5F, 0F, 0F, 3, 2, 2);
        leftleg2.setTextureOffset(84, 15).addBox(-1F, 2F, 0F, 2, 2, 2);
        leftleg4 = new ModelRenderer(this, 84, 19);
        leftleg4.addBox(-1F, 0F, -2F, 2, 6, 2);
        leftleg5 = new ModelRenderer(this, 85, 27);
        leftleg5.addBox(-1F, 0F, 0F, 2, 3, 1);
        leftleg6 = new ModelRenderer(this, 86, 37);
        leftleg6.addBox(-0.5F, -2F, 0F, 1, 8, 1);
        leftleg7 = new ModelRenderer(this, 84, 31);
        leftleg7.addBox(-0.5F, 0F, 0F, 1, 5, 1);
        leftleg8 = new ModelRenderer(this, 88, 31);
        leftleg8.addBox(-0.5F, 0F, 0F, 1, 5, 1);

        rightarm2.addChild(rightarm4);
        rightarm1.addChild(rightarm3);
        rightarm1.addChild(rightarm2);
        rightarm0.addChild(rightarm1);

        leftarm2.addChild(leftarm4);
        leftarm1.addChild(leftarm3);
        leftarm1.addChild(leftarm2);
        leftarm0.addChild(leftarm1);

        rightleg5.addChild(rightleg8);
        rightleg5.addChild(rightleg7);
        rightleg5.addChild(rightleg6);
        rightleg4.addChild(rightleg5);
        rightleg2.addChild(rightleg4);
        rightleg1.addChild(rightleg2);
        rightleg0.addChild(rightleg1);

        leftleg5.addChild(leftleg8);
        leftleg5.addChild(leftleg7);
        leftleg5.addChild(leftleg6);
        leftleg4.addChild(leftleg5);
        leftleg2.addChild(leftleg4);
        leftleg1.addChild(leftleg2);
        leftleg0.addChild(leftleg1);

        head1.addChild(face);

        body1.addChild(rightbreast);
        body1.addChild(leftbreast);
        body1.addChild(rightarm0);
        body1.addChild(leftarm0);
        body1.addChild(rightleg0);
        body1.addChild(leftleg0);
        body1.addChild(tail);

        head1.setRotationPoint(0F, -2F, 0F);
        body1.setRotationPoint(0F, -2F, 0F);
        tail.setRotationPoint(0F, 9F, 2F);

        rightbreast.setRotationPoint(-0.1F, 0.8F, -2F);
        leftbreast.setRotationPoint(0.1F, 0.8F, -2F);

        rightarm0.setRotationPoint(-3F, 1.5F, 0F);
        rightarm2.setRotationPoint(-1F, 10F, -1F);
        rightarm3.setRotationPoint(-1F, 0F, 0F);
        rightarm4.setRotationPoint(0F, 0F, 1F);

        leftarm0.setRotationPoint(3F, 1.5F, 0F);
        leftarm2.setRotationPoint(1F, 10F, -1F);
        leftarm3.setRotationPoint(1F, 0F, 0F);
        leftarm4.setRotationPoint(0F, 0F, 1F);

        rightleg0.setRotationPoint(-2F, 11F, 0F);
        rightleg2.setRotationPoint(0F, 7F, -2F);
        rightleg4.setRotationPoint(0F, 4F, 2F);
        rightleg5.setRotationPoint(0F, 6F, 0F);
        rightleg7.setRotationPoint(-0.5F, 0.5F, 0F);
        rightleg8.setRotationPoint(0.5F, 0.5F, 0F);

        leftleg0.setRotationPoint(2F, 11F, 0F);
        leftleg2.setRotationPoint(0F, 7F, -2F);
        leftleg4.setRotationPoint(0F, 4F, 2F);
        leftleg5.setRotationPoint(0F, 6F, 0F);
        leftleg7.setRotationPoint(-0.5F, 0.5F, 0F);
        leftleg8.setRotationPoint(0.5F, 0.5F, 0F);

        setRotation(rightbreast, -0.6108652F, 0.0349066F, 0.0872665F);
        setRotation(leftbreast, -0.6108652F, -0.0349066F, -0.0872665F);
        setRotation(tail, 0.6283185F, 0F, 0F);

        setRotation(rightarm1, 0F, 0F, 0.1570796F);
        setRotation(rightarm2, 0.6283185F, 0F, 0F);

        setRotation(leftarm1, 0F, 0F, -0.1570796F);
        setRotation(leftarm2, 0.6283185F, 0F, 0F);

        setRotation(rightleg1, -0.1570796F, 0F, 0F);
        setRotation(rightleg2, 0.9424778F, 0F, 0F);
        setRotation(rightleg4, -0.8726647F, 0F, 0F);
        setRotation(rightleg5, -1.4835295F, 0F, 0F);
        setRotation(rightleg7, 0F, 0F, 0.1919862F);
        setRotation(rightleg8, 0F, 0F, -0.1919862F);

        setRotation(leftleg1, -0.1570796F, 0F, 0F);
        setRotation(leftleg2, 0.9424778F, 0F, 0F);
        setRotation(leftleg4, -0.8726647F, 0F, 0F);
        setRotation(leftleg5, -1.4835295F, 0F, 0F);
        setRotation(leftleg7, 0F, 0F, 0.1919862F);
        setRotation(leftleg8, 0F, 0F, -0.1919862F);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        //		head1.render(f5);
        //		body1.render(f5);
        GL11.glPushMatrix();
        GL11.glScalef(0.7F, 0.7F, 0.7F);
        GL11.glTranslatef(0.0F, 10.0F * f5, 0.0F);
        EntityHarpy entityharpy = (EntityHarpy) entity;
        if (entityharpy.getWinkTimer() > 0)
        {
            face.isHidden = true;
        }
        else
        {
            face.isHidden = false;
        }
        head1.render(f5);
        body1.render(f5);
        GL11.glPopMatrix();
    }

    @Override
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityHarpy entityharpy = (EntityHarpy) p_78086_1_;

        if (entityharpy.isSitting())
        {
            setRotation(rightarm0, 0F, 0F, 0F);
            setRotation(leftarm0, 0F, 0F, 0F);
            //			setRotation(rightarm1, -0.3839724F, -0.0872665F, -0.2443461F);
            //			setRotation(leftarm1, -0.3839724F, 0.1047198F, 0.2443461F);
            setRotation(rightarm1, -0.4712389F, -0.4014257F, -0.122173F);
            setRotation(leftarm1, -0.4712389F, 0.4014257F, 0.122173F);
            setRotation(rightarm3, 0F, -0.7853982F, 0F);
            setRotation(leftarm3, 0F, 0.7853982F, 0F);
            setRotation(rightarm4, 0F, -0.7853982F, 0F);
            setRotation(leftarm4, 0F, 0.7853982F, 0F);
        }
        else
        {
            setRotation(rightarm1, 0F, 0F, 0.1570796F);
            setRotation(leftarm1, 0F, 0F, -0.1570796F);
            setRotation(rightarm3, 0F, 0F, 0F);
            setRotation(leftarm3, 0F, 0F, 0F);
            setRotation(rightarm4, 0F, 0F, 0F);
            setRotation(leftarm4, 0F, 0F, 0F);
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head1.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.head1.rotateAngleY = f3 / (180F / (float) Math.PI);

        EntityHarpy entityharpy = (EntityHarpy) entity;
        if (!entityharpy.isSitting())
        {
            this.rightarm0.rotateAngleX = MathHelper.cos(f * 0.7F + (float) Math.PI) * 1.2F * f1 * 0.5F;
            this.leftarm0.rotateAngleX = MathHelper.cos(f * 0.7F) * 1.2F * f1 * 0.5F;
            this.rightarm0.rotateAngleX += MathHelper.sin(f2 * 0.07F) * 0.05F;
            this.leftarm0.rotateAngleX -= MathHelper.sin(f2 * 0.07F) * 0.05F;

            this.rightarm0.rotateAngleZ = f2;
            this.leftarm0.rotateAngleZ = -f2;
        }

        this.rightleg0.rotateAngleX = MathHelper.cos(f * 0.7F) * 1.1F * f1;
        this.leftleg0.rotateAngleX = MathHelper.cos(f * 0.7F + (float) Math.PI) * 1.1F * f1;
    }

}
