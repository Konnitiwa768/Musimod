package com.sakalti.musimod.client.renderer;

import com.sakalti.musimod.entity.ScorpionEntity;
import com.sakalti.musimod.entity.model.ScorpionModel;
import com.sakalti.musimod.MusiMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class ScorpionRenderer extends MobEntityRenderer<ScorpionEntity, ScorpionModel> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(
        new Identifier(MusiMod.MOD_ID, "scorpion"), "main"
    );

    public ScorpionRenderer(EntityRendererFactory.Context context) {
        super(context, new ScorpionModel(context.getPart(LAYER)), 0.6f);
    }

    @Override
    public Identifier getTexture(ScorpionEntity entity) {
        return new Identifier(MusiMod.MOD_ID, "textures/entity/centipede.png");
    }
}
