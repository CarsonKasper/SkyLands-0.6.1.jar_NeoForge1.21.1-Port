package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.core.registries.BuiltInRegistries;

public class AridSkyAutomatonEntity extends Monster {

   public AridSkyAutomatonEntity(EntityType<AridSkyAutomatonEntity> type, Level world) {
      super(type, world);      this.xpReward = 10;
      this.setNoAi(false);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
         }
      });
      this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.6));
      this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bone_block.break"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bone_block.break"));
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      return !(damagesource.getDirectEntity() instanceof ThrownPotion) && !(damagesource.getDirectEntity() instanceof AreaEffectCloud)
         ? super.hurt(damagesource, amount)
         : false;
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
      builder = builder.add(Attributes.MAX_HEALTH, 30.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 8.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 25.0);
      builder = builder.add(Attributes.ARMOR, 0.2);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.8);
   }
}





