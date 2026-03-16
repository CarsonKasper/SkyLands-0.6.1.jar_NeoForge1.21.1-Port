package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.GlaciatedSkyLevel1ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GlaciatedSkyLevel1ChestDisplayModel extends GeoModel<GlaciatedSkyLevel1ChestDisplayItem> {
   public ResourceLocation getAnimationResource(GlaciatedSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GlaciatedSkyLevel1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GlaciatedSkyLevel1ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest0.png");
   }
}
