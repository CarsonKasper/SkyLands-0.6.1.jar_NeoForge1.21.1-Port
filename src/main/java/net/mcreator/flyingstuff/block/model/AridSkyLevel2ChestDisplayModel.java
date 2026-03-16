package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.AridSkyLevel2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AridSkyLevel2ChestDisplayModel extends GeoModel<AridSkyLevel2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(AridSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(AridSkyLevel2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(AridSkyLevel2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/arid_chest_1.png");
   }
}
