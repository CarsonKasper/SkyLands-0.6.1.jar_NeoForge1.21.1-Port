package net.mcreator.flyingstuff.procedures;

import javax.annotation.Nullable;
import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class AaaaProcedure {
   @SubscribeEvent
   public static void onEntityJoin(EntityJoinLevelEvent event) {
      execute(event, event.getLevel());
   }

   public static void execute(LevelAccessor world) {
      execute(null, world);
   }

   private static void execute(@Nullable Event event, LevelAccessor world) {
      if (world.isClientSide()) {
         FlyingStuffModVariables.CloudActive = FlyingStuffModVariables.CloudActiveBolean.getValue();
      }
   }
}

