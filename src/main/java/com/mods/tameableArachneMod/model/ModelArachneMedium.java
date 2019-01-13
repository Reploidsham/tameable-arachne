package com.mods.tameableArachneMod.model;

import com.mods.tameableArachneMod.entity.EntityArachneMedium;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelArachneMedium extends ModelBase
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
    ModelRenderer body4j;
    ModelRenderer body51;
    ModelRenderer rightleg11;
    ModelRenderer rightleg12j;
    ModelRenderer rightleg12;
    ModelRenderer leftleg11;
    ModelRenderer leftleg12j;
    ModelRenderer leftleg12;
    ModelRenderer rightleg20;
    ModelRenderer rightleg21;
    ModelRenderer rightleg22j;
    ModelRenderer rightleg22;
    ModelRenderer rightleg23j;
    ModelRenderer rightleg23;
    ModelRenderer rightleg30;
    ModelRenderer rightleg31;
    ModelRenderer rightleg32j;
    ModelRenderer rightleg32;
    ModelRenderer rightleg33j;
    ModelRenderer rightleg33;
    ModelRenderer rightleg40;
    ModelRenderer rightleg41;
    ModelRenderer rightleg42j;
    ModelRenderer rightleg42;
    ModelRenderer rightleg43j;
    ModelRenderer rightleg43;
    ModelRenderer rightleg50;
    ModelRenderer rightleg51;
    ModelRenderer rightleg52j;
    ModelRenderer rightleg52;
    ModelRenderer rightleg53j;
    ModelRenderer rightleg53;
    ModelRenderer leftleg20;
    ModelRenderer leftleg21;
    ModelRenderer leftleg22j;
    ModelRenderer leftleg22;
    ModelRenderer leftleg23j;
    ModelRenderer leftleg23;
    ModelRenderer leftleg30;
    ModelRenderer leftleg31;
    ModelRenderer leftleg32j;
    ModelRenderer leftleg32;
    ModelRenderer leftleg33j;
    ModelRenderer leftleg33;
    ModelRenderer leftleg40;
    ModelRenderer leftleg41;
    ModelRenderer leftleg42j;
    ModelRenderer leftleg42;
    ModelRenderer leftleg43j;
    ModelRenderer leftleg43;
    ModelRenderer leftleg50;
    ModelRenderer leftleg51;
    ModelRenderer leftleg52j;
    ModelRenderer leftleg52;
    ModelRenderer leftleg53j;
    ModelRenderer leftleg53;

    public ModelArachneMedium()
    {
        textureWidth = 128;
        textureHeight = 128;

        head1 = new ModelRenderer(this);
        head1.setTextureOffset(0, 0).addBox(-4F, -8F, -4F, 8, 8, 8);
        head1.setTextureOffset(32, 0).addBox(-4F, 0F, -4F, 8, 8, 8);
        head1.setTextureOffset(64, 0).addBox(-4F, -8F, -4F, 8, 16, 8, 0.3F);

        face = new ModelRenderer(this, 24, 0);
        face.addBox(-4F, -8F, -4.01F, 8, 8, 0);

        body1 = new ModelRenderer(this);
        body1.setTextureOffset(0, 16).addBox(-3F, 0F, -2F, 6, 8, 4);
        body1.setTextureOffset(0, 28).addBox(-3.5F, 8F, -2F, 7, 4, 5);

        rightbreast = new ModelRenderer(this, 0, 37);
        rightbreast.addBox(-2.8F, -0.8F, -5.4F, 3, 3, 4);

        leftbreast = new ModelRenderer(this, 14, 37);
        leftbreast.addBox(-0.2F, -0.8F, -5.4F, 3, 3, 4);

        rightarm0 = new ModelRenderer(this);
        rightarm1 = new ModelRenderer(this);
        rightarm1.setTextureOffset(24, 16).addBox(-1F, -1F, -1F, 2, 12, 2);
        rightarm1.setTextureOffset(40, 16).addBox(-1F, -1F, -1F, 2, 12, 2, 0.5F);

        leftarm0 = new ModelRenderer(this);
        leftarm1 = new ModelRenderer(this);
        leftarm1.setTextureOffset(32, 16).addBox(-1F, -1F, -1F, 2, 12, 2);
        leftarm1.setTextureOffset(48, 16).addBox(-1F, -1F, -1F, 2, 12, 2, 0.5F);

        body31 = new ModelRenderer(this);
        body31.setTextureOffset(0, 54).addBox(-4F, -3.5F, -5F, 8, 7, 10);
        body31.setTextureOffset(18, 71).addBox(3.5F, -2.5F, -4F, 1, 5, 8);
        body31.setTextureOffset(0, 71).addBox(-4.5F, -2.5F, -4F, 1, 5, 8);
        body31.setTextureOffset(0, 84).addBox(-3F, -2.5F, 5F, 6, 5, 1);

        body4j = new ModelRenderer(this, 0, 97);
        body4j.addBox(-2.5F, -2F, -1F, 5, 4, 2);

        body51 = new ModelRenderer(this);
        body51.setTextureOffset(0, 103).addBox(-4F, -2.5F, 0.5F, 8, 5, 1);
        body51.setTextureOffset(0, 109).addBox(-5F, -4.5F, 1.5F, 10, 8, 1);
        body51.setTextureOffset(40, 67).addBox(-7F, -6.5F, 2.5F, 14, 11, 15);
        body51.setTextureOffset(40, 54).addBox(-6F, -7.5F, 3.5F, 12, 1, 12);
        body51.setTextureOffset(69, 93).addBox(7F, -5.5F, 3.5F, 1, 9, 12);
        body51.setTextureOffset(40, 93).addBox(-8F, -5.5F, 3.5F, 1, 9, 12);
        body51.setTextureOffset(40, 114).addBox(-6F, -5.5F, 17.5F, 12, 9, 2);
        body51.setTextureOffset(69, 114).addBox(-5F, -4.5F, 19.5F, 10, 7, 1);

        rightleg11 = new ModelRenderer(this, 98, 0);
        rightleg11.addBox(-1.5F, 0F, -1.5F, 3, 7, 3, 0.1F);
        rightleg12j = new ModelRenderer(this, 100, 31);
        rightleg12j.addBox(-1F, -1.5F, -0.5F, 2, 3, 2);
        rightleg12 = new ModelRenderer(this);
        rightleg12.setTextureOffset(98, 10).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        rightleg12.setTextureOffset(99, 15).addBox(-1F, 2.5F, -1.5F, 2, 2, 3);
        rightleg12.setTextureOffset(100, 20).addBox(-1F, 4.5F, -0.5F, 2, 2, 2);
        rightleg12.setTextureOffset(101, 24).addBox(-0.5F, 6.5F, -0.5F, 1, 2, 2);
        rightleg12.setTextureOffset(102, 28).addBox(-0.5F, 8.5F, 0.5F, 1, 2, 1);

        leftleg11 = new ModelRenderer(this, 110, 0);
        leftleg11.addBox(-1.5F, 0F, -1.5F, 3, 7, 3, 0.1F);
        leftleg12j = new ModelRenderer(this, 112, 31);
        leftleg12j.addBox(-1F, -1.5F, -0.5F, 2, 3, 2);
        leftleg12 = new ModelRenderer(this);
        leftleg12.setTextureOffset(110, 10).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        leftleg12.setTextureOffset(111, 15).addBox(-1F, 2.5F, -1.5F, 2, 2, 3);
        leftleg12.setTextureOffset(112, 20).addBox(-1F, 4.5F, -0.5F, 2, 2, 2);
        leftleg12.setTextureOffset(113, 24).addBox(-0.5F, 6.5F, -0.5F, 1, 2, 2);
        leftleg12.setTextureOffset(114, 28).addBox(-0.5F, 8.5F, 0.5F, 1, 2, 1);

        rightleg20 = new ModelRenderer(this);
        rightleg21 = new ModelRenderer(this, 98, 54);
        rightleg21.addBox(0F, 0F, -1.5F, 3, 9, 3, 0.2F);
        rightleg22j = new ModelRenderer(this, 100, 96);
        rightleg22j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg22 = new ModelRenderer(this, 98, 66);
        rightleg22.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        rightleg23j = new ModelRenderer(this, 100, 101);
        rightleg23j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg23 = new ModelRenderer(this);
        rightleg23.setTextureOffset(98, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        rightleg23.setTextureOffset(99, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        rightleg23.setTextureOffset(100, 87).addBox(-0.5F, 3.5F, -1F, 2, 2, 2);
        rightleg23.setTextureOffset(101, 91).addBox(-0.5F, 5.5F, -0.5F, 2, 1, 1);
        rightleg23.setTextureOffset(102, 93).addBox(0.5F, 6.5F, -0.5F, 1, 2, 1);

        rightleg30 = new ModelRenderer(this);
        rightleg31 = new ModelRenderer(this, 98, 54);
        rightleg31.addBox(0F, 0F, -1.5F, 3, 9, 3, 0.2F);
        rightleg32j = new ModelRenderer(this, 100, 96);
        rightleg32j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg32 = new ModelRenderer(this, 98, 66);
        rightleg32.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        rightleg33j = new ModelRenderer(this, 100, 101);
        rightleg33j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg33 = new ModelRenderer(this);
        rightleg33.setTextureOffset(98, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        rightleg33.setTextureOffset(99, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        rightleg33.setTextureOffset(100, 87).addBox(-0.5F, 3.5F, -1F, 2, 2, 2);
        rightleg33.setTextureOffset(101, 91).addBox(-0.5F, 5.5F, -0.5F, 2, 1, 1);
        rightleg33.setTextureOffset(102, 93).addBox(0.5F, 6.5F, -0.5F, 1, 2, 1);
        rightleg40 = new ModelRenderer(this);
        rightleg41 = new ModelRenderer(this, 98, 54);
        rightleg41.addBox(0F, 0F, -1.5F, 3, 9, 3, 0.2F);
        rightleg42j = new ModelRenderer(this, 100, 96);
        rightleg42j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg42 = new ModelRenderer(this, 98, 66);
        rightleg42.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        rightleg43j = new ModelRenderer(this, 100, 101);
        rightleg43j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg43 = new ModelRenderer(this);
        rightleg43.setTextureOffset(98, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        rightleg43.setTextureOffset(99, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        rightleg43.setTextureOffset(100, 87).addBox(-0.5F, 3.5F, -1F, 2, 2, 2);
        rightleg43.setTextureOffset(101, 91).addBox(-0.5F, 5.5F, -0.5F, 2, 1, 1);
        rightleg43.setTextureOffset(102, 93).addBox(0.5F, 6.5F, -0.5F, 1, 2, 1);
        rightleg50 = new ModelRenderer(this);
        rightleg51 = new ModelRenderer(this, 98, 54);
        rightleg51.addBox(0F, 0F, -1.5F, 3, 9, 3, 0.2F);
        rightleg52j = new ModelRenderer(this, 100, 96);
        rightleg52j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg52 = new ModelRenderer(this, 98, 66);
        rightleg52.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        rightleg53j = new ModelRenderer(this, 100, 101);
        rightleg53j.addBox(-0.5F, -1.5F, -1F, 2, 3, 2);
        rightleg53 = new ModelRenderer(this);
        rightleg53.setTextureOffset(98, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        rightleg53.setTextureOffset(99, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        rightleg53.setTextureOffset(100, 87).addBox(-0.5F, 3.5F, -1F, 2, 2, 2);
        rightleg53.setTextureOffset(101, 91).addBox(-0.5F, 5.5F, -0.5F, 2, 1, 1);
        rightleg53.setTextureOffset(102, 93).addBox(0.5F, 6.5F, -0.5F, 1, 2, 1);

        leftleg20 = new ModelRenderer(this);
        leftleg21 = new ModelRenderer(this, 110, 54);
        leftleg21.addBox(-3F, 0F, -1.5F, 3, 9, 3, 0.2F);
        leftleg22j = new ModelRenderer(this, 112, 96);
        leftleg22j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg22 = new ModelRenderer(this, 110, 66);
        leftleg22.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        leftleg23j = new ModelRenderer(this, 112, 101);
        leftleg23j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg23 = new ModelRenderer(this);
        leftleg23.setTextureOffset(110, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        leftleg23.setTextureOffset(111, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        leftleg23.setTextureOffset(112, 87).addBox(-1.5F, 3.5F, -1F, 2, 2, 2);
        leftleg23.setTextureOffset(113, 91).addBox(-1.5F, 5.5F, -0.5F, 2, 1, 1);
        leftleg23.setTextureOffset(114, 93).addBox(-1.5F, 6.5F, -0.5F, 1, 2, 1);

        leftleg30 = new ModelRenderer(this);
        leftleg31 = new ModelRenderer(this, 110, 54);
        leftleg31.addBox(-3F, 0F, -1.5F, 3, 9, 3, 0.2F);
        leftleg32j = new ModelRenderer(this, 112, 96);
        leftleg32j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg32 = new ModelRenderer(this, 110, 66);
        leftleg32.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        leftleg33j = new ModelRenderer(this, 112, 101);
        leftleg33j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg33 = new ModelRenderer(this);
        leftleg33.setTextureOffset(110, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        leftleg33.setTextureOffset(111, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        leftleg33.setTextureOffset(112, 87).addBox(-1.5F, 3.5F, -1F, 2, 2, 2);
        leftleg33.setTextureOffset(113, 91).addBox(-1.5F, 5.5F, -0.5F, 2, 1, 1);
        leftleg33.setTextureOffset(114, 93).addBox(-1.5F, 6.5F, -0.5F, 1, 2, 1);
        leftleg40 = new ModelRenderer(this);
        leftleg41 = new ModelRenderer(this, 110, 54);
        leftleg41.addBox(-3F, 0F, -1.5F, 3, 9, 3, 0.2F);
        leftleg42j = new ModelRenderer(this, 112, 96);
        leftleg42j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg42 = new ModelRenderer(this, 110, 66);
        leftleg42.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        leftleg43j = new ModelRenderer(this, 112, 101);
        leftleg43j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg43 = new ModelRenderer(this);
        leftleg43.setTextureOffset(110, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        leftleg43.setTextureOffset(111, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        leftleg43.setTextureOffset(112, 87).addBox(-1.5F, 3.5F, -1F, 2, 2, 2);
        leftleg43.setTextureOffset(113, 91).addBox(-1.5F, 5.5F, -0.5F, 2, 1, 1);
        leftleg43.setTextureOffset(114, 93).addBox(-1.5F, 6.5F, -0.5F, 1, 2, 1);
        leftleg50 = new ModelRenderer(this);
        leftleg51 = new ModelRenderer(this, 110, 54);
        leftleg51.addBox(-3F, 0F, -1.5F, 3, 9, 3, 0.2F);
        leftleg52j = new ModelRenderer(this, 112, 96);
        leftleg52j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg52 = new ModelRenderer(this, 110, 66);
        leftleg52.addBox(-1.5F, 0.5F, -1.5F, 3, 10, 3, 0.1F);
        leftleg53j = new ModelRenderer(this, 112, 101);
        leftleg53j.addBox(-1.5F, -1.5F, -1F, 2, 3, 2);
        leftleg53 = new ModelRenderer(this);
        leftleg53.setTextureOffset(110, 79).addBox(-1.5F, 0.5F, -1.5F, 3, 2, 3);
        leftleg53.setTextureOffset(111, 84).addBox(-1.5F, 2.5F, -1F, 3, 1, 2);
        leftleg53.setTextureOffset(112, 87).addBox(-1.5F, 3.5F, -1F, 2, 2, 2);
        leftleg53.setTextureOffset(113, 91).addBox(-1.5F, 5.5F, -0.5F, 2, 1, 1);
        leftleg53.setTextureOffset(114, 93).addBox(-1.5F, 6.5F, -0.5F, 1, 2, 1);

        head1.addChild(face);

        rightarm0.addChild(rightarm1);
        leftarm0.addChild(leftarm1);
        body1.addChild(head1);
        body1.addChild(rightbreast);
        body1.addChild(leftbreast);
        body1.addChild(rightarm0);
        body1.addChild(leftarm0);

        rightleg11.addChild(rightleg12);
        rightleg11.addChild(rightleg12j);
        leftleg11.addChild(leftleg12);
        leftleg11.addChild(leftleg12j);

        rightleg22.addChild(rightleg23);
        rightleg22.addChild(rightleg23j);
        rightleg21.addChild(rightleg22);
        rightleg21.addChild(rightleg22j);
        rightleg20.addChild(rightleg21);
        rightleg32.addChild(rightleg33);
        rightleg32.addChild(rightleg33j);
        rightleg31.addChild(rightleg32);
        rightleg31.addChild(rightleg32j);
        rightleg30.addChild(rightleg31);
        rightleg42.addChild(rightleg43);
        rightleg42.addChild(rightleg43j);
        rightleg41.addChild(rightleg42);
        rightleg41.addChild(rightleg42j);
        rightleg40.addChild(rightleg41);
        rightleg52.addChild(rightleg53);
        rightleg52.addChild(rightleg53j);
        rightleg51.addChild(rightleg52);
        rightleg51.addChild(rightleg52j);
        rightleg50.addChild(rightleg51);

        leftleg22.addChild(leftleg23);
        leftleg22.addChild(leftleg23j);
        leftleg21.addChild(leftleg22);
        leftleg21.addChild(leftleg22j);
        leftleg20.addChild(leftleg21);
        leftleg32.addChild(leftleg33);
        leftleg32.addChild(leftleg33j);
        leftleg31.addChild(leftleg32);
        leftleg31.addChild(leftleg32j);
        leftleg30.addChild(leftleg31);
        leftleg42.addChild(leftleg43);
        leftleg42.addChild(leftleg43j);
        leftleg41.addChild(leftleg42);
        leftleg41.addChild(leftleg42j);
        leftleg40.addChild(leftleg41);
        leftleg52.addChild(leftleg53);
        leftleg52.addChild(leftleg53j);
        leftleg51.addChild(leftleg52);
        leftleg51.addChild(leftleg52j);
        leftleg50.addChild(leftleg51);

        body31.addChild(body4j);
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

        body1.setRotationPoint(0F, -1F, -3.5F);
        rightarm0.setRotationPoint(-4F, 1.2F, 0F);
        leftarm0.setRotationPoint(4F, 1.2F, 0F);

        body31.setRotationPoint(0F, 11.5F, 0F);
        body4j.setRotationPoint(0F, 0F, 6.5F);
        body51.setRotationPoint(0F, 0F, 6.5F);

        rightleg11.setRotationPoint(-2.5F, 1F, -5F);
        rightleg12j.setRotationPoint(0F, 7.5F, 0F);
        rightleg12.setRotationPoint(0F, 7.5F, 0F);

        leftleg11.setRotationPoint(2.5F, 1F, -5F);
        leftleg12j.setRotationPoint(0F, 7.5F, 0F);
        leftleg12.setRotationPoint(0F, 7.5F, 0F);

        rightleg20.setRotationPoint(-4F, 2.5F, -3.5F);
        rightleg22j.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg22.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg23j.setRotationPoint(0F, 11F, 0F);
        rightleg23.setRotationPoint(0F, 11F, 0F);

        rightleg30.setRotationPoint(-4F, 2.5F, -1.5F);
        rightleg32j.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg32.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg33j.setRotationPoint(0F, 11F, 0F);
        rightleg33.setRotationPoint(0F, 11F, 0F);
        rightleg40.setRotationPoint(-4F, 2.5F, 1.5F);
        rightleg42j.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg42.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg43j.setRotationPoint(0F, 11F, 0F);
        rightleg43.setRotationPoint(0F, 11F, 0F);
        rightleg50.setRotationPoint(-4F, 2.5F, 3.5F);
        rightleg52j.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg52.setRotationPoint(1.5F, 9.5F, 0F);
        rightleg53j.setRotationPoint(0F, 11F, 0F);
        rightleg53.setRotationPoint(0F, 11F, 0F);

        leftleg20.setRotationPoint(4F, 2.5F, -3.5F);
        leftleg22j.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg22.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg23j.setRotationPoint(0F, 11F, 0F);
        leftleg23.setRotationPoint(0F, 11F, 0F);

        leftleg30.setRotationPoint(4F, 2.5F, -1.5F);
        leftleg32j.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg32.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg33j.setRotationPoint(0F, 11F, 0F);
        leftleg33.setRotationPoint(0F, 11F, 0F);
        leftleg40.setRotationPoint(4F, 2.5F, 1.5F);
        leftleg42j.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg42.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg43j.setRotationPoint(0F, 11F, 0F);
        leftleg43.setRotationPoint(0F, 11F, 0F);
        leftleg50.setRotationPoint(4F, 2.5F, 3.5F);
        leftleg52j.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg52.setRotationPoint(-1.5F, 9.5F, 0F);
        leftleg53j.setRotationPoint(0F, 11F, 0F);
        leftleg53.setRotationPoint(0F, 11F, 0F);

        setRotation(rightbreast, 0.7679449F, 0.0523599F, 0.0872665F);
        setRotation(leftbreast, 0.7679449F, -0.0523599F, -0.0872665F);

        setRotation(body4j, 0.0698131F, 0F, 0F);
        setRotation(body51, 0.1396263F, 0F, 0F);

        setRotation(rightleg11, -2.443461F, 0.2268928F, 0F);
        setRotation(rightleg12j, 1.038471F, 0F, 0F);
        setRotation(rightleg12, 2.076942F, 0F, 0F);

        setRotation(leftleg11, -2.443461F, -0.2268928F, 0F);
        setRotation(leftleg12j, 1.038471F, 0F, 0F);
        setRotation(leftleg12, 2.076942F, 0F, 0F);

        setRotation(rightleg21, 0F, 0F, 2.635447F);
        setRotation(rightleg22j, 0F, 0F, -1.0210175F);
        setRotation(rightleg22, 0F, 0F, -2.0420351F);
        setRotation(rightleg23j, 0F, 0F, -0.392699F);
        setRotation(rightleg23, 0F, 0F, -0.7853981F);
        setRotation(rightleg31, 0F, 0F, 2.635447F);
        setRotation(rightleg32j, 0F, 0F, -1.0210175F);
        setRotation(rightleg32, 0F, 0F, -2.0420351F);
        setRotation(rightleg33j, 0F, 0F, -0.392699F);
        setRotation(rightleg33, 0F, 0F, -0.7853981F);
        setRotation(rightleg41, 0F, 0F, 2.635447F);
        setRotation(rightleg42j, 0F, 0F, -1.0210175F);
        setRotation(rightleg42, 0F, 0F, -2.0420351F);
        setRotation(rightleg43j, 0F, 0F, -0.392699F);
        setRotation(rightleg43, 0F, 0F, -0.7853981F);
        setRotation(rightleg51, 0F, 0F, 2.635447F);
        setRotation(rightleg52j, 0F, 0F, -1.0210175F);
        setRotation(rightleg52, 0F, 0F, -2.0420351F);
        setRotation(rightleg53j, 0F, 0F, -0.392699F);
        setRotation(rightleg53, 0F, 0F, -0.7853981F);

        setRotation(leftleg21, 0F, 0F, -2.635447F);
        setRotation(leftleg22j, 0F, 0F, 1.0210175F);
        setRotation(leftleg22, 0F, 0F, 2.0420351F);
        setRotation(leftleg23j, 0F, 0F, 0.392699F);
        setRotation(leftleg23, 0F, 0F, 0.7853981F);
        setRotation(leftleg31, 0F, 0F, -2.635447F);
        setRotation(leftleg32j, 0F, 0F, 1.0210175F);
        setRotation(leftleg32, 0F, 0F, 2.0420351F);
        setRotation(leftleg33j, 0F, 0F, 0.392699F);
        setRotation(leftleg33, 0F, 0F, 0.7853981F);
        setRotation(leftleg41, 0F, 0F, -2.635447F);
        setRotation(leftleg42j, 0F, 0F, 1.0210175F);
        setRotation(leftleg42, 0F, 0F, 2.0420351F);
        setRotation(leftleg43j, 0F, 0F, 0.392699F);
        setRotation(leftleg43, 0F, 0F, 0.7853981F);
        setRotation(leftleg51, 0F, 0F, -2.635447F);
        setRotation(leftleg52j, 0F, 0F, 1.0210175F);
        setRotation(leftleg52, 0F, 0F, 2.0420351F);
        setRotation(leftleg53j, 0F, 0F, 0.392699F);
        setRotation(leftleg53, 0F, 0F, 0.7853981F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        EntityArachneMedium entityarachne = (EntityArachneMedium) entity;
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
        EntityArachneMedium entityarachne = (EntityArachneMedium) p_78086_1_;

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
            this.rightleg11.rotateAngleX = -f - 2.443461F;
            this.rightleg12j.rotateAngleX = (f + 2.076942F) / 2F;
            this.rightleg12.rotateAngleX = f + 2.076942F;
            if (i < 10)
            {
                float f2 = -0.25F + 0.4F * this.func_78172_a((float) i + 3 - p_78086_4_, 6.0F);
                this.leftleg11.rotateAngleX = -f2 - 2.443461F;
                this.leftleg12j.rotateAngleX = (f2 + 2.076942F) / 2F;
                this.leftleg12.rotateAngleX = f2 + 2.076942F;
            }
        }
        else
        {
            this.rightleg11.rotateAngleX = -2.443461F;
            this.leftleg11.rotateAngleX = -2.443461F;
            this.rightleg12j.rotateAngleX = 1.038471F;
            this.leftleg12j.rotateAngleX = 1.038471F;
            this.rightleg12.rotateAngleX = 2.076942F;
            this.leftleg12.rotateAngleX = 2.076942F;
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

        float f6 = -2.635447F;
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
