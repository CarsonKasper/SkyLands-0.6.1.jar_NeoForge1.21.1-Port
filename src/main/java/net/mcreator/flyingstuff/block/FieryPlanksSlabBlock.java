package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class FieryPlanksSlabBlock extends SlabBlock {
   public FieryPlanksSlabBlock() {
      super(Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(1.1F, 11.0F).noOcclusion());
   }
}
