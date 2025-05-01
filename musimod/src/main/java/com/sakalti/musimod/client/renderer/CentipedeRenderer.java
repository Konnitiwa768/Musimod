package com.sakalti.musimod.client.renderer;

import com.sakalti.musimod.MusiMod;
import com.sakalti.musimod.entity.CentipedeEntity;
import com.sakalti.musimod.entity.model.CentipedeModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CentipedeRenderer extends MobEntityRenderer<CentipedeEntity, CentipedeModel> {
    public CentipedeRenderer(EntityRendererFactory.Context context) {
        super(context, new CentipedeModel(context.getPart(CentipedeModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public Identifier getTexture(CentipedeEntity entity) {
        return new Identifier(MusiMod.MOD_ID, "textures/entity/centipede.png");
    }
}
