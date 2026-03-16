package net.mcreator.flyingstuff.init;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

@EventBusSubscriber
public class FlyingStuffModBiomes {
   @SubscribeEvent
   public static void onServerAboutToStart(ServerAboutToStartEvent event) {
   }
}

