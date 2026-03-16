package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DeactivatedStormBlockBlock extends Block {
   public DeactivatedStormBlockBlock() {
      super(
         Properties.of()
            .sound(SoundType.AMETHYST)
            .strength(-1.0F, 3600000.0F)
            .lightLevel(s -> 15)
            .requiresCorrectToolForDrops()
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
      );
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }
}
