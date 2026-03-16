package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.GoldenSkyLevel2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldenSkyLevel2ChestDisplayModel extends GeoModel<GoldenSkyLevel2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(GoldenSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GoldenSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GoldenSkyLevel2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/level2chest.png");
   }
}
