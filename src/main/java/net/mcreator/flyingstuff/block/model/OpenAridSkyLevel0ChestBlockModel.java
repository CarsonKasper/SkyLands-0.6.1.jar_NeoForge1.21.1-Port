package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel0ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenAridSkyLevel0ChestBlockModel extends GeoModel<OpenAridSkyLevel0ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenAridSkyLevel0ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenAridSkyLevel0ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenAridSkyLevel0ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/arid_chest_0_open.png");
   }
}
