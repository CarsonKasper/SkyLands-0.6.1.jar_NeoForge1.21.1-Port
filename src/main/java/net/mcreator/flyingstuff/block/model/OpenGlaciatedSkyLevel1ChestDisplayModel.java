package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLevel1ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGlaciatedSkyLevel1ChestDisplayModel extends GeoModel<OpenGlaciatedSkyLevel1ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenGlaciatedSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGlaciatedSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGlaciatedSkyLevel1ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest0_open.png");
   }
}
