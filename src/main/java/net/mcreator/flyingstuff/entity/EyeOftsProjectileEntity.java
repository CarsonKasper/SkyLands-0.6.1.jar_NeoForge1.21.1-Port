package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.core.registries.BuiltInRegistries;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class EyeOftsProjectileEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack((net.minecraft.world.level.ItemLike)FlyingStuffModItems.EYE_OF_THE_SKY.get());

   public EyeOftsProjectileEntity(EntityType<? extends EyeOftsProjectileEntity> type, Level world) {
      super(type, world);
   }

   public EyeOftsProjectileEntity(EntityType<? extends EyeOftsProjectileEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world, PROJECTILE_ITEM, null);
   }

   public EyeOftsProjectileEntity(EntityType<? extends EyeOftsProjectileEntity> type, LivingEntity entity, Level world) {
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
      if (this.inGround) {
         this.discard();
      }
   }

   public static EyeOftsProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 0.0F, 0.0, 0);
   }

   public static EyeOftsProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      EyeOftsProjectileEntity entityarrow = new EyeOftsProjectileEntity(
         (EntityType<? extends EyeOftsProjectileEntity>)FlyingStuffModEntities.EYE_OFTS_PROJECTILE.get(), entity, world
      );
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setNoPhysics(true);
      entityarrow.setBaseDamage(damage);
      world.addFreshEntity(entityarrow);
      world.playSound(
         null,
         entity.getX(),
         entity.getY(),
         entity.getZ(),
         (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_eye.launch")),
         SoundSource.PLAYERS,
         1.0F,
         (float)(1.0F / (random.nextDouble() * 0.5F + 1.0F) + power / 2.0F)
      );
      return entityarrow;
   }

   public static EyeOftsProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
      EyeOftsProjectileEntity entityarrow = new EyeOftsProjectileEntity(
         (EntityType<? extends EyeOftsProjectileEntity>)FlyingStuffModEntities.EYE_OFTS_PROJECTILE.get(), entity, entity.level()
      );
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + target.getBbHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.0F, 12.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setBaseDamage(0.0);
      entityarrow.setNoPhysics(true);
      entity.level().addFreshEntity(entityarrow);
      entity.level()
         .playSound(
            null,
            entity.getX(),
            entity.getY(),
            entity.getZ(),
            (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_eye.launch")),
            SoundSource.PLAYERS,
            1.0F,
            (float)(1.0F / (RandomSource.create().nextDouble() * 0.5F + 1.0F))
         );
      return entityarrow;
   }
}





