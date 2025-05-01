package com.sakalti.musimod.client;

import com.sakalti.musimod.MusiMod;
import com.sakalti.musimod.entity.CentipedeEntity;
import com.sakalti.musimod.entity.FlyEntity;
import com.sakalti.musimod.entity.model.CentipedeModel;
import com.sakalti.musimod.entity.model.FlyModel;
import com.sakalti.musimod.entity.ModEntities;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ModEntityRenderers {

    public static class CentipedeRenderer extends MobEntityRenderer<CentipedeEntity, CentipedeModel> {
        public CentipedeRenderer(EntityRendererFactory.Context context) {
            super(context, new CentipedeModel(context.getPart(CentipedeModel.LAYER_LOCATION)), 0.7f);
        }

        @Override
        public Identifier getTexture(CentipedeEntity entity) {
            return new Identifier(MusiMod.MOD_ID, "textures/entity/centipede.png");
        }
    }

    public static class FlyRenderer extends MobEntityRenderer<FlyEntity, FlyModel> {
        public FlyRenderer(EntityRendererFactory.Context context) {
            super(context, new FlyModel(context.getPart(FlyModel.LAYER_LOCATION)), 0.4f);
        }

        @Override
        public Identifier getTexture(FlyEntity entity) {
            return new Identifier(MusiMod.MOD_ID, "textures/entity/fly/fly_1.png");
        }
    }
}
