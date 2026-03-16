package net.mcreator.flyingstuff.entity.model;

import net.mcreator.flyingstuff.entity.SkyAutomatonBruteEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SkyAutomatonBruteModel extends GeoModel<SkyAutomatonBruteEntity> {
   public ResourceLocation getAnimationResource(SkyAutomatonBruteEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/automaton_brute.animation.json");
   }

   public ResourceLocation getModelResource(SkyAutomatonBruteEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/automaton_brute.geo.json");
   }

   public ResourceLocation getTextureResource(SkyAutomatonBruteEntity entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(SkyAutomatonBruteEntity animatable, long instanceId, AnimationState animationState) {
      GeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
         head.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
      }
   }
}

