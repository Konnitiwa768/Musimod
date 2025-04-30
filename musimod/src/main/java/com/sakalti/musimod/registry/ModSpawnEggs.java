package com.sakalti.musimod.registry;

import com.sakalti.musimod.MusiMod;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Rarity;

public class ModSpawnEggs {
    public static final Item CENTIPEDE_SPAWN_EGG = registerSpawnEgg("centipede_spawn_egg",
        MusiModEntities.CENTIPEDE,
        0x553311, // 背景色（茶色）
        0xDDCC00  // 点の色（黄）
    );

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
