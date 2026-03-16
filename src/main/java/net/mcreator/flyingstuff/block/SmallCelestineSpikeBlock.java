package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallCelestineSpikeBlock extends Block {
   public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
   public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

   public SmallCelestineSpikeBlock() {
      super(
         Properties.of()
            .sound(SoundType.GLASS)
            .strength(0.9F, 15.0F)
            .lightLevel(s -> 8)
            .requiresCorrectToolForDrops()
            .noOcclusion()
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
            .isRedstoneConductor((bs, br, bp) -> false)
      );
      this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(FACE, AttachFace.WALL));
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return switch ((Direction)state.getValue(FACING)) {
         case NORTH -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(4.0, 0.0, 4.0, 12.0, 7.0, 12.0);
               case WALL:
                  yield box(4.0, 4.0, 9.0, 12.0, 12.0, 16.0);
               case CEILING:
                  yield box(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
         case EAST -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(4.0, 0.0, 4.0, 12.0, 7.0, 12.0);
               case WALL:
                  yield box(0.0, 4.0, 4.0, 7.0, 12.0, 12.0);
               case CEILING:
                  yield box(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
         case WEST -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(4.0, 0.0, 4.0, 12.0, 7.0, 12.0);
               case WALL:
                  yield box(9.0, 4.0, 4.0, 16.0, 12.0, 12.0);
               case CEILING:
                  yield box(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
         default -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(4.0, 0.0, 4.0, 12.0, 7.0, 12.0);
               case WALL:
                  yield box(4.0, 4.0, 0.0, 12.0, 12.0, 7.0);
               case CEILING:
                  yield box(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
      };
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(FACING, FACE);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return context.getClickedFace().getAxis() == Axis.Y
         ? (BlockState)((BlockState)this.defaultBlockState().setValue(FACE, context.getClickedFace().getOpposite() == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR))
            .setValue(FACING, context.getHorizontalDirection())
         : (BlockState)((BlockState)this.defaultBlockState().setValue(FACE, AttachFace.WALL)).setValue(FACING, context.getClickedFace());
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }
}
