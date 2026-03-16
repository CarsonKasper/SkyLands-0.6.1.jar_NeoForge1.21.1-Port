package net.mcreator.flyingstuff.entity.model;

import net.mcreator.flyingstuff.entity.GlaciatedDragonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GlaciatedDragonModel extends GeoModel<GlaciatedDragonEntity> {
   public ResourceLocation getAnimationResource(GlaciatedDragonEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/icedragon.animation.json");
   }

   public ResourceLocation getModelResource(GlaciatedDragonEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/icedragon.geo.json");
   }

   public ResourceLocation getTextureResource(GlaciatedDragonEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(GlaciatedDragonEntity animatable, long instanceId, AnimationState animationState) {
      GeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}

