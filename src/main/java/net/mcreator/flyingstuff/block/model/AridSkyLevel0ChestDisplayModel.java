package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.AridSkyLevel0ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AridSkyLevel0ChestDisplayModel extends GeoModel<AridSkyLevel0ChestDisplayItem> {
   public ResourceLocation getAnimationResource(AridSkyLevel0ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(AridSkyLevel0ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(AridSkyLevel0ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/arid_chest_0.png");
   }
}
