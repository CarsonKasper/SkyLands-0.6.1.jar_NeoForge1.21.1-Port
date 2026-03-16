package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PolishedGrimstoneSlabBlock extends SlabBlock {
   public PolishedGrimstoneSlabBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.15F, 10.0F).requiresCorrectToolForDrops().noOcclusion());
   }
}
