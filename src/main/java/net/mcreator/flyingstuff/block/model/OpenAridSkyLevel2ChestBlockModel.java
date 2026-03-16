package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel2ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenAridSkyLevel2ChestBlockModel extends GeoModel<OpenAridSkyLevel2ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenAridSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenAridSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenAridSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/arid_chest_1_open.png");
   }
}
