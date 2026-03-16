package net.mcreator.flyingstuff.item;

import net.mcreator.flyingstuff.procedures.PearlecentSwordOfTheSkyLivingEntityIsHitWithToolProcedure;
import net.mcreator.flyingstuff.procedures.PearlecentSwordOfTheSkyRightclickedOnBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;

public class PearlecentSwordOfTheSkyItem extends Item {
   public PearlecentSwordOfTheSkyItem() {
      super(new Properties().fireResistant());
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
      PearlecentSwordOfTheSkyLivingEntityIsHitWithToolProcedure.execute(entity);
      return retval;
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      PearlecentSwordOfTheSkyRightclickedOnBlockProcedure.execute(
         context.getLevel(),
         context.getClickedPos().getX(),
         context.getClickedPos().getY(),
         context.getClickedPos().getZ(),
         context.getPlayer(),
         context.getItemInHand()
      );
      return InteractionResult.SUCCESS;
   }
}




