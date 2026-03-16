package net.mcreator.flyingstuff.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.procedures.GlaciatedDragonDeathTimeIsReachedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.registries.BuiltInRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GlaciatedDragonEntity extends Monster implements RangedAttackMob, GeoEntity {
   private static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(GlaciatedDragonEntity.class, EntityDataSerializers.BOOLEAN);
   private static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(GlaciatedDragonEntity.class, EntityDataSerializers.STRING);
   private static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(GlaciatedDragonEntity.class, EntityDataSerializers.STRING);
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private String animationprocedure = "empty";
   private long lastSwing;


   public GlaciatedDragonEntity(EntityType<GlaciatedDragonEntity> type, Level world) {
      super(type, world);
      this.xpReward = 5;
      this.setNoAi(false);
      this.setPersistenceRequired();
      this.moveControl = new FlyingMoveControl(this, 10, true);
   }

   protected void defineSynchedData(SynchedEntityData.Builder builder) {
      super.defineSynchedData(builder);
      builder.define(SHOOT, false);
      builder.define(ANIMATION, "undefined");
      builder.define(TEXTURE, "dragon");
   }

   public void setTexture(String texture) {
      this.entityData.set(TEXTURE, texture);
   }

   public String getTexture() {
      return (String)this.entityData.get(TEXTURE);
   }

   protected PathNavigation createNavigation(Level world) {
      return new FlyingPathNavigation(this, world);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.5, 20) {
         protected Vec3 getPosition() {
            RandomSource random = GlaciatedDragonEntity.this.getRandom();
            double dir_x = GlaciatedDragonEntity.this.getX() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            double dir_y = GlaciatedDragonEntity.this.getY() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            double dir_z = GlaciatedDragonEntity.this.getZ() + (random.nextDouble() * 2.0F - 1.0F) * 16.0F;
            return new Vec3(dir_x, dir_y, dir_z);
         }
      });
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false));
      this.goalSelector
         .addGoal(
            3,
            new Goal() {
               {
                  this.setFlags(EnumSet.of(Flag.MOVE));
               }

               public boolean canContinueToUse() {
                  return GlaciatedDragonEntity.this.getTarget() != null && !GlaciatedDragonEntity.this.getMoveControl().hasWanted();
               }

               public boolean canUse() {
                  return GlaciatedDragonEntity.this.getMoveControl().hasWanted()
                     && GlaciatedDragonEntity.this.getTarget() != null
                     && GlaciatedDragonEntity.this.getTarget().isAlive();
               }

               public void start() {
                  LivingEntity livingentity = GlaciatedDragonEntity.this.getTarget();
                  Vec3 vec3d = livingentity.getEyePosition(1.0F);
                  GlaciatedDragonEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
               }

               public void tick() {
                  LivingEntity livingentity = GlaciatedDragonEntity.this.getTarget();
                  if (GlaciatedDragonEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                     GlaciatedDragonEntity.this.doHurtTarget(livingentity);
                  } else {
                     double d0 = GlaciatedDragonEntity.this.distanceToSqr(livingentity);
                     if (d0 < 40.0) {
                        Vec3 vec3d = livingentity.getEyePosition(1.0F);
                        GlaciatedDragonEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0);
                     }
                  }
               }
            }
         );
      this.targetSelector.addGoal(4, new HurtByTargetGoal(this, new Class[0]));
      this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(1, new GlaciatedDragonEntity.RangedAttackGoal(this, 1.25, 60, 18.9F) {
         @Override
         public boolean canUse() {
            return super.canUse();
         }
      });
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return false;
   }

   protected SoundEvent getAmbientSound() {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:ice_dragon_flap"));
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:dragon_attack"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:dragon_final_kill"));
   }

   public boolean causeFallDamage(float l, float d, DamageSource source) {
      return false;
   }

   public boolean hurt(DamageSource source, float amount) {
      return !(source.getDirectEntity() instanceof ThrownPotion) && !(source.getDirectEntity() instanceof AreaEffectCloud) ? super.hurt(source, amount) : false;
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putString("Texture", this.getTexture());
   }

   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("Texture")) {
         this.setTexture(compound.getString("Texture"));
      }
   }

   public void tick() {
      super.tick();
      this.refreshDimensions();
   }

   public EntityDimensions getDefaultDimensions(Pose p_33597_) {
      return super.getDefaultDimensions(p_33597_).scale(1.0F);
   }

   public void performRangedAttack(LivingEntity target, float flval) {
      IcebombEntity.shoot(this, target);
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
      builder = builder.add(Attributes.MOVEMENT_SPEED, 1.0);
      builder = builder.add(Attributes.MAX_HEALTH, 150.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.6);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 6.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 32.0);
      builder = builder.add(Attributes.ARMOR, 0.6);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.6);
      return builder.add(Attributes.FLYING_SPEED, 1.0);
   }

   private PlayState movementPredicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
         } else {
            return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
         }
      } else {
         return PlayState.STOP;
      }
   }

   private PlayState attackingPredicate(AnimationState event) {
      double d1 = this.getX() - this.xo;
      double d0 = this.getZ() - this.zo;
      float velocity = (float)Math.sqrt(d1 * d1 + d0 * d0);
      if (this.getAttackAnim(event.getPartialTick()) > 0.0F && !this.swinging) {
         this.swinging = true;
         this.lastSwing = this.level().getGameTime();
      }

      if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime()) {
         this.swinging = false;
      }

      if ((this.swinging || (Boolean)this.entityData.get(SHOOT)) && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         return event.setAndContinue(RawAnimation.begin().thenPlay("attacl"));
      } else {
         return PlayState.CONTINUE;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }
      } else if (this.animationprocedure.equals("empty")) {
         return PlayState.STOP;
      }

      return PlayState.CONTINUE;
   }

   protected void tickDeath() {
      this.deathTime++;
      if (this.deathTime == 40) {
         this.remove(RemovalReason.KILLED);
         
         GlaciatedDragonDeathTimeIsReachedProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
      }
   }

   public String getSyncedAnimation() {
      return (String)this.entityData.get(ANIMATION);
   }

   public void setAnimation(String animation) {
      this.entityData.set(ANIMATION, animation);
   }

   public void registerControllers(ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "movement", 4, this::movementPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "attacking", 4, this::attackingPredicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedure", 4, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public class RangedAttackGoal extends Goal {
      private final Mob mob;
      private final RangedAttackMob rangedAttackMob;
      @Nullable
      private LivingEntity target;
      private int attackTime = -1;
      private final double speedModifier;
      private int seeTime;
      private final int attackIntervalMin;
      private final int attackIntervalMax;
      private final float attackRadius;
      private final float attackRadiusSqr;

      public RangedAttackGoal(RangedAttackMob p_25768_, double p_25769_, int p_25770_, float p_25771_) {
         this(p_25768_, p_25769_, p_25770_, p_25770_, p_25771_);
      }

      public RangedAttackGoal(RangedAttackMob p_25773_, double p_25774_, int p_25775_, int p_25776_, float p_25777_) {
         if (!(p_25773_ instanceof LivingEntity)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
         } else {
            this.rangedAttackMob = p_25773_;
            this.mob = (Mob)p_25773_;
            this.speedModifier = p_25774_;
            this.attackIntervalMin = p_25775_;
            this.attackIntervalMax = p_25776_;
            this.attackRadius = p_25777_;
            this.attackRadiusSqr = p_25777_ * p_25777_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
         }
      }

      public boolean canUse() {
         LivingEntity livingentity = this.mob.getTarget();
         if (livingentity != null && livingentity.isAlive()) {
            this.target = livingentity;
            return true;
         } else {
            return false;
         }
      }

      public boolean canContinueToUse() {
         return this.canUse() || this.target != null && this.target.isAlive() && !this.mob.getNavigation().isDone();
      }

      public void stop() {
         this.target = null;
         this.seeTime = 0;
         this.attackTime = -1;
         ((GlaciatedDragonEntity)this.rangedAttackMob).entityData.set(GlaciatedDragonEntity.SHOOT, false);
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public void tick() {
         double d0 = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
         boolean flag = this.mob.getSensing().hasLineOfSight(this.target);
         if (flag) {
            this.seeTime++;
         } else {
            this.seeTime = 0;
         }

         if (!(d0 > this.attackRadiusSqr) && this.seeTime >= 5) {
            this.mob.getNavigation().stop();
         } else {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier);
         }

         this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
         if (--this.attackTime == 0) {
            if (!flag) {
               ((GlaciatedDragonEntity)this.rangedAttackMob).entityData.set(GlaciatedDragonEntity.SHOOT, false);
               return;
            }

            ((GlaciatedDragonEntity)this.rangedAttackMob).entityData.set(GlaciatedDragonEntity.SHOOT, true);
            float f = (float)Math.sqrt(d0) / this.attackRadius;
            float f1 = Mth.clamp(f, 0.1F, 1.0F);
            this.rangedAttackMob.performRangedAttack(this.target, f1);
            this.attackTime = Mth.floor(f * (this.attackIntervalMax - this.attackIntervalMin) + this.attackIntervalMin);
         } else if (this.attackTime < 0) {
            this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / this.attackRadius, this.attackIntervalMin, this.attackIntervalMax));
         } else {
            ((GlaciatedDragonEntity)this.rangedAttackMob).entityData.set(GlaciatedDragonEntity.SHOOT, false);
         }
      }
   }
}





