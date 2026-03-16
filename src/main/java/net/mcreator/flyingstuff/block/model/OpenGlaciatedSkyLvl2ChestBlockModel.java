package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLvl2ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGlaciatedSkyLvl2ChestBlockModel extends GeoModel<OpenGlaciatedSkyLvl2ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenGlaciatedSkyLvl2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGlaciatedSkyLvl2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGlaciatedSkyLvl2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl2_chest_open.png");
   }
}
