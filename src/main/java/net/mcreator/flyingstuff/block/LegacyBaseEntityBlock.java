package net.mcreator.flyingstuff.block;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public abstract class LegacyBaseEntityBlock extends BaseEntityBlock {
   protected LegacyBaseEntityBlock(BlockBehaviour.Properties properties) {
      super(properties);
   }

   @Override
   protected MapCodec<? extends BaseEntityBlock> codec() {
      return MapCodec.unit(this);
   }

   @Override
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return this.m_142194_(pos, state);
   }

   @Nullable
   public BlockEntity m_142194_(BlockPos pos, BlockState state) {
      return null;
   }
}

