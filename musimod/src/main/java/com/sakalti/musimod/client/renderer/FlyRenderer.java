package com.sakalti.musimod.entity.renderer;

import com.sakalti.musimod.entity.FlyEntity;
import com.sakalti.musimod.entity.model.FlyModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FlyRenderer extends MobEntityRenderer<FlyEntity, FlyModel> {
    public FlyRenderer(EntityRendererFactory.Context context) {
        super(context, new FlyModel(context.getPart(FlyModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public Identifier getTexture(FlyEntity entity) {
        int index = entity.getId() % 3;
        return new Identifier("musimod", "textures/entity/fly/fly_" + (index + 1) + ".png");
    }
}
