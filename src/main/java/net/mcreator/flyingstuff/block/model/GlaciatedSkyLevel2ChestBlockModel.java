package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel2ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GlaciatedSkyLevel2ChestBlockModel extends GeoModel<GlaciatedSkyLevel2ChestTileEntity> {
   public ResourceLocation getAnimationResource(GlaciatedSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GlaciatedSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GlaciatedSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest.png");
   }
}
