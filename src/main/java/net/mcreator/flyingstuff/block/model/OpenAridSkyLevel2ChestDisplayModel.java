package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenAridSkyLevel2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenAridSkyLevel2ChestDisplayModel extends GeoModel<OpenAridSkyLevel2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenAridSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenAridSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenAridSkyLevel2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/arid_chest_1_open.png");
   }
}
