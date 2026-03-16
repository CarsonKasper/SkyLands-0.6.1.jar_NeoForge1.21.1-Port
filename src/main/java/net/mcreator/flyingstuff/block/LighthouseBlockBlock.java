package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.procedures.LighthouseBlockRedstoneOnProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class LighthouseBlockBlock extends Block {
   public LighthouseBlockBlock() {
      super(
         Properties.of()
            .sound(SoundType.STONE)
            .strength(-1.0F, 3600000.0F)
            .lightLevel(s -> 15)
            .requiresCorrectToolForDrops()
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
      );
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void m_6861_(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
      if (world.getBestNeighborSignal(pos) > 0) {
         LighthouseBlockRedstoneOnProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
      }
   }
}
