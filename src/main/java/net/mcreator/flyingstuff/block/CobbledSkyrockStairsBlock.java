package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class CobbledSkyrockStairsBlock extends StairBlock {
   public CobbledSkyrockStairsBlock() {
      super(
         Blocks.AIR.defaultBlockState(),
         Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.2F, 11.0F).requiresCorrectToolForDrops().noOcclusion()
      );
   }

   public float m_7325_() {
      return 11.0F;
   }

   public boolean m_6724_(BlockState state) {
      return false;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 2;
   }
}
