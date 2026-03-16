package net.mcreator.flyingstuff.entity.model;

import net.mcreator.flyingstuff.entity.SkyPharaohEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SkyPharaohModel extends GeoModel<SkyPharaohEntity> {
   public ResourceLocation getAnimationResource(SkyPharaohEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/sky_pharaoh.animation.json");
   }

   public ResourceLocation getModelResource(SkyPharaohEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/sky_pharaoh.geo.json");
   }

   public ResourceLocation getTextureResource(SkyPharaohEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SkyPharaohEntity animatable, long instanceId, AnimationState animationState) {
      GeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}

