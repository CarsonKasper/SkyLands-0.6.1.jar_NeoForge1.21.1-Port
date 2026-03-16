package net.mcreator.flyingstuff.item;

import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class CookedTucTucWingItem extends Item {
   public CookedTucTucWingItem() {
      super(new Properties().stacksTo(64).rarity(Rarity.COMMON).food(new Builder().nutrition(7).saturationModifier(0.6F).build()));
   }
}


