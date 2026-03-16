package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.minecraft.world.entity.Entity;

public class GliderStamina2Procedure {
   public static boolean execute(Entity entity) {
      return entity == null
         ? false
         : ((FlyingStuffModVariables.PlayerVariables)entity.getCapability(FlyingStuffModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                  .orElse(new FlyingStuffModVariables.PlayerVariables()))
               .gliding_stamina
            >= 2.0;
   }
}
