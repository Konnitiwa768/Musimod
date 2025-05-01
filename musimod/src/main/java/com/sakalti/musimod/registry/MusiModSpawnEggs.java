package com.sakalti.musimod.registry;

import com.sakalti.musimod.MusiMod;
import com.sakalti.musimod.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Rarity;

public class ModSpawnEggs {
    public static final Item CENTIPEDE_SPAWN_EGG = registerSpawnEgg("centipede_spawn_egg",
        ModEntities.CENTIPEDE, 0x553311, 0xDDCC00);

    public static final Item FLY_SPAWN_EGG = registerSpawnEgg("fly_spawn_egg",
        ModEntities.FLY, 0x00FF00, 0x000000);

    public static final Item SCORPION_SPAWN_EGG = registerSpawnEgg("scorpion_spawn_egg",
        ModEntities.SCORPION, 0x880000, 0x000000); // 赤と黒

    private static Item registerSpawnEgg(String name, EntityType<?> type, int primaryColor, int secondaryColor) {
        return Registry.register(
            Registry.ITEM,
            new Identifier(MusiMod.MOD_ID, name),
            new SpawnEggItem(type, primaryColor, secondaryColor, new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON))
        );
    }

    public static void register() {
        MusiMod.LOGGER.info("Registering spawn eggs for MusiMod");
    }
}
