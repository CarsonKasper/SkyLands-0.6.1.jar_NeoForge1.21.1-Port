package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.procedures.SmokeFlowerPlantPlantRightClickedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;

public class SmokeFlowerPlantBlock extends DoublePlantBlock {
   public SmokeFlowerPlantBlock() {
      super(
         Properties.of()
            .mapColor(MapColor.PLANT)
            .sound(SoundType.GRASS)
            .instabreak()
            .noCollission()
            .offsetType(OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
      );
   }

   public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 100;
   }

   public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 60;
   }
   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.useWithoutItem(blockstate, world, pos, entity, hit);
      SmokeFlowerPlantPlantRightClickedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
      return InteractionResult.SUCCESS;
   }
}
