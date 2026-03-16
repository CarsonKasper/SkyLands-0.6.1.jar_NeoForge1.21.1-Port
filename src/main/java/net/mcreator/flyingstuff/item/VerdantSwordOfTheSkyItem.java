package net.mcreator.flyingstuff.item;

import net.mcreator.flyingstuff.procedures.VerdantSwordOfTheSkyLivingEntityIsHitWithToolProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class VerdantSwordOfTheSkyItem extends Item {
   public VerdantSwordOfTheSkyItem() {
      super(new Properties().fireResistant());
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      VerdantSwordOfTheSkyLivingEntityIsHitWithToolProcedure.execute(entity);
      return retval;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }
}




