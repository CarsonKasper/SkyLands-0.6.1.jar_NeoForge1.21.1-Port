package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CelestineblockBlock extends Block {
   public CelestineblockBlock() {
      super(Properties.of().sound(SoundType.GLASS).strength(1.4F, 15.0F).lightLevel(s -> 1).requiresCorrectToolForDrops());
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
