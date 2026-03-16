package net.mcreator.flyingstuff.item.inventory;

import net.mcreator.flyingstuff.client.gui.St0Screen;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(Dist.CLIENT)
public class SkyLandsStarterGuideInventoryCapability {
   @SubscribeEvent
   @OnlyIn(Dist.CLIENT)
   public static void onItemDropped(ItemTossEvent event) {
      if (event.getEntity().getItem().getItem() == FlyingStuffModItems.SKY_LANDS_STARTER_GUIDE.get() && Minecraft.getInstance().screen instanceof St0Screen) {
         Minecraft.getInstance().player.closeContainer();
      }
   }
}


