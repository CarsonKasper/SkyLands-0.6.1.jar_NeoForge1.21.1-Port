package net.mcreator.flyingstuff.procedures;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;

public class HiddenOnEffectActiveTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (!(entity instanceof Warden)) {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               CommandSourceStack source = entity.createCommandSourceStack().withPermission(4).withSuppressedOutput();
               entity.getServer().getCommands().performPrefixedCommand(source, "team add mobc");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               CommandSourceStack source = entity.createCommandSourceStack().withPermission(4).withSuppressedOutput();
               entity.getServer().getCommands().performPrefixedCommand(source, "team join mobc");
            }
         }
      }
   }
}


