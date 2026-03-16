package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.LavicSkyLvl2ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LavicSkyLvl2ChestDisplayModel extends GeoModel<LavicSkyLvl2ChestDisplayItem> {
   public ResourceLocation getAnimationResource(LavicSkyLvl2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(LavicSkyLvl2ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(LavicSkyLvl2ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl2_chest.png");
   }
}
