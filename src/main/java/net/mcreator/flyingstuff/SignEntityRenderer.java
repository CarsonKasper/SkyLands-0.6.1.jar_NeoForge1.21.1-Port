package net.mcreator.flyingstuff;

import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class SignEntityRenderer {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      new SignEntityRenderer();
   }

   @SubscribeEvent
   public static void registerBER(RegisterRenderers event) {
      event.registerBlockEntityRenderer((BlockEntityType)FlyingStuffModSigns.MOD_SIGN.get(), SignRenderer::new);
      event.registerBlockEntityRenderer((BlockEntityType)FlyingStuffModSigns.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
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
