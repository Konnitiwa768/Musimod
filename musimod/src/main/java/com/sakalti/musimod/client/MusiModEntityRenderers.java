package com.sakalti.musimod.client;

import com.sakalti.musimod.client.renderer.*;
import com.sakalti.musimod.entity.model.*;
import com.sakalti.musimod.registry.MusiModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererRegistry;

public class MusiModEntityRenderers implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(MusiModEntities.FLY, FlyRenderer::new);
        EntityRendererRegistry.register(MusiModEntities.CENTIPEDE, CentipedeRenderer::new);
        EntityRendererRegistry.register(MusiModEntities.SCORPION, ScorpionRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FlyModel.LAYER_LOCATION, FlyModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(CentipedeModel.LAYER_LOCATION, CentipedeModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ScorpionModel.LAYER_LOCATION, ScorpionModel::getTexturedModelData);
    }
}
