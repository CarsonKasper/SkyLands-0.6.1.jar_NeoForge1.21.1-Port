package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class LavicSkyrockWallsBlock extends WallBlock {
   public LavicSkyrockWallsBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.1F, 12.0F).requiresCorrectToolForDrops().noOcclusion().forceSolidOn());
   }
}
