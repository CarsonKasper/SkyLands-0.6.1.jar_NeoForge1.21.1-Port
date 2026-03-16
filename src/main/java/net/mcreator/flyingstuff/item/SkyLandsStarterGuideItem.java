package net.mcreator.flyingstuff.item;

import io.netty.buffer.Unpooled;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.item.inventory.SkyLandsStarterGuideInventoryCapability;
import net.mcreator.flyingstuff.world.inventory.St0Menu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class SkyLandsStarterGuideItem extends Item {
   public SkyLandsStarterGuideItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
   }

   public InteractionResultHolder<ItemStack> use(Level world, final Player entity, final InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      if (entity instanceof ServerPlayer serverPlayer) {
         serverPlayer.openMenu(new MenuProvider() {
            public Component getDisplayName() {
               return Component.literal("Sky Lands Starter Guide");
            }

            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
               FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
               packetBuffer.writeBlockPos(entity.blockPosition());
               packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
               return new St0Menu(id, inventory, packetBuffer);
            }
         }, buf -> {
            buf.writeBlockPos(entity.blockPosition());
            buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
         });
      }

      return ar;
   }
}



