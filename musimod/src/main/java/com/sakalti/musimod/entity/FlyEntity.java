package com.sakalti.musimod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class FlyEntity extends HostileEntity {

    public FlyEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, false));  // 攻撃目標
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.6));    // ランダムに動く
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));  // プレイヤーを見る
        this.goalSelector.add(4, new LookAroundGoal(this));  // 周囲を見回す

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));  // プレイヤー攻撃対象
    }

    public static DefaultAttributeContainer.Builder createFlyAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    // ドロップアイテムの設定
    @Override
    protected void dropLoot(LootContext.Builder context) {
        super.dropLoot(context); // デフォルトのドロップアイテムを追加

        Random random = context.getWorld().getRandom();
        if (random.nextDouble() <= 0.846) { // 84.6%の確率で鉄をドロップ
            int amount = random.nextInt(2) + 1; // 1〜2個
            this.dropItem(Items.IRON_INGOT, amount);
        }
    }

    @Override
    public boolean isFireImmune() {
        return true;  // 火に免疫
    }
}
