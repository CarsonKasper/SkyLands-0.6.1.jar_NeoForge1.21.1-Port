package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.procedures.GenLaunch0UpdateTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GenLaunch0Block extends Block {
   public GenLaunch0Block() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.ROOTED_DIRT).strength(1.0F, 10.0F));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.randomTick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      GenLaunch0UpdateTickProcedure.execute(world, x, y, z);
   }
}
