package net.mcreator.flyingstuff.entity.model;

import net.mcreator.flyingstuff.entity.MagmaSlobertEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MagmaSlobertModel extends GeoModel<MagmaSlobertEntity> {
   public ResourceLocation getAnimationResource(MagmaSlobertEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/blob.animation.json");
   }

   public ResourceLocation getModelResource(MagmaSlobertEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/blob.geo.json");
   }

   public ResourceLocation getTextureResource(MagmaSlobertEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
   }
}

