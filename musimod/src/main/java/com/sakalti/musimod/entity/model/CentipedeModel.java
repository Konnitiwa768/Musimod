package com.sakalti.musimod.entity.model;

import com.sakalti.musimod.entity.CentipedeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class CentipedeModel extends SinglePartEntityModel<CentipedeEntity> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(
        new Identifier("musimod", "centipede"), "main");

    private final ModelPart root;

    public CentipedeModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // 各体節を作成（X方向に10個）
        ModelPartData body = root.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0, 24, 0));
        for (int i = 0; i < 10; i++) {
            int offset = -20 + i * 4; // 4ピクセルずつ間隔
            body.addChild("segment_" + i, ModelPartBuilder.create()
                .uv(0, i * 2).cuboid(offset, -5, -1, 4, 5, 2), ModelTransform.NONE);
        }

        // 左右の足（同様に10セットずつ）
        ModelPartData leftLegs = root.addChild("left_legs", ModelPartBuilder.create(), ModelTransform.pivot(0, 24, 0));
        ModelPartData rightLegs = root.addChild("right_legs", ModelPartBuilder.create(), ModelTransform.pivot(0, 24, 0));

        for (int i = 0; i < 10; i++) {
            int offset = -18 + i * 4;
            leftLegs.addChild("left_leg_" + i, ModelPartBuilder.create()
                .uv(16, 0).cuboid(-1, 0, -3, 2, 1, 6), ModelTransform.pivot(offset, -1, 0));

            rightLegs.addChild("right_leg_" + i, ModelPartBuilder.create()
                .uv(16, 8).cuboid(-1, 0, -3, 2, 1, 6), ModelTransform.pivot(offset + 2, -1, 0));
        }

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
public void setAngles(CentipedeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    float speed = 0.157f; // ≒ 2π / 40tick
    float rotation = (float) Math.sin(animationProgress * speed) * 0.785f; // ±45° = ±π/4 ≒ 0.785

    // 各脚に適用
    for (int i = 0; i < 10; i++) {
        ModelPart leftLeg = this.root.getChild("left_legs").getChild("left_leg_" + i);
        ModelPart rightLeg = this.root.getChild("right_legs").getChild("right_leg_" + i);

        float phase = (i % 2 == 0 ? 1 : -1); // ジグザグに動くように交互で位相反転
        leftLeg.pitch = rotation * phase;
        rightLeg.pitch = -rotation * phase;
    }
}


    @Override
    public ModelPart getPart() {
        return root;
    }
}
