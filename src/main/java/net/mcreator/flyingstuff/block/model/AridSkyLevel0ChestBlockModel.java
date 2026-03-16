package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.AridSkyLevel0ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AridSkyLevel0ChestBlockModel extends GeoModel<AridSkyLevel0ChestTileEntity> {
   public ResourceLocation getAnimationResource(AridSkyLevel0ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(AridSkyLevel0ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(AridSkyLevel0ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/arid_chest_0.png");
   }
}
