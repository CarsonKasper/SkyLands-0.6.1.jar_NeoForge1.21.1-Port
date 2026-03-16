package net.mcreator.flyingstuff.client.renderer;

import net.mcreator.flyingstuff.client.model.ModelAutomaton_boss;
import net.mcreator.flyingstuff.entity.GlaciatedSkyAutomatonEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class GlaciatedSkyAutomatonRenderer extends MobRenderer<GlaciatedSkyAutomatonEntity, ModelAutomaton_boss<GlaciatedSkyAutomatonEntity>> {
   public GlaciatedSkyAutomatonRenderer(Context context) {
      super(context, new ModelAutomaton_boss(context.bakeLayer(ModelAutomaton_boss.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(GlaciatedSkyAutomatonEntity entity) {
      return ResourceLocation.parse("flying_stuff:textures/entities/sky_automaton_ice.png");
   }
}


