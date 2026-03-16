package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class LAUNCHER01OnStructureInstanceGeneratedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      BlockPos pos = BlockPos.containing(x, y + 180.0, z);
      world.setBlock(pos, ((Block)FlyingStuffModBlocks.GEN_LAUNCH_0.get()).defaultBlockState(), 3);
      world.scheduleTick(pos, world.getBlockState(pos).getBlock(), 20);
   }
}

