package com.sakalti.musimod.entity.model;

import com.sakalti.musimod.entity.FlyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class FlyModel extends SinglePartEntityModel<FlyEntity> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(
        new Identifier("musimod", "fly"), "main");

    private final ModelPart root;
    private final ModelPart leg;
    private final ModelPart wing;

    public FlyModel(ModelPart root) {
        this.root = root;
        this.leg = root.getChild("leg");
        this.wing = root.getChild("wing");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("body", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4, 0, -4, 8, 8, 8),
            ModelTransform.pivot(0, 16, 0));

        root.addChild("head", ModelPartBuilder.create()
            .uv(32, 0).cuboid(-2, -4, -2, 4, 4, 4),
            ModelTransform.pivot(0, 16, -4));

        root.addChild("leg", ModelPartBuilder.create()
            .uv(32, 8).cuboid(-1, 0, -1, 2, 4, 2),
            ModelTransform.pivot(0, 20, 0));

        root.addChild("wing", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-8, 0, -3, 16, 1, 6),
            ModelTransform.pivot(0, 15, 0));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(FlyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.leg.pitch = (float) Math.sin(animationProgress * Math.PI) * 0.785f;
        this.wing.roll = (float) Math.sin(animationProgress * Math.PI * 2) * 0.5f;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}

        // 羽のモデル設定
        wings[0] = root.getChild("wing_left");
        wings[1] = root.getChild("wing_right");
    }

    // モデルデータの定義
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // 体
        root.addChild("body", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4, 0, -4, 8, 8, 8),
            ModelTransform.pivot(0, 16, 0));

        // 頭
        root.addChild("head", ModelPartBuilder.create()
            .uv(32, 0).cuboid(-2, -4, -2, 4, 4, 4),
            ModelTransform.pivot(0, 16, -4));

        // 足 (6本の足を追加)
        for (int i = 0; i < 6; i++) {
            root.addChild("leg_" + i, ModelPartBuilder.create()
                .uv(32, 8).cuboid(-1, 0, -1, 2, 4, 2),
                ModelTransform.pivot(0, 20, 0));
        }

        // 羽 (2つの羽)
        root.addChild("wing_left", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-8, 0, -3, 16, 1, 6),
            ModelTransform.pivot(0, 15, 0));

        root.addChild("wing_right", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-8, 0, -3, 16, 1, 6),
            ModelTransform.pivot(0, 15, 0));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(FlyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 羽ばたきアニメーション (周期的に上下動)
        float wingAngle = Math.cos(animationProgress * 0.4f) * 0.5f; // 上下に振れる角度

        // 右羽、左羽のアニメーション設定
        wings[0].pitch = wingAngle;
        wings[1].pitch = -wingAngle;

        // 足のアニメーション（簡単な前後運動）
        for (int i = 0; i < 6; i++) {
            float legAngle = Math.sin(animationProgress * 0.5f + i) * 0.3f; // 各足を異なる速度で前後に動かす
            legs[i].pitch = legAngle;
        }
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
