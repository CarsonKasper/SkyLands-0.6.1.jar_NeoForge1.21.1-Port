package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;

public class SwampyBushOnRandomClientDisplayTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.addParticle(
         (SimpleParticleType)FlyingStuffModParticleTypes.FIREFLY.get(),
         x + Mth.nextDouble(RandomSource.create(), -4.0, 4.0),
         y + Mth.nextDouble(RandomSource.create(), -3.0, 5.0),
         z + Mth.nextDouble(RandomSource.create(), -4.0, 4.0),
         0.0,
         0.0,
         0.0
      );
   }
}


