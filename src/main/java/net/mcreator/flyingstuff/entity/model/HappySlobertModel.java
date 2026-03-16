package net.mcreator.flyingstuff.entity.model;

import net.mcreator.flyingstuff.entity.HappySlobertEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HappySlobertModel extends GeoModel<HappySlobertEntity> {
   public ResourceLocation getAnimationResource(HappySlobertEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/blob.animation.json");
   }

   public ResourceLocation getModelResource(HappySlobertEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/blob.geo.json");
   }

   public ResourceLocation getTextureResource(HappySlobertEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
   }
}

