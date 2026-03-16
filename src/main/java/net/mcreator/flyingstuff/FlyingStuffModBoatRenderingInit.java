package net.mcreator.flyingstuff;

import net.custom.flyingstuff.entity.client.ModBoatRenderer;
import net.custom.flyingstuff.entity.client.ModModelLayers;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModBoatRenderingInit {
   @SubscribeEvent
   public static void registerLayer(RegisterLayerDefinitions event) {
      event.registerLayerDefinition(ModModelLayers.GOLDENLEAVES_BOAT_LAYER, BoatModel::createBodyModel);
      event.registerLayerDefinition(ModModelLayers.GOLDENLEAVES_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
      event.registerLayerDefinition(ModModelLayers.GLACIATED_BOAT_LAYER, BoatModel::createBodyModel);
      event.registerLayerDefinition(ModModelLayers.GLACIATED_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
      event.registerLayerDefinition(ModModelLayers.LAVIC_BOAT_LAYER, BoatModel::createBodyModel);
      event.registerLayerDefinition(ModModelLayers.LAVIC_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
      event.registerLayerDefinition(ModModelLayers.INKY_BOAT_LAYER, BoatModel::createBodyModel);
      event.registerLayerDefinition(ModModelLayers.INKY_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
   }

   @SubscribeEvent
   public static void onclientSetup(FMLClientSetupEvent event) {
      EntityRenderers.register((EntityType)FlyingStuffModSigns.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
      EntityRenderers.register((EntityType)FlyingStuffModSigns.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
   }
}

