package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.WalkableAbyssalDoorDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WalkableAbyssalDoorDisplayModel extends GeoModel<WalkableAbyssalDoorDisplayItem> {
   public ResourceLocation getAnimationResource(WalkableAbyssalDoorDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/abyssal_door.animation.json");
   }

   public ResourceLocation getModelResource(WalkableAbyssalDoorDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/abyssal_door.geo.json");
   }

   public ResourceLocation getTextureResource(WalkableAbyssalDoorDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/abyssal_door.png");
   }
}
