package net.mcreator.flyingstuff.client.renderer;

import net.mcreator.flyingstuff.client.model.ModelAutomaton;
import net.mcreator.flyingstuff.entity.LavicSkyAutomatonEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class LavicSkyAutomatonRenderer extends MobRenderer<LavicSkyAutomatonEntity, ModelAutomaton<LavicSkyAutomatonEntity>> {
   public LavicSkyAutomatonRenderer(Context context) {
      super(context, new ModelAutomaton(context.bakeLayer(ModelAutomaton.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(LavicSkyAutomatonEntity entity) {
      return ResourceLocation.parse("flying_stuff:textures/entities/lavic_sky_automaton.png");
   }
}


