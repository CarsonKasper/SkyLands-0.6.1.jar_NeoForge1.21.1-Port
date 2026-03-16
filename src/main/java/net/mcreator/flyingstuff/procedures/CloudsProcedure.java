package net.mcreator.flyingstuff.procedures;

import javax.annotation.Nullable;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class CloudsProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent.Post event) {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, SimplexNoise noise) {
      execute(null, world, x, y, z, noise);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, SimplexNoise noise) {
   }
}

