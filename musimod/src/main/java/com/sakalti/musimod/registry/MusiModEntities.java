package com.sakalti.musimod.registry;

import com.sakalti.musimod.entity.CentipedeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MusiModEntities {
    public static final EntityType<CentipedeEntity> CENTIPEDE = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("musimod", "centipede"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CentipedeEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f, 1.0f)) // 長さはモデルで制御
            .build()
    );

    public static void register() {
        // 呼び出し専用
    }
}
