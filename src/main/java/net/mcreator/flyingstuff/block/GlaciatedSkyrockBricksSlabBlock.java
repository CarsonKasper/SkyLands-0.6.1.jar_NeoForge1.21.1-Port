package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GlaciatedSkyrockBricksSlabBlock extends SlabBlock {
   public GlaciatedSkyrockBricksSlabBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.1F, 11.0F).requiresCorrectToolForDrops().noOcclusion());
   }
}
