package net.mcreator.flyingstuff.client.renderer;

import net.mcreator.flyingstuff.client.model.ModelAutomatondesert;
import net.mcreator.flyingstuff.entity.AridSkyAutomatonEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class AridSkyAutomatonRenderer extends MobRenderer<AridSkyAutomatonEntity, ModelAutomatondesert<AridSkyAutomatonEntity>> {
   public AridSkyAutomatonRenderer(Context context) {
      super(context, new ModelAutomatondesert(context.bakeLayer(ModelAutomatondesert.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(AridSkyAutomatonEntity entity) {
      return ResourceLocation.parse("flying_stuff:textures/entities/desertic_sky_automaton.png");
   }
}


