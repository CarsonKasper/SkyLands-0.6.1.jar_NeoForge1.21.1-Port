package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.FlyingStuffMod;
import net.mcreator.flyingstuff.network.FreefallMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModKeyMappings {
   public static final KeyMapping FREEFALL = new KeyMapping("key.flying_stuff.freefall", 82, "key.categories.movement") {
      private boolean isDownOld = false;

      public void setDown(boolean isDown) {
         super.setDown(isDown);
         if (this.isDownOld != isDown && isDown) {
            FlyingStuffMod.PACKET_HANDLER.sendToServer(new FreefallMessage(0, 0));
            FreefallMessage.pressAction(Minecraft.getInstance().player, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };

   @SubscribeEvent
   public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
      event.register(FREEFALL);
   }

   @EventBusSubscriber(Dist.CLIENT)
   public static class KeyEventListener {
      @SubscribeEvent
      public static void onClientTick(ClientTickEvent event) {
         if (Minecraft.getInstance().screen == null) {
            FlyingStuffModKeyMappings.FREEFALL.setDown(false);
         }
      }
   }
}


