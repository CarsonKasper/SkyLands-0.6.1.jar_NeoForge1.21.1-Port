package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SkyCactusUpdateTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (Math.random() > 0.3 && world.getBlockState(BlockPos.containing(x, 1.0 + y, z)).getBlock() == Blocks.AIR) {
         if (Math.random() > 0.4 && Math.random() < 0.6) {
            world.setBlock(BlockPos.containing(x, 1.0 + y, z), ((Block)FlyingStuffModBlocks.SKY_CACTUS_BRANCH.get()).defaultBlockState(), 3);
         } else if (Math.random() >= 0.6 && Math.random() < 1.0) {
            world.setBlock(BlockPos.containing(x, 1.0 + y, z), ((Block)FlyingStuffModBlocks.SKY_CACTUS.get()).defaultBlockState(), 3);
         } else {
            world.setBlock(BlockPos.containing(x, 1.0 + y, z), ((Block)FlyingStuffModBlocks.SKY_CACTUS_TOP.get()).defaultBlockState(), 3);
         }
      }
   }
}

