package com.sakalti.musimod.registry;

import com.sakalti.musimod.entity.ScorpionEntity;
import com.sakalti.musimod.entity.FlyEntity;
import com.sakalti.musimod.entity.CentipedeEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.entity.SpawnGroup;

public class MusiModEntitySpawns {
    public static void register() {
        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.PLAINS),
            SpawnGroup.MONSTER,
            MusiModEntities.FLY,
            70, 2, 4
        );

        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(BiomeKeys.FOREST),
            SpawnGroup.MONSTER,
            MusiModEntities.CENTIPEDE,
            40, 1, 2
        );

        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(BiomeKeys.DESERT),
            SpawnGroup.MONSTER,
            MusiModEntities.SCORPION,
            30, 1, 2
        );
    }
}
