package net.mcreator.flyingstuff.item;

import java.util.List;
import net.mcreator.flyingstuff.block.UnderGroundPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class UnderGroundItem extends Item {
   public UnderGroundItem() {
      super(new Properties().stacksTo(64));
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext world, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, world, list, flag);
   }

   public InteractionResult useOn(UseOnContext context) {
      Player entity = context.getPlayer();
      BlockPos pos = context.getClickedPos() .relative(context.getClickedFace());
      ItemStack itemstack = context.getItemInHand();
      Level world = context.getLevel();
      if (!entity.mayUseItemAt(pos, context.getClickedFace(), itemstack)) {
         return InteractionResult.FAIL;
      } else {
         int x = pos.getX();
         int y = pos.getY();
         int z = pos.getZ();
         boolean success = false;
         if (world.isEmptyBlock(pos)) {
            UnderGroundPortalBlock.portalSpawn(world, pos);
            itemstack.hurtAndBreak(1, entity, LivingEntity.getSlotForHand(context.getHand()));
            success = true;
         }

         return success ? InteractionResult.SUCCESS : InteractionResult.FAIL;
      }
   }
}



