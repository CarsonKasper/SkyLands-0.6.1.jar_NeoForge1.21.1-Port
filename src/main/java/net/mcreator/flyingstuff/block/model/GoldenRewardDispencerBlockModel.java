package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.GoldenRewardDispencerTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldenRewardDispencerBlockModel extends GeoModel<GoldenRewardDispencerTileEntity> {
   public ResourceLocation getAnimationResource(GoldenRewardDispencerTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(GoldenRewardDispencerTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(GoldenRewardDispencerTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine.png");
   }
}
