package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenAridSkyLevel0ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenAridSkyLevel0ChestDisplayModel extends GeoModel<OpenAridSkyLevel0ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenAridSkyLevel0ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenAridSkyLevel0ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenAridSkyLevel0ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/arid_chest_0_open.png");
   }
}
