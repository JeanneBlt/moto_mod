package com.pyloufass.motomod.entity.client;
import com.pyloufass.motomod.MotoMod;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class MotoModel extends EntityModel<MotoRenderState> {
    public static final EntityModelLayer MOTO = new EntityModelLayer(Identifier.of(MotoMod.MOD_ID, "moto"), "main");
    private final ModelPart moto;
    private final ModelPart front_moto;
    private final ModelPart front_body;
    private final ModelPart head;
    private final ModelPart Retroviseur;
    private final ModelPart bone;
    private final ModelPart bone2;
    private final ModelPart fork;
    private final ModelPart front_wheel;
    private final ModelPart back_moto;
    private final ModelPart body;
    private final ModelPart moto_butt;
    private final ModelPart Mufflers;
    private final ModelPart back_wheel;
    public MotoModel(ModelPart root) {
        super(root);
        this.moto = root.getChild("moto");
        this.front_moto = this.moto.getChild("front_moto");
        this.front_body = this.front_moto.getChild("front_body");
        this.head = this.front_body.getChild("head");
        this.Retroviseur = this.head.getChild("Retroviseur");
        this.bone = this.Retroviseur.getChild("bone");
        this.bone2 = this.Retroviseur.getChild("bone2");
        this.fork = this.front_body.getChild("fork");
        this.front_wheel = this.front_moto.getChild("front_wheel");
        this.back_moto = this.moto.getChild("back_moto");
        this.body = this.back_moto.getChild("body");
        this.moto_butt = this.body.getChild("moto_butt");
        this.Mufflers = this.moto_butt.getChild("Mufflers");
        this.back_wheel = this.back_moto.getChild("back_wheel");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData moto = modelPartData.addChild("moto", ModelPartBuilder.create(), ModelTransform.of(0.0F, 5.0F, 3.0F,0,0,0));

        ModelPartData front_moto = moto.addChild("front_moto", ModelPartBuilder.create(), ModelTransform.of(0.0F, 1.0F, -8.0F,0,0,0));

        ModelPartData front_body = front_moto.addChild("front_body", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.0F, -1.0F,0,0,0));

        ModelPartData head = front_body.addChild("head", ModelPartBuilder.create().uv(61, 88).cuboid(-2.0F, -5.0F, -18.0F, 4.0F, 6.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 58).cuboid(-6.0F, -13.0F, -15.0F, 12.0F, 13.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F,0,0,0));

        ModelPartData Retroviseur = head.addChild("Retroviseur", ModelPartBuilder.create(), ModelTransform.of(0.0F, -10.0F, -3.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData bone = Retroviseur.addChild("bone", ModelPartBuilder.create().uv(76, 88).cuboid(0.0F, -5.0F, 0.0F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -1.0F, 0.0F, 0.1745F, -0.3491F, 0.1745F));

        ModelPartData bone2 = Retroviseur.addChild("bone2", ModelPartBuilder.create().uv(76, 88).mirrored().cuboid(-7.0F, -5.0F, 0.0F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.0F, -1.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

        ModelPartData fork = front_body.addChild("fork", ModelPartBuilder.create().uv(0, 88).cuboid(-5.0F, -4.0F, -2.5F, 10.0F, 15.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, -7.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData front_wheel = front_moto.addChild("front_wheel", ModelPartBuilder.create().uv(61, 29).cuboid(-4.0F, -7.0F, -7.0F, 8.0F, 14.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, -11.0F,0,0,0));

        ModelPartData back_moto = moto.addChild("back_moto", ModelPartBuilder.create(), ModelTransform.of(0.0F, 4.0F, -3.0F,0,0,0));

        ModelPartData body = back_moto.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -4.0F, -20.0F, 9.0F, 6.0F, 22.0F, new Dilation(0.0F))
                .uv(0, 29).cuboid(-5.0F, -14.0F, -23.0F, 12.0F, 10.0F, 18.0F, new Dilation(0.3F)), ModelTransform.of(-1.0F, 8.0F, 15.0F,0,0,0));

        ModelPartData moto_butt = body.addChild("moto_butt", ModelPartBuilder.create().uv(57, 58).cuboid(-6.0F, -13.0F, 0.0F, 12.0F, 14.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -5.0F, -5.0F, 0.2793F, 0.0F, 0.0F));

        ModelPartData Mufflers = moto_butt.addChild("Mufflers", ModelPartBuilder.create().uv(31, 88).cuboid(6.0F, -2.0F, 0.0F, 0.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(46, 88).cuboid(-6.0F, -2.0F, 0.0F, 0.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 15.0F,0,0,0));

        ModelPartData back_wheel = back_moto.addChild("back_wheel", ModelPartBuilder.create().uv(61, 29).cuboid(-4.0F, -7.0F, -7.0F, 8.0F, 14.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, 15.0F,0,0,0));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(MotoRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.animateWalking(MotoAnimations.MOTO_WALK, state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.animate(state.idleAnimationState, MotoAnimations.MOTO_IDLE, state.age, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
}

