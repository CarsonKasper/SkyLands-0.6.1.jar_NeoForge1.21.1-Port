package net.mcreator.flyingstuff.procedures;

import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent.Context;

@EventBusSubscriber(modid = "flying_stuff")
public class SetupPlayerAnimationProcedure {
   public static void execute() {
      execute(null);
   }

   private static void execute(@Nullable Event event) {
   }

   @EventBusSubscriber(modid = "flying_stuff")
   public static class FlyingStuffModAnimationMessage {
      public FlyingStuffModAnimationMessage(String animation, int target, boolean override) {
      }

      public FlyingStuffModAnimationMessage(FriendlyByteBuf buffer) {
      }

      public static void buffer(SetupPlayerAnimationProcedure.FlyingStuffModAnimationMessage message, FriendlyByteBuf buffer) {
      }

      public static void handler(SetupPlayerAnimationProcedure.FlyingStuffModAnimationMessage message, Supplier<Context> contextSupplier) {
         Context context = contextSupplier.get();
         context.enqueueWork(() -> {
         });
         context.setPacketHandled(true);
      }

      @SubscribeEvent
      public static void registerMessage(FMLCommonSetupEvent event) {
      }
   }
}

