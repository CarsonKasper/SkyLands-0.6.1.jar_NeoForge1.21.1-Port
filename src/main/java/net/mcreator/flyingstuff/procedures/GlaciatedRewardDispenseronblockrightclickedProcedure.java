package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;

public class GlaciatedRewardDispenseronblockrightclickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      RewardDispenserProcedure.execute(
         world, x, y, z, entity, (Item)FlyingStuffModItems.AMBER_CELESTIUM.get(), " ", "flying_stuff:glaciated_reward_dispenser_loots"
      );
   }
}
