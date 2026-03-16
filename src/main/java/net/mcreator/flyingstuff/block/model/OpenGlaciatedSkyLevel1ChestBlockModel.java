package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel1ChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OpenGlaciatedSkyLevel1ChestBlockModel extends GeoModel<OpenGlaciatedSkyLevel1ChestTileEntity> {
   public ResourceLocation getAnimationResource(OpenGlaciatedSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/golden_sky_chest_lvl1.animation.json");
   }

   public ResourceLocation getModelResource(OpenGlaciatedSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/golden_sky_chest_lvl1.geo.json");
   }

   public ResourceLocation getTextureResource(OpenGlaciatedSkyLevel1ChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/glaciated_chest0_open.png");
   }
}
