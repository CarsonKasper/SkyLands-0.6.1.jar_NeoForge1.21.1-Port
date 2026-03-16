package net.mcreator.flyingstuff.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class PharaohStaffPlayerFinishesUsingItemProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (entity instanceof Player _player) {
            _player.getCooldowns().addCooldown(itemstack.getItem(), 260);
         }

         if (itemstack.isDamageableItem()) {
            itemstack.setDamageValue(Math.max(0, itemstack.getDamageValue() - 1));
         }
      }
   }
}



