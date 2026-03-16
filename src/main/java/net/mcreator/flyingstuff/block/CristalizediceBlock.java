package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CristalizediceBlock extends Block {
   public CristalizediceBlock() {
      super(
         Properties.of()
            .sound(SoundType.GLASS)
            .strength(0.6F, 4.0F)
            .lightLevel(s -> 3)
            .requiresCorrectToolForDrops()
            .friction(0.9F)
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
      );
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 13;
   }
}
