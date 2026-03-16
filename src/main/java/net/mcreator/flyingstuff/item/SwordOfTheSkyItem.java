package net.mcreator.flyingstuff.item;

import java.util.List;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class SwordOfTheSkyItem extends Item {
   public SwordOfTheSkyItem() {
      super(new Properties().fireResistant());
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Can Be Infused with All Celestium Types"));
   }
}





