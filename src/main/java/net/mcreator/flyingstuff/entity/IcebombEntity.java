package net.mcreator.flyingstuff.entity;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.procedures.IcebombProjectileHitsBlockProcedure;
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
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.core.registries.BuiltInRegistries;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class IcebombEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM = new ItemStack((ItemLike)FlyingStuffModBlocks.CRISTALIZEDICE.get());

   public IcebombEntity(EntityType<? extends IcebombEntity> type, Level world) {
      super(type, world);
   }

   public IcebombEntity(EntityType<? extends IcebombEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world, PROJECTILE_ITEM, null);
   }

   public IcebombEntity(EntityType<? extends IcebombEntity> type, LivingEntity entity, Level world) {
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
      IcebombProjectileHitsBlockProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
   }

   protected void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      IcebombProjectileHitsBlockProcedure.execute(
         this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ()
      );
   }

   public void tick() {
      super.tick();
      if (this.inGround) {
         this.discard();
      }
   }

   public static IcebombEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 0.8F, 5.0, 1);
   }

   public static IcebombEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      IcebombEntity entityarrow = new IcebombEntity((EntityType<? extends IcebombEntity>)FlyingStuffModEntities.ICEBOMB.get(), entity, world);
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
         (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:ice_bomb_trown")),
         SoundSource.PLAYERS,
         1.0F,
         (float)(1.0F / (random.nextDouble() * 0.5F + 1.0F) + power / 2.0F)
      );
      return entityarrow;
   }

   public static IcebombEntity shoot(LivingEntity entity, LivingEntity target) {
      IcebombEntity entityarrow = new IcebombEntity((EntityType<? extends IcebombEntity>)FlyingStuffModEntities.ICEBOMB.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + target.getBbHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1.6F, 12.0F);
      entityarrow.setCritArrow(true);
      entityarrow.setBaseDamage(5.0);
      entityarrow.setNoPhysics(false);
      entity.level().addFreshEntity(entityarrow);
      entity.level()
         .playSound(
            null,
            entity.getX(),
            entity.getY(),
            entity.getZ(),
            (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:ice_bomb_trown")),
            SoundSource.PLAYERS,
            1.0F,
            (float)(1.0F / (RandomSource.create().nextDouble() * 0.5F + 1.0F))
         );
      return entityarrow;
   }
}





