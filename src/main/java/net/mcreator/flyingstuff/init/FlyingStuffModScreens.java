package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.client.gui.GoldenChestScreen;
import net.mcreator.flyingstuff.client.gui.ProtoChestGuiScreen;
import net.mcreator.flyingstuff.client.gui.St0Screen;
import net.mcreator.flyingstuff.client.gui.St1Screen;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModScreens {
   @SubscribeEvent
   public static void clientLoad(RegisterMenuScreensEvent event) {
      event.register((MenuType)FlyingStuffModMenus.GOLDEN_CHEST.get(), GoldenChestScreen::new);
      event.register((MenuType)FlyingStuffModMenus.ST_0.get(), St0Screen::new);
      event.register((MenuType)FlyingStuffModMenus.ST_1.get(), St1Screen::new);
      event.register((MenuType)FlyingStuffModMenus.PROTO_CHEST_GUI.get(), ProtoChestGuiScreen::new);
   }
}


