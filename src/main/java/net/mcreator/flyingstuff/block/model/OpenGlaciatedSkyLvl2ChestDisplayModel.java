package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLvl2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGlaciatedSkyLvl2ChestDisplayModel extends GeoModel<OpenGlaciatedSkyLvl2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenGlaciatedSkyLvl2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGlaciatedSkyLvl2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGlaciatedSkyLvl2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl2_chest_open.png");
   }
}
