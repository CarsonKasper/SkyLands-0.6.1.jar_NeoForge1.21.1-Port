package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.registries.BuiltInRegistries;

public class AutomatonDroneEntity extends Monster implements RangedAttackMob {

   public AutomatonDroneEntity(EntityType<AutomatonDroneEntity> type, Level world) {
      super(type, world);
      this.xpReward = 6;
      this.setNoAi(false);
      this.moveControl = new FlyingMoveControl(this, 10, true);
      this.refreshDimensions();
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 15.0F));
      this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.9, 20) {
         protected Vec3 getPosition() {
            RandomSource random = AutomatonDroneEntity.this.getRandom();
            double dir_x = AutomatonDroneEntity.this.getX() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            double dir_y = AutomatonDroneEntity.this.getY() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            double dir_z = AutomatonDroneEntity.this.getZ() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            return new Vec3(dir_x, dir_y, dir_z);
         }
      });
      this.targetSelector.addGoal(4, new HurtByTargetGoal(this, new Class[0]));
      this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(6, new FloatGoal(this));
      this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 60, 15.0F) {
         public boolean canUse() {
            return super.canUse();
         }
      });
   }

   protected void dropCustomDeathLoot(ServerLevel level, DamageSource source, boolean recentlyHitIn) {
      super.dropCustomDeathLoot(level, source, recentlyHitIn);
      this.spawnAtLocation(new ItemStack((ItemLike)FlyingStuffModItems.CELESTIUM.get()));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource damagesource, float amount) {
      if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud) {
         return false;
      } else {
         return damagesource.is(DamageTypes.FALL) ? false : super.hurt(damagesource, amount);
      }
   }

   public void performRangedAttack(LivingEntity target, float flval) {
      FloatGrapeProjEntity.shoot(this, target);
   }

   public EntityDimensions getDefaultDimensions(Pose pose) {
      return super.getDefaultDimensions(pose).scale(1.02F);
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
      builder = builder.add(Attributes.MAX_HEALTH, 15.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.0);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 1.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 40.0);
      return builder.add(Attributes.FLYING_SPEED, 0.4);
   }
}





