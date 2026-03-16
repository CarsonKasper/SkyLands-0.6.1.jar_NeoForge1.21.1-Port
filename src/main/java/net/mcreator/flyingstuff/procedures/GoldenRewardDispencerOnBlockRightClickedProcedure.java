package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;

public class GoldenRewardDispencerOnBlockRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      RewardDispenserProcedure.execute(world, x, y, z, entity, (Item)FlyingStuffModItems.CELESTIUM.get(), " ", "flying_stuff:golden_reward_dispencer_loots");
   }
}
