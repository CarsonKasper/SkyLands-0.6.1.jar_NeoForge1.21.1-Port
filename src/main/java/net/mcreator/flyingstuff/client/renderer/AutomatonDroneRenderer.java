package net.mcreator.flyingstuff.client.renderer;

import net.mcreator.flyingstuff.client.model.Modelhovering_automaton;
import net.mcreator.flyingstuff.entity.AutomatonDroneEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class AutomatonDroneRenderer extends MobRenderer<AutomatonDroneEntity, Modelhovering_automaton<AutomatonDroneEntity>> {
   public AutomatonDroneRenderer(Context context) {
      super(context, new Modelhovering_automaton(context.bakeLayer(Modelhovering_automaton.LAYER_LOCATION)), 0.4F);
   }

   public ResourceLocation getTextureLocation(AutomatonDroneEntity entity) {
      return ResourceLocation.parse("flying_stuff:textures/entities/drone_automaton.png");
   }
}


