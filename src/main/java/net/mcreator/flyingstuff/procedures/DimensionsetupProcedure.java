package net.mcreator.flyingstuff.procedures;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD)
public class DimensionsetupProcedure {
   @SubscribeEvent(priority = EventPriority.LOWEST)
   public static void setupDimensions(RegisterDimensionSpecialEffectsEvent event) {
      execute(event);
   }

   public static void execute() {
      execute(null);
   }

   private static void execute(@Nullable Event event) {
   }

   public static void register(ResourceKey<Level> dimension, DimensionSpecialEffects effects) {
   }
}

