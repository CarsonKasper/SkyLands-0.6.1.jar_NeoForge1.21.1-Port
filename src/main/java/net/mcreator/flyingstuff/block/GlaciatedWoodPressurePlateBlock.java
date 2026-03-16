package net.mcreator.flyingstuff.block;

import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GlaciatedWoodPressurePlateBlock extends PressurePlateBlock {
   public GlaciatedWoodPressurePlateBlock() {
      super(
         BlockSetType.OAK,
         Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(0.7F, 6.0F).noOcclusion().forceSolidOn()
      );
   }
}
