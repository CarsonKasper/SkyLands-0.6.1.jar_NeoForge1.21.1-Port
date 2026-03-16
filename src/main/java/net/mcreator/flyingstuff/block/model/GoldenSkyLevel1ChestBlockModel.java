package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel1ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldenSkyLevel1ChestBlockModel extends GeoModel<GoldenSkyLevel1ChestTileEntity> {
   public ResourceLocation getAnimationResource(GoldenSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GoldenSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GoldenSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/chest.png");
   }
}
