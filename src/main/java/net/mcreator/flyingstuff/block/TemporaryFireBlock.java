package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.procedures.TemporaryFireBlockAddedProcedure;
import net.mcreator.flyingstuff.procedures.TemporaryFireEntityCollidesInTheBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TemporaryFireBlock extends Block {
   public TemporaryFireBlock() {
      super(
         Properties.of()
            
            .strength(0.05F, 0.1F)
            .lightLevel(s -> 15)
            .noCollission()
            .noOcclusion()
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
            .isRedstoneConductor((bs, br, bp) -> false)
      );
   }

   public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      TemporaryFireBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
      TemporaryFireBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.entityInside(blockstate, world, pos, entity);
      TemporaryFireEntityCollidesInTheBlockProcedure.execute(entity);
   }

   public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
      super.stepOn(world, pos, blockstate, entity);
      TemporaryFireBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }
}

