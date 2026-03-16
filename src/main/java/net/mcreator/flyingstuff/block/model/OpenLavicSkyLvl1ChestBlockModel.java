package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenLavicSkyLvl1ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenLavicSkyLvl1ChestBlockModel extends GeoModel<OpenLavicSkyLvl1ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenLavicSkyLvl1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenLavicSkyLvl1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenLavicSkyLvl1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl1_chest_open.png");
   }
}
