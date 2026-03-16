package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel1ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GlaciatedSkyLevel1ChestBlockModel extends GeoModel<GlaciatedSkyLevel1ChestTileEntity> {
   public ResourceLocation getAnimationResource(GlaciatedSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(GlaciatedSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(GlaciatedSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest0.png");
   }
}
