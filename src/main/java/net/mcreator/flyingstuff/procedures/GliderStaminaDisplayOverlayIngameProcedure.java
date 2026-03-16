package net.mcreator.flyingstuff.procedures;

import javax.annotation.Nullable;
import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class GliderStaminaDisplayOverlayIngameProcedure {
   @SubscribeEvent
   public static void onPlayerTick(PlayerTickEvent.Post event) {
      execute(event, event.getEntity());
   }

   public static boolean execute(Entity entity) {
      return execute(null, entity);
   }

   private static boolean execute(@Nullable Event event, Entity entity) {
      return entity == null
         ? false
         : ((FlyingStuffModVariables.PlayerVariables)entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new FlyingStuffModVariables.PlayerVariables()))
               .gliding_stamina
            < 6.0;
   }
}

