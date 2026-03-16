package net.mcreator.flyingstuff.item;

import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class RawTucTucWingItem extends Item {
   public RawTucTucWingItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON).food(new Builder().nutrition(2).saturationModifier(0.2F).build()));
   }
}


