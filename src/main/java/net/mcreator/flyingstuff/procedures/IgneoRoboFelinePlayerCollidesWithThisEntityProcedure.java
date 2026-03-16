package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.entity.IgneoRoboFelineEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class IgneoRoboFelinePlayerCollidesWithThisEntityProcedure {
   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity instanceof IgneoRoboFelineEntity) {
            ((IgneoRoboFelineEntity)entity).setAnimation("attack");
         }

         if (world instanceof Level level) {
            if (entity instanceof LivingEntity livingEntity) {
               sourceentity.hurt(level.damageSources().mobAttack(livingEntity), 3.0F);
            } else {
               sourceentity.hurt(level.damageSources().generic(), 3.0F);
            }
         }
      }
   }
}

