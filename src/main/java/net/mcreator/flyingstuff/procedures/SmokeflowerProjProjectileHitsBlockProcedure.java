package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class SmokeflowerProjProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof ServerLevel level) {
         level.sendParticles((SimpleParticleType)FlyingStuffModParticleTypes.CLOUD_SMOKE.get(), x, y + 3.0, z, 25, 2.0, 1.0, 2.0, 0.2);
         level.sendParticles((SimpleParticleType)FlyingStuffModParticleTypes.CLOUD_SMOKE_1.get(), x, y + 3.0, z, 25, 2.0, 1.0, 2.0, 0.2);
      }
   }
}

