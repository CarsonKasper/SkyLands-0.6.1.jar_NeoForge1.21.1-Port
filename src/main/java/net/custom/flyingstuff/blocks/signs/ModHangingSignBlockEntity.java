package net.custom.flyingstuff.blocks.signs;

import net.mcreator.flyingstuff.FlyingStuffModSigns;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity extends SignBlockEntity {
   public ModHangingSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
      super((BlockEntityType)FlyingStuffModSigns.MOD_HANGING_SIGN.get(), pPos, pBlockState);
   }

   public BlockEntityType<?> m_58903_() {
      return (BlockEntityType<?>)FlyingStuffModSigns.MOD_HANGING_SIGN.get();
   }
}
