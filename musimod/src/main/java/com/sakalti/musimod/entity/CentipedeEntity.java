package com.sakalti.musimod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class CentipedeEntity extends HostileEntity {

    public CentipedeEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, ZombieEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createCentipedeAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 75.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0);
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    // ドロップアイテムの設定
    @Override
    protected void dropLoot(LootContext.Builder context) {
        super.dropLoot(context); // デフォルトのドロップアイテムを追加

        Random random = context.getWorld().getRandom();
        if (random.nextDouble() <= 0.147) { // 14.7%の確率でダイヤモンドをドロップ
            int amount = random.nextInt(3) + 1; // 1〜3個
            this.dropItem(Items.DIAMOND, amount);
        }
    }
}
