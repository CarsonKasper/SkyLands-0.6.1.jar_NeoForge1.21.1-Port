package net.mcreator.flyingstuff.block;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LavicFungusBlockBlock extends LeavesBlock {
   public LavicFungusBlockBlock() {
      super(
         Properties.of()
            .sound(SoundType.WOOL)
            .strength(0.3F, 6.0F)
            .lightLevel(s -> 1)
            .noOcclusion()
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
            .isRedstoneConductor((bs, br, bp) -> false)
      );
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, context, list, flag);
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 10;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }
}


