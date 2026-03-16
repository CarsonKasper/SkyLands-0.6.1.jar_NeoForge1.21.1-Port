package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SkyrockSlabBlock extends SlabBlock {
   public SkyrockSlabBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.35F, 12.0F).requiresCorrectToolForDrops().noOcclusion());
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 2;
   }
}
