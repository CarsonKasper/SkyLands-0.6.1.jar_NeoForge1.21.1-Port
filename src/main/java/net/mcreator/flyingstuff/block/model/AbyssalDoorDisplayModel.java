package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.AbyssalDoorDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AbyssalDoorDisplayModel extends GeoModel<AbyssalDoorDisplayItem> {
   public ResourceLocation getAnimationResource(AbyssalDoorDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/abyssal_door.animation.json");
   }

   public ResourceLocation getModelResource(AbyssalDoorDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/abyssal_door.geo.json");
   }

   public ResourceLocation getTextureResource(AbyssalDoorDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/abyssal_door.png");
   }
}
