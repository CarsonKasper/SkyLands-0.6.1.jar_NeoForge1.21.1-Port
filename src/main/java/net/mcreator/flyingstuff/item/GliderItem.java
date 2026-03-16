package net.mcreator.flyingstuff.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class GliderItem extends Item {
   public GliderItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 5000;
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext world, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, world, list, flag);
   }
}



