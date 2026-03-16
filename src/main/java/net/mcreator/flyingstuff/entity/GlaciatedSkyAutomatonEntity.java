package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.core.registries.BuiltInRegistries;

public class GlaciatedSkyAutomatonEntity extends Monster implements RangedAttackMob {

   public GlaciatedSkyAutomatonEntity(EntityType<GlaciatedSkyAutomatonEntity> type, Level world) {
      super(type, world);      this.xpReward = 10;
      this.setNoAi(false);
      this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)FlyingStuffModItems.ICE_BOW.get()));
   }

   protected void registerGoals() {
      super.registerGoals();
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true, false));
      this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
      this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 50, 10.0F) {
         public boolean canUse() {
            return super.canUse();
         }
      });
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

   public void performRangedAttack(LivingEntity target, float flval) {
      IceArrowEntity.shoot(this, target);
   }

   public static void init() {
   }

   public static Builder createAttributes() {
      Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
      builder = builder.add(Attributes.MAX_HEALTH, 30.0);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
      builder = builder.add(Attributes.ATTACK_DAMAGE, 1.0);
      builder = builder.add(Attributes.FOLLOW_RANGE, 25.0);
      builder = builder.add(Attributes.ARMOR, 0.2);
      return builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
   }
}





