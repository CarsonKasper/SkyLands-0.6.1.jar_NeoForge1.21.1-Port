package net.mcreator.flyingstuff.block;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.mcreator.flyingstuff.procedures.AbyssalDoorOnBlockRightClickedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AbyssalDoorBlock extends LegacyBaseEntityBlock implements EntityBlock {
   public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 2);
   public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

   public AbyssalDoorBlock() {
      super(Properties.of().sound(SoundType.STONE).strength(-1.0F, 3600000.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
   }

   public RenderShape m_7514_(BlockState state) {
      return RenderShape.ENTITYBLOCK_ANIMATED;
   }

   @Nullable
   public BlockEntity m_142194_(BlockPos blockPos, BlockState blockState) {
      return ((BlockEntityType)FlyingStuffModBlockEntities.ABYSSAL_DOOR.get()).create(blockPos, blockState);
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5940_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return switch ((Direction)state.getValue(FACING)) {
         case NORTH -> box(-16.0, 0.0, 0.0, 48.0, 48.0, 18.0);
         case EAST -> box(-2.0, 0.0, -16.0, 16.0, 48.0, 48.0);
         case WEST -> box(0.0, 0.0, -32.0, 18.0, 48.0, 32.0);
         default -> box(-32.0, 0.0, -2.0, 32.0, 48.0, 16.0);
      };
   }

   protected void m_7926_(Builder<Block, BlockState> builder) {
      builder.add(ANIMATION, FACING);
   }

   public BlockState m_5573_(BlockPlaceContext context) {
      return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
   }

   public BlockState m_6843_(BlockState state, Rotation rot) {
      return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
   }

   public BlockState m_6943_(BlockState state, Mirror mirrorIn) {
      return state.rotate(mirrorIn.getRotation((Direction)state.getValue(FACING)));
   }

   public List<ItemStack> m_49635_(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
      List<ItemStack> dropsOriginal = super.getDrops(state, builder);
      return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.useWithoutItem(blockstate, world, pos, entity, hit);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      double hitX = hit.getLocation().x;
      double hitY = hit.getLocation().y;
      double hitZ = hit.getLocation().z;
      Direction direction = hit.getDirection();
      AbyssalDoorOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
      return InteractionResult.SUCCESS;
   }
}
