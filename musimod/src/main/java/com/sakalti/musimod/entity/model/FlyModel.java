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

    public FlyModel(ModelPart root) {
        this.root = root;
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
    public void setAngles(FlyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {}

    @Override
    public ModelPart getPart() {
        return root;
    }
}
