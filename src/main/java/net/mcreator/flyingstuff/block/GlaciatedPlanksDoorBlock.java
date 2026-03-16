package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GlaciatedPlanksDoorBlock extends DoorBlock {
   public GlaciatedPlanksDoorBlock() {
      super(BlockSetType.OAK, Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(0.7F, 6.0F).noOcclusion());
   }
}
