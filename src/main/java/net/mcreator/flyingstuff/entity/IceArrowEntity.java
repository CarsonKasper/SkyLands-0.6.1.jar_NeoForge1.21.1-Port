package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.procedures.IceArrowProjectileHitsLivingEntityProcedure;
import net.mcreator.flyingstuff.procedures.IceArrowWhileProjectileFlyingTickProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.core.registries.BuiltInRegistries;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class IceArrowEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack(Items.ARROW);

   public IceArrowEntity(EntityType<? extends IceArrowEntity> type, Level world) {
      super(type, world);
   }

   public IceArrowEntity(EntityType<? extends IceArrowEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world, PROJECTILE_ITEM, null);
   }

   public IceArrowEntity(EntityType<? extends IceArrowEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world, PROJECTILE_ITEM, null);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getItem() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack getDefaultPickupItem() {
      return PROJECTILE_ITEM;
   }

   protected void doPostHurtEffects(LivingEntity entity) {
      super.doPostHurtEffects(entity);
      entity.setArrowCount(entity.getArrowCount() - 1);
   }

   protected void onHitEntity(EntityHitResult entityHitResult) {
      super.onHitEntity(entityHitResult);
      IceArrowProjectileHitsLivingEntityProcedure.execute(entityHitResult.getEntity());
   }

   public void tick() {
      super.tick();
      IceArrowWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
      if (this.inGround) {
         this.discard();
      }
   }

   public static IceArrowEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.5F, 0.5, 0);
   }

   public static IceArrowEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      IceArrowEntity entityarrow = new IceArrowEntity((EntityType<? extends IceArrowEntity>)FlyingStuffModEntities.ICE_ARROW.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setNoPhysics(false);
      entityarrow.setBaseDamage(damage);
      world.addFreshEntity(entityarrow);
      world.playSound(
         null,
         entity.getX(),
         entity.getY(),
         entity.getZ(),
         (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")),
         SoundSource.PLAYERS,
         1.0F,
         (float)(1.0F / (random.nextDouble() * 0.5F + 1.0F) + power / 2.0F)
      );
      return entityarrow;
   }

   public static IceArrowEntity shoot(LivingEntity entity, LivingEntity target) {
      IceArrowEntity entityarrow = new IceArrowEntity((EntityType<? extends IceArrowEntity>)FlyingStuffModEntities.ICE_ARROW.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + target.getBbHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 3.0F, 12.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setBaseDamage(0.5);
      entityarrow.setNoPhysics(false);
      entity.level().addFreshEntity(entityarrow);
      entity.level()
         .playSound(
            null,
            entity.getX(),
            entity.getY(),
            entity.getZ(),
            (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")),
            SoundSource.PLAYERS,
            1.0F,
            (float)(1.0F / (RandomSource.create().nextDouble() * 0.5F + 1.0F))
         );
      return entityarrow;
   }
}





