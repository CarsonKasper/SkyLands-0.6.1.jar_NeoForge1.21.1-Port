package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class LavicLevel1KeyItem extends Item {
   public LavicLevel1KeyItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }
}

