package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class AridGrassBlock extends FlowerBlock {
   public AridGrassBlock() {
      super(
         MobEffects.NIGHT_VISION,
         100,
         Properties.of()
            .mapColor(MapColor.PLANT)
            .sound(SoundType.GRASS)
            .instabreak()
            .noCollission()
            .replaceable()
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

   public boolean m_6266_(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
      return groundState.is(Blocks.SAND)
         || groundState.is((Block)FlyingStuffModBlocks.SKY_SAND.get())
         || groundState.is((Block)FlyingStuffModBlocks.MOSSY_SKY_SANDSTONE_BRICKS.get())
         || groundState.is((Block)FlyingStuffModBlocks.MOSSY_SKY_SANDSTONE.get());
   }

   public boolean m_7898_(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
      BlockPos blockpos = pos.below();
      BlockState groundState = worldIn.getBlockState(blockpos);
      return this.m_6266_(groundState, worldIn, blockpos);
   }
}
