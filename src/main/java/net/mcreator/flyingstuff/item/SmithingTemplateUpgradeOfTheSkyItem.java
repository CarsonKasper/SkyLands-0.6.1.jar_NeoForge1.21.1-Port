package net.mcreator.flyingstuff.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class SmithingTemplateUpgradeOfTheSkyItem extends Item {
   public SmithingTemplateUpgradeOfTheSkyItem() {
      super(new Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC));
   }

   public boolean m_41470_() {
      return true;
   }

   public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
      return new ItemStack(this);
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Made with ancient materials that no longer exist"));
      list.add(Component.literal("Cannot be duplicated"));
   }
}



