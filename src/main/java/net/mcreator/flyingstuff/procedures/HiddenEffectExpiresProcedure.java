package net.mcreator.flyingstuff.procedures;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class HiddenEffectExpiresProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Player && !entity.level().isClientSide() && entity.getServer() != null) {
            CommandSourceStack source = entity.createCommandSourceStack().withPermission(4).withSuppressedOutput();
            entity.getServer().getCommands().performPrefixedCommand(source, "team leave @s");
         }
      }
   }
}


