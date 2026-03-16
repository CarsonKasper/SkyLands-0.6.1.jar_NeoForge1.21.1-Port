package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel2ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGlaciatedSkyLevel2ChestBlockModel extends GeoModel<OpenGlaciatedSkyLevel2ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenGlaciatedSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGlaciatedSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGlaciatedSkyLevel2ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest_open.png");
   }
}
