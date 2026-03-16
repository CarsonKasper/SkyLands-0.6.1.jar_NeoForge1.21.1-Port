package net.mcreator.flyingstuff.entity.model;

import net.mcreator.flyingstuff.entity.IceBlobEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceBlobModel extends GeoModel<IceBlobEntity> {
   public ResourceLocation getAnimationResource(IceBlobEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/blob.animation.json");
   }

   public ResourceLocation getModelResource(IceBlobEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/blob.geo.json");
   }

   public ResourceLocation getTextureResource(IceBlobEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
   }
}

