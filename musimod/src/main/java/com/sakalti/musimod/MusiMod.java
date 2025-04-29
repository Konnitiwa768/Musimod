package com.sakalti.musimod;

import com.sakalti.musimod.registry.MusiModEntities;
import com.sakalti.musimod.entity.CentipedeEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class MusiMod implements ModInitializer {

    public static final String MOD_ID = "musimod";

    @Override
    public void onInitialize() {
        MusiModEntities.register();
        FabricDefaultAttributeRegistry.register(MusiModEntities.CENTIPEDE, CentipedeEntity.createCentipedeAttributes());
    }
}
