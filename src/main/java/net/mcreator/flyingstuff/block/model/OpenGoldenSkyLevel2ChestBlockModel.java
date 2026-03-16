package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel2ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGoldenSkyLevel2ChestBlockModel extends GeoModel<OpenGoldenSkyLevel2ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenGoldenSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGoldenSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGoldenSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/level2chest_open.png");
   }
}
