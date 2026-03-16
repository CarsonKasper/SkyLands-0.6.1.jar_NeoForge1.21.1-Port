package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.procedures.FriendlyVexOnEntityTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.registries.BuiltInRegistries;

public class FriendlyVexEntity extends PathfinderMob {

   public FriendlyVexEntity(EntityType<FriendlyVexEntity> type, Level world) {
      super(type, world);
      this.xpReward = 0;
      this.setNoAi(false);
      this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 3.0, false) {
         protected double getAttackReachSqr(LivingEntity entity) {
            return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
         }
      });
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Monster.class, false, false));
      this.goalSelector.addGoal(3, new RandomStrollGoal(this, 2.0, 20) {
         protected Vec3 getPosition() {
            RandomSource random = FriendlyVexEntity.this.getRandom();
            double dir_x = FriendlyVexEntity.this.getX() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            double dir_y = FriendlyVexEntity.this.getY() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            double dir_z = FriendlyVexEntity.this.getZ() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            return new Vec3(dir_x, dir_y, dir_z);
         }
      });
      this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(5, new FloatGoal(this));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.allay.ambient_with_item"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      return damagesource.getDirectEntity() instanceof Player ? false : super.hurt(damagesource, amount);
   }

   public void tick() {
      super.tick();
      FriendlyVexOnEntityTickUpdateProcedure.execute(this.level(), this);
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   public void setNoGravity(boolean ignored) {
      super.setNoGravity(true);
   }

   public void aiStep() {
      super.aiStep();
      this.setNoGravity(true);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, 30.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
      return builder.add(Attributes.FLYING_SPEED, 0.3);
   }
}





