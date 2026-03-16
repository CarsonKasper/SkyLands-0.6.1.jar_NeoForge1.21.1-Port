package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class SmokeFlowerPlantGrowStageUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (Mth.nextDouble(RandomSource.create(), 0.0, 1.0) <= 0.4) {
         world.setBlock(BlockPos.containing(x, y, z), ((Block)FlyingStuffModBlocks.SMOKE_FLOWER_PLANT.get()).defaultBlockState(), 3);
      }
   }
}




