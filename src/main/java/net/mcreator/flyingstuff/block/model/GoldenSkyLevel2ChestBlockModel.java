package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel2ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldenSkyLevel2ChestBlockModel extends GeoModel<GoldenSkyLevel2ChestTileEntity> {
   public ResourceLocation getAnimationResource(GoldenSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GoldenSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GoldenSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/level2chest.png");
   }
}
