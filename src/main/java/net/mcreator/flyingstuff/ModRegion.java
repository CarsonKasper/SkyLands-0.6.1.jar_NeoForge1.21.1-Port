package net.mcreator.flyingstuff;

import net.custom.flyingstuff.world.GoldenRegion;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import terrablender.api.Regions;

@EventBusSubscriber(bus = Bus.MOD)
public class ModRegion {
   public ModRegion() {
      Regions.register(new GoldenRegion(ResourceLocation.fromNamespaceAndPath("flying_stuff", "overworld"), 1));
   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      new ModRegion();
   }

   @EventBusSubscriber
   private static class ForgeBusEvents {
      @SubscribeEvent
      public static void serverLoad(ServerStartingEvent event) {
      }

      @OnlyIn(Dist.CLIENT)
      @SubscribeEvent
      public static void clientLoad(FMLClientSetupEvent event) {
      }
   }
}
