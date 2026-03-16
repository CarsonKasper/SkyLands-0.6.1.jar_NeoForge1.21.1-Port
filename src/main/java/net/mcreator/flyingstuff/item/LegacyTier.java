package net.mcreator.flyingstuff.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;

public abstract class LegacyTier implements Tier {
   @Override
   public TagKey<Block> getIncorrectBlocksForDrops() {
      return BlockTags.INCORRECT_FOR_IRON_TOOL;
   }
}

