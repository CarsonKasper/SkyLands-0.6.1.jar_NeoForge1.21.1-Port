package net.mcreator.flyingstuff.block.entity;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.Container;
import java.util.stream.IntStream;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class LegacyRandomizableContainerBlockEntity extends RandomizableContainerBlockEntity {
   @Nullable
   protected Level f_58857_;

   protected LegacyRandomizableContainerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
      super(type, pos, state);
   }

   @Override
   public void setLevel(Level level) {
      super.setLevel(level);
      this.f_58857_ = level;
   }

   public BlockState m_58900_() {
      return this.getBlockState();
   }

   public BlockPos m_58899_() {
      return this.getBlockPos();
   }

   public void loadWithComponents(CompoundTag tag) {
      this.loadAdditional(tag, this.lookupProvider());
   }

   public void m_183515_(CompoundTag tag) {
      this.saveAdditional(tag, this.lookupProvider());
   }

   public boolean m_59631_(CompoundTag tag) {
      return this.tryLoadLootTable(tag);
   }

   public boolean m_59634_(CompoundTag tag) {
      return this.trySaveLootTable(tag);
   }

   public CompoundTag saveWithoutMetadata() {
      return this.getUpdateTag(this.lookupProvider());
   }

   public void setChanged() {
      super.setChanged();
   }

   public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction side) {
      return ((Container)this).canPlaceItem(slot, stack);
   }

   public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction side) {
      return true;
   }

   public int[] getSlotsForFace(Direction side) {
      return this.m_7071_(side);
   }

   protected HolderLookup.Provider lookupProvider() {
      return this.level != null ? this.level.registryAccess() : HolderLookup.Provider.create(java.util.stream.Stream.of());
   }

   @Override
   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.create(this);
   }

   @Override
   protected AbstractContainerMenu createMenu(int containerId, Inventory playerInventory) {
      return this.m_6555_(containerId, playerInventory);
   }

   @Override
   protected Component getDefaultName() {
      return Component.empty();
   }

   @Override
   protected NonNullList<ItemStack> getItems() {
      return this.m_7086_();
   }

   @Override
   protected void setItems(NonNullList<ItemStack> stacks) {
      this.m_6520_(stacks);
   }

   @Override
   public int getContainerSize() {
      return this.m_6643_();
   }

   @Override
   public boolean isEmpty() {
      return this.m_7983_();
   }

   @Override
   public int getMaxStackSize() {
      return this.m_6893_();
   }

   @Override
   public boolean canPlaceItem(int index, ItemStack stack) {
      return this.m_7013_(index, stack);
   }

   public abstract AbstractContainerMenu m_6555_(int id, Inventory inventory);

   public Component m_5446_() {
      return Component.empty();
   }

   protected abstract NonNullList<ItemStack> m_7086_();

   protected abstract void m_6520_(NonNullList<ItemStack> stacks);

   public abstract int m_6643_();

   public abstract boolean m_7983_();

   public abstract int m_6893_();

   public abstract boolean m_7013_(int index, ItemStack stack);

   public int[] m_7071_(Direction side) {
      return IntStream.range(0, this.getContainerSize()).toArray();
   }

   public boolean m_7155_(int index, ItemStack stack, @Nullable Direction direction) {
      return this.canPlaceItemThroughFace(index, stack, direction);
   }

   public boolean m_7157_(int index, ItemStack stack, Direction direction) {
      return this.canTakeItemThroughFace(index, stack, direction);
   }
}


