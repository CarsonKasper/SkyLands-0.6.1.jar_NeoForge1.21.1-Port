package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLevel2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGlaciatedSkyLevel2ChestDisplayModel extends GeoModel<OpenGlaciatedSkyLevel2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenGlaciatedSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGlaciatedSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGlaciatedSkyLevel2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest_open.png");
   }
}
