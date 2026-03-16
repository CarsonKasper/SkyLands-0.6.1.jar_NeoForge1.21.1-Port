package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel1ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGoldenSkyLevel1ChestDisplayModel extends GeoModel<OpenGoldenSkyLevel1ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenGoldenSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGoldenSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGoldenSkyLevel1ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/chest_active.png");
   }
}
