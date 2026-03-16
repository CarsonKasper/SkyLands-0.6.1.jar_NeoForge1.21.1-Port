package net.mcreator.flyingstuff.init;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.GAME)
public class FlyingStuffModTrades {
   @SubscribeEvent
   public static void registerTrades(VillagerTradesEvent event) {
      if (event.getType() == FlyingStuffModVillagerProfessions.COOL.get()) {
         ((List)event.getTrades().get(2))
            .add(
               new BasicItemListing(
                  new ItemStack((ItemLike)FlyingStuffModItems.GOLDENLEVEL_1_KEY.get()),
                  new ItemStack((ItemLike)FlyingStuffModBlocks.CELESTIUM_BLOCK.get()),
                  new ItemStack((ItemLike)FlyingStuffModItems.HEADSET_ARMOR_TRIM_SMITHING_TEMPLATE.get()),
                  10,
                  11,
                  0.05F
               )
            );
         ((List)event.getTrades().get(1))
            .add(
               new BasicItemListing(
                  new ItemStack((ItemLike)FlyingStuffModItems.CELESTIUM.get(), 10),
                  new ItemStack((ItemLike)FlyingStuffModBlocks.CLOUD_BLOCK.get()),
                  10,
                  5,
                  0.05F
               )
            );
         ((List)event.getTrades().get(1))
            .add(
               new BasicItemListing(
                  new ItemStack(Items.EMERALD, 2),
                  new ItemStack((ItemLike)FlyingStuffModItems.CELESTIUM.get(), 8),
                  new ItemStack((ItemLike)FlyingStuffModItems.ISLAND_GLIDER_DESIGN.get()),
                  10,
                  9,
                  0.05F
               )
            );
      }
   }
}

