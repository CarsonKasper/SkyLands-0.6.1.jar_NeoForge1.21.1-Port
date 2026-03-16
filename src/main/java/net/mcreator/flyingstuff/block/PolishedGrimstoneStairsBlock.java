package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PolishedGrimstoneStairsBlock extends StairBlock {
   public PolishedGrimstoneStairsBlock() {
      super(
         Blocks.AIR.defaultBlockState(),
         Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.15F, 10.0F).requiresCorrectToolForDrops().noOcclusion()
      );
   }

   public float m_7325_() {
      return 10.0F;
   }

   public boolean m_6724_(BlockState state) {
      return false;
   }
}
