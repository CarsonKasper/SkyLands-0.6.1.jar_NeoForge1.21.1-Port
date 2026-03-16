package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GlaciatedPlanksStairsBlock extends StairBlock {
   public GlaciatedPlanksStairsBlock() {
      super(
         Blocks.AIR.defaultBlockState(),
         Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(0.7F, 6.0F).noOcclusion()
      );
   }

   public float m_7325_() {
      return 6.0F;
   }

   public boolean m_6724_(BlockState state) {
      return false;
   }
}
