package net.mcreator.flyingstuff.item;

import net.mcreator.flyingstuff.procedures.AutomatonSwordLivingEntityIsHitWithToolProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;

public class AutomatonSwordItem extends Item {
   public AutomatonSwordItem() {
      super(new Properties());
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      AutomatonSwordLivingEntityIsHitWithToolProcedure.execute(entity);
      return retval;
   }
}



