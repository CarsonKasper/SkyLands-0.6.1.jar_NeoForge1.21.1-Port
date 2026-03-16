package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class InkyCelestiumAntennaBlock extends Block implements SimpleWaterloggedBlock {
   public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
   public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
   public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

   public InkyCelestiumAntennaBlock() {
      super(
         Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.STONE)
            .strength(1.35F, 13.5F)
            .lightLevel(s -> 12)
            .requiresCorrectToolForDrops()
            .noOcclusion()
            .isRedstoneConductor((bs, br, bp) -> false)
      );
      this.registerDefaultState(
         (BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(FACE, AttachFace.WALL))
            .setValue(WATERLOGGED, false)
      );
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return state.getFluidState().isEmpty();
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
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               case WALL:
                  yield box(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);
               case CEILING:
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
         case EAST -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               case WALL:
                  yield box(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);
               case CEILING:
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
         case WEST -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               case WALL:
                  yield box(0.0, 2.0, 2.0, 16.0, 14.0, 14.0);
               case CEILING:
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
         default -> {
            switch ((AttachFace)state.getValue(FACE)) {
               case FLOOR:
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               case WALL:
                  yield box(2.0, 2.0, 0.0, 14.0, 14.0, 16.0);
               case CEILING:
                  yield box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
               default:
                  throw new IncompatibleClassChangeError();
            }
         }
      };
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(FACING, FACE, WATERLOGGED);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
      return context.getClickedFace().getAxis() == Axis.Y
         ? (BlockState)((BlockState)((BlockState)this.defaultBlockState()
                  .setValue(FACE, context.getClickedFace().getOpposite() == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR))
               .setValue(FACING, context.getHorizontalDirection()))
            .setValue(WATERLOGGED, flag)
         : (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(FACE, AttachFace.WALL)).setValue(FACING, context.getClickedFace()))
            .setValue(WATERLOGGED, flag);
   }

   public BlockState rotate(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState mirror(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public FluidState m_5888_(BlockState state) {
      return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
   }

   public BlockState m_7417_(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
      if ((Boolean)state.getValue(WATERLOGGED)) {
         world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
      }

      return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
   }
}
