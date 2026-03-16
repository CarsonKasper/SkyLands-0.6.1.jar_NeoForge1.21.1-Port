package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class CobbledGlaciatedSkyrockwallBlock extends WallBlock {
   public CobbledGlaciatedSkyrockwallBlock() {
      super(
         Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.05F, 10.5F).requiresCorrectToolForDrops().noOcclusion().forceSolidOn()
      );
   }
}
