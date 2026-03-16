package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CelestiumItem extends Item {
   public CelestiumItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }
}

