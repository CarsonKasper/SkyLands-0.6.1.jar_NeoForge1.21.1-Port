package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class DiamondLevel1KeyItem extends Item {
   public DiamondLevel1KeyItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
   }
}

