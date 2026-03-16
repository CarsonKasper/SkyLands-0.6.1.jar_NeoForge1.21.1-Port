package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.GlaciatedSkyLevel2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GlaciatedSkyLevel2ChestDisplayModel extends GeoModel<GlaciatedSkyLevel2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(GlaciatedSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GlaciatedSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GlaciatedSkyLevel2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest.png");
   }
}
