package net.mcreator.flyingstuff.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;

public class Lavictree0Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null && (entity instanceof LivingEntity living ? living.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL) {
         if (world instanceof ServerLevel level) {
            level.sendParticles(
               ParticleTypes.HAPPY_VILLAGER,
               Mth.nextDouble(RandomSource.create(), -1.0, 1.0) + x,
               Mth.nextDouble(RandomSource.create(), -1.0, 1.0) + y,
               Mth.nextDouble(RandomSource.create(), -1.0, 1.0) + z,
               5,
               Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
               Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
               Mth.nextDouble(RandomSource.create(), -1.0, 1.0),
               0.1
            );
         }
      }
   }
}

