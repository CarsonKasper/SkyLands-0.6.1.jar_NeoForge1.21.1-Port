package net.mcreator.flyingstuff.config;

import java.util.HashMap;
import java.util.Map;
import net.mcreator.flyingstuff.FlyingStuffMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.MarkerManager;

@EventBusSubscriber(modid = "flying_stuff", bus = Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModConfigInit {
   @SubscribeEvent
   public static void register(FMLConstructModEvent event) {
      event.enqueueWork(
         () -> ModLoadingContext.get()
            .registerExtensionPoint(
               IConfigScreenFactory.class,
               () -> (container, screen) -> FlyingStuffModConfig.getConfigBuilder().setParentScreen(screen).build()
            )
      );
   }

   @SubscribeEvent
   public static void clientSetup(FMLCommonSetupEvent event) {
      Map<String, Object> entries = FlyingStuffModConfig.serializer.deserialize();
      FlyingStuffModConfig.entries = (Map<String, Object>)(entries == null ? new HashMap<>() : entries);
      FlyingStuffModConfig.getConfigBuilder();
      FlyingStuffModConfig.serializer.serialize(FlyingStuffModConfig.entries);
      FlyingStuffMod.LOGGER.atLevel(Level.DEBUG).withMarker(MarkerManager.getMarker("CONFIG")).log(FlyingStuffModConfig.serializer.getMessage());
   }
}
