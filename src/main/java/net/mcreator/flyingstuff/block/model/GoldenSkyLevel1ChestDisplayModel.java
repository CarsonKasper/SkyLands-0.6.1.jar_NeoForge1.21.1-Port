package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.GoldenSkyLevel1ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldenSkyLevel1ChestDisplayModel extends GeoModel<GoldenSkyLevel1ChestDisplayItem> {
   public ResourceLocation getAnimationResource(GoldenSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GoldenSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GoldenSkyLevel1ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/chest.png");
   }
}
