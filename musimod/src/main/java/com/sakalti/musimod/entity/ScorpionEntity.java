package com.sakalti.musimod.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.random.Random;

public class ScorpionEntity extends HostileEntity {
    public ScorpionEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.1, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.7));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, FlyEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createScorpionAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 90.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean success = super.tryAttack(target);
        if (success && target instanceof LivingEntity living) {
            living.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 2)); // 毒III, 5秒
        }
        return success;
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        if (this.random.nextFloat() < 0.5f) {
            this.dropStack(new net.minecraft.item.ItemStack(net.minecraft.item.Items.EMERALD, 1 + this.random.nextInt(2)));
        }
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }
}
