package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.LavicSkyLvl1ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LavicSkyLvl1ChestBlockModel extends GeoModel<LavicSkyLvl1ChestTileEntity> {
   public ResourceLocation getAnimationResource(LavicSkyLvl1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(LavicSkyLvl1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(LavicSkyLvl1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/lavic_lvl1_chest.png");
   }
}
