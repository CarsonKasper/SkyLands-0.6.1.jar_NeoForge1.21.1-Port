package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.OpenLavicSkyLvl1ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenLavicSkyLvl1ChestDisplayModel extends GeoModel<OpenLavicSkyLvl1ChestDisplayItem> {
   public ResourceLocation getAnimationResource(OpenLavicSkyLvl1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenLavicSkyLvl1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenLavicSkyLvl1ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl1_chest_open.png");
   }
}
