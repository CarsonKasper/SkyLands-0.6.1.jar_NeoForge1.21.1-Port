package net.mcreator.flyingstuff.client.renderer;

import net.mcreator.flyingstuff.client.model.ModelAutomaton;
import net.mcreator.flyingstuff.entity.SkyAutomatonEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class SkyAutomatonRenderer extends MobRenderer<SkyAutomatonEntity, ModelAutomaton<SkyAutomatonEntity>> {
   public SkyAutomatonRenderer(Context context) {
      super(context, new ModelAutomaton(context.bakeLayer(ModelAutomaton.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(SkyAutomatonEntity entity) {
      return ResourceLocation.parse("flying_stuff:textures/entities/sky_automaton.png");
   }
}


