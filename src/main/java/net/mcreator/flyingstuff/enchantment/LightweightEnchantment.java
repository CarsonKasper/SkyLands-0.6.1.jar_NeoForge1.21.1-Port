package net.mcreator.flyingstuff.enchantment;

import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.core.HolderSet;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

public final class LightweightEnchantment {
   private LightweightEnchantment() {
   }

   public static Enchantment create() {
      HolderSet.Direct<Item> supported = HolderSet.direct(FlyingStuffModItems.GLIDER.get().builtInRegistryHolder());
      return Enchantment.enchantment(
            Enchantment.definition(
               supported,
               supported,
               2,
               5,
               Enchantment.constantCost(10),
               Enchantment.dynamicCost(25, 8),
               4,
               EquipmentSlotGroup.MAINHAND,
               EquipmentSlotGroup.OFFHAND
            )
         )
         .withCustomName(component -> Component.literal("Lightweight"))
         .build(ResourceLocation.fromNamespaceAndPath("flying_stuff", "lightweight"));
   }
}

