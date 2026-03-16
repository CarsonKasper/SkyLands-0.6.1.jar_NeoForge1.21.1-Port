package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.procedures.FireWaveWhileProjectileFlyingTickProcedure;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.core.registries.BuiltInRegistries;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class FireWaveEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack(Items.FIRE_CHARGE);

   public FireWaveEntity(EntityType<? extends FireWaveEntity> type, Level world) {
      super(type, world);
   }

   public FireWaveEntity(EntityType<? extends FireWaveEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world, PROJECTILE_ITEM, null);
   }

   public FireWaveEntity(EntityType<? extends FireWaveEntity> type, LivingEntity entity, Level world) {
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

   public void tick() {
      super.tick();
      FireWaveWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
      if (this.inGround) {
         this.discard();
      }
   }

   public static FireWaveEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.1F, 2.0, 1);
   }

   public static FireWaveEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      FireWaveEntity entityarrow = new FireWaveEntity((EntityType<? extends FireWaveEntity>)FlyingStuffModEntities.FIRE_WAVE.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setNoPhysics(false);
      entityarrow.setBaseDamage(damage);
      entityarrow.setRemainingFireTicks(100);
      world.addFreshEntity(entityarrow);
      world.playSound(
         null,
         entity.getX(),
         entity.getY(),
         entity.getZ(),
         (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:fireblade_sound")),
         SoundSource.PLAYERS,
         1.0F,
         (float)(1.0F / (random.nextDouble() * 0.5F + 1.0F) + power / 2.0F)
      );
      return entityarrow;
   }

   public static FireWaveEntity shoot(LivingEntity entity, LivingEntity target) {
      FireWaveEntity entityarrow = new FireWaveEntity((EntityType<? extends FireWaveEntity>)FlyingStuffModEntities.FIRE_WAVE.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + target.getBbHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2.2F, 12.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setBaseDamage(2.0);
      entityarrow.setNoPhysics(false);
      entityarrow.setRemainingFireTicks(100);
      entity.level().addFreshEntity(entityarrow);
      entity.level()
         .playSound(
            null,
            entity.getX(),
            entity.getY(),
            entity.getZ(),
            (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:fireblade_sound")),
            SoundSource.PLAYERS,
            1.0F,
            (float)(1.0F / (RandomSource.create().nextDouble() * 0.5F + 1.0F))
         );
      return entityarrow;
   }
}





