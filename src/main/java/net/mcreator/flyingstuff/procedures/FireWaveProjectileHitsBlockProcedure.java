package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class FireWaveProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.setBlock(BlockPos.containing(x, y, z), ((Block)FlyingStuffModBlocks.TEMPORARY_FIRE.get()).defaultBlockState(), 3);
   }
}

