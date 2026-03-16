package net.mcreator.flyingstuff.procedures;

import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.player.PlayerDestroyItemEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class OnItemBrokenProcedure {
   @SubscribeEvent
   public static void onItemDestroyed(PlayerDestroyItemEvent event) {
      execute(event, event.getOriginal(), event.getEntity(), event.getHand());
   }

   public static void execute(ItemStack itemstack, Player player, InteractionHand hand) {
      execute(null, itemstack, player, hand);
   }

   private static void execute(@Nullable Event event, ItemStack itemstack, Player player, InteractionHand hand) {
      ItemStack sword = ItemStack.EMPTY;
      if (itemstack.is(ItemTags.create(ResourceLocation.parse("flying_stuff:breaks_in_sword")))) {
         sword = new ItemStack((ItemLike)FlyingStuffModItems.SWORD_OF_THE_SKY.get());
         sword.setDamageValue(1);

         Level lvl = player.level();
         RandomSource rand = lvl.getRandom();
         lvl.addParticle(
            (ParticleOptions)FlyingStuffModParticleTypes.ITEM_BREAK.get(),
            player.getX(),
            player.getY(),
            player.getZ(),
            Mth.nextDouble(rand, -0.2, 0.2),
            Mth.nextDouble(rand, -0.1, 0.2),
            Mth.nextDouble(rand, -0.2, 0.2)
         );
         lvl.addParticle(
            (ParticleOptions)FlyingStuffModParticleTypes.ITEM_BREAK.get(),
            player.getX(),
            player.getY(),
            player.getZ(),
            Mth.nextDouble(rand, -0.2, 0.2),
            Mth.nextDouble(rand, -0.1, 0.2),
            Mth.nextDouble(rand, -0.2, 0.2)
         );
         lvl.addParticle(
            (ParticleOptions)FlyingStuffModParticleTypes.ITEM_BREAK.get(),
            player.getX(),
            player.getY(),
            player.getZ(),
            Mth.nextDouble(rand, -0.2, 0.2),
            Mth.nextDouble(rand, -0.1, 0.2),
            Mth.nextDouble(rand, -0.2, 0.2)
         );
         lvl.addParticle(
            (ParticleOptions)FlyingStuffModParticleTypes.ITEM_BREAK.get(),
            player.getX(),
            player.getY(),
            player.getZ(),
            Mth.nextDouble(rand, -0.2, 0.2),
            Mth.nextDouble(rand, -0.1, 0.2),
            Mth.nextDouble(rand, -0.2, 0.2)
         );
         lvl.addParticle(
            (ParticleOptions)FlyingStuffModParticleTypes.ITEM_BREAK.get(),
            player.getX(),
            player.getY(),
            player.getZ(),
            Mth.nextDouble(rand, -0.2, 0.2),
            Mth.nextDouble(rand, -0.1, 0.2),
            Mth.nextDouble(rand, -0.2, 0.2)
         );
         lvl.addParticle(
            (ParticleOptions)FlyingStuffModParticleTypes.ITEM_BREAK.get(),
            player.getX(),
            player.getY(),
            player.getZ(),
            Mth.nextDouble(rand, -0.2, 0.2),
            Mth.nextDouble(rand, -0.1, 0.2),
            Mth.nextDouble(rand, -0.2, 0.2)
         );
         player.setItemInHand(hand, sword);
      }
   }
}


