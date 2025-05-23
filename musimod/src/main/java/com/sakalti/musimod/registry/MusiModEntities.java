package com.sakalti.musimod.registry;

import com.sakalti.musimod.entity.*;
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
            .dimensions(EntityDimensions.fixed(0.5f, 1.0f))
            .build()
    );

    public static final EntityType<FlyEntity> FLY = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("musimod", "fly"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FlyEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
            .build()
    );

    public static final EntityType<ScorpionEntity> SCORPION = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("musimod", "scorpion"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScorpionEntity::new)
            .dimensions(EntityDimensions.fixed(1.0f, 0.6f))
            .build()
    );

    public static void register() {}
}
