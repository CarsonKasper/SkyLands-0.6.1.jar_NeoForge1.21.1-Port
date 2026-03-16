package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.LavicSkyLvl2ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LavicSkyLvl2ChestBlockModel extends GeoModel<LavicSkyLvl2ChestTileEntity> {
   public ResourceLocation getAnimationResource(LavicSkyLvl2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(LavicSkyLvl2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(LavicSkyLvl2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl2_chest.png");
   }
}
