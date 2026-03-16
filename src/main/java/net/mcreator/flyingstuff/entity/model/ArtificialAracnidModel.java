package net.mcreator.flyingstuff.entity.model;

import net.mcreator.flyingstuff.entity.ArtificialAracnidEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ArtificialAracnidModel extends GeoModel<ArtificialAracnidEntity> {
   public ResourceLocation getAnimationResource(ArtificialAracnidEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/artificialaracnid.animation.json");
   }

   public ResourceLocation getModelResource(ArtificialAracnidEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/artificialaracnid.geo.json");
   }

   public ResourceLocation getTextureResource(ArtificialAracnidEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ArtificialAracnidEntity animatable, long instanceId, AnimationState animationState) {
      GeoBone head = this.getAnimationProcessor().getBone("");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}

