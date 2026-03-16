package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.LavicSkyLvl1ChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LavicSkyLvl1ChestDisplayModel extends GeoModel<LavicSkyLvl1ChestDisplayItem> {
   public ResourceLocation getAnimationResource(LavicSkyLvl1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(LavicSkyLvl1ChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(LavicSkyLvl1ChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl1_chest.png");
   }
}
