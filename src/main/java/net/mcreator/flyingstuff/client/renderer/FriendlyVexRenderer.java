package net.mcreator.flyingstuff.client.renderer;

import net.mcreator.flyingstuff.client.model.Modelfvex;
import net.mcreator.flyingstuff.entity.FriendlyVexEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class FriendlyVexRenderer extends MobRenderer<FriendlyVexEntity, Modelfvex<FriendlyVexEntity>> {
   public FriendlyVexRenderer(Context context) {
      super(context, new Modelfvex(context.bakeLayer(Modelfvex.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(FriendlyVexEntity entity) {
      return ResourceLocation.parse("flying_stuff:textures/entities/friendlyvex.png");
   }
}


