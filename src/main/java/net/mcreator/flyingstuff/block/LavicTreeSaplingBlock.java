package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.procedures.Lavictree0Procedure;
import net.mcreator.flyingstuff.procedures.Lavictree1Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;

public class LavicTreeSaplingBlock extends FlowerBlock {
   public LavicTreeSaplingBlock() {
      super(
         MobEffects.NIGHT_VISION,
         100,
         Properties.of()
            .mapColor(MapColor.PLANT)
            .randomTicks()
            .sound(SoundType.GRASS)
            .instabreak()
            .noCollission()
            .offsetType(OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
      );
   }

   public int m_53522_() {
      return 100;
   }

   public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 100;
   }

   public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
      return 60;
   }

   public void m_213898_(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      Lavictree1Procedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.useWithoutItem(blockstate, world, pos, entity, hit);
      Lavictree0Procedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
      return InteractionResult.SUCCESS;
   }
}
