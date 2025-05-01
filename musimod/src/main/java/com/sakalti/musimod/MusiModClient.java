package com.sakalti.musimod;

import com.sakalti.musimod.client.renderer.CentipedeRenderer;
import com.sakalti.musimod.client.renderer.FlyRenderer;
import com.sakalti.musimod.client.renderer.ScorpionRenderer;
import com.sakalti.musimod.registry.MusiModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MusiModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(MusiModEntities.CENTIPEDE, CentipedeRenderer::new);
        EntityRendererRegistry.register(MusiModEntities.FLY, FlyRenderer::new);
        EntityRendererRegistry.register(MusiModEntities.SCORPION, ScorpionRenderer::new);
    }
}
