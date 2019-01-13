package com.mods.tameableArachneMod.model;

import com.mods.tameableArachneMod.entity.EntityArachne;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelArachne extends ModelBase
{
    ModelRenderer head1;
    ModelRenderer face;
    ModelRenderer body1;
    ModelRenderer rightbreast;
    ModelRenderer leftbreast;
    ModelRenderer rightarm0;
    ModelRenderer rightarm1;
    ModelRenderer leftarm0;
    ModelRenderer leftarm1;
    ModelRenderer body31;
    ModelRenderer body41;
    ModelRenderer body51;
    ModelRenderer rightleg11;
    ModelRenderer rightleg12;
    ModelRenderer rightleg20;
    ModelRenderer rightleg21;
    ModelRenderer rightleg22;
    ModelRenderer rightleg23;
    ModelRenderer rightleg30;
    ModelRenderer rightleg31;
    ModelRenderer rightleg32;
    ModelRenderer rightleg33;
    ModelRenderer rightleg40;
    ModelRenderer rightleg41;
    ModelRenderer rightleg42;
    ModelRenderer rightleg43;
    ModelRenderer rightleg50;
    ModelRenderer rightleg51;
    ModelRenderer rightleg52;
    ModelRenderer rightleg53;
    ModelRenderer leftleg11;
    ModelRenderer leftleg12;
    ModelRenderer leftleg20;
    ModelRenderer leftleg21;
    ModelRenderer leftleg22;
    ModelRenderer leftleg23;
    ModelRenderer leftleg30;
    ModelRenderer leftleg31;
    ModelRenderer leftleg32;
    ModelRenderer leftleg33;
    ModelRenderer leftleg40;
    ModelRenderer leftleg41;
    ModelRenderer leftleg42;
    ModelRenderer leftleg43;
    ModelRenderer leftleg50;
    ModelRenderer leftleg51;
    ModelRenderer leftleg52;
    ModelRenderer leftleg53;

    public ModelArachne()
    {
        textureWidth = 128;
        textureHeight = 64;

        head1 = new ModelRenderer(this, 0, 0);
        head1.setTextureOffset(0, 0).addBox(-3F, -6F, -3F, 6, 6, 6);
        head1.setTextureOffset(24, 0).addBox(-3F, 0F, 0F, 6, 6, 3);
        head1.setTextureOffset(42, 0).addBox(-3F, -6F, -3F, 6, 12, 6, 0.3F);

        face = new ModelRenderer(this, 42, 18);
        face.addBox(-3F, -6F, -3.01F, 6, 6, 0);

        body1 = new ModelRenderer(this, 0, 12);
        body1.setTextureOffset(0, 12).addBox(-2F, 0F, -1.5F, 4, 6, 3);
        body1.setTextureOffset(0, 21).addBox(-2.5F, 6F, -1.5F, 5, 3, 3);

        rightbreast = new ModelRenderer(this, 0, 27);
        rightbreast.addBox(-1.9F, -0.7F, -3.8F, 2, 2, 3);

        leftbreast = new ModelRenderer(this, 10, 27);
        leftbreast.addBox(-0.1F, -0.7F, -3.8F, 2, 2, 3);

        rightarm0 = new ModelRenderer(this, 24, 9);
        rightarm1 = new ModelRenderer(this, 24, 9);
        rightarm1.addBox(-1F, -1F, -1F, 2, 9, 2);

        leftarm0 = new ModelRenderer(this, 32, 9);
        leftarm1 = new ModelRenderer(this, 32, 9);
        leftarm1.addBox(-1F, -1F, -1F, 2, 9, 2);

        body31 = new ModelRenderer(this, 0, 33);
        body31.setTextureOffset(0, 33).addBox(-3F, -2F, -3.5F, 6, 4, 7);
        body31.setTextureOffset(0, 44).addBox(2.5F, -1.5F, -3F, 1, 3, 6);
        body31.setTextureOffset(0, 53).addBox(-3.5F, -1.5F, -3F, 1, 3, 6);

        body41 = new ModelRenderer(this, 14, 44);
        body41.addBox(-2F, -1.5F, -0.5F, 4, 3, 1);

        body51 = new ModelRenderer(this, 26, 52);
        body51.setTextureOffset(26, 52).addBox(-3.5F, -2.5F, 0.5F, 7, 5, 1);
        body51.setTextureOffset(42, 52).addBox(-4F, -3F, 1.5F, 8, 6, 1);
        body51.setTextureOffset(26, 33).addBox(-5F, -3.5F, 2.5F, 10, 7, 12);
        body51.setTextureOffset(70, 33).addBox(-4F, -4.5F, 3.5F, 8, 1, 9);
        body51.setTextureOffset(104, 33).addBox(5F, -2.5F, 3.5F, 1, 5, 9);
        body51.setTextureOffset(104, 47).addBox(-6F, -2.5F, 3.5F, 1, 5, 9);
        body51.setTextureOffset(70, 43).addBox(-4F, -3F, 14.5F, 8, 6, 2);

        rightleg11 = new ModelRenderer(this, 66, 0);
        rightleg11.addBox(-1F, 0F, -1F, 2, 5, 2);
        rightleg12 = new ModelRenderer(this, 67, 7);
        rightleg12.addBox(-0.5F, 0F, 0F, 1, 5, 2);

        leftleg11 = new ModelRenderer(this, 66, 14);
        leftleg11.addBox(-1F, 0F, -1F, 2, 5, 2);
        leftleg12 = new ModelRenderer(this, 67, 21);
        leftleg12.addBox(-0.5F, 0F, 0F, 1, 5, 2);

        rightleg20 = new ModelRenderer(this, 74, 0);
        rightleg21 = new ModelRenderer(this, 74, 0);
        rightleg21.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        rightleg22 = new ModelRenderer(this, 74, 9);
        rightleg22.addBox(0F, 0F, -1F, 2, 7, 2, 0.1F);
        rightleg23 = new ModelRenderer(this, 74, 18);
        rightleg23.addBox(0F, 0F, -1F, 2, 8, 2);

        rightleg30 = new ModelRenderer(this, 74, 0);
        rightleg31 = new ModelRenderer(this, 74, 0);
        rightleg31.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        rightleg32 = new ModelRenderer(this, 74, 9);
        rightleg32.addBox(0F, 0F, -1F, 2, 7, 2, 0.1F);
        rightleg33 = new ModelRenderer(this, 74, 18);
        rightleg33.addBox(0F, 0F, -1F, 2, 8, 2);

        rightleg40 = new ModelRenderer(this, 74, 0);
        rightleg41 = new ModelRenderer(this, 74, 0);
        rightleg41.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        rightleg42 = new ModelRenderer(this, 74, 9);
        rightleg42.addBox(0F, 0F, -1F, 2, 7, 2, 0.1F);
        rightleg43 = new ModelRenderer(this, 74, 18);
        rightleg43.addBox(0F, 0F, -1F, 2, 8, 2);

        rightleg50 = new ModelRenderer(this, 74, 0);
        rightleg51 = new ModelRenderer(this, 74, 0);
        rightleg51.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        rightleg52 = new ModelRenderer(this, 74, 9);
        rightleg52.addBox(0F, 0F, -1F, 2, 7, 2, 0.1F);
        rightleg53 = new ModelRenderer(this, 74, 18);
        rightleg53.addBox(0F, 0F, -1F, 2, 8, 2);

        leftleg20 = new ModelRenderer(this, 82, 0);
        leftleg21 = new ModelRenderer(this, 82, 0);
        leftleg21.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        leftleg22 = new ModelRenderer(this, 82, 9);
        leftleg22.addBox(-2F, 0F, -1F, 2, 7, 2, 0.1F);
        leftleg23 = new ModelRenderer(this, 82, 18);
        leftleg23.addBox(-2F, 0F, -1F, 2, 8, 2);

        leftleg30 = new ModelRenderer(this, 82, 0);
        leftleg31 = new ModelRenderer(this, 82, 0);
        leftleg31.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        leftleg32 = new ModelRenderer(this, 82, 9);
        leftleg32.addBox(-2F, 0F, -1F, 2, 7, 2, 0.1F);
        leftleg33 = new ModelRenderer(this, 82, 18);
        leftleg33.addBox(-2F, 0F, -1F, 2, 8, 2);

        leftleg40 = new ModelRenderer(this, 82, 0);
        leftleg41 = new ModelRenderer(this, 82, 0);
        leftleg41.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        leftleg42 = new ModelRenderer(this, 82, 9);
        leftleg42.addBox(-2F, 0F, -1F, 2, 7, 2, 0.1F);
        leftleg43 = new ModelRenderer(this, 82, 18);
        leftleg43.addBox(-2F, 0F, -1F, 2, 8, 2);

        leftleg50 = new ModelRenderer(this, 82, 0);
        leftleg51 = new ModelRenderer(this, 82, 0);
        leftleg51.addBox(-1F, 0F, -1F, 2, 7, 2, 0.2F);
        leftleg52 = new ModelRenderer(this, 82, 9);
        leftleg52.addBox(-2F, 0F, -1F, 2, 7, 2, 0.1F);
        leftleg53 = new ModelRenderer(this, 82, 18);
        leftleg53.addBox(-2F, 0F, -1F, 2, 8, 2);

        head1.addChild(face);

        rightarm0.addChild(rightarm1);
        leftarm0.addChild(leftarm1);
        body1.addChild(head1);
        body1.addChild(rightbreast);
        body1.addChild(leftbreast);
        body1.addChild(rightarm0);
        body1.addChild(leftarm0);

        rightleg11.addChild(rightleg12);
        leftleg11.addChild(leftleg12);

        rightleg22.addChild(rightleg23);
        rightleg21.addChild(rightleg22);
        rightleg20.addChild(rightleg21);
        rightleg32.addChild(rightleg33);
        rightleg31.addChild(rightleg32);
        rightleg30.addChild(rightleg31);
        rightleg42.addChild(rightleg43);
        rightleg41.addChild(rightleg42);
        rightleg40.addChild(rightleg41);
        rightleg52.addChild(rightleg53);
        rightleg51.addChild(rightleg52);
        rightleg50.addChild(rightleg51);

        leftleg22.addChild(leftleg23);
        leftleg21.addChild(leftleg22);
        leftleg20.addChild(leftleg21);
        leftleg32.addChild(leftleg33);
        leftleg31.addChild(leftleg32);
        leftleg30.addChild(leftleg31);
        leftleg42.addChild(leftleg43);
        leftleg41.addChild(leftleg42);
        leftleg40.addChild(leftleg41);
        leftleg52.addChild(leftleg53);
        leftleg51.addChild(leftleg52);
        leftleg50.addChild(leftleg51);

        body31.addChild(body41);
        body31.addChild(body51);

        body31.addChild(rightleg11);
        body31.addChild(leftleg11);
        body31.addChild(rightleg20);
        body31.addChild(rightleg30);
        body31.addChild(rightleg40);
        body31.addChild(rightleg50);
        body31.addChild(leftleg20);
        body31.addChild(leftleg30);
        body31.addChild(leftleg40);
        body31.addChild(leftleg50);

        body1.setRotationPoint(0F, 8.5F, -2.5F);
        rightarm0.setRotationPoint(-3F, 1.2F, 0F);
        leftarm0.setRotationPoint(3F, 1.2F, 0F);

        body31.setRotationPoint(0F, 17F, 0F);
        body41.setRotationPoint(0F, 0F, 4F);
        body51.setRotationPoint(0F, 0F, 4F);

        rightleg11.setRotationPoint(-1.5F, 0.5F, -3.5F);
        rightleg12.setRotationPoint(0F, 5F, -1F);

        leftleg11.setRotationPoint(1.5F, 0.5F, -3.5F);
        leftleg12.setRotationPoint(0F, 5F, -1F);

        rightleg20.setRotationPoint(-3F, 2F, -2.5F);
        rightleg22.setRotationPoint(-1F, 7F, 0F);
        rightleg23.setRotationPoint(0F, 7F, 0F);

        rightleg30.setRotationPoint(-3F, 2F, -1F);
        rightleg32.setRotationPoint(-1F, 7F, 0F);
        rightleg33.setRotationPoint(0F, 7F, 0F);

        rightleg40.setRotationPoint(-3F, 2F, 1F);
        rightleg42.setRotationPoint(-1F, 7F, 0F);
        rightleg43.setRotationPoint(0F, 7F, 0F);

        rightleg50.setRotationPoint(-3F, 2F, 2.5F);
        rightleg52.setRotationPoint(-1F, 7F, 0F);
        rightleg53.setRotationPoint(0F, 7F, 0F);

        leftleg20.setRotationPoint(3F, 2F, -2.5F);
        leftleg22.setRotationPoint(1F, 7F, 0F);
        leftleg23.setRotationPoint(0F, 7F, 0F);

        leftleg30.setRotationPoint(3F, 2F, -1F);
        leftleg32.setRotationPoint(1F, 7F, 0F);
        leftleg33.setRotationPoint(0F, 7F, 0F);

        leftleg40.setRotationPoint(3F, 2F, 1F);
        leftleg42.setRotationPoint(1F, 7F, 0F);
        leftleg43.setRotationPoint(0F, 7F, 0F);

        leftleg50.setRotationPoint(3F, 2F, 2.5F);
        leftleg52.setRotationPoint(1F, 7F, 0F);
        leftleg53.setRotationPoint(0F, 7F, 0F);

        setRotation(rightbreast, 0.8203047F, 0.0523599F, 0.0872665F);
        setRotation(leftbreast, 0.8203047F, -0.0523599F, -0.0872665F);

        setRotation(body41, 0.0698131F, 0F, 0F);
        setRotation(body51, 0.1396263F, 0F, 0F);

        setRotation(rightleg11, -2.059489F, 0.3141593F, 0F);
        setRotation(rightleg12, 1.343904F, 0F, 0F);

        setRotation(leftleg11, -2.059489F, -0.3141593F, 0F);
        setRotation(leftleg12, 1.343904F, 0F, 0F);

        setRotation(rightleg21, 0F, 0F, 2.460914F);
        setRotation(rightleg22, 0F, 0F, -1.343903F);
        setRotation(rightleg23, 0F, 0F, -0.8552116F);
        setRotation(rightleg31, 0F, 0F, 2.460914F);
        setRotation(rightleg32, 0F, 0F, -1.343903F);
        setRotation(rightleg33, 0F, 0F, -0.8552116F);
        setRotation(rightleg41, 0F, 0F, 2.460914F);
        setRotation(rightleg42, 0F, 0F, -1.343903F);
        setRotation(rightleg43, 0F, 0F, -0.8552116F);
        setRotation(rightleg51, 0F, 0F, 2.460914F);
        setRotation(rightleg52, 0F, 0F, -1.343903F);
        setRotation(rightleg53, 0F, 0F, -0.8552116F);

        setRotation(leftleg21, 0F, 0F, -2.460914F);
        setRotation(leftleg22, 0F, 0F, 1.343903F);
        setRotation(leftleg23, 0F, 0F, 0.8552116F);
        setRotation(leftleg31, 0F, 0F, -2.460914F);
        setRotation(leftleg32, 0F, 0F, 1.343903F);
        setRotation(leftleg33, 0F, 0F, 0.8552116F);
        setRotation(leftleg41, 0F, 0F, -2.460914F);
        setRotation(leftleg42, 0F, 0F, 1.343903F);
        setRotation(leftleg43, 0F, 0F, 0.8552116F);
        setRotation(leftleg51, 0F, 0F, -2.460914F);
        setRotation(leftleg52, 0F, 0F, 1.343903F);
        setRotation(leftleg53, 0F, 0F, 0.8552116F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        EntityArachne entityarachne = (EntityArachne) entity;
        if (entityarachne.getWinkTimer() > 0)
        {
            face.isHidden = true;
        }
        else
        {
            face.isHidden = false;
        }
        body1.render(f5);
        body31.render(f5);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityArachne entityarachne = (EntityArachne) p_78086_1_;

        this.rightleg11.rotateAngleX = -2.059489F;
        this.leftleg11.rotateAngleX = -2.059489F;

        if (entityarachne.isSitting())
        {
            setRotation(rightarm0, 0F, 0F, 0F);
            setRotation(leftarm0, 0F, 0F, 0F);
            setRotation(rightarm1, -0.3839724F, -0.0872665F, -0.2443461F);
            setRotation(leftarm1, -0.3839724F, 0.1047198F, 0.2443461F);
        }
        else
        {
            setRotation(rightarm1, 0F, 0F, 0.2443461F);
            setRotation(leftarm1, 0F, 0F, -0.2443461F);
        }

        int i = entityarachne.getAttackTimer();
        if (i > 0)
        {
            float f = -0.25F + 0.4F * this.func_78172_a(i - p_78086_4_, 6.0F);
            this.rightleg11.rotateAngleX = -f - 2.059489F;
            this.rightleg12.rotateAngleX = f + 1.343904F;
            if (i < 10)
            {
                float f2 = -0.25F + 0.4F * this.func_78172_a((float) i + 3 - p_78086_4_, 6.0F);
                this.leftleg11.rotateAngleX = -f2 - 2.059489F;
                this.leftleg12.rotateAngleX = f2 + 1.343904F;
            }
        }
        else
        {
            this.rightleg11.rotateAngleX = -2.059489F;
            this.leftleg11.rotateAngleX = -2.059489F;
            this.rightleg12.rotateAngleX = 1.343904F;
            this.leftleg12.rotateAngleX = 1.343904F;
        }
    }

    private float func_78172_a(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
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

        this.rightarm0.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
        this.leftarm0.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.rightarm0.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        this.leftarm0.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;

        float f6 = -2.460914F;
        this.rightleg51.rotateAngleZ = -f6;
        this.leftleg51.rotateAngleZ = f6;
        this.rightleg41.rotateAngleZ = -f6;
        this.leftleg41.rotateAngleZ = f6;
        this.rightleg31.rotateAngleZ = -f6;
        this.leftleg31.rotateAngleZ = f6;
        this.rightleg21.rotateAngleZ = -f6;
        this.leftleg21.rotateAngleZ = f6;

        float f7 = -0.0F;
        float f8 = 0.3926991F;
        this.rightleg50.rotateAngleY = f8 * 2.0F + f7;
        this.leftleg50.rotateAngleY = -f8 * 2.0F - f7;
        this.rightleg40.rotateAngleY = f8 * 1.0F + f7;
        this.leftleg40.rotateAngleY = -f8 * 1.0F - f7;
        this.rightleg30.rotateAngleY = -f8 * 1.0F + f7;
        this.leftleg30.rotateAngleY = f8 * 1.0F - f7;
        this.rightleg20.rotateAngleY = -f8 * 2.0F + f7;
        this.leftleg20.rotateAngleY = f8 * 2.0F - f7;

        float f9 = -(MathHelper.cos(f * 0.6662F * 2.0F + 0.0F) * 0.4F) * f1;
        float f10 = -(MathHelper.cos(f * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * f1;
        float f11 = -(MathHelper.cos(f * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * f1;
        float f12 = -(MathHelper.cos(f * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * f1;

        float f13 = Math.abs(MathHelper.sin(f * 0.6662F + 0.0F) * 0.4F) * f1;
        float f14 = Math.abs(MathHelper.sin(f * 0.6662F + (float) Math.PI) * 0.4F) * f1;
        float f15 = Math.abs(MathHelper.sin(f * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * f1;
        float f16 = Math.abs(MathHelper.sin(f * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * f1;

        this.rightleg50.rotateAngleY += f9;
        this.leftleg50.rotateAngleY += -f9;
        this.rightleg40.rotateAngleY += f10;
        this.leftleg40.rotateAngleY += -f10;
        this.rightleg30.rotateAngleY += f11;
        this.leftleg30.rotateAngleY += -f11;
        this.rightleg20.rotateAngleY += f12;
        this.leftleg20.rotateAngleY += -f12;

        this.rightleg51.rotateAngleZ += f13;
        this.leftleg51.rotateAngleZ += -f13;
        this.rightleg41.rotateAngleZ += f14;
        this.leftleg41.rotateAngleZ += -f14;
        this.rightleg31.rotateAngleZ += f15;
        this.leftleg31.rotateAngleZ += -f15;
        this.rightleg21.rotateAngleZ += f16;
        this.leftleg21.rotateAngleZ += -f16;
    }

}
