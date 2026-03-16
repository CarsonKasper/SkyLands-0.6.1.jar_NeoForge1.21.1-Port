package net.mcreator.flyingstuff.block.entity;

import io.netty.buffer.Unpooled;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.block.GlaciatedSkyLevel2ChestBlock;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.mcreator.flyingstuff.world.inventory.GoldenChestMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GlaciatedSkyLevel2ChestTileEntity extends LegacyRandomizableContainerBlockEntity implements GeoBlockEntity, WorldlyContainer {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private NonNullList<ItemStack> stacks = NonNullList.withSize(27, ItemStack.EMPTY);

   public GlaciatedSkyLevel2ChestTileEntity(BlockPos pos, BlockState state) {
      super((BlockEntityType)FlyingStuffModBlockEntities.GLACIATED_SKY_LEVEL_2_CHEST.get(), pos, state);
   }

   private PlayState predicate(AnimationState event) {
      String animationprocedure = this.m_58900_().getValue(GlaciatedSkyLevel2ChestBlock.ANIMATION) + "";
      return animationprocedure.equals("0") ? event.setAndContinue(RawAnimation.begin().thenLoop(animationprocedure)) : PlayState.STOP;
   }

   private PlayState procedurePredicate(AnimationState event) {
      String animationprocedure = this.m_58900_().getValue(GlaciatedSkyLevel2ChestBlock.ANIMATION) + "";
      if (!animationprocedure.equals("0") && event.getController().getAnimationState() == State.STOPPED) {
         event.getController().setAnimation(RawAnimation.begin().thenPlay(animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            if (this.m_58900_().getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp) {
               this.getLevel().setBlock(this.m_58899_(), (BlockState)this.m_58900_().setValue(_integerProp, 0), 3);
            }

            event.getController().forceAnimationReset();
         }
      } else if (animationprocedure.equals("0")) {
         return PlayState.STOP;
      }

      return PlayState.CONTINUE;
   }

   public void registerControllers(ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "controller", 0, this::predicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedurecontroller", 0, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public void loadWithComponents(CompoundTag compound) {
      super.loadWithComponents(compound);
      if (!this.m_59631_(compound)) {
         this.stacks = NonNullList.withSize(this.m_6643_(), ItemStack.EMPTY);
      }

      ContainerHelper.loadAllItems(compound, this.stacks, this.lookupProvider());
   }

   public void m_183515_(CompoundTag compound) {
      super.m_183515_(compound);
      if (!this.m_59634_(compound)) {
         ContainerHelper.saveAllItems(compound, this.stacks, this.lookupProvider());
      }
   }

   public ClientboundBlockEntityDataPacket getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.create(this);
   }

   public CompoundTag m_5995_() {
      return this.saveWithoutMetadata();
   }

   public int m_6643_() {
      return this.stacks.size();
   }

   public boolean m_7983_() {
      for (ItemStack itemstack : this.stacks) {
         if (!itemstack.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public Component m_6820_() {
      return Component.literal("glaciated_sky_level_2_chest");
   }

   public int m_6893_() {
      return 64;
   }

   public AbstractContainerMenu m_6555_(int id, Inventory inventory) {
      return new GoldenChestMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.getBlockPos()));
   }

   public Component getDisplayName() {
      return Component.literal("Glaciated Sky Level 2 Chest");
   }

   protected NonNullList<ItemStack> m_7086_() {
      return this.stacks;
   }

   protected void m_6520_(NonNullList<ItemStack> stacks) {
      this.stacks = stacks;
   }

   public boolean m_7013_(int index, ItemStack stack) {
      return true;
   }

   public int[] m_7071_(Direction side) {
      return IntStream.range(0, this.m_6643_()).toArray();
   }

   public boolean m_7155_(int index, ItemStack stack, @Nullable Direction direction) {
      return this.m_7013_(index, stack);
   }

   public boolean m_7157_(int index, ItemStack stack, Direction direction) {
      return true;
   }

   public void setChanged() {
      super.setChanged();
   }
}

