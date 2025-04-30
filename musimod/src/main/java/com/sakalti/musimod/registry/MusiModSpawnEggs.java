package com.sakalti.musimod.registry;

import com.sakalti.musimod.MusiMod;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Rarity;

public class MusiModSpawnEggs {
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
        MusiMod.LOpackage com.sakalti.musimod.registry;

import com.sakalti.musimod.MusiMod;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Rarity;

public class MusiModSpawnEggs {
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

    public statipackage com.sakalti.musimod.registry;

import com.sakalti.musimod.MusiMod;
import com.sakalti.musimod.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Rarity;
import net.minecraft.item.ItemGroup;

public class ModSpawnEggs {
    public static final Item CENTIPEDE_SPAWN_EGG = registerSpawnEgg("centipede_spawn_egg",
        ModEntities.CENTIPEDE,
        0x553311, // 背景色（茶色）
        0xDDCC00  // 点の色（黄）
    );

    public static final Item FLY_SPAWN_EGG = registerSpawnEgg("fly_spawn_egg",
        ModEntities.FLY,
        0x00FF00, // 体の色（緑）
        0x000000  // 目の色（黒）
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
