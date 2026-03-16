package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.client.model.ModelAutomaton;
import net.mcreator.flyingstuff.client.model.ModelAutomaton_boss;
import net.mcreator.flyingstuff.client.model.ModelAutomatondesert;
import net.mcreator.flyingstuff.client.model.Modelfvex;
import net.mcreator.flyingstuff.client.model.Modelhovering_automaton;
import net.mcreator.flyingstuff.client.model.Modelsky_boss0;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModModels {
   @SubscribeEvent
   public static void registerLayerDefinitions(RegisterLayerDefinitions event) {
      event.registerLayerDefinition(Modelfvex.LAYER_LOCATION, Modelfvex::createBodyLayer);
      event.registerLayerDefinition(ModelAutomatondesert.LAYER_LOCATION, ModelAutomatondesert::createBodyLayer);
      event.registerLayerDefinition(ModelAutomaton_boss.LAYER_LOCATION, ModelAutomaton_boss::createBodyLayer);
      event.registerLayerDefinition(Modelhovering_automaton.LAYER_LOCATION, Modelhovering_automaton::createBodyLayer);
      event.registerLayerDefinition(ModelAutomaton.LAYER_LOCATION, ModelAutomaton::createBodyLayer);
      event.registerLayerDefinition(Modelsky_boss0.LAYER_LOCATION, Modelsky_boss0::createBodyLayer);
   }
}
