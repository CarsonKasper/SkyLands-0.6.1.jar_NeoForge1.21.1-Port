package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class TiledSkyrockBlock extends Block {
   public TiledSkyrockBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.2F, 11.0F).requiresCorrectToolForDrops());
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 4;
   }
}
