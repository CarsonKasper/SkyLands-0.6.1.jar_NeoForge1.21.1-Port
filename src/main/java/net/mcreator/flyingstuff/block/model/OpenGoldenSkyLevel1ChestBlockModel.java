package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel1ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGoldenSkyLevel1ChestBlockModel extends GeoModel<OpenGoldenSkyLevel1ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenGoldenSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGoldenSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGoldenSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/chest_active.png");
   }
}
