package net.mcreator.flyingstuff.block;

import java.util.List;
import net.mcreator.flyingstuff.procedures.FieryLeavesClientDisplayRandomTickProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class FieryLeavesBlock extends LeavesBlock {
   public FieryLeavesBlock() {
      super(Properties.ofFullCopy(Blocks.OAK_LEAVES));
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, context, list, flag);
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 5;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   @OnlyIn(Dist.CLIENT)
   public void m_214162_(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
      super.animateTick(blockstate, world, pos, random);
      Player entity = Minecraft.getInstance().player;
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      FieryLeavesClientDisplayRandomTickProcedure.execute(world, x, y, z);
   }
}


