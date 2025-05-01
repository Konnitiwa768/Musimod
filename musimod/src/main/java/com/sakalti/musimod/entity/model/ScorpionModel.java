package com.sakalti.musimod.entity.model;

import com.sakalti.musimod.entity.ScorpionEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ScorpionModel extends SinglePartEntityModel<ScorpionEntity> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(
        new Identifier("musimod", "scorpion"), "main");

    private final ModelPart root;
    private final ModelPart segment2;
    private final ModelPart segment3;

    public ScorpionModel(ModelPart root) {
        this.root = root;
        this.segment2 = root.getChild("segment2");
        this.segment3 = root.getChild("segment3");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("segment1", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4, 0, -4, 8, 4, 8),
            ModelTransform.pivot(0, 20, 0));

        root.addChild("segment2", ModelPartBuilder.create()
            .uv(0, 12).cuboid(-3, 0, -3, 6, 3, 6),
            ModelTransform.pivot(0, 20, 5));

        root.addChild("segment3", ModelPartBuilder.create()
            .uv(0, 21).cuboid(-2, 0, -2, 4, 2, 4),
            ModelTransform.pivot(0, 20, 10));

        root.addChild("left_claw", ModelPartBuilder.create()
            .uv(20, 0).cuboid(-1, 0, -3, 2, 2, 4),
            ModelTransform.pivot(3, 21, -4));

        root.addChild("right_claw", ModelPartBuilder.create()
            .uv(20, 6).cuboid(-1, 0, -3, 2, 2, 4),
            ModelTransform.pivot(-3, 21, -4));

        for (int i = 0; i < 6; i++) {
            root.addChild("leg" + i, ModelPartBuilder.create()
                .uv(30, 0).cuboid(-1, 0, -1, 2, 3, 2),
                ModelTransform.pivot((i - 3) * 2, 21, (i % 2 == 0) ? 0 : 2));
        }

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(ScorpionEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float rotation = (float) Math.sin(animationProgress * Math.PI) * 0.3f;
        segment2.yaw = rotation;
        segment3.yaw = rotation * 1.5f;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
