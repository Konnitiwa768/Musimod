package com.sakalti.musimod;

import com.sakalti.musimod.registry.MusiModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

public class MusiModWorldGen {

    public static void register() {
        BiomeModifications.addSpawn(
            (context) -> context.getBiomeKey() == BiomeKeys.FOREST || context.getBiomeKey() == BiomeKeys.PLAINS,
            SpawnGroup.MONSTER,
            MusiModEntities.CENTIPEDE,
            10, 1, 3
        );
    }
}
