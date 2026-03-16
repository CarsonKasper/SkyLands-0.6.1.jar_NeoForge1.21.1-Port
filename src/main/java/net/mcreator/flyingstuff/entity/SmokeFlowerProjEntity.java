package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.procedures.SmokeflowerProjProjectileHitsBlockProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.core.registries.BuiltInRegistries;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SmokeFlowerProjEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack((ItemLike)FlyingStuffModItems.SMOKE_FLOWER.get());

   public SmokeFlowerProjEntity(EntityType<? extends SmokeFlowerProjEntity> type, Level world) {
      super(type, world);
   }

   public SmokeFlowerProjEntity(EntityType<? extends SmokeFlowerProjEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world, PROJECTILE_ITEM, null);
   }

   public SmokeFlowerProjEntity(EntityType<? extends SmokeFlowerProjEntity> type, LivingEntity entity, Level world) {
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

   protected void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      SmokeflowerProjProjectileHitsBlockProcedure.execute(
         this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ()
      );
   }

   public void tick() {
      super.tick();
      if (this.inGround) {
         this.discard();
      }
   }

   public static SmokeFlowerProjEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.0F, 1.0, 1);
   }

   public static SmokeFlowerProjEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      SmokeFlowerProjEntity entityarrow = new SmokeFlowerProjEntity(
         (EntityType<? extends SmokeFlowerProjEntity>)FlyingStuffModEntities.SMOKE_FLOWER_PROJ.get(), entity, world
      );
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

   public static SmokeFlowerProjEntity shoot(LivingEntity entity, LivingEntity target) {
      SmokeFlowerProjEntity entityarrow = new SmokeFlowerProjEntity(
         (EntityType<? extends SmokeFlowerProjEntity>)FlyingStuffModEntities.SMOKE_FLOWER_PROJ.get(), entity, entity.level()
      );
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + target.getBbHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2.0F, 12.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setBaseDamage(1.0);
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





