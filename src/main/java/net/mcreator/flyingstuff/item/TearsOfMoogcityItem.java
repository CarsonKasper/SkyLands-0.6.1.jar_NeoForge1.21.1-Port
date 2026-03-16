package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class TearsOfMoogcityItem extends Item {
   public TearsOfMoogcityItem() {
      super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }
}






