package com.teamabnormals.pet_cemetery.common.entity;

import com.teamabnormals.pet_cemetery.core.registry.PCEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.level.Level;

public class SkeletonParrot extends Parrot {

	public SkeletonParrot(EntityType<? extends SkeletonParrot> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	public SkeletonParrot getBreedOffspring(ServerLevel world, AgeableMob entity) {
		SkeletonParrot parrot = PCEntityTypes.SKELETON_PARROT.get().create(world);
		if (this.random.nextBoolean()) {
			parrot.setVariant(this.getVariant());
		} else {
			parrot.setVariant(parrot.getVariant());
		}

		if (this.isTame()) {
			parrot.setOwnerUUID(this.getOwnerUUID());
			parrot.setTame(true);
		}

		return parrot;
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.SKELETON_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SKELETON_DEATH;
	}
}