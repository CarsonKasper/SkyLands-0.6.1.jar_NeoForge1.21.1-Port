package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class SmokeFlowerPlantPlantRightClickedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      world.setBlock(BlockPos.containing(x, y, z), ((Block)FlyingStuffModBlocks.SMOKE_FLOWER_PLANT_GROW_STAGE.get()).defaultBlockState(), 3);
      if (world instanceof ServerLevel level) {
         ItemEntity entityToSpawn = new ItemEntity(level, x, y, z, ItemStack.EMPTY);
         entityToSpawn.setPickUpDelay(10);
         level.addFreshEntity(entityToSpawn);
      }
   }
}

