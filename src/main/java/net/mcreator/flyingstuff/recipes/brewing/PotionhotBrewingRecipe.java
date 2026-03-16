package net.mcreator.flyingstuff.recipes.brewing;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class PotionhotBrewingRecipe implements IBrewingRecipe {
   public static void init(FMLCommonSetupEvent event) {
   }

   @Override
   public boolean isInput(ItemStack input) {
      return false;
   }

   @Override
   public boolean isIngredient(ItemStack ingredient) {
      return false;
   }

   @Override
   public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
      return ItemStack.EMPTY;
   }
}

