package net.mcreator.flyingstuff.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;

public class LavicSkyrockPipeBlock extends Block {
   public static final EnumProperty<Axis> AXIS = BlockStateProperties.AXIS;

   public LavicSkyrockPipeBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.1F, 12.0F).requiresCorrectToolForDrops());
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(AXIS, Axis.Y));
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      builder.add(AXIS);
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
         if (state.getValue(AXIS) == Axis.X) {
            return (BlockState)state.setValue(AXIS, Axis.Z);
         }

         if (state.getValue(AXIS) == Axis.Z) {
            return (BlockState)state.setValue(AXIS, Axis.X);
         }
      }

      return state;
   }
}
