package net.mcreator.flyingstuff.item;

import java.util.List;
import net.mcreator.flyingstuff.entity.FireWaveEntity;
import net.mcreator.flyingstuff.procedures.IgneusLaserBladeLivingEntityIsHitWithToolProcedure;
import net.mcreator.flyingstuff.procedures.IgneusLaserBladeRangedItemUsedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class IgneusLaserBladeItem extends Item {
   public IgneusLaserBladeItem() {
      super(new Properties().stacksTo(400).fireResistant().rarity(Rarity.RARE));
   }

   public int getUseDuration(ItemStack itemstack) {
      return 72000;
   }

   public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
      return 1.5F;
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.literal("Right Click For Special Ability"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = InteractionResultHolder.fail(entity.getItemInHand(hand));
      if (entity.getAbilities().instabuild || this.findAmmo(entity) != ItemStack.EMPTY) {
         ar = InteractionResultHolder.consume(entity.getItemInHand(hand));
         entity.startUsingItem(hand);
      }

      return ar;
   }

   public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
      itemstack.hurtAndBreak(1, sourceentity, EquipmentSlot.MAINHAND);
      IgneusLaserBladeLivingEntityIsHitWithToolProcedure.execute(entity);
      return true;
   }

   public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      if (!world.isClientSide() && entity instanceof ServerPlayer player) {
         ItemStack stack = this.findAmmo(player);
         if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
            FireWaveEntity projectile = FireWaveEntity.shoot(world, entity, world.getRandom());
            itemstack.hurtAndBreak(1, entity, LivingEntity.getSlotForHand(entity.getUsedItemHand()));
            if (player.getAbilities().instabuild) {
               projectile.pickup = Pickup.CREATIVE_ONLY;
            } else if (stack.isDamageableItem()) {
               stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
               if (stack.isEmpty()) {
                  player.getInventory().removeItem(stack);
               }
            } else {
               stack.shrink(1);
               if (stack.isEmpty()) {
                  player.getInventory().removeItem(stack);
               }
            }

            IgneusLaserBladeRangedItemUsedProcedure.execute(entity, itemstack);
         }
      }
   }

   private ItemStack findAmmo(Player player) {
      ItemStack stack = ProjectileWeaponItem.getHeldProjectile(player, e -> e.getItem() == FireWaveEntity.PROJECTILE_ITEM.getItem());
      if (stack == ItemStack.EMPTY) {
         for (int i = 0; i < player.getInventory().items.size(); i++) {
            ItemStack teststack = (ItemStack)player.getInventory().items.get(i);
            if (teststack != null && teststack.getItem() == FireWaveEntity.PROJECTILE_ITEM.getItem()) {
               stack = teststack;
               break;
            }
         }
      }

      return stack;
   }
}



