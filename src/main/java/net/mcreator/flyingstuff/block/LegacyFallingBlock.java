package net.mcreator.flyingstuff.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class LegacyFallingBlock extends FallingBlock {
   private final MapCodec<? extends FallingBlock> codec;

   protected LegacyFallingBlock(Properties properties) {
      super(properties);
      this.codec = simpleCodec(ignored -> this);
   }

   @Override
   protected MapCodec<? extends FallingBlock> codec() {
      return this.codec;
   }
}

