package net.mcreator.flyingstuff.block;

import io.netty.buffer.Unpooled;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.block.entity.ProtoChestTileEntity;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.mcreator.flyingstuff.world.inventory.ProtoChestGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
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

public class ProtoChestBlock extends LegacyBaseEntityBlock implements EntityBlock {
   public static final IntegerProperty ANIMATION = IntegerProperty.create("animation", 0, 1);
   public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

   public ProtoChestBlock() {
      super(
         Properties.of()
            .sound(SoundType.STONE)
            .strength(1.5F, 15.0F)
            .lightLevel(s -> 5)
            .requiresCorrectToolForDrops()
            .noOcclusion()
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
            .isRedstoneConductor((bs, br, bp) -> false)
      );
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
   }

   public RenderShape m_7514_(BlockState state) {
      return RenderShape.ENTITYBLOCK_ANIMATED;
   }

   @Nullable
   public BlockEntity m_142194_(BlockPos blockPos, BlockState blockState) {
      return ((BlockEntityType)FlyingStuffModBlockEntities.PROTO_CHEST.get()).create(blockPos, blockState);
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
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

   public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
      return player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem ? tieredItem.getTier() != net.minecraft.world.item.Tiers.WOOD : false;
   }

   public List<ItemStack> m_49635_(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
      List<ItemStack> dropsOriginal = super.getDrops(state, builder);
      return !dropsOriginal.isEmpty() ? dropsOriginal : Collections.singletonList(new ItemStack(this, 1));
   }

   public InteractionResult m_6227_(BlockState blockstate, Level world, final BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      super.useWithoutItem(blockstate, world, pos, entity, hit);
      if (entity instanceof ServerPlayer player) {
         player.openMenu(new MenuProvider() {
            public Component getDisplayName() {
               return Component.literal("Proto Chest");
            }

            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player playerx) {
               return new ProtoChestGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
            }
         }, buf -> buf.writeBlockPos(pos));
      }

      return InteractionResult.SUCCESS;
   }

   public MenuProvider m_7246_(BlockState state, Level worldIn, BlockPos pos) {
      return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
   }

   public boolean m_8133_(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
      super.triggerEvent(state, world, pos, eventID, eventParam);
      BlockEntity blockEntity = world.getBlockEntity(pos);
      return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
   }

   public void m_6810_(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
      if (state.getBlock() != newState.getBlock()) {
         if (world.getBlockEntity(pos) instanceof ProtoChestTileEntity be) {
            Containers.dropContents(world, pos, be);
            world.updateNeighbourForOutputSignal(pos, this);
         }

         super.onRemove(state, world, pos, newState, isMoving);
      }
   }

   public boolean m_7278_(BlockState state) {
      return true;
   }

   public int m_6782_(BlockState blockState, Level world, BlockPos pos) {
      return world.getBlockEntity(pos) instanceof ProtoChestTileEntity be ? AbstractContainerMenu.getRedstoneSignalFromBlockEntity(be) : 0;
   }
}
