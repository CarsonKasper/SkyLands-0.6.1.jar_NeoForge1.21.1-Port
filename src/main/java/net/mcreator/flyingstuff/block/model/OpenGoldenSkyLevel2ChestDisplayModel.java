package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGoldenSkyLevel2ChestDisplayModel extends GeoModel<OpenGoldenSkyLevel2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenGoldenSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGoldenSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGoldenSkyLevel2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/level2chest_open.png");
   }
}
